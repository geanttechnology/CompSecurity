// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

// Referenced classes of package a:
//            e, a, o, k, 
//            n, i, g, l

public final class h
{

    public static final ExecutorService a = a.e.a();
    public static final Executor b = a.e.b();
    public static final Executor c = a.a.b();
    private final Object d = new Object();
    private boolean e;
    private boolean f;
    private Object g;
    private Exception h;
    private List i;

    private h()
    {
        i = new ArrayList();
    }

    public static h a(Exception exception)
    {
        o o1 = a();
        o1.a(exception);
        return o1.a;
    }

    public static h a(Object obj)
    {
        o o1 = a();
        o1.a(obj);
        return o1.a;
    }

    public static o a()
    {
        h h1 = new h();
        h1.getClass();
        return new o(h1, (byte)0);
    }

    static Exception a(h h1, Exception exception)
    {
        h1.h = exception;
        return exception;
    }

    static Object a(h h1)
    {
        return h1.d;
    }

    static Object a(h h1, Object obj)
    {
        h1.g = obj;
        return obj;
    }

    static void a(o o1, g g1, h h1, Executor executor)
    {
        c(o1, g1, h1, executor);
    }

    private h b(g g1, Executor executor)
    {
        o o1 = a();
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        boolean flag = g();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        i.add(new k(this, o1, g1, executor));
        obj;
        JVM INSTR monitorexit ;
        if (flag)
        {
            c(o1, g1, this, executor);
        }
        return o1.a;
        g1;
        obj;
        JVM INSTR monitorexit ;
        throw g1;
    }

    static void b(o o1, g g1, h h1, Executor executor)
    {
        d(o1, g1, h1, executor);
    }

    static boolean b(h h1)
    {
        return h1.e;
    }

    private static void c(o o1, g g1, h h1, Executor executor)
    {
        executor.execute(new n(g1, h1, o1));
    }

    static boolean c(h h1)
    {
        h1.e = true;
        return true;
    }

    private static void d(o o1, g g1, h h1, Executor executor)
    {
        executor.execute(new i(g1, h1, o1));
    }

    static boolean d(h h1)
    {
        h1.f = true;
        return true;
    }

    static void e(h h1)
    {
        Object obj = h1.d;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = h1.i.iterator();
_L1:
        g g1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_65;
        }
        g1 = (g)iterator.next();
        g1.then(h1);
          goto _L1
        h1;
        throw h1;
        h1;
        obj;
        JVM INSTR monitorexit ;
        throw h1;
        h1;
        throw new RuntimeException(h1);
        h1.i = null;
        obj;
        JVM INSTR monitorexit ;
    }

    public static h f()
    {
        o o1 = a();
        o1.a();
        return o1.a;
    }

    private boolean g()
    {
        boolean flag;
        synchronized (d)
        {
            flag = e;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final h a(g g1)
    {
        return b(g1, b);
    }

    public final h a(g g1, Executor executor)
    {
        o o1 = a();
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        boolean flag = g();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        i.add(new l(this, o1, g1, executor));
        obj;
        JVM INSTR monitorexit ;
        if (flag)
        {
            d(o1, g1, this, executor);
        }
        return o1.a;
        g1;
        obj;
        JVM INSTR monitorexit ;
        throw g1;
    }

    public final boolean b()
    {
        boolean flag;
        synchronized (d)
        {
            flag = f;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean c()
    {
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (h != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final Object d()
    {
        Object obj1;
        synchronized (d)
        {
            obj1 = g;
        }
        return obj1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final Exception e()
    {
        Exception exception;
        synchronized (d)
        {
            exception = h;
        }
        return exception;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
    }

}
