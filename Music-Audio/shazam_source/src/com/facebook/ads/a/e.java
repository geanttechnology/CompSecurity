// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a;

import android.text.TextUtils;
import org.json.JSONArray;

public final class e extends Enum
{

    public static final e a;
    public static final e b;
    public static final e c;
    public static final e d;
    public static final e e;
    public static final e f;
    public static final e g;
    public static final e h;
    public static final e i;
    public static final e j;
    public static final e k;
    public static final e l;
    private static final e n[];
    private static final String o;
    private static final String p;
    private static final e q[];
    private final int m;

    private e(String s, int i1, int j1)
    {
        super(s, i1);
        m = j1;
    }

    public static String a()
    {
        return o;
    }

    public static e valueOf(String s)
    {
        return (e)Enum.valueOf(com/facebook/ads/a/e, s);
    }

    public static e[] values()
    {
        return (e[])q.clone();
    }

    public final String toString()
    {
        return String.valueOf(m);
    }

    static 
    {
        int i1 = 0;
        a = new e("APP_AD", 0, 0);
        b = new e("LINK_AD", 1, 1);
        c = new e("APP_AD_V2", 2, 2);
        d = new e("LINK_AD_V2", 3, 3);
        e = new e("APP_ENGAGEMENT_AD", 4, 4);
        f = new e("AD_CHOICES", 5, 5);
        g = new e("JS_TRIGGER", 6, 6);
        h = new e("JS_TRIGGER_NO_AUTO_IMP_LOGGING", 7, 7);
        i = new e("VIDEO_AD", 8, 8);
        j = new e("INLINE_VIDEO_AD", 9, 9);
        k = new e("BANNER_TO_INTERSTITIAL", 10, 10);
        l = new e("NATIVE_CLOSE_BUTTON", 11, 11);
        q = (new e[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l
        });
        n = (new e[] {
            d, e, f, h, l
        });
        JSONArray jsonarray = new JSONArray();
        e ae[] = n;
        for (int j1 = ae.length; i1 < j1; i1++)
        {
            jsonarray.put(ae[i1].m);
        }

        o = jsonarray.toString();
        p = TextUtils.join(",", n);
    }
}
