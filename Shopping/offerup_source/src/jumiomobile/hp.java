// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


public final class hp extends Enum
{

    public static final hp a;
    public static final hp b;
    public static final hp c;
    public static final hp d;
    private static final hp l[];
    private double e;
    private double f;
    private double g;
    private double h;
    private double i;
    private double j;
    private double k;

    private hp(String s, int i1, double d1, double d2, double d3, double d4, double d5, double d6, 
            double d7)
    {
        super(s, i1);
        e = d1;
        f = d2;
        g = d3;
        h = d4;
        i = d5;
        j = d6;
        k = d7;
    }

    public static hp valueOf(String s)
    {
        return (hp)Enum.valueOf(jumiomobile/hp, s);
    }

    public static hp[] values()
    {
        return (hp[])l.clone();
    }

    public final double a()
    {
        return e;
    }

    public final int a(int i1)
    {
        return (int)((double)i1 * g);
    }

    public final double b()
    {
        return f;
    }

    public final int b(int i1)
    {
        return (int)((double)i1 * h);
    }

    public final double c()
    {
        return g;
    }

    public final int c(int i1)
    {
        return (int)((double)i1 * e);
    }

    public final double d()
    {
        return h;
    }

    public final int d(int i1)
    {
        return (int)((double)i1 * f);
    }

    public final double e()
    {
        return i;
    }

    public final int e(int i1)
    {
        return (int)((double)(i1 - c(i1) * 2) * j);
    }

    public final double f()
    {
        return j;
    }

    public final int f(int i1)
    {
        return (int)((double)(i1 - c(i1) * 2) * k);
    }

    static 
    {
        a = new hp("NONE", 0, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
        b = new hp("ID1", 1, 0.13600000000000001D, 0.13600000000000001D, 0.067500000000000004D, 0.067500000000000004D, 1.585185185185185D, 0.24000000000000002D, 0.095462962962962972D);
        c = new hp("ID2", 2, 0.093600000000000003D, 0.093600000000000003D, 0.067500000000000004D, 0.067500000000000004D, 1.4189189189189189D, 0.17162162162162162D, 0.084121621621621623D);
        d = new hp("ID3", 3, 0.021999999999999999D, 0.021999999999999999D, 0.021999999999999999D, 0.021999999999999999D, 1.4119318181818181D, 0.23531818181818179D, 0.0D);
        l = (new hp[] {
            a, b, c, d
        });
    }
}
