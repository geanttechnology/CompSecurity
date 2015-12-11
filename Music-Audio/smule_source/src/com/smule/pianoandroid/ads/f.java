// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.ads;

import com.flurry.android.FlurryAdListener;
import com.flurry.android.FlurryAdType;
import com.google.a.a.b.b;
import com.smule.android.c.aa;

// Referenced classes of package com.smule.pianoandroid.ads:
//            FlurryDFPInterstitial

class f
    implements FlurryAdListener
{

    final FlurryDFPInterstitial a;
    private b b;

    public f(FlurryDFPInterstitial flurrydfpinterstitial, b b1)
    {
        a = flurrydfpinterstitial;
        super();
        b = b1;
    }

    public void onAdClicked(String s)
    {
    }

    public void onAdClosed(String s)
    {
        aa.a(FlurryDFPInterstitial.access$000(), (new StringBuilder()).append("On ad closed ").append(s).toString());
        b.c();
    }

    public void onAdOpened(String s)
    {
    }

    public void onApplicationExit(String s)
    {
        aa.a(FlurryDFPInterstitial.access$000(), (new StringBuilder()).append("On application exit ").append(s).toString());
        b.d();
    }

    public void onRenderFailed(String s)
    {
        aa.a(FlurryDFPInterstitial.access$000(), (new StringBuilder()).append("On render failed ").append(s).toString());
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
        return flurryadtype != FlurryAdType.WEB_BANNER;
    }

    public void spaceDidFailToReceiveAd(String s)
    {
        aa.a(FlurryDFPInterstitial.access$000(), (new StringBuilder()).append("spaceDidFailToReceiveAd ").append(s).toString());
        FlurryDFPInterstitial.access$102(a, false);
        b.b();
    }

    public void spaceDidReceiveAd(String s)
    {
        aa.a(FlurryDFPInterstitial.access$000(), (new StringBuilder()).append("spaceDidReceiveAd ").append(s).toString());
        FlurryDFPInterstitial.access$102(a, true);
        b.a();
    }
}
