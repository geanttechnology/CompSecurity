// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ExecutionList
{
    private static final class RunnableExecutorPair
    {

        final Executor executor;
        RunnableExecutorPair next;
        final Runnable runnable;

        RunnableExecutorPair(Runnable runnable1, Executor executor1, RunnableExecutorPair runnableexecutorpair)
        {
            runnable = runnable1;
            executor = executor1;
            next = runnableexecutorpair;
        }
    }


    static final Logger log = Logger.getLogger(com/google/common/util/concurrent/ExecutionList.getName());
    private boolean executed;
    private RunnableExecutorPair runnables;

    public ExecutionList()
    {
    }

    private static void executeListener(Runnable runnable, Executor executor)
    {
        try
        {
            executor.execute(runnable);
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            log.log(Level.SEVERE, (new StringBuilder()).append("RuntimeException while executing runnable ").append(runnable).append(" with executor ").append(executor).toString(), runtimeexception);
        }
    }

    public void add(Runnable runnable, Executor executor)
    {
        Preconditions.checkNotNull(runnable, "Runnable was null.");
        Preconditions.checkNotNull(executor, "Executor was null.");
        this;
        JVM INSTR monitorenter ;
        if (executed)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        runnables = new RunnableExecutorPair(runnable, executor, runnables);
        this;
        JVM INSTR monitorexit ;
        return;
        this;
        JVM INSTR monitorexit ;
        executeListener(runnable, executor);
        return;
        runnable;
        this;
        JVM INSTR monitorexit ;
        throw runnable;
    }

    public void execute()
    {
        RunnableExecutorPair runnableexecutorpair = null;
        this;
        JVM INSTR monitorenter ;
        if (!executed)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        RunnableExecutorPair runnableexecutorpair1;
        executed = true;
        runnableexecutorpair1 = runnables;
        runnables = null;
        this;
        JVM INSTR monitorexit ;
          goto _L1
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
        Exception exception;
        RunnableExecutorPair runnableexecutorpair2;
        do
        {
            runnableexecutorpair2 = runnableexecutorpair;
            if (runnableexecutorpair1 == null)
            {
                break;
            }
            runnableexecutorpair2 = runnableexecutorpair1.next;
            runnableexecutorpair1.next = runnableexecutorpair;
            runnableexecutorpair = runnableexecutorpair1;
            runnableexecutorpair1 = runnableexecutorpair2;
        } while (true);
        for (; runnableexecutorpair2 != null; runnableexecutorpair2 = runnableexecutorpair2.next)
        {
            executeListener(runnableexecutorpair2.runnable, runnableexecutorpair2.executor);
        }

        return;
    }

}
