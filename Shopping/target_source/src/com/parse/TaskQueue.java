// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TaskQueue
{

    private final Lock lock = new ReentrantLock();
    private j tail;

    TaskQueue()
    {
    }

    private j getTaskToAwait()
    {
        lock.lock();
        j j1;
        if (tail == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        j1 = tail;
_L1:
        j1 = j1.a(new i() {

            final TaskQueue this$0;

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            public Void then(j j2)
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
        return j1;
        j1 = j.a(null);
          goto _L1
        Exception exception;
        exception;
        lock.unlock();
        throw exception;
    }

    static i waitFor(j j1)
    {
        return new i(j1) {

            final j val$toAwait;

            public j then(j j2)
                throws Exception
            {
                return toAwait.b(j2. new i() {

                    final _cls2 this$0;
                    final j val$task;

                    public j then(j j1)
                        throws Exception
                    {
                        return task;
                    }

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

            
            {
                this$0 = final__pcls2;
                task = j.this;
                super();
            }
                });
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                toAwait = j1;
                super();
            }
        };
    }

    j enqueue(i k)
    {
        lock.lock();
        if (tail == null) goto _L2; else goto _L1
_L1:
        j j1 = tail;
_L4:
        k = (j)k.then(getTaskToAwait());
        tail = j.a(Arrays.asList(new j[] {
            j1, k
        }));
        lock.unlock();
        return k;
_L2:
        j1 = j.a(null);
        if (true) goto _L4; else goto _L3
_L3:
        k;
        throw k;
        k;
        lock.unlock();
        throw k;
        k;
        throw new RuntimeException(k);
    }

    Lock getLock()
    {
        return lock;
    }

    void waitUntilFinished()
        throws InterruptedException
    {
        lock.lock();
        j j1 = tail;
        if (j1 == null)
        {
            lock.unlock();
            return;
        }
        tail.g();
        lock.unlock();
        return;
        Exception exception;
        exception;
        lock.unlock();
        throw exception;
    }
}
