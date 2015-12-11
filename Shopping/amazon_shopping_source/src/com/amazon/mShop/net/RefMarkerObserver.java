// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mShop.net:
//            MetricsCollector, MetricsAggregator, RefMarkersAggregatedMetrics, AggregatedMetrics

public class RefMarkerObserver extends MetricsAggregator.MetricEvent
{

    static final MetricsAggregator METRICS_AGGREGATOR = new MetricsAggregator() {

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
                Object obj = (MetricsAggregator.MetricEvent)list.next();
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

    };
    private String mRefMarker;

    private RefMarkerObserver(String s)
    {
        if (s.split(":").length > 1)
        {
            mRefMarker = s;
            return;
        } else
        {
            String s1 = ConfigUtils.getStringForApp(AndroidPlatform.getInstance().getApplicationContext(), com.amazon.mShop.android.lib.R.string.config_refmarker_platform_specific_prefix);
            mRefMarker = (new StringBuilder()).append("msh_:").append(s1).append(s).toString();
            return;
        }
    }

    public static void logRefMarker(String s)
    {
        if (!Util.isEmpty(s) && ConfigUtils.isEnabledForApp(AndroidPlatform.getInstance().getApplicationContext(), com.amazon.mShop.android.lib.R.bool.config_postRefMarker))
        {
            MetricsCollector.queueEvent(new RefMarkerObserver(s.toLowerCase()));
        }
    }

    public MetricsAggregator getAggregator()
    {
        return METRICS_AGGREGATOR;
    }

    public MetricsAggregator.Type getEventAggregatorType()
    {
        return MetricsAggregator.Type.RefMarkerMetric;
    }

    public String getRefMarker()
    {
        return mRefMarker;
    }

}
