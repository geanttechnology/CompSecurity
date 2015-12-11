// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now;

import android.content.Context;
import com.amazon.client.metrics.AndroidMetricsFactoryImpl;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.client.metrics.MetricsFactory;
import com.amazon.client.metrics.Priority;

public class DCMCollector
{

    public DCMCollector()
    {
    }

    public static MetricsFactory getMetricsFactory(Context context)
    {
        MetricsFactory metricsfactory1 = (MetricsFactory)context.getSystemService("com.amazon.client.metrics.api");
        MetricsFactory metricsfactory = metricsfactory1;
        if (metricsfactory1 == null)
        {
            metricsfactory = AndroidMetricsFactoryImpl.getInstance(context);
        }
        return metricsfactory;
    }

    public static MetricEvent startPmetEvent(Context context, String s)
    {
        context = getMetricsFactory(context).createMetricEvent("HoudiniAndroid", s);
        context.startTimer("StartToCompleteTime");
        return context;
    }

    public static void stopAndRecordEvent(Context context, MetricEvent metricevent)
    {
        if (metricevent != null)
        {
            metricevent.stopTimer("StartToCompleteTime");
            getMetricsFactory(context).record(metricevent, Priority.NORMAL);
        }
    }
}
