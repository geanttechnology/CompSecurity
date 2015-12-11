// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.IOException;

// Referenced classes of package com.tapjoy.internal:
//            ds, gt, do, du, 
//            dq, dp, dz, dr, 
//            ec, dm

public static final class <init> extends ds
    implements <init>
{
    public static final class a extends ds.a
        implements gt.o
    {

        private int b;
        private gt.l c;
        private gt.a d;
        private gt.x e;

        static a f()
        {
            return new a();
        }

        private a g()
        {
            a a1 = new a();
            gt.n n1 = h();
            if (n1 == gt.n.c())
            {
                return a1;
            }
            Object obj;
            if (n1.e())
            {
                obj = n1.f();
                if ((a1.b & 1) == 1 && a1.c != gt.l.c())
                {
                    a1.c = gt.l.a(a1.c).a(((gt.l) (obj))).e();
                } else
                {
                    a1.c = ((gt.l) (obj));
                }
                a1.b = a1.b | 1;
            }
            if (n1.g())
            {
                obj = n1.h();
                if ((a1.b & 2) == 2 && a1.d != gt.a.c())
                {
                    a1.d = gt.a.a(a1.d).a(((gt.a) (obj))).e();
                } else
                {
                    a1.d = ((gt.a) (obj));
                }
                a1.b = a1.b | 2;
            }
            if (n1.i())
            {
                obj = n1.j();
                if ((a1.b & 4) == 4 && a1.e != gt.x.c())
                {
                    a1.e = gt.x.a(a1.e).a(((gt.x) (obj))).e();
                } else
                {
                    a1.e = ((gt.x) (obj));
                }
                a1.b = a1.b | 4;
            }
            a1.a = ((ds.a) (a1)).a.a(gt.n.a(n1));
            return a1;
        }

        private gt.n h()
        {
            int j1 = 1;
            gt.n n1 = new gt.n(this, (byte)0);
            int k1 = b;
            int i1;
            if ((k1 & 1) != 1)
            {
                j1 = 0;
            }
            gt.n.a(n1, c);
            i1 = j1;
            if ((k1 & 2) == 2)
            {
                i1 = j1 | 2;
            }
            gt.n.a(n1, d);
            j1 = i1;
            if ((k1 & 4) == 4)
            {
                j1 = i1 | 4;
            }
            gt.n.a(n1, e);
            gt.n.a(n1, j1);
            return n1;
        }

        public final dl.a a()
        {
            return g();
        }

        public final a a(gt.a.a a1)
        {
            a1 = a1.e();
            if (!a1.d())
            {
                throw new ec();
            } else
            {
                d = a1;
                b = b | 2;
                return this;
            }
        }

        public final a a(gt.l.a a1)
        {
            a1 = a1.e();
            if (!a1.d())
            {
                throw new ec();
            } else
            {
                c = a1;
                b = b | 1;
                return this;
            }
        }

        public final a a(gt.x.a a1)
        {
            a1 = a1.e();
            if (!a1.d())
            {
                throw new ec();
            } else
            {
                e = a1;
                b = b | 4;
                return this;
            }
        }

        public final ds.a b()
        {
            return g();
        }

        public final Object clone()
        {
            return g();
        }

        public final boolean d()
        {
            boolean flag;
            if ((b & 4) == 4)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return !flag || e.d();
        }

        public final gt.n e()
        {
            gt.n n1 = h();
            if (!n1.d())
            {
                throw new ec();
            } else
            {
                return n1;
            }
        }

        private a()
        {
            c = gt.l.c();
            d = gt.a.c();
            e = gt.x.c();
        }
    }


    public static dz b = new dm() {

        public final Object a(dp dp1, dr dr)
        {
            return new gt.n(dp1, dr, (byte)0);
        }

    };
    private static final <init> c;
    private final do d;
    private int e;
    private <init> f;
    private <init> g;
    private <init> h;
    private byte i;
    private int j;

    static int a(nit> nit>, int i1)
    {
        nit>.e = i1;
        return i1;
    }

    static do a(e e1)
    {
        return e1.d;
    }

    static d a(d d1, d d2)
    {
        d1.g = d2;
        return d2;
    }

    static g a(g g1, g g2)
    {
        g1.f = g2;
        return g2;
    }

    static f a(f f1, f f2)
    {
        f1.h = f2;
        return f2;
    }

    public static h c()
    {
        return c;
    }

    public static a k()
    {
        return a.f();
    }

    private void l()
    {
        f = c();
        g = c();
        h = c();
    }

    public final void a(dq dq1)
    {
        b();
        if ((e & 1) == 1)
        {
            dq1.a(1, f);
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
            j1 = dq.b(1, f) + 0;
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
        if (i() && !h.d())
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
                if (flag && f.equals(((equals) (obj)).f))
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
                if (flag && g.equals(((equals) (obj)).g))
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
                if (!flag2 || !h.equals(((equals) (obj)).h))
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

    public final h f()
    {
        return f;
    }

    public final boolean g()
    {
        return (e & 2) == 2;
    }

    public final e h()
    {
        return g;
    }

    public final int hashCode()
    {
        if (a != 0)
        {
            return a;
        }
        int j1 = com/tapjoy/internal/gt$n.hashCode() + 779;
        int i1 = j1;
        if (e())
        {
            i1 = (j1 * 37 + 1) * 53 + f.hashCode();
        }
        j1 = i1;
        if (g())
        {
            j1 = (i1 * 37 + 2) * 53 + g.hashCode();
        }
        i1 = j1;
        if (i())
        {
            i1 = (j1 * 37 + 3) * 53 + h.hashCode();
        }
        i1 = i1 * 29 + d.hashCode();
        a = i1;
        return i1;
    }

    public final boolean i()
    {
        return (e & 4) == 4;
    }

    public final e j()
    {
        return h;
    }

    static 
    {
        h h1 = new <init>();
        c = h1;
        h1.l();
    }

    private _cls1()
    {
        i = -1;
        j = -1;
        d = do.a;
    }

    private a(dp dp1, dr dr)
    {
        d d1;
        dq dq1;
        boolean flag;
        i = -1;
        j = -1;
        l();
        d1 = com.tapjoy.internal.do.h();
        dq1 = dq.a(d1, 4096);
        flag = false;
_L25:
        if (flag) goto _L2; else goto _L1
_L1:
        int i1 = dp1.a();
        i1;
        JVM INSTR lookupswitch 4: default 429
    //                   0: 432
    //                   10: 109
    //                   18: 200
    //                   26: 284;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        if (!dp1.a(i1, dq1))
        {
            flag = true;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if ((e & 1) != 1) goto _L9; else goto _L8
_L8:
        Object obj = f.N();
_L23:
        f = (f)dp1.a(b, dr);
        if (obj == null) goto _L11; else goto _L10
_L10:
        ((a) (obj)).a(f);
        f = ((a) (obj)).e();
_L11:
        e = e | 1;
        continue; /* Loop/switch isn't completed */
        dp1;
        throw dp1.a(this);
        dp1;
        dq1.a();
        d = d1.a();
_L20:
        throw dp1;
_L6:
        if ((e & 2) != 2) goto _L13; else goto _L12
_L12:
        obj = g.p();
_L22:
        g = (g)dp1.a(b, dr);
        if (obj == null) goto _L15; else goto _L14
_L14:
        ((a) (obj)).a(g);
        g = ((a) (obj)).e();
_L15:
        e = e | 2;
        continue; /* Loop/switch isn't completed */
        dp1;
        throw (new du(dp1.getMessage())).a(this);
_L7:
        if ((e & 4) != 4) goto _L17; else goto _L16
_L16:
        obj = h.ad();
_L21:
        h = (h)dp1.a(b, dr);
        if (obj == null) goto _L19; else goto _L18
_L18:
        ((a) (obj)).a(h);
        h = ((a) (obj)).e();
_L19:
        e = e | 4;
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
        dr;
        d = d1.a();
          goto _L20
        dp1;
        d = d1.a();
        throw dp1;
_L17:
        obj = null;
          goto _L21
_L13:
        obj = null;
          goto _L22
_L9:
        obj = null;
          goto _L23
_L4:
        flag = true;
        if (true) goto _L25; else goto _L24
_L24:
    }

    a(dp dp1, dr dr, byte byte0)
    {
        this(dp1, dr);
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
