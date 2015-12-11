// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class anc
{
    private static class a
    {

        final anc a;
        final Object b[];

        transient a(anc anc1, Object aobj[])
        {
            a = anc1;
            b = aobj;
        }
    }

    private static class b extends Handler
    {

        public void handleMessage(Message message)
        {
            a a1 = (a)message.obj;
            switch (message.what)
            {
            default:
                return;

            case 1: // '\001'
                anc.c(a1.a, a1.b[0]);
                return;

            case 2: // '\002'
                a1.a.b(a1.b);
                break;
            }
        }

        public b()
        {
            super(Looper.getMainLooper());
        }
    }

    private static class c
        implements Executor
    {

        final LinkedList a;
        Runnable b;

        protected void a()
        {
            this;
            JVM INSTR monitorenter ;
            Runnable runnable;
            runnable = (Runnable)a.poll();
            b = runnable;
            if (runnable == null)
            {
                break MISSING_BLOCK_LABEL_34;
            }
            anc.b.execute(b);
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public void execute(Runnable runnable)
        {
            this;
            JVM INSTR monitorenter ;
            a.offer(new Runnable(this, runnable) {

                final Runnable a;
                final c b;

                public void run()
                {
                    a.run();
                    b.a();
                    return;
                    Exception exception;
                    exception;
                    b.a();
                    throw exception;
                }

            
            {
                b = c1;
                a = runnable;
                super();
            }
            });
            if (b == null)
            {
                a();
            }
            this;
            JVM INSTR monitorexit ;
            return;
            runnable;
            throw runnable;
        }

        private c()
        {
            a = new LinkedList();
        }

    }

    public static final class d extends Enum
    {

        public static final d a;
        public static final d b;
        public static final d c;
        private static final d d[];

        public static d valueOf(String s)
        {
            return (d)Enum.valueOf(android/support/v7/anc$d, s);
        }

        public static d[] values()
        {
            return (d[])d.clone();
        }

        static 
        {
            a = new d("PENDING", 0);
            b = new d("RUNNING", 1);
            c = new d("FINISHED", 2);
            d = (new d[] {
                a, b, c
            });
        }

        private d(String s, int i1)
        {
            super(s, i1);
        }
    }

    private static abstract class e
        implements Callable
    {

        Object b[];

        private e()
        {
        }

    }


    private static final int a;
    public static final Executor b;
    public static final Executor c;
    private static final int d;
    private static final int e;
    private static final ThreadFactory f;
    private static final BlockingQueue g;
    private static final b h = new b();
    private static volatile Executor i;
    private final e j = new e() {

        final anc a;

        public Object call()
            throws Exception
        {
            anc.a(a).set(true);
            Process.setThreadPriority(10);
            return anc.a(a, a.a(b));
        }

            
            {
                a = anc.this;
                super();
            }
    };
    private final FutureTask k;
    private volatile d l;
    private final AtomicBoolean m = new AtomicBoolean();
    private final AtomicBoolean n = new AtomicBoolean();

    public anc()
    {
        l = d.a;
        k = new FutureTask(j) {

            final anc a;

            protected void done()
            {
                try
                {
                    anc.b(a, get());
                    return;
                }
                catch (InterruptedException interruptedexception)
                {
                    Log.w("AsyncTask", interruptedexception);
                    return;
                }
                catch (ExecutionException executionexception)
                {
                    throw new RuntimeException("An error occured while executing doInBackground()", executionexception.getCause());
                }
                catch (CancellationException cancellationexception)
                {
                    anc.b(a, null);
                }
            }

            
            {
                a = anc.this;
                super(callable);
            }
        };
    }

    static Object a(anc anc1, Object obj)
    {
        return anc1.d(obj);
    }

    static AtomicBoolean a(anc anc1)
    {
        return anc1.n;
    }

    static void b(anc anc1, Object obj)
    {
        anc1.c(obj);
    }

    static void c(anc anc1, Object obj)
    {
        anc1.e(obj);
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
        h.obtainMessage(1, new a(this, new Object[] {
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
        l = d.c;
    }

    public final transient anc a(Executor executor, Object aobj[])
    {
        if (l == d.a) goto _L2; else goto _L1
_L1:
        static class _cls4
        {

            static final int a[];

            static 
            {
                a = new int[d.values().length];
                try
                {
                    a[d.b.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[d.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls4.a[l.ordinal()];
        JVM INSTR tableswitch 1 2: default 44
    //                   1 75
    //                   2 85;
           goto _L2 _L3 _L4
_L2:
        l = d.b;
        a();
        j.b = aobj;
        executor.execute(k);
        return this;
_L3:
        throw new IllegalStateException("Cannot execute task: the task is already running.");
_L4:
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    }

    protected transient abstract Object a(Object aobj[]);

    protected void a()
    {
    }

    protected void a(Object obj)
    {
    }

    public final boolean a(boolean flag)
    {
        m.set(true);
        return k.cancel(flag);
    }

    public final d b()
    {
        return l;
    }

    protected void b(Object obj)
    {
        c();
    }

    protected transient void b(Object aobj[])
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
        f = new ThreadFactory() {

            private final AtomicInteger a = new AtomicInteger(1);

            public Thread newThread(Runnable runnable)
            {
                return new Thread(runnable, (new StringBuilder()).append("AsyncTask #").append(a.getAndIncrement()).toString());
            }

        };
        g = new LinkedBlockingQueue(128);
        b = new ThreadPoolExecutor(d, e, 1L, TimeUnit.SECONDS, g, f);
        c = new c();
        i = c;
    }
}
