// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            SISDeviceRequest, DebugProperties, StringUtils, JSONUtils, 
//            Metrics, MetricsCollector, MobileAdsInfoStore, RegistrationInfo

class SISUpdateDeviceInfoRequest extends SISDeviceRequest
{

    private static final Metrics.MetricType CALL_METRIC_TYPE;
    private static final String LOGTAG = "SISUpdateDeviceInfoRequest";
    private static final String PATH = "/update_dev_info";

    public SISUpdateDeviceInfoRequest()
    {
        setCallMetricType(CALL_METRIC_TYPE);
        setLogTag("SISUpdateDeviceInfoRequest");
        setPath("/update_dev_info");
    }

    public WebRequest.QueryStringParameters getQueryParameters()
    {
        String s = DebugProperties.getInstance().getDebugPropertyAsString("debug.adid", getAdvertisingIdentifierInfo().getSISDeviceIdentifier());
        WebRequest.QueryStringParameters querystringparameters = super.getQueryParameters();
        if (!StringUtils.isNullOrEmpty(s))
        {
            querystringparameters.putUrlEncoded("adId", s);
        }
        return querystringparameters;
    }

    public void onResponseReceived(JSONObject jsonobject)
    {
        String s = JSONUtils.getStringFromJSON(jsonobject, "adId", "");
        if (JSONUtils.getBooleanFromJSON(jsonobject, "idChanged", false))
        {
            Metrics.getInstance().getMetricsCollector().incrementMetric(Metrics.MetricType.SIS_COUNTER_IDENTIFIED_DEVICE_CHANGED);
        }
        if (s.length() > 0)
        {
            MobileAdsInfoStore.getInstance().getRegistrationInfo().putAdId(s, getAdvertisingIdentifierInfo());
        }
    }

    static 
    {
        CALL_METRIC_TYPE = Metrics.MetricType.SIS_LATENCY_UPDATE_DEVICE_INFO;
    }
}
