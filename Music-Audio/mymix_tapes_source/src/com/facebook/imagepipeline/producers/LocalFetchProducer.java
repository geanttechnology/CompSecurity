// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Closeables;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            Producer, ProducerContext, Consumer, StatefulProducerRunnable, 
//            ProducerListener, BaseProducerContextCallbacks

public abstract class LocalFetchProducer
    implements Producer
{

    private final Executor mExecutor;
    private final PooledByteBufferFactory mPooledByteBufferFactory;

    protected LocalFetchProducer(Executor executor, PooledByteBufferFactory pooledbytebufferfactory)
    {
        mExecutor = executor;
        mPooledByteBufferFactory = pooledbytebufferfactory;
    }

    protected EncodedImage getByteBufferBackedEncodedImage(InputStream inputstream, int i)
        throws IOException
    {
        CloseableReference closeablereference1 = null;
        if (i >= 0) goto _L2; else goto _L1
_L1:
        CloseableReference closeablereference = CloseableReference.of(mPooledByteBufferFactory.newByteBuffer(inputstream));
_L4:
        closeablereference1 = closeablereference;
        EncodedImage encodedimage = new EncodedImage(closeablereference);
        Closeables.closeQuietly(inputstream);
        CloseableReference.closeSafely(closeablereference);
        return encodedimage;
_L2:
        closeablereference = CloseableReference.of(mPooledByteBufferFactory.newByteBuffer(inputstream, i));
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        Closeables.closeQuietly(inputstream);
        CloseableReference.closeSafely(closeablereference1);
        throw exception;
    }

    protected EncodedImage getByteBufferBackedEncodedImage(String s, int i)
        throws IOException
    {
        return getByteBufferBackedEncodedImage(((InputStream) (new FileInputStream(s))), i);
    }

    protected abstract EncodedImage getEncodedImage(ImageRequest imagerequest)
        throws IOException;

    protected abstract String getProducerName();

    public void produceResults(final Consumer final_consumer, ProducerContext producercontext)
    {
        ProducerListener producerlistener = producercontext.getListener();
        String s = producercontext.getId();
        ImageRequest imagerequest = producercontext.getImageRequest();
        final_consumer = new StatefulProducerRunnable(producerlistener, getProducerName(), s, imagerequest) {

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
                EncodedImage encodedimage = getEncodedImage(imageRequest);
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

            
            {
                this$0 = LocalFetchProducer.this;
                imageRequest = imagerequest;
                super(final_consumer, producerlistener, s, s1);
            }
        };
        producercontext.addCallbacks(new BaseProducerContextCallbacks() {

            final LocalFetchProducer this$0;
            final StatefulProducerRunnable val$cancellableProducerRunnable;

            public void onCancellationRequested()
            {
                cancellableProducerRunnable.cancel();
            }

            
            {
                this$0 = LocalFetchProducer.this;
                cancellableProducerRunnable = statefulproducerrunnable;
                super();
            }
        });
        mExecutor.execute(final_consumer);
    }
}
