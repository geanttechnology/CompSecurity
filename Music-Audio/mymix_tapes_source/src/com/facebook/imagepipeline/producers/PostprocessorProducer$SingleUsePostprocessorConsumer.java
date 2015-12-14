// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.common.references.CloseableReference;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            DelegatingConsumer, PostprocessorProducer, Consumer

class <init> extends DelegatingConsumer
{

    final PostprocessorProducer this$0;

    protected void onNewResultImpl(CloseableReference closeablereference, boolean flag)
    {
        if (!flag)
        {
            return;
        } else
        {
            getConsumer().onNewResult(closeablereference, flag);
            return;
        }
    }

    protected volatile void onNewResultImpl(Object obj, boolean flag)
    {
        onNewResultImpl((CloseableReference)obj, flag);
    }

    private ( )
    {
        this$0 = PostprocessorProducer.this;
        super();
    }

    this._cls0(this._cls0 _pcls0, this._cls0 _pcls0_1)
    {
        this(_pcls0);
    }
}
