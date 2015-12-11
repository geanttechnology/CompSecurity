// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.ebay.mobile.notifications.EbaySmartNotificationManager;
import com.ebay.mobile.notifications.EventService;
import com.ebay.mobile.notifications.PollService;

public class ServiceStarter
{

    private ServiceStarter()
    {
    }

    public static void instructNotificationManagerService(Context context, int i)
    {
        instructNotificationManagerService(context, i, null);
    }

    public static void instructNotificationManagerService(Context context, int i, Bundle bundle)
    {
        Intent intent = new Intent(context, com/ebay/mobile/notifications/EbaySmartNotificationManager);
        intent.putExtra("push_action", i);
        intent.putExtra("not_mgr_bundle", bundle);
        context.startService(intent);
    }

    public static void startNotificationManagerService(Context context)
    {
        startNotificationManagerService(context, false);
    }

    public static void startNotificationManagerService(Context context, boolean flag)
    {
        Intent intent = new Intent(context, com/ebay/mobile/notifications/EbaySmartNotificationManager);
        intent.putExtra("push_action", 1);
        intent.putExtra("not_release_wakelock", flag);
        context.startService(intent);
    }

    public static void startPollService(Context context, String s)
    {
        Intent intent = new Intent(context, com/ebay/mobile/notifications/PollService);
        intent.setAction(s);
        context.startService(intent);
    }

    public static void startUpdateNotificationCacheService(Activity activity, String s, String s1)
    {
        Intent intent = new Intent(activity, com/ebay/mobile/notifications/EventService);
        intent.setAction("clearNotificationCache");
        if (!TextUtils.isEmpty(s))
        {
            intent.putExtra("event_type", s);
        }
        if (!TextUtils.isEmpty(s1))
        {
            intent.putExtra("item_id", s1);
        }
        intent.putExtra("track_clear", false);
        activity.startService(intent);
    }
}
