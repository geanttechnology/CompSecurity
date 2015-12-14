// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.fabric.sdk.android.services.concurrency;

import android.os.Message;
import bun;
import buo;
import bup;
import buq;
import bur;
import bus;
import but;
import buv;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AsyncTask
{

    private static final int a;
    public static final Executor b;
    public static final Executor c;
    private static final int d;
    private static final int e;
    private static final ThreadFactory f;
    private static final BlockingQueue g;
    private static final bus h = new bus();
    private static volatile Executor i;
    private final buv j = new buo(this);
    private final FutureTask k;
    private volatile Status l;
    private final AtomicBoolean m = new AtomicBoolean();
    private final AtomicBoolean n = new AtomicBoolean();

    public AsyncTask()
    {
        l = Status.PENDING;
        k = new bup(this, j);
    }

    public static Object a(AsyncTask asynctask, Object obj)
    {
        return asynctask.d(obj);
    }

    public static AtomicBoolean a(AsyncTask asynctask)
    {
        return asynctask.n;
    }

    public static void b(AsyncTask asynctask, Object obj)
    {
        asynctask.c(obj);
    }

    public static void c(AsyncTask asynctask, Object obj)
    {
        asynctask.e(obj);
    }

    private void c(Object obj)
    {
        if (!n.get())
        {
            d(obj);
        }
    }

    private Object d(Object obj)
    {
        h.obtainMessage(1, new bur(this, new Object[] {
            obj
        })).sendToTarget();
        return obj;
    }

    private void e(Object obj)
    {
        if (d())
        {
            b(obj);
        } else
        {
            a(obj);
        }
        l = Status.FINISHED;
    }

    public final transient AsyncTask a(Executor executor, Object aobj[])
    {
        if (l == Status.PENDING) goto _L2; else goto _L1
_L1:
        buq.a[l.ordinal()];
        JVM INSTR tableswitch 1 2: default 44
    //                   1 75
    //                   2 85;
           goto _L2 _L3 _L4
_L2:
        l = Status.RUNNING;
        a();
        j.b = aobj;
        executor.execute(k);
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

    public final boolean a(boolean flag)
    {
        m.set(true);
        return k.cancel(flag);
    }

    public final Status b()
    {
        return l;
    }

    public void b(Object obj)
    {
        c();
    }

    public transient void b(Object aobj[])
    {
    }

    protected void c()
    {
    }

    public final boolean d()
    {
        return m.get();
    }

    static 
    {
        a = Runtime.getRuntime().availableProcessors();
        d = a + 1;
        e = a * 2 + 1;
        f = new bun();
        g = new LinkedBlockingQueue(128);
        b = new ThreadPoolExecutor(d, e, 1L, TimeUnit.SECONDS, g, f);
        c = new but(null);
        i = c;
    }

    private class Status extends Enum
    {

        private static final Status $VALUES[];
        public static final Status FINISHED;
        public static final Status PENDING;
        public static final Status RUNNING;

        public static Status valueOf(String s)
        {
            return (Status)Enum.valueOf(io/fabric/sdk/android/services/concurrency/AsyncTask$Status, s);
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
