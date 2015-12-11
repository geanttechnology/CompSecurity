// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.c;

import android.os.Message;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package c.a.a.a.a.c:
//            b, h, g, j, 
//            c, d, f, e, 
//            k

public abstract class a
{

    public static final Executor a;
    private static final int b;
    private static final int c;
    private static final int d;
    private static final ThreadFactory e;
    private static final BlockingQueue f;
    private static Executor g;
    private static final g h = new g();
    private static volatile Executor i;
    private final k j = new c(this);
    private final FutureTask k;
    private volatile int l;
    private final AtomicBoolean m = new AtomicBoolean();
    private final AtomicBoolean n = new AtomicBoolean();

    public a()
    {
        l = j.a;
        k = new d(this, j);
    }

    static Object a(a a1, Object obj)
    {
        return a1.c(obj);
    }

    static AtomicBoolean a(a a1)
    {
        return a1.n;
    }

    static void b(a a1, Object obj)
    {
        if (!a1.n.get())
        {
            a1.c(obj);
        }
    }

    private Object c(Object obj)
    {
        h.obtainMessage(1, new f(this, new Object[] {
            obj
        })).sendToTarget();
        return obj;
    }

    protected static transient void c()
    {
    }

    static void c(a a1, Object obj)
    {
        if (a1.m.get())
        {
            a1.b(obj);
        } else
        {
            a1.a(obj);
        }
        a1.l = j.c;
    }

    public final transient a a(Executor executor, Object aobj[])
    {
        if (l == j.a) goto _L2; else goto _L1
_L1:
        e.a[l - 1];
        JVM INSTR tableswitch 1 2: default 44
    //                   1 75
    //                   2 85;
           goto _L2 _L3 _L4
_L2:
        l = j.b;
        a();
        j.a = aobj;
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
        return k.cancel(true);
    }

    public final int b()
    {
        return l;
    }

    protected void b(Object obj)
    {
    }

    public final boolean d()
    {
        return m.get();
    }

    static 
    {
        int i1 = Runtime.getRuntime().availableProcessors();
        b = i1;
        c = i1 + 1;
        d = (b << 1) + 1;
        e = new b();
        f = new LinkedBlockingQueue(128);
        a = new ThreadPoolExecutor(c, d, 1L, TimeUnit.SECONDS, f, e);
        g = new h((byte)0);
        i = g;
    }
}
