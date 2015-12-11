// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.ebay.nautilus.domain.content.InternalDomainError;
import com.ebay.nautilus.domain.data.EbayCosDateTime;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.domain.net.symban.SymbanReadRequest;
import com.ebay.nautilus.domain.net.symban.SymbanReadResponse;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            SymbanDataManager

private class <init> extends AsyncTask
{

    private com.ebay.nautilus.domain.net.symban.onPostExecute body;
    private com.ebay.nautilus.domain.net.symban.onPostExecute params;
    private Date requestTime;
    final SymbanDataManager this$0;

    private com.ebay.nautilus.domain.net.symban.<init> checkResponseBody(com.ebay.nautilus.domain.net.symban.<init> <init>1)
    {
        if (<init>1 == null || <init>1.ifications == null) goto _L2; else goto _L1
_L1:
        boolean flag;
        boolean flag1 = false;
        Iterator iterator = <init>1.ifications.iterator();
        do
        {
            flag = flag1;
            if (!iterator.hasNext())
            {
                break;
            }
            if (isNotificationValid((com.ebay.nautilus.domain.net.symban.lNotification)iterator.next()))
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
        SymbanDataManager.logDm.Dm("Invalid symban notifications received");
        arraylist = new ArrayList();
        iterator1 = <init>1.ifications.iterator();
_L5:
        if (iterator1.hasNext())
        {
            com.ebay.nautilus.domain.net.symban.lNotification lnotification = (com.ebay.nautilus.domain.net.symban.lNotification)iterator1.next();
            if (isNotificationValid(lnotification))
            {
                arraylist.add(lnotification);
            } else
            if (lnotification != null)
            {
                String s;
                if (lnotification.creationDate != null)
                {
                    s = lnotification.creationDate.formattedValue;
                } else
                {
                    s = null;
                }
                SymbanDataManager.logDm.Dm(String.format("Invalid symban notification:  notificationId='%s', creationDate='%s'", new Object[] {
                    lnotification.notificationId, s
                }));
                lnotification.status = com.ebay.nautilus.domain.data.um.DELETED;
                <init>1.geCount = Math.max(0, <init>1.geCount - 1);
            }
            continue; /* Loop/switch isn't completed */
        }
        <init>1.ifications = arraylist;
_L2:
        return <init>1;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private boolean isNotificationValid(com.ebay.nautilus.domain.net.symban.lNotification lnotification)
    {
        DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
        boolean flag1 = com.ebay.nautilus.domain.data.Enum.UCI.equals(lnotification.mdnsName);
        if (flag1 && !deviceconfiguration.get(com.ebay.nautilus.domain.dcs.fication))
        {
            flag1 = false;
        } else
        {
            boolean flag;
            if (lnotification.subject != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (lnotification == null)
            {
                return false;
            }
            if (TextUtils.isEmpty(lnotification.notificationId))
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

    protected transient ResultStatus doInBackground(com.ebay.nautilus.domain.net.symban.d ad[])
    {
        if (SymbanDataManager.log. || SymbanDataManager.logDm.Dm || SymbanDataManager.logDmNetwork.DmNetwork)
        {
            SymbanDataManager.logDmNetwork.DmNetwork((new StringBuilder()).append("Starting background task: ").append(this).toString());
        }
        requestTime = new Date();
        if (ad != null && ad.length > 0)
        {
            ad = ad[0];
        } else
        {
            ad = new com.ebay.nautilus.domain.net.symban.nit>();
        }
        params = ad;
        ad = new ResultStatusOwner();
        if (SymbanDataManager.access$300(SymbanDataManager.this) != null) goto _L2; else goto _L1
_L1:
        ad.addResultMessage(new com.ebay.nautilus.kernel.content.Message[] {
            InternalDomainError.getPleaseSignInMessage()
        });
_L4:
        return ad.getResultStatus();
_L2:
        if (currentCountry == null)
        {
            ad.addResultMessage(new com.ebay.nautilus.kernel.content.Message[] {
                InternalDomainError.getCountryNotSpecifiedMessage()
            });
        } else
        {
            Object obj = new SymbanReadRequest(SymbanDataManager.access$300(SymbanDataManager.this), currentCountry, params);
            obj = (SymbanReadResponse)SymbanDataManager.access$400(SymbanDataManager.this, ((com.ebay.nautilus.kernel.net.Request) (obj)), ad);
            if (obj != null)
            {
                body = checkResponseBody(((SymbanReadResponse) (obj)).getBody());
            }
            if (body == null || !params.BadgeCountOnly() && body.ifications == null)
            {
                EbayResponseError ebayresponseerror = new EbayResponseError();
                ebayresponseerror.userDisplay = false;
                ad.addResultMessage(new com.ebay.nautilus.kernel.content.Message[] {
                    ebayresponseerror
                });
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((com.ebay.nautilus.domain.net.symban.doInBackground[])aobj);
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
                countData = Integer.valueOf(body.geCount);
                ((geCount)SymbanDataManager.access$500(SymbanDataManager.this)).onSymbanCountChanged(SymbanDataManager.this, countData.intValue());
            }
            if (!params.BadgeCountOnly())
            {
                if (!flag)
                {
                    break label0;
                }
                ((BadgeCountOnly)SymbanDataManager.access$600(SymbanDataManager.this)).onSymbanListChanged(SymbanDataManager.this, getListContent(null, resultstatus));
            }
            return;
        }
        listStatus = resultstatus;
        listData = new ArrayList();
        com.ebay.nautilus.domain.net.symban.lNotification lnotification;
        for (resultstatus = body.ifications.iterator(); resultstatus.hasNext(); listData.add(lnotification))
        {
            lnotification = (com.ebay.nautilus.domain.net.symban.lNotification)resultstatus.next();
        }

        ((lNotification)SymbanDataManager.access$700(SymbanDataManager.this)).onSymbanListChanged(SymbanDataManager.this, getListContent(listData, listStatus));
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ResultStatus)obj);
    }

    public String toString()
    {
        return getClass().getSimpleName();
    }

    private lNotification()
    {
        this$0 = SymbanDataManager.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
