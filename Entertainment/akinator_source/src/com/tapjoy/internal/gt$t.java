// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.IOException;

// Referenced classes of package com.tapjoy.internal:
//            ds, gt, do, du, 
//            dq, dp, dt, dz, 
//            ec, dm, dr

public static final class <init> extends ds
    implements <init>
{
    public static final class a extends ds.a
        implements gt.w
    {

        private int b;
        private Object c;
        private long d;
        private long e;

        static a f()
        {
            return new a();
        }

        private a g()
        {
            return (new a()).a(h());
        }

        private gt.t h()
        {
            int j1 = 1;
            gt.t t1 = new gt.t(this, (byte)0);
            int k1 = b;
            int i1;
            if ((k1 & 1) != 1)
            {
                j1 = 0;
            }
            gt.t.a(t1, c);
            i1 = j1;
            if ((k1 & 2) == 2)
            {
                i1 = j1 | 2;
            }
            gt.t.a(t1, d);
            j1 = i1;
            if ((k1 & 4) == 4)
            {
                j1 = i1 | 4;
            }
            gt.t.b(t1, e);
            gt.t.a(t1, j1);
            return t1;
        }

        public final dl.a a()
        {
            return g();
        }

        public final a a(long l1)
        {
            b = b | 2;
            d = l1;
            return this;
        }

        public final a a(gt.t t1)
        {
            if (t1 == gt.t.c())
            {
                return this;
            }
            if (t1.e())
            {
                b = b | 1;
                c = gt.t.b(t1);
            }
            if (t1.g())
            {
                a(t1.h());
            }
            if (t1.i())
            {
                b(t1.j());
            }
            super.a = super.a.a(gt.t.c(t1));
            return this;
        }

        public final a a(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                b = b | 1;
                c = s;
                return this;
            }
        }

        public final ds.a b()
        {
            return g();
        }

        public final a b(long l1)
        {
            b = b | 4;
            e = l1;
            return this;
        }

        public final Object clone()
        {
            return g();
        }

        public final boolean d()
        {
            boolean flag;
            if ((b & 1) == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                boolean flag1;
                if ((b & 2) == 2)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag1)
                {
                    return true;
                }
            }
            return false;
        }

        public final gt.t e()
        {
            gt.t t1 = h();
            if (!t1.d())
            {
                throw new ec();
            } else
            {
                return t1;
            }
        }

        private a()
        {
            c = "";
        }
    }


    public static dz b = new dm() {

        public final Object a(dp dp1, dr dr)
        {
            return new gt.t(dp1, (byte)0);
        }

    };
    private static final <init> c;
    private final do d;
    private int e;
    private Object f;
    private long g;
    private long h;
    private byte i;
    private int j;

    static int a(nit> nit>, int i1)
    {
        nit>.e = i1;
        return i1;
    }

    static long a(e e1, long l1)
    {
        e1.g = l1;
        return l1;
    }

    public static a a(g g1)
    {
        return a.f().a(g1);
    }

    static Object a(a.a a1, Object obj)
    {
        a1.f = obj;
        return obj;
    }

    static long b(f f1, long l1)
    {
        f1.h = l1;
        return l1;
    }

    static Object b(h h1)
    {
        return h1.f;
    }

    static do c(f f1)
    {
        return f1.d;
    }

    public static d c()
    {
        return c;
    }

    public static a k()
    {
        return a.f();
    }

    private do l()
    {
        Object obj = f;
        if (obj instanceof String)
        {
            obj = com.tapjoy.internal.do.a((String)obj);
            f = obj;
            return ((do) (obj));
        } else
        {
            return (do)obj;
        }
    }

    private void m()
    {
        f = "";
        g = 0L;
        h = 0L;
    }

    public final void a(dq dq1)
    {
        b();
        if ((e & 1) == 1)
        {
            dq1.a(1, l());
        }
        if ((e & 2) == 2)
        {
            dq1.a(2, g);
        }
        if ((e & 4) == 4)
        {
            dq1.a(3, h);
        }
        dq1.b(d);
    }

    public final int b()
    {
        int i1 = j;
        if (i1 != -1)
        {
            return i1;
        }
        int j1 = 0;
        if ((e & 1) == 1)
        {
            j1 = dq.b(1, l()) + 0;
        }
        i1 = j1;
        if ((e & 2) == 2)
        {
            i1 = j1 + dq.b(2, g);
        }
        j1 = i1;
        if ((e & 4) == 4)
        {
            j1 = i1 + dq.b(3, h);
        }
        i1 = j1 + d.a();
        j = i1;
        return i1;
    }

    public final boolean d()
    {
        byte byte0 = i;
        if (byte0 == 1)
        {
            return true;
        }
        if (byte0 == 0)
        {
            return false;
        }
        if (!e())
        {
            i = 0;
            return false;
        }
        if (!g())
        {
            i = 0;
            return false;
        } else
        {
            i = 1;
            return true;
        }
    }

    public final boolean e()
    {
        return (e & 1) == 1;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof e))
            {
                return super.equals(obj);
            }
            obj = (e)obj;
            boolean flag;
            boolean flag1;
            boolean flag2;
            if (e() == ((e) (obj)).e())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (e())
            {
                if (flag && f().equals(((f) (obj)).f()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && g() == ((g) (obj)).g())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (g())
            {
                if (flag && g == ((g) (obj)).g)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && i() == ((i) (obj)).i())
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (i())
            {
                if (!flag2 || h != ((h) (obj)).h)
                {
                    return false;
                }
            } else
            {
                return flag2;
            }
        }
        return true;
    }

    public final String f()
    {
        Object obj = f;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (do)obj;
        String s = ((do) (obj)).f();
        if (((do) (obj)).g())
        {
            f = s;
        }
        return s;
    }

    public final boolean g()
    {
        return (e & 2) == 2;
    }

    public final long h()
    {
        return g;
    }

    public final int hashCode()
    {
        if (a != 0)
        {
            return a;
        }
        int j1 = com/tapjoy/internal/gt$t.hashCode() + 779;
        int i1 = j1;
        if (e())
        {
            i1 = (j1 * 37 + 1) * 53 + f().hashCode();
        }
        j1 = i1;
        if (g())
        {
            j1 = (i1 * 37 + 2) * 53 + dt.a(g);
        }
        i1 = j1;
        if (i())
        {
            i1 = (j1 * 37 + 3) * 53 + dt.a(h);
        }
        i1 = i1 * 29 + d.hashCode();
        a = i1;
        return i1;
    }

    public final boolean i()
    {
        return (e & 4) == 4;
    }

    public final long j()
    {
        return h;
    }

    static 
    {
        h h1 = new <init>();
        c = h1;
        h1.m();
    }

    private _cls1()
    {
        i = -1;
        j = -1;
        d = do.a;
    }

    private d(dp dp1)
    {
        d d1;
        dq dq1;
        boolean flag;
        i = -1;
        j = -1;
        m();
        d1 = com.tapjoy.internal.do.h();
        dq1 = dq.a(d1, 4096);
        flag = false;
_L11:
        if (flag) goto _L2; else goto _L1
_L1:
        int i1 = dp1.a();
        i1;
        JVM INSTR lookupswitch 4: default 267
    //                   0: 270
    //                   10: 104
    //                   16: 151
    //                   24: 189;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        if (!dp1.a(i1, dq1))
        {
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        do do1 = dp1.d();
        e = e | 1;
        f = do1;
        continue; /* Loop/switch isn't completed */
        dp1;
        throw dp1.a(this);
        dp1;
        dq1.a();
        d = d1.a();
_L9:
        throw dp1;
_L6:
        e = e | 2;
        g = dp1.f();
        continue; /* Loop/switch isn't completed */
        dp1;
        throw (new du(dp1.getMessage())).a(this);
_L7:
        e = e | 4;
        h = dp1.f();
        continue; /* Loop/switch isn't completed */
_L2:
        try
        {
            dq1.a();
        }
        // Misplaced declaration of an exception variable
        catch (dp dp1)
        {
            d = d1.a();
            return;
        }
        finally
        {
            d = d1.a();
        }
        d = d1.a();
        return;
        throw dp1;
        IOException ioexception;
        ioexception;
        d = d1.a();
        if (true) goto _L9; else goto _L8
_L8:
        dp1;
        d = d1.a();
        throw dp1;
_L4:
        flag = true;
        if (true) goto _L11; else goto _L10
_L10:
    }

    a(dp dp1, byte byte0)
    {
        this(dp1);
    }

    private <init>(<init> <init>1)
    {
        super((byte)0);
        i = -1;
        j = -1;
        d = <init>1.c();
    }

    c(c c1, byte byte0)
    {
        this(c1);
    }
}
