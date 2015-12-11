// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AdWrapper, InterstitialAd, Ad, AdData, 
//            IAdLoaderCallback

class InterstitialAdWrapper
    implements AdWrapper
{

    private final InterstitialAd interstitialAd;

    InterstitialAdWrapper(InterstitialAd interstitialad)
    {
        interstitialAd = interstitialad;
    }

    public Ad getAd()
    {
        return interstitialAd;
    }

    public AdData getAdData()
    {
        return interstitialAd.getAdData();
    }

    public IAdLoaderCallback getAdLoaderCallback()
    {
        return interstitialAd.getAdLoaderCallback();
    }

    public int prepareAd(AdLoader.AdReadyToLoadListener adreadytoloadlistener)
    {
        return interstitialAd.prepareAd(adreadytoloadlistener);
    }
}
