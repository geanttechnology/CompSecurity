// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.d;


public final class j extends Enum
{

    public static final j a;
    public static final j b;
    public static final j c;
    public static final j d;
    public static final j e;
    public static final j f;
    public static final j g;
    public static final j h;
    public static final j i;
    public static final j j;
    public static final j k;
    public static final j l;
    public static final j m;
    public static final j n;
    public static final j o;
    public static final j p;
    public static final j q;
    public static final j r;
    public static final j s;
    public static final j t;
    public static final j u;
    public static final j v;
    public static final j w;
    private static final j y[];
    public final String x;

    private j(String s1, int i1, String s2)
    {
        super(s1, i1);
        x = s2;
    }

    public static j valueOf(String s1)
    {
        return (j)Enum.valueOf(com/mopub/common/d/j, s1);
    }

    public static j[] values()
    {
        return (j[])y.clone();
    }

    static 
    {
        a = new j("AD_TIMEOUT", 0, "X-AdTimeout");
        b = new j("AD_TYPE", 1, "X-Adtype");
        c = new j("CLICK_TRACKING_URL", 2, "X-Clickthrough");
        d = new j("CUSTOM_EVENT_DATA", 3, "X-Custom-Event-Class-Data");
        e = new j("CUSTOM_EVENT_NAME", 4, "X-Custom-Event-Class-Name");
        f = new j("CUSTOM_EVENT_HTML_DATA", 5, "X-Custom-Event-Html-Data");
        g = new j("DSP_CREATIVE_ID", 6, "X-DspCreativeid");
        h = new j("FAIL_URL", 7, "X-Failurl");
        i = new j("FULL_AD_TYPE", 8, "X-Fulladtype");
        j = new j("HEIGHT", 9, "X-Height");
        k = new j("IMPRESSION_URL", 10, "X-Imptracker");
        l = new j("REDIRECT_URL", 11, "X-Launchpage");
        m = new j("NATIVE_PARAMS", 12, "X-Nativeparams");
        n = new j("NETWORK_TYPE", 13, "X-Networktype");
        o = new j("ORIENTATION", 14, "X-Orientation");
        p = new j("REFRESH_TIME", 15, "X-Refreshtime");
        q = new j("SCROLLABLE", 16, "X-Scrollable");
        r = new j("WARMUP", 17, "X-Warmup");
        s = new j("WIDTH", 18, "X-Width");
        t = new j("LOCATION", 19, "Location");
        u = new j("USER_AGENT", 20, "User-Agent");
        v = new j("ACCEPT_LANGUAGE", 21, "Accept-Language");
        w = new j("CUSTOM_SELECTOR", 22, "X-Customselector");
        y = (new j[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r, s, t, 
            u, v, w
        });
    }
}
