// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class amj extends Enum
{

    public static final amj a;
    public static final amj b;
    public static final amj c;
    public static final amj d;
    public static final amj e;
    public static final amj f;
    private static final amj g[];

    private amj(String s, int i)
    {
        super(s, i);
    }

    public static amj valueOf(String s)
    {
        return (amj)Enum.valueOf(amj, s);
    }

    public static amj[] values()
    {
        return (amj[])g.clone();
    }

    public final boolean a()
    {
        return this == a || this == b;
    }

    static 
    {
        a = new amj("CONNECTING", 0);
        b = new amj("CONNECTED", 1);
        c = new amj("SLEEP", 2);
        d = new amj("DISCONNECTING", 3);
        e = new amj("OFFLINE", 4);
        f = new amj("ERROR", 5);
        g = (new amj[] {
            a, b, c, d, e, f
        });
    }
}
