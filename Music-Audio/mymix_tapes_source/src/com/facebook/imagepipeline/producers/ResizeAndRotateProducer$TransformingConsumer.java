// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.ImmutableMap;
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

// Referenced classes of package com.facebook.imagepipeline.producers:
//            DelegatingConsumer, ResizeAndRotateProducer, JobScheduler, ProducerContext, 
//            ProducerListener, Consumer, BaseProducerContextCallbacks

private class mJobScheduler extends DelegatingConsumer
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
        pooledbytebufferoutputstream = ResizeAndRotateProducer.access$600(ResizeAndRotateProducer.this).newOutputStream();
        map1 = null;
        closeablereference = null;
        obj = null;
        map = map1;
        obj2 = obj;
        obj1 = closeablereference;
        int i = ResizeAndRotateProducer.access$700(imagerequest, encodedimage);
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
        JpegTranscoder.transcodeJpeg(((java.io.InputStream) (obj)), pooledbytebufferoutputstream, ResizeAndRotateProducer.access$800(imagerequest, encodedimage), i, 85);
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
        TriState tristate = ResizeAndRotateProducer.access$500(mProducerContext.getImageRequest(), encodedimage);
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
    static boolean access$402(_cls2 _pcls2, boolean flag)
    {
        _pcls2.mIsCancelled = flag;
        return flag;
    }

*/

    public _cls2.val.consumer(final Consumer consumer, ProducerContext producercontext)
    {
        this.this$0 = ResizeAndRotateProducer.this;
        super(consumer);
        mIsCancelled = false;
        mProducerContext = producercontext;
        producercontext = new JobScheduler.JobRunnable() {

            final ResizeAndRotateProducer.TransformingConsumer this$1;
            final ResizeAndRotateProducer val$this$0;

            public void run(EncodedImage encodedimage, boolean flag)
            {
                doTransform(encodedimage, flag);
            }

            
            {
                this$1 = ResizeAndRotateProducer.TransformingConsumer.this;
                this$0 = resizeandrotateproducer;
                super();
            }
        };
        mJobScheduler = new JobScheduler(ResizeAndRotateProducer.access$100(ResizeAndRotateProducer.this), producercontext, 100);
        mProducerContext.addCallbacks(new BaseProducerContextCallbacks() {

            final ResizeAndRotateProducer.TransformingConsumer this$1;
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
                this$1 = ResizeAndRotateProducer.TransformingConsumer.this;
                this$0 = resizeandrotateproducer;
                consumer = consumer1;
                super();
            }
        });
    }
}
