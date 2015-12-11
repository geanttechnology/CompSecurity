// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.d;

import c.c;
import c.e;
import c.m;
import com.g.b.a.d;
import com.g.b.a.f;
import com.g.b.a.k;
import com.g.b.u;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.g.b.a.d:
//            m, g, q, n, 
//            p, k, c, a, 
//            i, l, b, e

public final class o
    implements Closeable
{
    public static final class a
    {

        String a;
        Socket b;
        i c;
        public u d;
        l e;
        boolean f;

        public a(String s1, Socket socket)
        {
            c = i.a;
            d = u.c;
            e = l.a;
            a = s1;
            f = true;
            b = socket;
        }
    }

    final class b extends f
        implements b.a
    {

        com.g.b.a.d.b b;
        final o c;

        protected final void a()
        {
            Object obj;
            com.g.b.a.d.a a1;
            Object obj2;
            com.g.b.a.d.a a2;
            obj2 = com.g.b.a.d.a.g;
            a2 = com.g.b.a.d.a.g;
            a1 = ((com.g.b.a.d.a) (obj2));
            obj = obj2;
            b = c.g.a(c.m.a(c.m.b(c.h)), c.b);
            a1 = ((com.g.b.a.d.a) (obj2));
            obj = obj2;
            if (c.b)
            {
                break MISSING_BLOCK_LABEL_76;
            }
            a1 = ((com.g.b.a.d.a) (obj2));
            obj = obj2;
            b.a();
_L2:
            a1 = ((com.g.b.a.d.a) (obj2));
            obj = obj2;
            if (b.a(this)) goto _L2; else goto _L1
_L1:
            a1 = ((com.g.b.a.d.a) (obj2));
            obj = obj2;
            obj2 = com.g.b.a.d.a.a;
            a1 = ((com.g.b.a.d.a) (obj2));
            obj = obj2;
            com.g.b.a.d.a a3 = com.g.b.a.d.a.l;
            IOException ioexception;
            Object obj1;
            try
            {
                o.a(c, ((com.g.b.a.d.a) (obj2)), a3);
            }
            catch (IOException ioexception1) { }
            com.g.b.a.k.a(b);
            return;
            obj;
            obj = a1;
            obj2 = com.g.b.a.d.a.b;
            obj = com.g.b.a.d.a.b;
            try
            {
                o.a(c, ((com.g.b.a.d.a) (obj2)), ((com.g.b.a.d.a) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception) { }
            com.g.b.a.k.a(b);
            return;
            obj1;
            obj2 = obj;
            obj = obj1;
_L4:
            try
            {
                o.a(c, ((com.g.b.a.d.a) (obj2)), a2);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1) { }
            com.g.b.a.k.a(b);
            throw obj;
            obj;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public final void a(int i1, long l1)
        {
            if (i1 == 0)
            {
                synchronized (c)
                {
                    o o2 = c;
                    o2.d = o2.d + l1;
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
            p1 = c.a(i1);
            if (p1 == null)
            {
                break MISSING_BLOCK_LABEL_86;
            }
            p1;
            JVM INSTR monitorenter ;
            p1.a(l1);
            p1;
            JVM INSTR monitorexit ;
            return;
            Exception exception1;
            exception1;
            p1;
            JVM INSTR monitorexit ;
            throw exception1;
        }

        public final void a(int i1, c.f f1)
        {
            f1 = f1.c;
            p ap[];
            synchronized (c)
            {
                ap = (p[])com.g.b.a.d.o.e(c).values().toArray(new p[com.g.b.a.d.o.e(c).size()]);
                o.i(c);
            }
            int k1 = ap.length;
            for (int j1 = 0; j1 < k1; j1++)
            {
                f1 = ap[j1];
                if (((p) (f1)).c > i1 && f1.b())
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

        public final void a(int i1, com.g.b.a.d.a a1)
        {
            if (o.a(c, i1))
            {
                o.a(c, i1, a1);
            } else
            {
                p p1 = c.b(i1);
                if (p1 != null)
                {
                    p1.c(a1);
                    return;
                }
            }
        }

        public final void a(int i1, List list)
        {
            o.a(c, i1, list);
        }

        public final void a(boolean flag, int i1, int j1)
        {
            if (flag)
            {
                com.g.b.a.d.k k1 = com.g.b.a.d.o.c(c, i1);
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
                o.a(c, i1, j1);
                return;
            }
        }

        public final void a(boolean flag, int i1, e e1, int j1)
        {
            if (o.a(c, i1))
            {
                o.a(c, i1, e1, j1, flag);
            } else
            {
                p p1 = c.a(i1);
                if (p1 == null)
                {
                    c.a(i1, com.g.b.a.d.a.c);
                    e1.f(j1);
                    return;
                }
                if (!p.i && Thread.holdsLock(p1))
                {
                    throw new AssertionError();
                }
                p1.f.a(e1, j1);
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
            int j1 = c.f.b();
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
            int i1 = 0;
_L5:
            if (i1 >= 10)
            {
                break MISSING_BLOCK_LABEL_111;
            }
            if (m1.a(i1))
            {
                m3.a(i1, m1.b(i1), m1.d[i1]);
            }
            break MISSING_BLOCK_LABEL_362;
            if (c.a == u.d)
            {
                com.g.b.a.d.o.d().execute(new f(this, "OkHttp %s ACK Settings", new Object[] {
                    o.a(c)
                }, m1) {

                    final com.g.b.a.d.m b;
                    final b c;

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
                c = b1;
                b = m1;
                super(s1, aobj);
            }
                });
            }
            i1 = c.f.b();
            long l1;
            if (i1 == -1 || i1 == j1)
            {
                break MISSING_BLOCK_LABEL_354;
            }
            l1 = i1 - j1;
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
                int k1 = m1.length;
                for (i1 = 0; i1 < k1; i1++)
                {
                    synchronized (m1[i1])
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
            i1++;
            if (true) goto _L5; else goto _L4
_L4:
        }

        public final void a(boolean flag, boolean flag1, int i1, List list, com.g.b.a.d.e e1)
        {
            boolean flag2;
            boolean flag3;
            boolean flag4;
            boolean flag5;
            flag3 = false;
            flag4 = false;
            flag2 = false;
            flag5 = true;
            if (!o.a(c, i1)) goto _L2; else goto _L1
_L1:
            o.a(c, i1, list, flag1);
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
            p p1 = c.a(i1);
            if (p1 != null)
            {
                break MISSING_BLOCK_LABEL_246;
            }
            Object obj;
            if (e1 == e.b || e1 == com.g.b.a.d.e.c)
            {
                flag2 = true;
            }
            if (!flag2)
            {
                break MISSING_BLOCK_LABEL_120;
            }
            c.a(i1, com.g.b.a.d.a.c);
            o1;
            JVM INSTR monitorexit ;
            return;
            if (i1 > com.g.b.a.d.o.c(c))
            {
                break MISSING_BLOCK_LABEL_135;
            }
            o1;
            JVM INSTR monitorexit ;
            return;
            if (i1 % 2 != com.g.b.a.d.o.d(c) % 2)
            {
                break MISSING_BLOCK_LABEL_154;
            }
            o1;
            JVM INSTR monitorexit ;
            return;
            list = new p(i1, c, flag, flag1, list);
            o.b(c, i1);
            com.g.b.a.d.o.e(c).put(Integer.valueOf(i1), list);
            com.g.b.a.d.o.d().execute(new f(this, "OkHttp %s stream %d", new Object[] {
                o.a(c), Integer.valueOf(i1)
            }, list) {

                final p b;
                final b c;

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
                        b.a(com.g.b.a.d.a.b);
                        return;
                    }
                    catch (IOException ioexception1)
                    {
                        return;
                    }
                }

            transient 
            {
                c = b1;
                b = p1;
                super(s1, aobj);
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
                p1.b(com.g.b.a.d.a.b);
                c.b(i1);
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
            i1 = ((flag3) ? 1 : 0);
            if (e1 == com.g.b.a.d.e.c)
            {
                i1 = 1;
            }
            if (i1 == 0) goto _L6; else goto _L5
_L5:
            list = com.g.b.a.d.a.b;
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
            i1 = ((flag4) ? 1 : 0);
            if (e1 == e.b)
            {
                i1 = 1;
            }
            if (i1 == 0)
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

        private b()
        {
            c = o.this;
            super("OkHttp %s", new Object[] {
                o.a(o.this)
            });
        }

        b(byte byte0)
        {
            this();
        }
    }


    static final boolean k;
    private static final ExecutorService l;
    public final u a;
    final boolean b;
    long c;
    long d;
    public final com.g.b.a.d.m e;
    final com.g.b.a.d.m f;
    final q g;
    final Socket h;
    public final com.g.b.a.d.c i;
    final b j;
    private final i m;
    private final Map n;
    private final String o;
    private int p;
    private int q;
    private boolean r;
    private long s;
    private final ExecutorService t;
    private Map u;
    private final l v;
    private int w;
    private boolean x;
    private final Set y;

    private o(a a1)
    {
        byte byte0 = 2;
        super();
        n = new HashMap();
        s = System.nanoTime();
        c = 0L;
        e = new com.g.b.a.d.m();
        f = new com.g.b.a.d.m();
        x = false;
        y = new LinkedHashSet();
        a = a1.d;
        v = a1.e;
        b = a1.f;
        m = a1.c;
        int i1;
        if (a1.f)
        {
            i1 = 1;
        } else
        {
            i1 = 2;
        }
        q = i1;
        if (a1.f && a == u.d)
        {
            q = q + 2;
        }
        i1 = byte0;
        if (a1.f)
        {
            i1 = 1;
        }
        w = i1;
        if (a1.f)
        {
            e.a(7, 0, 0x1000000);
        }
        o = a1.a;
        if (a == u.d)
        {
            g = new g();
            t = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.g.b.a.k.c(String.format("OkHttp %s Push Observer", new Object[] {
                o
            })));
            f.a(7, 0, 65535);
            f.a(5, 0, 16384);
        } else
        if (a == u.c)
        {
            g = new n();
            t = null;
        } else
        {
            throw new AssertionError(a);
        }
        d = f.b();
        h = a1.b;
        i = g.a(c.m.a(c.m.a(a1.b)), b);
        j = new b((byte)0);
        (new Thread(j)).start();
    }

    public o(a a1, byte byte0)
    {
        this(a1);
    }

    static String a(o o1)
    {
        return o1.o;
    }

    private void a(com.g.b.a.d.a a1, com.g.b.a.d.a a2)
    {
        if (!k && Thread.holdsLock(this))
        {
            throw new AssertionError();
        }
        Object obj = i;
        obj;
        JVM INSTR monitorenter ;
        this;
        JVM INSTR monitorenter ;
        if (!r) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        obj;
        JVM INSTR monitorexit ;
        a1 = null;
_L9:
        this;
        JVM INSTR monitorenter ;
        p ap[];
        if (n.isEmpty())
        {
            break MISSING_BLOCK_LABEL_390;
        }
        ap = (p[])n.values().toArray(new p[n.size()]);
        n.clear();
        a(false);
_L13:
        if (u == null) goto _L4; else goto _L3
_L3:
        com.g.b.a.d.k ak[];
        ak = (com.g.b.a.d.k[])u.values().toArray(new com.g.b.a.d.k[u.size()]);
        u = null;
_L12:
        this;
        JVM INSTR monitorexit ;
        obj = a1;
        if (ap == null) goto _L6; else goto _L5
_L5:
        int i1;
        int k1;
        k1 = ap.length;
        i1 = 0;
_L8:
        if (i1 >= k1)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = ap[i1];
        ((p) (obj)).a(a2);
        obj = a1;
_L10:
        i1++;
        a1 = ((com.g.b.a.d.a) (obj));
        if (true) goto _L8; else goto _L7
_L2:
        r = true;
        i1 = p;
        this;
        JVM INSTR monitorexit ;
        i.a(i1, a1, k.a);
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
        catch (com.g.b.a.d.a a1) { }
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
        if (ak != null)
        {
            int l1 = ak.length;
            for (int j1 = 0; j1 < l1; j1++)
            {
                a1 = ak[j1];
                if (((com.g.b.a.d.k) (a1)).c != -1L || ((com.g.b.a.d.k) (a1)).b == -1L)
                {
                    throw new IllegalStateException();
                }
                a1.c = ((com.g.b.a.d.k) (a1)).b - 1L;
                ((com.g.b.a.d.k) (a1)).a.countDown();
            }

        }
        i.close();
        a1 = ((com.g.b.a.d.a) (obj));
_L11:
        try
        {
            h.close();
        }
        // Misplaced declaration of an exception variable
        catch (com.g.b.a.d.a a1) { }
        if (a1 != null)
        {
            throw a1;
        } else
        {
            return;
        }
        a1;
        if (obj != null)
        {
            a1 = ((com.g.b.a.d.a) (obj));
        }
          goto _L11
_L4:
        ak = null;
          goto _L12
        ap = null;
          goto _L13
    }

    static void a(o o1, int i1, int j1)
    {
        l.execute(o1. new f("OkHttp %s ping %08x%08x", new Object[] {
            o1.o, Integer.valueOf(i1), Integer.valueOf(j1)
        }, i1, j1) {

            final boolean b = true;
            final int c;
            final int d;
            final com.g.b.a.d.k e = null;
            final o f;

            public final void a()
            {
                try
                {
                    o.a(f, b, c, d, e);
                    return;
                }
                catch (IOException ioexception)
                {
                    return;
                }
            }

            transient 
            {
                f = o.this;
                c = i1;
                d = j1;
                super(s1, aobj);
            }
        });
    }

    static void a(o o1, int i1, e e1, int j1, boolean flag)
    {
        c c1 = new c();
        e1.a(j1);
        e1.a(c1, j1);
        if (c1.b != (long)j1)
        {
            throw new IOException((new StringBuilder()).append(c1.b).append(" != ").append(j1).toString());
        } else
        {
            o1.t.execute(o1. new f("OkHttp %s Push Data[%s]", new Object[] {
                o1.o, Integer.valueOf(i1)
            }, i1, c1, j1, flag) {

                final int b;
                final c c;
                final int d;
                final boolean e;
                final o f;

                public final void a()
                {
                    o.j(f).a(c, d);
                    f.i.a(b, com.g.b.a.d.a.l);
                    synchronized (f)
                    {
                        com.g.b.a.d.o.k(f).remove(Integer.valueOf(b));
                    }
                    return;
                    exception;
                    o2;
                    JVM INSTR monitorexit ;
                    try
                    {
                        throw exception;
                    }
                    catch (IOException ioexception)
                    {
                        return;
                    }
                }

            transient 
            {
                f = o.this;
                b = i1;
                c = c1;
                d = j1;
                e = flag;
                super(s1, aobj);
            }
            });
            return;
        }
    }

    static void a(o o1, int i1, com.g.b.a.d.a a1)
    {
        o1.t.execute(o1. new f("OkHttp %s Push Reset[%s]", new Object[] {
            o1.o, Integer.valueOf(i1)
        }, i1, a1) {

            final int b;
            final com.g.b.a.d.a c;
            final o d;

            public final void a()
            {
                o.j(d).c();
                synchronized (d)
                {
                    com.g.b.a.d.o.k(d).remove(Integer.valueOf(b));
                }
                return;
                exception;
                o2;
                JVM INSTR monitorexit ;
                throw exception;
            }

            transient 
            {
                d = o.this;
                b = i1;
                c = a1;
                super(s1, aobj);
            }
        });
    }

    static void a(o o1, int i1, List list)
    {
        o1;
        JVM INSTR monitorenter ;
        if (!o1.y.contains(Integer.valueOf(i1)))
        {
            break MISSING_BLOCK_LABEL_29;
        }
        o1.a(i1, com.g.b.a.d.a.b);
        o1;
        JVM INSTR monitorexit ;
        return;
        o1.y.add(Integer.valueOf(i1));
        o1;
        JVM INSTR monitorexit ;
        o1.t.execute(o1. new f("OkHttp %s Push Request[%s]", new Object[] {
            o1.o, Integer.valueOf(i1)
        }, i1, list) {

            final int b;
            final List c;
            final o d;

            public final void a()
            {
                o.j(d).a();
                d.i.a(b, com.g.b.a.d.a.l);
                synchronized (d)
                {
                    com.g.b.a.d.o.k(d).remove(Integer.valueOf(b));
                }
                return;
                exception;
                o2;
                JVM INSTR monitorexit ;
                try
                {
                    throw exception;
                }
                catch (IOException ioexception)
                {
                    return;
                }
            }

            transient 
            {
                d = o.this;
                b = i1;
                c = list;
                super(s1, aobj);
            }
        });
        return;
        list;
        o1;
        JVM INSTR monitorexit ;
        throw list;
    }

    static void a(o o1, int i1, List list, boolean flag)
    {
        o1.t.execute(o1. new f("OkHttp %s Push Headers[%s]", new Object[] {
            o1.o, Integer.valueOf(i1)
        }, i1, list, flag) {

            final int b;
            final List c;
            final boolean d;
            final o e;

            public final void a()
            {
                o.j(e).b();
                e.i.a(b, com.g.b.a.d.a.l);
                synchronized (e)
                {
                    com.g.b.a.d.o.k(e).remove(Integer.valueOf(b));
                }
                return;
                exception;
                o2;
                JVM INSTR monitorexit ;
                try
                {
                    throw exception;
                }
                catch (IOException ioexception)
                {
                    return;
                }
            }

            transient 
            {
                e = o.this;
                b = i1;
                c = list;
                d = flag;
                super(s1, aobj);
            }
        });
    }

    static void a(o o1, com.g.b.a.d.a a1, com.g.b.a.d.a a2)
    {
        o1.a(a1, a2);
    }

    static void a(o o1, boolean flag, int i1, int j1, com.g.b.a.d.k k1)
    {
        com.g.b.a.d.c c1 = o1.i;
        c1;
        JVM INSTR monitorenter ;
        if (k1 == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        if (k1.b != -1L)
        {
            throw new IllegalStateException();
        }
        break MISSING_BLOCK_LABEL_40;
        o1;
        c1;
        JVM INSTR monitorexit ;
        throw o1;
        k1.b = System.nanoTime();
        o1.i.a(flag, i1, j1);
        c1;
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
        s = l1;
        this;
        JVM INSTR monitorexit ;
        return;
        l1 = 0x7fffffffffffffffL;
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    static boolean a(o o1, int i1)
    {
        return o1.a == u.d && i1 != 0 && (i1 & 1) == 0;
    }

    static int b(o o1, int i1)
    {
        o1.p = i1;
        return i1;
    }

    static boolean b(o o1)
    {
        return o1.r;
    }

    static int c(o o1)
    {
        return o1.p;
    }

    private com.g.b.a.d.k c(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        if (u == null) goto _L2; else goto _L1
_L1:
        com.g.b.a.d.k k1 = (com.g.b.a.d.k)u.remove(Integer.valueOf(i1));
_L4:
        this;
        JVM INSTR monitorexit ;
        return k1;
_L2:
        k1 = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    static com.g.b.a.d.k c(o o1, int i1)
    {
        return o1.c(i1);
    }

    static int d(o o1)
    {
        return o1.q;
    }

    static ExecutorService d()
    {
        return l;
    }

    static Map e(o o1)
    {
        return o1.n;
    }

    static i f(o o1)
    {
        return o1.m;
    }

    static boolean g(o o1)
    {
        return o1.x;
    }

    static boolean h(o o1)
    {
        o1.x = true;
        return true;
    }

    static boolean i(o o1)
    {
        o1.r = true;
        return true;
    }

    static l j(o o1)
    {
        return o1.v;
    }

    static Set k(o o1)
    {
        return o1.y;
    }

    final p a(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        p p1 = (p)n.get(Integer.valueOf(i1));
        this;
        JVM INSTR monitorexit ;
        return p1;
        Exception exception;
        exception;
        throw exception;
    }

    public final p a(List list, boolean flag)
    {
        boolean flag1;
        flag1 = false;
        if (!flag)
        {
            flag1 = true;
        }
        com.g.b.a.d.c c1 = i;
        c1;
        JVM INSTR monitorenter ;
        this;
        JVM INSTR monitorenter ;
        if (r)
        {
            throw new IOException("shutdown");
        }
        break MISSING_BLOCK_LABEL_47;
        list;
        this;
        JVM INSTR monitorexit ;
        throw list;
        list;
        c1;
        JVM INSTR monitorexit ;
        throw list;
        p p1;
        int i1;
        i1 = q;
        q = q + 2;
        p1 = new p(i1, this, flag1, false, list);
        if (p1.a())
        {
            n.put(Integer.valueOf(i1), p1);
            a(false);
        }
        this;
        JVM INSTR monitorexit ;
        i.a(flag1, i1, list);
        c1;
        JVM INSTR monitorexit ;
        if (!flag)
        {
            i.b();
        }
        return p1;
    }

    final void a(int i1, long l1)
    {
        l.execute(new f("OkHttp Window Update %s stream %d", new Object[] {
            o, Integer.valueOf(i1)
        }, i1, l1) {

            final int b;
            final long c;
            final o d;

            public final void a()
            {
                try
                {
                    d.i.a(b, c);
                    return;
                }
                catch (IOException ioexception)
                {
                    return;
                }
            }

            transient 
            {
                d = o.this;
                b = i1;
                c = l1;
                super(s1, aobj);
            }
        });
    }

    final void a(int i1, com.g.b.a.d.a a1)
    {
        l.submit(new f("OkHttp %s stream %d", new Object[] {
            o, Integer.valueOf(i1)
        }, i1, a1) {

            final int b;
            final com.g.b.a.d.a c;
            final o d;

            public final void a()
            {
                try
                {
                    d.b(b, c);
                    return;
                }
                catch (IOException ioexception)
                {
                    return;
                }
            }

            transient 
            {
                d = o.this;
                b = i1;
                c = a1;
                super(s1, aobj);
            }
        });
    }

    public final void a(int i1, boolean flag, c c1, long l1)
    {
        long l2 = l1;
        if (l1 != 0L) goto _L2; else goto _L1
_L1:
        i.a(flag, i1, c1, 0);
_L4:
        return;
_L6:
        int j1;
        j1 = Math.min((int)Math.min(l2, d), i.c());
        d = d - (long)j1;
        this;
        JVM INSTR monitorexit ;
        l2 -= j1;
        com.g.b.a.d.c c2 = i;
        boolean flag1;
        if (flag && l2 == 0L)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        c2.a(flag1, i1, c1, j1);
_L2:
        if (l2 <= 0L) goto _L4; else goto _L3
_L3:
        this;
        JVM INSTR monitorenter ;
_L8:
        if (d > 0L) goto _L6; else goto _L5
_L5:
        if (!n.containsKey(Integer.valueOf(i1)))
        {
            throw new IOException("stream closed");
        }
        break MISSING_BLOCK_LABEL_163;
        c1;
        throw new InterruptedIOException();
        c1;
        this;
        JVM INSTR monitorexit ;
        throw c1;
        wait();
        if (true) goto _L8; else goto _L7
_L7:
          goto _L6
    }

    public final boolean a()
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = s;
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
        long l1 = s;
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    final p b(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        p p1 = (p)n.remove(Integer.valueOf(i1));
        if (p1 == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        if (n.isEmpty())
        {
            a(true);
        }
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return p1;
        Exception exception;
        exception;
        throw exception;
    }

    final void b(int i1, com.g.b.a.d.a a1)
    {
        i.a(i1, a1);
    }

    public final void c()
    {
        i.b();
    }

    public final void close()
    {
        a(com.g.b.a.d.a.a, com.g.b.a.d.a.l);
    }

    static 
    {
        boolean flag;
        if (!com/g/b/a/d/o.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        k = flag;
        l = new ThreadPoolExecutor(0, 0x7fffffff, 60L, TimeUnit.SECONDS, new SynchronousQueue(), com.g.b.a.k.c("OkHttp SpdyConnection"));
    }
}
