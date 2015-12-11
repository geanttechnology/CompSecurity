// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TaskQueue
{

    private final Lock lock = new ReentrantLock();
    private cu tail;

    TaskQueue()
    {
    }

    private cu getTaskToAwait()
    {
        lock.lock();
        cu cu1;
        if (tail == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        cu1 = tail;
_L1:
        cu1 = cu1.a(new ct() {

            final TaskQueue this$0;

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            public Void then(cu cu2)
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
        return cu1;
        cu1 = cu.a(null);
          goto _L1
        Exception exception;
        exception;
        lock.unlock();
        throw exception;
    }

    static ct waitFor(cu cu1)
    {
        return new ct(cu1) {

            final cu val$toAwait;

            public cu then(cu cu2)
                throws Exception
            {
                return toAwait.b(cu2. new ct() {

                    final _cls2 this$0;
                    final cu val$task;

                    public cu then(cu cu1)
                        throws Exception
                    {
                        return task;
                    }

                    public volatile Object then(cu cu1)
                        throws Exception
                    {
                        return then(cu1);
                    }

            
            {
                this$0 = final__pcls2;
                task = cu.this;
                super();
            }
                });
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                toAwait = cu1;
                super();
            }
        };
    }

    cu enqueue(ct ct1)
    {
        lock.lock();
        if (tail == null) goto _L2; else goto _L1
_L1:
        cu cu1 = tail;
_L4:
        ct1 = (cu)ct1.then(getTaskToAwait());
        tail = cu.a(Arrays.asList(new cu[] {
            cu1, ct1
        }));
        lock.unlock();
        return ct1;
_L2:
        cu1 = cu.a(null);
        if (true) goto _L4; else goto _L3
_L3:
        ct1;
        throw ct1;
        ct1;
        lock.unlock();
        throw ct1;
        ct1;
        throw new RuntimeException(ct1);
    }

    Lock getLock()
    {
        return lock;
    }

    void waitUntilFinished()
        throws InterruptedException
    {
        lock.lock();
        cu cu1 = tail;
        if (cu1 == null)
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
