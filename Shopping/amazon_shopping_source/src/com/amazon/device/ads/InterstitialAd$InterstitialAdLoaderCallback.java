// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            IAdLoaderCallback, InterstitialAd, AdData, WebRequest, 
//            AdError

class interstitialAd
    implements IAdLoaderCallback
{

    private final InterstitialAd interstitialAd;
    final InterstitialAd this$0;

    public void adFailed(AdError aderror)
    {
        if (!getAndSetHasFinishedLoading(true))
        {
            InterstitialAd.access$000(InterstitialAd.this, aderror);
        }
    }

    public void adShown()
    {
        WebRequest.executeWebRequestInThread(getAdData().getImpressionPixelUrl());
    }

    public int getTimeout()
    {
        return interstitialAd.getTimeout();
    }

    public void handleResponse()
    {
        prerenderHtml();
    }

    public (InterstitialAd interstitialad1)
    {
        this$0 = InterstitialAd.this;
        super();
        interstitialAd = interstitialad1;
    }
}
