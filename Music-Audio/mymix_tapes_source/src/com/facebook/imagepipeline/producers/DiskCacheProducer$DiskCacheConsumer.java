// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.image.EncodedImage;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            DelegatingConsumer, DiskCacheProducer, Consumer

private class <init> extends DelegatingConsumer
{

    private final BufferedDiskCache mCache;
    private final CacheKey mCacheKey;
    final DiskCacheProducer this$0;

    public void onNewResultImpl(EncodedImage encodedimage, boolean flag)
    {
        if (encodedimage != null && flag)
        {
            mCache.put(mCacheKey, encodedimage);
        }
        getConsumer().onNewResult(encodedimage, flag);
    }

    public volatile void onNewResultImpl(Object obj, boolean flag)
    {
        onNewResultImpl((EncodedImage)obj, flag);
    }

    private (Consumer consumer, BufferedDiskCache buffereddiskcache, CacheKey cachekey)
    {
        this$0 = DiskCacheProducer.this;
        super(consumer);
        mCache = buffereddiskcache;
        mCacheKey = cachekey;
    }

    mCacheKey(Consumer consumer, BufferedDiskCache buffereddiskcache, CacheKey cachekey, mCacheKey mcachekey)
    {
        this(consumer, buffereddiskcache, cachekey);
    }
}
