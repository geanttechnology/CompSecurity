// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import android.app.NotificationManager;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.app.BaseIntentService;
import java.util.List;

// Referenced classes of package com.ebay.mobile.notifications:
//            ItemCache, NotificationTrackingUtil, EbaySmartNotificationManager, DevLog

public class EventService extends BaseIntentService
{

    public static final String ACTION_CLEAR_EVENTS = "clearNotificationCache";
    private static final String NAME = "EventService";
    private final ItemCache cache = new ItemCache(this);

    public EventService()
    {
        super("EventService");
    }

    private transient void sendTracking(String as[])
    {
        NotificationTrackingUtil.sendEvent(this, NotificationTrackingUtil.createNotificationClearedTrackingData(as));
    }

    protected void onHandleIntent(Intent intent)
    {
        String s = intent.getAction();
        if (s == null)
        {
            Log.w("EventService", "No Action set on intent, ingoring it");
        } else
        {
            NotificationManager notificationmanager = (NotificationManager)getSystemService("notification");
            boolean flag;
            if (NotificationTrackingUtil.isTrackingEnabled(EbaySmartNotificationManager.getCurrentConfiguration(this)) && intent.getBooleanExtra("track_clear", true))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (s.equals("clearNotificationCache"))
            {
                String s1 = intent.getStringExtra("event_type");
                String s2 = intent.getStringExtra("item_id");
                int i = intent.getIntExtra("collapsedNotificationCount", 1);
                int j = intent.getIntExtra("noti_sys_id", -1);
                String s3;
                boolean flag1;
                if (i > 1)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                s3 = intent.getStringExtra("rid");
                if (TextUtils.isEmpty(s2) && !TextUtils.isEmpty(s1))
                {
                    if (DevLog.logNotifications.isLoggable)
                    {
                        FwLog.println(DevLog.logNotifications, (new StringBuilder()).append("Marking events viewed of type=").append(s1).toString());
                    }
                    cache.markEventsViewedForEventType(s1);
                    notificationmanager.cancel(j);
                } else
                if (!TextUtils.isEmpty(s2) && !TextUtils.isEmpty(s1))
                {
                    if (DevLog.logNotifications.isLoggable)
                    {
                        FwLog.println(DevLog.logNotifications, (new StringBuilder()).append("Marking events viewed for item=").append(s2).toString());
                    }
                    cache.markEventsViewedForItem(s1, s2);
                    notificationmanager.cancel(j);
                } else
                {
                    if (DevLog.logNotifications.isLoggable)
                    {
                        FwLog.println(DevLog.logNotifications, "Marking all events viewed");
                    }
                    cache.markAllEventsViewed();
                    notificationmanager.cancelAll();
                }
                if (flag)
                {
                    if (flag1)
                    {
                        intent = (List)intent.getSerializableExtra("noti_rid_list");
                        if (intent == null)
                        {
                            intent = new String[0];
                        } else
                        {
                            intent = (String[])intent.toArray(new String[0]);
                        }
                        sendTracking(intent);
                        return;
                    } else
                    {
                        sendTracking(new String[] {
                            s3
                        });
                        return;
                    }
                }
            } else
            {
                FwLog.println(DevLog.logNotifications, (new StringBuilder()).append("Unknown action:").append(intent.getAction()).append(". Ignoring").toString());
                return;
            }
        }
    }
}
