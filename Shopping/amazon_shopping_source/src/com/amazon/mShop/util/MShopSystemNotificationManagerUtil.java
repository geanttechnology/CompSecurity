// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import java.util.HashMap;
import java.util.Map;

public class MShopSystemNotificationManagerUtil
{

    public static final String TAG = com/amazon/mShop/util/MShopSystemNotificationManagerUtil.getSimpleName();
    public static int sNotificationId = 0;
    private static Map sNotificationMap = new HashMap();

    public MShopSystemNotificationManagerUtil()
    {
    }

    public static int getNextUniqueNotificationId()
    {
        com/amazon/mShop/util/MShopSystemNotificationManagerUtil;
        JVM INSTR monitorenter ;
        int i;
        i = sNotificationId + 1;
        sNotificationId = i;
        com/amazon/mShop/util/MShopSystemNotificationManagerUtil;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public static Notification newNotification(Context context, String s, String s1, String s2, PendingIntent pendingintent, PendingIntent pendingintent1, android.support.v4.app.NotificationCompat.Style style, int i, 
            int j)
    {
        long l = System.currentTimeMillis();
        android.support.v4.app.NotificationCompat.Builder builder = new android.support.v4.app.NotificationCompat.Builder(context);
        if (s != null)
        {
            builder.setContentTitle(s);
        }
        if (s1 != null)
        {
            builder.setContentText(s1);
        }
        if (s2 != null)
        {
            builder.setTicker(s2);
        }
        if (pendingintent != null)
        {
            builder.setContentIntent(pendingintent);
        }
        if (pendingintent1 != null)
        {
            builder.setDeleteIntent(pendingintent1);
        }
        if (style != null)
        {
            builder.setStyle(style);
        }
        builder.setWhen(l);
        builder.setSmallIcon(i);
        if (j != 0)
        {
            builder.setLargeIcon(((BitmapDrawable)context.getResources().getDrawable(j)).getBitmap());
        }
        return builder.build();
    }

    public static void notifyToSystem(int i, Notification notification, Context context)
    {
        ((NotificationManager)context.getSystemService("notification")).notify(i, notification);
    }

    public static void notifyToSystem(Notification notification, Context context)
    {
        notifyToSystem(getNextUniqueNotificationId(), notification, context);
    }

    public static void removeStackedNotifications(String s)
    {
        com/amazon/mShop/util/MShopSystemNotificationManagerUtil;
        JVM INSTR monitorenter ;
        sNotificationMap.remove(s);
        com/amazon/mShop/util/MShopSystemNotificationManagerUtil;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

}
