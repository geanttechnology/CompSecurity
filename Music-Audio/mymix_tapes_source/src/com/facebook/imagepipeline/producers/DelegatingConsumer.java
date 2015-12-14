// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;


// Referenced classes of package com.facebook.imagepipeline.producers:
//            BaseConsumer, Consumer

public abstract class DelegatingConsumer extends BaseConsumer
{

    private final Consumer mConsumer;

    public DelegatingConsumer(Consumer consumer)
    {
        mConsumer = consumer;
    }

    public Consumer getConsumer()
    {
        return mConsumer;
    }

    protected void onCancellationImpl()
    {
        mConsumer.onCancellation();
    }

    protected void onFailureImpl(Throwable throwable)
    {
        mConsumer.onFailure(throwable);
    }

    protected void onProgressUpdateImpl(float f)
    {
        mConsumer.onProgressUpdate(f);
    }
}
