// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            MetricsCollector, JSONUtils, Utils, AdData, 
//            InternalAdRegistration, IInternalAdRegistration, RegistrationInfo, Log, 
//            Version, WebRequest

class AdMetrics
{

    public static final String LOG_TAG = "AdMetrics";
    private AdData adData;
    private MetricsCollector globalMetrics;

    public AdMetrics(AdData addata)
    {
        adData = addata;
    }

    protected static void addMetricsToJSON(JSONObject jsonobject, MetricsCollector metricscollector)
    {
        if (metricscollector != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj = new HashMap();
        HashMap hashmap = new HashMap();
        String s1 = metricscollector.getAdTypeMetricTag();
        String s = s1;
        if (s1 != null)
        {
            s = (new StringBuilder()).append(s1).append("_").toString();
        }
        MetricsCollector.MetricHit ametrichit[] = (MetricsCollector.MetricHit[])metricscollector.getMetricHits().toArray(new MetricsCollector.MetricHit[metricscollector.getMetricHits().size()]);
        int k = ametrichit.length;
        int i = 0;
        while (i < k) 
        {
            Object obj1 = ametrichit[i];
            String s2 = ((MetricsCollector.MetricHit) (obj1)).metric.getAaxName();
            metricscollector = s2;
            if (s != null)
            {
                metricscollector = s2;
                if (((MetricsCollector.MetricHit) (obj1)).metric.isAdTypeSpecific())
                {
                    metricscollector = (new StringBuilder()).append(s).append(s2).toString();
                }
            }
            if (obj1 instanceof MetricsCollector.MetricHitStartTime)
            {
                metricscollector = (MetricsCollector.MetricHitStartTime)obj1;
                ((HashMap) (obj)).put(((MetricsCollector.MetricHit) (obj1)).metric, Long.valueOf(((MetricsCollector.MetricHitStartTime) (metricscollector)).startTime));
            } else
            if (obj1 instanceof MetricsCollector.MetricHitStopTime)
            {
                MetricsCollector.MetricHitStopTime metrichitstoptime = (MetricsCollector.MetricHitStopTime)obj1;
                obj1 = (Long)((HashMap) (obj)).get(((MetricsCollector.MetricHit) (obj1)).metric);
                if (obj1 != null)
                {
                    JSONUtils.put(jsonobject, metricscollector, metrichitstoptime.stopTime - ((Long) (obj1)).longValue());
                }
            } else
            if (obj1 instanceof MetricsCollector.MetricHitTotalTime)
            {
                JSONUtils.put(jsonobject, metricscollector, ((MetricsCollector.MetricHitTotalTime)obj1).totalTime);
            } else
            if (obj1 instanceof MetricsCollector.MetricHitIncrement)
            {
                metricscollector = (MetricsCollector.MetricHitIncrement)obj1;
                Integer integer = (Integer)hashmap.get(((MetricsCollector.MetricHit) (obj1)).metric);
                int j;
                if (integer == null)
                {
                    j = ((MetricsCollector.MetricHitIncrement) (metricscollector)).increment;
                } else
                {
                    j = integer.intValue() + ((MetricsCollector.MetricHitIncrement) (metricscollector)).increment;
                }
                hashmap.put(((MetricsCollector.MetricHit) (obj1)).metric, Integer.valueOf(j));
            } else
            if (obj1 instanceof MetricsCollector.MetricHitString)
            {
                JSONUtils.put(jsonobject, metricscollector, ((MetricsCollector.MetricHitString)obj1).text);
            }
            i++;
        }
        obj = hashmap.entrySet().iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
            String s3 = ((Metrics.MetricType)entry.getKey()).getAaxName();
            metricscollector = s3;
            if (s != null)
            {
                metricscollector = s3;
                if (((Metrics.MetricType)entry.getKey()).isAdTypeSpecific())
                {
                    metricscollector = (new StringBuilder()).append(s).append(s3).toString();
                }
            }
            JSONUtils.put(jsonobject, metricscollector, ((Integer)entry.getValue()).intValue());
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private String getAaxUrlAndResetAdMetrics()
    {
        String s = Utils.getURLEncodedString(getAaxJson());
        s = (new StringBuilder()).append(adData.getInstrumentationPixelUrl()).append(s).toString();
        adData.resetMetricsCollector();
        return s;
    }

    public void addGlobalMetrics(MetricsCollector metricscollector)
    {
        globalMetrics = metricscollector;
    }

    public boolean canSubmit()
    {
        String s;
        if (adData != null)
        {
            if ((s = adData.getInstrumentationPixelUrl()) != null && !s.equals(""))
            {
                String s1 = InternalAdRegistration.getInstance().getRegistrationInfo().getAppKey();
                if (s1 == null || s1.equals("123"))
                {
                    Log.d("AdMetrics", "Not submitting metrics because the AppKey is either not set or set to a test key.");
                    return false;
                } else
                {
                    return true;
                }
            }
        }
        return false;
    }

    protected String getAaxJson()
    {
        Object obj = new JSONObject();
        JSONUtils.put(((JSONObject) (obj)), "c", "msdk");
        JSONUtils.put(((JSONObject) (obj)), "v", Version.getRawSDKVersion());
        addMetricsToJSON(((JSONObject) (obj)), adData.getMetricsCollector());
        addMetricsToJSON(((JSONObject) (obj)), globalMetrics);
        obj = ((JSONObject) (obj)).toString();
        return ((String) (obj)).substring(1, ((String) (obj)).length() - 1);
    }

    public WebRequest getAaxWebRequestAndResetAdMetrics()
    {
        WebRequest webrequest = WebRequest.createNewWebRequest();
        webrequest.setUrlString(getAaxUrlAndResetAdMetrics());
        return webrequest;
    }
}
