// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import android.util.Log;
import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.ClientMetric;
import com.amazon.rio.j2me.client.services.mShop.ClientMetrics;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

// Referenced classes of package com.amazon.mShop.net:
//            MetricsSender, MShopAggregatedClientMetrics, AggregatedMetrics

static final class ics extends MetricsSender
{

    private ClientMetrics mClientMetrics;

    private void appendClickedSlots(List list)
    {
        if (Util.isEmpty(mClientMetrics.getClickedSlots()))
        {
            mClientMetrics.setClickedSlots(new Vector());
        }
        mClientMetrics.getClickedSlots().addAll(list);
    }

    private void appendClientMetrics(List list)
    {
        if (Util.isEmpty(mClientMetrics.getMetrics()))
        {
            mClientMetrics.setMetrics(new Vector());
        }
        mClientMetrics.getMetrics().addAll(list);
    }

    private void appendExposedSlots(List list)
    {
        if (Util.isEmpty(mClientMetrics.getExposedSlots()))
        {
            mClientMetrics.setExposedSlots(new Vector());
        }
        mClientMetrics.getExposedSlots().addAll(list);
    }

    public void appendAggregatedMetrics(AggregatedMetrics aggregatedmetrics)
    {
        if (aggregatedmetrics instanceof MShopAggregatedClientMetrics)
        {
            aggregatedmetrics = ((MShopAggregatedClientMetrics)aggregatedmetrics).getClientMetrics();
            if (!Util.isEmpty(aggregatedmetrics.getMetrics()))
            {
                appendClientMetrics(aggregatedmetrics.getMetrics());
            }
            if (!Util.isEmpty(aggregatedmetrics.getExposedSlots()))
            {
                appendExposedSlots(aggregatedmetrics.getExposedSlots());
            }
            if (!Util.isEmpty(aggregatedmetrics.getClickedSlots()))
            {
                appendClickedSlots(aggregatedmetrics.getClickedSlots());
            }
        }
    }

    public void postMetrics()
    {
        if (MShopAggregatedClientMetrics.access$000())
        {
            if (mClientMetrics.getMetrics() != null)
            {
                ClientMetric clientmetric;
                for (Iterator iterator = mClientMetrics.getMetrics().iterator(); iterator.hasNext(); Log.v("Amazon", (new StringBuilder()).append(" -> ").append(clientmetric.getName()).append(" count:").append(clientmetric.getCount()).append(" size:").append(clientmetric.getSize()).append(" time:").append(clientmetric.getTime()).append(" info:").append(clientmetric.getInfo()).toString()))
                {
                    clientmetric = (ClientMetric)iterator.next();
                }

            }
            if (mClientMetrics.getClickedSlots() != null)
            {
                Log.d("Amazon", "clickedSlots metric:");
                for (Iterator iterator1 = mClientMetrics.getClickedSlots().iterator(); iterator1.hasNext(); Log.v("Amazon", (String)iterator1.next())) { }
            }
            if (mClientMetrics.getExposedSlots() != null)
            {
                Log.d("Amazon", "exposedSlots metric:");
                for (Iterator iterator2 = mClientMetrics.getExposedSlots().iterator(); iterator2.hasNext(); Log.v("Amazon", (String)iterator2.next())) { }
            }
        }
        if (!Util.isEmpty(mClientMetrics.getClickedSlots()) || !Util.isEmpty(mClientMetrics.getExposedSlots()) || !Util.isEmpty(mClientMetrics.getMetrics()))
        {
            ServiceController.getMShopService().postMetrics(mClientMetrics, MShopAggregatedClientMetrics.access$100());
        }
        mClientMetrics = new ClientMetrics();
    }

    ics()
    {
        mClientMetrics = new ClientMetrics();
    }
}
