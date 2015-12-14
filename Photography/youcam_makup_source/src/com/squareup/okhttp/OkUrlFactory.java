// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.huc.CacheAdapter;
import com.squareup.okhttp.internal.huc.HttpURLConnectionImpl;
import com.squareup.okhttp.internal.huc.HttpsURLConnectionImpl;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.ResponseCache;
import java.net.URL;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

// Referenced classes of package com.squareup.okhttp:
//            OkHttpClient

public final class OkUrlFactory
    implements Cloneable, URLStreamHandlerFactory
{

    private final OkHttpClient client;

    public OkUrlFactory(OkHttpClient okhttpclient)
    {
        client = okhttpclient;
    }

    public OkHttpClient client()
    {
        return client;
    }

    public OkUrlFactory clone()
    {
        return new OkUrlFactory(client.clone());
    }

    public volatile Object clone()
    {
        return clone();
    }

    public URLStreamHandler createURLStreamHandler(String s)
    {
        if (!s.equals("http") && !s.equals("https"))
        {
            return null;
        } else
        {
            return new _cls1(s);
        }
    }

    ResponseCache getResponseCache()
    {
        com.squareup.okhttp.internal.InternalCache internalcache = client.internalCache();
        if (internalcache instanceof CacheAdapter)
        {
            return ((CacheAdapter)internalcache).getDelegate();
        } else
        {
            return null;
        }
    }

    public HttpURLConnection open(URL url)
    {
        return open(url, client.getProxy());
    }

    HttpURLConnection open(URL url, Proxy proxy)
    {
        String s = url.getProtocol();
        OkHttpClient okhttpclient = client.copyWithDefaults();
        okhttpclient.setProxy(proxy);
        if (s.equals("http"))
        {
            return new HttpURLConnectionImpl(url, okhttpclient);
        }
        if (s.equals("https"))
        {
            return new HttpsURLConnectionImpl(url, okhttpclient);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unexpected protocol: ").append(s).toString());
        }
    }

    OkUrlFactory setResponseCache(ResponseCache responsecache)
    {
        OkHttpClient okhttpclient = client;
        if (responsecache != null)
        {
            responsecache = new CacheAdapter(responsecache);
        } else
        {
            responsecache = null;
        }
        okhttpclient.setInternalCache(responsecache);
        return this;
    }

    /* member class not found */
    class _cls1 {}

}
