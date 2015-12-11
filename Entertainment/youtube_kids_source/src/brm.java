// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public abstract class brm
    implements bnj, bsn, bvz
{

    public final dkq a;
    final bvz b;
    final bvz c = new brn(this);

    brm(dkq dkq1, bvz bvz1)
    {
        a = (dkq)b.a(dkq1);
        b = bvz1;
        b.a(dkq1.a);
    }

    public final void a(bnk bnk)
    {
        ((bnj)d()).a(bnk);
    }

    public final byte[] a()
    {
        return ((bvz)d()).a();
    }

    public final bvz b()
    {
        return ((bvz)d()).b();
    }

    public final dre c()
    {
        return d().c();
    }

    public abstract bsn d();
}
