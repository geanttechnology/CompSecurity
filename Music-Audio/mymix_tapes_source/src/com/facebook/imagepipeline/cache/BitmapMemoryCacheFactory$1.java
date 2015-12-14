// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.cache;


// Referenced classes of package com.facebook.imagepipeline.cache:
//            MemoryCacheTracker, BitmapMemoryCacheFactory, ImageCacheStatsTracker

static final class val.imageCacheStatsTracker
    implements MemoryCacheTracker
{

    final ImageCacheStatsTracker val$imageCacheStatsTracker;

    public void onCacheHit()
    {
        val$imageCacheStatsTracker.onBitmapCacheHit();
    }

    public void onCacheMiss()
    {
        val$imageCacheStatsTracker.onBitmapCacheMiss();
    }

    public void onCachePut()
    {
        val$imageCacheStatsTracker.onBitmapCachePut();
    }

    A(ImageCacheStatsTracker imagecachestatstracker)
    {
        val$imageCacheStatsTracker = imagecachestatstracker;
        super();
    }
}
