// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager;

import com.amazon.client.metrics.MetricEvent;

// Referenced classes of package com.amazon.device.crashmanager:
//            MetricsHeaderProcessor, AmazonPackageLookup

class MetricsHeaderProcessorFactory
{

    private AmazonPackageLookup mAmazonPackageLookup;
    private MetricEvent mMetricEvent;

    public MetricsHeaderProcessorFactory(AmazonPackageLookup amazonpackagelookup, MetricEvent metricevent)
    {
        if (amazonpackagelookup == null)
        {
            throw new IllegalArgumentException("Amazon Package Lookup must not be null.");
        }
        if (metricevent == null)
        {
            throw new IllegalArgumentException("Metric event must not be null.");
        } else
        {
            mAmazonPackageLookup = amazonpackagelookup;
            mMetricEvent = metricevent;
            return;
        }
    }

    public MetricsHeaderProcessor construct(com.amazon.device.utils.DetUtil.HeaderProcessor headerprocessor)
    {
        if (headerprocessor == null)
        {
            throw new IllegalArgumentException("Header processor must not be null.");
        } else
        {
            return new MetricsHeaderProcessor(headerprocessor, mAmazonPackageLookup, mMetricEvent);
        }
    }
}
