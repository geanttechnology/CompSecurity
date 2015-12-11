// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.d;


public final class n extends Enum
{

    public static final n a;
    public static final n b;
    public static final n c;
    public static final n d;
    public static final n e;
    public static final n f;
    public static final n g;
    public static final n h;
    public static final n i;
    public static final n j;
    public static final n k;
    public static final n l;
    public static final n m;
    public static final n n;
    public static final n o;
    public static final n p;
    public static final n q;
    public static final n r;
    public static final n s;
    public static final n t;
    private static final n v[];
    public int u;

    private n(String s1, int i1, int j1)
    {
        super(s1, i1);
        u = j1;
    }

    public static n a()
    {
        int j1 = android.os.Build.VERSION.SDK_INT;
        n an[] = values();
        int k1 = an.length;
        for (int i1 = 0; i1 < k1; i1++)
        {
            n n1 = an[i1];
            if (n1.u == j1)
            {
                return n1;
            }
        }

        return t;
    }

    public static n valueOf(String s1)
    {
        return (n)Enum.valueOf(com/mopub/common/d/n, s1);
    }

    public static n[] values()
    {
        return (n[])v.clone();
    }

    public final boolean a(n n1)
    {
        return u >= n1.u;
    }

    static 
    {
        a = new n("BASE", 0, 1);
        b = new n("BASE_1_1", 1, 2);
        c = new n("CUPCAKE", 2, 3);
        d = new n("DONUT", 3, 4);
        e = new n("ECLAIR", 4, 5);
        f = new n("ECLAIR_0_1", 5, 6);
        g = new n("ECLAIR_MR1", 6, 7);
        h = new n("FROYO", 7, 8);
        i = new n("GINGERBREAD", 8, 9);
        j = new n("GINGERBREAD_MR1", 9, 10);
        k = new n("HONEYCOMB", 10, 11);
        l = new n("HONEYCOMB_MR1", 11, 12);
        m = new n("HONEYCOMB_MR2", 12, 13);
        n = new n("ICE_CREAM_SANDWICH", 13, 14);
        o = new n("ICE_CREAM_SANDWICH_MR1", 14, 15);
        p = new n("JELLY_BEAN", 15, 16);
        q = new n("JELLY_BEAN_MR1", 16, 17);
        r = new n("JELLY_BEAN_MR2", 17, 18);
        s = new n("KITKAT", 18, 19);
        t = new n("CUR_DEVELOPMENT", 19, 10000);
        v = (new n[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r, s, t
        });
    }
}
