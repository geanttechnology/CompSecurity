// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Function;

// Referenced classes of package com.google.common.util.concurrent:
//            Futures, ListenableFuture

static final class gFuture extends gFuture
{

    void doFallback(Function function, Throwable throwable)
        throws Exception
    {
        set(function.apply(throwable));
    }

    volatile void doFallback(Object obj, Throwable throwable)
        throws Exception
    {
        doFallback((Function)obj, throwable);
    }

    gFuture(ListenableFuture listenablefuture, Class class1, Function function)
    {
        super(listenablefuture, class1, function);
    }
}
