// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import com.amazon.client.metrics.clickstream.ClickStreamInfo;
import com.amazon.client.metrics.clickstream.ECommerceInfo;
import com.amazon.client.metrics.clickstream.ImpressionTrackingData;
import com.amazon.client.metrics.clickstream.UsageInfo;
import java.util.ArrayList;
import java.util.Collection;

// Referenced classes of package com.amazon.client.metrics:
//            NullMetricEvent, ClickStreamMetricsEvent, MetricEventType

public class NullClickStreamMetricEvent extends NullMetricEvent
    implements ClickStreamMetricsEvent
{

    private static final String NULL_REQUEST_ID = " ";

    public NullClickStreamMetricEvent(String s, String s1)
    {
        this(s, s1, MetricEventType.getDefault());
    }

    public NullClickStreamMetricEvent(String s, String s1, MetricEventType metriceventtype)
    {
        super(s, s1, metriceventtype);
    }

    public void addClickStreamInfo(ClickStreamInfo clickstreaminfo)
    {
    }

    public Collection getClickStreamInfo()
    {
        return new ArrayList(0);
    }

    public String getRequestId()
    {
        return " ";
    }

    public void removeClickStreamInfo(Class class1)
    {
    }

    public void setECommerceInfo(ECommerceInfo ecommerceinfo)
    {
    }

    public void setImpressionTrackingData(ImpressionTrackingData impressiontrackingdata)
    {
    }

    public void setUsageInfo(UsageInfo usageinfo)
    {
    }

    public boolean validateMetricEvent()
    {
        return false;
    }
}
