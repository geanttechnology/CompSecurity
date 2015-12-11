// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

// Referenced classes of package cz.msebera.android.httpclient.impl.client.cache:
//            Variant

interface HttpCache
{

    public abstract HttpResponse cacheAndReturnResponse(HttpHost httphost, HttpRequest httprequest, HttpResponse httpresponse, Date date, Date date1)
        throws IOException;

    public abstract CloseableHttpResponse cacheAndReturnResponse(HttpHost httphost, HttpRequest httprequest, CloseableHttpResponse closeablehttpresponse, Date date, Date date1)
        throws IOException;

    public abstract void flushCacheEntriesFor(HttpHost httphost, HttpRequest httprequest)
        throws IOException;

    public abstract void flushInvalidatedCacheEntriesFor(HttpHost httphost, HttpRequest httprequest)
        throws IOException;

    public abstract void flushInvalidatedCacheEntriesFor(HttpHost httphost, HttpRequest httprequest, HttpResponse httpresponse);

    public abstract HttpCacheEntry getCacheEntry(HttpHost httphost, HttpRequest httprequest)
        throws IOException;

    public abstract Map getVariantCacheEntriesWithEtags(HttpHost httphost, HttpRequest httprequest)
        throws IOException;

    public abstract void reuseVariantEntryFor(HttpHost httphost, HttpRequest httprequest, Variant variant)
        throws IOException;

    public abstract HttpCacheEntry updateCacheEntry(HttpHost httphost, HttpRequest httprequest, HttpCacheEntry httpcacheentry, HttpResponse httpresponse, Date date, Date date1)
        throws IOException;

    public abstract HttpCacheEntry updateVariantCacheEntry(HttpHost httphost, HttpRequest httprequest, HttpCacheEntry httpcacheentry, HttpResponse httpresponse, Date date, Date date1, String s)
        throws IOException;
}
