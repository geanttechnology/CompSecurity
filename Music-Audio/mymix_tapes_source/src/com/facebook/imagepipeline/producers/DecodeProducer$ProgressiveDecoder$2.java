// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;


// Referenced classes of package com.facebook.imagepipeline.producers:
//            BaseProducerContextCallbacks, DecodeProducer, ProducerContext, JobScheduler

class val.this._cls0 extends BaseProducerContextCallbacks
{

    final this._cls1 this$1;
    final DecodeProducer val$this$0;

    public void onIsIntermediateResultExpectedChanged()
    {
        if (cess._mth400(this._cls1.this).isIntermediateResultExpected())
        {
            cess._mth500(this._cls1.this).scheduleJob();
        }
    }

    ()
    {
        this$1 = final_;
        val$this$0 = DecodeProducer.this;
        super();
    }
}
