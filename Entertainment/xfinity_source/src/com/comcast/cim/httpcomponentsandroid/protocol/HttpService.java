// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.protocol;

import com.comcast.cim.httpcomponentsandroid.ConnectionReuseStrategy;
import com.comcast.cim.httpcomponentsandroid.HttpResponseFactory;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.protocol:
//            HttpExpectationVerifier, HttpRequestHandlerResolver, HttpProcessor

public class HttpService
{

    private volatile ConnectionReuseStrategy connStrategy;
    private volatile HttpExpectationVerifier expectationVerifier;
    private volatile HttpRequestHandlerResolver handlerResolver;
    private volatile HttpParams params;
    private volatile HttpProcessor processor;
    private volatile HttpResponseFactory responseFactory;

    public HttpParams getParams()
    {
        return params;
    }

    public void setConnReuseStrategy(ConnectionReuseStrategy connectionreusestrategy)
    {
        if (connectionreusestrategy == null)
        {
            throw new IllegalArgumentException("Connection reuse strategy may not be null");
        } else
        {
            connStrategy = connectionreusestrategy;
            return;
        }
    }

    public void setExpectationVerifier(HttpExpectationVerifier httpexpectationverifier)
    {
        expectationVerifier = httpexpectationverifier;
    }

    public void setHandlerResolver(HttpRequestHandlerResolver httprequesthandlerresolver)
    {
        handlerResolver = httprequesthandlerresolver;
    }

    public void setHttpProcessor(HttpProcessor httpprocessor)
    {
        if (httpprocessor == null)
        {
            throw new IllegalArgumentException("HTTP processor may not be null");
        } else
        {
            processor = httpprocessor;
            return;
        }
    }

    public void setParams(HttpParams httpparams)
    {
        params = httpparams;
    }

    public void setResponseFactory(HttpResponseFactory httpresponsefactory)
    {
        if (httpresponsefactory == null)
        {
            throw new IllegalArgumentException("Response factory may not be null");
        } else
        {
            responseFactory = httpresponsefactory;
            return;
        }
    }
}
