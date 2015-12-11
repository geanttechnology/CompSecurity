// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class exs extends eug
{

    private int a;

    public exs()
    {
        a = -1;
    }

    public final int a()
    {
        if (a < 0)
        {
            a = 0;
        }
        return a;
    }

    public final eug a(eud eud1)
    {
_L3:
        int i = eud1.a();
        i;
        JVM INSTR tableswitch 0 0: default 24
    //                   0 32;
           goto _L1 _L2
_L1:
        if (a(eud1, i)) goto _L3; else goto _L2
_L2:
        return this;
    }

    public final void a(eue eue)
    {
    }

    public final int b()
    {
        a = 0;
        return 0;
    }
}
