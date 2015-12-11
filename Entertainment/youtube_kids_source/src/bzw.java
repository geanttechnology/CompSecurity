// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bzw extends bzn
{

    private final bnq b;

    public bzw(bns bns)
    {
        super(bns);
        bns = cov.a("/feed");
        b.a(bns);
        a.a(bns, "/feed");
        bns.a(String.valueOf("/feed").concat("/entry"), new bzy());
        b = bns.a();
    }

    protected final bnq a()
    {
        return b;
    }
}
