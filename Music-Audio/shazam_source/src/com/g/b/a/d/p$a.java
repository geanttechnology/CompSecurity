// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.d;

import c.c;
import c.r;
import c.t;

// Referenced classes of package com.g.b.a.d:
//            p, o

final class 
    implements r
{

    static final boolean a;
    final p b;
    private final c c = new c();
    private boolean d;
    private boolean e;

    private void a(boolean flag)
    {
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        p.g(b).x_();
        for (; b.b <= 0L && !e && !d && p.d(b) == null; p.e(b)) { }
        break MISSING_BLOCK_LABEL_81;
        Exception exception1;
        exception1;
        p.g(b).b();
        throw exception1;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        long l;
        p.g(b).b();
        p.h(b);
        l = Math.min(b.b, c.b);
        p p1 = b;
        p1.b = p1.b - l;
        obj;
        JVM INSTR monitorexit ;
        p.g(b).x_();
        int i;
        obj = p.a(b);
        i = p.b(b);
        if (!flag) goto _L2; else goto _L1
_L1:
        if (l != c.b) goto _L2; else goto _L3
_L3:
        flag = true;
_L5:
        ((o) (obj)).a(i, flag, c, l);
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

    static boolean a(b b1)
    {
        return b1.e;
    }

    static boolean a(e e1, boolean flag)
    {
        e1.e = flag;
        return flag;
    }

    static boolean b(e e1)
    {
        return e1.d;
    }

    public final void a_(c c1, long l)
    {
        if (!a && Thread.holdsLock(b))
        {
            throw new AssertionError();
        }
        c.a_(c1, l);
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

    ionError(p p1)
    {
        b = p1;
        super();
    }
}
