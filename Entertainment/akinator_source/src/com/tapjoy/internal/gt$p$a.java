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
    private Object c;
    private Object d;
    private Object e;

    static e g()
    {
        return new <init>();
    }

    private <init> h()
    {
        return (new <init>()).a(f());
    }

    public final f a()
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
            b = b | 1;
            c = c(h1);
        }
        if (h1.c())
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

    public final e a(String s)
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
        return h();
    }

    public final h b(String s)
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

    public final d c(String s)
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

    public final h e()
    {
        h h1 = f();
        if (!h1.f())
        {
            throw new ec();
        } else
        {
            return h1;
        }
    }

    public final t> f()
    {
        int j = 1;
        t> t> = new nit>(this, (byte)0);
        int k = b;
        int i;
        if ((k & 1) != 1)
        {
            j = 0;
        }
        b(t>, c);
        i = j;
        if ((k & 2) == 2)
        {
            i = j | 2;
        }
        c(t>, d);
        j = i;
        if ((k & 4) == 4)
        {
            j = i | 4;
        }
        d(t>, e);
        e(t>, j);
        return t>;
    }

    private ion()
    {
        c = "";
        d = "";
        e = "";
    }
}
