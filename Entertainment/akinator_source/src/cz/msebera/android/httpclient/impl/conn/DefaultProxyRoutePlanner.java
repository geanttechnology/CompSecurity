// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.conn.SchemePortResolver;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn:
//            DefaultRoutePlanner

public class DefaultProxyRoutePlanner extends DefaultRoutePlanner
{

    private final HttpHost proxy;

    public DefaultProxyRoutePlanner(HttpHost httphost)
    {
        this(httphost, null);
    }

    public DefaultProxyRoutePlanner(HttpHost httphost, SchemePortResolver schemeportresolver)
    {
        super(schemeportresolver);
        proxy = (HttpHost)Args.notNull(httphost, "Proxy host");
    }

    protected HttpHost determineProxy(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException
    {
        return proxy;
    }
}
