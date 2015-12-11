// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.paypal.android.sdk:
//            ih, hr, jb, if, 
//            ie, hn, ij, ks, 
//            lk, lj, lh

public final class id
{

    private static boolean k;
    long a;
    long b;
    final ie c;
    private final int d;
    private final hr e;
    private List f;
    private final if g;
    private final ih h = new ih(this);
    private final ih i = new ih(this);
    private hn j;

    id(int l, hr hr1, boolean flag, boolean flag1, List list)
    {
        a = 0L;
        j = null;
        if (hr1 == null)
        {
            throw new NullPointerException("connection == null");
        }
        if (list == null)
        {
            throw new NullPointerException("requestHeaders == null");
        } else
        {
            d = l;
            e = hr1;
            b = hr1.f.d();
            g = new if(this, hr1.e.d(), (byte)0);
            c = new ie(this);
            com.paypal.android.sdk.if.a(g, flag1);
            ie.a(c, flag);
            return;
        }
    }

    static hr a(id id1)
    {
        return id1.e;
    }

    static int b(id id1)
    {
        return id1.d;
    }

    static ih c(id id1)
    {
        return id1.h;
    }

    static hn d(id id1)
    {
        return id1.j;
    }

    private boolean d(hn hn1)
    {
        if (!k && Thread.holdsLock(this))
        {
            throw new AssertionError();
        }
        this;
        JVM INSTR monitorenter ;
        if (j == null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        if (!com.paypal.android.sdk.if.a(g) || !ie.a(c))
        {
            break MISSING_BLOCK_LABEL_63;
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        hn1;
        this;
        JVM INSTR monitorexit ;
        throw hn1;
        j = hn1;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        e.b(d);
        return true;
    }

    static void e(id id1)
    {
        id1.i();
    }

    static void f(id id1)
    {
        if (!k && Thread.holdsLock(id1))
        {
            throw new AssertionError();
        }
        id1;
        JVM INSTR monitorenter ;
        boolean flag;
        boolean flag1;
        if (com.paypal.android.sdk.if.a(id1.g) || !com.paypal.android.sdk.if.b(id1.g) || !ie.a(id1.c) && !ie.b(id1.c))
        {
            flag = false;
        } else
        {
            flag = true;
        }
        flag1 = id1.b();
        id1;
        JVM INSTR monitorexit ;
        Exception exception;
        if (flag)
        {
            id1.a(hn.h);
        } else
        if (!flag1)
        {
            id1.e.b(id1.d);
            return;
        }
        return;
        exception;
        id1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static ih g(id id1)
    {
        return id1.i;
    }

    static void h(id id1)
    {
        if (ie.b(id1.c))
        {
            throw new IOException("stream closed");
        }
        if (ie.a(id1.c))
        {
            throw new IOException("stream finished");
        }
        if (id1.j != null)
        {
            throw new IOException((new StringBuilder("stream was reset: ")).append(id1.j).toString());
        } else
        {
            return;
        }
    }

    private void i()
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

    public final int a()
    {
        return d;
    }

    final void a(long l)
    {
        b = b + l;
        if (l > 0L)
        {
            notifyAll();
        }
    }

    public final void a(hn hn1)
    {
        if (!d(hn1))
        {
            return;
        } else
        {
            e.b(d, hn1);
            return;
        }
    }

    final void a(ks ks, int l)
    {
        if (!k && Thread.holdsLock(this))
        {
            throw new AssertionError();
        } else
        {
            g.a(ks, l);
            return;
        }
    }

    final void a(List list, ij ij1)
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        flag1 = false;
        flag = false;
        flag2 = true;
        if (!k && Thread.holdsLock(this))
        {
            throw new AssertionError();
        }
        Object obj = null;
        this;
        JVM INSTR monitorenter ;
        if (f != null) goto _L2; else goto _L1
_L1:
        if (ij1 == ij.c)
        {
            flag = true;
        }
        if (!flag) goto _L4; else goto _L3
_L3:
        list = hn.b;
_L7:
        this;
        JVM INSTR monitorexit ;
        if (list == null) goto _L6; else goto _L5
_L5:
        b(list);
_L9:
        return;
_L4:
        f = list;
        flag2 = b();
        notifyAll();
        list = obj;
          goto _L7
        list;
        this;
        JVM INSTR monitorexit ;
        throw list;
_L2:
        flag = flag1;
        if (ij1 == ij.b)
        {
            flag = true;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        list = hn.d;
          goto _L7
        ij1 = new ArrayList();
        ij1.addAll(f);
        ij1.addAll(list);
        f = ij1;
        list = obj;
          goto _L7
_L6:
        if (flag2) goto _L9; else goto _L8
_L8:
        e.b(d);
        return;
          goto _L7
    }

    public final void b(hn hn1)
    {
        if (!d(hn1))
        {
            return;
        } else
        {
            e.a(d, hn1);
            return;
        }
    }

    public final boolean b()
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        Object obj = j;
        if (obj == null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        if (!com.paypal.android.sdk.if.a(g) && !com.paypal.android.sdk.if.b(g) || !ie.a(c) && !ie.b(c))
        {
            break MISSING_BLOCK_LABEL_66;
        }
        obj = f;
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

    final void c(hn hn1)
    {
        this;
        JVM INSTR monitorenter ;
        if (j == null)
        {
            j = hn1;
            notifyAll();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        hn1;
        throw hn1;
    }

    public final boolean c()
    {
        boolean flag;
        if ((d & 1) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return e.b == flag;
    }

    public final List d()
    {
        this;
        JVM INSTR monitorenter ;
        h.c();
        while (f == null && j == null) 
        {
            i();
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
        if (f == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        list = f;
        this;
        JVM INSTR monitorexit ;
        return list;
        throw new IOException((new StringBuilder("stream was reset: ")).append(j).toString());
    }

    public final lk e()
    {
        return h;
    }

    public final lj f()
    {
        return g;
    }

    public final lh g()
    {
        this;
        JVM INSTR monitorenter ;
        if (f == null && !c())
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
        return c;
    }

    final void h()
    {
        if (!k && Thread.holdsLock(this))
        {
            throw new AssertionError();
        }
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        com.paypal.android.sdk.if.a(g, true);
        flag = b();
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        if (!flag)
        {
            e.b(d);
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
        if (!com/paypal/android/sdk/id.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        k = flag;
    }
}
