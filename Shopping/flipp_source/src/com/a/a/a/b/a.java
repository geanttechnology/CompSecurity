// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.b;


public final class a extends Enum
{

    public static final a a;
    public static final a b;
    public static final a c;
    public static final a d;
    public static final a e;
    public static final a f;
    public static final a g;
    public static final a h;
    public static final a i;
    public static final a j;
    public static final a k;
    public static final a l;
    public static final a m;
    public static final a n;
    private static final a r[];
    public final int o;
    public final int p;
    public final int q;

    private a(String s, int i1, int j1, int k1, int l1)
    {
        super(s, i1);
        o = j1;
        p = k1;
        q = l1;
    }

    public static a a(int i1)
    {
        a aa[] = values();
        int k1 = aa.length;
        for (int j1 = 0; j1 < k1; j1++)
        {
            a a1 = aa[j1];
            if (a1.p == i1)
            {
                return a1;
            }
        }

        return null;
    }

    public static a b(int i1)
    {
        a aa[] = values();
        int k1 = aa.length;
        for (int j1 = 0; j1 < k1; j1++)
        {
            a a1 = aa[j1];
            if (a1.o == i1)
            {
                return a1;
            }
        }

        return null;
    }

    public static a c(int i1)
    {
        a aa[] = values();
        int k1 = aa.length;
        for (int j1 = 0; j1 < k1; j1++)
        {
            a a1 = aa[j1];
            if (a1.q == i1)
            {
                return a1;
            }
        }

        return null;
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/a/a/a/b/a, s);
    }

    public static a[] values()
    {
        return (a[])r.clone();
    }

    static 
    {
        a = new a("NO_ERROR", 0, 0, -1, 0);
        b = new a("PROTOCOL_ERROR", 1, 1, 1, 1);
        c = new a("INVALID_STREAM", 2, 1, 2, -1);
        d = new a("UNSUPPORTED_VERSION", 3, 1, 4, -1);
        e = new a("STREAM_IN_USE", 4, 1, 8, -1);
        f = new a("STREAM_ALREADY_CLOSED", 5, 1, 9, -1);
        g = new a("INTERNAL_ERROR", 6, 2, 6, 2);
        h = new a("FLOW_CONTROL_ERROR", 7, 3, 7, -1);
        i = new a("STREAM_CLOSED", 8, 5, -1, -1);
        j = new a("FRAME_TOO_LARGE", 9, 6, 11, -1);
        k = new a("REFUSED_STREAM", 10, 7, 3, -1);
        l = new a("CANCEL", 11, 8, 5, -1);
        m = new a("COMPRESSION_ERROR", 12, 9, -1, -1);
        n = new a("INVALID_CREDENTIALS", 13, -1, 10, -1);
        r = (new a[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n
        });
    }
}
