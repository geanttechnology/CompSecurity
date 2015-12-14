// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessorRunner;
import java.util.Map;
import java.util.concurrent.Executor;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            Producer, ProducerContext, Consumer, DelegatingConsumer, 
//            ProducerListener, BaseProducerContextCallbacks

public class PostprocessorProducer
    implements Producer
{
    private class PostprocessorConsumer extends DelegatingConsumer
    {

        private boolean mIsClosed;
        private boolean mIsDirty;
        private boolean mIsLast;
        private boolean mIsPostProcessingRunning;
        private final ProducerListener mListener;
        private final Postprocessor mPostprocessor;
        private final String mRequestId;
        private CloseableReference mSourceImageRef;
        final PostprocessorProducer this$0;

        private void clearRunningAndStartIfDirty()
        {
            this;
            JVM INSTR monitorenter ;
            boolean flag;
            mIsPostProcessingRunning = false;
            flag = setRunningIfDirtyAndNotRunning();
            this;
            JVM INSTR monitorexit ;
            if (flag)
            {
                submitPostprocessing();
            }
            return;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private boolean close()
        {
            this;
            JVM INSTR monitorenter ;
            if (!mIsClosed)
            {
                break MISSING_BLOCK_LABEL_13;
            }
            this;
            JVM INSTR monitorexit ;
            return false;
            CloseableReference closeablereference;
            closeablereference = mSourceImageRef;
            mSourceImageRef = null;
            mIsClosed = true;
            this;
            JVM INSTR monitorexit ;
            CloseableReference.closeSafely(closeablereference);
            return true;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private void doPostprocessing(CloseableReference closeablereference, boolean flag)
        {
            CloseableReference closeablereference1;
            Object obj;
            Preconditions.checkArgument(CloseableReference.isValid(closeablereference));
            if (!shouldPostprocess((CloseableImage)closeablereference.get()))
            {
                maybeNotifyOnNewResult(closeablereference, flag);
                return;
            }
            mListener.onProducerStart(mRequestId, "PostprocessorProducer");
            obj = null;
            closeablereference1 = obj;
            closeablereference = postprocessInternal((CloseableImage)closeablereference.get());
            closeablereference1 = closeablereference;
            mListener.onProducerFinishWithSuccess(mRequestId, "PostprocessorProducer", getExtraMap(mListener, mRequestId, mPostprocessor));
            closeablereference1 = closeablereference;
            maybeNotifyOnNewResult(closeablereference, flag);
            CloseableReference.closeSafely(closeablereference);
            return;
            closeablereference;
            closeablereference1 = obj;
            mListener.onProducerFinishWithFailure(mRequestId, "PostprocessorProducer", closeablereference, getExtraMap(mListener, mRequestId, mPostprocessor));
            closeablereference1 = obj;
            maybeNotifyOnFailure(closeablereference);
            CloseableReference.closeSafely(null);
            return;
            closeablereference;
            CloseableReference.closeSafely(closeablereference1);
            throw closeablereference;
        }

        private Map getExtraMap(ProducerListener producerlistener, String s, Postprocessor postprocessor)
        {
            if (!producerlistener.requiresExtraMap(s))
            {
                return null;
            } else
            {
                return ImmutableMap.of("Postprocessor", postprocessor.getName());
            }
        }

        private boolean isClosed()
        {
            this;
            JVM INSTR monitorenter ;
            boolean flag = mIsClosed;
            this;
            JVM INSTR monitorexit ;
            return flag;
            Exception exception;
            exception;
            throw exception;
        }

        private void maybeNotifyOnCancellation()
        {
            if (close())
            {
                getConsumer().onCancellation();
            }
        }

        private void maybeNotifyOnFailure(Throwable throwable)
        {
            if (close())
            {
                getConsumer().onFailure(throwable);
            }
        }

        private void maybeNotifyOnNewResult(CloseableReference closeablereference, boolean flag)
        {
            if (!flag && !isClosed() || flag && close())
            {
                getConsumer().onNewResult(closeablereference, flag);
            }
        }

        private CloseableReference postprocessInternal(CloseableImage closeableimage)
        {
            Object obj;
            int i;
            CloseableStaticBitmap closeablestaticbitmap = (CloseableStaticBitmap)closeableimage;
            obj = closeablestaticbitmap.getUnderlyingBitmap();
            obj = mPostprocessor.process(((android.graphics.Bitmap) (obj)), mBitmapFactory);
            i = closeablestaticbitmap.getRotationAngle();
            closeableimage = CloseableReference.of(new CloseableStaticBitmap(((CloseableReference) (obj)), closeableimage.getQualityInfo(), i));
            CloseableReference.closeSafely(((CloseableReference) (obj)));
            return closeableimage;
            closeableimage;
            CloseableReference.closeSafely(((CloseableReference) (obj)));
            throw closeableimage;
        }

        private boolean setRunningIfDirtyAndNotRunning()
        {
            boolean flag = true;
            this;
            JVM INSTR monitorenter ;
            if (mIsClosed || !mIsDirty || mIsPostProcessingRunning || !CloseableReference.isValid(mSourceImageRef)) goto _L2; else goto _L1
_L1:
            mIsPostProcessingRunning = true;
_L4:
            this;
            JVM INSTR monitorexit ;
            return flag;
_L2:
            flag = false;
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        private boolean shouldPostprocess(CloseableImage closeableimage)
        {
            return closeableimage instanceof CloseableStaticBitmap;
        }

        private void submitPostprocessing()
        {
            mExecutor.execute(new Runnable() {

                final PostprocessorConsumer this$1;

                public void run()
                {
                    boolean flag;
                    synchronized (PostprocessorConsumer.this)
                    {
                        obj = mSourceImageRef;
                        flag = mIsLast;
                        mSourceImageRef = null;
                        mIsDirty = false;
                    }
                    if (!CloseableReference.isValid(((CloseableReference) (obj))))
                    {
                        break MISSING_BLOCK_LABEL_63;
                    }
                    doPostprocessing(((CloseableReference) (obj)), flag);
                    CloseableReference.closeSafely(((CloseableReference) (obj)));
                    clearRunningAndStartIfDirty();
                    return;
                    obj;
                    postprocessorconsumer;
                    JVM INSTR monitorexit ;
                    throw obj;
                    Exception exception;
                    exception;
                    CloseableReference.closeSafely(((CloseableReference) (obj)));
                    throw exception;
                }

            
            {
                this$1 = PostprocessorConsumer.this;
                super();
            }
            });
        }

        private void updateSourceImageRef(CloseableReference closeablereference, boolean flag)
        {
            this;
            JVM INSTR monitorenter ;
            if (!mIsClosed)
            {
                break MISSING_BLOCK_LABEL_12;
            }
            this;
            JVM INSTR monitorexit ;
            return;
            CloseableReference closeablereference1;
            closeablereference1 = mSourceImageRef;
            mSourceImageRef = CloseableReference.cloneOrNull(closeablereference);
            mIsLast = flag;
            mIsDirty = true;
            flag = setRunningIfDirtyAndNotRunning();
            this;
            JVM INSTR monitorexit ;
            CloseableReference.closeSafely(closeablereference1);
            if (flag)
            {
                submitPostprocessing();
                return;
            } else
            {
                return;
            }
            closeablereference;
            this;
            JVM INSTR monitorexit ;
            throw closeablereference;
        }

        protected void onCancellationImpl()
        {
            maybeNotifyOnCancellation();
        }

        protected void onFailureImpl(Throwable throwable)
        {
            maybeNotifyOnFailure(throwable);
        }

        protected void onNewResultImpl(CloseableReference closeablereference, boolean flag)
        {
            if (!CloseableReference.isValid(closeablereference))
            {
                if (flag)
                {
                    maybeNotifyOnNewResult(null, true);
                }
                return;
            } else
            {
                updateSourceImageRef(closeablereference, flag);
                return;
            }
        }

        protected volatile void onNewResultImpl(Object obj, boolean flag)
        {
            onNewResultImpl((CloseableReference)obj, flag);
        }




/*
        static CloseableReference access$302(PostprocessorConsumer postprocessorconsumer, CloseableReference closeablereference)
        {
            postprocessorconsumer.mSourceImageRef = closeablereference;
            return closeablereference;
        }

*/



/*
        static boolean access$502(PostprocessorConsumer postprocessorconsumer, boolean flag)
        {
            postprocessorconsumer.mIsDirty = flag;
            return flag;
        }

*/



        public PostprocessorConsumer(Consumer consumer, ProducerListener producerlistener, String s, Postprocessor postprocessor, ProducerContext producercontext)
        {
            this$0 = PostprocessorProducer.this;
            super(consumer);
            mSourceImageRef = null;
            mIsLast = false;
            mIsDirty = false;
            mIsPostProcessingRunning = false;
            mListener = producerlistener;
            mRequestId = s;
            mPostprocessor = postprocessor;
            producercontext.addCallbacks(new _cls1());
        }
    }

    class RepeatedPostprocessorConsumer extends DelegatingConsumer
        implements RepeatedPostprocessorRunner
    {

        private boolean mIsClosed;
        private CloseableReference mSourceImageRef;
        final PostprocessorProducer this$0;

        private boolean close()
        {
            this;
            JVM INSTR monitorenter ;
            if (!mIsClosed)
            {
                break MISSING_BLOCK_LABEL_13;
            }
            this;
            JVM INSTR monitorexit ;
            return false;
            CloseableReference closeablereference;
            closeablereference = mSourceImageRef;
            mSourceImageRef = null;
            mIsClosed = true;
            this;
            JVM INSTR monitorexit ;
            CloseableReference.closeSafely(closeablereference);
            return true;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private void setSourceImageRef(CloseableReference closeablereference)
        {
            this;
            JVM INSTR monitorenter ;
            if (!mIsClosed)
            {
                break MISSING_BLOCK_LABEL_12;
            }
            this;
            JVM INSTR monitorexit ;
            return;
            CloseableReference closeablereference1;
            closeablereference1 = mSourceImageRef;
            mSourceImageRef = CloseableReference.cloneOrNull(closeablereference);
            this;
            JVM INSTR monitorexit ;
            CloseableReference.closeSafely(closeablereference1);
            return;
            closeablereference;
            this;
            JVM INSTR monitorexit ;
            throw closeablereference;
        }

        private void updateInternal()
        {
            this;
            JVM INSTR monitorenter ;
            if (!mIsClosed)
            {
                break MISSING_BLOCK_LABEL_12;
            }
            this;
            JVM INSTR monitorexit ;
            return;
            Object obj = CloseableReference.cloneOrNull(mSourceImageRef);
            this;
            JVM INSTR monitorexit ;
            getConsumer().onNewResult(obj, false);
            CloseableReference.closeSafely(((CloseableReference) (obj)));
            return;
            obj;
            this;
            JVM INSTR monitorexit ;
            throw obj;
            Exception exception;
            exception;
            CloseableReference.closeSafely(((CloseableReference) (obj)));
            throw exception;
        }

        protected void onCancellationImpl()
        {
            if (close())
            {
                getConsumer().onCancellation();
            }
        }

        protected void onFailureImpl(Throwable throwable)
        {
            if (close())
            {
                getConsumer().onFailure(throwable);
            }
        }

        protected void onNewResultImpl(CloseableReference closeablereference, boolean flag)
        {
            if (!flag)
            {
                return;
            } else
            {
                setSourceImageRef(closeablereference);
                updateInternal();
                return;
            }
        }

        protected volatile void onNewResultImpl(Object obj, boolean flag)
        {
            onNewResultImpl((CloseableReference)obj, flag);
        }

        public void update()
        {
            this;
            JVM INSTR monitorenter ;
            updateInternal();
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }


        private RepeatedPostprocessorConsumer(PostprocessorConsumer postprocessorconsumer, RepeatedPostprocessor repeatedpostprocessor, ProducerContext producercontext)
        {
            this$0 = PostprocessorProducer.this;
            super(postprocessorconsumer);
            mIsClosed = false;
            mSourceImageRef = null;
            repeatedpostprocessor.setCallback(this);
            producercontext.addCallbacks(new _cls1());
        }

    }

    class SingleUsePostprocessorConsumer extends DelegatingConsumer
    {

        final PostprocessorProducer this$0;

        protected void onNewResultImpl(CloseableReference closeablereference, boolean flag)
        {
            if (!flag)
            {
                return;
            } else
            {
                getConsumer().onNewResult(closeablereference, flag);
                return;
            }
        }

        protected volatile void onNewResultImpl(Object obj, boolean flag)
        {
            onNewResultImpl((CloseableReference)obj, flag);
        }

        private SingleUsePostprocessorConsumer(PostprocessorConsumer postprocessorconsumer)
        {
            this$0 = PostprocessorProducer.this;
            super(postprocessorconsumer);
        }

    }


    static final String NAME = "PostprocessorProducer";
    static final String POSTPROCESSOR = "Postprocessor";
    private final PlatformBitmapFactory mBitmapFactory;
    private final Executor mExecutor;
    private final Producer mNextProducer;

    public PostprocessorProducer(Producer producer, PlatformBitmapFactory platformbitmapfactory, Executor executor)
    {
        mNextProducer = (Producer)Preconditions.checkNotNull(producer);
        mBitmapFactory = platformbitmapfactory;
        mExecutor = (Executor)Preconditions.checkNotNull(executor);
    }

    public void produceResults(Consumer consumer, ProducerContext producercontext)
    {
        ProducerListener producerlistener = producercontext.getListener();
        Postprocessor postprocessor = producercontext.getImageRequest().getPostprocessor();
        consumer = new PostprocessorConsumer(consumer, producerlistener, producercontext.getId(), postprocessor, producercontext);
        if (postprocessor instanceof RepeatedPostprocessor)
        {
            consumer = new RepeatedPostprocessorConsumer(consumer, (RepeatedPostprocessor)postprocessor, producercontext);
        } else
        {
            consumer = new SingleUsePostprocessorConsumer(consumer);
        }
        mNextProducer.produceResults(consumer, producercontext);
    }



    // Unreferenced inner class com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer$1

/* anonymous class */
    class PostprocessorConsumer._cls1 extends BaseProducerContextCallbacks
    {

        final PostprocessorConsumer this$1;
        final PostprocessorProducer val$this$0;

        public void onCancellationRequested()
        {
            maybeNotifyOnCancellation();
        }

            
            {
                this$1 = final_postprocessorconsumer;
                this$0 = PostprocessorProducer.this;
                super();
            }
    }


    // Unreferenced inner class com/facebook/imagepipeline/producers/PostprocessorProducer$RepeatedPostprocessorConsumer$1

/* anonymous class */
    class RepeatedPostprocessorConsumer._cls1 extends BaseProducerContextCallbacks
    {

        final RepeatedPostprocessorConsumer this$1;
        final PostprocessorProducer val$this$0;

        public void onCancellationRequested()
        {
            if (close())
            {
                getConsumer().onCancellation();
            }
        }

            
            {
                this$1 = final_repeatedpostprocessorconsumer;
                this$0 = PostprocessorProducer.this;
                super();
            }
    }

}
