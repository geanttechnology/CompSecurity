// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

// Referenced classes of package com.amazon.device.ads:
//            MobileAdsLoggerFactory, MobileAdsLogger, NumberUtils

class MetricsCollector
{
    static class CompositeMetricsCollector extends MetricsCollector
    {

        private final ArrayList collectors;

        public void incrementMetric(Metrics.MetricType metrictype)
        {
            for (Iterator iterator = collectors.iterator(); iterator.hasNext(); ((MetricsCollector)iterator.next()).incrementMetric(metrictype)) { }
        }

        public void publishMetricInMilliseconds(Metrics.MetricType metrictype, long l)
        {
            for (Iterator iterator = collectors.iterator(); iterator.hasNext(); ((MetricsCollector)iterator.next()).publishMetricInMilliseconds(metrictype, l)) { }
        }

        public void publishMetricInMillisecondsFromNanoseconds(Metrics.MetricType metrictype, long l)
        {
            for (Iterator iterator = collectors.iterator(); iterator.hasNext(); ((MetricsCollector)iterator.next()).publishMetricInMillisecondsFromNanoseconds(metrictype, l)) { }
        }

        public void setMetricString(Metrics.MetricType metrictype, String s)
        {
            for (Iterator iterator = collectors.iterator(); iterator.hasNext(); ((MetricsCollector)iterator.next()).setMetricString(metrictype, s)) { }
        }

        public void startMetric(Metrics.MetricType metrictype)
        {
            for (Iterator iterator = collectors.iterator(); iterator.hasNext(); ((MetricsCollector)iterator.next()).startMetric(metrictype)) { }
        }

        public void startMetricInMillisecondsFromNanoseconds(Metrics.MetricType metrictype, long l)
        {
            for (Iterator iterator = collectors.iterator(); iterator.hasNext(); ((MetricsCollector)iterator.next()).startMetricInMillisecondsFromNanoseconds(metrictype, l)) { }
        }

        public void stopMetric(Metrics.MetricType metrictype)
        {
            for (Iterator iterator = collectors.iterator(); iterator.hasNext(); ((MetricsCollector)iterator.next()).stopMetric(metrictype)) { }
        }

        public void stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType metrictype, long l)
        {
            for (Iterator iterator = collectors.iterator(); iterator.hasNext(); ((MetricsCollector)iterator.next()).stopMetricInMillisecondsFromNanoseconds(metrictype, l)) { }
        }

        public CompositeMetricsCollector(ArrayList arraylist)
        {
            collectors = arraylist;
        }
    }

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

        public final int increment;

        public MetricHitIncrement(Metrics.MetricType metrictype, int i)
        {
            super(metrictype);
            increment = i;
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

    static class MetricHitString extends MetricHit
    {

        public final String text;

        public MetricHitString(Metrics.MetricType metrictype, String s)
        {
            super(metrictype);
            text = s;
        }
    }

    static class MetricHitTotalTime extends MetricHit
    {

        public final long totalTime;

        public MetricHitTotalTime(Metrics.MetricType metrictype, long l)
        {
            super(metrictype);
            totalTime = l;
        }
    }


    private static final String LOGTAG = com/amazon/device/ads/MetricsCollector.getSimpleName();
    private String adTypeMetricTag;
    private final MobileAdsLogger logger;
    protected Vector metricHits;

    public MetricsCollector()
    {
        logger = (new MobileAdsLoggerFactory()).createMobileAdsLogger(LOGTAG);
        metricHits = new Vector(60);
    }

    public String getAdTypeMetricTag()
    {
        return adTypeMetricTag;
    }

    public Vector getMetricHits()
    {
        return metricHits;
    }

    public void incrementMetric(Metrics.MetricType metrictype)
    {
        logger.d((new StringBuilder()).append("METRIC Increment ").append(metrictype.toString()).toString());
        metricHits.add(new MetricHitIncrement(metrictype, 1));
    }

    public boolean isMetricsCollectorEmpty()
    {
        return metricHits.isEmpty();
    }

    public void publishMetricInMilliseconds(Metrics.MetricType metrictype, long l)
    {
        logger.d((new StringBuilder()).append("METRIC Publish ").append(metrictype.toString()).toString());
        metricHits.add(new MetricHitTotalTime(metrictype, l));
    }

    public void publishMetricInMillisecondsFromNanoseconds(Metrics.MetricType metrictype, long l)
    {
        publishMetricInMilliseconds(metrictype, NumberUtils.convertToMillisecondsFromNanoseconds(l));
    }

    public void setAdType(AdProperties.AdType adtype)
    {
        adTypeMetricTag = adtype.getAdTypeMetricTag();
    }

    public void setMetricString(Metrics.MetricType metrictype, String s)
    {
        logger.d((new StringBuilder()).append("METRIC Set ").append(metrictype.toString()).append(": ").append(s).toString());
        metricHits.add(new MetricHitString(metrictype, s));
    }

    public void startMetric(Metrics.MetricType metrictype)
    {
        startMetricInMillisecondsFromNanoseconds(metrictype, System.nanoTime());
    }

    public void startMetricInMillisecondsFromNanoseconds(Metrics.MetricType metrictype, long l)
    {
        logger.d((new StringBuilder()).append("METRIC Start ").append(metrictype.toString()).toString());
        l = NumberUtils.convertToMillisecondsFromNanoseconds(l);
        metricHits.add(new MetricHitStartTime(metrictype, l));
    }

    public void stopMetric(Metrics.MetricType metrictype)
    {
        stopMetricInMillisecondsFromNanoseconds(metrictype, System.nanoTime());
    }

    public void stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType metrictype, long l)
    {
        logger.d((new StringBuilder()).append("METRIC Stop ").append(metrictype.toString()).toString());
        l = NumberUtils.convertToMillisecondsFromNanoseconds(l);
        metricHits.add(new MetricHitStopTime(metrictype, l));
    }

}
