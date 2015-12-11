// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bnb
{

    private bmi a;
    private long b;

    public bnb(bmi bmi1, long l)
    {
        a = (bmi)b.a(bmi1);
        boolean flag;
        if (l > 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.a(flag);
        b = bmi1.b() + l;
    }

    public final long a()
    {
        long l = b - a.b();
        if (l < 0L)
        {
            return 0L;
        } else
        {
            return l;
        }
    }
}
