// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cae extends bzn
{

    private final bnq b;

    public cae(bns bns)
    {
        super(bns);
        bns = cov.a();
        bns.a("/feed/entry", new cag());
        a.b(bns, "/feed/entry");
        b = bns.a();
    }

    protected final bnq a()
    {
        return b;
    }
}
