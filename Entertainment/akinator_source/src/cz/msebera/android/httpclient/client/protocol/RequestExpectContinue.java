// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

// Referenced classes of package cz.msebera.android.httpclient.client.protocol:
//            HttpClientContext

public class RequestExpectContinue
    implements HttpRequestInterceptor
{

    public RequestExpectContinue()
    {
    }

    public void process(HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException, IOException
    {
        Args.notNull(httprequest, "HTTP request");
        if (!httprequest.containsHeader("Expect") && (httprequest instanceof HttpEntityEnclosingRequest))
        {
            ProtocolVersion protocolversion = httprequest.getRequestLine().getProtocolVersion();
            HttpEntity httpentity = ((HttpEntityEnclosingRequest)httprequest).getEntity();
            if (httpentity != null && httpentity.getContentLength() != 0L && !protocolversion.lessEquals(HttpVersion.HTTP_1_0) && HttpClientContext.adapt(httpcontext).getRequestConfig().isExpectContinueEnabled())
            {
                httprequest.addHeader("Expect", "100-continue");
            }
        }
    }
}
