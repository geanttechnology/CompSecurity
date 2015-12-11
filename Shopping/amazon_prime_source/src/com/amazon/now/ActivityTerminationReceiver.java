// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class ActivityTerminationReceiver extends BroadcastReceiver
{

    public static final String ACTIVITY_TERMINATION_RECEIVER_INTENT = "com.amazon.now.ActivityTerminationReceiverIntent";
    public static final IntentFilter INTENT_FILTER = new IntentFilter("com.amazon.now.ActivityTerminationReceiverIntent");

    public ActivityTerminationReceiver()
    {
    }

    public static void sendTerminationBroadcast(Context context)
    {
        Intent intent = new Intent();
        intent.setAction("com.amazon.now.ActivityTerminationReceiverIntent");
        context.sendBroadcast(intent);
    }

    public void onReceive(Context context, Intent intent)
    {
        if ("com.amazon.now.ActivityTerminationReceiverIntent".equals(intent.getAction()) && (context instanceof Activity))
        {
            ((Activity)context).finish();
        }
    }

}
