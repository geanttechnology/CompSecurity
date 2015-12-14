// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.client.metrics:
//            MetricEvent, MetricEventType

public class NullMetricEvent
    implements MetricEvent
{

    private final MetricEventType mMetricEventType;
    private final String mProgram;
    private final String mSource;

    public NullMetricEvent(String s, String s1)
    {
        this(s, s1, MetricEventType.getDefault());
    }

    public NullMetricEvent(String s, String s1, MetricEventType metriceventtype)
    {
        mProgram = s;
        mSource = s1;
        mMetricEventType = metriceventtype;
    }

    public void addCounter(String s, double d)
    {
    }

    public void addString(String s, String s1)
    {
    }

    public void addTimer(String s, double d)
    {
    }

    public void clear()
    {
    }

    public List getAsDataPoints()
    {
        return new ArrayList(0);
    }

    public String getProgram()
    {
        return mProgram;
    }

    public String getSource()
    {
        return mSource;
    }

    public boolean hasDataPoints()
    {
        return false;
    }

    public void incrementCounter(String s, double d)
    {
    }

    public void startTimer(String s)
    {
    }

    public void stopTimer(String s)
    {
    }
}
