// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;


// Referenced classes of package com.amazon.client.metrics:
//            MetricsFactory, NullClickStreamMetricEvent, NullMetricEvent, ClickStreamMetricsEvent, 
//            MetricEventType, MetricEvent, Priority

public class NullMetricsFactory
    implements MetricsFactory
{

    public NullMetricsFactory()
    {
    }

    public ClickStreamMetricsEvent createClickStreamMetricEvent(String s, String s1)
    {
        return new NullClickStreamMetricEvent(s, s1);
    }

    public ClickStreamMetricsEvent createClickStreamMetricEvent(String s, String s1, MetricEventType metriceventtype)
    {
        return new NullClickStreamMetricEvent(s, s1, metriceventtype);
    }

    public ClickStreamMetricsEvent createClickStreamMetricEvent(String s, String s1, MetricEventType metriceventtype, boolean flag)
    {
        return new NullClickStreamMetricEvent(s, s1, metriceventtype);
    }

    public MetricEvent createConcurrentMetricEvent(String s, String s1)
    {
        return new NullMetricEvent(s, s1);
    }

    public MetricEvent createConcurrentMetricEvent(String s, String s1, MetricEventType metriceventtype)
    {
        return new NullMetricEvent(s, s1, metriceventtype);
    }

    public MetricEvent createConcurrentMetricEvent(String s, String s1, MetricEventType metriceventtype, boolean flag)
    {
        return new NullMetricEvent(s, s1, metriceventtype);
    }

    public MetricEvent createMetricEvent(String s, String s1)
    {
        return new NullMetricEvent(s, s1);
    }

    public MetricEvent createMetricEvent(String s, String s1, MetricEventType metriceventtype)
    {
        return new NullMetricEvent(s, s1, metriceventtype);
    }

    public MetricEvent createMetricEvent(String s, String s1, MetricEventType metriceventtype, boolean flag)
    {
        return new NullMetricEvent(s, s1, metriceventtype);
    }

    public String getSessionID()
    {
        return "";
    }

    public void record(MetricEvent metricevent)
    {
    }

    public void record(MetricEvent metricevent, Priority priority)
    {
    }
}
