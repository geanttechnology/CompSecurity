// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import java.util.concurrent.Executor;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            Producer, ProducerContext, Consumer, StatefulProducerRunnable, 
//            ProducerListener, BaseProducerContextCallbacks

public class ThreadHandoffProducer
    implements Producer
{

    protected static final String PRODUCER_NAME = "BackgroundThreadHandoffProducer";
    private final Executor mExecutor;
    private final Producer mNextProducer;

    public ThreadHandoffProducer(Executor executor, Producer producer)
    {
        mExecutor = (Executor)Preconditions.checkNotNull(executor);
        mNextProducer = (Producer)Preconditions.checkNotNull(producer);
    }

    public void produceResults(final Consumer final_consumer1, ProducerContext producercontext)
    {
        final ProducerListener final_producerlistener = producercontext.getListener();
        String s = producercontext.getId();
        final_consumer1 = new StatefulProducerRunnable(final_producerlistener, s, final_consumer1, producercontext) {

            final ThreadHandoffProducer this$0;
            final Consumer val$consumer;
            final ProducerContext val$context;
            final ProducerListener val$producerListener;
            final String val$requestId;

            protected void disposeResult(Object obj)
            {
            }

            protected Object getResult()
                throws Exception
            {
                return null;
            }

            protected void onSuccess(Object obj)
            {
                producerListener.onProducerFinishWithSuccess(requestId, "BackgroundThreadHandoffProducer", null);
                mNextProducer.produceResults(consumer, context);
            }

            
            {
                this$0 = ThreadHandoffProducer.this;
                producerListener = producerlistener1;
                requestId = s2;
                consumer = consumer2;
                context = producercontext;
                super(final_consumer1, final_producerlistener, final_s, final_s1);
            }
        };
        producercontext.addCallbacks(new BaseProducerContextCallbacks() {

            final ThreadHandoffProducer this$0;
            final StatefulProducerRunnable val$statefulRunnable;

            public void onCancellationRequested()
            {
                statefulRunnable.cancel();
            }

            
            {
                this$0 = ThreadHandoffProducer.this;
                statefulRunnable = statefulproducerrunnable;
                super();
            }
        });
        mExecutor.execute(final_consumer1);
    }

}
