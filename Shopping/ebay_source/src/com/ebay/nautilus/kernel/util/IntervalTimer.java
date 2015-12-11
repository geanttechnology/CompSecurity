// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import android.os.SystemClock;
import android.util.Log;

public class IntervalTimer
{

    public static final long MAX_TTL = 0x3fffffffffffffffL;
    private static final String tag = "interval";
    public long duration;
    private final int logLevel;
    private final String msg;
    public long startTime;

    public IntervalTimer()
    {
        this(null, 2);
    }

    public IntervalTimer(String s)
    {
        this(s, 2);
    }

    public IntervalTimer(String s, int i)
    {
        String s1 = s;
        if (s != null)
        {
            s1 = (new StringBuilder()).append(s).append(" took %.3f seconds.").toString();
        }
        msg = s1;
        logLevel = i;
        start();
    }

    public static long msTime()
    {
        return SystemClock.uptimeMillis();
    }

    public void start()
    {
        startTime = msTime();
    }

    public long stop()
    {
        return stop(false);
    }

    public long stop(boolean flag)
    {
        long l = msTime() - startTime;
        if (flag && msg != null)
        {
            String s = String.format(msg, new Object[] {
                Double.valueOf((double)l / 1000D)
            });
            Log.println(logLevel, "interval", s);
        }
        duration = l;
        return l;
    }

    public long stop_print()
    {
        return stop(true);
    }
}
