// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;

public class SDKNotification
{

    private Context mContext;
    private Notification mNotification;

    private SDKNotification(Context context, Notification notification)
    {
        mContext = context.getApplicationContext();
        mNotification = notification;
    }

    SDKNotification(Context context, Notification notification, SDKNotification sdknotification)
    {
        this(context, notification);
    }

    public void show(int i)
    {
        if (mNotification != null)
        {
            ((NotificationManager)mContext.getSystemService("notification")).notify(i, mNotification);
        }
    }
}
