// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import com.amazon.rio.j2me.client.services.mShop.ClientMetric;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.net:
//            MetricsAggregator, StartupMetricsObserver, NetInfo, MShopAggregatedClientMetrics, 
//            AggregatedMetrics

static final class ics extends MetricsAggregator
{

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
        list = (vent)iterator.next();
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

    ics()
    {
    }
}
