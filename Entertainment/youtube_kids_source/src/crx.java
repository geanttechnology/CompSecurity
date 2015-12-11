// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class crx extends Enum
{

    public static final crx a;
    public static final crx b;
    public static final crx c;
    public static final crx d;
    public static final crx e;
    public static final crx f;
    public static final crx g;
    public static final crx h;
    public static final crx i;
    public static final crx j;
    public static final crx k;
    public static final crx l;
    private static crx p;
    private static crx q;
    private static final crx r[];
    public final int m;
    public final int n;
    public final int o;

    private crx(String s, int i1, int j1, int k1, int l1)
    {
        super(s, i1);
        m = j1;
        n = k1;
        o = l1;
    }

    public static crx valueOf(String s)
    {
        return (crx)Enum.valueOf(crx, s);
    }

    public static crx[] values()
    {
        return (crx[])r.clone();
    }

    static 
    {
        a = new crx("NONE", 0, 0, 0, 0);
        p = new crx("NO_AD_RETURNED_ERROR", 1, 1, 2, 300);
        b = new crx("VIDEO_PLAYBACK_ERROR_NO_NETWORK", 2, 10, 7, 405);
        c = new crx("VIDEO_PLAYBACK_ERROR_UNKNOWN_HOST", 3, 11, 7, 401);
        d = new crx("VIDEO_PLAYBACK_ERROR_CANNOT_CONNECT", 4, 12, 7, 401);
        e = new crx("VIDEO_PLAYBACK_ERROR_TIMEOUT", 5, 13, 3, 402);
        f = new crx("VIDEO_PLAYBACK_UNKNOWN_ERROR", 6, 14, 3, 405);
        g = new crx("UNSUPPORTED_VIDEO_FORMAT", 7, 15, 6, 403);
        h = new crx("AD_SURVEY_PARSING_ERROR", 8, 20, 10, 900);
        i = new crx("VAST_AD_PARSING_ERROR", 9, 21, 10, 900);
        q = new crx("VMAP_AD_PARSING_ERROR", 10, 22, 11, 900);
        j = new crx("VIDEO_INFO_EXCEPTION", 11, 23, 7, 405);
        k = new crx("VAST_REQUEST_ERROR", 12, 24, 8, 301);
        l = new crx("VAST_TOO_MANY_WRAPPERS_ERROR", 13, 25, 8, 302);
        r = (new crx[] {
            a, p, b, c, d, e, f, g, h, i, 
            q, j, k, l
        });
    }
}
