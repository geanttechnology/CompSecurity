// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            BitmapMemoryCacheProducer, Producer, Consumer

public class BitmapMemoryCacheGetProducer extends BitmapMemoryCacheProducer
{

    static final String PRODUCER_NAME = "BitmapMemoryCacheGetProducer";

    public BitmapMemoryCacheGetProducer(MemoryCache memorycache, CacheKeyFactory cachekeyfactory, Producer producer)
    {
        super(memorycache, cachekeyfactory, producer);
    }

    protected String getProducerName()
    {
        return "BitmapMemoryCacheGetProducer";
    }

    protected Consumer wrapConsumer(Consumer consumer, CacheKey cachekey)
    {
        return consumer;
    }
}
