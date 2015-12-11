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
        implements gt.k
    {

        private int b;
        private Object c;
        private long d;

        static a f()
        {
            return new a();
        }

        private a g()
        {
            a a1 = new a();
            gt.j j1 = e();
            if (j1 == gt.j.c())
            {
                return a1;
            }
            if (j1.e())
            {
                a1.b = a1.b | 1;
                a1.c = gt.j.a(j1);
            }
            if (j1.g())
            {
                a1.a(j1.h());
            }
            a1.a = ((ds.a) (a1)).a.a(gt.j.b(j1));
            return a1;
        }

        public final dl.a a()
        {
            return g();
        }

        public final a a(long l)
        {
            b = b | 2;
            d = l;
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

        final gt.j e()
        {
            int l = 1;
            gt.j j1 = new gt.j(this, (byte)0);
            int k1 = b;
            int i1;
            if ((k1 & 1) != 1)
            {
                l = 0;
            }
            gt.j.a(j1, c);
            i1 = l;
            if ((k1 & 2) == 2)
            {
                i1 = l | 2;
            }
            gt.j.a(j1, d);
            gt.j.a(j1, i1);
            return j1;
        }

        private a()
        {
            c = "";
        }
    }


    public static dz b = new dm() {

        public final Object a(dp dp1, dr dr)
        {
            return new gt.j(dp1, (byte)0);
        }

    };
    private static final <init> c;
    private final do d;
    private int e;
    private Object f;
    private long g;
    private byte h;
    private int i;

    static int a(a a1, int l)
    {
        a1.e = l;
        return l;
    }

    static long a(e e1, long l)
    {
        e1.g = l;
        return l;
    }

    static Object a(g g1)
    {
        return g1.f;
    }

    static Object a(f f1, Object obj)
    {
        f1.f = obj;
        return obj;
    }

    static do b(f f1)
    {
        return f1.d;
    }

    public static d c()
    {
        return c;
    }

    public static a i()
    {
        return a.f();
    }

    private do j()
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

    private void k()
    {
        f = "";
        g = 0L;
    }

    public final void a(dq dq1)
    {
        b();
        if ((e & 1) == 1)
        {
            dq1.a(1, j());
        }
        if ((e & 2) == 2)
        {
            dq1.a(2, g);
        }
        dq1.b(d);
    }

    public final int b()
    {
        int l = i;
        if (l != -1)
        {
            return l;
        }
        l = 0;
        if ((e & 1) == 1)
        {
            l = dq.b(1, j()) + 0;
        }
        int i1 = l;
        if ((e & 2) == 2)
        {
            i1 = l + dq.b(2, g);
        }
        l = i1 + d.a();
        i = l;
        return l;
    }

    public final boolean d()
    {
        byte byte0 = h;
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
            h = 0;
            return false;
        }
        if (!g())
        {
            h = 0;
            return false;
        } else
        {
            h = 1;
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
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (g())
            {
                if (!flag2 || g != ((g) (obj)).g)
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
        int i1 = com/tapjoy/internal/gt$j.hashCode() + 779;
        int l = i1;
        if (e())
        {
            l = (i1 * 37 + 1) * 53 + f().hashCode();
        }
        i1 = l;
        if (g())
        {
            i1 = (l * 37 + 2) * 53 + dt.a(g);
        }
        l = i1 * 29 + d.hashCode();
        a = l;
        return l;
    }

    static 
    {
        a a1 = new <init>();
        c = a1;
        a1.k();
    }

    private _cls1()
    {
        h = -1;
        i = -1;
        d = do.a;
    }

    private d(dp dp1)
    {
        d d1;
        dq dq1;
        boolean flag;
        h = -1;
        i = -1;
        k();
        d1 = com.tapjoy.internal.do.h();
        dq1 = dq.a(d1, 4096);
        flag = false;
_L10:
        if (flag) goto _L2; else goto _L1
_L1:
        int l = dp1.a();
        l;
        JVM INSTR lookupswitch 3: default 238
    //                   0: 241
    //                   10: 96
    //                   16: 143;
           goto _L3 _L4 _L5 _L6
_L3:
        if (!dp1.a(l, dq1))
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
_L8:
        throw dp1;
_L6:
        e = e | 2;
        g = dp1.f();
        continue; /* Loop/switch isn't completed */
        dp1;
        throw (new du(dp1.getMessage())).a(this);
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
        if (true) goto _L8; else goto _L7
_L7:
        dp1;
        d = d1.a();
        throw dp1;
_L4:
        flag = true;
        if (true) goto _L10; else goto _L9
_L9:
    }

    a(dp dp1, byte byte0)
    {
        this(dp1);
    }

    private <init>(<init> <init>1)
    {
        super((byte)0);
        h = -1;
        i = -1;
        d = <init>1.c();
    }

    c(c c1, byte byte0)
    {
        this(c1);
    }
}
