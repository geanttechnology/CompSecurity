// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class btb extends bqg
    implements bnj, bvz
{

    private final duv a;
    private final bvz b;
    private dre c;

    public btb(duv duv1, bvz bvz1)
    {
        a = (duv)b.a(duv1);
        b = bvz1;
        b.a(duv1.a);
        b.a(duv1.b);
        b.a(Long.valueOf(duv1.c));
        b.a(duv1.f);
        b.a(duv1.e);
    }

    public final void a(bnk bnk1)
    {
        bnk1.a();
    }

    public final byte[] a()
    {
        return a.g;
    }

    public final bvz b()
    {
        return b;
    }

    public final dre c()
    {
        if (c == null)
        {
            c = a.d;
        }
        return c;
    }
}
