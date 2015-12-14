// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PooledByteBufferOutputStream;
import com.facebook.imagepipeline.nativecode.JpegTranscoder;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.Executor;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            Producer, Consumer, ProducerContext, DelegatingConsumer, 
//            JobScheduler, ProducerListener, BaseProducerContextCallbacks

public class ResizeAndRotateProducer
    implements Producer
{
    private class TransformingConsumer extends DelegatingConsumer
    {

        private boolean mIsCancelled;
        private final JobScheduler mJobScheduler;
        private final ProducerContext mProducerContext;
        final ResizeAndRotateProducer this$0;

        private void doTransform(EncodedImage encodedimage, boolean flag)
        {
            Object obj;
            Object obj1;
            Map map;
            Object obj2;
            Map map1;
            CloseableReference closeablereference;
            PooledByteBufferOutputStream pooledbytebufferoutputstream;
            ImageRequest imagerequest;
            mProducerContext.getListener().onProducerStart(mProducerContext.getId(), "ResizeAndRotateProducer");
            imagerequest = mProducerContext.getImageRequest();
            pooledbytebufferoutputstream = mPooledByteBufferFactory.newOutputStream();
            map1 = null;
            closeablereference = null;
            obj = null;
            map = map1;
            obj2 = obj;
            obj1 = closeablereference;
            int i = ResizeAndRotateProducer.getScaleNumerator(imagerequest, encodedimage);
            map = map1;
            obj2 = obj;
            obj1 = closeablereference;
            map1 = getExtraMap(encodedimage, imagerequest, i);
            map = map1;
            obj2 = obj;
            obj1 = closeablereference;
            obj = encodedimage.getInputStream();
            map = map1;
            obj2 = obj;
            obj1 = obj;
            JpegTranscoder.transcodeJpeg(((java.io.InputStream) (obj)), pooledbytebufferoutputstream, ResizeAndRotateProducer.getRotationAngle(imagerequest, encodedimage), i, 85);
            map = map1;
            obj2 = obj;
            obj1 = obj;
            closeablereference = CloseableReference.of(pooledbytebufferoutputstream.toByteBuffer());
            encodedimage = new EncodedImage(closeablereference);
            encodedimage.setImageFormat(ImageFormat.JPEG);
            encodedimage.parseMetaData();
            mProducerContext.getListener().onProducerFinishWithSuccess(mProducerContext.getId(), "ResizeAndRotateProducer", map1);
            getConsumer().onNewResult(encodedimage, flag);
            EncodedImage.closeSafely(encodedimage);
            CloseableReference.closeSafely(closeablereference);
            Closeables.closeQuietly(((java.io.InputStream) (obj)));
            pooledbytebufferoutputstream.close();
            return;
            obj1;
            EncodedImage.closeSafely(encodedimage);
            throw obj1;
            encodedimage;
_L6:
            map = map1;
            obj2 = obj;
            obj1 = obj;
            CloseableReference.closeSafely(closeablereference);
            map = map1;
            obj2 = obj;
            obj1 = obj;
            try
            {
                throw encodedimage;
            }
            // Misplaced declaration of an exception variable
            catch (EncodedImage encodedimage)
            {
                obj = obj2;
            }
            finally
            {
                obj = obj1;
            }
_L4:
            obj1 = obj;
            mProducerContext.getListener().onProducerFinishWithFailure(mProducerContext.getId(), "ResizeAndRotateProducer", encodedimage, map);
            obj1 = obj;
            getConsumer().onFailure(encodedimage);
            Closeables.closeQuietly(((java.io.InputStream) (obj)));
            pooledbytebufferoutputstream.close();
            return;
_L2:
            Closeables.closeQuietly(((java.io.InputStream) (obj)));
            pooledbytebufferoutputstream.close();
            throw encodedimage;
            encodedimage;
            if (true) goto _L2; else goto _L1
_L1:
            encodedimage;
            map = map1;
            if (true) goto _L4; else goto _L3
_L3:
            encodedimage;
            if (true) goto _L6; else goto _L5
_L5:
        }

        private Map getExtraMap(EncodedImage encodedimage, ImageRequest imagerequest, int i)
        {
            if (!mProducerContext.getListener().requiresExtraMap(mProducerContext.getId()))
            {
                return null;
            }
            String s = (new StringBuilder()).append(encodedimage.getWidth()).append("x").append(encodedimage.getHeight()).toString();
            if (imagerequest.getResizeOptions() != null)
            {
                encodedimage = (new StringBuilder()).append(imagerequest.getResizeOptions().width).append("x").append(imagerequest.getResizeOptions().height).toString();
            } else
            {
                encodedimage = "Unspecified";
            }
            if (i > 0)
            {
                imagerequest = (new StringBuilder()).append(i).append("/8").toString();
            } else
            {
                imagerequest = "";
            }
            return ImmutableMap.of("Original size", s, "Requested size", encodedimage, "Fraction", imagerequest, "queueTime", String.valueOf(mJobScheduler.getQueuedTime()));
        }

        protected void onNewResultImpl(EncodedImage encodedimage, boolean flag)
        {
            if (!mIsCancelled) goto _L2; else goto _L1
_L1:
            return;
_L2:
            if (encodedimage != null)
            {
                break; /* Loop/switch isn't completed */
            }
            if (flag)
            {
                getConsumer().onNewResult(null, true);
                return;
            }
            if (true) goto _L1; else goto _L3
_L3:
            TriState tristate = ResizeAndRotateProducer.shouldTransform(mProducerContext.getImageRequest(), encodedimage);
            if (flag || tristate != TriState.UNSET)
            {
                if (tristate != TriState.YES)
                {
                    getConsumer().onNewResult(encodedimage, flag);
                    return;
                }
                if (mJobScheduler.updateJob(encodedimage, flag) && (flag || mProducerContext.isIntermediateResultExpected()))
                {
                    mJobScheduler.scheduleJob();
                    return;
                }
            }
            if (true) goto _L1; else goto _L4
_L4:
        }

        protected volatile void onNewResultImpl(Object obj, boolean flag)
        {
            onNewResultImpl((EncodedImage)obj, flag);
        }





/*
        static boolean access$402(TransformingConsumer transformingconsumer, boolean flag)
        {
            transformingconsumer.mIsCancelled = flag;
            return flag;
        }

*/

        public TransformingConsumer(Consumer consumer, ProducerContext producercontext)
        {
            this.this$0 = ResizeAndRotateProducer.this;
            super(consumer);
            mIsCancelled = false;
            mProducerContext = producercontext;
            producercontext = new _cls1();
            mJobScheduler = new JobScheduler(mExecutor, producercontext, 100);
            mProducerContext.addCallbacks(consumer. new _cls2());
        }
    }


    static final int DEFAULT_JPEG_QUALITY = 85;
    private static final String FRACTION_KEY = "Fraction";
    private static final float MAX_BITMAP_SIZE = 2048F;
    static final int MAX_JPEG_SCALE_NUMERATOR = 8;
    static final int MIN_TRANSFORM_INTERVAL_MS = 100;
    private static final String ORIGINAL_SIZE_KEY = "Original size";
    private static final String PRODUCER_NAME = "ResizeAndRotateProducer";
    private static final String REQUESTED_SIZE_KEY = "Requested size";
    private static final float ROUNDUP_FRACTION = 0.6666667F;
    private final Executor mExecutor;
    private final Producer mNextProducer;
    private final PooledByteBufferFactory mPooledByteBufferFactory;

    public ResizeAndRotateProducer(Executor executor, PooledByteBufferFactory pooledbytebufferfactory, Producer producer)
    {
        mExecutor = (Executor)Preconditions.checkNotNull(executor);
        mPooledByteBufferFactory = (PooledByteBufferFactory)Preconditions.checkNotNull(pooledbytebufferfactory);
        mNextProducer = (Producer)Preconditions.checkNotNull(producer);
    }

    static float determineResizeRatio(ResizeOptions resizeoptions, int i, int j)
    {
        float f1;
        if (resizeoptions == null)
        {
            f1 = 1.0F;
        } else
        {
            f1 = Math.max((float)resizeoptions.width / (float)i, (float)resizeoptions.height / (float)j);
            float f = f1;
            if ((float)i * f1 > 2048F)
            {
                f = 2048F / (float)i;
            }
            f1 = f;
            if ((float)j * f > 2048F)
            {
                return 2048F / (float)j;
            }
        }
        return f1;
    }

    private static int getRotationAngle(ImageRequest imagerequest, EncodedImage encodedimage)
    {
        boolean flag = false;
        if (!imagerequest.getAutoRotateEnabled())
        {
            return 0;
        }
        int i = encodedimage.getRotationAngle();
        if (i == 0 || i == 90 || i == 180 || i == 270)
        {
            flag = true;
        }
        Preconditions.checkArgument(flag);
        return i;
    }

    private static int getScaleNumerator(ImageRequest imagerequest, EncodedImage encodedimage)
    {
        ResizeOptions resizeoptions = imagerequest.getResizeOptions();
        int i;
        if (resizeoptions == null)
        {
            i = 8;
        } else
        {
            i = getRotationAngle(imagerequest, encodedimage);
            int j;
            if (i == 90 || i == 270)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            if (j != 0)
            {
                i = encodedimage.getHeight();
            } else
            {
                i = encodedimage.getWidth();
            }
            if (j != 0)
            {
                j = encodedimage.getWidth();
            } else
            {
                j = encodedimage.getHeight();
            }
            j = roundNumerator(determineResizeRatio(resizeoptions, i, j));
            if (j > 8)
            {
                return 8;
            }
            i = j;
            if (j < 1)
            {
                return 1;
            }
        }
        return i;
    }

    static int roundNumerator(float f)
    {
        return (int)(0.6666667F + 8F * f);
    }

    private static boolean shouldResize(int i)
    {
        return i < 8;
    }

    private static TriState shouldTransform(ImageRequest imagerequest, EncodedImage encodedimage)
    {
        if (encodedimage == null || encodedimage.getImageFormat() == ImageFormat.UNKNOWN)
        {
            return TriState.UNSET;
        }
        if (encodedimage.getImageFormat() != ImageFormat.JPEG)
        {
            return TriState.NO;
        }
        boolean flag;
        if (getRotationAngle(imagerequest, encodedimage) != 0 || shouldResize(getScaleNumerator(imagerequest, encodedimage)))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return TriState.valueOf(flag);
    }

    public void produceResults(Consumer consumer, ProducerContext producercontext)
    {
        mNextProducer.produceResults(new TransformingConsumer(consumer, producercontext), producercontext);
    }






    // Unreferenced inner class com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer$1

/* anonymous class */
    class TransformingConsumer._cls1
        implements JobScheduler.JobRunnable
    {

        final TransformingConsumer this$1;
        final ResizeAndRotateProducer val$this$0;

        public void run(EncodedImage encodedimage, boolean flag)
        {
            doTransform(encodedimage, flag);
        }

            
            {
                this$1 = final_transformingconsumer;
                this$0 = ResizeAndRotateProducer.this;
                super();
            }
    }


    // Unreferenced inner class com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer$2

/* anonymous class */
    class TransformingConsumer._cls2 extends BaseProducerContextCallbacks
    {

        final TransformingConsumer this$1;
        final Consumer val$consumer;
        final ResizeAndRotateProducer val$this$0;

        public void onCancellationRequested()
        {
            mJobScheduler.clearJob();
            mIsCancelled = true;
            consumer.onCancellation();
        }

        public void onIsIntermediateResultExpectedChanged()
        {
            if (mProducerContext.isIntermediateResultExpected())
            {
                mJobScheduler.scheduleJob();
            }
        }

            
            {
                this$1 = final_transformingconsumer;
                this$0 = resizeandrotateproducer;
                consumer = Consumer.this;
                super();
            }
    }

}
