// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.admob;

import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.mediation.MediationInterstitialListener;

// Referenced classes of package com.google.ads.mediation.admob:
//            AdMobAdapter

private class <init>
    implements AdListener
{

    final AdMobAdapter a;

    public void onDismissScreen(Ad ad)
    {
        AdMobAdapter.b(a).onDismissScreen(a);
    }

    public void onFailedToReceiveAd(Ad ad, com.google.ads.Code code)
    {
        AdMobAdapter.b(a).onFailedToReceiveAd(a, code);
    }

    public void onLeaveApplication(Ad ad)
    {
        AdMobAdapter.b(a).onLeaveApplication(a);
    }

    public void onPresentScreen(Ad ad)
    {
        AdMobAdapter.b(a).onPresentScreen(a);
    }

    public void onReceiveAd(Ad ad)
    {
        AdMobAdapter.b(a).onReceivedAd(a);
    }

    private Listener(AdMobAdapter admobadapter)
    {
        a = admobadapter;
        super();
    }

    a(AdMobAdapter admobadapter, a a1)
    {
        this(admobadapter);
    }
}
