// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a;


public final class f extends Enum
{

    public static final f a;
    public static final f b;
    public static final f c;
    public static final f d;
    public static final f e;
    public static final f f;
    public static final f g;
    public static final f h;
    public static final f i;
    public static final f j;
    public static final f k;
    private static final f m[];
    public final int l;

    private f(String s, int i1, int j1)
    {
        super(s, i1);
        l = j1;
    }

    public static f valueOf(String s)
    {
        return (f)Enum.valueOf(com/facebook/ads/a/f, s);
    }

    public static f[] values()
    {
        return (f[])m.clone();
    }

    static 
    {
        a = new f("UNKNOWN", 0, 0);
        b = new f("WEBVIEW_BANNER_LEGACY", 1, 4);
        c = new f("WEBVIEW_BANNER_50", 2, 5);
        d = new f("WEBVIEW_BANNER_90", 3, 6);
        e = new f("WEBVIEW_BANNER_250", 4, 7);
        f = new f("WEBVIEW_INTERSTITIAL_UNKNOWN", 5, 100);
        g = new f("WEBVIEW_INTERSTITIAL_HORIZONTAL", 6, 101);
        h = new f("WEBVIEW_INTERSTITIAL_VERTICAL", 7, 102);
        i = new f("WEBVIEW_INTERSTITIAL_TABLET", 8, 103);
        j = new f("NATIVE_UNKNOWN", 9, 200);
        k = new f("NATIVE_250", 10, 201);
        m = (new f[] {
            a, b, c, d, e, f, g, h, i, j, 
            k
        });
    }
}
