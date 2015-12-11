// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.client.metrics:
//            MetricEvent, MetricEventType, BasicMetricEvent, MetricsException, 
//            DataPoint

public class ConcurrentMetricEvent
    implements MetricEvent
{

    private final MetricEvent mDelegate;

    protected ConcurrentMetricEvent(MetricEvent metricevent)
    {
        mDelegate = metricevent;
    }

    public ConcurrentMetricEvent(String s, String s1)
    {
        this(s, s1, MetricEventType.getDefault());
    }

    public ConcurrentMetricEvent(String s, String s1, MetricEventType metriceventtype)
    {
        this(s, s1, metriceventtype, false);
    }

    public ConcurrentMetricEvent(String s, String s1, MetricEventType metriceventtype, boolean flag)
    {
        mDelegate = new BasicMetricEvent(s, s1, metriceventtype, flag);
    }

    public void addCounter(String s, double d)
    {
        this;
        JVM INSTR monitorenter ;
        mDelegate.addCounter(s, d);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void addDataPoint(DataPoint datapoint)
        throws MetricsException
    {
        this;
        JVM INSTR monitorenter ;
        mDelegate.addDataPoint(datapoint);
        this;
        JVM INSTR monitorexit ;
        return;
        datapoint;
        throw datapoint;
    }

    public void addDataPoints(List list)
        throws MetricsException
    {
        this;
        JVM INSTR monitorenter ;
        mDelegate.addDataPoints(list);
        this;
        JVM INSTR monitorexit ;
        return;
        list;
        throw list;
    }

    public void addString(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        mDelegate.addString(s, s1);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void addTimer(String s, double d)
    {
        this;
        JVM INSTR monitorenter ;
        mDelegate.addTimer(s, d);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void addTimer(String s, double d, int i)
    {
        this;
        JVM INSTR monitorenter ;
        mDelegate.addTimer(s, d, i);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void appendString(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        mDelegate.appendString(s, s1);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void clear()
    {
        this;
        JVM INSTR monitorenter ;
        mDelegate.clear();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public List getAsDataPoints()
    {
        this;
        JVM INSTR monitorenter ;
        List list = mDelegate.getAsDataPoints();
        this;
        JVM INSTR monitorexit ;
        return list;
        Exception exception;
        exception;
        throw exception;
    }

    public List getAsDataPointsAndClear()
    {
        this;
        JVM INSTR monitorenter ;
        List list;
        list = mDelegate.getAsDataPoints();
        mDelegate.clear();
        this;
        JVM INSTR monitorexit ;
        return list;
        Exception exception;
        exception;
        throw exception;
    }

    public MetricEventType getMetricEventType()
    {
        return mDelegate.getMetricEventType();
    }

    public String getProgram()
    {
        return mDelegate.getProgram();
    }

    public String getSource()
    {
        return mDelegate.getSource();
    }

    public boolean hasDataPoints()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mDelegate.hasDataPoints();
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public void incrementCounter(String s, double d)
    {
        this;
        JVM INSTR monitorenter ;
        mDelegate.incrementCounter(s, d);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void removeCounter(String s)
    {
        this;
        JVM INSTR monitorenter ;
        mDelegate.removeCounter(s);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void removeString(String s)
    {
        this;
        JVM INSTR monitorenter ;
        mDelegate.removeString(s);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void removeTimer(String s)
    {
        this;
        JVM INSTR monitorenter ;
        mDelegate.removeTimer(s);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void restoreFromMap(Map map)
    {
        this;
        JVM INSTR monitorenter ;
        mDelegate.restoreFromMap(map);
        this;
        JVM INSTR monitorexit ;
        return;
        map;
        throw map;
    }

    public void saveToMap(Map map)
    {
        this;
        JVM INSTR monitorenter ;
        mDelegate.saveToMap(map);
        this;
        JVM INSTR monitorexit ;
        return;
        map;
        throw map;
    }

    public void startTimer(String s)
    {
        this;
        JVM INSTR monitorenter ;
        mDelegate.startTimer(s);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void stopTimer(String s)
    {
        this;
        JVM INSTR monitorenter ;
        mDelegate.stopTimer(s);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public String toString()
    {
        this;
        JVM INSTR monitorenter ;
        String s = mDelegate.toString();
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }
}
