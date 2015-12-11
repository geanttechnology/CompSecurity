// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;


public final class p extends Enum
{

    public static final p a;
    public static final p b;
    public static final p c;
    public static final p d;
    public static final p e;
    public static final p f;
    public static final p g;
    public static final p h;
    public static final p i;
    private static final p l[];
    public final int j;
    final String k;

    private p(String s, int i1, int j1, String s1)
    {
        super(s, i1);
        j = j1;
        k = s1;
    }

    public static p a(int i1)
    {
        p ap[] = values();
        int k1 = ap.length;
        for (int j1 = 0; j1 < k1; j1++)
        {
            p p1 = ap[j1];
            if (p1.j == i1)
            {
                return p1;
            }
        }

        return null;
    }

    public static p valueOf(String s)
    {
        return (p)Enum.valueOf(com/wishabi/flipp/b/p, s);
    }

    public static p[] values()
    {
        return (p[])l.clone();
    }

    static 
    {
        a = new p("FLYER", 0, 0, "flyer");
        b = new p("ITEM_DETAILS", 1, 1, "item_details");
        c = new p("SEARCH", 2, 2, "search");
        d = new p("COUPON_LISTING", 3, 3, "coupon_listing");
        e = new p("COUPON_DETAILS", 4, 4, "coupon_details");
        f = new p("CLIPPINGS", 5, 5, "clippings");
        g = new p("SEARCH_MATCHUP", 6, 6, "search_matchup");
        h = new p("CLIPPING_MATCHUP", 7, 7, "clippings_matchup");
        i = new p("PRINT", 8, 8, "print");
        l = (new p[] {
            a, b, c, d, e, f, g, h, i
        });
    }
}
