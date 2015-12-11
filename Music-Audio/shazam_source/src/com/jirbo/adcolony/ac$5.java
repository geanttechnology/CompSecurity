// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            ah, ac, g, f, 
//            ar, aj, x

final class nit> extends ah
{

    final double a;
    final g b;
    final ac c;

    final void a()
    {
        ar ar1 = n.d;
        double d = a;
        g g1 = b;
        double d1 = g1.i;
        if (d >= d1)
        {
            if (d1 < 0.25D && d >= 0.25D)
            {
                if (!f.a(g1.b) && g1.f.equals("native"))
                {
                    ar1.a("native_first_quartile", null, g1);
                } else
                {
                    ar1.a("first_quartile", null, g1);
                }
            }
            if (d1 < 0.5D && d >= 0.5D)
            {
                if (!f.a(g1.b) && g1.f.equals("native"))
                {
                    ar1.a("native_midpoint", null, g1);
                } else
                {
                    ar1.a("midpoint", null, g1);
                }
            }
            if (d1 < 0.75D && d >= 0.75D)
            {
                if (!f.a(g1.b) && g1.f.equals("native"))
                {
                    ar1.a("native_third_quartile", null, g1);
                } else
                {
                    ar1.a("third_quartile", null, g1);
                }
            }
            if (d1 < 1.0D && d >= 1.0D && !g1.f.equals("native"))
            {
                aj.a.a("Tracking ad event - complete");
                nit> nit> = new init>();
                nit>.("ad_slot", g1.c.k.d);
                nit>.("replay", g1.n);
                ar1.a("complete", nit>, g1);
            }
            g1.i = d;
        }
    }

    (ac ac1, ac ac2, double d, g g1)
    {
        c = ac1;
        a = d;
        b = g1;
        super(ac2);
    }
}
