// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import bolts.Continuation;
import bolts.Task;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.concurrent.CancellationException;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            DiskCacheProducer, ProducerListener, Consumer, ProducerContext

class val.producerContext
    implements Continuation
{

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
            val$listener.onProducerFinishWithCancellation(val$requestId, "DiskCacheProducer", null);
            val$consumer.onCancellation();
            return null;
        }
        if (task.isFaulted())
        {
            val$listener.onProducerFinishWithFailure(val$requestId, "DiskCacheProducer", task.getError(), null);
            DiskCacheProducer.access$100(DiskCacheProducer.this, val$consumer, new skCacheConsumer(DiskCacheProducer.this, val$consumer, val$cache, val$cacheKey, null), val$producerContext);
            return null;
        }
        task = (EncodedImage)task.getResult();
        if (task != null)
        {
            val$listener.onProducerFinishWithSuccess(val$requestId, "DiskCacheProducer", DiskCacheProducer.getExtraMap(val$listener, val$requestId, true));
            val$consumer.onProgressUpdate(1.0F);
            val$consumer.onNewResult(task, true);
            task.close();
            return null;
        } else
        {
            val$listener.onProducerFinishWithSuccess(val$requestId, "DiskCacheProducer", DiskCacheProducer.getExtraMap(val$listener, val$requestId, false));
            DiskCacheProducer.access$100(DiskCacheProducer.this, val$consumer, new skCacheConsumer(DiskCacheProducer.this, val$consumer, val$cache, val$cacheKey, null), val$producerContext);
            return null;
        }
    }

    skCacheConsumer()
    {
        this$0 = final_diskcacheproducer;
        val$listener = producerlistener;
        val$requestId = s;
        val$consumer = consumer1;
        val$cache = buffereddiskcache;
        val$cacheKey = cachekey;
        val$producerContext = ProducerContext.this;
        super();
    }
}
