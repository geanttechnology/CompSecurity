// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ad extends Enum
{

    public static final ad a;
    public static final ad b;
    public static final ad c;
    private static final ad d[];

    private ad(String s, int i)
    {
        super(s, i);
    }

    public static ad[] a()
    {
        return (ad[])d.clone();
    }

    static 
    {
        a = new ad("ABOUT_TO_SEND", 0);
        b = new ad("REQUEST_SENT", 1);
        c = new ad("ERROR", 2);
        d = (new ad[] {
            a, b, c
        });
    }
}
