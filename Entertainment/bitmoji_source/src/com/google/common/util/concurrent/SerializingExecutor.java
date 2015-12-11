// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

final class SerializingExecutor
    implements Executor
{
    private final class QueueWorker
        implements Runnable
    {

        final SerializingExecutor this$0;

        private void workOnQueue()
        {
_L2:
            Object obj = null;
            Object obj1 = internalLock;
            obj1;
            JVM INSTR monitorenter ;
            if (suspensions == 0)
            {
                obj = (Runnable)queue.poll();
            }
            if (obj != null)
            {
                break MISSING_BLOCK_LABEL_54;
            }
            isWorkerRunning = false;
            obj1;
            JVM INSTR monitorexit ;
            return;
            obj1;
            JVM INSTR monitorexit ;
            try
            {
                ((Runnable) (obj)).run();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                Logger logger = SerializingExecutor.log;
                Level level = Level.SEVERE;
                obj = String.valueOf(obj);
                logger.log(level, (new StringBuilder(String.valueOf(obj).length() + 35)).append("Exception while executing runnable ").append(((String) (obj))).toString(), ((Throwable) (obj1)));
            }
            if (true) goto _L2; else goto _L1
_L1:
            Exception exception;
            exception;
            obj1;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void run()
        {
            try
            {
                workOnQueue();
                return;
            }
            catch (Error error)
            {
                synchronized (internalLock)
                {
                    isWorkerRunning = false;
                }
                throw error;
            }
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private QueueWorker()
        {
            this$0 = SerializingExecutor.this;
            super();
        }

    }


    private static final Logger log = Logger.getLogger(com/google/common/util/concurrent/SerializingExecutor.getName());
    private final Executor executor;
    private final Object internalLock = new Object();
    private boolean isWorkerRunning;
    private final Deque queue = new ArrayDeque();
    private int suspensions;

    public SerializingExecutor(Executor executor1)
    {
        isWorkerRunning = false;
        suspensions = 0;
        executor = (Executor)Preconditions.checkNotNull(executor1);
    }

    private void startQueueWorker()
    {
label0:
        {
            synchronized (internalLock)
            {
                if (queue.peek() != null)
                {
                    break label0;
                }
            }
            return;
        }
        if (suspensions <= 0)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        if (!isWorkerRunning)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        isWorkerRunning = true;
        obj;
        JVM INSTR monitorexit ;
        executor.execute(new QueueWorker());
        Exception exception2;
        if (false)
        {
            synchronized (internalLock)
            {
                isWorkerRunning = false;
            }
            return;
        } else
        {
            return;
        }
        exception1;
        obj1;
        JVM INSTR monitorexit ;
        throw exception1;
        exception2;
        if (true)
        {
            synchronized (internalLock)
            {
                isWorkerRunning = false;
            }
        }
        throw exception2;
        exception3;
        obj2;
        JVM INSTR monitorexit ;
        throw exception3;
    }

    public void execute(Runnable runnable)
    {
        synchronized (internalLock)
        {
            queue.add(runnable);
        }
        startQueueWorker();
        return;
        runnable;
        obj;
        JVM INSTR monitorexit ;
        throw runnable;
    }

    public void executeFirst(Runnable runnable)
    {
        synchronized (internalLock)
        {
            queue.addFirst(runnable);
        }
        startQueueWorker();
        return;
        runnable;
        obj;
        JVM INSTR monitorexit ;
        throw runnable;
    }

    public void resume()
    {
        Object obj = internalLock;
        obj;
        JVM INSTR monitorenter ;
        boolean flag;
        if (suspensions > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag);
        suspensions = suspensions - 1;
        obj;
        JVM INSTR monitorexit ;
        startQueueWorker();
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void suspend()
    {
        synchronized (internalLock)
        {
            suspensions = suspensions + 1;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }




/*
    static boolean access$202(SerializingExecutor serializingexecutor, boolean flag)
    {
        serializingexecutor.isWorkerRunning = flag;
        return flag;
    }

*/



}
