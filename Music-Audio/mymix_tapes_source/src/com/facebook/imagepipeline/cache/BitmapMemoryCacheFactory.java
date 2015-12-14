// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.cache;


// Referenced classes of package com.facebook.imagepipeline.cache:
//            ImageCacheStatsTracker, InstrumentedMemoryCache, CountingMemoryCache, MemoryCache, 
//            MemoryCacheTracker

public class BitmapMemoryCacheFactory
{

    public BitmapMemoryCacheFactory()
    {
    }

    public static MemoryCache get(CountingMemoryCache countingmemorycache, ImageCacheStatsTracker imagecachestatstracker)
    {
        imagecachestatstracker.registerBitmapMemoryCache(countingmemorycache);
        return new InstrumentedMemoryCache(countingmemorycache, new MemoryCacheTracker(imagecachestatstracker) {

            final ImageCacheStatsTracker val$imageCacheStatsTracker;

            public void onCacheHit()
            {
                imageCacheStatsTracker.onBitmapCacheHit();
            }

            public void onCacheMiss()
            {
                imageCacheStatsTracker.onBitmapCacheMiss();
            }

            public void onCachePut()
            {
                imageCacheStatsTracker.onBitmapCachePut();
            }

            
            {
                imageCacheStatsTracker = imagecachestatstracker;
                super();
            }
        });
    }
}
