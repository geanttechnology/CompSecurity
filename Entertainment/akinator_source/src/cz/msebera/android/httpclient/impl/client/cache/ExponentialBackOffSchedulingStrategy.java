// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package cz.msebera.android.httpclient.impl.client.cache:
//            SchedulingStrategy, CacheConfig, AsynchronousValidationRequest

public class ExponentialBackOffSchedulingStrategy
    implements SchedulingStrategy
{

    public static final long DEFAULT_BACK_OFF_RATE = 10L;
    public static final long DEFAULT_INITIAL_EXPIRY_IN_MILLIS;
    public static final long DEFAULT_MAX_EXPIRY_IN_MILLIS;
    private final long backOffRate;
    private final ScheduledExecutorService executor;
    private final long initialExpiryInMillis;
    private final long maxExpiryInMillis;

    public ExponentialBackOffSchedulingStrategy(CacheConfig cacheconfig)
    {
        this(cacheconfig, 10L, DEFAULT_INITIAL_EXPIRY_IN_MILLIS, DEFAULT_MAX_EXPIRY_IN_MILLIS);
    }

    public ExponentialBackOffSchedulingStrategy(CacheConfig cacheconfig, long l, long l1, long l2)
    {
        this(((ScheduledExecutorService) (createThreadPoolFromCacheConfig(cacheconfig))), l, l1, l2);
    }

    ExponentialBackOffSchedulingStrategy(ScheduledExecutorService scheduledexecutorservice, long l, long l1, long l2)
    {
        executor = (ScheduledExecutorService)checkNotNull("executor", scheduledexecutorservice);
        backOffRate = checkNotNegative("backOffRate", l);
        initialExpiryInMillis = checkNotNegative("initialExpiryInMillis", l1);
        maxExpiryInMillis = checkNotNegative("maxExpiryInMillis", l2);
    }

    protected static long checkNotNegative(String s, long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder()).append(s).append(" may not be negative").toString());
        } else
        {
            return l;
        }
    }

    protected static Object checkNotNull(String s, Object obj)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append(s).append(" may not be null").toString());
        } else
        {
            return obj;
        }
    }

    private static ScheduledThreadPoolExecutor createThreadPoolFromCacheConfig(CacheConfig cacheconfig)
    {
        cacheconfig = new ScheduledThreadPoolExecutor(cacheconfig.getAsynchronousWorkersMax());
        cacheconfig.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
        return cacheconfig;
    }

    protected long calculateDelayInMillis(int i)
    {
        if (i > 0)
        {
            return Math.min((long)((double)initialExpiryInMillis * Math.pow(backOffRate, i - 1)), maxExpiryInMillis);
        } else
        {
            return 0L;
        }
    }

    public void close()
    {
        executor.shutdown();
    }

    public long getBackOffRate()
    {
        return backOffRate;
    }

    public long getInitialExpiryInMillis()
    {
        return initialExpiryInMillis;
    }

    public long getMaxExpiryInMillis()
    {
        return maxExpiryInMillis;
    }

    public void schedule(AsynchronousValidationRequest asynchronousvalidationrequest)
    {
        checkNotNull("revalidationRequest", asynchronousvalidationrequest);
        long l = calculateDelayInMillis(asynchronousvalidationrequest.getConsecutiveFailedAttempts());
        executor.schedule(asynchronousvalidationrequest, l, TimeUnit.MILLISECONDS);
    }

    static 
    {
        DEFAULT_INITIAL_EXPIRY_IN_MILLIS = TimeUnit.SECONDS.toMillis(6L);
        DEFAULT_MAX_EXPIRY_IN_MILLIS = TimeUnit.SECONDS.toMillis(0x15180L);
    }
}
