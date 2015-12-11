// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.device.ads:
//            Configuration, SISRequest, WebRequest, JSONUtils, 
//            Log, InternalAdRegistration, IInternalAdRegistration, RegistrationInfo, 
//            Version, Metrics, SISRequestorCallback

class SISRequestor
{

    protected static final String API_LEVEL_ENDPOINT = "/api3";
    private final SISRequestorCallback sisRequestorCallback;
    private final SISRequest sisRequests[];

    public transient SISRequestor(SISRequestorCallback sisrequestorcallback, SISRequest asisrequest[])
    {
        sisRequestorCallback = sisrequestorcallback;
        sisRequests = asisrequest;
    }

    public transient SISRequestor(SISRequest asisrequest[])
    {
        this(null, asisrequest);
    }

    protected static String getEndpoint(SISRequest sisrequest)
    {
        String s1 = Configuration.getInstance().getString(Configuration.ConfigOption.SIS_URL);
        String s = s1;
        if (s1 != null)
        {
            int i = s1.indexOf("/");
            if (i > -1)
            {
                s = s1.substring(i);
            } else
            {
                s = "";
            }
        }
        return (new StringBuilder()).append(s).append("/api3").append(sisrequest.getPath()).toString();
    }

    protected static String getHostname()
    {
        String s1 = Configuration.getInstance().getString(Configuration.ConfigOption.SIS_URL);
        String s = s1;
        if (s1 != null)
        {
            int i = s1.indexOf("/");
            s = s1;
            if (i > -1)
            {
                s = s1.substring(0, i);
            }
        }
        return s;
    }

    protected void callSIS()
    {
        SISRequest asisrequest[] = sisRequests;
        int j = asisrequest.length;
        for (int i = 0; i < j; i++)
        {
            callSIS(asisrequest[i]);
        }

    }

    protected void callSIS(SISRequest sisrequest)
    {
        Object obj = getWebRequest(sisrequest);
        try
        {
            obj = ((WebRequest) (obj)).makeCall();
        }
        // Misplaced declaration of an exception variable
        catch (SISRequest sisrequest)
        {
            return;
        }
        obj = ((WebRequest.WebResponse) (obj)).getJSONObjectBody();
        if (obj == null)
        {
            return;
        }
        int i = JSONUtils.getIntegerFromJSON(((org.json.JSONObject) (obj)), "rcode", 0);
        String s = JSONUtils.getStringFromJSON(((org.json.JSONObject) (obj)), "msg", "");
        if (i == 1)
        {
            Log.i(sisrequest.getLogTag(), "Result - code: %d, msg: %s", new Object[] {
                Integer.valueOf(i), s
            });
            sisrequest.onResponseReceived(((org.json.JSONObject) (obj)));
            return;
        } else
        {
            Log.w(sisrequest.getLogTag(), "Result - code: %d, msg: %s", new Object[] {
                Integer.valueOf(i), s
            });
            return;
        }
    }

    protected SISRequestorCallback getSisRequestorCallback()
    {
        return sisRequestorCallback;
    }

    protected WebRequest getWebRequest(SISRequest sisrequest)
    {
        WebRequest webrequest = WebRequest.createNewWebRequest();
        webrequest.setExternalLogTag(sisrequest.getLogTag());
        webrequest.setHttpMethod(WebRequest.HttpMethod.POST);
        webrequest.setHost(getHostname());
        webrequest.setPath(getEndpoint(sisrequest));
        webrequest.enableLog(true);
        if (sisrequest.getPostParameters() != null)
        {
            java.util.Map.Entry entry;
            for (Iterator iterator = sisrequest.getPostParameters().entrySet().iterator(); iterator.hasNext(); webrequest.putPostParameter((String)entry.getKey(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

        }
        WebRequest.QueryStringParameters querystringparameters = sisrequest.getQueryParameters();
        querystringparameters.putUrlEncoded("appId", InternalAdRegistration.getInstance().getRegistrationInfo().getAppKey());
        querystringparameters.putUrlEncoded("sdkVer", Version.getSDKVersion());
        webrequest.setQueryStringParameters(querystringparameters);
        webrequest.setMetricsCollector(Metrics.getInstance().getMetricsCollector());
        webrequest.setServiceCallLatencyMetric(sisrequest.getCallMetricType());
        return webrequest;
    }

    public void startCallSIS()
    {
        callSIS();
        SISRequestorCallback sisrequestorcallback = getSisRequestorCallback();
        if (sisrequestorcallback != null)
        {
            sisrequestorcallback.onSISCallComplete();
        }
    }
}
