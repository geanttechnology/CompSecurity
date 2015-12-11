// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.client.AuthCache;
import cz.msebera.android.httpclient.conn.SchemePortResolver;
import cz.msebera.android.httpclient.conn.UnsupportedSchemeException;
import cz.msebera.android.httpclient.impl.conn.DefaultSchemePortResolver;
import cz.msebera.android.httpclient.util.Args;
import java.util.HashMap;

public class BasicAuthCache
    implements AuthCache
{

    private final HashMap map;
    private final SchemePortResolver schemePortResolver;

    public BasicAuthCache()
    {
        this(null);
    }

    public BasicAuthCache(SchemePortResolver schemeportresolver)
    {
        map = new HashMap();
        if (schemeportresolver == null)
        {
            schemeportresolver = DefaultSchemePortResolver.INSTANCE;
        }
        schemePortResolver = schemeportresolver;
    }

    public void clear()
    {
        map.clear();
    }

    public AuthScheme get(HttpHost httphost)
    {
        Args.notNull(httphost, "HTTP host");
        return (AuthScheme)map.get(getKey(httphost));
    }

    protected HttpHost getKey(HttpHost httphost)
    {
        HttpHost httphost1 = httphost;
        if (httphost.getPort() <= 0)
        {
            int i;
            try
            {
                i = schemePortResolver.resolve(httphost);
            }
            catch (UnsupportedSchemeException unsupportedschemeexception)
            {
                return httphost;
            }
            httphost1 = new HttpHost(httphost.getHostName(), i, httphost.getSchemeName());
        }
        return httphost1;
    }

    public void put(HttpHost httphost, AuthScheme authscheme)
    {
        Args.notNull(httphost, "HTTP host");
        map.put(getKey(httphost), authscheme);
    }

    public void remove(HttpHost httphost)
    {
        Args.notNull(httphost, "HTTP host");
        map.remove(getKey(httphost));
    }

    public String toString()
    {
        return map.toString();
    }
}
