// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


public final class hn extends Enum
{

    public static final hn a;
    public static final hn b;
    public static final hn c;
    public static final hn d;
    public static final hn e;
    public static final hn f;
    public static final hn g;
    public static final hn h;
    private static hn l;
    private static hn m;
    private static hn n;
    private static hn o;
    private static hn p;
    private static hn q;
    private static hn r;
    private static hn s;
    private static hn t;
    private static hn u;
    private static final hn v[];
    public final int i;
    public final int j;
    public final int k;

    private hn(String s1, int i1, int j1, int k1, int l1)
    {
        super(s1, i1);
        i = j1;
        j = k1;
        k = l1;
    }

    public static hn a(int i1)
    {
        hn ahn[] = values();
        int k1 = ahn.length;
        for (int j1 = 0; j1 < k1; j1++)
        {
            hn hn1 = ahn[j1];
            if (hn1.j == i1)
            {
                return hn1;
            }
        }

        return null;
    }

    public static hn b(int i1)
    {
        hn ahn[] = values();
        int k1 = ahn.length;
        for (int j1 = 0; j1 < k1; j1++)
        {
            hn hn1 = ahn[j1];
            if (hn1.i == i1)
            {
                return hn1;
            }
        }

        return null;
    }

    public static hn c(int i1)
    {
        hn ahn[] = values();
        int k1 = ahn.length;
        for (int j1 = 0; j1 < k1; j1++)
        {
            hn hn1 = ahn[j1];
            if (hn1.k == i1)
            {
                return hn1;
            }
        }

        return null;
    }

    public static hn valueOf(String s1)
    {
        return (hn)Enum.valueOf(com/paypal/android/sdk/hn, s1);
    }

    public static hn[] values()
    {
        return (hn[])v.clone();
    }

    static 
    {
        a = new hn("NO_ERROR", 0, 0, -1, 0);
        b = new hn("PROTOCOL_ERROR", 1, 1, 1, 1);
        c = new hn("INVALID_STREAM", 2, 1, 2, -1);
        l = new hn("UNSUPPORTED_VERSION", 3, 1, 4, -1);
        d = new hn("STREAM_IN_USE", 4, 1, 8, -1);
        m = new hn("STREAM_ALREADY_CLOSED", 5, 1, 9, -1);
        e = new hn("INTERNAL_ERROR", 6, 2, 6, 2);
        f = new hn("FLOW_CONTROL_ERROR", 7, 3, 7, -1);
        n = new hn("STREAM_CLOSED", 8, 5, -1, -1);
        o = new hn("FRAME_TOO_LARGE", 9, 6, 11, -1);
        g = new hn("REFUSED_STREAM", 10, 7, 3, -1);
        h = new hn("CANCEL", 11, 8, 5, -1);
        p = new hn("COMPRESSION_ERROR", 12, 9, -1, -1);
        q = new hn("CONNECT_ERROR", 13, 10, -1, -1);
        r = new hn("ENHANCE_YOUR_CALM", 14, 11, -1, -1);
        s = new hn("INADEQUATE_SECURITY", 15, 12, -1, -1);
        t = new hn("HTTP_1_1_REQUIRED", 16, 13, -1, -1);
        u = new hn("INVALID_CREDENTIALS", 17, -1, 10, -1);
        v = (new hn[] {
            a, b, c, l, d, m, e, f, n, o, 
            g, h, p, q, r, s, t, u
        });
    }
}
