// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import com.amazon.client.metrics.clickstream.UsageInfo;

// Referenced classes of package com.amazon.client.metrics:
//            AbstractClickStreamMetricEvent, ClickStreamMetricsEvent, MetricEventType

public class BasicClickStreamMetricEvent extends AbstractClickStreamMetricEvent
    implements ClickStreamMetricsEvent
{

    public BasicClickStreamMetricEvent(String s, String s1, MetricEventType metriceventtype, boolean flag)
    {
        super(s, s1, metriceventtype, flag);
    }

    public void setUsageInfo(UsageInfo usageinfo)
    {
        if (usageinfo == null)
        {
            removeClickStreamInfo(com/amazon/client/metrics/clickstream/UsageInfo);
            return;
        } else
        {
            addClickStreamInfo(usageinfo);
            return;
        }
    }
}
