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
import java.util.Set;

// Referenced classes of package com.amazon.mShop.net:
//            BaseMetricsObserver, MetricsAggregator, ServiceCallIdentifier, NetInfo, 
//            MShopAggregatedClientMetrics, AggregatedMetrics

public class CallObserver extends BaseMetricsObserver
{
    private static class AvailabilityCounter
    {

        String errors;
        int successCount;
        int totalCount;

        private AvailabilityCounter()
        {
        }

    }

    private static class CacheHitCounter
    {

        int hitCount;
        int totalCount;

        private CacheHitCounter()
        {
        }

    }


    static final MetricsAggregator METRICS_AGGREGATOR = new MetricsAggregator() {

        public AggregatedMetrics aggregate(List list)
        {
            ArrayList arraylist;
            String s;
            HashMap hashmap;
            HashMap hashmap1;
            HashMap hashmap2;
            s = NetInfo.getCurrentCarrierName();
            hashmap1 = new HashMap();
            hashmap2 = new HashMap();
            hashmap = new HashMap();
            arraylist = new ArrayList();
            list = list.iterator();
_L15:
            Object obj2;
            if (!list.hasNext())
            {
                break MISSING_BLOCK_LABEL_613;
            }
            obj2 = (MetricsAggregator.MetricEvent)list.next();
            if (!(obj2 instanceof CallObserver))
            {
                continue; /* Loop/switch isn't completed */
            }
            obj2 = (CallObserver)obj2;
            obj2;
            JVM INSTR monitorenter ;
            String s1;
            Object obj3;
            String s2;
            ClientMetric clientmetric2;
            obj3 = ((CallObserver) (obj2)).getServiceCallIdentifier();
            s1 = ((ServiceCallIdentifier) (obj3)).getServiceName();
            obj3 = ((ServiceCallIdentifier) (obj3)).getMethodName();
            s2 = (new StringBuilder()).append(s).append("/").append(s1).append("/").append(((String) (obj3))).append("/Time").toString();
            clientmetric2 = (ClientMetric)hashmap1.get(s2);
            if (clientmetric2 != null) goto _L2; else goto _L1
_L1:
            clientmetric2 = new ClientMetric();
            clientmetric2.setName(s2);
            hashmap1.put(s2, clientmetric2);
            clientmetric2.setCount(Integer.valueOf(1));
            clientmetric2.setTime(Integer.valueOf(((CallObserver) (obj2)).getTotalTime()));
_L7:
            boolean flag;
            s1 = (new StringBuilder()).append(s1).append("/").append(((String) (obj3))).toString();
            flag = ((CallObserver) (obj2)).isStatusFailed();
            obj3 = (AvailabilityCounter)hashmap2.get(s1);
            if (obj3 != null) goto _L4; else goto _L3
_L3:
            obj3 = new AvailabilityCounter();
            obj3.totalCount = 1;
            int i;
            int j;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 1;
            }
            obj3.successCount = i;
            obj3.errors = ((CallObserver) (obj2)).getErrorMessage();
            hashmap2.put(s1, obj3);
_L9:
            flag = ((CallObserver) (obj2)).getCacheHit();
            obj3 = (CacheHitCounter)hashmap.get(s1);
            if (obj3 != null) goto _L6; else goto _L5
_L5:
            obj3 = new CacheHitCounter();
            obj3.totalCount = 1;
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            obj3.hitCount = i;
            hashmap.put(s1, obj3);
_L13:
            obj2;
            JVM INSTR monitorexit ;
            continue; /* Loop/switch isn't completed */
            list;
            obj2;
            JVM INSTR monitorexit ;
            throw list;
_L2:
            clientmetric2.setCount(Integer.valueOf(clientmetric2.getCount().intValue() + 1));
            clientmetric2.setTime(Integer.valueOf(clientmetric2.getTime().intValue() + ((CallObserver) (obj2)).getTotalTime()));
              goto _L7
_L4:
            obj3.totalCount = ((AvailabilityCounter) (obj3)).totalCount + 1;
            j = ((AvailabilityCounter) (obj3)).successCount;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 1;
            }
            obj3.successCount = i + j;
            s2 = ((CallObserver) (obj2)).getErrorMessage();
            if (Util.isEmpty(s2)) goto _L9; else goto _L8
_L8:
            if (!Util.isEmpty(((AvailabilityCounter) (obj3)).errors)) goto _L11; else goto _L10
_L10:
            obj3.errors = s2;
              goto _L9
_L11:
            if (s2.equals(((AvailabilityCounter) (obj3)).errors)) goto _L9; else goto _L12
_L12:
            obj3.errors = (new StringBuilder()).append(((AvailabilityCounter) (obj3)).errors).append(",").append(s2).toString();
              goto _L9
_L6:
            obj3.totalCount = ((CacheHitCounter) (obj3)).totalCount + 1;
            j = ((CacheHitCounter) (obj3)).hitCount;
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            obj3.hitCount = i + j;
              goto _L13
            arraylist.addAll(hashmap1.values());
            ClientMetric clientmetric1;
            for (list = hashmap2.entrySet().iterator(); list.hasNext(); arraylist.add(clientmetric1))
            {
                Object obj1 = (java.util.Map.Entry)list.next();
                AvailabilityCounter availabilitycounter = (AvailabilityCounter)((java.util.Map.Entry) (obj1)).getValue();
                obj1 = (new StringBuilder()).append(s).append("/").append((String)((java.util.Map.Entry) (obj1)).getKey()).append("/availability:critical").toString();
                clientmetric1 = new ClientMetric();
                clientmetric1.setName(((String) (obj1)));
                clientmetric1.setCount(Integer.valueOf((availabilitycounter.successCount * 100) / availabilitycounter.totalCount));
                clientmetric1.setInfo(availabilitycounter.errors);
            }

            ClientMetric clientmetric;
            for (list = hashmap.entrySet().iterator(); list.hasNext(); arraylist.add(clientmetric))
            {
                Object obj = (java.util.Map.Entry)list.next();
                CacheHitCounter cachehitcounter = (CacheHitCounter)((java.util.Map.Entry) (obj)).getValue();
                obj = (new StringBuilder()).append(s).append("/").append((String)((java.util.Map.Entry) (obj)).getKey()).append("/cacheHit").toString();
                clientmetric = new ClientMetric();
                clientmetric.setName(((String) (obj)));
                clientmetric.setCount(Integer.valueOf((cachehitcounter.hitCount * 100) / cachehitcounter.totalCount));
            }

            list = new MShopAggregatedClientMetrics();
            list.setMetrics(arraylist);
            return list;
            if (true) goto _L15; else goto _L14
_L14:
        }

    };
    private boolean mCacheHit;
    private final ServiceCallIdentifier mServiceCallIdentifier;

    public CallObserver(ServiceCallIdentifier servicecallidentifier)
    {
        mCacheHit = false;
        mServiceCallIdentifier = servicecallidentifier;
    }

    public static CallObserver start(ServiceCallIdentifier servicecallidentifier)
    {
        servicecallidentifier = new CallObserver(servicecallidentifier);
        servicecallidentifier.onStart();
        return servicecallidentifier;
    }

    public MetricsAggregator getAggregator()
    {
        return METRICS_AGGREGATOR;
    }

    public boolean getCacheHit()
    {
        return mCacheHit;
    }

    public MetricsAggregator.Type getEventAggregatorType()
    {
        return MetricsAggregator.Type.CallMetric;
    }

    public ServiceCallIdentifier getServiceCallIdentifier()
    {
        return mServiceCallIdentifier;
    }

    public void setCacheHit(boolean flag)
    {
        mCacheHit = flag;
    }

}
