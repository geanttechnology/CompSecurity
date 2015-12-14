// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.ui;

import com.amazon.gallery.foundation.utils.DebugAssert;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.thread.NamedThreadFactory;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class UiReadyExecutor
    implements Executor
{
    private static final class RunMode extends Enum
    {

        private static final RunMode $VALUES[];
        public static final RunMode QUEUEING;
        public static final RunMode RUNNING;

        public static RunMode valueOf(String s)
        {
            return (RunMode)Enum.valueOf(com/amazon/gallery/thor/app/ui/UiReadyExecutor$RunMode, s);
        }

        public static RunMode[] values()
        {
            return (RunMode[])$VALUES.clone();
        }

        static 
        {
            QUEUEING = new RunMode("QUEUEING", 0);
            RUNNING = new RunMode("RUNNING", 1);
            $VALUES = (new RunMode[] {
                QUEUEING, RUNNING
            });
        }

        private RunMode(String s, int i)
        {
            super(s, i);
        }
    }


    private final String TAG = com/amazon/gallery/thor/app/ui/UiReadyExecutor.getName();
    private Executor executor;
    private RunMode mode;
    private Queue queue;

    public UiReadyExecutor()
    {
        executor = Executors.newSingleThreadExecutor(new NamedThreadFactory(com/amazon/gallery/thor/app/ui/UiReadyExecutor.getSimpleName()));
        queue = new LinkedList();
        mode = RunMode.RUNNING;
    }

    private void scheduleQueuedTasks()
    {
        Runnable arunnable[];
        boolean flag;
        if (mode == RunMode.RUNNING)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        DebugAssert.assertTrue(flag, "Scheduling tasks while not in running mode");
        arunnable = (Runnable[])queue.toArray(new Runnable[queue.size()]);
        queue.clear();
        if (arunnable != null)
        {
            GLogger.i(TAG, "#scheduleQueuedTasks, running %d tasks.", new Object[] {
                Integer.valueOf(arunnable.length)
            });
            int j = arunnable.length;
            for (int i = 0; i < j; i++)
            {
                Runnable runnable = arunnable[i];
                executor.execute(runnable);
            }

        }
    }

    public void execute(Runnable runnable)
    {
        this;
        JVM INSTR monitorenter ;
        if (mode != RunMode.RUNNING) goto _L2; else goto _L1
_L1:
        GLogger.i(TAG, "Scheduling a task", new Object[0]);
        executor.execute(runnable);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        GLogger.i(TAG, "Queueing a task", new Object[0]);
        queue.add(runnable);
        if (true) goto _L4; else goto _L3
_L3:
        runnable;
        throw runnable;
    }

    public void onLoadFinished()
    {
        this;
        JVM INSTR monitorenter ;
        mode = RunMode.RUNNING;
        GLogger.i(TAG, "#onLoadFinished, mode: RUNNING", new Object[0]);
        scheduleQueuedTasks();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void onLoaderInitialized()
    {
        this;
        JVM INSTR monitorenter ;
        mode = RunMode.QUEUEING;
        GLogger.i(TAG, "#onLoaderInitialized, mode: QUEUEING", new Object[0]);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
