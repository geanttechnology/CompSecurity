// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class tj extends Enum
{

    public static final tj a;
    public static final tj b;
    public static final tj c;
    public static final tj d;
    public static final tj e;
    private static final tj g[];
    private int f;

    private tj(String s, int i, int j, int k)
    {
        super(s, i);
        f = k;
    }

    public static int a()
    {
        return values()[0].f;
    }

    static int a(tj tj1)
    {
        return tj1.f;
    }

    public static tj valueOf(String s)
    {
        return (tj)Enum.valueOf(tj, s);
    }

    public static tj[] values()
    {
        return (tj[])g.clone();
    }

    static 
    {
        a = new tj("WHITE_ON_BLACK", 0, 0x7f0b00c8, 0);
        b = new tj("BLACK_ON_WHITE", 1, 0x7f0b00c9, 1);
        c = new tj("YELLOW_ON_BLACK", 2, 0x7f0b00ca, 2);
        d = new tj("YELLOW_ON_BLUE", 3, 0x7f0b00cb, 3);
        e = new tj("CUSTOM", 4, 0x7f0b00cc, 4);
        g = (new tj[] {
            a, b, c, d, e
        });
    }
}
