// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import com.amazon.mShop.util.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mShop.net:
//            MetricsAggregator, RefMarkerObserver, RefMarkersAggregatedMetrics, AggregatedMetrics

static final class Metrics extends MetricsAggregator
{

    public AggregatedMetrics aggregate(List list)
    {
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Object obj = (tricEvent)list.next();
            if (obj instanceof RefMarkerObserver)
            {
                obj = ((RefMarkerObserver)obj).getRefMarker();
                if (!Util.isEmpty(((String) (obj))))
                {
                    arraylist.add(obj);
                }
            }
        } while (true);
        list = new RefMarkersAggregatedMetrics();
        list.setRefmarkers(arraylist);
        return list;
    }

    Metrics()
    {
    }
}
