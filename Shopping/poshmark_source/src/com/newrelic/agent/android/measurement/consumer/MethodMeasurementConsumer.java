// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.measurement.consumer;

import com.newrelic.agent.android.measurement.MeasurementType;

// Referenced classes of package com.newrelic.agent.android.measurement.consumer:
//            MetricMeasurementConsumer

public class MethodMeasurementConsumer extends MetricMeasurementConsumer
{

    private static final String METRIC_PREFIX = "Method/";

    public MethodMeasurementConsumer()
    {
        super(MeasurementType.Method);
    }

    protected String formatMetricName(String s)
    {
        return (new StringBuilder()).append("Method/").append(s.replace("#", "/")).toString();
    }
}
