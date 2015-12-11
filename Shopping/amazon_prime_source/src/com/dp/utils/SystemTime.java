// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dp.utils;


public final class SystemTime
{
    public static interface TimeSource
    {

        public abstract long now();
    }


    public static final TimeSource REAL_TIME;
    private static TimeSource sTimeSource;

    public SystemTime()
    {
    }

    public static long now()
    {
        return sTimeSource.now();
    }

    static 
    {
        REAL_TIME = new TimeSource() {

            public long now()
            {
                return System.currentTimeMillis();
            }

        };
        sTimeSource = REAL_TIME;
    }
}
