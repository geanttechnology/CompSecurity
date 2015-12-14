// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.example.android.bitmapfun.util;

import android.os.Message;
import android.os.Process;
import dy;
import dz;
import ea;
import eb;
import gb;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AsyncTask
{

    public static final Executor a;
    public static final Executor b;
    public static final Executor c;
    private static final ThreadFactory d;
    private static final BlockingQueue e;
    private static final dz f = new dz();
    private static volatile Executor g;
    private final eb h = new eb() {

        final AsyncTask a;

        public Object call()
        {
            AsyncTask.a(a).set(true);
            Process.setThreadPriority(10);
            return AsyncTask.a(a, a.a(b));
        }

            
            {
                a = AsyncTask.this;
                super();
            }
    };
    private final FutureTask i;
    private volatile Status j;
    private final AtomicBoolean k = new AtomicBoolean();
    private final AtomicBoolean l = new AtomicBoolean();

    public AsyncTask()
    {
        j = Status.PENDING;
        i = new FutureTask(h) {

            final AsyncTask a;

            protected void done()
            {
                try
                {
                    AsyncTask.b(a, get());
                    return;
                }
                catch (InterruptedException interruptedexception)
                {
                    return;
                }
                catch (ExecutionException executionexception)
                {
                    throw new RuntimeException("An error occured while executing doInBackground()", executionexception.getCause());
                }
                catch (CancellationException cancellationexception)
                {
                    AsyncTask.b(a, null);
                }
            }

            
            {
                a = AsyncTask.this;
                super(callable);
            }
        };
    }

    static Object a(AsyncTask asynctask, Object obj)
    {
        return asynctask.d(obj);
    }

    static AtomicBoolean a(AsyncTask asynctask)
    {
        return asynctask.l;
    }

    static void b(AsyncTask asynctask, Object obj)
    {
        asynctask.c(obj);
    }

    public static void c(AsyncTask asynctask, Object obj)
    {
        asynctask.e(obj);
    }

    private void c(Object obj)
    {
        if (!l.get())
        {
            d(obj);
        }
    }

    private Object d(Object obj)
    {
        f.obtainMessage(1, new dy(this, new Object[] {
            obj
        })).sendToTarget();
        return obj;
    }

    private void e(Object obj)
    {
        if (c())
        {
            b(obj);
        } else
        {
            a(obj);
        }
        j = Status.FINISHED;
    }

    public final transient AsyncTask a(Executor executor, Object aobj[])
    {
        if (j == Status.PENDING) goto _L2; else goto _L1
_L1:
        class _cls4
        {

            static final int a[];

            static 
            {
                a = new int[Status.values().length];
                try
                {
                    a[Status.RUNNING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[Status.FINISHED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls4.a[j.ordinal()];
        JVM INSTR tableswitch 1 2: default 44
    //                   1 75
    //                   2 85;
           goto _L2 _L3 _L4
_L2:
        j = Status.RUNNING;
        a();
        h.b = aobj;
        executor.execute(i);
        return this;
_L3:
        throw new IllegalStateException("Cannot execute task: the task is already running.");
_L4:
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    }

    public transient abstract Object a(Object aobj[]);

    public void a()
    {
    }

    public void a(Object obj)
    {
    }

    protected void b()
    {
    }

    protected void b(Object obj)
    {
        b();
    }

    public transient void b(Object aobj[])
    {
    }

    public final transient AsyncTask c(Object aobj[])
    {
        return a(g, aobj);
    }

    public final boolean c()
    {
        return k.get();
    }

    static 
    {
        d = new ThreadFactory() {

            private final AtomicInteger a = new AtomicInteger(1);

            public Thread newThread(Runnable runnable)
            {
                return new Thread(runnable, (new StringBuilder()).append("AsyncTask #").append(a.getAndIncrement()).toString());
            }

        };
        e = new LinkedBlockingQueue(10);
        a = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, e, d, new java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy());
        Object obj;
        if (gb.c())
        {
            obj = new ea();
        } else
        {
            obj = Executors.newSingleThreadExecutor(d);
        }
        b = ((Executor) (obj));
        c = Executors.newFixedThreadPool(2, d);
        g = b;
    }

    private class Status extends Enum
    {

        private static final Status $VALUES[];
        public static final Status FINISHED;
        public static final Status PENDING;
        public static final Status RUNNING;

        public static Status valueOf(String s)
        {
            return (Status)Enum.valueOf(com/example/android/bitmapfun/util/AsyncTask$Status, s);
        }

        public static Status[] values()
        {
            return (Status[])$VALUES.clone();
        }

        static 
        {
            PENDING = new Status("PENDING", 0);
            RUNNING = new Status("RUNNING", 1);
            FINISHED = new Status("FINISHED", 2);
            $VALUES = (new Status[] {
                PENDING, RUNNING, FINISHED
            });
        }

        private Status(String s, int i1)
        {
            super(s, i1);
        }
    }

}
