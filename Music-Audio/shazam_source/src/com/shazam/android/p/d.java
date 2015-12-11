// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.p;


public final class d extends Enum
{

    public static final d A;
    public static final d B;
    public static final d C;
    public static final d D;
    public static final d E;
    public static final d F;
    public static final d G;
    public static final d H;
    public static final d I;
    public static final d J;
    public static final d K;
    public static final d L;
    public static final d M;
    public static final d N;
    public static final d O;
    public static final d P;
    private static final d S[];
    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    public static final d e;
    public static final d f;
    public static final d g;
    public static final d h;
    public static final d i;
    public static final d j;
    public static final d k;
    public static final d l;
    public static final d m;
    public static final d n;
    public static final d o;
    public static final d p;
    public static final d q;
    public static final d r;
    public static final d s;
    public static final d t;
    public static final d u;
    public static final d v;
    public static final d w;
    public static final d x;
    public static final d y;
    public static final d z;
    public final int Q;
    private final int R;

    private d(String s1, int i1, int j1, int k1)
    {
        super(s1, i1);
        R = j1;
        Q = k1;
    }

    public static d a()
    {
        d d1 = null;
        d ad[] = values();
        int j1 = ad.length;
        int i1 = 0;
        while (i1 < j1) 
        {
            d d3 = ad[i1];
            d d2;
            if (d1 == null)
            {
                d2 = d3;
            } else
            {
                d2 = d3;
                if (d3.R <= d1.R)
                {
                    d2 = d1;
                }
            }
            i1++;
            d1 = d2;
        }
        return d1;
    }

    public static d valueOf(String s1)
    {
        return (d)Enum.valueOf(com/shazam/android/p/d, s1);
    }

    public static d[] values()
    {
        return (d[])S.clone();
    }

    static 
    {
        a = new d("VERSION_5_12_0", 0, 42, 110);
        b = new d("VERSION_5_7_0", 1, 41, 109);
        c = new d("VERSION_5_6_0", 2, 40, 107);
        d = new d("VERSION_5_5_0", 3, 39, 104);
        e = new d("VERSION_5_1_0", 4, 38, 103);
        f = new d("VERSION_5_0_0", 5, 37, 102);
        g = new d("VERSION_4_9_1", 6, 36, 101);
        h = new d("VERSION_4_9_0", 7, 35, 100);
        i = new d("VERSION_4_8_0", 8, 34, 99);
        j = new d("VERSION_4_7_0", 9, 33, 98);
        k = new d("VERSION_4_6_0", 10, 32, 97);
        l = new d("VERSION_4_5_0", 11, 31, 96);
        m = new d("VERSION_4_3_0", 12, 30, 93);
        n = new d("VERSION_4_1_0", 13, 29, 92);
        o = new d("VERSION_4_0_0", 14, 28, 91);
        p = new d("VERSION_3_11_0", 15, 27, 88);
        q = new d("VERSION_3_10_0", 16, 26, 87);
        r = new d("VERSION_3_9_4", 17, 25, 86);
        s = new d("VERSION_3_9_3", 18, 24, 86);
        t = new d("VERSION_3_9_2", 19, 23, 86);
        u = new d("VERSION_3_9_1", 20, 22, 86);
        v = new d("VERSION_3_9_0", 21, 21, 86);
        w = new d("VERSION_3_8_0", 22, 20, 85);
        x = new d("VERSION_3_7_0", 23, 19, 83);
        y = new d("VERSION_3_6_1", 24, 18, 82);
        z = new d("VERSION_3_6_0", 25, 17, 81);
        A = new d("VERSION_3_5_0", 26, 16, 78);
        B = new d("VERSION_3_4_0", 27, 15, 78);
        C = new d("VERSION_3_3_0", 28, 14, 75);
        D = new d("VERSION_3_2_1", 29, 13, 56);
        E = new d("VERSION_3_1_0", 30, 12, 53);
        F = new d("VERSION_3_0_0", 31, 11, 51);
        G = new d("VERSION_2_5_3", 32, 10, 16);
        H = new d("VERSION_2_5_1", 33, 9, 15);
        I = new d("VERSION_2_5_0", 34, 8, 15);
        J = new d("VERSION_2_1_1", 35, 7, 5);
        K = new d("VERSION_2_1_0", 36, 6, 5);
        L = new d("VERSION_2_0_2", 37, 5, 4);
        M = new d("VERSION_2_0_0", 38, 4, 4);
        N = new d("VERSION_1_3", 39, 3, 2);
        O = new d("VERSION_1_2", 40, 2, 2);
        P = new d("VERSION_1_1", 41, 1, 2);
        S = (new d[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r, s, t, 
            u, v, w, x, y, z, A, B, C, D, 
            E, F, G, H, I, J, K, L, M, N, 
            O, P
        });
    }
}
