// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.client.cache;

import com.comcast.cim.httpcomponentsandroid.HttpHost;
import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.client.cache.HttpCacheEntry;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.client.cache:
//            CacheConfig, CacheKeyGenerator, AsynchronousValidationRequest, CachingHttpClient

class AsynchronousValidator
{

    private final CacheKeyGenerator cacheKeyGenerator;
    private final CachingHttpClient cachingClient;
    private final ExecutorService executor;
    private final Log log;
    private final Set queued;

    public AsynchronousValidator(CachingHttpClient cachinghttpclient, CacheConfig cacheconfig)
    {
        this(cachinghttpclient, ((ExecutorService) (new ThreadPoolExecutor(cacheconfig.getAsynchronousWorkersCore(), cacheconfig.getAsynchronousWorkersMax(), cacheconfig.getAsynchronousWorkerIdleLifetimeSecs(), TimeUnit.SECONDS, new ArrayBlockingQueue(cacheconfig.getRevalidationQueueSize())))));
    }

    AsynchronousValidator(CachingHttpClient cachinghttpclient, ExecutorService executorservice)
    {
        log = LogFactory.getLog(getClass());
        cachingClient = cachinghttpclient;
        executor = executorservice;
        queued = new HashSet();
        cacheKeyGenerator = new CacheKeyGenerator();
    }

    void markComplete(String s)
    {
        this;
        JVM INSTR monitorenter ;
        queued.remove(s);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void revalidateCacheEntry(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext, HttpCacheEntry httpcacheentry)
    {
        this;
        JVM INSTR monitorenter ;
        String s;
        s = cacheKeyGenerator.getVariantURI(httphost, httprequest, httpcacheentry);
        if (queued.contains(s))
        {
            break MISSING_BLOCK_LABEL_71;
        }
        httphost = new AsynchronousValidationRequest(this, cachingClient, httphost, httprequest, httpcontext, httpcacheentry, s);
        executor.execute(httphost);
        queued.add(s);
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        httphost;
        log.debug((new StringBuilder()).append("Revalidation for [").append(s).append("] not scheduled: ").append(httphost).toString());
        if (true) goto _L2; else goto _L1
_L1:
        httphost;
        throw httphost;
    }
}
