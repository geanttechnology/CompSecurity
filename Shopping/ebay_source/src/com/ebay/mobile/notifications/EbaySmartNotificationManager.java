// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import com.ebay.common.Preferences;
import com.ebay.common.util.EnvironmentUtils;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.ServiceStarter;
import com.ebay.mobile.common.EbayUtil;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.providers.ItemCacheProvider;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.app.BaseIntentService;
import com.ebay.nautilus.shell.app.FwContext;
import com.google.android.gcm.GCMRegistrar;

// Referenced classes of package com.ebay.mobile.notifications:
//            NotificationPreferenceManager, NotificationUtil, PollServiceListCache, ItemCache, 
//            SharedWakeLock, NotificationTrackingUtil

public class EbaySmartNotificationManager extends BaseIntentService
{
    public static final class NotificationType extends Enum
    {

        private static final NotificationType $VALUES[];
        public static final NotificationType C2DM;
        public static final NotificationType GCM;
        public static final NotificationType GOOGLE_NOW;
        public static final NotificationType POLL;
        private String value;

        public static NotificationType valueOf(String s)
        {
            return (NotificationType)Enum.valueOf(com/ebay/mobile/notifications/EbaySmartNotificationManager$NotificationType, s);
        }

        public static NotificationType[] values()
        {
            return (NotificationType[])$VALUES.clone();
        }

        public String getValue()
        {
            return value;
        }

        static 
        {
            POLL = new NotificationType("POLL", 0, "POLL");
            C2DM = new NotificationType("C2DM", 1, "C2DM");
            GCM = new NotificationType("GCM", 2, "GCM");
            GOOGLE_NOW = new NotificationType("GOOGLE_NOW", 3, "GOOGLE_NOW");
            $VALUES = (new NotificationType[] {
                POLL, C2DM, GCM, GOOGLE_NOW
            });
        }

        private NotificationType(String s, int i, String s1)
        {
            super(s, i);
            value = s1;
        }
    }


    public static final int ACTION_ACTIVATE_MDNS = 10;
    public static final int ACTION_C2DM_FAILED = 9;
    public static final int ACTION_DCS_CHANGED = 11;
    public static final int ACTION_DISABLE_POLLING = 14;
    public static final int ACTION_ENABLE_POLLING = 13;
    public static final int ACTION_GCM_FAILED = 8;
    public static final int ACTION_RAMP_DOWN = 6;
    public static final int ACTION_RAMP_UP = 5;
    public static final int ACTION_SETUP = 1;
    public static final int ACTION_SET_CURRENT_CONFIG = 4;
    public static final int ACTION_START_GCM = 7;
    public static final int ACTION_START_POLLING = 2;
    public static final int ACTION_STOP = 12;
    public static final int ACTION_STOP_POLLING = 3;
    public static final String AUTH_CORE = "authCore";
    public static final String CLIENT_ID_AEAPP_BB = "AEAPP_BB";
    public static final String CLIENT_ID_AEAPP_GCM = "AEAPP_GCM";
    public static final String CLIENT_ID_AMOTORS_BB = "AMOTORS_BB";
    public static final String CLIENT_ID_AMOTORS_GCM = "AMOTORS_GCM";
    public static final String CLIENT_ID_GOOGLENOW = "GOOGLENOW";
    public static final String INTENT_FORCE_ACTIVATE = "force_activate";
    public static final int TRANSITION_OFF = 0;
    public static final int TRANSITION_STATE_C2DM = 2;
    public static final int TRANSITION_STATE_GCM = 1;
    public static final int TRANSITION_STATE_POLL = 3;
    private static volatile ItemCache cache;
    private static boolean inTransition = false;
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logMethod = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("ESNM", 3, "Smart Notifications Method");
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("ESNM", 3, "Smart Notifications");
    private static Object syncObject = new Object();
    private static int transitionState;
    private boolean deviceSupportsC2DM;
    private boolean deviceSupportsGCM;

    public EbaySmartNotificationManager()
    {
        super("ESNM");
        deviceSupportsGCM = false;
        deviceSupportsC2DM = false;
        if (logMethod.isLoggable)
        {
            FwLog.logMethod(logMethod, new Object[0]);
        }
    }

    public static boolean activateAndSetMdnsPrefs(Context context, NotificationType notificationtype)
    {
        if (logMethod.isLoggable)
        {
            FwLog.logMethod(logMethod, new Object[] {
                notificationtype
            });
        }
        Authentication authentication = getAuth();
        if (authentication == null)
        {
            if (logTag.isLoggable)
            {
                FwLog.println(logTag, "activateAndSetMdnsPrefs: not signed in, exiting");
            }
            return false;
        }
        NotificationPreferenceManager notificationpreferencemanager = new NotificationPreferenceManager(context);
        notificationpreferencemanager.setInactiveWithMdns(authentication.user, NotificationUtil.getClientIdForNotificationType(notificationtype, "AEAPP"));
        notificationpreferencemanager.setInactiveWithMdns(authentication.user, NotificationUtil.getClientIdForNotificationType(notificationtype, "AMOTORS"));
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, (new StringBuilder()).append("activate: get and saved new REG ID, calling load, type=").append(notificationtype.getValue()).append(";uid=").append(authentication.user).append(";regid=").append(getRegistrationId(context, notificationtype, authentication.user)).toString());
        }
        boolean flag = NotificationUtil.activateAndSetMdnsPrefs(context, notificationtype);
        try
        {
            PollServiceListCache.refreshSavedSearchList(context, ((FwContext)context).getEbayContext(), authentication.iafToken);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            FwLog.println(logTag, "refreshSavedSearchList threw exception", context);
            return flag;
        }
        return flag;
    }

    private void c2dmFailed()
    {
        if (logMethod.isLoggable)
        {
            FwLog.logMethod(logMethod, new Object[0]);
        }
        startPolling();
    }

    public static boolean canIgnoreC2DMStateViaDCS()
    {
        return EnvironmentUtils.isBlackberry();
    }

    private void dcsChanged(Context context)
    {
        Object obj;
        boolean flag;
        flag = false;
        if (logMethod.isLoggable)
        {
            FwLog.logMethod(logMethod, new Object[0]);
        }
        Authentication authentication = getAuth();
        obj = authentication;
        if (authentication == null)
        {
            obj = MyApp.getPrefs().getAuthentication();
        }
        if (obj != null) goto _L2; else goto _L1
_L1:
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "dcsChanged but we are not logged in, ignoring");
        }
_L8:
        return;
_L2:
        NotificationType notificationtype;
        boolean flag1;
        obj = DeviceConfiguration.getAsync();
        notificationtype = getCurrentConfiguration(context);
        flag1 = ((DeviceConfiguration) (obj)).get(DcsBoolean.GCM);
        if (canIgnoreC2DMStateViaDCS() || ((DeviceConfiguration) (obj)).get(DcsBoolean.C2DM))
        {
            flag = true;
        }
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$mobile$notifications$EbaySmartNotificationManager$NotificationType[];

            static 
            {
                $SwitchMap$com$ebay$mobile$notifications$EbaySmartNotificationManager$NotificationType = new int[NotificationType.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$notifications$EbaySmartNotificationManager$NotificationType[NotificationType.C2DM.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$notifications$EbaySmartNotificationManager$NotificationType[NotificationType.GCM.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$notifications$EbaySmartNotificationManager$NotificationType[NotificationType.POLL.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.ebay.mobile.notifications.EbaySmartNotificationManager.NotificationType[notificationtype.ordinal()];
        JVM INSTR tableswitch 1 3: default 132
    //                   1 133
    //                   2 174
    //                   3 227;
           goto _L3 _L4 _L5 _L6
_L6:
        continue; /* Loop/switch isn't completed */
_L3:
        return;
_L4:
        if (flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (flag1 && deviceSupportsGCM)
        {
            if (logTag.isLoggable)
            {
                FwLog.println(logTag, "DCS disabled C2DM and we are using C2DM, attempt to ramp up to GCM");
            }
            rampUp(context);
            return;
        }
        break; /* Loop/switch isn't completed */
_L5:
        if (!flag1)
        {
            if (logTag.isLoggable)
            {
                FwLog.println(logTag, "DCS disabled GCM and we are using GCM, attempt to ramp down");
            }
            rampDown(context);
            return;
        }
        if (true) goto _L8; else goto _L7
_L7:
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "DCS disabled C2DM and we are using C2DM, attempt to ramp down");
        }
        rampDown(context);
        return;
        if (((DeviceConfiguration) (obj)).get(DcsBoolean.Polling)) goto _L8; else goto _L9
_L9:
        stopPolling();
        return;
    }

    private void deleteCurrentConfiguration()
    {
        if (logMethod.isLoggable)
        {
            FwLog.logMethod(logMethod, new Object[0]);
        }
        Object obj = syncObject;
        obj;
        JVM INSTR monitorenter ;
        ContentResolver contentresolver = getContentResolver();
        contentresolver.delete(ItemCacheProvider.MISC_CONTENT_URI, "name=?", new String[] {
            "ESNM"
        });
_L1:
        return;
        Object obj1;
        obj1;
        Log.e("ESNM", "deleteCurrentConfiguration: unable to save state", ((Throwable) (obj1)));
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    private void determineNotificationPlatformAvailability()
    {
        if (logMethod.isLoggable)
        {
            FwLog.logMethod(logMethod, new Object[0]);
        }
        deviceSupportsGCM = isGCMSupportOnDevice(this);
        deviceSupportsC2DM = EbayUtil.deviceSupportsC2dm();
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, (new StringBuilder()).append("Device supports C2DM=").append(deviceSupportsC2DM).toString());
        }
    }

    private void disablePolling()
    {
        if (logMethod.isLoggable)
        {
            FwLog.logMethod(logMethod, new Object[0]);
        }
        ServiceStarter.startPollService(this, "com.ebay.mobile.service.DISABLE_POLLING");
    }

    private void enablePolling()
    {
        if (logMethod.isLoggable)
        {
            FwLog.logMethod(logMethod, new Object[0]);
        }
        ServiceStarter.startPollService(this, "com.ebay.mobile.service.ENABLE_POLLING");
    }

    private void gcmNotAvailableOrFailed()
    {
        if (logMethod.isLoggable)
        {
            FwLog.logMethod(logMethod, new Object[0]);
        }
        startPolling();
    }

    private static Authentication getAuth()
    {
        return MyApp.getPrefs().getAuthentication();
    }

    public static NotificationType getCurrentConfiguration(Context context)
    {
        if (logMethod.isLoggable)
        {
            FwLog.logMethod(logMethod, new Object[0]);
        }
        Object obj1 = syncObject;
        obj1;
        JVM INSTR monitorenter ;
        Object obj2 = context.getContentResolver();
        Object obj;
        context = null;
        obj = null;
        obj2 = ((ContentResolver) (obj2)).query(ItemCacheProvider.MISC_CONTENT_URI, ItemCacheProvider.MISC_COLUMNS, "name= ?", new String[] {
            "ESNM"
        }, null);
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        context = ((Context) (obj));
        if (!((Cursor) (obj2)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_134;
        }
        obj = ((Cursor) (obj2)).getString(((Cursor) (obj2)).getColumnIndex("value"));
        context = ((Context) (obj));
        if (!logTag.isLoggable)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        FwLog.println(logTag, (new StringBuilder()).append("DB returned ").append(((String) (obj))).append(" for ESNM current type").toString());
        context = ((Context) (obj));
        ((Cursor) (obj2)).close();
        obj = context;
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "null read from db for current type, defaulting to POLL");
        }
        obj = NotificationType.POLL.getValue();
        context = NotificationType.valueOf(((String) (obj)));
        obj1;
        JVM INSTR monitorexit ;
        return context;
        context;
        ((Cursor) (obj2)).close();
        throw context;
        context;
        obj1;
        JVM INSTR monitorexit ;
        throw context;
    }

    private static String getRegistrationId(Context context, NotificationType notificationtype, String s)
    {
        if (cache == null)
        {
            cache = new ItemCache(context);
        }
        switch (_cls1..SwitchMap.com.ebay.mobile.notifications.EbaySmartNotificationManager.NotificationType[notificationtype.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return cache.getRegistrationId(s);

        case 2: // '\002'
            return cache.getGCMRegistrationId(s);
        }
    }

    public static int getTransitionState()
    {
        if (logMethod.isLoggable)
        {
            FwLog.logMethod(logMethod, new Object[0]);
        }
        int i;
        synchronized (syncObject)
        {
            i = transitionState;
        }
        return i;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static boolean isGCMSupportOnDevice(Context context)
    {
        boolean flag2;
        flag2 = true;
        if (logMethod.isLoggable)
        {
            FwLog.logMethod(logMethod, new Object[0]);
        }
        if (!EnvironmentUtils.isBlackberry()) goto _L2; else goto _L1
_L1:
        long l;
        return false;
_L2:
        if (System.currentTimeMillis() - (l = MyApp.getPrefs().getUserPref("notifications_timestamp_of_last_service_failure", 0L)) < 0x1499700L) goto _L1; else goto _L3
_L3:
        GCMRegistrar.checkDevice(context);
        boolean flag = true;
_L4:
        boolean flag1;
        if (logTag.isLoggable)
        {
            context = logTag;
            StringBuilder stringbuilder = (new StringBuilder()).append("Device supports GCM=");
            if (flag)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            FwLog.println(context, stringbuilder.append(flag1).toString());
        }
        if (flag)
        {
            flag1 = flag2;
        } else
        {
            flag1 = false;
        }
        return flag1;
        context;
        flag = false;
          goto _L4
    }

    public static boolean isInTransition()
    {
        if (logMethod.isLoggable)
        {
            FwLog.logMethod(logMethod, new Object[0]);
        }
        boolean flag;
        synchronized (syncObject)
        {
            flag = inTransition;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void markComplete()
    {
        setTransition(false, 0);
    }

    private void rampDown(Context context)
    {
        if (logMethod.isLoggable)
        {
            FwLog.logMethod(logMethod, new Object[0]);
        }
        if (getCurrentConfiguration(context) == NotificationType.POLL)
        {
            if (logTag.isLoggable)
            {
                FwLog.println(logTag, "rampDown called but we're already polling");
            }
        } else
        {
            Object obj = getCurrentConfiguration(context);
            if (deactivateWithMDNS(context, ((NotificationType) (obj))))
            {
                if (logTag.isLoggable)
                {
                    FwLog.println(logTag, (new StringBuilder()).append("Successfully deactivated ").append(((NotificationType) (obj)).getValue()).append(" with MDNS").toString());
                }
                switch (_cls1..SwitchMap.com.ebay.mobile.notifications.EbaySmartNotificationManager.NotificationType[((NotificationType) (obj)).ordinal()])
                {
                default:
                    return;

                case 1: // '\001'
                    startPolling();
                    return;

                case 2: // '\002'
                    GCMRegistrar.unregister(context);
                    break;
                }
                obj = getAuth();
                context = ((Context) (obj));
                if (obj == null)
                {
                    context = MyApp.getPrefs().getAuthentication();
                }
                if (context != null)
                {
                    if (cache == null)
                    {
                        cache = new ItemCache(this);
                    }
                    cache.setGCMRegistrationId(((Authentication) (context)).user, null);
                    cache.setRegistrationId(((Authentication) (context)).user, null);
                }
                startPolling();
                return;
            }
            if (logTag.isLoggable)
            {
                FwLog.println(logTag, (new StringBuilder()).append("Failed to deactivate ").append(((NotificationType) (obj)).getValue()).append(" with MDNS, aborting rampDown").toString());
                return;
            }
        }
    }

    private void rampUp(Context context)
    {
        if (logMethod.isLoggable)
        {
            FwLog.logMethod(logMethod, new Object[0]);
        }
        if (getCurrentConfiguration(context) != NotificationType.GCM) goto _L2; else goto _L1
_L1:
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "rampUp called but we're already using GCM");
        }
_L4:
        return;
_L2:
        NotificationType notificationtype;
        DeviceConfiguration deviceconfiguration;
        notificationtype = getCurrentConfiguration(context);
        deviceconfiguration = DeviceConfiguration.getAsync();
        if (notificationtype != NotificationType.C2DM || deviceSupportsGCM && deviceconfiguration.get(DcsBoolean.GCM))
        {
            break; /* Loop/switch isn't completed */
        }
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "rampUp called but we are using C2DM and device does not support GCM or DCS disabled GCM");
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (notificationtype != NotificationType.POLL || deviceSupportsGCM && deviceconfiguration.get(DcsBoolean.GCM))
        {
            break; /* Loop/switch isn't completed */
        }
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "rampUp called but we are using polling and device does not support GCM or DCS disabled GCM");
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
        boolean flag;
        if (notificationtype == NotificationType.POLL)
        {
            flag = true;
        } else
        {
            flag = deactivateWithMDNS(context, notificationtype);
        }
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (logTag.isLoggable && notificationtype != NotificationType.POLL)
        {
            FwLog.println(logTag, (new StringBuilder()).append("Successfully deactivated ").append(notificationtype.getValue()).append(" with MDNS").toString());
        }
        if (deviceconfiguration.get(DcsBoolean.GCM) && deviceSupportsGCM && startGCM() || !logTag.isLoggable) goto _L4; else goto _L6
_L6:
        FwLog.println(logTag, "rampUp didn't attempt to ramp to GCM - GCM is disabled or device doesn't support it");
        return;
        if (!logTag.isLoggable) goto _L4; else goto _L7
_L7:
        FwLog.println(logTag, (new StringBuilder()).append("Failed to deactivate ").append(notificationtype.getValue()).append(" with MDNS, aborting rampUp").toString());
        return;
    }

    private void setCurrentConfiguration(NotificationType notificationtype)
    {
        if (logMethod.isLoggable)
        {
            FwLog.logMethod(logMethod, new Object[] {
                notificationtype
            });
        }
        Object obj = syncObject;
        obj;
        JVM INSTR monitorenter ;
        ContentResolver contentresolver;
        ContentValues contentvalues;
        contentresolver = getContentResolver();
        contentvalues = new ContentValues();
        contentvalues.put("name", "ESNM");
        contentvalues.put("value", notificationtype.getValue());
        contentresolver.delete(ItemCacheProvider.MISC_CONTENT_URI, "name=?", new String[] {
            "ESNM"
        });
        contentresolver.insert(ItemCacheProvider.MISC_CONTENT_URI, contentvalues);
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, (new StringBuilder()).append("Using ").append(notificationtype.getValue()).append(" for notifications").toString());
        }
_L1:
        return;
        notificationtype;
        Log.e("ESNM", "setCurrentConfiguration: unable to save state", notificationtype);
          goto _L1
        notificationtype;
        obj;
        JVM INSTR monitorexit ;
        throw notificationtype;
    }

    public static void setTransition(boolean flag, int i)
    {
        if (logMethod.isLoggable)
        {
            FwLog.logMethod(logMethod, new Object[] {
                Boolean.valueOf(flag), Integer.valueOf(i)
            });
        }
        Object obj = syncObject;
        obj;
        JVM INSTR monitorenter ;
        inTransition = flag;
        if (!inTransition)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        transitionState = i;
_L2:
        return;
        transitionState = 0;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void setupNotifications()
    {
        if (logMethod.isLoggable)
        {
            FwLog.logMethod(logMethod, new Object[0]);
        }
        if (isInTransition())
        {
            if (logTag.isLoggable)
            {
                FwLog.println(logTag, "We are in transition, exiting");
            }
            return;
        }
        determineNotificationPlatformAvailability();
        if (DeviceConfiguration.getAsync().get(DcsBoolean.GCM) && deviceSupportsGCM && startGCM())
        {
            setTransition(true, 1);
            return;
        } else
        {
            gcmNotAvailableOrFailed();
            return;
        }
    }

    private boolean startGCM()
    {
        Object obj;
        if (logMethod.isLoggable)
        {
            FwLog.logMethod(logMethod, new Object[0]);
        }
        obj = getAuth();
        if (obj == null)
        {
            if (logTag.isLoggable)
            {
                FwLog.println(logTag, "startGCM: not signed in, exiting");
            }
            return false;
        }
        DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
        if (!deviceSupportsGCM || !deviceconfiguration.get(DcsBoolean.GCM))
        {
            if (logTag.isLoggable)
            {
                FwLog.println(logTag, "startGCM: device does not support GCM or DCS disabled");
            }
            return false;
        }
label0:
        {
            setTransition(true, 1);
            String s = GCMRegistrar.getRegistrationId(this);
            if (s.equals(""))
            {
                GCMRegistrar.register(getApplicationContext(), new String[] {
                    "953932623788"
                });
                break label0;
            }
            try
            {
                if (logTag.isLoggable)
                {
                    FwLog.println(logTag, "Already registered with GCM");
                }
                if (cache == null)
                {
                    cache = new ItemCache(this);
                }
                cache.setGCMRegistrationId(((Authentication) (obj)).user, s);
                obj = new Bundle();
                ((Bundle) (obj)).putSerializable("type", NotificationType.GCM);
                ServiceStarter.instructNotificationManagerService(this, 10, ((Bundle) (obj)));
            }
            catch (Exception exception)
            {
                FwLog.println(logTag, "GCM exception", exception);
            }
        }
        return true;
    }

    private void startPolling()
    {
        if (logMethod.isLoggable)
        {
            FwLog.logMethod(logMethod, new Object[0]);
        }
        Authentication authentication = getAuth();
        if (authentication != null)
        {
            setTransition(true, 3);
            NotificationPreferenceManager notificationpreferencemanager = new NotificationPreferenceManager(this);
            notificationpreferencemanager.setInactiveWithMdns(authentication.user, "AEAPP");
            notificationpreferencemanager.setInactiveWithMdns(authentication.user, "AMOTORS");
            ServiceStarter.startPollService(this, "com.ebay.mobile.service.SET_PREFERENCES");
        }
    }

    private void startPollingForPush()
    {
        if (logMethod.isLoggable)
        {
            FwLog.logMethod(logMethod, new Object[0]);
        }
        ServiceStarter.startPollService(this, "com.ebay.mobile.service.WAKE_UP_SOON");
    }

    private void stopNotifications(Authentication authentication)
    {
        if (logMethod.isLoggable)
        {
            FwLog.logMethod(logMethod, new Object[0]);
        }
        if (authentication != null)
        {
            NotificationUtil.stopNotification(this, getCurrentConfiguration(this), authentication);
            deleteCurrentConfiguration();
        }
        disablePolling();
        setTransition(false, 0);
        if (DeviceConfiguration.getAsync().get(DcsBoolean.LocalNotifications))
        {
            if (cache == null)
            {
                cache = new ItemCache(this);
            }
            if (logTag.isLoggable)
            {
                FwLog.println(logTag, "Deleting local notifications items due to signout");
            }
            cache.deleteAllLocalNotificationsItem();
        }
    }

    private void stopPolling()
    {
        if (logMethod.isLoggable)
        {
            FwLog.logMethod(logMethod, new Object[0]);
        }
        ServiceStarter.startPollService(this, "com.ebay.mobile.service.DISABLE_NOTIFICATIONS");
    }

    public boolean deactivateWithMDNS(Context context, NotificationType notificationtype)
    {
        return NotificationUtil.deactivateMdns(this, notificationtype, getAuth(), "AEAPP", "C2DM");
    }

    public void onCreate()
    {
        super.onCreate();
        if (logMethod.isLoggable)
        {
            FwLog.logMethod(logMethod, new Object[0]);
        }
        NotificationType notificationtype = getCurrentConfiguration(this);
        setCurrentConfiguration(notificationtype);
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, (new StringBuilder()).append("currentType=").append(notificationtype).toString());
        }
        cache = new ItemCache(this);
        determineNotificationPlatformAvailability();
    }

    protected void onHandleIntent(Intent intent)
    {
        if (intent != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        boolean flag;
        int i;
        i = intent.getIntExtra("push_action", -1);
        if (logMethod.isLoggable)
        {
            FwLog.logMethod(logMethod, new Object[] {
                Integer.valueOf(i)
            });
        }
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, (new StringBuilder()).append("onHandleIntent: action=").append(i).append(", intent data=").append(intent.getExtras().toString()).toString());
        }
        boolean flag1 = false;
        flag = flag1;
        if (i == 1)
        {
            flag = flag1;
            if (intent.getBooleanExtra("not_release_wakelock", false))
            {
                flag = true;
            }
        }
        NotificationPreferenceManager notificationpreferencemanager;
        Bundle bundle;
        bundle = intent.getBundleExtra("not_mgr_bundle");
        notificationpreferencemanager = new NotificationPreferenceManager(this);
        intent = getAuth();
        i;
        JVM INSTR tableswitch 1 14: default 220
    //                   1 247
    //                   2 452
    //                   3 459
    //                   4 480
    //                   5 544
    //                   6 552
    //                   7 560
    //                   8 568
    //                   9 575
    //                   10 582
    //                   11 813
    //                   12 821
    //                   13 466
    //                   14 473;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17
_L3:
        if (flag)
        {
            if (logTag.isLoggable)
            {
                FwLog.println(logTag, "Releasing WakeLock per intent instruction");
            }
            SharedWakeLock.releaseLock();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        Object obj = intent;
        if (intent != null) goto _L19; else goto _L18
_L18:
        obj = intent;
        if (bundle == null) goto _L19; else goto _L20
_L20:
        obj = (Authentication)bundle.getParcelable("authCore");
_L19:
        if (!Util.hasNetwork() || obj == null) goto _L3; else goto _L21
_L21:
        boolean flag3;
        boolean flag4;
        flag3 = EbayUtil.isPushActive(this, ((Authentication) (obj)).user, "AEAPP");
        flag4 = notificationpreferencemanager.hasSimplifiedSettingsUpgrades(((Authentication) (obj)).user);
        boolean flag2 = true;
        if (flag4) goto _L23; else goto _L22
_L22:
        notificationpreferencemanager.upgradeNotificationPreferences(((Authentication) (obj)).user);
        notificationpreferencemanager.removeMdnsActivationTime(((Authentication) (obj)).user, "AEAPP");
_L25:
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, (new StringBuilder()).append("ACTION_SETUP: pushActive=").append(flag3).append(";timeToActivate=").append(flag2).toString());
        }
          goto _L24
_L40:
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "ACTION_SETUP: calling setupNotifications");
        }
        setupNotifications();
_L41:
        startPollingForPush();
          goto _L3
        intent;
        if (flag)
        {
            if (logTag.isLoggable)
            {
                FwLog.println(logTag, "Releasing WakeLock per intent instruction");
            }
            SharedWakeLock.releaseLock();
        } else
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "NOT releasing WakeLock");
        }
        throw intent;
_L23:
        flag2 = notificationpreferencemanager.isTimeToActivateWithMdns(((Authentication) (obj)).user, "AEAPP");
          goto _L25
_L5:
        startPolling();
          goto _L3
_L6:
        stopPolling();
          goto _L3
_L16:
        enablePolling();
          goto _L3
_L17:
        disablePolling();
          goto _L3
_L7:
        if (bundle == null) goto _L3; else goto _L26
_L26:
        setCurrentConfiguration((NotificationType)bundle.getSerializable("type"));
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "setCurrentConfiguration: finally set loading state ready");
        }
        if (cache == null)
        {
            cache = new ItemCache(this);
        }
        cache.setSettingsLoadingReady();
          goto _L3
_L8:
        rampUp(this);
          goto _L3
_L9:
        rampDown(this);
          goto _L3
_L10:
        startGCM();
          goto _L3
_L11:
        gcmNotAvailableOrFailed();
          goto _L3
_L12:
        c2dmFailed();
          goto _L3
_L13:
        flag2 = Util.hasNetwork();
        if (flag2) goto _L28; else goto _L27
_L27:
        if (flag)
        {
            if (logTag.isLoggable)
            {
                FwLog.println(logTag, "Releasing WakeLock per intent instruction");
            }
            SharedWakeLock.releaseLock();
            return;
        }
        if (!logTag.isLoggable) goto _L1; else goto _L29
_L29:
        FwLog.println(logTag, "NOT releasing WakeLock");
        return;
_L28:
        if (bundle == null || intent == null) goto _L3; else goto _L30
_L30:
        if (!bundle.getBoolean("force_activate", false) && EbayUtil.isPushActive(this, ((Authentication) (intent)).user, "AEAPP") && !notificationpreferencemanager.isTimeToActivateWithMdns(((Authentication) (intent)).user, "AEAPP")) goto _L32; else goto _L31
_L31:
        obj = (NotificationType)bundle.getSerializable("type");
        if (!activateAndSetMdnsPrefs(this, ((NotificationType) (obj))))
        {
            break MISSING_BLOCK_LABEL_759;
        }
        notificationpreferencemanager.setLastActivationTimeMdns(((Authentication) (intent)).user, "AEAPP", System.currentTimeMillis());
        markComplete();
        startPollingForPush();
        intent = DeviceConfiguration.getAsync();
        if (obj == NotificationType.GCM && intent.get(DcsBoolean.NotificationTracking))
        {
            NotificationTrackingUtil.sendEvent(this, NotificationTrackingUtil.createNotificationModeChangeTrackingData("1"));
        }
          goto _L3
        _cls1..SwitchMap.com.ebay.mobile.notifications.EbaySmartNotificationManager.NotificationType[((NotificationType) (obj)).ordinal()];
        JVM INSTR tableswitch 1 2: default 904
    //                   1 788
    //                   2 795;
           goto _L33 _L34 _L35
_L33:
        if (true) goto _L3; else goto _L36
_L36:
_L34:
        c2dmFailed();
          goto _L3
_L35:
        gcmNotAvailableOrFailed();
          goto _L3
_L32:
        markComplete();
        startPollingForPush();
          goto _L3
_L14:
        dcsChanged(this);
          goto _L3
_L15:
        if (bundle == null) goto _L38; else goto _L37
_L37:
        stopNotifications((Authentication)bundle.getParcelable("authCore"));
          goto _L3
_L38:
        stopNotifications(intent);
          goto _L3
        if (!logTag.isLoggable) goto _L1; else goto _L39
_L39:
        FwLog.println(logTag, "NOT releasing WakeLock");
        return;
_L24:
        if (flag3 && !flag2) goto _L41; else goto _L40
    }

}
