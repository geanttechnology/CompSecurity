// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


public final class ad extends Enum
{

    public static final ad a;
    public static final ad b;
    public static final ad c;
    public static final ad d;
    private static final ad e[];

    private ad(String s, int i)
    {
        super(s, i);
    }

    public static ad valueOf(String s)
    {
        return (ad)Enum.valueOf(jumiomobile/ad, s);
    }

    public static ad[] values()
    {
        return (ad[])e.clone();
    }

    static 
    {
        a = new ad("UPPER_RIGHT", 0);
        b = new ad("UPPER_LEFT", 1);
        c = new ad("LOWER_LEFT", 2);
        d = new ad("LOWER_RIGHT", 3);
        e = (new ad[] {
            a, b, c, d
        });
    }
}
