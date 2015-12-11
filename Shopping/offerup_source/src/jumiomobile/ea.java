// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


public final class ea extends Enum
{

    public static final ea a;
    public static final ea b;
    public static final ea c;
    public static final ea d;
    public static final ea e;
    public static final ea f;
    private static final ea g[];

    private ea(String s, int i)
    {
        super(s, i);
    }

    public static ea valueOf(String s)
    {
        return (ea)Enum.valueOf(jumiomobile/ea, s);
    }

    public static ea[] values()
    {
        return (ea[])g.clone();
    }

    static 
    {
        a = new ea("STOP", 0);
        b = new ea("INIT", 1);
        c = new ea("SCAN", 2);
        d = new ea("ADDITIONAL_ENTRY", 3);
        e = new ea("MANUAL_ENTRY", 4);
        f = new ea("ERROR", 5);
        g = (new ea[] {
            a, b, c, d, e, f
        });
    }
}
