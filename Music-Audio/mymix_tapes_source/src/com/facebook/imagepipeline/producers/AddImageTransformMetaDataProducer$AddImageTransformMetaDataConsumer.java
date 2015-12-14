// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            DelegatingConsumer, AddImageTransformMetaDataProducer, Consumer

private static class <init> extends DelegatingConsumer
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

    private (Consumer consumer)
    {
        super(consumer);
    }

    (Consumer consumer,  )
    {
        this(consumer);
    }
}
