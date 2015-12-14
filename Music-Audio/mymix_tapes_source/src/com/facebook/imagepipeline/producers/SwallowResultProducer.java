// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;


// Referenced classes of package com.facebook.imagepipeline.producers:
//            Producer, Consumer, ProducerContext, DelegatingConsumer

public class SwallowResultProducer
    implements Producer
{

    private final Producer mNextProducer;

    public SwallowResultProducer(Producer producer)
    {
        mNextProducer = producer;
    }

    public void produceResults(Consumer consumer, ProducerContext producercontext)
    {
        consumer = new DelegatingConsumer(consumer) {

            final SwallowResultProducer this$0;

            protected void onNewResultImpl(Object obj, boolean flag)
            {
                if (flag)
                {
                    getConsumer().onNewResult(null, flag);
                }
            }

            
            {
                this$0 = SwallowResultProducer.this;
                super(consumer);
            }
        };
        mNextProducer.produceResults(consumer, producercontext);
    }
}
