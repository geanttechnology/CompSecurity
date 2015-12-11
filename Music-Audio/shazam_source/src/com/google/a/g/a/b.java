// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.g.a;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;

// Referenced classes of package com.google.a.g.a:
//            m, j, k

public abstract class b extends AbstractExecutorService
    implements m
{

    public b()
    {
    }

    public final j a(Runnable runnable)
    {
        return (j)super.submit(runnable);
    }

    protected RunnableFuture newTaskFor(Runnable runnable, Object obj)
    {
        return k.a(runnable, obj);
    }

    protected RunnableFuture newTaskFor(Callable callable)
    {
        return k.a(callable);
    }

    public Future submit(Runnable runnable)
    {
        return a(runnable);
    }

    public volatile Future submit(Runnable runnable, Object obj)
    {
        return (j)super.submit(runnable, obj);
    }

    public volatile Future submit(Callable callable)
    {
        return (j)super.submit(callable);
    }
}
