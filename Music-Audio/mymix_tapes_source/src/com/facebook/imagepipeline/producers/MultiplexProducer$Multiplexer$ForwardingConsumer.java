// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import java.io.Closeable;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            BaseConsumer, MultiplexProducer

private class <init> extends BaseConsumer
{

    final onNewResultImpl this$1;

    protected void onCancellationImpl()
    {
        <init>.this.<init>(this);
    }

    protected void onFailureImpl(Throwable throwable)
    {
        <init>.this.<init>(this, throwable);
    }

    protected void onNewResultImpl(Closeable closeable, boolean flag)
    {
        <init>.this.<init>(this, closeable, flag);
    }

    protected volatile void onNewResultImpl(Object obj, boolean flag)
    {
        onNewResultImpl((Closeable)obj, flag);
    }

    protected void onProgressUpdateImpl(float f)
    {
        onNewResultImpl.this.onNewResultImpl(this, f);
    }

    private ()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
