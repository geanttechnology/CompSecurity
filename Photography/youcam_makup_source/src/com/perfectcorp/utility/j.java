// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.perfectcorp.utility;

import android.os.AsyncTask;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.perfectcorp.utility:
//            o, m, k, e

public abstract class j
{

    private static final int a;
    private static final int b;
    private static final int c;
    private static final ThreadFactory d;
    private static final BlockingQueue e;
    public static boolean o = false;
    protected static Executor p = Executors.newFixedThreadPool(20);
    public static Executor q;
    private Integer f;
    private Boolean g;
    private Object h;
    protected Executor r;
    protected AsyncTask s;
    protected j t;
    protected o u;

    public j()
    {
        r = p;
        s = null;
        t = null;
        f = null;
        g = Boolean.valueOf(false);
        h = null;
        u = null;
        s = new AsyncTask() {

            final j a;

            protected transient Object doInBackground(Object aobj[])
            {
                a.u = new o(this) {

                    final _cls3 a;

            
            {
                a = _pcls3;
                super();
            }
                };
                aobj = ((Object []) (a.a(aobj[0])));
                return ((Object) (aobj));
                aobj;
                com.perfectcorp.utility.e.e(new Object[] {
                    aobj
                });
                ((Exception) (aobj)).printStackTrace();
                a.b(0x80000001);
_L2:
                return null;
                aobj;
                com.perfectcorp.utility.e.e(new Object[] {
                    aobj
                });
                ((OutOfMemoryError) (aobj)).printStackTrace();
                a.b(0x80000006);
                System.gc();
                if (true) goto _L2; else goto _L1
_L1:
            }

            protected void onCancelled()
            {
                if (a.t == null)
                {
                    a.a();
                    return;
                }
                if (j.b(a) != null)
                {
                    a.t.a(j.b(a).intValue());
                } else
                {
                    a.t.a();
                }
                a.b();
            }

            protected void onPostExecute(Object obj)
            {
                a.a_(obj);
            }

            protected transient void onProgressUpdate(Object aobj[])
            {
                a.c(aobj[0]);
            }

            
            {
                a = j.this;
                super();
            }
        };
    }

    static Integer b(j j1)
    {
        return j1.f;
    }

    public final j a(j j1)
    {
        this;
        JVM INSTR monitorenter ;
        t = j1;
        if (g.booleanValue())
        {
            t.a(r, h);
        }
        this;
        JVM INSTR monitorexit ;
        return j1;
        j1;
        throw j1;
    }

    public final j a(Executor executor, Object obj)
    {
        r = executor;
        if (!s.isCancelled())
        {
            s.executeOnExecutor(executor, new Object[] {
                obj
            });
        }
        return this;
    }

    protected abstract Object a(Object obj);

    protected void a()
    {
        if (t != null)
        {
            t.a();
        }
        b();
    }

    protected void a(int i)
    {
        f = Integer.valueOf(i);
        a(true);
    }

    public final void a(m m)
    {
        this;
        JVM INSTR monitorenter ;
        t = m;
        if (g.booleanValue())
        {
            t.a(r, h);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        m;
        throw m;
    }

    public final boolean a(boolean flag)
    {
        return s.cancel(flag);
    }

    protected void a_(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        h = obj;
        if (t != null)
        {
            t.a(r, obj);
        }
        g = Boolean.valueOf(true);
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }

    protected void b()
    {
        t = null;
    }

    public final void b(int i)
    {
        a(i);
    }

    protected void c(Object obj)
    {
    }

    public final boolean c()
    {
        return s.isCancelled();
    }

    public final j d(Object obj)
    {
        return a(r, obj);
    }

    public final Object d()
    {
        return s.get();
    }

    static 
    {
        a = Runtime.getRuntime().availableProcessors();
        b = a + 1;
        c = a * 2 + 1;
        d = new ThreadFactory() {

            private final AtomicInteger a = new AtomicInteger(1);

            public Thread newThread(Runnable runnable)
            {
                return new Thread(runnable, (new StringBuilder()).append("AsyncTask #").append(a.getAndIncrement()).toString());
            }

        };
        e = new LinkedBlockingQueue(128);
        q = new ThreadPoolExecutor(b, c, 1L, TimeUnit.SECONDS, e, d) {

            private ConcurrentHashMap a;
            private ConcurrentHashMap b;

            private String a(Thread thread)
            {
                StringBuilder stringbuilder = new StringBuilder();
                thread = thread.getStackTrace();
                int l = thread.length;
                for (int i = 0; i < l; i++)
                {
                    stringbuilder.append(thread[i]).append('\n');
                }

                return stringbuilder.toString();
            }

            protected void afterExecute(Runnable runnable, Throwable throwable)
            {
                super.afterExecute(runnable, throwable);
                b.remove(Integer.valueOf(runnable.hashCode()));
                if (j.o)
                {
                    k k1;
                    for (runnable = b.entrySet().iterator(); runnable.hasNext(); com.perfectcorp.utility.e.b(new Object[] {
            "Running Task ", throwable.getKey(), " from: ", k1.a, ", stack:\n", a(k1.b)
        }))
                    {
                        throwable = (java.util.Map.Entry)runnable.next();
                        k1 = (k)throwable.getValue();
                    }

                }
            }

            protected void beforeExecute(Thread thread, Runnable runnable)
            {
                b.put(Integer.valueOf(runnable.hashCode()), new k(this, (StackTraceElement)a.remove(Integer.valueOf(runnable.hashCode())), thread));
                super.beforeExecute(thread, runnable);
            }

            public void execute(Runnable runnable)
            {
                StackTraceElement astacktraceelement[] = Thread.currentThread().getStackTrace();
                a.put(Integer.valueOf(runnable.hashCode()), astacktraceelement[4]);
                if (j.o)
                {
                    com.perfectcorp.utility.e.b(new Object[] {
                        "Queue Task ", Integer.valueOf(runnable.hashCode()), " from: ", astacktraceelement[4]
                    });
                }
                if (!b.isEmpty() && j.o)
                {
                    java.util.Map.Entry entry;
                    k k1;
                    for (Iterator iterator = b.entrySet().iterator(); iterator.hasNext(); com.perfectcorp.utility.e.b(new Object[] {
            "Running Task ", entry.getKey(), " from: ", k1.a, ", stack:\n", a(k1.b)
        }))
                    {
                        entry = (java.util.Map.Entry)iterator.next();
                        k1 = (k)entry.getValue();
                    }

                }
                super.execute(runnable);
            }

            
            {
                a = new ConcurrentHashMap();
                b = new ConcurrentHashMap();
            }
        };
    }
}
