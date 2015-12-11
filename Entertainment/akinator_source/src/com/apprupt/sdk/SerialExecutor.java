// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class SerialExecutor
    implements Executor
{

    private Runnable active;
    private final Executor executor = Executors.newSingleThreadExecutor();
    private final Queue tasks = new ArrayDeque();

    SerialExecutor()
    {
    }

    public void execute(final Runnable r)
    {
        this;
        JVM INSTR monitorenter ;
        tasks.offer(new Runnable() {

            final SerialExecutor this$0;
            final Runnable val$r;

            public void run()
            {
                r.run();
                scheduleNext();
                return;
                Exception exception;
                exception;
                scheduleNext();
                throw exception;
            }

            
            {
                this$0 = SerialExecutor.this;
                r = runnable;
                super();
            }
        });
        if (active == null)
        {
            scheduleNext();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        r;
        throw r;
    }

    protected void scheduleNext()
    {
        this;
        JVM INSTR monitorenter ;
        Runnable runnable;
        runnable = (Runnable)tasks.poll();
        active = runnable;
        if (runnable == null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        executor.execute(active);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
