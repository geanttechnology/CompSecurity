// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;


// Referenced classes of package com.google.common.util.concurrent:
//            Futures, ListenableFuture

class val.delegate
    implements Runnable
{

    final val.delegate this$0;
    final ListenableFuture val$delegate;

    public void run()
    {
        tFuture(val$delegate);
    }

    ()
    {
        this$0 = final_;
        val$delegate = ListenableFuture.this;
        super();
    }
}
