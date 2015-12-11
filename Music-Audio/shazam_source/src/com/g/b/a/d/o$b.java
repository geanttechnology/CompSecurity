// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.d;

import c.e;
import c.m;
import com.g.b.a.d;
import com.g.b.a.f;
import com.g.b.a.k;
import com.g.b.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.g.b.a.d:
//            o, a, q, b, 
//            p, k, m, e, 
//            i, c

final class <init> extends f
    implements <init>
{

    b b;
    final o c;

    protected final void a()
    {
        Object obj;
        a a1;
        Object obj2;
        a a2;
        obj2 = a.g;
        a2 = a.g;
        a1 = ((a) (obj2));
        obj = obj2;
        b = c.g.a(m.a(m.b(c.h)), c.b);
        a1 = ((a) (obj2));
        obj = obj2;
        if (c.b)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        a1 = ((a) (obj2));
        obj = obj2;
        b.a();
_L2:
        a1 = ((a) (obj2));
        obj = obj2;
        if (b.a(this)) goto _L2; else goto _L1
_L1:
        a1 = ((a) (obj2));
        obj = obj2;
        obj2 = a.a;
        a1 = ((a) (obj2));
        obj = obj2;
        a a3 = a.l;
        IOException ioexception;
        Object obj1;
        try
        {
            o.a(c, ((a) (obj2)), a3);
        }
        catch (IOException ioexception1) { }
        k.a(b);
        return;
        obj;
        obj = a1;
        obj2 = a.b;
        obj = a.b;
        try
        {
            o.a(c, ((a) (obj2)), ((a) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception) { }
        k.a(b);
        return;
        obj1;
        obj2 = obj;
        obj = obj1;
_L4:
        try
        {
            o.a(c, ((a) (obj2)), a2);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1) { }
        k.a(b);
        throw obj;
        obj;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(int i, long l)
    {
        if (i == 0)
        {
            synchronized (c)
            {
                o o2 = c;
                o2.d = o2.d + l;
                c.notifyAll();
            }
            return;
        }
        break MISSING_BLOCK_LABEL_50;
        exception;
        o1;
        JVM INSTR monitorexit ;
        throw exception;
        p p1;
        p1 = c.a(i);
        if (p1 == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        p1;
        JVM INSTR monitorenter ;
        p1.a(l);
        p1;
        JVM INSTR monitorexit ;
        return;
        Exception exception1;
        exception1;
        p1;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    public final void a(int i, c.f f1)
    {
        f1 = f1.c;
        p ap[];
        synchronized (c)
        {
            ap = (p[])com.g.b.a.d.o.e(c).values().toArray(new p[com.g.b.a.d.o.e(c).size()]);
            o.i(c);
        }
        int l = ap.length;
        for (int j = 0; j < l; j++)
        {
            f1 = ap[j];
            if (((p) (f1)).c > i && f1.b())
            {
                f1.c(com.g.b.a.d.a.k);
                c.b(((p) (f1)).c);
            }
        }

        break MISSING_BLOCK_LABEL_125;
        exception;
        f1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void a(int i, a a1)
    {
        if (o.a(c, i))
        {
            o.a(c, i, a1);
        } else
        {
            p p1 = c.b(i);
            if (p1 != null)
            {
                p1.c(a1);
                return;
            }
        }
    }

    public final void a(int i, List list)
    {
        o.a(c, i, list);
    }

    public final void a(boolean flag, int i, int j)
    {
        if (flag)
        {
            com.g.b.a.d.k k1 = o.c(c, i);
            if (k1 != null)
            {
                if (k1.c != -1L || k1.b == -1L)
                {
                    throw new IllegalStateException();
                }
                k1.c = System.nanoTime();
                k1.a.countDown();
            }
            return;
        } else
        {
            o.a(c, i, j);
            return;
        }
    }

    public final void a(boolean flag, int i, e e1, int j)
    {
        if (o.a(c, i))
        {
            o.a(c, i, e1, j, flag);
        } else
        {
            p p1 = c.a(i);
            if (p1 == null)
            {
                c.a(i, a.c);
                e1.f(j);
                return;
            }
            if (!p.i && Thread.holdsLock(p1))
            {
                throw new AssertionError();
            }
            p1.f.a(e1, j);
            if (flag)
            {
                p1.e();
                return;
            }
        }
    }

    public final void a(boolean flag, com.g.b.a.d.m m1)
    {
        o1 = c;
        o1;
        JVM INSTR monitorenter ;
        int j = c.f.b();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        com.g.b.a.d.m m2 = c.f;
        m2.c = 0;
        m2.b = 0;
        m2.a = 0;
        Arrays.fill(m2.d, 0);
        com.g.b.a.d.m m3 = c.f;
        int i = 0;
_L5:
        if (i >= 10)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        if (m1.a(i))
        {
            m3.a(i, m1.b(i), m1.d[i]);
        }
        break MISSING_BLOCK_LABEL_362;
        if (c.a == u.d)
        {
            com.g.b.a.d.o.d().execute(new f("OkHttp %s ACK Settings", new Object[] {
                o.a(c)
            }, m1) {

                final com.g.b.a.d.m b;
                final o.b c;

                public final void a()
                {
                    try
                    {
                        c.c.i.a(b);
                        return;
                    }
                    catch (IOException ioexception)
                    {
                        return;
                    }
                }

            transient 
            {
                c = o.b.this;
                b = m1;
                super(s, aobj);
            }
            });
        }
        i = c.f.b();
        long l1;
        if (i == -1 || i == j)
        {
            break MISSING_BLOCK_LABEL_354;
        }
        l1 = i - j;
        if (o.g(c))
        {
            break MISSING_BLOCK_LABEL_236;
        }
        m1 = c;
        m1.d = ((o) (m1)).d + l1;
        if (l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_228;
        }
        m1.notifyAll();
        o.h(c);
        if (com.g.b.a.d.o.e(c).isEmpty()) goto _L2; else goto _L1
_L1:
        m1 = (p[])com.g.b.a.d.o.e(c).values().toArray(new p[com.g.b.a.d.o.e(c).size()]);
_L3:
        o1;
        JVM INSTR monitorexit ;
        if (m1 != null && l1 != 0L)
        {
            int l = m1.length;
            for (i = 0; i < l; i++)
            {
                synchronized (m1[i])
                {
                    o1.a(l1);
                }
            }

        }
        break MISSING_BLOCK_LABEL_348;
        m1;
        o1;
        JVM INSTR monitorexit ;
        throw m1;
        m1;
        o1;
        JVM INSTR monitorexit ;
        throw m1;
        return;
_L2:
        m1 = null;
          goto _L3
        m1 = null;
        l1 = 0L;
          goto _L3
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final void a(boolean flag, boolean flag1, int i, List list, com.g.b.a.d.e e1)
    {
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        flag3 = false;
        flag4 = false;
        flag2 = false;
        flag5 = true;
        if (!o.a(c, i)) goto _L2; else goto _L1
_L1:
        o.a(c, i, list, flag1);
_L8:
        return;
_L2:
        synchronized (c)
        {
            if (!o.b(c))
            {
                break MISSING_BLOCK_LABEL_66;
            }
        }
        return;
        list;
        o1;
        JVM INSTR monitorexit ;
        throw list;
        p p1 = c.a(i);
        if (p1 != null)
        {
            break MISSING_BLOCK_LABEL_246;
        }
        Object obj;
        if (e1 == e.b || e1 == e.c)
        {
            flag2 = true;
        }
        if (!flag2)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        c.a(i, a.c);
        o1;
        JVM INSTR monitorexit ;
        return;
        if (i > o.c(c))
        {
            break MISSING_BLOCK_LABEL_135;
        }
        o1;
        JVM INSTR monitorexit ;
        return;
        if (i % 2 != com.g.b.a.d.o.d(c) % 2)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        o1;
        JVM INSTR monitorexit ;
        return;
        list = new p(i, c, flag, flag1, list);
        o.b(c, i);
        com.g.b.a.d.o.e(c).put(Integer.valueOf(i), list);
        com.g.b.a.d.o.d().execute(new f("OkHttp %s stream %d", new Object[] {
            o.a(c), Integer.valueOf(i)
        }, list) {

            final p b;
            final o.b c;

            public final void a()
            {
                try
                {
                    com.g.b.a.d.o.f(c.c).a(b);
                    return;
                }
                catch (IOException ioexception)
                {
                    d.a.log(Level.INFO, (new StringBuilder("StreamHandler failure for ")).append(o.a(c.c)).toString(), ioexception);
                }
                try
                {
                    b.a(a.b);
                    return;
                }
                catch (IOException ioexception1)
                {
                    return;
                }
            }

            transient 
            {
                c = o.b.this;
                b = p1;
                super(s, aobj);
            }
        });
        o1;
        JVM INSTR monitorexit ;
        return;
        o1;
        JVM INSTR monitorexit ;
        if (e1 == e.a)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag2)
        {
            p1.b(a.b);
            c.b(i);
            return;
        }
        if (!p.i && Thread.holdsLock(p1))
        {
            throw new AssertionError();
        }
        obj = null;
        p1;
        JVM INSTR monitorenter ;
        if (p1.e != null) goto _L4; else goto _L3
_L3:
        i = ((flag3) ? 1 : 0);
        if (e1 == e.c)
        {
            i = 1;
        }
        if (i == 0) goto _L6; else goto _L5
_L5:
        list = a.b;
        flag = flag5;
_L9:
        p1;
        JVM INSTR monitorexit ;
        if (list != null)
        {
            p1.b(list);
        } else
        if (!flag)
        {
            p1.d.b(p1.c);
        }
        if (!flag1) goto _L8; else goto _L7
_L7:
        p1.e();
        return;
_L6:
        p1.e = list;
        flag = p1.a();
        p1.notifyAll();
        list = obj;
          goto _L9
        list;
        p1;
        JVM INSTR monitorexit ;
        throw list;
_L4:
        i = ((flag4) ? 1 : 0);
        if (e1 == e.b)
        {
            i = 1;
        }
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_436;
        }
        list = com.g.b.a.d.a.e;
        flag = flag5;
          goto _L9
        e1 = new ArrayList();
        e1.addAll(p1.e);
        e1.addAll(list);
        p1.e = e1;
        flag = flag5;
        list = obj;
          goto _L9
    }

    private (o o1)
    {
        c = o1;
        super("OkHttp %s", new Object[] {
            o.a(o1)
        });
    }

    (o o1, byte byte0)
    {
        this(o1);
    }
}
