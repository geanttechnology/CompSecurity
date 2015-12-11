// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import com.ebay.mobile.analytics.AnalyticsUtil;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.notifications:
//            DevLog, EbaySmartNotificationManager

public class NotificationTrackingUtil
{
    public static final class ErrorType extends Enum
    {

        private static final ErrorType $VALUES[];
        public static final ErrorType DUPLICATE_NOTIFICATION;
        public static final ErrorType MISMATCHED_TOKENS;
        public static final ErrorType MISMATCHED_USERS;
        public static final ErrorType MISSING_EVENT_TYPE;
        public static final ErrorType NOT_LOGGED_IN;
        public static final ErrorType NO_USERNAME;
        public static final ErrorType REF_ID_EMPTY;
        public final String name;

        public static ErrorType valueOf(String s)
        {
            return (ErrorType)Enum.valueOf(com/ebay/mobile/notifications/NotificationTrackingUtil$ErrorType, s);
        }

        public static ErrorType[] values()
        {
            return (ErrorType[])$VALUES.clone();
        }

        static 
        {
            NO_USERNAME = new ErrorType("NO_USERNAME", 0, "N001");
            NOT_LOGGED_IN = new ErrorType("NOT_LOGGED_IN", 1, "N002");
            MISMATCHED_USERS = new ErrorType("MISMATCHED_USERS", 2, "N003");
            REF_ID_EMPTY = new ErrorType("REF_ID_EMPTY", 3, "N004");
            MISMATCHED_TOKENS = new ErrorType("MISMATCHED_TOKENS", 4, "N005");
            MISSING_EVENT_TYPE = new ErrorType("MISSING_EVENT_TYPE", 5, "N006");
            DUPLICATE_NOTIFICATION = new ErrorType("DUPLICATE_NOTIFICATION", 6, "N007");
            $VALUES = (new ErrorType[] {
                NO_USERNAME, NOT_LOGGED_IN, MISMATCHED_USERS, REF_ID_EMPTY, MISMATCHED_TOKENS, MISSING_EVENT_TYPE, DUPLICATE_NOTIFICATION
            });
        }

        private ErrorType(String s, int i, String s1)
        {
            super(s, i);
            name = s1;
        }
    }

    public static final class EventType extends Enum
    {

        private static final EventType $VALUES[];
        public static final EventType CLEARED;
        public static final EventType RECEIVED;
        public static final EventType SETTING_DISABLED;
        public static final EventType SETTING_ENABLED;
        public final int id;

        public static EventType valueOf(String s)
        {
            return (EventType)Enum.valueOf(com/ebay/mobile/notifications/NotificationTrackingUtil$EventType, s);
        }

        public static EventType[] values()
        {
            return (EventType[])$VALUES.clone();
        }

        static 
        {
            RECEIVED = new EventType("RECEIVED", 0, 0);
            SETTING_ENABLED = new EventType("SETTING_ENABLED", 1, 1);
            SETTING_DISABLED = new EventType("SETTING_DISABLED", 2, 2);
            CLEARED = new EventType("CLEARED", 3, 3);
            $VALUES = (new EventType[] {
                RECEIVED, SETTING_ENABLED, SETTING_DISABLED, CLEARED
            });
        }

        private EventType(String s, int i, int j)
        {
            super(s, i);
            id = j;
        }
    }


    public static final String KEY_APN = "apn";
    public static final String KEY_DNTYPE = "dntype";
    public static final String KEY_ENTYPE = "entype";
    public static final String KEY_NC = "nc";
    public static final String KEY_NID = "nid";
    public static final String KEY_NMODE = "nmode";
    public static final String KEY_NOTIFY_TAP = "notifyTap";
    public static final String KEY_NTYPE = "ntype";
    public static final String KEY_PNACT = "pnact";
    public static final String NMODE_POLL = "0";
    public static final String NMODE_PUSH = "1";
    public static final int NOTIFY_TAP_BUY_IT_NOW = 5;
    public static final int NOTIFY_TAP_HEADER = 0;
    public static final int NOTIFY_TAP_IMAGE = 1;
    public static final int NOTIFY_TAP_PLACE_BID = 3;
    public static final int NOTIFY_TAP_RAISE_BID = 4;
    public static final int NOTIFY_TAP_VIEW_ITEM = 2;
    public static final String PNACT_CANCEL = "0";
    public static final String PNACT_OPEN = "1";

    public NotificationTrackingUtil()
    {
    }

    public static void addNotificationTracking(Activity activity, TrackingData trackingdata, Intent intent, String s)
    {
        if (intent.getIntExtra("noti_type_id", -1) != -1 && isTrackingEnabled(activity))
        {
            int i = intent.getIntExtra("notify_tap", 0);
            int j = intent.getIntExtra("collapsedNotificationCount", -1);
            if (j == -1)
            {
                intent = intent.getStringExtra("rid");
                trackingdata.addKeyValuePair("nid", intent);
                createAndSendNotificationActedOn(activity, Integer.valueOf(i), intent);
                if (DevLog.logNotifications.isLoggable)
                {
                    DevLog.logNotifications.log((new StringBuilder()).append("addNotificationTracking added to trackingData nid=").append(trackingdata.getValueForKey("nid")).append(";pnact=").append("1").toString());
                }
            } else
            {
                intent = (List)intent.getSerializableExtra("noti_rid_list");
                if (intent == null)
                {
                    intent = new String[0];
                } else
                {
                    intent = (String[])intent.toArray(new String[0]);
                }
                trackingdata.addKeyValuePair("nid", AnalyticsUtil.getCommaSeparatedStringFromCollection(Arrays.asList(intent)));
                createAndSendBundledNotificationActedOn(activity, s, j, Integer.valueOf(i), intent);
                if (DevLog.logNotifications.isLoggable)
                {
                    DevLog.logNotifications.log((new StringBuilder()).append("addNotificationTracking added to trackingData ntype=").append(s).append(";nc=").append(j).toString());
                    return;
                }
            }
        }
    }

    public static TrackingData createAllNotificationsToggledTrackingData(boolean flag)
    {
        TrackingData trackingdata = new TrackingData("SettingsNotificationsChanged", TrackingType.EVENT);
        String s;
        if (flag)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        trackingdata.addKeyValuePair("apn", s);
        return trackingdata;
    }

    private static transient void createAndSendBundledNotificationActedOn(Activity activity, String s, int i, Integer integer, String as[])
    {
        createNotificationBundleCreatedTrackingData(s, i, as).send(activity);
        createNotificationActionTrackingData("1", integer, as).send(activity);
    }

    private static void createAndSendNotificationActedOn(Activity activity, Integer integer, String s)
    {
        createNotificationActionTrackingData("1", integer, new String[] {
            s
        }).send(activity);
    }

    public static void createAndSendNotificationErrorEvent(Service service, ErrorType errortype, String s)
    {
        TrackingData trackingdata = new TrackingData("NotificationError", TrackingType.EVENT);
        trackingdata.addKeyValuePair("nid", s);
        if (errortype != null)
        {
            trackingdata.addKeyValuePair("mfls", errortype.name);
        }
        sendEvent(service, trackingdata);
    }

    private static transient TrackingData createNotificationActionTrackingData(String s, Integer integer, String as[])
    {
        TrackingData trackingdata = new TrackingData("NotificationAction", TrackingType.EVENT);
        if (as.length != 1) goto _L2; else goto _L1
_L1:
        trackingdata.addKeyValuePair("nid", as[0]);
_L4:
        trackingdata.addKeyValuePair("pnact", s);
        if (integer != null)
        {
            trackingdata.addKeyValuePair("notifyTap", integer.toString());
        }
        return trackingdata;
_L2:
        if (as.length > 1)
        {
            trackingdata.addKeyValuePair("nid", AnalyticsUtil.getCommaSeparatedStringFromCollection(Arrays.asList(as)));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static transient TrackingData createNotificationBundleCreatedTrackingData(String s, int i, String as[])
    {
        TrackingData trackingdata = new TrackingData("BundledNotificationsReceived", TrackingType.EVENT);
        trackingdata.addKeyValuePair("ntype", s);
        trackingdata.addKeyValuePair("nc", String.valueOf(i));
        if (as.length > 0)
        {
            trackingdata.addKeyValuePair("nid", AnalyticsUtil.getCommaSeparatedStringFromCollection(Arrays.asList(as)));
        }
        return trackingdata;
    }

    public static transient TrackingData createNotificationClearedTrackingData(String as[])
    {
        return createNotificationActionTrackingData("0", null, as);
    }

    public static TrackingData createNotificationModeChangeTrackingData(String s)
    {
        TrackingData trackingdata = new TrackingData("NotificationModeChange", TrackingType.EVENT);
        trackingdata.addKeyValuePair("nmode", s);
        return trackingdata;
    }

    public static TrackingData createNotificationReceivedTrackingData(String s)
    {
        TrackingData trackingdata = new TrackingData("NotificationReceived", TrackingType.EVENT);
        trackingdata.addKeyValuePair("nid", s);
        return trackingdata;
    }

    public static TrackingData createNotificationsToggledTrackingData(List list, List list1, String s)
    {
        TrackingData trackingdata = new TrackingData("SettingsNotificationsChanged", TrackingType.EVENT);
        trackingdata.addKeyValuePair("apn", s);
        if (list != null && !list.isEmpty())
        {
            s = new StringBuffer();
            String s1;
            for (list = list.iterator(); list.hasNext(); s.append(s1))
            {
                s1 = (String)list.next();
                if (s.length() > 0)
                {
                    s.append(",");
                }
            }

            trackingdata.addKeyValuePair("entype", s.toString());
        }
        if (list1 != null && !list1.isEmpty())
        {
            list = new StringBuffer();
            for (list1 = list1.iterator(); list1.hasNext(); list.append(s))
            {
                s = (String)list1.next();
                if (list.length() > 0)
                {
                    list.append(",");
                }
            }

            trackingdata.addKeyValuePair("dntype", list.toString());
        }
        return trackingdata;
    }

    public static boolean isTrackingEnabled(Context context)
    {
        return isTrackingEnabled(EbaySmartNotificationManager.getCurrentConfiguration(context));
    }

    public static boolean isTrackingEnabled(EbaySmartNotificationManager.NotificationType notificationtype)
    {
        return DeviceConfiguration.getAsync().get(DcsBoolean.NotificationTracking) && notificationtype == EbaySmartNotificationManager.NotificationType.GCM;
    }

    public static void sendEvent(Activity activity, TrackingData trackingdata)
    {
        if (DeviceConfiguration.getAsync().get(DcsBoolean.NotificationTracking))
        {
            trackingdata.send(activity);
            TrackingData.logContents(DevLog.logNotifications, trackingdata);
        }
    }

    public static void sendEvent(Service service, TrackingData trackingdata)
    {
        if (DeviceConfiguration.getAsync().get(DcsBoolean.NotificationTracking))
        {
            trackingdata.send(service);
            TrackingData.logContents(DevLog.logNotifications, trackingdata);
        }
    }
}
