// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

// Referenced classes of package com.google.common.util.concurrent:
//            InterruptibleTask

class TrustedListenableFutureTask extends AbstractFuture.TrustedFuture
    implements RunnableFuture
{
    private final class TrustedFutureInterruptibleTask extends InterruptibleTask
    {

        private final Callable callable;
        final TrustedListenableFutureTask this$0;

        void runInterruptibly()
        {
            if (isDone())
            {
                break MISSING_BLOCK_LABEL_27;
            }
            set(callable.call());
            return;
            Throwable throwable;
            throwable;
            setException(throwable);
            return;
        }

        boolean wasInterrupted()
        {
            return TrustedListenableFutureTask.this.wasInterrupted();
        }

        TrustedFutureInterruptibleTask(Callable callable1)
        {
            this$0 = TrustedListenableFutureTask.this;
            super();
            callable = (Callable)Preconditions.checkNotNull(callable1);
        }
    }


    private TrustedFutureInterruptibleTask task;

    TrustedListenableFutureTask(Callable callable)
    {
        task = new TrustedFutureInterruptibleTask(callable);
    }

    static TrustedListenableFutureTask create(Runnable runnable, Object obj)
    {
        return new TrustedListenableFutureTask(Executors.callable(runnable, obj));
    }

    static TrustedListenableFutureTask create(Callable callable)
    {
        return new TrustedListenableFutureTask(callable);
    }

    final void done()
    {
        super.done();
        task = null;
    }

    protected final void interruptTask()
    {
        TrustedFutureInterruptibleTask trustedfutureinterruptibletask = task;
        if (trustedfutureinterruptibletask != null)
        {
            trustedfutureinterruptibletask.interruptTask();
        }
    }

    public void run()
    {
        TrustedFutureInterruptibleTask trustedfutureinterruptibletask = task;
        if (trustedfutureinterruptibletask != null)
        {
            trustedfutureinterruptibletask.run();
        }
    }
}
