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
//            u

public interface t
{

    public abstract CacheRequest a(URI uri, URLConnection urlconnection);

    public abstract CacheResponse a(URI uri, String s, Map map);

    public abstract void a();

    public abstract void a(u u);

    public abstract void a(String s, URI uri);

    public abstract void a(CacheResponse cacheresponse, HttpURLConnection httpurlconnection);
}
