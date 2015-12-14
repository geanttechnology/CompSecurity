// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.EncodedImage;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            Producer, ProducerContext, ProducerListener, Consumer, 
//            DelegatingConsumer

public class EncodedMemoryCacheProducer
    implements Producer
{

    static final String PRODUCER_NAME = "EncodedMemoryCacheProducer";
    static final String VALUE_FOUND = "cached_value_found";
    private final CacheKeyFactory mCacheKeyFactory;
    private final MemoryCache mMemoryCache;
    private final Producer mNextProducer;

    public EncodedMemoryCacheProducer(MemoryCache memorycache, CacheKeyFactory cachekeyfactory, Producer producer)
    {
        mMemoryCache = memorycache;
        mCacheKeyFactory = cachekeyfactory;
        mNextProducer = producer;
    }

    public void produceResults(final Consumer final_consumer, ProducerContext producercontext)
    {
        DelegatingConsumer delegatingconsumer;
        EncodedImage encodedimage;
        Object obj;
        Object obj1;
        String s;
        ProducerListener producerlistener;
        CacheKey cachekey;
        obj = null;
        encodedimage = null;
        delegatingconsumer = null;
        s = producercontext.getId();
        producerlistener = producercontext.getListener();
        producerlistener.onProducerStart(s, "EncodedMemoryCacheProducer");
        obj1 = producercontext.getImageRequest();
        cachekey = mCacheKeyFactory.getEncodedCacheKey(((com.facebook.imagepipeline.request.ImageRequest) (obj1)));
        obj1 = mMemoryCache.get(cachekey);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        encodedimage = new EncodedImage(((CloseableReference) (obj1)));
        producercontext = delegatingconsumer;
        if (producerlistener.requiresExtraMap(s))
        {
            producercontext = ImmutableMap.of("cached_value_found", "true");
        }
        producerlistener.onProducerFinishWithSuccess(s, "EncodedMemoryCacheProducer", producercontext);
        final_consumer.onProgressUpdate(1.0F);
        final_consumer.onNewResult(encodedimage, true);
        EncodedImage.closeSafely(encodedimage);
        CloseableReference.closeSafely(((CloseableReference) (obj1)));
        return;
        final_consumer;
        EncodedImage.closeSafely(encodedimage);
        throw final_consumer;
        final_consumer;
        CloseableReference.closeSafely(((CloseableReference) (obj1)));
        throw final_consumer;
        if (producercontext.getLowestPermittedRequestLevel().getValue() < com.facebook.imagepipeline.request.ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue())
        {
            break MISSING_BLOCK_LABEL_229;
        }
        producercontext = obj;
        if (producerlistener.requiresExtraMap(s))
        {
            producercontext = ImmutableMap.of("cached_value_found", "false");
        }
        producerlistener.onProducerFinishWithSuccess(s, "EncodedMemoryCacheProducer", producercontext);
        final_consumer.onNewResult(null, true);
        CloseableReference.closeSafely(((CloseableReference) (obj1)));
        return;
        delegatingconsumer = new DelegatingConsumer(cachekey) {

            final EncodedMemoryCacheProducer this$0;
            final CacheKey val$cacheKey;

            public void onNewResultImpl(EncodedImage encodedimage1, boolean flag)
            {
                Object obj2;
                if (!flag || encodedimage1 == null)
                {
                    getConsumer().onNewResult(encodedimage1, flag);
                    return;
                }
                obj2 = encodedimage1.getByteBufferRef();
                if (obj2 == null)
                {
                    break MISSING_BLOCK_LABEL_130;
                }
                CloseableReference closeablereference = mMemoryCache.cache(cacheKey, ((CloseableReference) (obj2)));
                CloseableReference.closeSafely(((CloseableReference) (obj2)));
                if (closeablereference == null)
                {
                    break MISSING_BLOCK_LABEL_130;
                }
                obj2 = new EncodedImage(closeablereference);
                ((EncodedImage) (obj2)).copyMetaDataFrom(encodedimage1);
                CloseableReference.closeSafely(closeablereference);
                getConsumer().onProgressUpdate(1.0F);
                getConsumer().onNewResult(obj2, true);
                EncodedImage.closeSafely(((EncodedImage) (obj2)));
                return;
                encodedimage1;
                CloseableReference.closeSafely(((CloseableReference) (obj2)));
                throw encodedimage1;
                encodedimage1;
                CloseableReference.closeSafely(closeablereference);
                throw encodedimage1;
                encodedimage1;
                EncodedImage.closeSafely(((EncodedImage) (obj2)));
                throw encodedimage1;
                getConsumer().onNewResult(encodedimage1, true);
                return;
            }

            public volatile void onNewResultImpl(Object obj2, boolean flag)
            {
                onNewResultImpl((EncodedImage)obj2, flag);
            }

            
            {
                this$0 = EncodedMemoryCacheProducer.this;
                cacheKey = cachekey;
                super(final_consumer);
            }
        };
        final_consumer = encodedimage;
        if (producerlistener.requiresExtraMap(s))
        {
            final_consumer = ImmutableMap.of("cached_value_found", "false");
        }
        producerlistener.onProducerFinishWithSuccess(s, "EncodedMemoryCacheProducer", final_consumer);
        mNextProducer.produceResults(delegatingconsumer, producercontext);
        CloseableReference.closeSafely(((CloseableReference) (obj1)));
        return;
    }

}
