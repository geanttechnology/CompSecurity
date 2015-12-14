// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request;


// Referenced classes of package com.bumptech.glide.request:
//            b, c

public final class g
    implements b, c
{

    private b a;
    private b b;
    private c c;
    private boolean d;

    public g()
    {
        this(null);
    }

    public g(c c1)
    {
        c = c1;
    }

    public final void a()
    {
        d = true;
        if (!b.e())
        {
            b.a();
        }
        if (d && !a.e())
        {
            a.a();
        }
    }

    public final void a(b b1, b b2)
    {
        a = b1;
        b = b2;
    }

    public final boolean a(b b1)
    {
        boolean flag;
        if (c == null || c.a(this))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag && (b1.equals(a) || !a.g());
    }

    public final boolean b()
    {
        boolean flag1 = false;
        boolean flag;
        if (c != null && c.b())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag || g())
        {
            flag1 = true;
        }
        return flag1;
    }

    public final boolean b(b b1)
    {
        boolean flag;
        if (c == null || c.b(this))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag && b1.equals(a) && !b();
    }

    public final void c()
    {
        d = false;
        a.c();
        b.c();
    }

    public final void c(b b1)
    {
        if (!b1.equals(b))
        {
            if (c != null)
            {
                c.c(this);
            }
            if (!b.f())
            {
                b.d();
                return;
            }
        }
    }

    public final void d()
    {
        d = false;
        b.d();
        a.d();
    }

    public final boolean e()
    {
        return a.e();
    }

    public final boolean f()
    {
        return a.f() || b.f();
    }

    public final boolean g()
    {
        return a.g() || b.g();
    }

    public final boolean h()
    {
        return a.h();
    }

    public final void i()
    {
        a.i();
        b.i();
    }
}
