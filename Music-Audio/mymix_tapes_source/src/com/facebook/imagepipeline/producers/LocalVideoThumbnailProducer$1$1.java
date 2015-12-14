// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.util.Map;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            StatefulProducerRunnable, LocalVideoThumbnailProducer, Consumer, ProducerListener

class this._cls1
    implements ResourceReleaser
{

    final release this$1;

    public void release(Bitmap bitmap)
    {
        bitmap.recycle();
    }

    public volatile void release(Object obj)
    {
        release((Bitmap)obj);
    }

    l.imageRequest()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/facebook/imagepipeline/producers/LocalVideoThumbnailProducer$1

/* anonymous class */
    class LocalVideoThumbnailProducer._cls1 extends StatefulProducerRunnable
    {

        final LocalVideoThumbnailProducer this$0;
        final ImageRequest val$imageRequest;

        protected void disposeResult(CloseableReference closeablereference)
        {
            CloseableReference.closeSafely(closeablereference);
        }

        protected volatile void disposeResult(Object obj)
        {
            disposeResult((CloseableReference)obj);
        }

        protected Map getExtraMapOnSuccess(CloseableReference closeablereference)
        {
            boolean flag;
            if (closeablereference != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return ImmutableMap.of("createdThumbnail", String.valueOf(flag));
        }

        protected volatile Map getExtraMapOnSuccess(Object obj)
        {
            return getExtraMapOnSuccess((CloseableReference)obj);
        }

        protected CloseableReference getResult()
            throws Exception
        {
            Bitmap bitmap = ThumbnailUtils.createVideoThumbnail(imageRequest.getSourceFile().getPath(), LocalVideoThumbnailProducer.access$000(imageRequest));
            if (bitmap == null)
            {
                return null;
            } else
            {
                return CloseableReference.of(new CloseableStaticBitmap(bitmap, new LocalVideoThumbnailProducer._cls1._cls1(), ImmutableQualityInfo.FULL_QUALITY, 0));
            }
        }

        protected volatile Object getResult()
            throws Exception
        {
            return getResult();
        }

            
            {
                this$0 = final_localvideothumbnailproducer;
                imageRequest = imagerequest;
                super(Consumer.this, producerlistener, s, s1);
            }
    }

}
