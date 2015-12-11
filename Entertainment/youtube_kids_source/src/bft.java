// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bft extends Enum
{

    public static final bft a;
    public static final bft b;
    public static final bft c;
    public static final bft d;
    public static final bft e;
    public static final bft f;
    private static final bft g[];

    private bft(String s, int i)
    {
        super(s, i);
    }

    public static bft valueOf(String s)
    {
        return (bft)Enum.valueOf(bft, s);
    }

    public static bft[] values()
    {
        return (bft[])g.clone();
    }

    static 
    {
        a = new bft("TIME", 0);
        b = new bft("PERCENTAGE", 1);
        c = new bft("PRE_ROLL", 2);
        d = new bft("POST_ROLL", 3);
        e = new bft("POSITIONAL", 4);
        f = new bft("UNKNOWN", 5);
        g = (new bft[] {
            a, b, c, d, e, f
        });
    }
}
