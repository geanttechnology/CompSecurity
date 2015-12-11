// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;

final class yf
    implements cur
{

    private yc a;

    yf(yc yc1)
    {
        a = yc1;
        super();
    }

    private boolean i()
    {
        return a.b.l() == amb.g;
    }

    public final void a()
    {
        if (a.b != null)
        {
            a.a.a(a.b.d(), a.b.f());
        }
    }

    public final void a(long l)
    {
        a.b.a((int)l);
    }

    public final void b()
    {
        if (!i())
        {
            a.b.a();
        }
    }

    public final void c()
    {
        if (!i())
        {
            a.b.b();
        }
    }

    public final void d()
    {
        if (a.b.l() == amb.c)
        {
            a.b.b();
        } else
        if (!i())
        {
            a.b.a();
            return;
        }
    }

    public final void e()
    {
        a.b.a(0);
    }

    public final void f()
    {
        if (a.b.d())
        {
            a.b.e();
        } else
        if (!TextUtils.isEmpty(a.b.o()))
        {
            a.b.a(0);
            return;
        }
    }

    public final void g()
    {
        if (a.b.f())
        {
            a.b.g();
        }
    }

    public final void h()
    {
        a.b.c();
        a.a.b();
    }
}
