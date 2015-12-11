// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class bcv extends Enum
{

    public static final bcv a;
    public static final bcv b;
    public static final bcv c;
    public static final bcv d;
    public static final bcv e;
    private static final bcv g[];
    public final double f;

    private bcv(String s, int i, double d1)
    {
        super(s, i);
        f = d1;
    }

    public static bcv valueOf(String s)
    {
        return (bcv)Enum.valueOf(bcv, s);
    }

    public static bcv[] values()
    {
        return (bcv[])g.clone();
    }

    static 
    {
        a = new bcv("FULL", 0, 1.0D);
        b = new bcv("THREE_QUARTER", 1, 0.75D);
        c = new bcv("HALF", 2, 0.5D);
        d = new bcv("QUARTER", 3, 0.25D);
        e = new bcv("NONE", 4, 0.0D);
        g = (new bcv[] {
            a, b, c, d, e
        });
    }
}
