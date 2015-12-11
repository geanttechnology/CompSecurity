// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cuv extends Enum
{

    public static final cuv a;
    public static final cuv b;
    public static final cuv c;
    public static final cuv d;
    public static final cuv e;
    public static final cuv f;
    public static final cuv g;
    private static final cuv h[];

    private cuv(String s, int i)
    {
        super(s, i);
    }

    public static cuv valueOf(String s)
    {
        return (cuv)Enum.valueOf(cuv, s);
    }

    public static cuv[] values()
    {
        return (cuv[])h.clone();
    }

    public final boolean a()
    {
        return this == e || this == f;
    }

    public final boolean b()
    {
        return this == b || this == c || this == g;
    }

    public final boolean c()
    {
        return b() || this == d;
    }

    static 
    {
        a = new cuv("NEW", 0);
        b = new cuv("PLAYING", 1);
        c = new cuv("PAUSED", 2);
        d = new cuv("LOADING", 3);
        e = new cuv("RECOVERABLE_ERROR", 4);
        f = new cuv("UNRECOVERABLE_ERROR", 5);
        g = new cuv("ENDED", 6);
        h = (new cuv[] {
            a, b, c, d, e, f, g
        });
    }
}
