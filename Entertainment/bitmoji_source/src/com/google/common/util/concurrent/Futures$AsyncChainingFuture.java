// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;

// Referenced classes of package com.google.common.util.concurrent:
//            Futures, AsyncFunction, ListenableFuture

private static final class re extends re
{

    void doTransform(AsyncFunction asyncfunction, Object obj)
        throws Exception
    {
        asyncfunction = asyncfunction.apply(obj);
        Preconditions.checkNotNull(asyncfunction, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)?");
        setFuture(asyncfunction);
    }

    volatile void doTransform(Object obj, Object obj1)
        throws Exception
    {
        doTransform((AsyncFunction)obj, obj1);
    }

    re(ListenableFuture listenablefuture, AsyncFunction asyncfunction)
    {
        super(listenablefuture, asyncfunction);
    }
}
