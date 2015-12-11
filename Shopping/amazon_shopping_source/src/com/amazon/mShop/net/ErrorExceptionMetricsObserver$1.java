// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import android.os.Build;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.ClientMetric;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.net:
//            MetricsAggregator, ErrorExceptionMetricsObserver, NetInfo, MShopAggregatedClientMetrics, 
//            AggregatedMetrics

static final class c extends MetricsAggregator
{

    public AggregatedMetrics aggregate(List list)
    {
        ArrayList arraylist = new ArrayList();
        HashMap hashmap = new HashMap();
        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            list = (c)iterator.next();
            if (list instanceof ErrorExceptionMetricsObserver)
            {
                list = (ErrorExceptionMetricsObserver)list;
                if (ErrorExceptionMetricsObserver.access$000(list) != null)
                {
                    String s = ErrorExceptionMetricsObserver.access$100(ErrorExceptionMetricsObserver.access$000(list));
                    String s1 = String.format("%s/%s:%s", new Object[] {
                        NetInfo.getCurrentCarrierName(), "ErrorExceptionType", ErrorExceptionMetricsObserver.access$000(list).getClass().getSimpleName()
                    });
                    ClientMetric clientmetric = (ClientMetric)hashmap.get(s1);
                    StringBuilder stringbuilder = new StringBuilder();
                    stringbuilder.append("Info: { Model: ").append(Build.MODEL).append(",\n SDK: ").append(android.os.lientMetric).append(",\n Release: ").append(android.os.lientMetric);
                    if (clientmetric == null)
                    {
                        list = new ClientMetric();
                        list.setName(s1);
                        hashmap.put(s1, list);
                        if (!Util.isEmpty(s))
                        {
                            stringbuilder.append(",\n Error Message: ").append(s);
                        }
                        list.setCount(Integer.valueOf(1));
                    } else
                    {
                        clientmetric.setCount(Integer.valueOf(clientmetric.getCount().intValue() + 1));
                        if (!Util.isEmpty(s))
                        {
                            stringbuilder.append(",\n Error Message: ").append(s);
                        }
                        list = clientmetric;
                        if (!Util.isEmpty(clientmetric.getInfo()))
                        {
                            stringbuilder.insert(0, (new StringBuilder()).append(clientmetric.getInfo()).append(", ").toString());
                            list = clientmetric;
                        }
                    }
                    list.setInfo(stringbuilder.append("}").toString());
                }
            }
        }

        arraylist.addAll(hashmap.values());
        list = new MShopAggregatedClientMetrics();
        list.setMetrics(arraylist);
        return list;
    }

    c()
    {
    }
}
