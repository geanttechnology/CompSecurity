// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.cache;


// Referenced classes of package com.facebook.imagepipeline.cache:
//            CountingMemoryCache

public interface ImageCacheStatsTracker
{

    public abstract void onBitmapCacheHit();

    public abstract void onBitmapCacheMiss();

    public abstract void onBitmapCachePut();

    public abstract void onDiskCacheGetFail();

    public abstract void onDiskCacheHit();

    public abstract void onDiskCacheMiss();

    public abstract void onMemoryCacheHit();

    public abstract void onMemoryCacheMiss();

    public abstract void onMemoryCachePut();

    public abstract void onStagingAreaHit();

    public abstract void onStagingAreaMiss();

    public abstract void registerBitmapMemoryCache(CountingMemoryCache countingmemorycache);

    public abstract void registerEncodedMemoryCache(CountingMemoryCache countingmemorycache);
}
