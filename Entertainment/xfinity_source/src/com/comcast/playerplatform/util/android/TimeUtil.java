// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.util.android;


public class TimeUtil
{

    public TimeUtil()
    {
    }

    public static long getClockMonoTonicMillis()
    {
        return System.nanoTime() / 0xf4240L;
    }

    public static long getUnixEpochTimeInMillis()
    {
        return System.currentTimeMillis();
    }
}
