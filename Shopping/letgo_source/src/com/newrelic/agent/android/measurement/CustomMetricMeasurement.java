// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.measurement;

import com.newrelic.agent.android.metric.Metric;

// Referenced classes of package com.newrelic.agent.android.measurement:
//            CategorizedMeasurement, MeasurementType

public class CustomMetricMeasurement extends CategorizedMeasurement
{

    private Metric customMetric;

    public CustomMetricMeasurement()
    {
        super(MeasurementType.Custom);
    }

    public CustomMetricMeasurement(String s, int i, double d, double d1)
    {
        this();
        setName(s);
        customMetric = new Metric(s);
        customMetric.sample(d);
        customMetric.setCount(i);
        customMetric.setExclusive(Double.valueOf(d1));
    }

    public Metric getCustomMetric()
    {
        return customMetric;
    }
}
