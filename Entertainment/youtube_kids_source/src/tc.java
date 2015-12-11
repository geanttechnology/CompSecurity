// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class tc extends Enum
{

    private static tc a;
    private static tc b;
    private static tc c;
    private static tc d;
    private static tc e;
    private static final tc g[];
    private int f;

    private tc(String s, int i, int j, int k)
    {
        super(s, i);
        f = k;
    }

    public static int a()
    {
        return values()[0].f;
    }

    public static tc valueOf(String s)
    {
        return (tc)Enum.valueOf(tc, s);
    }

    public static tc[] values()
    {
        return (tc[])g.clone();
    }

    static 
    {
        a = new tc("NONE", 0, 0x7f0b00ba, 0);
        b = new tc("UNIFORM", 1, 0x7f0b00d4, 1);
        c = new tc("DROP_SHADOW", 2, 0x7f0b00d5, 2);
        d = new tc("RAISED", 3, 0x7f0b00d6, 3);
        e = new tc("DEPRESSED", 4, 0x7f0b00d7, 4);
        g = (new tc[] {
            a, b, c, d, e
        });
    }
}
