// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import com.amazon.rio.j2me.client.services.mShop.ClientMetric;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.net:
//            MetricsAggregator, CountMetricObserver, NetInfo, MShopAggregatedClientMetrics, 
//            AggregatedMetrics

static final class etrics extends MetricsAggregator
{

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
        list = (icEvent)iterator.next();
        if (!(list instanceof CountMetricObserver)) goto _L4; else goto _L3
_L3:
        CountMetricObserver countmetricobserver = (CountMetricObserver)list;
        countmetricobserver;
        JVM INSTR monitorenter ;
        Object obj;
        String s;
        int i;
        obj = (String)CountMetricObserver.access$100().get(CountMetricObserver.access$000(countmetricobserver));
        s = CountMetricObserver.access$200(countmetricobserver);
        i = CountMetricObserver.access$300(countmetricobserver);
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

    etrics()
    {
    }
}
