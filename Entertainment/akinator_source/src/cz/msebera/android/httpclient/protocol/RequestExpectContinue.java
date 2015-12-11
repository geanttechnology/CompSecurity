// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

// Referenced classes of package cz.msebera.android.httpclient.protocol:
//            HttpContext

public class RequestExpectContinue
    implements HttpRequestInterceptor
{

    private final boolean activeByDefault;

    public RequestExpectContinue()
    {
        this(false);
    }

    public RequestExpectContinue(boolean flag)
    {
        activeByDefault = flag;
    }

    public void process(HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException, IOException
    {
        Args.notNull(httprequest, "HTTP request");
        if (!httprequest.containsHeader("Expect") && (httprequest instanceof HttpEntityEnclosingRequest))
        {
            httpcontext = httprequest.getRequestLine().getProtocolVersion();
            HttpEntity httpentity = ((HttpEntityEnclosingRequest)httprequest).getEntity();
            if (httpentity != null && httpentity.getContentLength() != 0L && !httpcontext.lessEquals(HttpVersion.HTTP_1_0) && httprequest.getParams().getBooleanParameter("http.protocol.expect-continue", activeByDefault))
            {
                httprequest.addHeader("Expect", "100-continue");
            }
        }
    }
}
