// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.receiver;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.groupon.service.PullNotificationService;

public class PullNotificationReceiver extends WakefulBroadcastReceiver
{

    private static int APP_CREATE_REQUEST_CODE = 0;

    public PullNotificationReceiver()
    {
    }

    public static PendingIntent getIntentForAppCreate(Context context)
    {
        Intent intent = new Intent(context, com/groupon/receiver/PullNotificationReceiver);
        return PendingIntent.getBroadcast(context, APP_CREATE_REQUEST_CODE, intent, 0x8000000);
    }

    public static boolean isAlarmSet(Context context)
    {
        Intent intent = new Intent(context, com/groupon/receiver/PullNotificationReceiver);
        return PendingIntent.getBroadcast(context, APP_CREATE_REQUEST_CODE, intent, 0x20000000) != null;
    }

    public void onReceive(Context context, Intent intent)
    {
        startWakefulService(context, (new Intent(context, com/groupon/service/PullNotificationService)).putExtras(intent));
    }

}
