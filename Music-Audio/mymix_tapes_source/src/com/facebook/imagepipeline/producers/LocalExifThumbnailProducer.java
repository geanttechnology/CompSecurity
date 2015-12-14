// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import android.media.ExifInterface;
import android.util.Pair;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PooledByteBufferInputStream;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.imageutils.JfifUtil;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            Producer, ProducerContext, Consumer, StatefulProducerRunnable, 
//            ProducerListener, BaseProducerContextCallbacks

public class LocalExifThumbnailProducer
    implements Producer
{

    static final String CREATED_THUMBNAIL = "createdThumbnail";
    static final String PRODUCER_NAME = "LocalExifThumbnailProducer";
    private final Executor mExecutor;
    private final PooledByteBufferFactory mPooledByteBufferFactory;

    public LocalExifThumbnailProducer(Executor executor, PooledByteBufferFactory pooledbytebufferfactory)
    {
        mExecutor = executor;
        mPooledByteBufferFactory = pooledbytebufferfactory;
    }

    private EncodedImage buildEncodedImage(PooledByteBuffer pooledbytebuffer, ExifInterface exifinterface)
    {
        int j = -1;
        Pair pair = BitmapUtil.decodeDimensions(new PooledByteBufferInputStream(pooledbytebuffer));
        int k = getRotationAngle(exifinterface);
        int i;
        if (pair != null)
        {
            i = ((Integer)pair.first).intValue();
        } else
        {
            i = -1;
        }
        if (pair != null)
        {
            j = ((Integer)pair.second).intValue();
        }
        pooledbytebuffer = new EncodedImage(CloseableReference.of(pooledbytebuffer));
        pooledbytebuffer.setImageFormat(ImageFormat.JPEG);
        pooledbytebuffer.setRotationAngle(k);
        pooledbytebuffer.setWidth(i);
        pooledbytebuffer.setHeight(j);
        return pooledbytebuffer;
    }

    private int getRotationAngle(ExifInterface exifinterface)
    {
        return JfifUtil.getAutoRotateAngleFromOrientation(Integer.parseInt(exifinterface.getAttribute("Orientation")));
    }

    ExifInterface getExifInterface(String s)
        throws IOException
    {
        return new ExifInterface(s);
    }

    public void produceResults(final Consumer final_consumer, ProducerContext producercontext)
    {
        final_consumer = new StatefulProducerRunnable(producercontext.getListener(), "LocalExifThumbnailProducer", producercontext.getId(), producercontext.getImageRequest()) {

            final LocalExifThumbnailProducer this$0;
            final ImageRequest val$imageRequest;

            protected void disposeResult(EncodedImage encodedimage)
            {
                EncodedImage.closeSafely(encodedimage);
            }

            protected volatile void disposeResult(Object obj)
            {
                disposeResult((EncodedImage)obj);
            }

            protected Map getExtraMapOnSuccess(EncodedImage encodedimage)
            {
                boolean flag;
                if (encodedimage != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                return ImmutableMap.of("createdThumbnail", Boolean.toString(flag));
            }

            protected volatile Map getExtraMapOnSuccess(Object obj)
            {
                return getExtraMapOnSuccess((EncodedImage)obj);
            }

            protected EncodedImage getResult()
                throws Exception
            {
                ExifInterface exifinterface = getExifInterface(imageRequest.getSourceFile().getPath());
                if (!exifinterface.hasThumbnail())
                {
                    return null;
                } else
                {
                    byte abyte0[] = exifinterface.getThumbnail();
                    PooledByteBuffer pooledbytebuffer = mPooledByteBufferFactory.newByteBuffer(abyte0);
                    return buildEncodedImage(pooledbytebuffer, exifinterface);
                }
            }

            protected volatile Object getResult()
                throws Exception
            {
                return getResult();
            }

            
            {
                this$0 = LocalExifThumbnailProducer.this;
                imageRequest = imagerequest;
                super(final_consumer, producerlistener, s, s1);
            }
        };
        producercontext.addCallbacks(new BaseProducerContextCallbacks() {

            final LocalExifThumbnailProducer this$0;
            final StatefulProducerRunnable val$cancellableProducerRunnable;

            public void onCancellationRequested()
            {
                cancellableProducerRunnable.cancel();
            }

            
            {
                this$0 = LocalExifThumbnailProducer.this;
                cancellableProducerRunnable = statefulproducerrunnable;
                super();
            }
        });
        mExecutor.execute(final_consumer);
    }


}
