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
//            MetricsAggregator, NetworkInfoMetricObserver, MShopAggregatedClientMetrics, AggregatedMetrics

static final class  extends MetricsAggregator
{

    private String getNetworkCollectionType(String s)
    {
        if ("unknown".equals(s))
        {
            return "Unknown";
        }
        if ("Wifi".equals(s))
        {
            return "Wifi";
        } else
        {
            return "Mobile";
        }
    }

    public AggregatedMetrics aggregate(List list)
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        list = list.iterator();
_L2:
        String s;
        if (!list.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        t t = (t)list.next();
        if (!(t instanceof NetworkInfoMetricObserver))
        {
            continue; /* Loop/switch isn't completed */
        }
        synchronized ((NetworkInfoMetricObserver)t)
        {
            s = networkinfometricobserver.getPageIdentifier();
            if (!"none".equals(s) && !networkinfometricobserver.isStatusFailed())
            {
                break MISSING_BLOCK_LABEL_81;
            }
        }
        continue; /* Loop/switch isn't completed */
        list;
        networkinfometricobserver;
        JVM INSTR monitorexit ;
        throw list;
        s = String.format("%s/%s:%s", new Object[] {
            s, "Latency", getNetworkCollectionType(s)
        });
        ClientMetric clientmetric1 = new ClientMetric();
        clientmetric1.setTime(Integer.valueOf(networkinfometricobserver.getTotalTime()));
        clientmetric1.setName(s);
        clientmetric1.setCount(Integer.valueOf(1));
        arraylist.add(clientmetric1);
        networkinfometricobserver;
        JVM INSTR monitorexit ;
        if (true) goto _L2; else goto _L1
_L1:
        if (NetworkInfoMetricObserver.access$000())
        {
            Log.v(getClass().getSimpleName(), "Network collection aggregator data");
            ClientMetric clientmetric;
            for (list = arraylist.iterator(); list.hasNext(); Log.v(getClass().getSimpleName(), (new StringBuilder()).append("Network collection data name is : ").append(clientmetric.getName()).append(" time is ").append(clientmetric.getTime()).toString()))
            {
                clientmetric = (ClientMetric)list.next();
            }

        }
        list = new MShopAggregatedClientMetrics();
        list.setMetrics(arraylist);
        return list;
    }

    ()
    {
    }
}
