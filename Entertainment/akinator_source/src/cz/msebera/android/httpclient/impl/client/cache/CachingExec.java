// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.cache.CacheResponseStatus;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.cache.HttpCacheStorage;
import cz.msebera.android.httpclient.client.cache.ResourceFactory;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.client.utils.DateUtils;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.execchain.ClientExecChain;
import cz.msebera.android.httpclient.message.BasicHttpResponse;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.VersionInfo;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package cz.msebera.android.httpclient.impl.client.cache:
//            BasicHttpCache, CacheConfig, CacheValidityPolicy, CachedHttpResponseGenerator, 
//            CacheableRequestPolicy, CachedResponseSuitabilityChecker, ConditionalRequestBuilder, ResponseProtocolCompliance, 
//            RequestProtocolCompliance, ResponseCachingPolicy, HttpCache, Proxies, 
//            RequestProtocolError, Variant, AsynchronousValidator, OptionsHttp11Response, 
//            IOUtils, InternalURIUtils

public class CachingExec
    implements ClientExecChain
{

    private static final boolean SUPPORTS_RANGE_AND_CONTENT_RANGE_HEADERS = false;
    private final AsynchronousValidator asynchRevalidator;
    private final ClientExecChain backend;
    private final CacheConfig cacheConfig;
    private final AtomicLong cacheHits;
    private final AtomicLong cacheMisses;
    private final AtomicLong cacheUpdates;
    private final CacheableRequestPolicy cacheableRequestPolicy;
    private final ConditionalRequestBuilder conditionalRequestBuilder;
    public HttpClientAndroidLog log;
    private final RequestProtocolCompliance requestCompliance;
    private final HttpCache responseCache;
    private final ResponseCachingPolicy responseCachingPolicy;
    private final ResponseProtocolCompliance responseCompliance;
    private final CachedHttpResponseGenerator responseGenerator;
    private final CachedResponseSuitabilityChecker suitabilityChecker;
    private final CacheValidityPolicy validityPolicy;
    private final Map viaHeaders;

    public CachingExec(ClientExecChain clientexecchain)
    {
        this(clientexecchain, ((HttpCache) (new BasicHttpCache())), CacheConfig.DEFAULT);
    }

    public CachingExec(ClientExecChain clientexecchain, ResourceFactory resourcefactory, HttpCacheStorage httpcachestorage, CacheConfig cacheconfig)
    {
        this(clientexecchain, ((HttpCache) (new BasicHttpCache(resourcefactory, httpcachestorage, cacheconfig))), cacheconfig);
    }

    public CachingExec(ClientExecChain clientexecchain, HttpCache httpcache, CacheConfig cacheconfig)
    {
        this(clientexecchain, httpcache, cacheconfig, ((AsynchronousValidator) (null)));
    }

    public CachingExec(ClientExecChain clientexecchain, HttpCache httpcache, CacheConfig cacheconfig, AsynchronousValidator asynchronousvalidator)
    {
        cacheHits = new AtomicLong();
        cacheMisses = new AtomicLong();
        cacheUpdates = new AtomicLong();
        viaHeaders = new HashMap(4);
        log = new HttpClientAndroidLog(getClass());
        Args.notNull(clientexecchain, "HTTP backend");
        Args.notNull(httpcache, "HttpCache");
        if (cacheconfig == null)
        {
            cacheconfig = CacheConfig.DEFAULT;
        }
        cacheConfig = cacheconfig;
        backend = clientexecchain;
        responseCache = httpcache;
        validityPolicy = new CacheValidityPolicy();
        responseGenerator = new CachedHttpResponseGenerator(validityPolicy);
        cacheableRequestPolicy = new CacheableRequestPolicy();
        suitabilityChecker = new CachedResponseSuitabilityChecker(validityPolicy, cacheConfig);
        conditionalRequestBuilder = new ConditionalRequestBuilder();
        responseCompliance = new ResponseProtocolCompliance();
        requestCompliance = new RequestProtocolCompliance(cacheConfig.isWeakETagOnPutDeleteAllowed());
        responseCachingPolicy = new ResponseCachingPolicy(cacheConfig.getMaxObjectSize(), cacheConfig.isSharedCache(), cacheConfig.isNeverCacheHTTP10ResponsesWithQuery(), cacheConfig.is303CachingEnabled());
        asynchRevalidator = asynchronousvalidator;
    }

    CachingExec(ClientExecChain clientexecchain, HttpCache httpcache, CacheValidityPolicy cachevaliditypolicy, ResponseCachingPolicy responsecachingpolicy, CachedHttpResponseGenerator cachedhttpresponsegenerator, CacheableRequestPolicy cacheablerequestpolicy, CachedResponseSuitabilityChecker cachedresponsesuitabilitychecker, 
            ConditionalRequestBuilder conditionalrequestbuilder, ResponseProtocolCompliance responseprotocolcompliance, RequestProtocolCompliance requestprotocolcompliance, CacheConfig cacheconfig, AsynchronousValidator asynchronousvalidator)
    {
        cacheHits = new AtomicLong();
        cacheMisses = new AtomicLong();
        cacheUpdates = new AtomicLong();
        viaHeaders = new HashMap(4);
        log = new HttpClientAndroidLog(getClass());
        if (cacheconfig == null)
        {
            cacheconfig = CacheConfig.DEFAULT;
        }
        cacheConfig = cacheconfig;
        backend = clientexecchain;
        responseCache = httpcache;
        validityPolicy = cachevaliditypolicy;
        responseCachingPolicy = responsecachingpolicy;
        responseGenerator = cachedhttpresponsegenerator;
        cacheableRequestPolicy = cacheablerequestpolicy;
        suitabilityChecker = cachedresponsesuitabilitychecker;
        conditionalRequestBuilder = conditionalrequestbuilder;
        responseCompliance = responseprotocolcompliance;
        requestCompliance = requestprotocolcompliance;
        asynchRevalidator = asynchronousvalidator;
    }

    private boolean alreadyHaveNewerCacheEntry(HttpHost httphost, HttpRequestWrapper httprequestwrapper, HttpResponse httpresponse)
    {
        Object obj = null;
        try
        {
            httphost = responseCache.getCacheEntry(httphost, httprequestwrapper);
        }
        // Misplaced declaration of an exception variable
        catch (HttpHost httphost)
        {
            httphost = obj;
        }
        if (httphost != null)
        {
            if ((httphost = httphost.getFirstHeader("Date")) != null && (httprequestwrapper = httpresponse.getFirstHeader("Date")) != null)
            {
                httphost = DateUtils.parseDate(httphost.getValue());
                httprequestwrapper = DateUtils.parseDate(httprequestwrapper.getValue());
                if (httphost != null && httprequestwrapper != null)
                {
                    return httprequestwrapper.before(httphost);
                }
            }
        }
        return false;
    }

    private boolean explicitFreshnessRequest(HttpRequestWrapper httprequestwrapper, HttpCacheEntry httpcacheentry, Date date)
    {
        httprequestwrapper = httprequestwrapper.getHeaders("Cache-Control");
        int k = httprequestwrapper.length;
        for (int i = 0; i < k; i++)
        {
            HeaderElement aheaderelement[] = httprequestwrapper[i].getElements();
            int l = aheaderelement.length;
            for (int j = 0; j < l; j++)
            {
                HeaderElement headerelement = aheaderelement[j];
                if ("max-stale".equals(headerelement.getName()))
                {
                    int i1;
                    long l1;
                    long l2;
                    try
                    {
                        i1 = Integer.parseInt(headerelement.getValue());
                        l1 = validityPolicy.getCurrentAgeSecs(httpcacheentry, date);
                        l2 = validityPolicy.getFreshnessLifetimeSecs(httpcacheentry);
                    }
                    // Misplaced declaration of an exception variable
                    catch (HttpRequestWrapper httprequestwrapper)
                    {
                        return true;
                    }
                    if (l1 - l2 > (long)i1)
                    {
                        return true;
                    }
                    continue;
                }
                if ("min-fresh".equals(headerelement.getName()) || "max-age".equals(headerelement.getName()))
                {
                    return true;
                }
            }

        }

        return false;
    }

    private void flushEntriesInvalidatedByRequest(HttpHost httphost, HttpRequestWrapper httprequestwrapper)
    {
        try
        {
            responseCache.flushInvalidatedCacheEntriesFor(httphost, httprequestwrapper);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HttpHost httphost)
        {
            log.warn("Unable to flush invalidated entries from cache", httphost);
        }
    }

    private CloseableHttpResponse generateCachedResponse(HttpRequestWrapper httprequestwrapper, HttpContext httpcontext, HttpCacheEntry httpcacheentry, Date date)
    {
        if (httprequestwrapper.containsHeader("If-None-Match") || httprequestwrapper.containsHeader("If-Modified-Since"))
        {
            httprequestwrapper = responseGenerator.generateNotModifiedResponse(httpcacheentry);
        } else
        {
            httprequestwrapper = responseGenerator.generateResponse(httpcacheentry);
        }
        setResponseStatus(httpcontext, CacheResponseStatus.CACHE_HIT);
        if (validityPolicy.getStalenessSecs(httpcacheentry, date) > 0L)
        {
            httprequestwrapper.addHeader("Warning", "110 localhost \"Response is stale\"");
        }
        return httprequestwrapper;
    }

    private CloseableHttpResponse generateGatewayTimeout(HttpContext httpcontext)
    {
        setResponseStatus(httpcontext, CacheResponseStatus.CACHE_MODULE_RESPONSE);
        return Proxies.enhanceResponse(new BasicHttpResponse(HttpVersion.HTTP_1_1, 504, "Gateway Timeout"));
    }

    private String generateViaHeader(HttpMessage httpmessage)
    {
        ProtocolVersion protocolversion = httpmessage.getProtocolVersion();
        httpmessage = (String)viaHeaders.get(protocolversion);
        if (httpmessage != null)
        {
            return httpmessage;
        }
        httpmessage = VersionInfo.loadVersionInfo("cz.msebera.android.httpclient.client", getClass().getClassLoader());
        if (httpmessage != null)
        {
            httpmessage = httpmessage.getRelease();
        } else
        {
            httpmessage = "UNAVAILABLE";
        }
        if ("http".equalsIgnoreCase(protocolversion.getProtocol()))
        {
            httpmessage = String.format("%d.%d localhost (Apache-HttpClient/%s (cache))", new Object[] {
                Integer.valueOf(protocolversion.getMajor()), Integer.valueOf(protocolversion.getMinor()), httpmessage
            });
        } else
        {
            httpmessage = String.format("%s/%d.%d localhost (Apache-HttpClient/%s (cache))", new Object[] {
                protocolversion.getProtocol(), Integer.valueOf(protocolversion.getMajor()), Integer.valueOf(protocolversion.getMinor()), httpmessage
            });
        }
        viaHeaders.put(protocolversion, httpmessage);
        return httpmessage;
    }

    private Map getExistingCacheVariants(HttpHost httphost, HttpRequestWrapper httprequestwrapper)
    {
        try
        {
            httphost = responseCache.getVariantCacheEntriesWithEtags(httphost, httprequestwrapper);
        }
        // Misplaced declaration of an exception variable
        catch (HttpHost httphost)
        {
            log.warn("Unable to retrieve variant entries from cache", httphost);
            return null;
        }
        return httphost;
    }

    private HttpResponse getFatallyNoncompliantResponse(HttpRequestWrapper httprequestwrapper, HttpContext httpcontext)
    {
        Object obj = null;
        Iterator iterator = requestCompliance.requestIsFatallyNonCompliant(httprequestwrapper).iterator();
        for (httprequestwrapper = obj; iterator.hasNext(); httprequestwrapper = requestCompliance.getErrorForRequest(httprequestwrapper))
        {
            httprequestwrapper = (RequestProtocolError)iterator.next();
            setResponseStatus(httpcontext, CacheResponseStatus.CACHE_MODULE_RESPONSE);
        }

        return httprequestwrapper;
    }

    private HttpCacheEntry getUpdatedVariantEntry(HttpHost httphost, HttpRequestWrapper httprequestwrapper, Date date, Date date1, CloseableHttpResponse closeablehttpresponse, Variant variant, HttpCacheEntry httpcacheentry)
        throws IOException
    {
        httphost = responseCache.updateVariantCacheEntry(httphost, httprequestwrapper, httpcacheentry, closeablehttpresponse, date, date1, variant.getCacheKey());
        closeablehttpresponse.close();
        return httphost;
        httphost;
        log.warn("Could not update cache entry", httphost);
        closeablehttpresponse.close();
        return httpcacheentry;
        httphost;
        closeablehttpresponse.close();
        throw httphost;
    }

    private CloseableHttpResponse handleCacheHit(HttpRoute httproute, HttpRequestWrapper httprequestwrapper, HttpClientContext httpclientcontext, HttpExecutionAware httpexecutionaware, HttpCacheEntry httpcacheentry)
        throws IOException, HttpException
    {
        HttpHost httphost;
        Date date;
        httphost = httpclientcontext.getTargetHost();
        recordCacheHit(httphost, httprequestwrapper);
        date = getCurrentDate();
        if (!suitabilityChecker.canCachedResponseBeUsed(httphost, httprequestwrapper, httpcacheentry, date)) goto _L2; else goto _L1
_L1:
        log.debug("Cache hit");
        httpexecutionaware = generateCachedResponse(httprequestwrapper, httpclientcontext, httpcacheentry, date);
_L4:
        httpclientcontext.setAttribute("http.route", httproute);
        httpclientcontext.setAttribute("http.target_host", httphost);
        httpclientcontext.setAttribute("http.request", httprequestwrapper);
        httpclientcontext.setAttribute("http.response", httpexecutionaware);
        httpclientcontext.setAttribute("http.request_sent", Boolean.TRUE);
        return httpexecutionaware;
_L2:
        if (mayCallBackend(httprequestwrapper))
        {
            break; /* Loop/switch isn't completed */
        }
        log.debug("Cache entry not suitable but only-if-cached requested");
        httpexecutionaware = generateGatewayTimeout(httpclientcontext);
        if (true) goto _L4; else goto _L3
_L3:
        if (httpcacheentry.getStatusCode() != 304 || suitabilityChecker.isConditional(httprequestwrapper))
        {
            log.debug("Revalidating cache entry");
            return revalidateCacheEntry(httproute, httprequestwrapper, httpclientcontext, httpexecutionaware, httpcacheentry, date);
        } else
        {
            log.debug("Cache entry not usable; calling backend");
            return callBackend(httproute, httprequestwrapper, httpclientcontext, httpexecutionaware);
        }
    }

    private CloseableHttpResponse handleCacheMiss(HttpRoute httproute, HttpRequestWrapper httprequestwrapper, HttpClientContext httpclientcontext, HttpExecutionAware httpexecutionaware)
        throws IOException, HttpException
    {
        Object obj = httpclientcontext.getTargetHost();
        recordCacheMiss(((HttpHost) (obj)), httprequestwrapper);
        if (!mayCallBackend(httprequestwrapper))
        {
            return Proxies.enhanceResponse(new BasicHttpResponse(HttpVersion.HTTP_1_1, 504, "Gateway Timeout"));
        }
        obj = getExistingCacheVariants(((HttpHost) (obj)), httprequestwrapper);
        if (obj != null && ((Map) (obj)).size() > 0)
        {
            return negotiateResponseFromVariants(httproute, httprequestwrapper, httpclientcontext, httpexecutionaware, ((Map) (obj)));
        } else
        {
            return callBackend(httproute, httprequestwrapper, httpclientcontext, httpexecutionaware);
        }
    }

    private CloseableHttpResponse handleRevalidationFailure(HttpRequestWrapper httprequestwrapper, HttpContext httpcontext, HttpCacheEntry httpcacheentry, Date date)
    {
        if (staleResponseNotAllowed(httprequestwrapper, httpcacheentry, date))
        {
            return generateGatewayTimeout(httpcontext);
        } else
        {
            return unvalidatedCacheHit(httpcontext, httpcacheentry);
        }
    }

    private boolean mayCallBackend(HttpRequestWrapper httprequestwrapper)
    {
        httprequestwrapper = httprequestwrapper.getHeaders("Cache-Control");
        int k = httprequestwrapper.length;
        for (int i = 0; i < k; i++)
        {
            HeaderElement aheaderelement[] = httprequestwrapper[i].getElements();
            int l = aheaderelement.length;
            for (int j = 0; j < l; j++)
            {
                if ("only-if-cached".equals(aheaderelement[j].getName()))
                {
                    log.trace("Request marked only-if-cached");
                    return false;
                }
            }

        }

        return true;
    }

    private void recordCacheHit(HttpHost httphost, HttpRequestWrapper httprequestwrapper)
    {
        cacheHits.getAndIncrement();
        if (log.isTraceEnabled())
        {
            httprequestwrapper = httprequestwrapper.getRequestLine();
            log.trace((new StringBuilder()).append("Cache hit [host: ").append(httphost).append("; uri: ").append(httprequestwrapper.getUri()).append("]").toString());
        }
    }

    private void recordCacheMiss(HttpHost httphost, HttpRequestWrapper httprequestwrapper)
    {
        cacheMisses.getAndIncrement();
        if (log.isTraceEnabled())
        {
            httprequestwrapper = httprequestwrapper.getRequestLine();
            log.trace((new StringBuilder()).append("Cache miss [host: ").append(httphost).append("; uri: ").append(httprequestwrapper.getUri()).append("]").toString());
        }
    }

    private void recordCacheUpdate(HttpContext httpcontext)
    {
        cacheUpdates.getAndIncrement();
        setResponseStatus(httpcontext, CacheResponseStatus.VALIDATED);
    }

    private CloseableHttpResponse retryRequestUnconditionally(HttpRoute httproute, HttpRequestWrapper httprequestwrapper, HttpClientContext httpclientcontext, HttpExecutionAware httpexecutionaware, HttpCacheEntry httpcacheentry)
        throws IOException, HttpException
    {
        return callBackend(httproute, conditionalRequestBuilder.buildUnconditionalRequest(httprequestwrapper, httpcacheentry), httpclientcontext, httpexecutionaware);
    }

    private CloseableHttpResponse revalidateCacheEntry(HttpRoute httproute, HttpRequestWrapper httprequestwrapper, HttpClientContext httpclientcontext, HttpExecutionAware httpexecutionaware, HttpCacheEntry httpcacheentry, Date date)
        throws HttpException
    {
        CloseableHttpResponse closeablehttpresponse;
        if (asynchRevalidator == null || staleResponseNotAllowed(httprequestwrapper, httpcacheentry, date) || !validityPolicy.mayReturnStaleWhileRevalidating(httpcacheentry, date))
        {
            break MISSING_BLOCK_LABEL_73;
        }
        log.trace("Serving stale with asynchronous revalidation");
        closeablehttpresponse = generateCachedResponse(httprequestwrapper, httpclientcontext, httpcacheentry, date);
        asynchRevalidator.revalidateCacheEntry(this, httproute, httprequestwrapper, httpclientcontext, httpexecutionaware, httpcacheentry);
        return closeablehttpresponse;
        try
        {
            httproute = revalidateCacheEntry(httproute, httprequestwrapper, httpclientcontext, httpexecutionaware, httpcacheentry);
        }
        // Misplaced declaration of an exception variable
        catch (HttpRoute httproute)
        {
            return handleRevalidationFailure(httprequestwrapper, httpclientcontext, httpcacheentry, date);
        }
        return httproute;
    }

    private boolean revalidationResponseIsTooOld(HttpResponse httpresponse, HttpCacheEntry httpcacheentry)
    {
        httpcacheentry = httpcacheentry.getFirstHeader("Date");
        httpresponse = httpresponse.getFirstHeader("Date");
        if (httpcacheentry != null && httpresponse != null)
        {
            httpcacheentry = DateUtils.parseDate(httpcacheentry.getValue());
            httpresponse = DateUtils.parseDate(httpresponse.getValue());
            break MISSING_BLOCK_LABEL_44;
        }
        do
        {
            return false;
        } while (httpcacheentry == null || httpresponse == null || !httpresponse.before(httpcacheentry));
        return true;
    }

    private HttpCacheEntry satisfyFromCache(HttpHost httphost, HttpRequestWrapper httprequestwrapper)
    {
        try
        {
            httphost = responseCache.getCacheEntry(httphost, httprequestwrapper);
        }
        // Misplaced declaration of an exception variable
        catch (HttpHost httphost)
        {
            log.warn("Unable to retrieve entries from cache", httphost);
            return null;
        }
        return httphost;
    }

    private void setResponseStatus(HttpContext httpcontext, CacheResponseStatus cacheresponsestatus)
    {
        if (httpcontext != null)
        {
            httpcontext.setAttribute("http.cache.response.status", cacheresponsestatus);
        }
    }

    private boolean shouldSendNotModifiedResponse(HttpRequestWrapper httprequestwrapper, HttpCacheEntry httpcacheentry)
    {
        return suitabilityChecker.isConditional(httprequestwrapper) && suitabilityChecker.allConditionalsMatch(httprequestwrapper, httpcacheentry, new Date());
    }

    private boolean staleIfErrorAppliesTo(int i)
    {
        return i == 500 || i == 502 || i == 503 || i == 504;
    }

    private boolean staleResponseNotAllowed(HttpRequestWrapper httprequestwrapper, HttpCacheEntry httpcacheentry, Date date)
    {
        return validityPolicy.mustRevalidate(httpcacheentry) || cacheConfig.isSharedCache() && validityPolicy.proxyRevalidate(httpcacheentry) || explicitFreshnessRequest(httprequestwrapper, httpcacheentry, date);
    }

    private void storeRequestIfModifiedSinceFor304Response(HttpRequest httprequest, HttpResponse httpresponse)
    {
        if (httpresponse.getStatusLine().getStatusCode() == 304)
        {
            httprequest = httprequest.getFirstHeader("If-Modified-Since");
            if (httprequest != null)
            {
                httpresponse.addHeader("Last-Modified", httprequest.getValue());
            }
        }
    }

    private void tryToUpdateVariantMap(HttpHost httphost, HttpRequestWrapper httprequestwrapper, Variant variant)
    {
        try
        {
            responseCache.reuseVariantEntryFor(httphost, httprequestwrapper, variant);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HttpHost httphost)
        {
            log.warn("Could not update cache entry to reuse variant", httphost);
        }
    }

    private CloseableHttpResponse unvalidatedCacheHit(HttpContext httpcontext, HttpCacheEntry httpcacheentry)
    {
        httpcacheentry = responseGenerator.generateResponse(httpcacheentry);
        setResponseStatus(httpcontext, CacheResponseStatus.CACHE_HIT);
        httpcacheentry.addHeader("Warning", "111 localhost \"Revalidation failed\"");
        return httpcacheentry;
    }

    CloseableHttpResponse callBackend(HttpRoute httproute, HttpRequestWrapper httprequestwrapper, HttpClientContext httpclientcontext, HttpExecutionAware httpexecutionaware)
        throws IOException, HttpException
    {
        Date date = getCurrentDate();
        log.trace("Calling the backend");
        CloseableHttpResponse closeablehttpresponse = backend.execute(httproute, httprequestwrapper, httpclientcontext, httpexecutionaware);
        try
        {
            closeablehttpresponse.addHeader("Via", generateViaHeader(closeablehttpresponse));
            httproute = handleBackendResponse(httproute, httprequestwrapper, httpclientcontext, httpexecutionaware, date, getCurrentDate(), closeablehttpresponse);
        }
        // Misplaced declaration of an exception variable
        catch (HttpRoute httproute)
        {
            closeablehttpresponse.close();
            throw httproute;
        }
        // Misplaced declaration of an exception variable
        catch (HttpRoute httproute)
        {
            closeablehttpresponse.close();
            throw httproute;
        }
        return httproute;
    }

    boolean clientRequestsOurOptions(HttpRequest httprequest)
    {
        for (RequestLine requestline = httprequest.getRequestLine(); !"OPTIONS".equals(requestline.getMethod()) || !"*".equals(requestline.getUri()) || !"0".equals(httprequest.getFirstHeader("Max-Forwards").getValue());)
        {
            return false;
        }

        return true;
    }

    public CloseableHttpResponse execute(HttpRoute httproute, HttpRequestWrapper httprequestwrapper)
        throws IOException, HttpException
    {
        return execute(httproute, httprequestwrapper, HttpClientContext.create(), null);
    }

    public CloseableHttpResponse execute(HttpRoute httproute, HttpRequestWrapper httprequestwrapper, HttpClientContext httpclientcontext)
        throws IOException, HttpException
    {
        return execute(httproute, httprequestwrapper, httpclientcontext, null);
    }

    public CloseableHttpResponse execute(HttpRoute httproute, HttpRequestWrapper httprequestwrapper, HttpClientContext httpclientcontext, HttpExecutionAware httpexecutionaware)
        throws IOException, HttpException
    {
        Object obj = httpclientcontext.getTargetHost();
        String s = generateViaHeader(httprequestwrapper.getOriginal());
        setResponseStatus(httpclientcontext, CacheResponseStatus.CACHE_MISS);
        if (clientRequestsOurOptions(httprequestwrapper))
        {
            setResponseStatus(httpclientcontext, CacheResponseStatus.CACHE_MODULE_RESPONSE);
            return Proxies.enhanceResponse(new OptionsHttp11Response());
        }
        HttpResponse httpresponse = getFatallyNoncompliantResponse(httprequestwrapper, httpclientcontext);
        if (httpresponse != null)
        {
            return Proxies.enhanceResponse(httpresponse);
        }
        requestCompliance.makeRequestCompliant(httprequestwrapper);
        httprequestwrapper.addHeader("Via", s);
        flushEntriesInvalidatedByRequest(httpclientcontext.getTargetHost(), httprequestwrapper);
        if (!cacheableRequestPolicy.isServableFromCache(httprequestwrapper))
        {
            log.debug("Request is not servable from cache");
            return callBackend(httproute, httprequestwrapper, httpclientcontext, httpexecutionaware);
        }
        obj = satisfyFromCache(((HttpHost) (obj)), httprequestwrapper);
        if (obj == null)
        {
            log.debug("Cache miss");
            return handleCacheMiss(httproute, httprequestwrapper, httpclientcontext, httpexecutionaware);
        } else
        {
            return handleCacheHit(httproute, httprequestwrapper, httpclientcontext, httpexecutionaware, ((HttpCacheEntry) (obj)));
        }
    }

    public long getCacheHits()
    {
        return cacheHits.get();
    }

    public long getCacheMisses()
    {
        return cacheMisses.get();
    }

    public long getCacheUpdates()
    {
        return cacheUpdates.get();
    }

    Date getCurrentDate()
    {
        return new Date();
    }

    CloseableHttpResponse handleBackendResponse(HttpRoute httproute, HttpRequestWrapper httprequestwrapper, HttpClientContext httpclientcontext, HttpExecutionAware httpexecutionaware, Date date, Date date1, CloseableHttpResponse closeablehttpresponse)
        throws IOException
    {
        log.trace("Handling Backend response");
        responseCompliance.ensureProtocolCompliance(httprequestwrapper, closeablehttpresponse);
        httpclientcontext = httpclientcontext.getTargetHost();
        boolean flag = responseCachingPolicy.isResponseCacheable(httprequestwrapper, closeablehttpresponse);
        responseCache.flushInvalidatedCacheEntriesFor(httpclientcontext, httprequestwrapper, closeablehttpresponse);
        if (flag && !alreadyHaveNewerCacheEntry(httpclientcontext, httprequestwrapper, closeablehttpresponse))
        {
            storeRequestIfModifiedSinceFor304Response(httprequestwrapper, closeablehttpresponse);
            httproute = responseCache.cacheAndReturnResponse(httpclientcontext, httprequestwrapper, closeablehttpresponse, date, date1);
        } else
        {
            httproute = closeablehttpresponse;
            if (!flag)
            {
                try
                {
                    responseCache.flushCacheEntriesFor(httpclientcontext, httprequestwrapper);
                }
                // Misplaced declaration of an exception variable
                catch (HttpRoute httproute)
                {
                    log.warn("Unable to flush invalid cache entries", httproute);
                    return closeablehttpresponse;
                }
                return closeablehttpresponse;
            }
        }
        return httproute;
    }

    CloseableHttpResponse negotiateResponseFromVariants(HttpRoute httproute, HttpRequestWrapper httprequestwrapper, HttpClientContext httpclientcontext, HttpExecutionAware httpexecutionaware, Map map)
        throws IOException, HttpException
    {
        HttpRequestWrapper httprequestwrapper1 = conditionalRequestBuilder.buildConditionalRequestFromVariants(httprequestwrapper, map);
        Date date = getCurrentDate();
        CloseableHttpResponse closeablehttpresponse = backend.execute(httproute, httprequestwrapper1, httpclientcontext, httpexecutionaware);
        Date date1;
        Object obj;
        try
        {
            date1 = getCurrentDate();
            closeablehttpresponse.addHeader("Via", generateViaHeader(closeablehttpresponse));
            if (closeablehttpresponse.getStatusLine().getStatusCode() != 304)
            {
                return handleBackendResponse(httproute, httprequestwrapper, httpclientcontext, httpexecutionaware, date, date1, closeablehttpresponse);
            }
            obj = closeablehttpresponse.getFirstHeader("ETag");
        }
        // Misplaced declaration of an exception variable
        catch (HttpRoute httproute)
        {
            closeablehttpresponse.close();
            throw httproute;
        }
        // Misplaced declaration of an exception variable
        catch (HttpRoute httproute)
        {
            closeablehttpresponse.close();
            throw httproute;
        }
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        log.warn("304 response did not contain ETag");
        IOUtils.consume(closeablehttpresponse.getEntity());
        closeablehttpresponse.close();
        return callBackend(httproute, httprequestwrapper, httpclientcontext, httpexecutionaware);
        map = (Variant)map.get(((Header) (obj)).getValue());
        if (map != null)
        {
            break MISSING_BLOCK_LABEL_206;
        }
        log.debug("304 response did not contain ETag matching one sent in If-None-Match");
        IOUtils.consume(closeablehttpresponse.getEntity());
        closeablehttpresponse.close();
        return callBackend(httproute, httprequestwrapper, httpclientcontext, httpexecutionaware);
        obj = map.getEntry();
        if (revalidationResponseIsTooOld(closeablehttpresponse, ((HttpCacheEntry) (obj))))
        {
            IOUtils.consume(closeablehttpresponse.getEntity());
            closeablehttpresponse.close();
            return retryRequestUnconditionally(httproute, httprequestwrapper, httpclientcontext, httpexecutionaware, ((HttpCacheEntry) (obj)));
        }
        recordCacheUpdate(httpclientcontext);
        httproute = getUpdatedVariantEntry(httpclientcontext.getTargetHost(), httprequestwrapper1, date, date1, closeablehttpresponse, map, ((HttpCacheEntry) (obj)));
        closeablehttpresponse.close();
        httpexecutionaware = responseGenerator.generateResponse(httproute);
        tryToUpdateVariantMap(httpclientcontext.getTargetHost(), httprequestwrapper, map);
        if (!shouldSendNotModifiedResponse(httprequestwrapper, httproute))
        {
            break MISSING_BLOCK_LABEL_347;
        }
        httproute = responseGenerator.generateNotModifiedResponse(httproute);
        return httproute;
        return httpexecutionaware;
    }

    CloseableHttpResponse revalidateCacheEntry(HttpRoute httproute, HttpRequestWrapper httprequestwrapper, HttpClientContext httpclientcontext, HttpExecutionAware httpexecutionaware, HttpCacheEntry httpcacheentry)
        throws IOException, HttpException
    {
        Object obj;
        Date date;
        Date date1;
        HttpRequestWrapper httprequestwrapper1;
        httprequestwrapper1 = conditionalRequestBuilder.buildConditionalRequest(httprequestwrapper, httpcacheentry);
        obj = httprequestwrapper1.getURI();
        CloseableHttpResponse closeablehttpresponse;
        int i;
        if (obj != null)
        {
            try
            {
                httprequestwrapper1.setURI(InternalURIUtils.rewriteURIForRoute(((java.net.URI) (obj)), httproute));
            }
            // Misplaced declaration of an exception variable
            catch (HttpRoute httproute)
            {
                throw new ProtocolException((new StringBuilder()).append("Invalid URI: ").append(obj).toString(), httproute);
            }
        }
        date = getCurrentDate();
        closeablehttpresponse = backend.execute(httproute, httprequestwrapper1, httpclientcontext, httpexecutionaware);
        date1 = getCurrentDate();
        obj = closeablehttpresponse;
        if (revalidationResponseIsTooOld(closeablehttpresponse, httpcacheentry))
        {
            closeablehttpresponse.close();
            obj = conditionalRequestBuilder.buildUnconditionalRequest(httprequestwrapper, httpcacheentry);
            date = getCurrentDate();
            obj = backend.execute(httproute, ((HttpRequestWrapper) (obj)), httpclientcontext, httpexecutionaware);
            date1 = getCurrentDate();
        }
        ((CloseableHttpResponse) (obj)).addHeader("Via", generateViaHeader(((HttpMessage) (obj))));
        i = ((CloseableHttpResponse) (obj)).getStatusLine().getStatusCode();
        if (i == 304 || i == 200)
        {
            recordCacheUpdate(httpclientcontext);
        }
        if (i == 304)
        {
            httproute = responseCache.updateCacheEntry(httpclientcontext.getTargetHost(), httprequestwrapper, httpcacheentry, ((HttpResponse) (obj)), date, date1);
            if (suitabilityChecker.isConditional(httprequestwrapper) && suitabilityChecker.allConditionalsMatch(httprequestwrapper, httproute, new Date()))
            {
                return responseGenerator.generateNotModifiedResponse(httproute);
            } else
            {
                return responseGenerator.generateResponse(httproute);
            }
        }
        if (!staleIfErrorAppliesTo(i) || staleResponseNotAllowed(httprequestwrapper, httpcacheentry, getCurrentDate()) || !validityPolicy.mayReturnStaleIfError(httprequestwrapper, httpcacheentry, date1))
        {
            break MISSING_BLOCK_LABEL_367;
        }
        httproute = responseGenerator.generateResponse(httpcacheentry);
        httproute.addHeader("Warning", "110 localhost \"Response is stale\"");
        ((CloseableHttpResponse) (obj)).close();
        return httproute;
        httproute;
        ((CloseableHttpResponse) (obj)).close();
        throw httproute;
        return handleBackendResponse(httproute, httprequestwrapper1, httpclientcontext, httpexecutionaware, date, date1, ((CloseableHttpResponse) (obj)));
    }

    public boolean supportsRangeAndContentRangeHeaders()
    {
        return false;
    }
}
