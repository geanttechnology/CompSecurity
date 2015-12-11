// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.b;

import b.a.a.a;
import b.a.a.aa;
import b.a.a.ab;
import b.a.a.c.q;
import b.a.a.c.r;
import b.a.a.d;
import b.a.a.l;
import b.a.a.m;
import java.io.Serializable;

public abstract class c extends a
    implements Serializable
{

    public c()
    {
    }

    public b.a.a.c A()
    {
        return b.a.a.c.q.a(b.a.a.d.q(), y());
    }

    public l B()
    {
        return b.a.a.c.r.a(b.a.a.m.i());
    }

    public b.a.a.c C()
    {
        return b.a.a.c.q.a(b.a.a.d.r(), B());
    }

    public l D()
    {
        return b.a.a.c.r.a(b.a.a.m.j());
    }

    public b.a.a.c E()
    {
        return b.a.a.c.q.a(b.a.a.d.s(), D());
    }

    public b.a.a.c F()
    {
        return b.a.a.c.q.a(b.a.a.d.t(), D());
    }

    public b.a.a.c G()
    {
        return b.a.a.c.q.a(b.a.a.d.u(), D());
    }

    public l H()
    {
        return b.a.a.c.r.a(b.a.a.m.k());
    }

    public b.a.a.c I()
    {
        return b.a.a.c.q.a(b.a.a.d.v(), H());
    }

    public l J()
    {
        return b.a.a.c.r.a(b.a.a.m.l());
    }

    public b.a.a.c K()
    {
        return b.a.a.c.q.a(b.a.a.d.w(), J());
    }

    public final long a(aa aa1, long l1)
    {
        for (int i1 = 0; i1 < 3; i1++)
        {
            l1 = aa1.b(i1).a(this).b(l1, aa1.a(i1));
        }

        return l1;
    }

    public final int[] a(ab ab1, long l1, long l2)
    {
        int ai[] = new int[1];
        if (l1 != l2)
        {
            for (int i1 = 0; i1 <= 0; i1++)
            {
                l l3 = ab1.c().a(this);
                int j1 = l3.b(l2, l1);
                l3.a(l1, j1);
                ai[0] = j1;
            }

        }
        return ai;
    }

    public l c()
    {
        return b.a.a.c.r.a(b.a.a.m.a());
    }

    public b.a.a.c d()
    {
        return b.a.a.c.q.a(b.a.a.d.a(), c());
    }

    public b.a.a.c e()
    {
        return b.a.a.c.q.a(b.a.a.d.b(), c());
    }

    public l f()
    {
        return b.a.a.c.r.a(b.a.a.m.b());
    }

    public b.a.a.c g()
    {
        return b.a.a.c.q.a(b.a.a.d.c(), f());
    }

    public b.a.a.c h()
    {
        return b.a.a.c.q.a(b.a.a.d.d(), f());
    }

    public l i()
    {
        return b.a.a.c.r.a(b.a.a.m.c());
    }

    public b.a.a.c j()
    {
        return b.a.a.c.q.a(b.a.a.d.e(), i());
    }

    public b.a.a.c k()
    {
        return b.a.a.c.q.a(b.a.a.d.f(), i());
    }

    public l l()
    {
        return b.a.a.c.r.a(b.a.a.m.d());
    }

    public b.a.a.c m()
    {
        return b.a.a.c.q.a(b.a.a.d.g(), l());
    }

    public b.a.a.c n()
    {
        return b.a.a.c.q.a(b.a.a.d.h(), l());
    }

    public l o()
    {
        return b.a.a.c.r.a(b.a.a.m.e());
    }

    public b.a.a.c p()
    {
        return b.a.a.c.q.a(b.a.a.d.i(), l());
    }

    public b.a.a.c q()
    {
        return b.a.a.c.q.a(b.a.a.d.j(), l());
    }

    public b.a.a.c r()
    {
        return b.a.a.c.q.a(b.a.a.d.k(), o());
    }

    public l s()
    {
        return b.a.a.c.r.a(b.a.a.m.f());
    }

    public b.a.a.c t()
    {
        return b.a.a.c.q.a(b.a.a.d.l(), s());
    }

    public b.a.a.c u()
    {
        return b.a.a.c.q.a(b.a.a.d.m(), s());
    }

    public b.a.a.c v()
    {
        return b.a.a.c.q.a(b.a.a.d.n(), s());
    }

    public l w()
    {
        return b.a.a.c.r.a(b.a.a.m.g());
    }

    public b.a.a.c x()
    {
        return b.a.a.c.q.a(b.a.a.d.o(), w());
    }

    public l y()
    {
        return b.a.a.c.r.a(b.a.a.m.h());
    }

    public b.a.a.c z()
    {
        return b.a.a.c.q.a(b.a.a.d.p(), y());
    }
}
