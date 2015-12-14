// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;


// Referenced classes of package com.facebook.imagepipeline.producers:
//            BaseProducerContextCallbacks, PostprocessorProducer, Consumer

class val.this._cls0 extends BaseProducerContextCallbacks
{

    final tConsumer this$1;
    final PostprocessorProducer val$this$0;

    public void onCancellationRequested()
    {
        if (cess._mth1000(this._cls1.this))
        {
            tConsumer().onCancellation();
        }
    }

    ()
    {
        this$1 = final_;
        val$this$0 = PostprocessorProducer.this;
        super();
    }
}
