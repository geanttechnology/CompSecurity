// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert.i;

import com.facebook.ads.a;
import com.facebook.ads.b;
import com.shazam.android.advert.ShazamAdView;
import com.shazam.android.advert.l;
import com.shazam.android.advert.m;

public final class c
    implements com.facebook.ads.c
{

    private final ShazamAdView a;
    private final String b;
    private final l c;

    public c(ShazamAdView shazamadview, String s, l l1)
    {
        a = shazamadview;
        b = s;
        c = l1;
    }

    public final void a(a a1)
    {
        c.a(a, m.b, b);
    }

    public final void a(a a1, b b1)
    {
        a1 = c;
        ShazamAdView shazamadview = a;
        m m1 = m.b;
        com.shazam.android.advert.a.a a2 = new com.shazam.android.advert.a.a();
        a2.a = b1.g;
        a1.a(shazamadview, m1, a2.a(), b);
    }

    public final void b(a a1)
    {
        c.b(a, m.b, b);
    }
}
