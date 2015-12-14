// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            DelegatingConsumer, ThrottlingProducer, Consumer, ProducerContext

private class <init> extends DelegatingConsumer
{

    final ThrottlingProducer this$0;

    private void onRequestFinished()
    {
        ThrottlingProducer throttlingproducer = ThrottlingProducer.this;
        throttlingproducer;
        JVM INSTR monitorenter ;
        final Pair nextRequestPair = (Pair)ThrottlingProducer.access$100(ThrottlingProducer.this).poll();
        if (nextRequestPair != null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        ThrottlingProducer.access$210(ThrottlingProducer.this);
        throttlingproducer;
        JVM INSTR monitorexit ;
        if (nextRequestPair != null)
        {
            ThrottlingProducer.access$300(ThrottlingProducer.this).execute(new Runnable() {

                final ThrottlingProducer.ThrottlerConsumer this$1;
                final Pair val$nextRequestPair;

                public void run()
                {
                    produceResultsInternal((Consumer)nextRequestPair.first, (ProducerContext)nextRequestPair.second);
                }

            
            {
                this$1 = ThrottlingProducer.ThrottlerConsumer.this;
                nextRequestPair = pair;
                super();
            }
            });
        }
        return;
        Exception exception;
        exception;
        throttlingproducer;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void onCancellationImpl()
    {
        getConsumer().onCancellation();
        onRequestFinished();
    }

    protected void onFailureImpl(Throwable throwable)
    {
        getConsumer().onFailure(throwable);
        onRequestFinished();
    }

    protected void onNewResultImpl(Object obj, boolean flag)
    {
        getConsumer().onNewResult(obj, flag);
        if (flag)
        {
            onRequestFinished();
        }
    }

    private _cls1.val.nextRequestPair(Consumer consumer)
    {
        this$0 = ThrottlingProducer.this;
        super(consumer);
    }

    this._cls0(Consumer consumer, this._cls0 _pcls0)
    {
        this(consumer);
    }
}
