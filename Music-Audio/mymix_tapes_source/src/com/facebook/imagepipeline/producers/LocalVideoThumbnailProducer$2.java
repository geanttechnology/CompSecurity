// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;


// Referenced classes of package com.facebook.imagepipeline.producers:
//            BaseProducerContextCallbacks, LocalVideoThumbnailProducer, StatefulProducerRunnable

class init> extends BaseProducerContextCallbacks
{

    final LocalVideoThumbnailProducer this$0;
    final StatefulProducerRunnable val$cancellableProducerRunnable;

    public void onCancellationRequested()
    {
        val$cancellableProducerRunnable.cancel();
    }

    ()
    {
        this$0 = final_localvideothumbnailproducer;
        val$cancellableProducerRunnable = StatefulProducerRunnable.this;
        super();
    }
}
