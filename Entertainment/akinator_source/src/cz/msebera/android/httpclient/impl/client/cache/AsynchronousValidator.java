// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;

// Referenced classes of package cz.msebera.android.httpclient.impl.client.cache:
//            ImmediateSchedulingStrategy, CacheKeyGenerator, DefaultFailureCache, SchedulingStrategy, 
//            FailureCache, AsynchronousValidationRequest, CacheConfig, CachingExec

class AsynchronousValidator
    implements Closeable
{

    private final CacheKeyGenerator cacheKeyGenerator;
    private final FailureCache failureCache;
    public HttpClientAndroidLog log;
    private final Set queued;
    private final SchedulingStrategy schedulingStrategy;

    public AsynchronousValidator(CacheConfig cacheconfig)
    {
        this(((SchedulingStrategy) (new ImmediateSchedulingStrategy(cacheconfig))));
    }

    AsynchronousValidator(SchedulingStrategy schedulingstrategy)
    {
        log = new HttpClientAndroidLog(getClass());
        schedulingStrategy = schedulingstrategy;
        queued = new HashSet();
        cacheKeyGenerator = new CacheKeyGenerator();
        failureCache = new DefaultFailureCache();
    }

    public void close()
        throws IOException
    {
        schedulingStrategy.close();
    }

    Set getScheduledIdentifiers()
    {
        return Collections.unmodifiableSet(queued);
    }

    void jobFailed(String s)
    {
        failureCache.increaseErrorCount(s);
    }

    void jobSuccessful(String s)
    {
        failureCache.resetErrorCount(s);
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

    public void revalidateCacheEntry(CachingExec cachingexec, HttpRoute httproute, HttpRequestWrapper httprequestwrapper, HttpClientContext httpclientcontext, HttpExecutionAware httpexecutionaware, HttpCacheEntry httpcacheentry)
    {
        this;
        JVM INSTR monitorenter ;
        String s;
        s = cacheKeyGenerator.getVariantURI(httpclientcontext.getTargetHost(), httprequestwrapper, httpcacheentry);
        if (queued.contains(s))
        {
            break MISSING_BLOCK_LABEL_86;
        }
        cachingexec = new AsynchronousValidationRequest(this, cachingexec, httproute, httprequestwrapper, httpclientcontext, httpexecutionaware, httpcacheentry, s, failureCache.getErrorCount(s));
        schedulingStrategy.schedule(cachingexec);
        queued.add(s);
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        cachingexec;
        log.debug((new StringBuilder()).append("Revalidation for [").append(s).append("] not scheduled: ").append(cachingexec).toString());
        if (true) goto _L2; else goto _L1
_L1:
        cachingexec;
        throw cachingexec;
    }
}
