// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import com.amazon.client.metrics.clickstream.ClickStreamData;
import com.amazon.client.metrics.clickstream.ClickStreamInfo;
import com.amazon.client.metrics.clickstream.ECommerceInfo;
import com.amazon.client.metrics.clickstream.ImpressionTrackingData;
import com.amazon.client.metrics.clickstream.UsageInfo;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;

// Referenced classes of package com.amazon.client.metrics:
//            BasicMetricEvent, ClickStreamMetricsEvent, MetricEventType, DataPoint, 
//            DataPointType

public class BasicClickStreamMetricEvent extends BasicMetricEvent
    implements ClickStreamMetricsEvent
{

    private ECommerceInfo mECommerceInfo;
    private ImpressionTrackingData mImpressionTrackingData;
    private final String mRequestId;
    private UsageInfo mUsageInfo;

    public BasicClickStreamMetricEvent(String s, String s1)
    {
        this(s, s1, MetricEventType.getDefault());
    }

    public BasicClickStreamMetricEvent(String s, String s1, MetricEventType metriceventtype)
    {
        this(s, s1, metriceventtype, false);
    }

    public BasicClickStreamMetricEvent(String s, String s1, MetricEventType metriceventtype, boolean flag)
    {
        super(s, s1, metriceventtype, flag);
        mRequestId = generateRequestId();
    }

    private void addDatapointsToList(List list, ClickStreamInfo clickstreaminfo)
    {
        if (clickstreaminfo != null)
        {
            clickstreaminfo = clickstreaminfo.getDataPoints().iterator();
            while (clickstreaminfo.hasNext()) 
            {
                list.add((DataPoint)clickstreaminfo.next());
            }
        }
    }

    private String generateRequestId()
    {
        String s = UUID.randomUUID().toString().replace("-", "");
        Random random = new Random();
        random.setSeed((new Date()).getTime());
        int i = random.nextInt(s.length() - 20);
        return s.subSequence(i, i + 20).toString().toUpperCase();
    }

    public List getAsDataPoints()
    {
        List list = super.getAsDataPoints();
        addDatapointsToList(list, mUsageInfo);
        addDatapointsToList(list, mImpressionTrackingData);
        addDatapointsToList(list, mECommerceInfo);
        list.add(new DataPoint(ClickStreamData.REQUEST_ID.getName(), mRequestId, 1, DataPointType.DV));
        return list;
    }

    public String getRequestId()
    {
        return mRequestId;
    }

    public void setECommerceInfo(ECommerceInfo ecommerceinfo)
    {
        mECommerceInfo = ecommerceinfo;
    }

    public void setImpressionTrackingData(ImpressionTrackingData impressiontrackingdata)
    {
        mImpressionTrackingData = impressiontrackingdata;
    }

    public void setUsageInfo(UsageInfo usageinfo)
    {
        mUsageInfo = usageinfo;
    }

    public boolean validateMetricEvent()
    {
        return mUsageInfo != null || mImpressionTrackingData != null || mECommerceInfo != null;
    }
}
