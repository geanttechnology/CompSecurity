// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.a;

import com.a.a.u;
import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.HttpURLConnection;
import java.net.ResponseCache;
import java.net.URI;
import java.net.URLConnection;
import java.util.Map;

public final class t
    implements com.a.a.t
{

    private final ResponseCache a;

    public t(ResponseCache responsecache)
    {
        a = responsecache;
    }

    public final CacheRequest a(URI uri, URLConnection urlconnection)
    {
        return a.put(uri, urlconnection);
    }

    public final CacheResponse a(URI uri, String s, Map map)
    {
        return a.get(uri, s, map);
    }

    public final void a()
    {
    }

    public final void a(u u)
    {
    }

    public final void a(String s, URI uri)
    {
    }

    public final void a(CacheResponse cacheresponse, HttpURLConnection httpurlconnection)
    {
    }
}
