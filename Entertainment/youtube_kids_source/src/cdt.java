// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cdt extends Enum
{

    public static final cdt a;
    private static cdt b;
    private static cdt c;
    private static cdt d;
    private static cdt e;
    private static cdt f;
    private static final cdt g[];

    private cdt(String s, int i)
    {
        super(s, i);
    }

    public static cdt valueOf(String s)
    {
        return (cdt)Enum.valueOf(cdt, s);
    }

    public static cdt[] values()
    {
        return (cdt[])g.clone();
    }

    static 
    {
        b = new cdt("PENDING", 0);
        a = new cdt("ACTIVE", 1);
        c = new cdt("DELAYED", 2);
        d = new cdt("COMPLETED", 3);
        e = new cdt("CANCELLED", 4);
        f = new cdt("REJECTED", 5);
        g = (new cdt[] {
            b, a, c, d, e, f
        });
    }
}
