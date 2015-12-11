// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public final class au extends Enum
{

    public static final au a;
    public static final au b;
    public static final au c;
    public static final au d;
    public static final au e;
    public static final au f;
    public static final au g;
    public static final au h;
    public static final au i;
    public static final au j;
    public static final au k;
    public static final au l;
    public static final au m;
    public static final au n;
    public static final au o;
    public static final au p;
    public static final au q;
    public static final au r;
    public static final au s;
    public static final au t;
    public static final au u;
    private static final au w[];
    private final String v;

    private au(String s1, int i1, String s2)
    {
        super(s1, i1);
        v = s2;
    }

    public static au valueOf(String s1)
    {
        return (au)Enum.valueOf(com/flurry/sdk/au, s1);
    }

    public static au[] values()
    {
        return (au[])w.clone();
    }

    public String toString()
    {
        return v;
    }

    static 
    {
        a = new au("AC_UNKNOWN", 0, "unknown");
        b = new au("AC_NOTIFY_USER", 1, "notifyUser");
        c = new au("AC_LOG_EVENT", 2, "logEvent");
        d = new au("AC_PROCESS_REDIRECT", 3, "processRedirect");
        e = new au("AC_NEXT_FRAME", 4, "nextFrame");
        f = new au("AC_NEXT_AD_UNIT", 5, "nextAdUnit");
        g = new au("AC_CLOSE_AD", 6, "closeAd");
        h = new au("AC_VERIFY_URL", 7, "verifyUrl");
        i = new au("AC_SEND_URL_ASYNC", 8, "sendUrlAsync");
        j = new au("AC_SEND_AD_LOGS", 9, "sendAdLogs");
        k = new au("AC_LOAD_AD_COMPONENTS", 10, "loadAdComponents");
        l = new au("AC_DIRECT_OPEN", 11, "directOpen");
        m = new au("AC_LOAD_COMPLETE", 12, "adFullyLoaded");
        n = new au("AC_DELETE", 13, "delete");
        o = new au("AC_CHECK_CAP", 14, "checkCap");
        p = new au("AC_UPDATE_VIEW_COUNT", 15, "updateViewCount");
        q = new au("AC_LAUNCH_PACKAGE", 16, "launchPackage");
        r = new au("AC_MRAID_DO_EXPAND", 17, "doExpand");
        s = new au("AC_MRAID_DO_COLLAPSE", 18, "doCollapse");
        t = new au("AC_MRAID_PLAY_VIDEO", 19, "MRAIDplayVideo");
        u = new au("AC_MRAID_OPEN", 20, "MRAIDOpen");
        w = (new au[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r, s, t, 
            u
        });
    }
}
