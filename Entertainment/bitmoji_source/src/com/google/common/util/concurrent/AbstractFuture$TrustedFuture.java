// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.google.common.util.concurrent:
//            AbstractFuture

static abstract class  extends AbstractFuture
{

    public final void addListener(Runnable runnable, Executor executor)
    {
        super.addListener(runnable, executor);
    }

    public final Object get()
        throws InterruptedException, ExecutionException
    {
        return super.get();
    }

    public final Object get(long l, TimeUnit timeunit)
        throws InterruptedException, ExecutionException, TimeoutException
    {
        return super.get(l, timeunit);
    }

    public final boolean isCancelled()
    {
        return super.isCancelled();
    }

    public final boolean isDone()
    {
        return super.isDone();
    }

    ()
    {
    }
}
