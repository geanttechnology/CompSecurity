// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.client.metrics:
//            MetricsException, DataPoint, MetricEventType

public interface MetricEvent
{

    public abstract void addCounter(String s, double d);

    public abstract void addDataPoint(DataPoint datapoint)
        throws MetricsException;

    public abstract void addDataPoints(List list)
        throws MetricsException;

    public abstract void addString(String s, String s1);

    public abstract void addTimer(String s, double d);

    public abstract void addTimer(String s, double d, int i);

    public abstract void appendString(String s, String s1);

    public abstract void clear();

    public abstract List getAsDataPoints();

    public abstract MetricEventType getMetricEventType();

    public abstract String getProgram();

    public abstract String getSource();

    public abstract boolean hasDataPoints();

    public abstract void incrementCounter(String s, double d);

    public abstract void removeCounter(String s);

    public abstract void removeString(String s);

    public abstract void removeTimer(String s);

    public abstract void restoreFromMap(Map map)
        throws IllegalArgumentException;

    public abstract void saveToMap(Map map);

    public abstract void startTimer(String s);

    public abstract void stopTimer(String s);
}
