// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.configuration;


// Referenced classes of package com.amazon.client.metrics.configuration:
//            MetricsConfigurationException, HttpRequestSignerType

public class HttpConfiguration
{

    protected static final String DEFAULT_HTTP_URL_ENDPOINT_DEVO = "https://dp-mont.integ.amazon.com:443";
    protected static final String DEFAULT_HTTP_URL_ENDPOINT_PROD = "https://device-metrics-us.amazon.com:443";
    protected static final String DEFAULT_STATIC_CREDENTIAL_HTTP_URL_ENDPOINT = "https://device-metrics-us-2.amazon.com:443";
    private final HttpRequestSignerType mHttpRequestSignerType;
    private final String mStaticCredentialUrlEndpoint;
    private final String mUrlEndpoint;

    public HttpConfiguration(HttpRequestSignerType httprequestsignertype, String s, String s1)
        throws MetricsConfigurationException
    {
        if (httprequestsignertype == null)
        {
            throw new MetricsConfigurationException("HttpRequestSignerType is null in configuration");
        }
        if (s == null)
        {
            throw new MetricsConfigurationException("UrlEndpoint is null in configuration");
        }
        if (s1 == null)
        {
            throw new MetricsConfigurationException("UrlEndpoint is null in configuration");
        } else
        {
            mHttpRequestSignerType = httprequestsignertype;
            mUrlEndpoint = s;
            mStaticCredentialUrlEndpoint = s1;
            return;
        }
    }

    public HttpRequestSignerType getHttpRequestSignerType()
    {
        return mHttpRequestSignerType;
    }

    public String getStaticCredentialUrlEndpoint()
    {
        return mStaticCredentialUrlEndpoint;
    }

    public String getUrlEndpoint()
    {
        return mUrlEndpoint;
    }
}
