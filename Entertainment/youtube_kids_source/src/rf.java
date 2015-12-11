// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class rf
    implements cur
{

    private rc a;

    rf(rc rc1)
    {
        a = rc1;
        super();
    }

    public final void a()
    {
        rc.c(a).a(rc.b(a).l(), rc.b(a).m());
    }

    public final void a(long l)
    {
        rc.d(a).a();
        rc.e(a).a((int)l);
    }

    public final void b()
    {
        rc.d(a).a();
        rc.e(a).a();
    }

    public final void c()
    {
        rc.d(a).a();
        rc.e(a).b();
    }

    public final void d()
    {
        rc.d(a).a();
        if (rc.f(a))
        {
            rc.e(a).b();
            return;
        } else
        {
            rc.e(a).a();
            return;
        }
    }

    public final void e()
    {
        rc.d(a).a();
        rc.e(a).d();
    }

    public final void f()
    {
        rc.d(a).a();
        if (rc.a(a) <= 3000L && rc.b(a).l())
        {
            rc.e(a).f();
            return;
        } else
        {
            rc.e(a).a(0);
            return;
        }
    }

    public final void g()
    {
        rc.d(a).a();
        rc.e(a).e();
    }

    public final void h()
    {
        rc.d(a).a();
        a.stopSelf();
    }
}
