// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.util;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;

public abstract class LocalNotificationManagerBase extends BroadcastReceiver
{

    public static final String ACTION_LOCAL_NOTIFICATION = "com.notifications.ACTION_LOCAL_NOTIFICATION";

    public LocalNotificationManagerBase()
    {
    }

    private android.support.v4.app.NotificationCompat.Builder createNotificationInternal(Context context, int i, int j, String s, Intent intent)
    {
        NotificationManager notificationmanager = (NotificationManager)context.getSystemService("notification");
        android.support.v4.app.NotificationCompat.Builder builder = (new android.support.v4.app.NotificationCompat.Builder(context)).setSmallIcon(getIconResourceId()).setAutoCancel(true);
        notificationmanager.cancel(i);
        builder.setContentTitle(s);
        if (j >= 2)
        {
            builder.setNumber(j);
        }
        builder.setContentIntent(PendingIntent.getActivity(context, 0, intent, 0x8000000));
        return builder;
    }

    protected void cancelAlarm(Context context, int i)
    {
        AlarmManager alarmmanager = (AlarmManager)context.getSystemService("alarm");
        context = PendingIntent.getBroadcast(context, i, new Intent(), 0x20000000);
        if (context != null)
        {
            alarmmanager.cancel(context);
            context.cancel();
        }
    }

    protected void createNotification(Context context, int i, int j, String s, Intent intent)
    {
        ((NotificationManager)context.getSystemService("notification")).notify(i, createNotificationInternal(context, i, j, s, intent).build());
    }

    protected void createStackedInboxNotification(Context context, int i, int j, String s, List list, Intent intent)
    {
        NotificationManager notificationmanager = (NotificationManager)context.getSystemService("notification");
        context = createNotificationInternal(context, i, j, s, intent);
        intent = new android.support.v4.app.NotificationCompat.InboxStyle();
        intent.setBigContentTitle(s);
        for (s = list.iterator(); s.hasNext(); intent.addLine((String)s.next())) { }
        context.setStyle(intent);
        notificationmanager.notify(i, context.build());
    }

    protected abstract Class getAlarmReceiverClass();

    protected abstract int getIconResourceId();

    protected int scheduleAlarm(Context context, long l, int i, int j, String s, Bundle bundle)
    {
        AlarmManager alarmmanager = (AlarmManager)context.getSystemService("alarm");
        int k = (int)System.currentTimeMillis();
        Bundle bundle1 = bundle;
        if (bundle == null)
        {
            bundle1 = new Bundle();
        }
        bundle1.putString("message", s);
        bundle1.putInt("alarmTypeId", i);
        bundle1.putInt("id", k);
        bundle1.putInt("count", j);
        s = new Intent(context, getAlarmReceiverClass());
        s.putExtras(bundle1);
        s.setAction("com.notifications.ACTION_LOCAL_NOTIFICATION");
        alarmmanager.set(0, l, PendingIntent.getBroadcast(context, k, s, 0x8000000));
        return k;
    }
}
