// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;

// Referenced classes of package com.google.common.util.concurrent:
//            Futures, AsyncFunction, ListenableFuture

static final class re extends re
{

    void doFallback(AsyncFunction asyncfunction, Throwable throwable)
        throws Exception
    {
        asyncfunction = asyncfunction.apply(throwable);
        Preconditions.checkNotNull(asyncfunction, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)?");
        setFuture(asyncfunction);
    }

    volatile void doFallback(Object obj, Throwable throwable)
        throws Exception
    {
        doFallback((AsyncFunction)obj, throwable);
    }

    re(ListenableFuture listenablefuture, Class class1, AsyncFunction asyncfunction)
    {
        super(listenablefuture, class1, asyncfunction);
    }
}
