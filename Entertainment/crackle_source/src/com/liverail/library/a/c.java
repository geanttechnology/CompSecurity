// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library.a;


public final class c extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;
    public static final c f;
    public static final c g;
    public static final c h;
    public static final c i;
    public static final c j;
    public static final c k;
    public static final c l;
    public static final c m;
    public static final c n;
    public static final c o;
    public static final c p;
    public static final c q;
    public static final c r;
    public static final c s;
    public static final c t;
    public static final c u;
    public static final c v;
    private static final c y[];
    public final int w;
    public final String x;

    private c(String s1, int i1, int j1, String s2)
    {
        super(s1, i1);
        w = j1;
        x = s2;
    }

    public static c valueOf(String s1)
    {
        return (c)Enum.valueOf(com/liverail/library/a/c, s1);
    }

    public static c[] values()
    {
        c ac[] = y;
        int i1 = ac.length;
        c ac1[] = new c[i1];
        System.arraycopy(ac, 0, ac1, 0, i1);
        return ac1;
    }

    static 
    {
        a = new c("LinearGeneralError", 0, 400, "General Linear error.");
        b = new c("LinearFileNotFound", 1, 401, "File not found.");
        c = new c("LinearFileTimeout", 2, 402, "Timeout of MediaFile URI");
        d = new c("LinearFileUnsupported", 3, 405, "Problem displaying MediaFile");
        e = new c("UndefinedPublisherId", 4, 1000, "Init failed because LR_PUBLISHER_ID was not defined.");
        f = new c("StartAdBeforeAdLoaded", 5, 1002, "startAd() called before AdLoaded event");
        g = new c("UnsupportedDevice", 6, 1005, "Unsupported device:");
        h = new c("BadPlayerDimensions", 7, 1007, "Bad player dimensions");
        i = new c("AdSourcesRequestFailed", 8, 1101, "LiveRail request for ad-sources has failed.");
        j = new c("AdSourcesRequestTimeout", 9, 1102, "LiveRail request for ad-sources has timed out.");
        k = new c("AdsRequestFailed", 10, 1111, "LiveRail request for ads failed.");
        l = new c("AdsRequestTimeout", 11, 1112, "LiveRail request for ads timed out.");
        m = new c("XMLParseFailure", 12, 1201, "Failed to parse LiveRail XML response.");
        n = new c("XMLUnknownResponse", 13, 1202, "Unknown LiveRail XML response type.");
        o = new c("XMLErrorMessage", 14, 1203, "LiveRail XML Error message:");
        p = new c("XMLDuplicateSources", 15, 1204, "Second LiveRail XML contains sources.");
        q = new c("NoAdSources", 16, 1301, "LiveRail returned no ad sources.");
        r = new c("NoAdSlots", 17, 1302, "No ad-slots available.");
        s = new c("VideoStreamInvalidProgress", 18, 1602, "Stream invalid play-progress before BufferFull.");
        t = new c("ClickThruFailed", 19, 1701, "Clickthrough failed.");
        u = new c("UncaughtErrorCode", 20, 1901, "Uncaught error");
        v = new c("AdImpressionButNotVisible", 21, 9001, "AdImpression but ad not visible.");
        y = (new c[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p, q, r, s, t, 
            u, v
        });
    }
}
