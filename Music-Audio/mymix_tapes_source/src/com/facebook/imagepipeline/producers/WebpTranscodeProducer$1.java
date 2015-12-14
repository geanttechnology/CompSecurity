// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PooledByteBufferOutputStream;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            StatefulProducerRunnable, WebpTranscodeProducer, Consumer, ProducerListener

class  extends StatefulProducerRunnable
{

    final WebpTranscodeProducer this$0;
    final EncodedImage val$encodedImageCopy;

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
        PooledByteBufferOutputStream pooledbytebufferoutputstream = WebpTranscodeProducer.access$200(WebpTranscodeProducer.this).newOutputStream();
        CloseableReference closeablereference;
        WebpTranscodeProducer.access$300(val$encodedImageCopy, pooledbytebufferoutputstream);
        closeablereference = CloseableReference.of(pooledbytebufferoutputstream.toByteBuffer());
        EncodedImage encodedimage;
        encodedimage = new EncodedImage(closeablereference);
        encodedimage.copyMetaDataFrom(val$encodedImageCopy);
        CloseableReference.closeSafely(closeablereference);
        pooledbytebufferoutputstream.close();
        return encodedimage;
        Exception exception1;
        exception1;
        CloseableReference.closeSafely(closeablereference);
        throw exception1;
        Exception exception;
        exception;
        pooledbytebufferoutputstream.close();
        throw exception;
    }

    protected volatile Object getResult()
        throws Exception
    {
        return getResult();
    }

    protected void onCancellation()
    {
        EncodedImage.closeSafely(val$encodedImageCopy);
        super.onCancellation();
    }

    protected void onFailure(Exception exception)
    {
        EncodedImage.closeSafely(val$encodedImageCopy);
        super.onFailure(exception);
    }

    protected void onSuccess(EncodedImage encodedimage)
    {
        EncodedImage.closeSafely(val$encodedImageCopy);
        super.onSuccess(encodedimage);
    }

    protected volatile void onSuccess(Object obj)
    {
        onSuccess((EncodedImage)obj);
    }

    m(ProducerListener producerlistener, String s, String s1, EncodedImage encodedimage)
    {
        this$0 = final_webptranscodeproducer;
        val$encodedImageCopy = encodedimage;
        super(Consumer.this, producerlistener, s, s1);
    }
}
