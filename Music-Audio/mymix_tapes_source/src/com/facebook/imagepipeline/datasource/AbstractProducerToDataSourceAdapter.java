// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.datasource;

import com.facebook.common.internal.Preconditions;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.BaseConsumer;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;

public abstract class AbstractProducerToDataSourceAdapter extends AbstractDataSource
{

    private final RequestListener mRequestListener;
    private final SettableProducerContext mSettableProducerContext;

    protected AbstractProducerToDataSourceAdapter(Producer producer, SettableProducerContext settableproducercontext, RequestListener requestlistener)
    {
        mSettableProducerContext = settableproducercontext;
        mRequestListener = requestlistener;
        mRequestListener.onRequestStart(settableproducercontext.getImageRequest(), mSettableProducerContext.getCallerContext(), mSettableProducerContext.getId(), mSettableProducerContext.isPrefetch());
        producer.produceResults(createConsumer(), settableproducercontext);
    }

    private Consumer createConsumer()
    {
        return new BaseConsumer() {

            final AbstractProducerToDataSourceAdapter this$0;

            protected void onCancellationImpl()
            {
                AbstractProducerToDataSourceAdapter.this.onCancellationImpl();
            }

            protected void onFailureImpl(Throwable throwable)
            {
                AbstractProducerToDataSourceAdapter.this.onFailureImpl(throwable);
            }

            protected void onNewResultImpl(Object obj, boolean flag)
            {
                AbstractProducerToDataSourceAdapter.this.onNewResultImpl(obj, flag);
            }

            protected void onProgressUpdateImpl(float f)
            {
                setProgress(f);
            }

            
            {
                this$0 = AbstractProducerToDataSourceAdapter.this;
                super();
            }
        };
    }

    private void onCancellationImpl()
    {
        this;
        JVM INSTR monitorenter ;
        Preconditions.checkState(isClosed());
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void onFailureImpl(Throwable throwable)
    {
        if (super.setFailure(throwable))
        {
            mRequestListener.onRequestFailure(mSettableProducerContext.getImageRequest(), mSettableProducerContext.getId(), throwable, mSettableProducerContext.isPrefetch());
        }
    }

    public boolean close()
    {
        if (!super.close())
        {
            return false;
        }
        if (!super.isFinished())
        {
            mRequestListener.onRequestCancellation(mSettableProducerContext.getId());
            mSettableProducerContext.cancel();
        }
        return true;
    }

    protected void onNewResultImpl(Object obj, boolean flag)
    {
        if (super.setResult(obj, flag) && flag)
        {
            mRequestListener.onRequestSuccess(mSettableProducerContext.getImageRequest(), mSettableProducerContext.getId(), mSettableProducerContext.isPrefetch());
        }
    }



}
