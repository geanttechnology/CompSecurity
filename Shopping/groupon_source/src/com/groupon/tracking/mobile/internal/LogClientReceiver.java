// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.tracking.mobile.internal:
//            LogClient

public class LogClientReceiver extends BroadcastReceiver
{

    public LogClientReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        Ln.d("NST LogClientReceiver %s", new Object[] {
            intent
        });
        ((LogClient)RoboGuice.getInjector(context).getInstance(com/groupon/tracking/mobile/internal/LogClient)).closeLogAndQueueForUpload();
        ((PowerManager)context.getSystemService("power")).newWakeLock(1, com/groupon/tracking/mobile/internal/LogClientReceiver.getSimpleName()).acquire(10000L);
    }
}
