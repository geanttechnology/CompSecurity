// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.ads;

import android.view.ViewGroup;
import com.flurry.android.FlurryAdListener;
import com.flurry.android.FlurryAdType;
import com.flurry.android.FlurryAds;
import com.google.a.a.b.a;
import com.smule.android.c.aa;

// Referenced classes of package com.smule.pianoandroid.ads:
//            c

class d
    implements FlurryAdListener
{

    final c a;
    private a b;
    private ViewGroup c;

    public d(c c1, a a1, ViewGroup viewgroup)
    {
        a = c1;
        super();
        b = a1;
        c = viewgroup;
    }

    public void onAdClicked(String s)
    {
    }

    public void onAdClosed(String s)
    {
        aa.a(com.smule.pianoandroid.ads.c.a(), (new StringBuilder()).append("On ad closed ").append(s).toString());
        b.c();
    }

    public void onAdOpened(String s)
    {
    }

    public void onApplicationExit(String s)
    {
        aa.a(com.smule.pianoandroid.ads.c.a(), (new StringBuilder()).append("On application exit ").append(s).toString());
        b.d();
    }

    public void onRenderFailed(String s)
    {
        aa.a(com.smule.pianoandroid.ads.c.a(), (new StringBuilder()).append("On render failed ").append(s).toString());
        b.b();
    }

    public void onRendered(String s)
    {
    }

    public void onVideoCompleted(String s)
    {
    }

    public boolean shouldDisplayAd(String s, FlurryAdType flurryadtype)
    {
        return s.equals(com.smule.pianoandroid.ads.c.a(a));
    }

    public void spaceDidFailToReceiveAd(String s)
    {
        aa.a(com.smule.pianoandroid.ads.c.a(), (new StringBuilder()).append("On ad failed ").append(s).toString());
        a.a(com.smule.pianoandroid.ads.c.b(a), b, c);
        b.b();
    }

    public void spaceDidReceiveAd(String s)
    {
        aa.a(com.smule.pianoandroid.ads.c.a(), (new StringBuilder()).append("Ad available ").append(s).toString());
        FlurryAds.displayAd(a.getContext(), s, c);
        b.a(c);
    }
}
