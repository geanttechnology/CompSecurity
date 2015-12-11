// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.ebay.common.Preferences;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.notifications.EbaySmartNotificationManager;
import com.ebay.mobile.notifications.ItemCache;
import com.ebay.mobile.notifications.NotificationPreferenceManager;
import com.ebay.mobile.notifications.NotificationUtil;
import com.ebay.mobile.notifications.PushService;
import com.ebay.mobile.notifications.SharedWakeLock;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.app.FwService;
import com.google.android.gcm.GCMBaseIntentService;

// Referenced classes of package com.ebay.mobile:
//            MyApp, ServiceStarter

public class GCMIntentService extends GCMBaseIntentService
    implements FwService
{

    public static final String SENDER_ID = "953932623788";
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("GCMIntentService", 3, "GCM Intent Service");
    private com.ebay.nautilus.shell.app.FwService.ServiceContext serviceContext;

    public GCMIntentService()
    {
        super("953932623788");
    }

    public final EbayContext getEbayContext()
    {
        this;
        JVM INSTR monitorenter ;
        com.ebay.nautilus.shell.app.FwService.ServiceContext servicecontext;
        if (serviceContext == null)
        {
            serviceContext = new com.ebay.nautilus.shell.app.FwService.ServiceContext(this);
        }
        servicecontext = serviceContext;
        this;
        JVM INSTR monitorexit ;
        return servicecontext;
        Exception exception;
        exception;
        throw exception;
    }

    protected void onError(Context context, String s)
    {
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[] {
                s
            });
        }
        if (MyApp.getPrefs().getAuthentication() == null)
        {
            FwLog.println(logTag, (new StringBuilder()).append("onError: errorId=").append(s).toString());
        } else
        if (EbaySmartNotificationManager.getTransitionState() == 1)
        {
            ServiceStarter.instructNotificationManagerService(context, 8);
            return;
        }
    }

    protected void onMessage(Context context, Intent intent)
    {
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "received GCM message");
        }
        String s = intent.getStringExtra("clientid");
        if (s != null && !s.contains("_GCM"))
        {
            if (logTag.isLoggable)
            {
                FwLog.println(logTag, (new StringBuilder()).append("Discarding as client_id=").append(s).toString());
            }
        } else
        {
            com.ebay.mobile.notifications.EbaySmartNotificationManager.NotificationType notificationtype = EbaySmartNotificationManager.getCurrentConfiguration(this);
            if (notificationtype == com.ebay.mobile.notifications.EbaySmartNotificationManager.NotificationType.GCM)
            {
                SharedWakeLock.acquireLock(context);
                PushService.processNotification(intent, this, com.ebay.mobile.notifications.EbaySmartNotificationManager.NotificationType.GCM);
                SharedWakeLock.releaseLock();
                return;
            }
            if (notificationtype == com.ebay.mobile.notifications.EbaySmartNotificationManager.NotificationType.POLL && !EbaySmartNotificationManager.isInTransition())
            {
                if (logTag.isLoggable)
                {
                    FwLog.println(logTag, "ESNM reports POLL as current type, attempting to recover");
                }
                ServiceStarter.startNotificationManagerService(this);
                return;
            }
            if (logTag.isLoggable)
            {
                FwLog.println(logTag, (new StringBuilder()).append("Discarding as ESNM reports current configuration as:").append(notificationtype).toString());
                return;
            }
        }
    }

    protected boolean onRecoverableError(Context context, String s)
    {
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[] {
                s
            });
        }
        ServiceStarter.instructNotificationManagerService(context, 7);
        return true;
    }

    protected void onRegistered(Context context, String s)
    {
        Authentication authentication;
        boolean flag;
        flag = false;
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[] {
                s
            });
        }
        authentication = MyApp.getPrefs().getAuthentication();
        if (authentication != null) goto _L2; else goto _L1
_L1:
        FwLog.println(logTag, "register: not signed in, exiting");
_L4:
        return;
_L2:
        if (DeviceConfiguration.getAsync().get(DcsBoolean.GCM))
        {
            break; /* Loop/switch isn't completed */
        }
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "onRegistered called but GCM disabled via DCS");
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        ItemCache itemcache = new ItemCache(context);
        context = itemcache.getGCMRegistrationId(authentication.user);
        if (!s.equals(context))
        {
            flag = true;
        }
        if (flag && !TextUtils.isEmpty(context))
        {
            NotificationUtil.deactivateMdnsOldToken(this, context, com.ebay.mobile.notifications.EbaySmartNotificationManager.NotificationType.GCM);
        }
        itemcache.setGCMRegistrationId(authentication.user, s);
        if (flag || EbaySmartNotificationManager.getTransitionState() == 1)
        {
            s = new Bundle();
            s.putSerializable("type", com.ebay.mobile.notifications.EbaySmartNotificationManager.NotificationType.GCM);
            if (flag && !TextUtils.isEmpty(context))
            {
                s.putBoolean("force_activate", true);
            }
            ServiceStarter.instructNotificationManagerService(this, 10, s);
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    protected void onUnregistered(Context context, String s)
    {
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "onUnregistered GCM");
        }
        NotificationUtil.deactivateMdns(this, com.ebay.mobile.notifications.EbaySmartNotificationManager.NotificationType.GCM, MyApp.getPrefs().getAuthentication(), "AEAPP", "C2DM");
        s = new NotificationPreferenceManager(context);
        Authentication authentication = MyApp.getPrefs().getAuthentication();
        if (authentication == null)
        {
            FwLog.println(logTag, "unregister: not signed in, exiting");
            return;
        } else
        {
            s.unregister(authentication.user);
            (new ItemCache(context)).removeAllData();
            return;
        }
    }

}
