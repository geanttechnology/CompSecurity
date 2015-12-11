// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.cache;

import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;

// Referenced classes of package cz.msebera.android.httpclient.client.cache:
//            CacheResponseStatus

public class HttpCacheContext extends HttpClientContext
{

    public static final String CACHE_RESPONSE_STATUS = "http.cache.response.status";

    public HttpCacheContext()
    {
    }

    public HttpCacheContext(HttpContext httpcontext)
    {
        super(httpcontext);
    }

    public static HttpCacheContext adapt(HttpContext httpcontext)
    {
        if (httpcontext instanceof HttpCacheContext)
        {
            return (HttpCacheContext)httpcontext;
        } else
        {
            return new HttpCacheContext(httpcontext);
        }
    }

    public static HttpCacheContext create()
    {
        return new HttpCacheContext(new BasicHttpContext());
    }

    public CacheResponseStatus getCacheResponseStatus()
    {
        return (CacheResponseStatus)getAttribute("http.cache.response.status", cz/msebera/android/httpclient/client/cache/CacheResponseStatus);
    }
}
