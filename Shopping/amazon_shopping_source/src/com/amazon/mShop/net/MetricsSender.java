// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.net:
//            AggregatedMetrics

public abstract class MetricsSender
{
    public static final class SenderType extends Enum
    {

        private static final SenderType $VALUES[];
        public static final SenderType MShopSender;
        public static final SenderType RefMarkerSender;

        public static SenderType valueOf(String s)
        {
            return (SenderType)Enum.valueOf(com/amazon/mShop/net/MetricsSender$SenderType, s);
        }

        public static SenderType[] values()
        {
            return (SenderType[])$VALUES.clone();
        }

        static 
        {
            MShopSender = new SenderType("MShopSender", 0);
            RefMarkerSender = new SenderType("RefMarkerSender", 1);
            $VALUES = (new SenderType[] {
                MShopSender, RefMarkerSender
            });
        }

        private SenderType(String s, int i)
        {
            super(s, i);
        }
    }


    private static Map sMetricsSenderMap = new HashMap();

    public MetricsSender()
    {
    }

    public static MetricsSender getMetricsSenderByType(SenderType sendertype)
    {
        return (MetricsSender)sMetricsSenderMap.get(sendertype);
    }

    public static void postAllMetrics(List list)
    {
        AggregatedMetrics aggregatedmetrics;
        for (list = list.iterator(); list.hasNext(); aggregatedmetrics.getMetricsSender().appendAggregatedMetrics(aggregatedmetrics))
        {
            aggregatedmetrics = (AggregatedMetrics)list.next();
        }

        for (list = sMetricsSenderMap.values().iterator(); list.hasNext(); ((MetricsSender)list.next()).postMetrics()) { }
    }

    public static void registerMetricsSender(SenderType sendertype, MetricsSender metricssender)
    {
        sMetricsSenderMap.put(sendertype, metricssender);
    }

    public abstract void appendAggregatedMetrics(AggregatedMetrics aggregatedmetrics);

    public abstract void postMetrics();

}
