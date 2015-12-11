// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.b;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.util.List;

// Referenced classes of package com.a.a.a.b:
//            y, z, q, a, 
//            k

public final class x
{

    static final boolean f;
    final int a;
    final q b;
    public long c;
    List d;
    public final y e = new y(this, (byte)0);
    private final int g;
    private final int h;
    private int i;
    private final List j;
    private final z k = new z(this, (byte)0);
    private a l;

    x(int i1, q q1, boolean flag, boolean flag1, int j1, int k1, List list, 
            k k2)
    {
        c = 0L;
        l = null;
        if (q1 == null)
        {
            throw new NullPointerException("connection == null");
        }
        if (list == null)
        {
            throw new NullPointerException("requestHeaders == null");
        } else
        {
            a = i1;
            b = q1;
            y.a(e, flag1);
            z.a(k, flag);
            g = j1;
            h = k1;
            j = list;
            a(k2);
            return;
        }
    }

    static int a(x x1)
    {
        return x1.a;
    }

    static q b(x x1)
    {
        return x1.b;
    }

    static long c(x x1)
    {
        return x1.c;
    }

    static a d(x x1)
    {
        return x1.l;
    }

    private boolean d(a a1)
    {
        if (!f && Thread.holdsLock(this))
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
        if (!y.a(e) || !z.a(k))
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
        b.a(a);
        return true;
    }

    static void e(x x1)
    {
        if (!f && Thread.holdsLock(x1))
        {
            throw new AssertionError();
        }
        x1;
        JVM INSTR monitorenter ;
        boolean flag;
        boolean flag1;
        if (y.a(x1.e) || !y.b(x1.e) || !z.a(x1.k) && !z.b(x1.k))
        {
            flag = false;
        } else
        {
            flag = true;
        }
        flag1 = x1.a();
        x1;
        JVM INSTR monitorexit ;
        Exception exception;
        if (flag)
        {
            x1.a(a.l);
        } else
        if (!flag1)
        {
            x1.b.a(x1.a);
            return;
        }
        return;
        exception;
        x1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static z f(x x1)
    {
        return x1.k;
    }

    static int g(x x1)
    {
        return x1.i;
    }

    final void a(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        z.a(k, i1);
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(a a1)
    {
        if (!d(a1))
        {
            return;
        } else
        {
            b.b(a, a1);
            return;
        }
    }

    final void a(k k1)
    {
        int j1 = 0x10000;
        if (!f && !Thread.holdsLock(b))
        {
            throw new AssertionError();
        }
        int i1 = j1;
        if (k1 != null)
        {
            i1 = j1;
            if ((k1.a & 0x80) != 0)
            {
                i1 = k1.d[7];
            }
        }
        i = i1;
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
        if (!y.a(e) && !y.b(e) || !z.a(k) && !z.b(k))
        {
            break MISSING_BLOCK_LABEL_66;
        }
        obj = d;
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

    public final void b(a a1)
    {
        if (!d(a1))
        {
            return;
        } else
        {
            b.a(a, a1);
            return;
        }
    }

    public final boolean b()
    {
        boolean flag;
        if (a % 2 == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return b.c == flag;
    }

    public final List c()
    {
        this;
        JVM INSTR monitorenter ;
        while (d == null && l == null) 
        {
            wait();
        }
        break MISSING_BLOCK_LABEL_45;
        Object obj;
        obj;
        InterruptedIOException interruptedioexception = new InterruptedIOException();
        interruptedioexception.initCause(((Throwable) (obj)));
        throw interruptedioexception;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        List list;
        if (d == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        list = d;
        this;
        JVM INSTR monitorexit ;
        return list;
        throw new IOException((new StringBuilder("stream was reset: ")).append(l).toString());
    }

    final void c(a a1)
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

    public final OutputStream d()
    {
        this;
        JVM INSTR monitorenter ;
        if (d == null && !b())
        {
            throw new IllegalStateException("reply before requesting the output stream");
        }
        break MISSING_BLOCK_LABEL_31;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        this;
        JVM INSTR monitorexit ;
        return k;
    }

    final void e()
    {
        if (!f && Thread.holdsLock(this))
        {
            throw new AssertionError();
        }
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        y.a(e, true);
        flag = a();
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        if (!flag)
        {
            b.a(a);
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
        if (!com/a/a/a/b/x.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f = flag;
    }
}
