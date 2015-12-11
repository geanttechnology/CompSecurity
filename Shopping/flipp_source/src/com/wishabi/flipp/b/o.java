// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;


public final class o extends Enum
{

    public static final o a;
    public static final o b;
    public static final o c;
    public static final o d;
    public static final o e;
    public static final o f;
    public static final o g;
    public static final o h;
    public static final o i;
    public static final o j;
    public static final o k;
    public static final o l;
    private static final o o[];
    final int m;
    final String n;

    private o(String s, int i1, int j1, String s1)
    {
        super(s, i1);
        m = j1;
        n = s1;
    }

    public static o valueOf(String s)
    {
        return (o)Enum.valueOf(com/wishabi/flipp/b/o, s);
    }

    public static o[] values()
    {
        return (o[])o.clone();
    }

    static 
    {
        a = new o("INFO", 0, 0, "open");
        b = new o("GOTO_MERCHANT", 1, 1, "TTM");
        c = new o("SHARE_FACEBOOK", 2, 2, "shareFB");
        d = new o("SHARE_TWITTER", 3, 3, "shareTwitter");
        e = new o("ADD_TO_SHOPPING_LIST", 4, 4, "add");
        f = new o("SHARE_URL", 5, 5, "shareURL");
        g = new o("SHARE_GOOGLE", 6, 6, "shareGoogle");
        h = new o("SHARE_PINTEREST", 7, 7, "sharePinterest");
        i = new o("ADD_TO_SHOPPING_CART", 8, 8, "cart");
        j = new o("SHARE_EMAIL", 9, 9, "shareEmail");
        k = new o("SHARE_SMS", 10, 10, "shareSMS");
        l = new o("VIDEO", 11, 11, "video");
        o = (new o[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l
        });
    }
}
