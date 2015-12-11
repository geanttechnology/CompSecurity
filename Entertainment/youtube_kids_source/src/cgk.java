// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cgk extends Enum
{

    public static final cgk a;
    private static cgk d;
    private static cgk e;
    private static cgk f;
    private static cgk g;
    private static cgk h;
    private static final cgk i[];
    public String b;
    public String c;

    private cgk(String s, int j, String s1, String s2)
    {
        super(s, j);
        b = s1;
        c = s2;
    }

    public static cgk valueOf(String s)
    {
        return (cgk)Enum.valueOf(cgk, s);
    }

    public static cgk[] values()
    {
        return (cgk[])i.clone();
    }

    public final boolean a()
    {
        return this != d;
    }

    static 
    {
        d = new cgk("CLASSIC", 0, "cl", "233637DE");
        a = new cgk("KIDS", 1, "k", "0354A290");
        e = new cgk("INSTANT", 2, "i", "3D6FC48F");
        f = new cgk("CREATOR", 3, "cr", "C261EE20");
        g = new cgk("MUSIC", 4, "m", "2DB7CC49");
        h = new cgk("GAMING", 5, "g", "D6EE3348");
        i = (new cgk[] {
            d, a, e, f, g, h
        });
    }
}
