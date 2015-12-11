// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.googlenow;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class a
{

    public static final int CONVERSION_FACTOR_MINUTE_TO_MS = 60000;
    public static final String CREATE_ALARM_BROADCAST_ACTION = "com.target.ui.googlenow.GOOGLE_NOW_CREATE_ALARM_INTENT";

    public static void a(Context context)
    {
        PendingIntent pendingintent = PendingIntent.getBroadcast(context, 0, new Intent("com.target.ui.googlenow.GOOGLE_NOW_CREATE_ALARM_INTENT"), 0);
        ((AlarmManager)context.getSystemService("alarm")).cancel(pendingintent);
    }

    public static void a(Context context, int i)
    {
        long l = System.currentTimeMillis();
        long l1 = 60000 * i;
        PendingIntent pendingintent = PendingIntent.getBroadcast(context, 0, new Intent("com.target.ui.googlenow.GOOGLE_NOW_CREATE_ALARM_INTENT"), 0);
        ((AlarmManager)context.getSystemService("alarm")).set(0, l1 + l, pendingintent);
    }
}
