// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.d;

import c.e;
import c.r;
import c.s;
import c.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.List;

// Referenced classes of package com.g.b.a.d:
//            o, m, a

public final class p
{
    final class a
        implements r
    {

        static final boolean a;
        final p b;
        private final c.c c = new c.c();
        private boolean d;
        private boolean e;

        private void a(boolean flag)
        {
            Object obj = b;
            obj;
            JVM INSTR monitorenter ;
            p.g(b).x_();
            for (; b.b <= 0L && !e && !d && p.d(b) == null; com.g.b.a.d.p.e(b)) { }
            break MISSING_BLOCK_LABEL_81;
            Exception exception1;
            exception1;
            p.g(b).b();
            throw exception1;
            exception1;
            obj;
            JVM INSTR monitorexit ;
            throw exception1;
            long l1;
            p.g(b).b();
            p.h(b);
            l1 = Math.min(b.b, c.b);
            p p1 = b;
            p1.b = p1.b - l1;
            obj;
            JVM INSTR monitorexit ;
            p.g(b).x_();
            int i1;
            obj = p.a(b);
            i1 = p.b(b);
            if (!flag) goto _L2; else goto _L1
_L1:
            if (l1 != c.b) goto _L2; else goto _L3
_L3:
            flag = true;
_L5:
            ((o) (obj)).a(i1, flag, c, l1);
            p.g(b).b();
            return;
_L2:
            flag = false;
            if (true) goto _L5; else goto _L4
_L4:
            Exception exception;
            exception;
            p.g(b).b();
            throw exception;
        }

        static boolean a(a a1)
        {
            return a1.e;
        }

        static boolean a(a a1, boolean flag)
        {
            a1.e = flag;
            return flag;
        }

        static boolean b(a a1)
        {
            return a1.d;
        }

        public final void a_(c.c c1, long l1)
        {
            if (!a && Thread.holdsLock(b))
            {
                throw new AssertionError();
            }
            c.a_(c1, l1);
            while (c.b >= 16384L) 
            {
                a(false);
            }
        }

        public final void close()
        {
label0:
            {
                if (!a && Thread.holdsLock(b))
                {
                    throw new AssertionError();
                }
                synchronized (b)
                {
                    if (!d)
                    {
                        break label0;
                    }
                }
                return;
            }
            p1;
            JVM INSTR monitorexit ;
            if (!b.g.e)
            {
                if (c.b > 0L)
                {
                    while (c.b > 0L) 
                    {
                        a(true);
                    }
                } else
                {
                    p.a(b).a(p.b(b), true, null, 0L);
                }
            }
            break MISSING_BLOCK_LABEL_113;
            exception;
            p1;
            JVM INSTR monitorexit ;
            throw exception;
            synchronized (b)
            {
                d = true;
            }
            p.a(b).c();
            p.f(b);
            return;
            exception1;
            p2;
            JVM INSTR monitorexit ;
            throw exception1;
        }

        public final void flush()
        {
            if (!a && Thread.holdsLock(b))
            {
                throw new AssertionError();
            }
            synchronized (b)
            {
                p.h(b);
            }
            while (c.b > 0L) 
            {
                a(false);
                p.a(b).c();
            }
            break MISSING_BLOCK_LABEL_75;
            exception;
            p1;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public final t w_()
        {
            return p.g(b);
        }

        static 
        {
            boolean flag;
            if (!com/g/b/a/d/p.desiredAssertionStatus())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            a = flag;
        }

        a()
        {
            b = p.this;
            super();
        }
    }

    private final class b
        implements s
    {

        static final boolean a;
        final p b;
        private final c.c c;
        private final c.c d;
        private final long e;
        private boolean f;
        private boolean g;

        static boolean a(b b1)
        {
            return b1.g;
        }

        static boolean a(b b1, boolean flag)
        {
            b1.g = flag;
            return flag;
        }

        private void b()
        {
            p.c(b).x_();
            for (; d.b == 0L && !g && !f && p.d(b) == null; com.g.b.a.d.p.e(b)) { }
            break MISSING_BLOCK_LABEL_69;
            Exception exception;
            exception;
            p.c(b).b();
            throw exception;
            p.c(b).b();
            return;
        }

        static boolean b(b b1)
        {
            return b1.f;
        }

        public final long a(c.c c1, long l1)
        {
            if (l1 < 0L)
            {
                throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l1).toString());
            }
            p p1 = b;
            p1;
            JVM INSTR monitorenter ;
            b();
            if (f)
            {
                throw new IOException("stream closed");
            }
            break MISSING_BLOCK_LABEL_66;
            c1;
            p1;
            JVM INSTR monitorexit ;
            throw c1;
            if (p.d(b) != null)
            {
                throw new IOException((new StringBuilder("stream was reset: ")).append(p.d(b)).toString());
            }
            if (d.b != 0L)
            {
                break MISSING_BLOCK_LABEL_125;
            }
            p1;
            JVM INSTR monitorexit ;
            return -1L;
            l1 = d.a(c1, Math.min(l1, d.b));
            c1 = b;
            c1.a = ((p) (c1)).a + l1;
            if (b.a >= (long)(p.a(b).e.b() / 2))
            {
                p.a(b).a(p.b(b), b.a);
                b.a = 0L;
            }
            p1;
            JVM INSTR monitorexit ;
            synchronized (p.a(b))
            {
                o o1 = p.a(b);
                o1.c = o1.c + l1;
                if (p.a(b).c >= (long)(p.a(b).e.b() / 2))
                {
                    p.a(b).a(0, p.a(b).c);
                    p.a(b).c = 0L;
                }
            }
            return l1;
            exception;
            c1;
            JVM INSTR monitorexit ;
            throw exception;
        }

        final void a(e e1, long l1)
        {
            long l2;
            l2 = l1;
            if (!a)
            {
                l2 = l1;
                if (Thread.holdsLock(b))
                {
                    throw new AssertionError();
                }
            }
              goto _L1
_L3:
            l2 -= l1;
            p p1 = b;
            p1;
            JVM INSTR monitorenter ;
            boolean flag;
            boolean flag1;
            if (d.b == 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            d.a(c);
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_84;
            }
            b.notifyAll();
            p1;
            JVM INSTR monitorexit ;
_L1:
            if (l2 <= 0L)
            {
                break MISSING_BLOCK_LABEL_156;
            }
            p1 = b;
            p1;
            JVM INSTR monitorenter ;
            flag1 = g;
            if (d.b + l2 > e)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            p1;
            JVM INSTR monitorexit ;
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_169;
            }
            e1.f(l2);
            b.b(com.g.b.a.d.a.h);
            return;
            e1;
            p1;
            JVM INSTR monitorexit ;
            throw e1;
            if (flag1)
            {
                e1.f(l2);
                return;
            }
            l1 = e1.a(c, l2);
            if (l1 != -1L) goto _L3; else goto _L2
_L2:
            throw new EOFException();
            e1;
            p1;
            JVM INSTR monitorexit ;
            throw e1;
        }

        public final void close()
        {
            synchronized (b)
            {
                f = true;
                d.r();
                b.notifyAll();
            }
            p.f(b);
            return;
            exception;
            p1;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public final t w_()
        {
            return p.c(b);
        }

        static 
        {
            boolean flag;
            if (!com/g/b/a/d/p.desiredAssertionStatus())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            a = flag;
        }

        private b(long l1)
        {
            b = p.this;
            super();
            c = new c.c();
            d = new c.c();
            e = l1;
        }

        b(long l1, byte byte0)
        {
            this(l1);
        }
    }

    final class c extends c.a
    {

        final p a;

        protected final void a()
        {
            a.b(com.g.b.a.d.a.l);
        }

        public final void b()
        {
            if (y_())
            {
                throw new InterruptedIOException("timeout");
            } else
            {
                return;
            }
        }

        c()
        {
            a = p.this;
            super();
        }
    }


    static final boolean i;
    long a;
    long b;
    final int c;
    final o d;
    List e;
    public final b f;
    final a g;
    public final c h = new c();
    private final List j;
    private final c k = new c();
    private com.g.b.a.d.a l;

    p(int i1, o o1, boolean flag, boolean flag1, List list)
    {
        a = 0L;
        l = null;
        if (o1 == null)
        {
            throw new NullPointerException("connection == null");
        }
        if (list == null)
        {
            throw new NullPointerException("requestHeaders == null");
        } else
        {
            c = i1;
            d = o1;
            b = o1.f.b();
            f = new b(o1.e.b(), (byte)0);
            g = new a();
            b.a(f, flag1);
            a.a(g, flag);
            j = list;
            return;
        }
    }

    static o a(p p1)
    {
        return p1.d;
    }

    static int b(p p1)
    {
        return p1.c;
    }

    static c c(p p1)
    {
        return p1.h;
    }

    static com.g.b.a.d.a d(p p1)
    {
        return p1.l;
    }

    private boolean d(com.g.b.a.d.a a1)
    {
        if (!i && Thread.holdsLock(this))
        {
            throw new AssertionError();
        }
        this;
        JVM INSTR monitorenter ;
        if (l == null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        if (!b.a(f) || !a.a(g))
        {
            break MISSING_BLOCK_LABEL_63;
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        a1;
        this;
        JVM INSTR monitorexit ;
        throw a1;
        l = a1;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        d.b(c);
        return true;
    }

    static void e(p p1)
    {
        p1.f();
    }

    private void f()
    {
        try
        {
            wait();
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            throw new InterruptedIOException();
        }
    }

    static void f(p p1)
    {
        if (!i && Thread.holdsLock(p1))
        {
            throw new AssertionError();
        }
        p1;
        JVM INSTR monitorenter ;
        boolean flag;
        boolean flag1;
        if (b.a(p1.f) || !b.b(p1.f) || !a.a(p1.g) && !a.b(p1.g))
        {
            flag = false;
        } else
        {
            flag = true;
        }
        flag1 = p1.a();
        p1;
        JVM INSTR monitorexit ;
        Exception exception;
        if (flag)
        {
            p1.a(com.g.b.a.d.a.l);
        } else
        if (!flag1)
        {
            p1.d.b(p1.c);
            return;
        }
        return;
        exception;
        p1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static c g(p p1)
    {
        return p1.k;
    }

    static void h(p p1)
    {
        if (a.b(p1.g))
        {
            throw new IOException("stream closed");
        }
        if (a.a(p1.g))
        {
            throw new IOException("stream finished");
        }
        if (p1.l != null)
        {
            throw new IOException((new StringBuilder("stream was reset: ")).append(p1.l).toString());
        } else
        {
            return;
        }
    }

    final void a(long l1)
    {
        b = b + l1;
        if (l1 > 0L)
        {
            notifyAll();
        }
    }

    public final void a(com.g.b.a.d.a a1)
    {
        if (!d(a1))
        {
            return;
        } else
        {
            d.b(c, a1);
            return;
        }
    }

    public final boolean a()
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        Object obj = l;
        if (obj == null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        if (!b.a(f) && !b.b(f) || !a.a(g) && !a.b(g))
        {
            break MISSING_BLOCK_LABEL_66;
        }
        obj = e;
        if (obj != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = true;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final void b(com.g.b.a.d.a a1)
    {
        if (!d(a1))
        {
            return;
        } else
        {
            d.a(c, a1);
            return;
        }
    }

    public final boolean b()
    {
        boolean flag;
        if ((c & 1) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return d.b == flag;
    }

    public final List c()
    {
        this;
        JVM INSTR monitorenter ;
        h.x_();
        while (e == null && l == null) 
        {
            f();
        }
        break MISSING_BLOCK_LABEL_45;
        Exception exception;
        exception;
        h.b();
        throw exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        List list;
        h.b();
        if (e == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        list = e;
        this;
        JVM INSTR monitorexit ;
        return list;
        throw new IOException((new StringBuilder("stream was reset: ")).append(l).toString());
    }

    final void c(com.g.b.a.d.a a1)
    {
        this;
        JVM INSTR monitorenter ;
        if (l == null)
        {
            l = a1;
            notifyAll();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        a1;
        throw a1;
    }

    public final r d()
    {
        this;
        JVM INSTR monitorenter ;
        if (e == null && !b())
        {
            throw new IllegalStateException("reply before requesting the sink");
        }
        break MISSING_BLOCK_LABEL_31;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        this;
        JVM INSTR monitorexit ;
        return g;
    }

    final void e()
    {
        if (!i && Thread.holdsLock(this))
        {
            throw new AssertionError();
        }
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        b.a(f, true);
        flag = a();
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        if (!flag)
        {
            d.b(c);
        }
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static 
    {
        boolean flag;
        if (!com/g/b/a/d/p.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = flag;
    }
}
