// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import android.media.ExifInterface;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.util.Map;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            StatefulProducerRunnable, LocalExifThumbnailProducer, Consumer, ProducerListener

class t> extends StatefulProducerRunnable
{

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
        ExifInterface exifinterface = getExifInterface(val$imageRequest.getSourceFile().getPath());
        if (!exifinterface.hasThumbnail())
        {
            return null;
        } else
        {
            byte abyte0[] = exifinterface.getThumbnail();
            com.facebook.imagepipeline.memory.PooledByteBuffer pooledbytebuffer = LocalExifThumbnailProducer.access$000(LocalExifThumbnailProducer.this).newByteBuffer(abyte0);
            return LocalExifThumbnailProducer.access$100(LocalExifThumbnailProducer.this, pooledbytebuffer, exifinterface);
        }
    }

    protected volatile Object getResult()
        throws Exception
    {
        return getResult();
    }

    (ProducerListener producerlistener, String s, String s1, ImageRequest imagerequest)
    {
        this$0 = final_localexifthumbnailproducer;
        val$imageRequest = imagerequest;
        super(Consumer.this, producerlistener, s, s1);
    }
}
