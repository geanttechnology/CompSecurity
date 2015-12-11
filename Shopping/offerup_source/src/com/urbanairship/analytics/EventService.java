// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.analytics;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.Autopilot;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.push.PushManager;
import java.util.Map;

// Referenced classes of package com.urbanairship.analytics:
//            EventAPIClient, Analytics, EventDataManager, AnalyticsPreferences, 
//            EventResponse

public class EventService extends IntentService
{

    static final String ACTION_ADD = "com.urbanairship.analytics.ADD";
    static final String ACTION_DELETE_ALL = "com.urbanairship.analytics.DELETE_ALL";
    public static final String ACTION_SEND = "com.urbanairship.analytics.SEND";
    private static final long BATCH_DELAY = 10000L;
    static final String EXTRA_EVENT_DATA = "EXTRA_EVENT_DATA";
    static final String EXTRA_EVENT_ID = "EXTRA_EVENT_ID";
    static final String EXTRA_EVENT_SESSION_ID = "EXTRA_EVENT_SESSION_ID";
    static final String EXTRA_EVENT_TIME_STAMP = "EXTRA_EVENT_TIME_STAMP";
    static final String EXTRA_EVENT_TYPE = "EXTRA_EVENT_TYPE";
    private static final long REGION_BATCH_DELAY = 1000L;
    private static long backoffMs = 0L;
    private final EventAPIClient eventClient;

    public EventService()
    {
        this("EventService");
    }

    public EventService(String s)
    {
        this(s, new EventAPIClient());
    }

    EventService(String s, EventAPIClient eventapiclient)
    {
        super(s);
        eventClient = eventapiclient;
    }

    private void addEventFromIntent(Intent intent)
    {
        AnalyticsPreferences analyticspreferences = UAirship.shared().getAnalytics().getPreferences();
        EventDataManager eventdatamanager = UAirship.shared().getAnalytics().getDataManager();
        String s = intent.getStringExtra("EXTRA_EVENT_TYPE");
        String s1 = intent.getStringExtra("EXTRA_EVENT_ID");
        String s2 = intent.getStringExtra("EXTRA_EVENT_DATA");
        String s3 = intent.getStringExtra("EXTRA_EVENT_TIME_STAMP");
        intent = intent.getStringExtra("EXTRA_EVENT_SESSION_ID");
        if (s == null || s2 == null || s3 == null || s1 == null)
        {
            Logger.warn("Event service unable to add event with missing data.");
            return;
        }
        if (eventdatamanager.getDatabaseSize() > analyticspreferences.getMaxTotalDbSize())
        {
            Logger.info("Event database size exceeded. Deleting oldest session.");
            String s4 = eventdatamanager.getOldestSessionId();
            if (s4 != null && s4.length() > 0)
            {
                eventdatamanager.deleteSession(s4);
            }
        }
        if (eventdatamanager.insertEvent(s, s2, s1, intent, s3) <= 0L)
        {
            Logger.error("EventService - Unable to insert event into database.");
        }
        if ("location".equals(s) && !UAirship.shared().getAnalytics().isAppInForeground())
        {
            long l = System.currentTimeMillis();
            long l1 = analyticspreferences.getLastSendTime();
            l = UAirship.shared().getAirshipConfigOptions().backgroundReportingIntervalMS - (l - l1);
            if (l > getNextSendDelay() && l > 10000L)
            {
                Logger.info((new StringBuilder("LocationEvent was inserted, but may not be updated until ")).append(l).append(" ms have passed").toString());
                scheduleEventUpload(l);
                return;
            } else
            {
                scheduleEventUpload(Math.max(getNextSendDelay(), 10000L));
                return;
            }
        }
        if ("region_event".equals(s))
        {
            scheduleEventUpload(1000L);
            return;
        } else
        {
            scheduleEventUpload(Math.max(getNextSendDelay(), 10000L));
            return;
        }
    }

    private long getNextSendDelay()
    {
        AnalyticsPreferences analyticspreferences = UAirship.shared().getAnalytics().getPreferences();
        long l = analyticspreferences.getLastSendTime();
        return Math.max(((long)analyticspreferences.getMinBatchInterval() + l + backoffMs) - System.currentTimeMillis(), 0L);
    }

    private void scheduleEventUpload(long l)
    {
        l = System.currentTimeMillis() + l;
        AnalyticsPreferences analyticspreferences = UAirship.shared().getAnalytics().getPreferences();
        AlarmManager alarmmanager = (AlarmManager)getApplicationContext().getSystemService("alarm");
        Intent intent = new Intent(getApplicationContext(), com/urbanairship/analytics/EventService);
        intent.setAction("com.urbanairship.analytics.SEND");
        long l1 = analyticspreferences.getScheduledSendTime();
        boolean flag;
        if (l1 < System.currentTimeMillis() || l1 > l)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag || PendingIntent.getService(getApplicationContext(), 0, intent, 0x20000000) == null)
        {
            alarmmanager.set(1, l, PendingIntent.getService(getApplicationContext(), 0, intent, 0x8000000));
            analyticspreferences.setScheduledSendTime(l);
            return;
        } else
        {
            Logger.verbose("EventService - Alarm already scheduled for an earlier time.");
            return;
        }
    }

    private void uploadEvents()
    {
        AnalyticsPreferences analyticspreferences = UAirship.shared().getAnalytics().getPreferences();
        EventDataManager eventdatamanager = UAirship.shared().getAnalytics().getDataManager();
        analyticspreferences.setLastSendTime(System.currentTimeMillis());
        int j = eventdatamanager.getEventCount();
        if (UAirship.shared().getPushManager().getChannelId() == null)
        {
            Logger.debug("EventService - No channel ID, skipping analytics send.");
        } else
        {
            if (j <= 0)
            {
                Logger.debug("EventService - No events to send. Ending analytics upload.");
                return;
            }
            int i = eventdatamanager.getDatabaseSize() / j;
            Map map = eventdatamanager.getEvents(analyticspreferences.getMaxBatchSize() / i);
            EventResponse eventresponse = eventClient.sendEvents(map.values());
            boolean flag;
            if (eventresponse != null && eventresponse.getStatus() == 200)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                Logger.info("Analytic events uploaded successfully.");
                eventdatamanager.deleteEvents(map.keySet());
                backoffMs = 0L;
            } else
            {
                if (backoffMs == 0L)
                {
                    backoffMs = analyticspreferences.getMinBatchInterval();
                } else
                {
                    backoffMs = Math.min(backoffMs << 1, analyticspreferences.getMaxWait());
                }
                Logger.debug((new StringBuilder("Analytic events failed to send. Will retry in ")).append(backoffMs).append("ms.").toString());
            }
            if (!flag || j - map.size() > 0)
            {
                Logger.debug("EventService - Scheduling next event batch upload.");
                scheduleEventUpload(getNextSendDelay());
            }
            if (eventresponse != null)
            {
                analyticspreferences.setMaxTotalDbSize(eventresponse.getMaxTotalSize());
                analyticspreferences.setMaxBatchSize(eventresponse.getMaxBatchSize());
                analyticspreferences.setMaxWait(eventresponse.getMaxWait());
                analyticspreferences.setMinBatchInterval(eventresponse.getMinBatchInterval());
                return;
            }
        }
    }

    public void onCreate()
    {
        super.onCreate();
        Autopilot.automaticTakeOff(getApplicationContext());
    }

    protected void onHandleIntent(Intent intent)
    {
        String s;
        byte byte0;
        if (intent == null || intent.getAction() == null)
        {
            return;
        }
        Logger.verbose((new StringBuilder("EventService - Received intent: ")).append(intent.getAction()).toString());
        s = intent.getAction();
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 80
    //                   -1528883156: 146
    //                   -150200003: 160
    //                   1857115874: 132;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_160;
_L5:
        switch (byte0)
        {
        default:
            Logger.warn((new StringBuilder("EventService - Unrecognized intent action: ")).append(intent.getAction()).toString());
            return;

        case 0: // '\0'
            Logger.info("Deleting all analytic events.");
            UAirship.shared().getAnalytics().getDataManager().deleteAllEvents();
            return;

        case 1: // '\001'
            addEventFromIntent(intent);
            return;

        case 2: // '\002'
            uploadEvents();
            break;
        }
        break MISSING_BLOCK_LABEL_203;
_L4:
        if (s.equals("com.urbanairship.analytics.DELETE_ALL"))
        {
            byte0 = 0;
        }
          goto _L5
_L2:
        if (s.equals("com.urbanairship.analytics.ADD"))
        {
            byte0 = 1;
        }
          goto _L5
        if (s.equals("com.urbanairship.analytics.SEND"))
        {
            byte0 = 2;
        }
          goto _L5
    }

}
