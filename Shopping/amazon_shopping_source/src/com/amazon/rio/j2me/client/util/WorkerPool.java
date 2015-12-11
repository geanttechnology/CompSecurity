// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.util;

import java.util.Vector;

// Referenced classes of package com.amazon.rio.j2me.client.util:
//            ObjectPool, LifecycleException, Worker, LifecycleManager

public class WorkerPool extends ObjectPool
{

    private static final WorkerPool instance = new WorkerPool("Worker Threads", 5, 1000);
    private final Vector stillRunning = new Vector();

    private WorkerPool(final String name, int i, int j)
    {
        super(name, new LifecycleManager() {

            private int cnt;
            final String val$name;

            public Worker createInstance()
            {
                StringBuilder stringbuilder = (new StringBuilder()).append(name).append("-");
                int k = cnt;
                cnt = k + 1;
                return new Worker(stringbuilder.append(k).toString());
            }

            public volatile Object createInstance()
                throws LifecycleException
            {
                return createInstance();
            }

            public void destroyInstance(Worker worker)
            {
                worker.stopWorker();
            }

            public volatile void destroyInstance(Object obj)
            {
                destroyInstance((Worker)obj);
            }

            
            {
                name = s;
                super();
            }
        }, i, j);
    }

    private void addStillRunning(Worker worker)
    {
        this;
        JVM INSTR monitorenter ;
        stillRunning.addElement(worker);
        this;
        JVM INSTR monitorexit ;
        return;
        worker;
        throw worker;
    }

    public static WorkerPool getInstance()
    {
        return instance;
    }

    public Worker acquireWorker()
        throws LifecycleException
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        cleanoutStillRunning();
        obj = (Worker)acquireObject();
        this;
        JVM INSTR monitorexit ;
        if (((Worker) (obj)).getWorkerState() != Worker.State.IDLE)
        {
            throw new LifecycleException((new StringBuilder()).append("worker was expected to be in state=").append(Worker.State.IDLE).append(": worker=").append(obj).toString());
        } else
        {
            ((Worker) (obj)).setPriority(5);
            return ((Worker) (obj));
        }
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public void cleanoutStillRunning()
    {
        this;
        JVM INSTR monitorenter ;
        int i = stillRunning.size() - 1;
_L2:
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        Worker worker;
        worker = (Worker)stillRunning.elementAt(i);
        if (worker.getWorkerState() == Worker.State.EXECUTING)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        stillRunning.removeElementAt(i);
        releaseWorker(worker);
        break MISSING_BLOCK_LABEL_65;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
        return;
        i--;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void releaseWorker(Worker worker)
    {
        Worker.State state = worker.getWorkerState();
        if (state == Worker.State.STOPPED)
        {
            destroyObject(worker);
            return;
        }
        if (state == Worker.State.EXECUTING)
        {
            addStillRunning(worker);
            return;
        } else
        {
            releaseObject(worker);
            return;
        }
    }

}
