// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cgn extends Enum
{

    public static final cgn a;
    public static final cgn b;
    public static final cgn c;
    public static final cgn d;
    private static cgn e;
    private static final cgn g[];
    private String f;

    private cgn(String s, int i, String s1)
    {
        super(s, i);
        f = s1;
    }

    public static cgn valueOf(String s)
    {
        return (cgn)Enum.valueOf(cgn, s);
    }

    public static cgn[] values()
    {
        return (cgn[])g.clone();
    }

    public final String toString()
    {
        return f;
    }

    static 
    {
        e = new cgn("UNKNOWN", 0, "unknown");
        a = new cgn("MANUAL", 1, "manual");
        b = new cgn("DIAL", 2, "dial");
        c = new cgn("IN_APP_DIAL", 3, "in_app_dial");
        d = new cgn("CAST", 4, "cast");
        g = (new cgn[] {
            e, a, b, c, d
        });
    }
}
