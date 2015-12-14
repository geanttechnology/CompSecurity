// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            StatefulProducerRunnable, LocalFetchProducer, Consumer, ProducerListener

class ble extends StatefulProducerRunnable
{

    final LocalFetchProducer this$0;
    final ImageRequest val$imageRequest;

    protected void disposeResult(EncodedImage encodedimage)
    {
        EncodedImage.closeSafely(encodedimage);
    }

    protected volatile void disposeResult(Object obj)
    {
        disposeResult((EncodedImage)obj);
    }

    protected EncodedImage getResult()
        throws Exception
    {
        EncodedImage encodedimage = getEncodedImage(val$imageRequest);
        if (encodedimage == null)
        {
            return null;
        } else
        {
            encodedimage.parseMetaData();
            return encodedimage;
        }
    }

    protected volatile Object getResult()
        throws Exception
    {
        return getResult();
    }

    ble(ProducerListener producerlistener, String s, String s1, ImageRequest imagerequest)
    {
        this$0 = final_localfetchproducer;
        val$imageRequest = imagerequest;
        super(Consumer.this, producerlistener, s, s1);
    }
}
