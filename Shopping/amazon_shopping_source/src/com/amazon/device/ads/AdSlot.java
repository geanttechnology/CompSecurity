// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AdTargetingOptions, AdLayout, AdLayoutWrapper, InterstitialAd, 
//            InterstitialAdWrapper, AdWrapper, AdError, Ad, 
//            AdData, IAdLoaderCallback

class AdSlot
{

    private AdError adError;
    private final AdTargetingOptions adOptions;
    private final AdWrapper adWrapper;
    private int slotNumber;

    public AdSlot(Ad ad, AdTargetingOptions adtargetingoptions)
    {
        this(createAdWrapper(ad), adtargetingoptions);
    }

    AdSlot(AdWrapper adwrapper, AdTargetingOptions adtargetingoptions)
    {
        adWrapper = adwrapper;
        if (adtargetingoptions == null)
        {
            adOptions = new AdTargetingOptions();
            return;
        } else
        {
            adOptions = adtargetingoptions;
            return;
        }
    }

    static AdWrapper createAdWrapper(Ad ad)
    {
        if (ad instanceof AdLayout)
        {
            return new AdLayoutWrapper((AdLayout)ad);
        }
        if (ad instanceof InterstitialAd)
        {
            return new InterstitialAdWrapper((InterstitialAd)ad);
        } else
        {
            return null;
        }
    }

    public Ad getAd()
    {
        return adWrapper.getAd();
    }

    AdData getAdData()
    {
        return adWrapper.getAdData();
    }

    AdError getAdError()
    {
        return adError;
    }

    IAdLoaderCallback getAdLoaderCallback()
    {
        return adWrapper.getAdLoaderCallback();
    }

    public AdTargetingOptions getAdTargetingOptions()
    {
        return adOptions;
    }

    AdWrapper getAdWrapper()
    {
        return adWrapper;
    }

    int getSlotNumber()
    {
        return slotNumber;
    }

    void setAdError(AdError aderror)
    {
        adError = aderror;
    }

    void setSlotNumber(int i)
    {
        slotNumber = i;
    }
}
