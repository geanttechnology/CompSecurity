// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.util;

import com.amazon.mShop.platform.Platform;

// Referenced classes of package com.amazon.rio.j2me.client.util:
//            Logger

public class Worker extends Thread
{
    public static class State
    {

        public static final State EXECUTING = new State("EXECUTING");
        public static final State IDLE = new State("IDLE");
        public static final State STOPPED = new State("STOPPED");
        private final String name;

        public String toString()
        {
            return name;
        }


        private State(String s)
        {
            name = s;
        }
    }


    private static final Logger logger = com.amazon.mShop.platform.Platform.Factory.getInstance().getLogger(com/amazon/rio/j2me/client/util/Worker);
    private final Object lock;
    private State state;
    private Runnable task;
    private String taskName;
    private boolean threadStarted;

    public Worker(String s)
    {
        this(s, null, null);
    }

    public Worker(String s, String s1, Runnable runnable)
    {
        super(s);
        lock = new Object();
        state = State.IDLE;
        taskName = s1;
        task = runnable;
    }

    private void setState(State state1)
    {
        synchronized (lock)
        {
            state = state1;
            lock.notifyAll();
        }
        return;
        state1;
        obj;
        JVM INSTR monitorexit ;
        throw state1;
    }

    public void execute(String s, Runnable runnable)
    {
        if (!executeIfIdle(s, runnable))
        {
            throw new IllegalStateException((new StringBuilder()).append("Worker can't execute task, bad state: worker=").append(this).toString());
        } else
        {
            return;
        }
    }

    public boolean executeIfIdle()
    {
label0:
        {
            synchronized (lock)
            {
                if (state == State.IDLE)
                {
                    break label0;
                }
            }
            return false;
        }
        if (!threadStarted)
        {
            start();
            threadStarted = true;
        }
        setState(State.EXECUTING);
        obj;
        JVM INSTR monitorexit ;
        return true;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean executeIfIdle(String s, Runnable runnable)
    {
label0:
        {
            synchronized (lock)
            {
                if (state == State.IDLE)
                {
                    break label0;
                }
            }
            return false;
        }
        taskName = s;
        task = runnable;
        executeIfIdle();
        obj;
        JVM INSTR monitorexit ;
        return true;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public String getTaskName()
    {
        String s;
        synchronized (lock)
        {
            s = taskName;
        }
        return s;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public State getWorkerState()
    {
        State state1;
        synchronized (lock)
        {
            state1 = state;
        }
        return state1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void run()
    {
        boolean flag = false;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        JVM INSTR monitorenter ;
_L2:
        boolean flag1;
label0:
        {
_L4:
            synchronized (lock)
            {
                if (state != State.STOPPED)
                {
                    break label0;
                }
            }
            return;
        }
        flag1 = flag;
        if (state != State.EXECUTING)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = false;
        setState(State.IDLE);
        lock.wait();
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        InterruptedException interruptedexception;
        interruptedexception;
        flag = flag1;
        if (state == State.EXECUTING)
        {
            flag = true;
        }
        if (true) goto _L4; else goto _L3
_L3:
        obj;
        JVM INSTR monitorexit ;
        if (task != null)
        {
            task.run();
        }
        task = null;
        flag = true;
        if (true) goto _L2; else goto _L5
_L5:
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        Object obj1;
        obj1;
        logger.error((new StringBuilder()).append("uncaught RuntimeExceptiong: exception=").append(obj1).append(" thread=").append(this).toString());
        setState(State.STOPPED);
        throw obj1;
        obj1;
        task = null;
        throw obj1;
    }

    public State stopWorker()
    {
        State state1;
        synchronized (lock)
        {
            state1 = state;
            setState(State.STOPPED);
        }
        return state1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append('[');
        stringbuffer.append("name=").append(getName());
        stringbuffer.append(" taskName=").append(getTaskName());
        stringbuffer.append(" state=").append(getWorkerState());
        stringbuffer.append(']');
        return stringbuffer.toString();
    }

}
