// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import bolts.Continuation;
import bolts.Task;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            Producer, ProducerListener, ProducerContext, Consumer, 
//            DelegatingConsumer, BaseProducerContextCallbacks

public class DiskCacheProducer
    implements Producer
{
    private class DiskCacheConsumer extends DelegatingConsumer
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

        private DiskCacheConsumer(Consumer consumer, BufferedDiskCache buffereddiskcache, CacheKey cachekey)
        {
            this$0 = DiskCacheProducer.this;
            super(consumer);
            mCache = buffereddiskcache;
            mCacheKey = cachekey;
        }

    }


    static final String PRODUCER_NAME = "DiskCacheProducer";
    static final String VALUE_FOUND = "cached_value_found";
    private final CacheKeyFactory mCacheKeyFactory;
    private final BufferedDiskCache mDefaultBufferedDiskCache;
    private final Producer mNextProducer;
    private final BufferedDiskCache mSmallImageBufferedDiskCache;

    public DiskCacheProducer(BufferedDiskCache buffereddiskcache, BufferedDiskCache buffereddiskcache1, CacheKeyFactory cachekeyfactory, Producer producer)
    {
        mDefaultBufferedDiskCache = buffereddiskcache;
        mSmallImageBufferedDiskCache = buffereddiskcache1;
        mCacheKeyFactory = cachekeyfactory;
        mNextProducer = producer;
    }

    static Map getExtraMap(ProducerListener producerlistener, String s, boolean flag)
    {
        if (!producerlistener.requiresExtraMap(s))
        {
            return null;
        } else
        {
            return ImmutableMap.of("cached_value_found", String.valueOf(flag));
        }
    }

    private void maybeStartNextProducer(Consumer consumer, Consumer consumer1, ProducerContext producercontext)
    {
        if (producercontext.getLowestPermittedRequestLevel().getValue() >= com.facebook.imagepipeline.request.ImageRequest.RequestLevel.DISK_CACHE.getValue())
        {
            consumer.onNewResult(null, true);
            return;
        } else
        {
            mNextProducer.produceResults(consumer1, producercontext);
            return;
        }
    }

    private void subscribeTaskForRequestCancellation(final AtomicBoolean isCancelled, ProducerContext producercontext)
    {
        producercontext.addCallbacks(new BaseProducerContextCallbacks() {

            final DiskCacheProducer this$0;
            final AtomicBoolean val$isCancelled;

            public void onCancellationRequested()
            {
                isCancelled.set(true);
            }

            
            {
                this$0 = DiskCacheProducer.this;
                isCancelled = atomicboolean;
                super();
            }
        });
    }

    public void produceResults(final Consumer consumer, final ProducerContext producerContext)
    {
        final BufferedDiskCache cache = producerContext.getImageRequest();
        if (!cache.isDiskCacheEnabled())
        {
            maybeStartNextProducer(consumer, consumer, producerContext);
            return;
        }
        final ProducerListener listener = producerContext.getListener();
        final String requestId = producerContext.getId();
        listener.onProducerStart(requestId, "DiskCacheProducer");
        final CacheKey cacheKey = mCacheKeyFactory.getEncodedCacheKey(cache);
        if (cache.getImageType() == com.facebook.imagepipeline.request.ImageRequest.ImageType.SMALL)
        {
            cache = mSmallImageBufferedDiskCache;
        } else
        {
            cache = mDefaultBufferedDiskCache;
        }
        consumer = new Continuation() {

            final DiskCacheProducer this$0;
            final BufferedDiskCache val$cache;
            final CacheKey val$cacheKey;
            final Consumer val$consumer;
            final ProducerListener val$listener;
            final ProducerContext val$producerContext;
            final String val$requestId;

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            public Void then(Task task)
                throws Exception
            {
                if (task.isCancelled() || task.isFaulted() && (task.getError() instanceof CancellationException))
                {
                    listener.onProducerFinishWithCancellation(requestId, "DiskCacheProducer", null);
                    consumer.onCancellation();
                    return null;
                }
                if (task.isFaulted())
                {
                    listener.onProducerFinishWithFailure(requestId, "DiskCacheProducer", task.getError(), null);
                    maybeStartNextProducer(consumer, new DiskCacheConsumer(consumer, cache, cacheKey), producerContext);
                    return null;
                }
                task = (EncodedImage)task.getResult();
                if (task != null)
                {
                    listener.onProducerFinishWithSuccess(requestId, "DiskCacheProducer", DiskCacheProducer.getExtraMap(listener, requestId, true));
                    consumer.onProgressUpdate(1.0F);
                    consumer.onNewResult(task, true);
                    task.close();
                    return null;
                } else
                {
                    listener.onProducerFinishWithSuccess(requestId, "DiskCacheProducer", DiskCacheProducer.getExtraMap(listener, requestId, false));
                    maybeStartNextProducer(consumer, new DiskCacheConsumer(consumer, cache, cacheKey), producerContext);
                    return null;
                }
            }

            
            {
                this$0 = DiskCacheProducer.this;
                listener = producerlistener;
                requestId = s;
                consumer = consumer1;
                cache = buffereddiskcache;
                cacheKey = cachekey;
                producerContext = producercontext;
                super();
            }
        };
        listener = new AtomicBoolean(false);
        cache.get(cacheKey, listener).continueWith(consumer);
        subscribeTaskForRequestCancellation(listener, producerContext);
    }

}
