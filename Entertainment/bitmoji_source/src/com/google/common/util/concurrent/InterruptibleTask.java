// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

abstract class InterruptibleTask
    implements Runnable
{

    private static final AtomicReferenceFieldUpdater RUNNER = AtomicReferenceFieldUpdater.newUpdater(com/google/common/util/concurrent/InterruptibleTask, java/lang/Thread, "runner");
    private volatile boolean doneInterrupting;
    private volatile Thread runner;

    InterruptibleTask()
    {
    }

    final void interruptTask()
    {
        Thread thread = runner;
        if (thread != null)
        {
            thread.interrupt();
        }
        doneInterrupting = true;
    }

    public final void run()
    {
        if (RUNNER.compareAndSet(this, null, Thread.currentThread())) goto _L2; else goto _L1
_L1:
        return;
_L2:
        runInterruptibly();
        if (wasInterrupted())
        {
            while (!doneInterrupting) 
            {
                Thread.yield();
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        if (wasInterrupted())
        {
            while (!doneInterrupting) 
            {
                Thread.yield();
            }
        }
        throw exception;
    }

    abstract void runInterruptibly();

    abstract boolean wasInterrupted();

}
