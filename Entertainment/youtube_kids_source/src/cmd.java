// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class cmd extends apb
{

    private final aqr f;
    private final apw g;

    public cmd(art art, arx arx, int i, apw apw1, aqr aqr1)
    {
        super(art, arx, aqr1.b, i);
        g = apw1;
        f = aqr1;
    }

    protected final void a(asn asn)
    {
        int i = g.a(asn, null);
        if (i != 26)
        {
            throw new aop((new StringBuilder(39)).append("Invalid initialization data ").append(i).toString());
        }
        asn = g.a();
        aqo aqo1 = f.g;
        if ((long)((apx) (asn)).a != aqo1.b)
        {
            int j = ((apx) (asn)).a;
            long l = aqo1.b;
            bmo.c((new StringBuilder(79)).append("Sidx length mismatch: sidxLen = ").append(j).append(", ExpectedLen = ").append(l).toString());
        }
        long l1 = cmc.a(g, f, ((apx) (asn)).b - 1);
        l1 = (long)((apx) (asn)).c[((apx) (asn)).b - 1] + l1;
        if (l1 != f.f)
        {
            long l2 = f.f;
            bmo.c((new StringBuilder(86)).append("ContentLength mismatch: Actual = ").append(l1).append(", Expected = ").append(l2).toString());
        }
    }
}
