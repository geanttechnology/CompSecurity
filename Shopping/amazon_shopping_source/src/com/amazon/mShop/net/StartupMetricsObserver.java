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

public class StartupMetricsObserver extends MetricsAggregator.MetricEvent
{
    public static final class StartupType extends Enum
    {

        private static final StartupType $VALUES[];
        public static final StartupType PUBLIC_URL_FIRST_START;
        public static final StartupType PUBLIC_URL_START;

        public static StartupType valueOf(String s)
        {
            return (StartupType)Enum.valueOf(com/amazon/mShop/net/StartupMetricsObserver$StartupType, s);
        }

        public static StartupType[] values()
        {
            return (StartupType[])$VALUES.clone();
        }

        static 
        {
            PUBLIC_URL_START = new StartupType("PUBLIC_URL_START", 0);
            PUBLIC_URL_FIRST_START = new StartupType("PUBLIC_URL_FIRST_START", 1);
            $VALUES = (new StartupType[] {
                PUBLIC_URL_START, PUBLIC_URL_FIRST_START
            });
        }

        private StartupType(String s, int i)
        {
            super(s, i);
        }
    }


    static final MetricsAggregator METRICS_AGGREGATOR = new MetricsAggregator() {

        public AggregatedMetrics aggregate(List list)
        {
            String s1;
            ArrayList arraylist;
            HashMap hashmap;
            Iterator iterator;
            arraylist = new ArrayList();
            s1 = NetInfo.getCurrentCarrierName();
            hashmap = new HashMap();
            iterator = list.iterator();
_L4:
            if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
            list = (MetricsAggregator.MetricEvent)iterator.next();
            if (!(list instanceof StartupMetricsObserver)) goto _L4; else goto _L3
_L3:
            StartupMetricsObserver startupmetricsobserver = (StartupMetricsObserver)list;
            startupmetricsobserver;
            JVM INSTR monitorenter ;
            Object obj;
            String s;
            obj = (String)StartupMetricsObserver.sStartupPrefixMap.get(startupmetricsobserver.getStartupType());
            s = startupmetricsobserver.getMetricsType();
            if (s1 != null)
            {
                list = s1;
            } else
            {
                list = "";
            }
            break MISSING_BLOCK_LABEL_239;
_L6:
            list = String.format("%s/%s%s", new Object[] {
                list, obj, s
            });
            obj = (ClientMetric)hashmap.get(list);
            if (obj != null)
            {
                break MISSING_BLOCK_LABEL_189;
            }
            obj = new ClientMetric();
            ((ClientMetric) (obj)).setName(list);
            hashmap.put(list, obj);
            ((ClientMetric) (obj)).setCount(Integer.valueOf(1));
_L5:
            startupmetricsobserver;
            JVM INSTR monitorexit ;
              goto _L4
            list;
            startupmetricsobserver;
            JVM INSTR monitorexit ;
            throw list;
            ((ClientMetric) (obj)).setCount(Integer.valueOf(((ClientMetric) (obj)).getCount().intValue() + 1));
              goto _L5
_L2:
            arraylist.addAll(hashmap.values());
            list = new MShopAggregatedClientMetrics();
            list.setMetrics(arraylist);
            return list;
            if (obj == null)
            {
                obj = "";
            }
            if (s == null)
            {
                s = "";
            }
              goto _L6
        }

    };
    static Map sStartupPrefixMap;
    private String mMetricsType;
    private StartupType mStartupType;

    public StartupMetricsObserver(StartupType startuptype, String s)
    {
        mStartupType = startuptype;
        mMetricsType = s;
    }

    public static void logStartupMetrics(String s, StartupType startuptype)
    {
        if (!Util.isEmpty(s))
        {
            MetricsCollector.queueEvent(new StartupMetricsObserver(startuptype, s));
        }
    }

    public MetricsAggregator getAggregator()
    {
        return METRICS_AGGREGATOR;
    }

    public MetricsAggregator.Type getEventAggregatorType()
    {
        return MetricsAggregator.Type.StartupMetric;
    }

    public String getMetricsType()
    {
        return mMetricsType;
    }

    public StartupType getStartupType()
    {
        return mStartupType;
    }

    static 
    {
        sStartupPrefixMap = new HashMap();
        sStartupPrefixMap.put(StartupType.PUBLIC_URL_START, "start:");
        sStartupPrefixMap.put(StartupType.PUBLIC_URL_FIRST_START, "first-start");
    }
}
