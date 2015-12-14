// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.cache;


// Referenced classes of package com.facebook.imagepipeline.cache:
//            ImageCacheStatsTracker, CountingMemoryCache

public class NoOpImageCacheStatsTracker
    implements ImageCacheStatsTracker
{

    private static NoOpImageCacheStatsTracker sInstance = null;

    private NoOpImageCacheStatsTracker()
    {
    }

    public static NoOpImageCacheStatsTracker getInstance()
    {
        com/facebook/imagepipeline/cache/NoOpImageCacheStatsTracker;
        JVM INSTR monitorenter ;
        NoOpImageCacheStatsTracker noopimagecachestatstracker;
        if (sInstance == null)
        {
            sInstance = new NoOpImageCacheStatsTracker();
        }
        noopimagecachestatstracker = sInstance;
        com/facebook/imagepipeline/cache/NoOpImageCacheStatsTracker;
        JVM INSTR monitorexit ;
        return noopimagecachestatstracker;
        Exception exception;
        exception;
        throw exception;
    }

    public void onBitmapCacheHit()
    {
    }

    public void onBitmapCacheMiss()
    {
    }

    public void onBitmapCachePut()
    {
    }

    public void onDiskCacheGetFail()
    {
    }

    public void onDiskCacheHit()
    {
    }

    public void onDiskCacheMiss()
    {
    }

    public void onMemoryCacheHit()
    {
    }

    public void onMemoryCacheMiss()
    {
    }

    public void onMemoryCachePut()
    {
    }

    public void onStagingAreaHit()
    {
    }

    public void onStagingAreaMiss()
    {
    }

    public void registerBitmapMemoryCache(CountingMemoryCache countingmemorycache)
    {
    }

    public void registerEncodedMemoryCache(CountingMemoryCache countingmemorycache)
    {
    }

}
