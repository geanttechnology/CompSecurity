// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;


// Referenced classes of package a.a:
//            ed, aa, em, ao, 
//            ay, cg, do, ea, 
//            dv, ae, dn

final class nit> extends ed
{

    final Throwable a;
    final long b;
    final aa c;

    public final void a()
    {
        if (!c.f.b())
        {
            ao ao1 = new ao(a, b);
            ao1.a("current_session", c.k);
            ao1.f = "he";
            if (c.h.a(ao1))
            {
                aa.a.a(new cg(ao1.c, ao1.d));
                if (c.p.a())
                {
                    ea ea1 = new ea(c.c);
                    ea1.a(c.h, new dv(), c.u.k(), "/android_v2/handle_exceptions", null, aa.a, new dn());
                    ea1.a(c.q, c.r);
                    c.p.b();
                    return;
                }
            }
        }
    }

    .Throwable(aa aa1, Throwable throwable, long l)
    {
        c = aa1;
        a = throwable;
        b = l;
        super();
    }
}
