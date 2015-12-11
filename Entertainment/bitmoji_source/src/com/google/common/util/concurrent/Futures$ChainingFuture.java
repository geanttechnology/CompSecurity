// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Function;

// Referenced classes of package com.google.common.util.concurrent:
//            Futures, ListenableFuture

private static final class gFuture extends gFuture
{

    void doTransform(Function function, Object obj)
    {
        set(function.apply(obj));
    }

    volatile void doTransform(Object obj, Object obj1)
        throws Exception
    {
        doTransform((Function)obj, obj1);
    }

    gFuture(ListenableFuture listenablefuture, Function function)
    {
        super(listenablefuture, function);
    }
}
