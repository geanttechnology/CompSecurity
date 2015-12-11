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

public class DefaultHttpRoutePlanner
    implements HttpRoutePlanner
{

    protected final SchemeRegistry schemeRegistry;

    public DefaultHttpRoutePlanner(SchemeRegistry schemeregistry)
    {
        Args.notNull(schemeregistry, "Scheme registry");
        schemeRegistry = schemeregistry;
    }

    public HttpRoute determineRoute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException
    {
        Args.notNull(httprequest, "HTTP request");
        httpcontext = ConnRouteParams.getForcedRoute(httprequest.getParams());
        if (httpcontext != null)
        {
            return httpcontext;
        }
        Asserts.notNull(httphost, "Target host");
        httpcontext = ConnRouteParams.getLocalAddress(httprequest.getParams());
        httprequest = ConnRouteParams.getDefaultProxy(httprequest.getParams());
        Scheme scheme;
        boolean flag;
        try
        {
            scheme = schemeRegistry.getScheme(httphost.getSchemeName());
        }
        // Misplaced declaration of an exception variable
        catch (HttpHost httphost)
        {
            throw new HttpException(httphost.getMessage());
        }
        flag = scheme.isLayered();
        if (httprequest == null)
        {
            httphost = new HttpRoute(httphost, httpcontext, flag);
        } else
        {
            httphost = new HttpRoute(httphost, httpcontext, httprequest, flag);
        }
        return httphost;
    }
}
