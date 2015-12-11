// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.measurement.consumer;

import com.newrelic.agent.android.measurement.CustomMetricMeasurement;
import com.newrelic.agent.android.measurement.Measurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.metric.Metric;

// Referenced classes of package com.newrelic.agent.android.measurement.consumer:
//            MetricMeasurementConsumer

public class CustomMetricConsumer extends MetricMeasurementConsumer
{

    private static final String METRIC_PREFIX = "Custom/";

    public CustomMetricConsumer()
    {
        super(MeasurementType.Custom);
    }

    public void consumeMeasurement(Measurement measurement)
    {
        measurement = ((CustomMetricMeasurement)measurement).getCustomMetric();
        measurement.setName(formatMetricName(measurement.getName()));
        addMetric(measurement);
    }

    protected String formatMetricName(String s)
    {
        return (new StringBuilder()).append("Custom/").append(s).toString();
    }
}
