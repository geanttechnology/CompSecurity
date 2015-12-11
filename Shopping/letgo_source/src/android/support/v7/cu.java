// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package android.support.v7:
//            co, cm, ct, cs, 
//            cp, cl

public class cu
{
    public class a
    {

        final cu a;

        public cu a()
        {
            return a;
        }

        public boolean a(Exception exception)
        {
label0:
            {
                synchronized (cu.a(a))
                {
                    if (!cu.b(a))
                    {
                        break label0;
                    }
                }
                return false;
            }
            cu.a(a, true);
            cu.a(a, exception);
            cu.a(a).notifyAll();
            cu.c(a);
            obj;
            JVM INSTR monitorexit ;
            return true;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public boolean a(Object obj)
        {
label0:
            {
                synchronized (cu.a(a))
                {
                    if (!cu.b(a))
                    {
                        break label0;
                    }
                }
                return false;
            }
            cu.a(a, true);
            cu.a(a, obj);
            cu.a(a).notifyAll();
            cu.c(a);
            obj1;
            JVM INSTR monitorexit ;
            return true;
            obj;
            obj1;
            JVM INSTR monitorexit ;
            throw obj;
        }

        public void b(Exception exception)
        {
            if (!a(exception))
            {
                throw new IllegalStateException("Cannot set the error on a completed task.");
            } else
            {
                return;
            }
        }

        public void b(Object obj)
        {
            if (!a(obj))
            {
                throw new IllegalStateException("Cannot set the result of a completed task.");
            } else
            {
                return;
            }
        }

        public boolean b()
        {
label0:
            {
                synchronized (cu.a(a))
                {
                    if (!cu.b(a))
                    {
                        break label0;
                    }
                }
                return false;
            }
            cu.a(a, true);
            cu.b(a, true);
            cu.a(a).notifyAll();
            cu.c(a);
            obj;
            JVM INSTR monitorexit ;
            return true;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void c()
        {
            if (!b())
            {
                throw new IllegalStateException("Cannot cancel a completed task.");
            } else
            {
                return;
            }
        }

        private a()
        {
            a = cu.this;
            super();
        }

    }


    public static final ExecutorService a = co.a();
    public static final Executor b = cm.b();
    private static final Executor c = co.b();
    private final Object d = new Object();
    private boolean e;
    private boolean f;
    private Object g;
    private Exception h;
    private List i;

    private cu()
    {
        i = new ArrayList();
    }

    public static a a()
    {
        cu cu1 = new cu();
        cu1.getClass();
        return cu1. new a();
    }

    public static cu a(Exception exception)
    {
        a a1 = a();
        a1.b(exception);
        return a1.a();
    }

    public static cu a(Object obj)
    {
        a a1 = a();
        a1.b(obj);
        return a1.a();
    }

    public static cu a(Collection collection)
    {
        if (collection.size() == 0)
        {
            return a(null);
        }
        a a1 = a();
        ArrayList arraylist = new ArrayList();
        Object obj = new Object();
        AtomicInteger atomicinteger = new AtomicInteger(collection.size());
        AtomicBoolean atomicboolean = new AtomicBoolean(false);
        for (collection = collection.iterator(); collection.hasNext(); ((cu)collection.next()).a(new ct(obj, arraylist, atomicboolean, atomicinteger, a1) {

        final Object a;
        final ArrayList b;
        final AtomicBoolean c;
        final AtomicInteger d;
        final a e;

        public Void a(cu cu1)
        {
            if (cu1.d())
            {
                synchronized (a)
                {
                    b.add(cu1.f());
                }
            }
            if (cu1.c())
            {
                c.set(true);
            }
            if (d.decrementAndGet() == 0)
            {
                if (b.size() == 0)
                {
                    break MISSING_BLOCK_LABEL_143;
                }
                if (b.size() != 1)
                {
                    break MISSING_BLOCK_LABEL_99;
                }
                e.b((Exception)b.get(0));
            }
            return null;
            cu1;
            obj1;
            JVM INSTR monitorexit ;
            throw cu1;
            cu1 = new cl(String.format("There were %d exceptions.", new Object[] {
                Integer.valueOf(b.size())
            }), b);
            e.b(cu1);
            return null;
            if (c.get())
            {
                e.c();
                return null;
            } else
            {
                e.b(null);
                return null;
            }
        }

        public Object then(cu cu1)
            throws Exception
        {
            return a(cu1);
        }

            
            {
                a = obj;
                b = arraylist;
                c = atomicboolean;
                d = atomicinteger;
                e = a1;
                super();
            }
    })) { }
        return a1.a();
    }

    public static cu a(Callable callable)
    {
        return a(callable, c, null);
    }

    public static cu a(Callable callable, Executor executor)
    {
        return a(callable, executor, null);
    }

    public static cu a(Callable callable, Executor executor, cp cp)
    {
        a a1 = a();
        executor.execute(new Runnable(cp, a1, callable) {

            final cp a;
            final a b;
            final Callable c;

            public void run()
            {
                if (a != null && a.a())
                {
                    b.c();
                    return;
                }
                try
                {
                    b.b(c.call());
                    return;
                }
                catch (CancellationException cancellationexception)
                {
                    b.c();
                    return;
                }
                catch (Exception exception)
                {
                    b.b(exception);
                }
            }

            
            {
                a = cp1;
                b = a1;
                c = callable;
                super();
            }
        });
        return a1.a();
    }

    static Exception a(cu cu1, Exception exception)
    {
        cu1.h = exception;
        return exception;
    }

    static Object a(cu cu1)
    {
        return cu1.d;
    }

    static Object a(cu cu1, Object obj)
    {
        cu1.g = obj;
        return obj;
    }

    static void a(a a1, ct ct1, cu cu1, Executor executor, cp cp)
    {
        c(a1, ct1, cu1, executor, cp);
    }

    static boolean a(cu cu1, boolean flag)
    {
        cu1.e = flag;
        return flag;
    }

    static void b(a a1, ct ct1, cu cu1, Executor executor, cp cp)
    {
        d(a1, ct1, cu1, executor, cp);
    }

    static boolean b(cu cu1)
    {
        return cu1.e;
    }

    static boolean b(cu cu1, boolean flag)
    {
        cu1.f = flag;
        return flag;
    }

    private static void c(a a1, ct ct1, cu cu1, Executor executor, cp cp)
    {
        executor.execute(new Runnable(cp, a1, ct1, cu1) {

            final cp a;
            final a b;
            final ct c;
            final cu d;

            public void run()
            {
                if (a != null && a.a())
                {
                    b.c();
                    return;
                }
                try
                {
                    Object obj = c.then(d);
                    b.b(obj);
                    return;
                }
                catch (CancellationException cancellationexception)
                {
                    b.c();
                    return;
                }
                catch (Exception exception)
                {
                    b.b(exception);
                }
            }

            
            {
                a = cp1;
                b = a1;
                c = ct1;
                d = cu1;
                super();
            }
        });
    }

    static void c(cu cu1)
    {
        cu1.k();
    }

    private static void d(a a1, ct ct1, cu cu1, Executor executor, cp cp)
    {
        executor.execute(new Runnable(cp, a1, ct1, cu1) {

            final cp a;
            final a b;
            final ct c;
            final cu d;

            public void run()
            {
                if (a != null && a.a())
                {
                    b.c();
                    return;
                }
                Object obj = (cu)c.then(d);
                if (obj == null)
                {
                    try
                    {
                        b.b(null);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        b.c();
                        return;
                    }
                    catch (Exception exception)
                    {
                        b.b(exception);
                    }
                    break MISSING_BLOCK_LABEL_87;
                }
                ((cu) (obj)).a(new ct(this) {

                    final _cls7 a;

                    public Void a(cu cu1)
                    {
                        if (a.a != null && a.a.a())
                        {
                            a.b.c();
                            return null;
                        }
                        if (cu1.c())
                        {
                            a.b.c();
                            return null;
                        }
                        if (cu1.d())
                        {
                            a.b.b(cu1.f());
                            return null;
                        } else
                        {
                            a.b.b(cu1.e());
                            return null;
                        }
                    }

                    public Object then(cu cu1)
                        throws Exception
                    {
                        return a(cu1);
                    }

            
            {
                a = _pcls7;
                super();
            }
                });
                return;
            }

            
            {
                a = cp1;
                b = a1;
                c = ct1;
                d = cu1;
                super();
            }
        });
    }

    public static cu h()
    {
        a a1 = a();
        a1.c();
        return a1.a();
    }

    private void k()
    {
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = i.iterator();
_L1:
        ct ct1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_65;
        }
        ct1 = (ct)iterator.next();
        ct1.then(this);
          goto _L1
        Object obj1;
        obj1;
        throw obj1;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj1;
        throw new RuntimeException(((Throwable) (obj1)));
        i = null;
        obj;
        JVM INSTR monitorexit ;
    }

    public cu a(ct ct1)
    {
        return a(ct1, c, null);
    }

    public cu a(ct ct1, Executor executor)
    {
        return a(ct1, executor, null);
    }

    public cu a(ct ct1, Executor executor, cp cp)
    {
        a a1 = a();
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        boolean flag = b();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        i.add(new ct(a1, ct1, executor, cp) {

            final a a;
            final ct b;
            final Executor c;
            final cp d;
            final cu e;

            public Void a(cu cu1)
            {
                cu.a(a, b, cu1, c, d);
                return null;
            }

            public Object then(cu cu1)
                throws Exception
            {
                return a(cu1);
            }

            
            {
                e = cu.this;
                a = a1;
                b = ct1;
                c = executor;
                d = cp;
                super();
            }
        });
        obj;
        JVM INSTR monitorexit ;
        if (flag)
        {
            c(a1, ct1, this, executor, cp);
        }
        return a1.a();
        ct1;
        obj;
        JVM INSTR monitorexit ;
        throw ct1;
    }

    public cu a(Callable callable, ct ct1)
    {
        return a(callable, ct1, c, null);
    }

    public cu a(Callable callable, ct ct1, Executor executor, cp cp)
    {
        cs cs1 = new cs();
        cs1.a(new ct(cp, callable, ct1, executor, cs1) {

            final cp a;
            final Callable b;
            final ct c;
            final Executor d;
            final cs e;
            final cu f;

            public cu a(cu cu1)
                throws Exception
            {
                if (a != null && a.a())
                {
                    return cu.h();
                }
                if (((Boolean)b.call()).booleanValue())
                {
                    return cu.a(null).d(c, d).d((ct)e.a(), d);
                } else
                {
                    return cu.a(null);
                }
            }

            public Object then(cu cu1)
                throws Exception
            {
                return a(cu1);
            }

            
            {
                f = cu.this;
                a = cp1;
                b = callable;
                c = ct1;
                d = executor;
                e = cs1;
                super();
            }
        });
        return j().b((ct)cs1.a(), executor);
    }

    public cu b(ct ct1)
    {
        return b(ct1, c, null);
    }

    public cu b(ct ct1, Executor executor)
    {
        return b(ct1, executor, null);
    }

    public cu b(ct ct1, Executor executor, cp cp)
    {
        a a1 = a();
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        boolean flag = b();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        i.add(new ct(a1, ct1, executor, cp) {

            final a a;
            final ct b;
            final Executor c;
            final cp d;
            final cu e;

            public Void a(cu cu1)
            {
                cu.b(a, b, cu1, c, d);
                return null;
            }

            public Object then(cu cu1)
                throws Exception
            {
                return a(cu1);
            }

            
            {
                e = cu.this;
                a = a1;
                b = ct1;
                c = executor;
                d = cp;
                super();
            }
        });
        obj;
        JVM INSTR monitorexit ;
        if (flag)
        {
            d(a1, ct1, this, executor, cp);
        }
        return a1.a();
        ct1;
        obj;
        JVM INSTR monitorexit ;
        throw ct1;
    }

    public boolean b()
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

    public cu c(ct ct1)
    {
        return c(ct1, c, null);
    }

    public cu c(ct ct1, Executor executor)
    {
        return c(ct1, executor, null);
    }

    public cu c(ct ct1, Executor executor, cp cp)
    {
        return b(new ct(cp, ct1) {

            final cp a;
            final ct b;
            final cu c;

            public cu a(cu cu1)
            {
                if (a != null && a.a())
                {
                    return cu.h();
                }
                if (cu1.d())
                {
                    return cu.a(cu1.f());
                }
                if (cu1.c())
                {
                    return cu.h();
                } else
                {
                    return cu1.a(b);
                }
            }

            public Object then(cu cu1)
                throws Exception
            {
                return a(cu1);
            }

            
            {
                c = cu.this;
                a = cp1;
                b = ct1;
                super();
            }
        }, executor);
    }

    public boolean c()
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

    public cu d(ct ct1)
    {
        return d(ct1, c);
    }

    public cu d(ct ct1, Executor executor)
    {
        return d(ct1, executor, null);
    }

    public cu d(ct ct1, Executor executor, cp cp)
    {
        return b(new ct(cp, ct1) {

            final cp a;
            final ct b;
            final cu c;

            public cu a(cu cu1)
            {
                if (a != null && a.a())
                {
                    return cu.h();
                }
                if (cu1.d())
                {
                    return cu.a(cu1.f());
                }
                if (cu1.c())
                {
                    return cu.h();
                } else
                {
                    return cu1.b(b);
                }
            }

            public Object then(cu cu1)
                throws Exception
            {
                return a(cu1);
            }

            
            {
                c = cu.this;
                a = cp1;
                b = ct1;
                super();
            }
        }, executor);
    }

    public boolean d()
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

    public Object e()
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

    public Exception f()
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

    public void g()
        throws InterruptedException
    {
        synchronized (d)
        {
            if (!b())
            {
                d.wait();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public cu i()
    {
        return this;
    }

    public cu j()
    {
        return b(new ct() {

            final cu a;

            public cu a(cu cu1)
                throws Exception
            {
                if (cu1.c())
                {
                    return cu.h();
                }
                if (cu1.d())
                {
                    return cu.a(cu1.f());
                } else
                {
                    return cu.a(null);
                }
            }

            public Object then(cu cu1)
                throws Exception
            {
                return a(cu1);
            }

            
            {
                a = cu.this;
                super();
            }
        });
    }


    // Unreferenced inner class android/support/v7/cu$1

/* anonymous class */
    static final class _cls1
        implements Runnable
    {

        final a a;

        public void run()
        {
            a.a(null);
        }
    }

}
