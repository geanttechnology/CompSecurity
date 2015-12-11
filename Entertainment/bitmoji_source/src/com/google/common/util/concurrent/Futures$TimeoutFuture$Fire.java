// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import java.util.concurrent.TimeoutException;

// Referenced classes of package com.google.common.util.concurrent:
//            Futures, ListenableFuture

private static final class timeoutFutureRef
    implements Runnable
{

    ception timeoutFutureRef;

    public void run()
    {
        timeoutFutureRef timeoutfutureref = timeoutFutureRef;
        if (timeoutfutureref != null) goto _L2; else goto _L1
_L1:
        ListenableFuture listenablefuture;
        return;
_L2:
        if ((listenablefuture = timeoutfutureref.ateRef) == null) goto _L1; else goto _L3
_L3:
        timeoutFutureRef = null;
        if (listenablefuture.isDone())
        {
            timeoutfutureref.ture(listenablefuture);
            return;
        }
        String s = String.valueOf(listenablefuture);
        timeoutfutureref.ception(new TimeoutException((new StringBuilder(String.valueOf(s).length() + 18)).append("Future timed out: ").append(s).toString()));
        listenablefuture.cancel(true);
        return;
        Exception exception;
        exception;
        listenablefuture.cancel(true);
        throw exception;
    }

    ( )
    {
        timeoutFutureRef = ;
    }
}
