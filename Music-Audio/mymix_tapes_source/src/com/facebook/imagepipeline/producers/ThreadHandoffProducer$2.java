// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;


// Referenced classes of package com.facebook.imagepipeline.producers:
//            BaseProducerContextCallbacks, ThreadHandoffProducer, StatefulProducerRunnable

class acks extends BaseProducerContextCallbacks
{

    final ThreadHandoffProducer this$0;
    final StatefulProducerRunnable val$statefulRunnable;

    public void onCancellationRequested()
    {
        val$statefulRunnable.cancel();
    }

    ()
    {
        this$0 = final_threadhandoffproducer;
        val$statefulRunnable = StatefulProducerRunnable.this;
        super();
    }
}
