// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            HttpClientImpl, NetworkLog

private static class <init>
    implements HttpRequestInterceptor, HttpResponseInterceptor
{

    public void process(HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException, IOException
    {
        NetworkLog.logHeaders(HttpClientImpl.access$400().init>, HttpClientImpl.access$400().init>, true, new (httprequest));
        if (!(httprequest instanceof HttpEntityEnclosingRequest)) goto _L2; else goto _L1
_L1:
        try
        {
            httpcontext = ((HttpEntityEnclosingRequest)httprequest).getEntity();
            httprequest = httprequest.getFirstHeader("Content-Type");
        }
        catch (Exception exception)
        {
            httpcontext = exception.getMessage();
            httprequest = httpcontext;
            if (httpcontext == null)
            {
                httprequest = exception.getClass().getName();
            }
            HttpClientImpl.access$400().init>(httprequest, exception);
            return;
        }
        if (httprequest == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        httprequest = httprequest.getValue();
_L3:
        NetworkLog.logContent(EntityUtils.toByteArray(httpcontext), httprequest);
_L2:
        return;
        httprequest = null;
          goto _L3
    }

    public void process(HttpResponse httpresponse, HttpContext httpcontext)
        throws HttpException, IOException
    {
        NetworkLog.logHeaders(HttpClientImpl.access$400().init>, HttpClientImpl.access$400().init>, false, new (httpresponse));
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
