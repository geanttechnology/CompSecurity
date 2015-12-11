// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


final class y extends Enum
{

    public static final y a;
    public static final y b;
    public static final y c;
    public static final y d;
    public static final y e;
    public static final y f;
    private static final y g[];

    private y(String s, int i)
    {
        super(s, i);
    }

    public static y valueOf(String s)
    {
        return (y)Enum.valueOf(jumiomobile/y, s);
    }

    public static y[] values()
    {
        return (y[])g.clone();
    }

    static 
    {
        a = new y("EMPTY_ARRAY", 0);
        b = new y("NONEMPTY_ARRAY", 1);
        c = new y("EMPTY_OBJECT", 2);
        d = new y("DANGLING_KEY", 3);
        e = new y("NONEMPTY_OBJECT", 4);
        f = new y("NULL", 5);
        g = (new y[] {
            a, b, c, d, e, f
        });
    }
}
