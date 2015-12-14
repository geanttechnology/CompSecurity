// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            BaseProducerContextCallbacks, DiskCacheProducer

class allbacks extends BaseProducerContextCallbacks
{

    final DiskCacheProducer this$0;
    final AtomicBoolean val$isCancelled;

    public void onCancellationRequested()
    {
        val$isCancelled.set(true);
    }

    allbacks()
    {
        this$0 = final_diskcacheproducer;
        val$isCancelled = AtomicBoolean.this;
        super();
    }
}
