// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class rv
{

    boolean a;
    boolean b;
    public boolean c;
    boolean d;
    boolean e;
    private final bje f;

    public rv(bje bje1)
    {
        f = (bje)b.a(bje1);
    }

    private ctr d()
    {
        if (b)
        {
            return ctr.c;
        }
        if (a)
        {
            return ctr.b;
        } else
        {
            return ctr.a;
        }
    }

    final void a()
    {
        f.c(b());
    }

    final void a(boolean flag)
    {
        if (flag != d)
        {
            d = flag;
            a();
        }
    }

    csg b()
    {
        ctr ctr1;
        if (e)
        {
            ctr1 = ctr.f;
        } else
        if (c)
        {
            ctr1 = ctr.d;
        } else
        if (d)
        {
            ctr1 = ctr.e;
        } else
        {
            ctr1 = d();
        }
        return new csg(ctr1, d());
    }

    public final void b(boolean flag)
    {
        if (flag != e)
        {
            e = flag;
            a();
        }
    }

    public final uw c()
    {
        return new uw(a, b, c, d, e);
    }
}
