// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

// Referenced classes of package a:
//            e, a, o, p, 
//            j, h, l, m, 
//            k, g

public final class i
{

    private static final Executor a = a.e.b();
    private final Object b = new Object();
    private boolean c;
    private boolean d;
    private Object e;
    private Exception f;
    private List g;

    private i()
    {
        g = new ArrayList();
    }

    private i a(h h1, Executor executor, g g1)
    {
        p p1 = a();
        g1 = ((g) (b));
        g1;
        JVM INSTR monitorenter ;
        boolean flag = g();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        g.add(new o(this, p1, h1, executor, null));
        g1;
        JVM INSTR monitorexit ;
        if (flag)
        {
            c(p1, h1, this, executor, null);
        }
        return p1.a;
        h1;
        g1;
        JVM INSTR monitorexit ;
        throw h1;
    }

    public static i a(Exception exception)
    {
        p p1 = a();
        p1.a(exception);
        return p1.a;
    }

    public static i a(Object obj)
    {
        p p1 = a();
        p1.a(obj);
        return p1.a;
    }

    public static p a()
    {
        i i1 = new i();
        i1.getClass();
        return new p(i1, (byte)0);
    }

    static Exception a(i i1, Exception exception)
    {
        i1.f = exception;
        return exception;
    }

    static Object a(i i1)
    {
        return i1.b;
    }

    static Object a(i i1, Object obj)
    {
        i1.e = obj;
        return obj;
    }

    static void a(p p1, h h1, i i1, Executor executor, g g1)
    {
        c(p1, h1, i1, executor, g1);
    }

    static boolean a(i i1, boolean flag)
    {
        i1.c = true;
        return true;
    }

    private i b(h h1, Executor executor, g g1)
    {
        p p1 = a();
        g1 = ((g) (b));
        g1;
        JVM INSTR monitorenter ;
        boolean flag = g();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        g.add(new j(this, p1, h1, executor, null));
        g1;
        JVM INSTR monitorexit ;
        if (flag)
        {
            d(p1, h1, this, executor, null);
        }
        return p1.a;
        h1;
        g1;
        JVM INSTR monitorexit ;
        throw h1;
    }

    static void b(p p1, h h1, i i1, Executor executor, g g1)
    {
        d(p1, h1, i1, executor, g1);
    }

    static boolean b(i i1)
    {
        return i1.c;
    }

    static boolean b(i i1, boolean flag)
    {
        i1.d = true;
        return true;
    }

    static void c(i i1)
    {
        Object obj = i1.b;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = i1.g.iterator();
_L1:
        h h1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_65;
        }
        h1 = (h)iterator.next();
        h1.then(i1);
          goto _L1
        i1;
        throw i1;
        i1;
        obj;
        JVM INSTR monitorexit ;
        throw i1;
        i1;
        throw new RuntimeException(i1);
        i1.g = null;
        obj;
        JVM INSTR monitorexit ;
    }

    private static void c(p p1, h h1, i i1, Executor executor, g g1)
    {
        executor.execute(new l(g1, p1, h1, i1));
    }

    private static void d(p p1, h h1, i i1, Executor executor, g g1)
    {
        executor.execute(new m(g1, p1, h1, i1));
    }

    public static i f()
    {
        p p1 = a();
        p1.b();
        return p1.a;
    }

    private boolean g()
    {
        boolean flag;
        synchronized (b)
        {
            flag = c;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final i a(h h1)
    {
        return a(h1, a, null);
    }

    public final i b(h h1)
    {
        Executor executor = a;
        return b(((h) (new k(this, null, h1))), executor, null);
    }

    public final boolean b()
    {
        boolean flag;
        synchronized (b)
        {
            flag = d;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean c()
    {
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (f != null)
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
        synchronized (b)
        {
            obj1 = e;
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
        synchronized (b)
        {
            exception = f;
        }
        return exception;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    static 
    {
        a.e.a();
        a.a.b();
    }
}
