// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            DelegatingConsumer, DecodeProducer, ProducerContext, JobScheduler, 
//            ProducerListener, Consumer, DownsampleUtil, BaseProducerContextCallbacks

private abstract class mJobScheduler extends DelegatingConsumer
{

    private final ImageDecodeOptions mImageDecodeOptions;
    private boolean mIsFinished;
    private final JobScheduler mJobScheduler;
    private final ProducerContext mProducerContext;
    private final ProducerListener mProducerListener;
    final DecodeProducer this$0;

    private void doDecode(EncodedImage encodedimage, boolean flag)
    {
        if (isFinished() || !EncodedImage.isValid(encodedimage))
        {
            return;
        }
        long l = mJobScheduler.getQueuedTime();
        if (!flag) goto _L2; else goto _L1
_L1:
        int i = encodedimage.getSize();
_L7:
        if (!flag) goto _L4; else goto _L3
_L3:
        Object obj = ImmutableQualityInfo.FULL_QUALITY;
_L5:
        mProducerListener.onProducerStart(mProducerContext.getId(), "DecodeProducer");
        CloseableImage closeableimage = DecodeProducer.access$600(DecodeProducer.this).decodeImage(encodedimage, i, ((QualityInfo) (obj)), mImageDecodeOptions);
        obj = getExtraMap(closeableimage, l, ((QualityInfo) (obj)), flag);
        mProducerListener.onProducerFinishWithSuccess(mProducerContext.getId(), "DecodeProducer", ((Map) (obj)));
        handleResult(closeableimage, flag);
        EncodedImage.closeSafely(encodedimage);
        return;
_L2:
        i = getIntermediateImageEndOffset(encodedimage);
        continue; /* Loop/switch isn't completed */
_L4:
        obj = getQualityInfo();
          goto _L5
        Exception exception1;
        exception1;
        obj = getExtraMap(null, l, ((QualityInfo) (obj)), flag);
        mProducerListener.onProducerFinishWithFailure(mProducerContext.getId(), "DecodeProducer", exception1, ((Map) (obj)));
        handleError(exception1);
        EncodedImage.closeSafely(encodedimage);
        return;
        Exception exception;
        exception;
        EncodedImage.closeSafely(encodedimage);
        throw exception;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private Map getExtraMap(CloseableImage closeableimage, long l, QualityInfo qualityinfo, boolean flag)
    {
        if (!mProducerListener.requiresExtraMap(mProducerContext.getId()))
        {
            return null;
        }
        String s = String.valueOf(l);
        qualityinfo = String.valueOf(qualityinfo.isOfGoodEnoughQuality());
        String s1 = String.valueOf(flag);
        if (closeableimage instanceof CloseableStaticBitmap)
        {
            closeableimage = ((CloseableStaticBitmap)closeableimage).getUnderlyingBitmap();
            return ImmutableMap.of("bitmapSize", (new StringBuilder()).append(closeableimage.getWidth()).append("x").append(closeableimage.getHeight()).toString(), "queueTime", s, "hasGoodQuality", qualityinfo, "isFinal", s1);
        } else
        {
            return ImmutableMap.of("queueTime", s, "hasGoodQuality", qualityinfo, "isFinal", s1);
        }
    }

    private void handleCancellation()
    {
        maybeFinish(true);
        getConsumer().onCancellation();
    }

    private void handleError(Throwable throwable)
    {
        maybeFinish(true);
        getConsumer().onFailure(throwable);
    }

    private void handleResult(CloseableImage closeableimage, boolean flag)
    {
        closeableimage = CloseableReference.of(closeableimage);
        maybeFinish(flag);
        getConsumer().onNewResult(closeableimage, flag);
        CloseableReference.closeSafely(closeableimage);
        return;
        Exception exception;
        exception;
        CloseableReference.closeSafely(closeableimage);
        throw exception;
    }

    private boolean isFinished()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mIsFinished;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    private void maybeFinish(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_13;
        }
        if (!mIsFinished)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        mIsFinished = true;
        this;
        JVM INSTR monitorexit ;
        mJobScheduler.clearJob();
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected abstract int getIntermediateImageEndOffset(EncodedImage encodedimage);

    protected abstract QualityInfo getQualityInfo();

    public void onCancellationImpl()
    {
        handleCancellation();
    }

    public void onFailureImpl(Throwable throwable)
    {
        handleError(throwable);
    }

    public void onNewResultImpl(EncodedImage encodedimage, boolean flag)
    {
        while (!updateDecodeJob(encodedimage, flag) || !flag && !mProducerContext.isIntermediateResultExpected()) 
        {
            return;
        }
        mJobScheduler.scheduleJob();
    }

    public volatile void onNewResultImpl(Object obj, boolean flag)
    {
        onNewResultImpl((EncodedImage)obj, flag);
    }

    protected boolean updateDecodeJob(EncodedImage encodedimage, boolean flag)
    {
        return mJobScheduler.updateJob(encodedimage, flag);
    }




    public >(Consumer consumer, final ProducerContext producerContext)
    {
        this.this$0 = DecodeProducer.this;
        super(consumer);
        mProducerContext = producerContext;
        mProducerListener = producerContext.getListener();
        mImageDecodeOptions = producerContext.getImageRequest().getImageDecodeOptions();
        mIsFinished = false;
        consumer = new JobScheduler.JobRunnable() {

            final DecodeProducer.ProgressiveDecoder this$1;
            final ProducerContext val$producerContext;
            final DecodeProducer val$this$0;

            public void run(EncodedImage encodedimage, boolean flag)
            {
                if (encodedimage != null)
                {
                    if (DecodeProducer.access$000(DecodeProducer.ProgressiveDecoder.this.this$0))
                    {
                        ImageRequest imagerequest = producerContext.getImageRequest();
                        if (DecodeProducer.access$100(DecodeProducer.ProgressiveDecoder.this.this$0) || !UriUtil.isNetworkUri(imagerequest.getSourceUri()))
                        {
                            encodedimage.setSampleSize(DownsampleUtil.determineSampleSize(imagerequest, encodedimage));
                        }
                    }
                    doDecode(encodedimage, flag);
                }
            }

            
            {
                this$1 = DecodeProducer.ProgressiveDecoder.this;
                this$0 = decodeproducer;
                producerContext = producercontext;
                super();
            }
        };
        mJobScheduler = new JobScheduler(DecodeProducer.access$300(DecodeProducer.this), consumer, mImageDecodeOptions.minDecodeIntervalMs);
        mProducerContext.addCallbacks(new BaseProducerContextCallbacks() {

            final DecodeProducer.ProgressiveDecoder this$1;
            final DecodeProducer val$this$0;

            public void onIsIntermediateResultExpectedChanged()
            {
                if (mProducerContext.isIntermediateResultExpected())
                {
                    mJobScheduler.scheduleJob();
                }
            }

            
            {
                this$1 = DecodeProducer.ProgressiveDecoder.this;
                this$0 = decodeproducer;
                super();
            }
        });
    }
}
