// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.mShop.net:
//            AggregatedMetrics

public abstract class MetricsAggregator
{
    public static abstract class MetricEvent
    {

        public abstract MetricsAggregator getAggregator();

        public abstract Type getEventAggregatorType();

        public MetricEvent()
        {
            if (MetricsAggregator.getAggregatorForType(getEventAggregatorType()) == null)
            {
                MetricsAggregator.registerAggregator(getEventAggregatorType(), getAggregator());
            }
        }
    }

    public static final class Type extends Enum
    {

        private static final Type $VALUES[];
        public static final Type CallMetric;
        public static final Type ClickedSlotsMetric;
        public static final Type CountMetric;
        public static final Type ErrorExceptionMetric;
        public static final Type ExposedSlotsMetric;
        public static final Type NetworkInfoMetric;
        public static final Type OrientationMetric;
        public static final Type PageMetric;
        public static final Type RefMarkerMetric;
        public static final Type StartupMetric;

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/amazon/mShop/net/MetricsAggregator$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])$VALUES.clone();
        }

        static 
        {
            CallMetric = new Type("CallMetric", 0);
            PageMetric = new Type("PageMetric", 1);
            ExposedSlotsMetric = new Type("ExposedSlotsMetric", 2);
            ClickedSlotsMetric = new Type("ClickedSlotsMetric", 3);
            ErrorExceptionMetric = new Type("ErrorExceptionMetric", 4);
            OrientationMetric = new Type("OrientationMetric", 5);
            RefMarkerMetric = new Type("RefMarkerMetric", 6);
            StartupMetric = new Type("StartupMetric", 7);
            CountMetric = new Type("CountMetric", 8);
            NetworkInfoMetric = new Type("NetworkInfoMetric", 9);
            $VALUES = (new Type[] {
                CallMetric, PageMetric, ExposedSlotsMetric, ClickedSlotsMetric, ErrorExceptionMetric, OrientationMetric, RefMarkerMetric, StartupMetric, CountMetric, NetworkInfoMetric
            });
        }

        private Type(String s, int i)
        {
            super(s, i);
        }
    }


    public static Map sMetricsAggregatorMap = new HashMap();

    public MetricsAggregator()
    {
    }

    static List aggregate(Collection collection)
    {
        HashMap hashmap = new HashMap();
        MetricEvent metricevent;
        for (Iterator iterator1 = collection.iterator(); iterator1.hasNext(); collection.add(metricevent))
        {
            metricevent = (MetricEvent)iterator1.next();
            Type type = metricevent.getEventAggregatorType();
            List list = (List)hashmap.get(type);
            collection = list;
            if (list == null)
            {
                collection = new ArrayList();
                hashmap.put(type, collection);
            }
        }

        collection = new ArrayList();
        Iterator iterator = hashmap.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (java.util.Map.Entry)iterator.next();
            obj = getAggregatorForType((Type)((java.util.Map.Entry) (obj)).getKey()).aggregate((List)((java.util.Map.Entry) (obj)).getValue());
            if (obj != null)
            {
                collection.add(obj);
            }
        } while (true);
        return collection;
    }

    public static MetricsAggregator getAggregatorForType(Type type)
    {
        synchronized (sMetricsAggregatorMap)
        {
            type = (MetricsAggregator)sMetricsAggregatorMap.get(type);
        }
        return type;
        type;
        map;
        JVM INSTR monitorexit ;
        throw type;
    }

    public static void registerAggregator(Type type, MetricsAggregator metricsaggregator)
    {
        synchronized (sMetricsAggregatorMap)
        {
            sMetricsAggregatorMap.put(type, metricsaggregator);
        }
        return;
        type;
        map;
        JVM INSTR monitorexit ;
        throw type;
    }

    public abstract AggregatedMetrics aggregate(List list);

}
