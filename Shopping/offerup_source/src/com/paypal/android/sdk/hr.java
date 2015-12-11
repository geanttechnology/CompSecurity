// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.paypal.android.sdk:
//            hl, jb, hz, gp, 
//            in, kz, jf, ia, 
//            jc, id, hq, hu, 
//            hy, kq, ks, hx, 
//            hn, hv, hw, fn, 
//            ht, hs, iu, iz

public final class hr
    implements Closeable
{

    private static final ExecutorService j;
    private static boolean w;
    final gp a;
    final boolean b;
    long c;
    long d;
    final jb e;
    final jb f;
    final jf g;
    final Socket h;
    final hq i;
    private final iu k;
    private final Map l;
    private final String m;
    private int n;
    private int o;
    private boolean p;
    private long q;
    private final ExecutorService r;
    private final iz s;
    private boolean t;
    private ia u;
    private final Set v;

    private hr(hz hz1)
    {
        l = new HashMap();
        q = System.nanoTime();
        c = 0L;
        e = new jb();
        f = new jb();
        t = false;
        v = new LinkedHashSet();
        a = hz.a(hz1);
        s = hz.b(hz1);
        b = hz.c(hz1);
        k = hz.d(hz1);
        int i1;
        if (hz.c(hz1))
        {
            i1 = 1;
        } else
        {
            i1 = 2;
        }
        o = i1;
        if (hz.c(hz1) && a == gp.d)
        {
            o = o + 2;
        }
        if (hz.c(hz1))
        {
            e.a(7, 0, 0x1000000);
        }
        m = hz.e(hz1);
        if (a == gp.d)
        {
            g = new in();
            r = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), hl.a(String.format("OkHttp %s Push Observer", new Object[] {
                m
            }), true));
            f.a(7, 0, 65535);
            f.a(5, 0, 16384);
        } else
        if (a == gp.c)
        {
            g = new jc();
            r = null;
        } else
        {
            throw new AssertionError(a);
        }
        d = f.d();
        h = hz.f(hz1);
        i = g.a(kz.a(kz.a(hz.f(hz1))), b);
        u = new ia(this, (byte)0);
        (new Thread(u)).start();
    }

    hr(hz hz1, byte byte0)
    {
        this(hz1);
    }

    private id a(List list, boolean flag, boolean flag1)
    {
        flag1 = false;
        if (!flag)
        {
            flag1 = true;
        }
        hq hq1 = i;
        hq1;
        JVM INSTR monitorenter ;
        this;
        JVM INSTR monitorenter ;
        if (p)
        {
            throw new IOException("shutdown");
        }
        break MISSING_BLOCK_LABEL_47;
        list;
        this;
        JVM INSTR monitorexit ;
        throw list;
        list;
        hq1;
        JVM INSTR monitorexit ;
        throw list;
        id id1;
        int i1;
        i1 = o;
        o = o + 2;
        id1 = new id(i1, this, flag1, false, list);
        if (id1.b())
        {
            l.put(Integer.valueOf(i1), id1);
            a(false);
        }
        this;
        JVM INSTR monitorexit ;
        i.a(flag1, false, i1, 0, list);
        hq1;
        JVM INSTR monitorexit ;
        if (!flag)
        {
            i.b();
        }
        return id1;
    }

    static String a(hr hr1)
    {
        return hr1.m;
    }

    private void a(hn hn1, hn hn2)
    {
        int i1;
        i1 = 0;
        if (!w && Thread.holdsLock(this))
        {
            throw new AssertionError();
        }
        Object obj = i;
        obj;
        JVM INSTR monitorenter ;
        this;
        JVM INSTR monitorenter ;
        if (!p) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        obj;
        JVM INSTR monitorexit ;
        hn1 = null;
_L7:
        this;
        JVM INSTR monitorenter ;
        id aid[];
        if (l.isEmpty())
        {
            break MISSING_BLOCK_LABEL_259;
        }
        aid = (id[])l.values().toArray(new id[l.size()]);
        l.clear();
        a(false);
_L10:
        this;
        JVM INSTR monitorexit ;
        obj = hn1;
        if (aid == null) goto _L4; else goto _L3
_L3:
        int j1 = aid.length;
_L6:
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = aid[i1];
        ((id) (obj)).a(hn2);
        obj = hn1;
_L8:
        i1++;
        hn1 = ((hn) (obj));
        if (true) goto _L6; else goto _L5
_L2:
        p = true;
        j1 = n;
        this;
        JVM INSTR monitorexit ;
        i.a(j1, hn1, hl.a);
        obj;
        JVM INSTR monitorexit ;
        hn1 = null;
          goto _L7
        hn1;
        this;
        JVM INSTR monitorexit ;
        throw hn1;
        hn1;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw hn1;
        }
        // Misplaced declaration of an exception variable
        catch (hn hn1) { }
          goto _L7
        hn1;
        this;
        JVM INSTR monitorexit ;
        throw hn1;
        IOException ioexception;
        ioexception;
        obj = hn1;
        if (hn1 != null)
        {
            obj = ioexception;
        }
          goto _L8
_L5:
        obj = hn1;
_L4:
        i.close();
        hn1 = ((hn) (obj));
_L9:
        try
        {
            h.close();
        }
        // Misplaced declaration of an exception variable
        catch (hn hn1) { }
        if (hn1 != null)
        {
            throw hn1;
        } else
        {
            return;
        }
        hn1;
        if (obj != null)
        {
            hn1 = ((hn) (obj));
        }
          goto _L9
        aid = null;
          goto _L10
    }

    static void a(hr hr1, int i1, int j1)
    {
        j.execute(new hu(hr1, "OkHttp %s ping %08x%08x", new Object[] {
            hr1.m, Integer.valueOf(i1), Integer.valueOf(j1)
        }, true, i1, j1, null));
    }

    static void a(hr hr1, int i1, hn hn1)
    {
        hr1.r.execute(new hy(hr1, "OkHttp %s Push Reset[%s]", new Object[] {
            hr1.m, Integer.valueOf(i1)
        }, i1, hn1));
    }

    static void a(hr hr1, int i1, ks ks1, int j1, boolean flag)
    {
        kq kq1 = new kq();
        ks1.a(j1);
        ks1.a(kq1, j1);
        if (kq1.b != (long)j1)
        {
            throw new IOException((new StringBuilder()).append(kq1.b).append(" != ").append(j1).toString());
        } else
        {
            hr1.r.execute(new hx(hr1, "OkHttp %s Push Data[%s]", new Object[] {
                hr1.m, Integer.valueOf(i1)
            }, i1, kq1, j1, flag));
            return;
        }
    }

    static void a(hr hr1, int i1, List list)
    {
        hr1;
        JVM INSTR monitorenter ;
        if (!hr1.v.contains(Integer.valueOf(i1)))
        {
            break MISSING_BLOCK_LABEL_29;
        }
        hr1.a(i1, hn.b);
        hr1;
        JVM INSTR monitorexit ;
        return;
        hr1.v.add(Integer.valueOf(i1));
        hr1;
        JVM INSTR monitorexit ;
        hr1.r.execute(new hv(hr1, "OkHttp %s Push Request[%s]", new Object[] {
            hr1.m, Integer.valueOf(i1)
        }, i1, list));
        return;
        list;
        hr1;
        JVM INSTR monitorexit ;
        throw list;
    }

    static void a(hr hr1, int i1, List list, boolean flag)
    {
        hr1.r.execute(new hw(hr1, "OkHttp %s Push Headers[%s]", new Object[] {
            hr1.m, Integer.valueOf(i1)
        }, i1, list, flag));
    }

    static void a(hr hr1, hn hn1, hn hn2)
    {
        hr1.a(hn1, hn2);
    }

    static void a(hr hr1, boolean flag, int i1, int j1, fn fn1)
    {
        hq hq1 = hr1.i;
        hq1;
        JVM INSTR monitorenter ;
        if (fn1 == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        fn1.a();
        hr1.i.a(flag, i1, j1);
        hq1;
        JVM INSTR monitorexit ;
        return;
        hr1;
        hq1;
        JVM INSTR monitorexit ;
        throw hr1;
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
        q = l1;
        this;
        JVM INSTR monitorexit ;
        return;
        l1 = 0x7fffffffffffffffL;
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    static boolean a(hr hr1, int i1)
    {
        return hr1.a == gp.d && i1 != 0 && (i1 & 1) == 0;
    }

    static int b(hr hr1, int i1)
    {
        hr1.n = i1;
        return i1;
    }

    static boolean b(hr hr1)
    {
        return hr1.p;
    }

    static int c(hr hr1)
    {
        return hr1.n;
    }

    static fn c(hr hr1, int i1)
    {
        return hr1.e();
    }

    static int d(hr hr1)
    {
        return hr1.o;
    }

    static ExecutorService d()
    {
        return j;
    }

    private fn e()
    {
        this;
        JVM INSTR monitorenter ;
        return null;
    }

    static Map e(hr hr1)
    {
        return hr1.l;
    }

    static iu f(hr hr1)
    {
        return hr1.k;
    }

    static boolean g(hr hr1)
    {
        return hr1.t;
    }

    static boolean h(hr hr1)
    {
        hr1.t = true;
        return true;
    }

    static boolean i(hr hr1)
    {
        hr1.p = true;
        return true;
    }

    static iz j(hr hr1)
    {
        return hr1.s;
    }

    static Set k(hr hr1)
    {
        return hr1.v;
    }

    final id a(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        id id1 = (id)l.get(Integer.valueOf(i1));
        this;
        JVM INSTR monitorexit ;
        return id1;
        Exception exception;
        exception;
        throw exception;
    }

    public final id a(List list, boolean flag)
    {
        return a(list, flag, true);
    }

    final void a(int i1, long l1)
    {
        j.execute(new ht(this, "OkHttp Window Update %s stream %d", new Object[] {
            m, Integer.valueOf(i1)
        }, i1, l1));
    }

    final void a(int i1, hn hn1)
    {
        j.submit(new hs(this, "OkHttp %s stream %d", new Object[] {
            m, Integer.valueOf(i1)
        }, i1, hn1));
    }

    public final void a(int i1, boolean flag, kq kq1, long l1)
    {
        long l2 = l1;
        if (l1 != 0L) goto _L2; else goto _L1
_L1:
        i.a(flag, i1, kq1, 0);
_L4:
        return;
_L6:
        int j1;
        j1 = Math.min((int)Math.min(l2, d), i.c());
        d = d - (long)j1;
        this;
        JVM INSTR monitorexit ;
        l2 -= j1;
        hq hq1 = i;
        boolean flag1;
        if (flag && l2 == 0L)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        hq1.a(flag1, i1, kq1, j1);
_L2:
        if (l2 <= 0L) goto _L4; else goto _L3
_L3:
        this;
        JVM INSTR monitorenter ;
_L8:
        if (d > 0L) goto _L6; else goto _L5
_L5:
        if (!l.containsKey(Integer.valueOf(i1)))
        {
            throw new IOException("stream closed");
        }
        break MISSING_BLOCK_LABEL_163;
        kq1;
        throw new InterruptedIOException();
        kq1;
        this;
        JVM INSTR monitorexit ;
        throw kq1;
        wait();
        if (true) goto _L8; else goto _L7
_L7:
          goto _L6
    }

    public final boolean a()
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = q;
        boolean flag;
        if (l1 != 0x7fffffffffffffffL)
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
        long l1 = q;
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    final id b(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        id id1 = (id)l.remove(Integer.valueOf(i1));
        if (id1 == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        if (l.isEmpty())
        {
            a(true);
        }
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return id1;
        Exception exception;
        exception;
        throw exception;
    }

    final void b(int i1, hn hn1)
    {
        i.a(i1, hn1);
    }

    public final void c()
    {
        i.b();
    }

    public final void close()
    {
        a(hn.a, hn.h);
    }

    static 
    {
        boolean flag;
        if (!com/paypal/android/sdk/hr.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        w = flag;
        j = new ThreadPoolExecutor(0, 0x7fffffff, 60L, TimeUnit.SECONDS, new SynchronousQueue(), hl.a("OkHttp FramedConnection", true));
    }
}
