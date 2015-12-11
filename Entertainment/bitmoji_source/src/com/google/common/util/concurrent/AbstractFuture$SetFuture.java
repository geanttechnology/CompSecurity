// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;


// Referenced classes of package com.google.common.util.concurrent:
//            AbstractFuture, ListenableFuture

private final class future
    implements Runnable
{

    final ListenableFuture future;
    final AbstractFuture this$0;

    public void run()
    {
        if (AbstractFuture.access$200(AbstractFuture.this) != this)
        {
            return;
        } else
        {
            AbstractFuture.access$300(AbstractFuture.this, future, this);
            return;
        }
    }

    (ListenableFuture listenablefuture)
    {
        this$0 = AbstractFuture.this;
        super();
        future = listenablefuture;
    }
}
