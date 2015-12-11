// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


// Referenced classes of package com.tapjoy.internal:
//            gt, do, ec

public static final class c extends c
    implements c
{

    private int b;
    private Object c;
    private long d;
    private long e;

    static c f()
    {
        return new <init>();
    }

    private <init> g()
    {
        return (new <init>()).a(h());
    }

    private h h()
    {
        int j = 1;
        h h1 = new nit>(this, (byte)0);
        int k = b;
        int i;
        if ((k & 1) != 1)
        {
            j = 0;
        }
        b(h1, c);
        i = j;
        if ((k & 2) == 2)
        {
            i = j | 2;
        }
        c(h1, d);
        j = i;
        if ((k & 4) == 4)
        {
            j = i | 4;
        }
        d(h1, e);
        e(h1, j);
        return h1;
    }

    public final e a()
    {
        return g();
    }

    public final g a(long l)
    {
        b = b | 2;
        d = l;
        return this;
    }

    public final d a(d d1)
    {
        if (d1 == d())
        {
            return this;
        }
        if (d1.d())
        {
            b = b | 1;
            c = c(d1);
        }
        if (d1.c())
        {
            a(d1.a());
        }
        if (d1.a())
        {
            b(d1.b());
        }
        super.b = super.b.a(b(d1));
        return this;
    }

    public final b a(String s)
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

    public final c b()
    {
        return g();
    }

    public final g b(long l)
    {
        b = b | 4;
        e = l;
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

    public final b e()
    {
        b b1 = h();
        if (!b1.h())
        {
            throw new ec();
        } else
        {
            return b1;
        }
    }

    private ion()
    {
        c = "";
    }
}
