// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a;

import c.d;
import c.e;
import c.m;
import c.r;
import c.s;
import c.t;
import com.g.b.a.c.a;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.g.b.a:
//            k, i, c

public final class com.g.b.a.b
    implements Closeable
{
    public final class a
    {

        final b a;
        final boolean b[];
        boolean c;
        final com.g.b.a.b d;
        private boolean e;

        public final r a(int i1)
        {
            com.g.b.a.b b1 = d;
            b1;
            JVM INSTR monitorenter ;
            if (a.f != this)
            {
                throw new IllegalStateException();
            }
            break MISSING_BLOCK_LABEL_31;
            Object obj;
            obj;
            b1;
            JVM INSTR monitorexit ;
            throw obj;
            Object obj1;
            if (!a.e)
            {
                b[i1] = true;
            }
            obj1 = a.d[i1];
            obj1 = com.g.b.a.b.i(d).b(((File) (obj1)));
            obj1 = new com.g.b.a.c(this, ((r) (obj1))) {

                final a a;

                protected final void a()
                {
                    synchronized (a.d)
                    {
                        a.c = true;
                    }
                    return;
                    exception;
                    b1;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

            
            {
                a = a1;
                super(r1);
            }
            };
            b1;
            JVM INSTR monitorexit ;
            return ((r) (obj1));
            obj1;
            obj1 = com.g.b.a.b.b();
            b1;
            JVM INSTR monitorexit ;
            return ((r) (obj1));
        }

        public final void a()
        {
            com.g.b.a.b b1 = d;
            b1;
            JVM INSTR monitorenter ;
            if (!c)
            {
                break MISSING_BLOCK_LABEL_43;
            }
            com.g.b.a.b.a(d, this, false);
            com.g.b.a.b.a(d, a);
_L2:
            e = true;
            return;
            com.g.b.a.b.a(d, this, true);
            if (true) goto _L2; else goto _L1
_L1:
            Exception exception;
            exception;
            b1;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public final void b()
        {
            synchronized (d)
            {
                com.g.b.a.b.a(d, this, false);
            }
            return;
            exception;
            b1;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private a(b b2)
        {
            d = com.g.b.a.b.this;
            super();
            a = b2;
            if (b2.e)
            {
                b1 = null;
            } else
            {
                b1 = new boolean[com.g.b.a.b.h(com.g.b.a.b.this)];
            }
            b = com.g.b.a.b.this;
        }

        a(b b2, byte byte0)
        {
            this(b2);
        }
    }

    private final class b
    {

        final String a;
        final long b[];
        final File c[];
        final File d[];
        boolean e;
        a f;
        long g;
        final com.g.b.a.b h;

        private static IOException b(String as[])
        {
            throw new IOException((new StringBuilder("unexpected journal line: ")).append(Arrays.toString(as)).toString());
        }

        final c a()
        {
            s as[];
            long al[];
            int i1;
            boolean flag;
            flag = false;
            if (!Thread.holdsLock(h))
            {
                throw new AssertionError();
            }
            as = new s[com.g.b.a.b.h(h)];
            al = (long[])b.clone();
            i1 = 0;
_L2:
            if (i1 >= com.g.b.a.b.h(h))
            {
                break; /* Loop/switch isn't completed */
            }
            as[i1] = com.g.b.a.b.i(h).a(c[i1]);
            i1++;
            if (true) goto _L2; else goto _L1
_L1:
            c c1 = h. new c(a, g, as, al, (byte)0);
            return c1;
_L4:
            for (; i1 < com.g.b.a.b.h(h) && as[i1] != null; i1++)
            {
                com.g.b.a.k.a(as[i1]);
            }

            return null;
            FileNotFoundException filenotfoundexception;
            filenotfoundexception;
            i1 = ((flag) ? 1 : 0);
            if (true) goto _L4; else goto _L3
_L3:
        }

        final void a(d d1)
        {
            long al[] = b;
            int j1 = al.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                long l1 = al[i1];
                d1.h(32).j(l1);
            }

        }

        final void a(String as[])
        {
            if (as.length != com.g.b.a.b.h(h))
            {
                throw b(as);
            }
            int i1 = 0;
            do
            {
                try
                {
                    if (i1 >= as.length)
                    {
                        break;
                    }
                    b[i1] = Long.parseLong(as[i1]);
                }
                catch (NumberFormatException numberformatexception)
                {
                    throw b(as);
                }
                i1++;
            } while (true);
        }

        private b(String s1)
        {
            h = com.g.b.a.b.this;
            super();
            a = s1;
            b = new long[com.g.b.a.b.h(com.g.b.a.b.this)];
            c = new File[com.g.b.a.b.h(com.g.b.a.b.this)];
            d = new File[com.g.b.a.b.h(com.g.b.a.b.this)];
            s1 = (new StringBuilder(s1)).append('.');
            int j1 = s1.length();
            for (int i1 = 0; i1 < com.g.b.a.b.h(com.g.b.a.b.this); i1++)
            {
                s1.append(i1);
                c[i1] = new File(com.g.b.a.b.j(com.g.b.a.b.this), s1.toString());
                s1.append(".tmp");
                d[i1] = new File(com.g.b.a.b.j(com.g.b.a.b.this), s1.toString());
                s1.setLength(j1);
            }

        }

        b(String s1, byte byte0)
        {
            this(s1);
        }
    }

    public final class c
        implements Closeable
    {

        public final String a;
        public final long b;
        public final s c[];
        public final com.g.b.a.b d;
        private final long e[];

        public final void close()
        {
            s as[] = c;
            int j1 = as.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                com.g.b.a.k.a(as[i1]);
            }

        }

        private c(String s1, long l1, s as[], long al[])
        {
            d = com.g.b.a.b.this;
            super();
            a = s1;
            b = l1;
            c = as;
            e = al;
        }

        c(String s1, long l1, s as[], long al[], byte byte0)
        {
            this(s1, l1, as, al);
        }
    }


    static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
    static final boolean b;
    private static final r u = new r() {

        public final void a_(c.c c1, long l1)
        {
            c1.f(l1);
        }

        public final void close()
        {
        }

        public final void flush()
        {
        }

        public final t w_()
        {
            return t.b;
        }

    };
    private final com.g.b.a.c.a c;
    private final File d;
    private final File e;
    private final File f;
    private final File g;
    private final int h = 0x31191;
    private long i;
    private final int j = 2;
    private long k;
    private d l;
    private final LinkedHashMap m = new LinkedHashMap(0, 0.75F, true);
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    private long r;
    private final Executor s;
    private final Runnable t = new Runnable() {

        final com.g.b.a.b a;

        public final void run()
        {
            com.g.b.a.b b1 = a;
            b1;
            JVM INSTR monitorenter ;
            boolean flag;
            if (!com.g.b.a.b.a(a))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!(flag | com.g.b.a.b.b(a)))
            {
                break MISSING_BLOCK_LABEL_39;
            }
            b1;
            JVM INSTR monitorexit ;
            return;
            com.g.b.a.b.c(a);
            if (com.g.b.a.b.d(a))
            {
                com.g.b.a.b.e(a);
                com.g.b.a.b.f(a);
            }
            b1;
            JVM INSTR monitorexit ;
            return;
            Object obj;
            obj;
            b1;
            JVM INSTR monitorexit ;
            throw obj;
            obj;
            throw new RuntimeException(((Throwable) (obj)));
        }

            
            {
                a = com.g.b.a.b.this;
                super();
            }
    };

    private com.g.b.a.b(com.g.b.a.c.a a1, File file, long l1, Executor executor)
    {
        k = 0L;
        r = 0L;
        c = a1;
        d = file;
        e = new File(file, "journal");
        f = new File(file, "journal.tmp");
        g = new File(file, "journal.bkp");
        i = l1;
        s = executor;
    }

    public static a a(com.g.b.a.b b1, String s1, long l1)
    {
        return b1.a(s1, l1);
    }

    public static com.g.b.a.b a(com.g.b.a.c.a a1, File file, long l1)
    {
        if (l1 <= 0L)
        {
            throw new IllegalArgumentException("maxSize <= 0");
        } else
        {
            return new com.g.b.a.b(a1, file, l1, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.g.b.a.k.c("OkHttp DiskLruCache")));
        }
    }

    private void a(a a1, boolean flag)
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        b b1;
        b1 = a1.a;
        if (b1.f != a1)
        {
            throw new IllegalStateException();
        }
        break MISSING_BLOCK_LABEL_31;
        a1;
        this;
        JVM INSTR monitorexit ;
        throw a1;
        int j1 = ((flag1) ? 1 : 0);
        if (!flag) goto _L2; else goto _L1
_L1:
        j1 = ((flag1) ? 1 : 0);
        if (b1.e) goto _L2; else goto _L3
_L3:
        int i1 = 0;
_L7:
        j1 = ((flag1) ? 1 : 0);
        if (i1 >= j) goto _L2; else goto _L4
_L4:
        if (!a1.b[i1])
        {
            a1.b();
            throw new IllegalStateException((new StringBuilder("Newly created entry didn't create value for index ")).append(i1).toString());
        }
        if (c.e(b1.d[i1])) goto _L6; else goto _L5
_L5:
        a1.b();
_L8:
        this;
        JVM INSTR monitorexit ;
        return;
_L6:
        i1++;
          goto _L7
_L2:
        File file;
        long l1;
        long l2;
        for (; j1 >= j; j1++)
        {
            break MISSING_BLOCK_LABEL_256;
        }

        a1 = b1.d[j1];
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_243;
        }
        if (c.e(a1))
        {
            file = b1.c[j1];
            c.a(a1, file);
            l1 = b1.b[j1];
            l2 = c.f(file);
            b1.b[j1] = l2;
            k = (k - l1) + l2;
        }
        break MISSING_BLOCK_LABEL_467;
        c.d(a1);
        break MISSING_BLOCK_LABEL_467;
        n = n + 1;
        b1.f = null;
        if (!(b1.e | flag))
        {
            break MISSING_BLOCK_LABEL_406;
        }
        b1.e = true;
        l.b("CLEAN").h(32);
        l.b(b1.a);
        b1.a(l);
        l.h(10);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_362;
        }
        l1 = r;
        r = 1L + l1;
        b1.g = l1;
_L9:
        l.flush();
        if (k > i || h())
        {
            s.execute(t);
        }
          goto _L8
        m.remove(b1.a);
        l.b("REMOVE").h(32);
        l.b(b1.a);
        l.h(10);
          goto _L9
    }

    static void a(com.g.b.a.b b1, a a1, boolean flag)
    {
        b1.a(a1, flag);
    }

    private boolean a(b b1)
    {
        if (b1.f != null)
        {
            b1.f.c = true;
        }
        for (int i1 = 0; i1 < j; i1++)
        {
            c.d(b1.c[i1]);
            k = k - b1.b[i1];
            b1.b[i1] = 0L;
        }

        n = n + 1;
        l.b("REMOVE").h(32).b(b1.a).h(10);
        m.remove(b1.a);
        if (h())
        {
            s.execute(t);
        }
        return true;
    }

    static boolean a(com.g.b.a.b b1)
    {
        return b1.p;
    }

    static boolean a(com.g.b.a.b b1, b b2)
    {
        return b1.a(b2);
    }

    static r b()
    {
        return u;
    }

    static boolean b(com.g.b.a.b b1)
    {
        return b1.q;
    }

    private void c()
    {
        if (!b && !Thread.holdsLock(this))
        {
            throw new AssertionError();
        }
        if (p)
        {
            return;
        }
        if (c.e(g))
        {
            if (c.e(e))
            {
                c.d(g);
            } else
            {
                c.a(g, e);
            }
        }
        if (c.e(e))
        {
            try
            {
                d();
                f();
                p = true;
                return;
            }
            catch (IOException ioexception)
            {
                com.g.b.a.i.a();
                com.g.b.a.i.a((new StringBuilder("DiskLruCache ")).append(d).append(" is corrupt: ").append(ioexception.getMessage()).append(", removing").toString());
                close();
                c.g(d);
                q = false;
            }
        }
        g();
        p = true;
    }

    static void c(com.g.b.a.b b1)
    {
        b1.k();
    }

    private static void c(String s1)
    {
        if (!a.matcher(s1).matches())
        {
            throw new IllegalArgumentException((new StringBuilder("keys must match regex [a-z0-9_-]{1,120}: \"")).append(s1).append("\"").toString());
        } else
        {
            return;
        }
    }

    private void d()
    {
        e e1 = c.m.a(c.a(e));
        Exception exception;
        String s1 = e1.p();
        String s3 = e1.p();
        String s4 = e1.p();
        String s5 = e1.p();
        String s7 = e1.p();
        if (!"libcore.io.DiskLruCache".equals(s1) || !"1".equals(s3) || !Integer.toString(h).equals(s4) || !Integer.toString(j).equals(s5) || !"".equals(s7))
        {
            throw new IOException((new StringBuilder("unexpected journal header: [")).append(s1).append(", ").append(s3).append(", ").append(s5).append(", ").append(s7).append("]").toString());
        }
        int i1 = 0;
_L8:
        String s6;
        int j1;
        s6 = e1.p();
        j1 = s6.indexOf(' ');
        if (j1 != -1) goto _L2; else goto _L1
_L1:
        try
        {
            throw new IOException((new StringBuilder("unexpected journal line: ")).append(s6).toString());
        }
        catch (EOFException eofexception) { }
        finally
        {
            com.g.b.a.k.a(e1);
            throw exception;
        }
        n = i1 - m.size();
        if (e1.e()) goto _L4; else goto _L3
_L3:
        g();
_L6:
        com.g.b.a.k.a(e1);
        return;
_L2:
        int k1 = j1 + 1;
        int l1 = s6.indexOf(' ', k1);
        if (l1 != -1)
        {
            break MISSING_BLOCK_LABEL_340;
        }
        String s2 = s6.substring(k1);
        if (j1 != 6)
        {
            break MISSING_BLOCK_LABEL_350;
        }
        if (s6.startsWith("REMOVE"))
        {
            m.remove(s2);
            break; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_350;
        s2 = s6.substring(k1, l1);
        b b2 = (b)m.get(s2);
        b b1;
        b1 = b2;
        if (b2 != null)
        {
            break MISSING_BLOCK_LABEL_389;
        }
        b1 = new b(s2, (byte)0);
        m.put(s2, b1);
        if (l1 == -1 || j1 != 5)
        {
            break MISSING_BLOCK_LABEL_445;
        }
        if (s6.startsWith("CLEAN"))
        {
            String as[] = s6.substring(l1 + 1).split(" ");
            b1.e = true;
            b1.f = null;
            b1.a(as);
            break; /* Loop/switch isn't completed */
        }
        if (l1 != -1 || j1 != 5)
        {
            break MISSING_BLOCK_LABEL_485;
        }
        if (s6.startsWith("DIRTY"))
        {
            b1.f = new a(b1, (byte)0);
            break; /* Loop/switch isn't completed */
        }
        if (l1 != -1 || j1 != 4)
        {
            break MISSING_BLOCK_LABEL_508;
        }
        if (s6.startsWith("READ"))
        {
            break; /* Loop/switch isn't completed */
        }
        throw new IOException((new StringBuilder("unexpected journal line: ")).append(s6).toString());
_L4:
        l = e();
        if (true) goto _L6; else goto _L5
_L5:
        i1++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    static boolean d(com.g.b.a.b b1)
    {
        return b1.h();
    }

    private d e()
    {
        return c.m.a(new com.g.b.a.c(c.c(e)) {

            static final boolean a;
            final com.g.b.a.b b;

            protected final void a()
            {
                if (!a && !Thread.holdsLock(b))
                {
                    throw new AssertionError();
                } else
                {
                    com.g.b.a.b.g(b);
                    return;
                }
            }

            static 
            {
                boolean flag;
                if (!com/g/b/a/b.desiredAssertionStatus())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                a = flag;
            }

            
            {
                b = com.g.b.a.b.this;
                super(r1);
            }
        });
    }

    static void e(com.g.b.a.b b1)
    {
        b1.g();
    }

    static int f(com.g.b.a.b b1)
    {
        b1.n = 0;
        return 0;
    }

    private void f()
    {
        c.d(f);
        for (Iterator iterator = m.values().iterator(); iterator.hasNext();)
        {
            b b1 = (b)iterator.next();
            if (b1.f == null)
            {
                int i1 = 0;
                while (i1 < j) 
                {
                    k = k + b1.b[i1];
                    i1++;
                }
            } else
            {
                b1.f = null;
                for (int j1 = 0; j1 < j; j1++)
                {
                    c.d(b1.c[j1]);
                    c.d(b1.d[j1]);
                }

                iterator.remove();
            }
        }

    }

    private void g()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        if (l != null)
        {
            l.close();
        }
        obj = c.m.a(c.b(f));
        Iterator iterator;
        ((d) (obj)).b("libcore.io.DiskLruCache").h(10);
        ((d) (obj)).b("1").h(10);
        ((d) (obj)).j(h).h(10);
        ((d) (obj)).j(j).h(10);
        ((d) (obj)).h(10);
        iterator = m.values().iterator();
_L1:
        b b1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_253;
            }
            b1 = (b)iterator.next();
            if (b1.f == null)
            {
                break MISSING_BLOCK_LABEL_209;
            }
            ((d) (obj)).b("DIRTY").h(32);
            ((d) (obj)).b(b1.a);
            ((d) (obj)).h(10);
        } while (true);
        Exception exception;
        exception;
        ((d) (obj)).close();
        throw exception;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        ((d) (obj)).b("CLEAN").h(32);
        ((d) (obj)).b(b1.a);
        b1.a(((d) (obj)));
        ((d) (obj)).h(10);
          goto _L1
        ((d) (obj)).close();
        if (c.e(e))
        {
            c.a(e, g);
        }
        c.a(f, e);
        c.d(g);
        l = e();
        o = false;
        this;
        JVM INSTR monitorexit ;
    }

    static boolean g(com.g.b.a.b b1)
    {
        b1.o = true;
        return true;
    }

    static int h(com.g.b.a.b b1)
    {
        return b1.j;
    }

    private boolean h()
    {
        return n >= 2000 && n >= m.size();
    }

    static com.g.b.a.c.a i(com.g.b.a.b b1)
    {
        return b1.c;
    }

    private boolean i()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = q;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    static File j(com.g.b.a.b b1)
    {
        return b1.d;
    }

    private void j()
    {
        this;
        JVM INSTR monitorenter ;
        if (i())
        {
            throw new IllegalStateException("cache is closed");
        }
        break MISSING_BLOCK_LABEL_25;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    private void k()
    {
        while (k > i) 
        {
            a((b)m.values().iterator().next());
        }
    }

    public final a a(String s1, long l1)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        c();
        j();
        c(s1);
        obj = (b)m.get(s1);
        if (l1 == -1L) goto _L2; else goto _L1
_L1:
        if (obj == null) goto _L4; else goto _L3
_L3:
        long l2 = ((b) (obj)).g;
        if (l2 == l1) goto _L2; else goto _L4
_L4:
        s1 = null;
_L5:
        this;
        JVM INSTR monitorexit ;
        return s1;
_L2:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        if (((b) (obj)).f == null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        s1 = null;
          goto _L5
        l.b("DIRTY").h(32).b(s1).h(10);
        l.flush();
        if (!o)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        s1 = null;
          goto _L5
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_192;
        }
        obj = new b(s1, (byte)0);
        m.put(s1, obj);
        s1 = ((String) (obj));
_L6:
        obj = new a(s1, (byte)0);
        s1.f = ((a) (obj));
        s1 = ((String) (obj));
          goto _L5
        s1;
        throw s1;
        s1 = ((String) (obj));
          goto _L6
    }

    public final c a(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        c();
        j();
        c(s1);
        obj = (b)m.get(s1);
        if (obj == null) goto _L2; else goto _L1
_L1:
        boolean flag = ((b) (obj)).e;
        if (flag) goto _L3; else goto _L2
_L2:
        s1 = null;
_L5:
        this;
        JVM INSTR monitorexit ;
        return s1;
_L3:
        obj = ((b) (obj)).a();
        if (obj == null)
        {
            s1 = null;
            continue; /* Loop/switch isn't completed */
        }
        n = n + 1;
        l.b("READ").h(32).b(s1).h(10);
        s1 = ((String) (obj));
        if (!h())
        {
            continue; /* Loop/switch isn't completed */
        }
        s.execute(t);
        s1 = ((String) (obj));
        if (true) goto _L5; else goto _L4
_L4:
        s1;
        throw s1;
    }

    public final void a()
    {
        this;
        JVM INSTR monitorenter ;
        b ab[];
        int j1;
        c();
        ab = (b[])m.values().toArray(new b[m.size()]);
        j1 = ab.length;
        int i1 = 0;
_L2:
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        a(ab[i1]);
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean b(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        c();
        j();
        c(s1);
        s1 = (b)m.get(s1);
        if (s1 != null) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = a(s1);
        if (true) goto _L4; else goto _L3
_L3:
        s1;
        throw s1;
    }

    public final void close()
    {
        this;
        JVM INSTR monitorenter ;
        if (p && !q) goto _L2; else goto _L1
_L1:
        q = true;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        b ab[];
        int j1;
        ab = (b[])m.values().toArray(new b[m.size()]);
        j1 = ab.length;
        Exception exception;
        b b1;
        for (int i1 = 0; i1 >= j1; i1++)
        {
            break MISSING_BLOCK_LABEL_83;
        }

        b1 = ab[i1];
        if (b1.f != null)
        {
            b1.f.b();
        }
        break MISSING_BLOCK_LABEL_114;
        k();
        l.close();
        l = null;
        q = true;
        if (true) goto _L4; else goto _L3
_L3:
        exception;
        throw exception;
    }

    static 
    {
        boolean flag;
        if (!com/g/b/a/b.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b = flag;
    }
}
