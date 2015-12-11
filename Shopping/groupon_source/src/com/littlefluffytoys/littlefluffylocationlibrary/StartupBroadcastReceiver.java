// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.littlefluffytoys.littlefluffylocationlibrary;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

// Referenced classes of package com.littlefluffytoys.littlefluffylocationlibrary:
//            LocationLibrary

public class StartupBroadcastReceiver extends BroadcastReceiver
{

    public StartupBroadcastReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        if (LocationLibrary.showDebugOutput)
        {
            Log.d("LittleFluffyLocationLibrary", "StartupBroadcastReceiver: onReceive: phone rebooted -> start alarm and listener");
        }
        LocationLibrary.startAlarmAndListener(context);
    }
}
