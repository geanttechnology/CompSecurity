// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;


public final class an extends Enum
{

    public static final an a;
    public static final an b;
    public static final an c;
    public static final an d;
    private static final an f[];
    private final int e;

    private an(String s, int i, int j)
    {
        super(s, i);
        e = j;
    }

    public static an valueOf(String s)
    {
        return (an)Enum.valueOf(netswipe/an, s);
    }

    public static an[] values()
    {
        return (an[])f.clone();
    }

    static 
    {
        a = new an("PORTRAIT", 0, 0);
        b = new an("LANDSCAPE", 1, 90);
        c = new an("INVERTED_PORTRAIT", 2, 180);
        d = new an("INVERTED_LANDSCAPE", 3, 270);
        f = (new an[] {
            a, b, c, d
        });
    }
}
