// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;

// Referenced classes of package com.google.common.util.concurrent:
//            InterruptibleTask, TrustedListenableFutureTask

private final class callable extends InterruptibleTask
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

    (Callable callable1)
    {
        this$0 = TrustedListenableFutureTask.this;
        super();
        callable = (Callable)Preconditions.checkNotNull(callable1);
    }
}
