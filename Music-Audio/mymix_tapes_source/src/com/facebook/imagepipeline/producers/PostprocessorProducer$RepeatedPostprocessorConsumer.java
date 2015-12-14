// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessorRunner;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            DelegatingConsumer, PostprocessorProducer, ProducerContext, Consumer, 
//            BaseProducerContextCallbacks

class <init> extends DelegatingConsumer
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


    private _cls1.val.this._cls0(_cls1.val.this._cls0 _pcls0, RepeatedPostprocessor repeatedpostprocessor, ProducerContext producercontext)
    {
        this.this$0 = PostprocessorProducer.this;
        super(_pcls0);
        mIsClosed = false;
        mSourceImageRef = null;
        repeatedpostprocessor.setCallback(this);
        producercontext.addCallbacks(new BaseProducerContextCallbacks() {

            final PostprocessorProducer.RepeatedPostprocessorConsumer this$1;
            final PostprocessorProducer val$this$0;

            public void onCancellationRequested()
            {
                if (close())
                {
                    getConsumer().onCancellation();
                }
            }

            
            {
                this$1 = PostprocessorProducer.RepeatedPostprocessorConsumer.this;
                this$0 = postprocessorproducer;
                super();
            }
        });
    }

    getConsumer(getConsumer getconsumer, RepeatedPostprocessor repeatedpostprocessor, ProducerContext producercontext, getConsumer getconsumer1)
    {
        this(getconsumer, repeatedpostprocessor, producercontext);
    }
}
