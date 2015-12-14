// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;

import java.util.Vector;

// Referenced classes of package com.amazon.device.ads.identity:
//            Log

class MetricsCollector
{
    static class MetricHit
    {

        public final Metrics.MetricType metric;

        public MetricHit(Metrics.MetricType metrictype)
        {
            metric = metrictype;
        }
    }

    static class MetricHitIncrement extends MetricHit
    {

        public final int increment = 1;

        public MetricHitIncrement(Metrics.MetricType metrictype)
        {
            super(metrictype);
        }
    }

    static class MetricHitStartTime extends MetricHit
    {

        public final long startTime;

        public MetricHitStartTime(Metrics.MetricType metrictype, long l)
        {
            super(metrictype);
            startTime = l;
        }
    }

    static class MetricHitStopTime extends MetricHit
    {

        public final long stopTime;

        public MetricHitStopTime(Metrics.MetricType metrictype, long l)
        {
            super(metrictype);
            stopTime = l;
        }
    }


    protected Vector metricHits;

    public MetricsCollector()
    {
        metricHits = new Vector(60);
    }

    public void incrementMetric(Metrics.MetricType metrictype)
    {
        Log.d("MetricsCollector", (new StringBuilder("METRIC Increment ")).append(metrictype.toString()).toString(), new Object[0]);
        metricHits.add(new MetricHitIncrement(metrictype));
    }

    public void startMetric(Metrics.MetricType metrictype)
    {
        startMetricInMillisecondsFromNanoseconds(metrictype, System.nanoTime());
    }

    public void startMetricInMillisecondsFromNanoseconds(Metrics.MetricType metrictype, long l)
    {
        Log.d("MetricsCollector", (new StringBuilder("METRIC Start ")).append(metrictype.toString()).toString(), new Object[0]);
        l /= 0xf4240L;
        metricHits.add(new MetricHitStartTime(metrictype, l));
    }

    public void stopMetric(Metrics.MetricType metrictype)
    {
        stopMetricInMillisecondsFromNanoseconds(metrictype, System.nanoTime());
    }

    public void stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType metrictype, long l)
    {
        Log.d("MetricsCollector", (new StringBuilder("METRIC Stop ")).append(metrictype.toString()).toString(), new Object[0]);
        l /= 0xf4240L;
        metricHits.add(new MetricHitStopTime(metrictype, l));
    }
}
