// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;

public final class HttpInterceptors
    implements HttpRequestInterceptor, HttpResponseInterceptor
{

    private static final HttpInterceptors THIS = new HttpInterceptors();
    private volatile List requestInterceptors;
    private volatile List responseInterceptors;

    private HttpInterceptors()
    {
        requestInterceptors = null;
        responseInterceptors = null;
    }

    public static void addRequestInterceptor(HttpRequestInterceptor httprequestinterceptor)
    {
        if (httprequestinterceptor == null)
        {
            throw new NullPointerException("interceptor");
        }
        if (THIS.requestInterceptors == null)
        {
            THIS.requestInterceptors = new ArrayList();
        }
        THIS.requestInterceptors.add(httprequestinterceptor);
    }

    public static void addResponseInterceptor(HttpResponseInterceptor httpresponseinterceptor)
    {
        if (httpresponseinterceptor == null)
        {
            throw new NullPointerException("interceptor");
        }
        if (THIS.responseInterceptors == null)
        {
            THIS.responseInterceptors = new ArrayList();
        }
        THIS.responseInterceptors.add(httpresponseinterceptor);
    }

    static HttpRequestInterceptor getRequestInterceptor()
    {
        return THIS;
    }

    static HttpResponseInterceptor getResponseInterceptor()
    {
        return THIS;
    }

    public void process(HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException, IOException
    {
        Object obj = requestInterceptors;
        if (obj != null)
        {
            obj = ((List) (obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                ((HttpRequestInterceptor)((Iterator) (obj)).next()).process(httprequest, httpcontext);
            }
        }
    }

    public void process(HttpResponse httpresponse, HttpContext httpcontext)
        throws HttpException, IOException
    {
        Object obj = responseInterceptors;
        if (obj != null)
        {
            obj = ((List) (obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                ((HttpResponseInterceptor)((Iterator) (obj)).next()).process(httpresponse, httpcontext);
            }
        }
    }

}
