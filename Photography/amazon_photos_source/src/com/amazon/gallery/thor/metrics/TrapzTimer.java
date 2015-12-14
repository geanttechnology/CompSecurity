// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.metrics;

import android.os.SystemClock;
import com.amazon.gallery.foundation.metrics.Timer;
import com.amazon.gallery.foundation.utils.log.GLogger;
import java.util.concurrent.atomic.AtomicLong;

public class TrapzTimer
    implements Timer
{

    private static final String TAG = com/amazon/gallery/thor/metrics/TrapzTimer.getName();
    private static final AtomicLong TIMER_ID_GENERATOR = new AtomicLong(0L);
    private final String event;
    private final long id;

    public TrapzTimer(String s)
    {
        event = s;
        id = TIMER_ID_GENERATOR.getAndIncrement();
    }

    private void log(String s)
    {
        GLogger.i(TAG, "[Photos %s%s [%d], t: %d]", new Object[] {
            event, s, Long.valueOf(id), Long.valueOf(SystemClock.elapsedRealtime())
        });
    }

    public void addExtra(String s, String s1)
    {
    }

    public void remove()
    {
    }

    public void start()
    {
        log("-start");
    }

    public void stop()
    {
        log("-end");
    }

    public void stop(boolean flag)
    {
        log("-end");
        if (flag)
        {
            log("-failed");
        }
    }

}
