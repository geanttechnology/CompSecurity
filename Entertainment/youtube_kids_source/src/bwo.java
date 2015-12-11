// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bwo
{

    public final dqp a;
    public final boolean b;
    public final boolean c;

    public bwo()
    {
        a = new dqp();
        b = false;
        c = false;
    }

    public bwo(dqp dqp1)
    {
        boolean flag1 = true;
        super();
        a = (dqp)b.a(dqp1);
        boolean flag;
        if (a.c <= 10000 && a.c >= -10000 && a.d <= 10000 && a.d > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b = flag;
        if (a.a <= 10000 && a.a >= -10000 && a.b <= 10000 && a.b > 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        c = flag;
    }
}
