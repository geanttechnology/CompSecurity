// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;


// Referenced classes of package com.rhythmnewmedia.sdk:
//            d

public static final class A extends Enum
{

    private static final x B[];
    public static final x a;
    public static final x b;
    public static final x c;
    public static final x d;
    public static final x e;
    public static final x f;
    public static final x g;
    public static final x h;
    public static final x i;
    public static final x j;
    public static final x k;
    public static final x l;
    public static final x m;
    public static final x n;
    public static final x o;
    public static final x p;
    public static final x q;
    public static final x r;
    public static final x s;
    public static final x t;
    public static final x u;
    public static final x v;
    public static final x w;
    public static final x x;
    private final boolean A;
    private final int y;
    private final boolean z;

    public static A valueOf(String s1)
    {
        return (A)Enum.valueOf(com/rhythmnewmedia/sdk/d$a, s1);
    }

    public static A[] values()
    {
        return (A[])B.clone();
    }

    public final int a()
    {
        return y;
    }

    public final boolean b()
    {
        return z;
    }

    public final boolean c()
    {
        return A;
    }

    static 
    {
        a = new <init>("none", 0, 0, false, false);
        b = new <init>("event", 1, 2, false, false);
        c = new <init>("dismiss", 2, 3, true, false);
        d = new <init>("showDone", 3, 4, false, false);
        e = new <init>("hideDone", 4, 5, false, false);
        f = new <init>("pinAd", 5, 6, false, false);
        g = new <init>("unpinAd", 6, 7, false, false);
        h = new <init>("videoPause", 7, 8, false, false);
        i = new <init>("videoPlay", 8, 9, false, false);
        j = new <init>("openBrowser", 9, 100, true, false);
        k = new <init>("adConnector", 10, 110, false, false);
        l = new <init>("clickUrl", 11, 10, true, true);
        m = new <init>("clickCall", 12, 11, true, false);
        n = new <init>("clickVideo", 13, 12, true, true);
        o = new <init>("clickAudio", 14, 13, true, false);
        p = new <init>("clickMarketplace", 15, 14, true, true);
        q = new <init>("clickMap", 16, 15, true, true);
        r = new <init>("clickEmail", 17, 16, true, false);
        s = new <init>("clickInteractiveVideo", 18, 17, true, true);
        t = new <init>("clickWebcal", 19, 18, true, false);
        u = new <init>("expand", 20, 19, true, false);
        v = new <init>("close", 21, 20, true, false);
        w = new <init>("hide", 22, 21, true, false);
        x = new <init>("show", 23, 22, true, false);
        B = (new B[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r, s, t, 
            u, v, w, x
        });
    }

    private (String s1, int i1, int j1, boolean flag, boolean flag1)
    {
        super(s1, i1);
        y = j1;
        z = flag;
        A = flag1;
    }
}
