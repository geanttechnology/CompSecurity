// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;


public final class MetricEventType extends Enum
{

    private static final MetricEventType $VALUES[];
    public static final MetricEventType AGGREGATING;
    public static final MetricEventType AVERAGING;

    private MetricEventType(String s, int i)
    {
        super(s, i);
    }

    public static MetricEventType getDefault()
    {
        return AGGREGATING;
    }

    public static MetricEventType valueOf(String s)
    {
        return (MetricEventType)Enum.valueOf(com/amazon/client/metrics/MetricEventType, s);
    }

    public static MetricEventType[] values()
    {
        return (MetricEventType[])$VALUES.clone();
    }

    static 
    {
        AGGREGATING = new MetricEventType("AGGREGATING", 0);
        AVERAGING = new MetricEventType("AVERAGING", 1);
        $VALUES = (new MetricEventType[] {
            AGGREGATING, AVERAGING
        });
    }
}
