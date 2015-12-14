// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;


// Referenced classes of package com.facebook.imagepipeline.producers:
//            StatefulProducerRunnable, ThreadHandoffProducer, ProducerListener, Producer, 
//            Consumer, ProducerContext

class  extends StatefulProducerRunnable
{

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
        val$producerListener.onProducerFinishWithSuccess(val$requestId, "BackgroundThreadHandoffProducer", null);
        ThreadHandoffProducer.access$000(ThreadHandoffProducer.this).produceResults(val$consumer, val$context);
    }

    (ProducerListener producerlistener1, String s2, 
            Consumer consumer2, ProducerContext producercontext)
    {
        this$0 = final_threadhandoffproducer;
        val$producerListener = producerlistener1;
        val$requestId = s2;
        val$consumer = consumer2;
        val$context = producercontext;
        super(final_consumer1, final_producerlistener, final_s, String.this);
    }
}
