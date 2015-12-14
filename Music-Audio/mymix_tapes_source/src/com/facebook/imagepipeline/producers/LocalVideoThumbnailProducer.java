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
import java.util.concurrent.Executor;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            Producer, ProducerContext, Consumer, StatefulProducerRunnable, 
//            ProducerListener, BaseProducerContextCallbacks

public class LocalVideoThumbnailProducer
    implements Producer
{

    static final String CREATED_THUMBNAIL = "createdThumbnail";
    static final String PRODUCER_NAME = "VideoThumbnailProducer";
    private final Executor mExecutor;

    public LocalVideoThumbnailProducer(Executor executor)
    {
        mExecutor = executor;
    }

    private static int calculateKind(ImageRequest imagerequest)
    {
        return imagerequest.getPreferredWidth() <= 96 && imagerequest.getPreferredHeight() <= 96 ? 3 : 1;
    }

    public void produceResults(final Consumer final_consumer, ProducerContext producercontext)
    {
        final_consumer = new StatefulProducerRunnable(producercontext.getListener(), "VideoThumbnailProducer", producercontext.getId(), producercontext.getImageRequest()) {

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
                Bitmap bitmap = ThumbnailUtils.createVideoThumbnail(imageRequest.getSourceFile().getPath(), LocalVideoThumbnailProducer.calculateKind(imageRequest));
                if (bitmap == null)
                {
                    return null;
                } else
                {
                    return CloseableReference.of(new CloseableStaticBitmap(bitmap, new ResourceReleaser() {

                        final _cls1 this$1;

                        public void release(Bitmap bitmap)
                        {
                            bitmap.recycle();
                        }

                        public volatile void release(Object obj)
                        {
                            release((Bitmap)obj);
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    }, ImmutableQualityInfo.FULL_QUALITY, 0));
                }
            }

            protected volatile Object getResult()
                throws Exception
            {
                return getResult();
            }

            
            {
                this$0 = LocalVideoThumbnailProducer.this;
                imageRequest = imagerequest;
                super(final_consumer, producerlistener, s, s1);
            }
        };
        producercontext.addCallbacks(new BaseProducerContextCallbacks() {

            final LocalVideoThumbnailProducer this$0;
            final StatefulProducerRunnable val$cancellableProducerRunnable;

            public void onCancellationRequested()
            {
                cancellableProducerRunnable.cancel();
            }

            
            {
                this$0 = LocalVideoThumbnailProducer.this;
                cancellableProducerRunnable = statefulproducerrunnable;
                super();
            }
        });
        mExecutor.execute(final_consumer);
    }

}
