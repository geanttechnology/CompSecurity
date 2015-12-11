// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;


final class dg extends Enum
{

    public static final dg a;
    public static final dg b;
    public static final dg c;
    public static final dg d;
    public static final dg e;
    public static final dg f;
    private static final dg g[];

    private dg(String s, int i)
    {
        super(s, i);
    }

    public static dg valueOf(String s)
    {
        return (dg)Enum.valueOf(netswipe/dg, s);
    }

    public static dg[] values()
    {
        return (dg[])g.clone();
    }

    static 
    {
        a = new dg("EMPTY_ARRAY", 0);
        b = new dg("NONEMPTY_ARRAY", 1);
        c = new dg("EMPTY_OBJECT", 2);
        d = new dg("DANGLING_KEY", 3);
        e = new dg("NONEMPTY_OBJECT", 4);
        f = new dg("NULL", 5);
        g = (new dg[] {
            a, b, c, d, e, f
        });
    }
}
