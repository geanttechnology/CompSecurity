// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TaskQueue
{

    private final Lock lock = new ReentrantLock();
    private Task tail;

    TaskQueue()
    {
    }

    private Task getTaskToAwait()
    {
        lock.lock();
        Task task;
        if (tail == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        task = tail;
_L1:
        task = task.continueWith(new Continuation() {

            final TaskQueue this$0;

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            public Void then(Task task1)
                throws Exception
            {
                return null;
            }

            
            {
                this$0 = TaskQueue.this;
                super();
            }
        });
        lock.unlock();
        return task;
        task = Task.forResult(null);
          goto _L1
        Exception exception;
        exception;
        lock.unlock();
        throw exception;
    }

    static Continuation waitFor(Task task)
    {
        return new Continuation(task) {

            final Task val$toAwait;

            public Task then(Task task1)
                throws Exception
            {
                return toAwait.continueWithTask(task1. new Continuation() {

                    final _cls2 this$0;
                    final Task val$task;

                    public Task then(Task task1)
                        throws Exception
                    {
                        return task;
                    }

                    public volatile Object then(Task task1)
                        throws Exception
                    {
                        return then(task1);
                    }

            
            {
                this$0 = final__pcls2;
                task = Task.this;
                super();
            }
                });
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                toAwait = task;
                super();
            }
        };
    }

    Task enqueue(Continuation continuation)
    {
        lock.lock();
        if (tail == null) goto _L2; else goto _L1
_L1:
        Task task = tail;
_L4:
        continuation = (Task)continuation.then(getTaskToAwait());
        tail = Task.whenAll(Arrays.asList(new Task[] {
            task, continuation
        }));
        lock.unlock();
        return continuation;
_L2:
        task = Task.forResult(null);
        if (true) goto _L4; else goto _L3
_L3:
        continuation;
        throw continuation;
        continuation;
        lock.unlock();
        throw continuation;
        continuation;
        throw new RuntimeException(continuation);
    }

    Lock getLock()
    {
        return lock;
    }

    void waitUntilFinished()
        throws InterruptedException
    {
        lock.lock();
        Task task = tail;
        if (task == null)
        {
            lock.unlock();
            return;
        }
        tail.waitForCompletion();
        lock.unlock();
        return;
        Exception exception;
        exception;
        lock.unlock();
        throw exception;
    }
}
