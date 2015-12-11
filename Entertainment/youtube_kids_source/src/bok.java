// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bok extends bob
{

    private final bol e;
    private final bxs f;
    private final boi g;

    public bok(bxo bxo, bxm bxm, qs qs1, mh mh)
    {
        this(bxo, bxm, qs1, mh, bnk.a, bxs.a, boi.a);
    }

    private bok(bxo bxo, bxm bxm, qs qs1, mh mh, bnk bnk1, bxs bxs1, boi boi1)
    {
        super(bxo, bxm, qs1, mh);
        f = (bxs)b.a(bxs1);
        g = (boi)b.a(boi1);
        e = new bol(this, bnk1);
    }

    public final bom a()
    {
        bom bom1 = new bom(b, c.b(), f);
        g.a();
        return bom1;
    }

    public final void a(bom bom1, mj mj)
    {
        e.b(bom1, mj);
    }
}
