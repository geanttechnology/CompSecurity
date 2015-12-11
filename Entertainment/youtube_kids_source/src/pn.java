// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class pn
    implements pq
{

    private ph a;

    pn(ph ph1)
    {
        a = ph1;
        super();
    }

    public final int a()
    {
        byte byte0;
        if (ph.d(a) > 0)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        return byte0 + 7;
    }

    public final void a(bnf bnf1)
    {
        bnf1.a("conn", ph.e(a).g());
        if (ph.d(a) > 0)
        {
            bnf1.a("fmt", ph.d(a));
        }
    }
}
