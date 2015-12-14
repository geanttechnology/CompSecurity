// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.cache;


// Referenced classes of package com.facebook.imagepipeline.cache:
//            ImageCacheStatsTracker, InstrumentedMemoryCache, CountingMemoryCache, MemoryCache, 
//            MemoryCacheTracker

public class EncodedMemoryCacheFactory
{

    public EncodedMemoryCacheFactory()
    {
    }

    public static MemoryCache get(CountingMemoryCache countingmemorycache, ImageCacheStatsTracker imagecachestatstracker)
    {
        imagecachestatstracker.registerEncodedMemoryCache(countingmemorycache);
        return new InstrumentedMemoryCache(countingmemorycache, new MemoryCacheTracker(imagecachestatstracker) {

            final ImageCacheStatsTracker val$imageCacheStatsTracker;

            public void onCacheHit()
            {
                imageCacheStatsTracker.onMemoryCacheHit();
            }

            public void onCacheMiss()
            {
                imageCacheStatsTracker.onMemoryCacheMiss();
            }

            public void onCachePut()
            {
                imageCacheStatsTracker.onMemoryCachePut();
            }

            
            {
                imageCacheStatsTracker = imagecachestatstracker;
                super();
            }
        });
    }
}
