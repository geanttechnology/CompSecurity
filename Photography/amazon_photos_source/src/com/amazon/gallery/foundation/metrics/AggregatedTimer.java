// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.metrics;


// Referenced classes of package com.amazon.gallery.foundation.metrics:
//            MetricName

public class AggregatedTimer
{

    protected final MetricName event;
    protected long maxElapsedTime;
    protected long minElapsedTime;
    protected int numErrors;
    protected int numRecordings;
    protected long totalElapsedTime;

    public AggregatedTimer(MetricName metricname)
    {
        event = metricname;
        minElapsedTime = 0x7fffffffffffffffL;
        maxElapsedTime = 0x8000000000000000L;
        totalElapsedTime = 0L;
        numRecordings = 0;
    }

    public long getAvgElapsedTime()
    {
        this;
        JVM INSTR monitorenter ;
        long l = totalElapsedTime / (long)numRecordings;
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public long getMaxElapsedTime()
    {
        this;
        JVM INSTR monitorenter ;
        long l = maxElapsedTime;
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public long getMinElapsedTime()
    {
        this;
        JVM INSTR monitorenter ;
        long l = minElapsedTime;
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public MetricName getName()
    {
        return event;
    }

    public int getNumErrors()
    {
        return numErrors;
    }

    public Integer getNumSamples()
    {
        return Integer.valueOf(numRecordings);
    }

    public void update(long l, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (minElapsedTime > l)
        {
            minElapsedTime = l;
        }
        if (maxElapsedTime < l)
        {
            maxElapsedTime = l;
        }
        totalElapsedTime = totalElapsedTime + l;
        numRecordings = numRecordings + 1;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        numErrors = numErrors + 1;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
