// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class acd
{

    private final int a;
    private final abz b;
    private final acc c;

    public acd(int i, abz abz1, acc acc)
    {
        a = i;
        b = abz1;
        c = acc;
    }

    public acd(abz abz1, acc acc)
    {
        this(0, abz1, acc);
    }

    public long a()
    {
        return b.getDelayMillis(a);
    }

    public acd b()
    {
        return new acd(a + 1, b, c);
    }

    public acd c()
    {
        return new acd(b, c);
    }
}
