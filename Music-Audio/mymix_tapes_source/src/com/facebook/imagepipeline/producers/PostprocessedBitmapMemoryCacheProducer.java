// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.android.internal.util.Predicate;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheKey;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            Producer, ProducerContext, ProducerListener, Consumer, 
//            DelegatingConsumer

public class PostprocessedBitmapMemoryCacheProducer
    implements Producer
{
    public static class CachedPostprocessorConsumer extends DelegatingConsumer
    {

        private final CacheKey mCacheKey;
        private final boolean mIsRepeatedProcessor;
        private final MemoryCache mMemoryCache;
        private final String mProcessorName;

        protected void onNewResultImpl(CloseableReference closeablereference, boolean flag)
        {
            CloseableReference closeablereference1;
            if (!flag && !mIsRepeatedProcessor)
            {
                return;
            }
            if (closeablereference == null)
            {
                getConsumer().onNewResult(null, flag);
                return;
            }
            Consumer consumer;
            if (mCacheKey != null)
            {
                mMemoryCache.removeAll(new Predicate() {

                    final CachedPostprocessorConsumer this$0;

                    public boolean apply(CacheKey cachekey)
                    {
                        if (cachekey instanceof BitmapMemoryCacheKey)
                        {
                            return mProcessorName.equals(((BitmapMemoryCacheKey)cachekey).getPostprocessorName());
                        } else
                        {
                            return false;
                        }
                    }

                    public volatile boolean apply(Object obj)
                    {
                        return apply((CacheKey)obj);
                    }

            
            {
                this$0 = CachedPostprocessorConsumer.this;
                super();
            }
                });
                closeablereference1 = mMemoryCache.cache(mCacheKey, closeablereference);
            } else
            {
                closeablereference1 = closeablereference;
            }
            getConsumer().onProgressUpdate(1.0F);
            consumer = getConsumer();
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
        }

        protected volatile void onNewResultImpl(Object obj, boolean flag)
        {
            onNewResultImpl((CloseableReference)obj, flag);
        }


        public CachedPostprocessorConsumer(Consumer consumer, CacheKey cachekey, boolean flag, String s, MemoryCache memorycache)
        {
            super(consumer);
            mCacheKey = cachekey;
            mIsRepeatedProcessor = flag;
            mProcessorName = s;
            mMemoryCache = memorycache;
        }
    }


    static final String PRODUCER_NAME = "PostprocessedBitmapMemoryCacheProducer";
    static final String VALUE_FOUND = "cached_value_found";
    private final CacheKeyFactory mCacheKeyFactory;
    private final MemoryCache mMemoryCache;
    private final Producer mNextProducer;

    public PostprocessedBitmapMemoryCacheProducer(MemoryCache memorycache, CacheKeyFactory cachekeyfactory, Producer producer)
    {
        mMemoryCache = memorycache;
        mCacheKeyFactory = cachekeyfactory;
        mNextProducer = producer;
    }

    protected String getProducerName()
    {
        return "PostprocessedBitmapMemoryCacheProducer";
    }

    public void produceResults(Consumer consumer, ProducerContext producercontext)
    {
        Object obj2 = null;
        ProducerListener producerlistener = producercontext.getListener();
        String s = producercontext.getId();
        Object obj1 = producercontext.getImageRequest();
        Postprocessor postprocessor = ((ImageRequest) (obj1)).getPostprocessor();
        if (postprocessor == null)
        {
            mNextProducer.produceResults(consumer, producercontext);
            return;
        }
        producerlistener.onProducerStart(s, getProducerName());
        CacheKey cachekey = postprocessor.getPostprocessorCacheKey();
        Object obj = null;
        if (cachekey != null)
        {
            obj1 = mCacheKeyFactory.getPostprocessedBitmapCacheKey(((ImageRequest) (obj1)));
            obj = mMemoryCache.get(obj1);
        } else
        {
            obj1 = null;
        }
        if (obj != null)
        {
            obj1 = getProducerName();
            if (producerlistener.requiresExtraMap(s))
            {
                producercontext = ImmutableMap.of("cached_value_found", "true");
            } else
            {
                producercontext = null;
            }
            producerlistener.onProducerFinishWithSuccess(s, ((String) (obj1)), producercontext);
            consumer.onProgressUpdate(1.0F);
            consumer.onNewResult(obj, true);
            ((CloseableReference) (obj)).close();
            return;
        }
        obj = new CachedPostprocessorConsumer(consumer, ((CacheKey) (obj1)), postprocessor instanceof RepeatedPostprocessor, postprocessor.getClass().getName(), mMemoryCache);
        obj1 = getProducerName();
        consumer = obj2;
        if (producerlistener.requiresExtraMap(s))
        {
            consumer = ImmutableMap.of("cached_value_found", "false");
        }
        producerlistener.onProducerFinishWithSuccess(s, ((String) (obj1)), consumer);
        mNextProducer.produceResults(((Consumer) (obj)), producercontext);
    }
}
