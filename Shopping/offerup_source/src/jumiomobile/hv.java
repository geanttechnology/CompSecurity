// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


public final class hv extends Enum
{

    public static final hv a;
    public static final hv b;
    public static final hv c;
    public static final hv d;
    public static final hv e;
    public static final hv f;
    private static final hv g[];

    private hv(String s, int i)
    {
        super(s, i);
    }

    public static hv valueOf(String s)
    {
        return (hv)Enum.valueOf(jumiomobile/hv, s);
    }

    public static hv[] values()
    {
        return (hv[])g.clone();
    }

    static 
    {
        a = new hv("STOP", 0);
        b = new hv("DESTROY", 1);
        c = new hv("INIT", 2);
        d = new hv("SCAN", 3);
        e = new hv("ERROR", 4);
        f = new hv("US_FALLBACK", 5);
        g = (new hv[] {
            a, b, c, d, e, f
        });
    }
}
