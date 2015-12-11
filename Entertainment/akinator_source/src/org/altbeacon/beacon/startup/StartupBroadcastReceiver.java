// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.startup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.logging.LogManager;

public class StartupBroadcastReceiver extends BroadcastReceiver
{

    private static final String TAG = "StartupBroadcastReceiver";

    public StartupBroadcastReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        LogManager.d("StartupBroadcastReceiver", "onReceive called in startup broadcast receiver", new Object[0]);
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            LogManager.w("StartupBroadcastReceiver", "Not starting up beacon service because we do not have SDK version 18 (Android 4.3).  We have: %s", new Object[] {
                Integer.valueOf(android.os.Build.VERSION.SDK_INT)
            });
        } else
        if (BeaconManager.getInstanceForApplication(context.getApplicationContext()).isAnyConsumerBound())
        {
            if (intent.getBooleanExtra("wakeup", false))
            {
                LogManager.d("StartupBroadcastReceiver", "got wake up intent", new Object[0]);
                return;
            } else
            {
                LogManager.d("StartupBroadcastReceiver", "Already started.  Ignoring intent: %s of type: %s", new Object[] {
                    intent, intent.getStringExtra("wakeup")
                });
                return;
            }
        }
    }
}
