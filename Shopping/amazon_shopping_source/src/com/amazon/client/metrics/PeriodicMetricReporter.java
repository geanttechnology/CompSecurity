// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.client.metrics:
//            MetricEvent, MetricEventType

public interface PeriodicMetricReporter
{

    public abstract MetricEvent createTrackedMetricEvent(String s, String s1);

    public abstract MetricEvent createTrackedMetricEvent(String s, String s1, MetricEventType metriceventtype);

    public abstract MetricEvent getMetricEvent();

    public abstract void shutdown();

    public abstract void startRecordingPeriodically(long l, TimeUnit timeunit);

    public abstract void stopTrackingMetricEvent(MetricEvent metricevent);
}
