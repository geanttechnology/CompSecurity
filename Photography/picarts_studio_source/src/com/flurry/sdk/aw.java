// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public final class aw extends Enum
{

    public static final aw a;
    public static final aw b;
    public static final aw c;
    public static final aw d;
    public static final aw e;
    public static final aw f;
    public static final aw g;
    public static final aw h;
    public static final aw i;
    public static final aw j;
    public static final aw k;
    public static final aw l;
    public static final aw m;
    public static final aw n;
    public static final aw o;
    public static final aw p;
    public static final aw q;
    public static final aw r;
    public static final aw s;
    public static final aw t;
    public static final aw u;
    public static final aw v;
    private static final aw x[];
    private final String w;

    private aw(String s1, int i1, String s2)
    {
        super(s1, i1);
        w = s2;
    }

    public static aw valueOf(String s1)
    {
        return (aw)Enum.valueOf(com/flurry/sdk/aw, s1);
    }

    public static aw[] values()
    {
        return (aw[])x.clone();
    }

    public final String toString()
    {
        return w;
    }

    static 
    {
        a = new aw("AC_UNKNOWN", 0, "unknown");
        b = new aw("AC_NOTIFY_USER", 1, "notifyUser");
        c = new aw("AC_LOG_EVENT", 2, "logEvent");
        d = new aw("AC_PROCESS_REDIRECT", 3, "processRedirect");
        e = new aw("AC_NEXT_FRAME", 4, "nextFrame");
        f = new aw("AC_NEXT_AD_UNIT", 5, "nextAdUnit");
        g = new aw("AC_CLOSE_AD", 6, "closeAd");
        h = new aw("AC_VERIFY_URL", 7, "verifyUrl");
        i = new aw("AC_VERIFY_PACKAGE", 8, "verifyPackage");
        j = new aw("AC_SEND_URL_ASYNC", 9, "sendUrlAsync");
        k = new aw("AC_SEND_AD_LOGS", 10, "sendAdLogs");
        l = new aw("AC_LOAD_AD_COMPONENTS", 11, "loadAdComponents");
        m = new aw("AC_DIRECT_OPEN", 12, "directOpen");
        n = new aw("AC_LOAD_COMPLETE", 13, "adFullyLoaded");
        o = new aw("AC_DELETE", 14, "delete");
        p = new aw("AC_CHECK_CAP", 15, "checkCap");
        q = new aw("AC_UPDATE_VIEW_COUNT", 16, "updateViewCount");
        r = new aw("AC_LAUNCH_PACKAGE", 17, "launchPackage");
        s = new aw("AC_MRAID_DO_EXPAND", 18, "doExpand");
        t = new aw("AC_MRAID_DO_COLLAPSE", 19, "doCollapse");
        u = new aw("AC_MRAID_PLAY_VIDEO", 20, "MRAIDplayVideo");
        v = new aw("AC_MRAID_OPEN", 21, "MRAIDOpen");
        x = (new aw[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r, s, t, 
            u, v
        });
    }
}
