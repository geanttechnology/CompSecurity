// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import com.amazon.client.metrics.clickstream.GenericClickStreamMetricEvent;

// Referenced classes of package com.amazon.client.metrics:
//            MetricsFactory, MetricEventType, BasicClickStreamMetricEvent, NullClickStreamMetricEvent, 
//            ClickStreamWeblabTrigger, ConcurrentMetricEvent, NullMetricEvent, BasicMetricEvent, 
//            Priority, ClickStreamMetricsEvent, MetricEvent

public abstract class BaseMetricsFactoryImpl
    implements MetricsFactory
{

    private static final boolean DEFAULT_ALLOW_RUNNING_TIMERS = false;

    public BaseMetricsFactoryImpl()
    {
    }

    public ClickStreamMetricsEvent createClickStreamMetricEvent(String s, String s1)
    {
        return createClickStreamMetricEvent(s, s1, MetricEventType.getDefault(), false);
    }

    public ClickStreamMetricsEvent createClickStreamMetricEvent(String s, String s1, MetricEventType metriceventtype)
    {
        return createClickStreamMetricEvent(s, s1, metriceventtype, false);
    }

    public ClickStreamMetricsEvent createClickStreamMetricEvent(String s, String s1, MetricEventType metriceventtype, boolean flag)
    {
        if (shouldRecordMetrics())
        {
            return new BasicClickStreamMetricEvent(s, s1, metriceventtype, flag);
        } else
        {
            return new NullClickStreamMetricEvent(s, s1, metriceventtype);
        }
    }

    public GenericClickStreamMetricEvent createClickStreamWeblabTrigger(String s, String s1, String s2, String s3)
    {
        if (shouldRecordMetrics())
        {
            return new ClickStreamWeblabTrigger(s, s1, s2, s3);
        } else
        {
            return new NullClickStreamMetricEvent(s, s1);
        }
    }

    public MetricEvent createConcurrentMetricEvent(String s, String s1)
    {
        return createConcurrentMetricEvent(s, s1, MetricEventType.getDefault(), false);
    }

    public MetricEvent createConcurrentMetricEvent(String s, String s1, MetricEventType metriceventtype)
    {
        return createConcurrentMetricEvent(s, s1, metriceventtype, false);
    }

    public MetricEvent createConcurrentMetricEvent(String s, String s1, MetricEventType metriceventtype, boolean flag)
    {
        if (shouldRecordMetrics())
        {
            return new ConcurrentMetricEvent(s, s1, metriceventtype, flag);
        } else
        {
            return new NullMetricEvent(s, s1, metriceventtype);
        }
    }

    public MetricEvent createMetricEvent(String s, String s1)
    {
        return createMetricEvent(s, s1, MetricEventType.getDefault(), false);
    }

    public MetricEvent createMetricEvent(String s, String s1, MetricEventType metriceventtype)
    {
        return createMetricEvent(s, s1, metriceventtype, false);
    }

    public MetricEvent createMetricEvent(String s, String s1, MetricEventType metriceventtype, boolean flag)
    {
        if (shouldRecordMetrics())
        {
            return new BasicMetricEvent(s, s1, metriceventtype, flag);
        } else
        {
            return new NullMetricEvent(s, s1, metriceventtype);
        }
    }

    public void record(MetricEvent metricevent)
    {
        record(metricevent, Priority.NORMAL);
    }

    protected abstract boolean shouldRecordMetrics();
}
