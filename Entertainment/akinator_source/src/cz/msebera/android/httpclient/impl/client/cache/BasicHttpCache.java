// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.cache.HttpCacheInvalidator;
import cz.msebera.android.httpclient.client.cache.HttpCacheStorage;
import cz.msebera.android.httpclient.client.cache.HttpCacheUpdateCallback;
import cz.msebera.android.httpclient.client.cache.HttpCacheUpdateException;
import cz.msebera.android.httpclient.client.cache.Resource;
import cz.msebera.android.httpclient.client.cache.ResourceFactory;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.entity.ByteArrayEntity;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.message.BasicHttpResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package cz.msebera.android.httpclient.impl.client.cache:
//            HttpCache, CacheConfig, CacheKeyGenerator, CacheInvalidator, 
//            CacheEntryUpdater, CachedHttpResponseGenerator, HeapResourceFactory, BasicHttpCacheStorage, 
//            Variant, Proxies, SizeLimitedResponseReader

class BasicHttpCache
    implements HttpCache
{

    private static final Set safeRequestMethods = new HashSet(Arrays.asList(new String[] {
        "HEAD", "GET", "OPTIONS", "TRACE"
    }));
    private final CacheEntryUpdater cacheEntryUpdater;
    private final HttpCacheInvalidator cacheInvalidator;
    public HttpClientAndroidLog log;
    private final long maxObjectSizeBytes;
    private final ResourceFactory resourceFactory;
    private final CachedHttpResponseGenerator responseGenerator;
    private final HttpCacheStorage storage;
    private final CacheKeyGenerator uriExtractor;

    public BasicHttpCache()
    {
        this(CacheConfig.DEFAULT);
    }

    public BasicHttpCache(ResourceFactory resourcefactory, HttpCacheStorage httpcachestorage, CacheConfig cacheconfig)
    {
        this(resourcefactory, httpcachestorage, cacheconfig, new CacheKeyGenerator());
    }

    public BasicHttpCache(ResourceFactory resourcefactory, HttpCacheStorage httpcachestorage, CacheConfig cacheconfig, CacheKeyGenerator cachekeygenerator)
    {
        this(resourcefactory, httpcachestorage, cacheconfig, cachekeygenerator, ((HttpCacheInvalidator) (new CacheInvalidator(cachekeygenerator, httpcachestorage))));
    }

    public BasicHttpCache(ResourceFactory resourcefactory, HttpCacheStorage httpcachestorage, CacheConfig cacheconfig, CacheKeyGenerator cachekeygenerator, HttpCacheInvalidator httpcacheinvalidator)
    {
        log = new HttpClientAndroidLog(getClass());
        resourceFactory = resourcefactory;
        uriExtractor = cachekeygenerator;
        cacheEntryUpdater = new CacheEntryUpdater(resourcefactory);
        maxObjectSizeBytes = cacheconfig.getMaxObjectSize();
        responseGenerator = new CachedHttpResponseGenerator();
        storage = httpcachestorage;
        cacheInvalidator = httpcacheinvalidator;
    }

    public BasicHttpCache(CacheConfig cacheconfig)
    {
        this(((ResourceFactory) (new HeapResourceFactory())), ((HttpCacheStorage) (new BasicHttpCacheStorage(cacheconfig))), cacheconfig);
    }

    private void addVariantWithEtag(String s, String s1, Map map)
        throws IOException
    {
        HttpCacheEntry httpcacheentry = storage.getEntry(s1);
        Header header;
        if (httpcacheentry != null)
        {
            if ((header = httpcacheentry.getFirstHeader("ETag")) != null)
            {
                map.put(header.getValue(), new Variant(s, s1, httpcacheentry));
                return;
            }
        }
    }

    public HttpResponse cacheAndReturnResponse(HttpHost httphost, HttpRequest httprequest, HttpResponse httpresponse, Date date, Date date1)
        throws IOException
    {
        return cacheAndReturnResponse(httphost, httprequest, Proxies.enhanceResponse(httpresponse), date, date1);
    }

    public CloseableHttpResponse cacheAndReturnResponse(HttpHost httphost, HttpRequest httprequest, CloseableHttpResponse closeablehttpresponse, Date date, Date date1)
        throws IOException
    {
        Object obj;
        boolean flag;
        boolean flag1;
        flag1 = true;
        obj = getResponseReader(httprequest, closeablehttpresponse);
        flag = flag1;
        ((SizeLimitedResponseReader) (obj)).readResponse();
        flag = flag1;
        if (!((SizeLimitedResponseReader) (obj)).isLimitReached()) goto _L2; else goto _L1
_L1:
        flag = false;
        httprequest = ((SizeLimitedResponseReader) (obj)).getReconstructedResponse();
        httphost = httprequest;
        if (false)
        {
            closeablehttpresponse.close();
            httphost = httprequest;
        }
_L4:
        return httphost;
_L2:
        flag = flag1;
        obj = ((SizeLimitedResponseReader) (obj)).getResource();
        flag = flag1;
        if (!isIncompleteResponse(closeablehttpresponse, ((Resource) (obj))))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        httprequest = generateIncompleteResponseError(closeablehttpresponse, ((Resource) (obj)));
        httphost = httprequest;
        if (true)
        {
            closeablehttpresponse.close();
            return httprequest;
        }
        if (true) goto _L4; else goto _L3
_L3:
        flag = flag1;
        date = new HttpCacheEntry(date, date1, closeablehttpresponse.getStatusLine(), closeablehttpresponse.getAllHeaders(), ((Resource) (obj)));
        flag = flag1;
        storeInCache(httphost, httprequest, date);
        flag = flag1;
        httprequest = responseGenerator.generateResponse(date);
        httphost = httprequest;
        if (false) goto _L4; else goto _L5
_L5:
        closeablehttpresponse.close();
        return httprequest;
        httphost;
        if (flag)
        {
            closeablehttpresponse.close();
        }
        throw httphost;
    }

    HttpCacheEntry doGetUpdatedParentEntry(String s, HttpCacheEntry httpcacheentry, HttpCacheEntry httpcacheentry1, String s1, String s2)
        throws IOException
    {
        HttpCacheEntry httpcacheentry2 = httpcacheentry;
        httpcacheentry = httpcacheentry2;
        if (httpcacheentry2 == null)
        {
            httpcacheentry = httpcacheentry1;
        }
        httpcacheentry1 = null;
        if (httpcacheentry.getResource() != null)
        {
            httpcacheentry1 = resourceFactory.copy(s, httpcacheentry.getResource());
        }
        s = new HashMap(httpcacheentry.getVariantMap());
        s.put(s1, s2);
        return new HttpCacheEntry(httpcacheentry.getRequestDate(), httpcacheentry.getResponseDate(), httpcacheentry.getStatusLine(), httpcacheentry.getAllHeaders(), httpcacheentry1, s);
    }

    public void flushCacheEntriesFor(HttpHost httphost, HttpRequest httprequest)
        throws IOException
    {
        if (!safeRequestMethods.contains(httprequest.getRequestLine().getMethod()))
        {
            httphost = uriExtractor.getURI(httphost, httprequest);
            storage.removeEntry(httphost);
        }
    }

    public void flushInvalidatedCacheEntriesFor(HttpHost httphost, HttpRequest httprequest)
        throws IOException
    {
        cacheInvalidator.flushInvalidatedCacheEntries(httphost, httprequest);
    }

    public void flushInvalidatedCacheEntriesFor(HttpHost httphost, HttpRequest httprequest, HttpResponse httpresponse)
    {
        if (!safeRequestMethods.contains(httprequest.getRequestLine().getMethod()))
        {
            cacheInvalidator.flushInvalidatedCacheEntries(httphost, httprequest, httpresponse);
        }
    }

    CloseableHttpResponse generateIncompleteResponseError(HttpResponse httpresponse, Resource resource)
    {
        int i = Integer.parseInt(httpresponse.getFirstHeader("Content-Length").getValue());
        httpresponse = new BasicHttpResponse(HttpVersion.HTTP_1_1, 502, "Bad Gateway");
        httpresponse.setHeader("Content-Type", "text/plain;charset=UTF-8");
        resource = String.format("Received incomplete response with Content-Length %d but actual body length %d", new Object[] {
            Integer.valueOf(i), Long.valueOf(resource.length())
        }).getBytes();
        httpresponse.setHeader("Content-Length", Integer.toString(resource.length));
        httpresponse.setEntity(new ByteArrayEntity(resource));
        return Proxies.enhanceResponse(httpresponse);
    }

    public HttpCacheEntry getCacheEntry(HttpHost httphost, HttpRequest httprequest)
        throws IOException
    {
        HttpCacheEntry httpcacheentry = storage.getEntry(uriExtractor.getURI(httphost, httprequest));
        if (httpcacheentry == null)
        {
            httphost = null;
        } else
        {
            httphost = httpcacheentry;
            if (httpcacheentry.hasVariants())
            {
                httphost = (String)httpcacheentry.getVariantMap().get(uriExtractor.getVariantKey(httprequest, httpcacheentry));
                if (httphost == null)
                {
                    return null;
                } else
                {
                    return storage.getEntry(httphost);
                }
            }
        }
        return httphost;
    }

    SizeLimitedResponseReader getResponseReader(HttpRequest httprequest, CloseableHttpResponse closeablehttpresponse)
    {
        return new SizeLimitedResponseReader(resourceFactory, maxObjectSizeBytes, httprequest, closeablehttpresponse);
    }

    public Map getVariantCacheEntriesWithEtags(HttpHost httphost, HttpRequest httprequest)
        throws IOException
    {
        HashMap hashmap = new HashMap();
        httphost = storage.getEntry(uriExtractor.getURI(httphost, httprequest));
        if (httphost != null && httphost.hasVariants())
        {
            httphost = httphost.getVariantMap().entrySet().iterator();
            while (httphost.hasNext()) 
            {
                httprequest = (java.util.Map.Entry)httphost.next();
                addVariantWithEtag((String)httprequest.getKey(), (String)httprequest.getValue(), hashmap);
            }
        }
        return hashmap;
    }

    boolean isIncompleteResponse(HttpResponse httpresponse, Resource resource)
    {
        int i = httpresponse.getStatusLine().getStatusCode();
        if (i == 200 || i == 206)
        {
            if ((httpresponse = httpresponse.getFirstHeader("Content-Length")) != null)
            {
                int j;
                try
                {
                    j = Integer.parseInt(httpresponse.getValue());
                }
                // Misplaced declaration of an exception variable
                catch (HttpResponse httpresponse)
                {
                    return false;
                }
                if (resource.length() < (long)j)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public void reuseVariantEntryFor(HttpHost httphost, final HttpRequest req, Variant variant)
        throws IOException
    {
        httphost = uriExtractor.getURI(httphost, req);
        final HttpCacheEntry entry = variant.getEntry();
        req = new HttpCacheUpdateCallback() {

            final BasicHttpCache this$0;
            final HttpCacheEntry val$entry;
            final HttpRequest val$req;
            final String val$variantCacheKey;
            final String val$variantKey;

            public HttpCacheEntry update(HttpCacheEntry httpcacheentry)
                throws IOException
            {
                return doGetUpdatedParentEntry(req.getRequestLine().getUri(), httpcacheentry, entry, variantKey, variantCacheKey);
            }

            
            {
                this$0 = BasicHttpCache.this;
                req = httprequest;
                entry = httpcacheentry;
                variantKey = s;
                variantCacheKey = s1;
                super();
            }
        };
        try
        {
            storage.updateEntry(httphost, req);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (final HttpRequest req)
        {
            log.warn((new StringBuilder()).append("Could not update key [").append(httphost).append("]").toString(), req);
        }
    }

    void storeInCache(HttpHost httphost, HttpRequest httprequest, HttpCacheEntry httpcacheentry)
        throws IOException
    {
        if (httpcacheentry.hasVariants())
        {
            storeVariantEntry(httphost, httprequest, httpcacheentry);
            return;
        } else
        {
            storeNonVariantEntry(httphost, httprequest, httpcacheentry);
            return;
        }
    }

    void storeNonVariantEntry(HttpHost httphost, HttpRequest httprequest, HttpCacheEntry httpcacheentry)
        throws IOException
    {
        httphost = uriExtractor.getURI(httphost, httprequest);
        storage.putEntry(httphost, httpcacheentry);
    }

    void storeVariantEntry(final HttpHost variantURI, final HttpRequest req, final HttpCacheEntry entry)
        throws IOException
    {
        String s = uriExtractor.getURI(variantURI, req);
        variantURI = uriExtractor.getVariantURI(variantURI, req, entry);
        storage.putEntry(variantURI, entry);
        variantURI = new HttpCacheUpdateCallback() {

            final BasicHttpCache this$0;
            final HttpCacheEntry val$entry;
            final HttpRequest val$req;
            final String val$variantURI;

            public HttpCacheEntry update(HttpCacheEntry httpcacheentry)
                throws IOException
            {
                return doGetUpdatedParentEntry(req.getRequestLine().getUri(), httpcacheentry, entry, uriExtractor.getVariantKey(req, entry), variantURI);
            }

            
            {
                this$0 = BasicHttpCache.this;
                req = httprequest;
                entry = httpcacheentry;
                variantURI = s;
                super();
            }
        };
        try
        {
            storage.updateEntry(s, variantURI);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (final HttpHost variantURI)
        {
            log.warn((new StringBuilder()).append("Could not update key [").append(s).append("]").toString(), variantURI);
        }
    }

    public HttpCacheEntry updateCacheEntry(HttpHost httphost, HttpRequest httprequest, HttpCacheEntry httpcacheentry, HttpResponse httpresponse, Date date, Date date1)
        throws IOException
    {
        httpcacheentry = cacheEntryUpdater.updateCacheEntry(httprequest.getRequestLine().getUri(), httpcacheentry, date, date1, httpresponse);
        storeInCache(httphost, httprequest, httpcacheentry);
        return httpcacheentry;
    }

    public HttpCacheEntry updateVariantCacheEntry(HttpHost httphost, HttpRequest httprequest, HttpCacheEntry httpcacheentry, HttpResponse httpresponse, Date date, Date date1, String s)
        throws IOException
    {
        httphost = cacheEntryUpdater.updateCacheEntry(httprequest.getRequestLine().getUri(), httpcacheentry, date, date1, httpresponse);
        storage.putEntry(s, httphost);
        return httphost;
    }


}
