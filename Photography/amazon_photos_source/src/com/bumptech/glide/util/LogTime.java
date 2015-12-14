// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.util;

import android.os.SystemClock;

public final class LogTime
{

    private static final double MILLIS_MULTIPLIER;

    public static double getElapsedMillis(long l)
    {
        return (double)(getLogTime() - l) * MILLIS_MULTIPLIER;
    }

    public static long getLogTime()
    {
        if (17 <= android.os.Build.VERSION.SDK_INT)
        {
            return SystemClock.elapsedRealtimeNanos();
        } else
        {
            return System.currentTimeMillis();
        }
    }

    static 
    {
        double d = 1.0D;
        if (17 <= android.os.Build.VERSION.SDK_INT)
        {
            d = 1.0D / Math.pow(10D, 6D);
        }
        MILLIS_MULTIPLIER = d;
    }
}
