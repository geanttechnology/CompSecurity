// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;


// Referenced classes of package com.google.common.util.concurrent:
//            Futures, MoreExecutors, ListenableFuture

private static final class _cls1.val.delegate extends _cls1.val.delegate
{

    _cls1.val.delegate(final ListenableFuture delegate)
    {
        delegate.addListener(new Runnable() {

            final Futures.NonCancellationPropagatingFuture this$0;
            final ListenableFuture val$delegate;

            public void run()
            {
                setFuture(delegate);
            }

            
            {
                this$0 = Futures.NonCancellationPropagatingFuture.this;
                delegate = listenablefuture;
                super();
            }
        }, MoreExecutors.directExecutor());
    }
}
