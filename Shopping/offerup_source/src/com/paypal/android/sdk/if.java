// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.EOFException;
import java.io.IOException;

// Referenced classes of package com.paypal.android.sdk:
//            lj, id, kq, ih, 
//            hr, jb, ks, hn, 
//            lk

final class if
    implements lj
{

    private static boolean f;
    private final kq a;
    private final kq b;
    private final long c;
    private boolean d;
    private boolean e;
    private id g;

    private if(id id1, long l)
    {
        g = id1;
        super();
        a = new kq();
        b = new kq();
        c = l;
    }

    if(id id1, long l, byte byte0)
    {
        this(id1, l);
    }

    static boolean a(if if1)
    {
        return if1.e;
    }

    static boolean a(if if1, boolean flag)
    {
        if1.e = flag;
        return flag;
    }

    private void b()
    {
        id.c(g).c();
        for (; b.b == 0L && !e && !d && id.d(g) == null; id.e(g)) { }
        break MISSING_BLOCK_LABEL_69;
        Exception exception;
        exception;
        id.c(g).b();
        throw exception;
        id.c(g).b();
        return;
    }

    static boolean b(if if1)
    {
        return if1.d;
    }

    public final long a(kq kq1, long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
        }
        id id1 = g;
        id1;
        JVM INSTR monitorenter ;
        b();
        if (d)
        {
            throw new IOException("stream closed");
        }
        break MISSING_BLOCK_LABEL_66;
        kq1;
        id1;
        JVM INSTR monitorexit ;
        throw kq1;
        if (id.d(g) != null)
        {
            throw new IOException((new StringBuilder("stream was reset: ")).append(id.d(g)).toString());
        }
        if (b.b != 0L)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        id1;
        JVM INSTR monitorexit ;
        return -1L;
        l = b.a(kq1, Math.min(l, b.b));
        kq1 = g;
        kq1.a = ((id) (kq1)).a + l;
        if (g.a >= (long)(id.a(g).e.d() / 2))
        {
            id.a(g).a(id.b(g), g.a);
            g.a = 0L;
        }
        id1;
        JVM INSTR monitorexit ;
        synchronized (id.a(g))
        {
            hr hr1 = id.a(g);
            hr1.c = hr1.c + l;
            if (id.a(g).c >= (long)(id.a(g).e.d() / 2))
            {
                id.a(g).a(0, id.a(g).c);
                id.a(g).c = 0L;
            }
        }
        return l;
        exception;
        kq1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final lk a()
    {
        return id.c(g);
    }

    final void a(ks ks1, long l)
    {
        long l1;
        l1 = l;
        if (!f)
        {
            l1 = l;
            if (Thread.holdsLock(g))
            {
                throw new AssertionError();
            }
        }
          goto _L1
_L3:
        l1 -= l;
        id id1 = g;
        id1;
        JVM INSTR monitorenter ;
        boolean flag;
        boolean flag1;
        if (b.b == 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.a(a);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        g.notifyAll();
        id1;
        JVM INSTR monitorexit ;
_L1:
        if (l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_156;
        }
        id1 = g;
        id1;
        JVM INSTR monitorenter ;
        flag1 = e;
        if (b.b + l1 > c)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        id1;
        JVM INSTR monitorexit ;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        ks1.f(l1);
        g.b(hn.f);
        return;
        ks1;
        id1;
        JVM INSTR monitorexit ;
        throw ks1;
        if (flag1)
        {
            ks1.f(l1);
            return;
        }
        l = ks1.a(a, l1);
        if (l != -1L) goto _L3; else goto _L2
_L2:
        throw new EOFException();
        ks1;
        id1;
        JVM INSTR monitorexit ;
        throw ks1;
    }

    public final void close()
    {
        synchronized (g)
        {
            d = true;
            b.n();
            g.notifyAll();
        }
        id.f(g);
        return;
        exception;
        id1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static 
    {
        boolean flag;
        if (!com/paypal/android/sdk/id.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f = flag;
    }
}
