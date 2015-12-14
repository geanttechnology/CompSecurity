// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.metrics.dcm;

import android.os.AsyncTask;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.client.metrics.MetricsFactory;
import com.amazon.gallery.foundation.metrics.AbstractProfiler;
import com.amazon.gallery.foundation.metrics.AggregatedCounter;
import com.amazon.gallery.foundation.metrics.AggregatedTimer;
import com.amazon.gallery.foundation.metrics.MetricName;
import java.util.Collection;
import java.util.Iterator;

public class DCMProfiler extends AbstractProfiler
{

    private final MetricsFactory metricsFactory;

    public DCMProfiler(MetricsFactory metricsfactory)
    {
        metricsFactory = metricsfactory;
        workaroundForV4();
    }

    private void recordCounters(Collection collection)
    {
        Object obj;
        for (collection = collection.iterator(); collection.hasNext(); metricsFactory.record(((MetricEvent) (obj))))
        {
            AggregatedCounter aggregatedcounter = (AggregatedCounter)collection.next();
            obj = aggregatedcounter.getName();
            obj = metricsFactory.createMetricEvent(((MetricName) (obj)).getComponent(), ((MetricName) (obj)).getEvent());
            ((MetricEvent) (obj)).addCounter("count", aggregatedcounter.getCount());
            ((MetricEvent) (obj)).addCounter("error", aggregatedcounter.getErrors());
        }

    }

    private void recordTimers(Collection collection)
    {
        Object obj;
        for (collection = collection.iterator(); collection.hasNext(); metricsFactory.record(((MetricEvent) (obj))))
        {
            AggregatedTimer aggregatedtimer = (AggregatedTimer)collection.next();
            obj = aggregatedtimer.getName();
            obj = metricsFactory.createMetricEvent(((MetricName) (obj)).getComponent(), ((MetricName) (obj)).getEvent());
            ((MetricEvent) (obj)).addTimer("time-max", aggregatedtimer.getMaxElapsedTime());
            ((MetricEvent) (obj)).addTimer("time-min", aggregatedtimer.getMinElapsedTime());
            ((MetricEvent) (obj)).addTimer("time-avg", aggregatedtimer.getAvgElapsedTime());
            ((MetricEvent) (obj)).addCounter("count", aggregatedtimer.getNumSamples().intValue());
            ((MetricEvent) (obj)).addCounter("error", aggregatedtimer.getNumErrors());
        }

    }

    private void workaroundForV4()
    {
        (new AsyncTask() {

            final DCMProfiler this$0;

            protected transient MetricEvent doInBackground(Void avoid[])
            {
                return metricsFactory.createMetricEvent("Photos", "Workaround");
            }

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            
            {
                this$0 = DCMProfiler.this;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    protected void record(Collection collection, Collection collection1)
    {
        recordCounters(collection);
        recordTimers(collection1);
    }

}
