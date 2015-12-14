// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.metrics.clickstream;

import com.amazon.client.metrics.ClickStreamMetricsEvent;
import com.amazon.client.metrics.MetricsFactory;
import com.amazon.client.metrics.clickstream.UsageInfo;
import com.amazon.gallery.foundation.utils.log.GLogger;

public class AbstractClickstreamRecorder
{

    public static final String TAG = com/amazon/gallery/framework/metrics/clickstream/AbstractClickstreamRecorder.getName();
    private final MetricsFactory metricsFactory;
    private final String program;
    private final String teamName;
    private final String variant;

    public AbstractClickstreamRecorder(String s, MetricsFactory metricsfactory)
    {
        this(s, "PhotosTeam", "Photos", metricsfactory);
    }

    AbstractClickstreamRecorder(String s, String s1, String s2, MetricsFactory metricsfactory)
    {
        variant = s;
        teamName = s1;
        program = s2;
        metricsFactory = metricsfactory;
    }

    protected UsageInfo createUsageInfo(String s, String s1, String s2, String s3)
    {
        return (new UsageInfo(s, s2, teamName, variant)).setSubPageType(s1).setPageAction(s3);
    }

    protected void recordClickstreamEvent(UsageInfo usageinfo)
    {
        ClickStreamMetricsEvent clickstreammetricsevent = metricsFactory.createClickStreamMetricEvent(program, usageinfo.getSubPageType());
        clickstreammetricsevent.setUsageInfo(usageinfo);
        if (clickstreammetricsevent.validateMetricEvent())
        {
            GLogger.v(TAG, "Logging Clickstream event: %s", new Object[] {
                clickstreammetricsevent.toString()
            });
            metricsFactory.record(clickstreammetricsevent);
            return;
        } else
        {
            GLogger.e(TAG, "Metric Event was invalid %s", new Object[] {
                clickstreammetricsevent.toString()
            });
            return;
        }
    }

}
