// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            SISRequest, DeviceInfo, InternalAdRegistration, IInternalAdRegistration, 
//            RegistrationInfo, Configuration, JSONUtils, Log, 
//            AppEventRegistrationHandler

class SISRegisterEventRequest
    implements SISRequest
{

    private static final Metrics.MetricType CALL_METRIC_TYPE;
    private static final String LOG_TAG = "SISRegisterEventRequest";
    private static final String PATH = "/register_event";
    private final AdvertisingIdentifier.Info advertisingIdentifierInfo;
    private final JSONArray appEvents;

    public SISRegisterEventRequest(AdvertisingIdentifier.Info info, JSONArray jsonarray)
    {
        advertisingIdentifierInfo = info;
        appEvents = jsonarray;
    }

    public Metrics.MetricType getCallMetricType()
    {
        return CALL_METRIC_TYPE;
    }

    public String getLogTag()
    {
        return "SISRegisterEventRequest";
    }

    public String getPath()
    {
        return "/register_event";
    }

    public HashMap getPostParameters()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("events", appEvents.toString());
        return hashmap;
    }

    public WebRequest.QueryStringParameters getQueryParameters()
    {
        WebRequest.QueryStringParameters querystringparameters = new WebRequest.QueryStringParameters();
        querystringparameters.putUrlEncoded("adId", advertisingIdentifierInfo.getSISDeviceIdentifier());
        querystringparameters.putUrlEncoded("dt", DeviceInfo.getDeviceType());
        RegistrationInfo registrationinfo = InternalAdRegistration.getInstance().getRegistrationInfo();
        querystringparameters.putUrlEncoded("app", registrationinfo.getAppName());
        querystringparameters.putUrlEncoded("appId", registrationinfo.getAppKey());
        querystringparameters.putUrlEncoded("aud", Configuration.getInstance().getString(Configuration.ConfigOption.SIS_DOMAIN));
        return querystringparameters;
    }

    public void onResponseReceived(JSONObject jsonobject)
    {
        int i = JSONUtils.getIntegerFromJSON(jsonobject, "rcode", 0);
        if (i == 1)
        {
            Log.d("SISRegisterEventRequest", "Application events registered successfully.");
            AppEventRegistrationHandler.getInstance().onAppEventsRegistered();
            return;
        } else
        {
            Log.d("SISRegisterEventRequest", (new StringBuilder()).append("Application events not registered. rcode:").append(i).toString());
            return;
        }
    }

    static 
    {
        CALL_METRIC_TYPE = Metrics.MetricType.SIS_LATENCY_REGISTER_EVENT;
    }
}
