// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;


// Referenced classes of package com.facebook.imagepipeline.producers:
//            Producer, Consumer, ProducerContext

public class NullProducer
    implements Producer
{

    public NullProducer()
    {
    }

    public void produceResults(Consumer consumer, ProducerContext producercontext)
    {
        consumer.onNewResult((Object)null, true);
    }
}
