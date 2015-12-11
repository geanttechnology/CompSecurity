// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

// Referenced classes of package com.amazon.mShop.net:
//            AggregatedMetrics, MetricsSender, CookieBridge, HttpFetcher

public class RefMarkersAggregatedMetrics extends AggregatedMetrics
{

    private static final MetricsSender METRICS_SENDER = new MetricsSender() {

        private final List mRefMarkers = new ArrayList();

        public void appendAggregatedMetrics(AggregatedMetrics aggregatedmetrics)
        {
            if (aggregatedmetrics instanceof RefMarkersAggregatedMetrics)
            {
                aggregatedmetrics = (RefMarkersAggregatedMetrics)aggregatedmetrics;
                mRefMarkers.addAll(aggregatedmetrics.getRefMarkers());
            }
        }

        public void postMetrics()
        {
            if (mRefMarkers.size() == 0)
            {
                return;
            }
            String s2 = ConfigUtils.getStringForSpecificLocale(AndroidPlatform.getInstance().getApplicationContext(), com.amazon.mShop.android.lib.R.string.config_refmarker_clickstream_host, AppLocale.getInstance().getCurrentLocaleName());
            String s1 = CookieBridge.getCurrentSessionId();
            String s = s1;
            if (Util.isEmpty(s1))
            {
                s = "123-1234567-1234567";
            }
            s1 = String.format("MSH%s", new Object[] {
                RefMarkersAggregatedMetrics.getRandomRequestId()
            });
            String s3 = ConfigUtils.getStringForSpecificLocale(AndroidPlatform.getInstance().getApplicationContext(), com.amazon.mShop.android.lib.R.string.config_marketplace_obfuscated_id, AppLocale.getInstance().getCurrentLocaleName());
            HashMap hashmap = new HashMap();
            for (Iterator iterator = mRefMarkers.iterator(); iterator.hasNext();)
            {
                String s6 = (String)iterator.next();
                String s4 = s6.split(":")[0];
                s6 = s6.substring(s4.length() + 1);
                if (hashmap.containsKey(s4))
                {
                    ((List)hashmap.get(s4)).add(s6);
                } else
                {
                    ArrayList arraylist = new ArrayList();
                    arraylist.add(s6);
                    hashmap.put(s4, arraylist);
                }
            }

            StringBuffer stringbuffer = new StringBuffer();
            for (Iterator iterator1 = hashmap.keySet().iterator(); iterator1.hasNext();)
            {
                String s7 = (String)iterator1.next();
                Object obj = (List)hashmap.get(s7);
                obj = Util.join((String[])((List) (obj)).toArray(new String[((List) (obj)).size()]), ",");
                if (stringbuffer.length() > 0)
                {
                    stringbuffer.append("/").append((new StringBuilder()).append(s7).append(":").toString()).append(((String) (obj)));
                } else
                {
                    stringbuffer.append((new StringBuilder()).append(s7).append(":").toString()).append(((String) (obj)));
                }
            }

            String s5 = ConfigUtils.getStringForSpecificLocale(AndroidPlatform.getInstance().getApplicationContext(), com.amazon.mShop.android.lib.R.string.config_refmarker_marketplaceName, AppLocale.getInstance().getCurrentLocaleName());
            HttpFetcher.fetch(String.format("https://%1$s/1/action-impressions/1/OP/mshop/action/%2$s?requestId=%3$s&marketplaceId=%4$s&session=%5$s&marketplace=%6$s", new Object[] {
                s2, stringbuffer.toString(), s1, s3, s, s5
            }));
            hashmap.clear();
            mRefMarkers.clear();
        }

    };
    private final List mRefMarkers = new ArrayList();

    public RefMarkersAggregatedMetrics()
    {
    }

    private static String getRandomRequestId()
    {
        Object obj = new Random(System.currentTimeMillis());
        String s;
        for (s = ""; s.length() < 17; s = (new StringBuilder()).append(s).append(Integer.valueOf(((Random) (obj)).nextInt(0x7fffffff)).toString()).toString()) { }
        obj = s;
        if (s.length() > 17)
        {
            obj = s.substring(0, 17);
        }
        return ((String) (obj));
    }

    public MetricsSender getMetricsSender()
    {
        return METRICS_SENDER;
    }

    public List getRefMarkers()
    {
        return mRefMarkers;
    }

    public MetricsSender.SenderType getSenderType()
    {
        return MetricsSender.SenderType.RefMarkerSender;
    }

    public void setRefmarkers(List list)
    {
        mRefMarkers.addAll(list);
    }


}
