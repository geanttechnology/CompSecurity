// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.google.common.util.concurrent:
//            Futures, ListenableFuture

private static final class delegateRef extends Future
{
    private static final class Fire
        implements Runnable
    {

        Futures.TimeoutFuture timeoutFutureRef;

        public void run()
        {
            Futures.TimeoutFuture timeoutfuture = timeoutFutureRef;
            if (timeoutfuture != null) goto _L2; else goto _L1
_L1:
            ListenableFuture listenablefuture;
            return;
_L2:
            if ((listenablefuture = timeoutfuture.delegateRef) == null) goto _L1; else goto _L3
_L3:
            timeoutFutureRef = null;
            if (listenablefuture.isDone())
            {
                timeoutfuture.setFuture(listenablefuture);
                return;
            }
            String s = String.valueOf(listenablefuture);
            timeoutfuture.setException(new TimeoutException((new StringBuilder(String.valueOf(s).length() + 18)).append("Future timed out: ").append(s).toString()));
            listenablefuture.cancel(true);
            return;
            Exception exception;
            exception;
            listenablefuture.cancel(true);
            throw exception;
        }

        Fire(Futures.TimeoutFuture timeoutfuture)
        {
            timeoutFutureRef = timeoutfuture;
        }
    }


    ListenableFuture delegateRef;
    Future timer;

    void done()
    {
        maybePropagateCancellation(delegateRef);
        Future future = timer;
        if (future != null)
        {
            future.cancel(false);
        }
        delegateRef = null;
        timer = null;
    }

    Fire.timeoutFutureRef(ListenableFuture listenablefuture)
    {
        delegateRef = (ListenableFuture)Preconditions.checkNotNull(listenablefuture);
    }
}
