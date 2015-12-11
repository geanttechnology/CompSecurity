// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.pushnotification.PushNotificationManager;
import com.amazon.rio.j2me.client.persistence.DataStore;

public final class MShopPushNotificationUtils
{
    public static class PushNotificationMessageReceiver extends BroadcastReceiver
    {

        public static final IntentFilter INTENT_FILTER = new IntentFilter("com.amazon.mShop.android.PUSH_NOTIFICATION_RESPONSE");

        public static void sendPushNotificationRegisteredMessageBroadcast(Context context, String s)
        {
            Intent intent = new Intent("com.amazon.mShop.android.PUSH_NOTIFICATION_RESPONSE");
            intent.putExtra("registration", s);
            context.sendBroadcast(intent);
        }

        public void onReceive(Context context, Intent intent)
        {
        }


        public PushNotificationMessageReceiver()
        {
        }
    }


    private static String sLastMarketPlace = null;

    public MShopPushNotificationUtils()
    {
    }

    public static String getLastMarketPlace()
    {
        return sLastMarketPlace;
    }

    public static boolean isMarketplaceSupportsNotification()
    {
        return com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getBoolean("isSupportNotifications", false);
    }

    public static boolean isPushNotificationAvailable()
    {
        return PushNotificationManager.getInstance() != null;
    }

    public static void setLastMarketPlace(String s)
    {
        sLastMarketPlace = s;
    }

}
