// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.ClientMetric;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.net:
//            MetricsCollector, MetricsAggregator, NetInfo, MShopAggregatedClientMetrics, 
//            AggregatedMetrics

public class CountMetricObserver extends MetricsAggregator.MetricEvent
{
    public static final class MetricType extends Enum
    {

        private static final MetricType $VALUES[];
        public static final MetricType FLOW_SCAN;

        public static MetricType valueOf(String s)
        {
            return (MetricType)Enum.valueOf(com/amazon/mShop/net/CountMetricObserver$MetricType, s);
        }

        public static MetricType[] values()
        {
            return (MetricType[])$VALUES.clone();
        }

        static 
        {
            FLOW_SCAN = new MetricType("FLOW_SCAN", 0);
            $VALUES = (new MetricType[] {
                FLOW_SCAN
            });
        }

        private MetricType(String s, int i)
        {
            super(s, i);
        }
    }


    static final MetricsAggregator METRICS_AGGREGATOR = new MetricsAggregator() {

        public AggregatedMetrics aggregate(List list)
        {
            String s1;
            ArrayList arraylist;
            Iterator iterator;
            arraylist = new ArrayList();
            s1 = NetInfo.getCurrentCarrierName();
            iterator = list.iterator();
_L4:
            if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
            list = (MetricsAggregator.MetricEvent)iterator.next();
            if (!(list instanceof CountMetricObserver)) goto _L4; else goto _L3
_L3:
            CountMetricObserver countmetricobserver = (CountMetricObserver)list;
            countmetricobserver;
            JVM INSTR monitorenter ;
            Object obj;
            String s;
            int i;
            obj = (String)CountMetricObserver.sMetricPrefixMap.get(countmetricobserver.getMetricType());
            s = countmetricobserver.getMetric();
            i = countmetricobserver.getCount();
            break MISSING_BLOCK_LABEL_89;
_L5:
            list = String.format("%s/%s%s", new Object[] {
                list, obj, s
            });
            obj = new ClientMetric();
            ((ClientMetric) (obj)).setName(list);
            ((ClientMetric) (obj)).setCount(Integer.valueOf(i));
            arraylist.add(obj);
            countmetricobserver;
            JVM INSTR monitorexit ;
              goto _L4
            list;
            countmetricobserver;
            JVM INSTR monitorexit ;
            throw list;
_L6:
            s = "";
            break; /* Loop/switch isn't completed */
_L2:
            list = new MShopAggregatedClientMetrics();
            list.setMetrics(arraylist);
            return list;
            if (s1 != null)
            {
                list = s1;
            } else
            {
                list = "";
            }
            if (obj == null)
            {
                obj = "";
            }
            if (s == null) goto _L6; else goto _L5
        }

    };
    private static Map sMetricPrefixMap;
    private int mCount;
    private String mMetric;
    private MetricType mMetricType;

    public CountMetricObserver(MetricType metrictype, String s, int i)
    {
        mMetricType = metrictype;
        mMetric = s;
        mCount = i;
    }

    private int getCount()
    {
        return mCount;
    }

    private String getMetric()
    {
        return mMetric;
    }

    private MetricType getMetricType()
    {
        return mMetricType;
    }

    public static void logCountMetrics(MetricType metrictype, String s, int i)
    {
        if (!Util.isEmpty(s) && i > 0)
        {
            MetricsCollector.queueEvent(new CountMetricObserver(metrictype, s, i));
        }
    }

    public MetricsAggregator getAggregator()
    {
        return METRICS_AGGREGATOR;
    }

    public MetricsAggregator.Type getEventAggregatorType()
    {
        return MetricsAggregator.Type.CountMetric;
    }

    static 
    {
        sMetricPrefixMap = new HashMap();
        sMetricPrefixMap.put(MetricType.FLOW_SCAN, "Scan:");
    }




}
