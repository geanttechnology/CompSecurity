// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.client.cache;


public class CacheConfig
{

    private int asynchronousWorkerIdleLifetimeSecs;
    private int asynchronousWorkersCore;
    private int asynchronousWorkersMax;
    private boolean heuristicCachingEnabled;
    private float heuristicCoefficient;
    private long heuristicDefaultLifetime;
    private boolean isSharedCache;
    private int maxCacheEntries;
    private int maxObjectSizeBytes;
    private int maxUpdateRetries;
    private int revalidationQueueSize;

    public CacheConfig()
    {
        maxObjectSizeBytes = 8192;
        maxCacheEntries = 1000;
        maxUpdateRetries = 1;
        heuristicCachingEnabled = false;
        heuristicCoefficient = 0.1F;
        heuristicDefaultLifetime = 0L;
        isSharedCache = true;
        asynchronousWorkersMax = 1;
        asynchronousWorkersCore = 1;
        asynchronousWorkerIdleLifetimeSecs = 60;
        revalidationQueueSize = 100;
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

    public int getMaxObjectSizeBytes()
    {
        return maxObjectSizeBytes;
    }

    public int getMaxUpdateRetries()
    {
        return maxUpdateRetries;
    }

    public int getRevalidationQueueSize()
    {
        return revalidationQueueSize;
    }

    public boolean isHeuristicCachingEnabled()
    {
        return heuristicCachingEnabled;
    }

    public boolean isSharedCache()
    {
        return isSharedCache;
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

    public void setMaxObjectSizeBytes(int i)
    {
        maxObjectSizeBytes = i;
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
}
