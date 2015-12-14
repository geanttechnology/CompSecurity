// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.comlib.util;

import aaa;
import aab;
import aac;
import aad;
import aae;
import aaf;
import aag;
import aai;
import aaj;
import android.os.Message;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class UgentAsyncTask
{

    private static final ThreadFactory a;
    public static final Executor b;
    public static final Executor c;
    public static final Executor d;
    private static final BlockingQueue e;
    private static final aaf f = new aaf(null);
    private static volatile Executor g;
    private final aai h = new aab(this);
    private final FutureTask i;
    private volatile Status j;
    private final AtomicBoolean k = new AtomicBoolean();
    private final AtomicBoolean l = new AtomicBoolean();

    public UgentAsyncTask()
    {
        j = Status.PENDING;
        i = new aac(this, h);
    }

    public static Object a(UgentAsyncTask ugentasynctask, Object obj)
    {
        return ugentasynctask.d(obj);
    }

    public static AtomicBoolean a(UgentAsyncTask ugentasynctask)
    {
        return ugentasynctask.l;
    }

    public static void b(UgentAsyncTask ugentasynctask, Object obj)
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
        f.obtainMessage(1, new aae(this, new Object[] {
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
        aad.a[j.ordinal()];
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

    public void a()
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
        a = new aaa();
        e = new LinkedBlockingQueue(10);
        b = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, e, a, new java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy());
        Object obj;
        if (aaj.c())
        {
            obj = new aag(null);
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
