// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import java.util.List;

// Referenced classes of package com.amazon.client.metrics:
//            MetricEvent, BasicMetricEvent, MetricEventType

public class ConcurrentMetricEvent
    implements MetricEvent
{

    private final Object mCounterLock = new Object();
    private final Object mDVLock = new Object();
    private final MetricEvent mDelegate;
    private final Object mTimerLock = new Object();

    public ConcurrentMetricEvent(String s, String s1, MetricEventType metriceventtype, boolean flag)
    {
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
