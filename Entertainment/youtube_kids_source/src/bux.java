// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bux extends Enum
{

    public static final bux a;
    public static final bux b;
    public static final bux c;
    private static bux e;
    private static final bux f[];
    public final int d;

    private bux(String s, int i, int j)
    {
        super(s, i);
        d = ((Integer)b.a(Integer.valueOf(j))).intValue();
    }

    public static bux valueOf(String s)
    {
        return (bux)Enum.valueOf(bux, s);
    }

    public static bux[] values()
    {
        return (bux[])f.clone();
    }

    static 
    {
        a = new bux("RANDOMIZE", 0, 0);
        b = new bux("RANDOMLY_REVERSE", 1, 1);
        e = new bux("SORTED", 2, 2);
        c = new bux("UNKNOWN", 3, -1);
        f = (new bux[] {
            a, b, e, c
        });
    }
}
