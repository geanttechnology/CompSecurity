// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a;


// Referenced classes of package com.facebook.ads.a:
//            c

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
    final int o;
    final String p;
    final boolean q;

    private a(String s, int i1, int j1, String s1, boolean flag)
    {
        super(s, i1);
        o = j1;
        p = s1;
        q = flag;
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/facebook/ads/a/a, s);
    }

    public static a[] values()
    {
        return (a[])r.clone();
    }

    public final c a(String s)
    {
        return new c(this, s);
    }

    static 
    {
        a = new a("UNKNOWN_ERROR", 0, -1, "unknown error", false);
        b = new a("NETWORK_ERROR", 1, 1000, "Network Error", true);
        c = new a("NO_FILL", 2, 1001, "No Fill", true);
        d = new a("LOAD_TOO_FREQUENTLY", 3, 1002, "Ad was re-loaded too frequently", true);
        e = new a("INVALID_PARAMETERS", 4, 1003, "Ad was requested with invalid parameters", true);
        f = new a("SERVER_ERROR", 5, 2000, "Server Error", true);
        g = new a("INTERNAL_ERROR", 6, 2001, "Internal Error", true);
        h = new a("START_BEFORE_INIT", 7, 2004, "initAd must be called before startAd", true);
        i = new a("AD_REQUEST_FAILED", 8, 1111, "Facebook Ads SDK request for ads failed", false);
        j = new a("AD_REQUEST_TIMEOUT", 9, 1112, "Facebook Ads SDK request for ads timed out", false);
        k = new a("PARSER_FAILURE", 10, 1201, "Failed to parse Facebook Ads SDK delivery response", false);
        l = new a("UNKNOWN_RESPONSE", 11, 1202, "Unknown Facebook Ads SDK delivery response type", false);
        m = new a("ERROR_MESSAGE", 12, 1203, "Facebook Ads SDK delivery response Error message", true);
        n = new a("NO_AD_PLACEMENT", 13, 1302, "Facebook Ads SDK returned no ad placements", false);
        r = (new a[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n
        });
    }
}
