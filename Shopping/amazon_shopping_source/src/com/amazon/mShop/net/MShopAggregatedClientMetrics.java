// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import android.util.Log;
import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.ClientMetric;
import com.amazon.rio.j2me.client.services.mShop.ClientMetrics;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.Null;
import com.amazon.rio.j2me.client.services.mShop.PostMetricsResponseListener;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

// Referenced classes of package com.amazon.mShop.net:
//            AggregatedMetrics, MetricsSender

public class MShopAggregatedClientMetrics extends AggregatedMetrics
{

    private static final boolean DEBUG = DebugSettings.isDebugEnabled();
    private static final MetricsSender METRICS_SENDER = new MetricsSender() {

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
            if (MShopAggregatedClientMetrics.DEBUG)
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
                ServiceController.getMShopService().postMetrics(mClientMetrics, MShopAggregatedClientMetrics.sPostMetricsResponseListener);
            }
            mClientMetrics = new ClientMetrics();
        }

            
            {
                mClientMetrics = new ClientMetrics();
            }
    };
    private static final PostMetricsResponseListener sPostMetricsResponseListener = new PostMetricsResponseListener() {

        public void cancelled(ServiceCall servicecall)
        {
            if (MShopAggregatedClientMetrics.DEBUG)
            {
                Log.v("Amazon", "post metrics cancelled");
            }
        }

        public void completed(Null null1, ServiceCall servicecall)
        {
            if (MShopAggregatedClientMetrics.DEBUG)
            {
                Log.v("Amazon", "post metrics completed");
            }
        }

        public void error(Exception exception, ServiceCall servicecall)
        {
            if (MShopAggregatedClientMetrics.DEBUG)
            {
                Log.d("Amazon", (new StringBuilder()).append("post metrics failed: ").append(exception).toString());
            }
        }

    };
    private ClientMetrics mClientMetrics;

    public MShopAggregatedClientMetrics()
    {
        mClientMetrics = new ClientMetrics();
    }

    public ClientMetrics getClientMetrics()
    {
        return mClientMetrics;
    }

    public MetricsSender getMetricsSender()
    {
        return METRICS_SENDER;
    }

    public MetricsSender.SenderType getSenderType()
    {
        return MetricsSender.SenderType.MShopSender;
    }

    public void setClickedSlots(List list)
    {
        if (list != null && list.size() > 0)
        {
            mClientMetrics.setClickedSlots(new Vector(list));
        }
    }

    public void setExposedSlots(List list)
    {
        if (list != null && list.size() > 0)
        {
            mClientMetrics.setExposedSlots(new Vector(list));
        }
    }

    public void setMetrics(List list)
    {
        if (list != null && list.size() > 0)
        {
            mClientMetrics.setMetrics(new Vector(list));
        }
    }



}
