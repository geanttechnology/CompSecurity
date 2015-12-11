// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.content.InternalDomainError;
import com.ebay.nautilus.domain.data.EbayCosDateTime;
import com.ebay.nautilus.domain.data.SymbanNotification;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.domain.net.symban.SymbanReadRequest;
import com.ebay.nautilus.domain.net.symban.SymbanReadResponse;
import com.ebay.nautilus.domain.net.symban.SymbanUpdateRequest;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UserContextObservingDataManager, UserContextDataManager

public class SymbanDataManager extends UserContextObservingDataManager
{
    public static final class KeyParams extends UserContextObservingDataManager.KeyBase
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return SymbanDataManager.KEY;
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public KeyParams[] newArray(int i)
            {
                return new KeyParams[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };

        public SymbanDataManager create(EbayContext ebaycontext)
        {
            return new SymbanDataManager(ebaycontext);
        }

        public volatile UserContextObservingDataManager create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }


        protected KeyParams()
        {
        }
    }

    public static interface Observer
    {

        public abstract void onMarkAllReadCompleted(SymbanDataManager symbandatamanager, ResultStatus resultstatus);

        public abstract void onSymbanCountChanged(SymbanDataManager symbandatamanager, int i);

        public abstract void onSymbanListChanged(SymbanDataManager symbandatamanager, Content content);

        public abstract void onSymbanUpdatedCompleted(SymbanDataManager symbandatamanager, SymbanNotification symbannotification, com.ebay.nautilus.domain.data.SymbanNotification.StatusEnum statusenum);
    }

    private class ReadTask extends AsyncTask
    {

        private com.ebay.nautilus.domain.net.symban.SymbanReadResponse.Body body;
        private com.ebay.nautilus.domain.net.symban.SymbanReadRequest.Params params;
        private Date requestTime;
        final SymbanDataManager this$0;

        private com.ebay.nautilus.domain.net.symban.SymbanReadResponse.Body checkResponseBody(com.ebay.nautilus.domain.net.symban.SymbanReadResponse.Body body1)
        {
            if (body1 == null || body1.notifications == null) goto _L2; else goto _L1
_L1:
            boolean flag;
            boolean flag1 = false;
            Iterator iterator = body1.notifications.iterator();
            do
            {
                flag = flag1;
                if (!iterator.hasNext())
                {
                    break;
                }
                if (isNotificationValid((com.ebay.nautilus.domain.net.symban.SymbanReadResponse.Body.PullNotification)iterator.next()))
                {
                    continue;
                }
                flag = true;
                break;
            } while (true);
            if (!flag) goto _L2; else goto _L3
_L3:
            ArrayList arraylist;
            Iterator iterator1;
            SymbanDataManager.logDm.logAsError("Invalid symban notifications received");
            arraylist = new ArrayList();
            iterator1 = body1.notifications.iterator();
_L5:
            if (iterator1.hasNext())
            {
                com.ebay.nautilus.domain.net.symban.SymbanReadResponse.Body.PullNotification pullnotification = (com.ebay.nautilus.domain.net.symban.SymbanReadResponse.Body.PullNotification)iterator1.next();
                if (isNotificationValid(pullnotification))
                {
                    arraylist.add(pullnotification);
                } else
                if (pullnotification != null)
                {
                    String s;
                    if (pullnotification.creationDate != null)
                    {
                        s = pullnotification.creationDate.formattedValue;
                    } else
                    {
                        s = null;
                    }
                    SymbanDataManager.logDm.logAsError(String.format("Invalid symban notification:  notificationId='%s', creationDate='%s'", new Object[] {
                        pullnotification.notificationId, s
                    }));
                    pullnotification.status = com.ebay.nautilus.domain.data.SymbanNotification.StatusEnum.DELETED;
                    body1.badgeCount = Math.max(0, body1.badgeCount - 1);
                }
                continue; /* Loop/switch isn't completed */
            }
            body1.notifications = arraylist;
_L2:
            return body1;
            if (true) goto _L5; else goto _L4
_L4:
        }

        private boolean isNotificationValid(com.ebay.nautilus.domain.net.symban.SymbanReadResponse.Body.PullNotification pullnotification)
        {
            DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
            boolean flag1 = com.ebay.nautilus.domain.data.SymbanNotification.MdnsNameEnum.UCI.equals(pullnotification.mdnsName);
            if (flag1 && !deviceconfiguration.get(com.ebay.nautilus.domain.dcs.DcsDomain.Connect.B.uciNotification))
            {
                flag1 = false;
            } else
            {
                boolean flag;
                if (pullnotification.subject != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (pullnotification == null)
                {
                    return false;
                }
                if (TextUtils.isEmpty(pullnotification.notificationId))
                {
                    return false;
                }
                if (flag)
                {
                    return true;
                }
            }
            return flag1;
        }

        protected transient ResultStatus doInBackground(com.ebay.nautilus.domain.net.symban.SymbanReadRequest.Params aparams[])
        {
            if (SymbanDataManager.log.isLoggable || SymbanDataManager.logDm.isLoggable || SymbanDataManager.logDmNetwork.isLoggable)
            {
                SymbanDataManager.logDmNetwork.log((new StringBuilder()).append("Starting background task: ").append(this).toString());
            }
            requestTime = new Date();
            if (aparams != null && aparams.length > 0)
            {
                aparams = aparams[0];
            } else
            {
                aparams = new com.ebay.nautilus.domain.net.symban.SymbanReadRequest.Params();
            }
            params = aparams;
            aparams = new ResultStatusOwner();
            if (currentIafToken != null) goto _L2; else goto _L1
_L1:
            aparams.addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                InternalDomainError.getPleaseSignInMessage()
            });
_L4:
            return aparams.getResultStatus();
_L2:
            if (currentCountry == null)
            {
                aparams.addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                    InternalDomainError.getCountryNotSpecifiedMessage()
                });
            } else
            {
                Object obj = new SymbanReadRequest(currentIafToken, currentCountry, params);
                obj = (SymbanReadResponse)safeSendRequest(((Request) (obj)), aparams);
                if (obj != null)
                {
                    body = checkResponseBody(((SymbanReadResponse) (obj)).getBody());
                }
                if (body == null || !params.isBadgeCountOnly() && body.notifications == null)
                {
                    EbayResponseError ebayresponseerror = new EbayResponseError();
                    ebayresponseerror.userDisplay = false;
                    aparams.addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                        ebayresponseerror
                    });
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((com.ebay.nautilus.domain.net.symban.SymbanReadRequest.Params[])aobj);
        }

        protected void onPostExecute(ResultStatus resultstatus)
        {
label0:
            {
                cancel(this);
                boolean flag = resultstatus.hasError();
                if (!flag)
                {
                    listLatestTime = requestTime;
                    countData = Integer.valueOf(body.badgeCount);
                    ((Observer)SymbanDataManager.this.SymbanNotification$StatusEnum).onSymbanCountChanged(SymbanDataManager.this, countData.intValue());
                }
                if (!params.isBadgeCountOnly())
                {
                    if (!flag)
                    {
                        break label0;
                    }
                    ((Observer)SymbanDataManager.this.SymbanNotification$StatusEnum).onSymbanListChanged(SymbanDataManager.this, getListContent(null, resultstatus));
                }
                return;
            }
            listStatus = resultstatus;
            listData = new ArrayList();
            com.ebay.nautilus.domain.net.symban.SymbanReadResponse.Body.PullNotification pullnotification;
            for (resultstatus = body.notifications.iterator(); resultstatus.hasNext(); listData.add(pullnotification))
            {
                pullnotification = (com.ebay.nautilus.domain.net.symban.SymbanReadResponse.Body.PullNotification)resultstatus.next();
            }

            ((Observer)SymbanDataManager.this.SymbanNotification$StatusEnum).onSymbanListChanged(SymbanDataManager.this, getListContent(listData, listStatus));
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((ResultStatus)obj);
        }

        public String toString()
        {
            return getClass().getSimpleName();
        }

        private ReadTask()
        {
            this$0 = SymbanDataManager.this;
            super();
        }

    }

    public static class SimpleObserver
        implements Observer
    {

        public void onMarkAllReadCompleted(SymbanDataManager symbandatamanager, ResultStatus resultstatus)
        {
        }

        public void onSymbanCountChanged(SymbanDataManager symbandatamanager, int i)
        {
        }

        public void onSymbanListChanged(SymbanDataManager symbandatamanager, Content content)
        {
        }

        public void onSymbanUpdatedCompleted(SymbanDataManager symbandatamanager, SymbanNotification symbannotification, com.ebay.nautilus.domain.data.SymbanNotification.StatusEnum statusenum)
        {
        }

        public SimpleObserver()
        {
        }
    }

    private class UpdateTask extends AsyncTask
    {

        private com.ebay.nautilus.domain.net.symban.SymbanUpdateRequest.Params params;
        final SymbanDataManager this$0;

        protected transient ResultStatus doInBackground(com.ebay.nautilus.domain.net.symban.SymbanUpdateRequest.Params aparams[])
        {
            if (SymbanDataManager.log.isLoggable || SymbanDataManager.logDm.isLoggable || SymbanDataManager.logDmNetwork.isLoggable)
            {
                SymbanDataManager.logDmNetwork.log((new StringBuilder()).append("Starting background task: ").append(this).toString());
            }
            if (aparams != null && aparams.length > 0)
            {
                aparams = aparams[0];
            } else
            {
                aparams = (new com.ebay.nautilus.domain.net.symban.SymbanUpdateRequest.Params(new Date())).setMarkAllRead(true);
            }
            params = aparams;
            aparams = new ResultStatusOwner();
            if (currentIafToken == null)
            {
                aparams.addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                    InternalDomainError.getPleaseSignInMessage()
                });
            } else
            if (currentCountry == null)
            {
                aparams.addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                    InternalDomainError.getCountryNotSpecifiedMessage()
                });
            } else
            {
                SymbanUpdateRequest symbanupdaterequest = new SymbanUpdateRequest(currentIafToken, currentCountry, params);
                safeSendRequest(symbanupdaterequest, aparams);
            }
            return aparams.getResultStatus();
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((com.ebay.nautilus.domain.net.symban.SymbanUpdateRequest.Params[])aobj);
        }

        protected void onPostExecute(ResultStatus resultstatus)
        {
            if (!resultstatus.hasError())
            {
                listLatestTime = params.getDate();
                Observer observer = (Observer)currentCountry;
                SymbanDataManager symbandatamanager = SymbanDataManager.this;
                int i;
                if (countData != null)
                {
                    i = countData.intValue();
                } else
                {
                    i = 0;
                }
                observer.onSymbanCountChanged(symbandatamanager, i);
            }
            ((Observer)currentCountry).onMarkAllReadCompleted(SymbanDataManager.this, resultstatus);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((ResultStatus)obj);
        }

        public String toString()
        {
            return getClass().getSimpleName();
        }

        private UpdateTask()
        {
            this$0 = SymbanDataManager.this;
            super();
        }

    }


    public static final KeyParams KEY = new KeyParams();
    protected static final com.ebay.nautilus.kernel.util.FwLog.LogInfo log = new LogInfo("Symban", 3, "SYMBA Notifications");
    protected static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logDm = new LogInfo("Symban.Dm", 3, "SYMBA Notification Data Manager");
    protected static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logDmNetwork = new LogInfo("Symban.Dm.Network", 3, "SYMBA Notification Data Manager network activity");
    protected Integer countData;
    private ReadTask countLoadTask;
    protected volatile EbayCountry currentCountry;
    private volatile String currentIafToken;
    protected List listData;
    protected Date listLatestTime;
    private ReadTask listLoadTask;
    protected ResultStatus listStatus;

    protected SymbanDataManager(EbayContext ebaycontext)
    {
        super(ebaycontext, com/ebay/nautilus/domain/content/dm/SymbanDataManager$Observer, KEY);
        listLoadTask = null;
        listStatus = null;
        listData = null;
        listLatestTime = null;
        countLoadTask = null;
        countData = null;
    }

    private boolean loadCountInternal(Observer observer, boolean flag)
    {
        if (getCurrentUser() == null && observer != null)
        {
            observer.onSymbanCountChanged(this, 0);
        } else
        if (listLoadTask == null && countLoadTask == null)
        {
            if (flag || countData == null)
            {
                countData = null;
                countLoadTask = new ReadTask();
                observer = (new com.ebay.nautilus.domain.net.symban.SymbanReadRequest.Params()).setBadgeCountOnly(true);
                executeOnThreadPool(countLoadTask, new com.ebay.nautilus.domain.net.symban.SymbanReadRequest.Params[] {
                    observer
                });
                return true;
            } else
            {
                ((Observer)getSafeCallback(observer)).onSymbanCountChanged(this, countData.intValue());
                return false;
            }
        }
        return false;
    }

    private boolean loadListInternal(Observer observer, boolean flag)
    {
label0:
        {
            boolean flag1 = false;
            if (listLoadTask == null)
            {
                cancel(countLoadTask);
                if (!flag && listData != null && countData != null)
                {
                    break label0;
                }
                countData = null;
                listData = null;
                listLoadTask = new ReadTask();
                observer = (new com.ebay.nautilus.domain.net.symban.SymbanReadRequest.Params()).setBadgeCountOnly(false);
                executeOnThreadPool(listLoadTask, new com.ebay.nautilus.domain.net.symban.SymbanReadRequest.Params[] {
                    observer
                });
                flag1 = true;
            }
            return flag1;
        }
        observer = (Observer)getSafeCallback(observer);
        observer.onSymbanCountChanged(this, countData.intValue());
        observer.onSymbanListChanged(this, getListContent(listData, listStatus));
        return false;
    }

    public static void setCount(EbayContext ebaycontext, int i)
    {
        ebaycontext = (SymbanDataManager)DataManager.getIfExists(ebaycontext, KEY);
        if (ebaycontext != null)
        {
            ebaycontext.setCountInternal(i);
        }
    }

    private void setCountInternal(int i)
    {
        runOnMainThread(new Runnable() );
    }

    private boolean updateStatusToDeleted(String s)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (listData == null) goto _L2; else goto _L1
_L1:
        flag = flag1;
        if (s == null) goto _L2; else goto _L3
_L3:
        int i;
        int j;
        j = listData.size();
        i = 0;
_L8:
        flag = flag1;
        if (i >= j) goto _L2; else goto _L4
_L4:
        SymbanNotification symbannotification = (SymbanNotification)listData.get(i);
        if (!s.equals(((SymbanNotification)listData.get(i)).getNotificationId())) goto _L6; else goto _L5
_L5:
        flag = symbannotification.isNew();
        listData.remove(i);
_L2:
        return flag;
_L6:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private boolean updateStatusToRead(String s)
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (listData == null)
            {
                break label0;
            }
            flag = flag1;
            if (s == null)
            {
                break label0;
            }
            Iterator iterator = listData.iterator();
            SymbanNotification symbannotification;
            do
            {
                flag = flag1;
                if (!iterator.hasNext())
                {
                    break label0;
                }
                symbannotification = (SymbanNotification)iterator.next();
            } while (!s.equals(symbannotification.getNotificationId()));
            flag1 = symbannotification.isNew();
            flag = flag1;
            if (symbannotification instanceof com.ebay.nautilus.domain.net.symban.SymbanReadResponse.Body.PullNotification)
            {
                ((com.ebay.nautilus.domain.net.symban.SymbanReadResponse.Body.PullNotification)symbannotification).status = com.ebay.nautilus.domain.data.SymbanNotification.StatusEnum.READ;
                flag = flag1;
            }
        }
        return flag;
    }

    protected void cancel(ReadTask readtask)
    {
        if (readtask != null)
        {
            readtask.cancel(true);
            if (listLoadTask == readtask)
            {
                listLoadTask = null;
            } else
            if (countLoadTask == readtask)
            {
                countLoadTask = null;
                return;
            }
        }
    }

    public Integer getCountIfExists()
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("getCountIfExists: ").append(this).toString());
        }
        NautilusKernel.verifyMain();
        return countData;
    }

    protected Content getListContent(List list, ResultStatus resultstatus)
    {
        if (list == null)
        {
            return new Content(resultstatus);
        } else
        {
            return new Content(Collections.unmodifiableList(list), resultstatus);
        }
    }

    public void invalidateCount()
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("invalidateCount: ").append(this).toString());
        }
        NautilusKernel.verifyMain();
        countData = null;
        cancel(countLoadTask);
    }

    public void invalidateList()
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("invalidateList: ").append(this).toString());
        }
        NautilusKernel.verifyMain();
        countData = null;
        listData = null;
        cancel(countLoadTask);
        cancel(listLoadTask);
    }

    public void loadCount(Observer observer)
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("loadCount: ").append(this).toString());
        }
        NautilusKernel.verifyMain();
        loadCountInternal(observer, false);
    }

    public void loadData(Observer observer)
    {
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    public void loadList(Observer observer)
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("loadList: ").append(this).toString());
        }
        NautilusKernel.verifyMain();
        loadListInternal(observer, false);
    }

    public void markAllRead()
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("markAllRead: ").append(this).toString());
        }
        NautilusKernel.verifyMain();
        invalidateList();
        com.ebay.nautilus.domain.net.symban.SymbanUpdateRequest.Params params = (new Params(listLatestTime)).setMarkAllRead(true);
        executeOnThreadPool(new UpdateTask(), new com.ebay.nautilus.domain.net.symban.SymbanUpdateRequest.Params[] {
            params
        });
    }

    public void onCurrentCountryChanged(UserContextDataManager usercontextdatamanager, EbayCountry ebaycountry)
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("onCurrentCountryChanged: ").append(this).toString());
        }
        onCurrentCountryChanged(usercontextdatamanager, ebaycountry);
        currentCountry = ebaycountry;
    }

    public void onCurrentUserChanged(UserContextDataManager usercontextdatamanager, String s, String s1, boolean flag)
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("onCurrentUserChanged: ").append(this).toString());
        }
        if (!flag)
        {
            invalidateCount();
            invalidateList();
            if (s == null)
            {
                countData = Integer.valueOf(0);
                ((Observer)dispatcher).onSymbanCountChanged(this, countData.intValue());
            }
        }
        currentIafToken = s1;
    }

    protected void onLastObserverUnregistered()
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("onLastObserverUnregistered: ").append(this).toString());
        }
        onLastObserverUnregistered();
        cancel(countLoadTask);
        cancel(listLoadTask);
    }

    public boolean reloadCount()
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("reloadCount: ").append(this).toString());
        }
        NautilusKernel.verifyMain();
        return loadCountInternal(null, true);
    }

    public boolean reloadList()
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("reloadList: ").append(this).toString());
        }
        NautilusKernel.verifyMain();
        return loadListInternal(null, true);
    }

    public transient void updateStatus(com.ebay.nautilus.domain.data.SymbanNotification.StatusEnum statusenum, SymbanNotification asymbannotification[])
    {
        int i;
        boolean flag;
        int l;
        NautilusKernel.verifyMain();
        flag = false;
        l = asymbannotification.length;
        i = 0;
_L8:
        if (i >= l) goto _L2; else goto _L1
_L1:
        SymbanNotification symbannotification;
        String s;
        symbannotification = asymbannotification[i];
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("markRead: ").append(symbannotification).append(", ").append(statusenum).append(", ").append(this).toString());
        }
        s = symbannotification.getNotificationId();
        static class _cls2
        {

            static final int $SwitchMap$com$ebay$nautilus$domain$data$SymbanNotification$StatusEnum[];

            static 
            {
                $SwitchMap$com$ebay$nautilus$domain$data$SymbanNotification$StatusEnum = new int[com.ebay.nautilus.domain.data.SymbanNotification.StatusEnum.values().length];
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$SymbanNotification$StatusEnum[com.ebay.nautilus.domain.data.SymbanNotification.StatusEnum.READ.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$SymbanNotification$StatusEnum[com.ebay.nautilus.domain.data.SymbanNotification.StatusEnum.DELETED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$SymbanNotification$StatusEnum[com.ebay.nautilus.domain.data.SymbanNotification.StatusEnum.NEW.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2..SwitchMap.com.ebay.nautilus.domain.data.SymbanNotification.StatusEnum[statusenum.ordinal()];
        JVM INSTR tableswitch 1 2: default 128
    //                   1 129
    //                   2 204;
           goto _L3 _L4 _L5
_L3:
        return;
_L4:
        boolean flag2 = updateStatusToRead(s);
_L6:
        boolean flag1 = flag;
        if (flag2)
        {
            flag1 = flag;
            if (countData != null)
            {
                countData = Integer.valueOf(countData.intValue() - 1);
                flag1 = true;
            }
        }
        ((Observer)dispatcher).onSymbanUpdatedCompleted(this, symbannotification, statusenum);
        i++;
        flag = flag1;
        continue; /* Loop/switch isn't completed */
_L5:
        flag2 = updateStatusToDeleted(s);
        if (true) goto _L6; else goto _L2
_L2:
        if (flag)
        {
            ((Observer)dispatcher).onSymbanCountChanged(this, countData.intValue());
        }
        com.ebay.nautilus.domain.net.symban.SymbanUpdateRequest.Params params = new Params(listLatestTime);
        int k = asymbannotification.length;
        for (int j = 0; j < k; j++)
        {
            params.addNotification(asymbannotification[j], statusenum);
        }

        executeOnThreadPool(new UpdateTask(), new com.ebay.nautilus.domain.net.symban.SymbanUpdateRequest.Params[] {
            params
        });
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }










}
