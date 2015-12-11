// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.pushnotification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.amazon.mShop.util.MShopSystemNotificationManagerUtil;
import com.amazon.mShop.util.Util;

public class MShopClearNotificationReceiver extends BroadcastReceiver
{

    public MShopClearNotificationReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getStringExtra("NotificationType");
        if (!Util.isEmpty(context))
        {
            MShopSystemNotificationManagerUtil.removeStackedNotifications(context);
        }
    }
}
