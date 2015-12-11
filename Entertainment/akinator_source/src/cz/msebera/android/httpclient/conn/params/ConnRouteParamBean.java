// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn.params;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.params.HttpAbstractParamBean;
import cz.msebera.android.httpclient.params.HttpParams;
import java.net.InetAddress;

public class ConnRouteParamBean extends HttpAbstractParamBean
{

    public ConnRouteParamBean(HttpParams httpparams)
    {
        super(httpparams);
    }

    public void setDefaultProxy(HttpHost httphost)
    {
        params.setParameter("http.route.default-proxy", httphost);
    }

    public void setForcedRoute(HttpRoute httproute)
    {
        params.setParameter("http.route.forced-route", httproute);
    }

    public void setLocalAddress(InetAddress inetaddress)
    {
        params.setParameter("http.route.local-address", inetaddress);
    }
}
