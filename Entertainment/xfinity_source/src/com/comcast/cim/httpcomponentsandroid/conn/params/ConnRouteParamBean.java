// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.conn.params;

import com.comcast.cim.httpcomponentsandroid.HttpHost;
import com.comcast.cim.httpcomponentsandroid.conn.routing.HttpRoute;
import com.comcast.cim.httpcomponentsandroid.params.HttpAbstractParamBean;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import java.net.InetAddress;

public class ConnRouteParamBean extends HttpAbstractParamBean
{

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
