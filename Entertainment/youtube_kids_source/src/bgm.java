// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bgm
{

    private final cpz a;
    private final cpz b;
    private final bmi c;
    private final bje d;
    private final ctw e;
    private final bcy f;
    private final crh g;
    private bfi h;

    public bgm(cpz cpz1, cpz cpz2, bmi bmi1, bje bje1, ctw ctw1, bcy bcy1, bfi bfi1, 
            crh crh1)
    {
        a = (cpz)b.a(cpz1);
        b = (cpz)b.a(cpz2);
        c = (bmi)b.a(bmi1);
        d = (bje)b.a(bje1);
        e = (ctw)b.a(ctw1);
        h = (bfi)b.a(bfi1);
        f = (bcy)b.a(bcy1);
        g = (crh)b.a(crh1);
    }

    private bgf a(bfz bfz1)
    {
        if (bfz1 != null && bfz1.j != null)
        {
            bfz1 = bfz1.j.b;
        } else
        {
            bfz1 = null;
        }
        return new bgf(a, b, bfz1, c);
    }

    public final bgi a(bfz bfz1, buz buz1, String s)
    {
        bcw bcw;
        if (buz1.n.n())
        {
            bcw = f.a();
        } else
        {
            bcw = null;
        }
        bfz1 = new bgp(d, a(bfz1), bfz1, buz1, s, e.g(), bcw, g, h.a());
        bfz1.n();
        return bfz1;
    }

    public final bgi a(bfz bfz1, buz buz1, String s, bgj bgj1)
    {
        if (bgj1 == null)
        {
            return null;
        }
        if (bgj1.g == bgl.a)
        {
            bcw bcw;
            if (buz1.n.n())
            {
                bcw = f.a();
            } else
            {
                bcw = null;
            }
            bfz1 = new bgp(d, a(bfz1), bfz1, buz1, s, bgj1.a, bgj1.b, bgj1.c, bgj1.d, bgj1.e, bgj1.f, e.g(), bcw, g, h.a());
            bfz1.n();
            return bfz1;
        }
        if (bgj1.g == bgl.b)
        {
            bfz1 = new bgn(d, a(null), buz1, s, bgj1.a, bgj1.c, bgj1.f, e.g(), g, h.a());
            bfz1.n();
            return bfz1;
        } else
        {
            return null;
        }
    }

    public final bgi a(bfz bfz1, String s)
    {
        bvd bvd1 = buz.a.a();
        bvd1.S = 0x7fffffffffffffffL;
        return a(bfz1, bvd1.a(), s);
    }

    public final bgi a(buz buz1, String s)
    {
        buz1 = new bgn(d, a(null), buz1, s, e.g(), g, h.a());
        buz1.n();
        return buz1;
    }

    public final bgi a(String s, cry cry)
    {
        cry = (bfm)cry;
        if (((bfm) (cry)).b == null)
        {
            return a(((bfm) (cry)).a, s);
        } else
        {
            return a(((bfm) (cry)).a, ((bfm) (cry)).b, s);
        }
    }
}
