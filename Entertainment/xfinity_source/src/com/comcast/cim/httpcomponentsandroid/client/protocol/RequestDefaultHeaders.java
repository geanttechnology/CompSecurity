// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.client.protocol;

import com.comcast.cim.httpcomponentsandroid.Header;
import com.comcast.cim.httpcomponentsandroid.HttpException;
import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.HttpRequestInterceptor;
import com.comcast.cim.httpcomponentsandroid.RequestLine;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public class RequestDefaultHeaders
    implements HttpRequestInterceptor
{

    public RequestDefaultHeaders()
    {
    }

    public void process(HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException, IOException
    {
        if (httprequest == null)
        {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
        if (!httprequest.getRequestLine().getMethod().equalsIgnoreCase("CONNECT")) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((httpcontext = (Collection)httprequest.getParams().getParameter("http.default-headers")) != null)
        {
            httpcontext = httpcontext.iterator();
            while (httpcontext.hasNext()) 
            {
                httprequest.addHeader((Header)httpcontext.next());
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }
}
