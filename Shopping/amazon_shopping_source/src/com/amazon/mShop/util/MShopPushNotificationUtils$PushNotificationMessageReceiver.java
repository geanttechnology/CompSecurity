// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

// Referenced classes of package com.amazon.mShop.util:
//            MShopPushNotificationUtils

public static class  extends BroadcastReceiver
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


    public ()
    {
    }
}
