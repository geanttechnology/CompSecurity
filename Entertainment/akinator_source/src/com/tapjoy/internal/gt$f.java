// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.IOException;

// Referenced classes of package com.tapjoy.internal:
//            ds, gt, do, du, 
//            dq, dp, dt, dz, 
//            dm, dr

public static final class <init> extends ds
    implements <init>
{
    public static final class a extends ds.a
        implements gt.g
    {

        private int b;
        private gt.i c;
        private Object d;
        private Object e;

        static a g()
        {
            return new a();
        }

        private a h()
        {
            return (new a()).a(e());
        }

        public final dl.a a()
        {
            return h();
        }

        public final a a(gt.f f1)
        {
            if (f1 == gt.f.c())
            {
                return this;
            }
            if (f1.e())
            {
                a(f1.f());
            }
            if (f1.g())
            {
                b = b | 2;
                d = gt.f.b(f1);
            }
            if (f1.i())
            {
                b = b | 4;
                e = gt.f.c(f1);
            }
            super.a = super.a.a(gt.f.d(f1));
            return this;
        }

        public final a a(gt.i i1)
        {
            if (i1 == null)
            {
                throw new NullPointerException();
            } else
            {
                b = b | 1;
                c = i1;
                return this;
            }
        }

        public final a a(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                b = b | 2;
                d = s;
                return this;
            }
        }

        public final ds.a b()
        {
            return h();
        }

        public final a b(String s)
        {
            if (s == null)
            {
                throw new NullPointerException();
            } else
            {
                b = b | 4;
                e = s;
                return this;
            }
        }

        public final Object clone()
        {
            return h();
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

        public final gt.f e()
        {
            int j1 = 1;
            gt.f f1 = new gt.f(this, (byte)0);
            int k1 = b;
            int i1;
            if ((k1 & 1) != 1)
            {
                j1 = 0;
            }
            gt.f.a(f1, c);
            i1 = j1;
            if ((k1 & 2) == 2)
            {
                i1 = j1 | 2;
            }
            gt.f.a(f1, d);
            j1 = i1;
            if ((k1 & 4) == 4)
            {
                j1 = i1 | 4;
            }
            gt.f.b(f1, e);
            gt.f.a(f1, j1);
            return f1;
        }

        public final a f()
        {
            b = b & -5;
            e = gt.f.c().j();
            return this;
        }

        private a()
        {
            c = gt.i.a;
            d = "";
            e = "";
        }
    }


    public static dz b = new dm() {

        public final Object a(dp dp1, dr dr)
        {
            return new gt.f(dp1, (byte)0);
        }

    };
    private static final <init> c;
    private final do d;
    private int e;
    private <init> f;
    private Object g;
    private Object h;
    private byte i;
    private int j;

    static int a(j j1, int i1)
    {
        j1.e = i1;
        return i1;
    }

    public static a a(e e1)
    {
        return a.g().a(e1);
    }

    static a.a a(a.a a1, a.a a2)
    {
        a1.f = a2;
        return a2;
    }

    static Object a(f f1, Object obj)
    {
        f1.g = obj;
        return obj;
    }

    static Object b(g g1)
    {
        return g1.g;
    }

    static Object b(g g1, Object obj)
    {
        g1.h = obj;
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

    static do d(h h1)
    {
        return h1.d;
    }

    public static a k()
    {
        return a.g();
    }

    private do m()
    {
        Object obj = g;
        if (obj instanceof String)
        {
            obj = com.tapjoy.internal.do.a((String)obj);
            g = obj;
            return ((do) (obj));
        } else
        {
            return (do)obj;
        }
    }

    private do n()
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

    private void o()
    {
        f = a;
        g = "";
        h = "";
    }

    public final void a(dq dq1)
    {
        b();
        if ((e & 1) == 1)
        {
            dq1.a(f.a());
        }
        if ((e & 2) == 2)
        {
            dq1.a(2, m());
        }
        if ((e & 4) == 4)
        {
            dq1.a(3, n());
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
            j1 = dq.b(f.a()) + 0;
        }
        i1 = j1;
        if ((e & 2) == 2)
        {
            i1 = j1 + dq.b(2, m());
        }
        j1 = i1;
        if ((e & 4) == 4)
        {
            j1 = i1 + dq.b(3, n());
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
                if (flag && f == ((f) (obj)).f)
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
                if (flag && h().equals(((h) (obj)).h()))
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
                if (!flag2 || !j().equals(((j) (obj)).j()))
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

    public final j f()
    {
        return f;
    }

    public final boolean g()
    {
        return (e & 2) == 2;
    }

    public final String h()
    {
        Object obj = g;
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (do)obj;
        String s = ((do) (obj)).f();
        if (((do) (obj)).g())
        {
            g = s;
        }
        return s;
    }

    public final int hashCode()
    {
        if (a != 0)
        {
            return a;
        }
        int j1 = com/tapjoy/internal/gt$f.hashCode() + 779;
        int i1 = j1;
        if (e())
        {
            i1 = (j1 * 37 + 1) * 53 + dt.a(f);
        }
        j1 = i1;
        if (g())
        {
            j1 = (i1 * 37 + 2) * 53 + h().hashCode();
        }
        i1 = j1;
        if (i())
        {
            i1 = (j1 * 37 + 3) * 53 + j().hashCode();
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
        String s = ((do) (obj)).f();
        if (((do) (obj)).g())
        {
            h = s;
        }
        return s;
    }

    public final a l()
    {
        return a.g().a(this);
    }

    static 
    {
        a.a a1 = new <init>();
        c = a1;
        a1.o();
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
        o();
        d1 = com.tapjoy.internal.do.h();
        dq1 = dq.a(d1, 4096);
        flag = false;
_L13:
        if (flag) goto _L2; else goto _L1
_L1:
        int i1 = dp1.a();
        i1;
        JVM INSTR lookupswitch 4: default 302
    //                   0: 305
    //                   8: 104
    //                   18: 195
    //                   26: 220;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        if (!dp1.a(i1, dq1))
        {
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        d d2;
        int j1;
        j1 = dp1.e();
        d2 = a(j1);
        if (d2 != null) goto _L9; else goto _L8
_L8:
        dq1.e(i1);
        dq1.e(j1);
        continue; /* Loop/switch isn't completed */
        dp1;
        throw dp1.a(this);
        dp1;
        dq1.a();
        d = d1.a();
_L11:
        throw dp1;
_L9:
        e = e | 1;
        f = d2;
        continue; /* Loop/switch isn't completed */
        dp1;
        throw (new du(dp1.getMessage())).a(this);
_L6:
        do do1 = dp1.d();
        e = e | 2;
        g = do1;
        continue; /* Loop/switch isn't completed */
_L7:
        do do2 = dp1.d();
        e = e | 4;
        h = do2;
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
        i = -1;
        j = -1;
        d = <init>1.c();
    }

    c(c c1, byte byte0)
    {
        this(c1);
    }
}
