// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.conn.SchemePortResolver;
import cz.msebera.android.httpclient.conn.UnsupportedSchemeException;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn:
//            DefaultSchemePortResolver

public class DefaultRoutePlanner
    implements HttpRoutePlanner
{

    private final SchemePortResolver schemePortResolver;

    public DefaultRoutePlanner(SchemePortResolver schemeportresolver)
    {
        if (schemeportresolver == null)
        {
            schemeportresolver = DefaultSchemePortResolver.INSTANCE;
        }
        schemePortResolver = schemeportresolver;
    }

    protected HttpHost determineProxy(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException
    {
        return null;
    }

    public HttpRoute determineRoute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException
    {
        Args.notNull(httprequest, "Request");
        if (httphost == null)
        {
            throw new ProtocolException("Target host is not specified");
        }
        Object obj = HttpClientContext.adapt(httpcontext).getRequestConfig();
        java.net.InetAddress inetaddress = ((RequestConfig) (obj)).getLocalAddress();
        HttpHost httphost1 = ((RequestConfig) (obj)).getProxy();
        obj = httphost1;
        if (httphost1 == null)
        {
            obj = determineProxy(httphost, httprequest, httpcontext);
        }
        boolean flag;
        if (httphost.getPort() <= 0)
        {
            try
            {
                httphost = new HttpHost(httphost.getHostName(), schemePortResolver.resolve(httphost), httphost.getSchemeName());
            }
            // Misplaced declaration of an exception variable
            catch (HttpHost httphost)
            {
                throw new HttpException(httphost.getMessage());
            }
        }
        flag = httphost.getSchemeName().equalsIgnoreCase("https");
        if (obj == null)
        {
            return new HttpRoute(httphost, inetaddress, flag);
        } else
        {
            return new HttpRoute(httphost, inetaddress, ((HttpHost) (obj)), flag);
        }
    }
}
