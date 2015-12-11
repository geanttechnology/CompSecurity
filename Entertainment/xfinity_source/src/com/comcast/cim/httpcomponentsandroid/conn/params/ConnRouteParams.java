// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.conn.params;

import com.comcast.cim.httpcomponentsandroid.HttpHost;
import com.comcast.cim.httpcomponentsandroid.conn.routing.HttpRoute;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import java.net.InetAddress;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.conn.params:
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
        if (httpparams == null)
        {
            throw new IllegalArgumentException("Parameters must not be null.");
        }
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
        if (httpparams == null)
        {
            throw new IllegalArgumentException("Parameters must not be null.");
        }
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
        if (httpparams == null)
        {
            throw new IllegalArgumentException("Parameters must not be null.");
        } else
        {
            return (InetAddress)httpparams.getParameter("http.route.local-address");
        }
    }

    static 
    {
        NO_HOST = new HttpHost("127.0.0.255", 0, "no-host");
        NO_ROUTE = new HttpRoute(NO_HOST);
    }
}
