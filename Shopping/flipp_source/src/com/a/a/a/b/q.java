// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.b;

import com.a.a.a.u;
import java.io.Closeable;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.a.a.a.b:
//            u, aa, v, x, 
//            j, d, b, t, 
//            r, a, k, h

public final class q
    implements Closeable
{

    static final ExecutorService a;
    static final boolean g;
    final aa b;
    final boolean c;
    public final d d;
    final String e;
    k f;
    private final h h;
    private final b i;
    private final Map j;
    private int k;
    private int l;
    private boolean m;
    private long n;
    private Map o;
    private int p;

    private q(com.a.a.a.b.u u1)
    {
        boolean flag = true;
        super();
        j = new HashMap();
        n = System.nanoTime();
        b = u1.e;
        c = u1.f;
        h = u1.d;
        i = b.a(u1.b, c);
        d = b.a(u1.c, c);
        int i1;
        if (u1.f)
        {
            i1 = 1;
        } else
        {
            i1 = 2;
        }
        l = i1;
        if (u1.f)
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = 2;
        }
        p = i1;
        e = u1.a;
        (new Thread(new v(this, (byte)0), (new StringBuilder("Spdy Reader ")).append(e).toString())).start();
    }

    public q(com.a.a.a.b.u u1, byte byte0)
    {
        this(u1);
    }

    static b a(q q1)
    {
        return q1.i;
    }

    static x a(q q1, int i1)
    {
        return q1.b(i1);
    }

    private void a(a a1, a a2)
    {
        if (!g && Thread.holdsLock(this))
        {
            throw new AssertionError();
        }
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        this;
        JVM INSTR monitorenter ;
        if (!m) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        obj;
        JVM INSTR monitorexit ;
        a1 = null;
_L9:
        this;
        JVM INSTR monitorenter ;
        x ax[];
        if (j.isEmpty())
        {
            break MISSING_BLOCK_LABEL_391;
        }
        ax = (x[])j.values().toArray(new x[j.size()]);
        j.clear();
        a(false);
_L14:
        if (o == null) goto _L4; else goto _L3
_L3:
        j aj[];
        aj = (j[])o.values().toArray(new j[o.size()]);
        o = null;
_L13:
        this;
        JVM INSTR monitorexit ;
        obj = a1;
        if (ax == null) goto _L6; else goto _L5
_L5:
        int i1;
        int k1;
        k1 = ax.length;
        i1 = 0;
_L8:
        if (i1 >= k1)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = ax[i1];
        ((x) (obj)).a(a2);
        obj = a1;
_L10:
        i1++;
        a1 = ((a) (obj));
        if (true) goto _L8; else goto _L7
_L2:
        m = true;
        i1 = k;
        this;
        JVM INSTR monitorexit ;
        d.b(i1, a1);
        obj;
        JVM INSTR monitorexit ;
        a1 = null;
          goto _L9
        a1;
        this;
        JVM INSTR monitorexit ;
        throw a1;
        a1;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw a1;
        }
        // Misplaced declaration of an exception variable
        catch (a a1) { }
          goto _L9
        a1;
        this;
        JVM INSTR monitorexit ;
        throw a1;
        IOException ioexception;
        ioexception;
        obj = a1;
        if (a1 != null)
        {
            obj = ioexception;
        }
          goto _L10
_L7:
        obj = a1;
_L6:
        if (aj != null)
        {
            int l1 = aj.length;
            for (int j1 = 0; j1 < l1; j1++)
            {
                a1 = aj[j1];
                if (((j) (a1)).c != -1L || ((j) (a1)).b == -1L)
                {
                    throw new IllegalStateException();
                }
                a1.c = ((j) (a1)).b - 1L;
                ((j) (a1)).a.countDown();
            }

        }
        i.close();
        a1 = ((a) (obj));
_L11:
        d.close();
        a2 = a1;
_L12:
        if (a2 != null)
        {
            throw a2;
        } else
        {
            return;
        }
        a1;
          goto _L11
        a2;
        if (a1 != null)
        {
            a2 = a1;
        }
          goto _L12
_L4:
        aj = null;
          goto _L13
        ax = null;
          goto _L14
    }

    static void a(q q1, int i1, int j1)
    {
        a.submit(new t(q1, "OkHttp SPDY Writer %s ping %08x%08x", new Object[] {
            q1.e, Integer.valueOf(i1), Integer.valueOf(j1)
        }, i1, j1));
    }

    static void a(q q1, a a1, a a2)
    {
        q1.a(a1, a2);
    }

    static void a(q q1, boolean flag, int i1, j j1)
    {
        d d1 = q1.d;
        d1;
        JVM INSTR monitorenter ;
        if (j1 == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        if (j1.b != -1L)
        {
            throw new IllegalStateException();
        }
        break MISSING_BLOCK_LABEL_38;
        q1;
        d1;
        JVM INSTR monitorexit ;
        throw q1;
        j1.b = System.nanoTime();
        q1.d.a(flag, i1);
        d1;
        JVM INSTR monitorexit ;
    }

    private void a(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_18;
        }
        long l1 = System.nanoTime();
_L1:
        n = l1;
        this;
        JVM INSTR monitorexit ;
        return;
        l1 = 0L;
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    static int b(q q1, int i1)
    {
        q1.k = i1;
        return i1;
    }

    private x b(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        x x1 = (x)j.get(Integer.valueOf(i1));
        this;
        JVM INSTR monitorexit ;
        return x1;
        Exception exception;
        exception;
        throw exception;
    }

    static boolean b(q q1)
    {
        return q1.m;
    }

    private j c(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        if (o == null) goto _L2; else goto _L1
_L1:
        j j1 = (j)o.remove(Integer.valueOf(i1));
_L4:
        this;
        JVM INSTR monitorexit ;
        return j1;
_L2:
        j1 = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    static j c(q q1, int i1)
    {
        return q1.c(i1);
    }

    static Map c(q q1)
    {
        return q1.j;
    }

    static String d(q q1)
    {
        return q1.e;
    }

    static ExecutorService d()
    {
        return a;
    }

    static h e(q q1)
    {
        return q1.h;
    }

    static boolean f(q q1)
    {
        q1.m = true;
        return true;
    }

    final x a(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        x x1 = (x)j.remove(Integer.valueOf(i1));
        if (x1 == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        if (j.isEmpty())
        {
            a(true);
        }
        this;
        JVM INSTR monitorexit ;
        return x1;
        Exception exception;
        exception;
        throw exception;
    }

    public final x a(List list, boolean flag)
    {
        boolean flag1;
        flag1 = false;
        if (!flag)
        {
            flag1 = true;
        }
        d d1 = d;
        d1;
        JVM INSTR monitorenter ;
        this;
        JVM INSTR monitorenter ;
        if (m)
        {
            throw new IOException("shutdown");
        }
        break MISSING_BLOCK_LABEL_47;
        list;
        this;
        JVM INSTR monitorexit ;
        throw list;
        list;
        d1;
        JVM INSTR monitorexit ;
        throw list;
        x x1;
        int i1;
        i1 = l;
        l = l + 2;
        x1 = new x(i1, this, flag1, false, 0, 0, list, f);
        if (x1.a())
        {
            j.put(Integer.valueOf(i1), x1);
            a(false);
        }
        this;
        JVM INSTR monitorexit ;
        d.a(flag1, i1, list);
        d1;
        JVM INSTR monitorexit ;
        return x1;
    }

    final void a(int i1, a a1)
    {
        a.submit(new r(this, "OkHttp SPDY Writer %s stream %d", new Object[] {
            e, Integer.valueOf(i1)
        }, i1, a1));
    }

    public final boolean a()
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = n;
        boolean flag;
        if (l1 != 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public final long b()
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = n;
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    final void b(int i1, a a1)
    {
        d.a(i1, a1);
    }

    public final void c()
    {
        d.b();
    }

    public final void close()
    {
        a(a.a, a.l);
    }

    static 
    {
        boolean flag;
        if (!com/a/a/a/b/q.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        g = flag;
        a = new ThreadPoolExecutor(0, 0x7fffffff, 60L, TimeUnit.SECONDS, new SynchronousQueue(), u.b("OkHttp SpdyConnection"));
    }
}
