// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.metrics;

import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.amazon.gallery.foundation.metrics:
//            MetricName

public class AggregatedCounter
{

    protected final AtomicInteger counter = new AtomicInteger(0);
    protected final AtomicInteger errors = new AtomicInteger(0);
    protected final MetricName event;

    public AggregatedCounter(MetricName metricname)
    {
        event = metricname;
    }

    public int get()
    {
        return counter.get();
    }

    public int getCount()
    {
        return counter.get();
    }

    public int getErrors()
    {
        return errors.get();
    }

    public MetricName getName()
    {
        return event;
    }

    public int increment(boolean flag)
    {
        if (!flag)
        {
            errors.incrementAndGet();
        }
        return counter.incrementAndGet();
    }
}
