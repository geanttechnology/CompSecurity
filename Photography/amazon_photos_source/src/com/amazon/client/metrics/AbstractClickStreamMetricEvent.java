// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import com.amazon.client.metrics.clickstream.ClickStreamData;
import com.amazon.client.metrics.clickstream.ClickStreamHelper;
import com.amazon.client.metrics.clickstream.ClickStreamInfo;
import com.amazon.client.metrics.clickstream.GenericClickStreamMetricEvent;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.client.metrics:
//            BasicMetricEvent, DataPoint, DataPointType, MetricEventType

public abstract class AbstractClickStreamMetricEvent extends BasicMetricEvent
    implements GenericClickStreamMetricEvent
{

    private final Map mInfoStructures = new HashMap();
    private final String mRequestId = ClickStreamHelper.generateRequestId();

    public AbstractClickStreamMetricEvent(String s, String s1, MetricEventType metriceventtype, boolean flag)
    {
        super(s, s1, metriceventtype, flag);
    }

    public void addClickStreamInfo(ClickStreamInfo clickstreaminfo)
    {
        if (clickstreaminfo != null)
        {
            mInfoStructures.put(clickstreaminfo.getClass().getName(), clickstreaminfo);
        }
    }

    public List getAsDataPoints()
    {
        List list = super.getAsDataPoints();
        for (Iterator iterator = getClickStreamInfo().iterator(); iterator.hasNext(); ClickStreamHelper.addDatapointsToList(list, (ClickStreamInfo)iterator.next())) { }
        list.add(new DataPoint(ClickStreamData.REQUEST_ID.getName(), mRequestId, 1, DataPointType.DV));
        return list;
    }

    public Collection getClickStreamInfo()
    {
        return mInfoStructures.values();
    }

    public void removeClickStreamInfo(Class class1)
    {
        if (class1 != null)
        {
            mInfoStructures.remove(class1.getName());
        }
    }

    public boolean validateMetricEvent()
    {
        return !mInfoStructures.isEmpty();
    }
}
