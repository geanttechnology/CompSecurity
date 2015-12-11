// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


// Referenced classes of package com.tapjoy.internal:
//            gt, do

public static final class e extends e
    implements e
{

    private int b;
    private e c;
    private Object d;
    private Object e;

    static e g()
    {
        return new <init>();
    }

    private <init> h()
    {
        return (new <init>()).a(e());
    }

    public final e a()
    {
        return h();
    }

    public final h a(h h1)
    {
        if (h1 == h())
        {
            return this;
        }
        if (h1.h())
        {
            a(h1.a());
        }
        if (h1.a())
        {
            b = b | 2;
            d = d(h1);
        }
        if (h1.d())
        {
            b = b | 4;
            e = e(h1);
        }
        super.e = super.e.a(e(h1));
        return this;
    }

    public final e a(e e1)
    {
        if (e1 == null)
        {
            throw new NullPointerException();
        } else
        {
            b = b | 1;
            c = e1;
            return this;
        }
    }

    public final c a(String s)
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

    public final d b()
    {
        return h();
    }

    public final h b(String s)
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

    public final b e()
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

    public final e f()
    {
        b = b & -5;
        e = e().e();
        return this;
    }

    private ion()
    {
        c = c;
        d = "";
        e = "";
    }
}
