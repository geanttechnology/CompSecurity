// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.metric;


public final class MetricUnit extends Enum
{

    private static final MetricUnit $VALUES[];
    public static final MetricUnit BYTES;
    public static final MetricUnit BYTES_PER_SECOND;
    public static final MetricUnit OPERATIONS;
    public static final MetricUnit PERCENT;
    public static final MetricUnit SECONDS;
    private String label;

    private MetricUnit(String s, int i, String s1)
    {
        super(s, i);
        label = s1;
    }

    public static MetricUnit valueOf(String s)
    {
        return (MetricUnit)Enum.valueOf(com/newrelic/agent/android/metric/MetricUnit, s);
    }

    public static MetricUnit[] values()
    {
        return (MetricUnit[])$VALUES.clone();
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String s)
    {
        label = s;
    }

    static 
    {
        PERCENT = new MetricUnit("PERCENT", 0, "%");
        BYTES = new MetricUnit("BYTES", 1, "bytes");
        SECONDS = new MetricUnit("SECONDS", 2, "sec");
        BYTES_PER_SECOND = new MetricUnit("BYTES_PER_SECOND", 3, "bytes/second");
        OPERATIONS = new MetricUnit("OPERATIONS", 4, "op");
        $VALUES = (new MetricUnit[] {
            PERCENT, BYTES, SECONDS, BYTES_PER_SECOND, OPERATIONS
        });
    }
}
