// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import android.util.Pair;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            ThrottlingProducer, Consumer, ProducerContext

class val.nextRequestPair
    implements Runnable
{

    final val.nextRequestPair this$1;
    final Pair val$nextRequestPair;

    public void run()
    {
        produceResultsInternal((Consumer)val$nextRequestPair.first, (ProducerContext)val$nextRequestPair.second);
    }

    Q()
    {
        this$1 = final_q;
        val$nextRequestPair = Pair.this;
        super();
    }
}
