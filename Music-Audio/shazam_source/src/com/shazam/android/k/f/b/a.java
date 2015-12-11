// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.k.f.b;

import android.net.Uri;
import com.shazam.android.k.f.b.a.b;
import com.shazam.android.k.f.b.a.c;
import com.shazam.android.k.f.b.a.d;
import com.shazam.android.k.f.b.a.e;
import com.shazam.android.k.f.b.a.f;
import com.shazam.android.k.f.b.a.g;
import com.shazam.android.k.f.b.a.h;
import com.shazam.android.k.f.b.a.i;
import com.shazam.android.k.f.b.a.j;
import com.shazam.android.k.f.b.a.k;
import com.shazam.android.k.f.b.a.l;
import com.shazam.android.k.f.b.a.m;
import com.shazam.android.k.f.b.a.n;
import com.shazam.android.k.f.b.a.o;
import com.shazam.android.k.f.b.a.p;
import com.shazam.android.k.f.b.a.r;

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
    public static final a o;
    public static final a p;
    private static final a t[];
    public final boolean q;
    public final boolean r;
    private final r s;

    private a(String s1, int i1, r r1, boolean flag, boolean flag1)
    {
        super(s1, i1);
        s = r1;
        q = flag;
        r = flag1;
    }

    public static a a(Uri uri)
    {
        a aa[] = values();
        int j1 = aa.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            a a1 = aa[i1];
            if (a1.s.a(uri))
            {
                return a1;
            }
        }

        return null;
    }

    public static a valueOf(String s1)
    {
        return (a)Enum.valueOf(com/shazam/android/k/f/b/a, s1);
    }

    public static a[] values()
    {
        return (a[])t.clone();
    }

    static 
    {
        a = new a("MY_TAGS_TAG", 0, new m(), true, false);
        b = new a("CHART_TRACK", 1, new e(), false, true);
        c = new a("NEWS_FEED_TRACK", 2, new o(), false, true);
        d = new a("DEEPLINK_TAG_TRACK", 3, new g(), false, true);
        e = new a("GENERIC_TRACK", 4, new i(), false, true);
        f = new a("GEOCHART_TRACK", 5, new j(), false, true);
        g = new a("MY_TAGS", 6, new n(), false, false);
        h = new a("MY_SHAZAM", 7, new l(), false, false);
        i = new a("AUTO_TAGS", 8, new d(), false, false);
        j = new a("AUTO_TAGS_TAG", 9, new c(), true, false);
        k = new a("CHARTS", 10, new f(), false, false);
        l = new a("NEWS_FEED", 11, new p(), false, false);
        m = new a("EXPLORE", 12, new h(), false, false);
        n = new a("HOME", 13, new k(), false, false);
        o = new a("ALBUM_TRACK", 14, new com.shazam.android.k.f.b.a.a(), false, true);
        p = new a("ARTIST", 15, new b(), false, false);
        t = (new a[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p
        });
    }
}
