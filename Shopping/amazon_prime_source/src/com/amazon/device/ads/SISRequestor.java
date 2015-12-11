// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.device.ads:
//            Configuration, SISRequest, WebRequest, ResponseReader, 
//            JSONUtils, MobileAdsLogger, MobileAdsInfoStore, RegistrationInfo, 
//            Version, Metrics, SISRequestorCallback

class SISRequestor
{
    static class SISRequestorFactory
    {

        public transient SISRequestor createSISRequestor(SISRequestorCallback sisrequestorcallback, SISRequest asisrequest[])
        {
            return new SISRequestor(sisrequestorcallback, asisrequest);
        }

        public transient SISRequestor createSISRequestor(SISRequest asisrequest[])
        {
            return createSISRequestor(null, asisrequest);
        }

        SISRequestorFactory()
        {
        }
    }


    protected static final String API_LEVEL_ENDPOINT = "/api3";
    private final SISRequestorCallback sisRequestorCallback;
    private final SISRequest sisRequests[];
    private final WebRequest.WebRequestFactory webRequestFactory;

    public transient SISRequestor(SISRequestorCallback sisrequestorcallback, SISRequest asisrequest[])
    {
        this(new WebRequest.WebRequestFactory(), sisrequestorcallback, asisrequest);
    }

    transient SISRequestor(WebRequest.WebRequestFactory webrequestfactory, SISRequestorCallback sisrequestorcallback, SISRequest asisrequest[])
    {
        webRequestFactory = webrequestfactory;
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
        obj = ((WebRequest.WebResponse) (obj)).getResponseReader().readAsJSON();
        if (obj == null)
        {
            return;
        }
        int i = JSONUtils.getIntegerFromJSON(((org.json.JSONObject) (obj)), "rcode", 0);
        String s = JSONUtils.getStringFromJSON(((org.json.JSONObject) (obj)), "msg", "");
        if (i == 1)
        {
            sisrequest.getLogger().i("Result - code: %d, msg: %s", new Object[] {
                Integer.valueOf(i), s
            });
            sisrequest.onResponseReceived(((org.json.JSONObject) (obj)));
            return;
        } else
        {
            sisrequest.getLogger().w("Result - code: %d, msg: %s", new Object[] {
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
        WebRequest webrequest = webRequestFactory.createWebRequest();
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
        querystringparameters.putUrlEncoded("appId", MobileAdsInfoStore.getInstance().getRegistrationInfo().getAppKey());
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
