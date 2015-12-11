// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public final class av extends Enum
{

    public static final av a;
    public static final av b;
    public static final av c;
    public static final av d;
    public static final av e;
    public static final av f;
    public static final av g;
    public static final av h;
    public static final av i;
    public static final av j;
    public static final av k;
    public static final av l;
    public static final av m;
    public static final av n;
    public static final av o;
    public static final av p;
    public static final av q;
    public static final av r;
    public static final av s;
    public static final av t;
    public static final av u;
    public static final av v;
    public static final av w;
    public static final av x;
    private static final av z[];
    private int y;

    private av(String s1, int i1, int j1)
    {
        super(s1, i1);
        y = j1;
    }

    public static av valueOf(String s1)
    {
        return (av)Enum.valueOf(com/flurry/sdk/av, s1);
    }

    public static av[] values()
    {
        return (av[])z.clone();
    }

    public int a()
    {
        return y;
    }

    static 
    {
        a = new av("kUnknown", 0, -1);
        b = new av("kSuccess", 1, 0);
        c = new av("kNoNetworkConnectivity", 2, 1);
        d = new av("kMissingAdController", 3, 2);
        e = new av("kNoContext", 4, 3);
        f = new av("kInvalidAdUnit", 5, 4);
        g = new av("kInvalidVASTAd", 6, 5);
        h = new av("kPrecachingDownloadFailed", 7, 6);
        i = new av("kPrecachingCopyFailed", 8, 7);
        j = new av("kPrecachingMissingAssets", 9, 8);
        k = new av("kPrerenderDownloadFailed", 10, 9);
        l = new av("kAdRequestTimeout", 11, 10);
        m = new av("kVASTResolveTimeout", 12, 11);
        n = new av("kCSRTBAuctionTimeout", 13, 12);
        o = new av("kPrerenderDownloadTimeout", 14, 13);
        p = new av("kPrepareFailed", 15, 14);
        q = new av("kAdDisplayError", 16, 15);
        r = new av("kVideoPlaybackError", 17, 16);
        s = new av("kNotReady", 18, 17);
        t = new av("kWrongOrientation", 19, 18);
        u = new av("kNoViewGroup", 20, 19);
        v = new av("kUnfilled", 21, 20);
        w = new av("kIncorrectClassForAdSpace", 22, 21);
        x = new av("kDeviceLocked", 23, 22);
        z = (new av[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r, s, t, 
            u, v, w, x
        });
    }
}
