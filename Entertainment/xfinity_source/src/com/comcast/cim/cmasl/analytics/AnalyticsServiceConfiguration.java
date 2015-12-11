// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.analytics;


public class AnalyticsServiceConfiguration
{

    private final long delayAfterError;
    private final int maxTaskFailures;

    public AnalyticsServiceConfiguration(int i, long l)
    {
        maxTaskFailures = i;
        delayAfterError = l;
    }

    public static AnalyticsServiceConfiguration getDefaultAnalyticsServiceConfiguration()
    {
        return new AnalyticsServiceConfiguration(2, 0x1d4c0L);
    }

    public long getDelayAfterError()
    {
        return delayAfterError;
    }

    public int getMaxTaskFailures()
    {
        return maxTaskFailures;
    }
}
