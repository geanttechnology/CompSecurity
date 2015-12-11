// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package cz.msebera.android.httpclient.impl.client.cache:
//            SchedulingStrategy, CacheConfig, AsynchronousValidationRequest

public class ImmediateSchedulingStrategy
    implements SchedulingStrategy
{

    private final ExecutorService executor;

    public ImmediateSchedulingStrategy(CacheConfig cacheconfig)
    {
        this(((ExecutorService) (new ThreadPoolExecutor(cacheconfig.getAsynchronousWorkersCore(), cacheconfig.getAsynchronousWorkersMax(), cacheconfig.getAsynchronousWorkerIdleLifetimeSecs(), TimeUnit.SECONDS, new ArrayBlockingQueue(cacheconfig.getRevalidationQueueSize())))));
    }

    ImmediateSchedulingStrategy(ExecutorService executorservice)
    {
        executor = executorservice;
    }

    void awaitTermination(long l, TimeUnit timeunit)
        throws InterruptedException
    {
        executor.awaitTermination(l, timeunit);
    }

    public void close()
    {
        executor.shutdown();
    }

    public void schedule(AsynchronousValidationRequest asynchronousvalidationrequest)
    {
        if (asynchronousvalidationrequest == null)
        {
            throw new IllegalArgumentException("AsynchronousValidationRequest may not be null");
        } else
        {
            executor.execute(asynchronousvalidationrequest);
            return;
        }
    }
}
