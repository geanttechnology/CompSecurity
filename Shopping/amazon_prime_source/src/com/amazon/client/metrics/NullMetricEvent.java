// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.client.metrics:
//            MetricEvent, MetricEventType, DataPoint

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

    public void addDataPoint(DataPoint datapoint)
    {
    }

    public void addDataPoints(List list)
    {
    }

    public void addString(String s, String s1)
    {
    }

    public void addTimer(String s, double d)
    {
    }

    public void addTimer(String s, double d, int i)
    {
    }

    public void appendString(String s, String s1)
    {
    }

    public void clear()
    {
    }

    public boolean getAnonymous()
    {
        return false;
    }

    public List getAsDataPoints()
    {
        return new ArrayList(0);
    }

    public MetricEventType getMetricEventType()
    {
        return mMetricEventType;
    }

    public String getNonAnonymousCustomerId()
    {
        return null;
    }

    public String getNonAnonymousSessionId()
    {
        return null;
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

    public void removeCounter(String s)
    {
    }

    public void removeString(String s)
    {
    }

    public void removeTimer(String s)
    {
    }

    public void restoreFromMap(Map map)
        throws IllegalArgumentException
    {
    }

    public void saveToMap(Map map)
    {
    }

    public void setAnonymous(boolean flag)
    {
    }

    public void setNonAnonymousCustomerId(String s)
    {
    }

    public void setNonAnonymousSessionId(String s)
    {
    }

    public void startTimer(String s)
    {
    }

    public void stopTimer(String s)
    {
    }
}
