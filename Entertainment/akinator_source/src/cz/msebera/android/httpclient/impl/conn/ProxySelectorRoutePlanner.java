// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.conn.params.ConnRouteParams;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner;
import cz.msebera.android.httpclient.conn.scheme.Scheme;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class ProxySelectorRoutePlanner
    implements HttpRoutePlanner
{

    protected ProxySelector proxySelector;
    protected final SchemeRegistry schemeRegistry;

    public ProxySelectorRoutePlanner(SchemeRegistry schemeregistry, ProxySelector proxyselector)
    {
        Args.notNull(schemeregistry, "SchemeRegistry");
        schemeRegistry = schemeregistry;
        proxySelector = proxyselector;
    }

    protected Proxy chooseProxy(List list, HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
    {
        int i;
        Args.notEmpty(list, "List of proxies");
        httphost = null;
        i = 0;
_L6:
        if (httphost != null || i >= list.size()) goto _L2; else goto _L1
_L1:
        httprequest = (Proxy)list.get(i);
        static class _cls1
        {

            static final int $SwitchMap$java$net$Proxy$Type[];

            static 
            {
                $SwitchMap$java$net$Proxy$Type = new int[java.net.Proxy.Type.values().length];
                try
                {
                    $SwitchMap$java$net$Proxy$Type[java.net.Proxy.Type.DIRECT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$java$net$Proxy$Type[java.net.Proxy.Type.HTTP.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$java$net$Proxy$Type[java.net.Proxy.Type.SOCKS.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.java.net.Proxy.Type[httprequest.type().ordinal()];
        JVM INSTR tableswitch 1 2: default 72
    //                   1 81
    //                   2 81;
           goto _L3 _L4 _L4
_L3:
        i++;
        continue; /* Loop/switch isn't completed */
_L4:
        httphost = httprequest;
        if (true) goto _L3; else goto _L2
_L2:
        list = httphost;
        if (httphost == null)
        {
            list = Proxy.NO_PROXY;
        }
        return list;
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected HttpHost determineProxy(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException
    {
        ProxySelector proxyselector1 = proxySelector;
        ProxySelector proxyselector = proxyselector1;
        if (proxyselector1 == null)
        {
            proxyselector = ProxySelector.getDefault();
        }
        if (proxyselector != null)
        {
            URI uri;
            try
            {
                uri = new URI(httphost.toURI());
            }
            // Misplaced declaration of an exception variable
            catch (HttpRequest httprequest)
            {
                throw new HttpException((new StringBuilder()).append("Cannot convert host to URI: ").append(httphost).toString(), httprequest);
            }
            httphost = chooseProxy(proxyselector.select(uri), httphost, httprequest, httpcontext);
            if (httphost.type() == java.net.Proxy.Type.HTTP)
            {
                if (!(httphost.address() instanceof InetSocketAddress))
                {
                    throw new HttpException((new StringBuilder()).append("Unable to handle non-Inet proxy address: ").append(httphost.address()).toString());
                } else
                {
                    httphost = (InetSocketAddress)httphost.address();
                    return new HttpHost(getHost(httphost), httphost.getPort());
                }
            }
        }
        return null;
    }

    public HttpRoute determineRoute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException
    {
        Args.notNull(httprequest, "HTTP request");
        Object obj = ConnRouteParams.getForcedRoute(httprequest.getParams());
        if (obj != null)
        {
            return ((HttpRoute) (obj));
        }
        Asserts.notNull(httphost, "Target host");
        obj = ConnRouteParams.getLocalAddress(httprequest.getParams());
        httprequest = determineProxy(httphost, httprequest, httpcontext);
        boolean flag = schemeRegistry.getScheme(httphost.getSchemeName()).isLayered();
        if (httprequest == null)
        {
            httphost = new HttpRoute(httphost, ((InetAddress) (obj)), flag);
        } else
        {
            httphost = new HttpRoute(httphost, ((InetAddress) (obj)), httprequest, flag);
        }
        return httphost;
    }

    protected String getHost(InetSocketAddress inetsocketaddress)
    {
        if (inetsocketaddress.isUnresolved())
        {
            return inetsocketaddress.getHostName();
        } else
        {
            return inetsocketaddress.getAddress().getHostAddress();
        }
    }

    public ProxySelector getProxySelector()
    {
        return proxySelector;
    }

    public void setProxySelector(ProxySelector proxyselector)
    {
        proxySelector = proxyselector;
    }
}
