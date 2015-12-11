// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLConnection;
import java.util.Map;

// Referenced classes of package com.a.a:
//            t, f, u

final class g
    implements t
{

    final f a;

    g(f f1)
    {
        a = f1;
        super();
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
        f.a(a);
    }

    public final void a(u u)
    {
        f.a(a, u);
    }

    public final void a(String s, URI uri)
    {
        f.a(a, s, uri);
    }

    public final void a(CacheResponse cacheresponse, HttpURLConnection httpurlconnection)
    {
        f.a(cacheresponse, httpurlconnection);
    }
}
