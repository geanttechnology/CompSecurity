// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.notifications;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import com.poshmark.application.PMApplication;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

// Referenced classes of package com.poshmark.notifications:
//            PMPartyAlarmBroadcastReciever, PMFiredNotifications, PMNotificationListener

public class PMNotificationManager
{
    public class PMBroadcastReciever extends BroadcastReceiver
    {

        PMNotificationListener listener;
        final PMNotificationManager this$0;

        public void onReceive(Context context, Intent intent)
        {
            if (listener != null)
            {
                listener.handleNotification(intent);
            }
        }

        public PMBroadcastReciever()
        {
            this$0 = PMNotificationManager.this;
            super();
            listener = null;
        }

        public PMBroadcastReciever(PMNotificationListener pmnotificationlistener)
        {
            this$0 = PMNotificationManager.this;
            super();
            listener = null;
            listener = pmnotificationlistener;
        }
    }


    static Map listeners = new HashMap();
    static PMNotificationManager notificationManager = null;
    PMPartyAlarmBroadcastReciever alarmBroadcastReceiver;

    public PMNotificationManager()
    {
        alarmBroadcastReceiver = new PMPartyAlarmBroadcastReciever();
        PMApplication.getContext().registerReceiver(alarmBroadcastReceiver, new IntentFilter("com.poshmark.intents.PARTY_ALARM"));
    }

    public static void cancelDelayedNotification(int i)
    {
        Object obj = new Intent(PMApplication.getContext(), com/poshmark/notifications/PMPartyAlarmBroadcastReciever);
        ((Intent) (obj)).setAction("com.poshmark.intents.PARTY_ALARM");
        obj = PendingIntent.getBroadcast(PMApplication.getContext(), i, ((Intent) (obj)), 0x10000000);
        ((AlarmManager)PMApplication.getContext().getSystemService("alarm")).cancel(((PendingIntent) (obj)));
    }

    public static void fireDelayedNotification(String s, Bundle bundle, long l)
    {
        Intent intent = new Intent(PMApplication.getContext(), com/poshmark/notifications/PMPartyAlarmBroadcastReciever);
        intent.putExtra("FRAGMENT_DATA", bundle);
        intent.setAction(s);
        int i = (new Random()).nextInt();
        s = PendingIntent.getBroadcast(PMApplication.getContext(), i, intent, 0x10000000);
        ((AlarmManager)PMApplication.getContext().getSystemService("alarm")).set(0, l, s);
        PMFiredNotifications.saveFiredNotification(i);
    }

    public static void fireNotification(String s)
    {
        s = new Intent(s);
        LocalBroadcastManager.getInstance(PMApplication.getContext()).sendBroadcast(s);
    }

    public static void fireNotification(String s, Bundle bundle)
    {
        s = new Intent(s);
        s.putExtra("RESULT", bundle);
        LocalBroadcastManager.getInstance(PMApplication.getContext()).sendBroadcast(s);
    }

    public static PMNotificationManager getNotificationManager()
    {
        if (notificationManager == null)
        {
            notificationManager = new PMNotificationManager();
        }
        return notificationManager;
    }

    public void registerForEvent(String s, PMNotificationListener pmnotificationlistener)
    {
        if (!listeners.containsKey(pmnotificationlistener))
        {
            HashMap hashmap = new HashMap();
            PMBroadcastReciever pmbroadcastreciever = new PMBroadcastReciever(pmnotificationlistener);
            hashmap.put(s, pmbroadcastreciever);
            LocalBroadcastManager.getInstance(PMApplication.getContext()).registerReceiver(pmbroadcastreciever, new IntentFilter(s));
            listeners.put(pmnotificationlistener, hashmap);
        } else
        {
            Map map = (Map)listeners.get(pmnotificationlistener);
            if (!map.containsKey(s))
            {
                pmnotificationlistener = new PMBroadcastReciever(pmnotificationlistener);
                LocalBroadcastManager.getInstance(PMApplication.getContext()).registerReceiver(pmnotificationlistener, new IntentFilter(s));
                map.put(s, pmnotificationlistener);
                return;
            }
        }
    }

    public void unRegisterForEvent(String s, PMNotificationListener pmnotificationlistener)
    {
        if (listeners.containsKey(pmnotificationlistener))
        {
            pmnotificationlistener = (Map)listeners.get(pmnotificationlistener);
            PMBroadcastReciever pmbroadcastreciever = (PMBroadcastReciever)pmnotificationlistener.get(s);
            if (pmbroadcastreciever != null)
            {
                LocalBroadcastManager.getInstance(PMApplication.getContext()).unregisterReceiver(pmbroadcastreciever);
                pmnotificationlistener.remove(s);
            }
        }
    }

    public void unregisterAllEvents(PMNotificationListener pmnotificationlistener)
    {
        if (listeners.containsKey(pmnotificationlistener))
        {
            for (Iterator iterator = ((Map)listeners.get(pmnotificationlistener)).values().iterator(); iterator.hasNext(); iterator.remove())
            {
                PMBroadcastReciever pmbroadcastreciever = (PMBroadcastReciever)iterator.next();
                LocalBroadcastManager.getInstance(PMApplication.getContext()).unregisterReceiver(pmbroadcastreciever);
            }

            listeners.remove(pmnotificationlistener);
        }
    }

}
