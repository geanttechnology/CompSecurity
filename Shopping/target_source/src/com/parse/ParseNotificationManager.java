// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;

class ParseNotificationManager
{
    public static class Singleton
    {

        private static final ParseNotificationManager INSTANCE = new ParseNotificationManager();



        public Singleton()
        {
        }
    }


    public static final String TAG = "com.parse.ParseNotificationManager";
    private final AtomicInteger notificationCount = new AtomicInteger(0);
    private volatile boolean shouldShowNotifications;

    ParseNotificationManager()
    {
        shouldShowNotifications = true;
    }

    public static ParseNotificationManager getInstance()
    {
        return Singleton.INSTANCE;
    }

    public int getNotificationCount()
    {
        return notificationCount.get();
    }

    public void setShouldShowNotifications(boolean flag)
    {
        shouldShowNotifications = flag;
    }

    public void showNotification(Context context, Notification notification)
    {
        int i;
        if (context == null || notification == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        notificationCount.incrementAndGet();
        if (!shouldShowNotifications)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        context = (NotificationManager)context.getSystemService("notification");
        i = (int)System.currentTimeMillis();
        context.notify(i, notification);
        return;
        SecurityException securityexception;
        securityexception;
        notification.defaults = 5;
        context.notify(i, notification);
        return;
    }
}
