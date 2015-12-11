// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.util.Args;

public class CacheConfig
    implements Cloneable
{
    public static class Builder
    {

        private boolean allow303Caching;
        private int asynchronousWorkerIdleLifetimeSecs;
        private int asynchronousWorkersCore;
        private int asynchronousWorkersMax;
        private boolean heuristicCachingEnabled;
        private float heuristicCoefficient;
        private long heuristicDefaultLifetime;
        private boolean isSharedCache;
        private int maxCacheEntries;
        private long maxObjectSize;
        private int maxUpdateRetries;
        private boolean neverCacheHTTP10ResponsesWithQuery;
        private int revalidationQueueSize;
        private boolean weakETagOnPutDeleteAllowed;

        public CacheConfig build()
        {
            return new CacheConfig(maxObjectSize, maxCacheEntries, maxUpdateRetries, allow303Caching, weakETagOnPutDeleteAllowed, heuristicCachingEnabled, heuristicCoefficient, heuristicDefaultLifetime, isSharedCache, asynchronousWorkersMax, asynchronousWorkersCore, asynchronousWorkerIdleLifetimeSecs, revalidationQueueSize, neverCacheHTTP10ResponsesWithQuery);
        }

        public Builder setAllow303Caching(boolean flag)
        {
            allow303Caching = flag;
            return this;
        }

        public Builder setAsynchronousWorkerIdleLifetimeSecs(int i)
        {
            asynchronousWorkerIdleLifetimeSecs = i;
            return this;
        }

        public Builder setAsynchronousWorkersCore(int i)
        {
            asynchronousWorkersCore = i;
            return this;
        }

        public Builder setAsynchronousWorkersMax(int i)
        {
            asynchronousWorkersMax = i;
            return this;
        }

        public Builder setHeuristicCachingEnabled(boolean flag)
        {
            heuristicCachingEnabled = flag;
            return this;
        }

        public Builder setHeuristicCoefficient(float f)
        {
            heuristicCoefficient = f;
            return this;
        }

        public Builder setHeuristicDefaultLifetime(long l)
        {
            heuristicDefaultLifetime = l;
            return this;
        }

        public Builder setMaxCacheEntries(int i)
        {
            maxCacheEntries = i;
            return this;
        }

        public Builder setMaxObjectSize(long l)
        {
            maxObjectSize = l;
            return this;
        }

        public Builder setMaxUpdateRetries(int i)
        {
            maxUpdateRetries = i;
            return this;
        }

        public Builder setNeverCacheHTTP10ResponsesWithQueryString(boolean flag)
        {
            neverCacheHTTP10ResponsesWithQuery = flag;
            return this;
        }

        public Builder setRevalidationQueueSize(int i)
        {
            revalidationQueueSize = i;
            return this;
        }

        public Builder setSharedCache(boolean flag)
        {
            isSharedCache = flag;
            return this;
        }

        public Builder setWeakETagOnPutDeleteAllowed(boolean flag)
        {
            weakETagOnPutDeleteAllowed = flag;
            return this;
        }

        Builder()
        {
            maxObjectSize = 8192L;
            maxCacheEntries = 1000;
            maxUpdateRetries = 1;
            allow303Caching = false;
            weakETagOnPutDeleteAllowed = false;
            heuristicCachingEnabled = false;
            heuristicCoefficient = 0.1F;
            heuristicDefaultLifetime = 0L;
            isSharedCache = true;
            asynchronousWorkersMax = 1;
            asynchronousWorkersCore = 1;
            asynchronousWorkerIdleLifetimeSecs = 60;
            revalidationQueueSize = 100;
        }
    }


    public static final CacheConfig DEFAULT = (new Builder()).build();
    public static final boolean DEFAULT_303_CACHING_ENABLED = false;
    public static final int DEFAULT_ASYNCHRONOUS_WORKERS_CORE = 1;
    public static final int DEFAULT_ASYNCHRONOUS_WORKERS_MAX = 1;
    public static final int DEFAULT_ASYNCHRONOUS_WORKER_IDLE_LIFETIME_SECS = 60;
    public static final boolean DEFAULT_HEURISTIC_CACHING_ENABLED = false;
    public static final float DEFAULT_HEURISTIC_COEFFICIENT = 0.1F;
    public static final long DEFAULT_HEURISTIC_LIFETIME = 0L;
    public static final int DEFAULT_MAX_CACHE_ENTRIES = 1000;
    public static final int DEFAULT_MAX_OBJECT_SIZE_BYTES = 8192;
    public static final int DEFAULT_MAX_UPDATE_RETRIES = 1;
    public static final int DEFAULT_REVALIDATION_QUEUE_SIZE = 100;
    public static final boolean DEFAULT_WEAK_ETAG_ON_PUTDELETE_ALLOWED = false;
    private boolean allow303Caching;
    private int asynchronousWorkerIdleLifetimeSecs;
    private int asynchronousWorkersCore;
    private int asynchronousWorkersMax;
    private boolean heuristicCachingEnabled;
    private float heuristicCoefficient;
    private long heuristicDefaultLifetime;
    private boolean isSharedCache;
    private int maxCacheEntries;
    private long maxObjectSize;
    private int maxUpdateRetries;
    private boolean neverCacheHTTP10ResponsesWithQuery;
    private int revalidationQueueSize;
    private boolean weakETagOnPutDeleteAllowed;

    public CacheConfig()
    {
        maxObjectSize = 8192L;
        maxCacheEntries = 1000;
        maxUpdateRetries = 1;
        allow303Caching = false;
        weakETagOnPutDeleteAllowed = false;
        heuristicCachingEnabled = false;
        heuristicCoefficient = 0.1F;
        heuristicDefaultLifetime = 0L;
        isSharedCache = true;
        asynchronousWorkersMax = 1;
        asynchronousWorkersCore = 1;
        asynchronousWorkerIdleLifetimeSecs = 60;
        revalidationQueueSize = 100;
    }

    CacheConfig(long l, int i, int j, boolean flag, boolean flag1, boolean flag2, 
            float f, long l1, boolean flag3, int k, int i1, int j1, 
            int k1, boolean flag4)
    {
        maxObjectSize = l;
        maxCacheEntries = i;
        maxUpdateRetries = j;
        allow303Caching = flag;
        weakETagOnPutDeleteAllowed = flag1;
        heuristicCachingEnabled = flag2;
        heuristicCoefficient = f;
        heuristicDefaultLifetime = l1;
        isSharedCache = flag3;
        asynchronousWorkersMax = k;
        asynchronousWorkersCore = i1;
        asynchronousWorkerIdleLifetimeSecs = j1;
        revalidationQueueSize = k1;
    }

    public static Builder copy(CacheConfig cacheconfig)
    {
        Args.notNull(cacheconfig, "Cache config");
        return (new Builder()).setMaxObjectSize(cacheconfig.getMaxObjectSize()).setMaxCacheEntries(cacheconfig.getMaxCacheEntries()).setMaxUpdateRetries(cacheconfig.getMaxUpdateRetries()).setHeuristicCachingEnabled(cacheconfig.isHeuristicCachingEnabled()).setHeuristicCoefficient(cacheconfig.getHeuristicCoefficient()).setHeuristicDefaultLifetime(cacheconfig.getHeuristicDefaultLifetime()).setSharedCache(cacheconfig.isSharedCache()).setAsynchronousWorkersMax(cacheconfig.getAsynchronousWorkersMax()).setAsynchronousWorkersCore(cacheconfig.getAsynchronousWorkersCore()).setAsynchronousWorkerIdleLifetimeSecs(cacheconfig.getAsynchronousWorkerIdleLifetimeSecs()).setRevalidationQueueSize(cacheconfig.getRevalidationQueueSize()).setNeverCacheHTTP10ResponsesWithQueryString(cacheconfig.isNeverCacheHTTP10ResponsesWithQuery());
    }

    public static Builder custom()
    {
        return new Builder();
    }

    protected CacheConfig clone()
        throws CloneNotSupportedException
    {
        return (CacheConfig)super.clone();
    }

    protected volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public int getAsynchronousWorkerIdleLifetimeSecs()
    {
        return asynchronousWorkerIdleLifetimeSecs;
    }

    public int getAsynchronousWorkersCore()
    {
        return asynchronousWorkersCore;
    }

    public int getAsynchronousWorkersMax()
    {
        return asynchronousWorkersMax;
    }

    public float getHeuristicCoefficient()
    {
        return heuristicCoefficient;
    }

    public long getHeuristicDefaultLifetime()
    {
        return heuristicDefaultLifetime;
    }

    public int getMaxCacheEntries()
    {
        return maxCacheEntries;
    }

    public long getMaxObjectSize()
    {
        return maxObjectSize;
    }

    public int getMaxObjectSizeBytes()
    {
        if (maxObjectSize > 0x7fffffffL)
        {
            return 0x7fffffff;
        } else
        {
            return (int)maxObjectSize;
        }
    }

    public int getMaxUpdateRetries()
    {
        return maxUpdateRetries;
    }

    public int getRevalidationQueueSize()
    {
        return revalidationQueueSize;
    }

    public boolean is303CachingEnabled()
    {
        return allow303Caching;
    }

    public boolean isHeuristicCachingEnabled()
    {
        return heuristicCachingEnabled;
    }

    public boolean isNeverCacheHTTP10ResponsesWithQuery()
    {
        return neverCacheHTTP10ResponsesWithQuery;
    }

    public boolean isSharedCache()
    {
        return isSharedCache;
    }

    public boolean isWeakETagOnPutDeleteAllowed()
    {
        return weakETagOnPutDeleteAllowed;
    }

    public void setAsynchronousWorkerIdleLifetimeSecs(int i)
    {
        asynchronousWorkerIdleLifetimeSecs = i;
    }

    public void setAsynchronousWorkersCore(int i)
    {
        asynchronousWorkersCore = i;
    }

    public void setAsynchronousWorkersMax(int i)
    {
        asynchronousWorkersMax = i;
    }

    public void setHeuristicCachingEnabled(boolean flag)
    {
        heuristicCachingEnabled = flag;
    }

    public void setHeuristicCoefficient(float f)
    {
        heuristicCoefficient = f;
    }

    public void setHeuristicDefaultLifetime(long l)
    {
        heuristicDefaultLifetime = l;
    }

    public void setMaxCacheEntries(int i)
    {
        maxCacheEntries = i;
    }

    public void setMaxObjectSize(long l)
    {
        maxObjectSize = l;
    }

    public void setMaxObjectSizeBytes(int i)
    {
        if (i > 0x7fffffff)
        {
            maxObjectSize = 0x7fffffffL;
            return;
        } else
        {
            maxObjectSize = i;
            return;
        }
    }

    public void setMaxUpdateRetries(int i)
    {
        maxUpdateRetries = i;
    }

    public void setRevalidationQueueSize(int i)
    {
        revalidationQueueSize = i;
    }

    public void setSharedCache(boolean flag)
    {
        isSharedCache = flag;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("[maxObjectSize=").append(maxObjectSize).append(", maxCacheEntries=").append(maxCacheEntries).append(", maxUpdateRetries=").append(maxUpdateRetries).append(", 303CachingEnabled=").append(allow303Caching).append(", weakETagOnPutDeleteAllowed=").append(weakETagOnPutDeleteAllowed).append(", heuristicCachingEnabled=").append(heuristicCachingEnabled).append(", heuristicCoefficient=").append(heuristicCoefficient).append(", heuristicDefaultLifetime=").append(heuristicDefaultLifetime).append(", isSharedCache=").append(isSharedCache).append(", asynchronousWorkersMax=").append(asynchronousWorkersMax).append(", asynchronousWorkersCore=").append(asynchronousWorkersCore).append(", asynchronousWorkerIdleLifetimeSecs=").append(asynchronousWorkerIdleLifetimeSecs).append(", revalidationQueueSize=").append(revalidationQueueSize).append(", neverCacheHTTP10ResponsesWithQuery=").append(neverCacheHTTP10ResponsesWithQuery).append("]");
        return stringbuilder.toString();
    }

}
