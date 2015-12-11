// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mShop.net:
//            MetricsAggregator, ExposedSlotsMetricsObserver, MShopAggregatedClientMetrics, AggregatedMetrics

static final class  extends MetricsAggregator
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
              = ()list.next();
            if ( instanceof ExposedSlotsMetricsObserver)
            {
                arraylist.addAll(((ExposedSlotsMetricsObserver)).getSlotTokens());
            }
        } while (true);
        list = new MShopAggregatedClientMetrics();
        list.setExposedSlots(arraylist);
        return list;
    }

    ()
    {
    }
}
