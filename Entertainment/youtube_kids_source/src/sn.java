// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class sn
    implements cuw
{

    private boolean a;
    private sm b;

    sn(sm sm1)
    {
        b = sm1;
        super();
    }

    public final void a()
    {
        cth cth1 = cth.b;
        b.a.g();
        a = false;
    }

    public final void a(int k)
    {
        b.a.a(k);
        cth cth1 = cth.b;
        a = false;
    }

    public final void a(boolean flag)
    {
        b.a.d(flag);
        a = false;
    }

    public final void b()
    {
        b.a.i();
        a = false;
    }

    public final void c()
    {
        Object obj = cth.b;
        obj = b.a;
        if (((rx) (obj)).f.a(ctt.d))
        {
            ((rx) (obj)).g();
        } else
        {
            ((rx) (obj)).j();
        }
        a = false;
    }

    public final void d()
    {
        b.c.b();
        cth cth1 = cth.b;
        b.a.h();
        a = false;
    }

    public final void e()
    {
        cth cth1 = cth.a;
        b.a.o();
        a = false;
    }

    public final void f()
    {
        cth cth1 = cth.a;
        b.a.n();
        a = false;
    }

    public final void g()
    {
        if (b.d)
        {
            b.a.f.k();
        } else
        {
            b.a.f.b(true);
        }
        a = false;
    }

    public final void h()
    {
        b.b.c(new csa());
        a = false;
    }

    public final void i()
    {
        b.b.c(new ctc(true));
        a = false;
    }

    public final void j()
    {
        b.b.c(new ctc(false));
        a = false;
    }
}
