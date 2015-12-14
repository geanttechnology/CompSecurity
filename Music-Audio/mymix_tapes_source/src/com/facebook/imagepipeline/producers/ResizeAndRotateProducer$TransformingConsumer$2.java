// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;


// Referenced classes of package com.facebook.imagepipeline.producers:
//            BaseProducerContextCallbacks, ResizeAndRotateProducer, JobScheduler, Consumer, 
//            ProducerContext

class val.consumer extends BaseProducerContextCallbacks
{

    final this._cls1 this$1;
    final Consumer val$consumer;
    final ResizeAndRotateProducer val$this$0;

    public void onCancellationRequested()
    {
        cess._mth300(this._cls1.this).clearJob();
        cess._mth402(this._cls1.this, true);
        val$consumer.onCancellation();
    }

    public void onIsIntermediateResultExpectedChanged()
    {
        if (cess._mth200(this._cls1.this).isIntermediateResultExpected())
        {
            cess._mth300(this._cls1.this).scheduleJob();
        }
    }

    Y()
    {
        this$1 = final_y;
        val$this$0 = resizeandrotateproducer;
        val$consumer = Consumer.this;
        super();
    }
}
