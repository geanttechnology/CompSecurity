// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.d;

import c.c;
import c.e;
import c.s;
import c.t;
import java.io.EOFException;
import java.io.IOException;

// Referenced classes of package com.g.b.a.d:
//            p, o, m, a

private final class <init>
    implements s
{

    static final boolean a;
    final p b;
    private final c c;
    private final c d;
    private final long e;
    private boolean f;
    private boolean g;

    static boolean a( )
    {
        return .g;
    }

    static boolean a(g g1, boolean flag)
    {
        g1.g = flag;
        return flag;
    }

    private void b()
    {
        com.g.b.a.d.p.c(b).x_();
        for (; d.b == 0L && !g && !f && p.d(b) == null; com.g.b.a.d.p.e(b)) { }
        break MISSING_BLOCK_LABEL_69;
        Exception exception;
        exception;
        com.g.b.a.d.p.c(b).b();
        throw exception;
        com.g.b.a.d.p.c(b).b();
        return;
    }

    static boolean b(b b1)
    {
        return b1.f;
    }

    public final long a(c c1, long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
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
        l = d.a(c1, Math.min(l, d.b));
        c1 = b;
        c1.a = ((p) (c1)).a + l;
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
            o1.c = o1.c + l;
            if (p.a(b).c >= (long)(p.a(b).e.b() / 2))
            {
                p.a(b).a(0, p.a(b).c);
                p.a(b).c = 0L;
            }
        }
        return l;
        exception;
        c1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    final void a(e e1, long l)
    {
        long l1;
        l1 = l;
        if (!a)
        {
            l1 = l;
            if (Thread.holdsLock(b))
            {
                throw new AssertionError();
            }
        }
          goto _L1
_L3:
        l1 -= l;
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
        if (l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_156;
        }
        p1 = b;
        p1;
        JVM INSTR monitorenter ;
        flag1 = g;
        if (d.b + l1 > e)
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
        e1.f(l1);
        b.b(a.h);
        return;
        e1;
        p1;
        JVM INSTR monitorexit ;
        throw e1;
        if (flag1)
        {
            e1.f(l1);
            return;
        }
        l = e1.a(c, l1);
        if (l != -1L) goto _L3; else goto _L2
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
        return com.g.b.a.d.p.c(b);
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

    private tion(p p1, long l)
    {
        b = p1;
        super();
        c = new c();
        d = new c();
        e = l;
    }

    e(p p1, long l, byte byte0)
    {
        this(p1, l);
    }
}
