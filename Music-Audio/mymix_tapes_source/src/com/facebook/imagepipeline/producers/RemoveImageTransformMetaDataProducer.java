// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            Producer, Consumer, ProducerContext, DelegatingConsumer

public class RemoveImageTransformMetaDataProducer
    implements Producer
{
    private class RemoveImageTransformMetaDataConsumer extends DelegatingConsumer
    {

        final RemoveImageTransformMetaDataProducer this$0;

        protected void onNewResultImpl(EncodedImage encodedimage, boolean flag)
        {
            CloseableReference closeablereference;
            CloseableReference closeablereference1;
            Object obj;
            obj = null;
            closeablereference = null;
            closeablereference1 = obj;
            if (!EncodedImage.isValid(encodedimage))
            {
                break MISSING_BLOCK_LABEL_25;
            }
            closeablereference1 = obj;
            closeablereference = encodedimage.getByteBufferRef();
            closeablereference1 = closeablereference;
            getConsumer().onNewResult(closeablereference, flag);
            CloseableReference.closeSafely(closeablereference);
            return;
            encodedimage;
            CloseableReference.closeSafely(closeablereference1);
            throw encodedimage;
        }

        protected volatile void onNewResultImpl(Object obj, boolean flag)
        {
            onNewResultImpl((EncodedImage)obj, flag);
        }

        private RemoveImageTransformMetaDataConsumer(Consumer consumer)
        {
            this$0 = RemoveImageTransformMetaDataProducer.this;
            super(consumer);
        }

    }


    private final Producer mNextProducer;

    public RemoveImageTransformMetaDataProducer(Producer producer)
    {
        mNextProducer = producer;
    }

    public void produceResults(Consumer consumer, ProducerContext producercontext)
    {
        mNextProducer.produceResults(new RemoveImageTransformMetaDataConsumer(consumer), producercontext);
    }
}
