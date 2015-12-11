// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


// Referenced classes of package com.tapjoy.internal:
//            gt, do, ec

public static final class e extends e
    implements e
{

    private int b;
    private t> c;
    private t> d;
    private t> e;

    static e f()
    {
        return new <init>();
    }

    private <init> g()
    {
        <init> <init>1 = new <init>();
        <init> <init>2 = h();
        if (<init>2 == h())
        {
            return <init>1;
        }
        Object obj;
        if (<init>2.h())
        {
            obj = <init>2.h();
            if ((<init>1.b & 1) == 1 && <init>1.c != c())
            {
                <init>1.c = c(<init>1.c).a(((a) (obj))).e();
            } else
            {
                <init>1.c = ((c) (obj));
            }
            <init>1.b = <init>1.b | 1;
        }
        if (<init>2.b())
        {
            obj = <init>2.b();
            if ((<init>1.b & 2) == 2 && <init>1.d != d())
            {
                <init>1.d = d(<init>1.d).a(((a) (obj))).e();
            } else
            {
                <init>1.d = ((d) (obj));
            }
            <init>1.b = <init>1.b | 2;
        }
        if (<init>2.b())
        {
            obj = <init>2.b();
            if ((<init>1.b & 4) == 4 && <init>1.e != e())
            {
                <init>1.e = e(<init>1.e).a(((a) (obj))).e();
            } else
            {
                <init>1.e = ((e) (obj));
            }
            <init>1.b = <init>1.b | 4;
        }
        <init>1.b = ((b) (<init>1)).b.a(b(<init>2));
        return <init>1;
    }

    private b h()
    {
        int j = 1;
        b b1 = new nit>(this, (byte)0);
        int k = b;
        int i;
        if ((k & 1) != 1)
        {
            j = 0;
        }
        b(b1, c);
        i = j;
        if ((k & 2) == 2)
        {
            i = j | 2;
        }
        c(b1, d);
        j = i;
        if ((k & 4) == 4)
        {
            j = i | 4;
        }
        d(b1, e);
        e(b1, j);
        return b1;
    }

    public final e a()
    {
        return g();
    }

    public final g a(g g1)
    {
        g1 = g1.e();
        if (!g1.e())
        {
            throw new ec();
        } else
        {
            d = g1;
            b = b | 2;
            return this;
        }
    }

    public final b a(b b1)
    {
        b1 = b1.e();
        if (!b1.e())
        {
            throw new ec();
        } else
        {
            c = b1;
            b = b | 1;
            return this;
        }
    }

    public final b a(b b1)
    {
        b1 = b1.e();
        if (!b1.e())
        {
            throw new ec();
        } else
        {
            e = b1;
            b = b | 4;
            return this;
        }
    }

    public final b b()
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
        return !flag || e.e();
    }

    public final e e()
    {
        e e1 = h();
        if (!e1.h())
        {
            throw new ec();
        } else
        {
            return e1;
        }
    }

    private ()
    {
        c = c();
        d = d();
        e = e();
    }
}
