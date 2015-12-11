// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class btf extends bqg
    implements bnj, bvz
{

    private final dvk a;
    private final bvz b;

    public btf(dvk dvk1, bvz bvz1)
    {
        a = (dvk)b.a(dvk1);
        b = bvz1;
        if (dvk1.b != null)
        {
            bvz1 = dvk1.b.a;
            dvk1 = dvk1.b.b;
        }
    }

    public final void a(bnk bnk1)
    {
        bnk1.a();
    }

    public final byte[] a()
    {
        return a.c;
    }

    public final bvz b()
    {
        return b;
    }

    public final dre c()
    {
        return a.a;
    }
}
