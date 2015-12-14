// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import com.amazon.client.metrics.clickstream.UsageInfo;

// Referenced classes of package com.amazon.client.metrics:
//            NullMetricEvent, ClickStreamMetricsEvent, MetricEventType

public class NullClickStreamMetricEvent extends NullMetricEvent
    implements ClickStreamMetricsEvent
{

    public NullClickStreamMetricEvent(String s, String s1, MetricEventType metriceventtype)
    {
        super(s, s1, metriceventtype);
    }

    public void setUsageInfo(UsageInfo usageinfo)
    {
    }

    public boolean validateMetricEvent()
    {
        return false;
    }
}
