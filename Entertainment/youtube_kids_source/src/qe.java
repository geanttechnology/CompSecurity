// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class qe
    implements mm
{

    private bnx a;
    private int b;

    public qe(bnx bnx1)
    {
        b = 0;
        a = (bnx)b.a(bnx1);
    }

    public final int a()
    {
        return 0;
    }

    public final void a(mp mp)
    {
        if (mp instanceof lq)
        {
            int i = b;
            b = i + 1;
            if (i == 0)
            {
                a.a();
                return;
            }
        }
        throw mp;
    }

    public final int b()
    {
        return b;
    }
}
