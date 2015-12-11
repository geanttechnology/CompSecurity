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

    private final Object mCounterLock;
    private final Object mDVLock;
    private final MetricEvent mDelegate;
    private final Object mTimerLock;

    protected ConcurrentMetricEvent(MetricEvent metricevent)
    {
        mCounterLock = new Object();
        mTimerLock = new Object();
        mDVLock = new Object();
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
        mCounterLock = new Object();
        mTimerLock = new Object();
        mDVLock = new Object();
        mDelegate = new BasicMetricEvent(s, s1, metriceventtype, flag);
    }

    public void addCounter(String s, double d)
    {
        synchronized (mCounterLock)
        {
            mDelegate.addCounter(s, d);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void addDataPoint(DataPoint datapoint)
        throws MetricsException
    {
        Object obj = mCounterLock;
        obj;
        JVM INSTR monitorenter ;
        Object obj1 = mTimerLock;
        obj1;
        JVM INSTR monitorenter ;
        synchronized (mDVLock)
        {
            mDelegate.addDataPoint(datapoint);
        }
        obj1;
        JVM INSTR monitorexit ;
        obj;
        JVM INSTR monitorexit ;
        return;
        datapoint;
        obj2;
        JVM INSTR monitorexit ;
        throw datapoint;
        datapoint;
        obj1;
        JVM INSTR monitorexit ;
        throw datapoint;
        datapoint;
        obj;
        JVM INSTR monitorexit ;
        throw datapoint;
    }

    public void addDataPoints(List list)
        throws MetricsException
    {
        Object obj = mCounterLock;
        obj;
        JVM INSTR monitorenter ;
        Object obj1 = mTimerLock;
        obj1;
        JVM INSTR monitorenter ;
        synchronized (mDVLock)
        {
            mDelegate.addDataPoints(list);
        }
        obj1;
        JVM INSTR monitorexit ;
        obj;
        JVM INSTR monitorexit ;
        return;
        list;
        obj2;
        JVM INSTR monitorexit ;
        throw list;
        list;
        obj1;
        JVM INSTR monitorexit ;
        throw list;
        list;
        obj;
        JVM INSTR monitorexit ;
        throw list;
    }

    public void addString(String s, String s1)
    {
        synchronized (mDVLock)
        {
            mDelegate.addString(s, s1);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void addTimer(String s, double d)
    {
        synchronized (mTimerLock)
        {
            mDelegate.addTimer(s, d);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void addTimer(String s, double d, int i)
    {
        synchronized (mTimerLock)
        {
            mDelegate.addTimer(s, d, i);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void appendString(String s, String s1)
    {
        synchronized (mDVLock)
        {
            mDelegate.appendString(s, s1);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void clear()
    {
        Object obj = mCounterLock;
        obj;
        JVM INSTR monitorenter ;
        Object obj1 = mTimerLock;
        obj1;
        JVM INSTR monitorenter ;
        synchronized (mDVLock)
        {
            mDelegate.clear();
        }
        obj1;
        JVM INSTR monitorexit ;
        obj;
        JVM INSTR monitorexit ;
        return;
        exception2;
        obj2;
        JVM INSTR monitorexit ;
        throw exception2;
        Exception exception1;
        exception1;
        obj1;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean getAnonymous()
    {
        return mDelegate.getAnonymous();
    }

    public List getAsDataPoints()
    {
        Object obj = mCounterLock;
        obj;
        JVM INSTR monitorenter ;
        Object obj1 = mTimerLock;
        obj1;
        JVM INSTR monitorenter ;
        List list;
        synchronized (mDVLock)
        {
            list = mDelegate.getAsDataPoints();
        }
        obj1;
        JVM INSTR monitorexit ;
        obj;
        JVM INSTR monitorexit ;
        return list;
        exception2;
        obj2;
        JVM INSTR monitorexit ;
        throw exception2;
        Exception exception1;
        exception1;
        obj1;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public List getAsDataPointsAndClear()
    {
        Object obj = mCounterLock;
        obj;
        JVM INSTR monitorenter ;
        Object obj1 = mTimerLock;
        obj1;
        JVM INSTR monitorenter ;
        List list;
        synchronized (mDVLock)
        {
            list = mDelegate.getAsDataPoints();
            mDelegate.clear();
        }
        obj1;
        JVM INSTR monitorexit ;
        obj;
        JVM INSTR monitorexit ;
        return list;
        exception2;
        obj2;
        JVM INSTR monitorexit ;
        throw exception2;
        Exception exception1;
        exception1;
        obj1;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public MetricEventType getMetricEventType()
    {
        return mDelegate.getMetricEventType();
    }

    public String getNonAnonymousCustomerId()
    {
        return mDelegate.getNonAnonymousCustomerId();
    }

    public String getNonAnonymousSessionId()
    {
        return mDelegate.getNonAnonymousSessionId();
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
        Object obj = mCounterLock;
        obj;
        JVM INSTR monitorenter ;
        Object obj1 = mTimerLock;
        obj1;
        JVM INSTR monitorenter ;
        boolean flag;
        synchronized (mDVLock)
        {
            flag = mDelegate.hasDataPoints();
        }
        obj1;
        JVM INSTR monitorexit ;
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception2;
        obj2;
        JVM INSTR monitorexit ;
        throw exception2;
        Exception exception1;
        exception1;
        obj1;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void incrementCounter(String s, double d)
    {
        synchronized (mCounterLock)
        {
            mDelegate.incrementCounter(s, d);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void removeCounter(String s)
    {
        synchronized (mCounterLock)
        {
            mDelegate.removeCounter(s);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void removeString(String s)
    {
        synchronized (mDVLock)
        {
            mDelegate.removeString(s);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void removeTimer(String s)
    {
        synchronized (mTimerLock)
        {
            mDelegate.removeTimer(s);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void restoreFromMap(Map map)
    {
        Object obj = mCounterLock;
        obj;
        JVM INSTR monitorenter ;
        Object obj1 = mTimerLock;
        obj1;
        JVM INSTR monitorenter ;
        synchronized (mDVLock)
        {
            mDelegate.restoreFromMap(map);
        }
        obj1;
        JVM INSTR monitorexit ;
        obj;
        JVM INSTR monitorexit ;
        return;
        map;
        obj2;
        JVM INSTR monitorexit ;
        throw map;
        map;
        obj1;
        JVM INSTR monitorexit ;
        throw map;
        map;
        obj;
        JVM INSTR monitorexit ;
        throw map;
    }

    public void saveToMap(Map map)
    {
        Object obj = mCounterLock;
        obj;
        JVM INSTR monitorenter ;
        Object obj1 = mTimerLock;
        obj1;
        JVM INSTR monitorenter ;
        synchronized (mDVLock)
        {
            mDelegate.saveToMap(map);
        }
        obj1;
        JVM INSTR monitorexit ;
        obj;
        JVM INSTR monitorexit ;
        return;
        map;
        obj2;
        JVM INSTR monitorexit ;
        throw map;
        map;
        obj1;
        JVM INSTR monitorexit ;
        throw map;
        map;
        obj;
        JVM INSTR monitorexit ;
        throw map;
    }

    public void setAnonymous(boolean flag)
    {
        synchronized (mDVLock)
        {
            mDelegate.setAnonymous(flag);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setNonAnonymousCustomerId(String s)
    {
        synchronized (mDVLock)
        {
            mDelegate.setNonAnonymousCustomerId(s);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void setNonAnonymousSessionId(String s)
    {
        synchronized (mDVLock)
        {
            mDelegate.setNonAnonymousSessionId(s);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void startTimer(String s)
    {
        synchronized (mTimerLock)
        {
            mDelegate.startTimer(s);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void stopTimer(String s)
    {
        synchronized (mTimerLock)
        {
            mDelegate.stopTimer(s);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public String toString()
    {
        Object obj = mCounterLock;
        obj;
        JVM INSTR monitorenter ;
        Object obj1 = mTimerLock;
        obj1;
        JVM INSTR monitorenter ;
        String s;
        synchronized (mDVLock)
        {
            s = mDelegate.toString();
        }
        obj1;
        JVM INSTR monitorexit ;
        obj;
        JVM INSTR monitorexit ;
        return s;
        exception2;
        obj2;
        JVM INSTR monitorexit ;
        throw exception2;
        Exception exception1;
        exception1;
        obj1;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
