// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.groupon.db.dao.DaoInAppMessage;
import com.groupon.db.events.InAppMessageEvent;
import com.groupon.db.models.InAppMessage;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.models.division.Division;
import com.groupon.service.InAppMessageService;
import com.groupon.service.LocationService;
import com.groupon.service.LoginService;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.util.CountryNotSupportedException;
import com.groupon.util.DivisionUtil;
import com.groupon.util.PausableThreadPoolExecutor;
import com.squareup.otto.Bus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.inject.Lazy;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.manager:
//            GrouponSyncManager, SyncManagerUtils

public class InAppMessageSyncManager extends GrouponSyncManager
{
    protected static class AppMessageResponse
    {

        private List inAppMessages;

        public List getAppMessages()
        {
            return inAppMessages;
        }

        protected AppMessageResponse()
        {
        }
    }


    private Lazy currentDivisionManager;
    private DaoInAppMessage daoInAppMessage;
    private String deviceId;
    private Lazy divisionUtil;
    private Bus globalBus;
    private Lazy locationService;
    private Lazy loginService;
    private Lazy prefs;
    private String version;

    public InAppMessageSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor)
    {
        super(context, pausablethreadpoolexecutor);
        try
        {
            version = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new RuntimeException(context);
        }
    }

    private void init()
    {
        locationService = new Lazy(context) {

            final InAppMessageSyncManager this$0;

            
            {
                this$0 = InAppMessageSyncManager.this;
                super(context);
            }
        };
        loginService = new Lazy(context) {

            final InAppMessageSyncManager this$0;

            
            {
                this$0 = InAppMessageSyncManager.this;
                super(context);
            }
        };
        divisionUtil = new Lazy(context) {

            final InAppMessageSyncManager this$0;

            
            {
                this$0 = InAppMessageSyncManager.this;
                super(context);
            }
        };
        currentDivisionManager = new Lazy(context) {

            final InAppMessageSyncManager this$0;

            
            {
                this$0 = InAppMessageSyncManager.this;
                super(context);
            }
        };
        prefs = new Lazy(context) {

            final InAppMessageSyncManager this$0;

            
            {
                this$0 = InAppMessageSyncManager.this;
                super(context);
            }
        };
    }

    protected volatile void doSync(Object obj)
        throws Exception
    {
        doSync((Void)obj);
    }

    protected void doSync(final Void appMessages)
        throws Exception
    {
        if (Strings.isEmpty(((CurrentDivisionManager)currentDivisionManager.get()).getCurrentDivision().id))
        {
            Ln.i("Division empty - cannot retrieve messages", new Object[0]);
            return;
        }
        if (Strings.isEmpty(deviceId))
        {
            Ln.w("Device Id empty - cannot retrieve messages", new Object[0]);
            return;
        } else
        {
            appMessages = ((AppMessageResponse)(new SyncHttp(context, com/groupon/manager/InAppMessageSyncManager$AppMessageResponse, "https:/in_app_messages", getNameValueParams().toArray())).call()).getAppMessages();
            daoInAppMessage.callBatchTasks(new Callable() {

                final InAppMessageSyncManager this$0;
                final List val$appMessages;

                public Object call()
                    throws Exception
                {
                    if (appMessages == null || appMessages.isEmpty()) goto _L2; else goto _L1
_L1:
                    Object obj = daoInAppMessage.queryForAll();
                    int i = appMessages.size();
                    Iterator iterator = appMessages.iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        InAppMessage inappmessage = (InAppMessage)iterator.next();
                        inappmessage.timestamp = System.currentTimeMillis();
                        Iterator iterator1 = ((List) (obj)).iterator();
                        int j;
                        do
                        {
                            j = i;
                            if (!iterator1.hasNext())
                            {
                                break;
                            }
                            InAppMessage inappmessage1 = (InAppMessage)iterator1.next();
                            if (!Strings.equals(inappmessage1.remoteId, inappmessage.remoteId))
                            {
                                continue;
                            }
                            inappmessage.timestamp = inappmessage1.timestamp;
                            inappmessage.viewed = inappmessage1.viewed;
                            inappmessage.read = inappmessage1.read;
                            j = i - 1;
                            break;
                        } while (true);
                        i = j;
                        if (inappmessage.viewed)
                        {
                            i = j;
                            if (!inappmessage.read)
                            {
                                ((InAppMessageService)RoboGuice.getInjector(viewed).getInstance(com/groupon/service/InAppMessageService)).onStateChanged(inappmessage, com.groupon.service.InAppMessageService.EventName.VIEWED);
                                i = j;
                            }
                        }
                    } while (true);
                    daoInAppMessage.clearAll();
                    daoInAppMessage.saveList(appMessages);
                    obj = ((SharedPreferences)prefs.get()).edit();
                    boolean flag;
                    if (i > 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    ((android.content.SharedPreferences.Editor) (obj)).putBoolean("show_message_box", flag).commit();
_L4:
                    return null;
_L2:
                    daoInAppMessage.clearAll();
                    if (true) goto _L4; else goto _L3
_L3:
                }

            
            {
                this$0 = InAppMessageSyncManager.this;
                appMessages = list;
                super();
            }
            });
            globalBus.post(new InAppMessageEvent());
            Ln.d("End doSync for In App Messages", new Object[0]);
            return;
        }
    }

    protected List getNameValueParams()
        throws CountryNotSupportedException
    {
        android.location.Location location = ((LocationService)locationService.get()).getLocation();
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "page", Integer.valueOf(1), "per_page", Integer.valueOf(5)
        }));
        if (((LoginService)loginService.get()).isLoggedIn())
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "user_id", ((LoginService)loginService.get()).getUserId()
            }));
        }
        arraylist.addAll(((DivisionUtil)divisionUtil.get()).getDivisionNameValuePairs(location));
        arraylist.addAll(Arrays.asList(new String[] {
            "version_number", version
        }));
        arraylist.addAll(Arrays.asList(new String[] {
            "device_id", deviceId
        }));
        return arraylist;
    }

    protected long lastUpdated()
        throws Exception
    {
        return SyncManagerUtils.getLastUpdatedForInAppMessage(daoInAppMessage);
    }



}
