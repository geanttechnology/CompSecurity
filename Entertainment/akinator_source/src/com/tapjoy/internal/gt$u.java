// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.tapjoy.internal:
//            ds, gt, do, du, 
//            dq, dp, dz, dx, 
//            dr, ec, dm

public static final class <init> extends ds
    implements <init>
{
    public static final class a extends ds.a
        implements gt.v
    {

        private int b;
        private List c;

        static a f()
        {
            return new a();
        }

        private a g()
        {
            a a1 = new a();
            gt.u u1 = h();
            if (u1 == gt.u.c())
            {
                return a1;
            }
            if (!gt.u.a(u1).isEmpty())
            {
                if (a1.c.isEmpty())
                {
                    a1.c = gt.u.a(u1);
                    a1.b = a1.b & -2;
                } else
                {
                    a1.i();
                    a1.c.addAll(gt.u.a(u1));
                }
            }
            a1.a = ((ds.a) (a1)).a.a(gt.u.b(u1));
            return a1;
        }

        private gt.u h()
        {
            gt.u u1 = new gt.u(this, (byte)0);
            int j = b;
            if ((b & 1) == 1)
            {
                c = Collections.unmodifiableList(c);
                b = b & -2;
            }
            gt.u.a(u1, c);
            return u1;
        }

        private void i()
        {
            if ((b & 1) != 1)
            {
                c = new ArrayList(c);
                b = b | 1;
            }
        }

        public final dl.a a()
        {
            return g();
        }

        public final a a(Iterable iterable)
        {
            i();
            dl.a.a(iterable, c);
            return this;
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
            for (int j = 0; j < c.size(); j++)
            {
                if (!((gt.t)c.get(j)).d())
                {
                    return false;
                }
            }

            return true;
        }

        public final gt.u e()
        {
            gt.u u1 = h();
            if (!u1.d())
            {
                throw new ec();
            } else
            {
                return u1;
            }
        }

        private a()
        {
            c = Collections.emptyList();
        }
    }


    public static dz b = new dm() {

        public final Object a(dp dp1, dr dr)
        {
            return new gt.u(dp1, dr, (byte)0);
        }

    };
    private static final <init> c;
    private final do d;
    private List e;
    private byte f;
    private int g;

    public static nit> a(byte abyte0[])
    {
        return (nit>)b.a(abyte0);
    }

    static List a(b b1)
    {
        return b1.e;
    }

    static List a(e e1, List list)
    {
        e1.e = list;
        return list;
    }

    static do b(e e1)
    {
        return e1.d;
    }

    public static d c()
    {
        return c;
    }

    public static a f()
    {
        return a.f();
    }

    private int g()
    {
        return e.size();
    }

    public final void a(dq dq1)
    {
        b();
        for (int i = 0; i < e.size(); i++)
        {
            dq1.a(1, (dx)e.get(i));
        }

        dq1.b(d);
    }

    public final int b()
    {
        int i = g;
        if (i != -1)
        {
            return i;
        }
        i = 0;
        int j = 0;
        for (; i < e.size(); i++)
        {
            j += dq.b(1, (dx)e.get(i));
        }

        i = d.a() + j;
        g = i;
        return i;
    }

    public final boolean d()
    {
        boolean flag = false;
        byte byte0 = f;
        if (byte0 == 1)
        {
            flag = true;
        } else
        if (byte0 != 0)
        {
            for (int i = 0; i < g(); i++)
            {
                if (!((g)e.get(i)).d())
                {
                    f = 0;
                    return false;
                }
            }

            f = 1;
            return true;
        }
        return flag;
    }

    public final List e()
    {
        return e;
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
            if (!e.equals(((e) (obj)).e))
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        if (a != 0)
        {
            return a;
        }
        int j = com/tapjoy/internal/gt$u.hashCode() + 779;
        int i = j;
        if (g() > 0)
        {
            i = (j * 37 + 1) * 53 + e.hashCode();
        }
        i = i * 29 + d.hashCode();
        a = i;
        return i;
    }

    static 
    {
        a a1 = new <init>();
        c = a1;
        a1.e = Collections.emptyList();
    }

    private _cls1()
    {
        f = -1;
        g = -1;
        d = do.a;
    }

    private d(dp dp1, dr dr)
    {
        d d1;
        dq dq1;
        boolean flag;
        boolean flag1;
        flag = false;
        super();
        f = -1;
        g = -1;
        e = Collections.emptyList();
        d1 = com.tapjoy.internal.do.h();
        dq1 = dq.a(d1, 4096);
        flag1 = false;
_L12:
        if (flag1) goto _L2; else goto _L1
_L1:
        boolean flag2;
        boolean flag3;
        boolean flag4;
        flag2 = flag;
        flag3 = flag;
        flag4 = flag;
        int i = dp1.a();
        i;
        JVM INSTR lookupswitch 2: default 351
    //                   0: 354
    //                   10: 121;
           goto _L3 _L4 _L5
_L3:
        flag2 = flag;
        flag3 = flag;
        flag4 = flag;
        if (!dp1.a(i, dq1))
        {
            flag1 = true;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        i = ((flag) ? 1 : 0);
        if ((flag & true)) goto _L7; else goto _L6
_L6:
        flag2 = flag;
        flag3 = flag;
        flag4 = flag;
        e = new ArrayList();
        i = flag | true;
_L7:
        flag2 = i;
        flag3 = i;
        flag4 = i;
        e.add(dp1.a(b, dr));
        flag = i;
        continue; /* Loop/switch isn't completed */
        dp1;
        flag = flag2;
        throw dp1.a(this);
        dp1;
_L10:
        if ((flag & true))
        {
            e = Collections.unmodifiableList(e);
        }
        dq1.a();
        d = d1.a();
_L9:
        throw dp1;
_L2:
        if ((flag & true))
        {
            e = Collections.unmodifiableList(e);
        }
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
        dp1;
        flag = flag3;
        throw (new du(dp1.getMessage())).a(this);
        dr;
        d = d1.a();
        if (true) goto _L9; else goto _L8
_L8:
        dp1;
        d = d1.a();
        throw dp1;
        dp1;
        flag = flag4;
          goto _L10
_L4:
        flag1 = true;
        if (true) goto _L12; else goto _L11
_L11:
    }

    a(dp dp1, dr dr, byte byte0)
    {
        this(dp1, dr);
    }

    private <init>(<init> <init>1)
    {
        super((byte)0);
        f = -1;
        g = -1;
        d = <init>1.c();
    }

    c(c c1, byte byte0)
    {
        this(c1);
    }
}
