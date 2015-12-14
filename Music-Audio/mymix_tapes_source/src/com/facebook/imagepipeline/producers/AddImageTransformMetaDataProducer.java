// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            Producer, Consumer, ProducerContext, DelegatingConsumer

public class AddImageTransformMetaDataProducer
    implements Producer
{
    private static class AddImageTransformMetaDataConsumer extends DelegatingConsumer
    {

        protected void onNewResultImpl(EncodedImage encodedimage, boolean flag)
        {
            if (encodedimage == null)
            {
                getConsumer().onNewResult(null, flag);
                return;
            }
            if (!EncodedImage.isMetaDataAvailable(encodedimage))
            {
                encodedimage.parseMetaData();
            }
            getConsumer().onNewResult(encodedimage, flag);
        }

        protected volatile void onNewResultImpl(Object obj, boolean flag)
        {
            onNewResultImpl((EncodedImage)obj, flag);
        }

        private AddImageTransformMetaDataConsumer(Consumer consumer)
        {
            super(consumer);
        }

    }


    private final Producer mNextProducer;

    public AddImageTransformMetaDataProducer(Producer producer)
    {
        mNextProducer = producer;
    }

    public void produceResults(Consumer consumer, ProducerContext producercontext)
    {
        mNextProducer.produceResults(new AddImageTransformMetaDataConsumer(consumer), producercontext);
    }
}
