// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class buc extends bqg
    implements bnj, bvz
{

    private final ebp a;
    private final bvz b;
    private final dre c;

    public buc(ebp ebp1, bvz bvz1)
    {
        a = (ebp)b.a(ebp1);
        b = bvz1;
        c = ebp1.c;
        if (c != null)
        {
            if (c.c != null && c.c.a != null)
            {
                ebp1 = c.c.a;
            } else
            if (c.g != null && c.g.a != null)
            {
                ebp1 = c.g.a;
                return;
            }
        }
    }

    public final void a(bnk bnk1)
    {
        bnk1.a();
    }

    public final byte[] a()
    {
        return a.d;
    }

    public final bvz b()
    {
        return b;
    }

    public final dre c()
    {
        return c;
    }
}
