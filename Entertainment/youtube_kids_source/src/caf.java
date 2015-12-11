// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class caf extends bzn
{

    private final bnq b;

    private caf(bns bns, bnq bnq)
    {
        super(bns);
        b = bnq;
    }

    public static caf b(bns bns)
    {
        bnr bnr1 = new bnr();
        bnr1.a("/entry", new cao());
        a.b(bnr1, "/entry");
        return new caf(bns, bnr1.a());
    }

    public static caf c(bns bns)
    {
        bnr bnr1 = new bnr();
        bnr1.a("/feed", new cah()).a("/feed/subtitle", new cav()).a("/feed/link", new cau()).a("/feed/openSearch:totalResults", new cat());
        a.c(bnr1, "/feed");
        return new caf(bns, bnr1.a());
    }

    protected final bnq a()
    {
        return b;
    }
}
