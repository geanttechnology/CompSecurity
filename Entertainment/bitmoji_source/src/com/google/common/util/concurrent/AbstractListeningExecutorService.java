// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;

// Referenced classes of package com.google.common.util.concurrent:
//            ListeningExecutorService, TrustedListenableFutureTask, ListenableFuture

public abstract class AbstractListeningExecutorService extends AbstractExecutorService
    implements ListeningExecutorService
{

    public AbstractListeningExecutorService()
    {
    }

    protected final RunnableFuture newTaskFor(Runnable runnable, Object obj)
    {
        return TrustedListenableFutureTask.create(runnable, obj);
    }

    protected final RunnableFuture newTaskFor(Callable callable)
    {
        return TrustedListenableFutureTask.create(callable);
    }

    public ListenableFuture submit(Runnable runnable)
    {
        return (ListenableFuture)super.submit(runnable);
    }

    public ListenableFuture submit(Runnable runnable, Object obj)
    {
        return (ListenableFuture)super.submit(runnable, obj);
    }

    public ListenableFuture submit(Callable callable)
    {
        return (ListenableFuture)super.submit(callable);
    }

    public volatile Future submit(Runnable runnable)
    {
        return submit(runnable);
    }

    public volatile Future submit(Runnable runnable, Object obj)
    {
        return submit(runnable, obj);
    }

    public volatile Future submit(Callable callable)
    {
        return submit(callable);
    }
}
