// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            DelegatingConsumer, BranchOnSeparateImagesProducer, Producer, ProducerContext, 
//            Consumer

private class <init> extends DelegatingConsumer
{

    private ProducerContext mProducerContext;
    final BranchOnSeparateImagesProducer this$0;

    private boolean isResultGoodEnough(EncodedImage encodedimage, ImageRequest imagerequest)
    {
        while (encodedimage == null || encodedimage.getWidth() < imagerequest.getPreferredWidth() || encodedimage.getHeight() < imagerequest.getPreferredHeight()) 
        {
            return false;
        }
        return true;
    }

    protected void onFailureImpl(Throwable throwable)
    {
        BranchOnSeparateImagesProducer.access$100(BranchOnSeparateImagesProducer.this).produceResults(getConsumer(), mProducerContext);
    }

    protected void onNewResultImpl(EncodedImage encodedimage, boolean flag)
    {
        ImageRequest imagerequest = mProducerContext.getImageRequest();
        boolean flag2 = isResultGoodEnough(encodedimage, imagerequest);
        if (encodedimage != null && (flag2 || imagerequest.getLocalThumbnailPreviewsEnabled()))
        {
            Consumer consumer = getConsumer();
            boolean flag1;
            if (flag && flag2)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            consumer.onNewResult(encodedimage, flag1);
        }
        if (flag && !flag2)
        {
            BranchOnSeparateImagesProducer.access$100(BranchOnSeparateImagesProducer.this).produceResults(getConsumer(), mProducerContext);
        }
    }

    protected volatile void onNewResultImpl(Object obj, boolean flag)
    {
        onNewResultImpl((EncodedImage)obj, flag);
    }

    private (Consumer consumer, ProducerContext producercontext)
    {
        this$0 = BranchOnSeparateImagesProducer.this;
        super(consumer);
        mProducerContext = producercontext;
    }

    mProducerContext(Consumer consumer, ProducerContext producercontext, mProducerContext mproducercontext)
    {
        this(consumer, producercontext);
    }
}
