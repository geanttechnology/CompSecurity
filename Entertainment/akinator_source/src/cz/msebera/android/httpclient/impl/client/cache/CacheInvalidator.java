// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.cache.HttpCacheInvalidator;
import cz.msebera.android.httpclient.client.cache.HttpCacheStorage;
import cz.msebera.android.httpclient.client.utils.DateUtils;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package cz.msebera.android.httpclient.impl.client.cache:
//            CacheKeyGenerator

class CacheInvalidator
    implements HttpCacheInvalidator
{

    private final CacheKeyGenerator cacheKeyGenerator;
    public HttpClientAndroidLog log;
    private final HttpCacheStorage storage;

    public CacheInvalidator(CacheKeyGenerator cachekeygenerator, HttpCacheStorage httpcachestorage)
    {
        log = new HttpClientAndroidLog(getClass());
        cacheKeyGenerator = cachekeygenerator;
        storage = httpcachestorage;
    }

    private void flushEntry(String s)
    {
        try
        {
            storage.removeEntry(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log.warn("unable to flush cache entry", s);
        }
    }

    private void flushLocationCacheEntry(URL url, HttpResponse httpresponse, URL url1)
    {
        for (HttpCacheEntry httpcacheentry = getEntry(cacheKeyGenerator.canonicalizeUri(url1.toString())); httpcacheentry == null || responseDateOlderThanEntryDate(httpresponse, httpcacheentry) || !responseAndEntryEtagsDiffer(httpresponse, httpcacheentry);)
        {
            return;
        }

        flushUriIfSameHost(url, url1);
    }

    private URL getAbsoluteURL(String s)
    {
        try
        {
            s = new URL(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    private URL getContentLocationURL(URL url, HttpResponse httpresponse)
    {
        httpresponse = httpresponse.getFirstHeader("Content-Location");
        if (httpresponse == null)
        {
            httpresponse = null;
        } else
        {
            String s = httpresponse.getValue();
            URL url1 = getAbsoluteURL(s);
            httpresponse = url1;
            if (url1 == null)
            {
                return getRelativeURL(url, s);
            }
        }
        return httpresponse;
    }

    private HttpCacheEntry getEntry(String s)
    {
        try
        {
            s = storage.getEntry(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log.warn("could not retrieve entry from storage", s);
            return null;
        }
        return s;
    }

    private URL getLocationURL(URL url, HttpResponse httpresponse)
    {
        httpresponse = httpresponse.getFirstHeader("Location");
        if (httpresponse == null)
        {
            httpresponse = null;
        } else
        {
            String s = httpresponse.getValue();
            URL url1 = getAbsoluteURL(s);
            httpresponse = url1;
            if (url1 == null)
            {
                return getRelativeURL(url, s);
            }
        }
        return httpresponse;
    }

    private URL getRelativeURL(URL url, String s)
    {
        try
        {
            url = new URL(url, s);
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            return null;
        }
        return url;
    }

    private boolean notGetOrHeadRequest(String s)
    {
        return !"GET".equals(s) && !"HEAD".equals(s);
    }

    private boolean responseAndEntryEtagsDiffer(HttpResponse httpresponse, HttpCacheEntry httpcacheentry)
    {
        httpcacheentry = httpcacheentry.getFirstHeader("ETag");
        for (httpresponse = httpresponse.getFirstHeader("ETag"); httpcacheentry == null || httpresponse == null || httpcacheentry.getValue().equals(httpresponse.getValue());)
        {
            return false;
        }

        return true;
    }

    private boolean responseDateOlderThanEntryDate(HttpResponse httpresponse, HttpCacheEntry httpcacheentry)
    {
        httpcacheentry = httpcacheentry.getFirstHeader("Date");
        httpresponse = httpresponse.getFirstHeader("Date");
        if (httpcacheentry != null && httpresponse != null)
        {
            httpcacheentry = DateUtils.parseDate(httpcacheentry.getValue());
            httpresponse = DateUtils.parseDate(httpresponse.getValue());
            if (httpcacheentry != null && httpresponse != null)
            {
                return httpresponse.before(httpcacheentry);
            }
        }
        return false;
    }

    protected boolean flushAbsoluteUriFromSameHost(URL url, String s)
    {
        s = getAbsoluteURL(s);
        if (s == null)
        {
            return false;
        } else
        {
            flushUriIfSameHost(url, s);
            return true;
        }
    }

    public void flushInvalidatedCacheEntries(HttpHost httphost, HttpRequest httprequest)
    {
        if (requestShouldNotBeCached(httprequest))
        {
            log.debug("Request should not be cached");
            httphost = cacheKeyGenerator.getURI(httphost, httprequest);
            Object obj = getEntry(httphost);
            log.debug((new StringBuilder()).append("parent entry: ").append(obj).toString());
            if (obj != null)
            {
                for (obj = ((HttpCacheEntry) (obj)).getVariantMap().values().iterator(); ((Iterator) (obj)).hasNext(); flushEntry((String)((Iterator) (obj)).next())) { }
                flushEntry(httphost);
            }
            httphost = getAbsoluteURL(httphost);
            if (httphost == null)
            {
                log.error("Couldn't transform request into valid URL");
            } else
            {
                Object obj1 = httprequest.getFirstHeader("Content-Location");
                if (obj1 != null)
                {
                    obj1 = ((Header) (obj1)).getValue();
                    if (!flushAbsoluteUriFromSameHost(httphost, ((String) (obj1))))
                    {
                        flushRelativeUriFromSameHost(httphost, ((String) (obj1)));
                    }
                }
                httprequest = httprequest.getFirstHeader("Location");
                if (httprequest != null)
                {
                    flushAbsoluteUriFromSameHost(httphost, httprequest.getValue());
                    return;
                }
            }
        }
    }

    public void flushInvalidatedCacheEntries(HttpHost httphost, HttpRequest httprequest, HttpResponse httpresponse)
    {
        int i = httpresponse.getStatusLine().getStatusCode();
        if (i >= 200 && i <= 299)
        {
            if ((httphost = getAbsoluteURL(cacheKeyGenerator.getURI(httphost, httprequest))) != null)
            {
                httprequest = getContentLocationURL(httphost, httpresponse);
                if (httprequest != null)
                {
                    flushLocationCacheEntry(httphost, httpresponse, httprequest);
                }
                httprequest = getLocationURL(httphost, httpresponse);
                if (httprequest != null)
                {
                    flushLocationCacheEntry(httphost, httpresponse, httprequest);
                    return;
                }
            }
        }
    }

    protected void flushRelativeUriFromSameHost(URL url, String s)
    {
        s = getRelativeURL(url, s);
        if (s == null)
        {
            return;
        } else
        {
            flushUriIfSameHost(url, s);
            return;
        }
    }

    protected void flushUriIfSameHost(URL url, URL url1)
    {
        for (url1 = getAbsoluteURL(cacheKeyGenerator.canonicalizeUri(url1.toString())); url1 == null || !url1.getAuthority().equalsIgnoreCase(url.getAuthority());)
        {
            return;
        }

        flushEntry(url1.toString());
    }

    protected boolean requestShouldNotBeCached(HttpRequest httprequest)
    {
        return notGetOrHeadRequest(httprequest.getRequestLine().getMethod());
    }
}
