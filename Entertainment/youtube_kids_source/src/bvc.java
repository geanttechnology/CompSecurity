// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bvc extends Enum
{

    public static final bvc a;
    public static final bvc b;
    public static final bvc c;
    public static final bvc d;
    private static final bvc f[];
    public final String e;

    private bvc(String s, int i, String s1)
    {
        super(s, i);
        e = s1;
    }

    public static bvc valueOf(String s)
    {
        return (bvc)Enum.valueOf(bvc, s);
    }

    public static bvc[] values()
    {
        return (bvc[])f.clone();
    }

    static 
    {
        a = new bvc("ADSENSE", 0, "2");
        b = new bvc("DOUBLECLICK", 1, "1");
        c = new bvc("FREEWHEEL", 2, "4");
        d = new bvc("UNKNOWN", 3, "0");
        f = (new bvc[] {
            a, b, c, d
        });
    }
}
