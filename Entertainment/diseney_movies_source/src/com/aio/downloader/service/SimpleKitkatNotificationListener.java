// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.service;

import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

public class SimpleKitkatNotificationListener extends NotificationListenerService
{

    public SimpleKitkatNotificationListener()
    {
    }

    public void onNotificationPosted(StatusBarNotification statusbarnotification)
    {
        Log.e("noti", (new StringBuilder("NotificationPosted=")).append(statusbarnotification.getPackageName()).toString());
    }

    public void onNotificationRemoved(StatusBarNotification statusbarnotification)
    {
        Log.e("noti", (new StringBuilder("NotificationRemoved=")).append(statusbarnotification.getPackageName()).toString());
    }
}
