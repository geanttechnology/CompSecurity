// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.Map;
import java.util.concurrent.Executor;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            DelegatingConsumer, PostprocessorProducer, ProducerContext, ProducerListener, 
//            Consumer, BaseProducerContextCallbacks

private class maybeNotifyOnCancellation extends DelegatingConsumer
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
        obj = mPostprocessor.process(((android.graphics.Bitmap) (obj)), PostprocessorProducer.access$900(PostprocessorProducer.this));
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
        PostprocessorProducer.access$800(PostprocessorProducer.this).execute(new Runnable() {

            final PostprocessorProducer.PostprocessorConsumer this$1;

            public void run()
            {
                boolean flag;
                synchronized (PostprocessorProducer.PostprocessorConsumer.this)
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
                this$1 = PostprocessorProducer.PostprocessorConsumer.this;
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
    static CloseableReference access$302(_cls2 _pcls2, CloseableReference closeablereference)
    {
        _pcls2.mSourceImageRef = closeablereference;
        return closeablereference;
    }

*/



/*
    static boolean access$502(mSourceImageRef msourceimageref, boolean flag)
    {
        msourceimageref.mIsDirty = flag;
        return flag;
    }

*/



    public _cls2.this._cls1(Consumer consumer, ProducerListener producerlistener, String s, Postprocessor postprocessor, ProducerContext producercontext)
    {
        this.this$0 = PostprocessorProducer.this;
        super(consumer);
        mSourceImageRef = null;
        mIsLast = false;
        mIsDirty = false;
        mIsPostProcessingRunning = false;
        mListener = producerlistener;
        mRequestId = s;
        mPostprocessor = postprocessor;
        producercontext.addCallbacks(new BaseProducerContextCallbacks() {

            final PostprocessorProducer.PostprocessorConsumer this$1;
            final PostprocessorProducer val$this$0;

            public void onCancellationRequested()
            {
                maybeNotifyOnCancellation();
            }

            
            {
                this$1 = PostprocessorProducer.PostprocessorConsumer.this;
                this$0 = postprocessorproducer;
                super();
            }
        });
    }
}
