// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegParser;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.memory.ByteArrayPool;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.Executor;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            Producer, ProducerContext, Consumer, DelegatingConsumer, 
//            JobScheduler, ProducerListener, DownsampleUtil, BaseProducerContextCallbacks

public class DecodeProducer
    implements Producer
{
    private class LocalImagesProgressiveDecoder extends ProgressiveDecoder
    {

        final DecodeProducer this$0;

        protected int getIntermediateImageEndOffset(EncodedImage encodedimage)
        {
            return encodedimage.getSize();
        }

        protected QualityInfo getQualityInfo()
        {
            return ImmutableQualityInfo.of(0, false, false);
        }

        protected boolean updateDecodeJob(EncodedImage encodedimage, boolean flag)
        {
            this;
            JVM INSTR monitorenter ;
            if (flag) goto _L2; else goto _L1
_L1:
            flag = false;
_L4:
            this;
            JVM INSTR monitorexit ;
            return flag;
_L2:
            flag = super.updateDecodeJob(encodedimage, flag);
            if (true) goto _L4; else goto _L3
_L3:
            encodedimage;
            throw encodedimage;
        }

        public LocalImagesProgressiveDecoder(Consumer consumer, ProducerContext producercontext)
        {
            this$0 = DecodeProducer.this;
            super(consumer, producercontext);
        }
    }

    private class NetworkImagesProgressiveDecoder extends ProgressiveDecoder
    {

        private int mLastScheduledScanNumber;
        private final ProgressiveJpegConfig mProgressiveJpegConfig;
        private final ProgressiveJpegParser mProgressiveJpegParser;
        final DecodeProducer this$0;

        protected int getIntermediateImageEndOffset(EncodedImage encodedimage)
        {
            return mProgressiveJpegParser.getBestScanEndOffset();
        }

        protected QualityInfo getQualityInfo()
        {
            return mProgressiveJpegConfig.getQualityInfo(mProgressiveJpegParser.getBestScanNumber());
        }

        protected boolean updateDecodeJob(EncodedImage encodedimage, boolean flag)
        {
            this;
            JVM INSTR monitorenter ;
            boolean flag2 = super.updateDecodeJob(encodedimage, flag);
            boolean flag1 = flag2;
            if (flag) goto _L2; else goto _L1
_L1:
            flag1 = flag2;
            if (!EncodedImage.isValid(encodedimage)) goto _L2; else goto _L3
_L3:
            flag = mProgressiveJpegParser.parseMoreData(encodedimage);
            if (flag) goto _L5; else goto _L4
_L4:
            flag1 = false;
_L2:
            this;
            JVM INSTR monitorexit ;
            return flag1;
_L5:
            int i;
            i = mProgressiveJpegParser.getBestScanNumber();
            if (i <= mLastScheduledScanNumber || i < mProgressiveJpegConfig.getNextScanNumberToDecode(mLastScheduledScanNumber))
            {
                break MISSING_BLOCK_LABEL_103;
            }
            mLastScheduledScanNumber = i;
            flag1 = flag2;
            continue; /* Loop/switch isn't completed */
            encodedimage;
            throw encodedimage;
            flag1 = false;
            if (true) goto _L2; else goto _L6
_L6:
        }

        public NetworkImagesProgressiveDecoder(Consumer consumer, ProducerContext producercontext, ProgressiveJpegParser progressivejpegparser, ProgressiveJpegConfig progressivejpegconfig)
        {
            this$0 = DecodeProducer.this;
            super(consumer, producercontext);
            mProgressiveJpegParser = (ProgressiveJpegParser)Preconditions.checkNotNull(progressivejpegparser);
            mProgressiveJpegConfig = (ProgressiveJpegConfig)Preconditions.checkNotNull(progressivejpegconfig);
            mLastScheduledScanNumber = 0;
        }
    }

    private abstract class ProgressiveDecoder extends DelegatingConsumer
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
            CloseableImage closeableimage = mImageDecoder.decodeImage(encodedimage, i, ((QualityInfo) (obj)), mImageDecodeOptions);
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




        public ProgressiveDecoder(Consumer consumer, ProducerContext producercontext)
        {
            this.this$0 = DecodeProducer.this;
            super(consumer);
            mProducerContext = producercontext;
            mProducerListener = producercontext.getListener();
            mImageDecodeOptions = producercontext.getImageRequest().getImageDecodeOptions();
            mIsFinished = false;
            consumer = producercontext. new _cls1();
            mJobScheduler = new JobScheduler(mExecutor, consumer, mImageDecodeOptions.minDecodeIntervalMs);
            mProducerContext.addCallbacks(new _cls2());
        }
    }


    private static final String BITMAP_SIZE_KEY = "bitmapSize";
    private static final String HAS_GOOD_QUALITY_KEY = "hasGoodQuality";
    private static final String IS_FINAL_KEY = "isFinal";
    public static final String PRODUCER_NAME = "DecodeProducer";
    private final ByteArrayPool mByteArrayPool;
    private final boolean mDownsampleEnabled;
    private final boolean mDownsampleEnabledForNetwork;
    private final Executor mExecutor;
    private final ImageDecoder mImageDecoder;
    private final Producer mNextProducer;
    private final ProgressiveJpegConfig mProgressiveJpegConfig;

    public DecodeProducer(ByteArrayPool bytearraypool, Executor executor, ImageDecoder imagedecoder, ProgressiveJpegConfig progressivejpegconfig, boolean flag, boolean flag1, Producer producer)
    {
        mByteArrayPool = (ByteArrayPool)Preconditions.checkNotNull(bytearraypool);
        mExecutor = (Executor)Preconditions.checkNotNull(executor);
        mImageDecoder = (ImageDecoder)Preconditions.checkNotNull(imagedecoder);
        mProgressiveJpegConfig = (ProgressiveJpegConfig)Preconditions.checkNotNull(progressivejpegconfig);
        mDownsampleEnabled = flag;
        mDownsampleEnabledForNetwork = flag1;
        mNextProducer = (Producer)Preconditions.checkNotNull(producer);
    }

    public void produceResults(Consumer consumer, ProducerContext producercontext)
    {
        if (!UriUtil.isNetworkUri(producercontext.getImageRequest().getSourceUri()))
        {
            consumer = new LocalImagesProgressiveDecoder(consumer, producercontext);
        } else
        {
            consumer = new NetworkImagesProgressiveDecoder(consumer, producercontext, new ProgressiveJpegParser(mByteArrayPool), mProgressiveJpegConfig);
        }
        mNextProducer.produceResults(consumer, producercontext);
    }





    // Unreferenced inner class com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder$1

/* anonymous class */
    class ProgressiveDecoder._cls1
        implements JobScheduler.JobRunnable
    {

        final ProgressiveDecoder this$1;
        final ProducerContext val$producerContext;
        final DecodeProducer val$this$0;

        public void run(EncodedImage encodedimage, boolean flag)
        {
            if (encodedimage != null)
            {
                if (mDownsampleEnabled)
                {
                    ImageRequest imagerequest = producerContext.getImageRequest();
                    if (mDownsampleEnabledForNetwork || !UriUtil.isNetworkUri(imagerequest.getSourceUri()))
                    {
                        encodedimage.setSampleSize(DownsampleUtil.determineSampleSize(imagerequest, encodedimage));
                    }
                }
                doDecode(encodedimage, flag);
            }
        }

            
            {
                this$1 = final_progressivedecoder;
                this$0 = decodeproducer;
                producerContext = ProducerContext.this;
                super();
            }
    }


    // Unreferenced inner class com/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder$2

/* anonymous class */
    class ProgressiveDecoder._cls2 extends BaseProducerContextCallbacks
    {

        final ProgressiveDecoder this$1;
        final DecodeProducer val$this$0;

        public void onIsIntermediateResultExpectedChanged()
        {
            if (mProducerContext.isIntermediateResultExpected())
            {
                mJobScheduler.scheduleJob();
            }
        }

            
            {
                this$1 = final_progressivedecoder;
                this$0 = DecodeProducer.this;
                super();
            }
    }

}
