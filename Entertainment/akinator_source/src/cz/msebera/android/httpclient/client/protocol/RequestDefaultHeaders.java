// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public class RequestDefaultHeaders
    implements HttpRequestInterceptor
{

    private final Collection defaultHeaders;

    public RequestDefaultHeaders()
    {
        this(null);
    }

    public RequestDefaultHeaders(Collection collection)
    {
        defaultHeaders = collection;
    }

    public void process(HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException, IOException
    {
        Args.notNull(httprequest, "HTTP request");
        if (!httprequest.getRequestLine().getMethod().equalsIgnoreCase("CONNECT")) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Collection collection = (Collection)httprequest.getParams().getParameter("http.default-headers");
        httpcontext = collection;
        if (collection == null)
        {
            httpcontext = defaultHeaders;
        }
        if (httpcontext != null)
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
