// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.comlib.util;

import android.os.Message;
import android.os.Process;
import android.util.Log;
import fx;
import fy;
import fz;
import ga;
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

public abstract class UgentAsyncTask
{

    private static final ThreadFactory a;
    public static final Executor b;
    public static final Executor c;
    public static final Executor d;
    private static final BlockingQueue e;
    private static final fy f = new fy();
    private static volatile Executor g;
    private final ga h = new ga() {

        final UgentAsyncTask a;

        public Object call()
        {
            UgentAsyncTask.a(a).set(true);
            Process.setThreadPriority(10);
            return UgentAsyncTask.a(a, a.b(b));
        }

            
            {
                a = UgentAsyncTask.this;
                super();
            }
    };
    private final FutureTask i;
    private volatile Status j;
    private final AtomicBoolean k = new AtomicBoolean();
    private final AtomicBoolean l = new AtomicBoolean();

    public UgentAsyncTask()
    {
        j = Status.PENDING;
        i = new FutureTask(h) {

            final UgentAsyncTask a;

            protected void done()
            {
                try
                {
                    UgentAsyncTask.b(a, get());
                    return;
                }
                catch (InterruptedException interruptedexception)
                {
                    Log.w("UgentAsyncTask", interruptedexception);
                    return;
                }
                catch (ExecutionException executionexception)
                {
                    throw new RuntimeException("An error occured while executing doInBackground()", executionexception.getCause());
                }
                catch (CancellationException cancellationexception)
                {
                    UgentAsyncTask.b(a, null);
                }
            }

            
            {
                a = UgentAsyncTask.this;
                super(callable);
            }
        };
    }

    static Object a(UgentAsyncTask ugentasynctask, Object obj)
    {
        return ugentasynctask.d(obj);
    }

    static AtomicBoolean a(UgentAsyncTask ugentasynctask)
    {
        return ugentasynctask.l;
    }

    static void b(UgentAsyncTask ugentasynctask, Object obj)
    {
        ugentasynctask.c(obj);
    }

    public static void c(UgentAsyncTask ugentasynctask, Object obj)
    {
        ugentasynctask.e(obj);
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
        f.obtainMessage(1, new fx(this, new Object[] {
            obj
        })).sendToTarget();
        return obj;
    }

    private void e(Object obj)
    {
        if (c())
        {
            a(obj);
        } else
        {
            b(obj);
        }
        j = Status.FINISHED;
    }

    public final transient UgentAsyncTask a(Executor executor, Object aobj[])
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

    protected void a()
    {
    }

    public void a(Object obj)
    {
        b();
    }

    public final boolean a(boolean flag)
    {
        k.set(true);
        return i.cancel(flag);
    }

    public transient abstract Object b(Object aobj[]);

    protected void b()
    {
    }

    public void b(Object obj)
    {
    }

    public transient void c(Object aobj[])
    {
    }

    public final boolean c()
    {
        return k.get();
    }

    public final transient UgentAsyncTask d(Object aobj[])
    {
        return a(g, aobj);
    }

    static 
    {
        a = new ThreadFactory() {

            private final AtomicInteger a = new AtomicInteger(1);

            public Thread newThread(Runnable runnable)
            {
                return new Thread(runnable, (new StringBuilder()).append("UgentAsyncTask #").append(a.getAndIncrement()).toString());
            }

        };
        e = new LinkedBlockingQueue(10);
        b = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, e, a, new java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy());
        Object obj;
        if (gb.c())
        {
            obj = new fz();
        } else
        {
            obj = Executors.newSingleThreadExecutor(a);
        }
        c = ((Executor) (obj));
        d = Executors.newFixedThreadPool(2, a);
        g = c;
    }

    private class Status extends Enum
    {

        private static final Status $VALUES[];
        public static final Status FINISHED;
        public static final Status PENDING;
        public static final Status RUNNING;

        public static Status valueOf(String s)
        {
            return (Status)Enum.valueOf(com/fotoable/comlib/util/UgentAsyncTask$Status, s);
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
