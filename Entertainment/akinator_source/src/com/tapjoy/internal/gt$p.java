// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.IOException;

// Referenced classes of package com.tapjoy.internal:
//            ds, gt, do, du, 
//            dq, dp, dz, ec, 
//            dm, dr

public static final class <init> extends ds
    implements <init>
{
    public static final class a extends ds.a
        implements gt.q
    {

        private int b;
        private Object c;
        private Object d;
        private Object e;

        static a g()
        {
            return new a();
        }

        private a h()
        {
            return (new a()).a(f());
        }

        public final dl.a a()
        {
            return h();
        }

        public final a a(gt.p p1)
        {
            if (p1 == gt.p.c())
            {
                return this;
            }
            if (p1.e())
            {
                b = b | 1;
                c = gt.p.b(p1);
            }
            if (p1.g())
            {
                b = b | 2;
                d = gt.p.c(p1);
            }
            if (p1.i())
            {
                b = b | 4;
                e = gt.p.d(p1);
            }
            super.a = super.a.a(gt.p.e(p1));
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
            return h();
        }

        public final a b(String s)
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

        public final a c(String s)
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
            return true;
        }

        public final gt.p e()
        {
            gt.p p1 = f();
            if (!p1.d())
            {
                throw new ec();
            } else
            {
                return p1;
            }
        }

        public final gt.p f()
        {
            int j1 = 1;
            gt.p p1 = new gt.p(this, (byte)0);
            int k1 = b;
            int i1;
            if ((k1 & 1) != 1)
            {
                j1 = 0;
            }
            gt.p.a(p1, c);
            i1 = j1;
            if ((k1 & 2) == 2)
            {
                i1 = j1 | 2;
            }
            gt.p.b(p1, d);
            j1 = i1;
            if ((k1 & 4) == 4)
            {
                j1 = i1 | 4;
            }
            gt.p.c(p1, e);
            gt.p.a(p1, j1);
            return p1;
        }

        private a()
        {
            c = "";
            d = "";
            e = "";
        }
    }


    public static dz b = new dm() {

        public final Object a(dp dp1, dr dr)
        {
            return new gt.p(dp1, (byte)0);
        }

    };
    private static final <init> c;
    private final do d;
    private int e;
    private Object f;
    private Object g;
    private Object h;
    private byte i;
    private int j;

    static int a(a a1, int i1)
    {
        a1.e = i1;
        return i1;
    }

    public static a a(e e1)
    {
        return a.g().a(e1);
    }

    static Object a(a.a a1, Object obj)
    {
        a1.f = obj;
        return obj;
    }

    static Object b(f f1)
    {
        return f1.f;
    }

    static Object b(f f1, Object obj)
    {
        f1.g = obj;
        return obj;
    }

    public static g c()
    {
        return c;
    }

    static Object c(c c1)
    {
        return c1.g;
    }

    static Object c(g g1, Object obj)
    {
        g1.h = obj;
        return obj;
    }

    static Object d(h h1)
    {
        return h1.h;
    }

    static do e(h h1)
    {
        return h1.d;
    }

    public static a k()
    {
        return a.g();
    }

    private do m()
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

    private do n()
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

    private do o()
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

    private void p()
    {
        f = "";
        g = "";
        h = "";
    }

    public final void a(dq dq1)
    {
        b();
        if ((e & 1) == 1)
        {
            dq1.a(1, m());
        }
        if ((e & 2) == 2)
        {
            dq1.a(2, n());
        }
        if ((e & 4) == 4)
        {
            dq1.a(3, o());
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
            j1 = dq.b(1, m()) + 0;
        }
        i1 = j1;
        if ((e & 2) == 2)
        {
            i1 = j1 + dq.b(2, n());
        }
        j1 = i1;
        if ((e & 4) == 4)
        {
            j1 = i1 + dq.b(3, o());
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
        int j1 = com/tapjoy/internal/gt$p.hashCode() + 779;
        int i1 = j1;
        if (e())
        {
            i1 = (j1 * 37 + 1) * 53 + f().hashCode();
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
        a1.p();
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
        p();
        d1 = com.tapjoy.internal.do.h();
        dq1 = dq.a(d1, 4096);
        flag = false;
_L11:
        if (flag) goto _L2; else goto _L1
_L1:
        int i1 = dp1.a();
        i1;
        JVM INSTR lookupswitch 4: default 275
    //                   0: 278
    //                   10: 104
    //                   18: 151
    //                   26: 193;
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
        do do2 = dp1.d();
        e = e | 2;
        g = do2;
        continue; /* Loop/switch isn't completed */
        dp1;
        throw (new du(dp1.getMessage())).a(this);
_L7:
        do do3 = dp1.d();
        e = e | 4;
        h = do3;
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
