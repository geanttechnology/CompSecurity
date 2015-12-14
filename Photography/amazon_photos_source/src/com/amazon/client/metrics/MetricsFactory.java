// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;


// Referenced classes of package com.amazon.client.metrics:
//            ClickStreamMetricsEvent, MetricEvent, MetricEventType, Priority

public interface MetricsFactory
{

    public abstract ClickStreamMetricsEvent createClickStreamMetricEvent(String s, String s1);

    public abstract MetricEvent createConcurrentMetricEvent(String s, String s1);

    public abstract MetricEvent createConcurrentMetricEvent(String s, String s1, MetricEventType metriceventtype, boolean flag);

    public abstract MetricEvent createMetricEvent(String s, String s1);

    public abstract void record(MetricEvent metricevent);

    public abstract void record(MetricEvent metricevent, Priority priority);
}
