// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.a;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
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

abstract class f
{
    private static final class a
    {

        final f a;
        final Object b[];

        transient a(f f1, Object aobj[])
        {
            a = f1;
            b = aobj;
        }
    }

    private static final class b extends Handler
    {

        public final void handleMessage(Message message)
        {
            a a1 = (a)message.obj;
            switch (message.what)
            {
            default:
                return;

            case 1: // '\001'
                f.c(a1.a, a1.b[0]);
                return;

            case 2: // '\002'
                f.c();
                break;
            }
        }

        private b()
        {
        }

        b(byte byte0)
        {
            this();
        }
    }

    public static final class c extends Enum
    {

        public static final c a;
        public static final c b;
        public static final c c;
        private static final c d[];

        public static c valueOf(String s)
        {
            return (c)Enum.valueOf(android/support/v4/a/f$c, s);
        }

        public static c[] values()
        {
            return (c[])d.clone();
        }

        static 
        {
            a = new c("PENDING", 0);
            b = new c("RUNNING", 1);
            c = new c("FINISHED", 2);
            d = (new c[] {
                a, b, c
            });
        }

        private c(String s, int j)
        {
            super(s, j);
        }
    }

    private static abstract class d
        implements Callable
    {

        Object b[];

        private d()
        {
        }

        d(byte byte0)
        {
            this();
        }
    }


    private static final ThreadFactory a;
    private static final BlockingQueue b;
    private static final b c = new b((byte)0);
    public static final Executor d;
    private static volatile Executor h;
    final d e = new d() {

        final f a;

        public final Object call()
        {
            f.a(a).set(true);
            Process.setThreadPriority(10);
            return f.a(a, a.b());
        }

            
            {
                a = f.this;
                super((byte)0);
            }
    };
    final FutureTask f;
    volatile c g;
    private final AtomicBoolean i = new AtomicBoolean();

    public f()
    {
        g = c.a;
        f = new FutureTask(e) {

            final f a;

            protected final void done()
            {
                try
                {
                    Object obj = get();
                    f.b(a, obj);
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
                    f.b(a, null);
                }
                catch (Throwable throwable)
                {
                    throw new RuntimeException("An error occured while executing doInBackground()", throwable);
                }
            }

            
            {
                a = f.this;
                super(callable);
            }
        };
    }

    static Object a(f f1, Object obj)
    {
        return f1.b(obj);
    }

    static AtomicBoolean a(f f1)
    {
        return f1.i;
    }

    private Object b(Object obj)
    {
        c.obtainMessage(1, new a(this, new Object[] {
            obj
        })).sendToTarget();
        return obj;
    }

    static void b(f f1, Object obj)
    {
        if (!f1.i.get())
        {
            f1.b(obj);
        }
    }

    protected static transient void c()
    {
    }

    static void c(f f1, Object obj)
    {
        if (f1.f.isCancelled())
        {
            f1.a();
        } else
        {
            f1.a(obj);
        }
        f1.g = c.c;
    }

    protected void a()
    {
    }

    protected void a(Object obj)
    {
    }

    protected transient abstract Object b();

    static 
    {
        a = new ThreadFactory() {

            private final AtomicInteger a = new AtomicInteger(1);

            public final Thread newThread(Runnable runnable)
            {
                return new Thread(runnable, (new StringBuilder("ModernAsyncTask #")).append(a.getAndIncrement()).toString());
            }

        };
        b = new LinkedBlockingQueue(10);
        d = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, b, a);
        h = d;
    }

    // Unreferenced inner class android/support/v4/a/f$4

/* anonymous class */
    static final class _cls4
    {

        static final int a[];

        static 
        {
            a = new int[c.values().length];
            try
            {
                a[c.b.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                a[c.c.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }

}
