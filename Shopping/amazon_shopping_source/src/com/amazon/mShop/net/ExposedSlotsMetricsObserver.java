// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mShop.net:
//            BaseSlotsMetricsObserver, MetricsAggregator, MShopAggregatedClientMetrics, AggregatedMetrics

public class ExposedSlotsMetricsObserver extends BaseSlotsMetricsObserver
{

    static final MetricsAggregator METRICS_AGGREGATOR = new MetricsAggregator() {

        public AggregatedMetrics aggregate(List list)
        {
            ArrayList arraylist = new ArrayList();
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                MetricsAggregator.MetricEvent metricevent = (MetricsAggregator.MetricEvent)list.next();
                if (metricevent instanceof ExposedSlotsMetricsObserver)
                {
                    arraylist.addAll(((ExposedSlotsMetricsObserver)metricevent).getSlotTokens());
                }
            } while (true);
            list = new MShopAggregatedClientMetrics();
            list.setExposedSlots(arraylist);
            return list;
        }

    };

    public ExposedSlotsMetricsObserver()
    {
    }

    public MetricsAggregator getAggregator()
    {
        return METRICS_AGGREGATOR;
    }

    public MetricsAggregator.Type getEventAggregatorType()
    {
        return MetricsAggregator.Type.ExposedSlotsMetric;
    }

}
