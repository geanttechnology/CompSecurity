// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            Producer, ProducerContext, ProducerListener, Consumer, 
//            DelegatingConsumer

public class ThrottlingProducer
    implements Producer
{
    private class ThrottlerConsumer extends DelegatingConsumer
    {

        final ThrottlingProducer this$0;

        private void onRequestFinished()
        {
            ThrottlingProducer throttlingproducer = ThrottlingProducer.this;
            throttlingproducer;
            JVM INSTR monitorenter ;
            Pair pair = (Pair)mPendingRequests.poll();
            if (pair != null)
            {
                break MISSING_BLOCK_LABEL_33;
            }
            int i = 
// JavaClassFileOutputException: get_constant: invalid tag

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

        private ThrottlerConsumer(Consumer consumer)
        {
            this$0 = ThrottlingProducer.this;
            super(consumer);
        }

    }


    static final String PRODUCER_NAME = "ThrottlingProducer";
    private final Executor mExecutor;
    private final int mMaxSimultaneousRequests;
    private final Producer mNextProducer;
    private int mNumCurrentRequests;
    private final ConcurrentLinkedQueue mPendingRequests = new ConcurrentLinkedQueue();

    public ThrottlingProducer(int i, Executor executor, Producer producer)
    {
        mMaxSimultaneousRequests = i;
        mExecutor = (Executor)Preconditions.checkNotNull(executor);
        mNextProducer = (Producer)Preconditions.checkNotNull(producer);
        mNumCurrentRequests = 0;
    }

    public void produceResults(Consumer consumer, ProducerContext producercontext)
    {
        producercontext.getListener().onProducerStart(producercontext.getId(), "ThrottlingProducer");
        this;
        JVM INSTR monitorenter ;
        if (mNumCurrentRequests < mMaxSimultaneousRequests) goto _L2; else goto _L1
_L1:
        mPendingRequests.add(Pair.create(consumer, producercontext));
        boolean flag = true;
_L4:
        this;
        JVM INSTR monitorexit ;
        if (!flag)
        {
            produceResultsInternal(consumer, producercontext);
        }
        return;
_L2:
        mNumCurrentRequests = mNumCurrentRequests + 1;
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
        consumer;
        this;
        JVM INSTR monitorexit ;
        throw consumer;
    }

    void produceResultsInternal(Consumer consumer, ProducerContext producercontext)
    {
        producercontext.getListener().onProducerFinishWithSuccess(producercontext.getId(), "ThrottlingProducer", null);
        mNextProducer.produceResults(new ThrottlerConsumer(consumer), producercontext);
    }



/*
    static int access$210(ThrottlingProducer throttlingproducer)
    {
        int i = throttlingproducer.mNumCurrentRequests;
        throttlingproducer.mNumCurrentRequests = i - 1;
        return i;
    }

*/


    // Unreferenced inner class com/facebook/imagepipeline/producers/ThrottlingProducer$ThrottlerConsumer$1

/* anonymous class */
    class ThrottlerConsumer._cls1
        implements Runnable
    {

        final ThrottlerConsumer this$1;
        final Pair val$nextRequestPair;

        public void run()
        {
            produceResultsInternal((Consumer)nextRequestPair.first, (ProducerContext)nextRequestPair.second);
        }

            
            {
                this$1 = final_throttlerconsumer;
                nextRequestPair = Pair.this;
                super();
            }
    }

}
