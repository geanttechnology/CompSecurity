// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import com.amazon.client.metrics.clickstream.ECommerceInfo;
import com.amazon.client.metrics.clickstream.ImpressionTrackingData;
import com.amazon.client.metrics.clickstream.UsageInfo;

// Referenced classes of package com.amazon.client.metrics:
//            MetricEvent

public interface ClickStreamMetricsEvent
    extends MetricEvent
{

    public abstract String getRequestId();

    public abstract void setECommerceInfo(ECommerceInfo ecommerceinfo);

    public abstract void setImpressionTrackingData(ImpressionTrackingData impressiontrackingdata);

    public abstract void setUsageInfo(UsageInfo usageinfo);

    public abstract boolean validateMetricEvent();
}
