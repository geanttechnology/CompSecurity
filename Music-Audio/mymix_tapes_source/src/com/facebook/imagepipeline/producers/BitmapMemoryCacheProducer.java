// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.QualityInfo;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            Producer, ProducerContext, ProducerListener, Consumer, 
//            DelegatingConsumer

public class BitmapMemoryCacheProducer
    implements Producer
{

    static final String PRODUCER_NAME = "BitmapMemoryCacheProducer";
    static final String VALUE_FOUND = "cached_value_found";
    private final CacheKeyFactory mCacheKeyFactory;
    private final MemoryCache mMemoryCache;
    private final Producer mNextProducer;

    public BitmapMemoryCacheProducer(MemoryCache memorycache, CacheKeyFactory cachekeyfactory, Producer producer)
    {
        mMemoryCache = memorycache;
        mCacheKeyFactory = cachekeyfactory;
        mNextProducer = producer;
    }

    protected String getProducerName()
    {
        return "BitmapMemoryCacheProducer";
    }

    public void produceResults(Consumer consumer, ProducerContext producercontext)
    {
        Object obj1 = null;
        ProducerListener producerlistener = producercontext.getListener();
        String s = producercontext.getId();
        producerlistener.onProducerStart(s, getProducerName());
        Object obj = producercontext.getImageRequest();
        Object obj2 = mCacheKeyFactory.getBitmapCacheKey(((com.facebook.imagepipeline.request.ImageRequest) (obj)));
        CloseableReference closeablereference = mMemoryCache.get(obj2);
        if (closeablereference != null)
        {
            boolean flag = ((CloseableImage)closeablereference.get()).getQualityInfo().isOfFullQuality();
            if (flag)
            {
                String s1 = getProducerName();
                if (producerlistener.requiresExtraMap(s))
                {
                    obj = ImmutableMap.of("cached_value_found", "true");
                } else
                {
                    obj = null;
                }
                producerlistener.onProducerFinishWithSuccess(s, s1, ((java.util.Map) (obj)));
                consumer.onProgressUpdate(1.0F);
            }
            consumer.onNewResult(closeablereference, flag);
            closeablereference.close();
            if (flag)
            {
                return;
            }
        }
        if (producercontext.getLowestPermittedRequestLevel().getValue() >= com.facebook.imagepipeline.request.ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue())
        {
            obj = getProducerName();
            if (producerlistener.requiresExtraMap(s))
            {
                producercontext = ImmutableMap.of("cached_value_found", "false");
            } else
            {
                producercontext = null;
            }
            producerlistener.onProducerFinishWithSuccess(s, ((String) (obj)), producercontext);
            consumer.onNewResult(null, true);
            return;
        }
        obj = wrapConsumer(consumer, ((CacheKey) (obj2)));
        obj2 = getProducerName();
        consumer = obj1;
        if (producerlistener.requiresExtraMap(s))
        {
            consumer = ImmutableMap.of("cached_value_found", "false");
        }
        producerlistener.onProducerFinishWithSuccess(s, ((String) (obj2)), consumer);
        mNextProducer.produceResults(((Consumer) (obj)), producercontext);
    }

    protected Consumer wrapConsumer(final Consumer final_consumer, CacheKey cachekey)
    {
        return new DelegatingConsumer(cachekey) {

            final BitmapMemoryCacheProducer this$0;
            final CacheKey val$cacheKey;

            public void onNewResultImpl(CloseableReference closeablereference, boolean flag)
            {
                CloseableReference closeablereference1;
                if (closeablereference == null)
                {
                    if (flag)
                    {
                        getConsumer().onNewResult(null, true);
                    }
                    return;
                }
                if (((CloseableImage)closeablereference.get()).isStateful())
                {
                    getConsumer().onNewResult(closeablereference, flag);
                    return;
                }
                if (flag)
                {
                    break MISSING_BLOCK_LABEL_141;
                }
                closeablereference1 = mMemoryCache.get(cacheKey);
                if (closeablereference1 == null)
                {
                    break MISSING_BLOCK_LABEL_141;
                }
                QualityInfo qualityinfo = ((CloseableImage)closeablereference.get()).getQualityInfo();
                QualityInfo qualityinfo1 = ((CloseableImage)closeablereference1.get()).getQualityInfo();
                if (!qualityinfo1.isOfFullQuality() && qualityinfo1.getQuality() < qualityinfo.getQuality())
                {
                    break MISSING_BLOCK_LABEL_137;
                }
                getConsumer().onNewResult(closeablereference1, false);
                CloseableReference.closeSafely(closeablereference1);
                return;
                CloseableReference.closeSafely(closeablereference1);
                closeablereference1 = mMemoryCache.cache(cacheKey, closeablereference);
                if (!flag)
                {
                    break MISSING_BLOCK_LABEL_173;
                }
                getConsumer().onProgressUpdate(1.0F);
                Consumer consumer = getConsumer();
                if (closeablereference1 != null)
                {
                    closeablereference = closeablereference1;
                }
                consumer.onNewResult(closeablereference, flag);
                CloseableReference.closeSafely(closeablereference1);
                return;
                closeablereference;
                CloseableReference.closeSafely(closeablereference1);
                throw closeablereference;
                closeablereference;
                CloseableReference.closeSafely(closeablereference1);
                throw closeablereference;
            }

            public volatile void onNewResultImpl(Object obj, boolean flag)
            {
                onNewResultImpl((CloseableReference)obj, flag);
            }

            
            {
                this$0 = BitmapMemoryCacheProducer.this;
                cacheKey = cachekey;
                super(final_consumer);
            }
        };
    }

}
