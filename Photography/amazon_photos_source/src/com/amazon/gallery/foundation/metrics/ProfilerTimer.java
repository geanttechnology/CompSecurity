// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.metrics;

import android.os.SystemClock;
import com.amazon.gallery.foundation.utils.log.GLogger;

// Referenced classes of package com.amazon.gallery.foundation.metrics:
//            ProfilerEvent, Timer, Profiler

public class ProfilerTimer extends ProfilerEvent
    implements Timer
{

    private static final String TAG = com/amazon/gallery/foundation/metrics/ProfilerTimer.getName();
    private long startTimeMs;

    public ProfilerTimer(Profiler profiler, String s, String s1)
    {
        super(profiler, s, s1);
        startTimeMs = -1L;
        start();
    }

    public void remove()
    {
    }

    public void start()
    {
        startTimeMs = SystemClock.uptimeMillis();
    }

    public void stop()
    {
        stop(true);
    }

    public void stop(boolean flag)
    {
        long l = SystemClock.uptimeMillis() - startTimeMs;
        profiler.trackTimer(component, eventName, l, extra, flag);
        GLogger.d(TAG, "%s#%s: %d ms", new Object[] {
            component, eventName, Long.valueOf(l)
        });
    }

}
