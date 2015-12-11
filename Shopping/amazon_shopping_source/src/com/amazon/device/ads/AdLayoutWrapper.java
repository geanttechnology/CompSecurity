// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AdWrapper, AdLayout, AdController, Ad, 
//            AdData, IAdLoaderCallback

class AdLayoutWrapper
    implements AdWrapper
{

    private final AdLayout adLayout;

    AdLayoutWrapper(AdLayout adlayout)
    {
        adLayout = adlayout;
    }

    public Ad getAd()
    {
        return adLayout;
    }

    public AdData getAdData()
    {
        return adLayout.getAdController().getAdData();
    }

    public IAdLoaderCallback getAdLoaderCallback()
    {
        return adLayout.getAdController();
    }

    public int prepareAd(AdLoader.AdReadyToLoadListener adreadytoloadlistener)
    {
        return adLayout.prepareAd(adreadytoloadlistener);
    }
}
