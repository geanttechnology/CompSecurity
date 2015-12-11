// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.admob;

import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.mediation.MediationBannerListener;

// Referenced classes of package com.google.ads.mediation.admob:
//            AdMobAdapter

private class <init>
    implements AdListener
{

    final AdMobAdapter a;

    public void onDismissScreen(Ad ad)
    {
        AdMobAdapter.a(a).onDismissScreen(a);
    }

    public void onFailedToReceiveAd(Ad ad, com.google.ads.Code code)
    {
        AdMobAdapter.a(a).onFailedToReceiveAd(a, code);
    }

    public void onLeaveApplication(Ad ad)
    {
        AdMobAdapter.a(a).onLeaveApplication(a);
    }

    public void onPresentScreen(Ad ad)
    {
        AdMobAdapter.a(a).onClick(a);
        AdMobAdapter.a(a).onPresentScreen(a);
    }

    public void onReceiveAd(Ad ad)
    {
        AdMobAdapter.a(a).onReceivedAd(a);
    }

    private er(AdMobAdapter admobadapter)
    {
        a = admobadapter;
        super();
    }

    a(AdMobAdapter admobadapter, a a1)
    {
        this(admobadapter);
    }
}
