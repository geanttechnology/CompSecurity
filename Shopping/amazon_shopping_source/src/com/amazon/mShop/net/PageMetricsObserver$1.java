// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import android.util.Log;
import com.amazon.rio.j2me.client.services.mShop.ClientMetric;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mShop.net:
//            MetricsAggregator, PageMetricsObserver, NetInfo, MShopAggregatedClientMetrics, 
//            AggregatedMetrics

static final class etrics extends MetricsAggregator
{

    public AggregatedMetrics aggregate(List list)
    {
        ArrayList arraylist;
        String s;
        Iterator iterator;
        arraylist = new ArrayList();
        s = NetInfo.getCurrentCarrierName();
        iterator = list.iterator();
_L2:
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_204;
            }
            list = (icEvent)iterator.next();
        } while (!(list instanceof PageMetricsObserver));
        PageMetricsObserver pagemetricsobserver = (PageMetricsObserver)list;
        pagemetricsobserver;
        JVM INSTR monitorenter ;
        Object obj = pagemetricsobserver.getPageIdentifier();
        if (pagemetricsobserver.isStatusFailed())
        {
            list = "Failed";
        } else
        {
            list = "Latency";
        }
        list = String.format("%s/%s:%s", new Object[] {
            s, list, obj
        });
        if (PageMetricsObserver.access$000())
        {
            Log.i("PageLatencyTest", (new StringBuilder()).append(list).append(":").append(String.valueOf(pagemetricsobserver.getTotalTime())).toString());
        }
        obj = new ClientMetric();
        ((ClientMetric) (obj)).setName(list);
        ((ClientMetric) (obj)).setCount(Integer.valueOf(1));
        ((ClientMetric) (obj)).setTime(Integer.valueOf(pagemetricsobserver.getTotalTime()));
        arraylist.add(obj);
        pagemetricsobserver;
        JVM INSTR monitorexit ;
        if (true) goto _L2; else goto _L1
_L1:
        list;
        pagemetricsobserver;
        JVM INSTR monitorexit ;
        throw list;
        list = new MShopAggregatedClientMetrics();
        list.setMetrics(arraylist);
        return list;
    }

    etrics()
    {
    }
}
