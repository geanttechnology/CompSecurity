// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import com.amazon.client.metrics.clickstream.ECommerceInfo;
import com.amazon.client.metrics.clickstream.ImpressionTrackingData;
import com.amazon.client.metrics.clickstream.UsageInfo;

// Referenced classes of package com.amazon.client.metrics:
//            NullMetricEvent, ClickStreamMetricsEvent, MetricEventType

public class NullClickStreamMetricEvent extends NullMetricEvent
    implements ClickStreamMetricsEvent
{

    private String mCustomerId;
    private String mRequestId;
    private String mSessionId;

    public NullClickStreamMetricEvent(String s, String s1)
    {
        this(s, s1, MetricEventType.getDefault());
        mRequestId = " ";
        mSessionId = " ";
        mCustomerId = " ";
    }

    public NullClickStreamMetricEvent(String s, String s1, MetricEventType metriceventtype)
    {
        super(s, s1, metriceventtype);
    }

    public String getRequestId()
    {
        return mRequestId;
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
