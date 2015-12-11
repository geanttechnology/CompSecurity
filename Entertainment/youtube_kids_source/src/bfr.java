// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bfr extends Enum
{

    public static final bfr a;
    public static final bfr b;
    public static final bfr c;
    private static final bfr e[];
    public int d;

    private bfr(String s, int i, int j)
    {
        super(s, i);
        d = j;
    }

    public static bfr valueOf(String s)
    {
        return (bfr)Enum.valueOf(bfr, s);
    }

    public static bfr[] values()
    {
        return (bfr[])e.clone();
    }

    static 
    {
        a = new bfr("PRE_ROLL", 0, 1);
        b = new bfr("MID_ROLL", 1, 2);
        c = new bfr("POST_ROLL", 2, 3);
        e = (new bfr[] {
            a, b, c
        });
    }
}
