// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.conn.routing.RouteInfo;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

// Referenced classes of package cz.msebera.android.httpclient.client.protocol:
//            HttpClientContext

public class RequestClientConnControl
    implements HttpRequestInterceptor
{

    private static final String PROXY_CONN_DIRECTIVE = "Proxy-Connection";
    public HttpClientAndroidLog log;

    public RequestClientConnControl()
    {
        log = new HttpClientAndroidLog(getClass());
    }

    public void process(HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException, IOException
    {
        Args.notNull(httprequest, "HTTP request");
        if (httprequest.getRequestLine().getMethod().equalsIgnoreCase("CONNECT"))
        {
            httprequest.setHeader("Proxy-Connection", "Keep-Alive");
        } else
        {
            httpcontext = HttpClientContext.adapt(httpcontext).getHttpRoute();
            if (httpcontext == null)
            {
                log.debug("Connection route not set in the context");
                return;
            }
            if ((httpcontext.getHopCount() == 1 || httpcontext.isTunnelled()) && !httprequest.containsHeader("Connection"))
            {
                httprequest.addHeader("Connection", "Keep-Alive");
            }
            if (httpcontext.getHopCount() == 2 && !httpcontext.isTunnelled() && !httprequest.containsHeader("Proxy-Connection"))
            {
                httprequest.addHeader("Proxy-Connection", "Keep-Alive");
                return;
            }
        }
    }
}
