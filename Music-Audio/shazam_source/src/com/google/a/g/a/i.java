// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.g.a;

import com.google.a.a.c;
import com.google.a.a.g;
import com.google.a.c.aw;
import java.lang.reflect.Constructor;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.google.a.g.a:
//            j, c, h, a, 
//            r

public final class i
{
    private static final class a extends com.google.a.g.a.a
        implements Runnable
    {

        private com.google.a.g.a.c b;
        private j c;
        private volatile j d;

        static j a(a a1)
        {
            a1.d = null;
            return null;
        }

        private static void a(Future future, boolean flag)
        {
            if (future != null)
            {
                future.cancel(flag);
            }
        }

        public final boolean cancel(boolean flag)
        {
            if (super.cancel(flag))
            {
                a(c, flag);
                a(d, flag);
                return true;
            } else
            {
                return false;
            }
        }

        public final void run()
        {
            Object obj = r.a(c);
            obj = (j)g.a(b.a(obj), "AsyncFunction may not return null.");
            d = ((j) (obj));
            if (!isCancelled())
            {
                break MISSING_BLOCK_LABEL_108;
            }
            ((j) (obj)).cancel(super.a.d());
            d = null;
            b = null;
            c = null;
            return;
            obj;
            cancel(false);
            b = null;
            c = null;
            return;
            obj;
            a(((ExecutionException) (obj)).getCause());
            b = null;
            c = null;
            return;
            ((j) (obj)).a(new Runnable(this, ((j) (obj))) {

                final j a;
                final a b;

                public final void run()
                {
                    b.a(r.a(a));
                    a.a(b);
                    return;
                    Object obj;
                    obj;
                    b.cancel(false);
                    a.a(b);
                    return;
                    obj;
                    b.a(((ExecutionException) (obj)).getCause());
                    a.a(b);
                    return;
                    obj;
                    a.a(b);
                    throw obj;
                }

            
            {
                b = a1;
                a = j1;
                super();
            }
            }, o.a.a);
            b = null;
            c = null;
            return;
            Object obj1;
            obj1;
            a(((UndeclaredThrowableException) (obj1)).getCause());
            b = null;
            c = null;
            return;
            obj1;
            a(((Throwable) (obj1)));
            b = null;
            c = null;
            return;
            obj1;
            b = null;
            c = null;
            throw obj1;
        }

        private a(com.google.a.g.a.c c1, j j1)
        {
            b = (com.google.a.g.a.c)g.a(c1);
            c = (j)g.a(j1);
        }

        a(com.google.a.g.a.c c1, j j1, byte byte0)
        {
            this(c1, j1);
        }
    }

    private static final class b extends c
    {

        private final Throwable a;

        public final Object get()
        {
            throw new ExecutionException(a);
        }

        b(Throwable throwable)
        {
            super((byte)0);
            a = throwable;
        }
    }

    private static abstract class c
        implements j
    {

        private static final Logger a = Logger.getLogger(com/google/a/g/a/i$c.getName());

        public final void a(Runnable runnable, Executor executor)
        {
            g.a(runnable, "Runnable was null.");
            g.a(executor, "Executor was null.");
            try
            {
                executor.execute(runnable);
                return;
            }
            catch (RuntimeException runtimeexception)
            {
                Logger logger = a;
                Level level = Level.SEVERE;
                runnable = String.valueOf(String.valueOf(runnable));
                executor = String.valueOf(String.valueOf(executor));
                logger.log(level, (new StringBuilder(runnable.length() + 57 + executor.length())).append("RuntimeException while executing runnable ").append(runnable).append(" with executor ").append(executor).toString(), runtimeexception);
                return;
            }
        }

        public boolean cancel(boolean flag)
        {
            return false;
        }

        public abstract Object get();

        public Object get(long l, TimeUnit timeunit)
        {
            g.a(timeunit);
            return get();
        }

        public boolean isCancelled()
        {
            return false;
        }

        public boolean isDone()
        {
            return true;
        }


        private c()
        {
        }

        c(byte byte0)
        {
            this();
        }
    }

    private static final class d extends c
    {

        private final Object a;

        public final Object get()
        {
            return a;
        }

        d(Object obj)
        {
            super((byte)0);
            a = obj;
        }
    }


    private static final com.google.a.g.a.c a = new com.google.a.g.a.c() {

        public final volatile j a(Object obj)
        {
            return (j)obj;
        }

    };
    private static final aw b;

    public static j a(j j1, com.google.a.a.c c1)
    {
        g.a(c1);
        c1 = new a(new com.google.a.g.a.c(c1) {

            final com.google.a.a.c a;

            public final j a(Object obj)
            {
                return i.a(a.a(obj));
            }

            
            {
                a = c1;
                super();
            }
        }, j1, (byte)0);
        j1.a(c1, o.a.a);
        return c1;
    }

    public static j a(Object obj)
    {
        return new d(obj);
    }

    public static j a(Throwable throwable)
    {
        g.a(throwable);
        return new b(throwable);
    }

    public static void a(j j1, h h)
    {
        o.a a1 = o.a.a;
        g.a(h);
        j1.a(new Runnable(j1, h) {

            final j a;
            final h b;

            public final void run()
            {
                Object obj;
                try
                {
                    obj = r.a(a);
                }
                catch (ExecutionException executionexception)
                {
                    b.onFailure(executionexception.getCause());
                    return;
                }
                catch (RuntimeException runtimeexception)
                {
                    b.onFailure(runtimeexception);
                    return;
                }
                catch (Error error)
                {
                    b.onFailure(error);
                    return;
                }
                b.onSuccess(obj);
            }

            
            {
                a = j1;
                b = h1;
                super();
            }
        }, a1);
    }

    static 
    {
        aw aw1 = aw.b();
        b = (new com.google.a.c.i(new com.google.a.a.c() {

            public final Object a(Object obj)
            {
                return Boolean.valueOf(Arrays.asList(((Constructor)obj).getParameterTypes()).contains(java/lang/String));
            }

        }, aw1)).a();
    }
}
