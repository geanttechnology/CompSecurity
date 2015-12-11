// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.IOException;

// Referenced classes of package com.tapjoy.internal:
//            ds, gt, do, du, 
//            dq, dp, dz, dm, 
//            dr

public static final class <init> extends ds
    implements <init>
{
    public static final class a extends ds.a
        implements gt.b
    {

        private int b;
        private Object c;
        private int d;
        private Object e;
        private Object f;
        private Object g;

        static a i()
        {
            return new a();
        }

        private a j()
        {
            return (new a()).a(e());
        }

        public final dl.a a()
        {
            return j();
        }

        public final a a(int i1)
        {
            b = b | 2;
            d = i1;
            return this;
        }

        public final a a(gt.a a1)
        {
            if (a1 == gt.a.c())
            {
                return this;
            }
            if (a1.e())
            {
                b = b | 1;
                c = gt.a.b(a1);
            }
            if (a1.g())
            {
                a(a1.h());
            }
            if (a1.i())
            {
                b = b | 4;
                e = gt.a.c(a1);
            }
            if (a1.k())
            {
                b = b | 8;
                f = gt.a.d(a1);
            }
            if (a1.m())
            {
                b = b | 0x10;
                g = gt.a.e(a1);
            }
            super.a = super.a.a(gt.a.f(a1));
            return this;
        }

        public final a a(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                b = b | 1;
                c = s1;
                return this;
            }
        }

        public final ds.a b()
        {
            return j();
        }

        public final a b(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                b = b | 4;
                e = s1;
                return this;
            }
        }

        public final a c(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                b = b | 8;
                f = s1;
                return this;
            }
        }

        public final Object clone()
        {
            return j();
        }

        public final a d(String s1)
        {
            if (s1 == null)
            {
                throw new NullPointerException();
            } else
            {
                b = b | 0x10;
                g = s1;
                return this;
            }
        }

        public final boolean d()
        {
            return true;
        }

        public final gt.a e()
        {
            int j1 = 1;
            gt.a a1 = new gt.a(this, (byte)0);
            int k1 = b;
            int i1;
            if ((k1 & 1) != 1)
            {
                j1 = 0;
            }
            gt.a.a(a1, c);
            i1 = j1;
            if ((k1 & 2) == 2)
            {
                i1 = j1 | 2;
            }
            gt.a.a(a1, d);
            j1 = i1;
            if ((k1 & 4) == 4)
            {
                j1 = i1 | 4;
            }
            gt.a.b(a1, e);
            i1 = j1;
            if ((k1 & 8) == 8)
            {
                i1 = j1 | 8;
            }
            gt.a.c(a1, f);
            j1 = i1;
            if ((k1 & 0x10) == 16)
            {
                j1 = i1 | 0x10;
            }
            gt.a.d(a1, g);
            gt.a.b(a1, j1);
            return a1;
        }

        public final boolean f()
        {
            return (b & 4) == 4;
        }

        public final String g()
        {
            Object obj = e;
            if (!(obj instanceof String))
            {
                obj = (do)obj;
                String s1 = ((do) (obj)).f();
                if (((do) (obj)).g())
                {
                    e = s1;
                }
                return s1;
            } else
            {
                return (String)obj;
            }
        }

        public final a h()
        {
            b = b & -5;
            e = gt.a.c().j();
            return this;
        }

        private a()
        {
            c = "";
            e = "";
            f = "";
            g = "";
        }
    }


    public static dz b = new dm() {

        public final Object a(dp dp1, dr dr)
        {
            return new gt.a(dp1, (byte)0);
        }

    };
    private static final <init> c;
    private final do d;
    private int e;
    private Object f;
    private int g;
    private Object h;
    private Object i;
    private Object j;
    private byte k;
    private int l;

    static int a(j j1, int i1)
    {
        j1.g = i1;
        return i1;
    }

    public static a a(g g1)
    {
        return a.i().a(g1);
    }

    static Object a(a.a a1, Object obj)
    {
        a1.f = obj;
        return obj;
    }

    static int b(f f1, int i1)
    {
        f1.e = i1;
        return i1;
    }

    static Object b(e e1)
    {
        return e1.f;
    }

    static Object b(f f1, Object obj)
    {
        f1.h = obj;
        return obj;
    }

    public static h c()
    {
        return c;
    }

    static Object c(c c1)
    {
        return c1.h;
    }

    static Object c(h h1, Object obj)
    {
        h1.i = obj;
        return obj;
    }

    static Object d(i i1)
    {
        return i1.i;
    }

    static Object d(i i1, Object obj)
    {
        i1.j = obj;
        return obj;
    }

    static Object e(j j1)
    {
        return j1.j;
    }

    static do f(j j1)
    {
        return j1.d;
    }

    public static a o()
    {
        return a.i();
    }

    private do q()
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

    private do r()
    {
        Object obj = h;
        if (obj instanceof String)
        {
            obj = com.tapjoy.internal.do.a((String)obj);
            h = obj;
            return ((do) (obj));
        } else
        {
            return (do)obj;
        }
    }

    private do s()
    {
        Object obj = i;
        if (obj instanceof String)
        {
            obj = com.tapjoy.internal.do.a((String)obj);
            i = obj;
            return ((do) (obj));
        } else
        {
            return (do)obj;
        }
    }

    private do t()
    {
        Object obj = j;
        if (obj instanceof String)
        {
            obj = com.tapjoy.internal.do.a((String)obj);
            j = obj;
            return ((do) (obj));
        } else
        {
            return (do)obj;
        }
    }

    private void u()
    {
        f = "";
        g = 0;
        h = "";
        i = "";
        j = "";
    }

    public final void a(dq dq1)
    {
        b();
        if ((e & 1) == 1)
        {
            dq1.a(1, q());
        }
        if ((e & 2) == 2)
        {
            dq1.a(2, g);
        }
        if ((e & 4) == 4)
        {
            dq1.a(3, r());
        }
        if ((e & 8) == 8)
        {
            dq1.a(4, s());
        }
        if ((e & 0x10) == 16)
        {
            dq1.a(5, t());
        }
        dq1.b(d);
    }

    public final int b()
    {
        int i1 = l;
        if (i1 != -1)
        {
            return i1;
        }
        int j1 = 0;
        if ((e & 1) == 1)
        {
            j1 = dq.b(1, q()) + 0;
        }
        i1 = j1;
        if ((e & 2) == 2)
        {
            i1 = j1 + dq.b(2, g);
        }
        j1 = i1;
        if ((e & 4) == 4)
        {
            j1 = i1 + dq.b(3, r());
        }
        i1 = j1;
        if ((e & 8) == 8)
        {
            i1 = j1 + dq.b(4, s());
        }
        j1 = i1;
        if ((e & 0x10) == 16)
        {
            j1 = i1 + dq.b(5, t());
        }
        i1 = j1 + d.a();
        l = i1;
        return i1;
    }

    public final boolean d()
    {
        byte byte0 = k;
        if (byte0 == 1)
        {
            return true;
        }
        if (byte0 == 0)
        {
            return false;
        } else
        {
            k = 1;
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
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (i())
            {
                if (flag && j().equals(((j) (obj)).j()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && k() == ((k) (obj)).k())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (k())
            {
                if (flag && l().equals(((l) (obj)).l()))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }
            if (flag1 && m() == ((m) (obj)).m())
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (m())
            {
                if (!flag2 || !n().equals(((n) (obj)).n()))
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
        String s1 = ((do) (obj)).f();
        if (((do) (obj)).g())
        {
            f = s1;
        }
        return s1;
    }

    public final boolean g()
    {
        return (e & 2) == 2;
    }

    public final int h()
    {
        return g;
    }

    public final int hashCode()
    {
        if (a != 0)
        {
            return a;
        }
        int j1 = com/tapjoy/internal/gt$a.hashCode() + 779;
        int i1 = j1;
        if (e())
        {
            i1 = (j1 * 37 + 1) * 53 + f().hashCode();
        }
        j1 = i1;
        if (g())
        {
            j1 = (i1 * 37 + 2) * 53 + g;
        }
        i1 = j1;
        if (i())
        {
            i1 = (j1 * 37 + 3) * 53 + j().hashCode();
        }
        j1 = i1;
        if (k())
        {
            j1 = (i1 * 37 + 4) * 53 + l().hashCode();
        }
        i1 = j1;
        if (m())
        {
            i1 = (j1 * 37 + 5) * 53 + n().hashCode();
        }
        i1 = i1 * 29 + d.hashCode();
        a = i1;
        return i1;
    }

    public final boolean i()
    {
        return (e & 4) == 4;
    }

    public final String j()
    {
        Object obj = h;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (do)obj;
        String s1 = ((do) (obj)).f();
        if (((do) (obj)).g())
        {
            h = s1;
        }
        return s1;
    }

    public final boolean k()
    {
        return (e & 8) == 8;
    }

    public final String l()
    {
        Object obj = i;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (do)obj;
        String s1 = ((do) (obj)).f();
        if (((do) (obj)).g())
        {
            i = s1;
        }
        return s1;
    }

    public final boolean m()
    {
        return (e & 0x10) == 16;
    }

    public final String n()
    {
        Object obj = j;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (do)obj;
        String s1 = ((do) (obj)).f();
        if (((do) (obj)).g())
        {
            j = s1;
        }
        return s1;
    }

    public final a p()
    {
        return a.i().a(this);
    }

    static 
    {
        a.a a1 = new <init>();
        c = a1;
        a1.u();
    }

    private _cls1()
    {
        k = -1;
        l = -1;
        d = do.a;
    }

    private d(dp dp1)
    {
        d d1;
        dq dq1;
        boolean flag;
        k = -1;
        l = -1;
        u();
        d1 = com.tapjoy.internal.do.h();
        dq1 = dq.a(d1, 4096);
        flag = false;
_L13:
        if (flag) goto _L2; else goto _L1
_L1:
        int i1 = dp1.a();
        i1;
        JVM INSTR lookupswitch 6: default 339
    //                   0: 342
    //                   10: 120
    //                   16: 167
    //                   26: 205
    //                   34: 230
    //                   42: 256;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9
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
_L11:
        throw dp1;
_L6:
        e = e | 2;
        g = dp1.e();
        continue; /* Loop/switch isn't completed */
        dp1;
        throw (new du(dp1.getMessage())).a(this);
_L7:
        do do2 = dp1.d();
        e = e | 4;
        h = do2;
        continue; /* Loop/switch isn't completed */
_L8:
        do do3 = dp1.d();
        e = e | 8;
        i = do3;
        continue; /* Loop/switch isn't completed */
_L9:
        do do4 = dp1.d();
        e = e | 0x10;
        j = do4;
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
        if (true) goto _L11; else goto _L10
_L10:
        dp1;
        d = d1.a();
        throw dp1;
_L4:
        flag = true;
        if (true) goto _L13; else goto _L12
_L12:
    }

    a(dp dp1, byte byte0)
    {
        this(dp1);
    }

    private <init>(<init> <init>1)
    {
        super((byte)0);
        k = -1;
        l = -1;
        d = <init>1.c();
    }

    c(c c1, byte byte0)
    {
        this(c1);
    }
}
