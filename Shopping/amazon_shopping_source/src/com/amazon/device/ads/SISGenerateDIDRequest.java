// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            SISDeviceRequest, JSONUtils, InternalAdRegistration, IInternalAdRegistration, 
//            RegistrationInfo

class SISGenerateDIDRequest extends SISDeviceRequest
{

    private static final Metrics.MetricType CALL_METRIC_TYPE;
    private static final String LOG_TAG = "SISGenerateDIDRequest";
    private static final String PATH = "/generate_did";

    public SISGenerateDIDRequest()
    {
        setCallMetricType(CALL_METRIC_TYPE);
        setLogTag("SISGenerateDIDRequest");
        setPath("/generate_did");
    }

    public void onResponseReceived(JSONObject jsonobject)
    {
        jsonobject = JSONUtils.getStringFromJSON(jsonobject, "adId", "");
        if (jsonobject.length() > 0)
        {
            InternalAdRegistration.getInstance().getRegistrationInfo().putAdId(jsonobject, getAdvertisingIdentifierInfo());
        }
    }

    static 
    {
        CALL_METRIC_TYPE = Metrics.MetricType.SIS_LATENCY_REGISTER;
    }
}
