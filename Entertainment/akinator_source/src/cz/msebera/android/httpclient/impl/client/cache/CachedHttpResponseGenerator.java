// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.utils.DateUtils;
import cz.msebera.android.httpclient.message.BasicHeader;
import cz.msebera.android.httpclient.message.BasicHttpResponse;
import java.util.Date;

// Referenced classes of package cz.msebera.android.httpclient.impl.client.cache:
//            CacheValidityPolicy, Proxies, CacheEntity

class CachedHttpResponseGenerator
{

    private final CacheValidityPolicy validityStrategy;

    CachedHttpResponseGenerator()
    {
        this(new CacheValidityPolicy());
    }

    CachedHttpResponseGenerator(CacheValidityPolicy cachevaliditypolicy)
    {
        validityStrategy = cachevaliditypolicy;
    }

    private void addMissingContentLengthHeader(HttpResponse httpresponse, HttpEntity httpentity)
    {
        while (transferEncodingIsPresent(httpresponse) || httpresponse.getFirstHeader("Content-Length") != null) 
        {
            return;
        }
        httpresponse.setHeader(new BasicHeader("Content-Length", Long.toString(httpentity.getContentLength())));
    }

    private boolean transferEncodingIsPresent(HttpResponse httpresponse)
    {
        return httpresponse.getFirstHeader("Transfer-Encoding") != null;
    }

    CloseableHttpResponse generateNotModifiedResponse(HttpCacheEntry httpcacheentry)
    {
        BasicHttpResponse basichttpresponse = new BasicHttpResponse(HttpVersion.HTTP_1_1, 304, "Not Modified");
        cz.msebera.android.httpclient.Header header = httpcacheentry.getFirstHeader("Date");
        Object obj = header;
        if (header == null)
        {
            obj = new BasicHeader("Date", DateUtils.formatDate(new Date()));
        }
        basichttpresponse.addHeader(((cz.msebera.android.httpclient.Header) (obj)));
        obj = httpcacheentry.getFirstHeader("ETag");
        if (obj != null)
        {
            basichttpresponse.addHeader(((cz.msebera.android.httpclient.Header) (obj)));
        }
        obj = httpcacheentry.getFirstHeader("Content-Location");
        if (obj != null)
        {
            basichttpresponse.addHeader(((cz.msebera.android.httpclient.Header) (obj)));
        }
        obj = httpcacheentry.getFirstHeader("Expires");
        if (obj != null)
        {
            basichttpresponse.addHeader(((cz.msebera.android.httpclient.Header) (obj)));
        }
        obj = httpcacheentry.getFirstHeader("Cache-Control");
        if (obj != null)
        {
            basichttpresponse.addHeader(((cz.msebera.android.httpclient.Header) (obj)));
        }
        httpcacheentry = httpcacheentry.getFirstHeader("Vary");
        if (httpcacheentry != null)
        {
            basichttpresponse.addHeader(httpcacheentry);
        }
        return Proxies.enhanceResponse(basichttpresponse);
    }

    CloseableHttpResponse generateResponse(HttpCacheEntry httpcacheentry)
    {
        Date date = new Date();
        BasicHttpResponse basichttpresponse = new BasicHttpResponse(HttpVersion.HTTP_1_1, httpcacheentry.getStatusCode(), httpcacheentry.getReasonPhrase());
        basichttpresponse.setHeaders(httpcacheentry.getAllHeaders());
        if (httpcacheentry.getResource() != null)
        {
            CacheEntity cacheentity = new CacheEntity(httpcacheentry);
            addMissingContentLengthHeader(basichttpresponse, cacheentity);
            basichttpresponse.setEntity(cacheentity);
        }
        long l = validityStrategy.getCurrentAgeSecs(httpcacheentry, date);
        if (l > 0L)
        {
            if (l >= 0x7fffffffL)
            {
                basichttpresponse.setHeader("Age", "2147483648");
            } else
            {
                basichttpresponse.setHeader("Age", (new StringBuilder()).append("").append((int)l).toString());
            }
        }
        return Proxies.enhanceResponse(basichttpresponse);
    }
}
