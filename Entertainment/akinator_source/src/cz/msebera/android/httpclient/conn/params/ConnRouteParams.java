// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn.params;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import java.net.InetAddress;

// Referenced classes of package cz.msebera.android.httpclient.conn.params:
//            ConnRoutePNames

public class ConnRouteParams
    implements ConnRoutePNames
{

    public static final HttpHost NO_HOST;
    public static final HttpRoute NO_ROUTE;

    private ConnRouteParams()
    {
    }

    public static HttpHost getDefaultProxy(HttpParams httpparams)
    {
        Args.notNull(httpparams, "Parameters");
        HttpHost httphost = (HttpHost)httpparams.getParameter("http.route.default-proxy");
        httpparams = httphost;
        if (httphost != null)
        {
            httpparams = httphost;
            if (NO_HOST.equals(httphost))
            {
                httpparams = null;
            }
        }
        return httpparams;
    }

    public static HttpRoute getForcedRoute(HttpParams httpparams)
    {
        Args.notNull(httpparams, "Parameters");
        HttpRoute httproute = (HttpRoute)httpparams.getParameter("http.route.forced-route");
        httpparams = httproute;
        if (httproute != null)
        {
            httpparams = httproute;
            if (NO_ROUTE.equals(httproute))
            {
                httpparams = null;
            }
        }
        return httpparams;
    }

    public static InetAddress getLocalAddress(HttpParams httpparams)
    {
        Args.notNull(httpparams, "Parameters");
        return (InetAddress)httpparams.getParameter("http.route.local-address");
    }

    public static void setDefaultProxy(HttpParams httpparams, HttpHost httphost)
    {
        Args.notNull(httpparams, "Parameters");
        httpparams.setParameter("http.route.default-proxy", httphost);
    }

    public static void setForcedRoute(HttpParams httpparams, HttpRoute httproute)
    {
        Args.notNull(httpparams, "Parameters");
        httpparams.setParameter("http.route.forced-route", httproute);
    }

    public static void setLocalAddress(HttpParams httpparams, InetAddress inetaddress)
    {
        Args.notNull(httpparams, "Parameters");
        httpparams.setParameter("http.route.local-address", inetaddress);
    }

    static 
    {
        NO_HOST = new HttpHost("127.0.0.255", 0, "no-host");
        NO_ROUTE = new HttpRoute(NO_HOST);
    }
}
