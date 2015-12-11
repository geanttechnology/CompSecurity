// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.http.apache;

import com.comcast.cim.microdata.http.HttpRequester;
import org.apache.http.client.HttpClient;
import org.apache.http.protocol.HttpContext;

public class ApacheHttpRequester
    implements HttpRequester
{

    private HttpClient httpClient;
    private HttpContext httpContext;

    public ApacheHttpRequester()
    {
    }

    public HttpClient getHttpClient()
    {
        return httpClient;
    }

    public HttpContext getHttpContext()
    {
        return httpContext;
    }

    public void setHttpClient(HttpClient httpclient)
    {
        httpClient = httpclient;
    }

    public void setHttpContext(HttpContext httpcontext)
    {
        httpContext = httpcontext;
    }
}
