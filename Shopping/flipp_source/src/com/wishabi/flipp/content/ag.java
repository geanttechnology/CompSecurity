// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;


public final class ag extends Enum
{

    public static final ag a;
    public static final ag b;
    public static final ag c;
    public static final ag d;
    public static final ag e;
    public static final ag f;
    public static final ag g;
    public static final ag h;
    public static final ag i;
    public static final ag j;
    public static final ag k;
    public static final ag l;
    public static final ag m;
    public static final ag n;
    public static final ag o;
    public static final ag p;
    public static final ag q;
    public static final ag r;
    public static final ag s;
    public static final ag t;
    public static final ag u;
    public static final int v[];
    private static final ag x[];
    public final int w;

    private ag(String s1, int i1, int j1)
    {
        super(s1, i1);
        w = j1;
    }

    public static ag a(int i1)
    {
        ag aag[] = values();
        int k1 = aag.length;
        for (int j1 = 0; j1 < k1; j1++)
        {
            ag ag1 = aag[j1];
            if (ag1.w == i1)
            {
                return ag1;
            }
        }

        return null;
    }

    public static boolean b(int i1)
    {
        boolean flag1 = false;
        int ai[] = v;
        int k1 = ai.length;
        int j1 = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (j1 < k1)
                {
                    if (ai[j1] != i1)
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            j1++;
        } while (true);
    }

    public static ag valueOf(String s1)
    {
        return (ag)Enum.valueOf(com/wishabi/flipp/content/ag, s1);
    }

    public static ag[] values()
    {
        return (ag[])x.clone();
    }

    static 
    {
        a = new ag("ITEM", 0, 1);
        b = new ag("COUPON", 1, 2);
        c = new ag("VIDEO", 2, 3);
        d = new ag("LINK", 3, 5);
        e = new ag("PAGE_LINK", 4, 7);
        f = new ag("CUSTOM_HTML", 5, 8);
        g = new ag("SIDE_SUB_ITEMS", 6, 10);
        h = new ag("CUSTOM_LIST", 7, 11);
        i = new ag("SHARE_FB", 8, 12);
        j = new ag("SHARE_TWITTER", 9, 13);
        k = new ag("ITEM_SIDE_LIST", 10, 14);
        l = new ag("IFRAME", 11, 15);
        m = new ag("ONLY_FEATURE_HTML", 12, 16);
        n = new ag("SPOTLIGHT", 13, 17);
        o = new ag("ITEM_SIDE_GRID", 14, 18);
        p = new ag("KEYFRAME", 15, 20);
        q = new ag("CATEGORY_SPOTLIGHT", 16, 21);
        r = new ag("ITEM_GROUP", 17, 22);
        s = new ag("ITEM_CORRECTION", 18, 23);
        t = new ag("TEXT_CONTENT", 19, 24);
        u = new ag("COUPON_V2", 20, 25);
        x = (new ag[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r, s, t, 
            u
        });
        v = (new int[] {
            u.w
        });
    }
}
