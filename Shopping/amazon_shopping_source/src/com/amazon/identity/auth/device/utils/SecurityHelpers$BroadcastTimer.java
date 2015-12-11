// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.amazon.identity.platform.metric.MetricsHelper;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            SecurityHelpers

private static class mTimer extends BroadcastReceiver
{

    final PlatformMetricsTimer mTimer;

    public void onReceive(Context context, Intent intent)
    {
        mTimer.stop();
    }

    (Intent intent)
    {
        mTimer = MetricsHelper.startTimer("BroadcastDelay", intent.getAction());
    }
}
