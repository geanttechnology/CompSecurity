// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mobileads;

import com.amazon.device.ads.Ad;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdProperties;
import com.amazon.device.ads.AmazonOOActionCode;
import com.amazon.device.ads.AmazonOOAdListener;
import com.amazon.device.ads.AmazonOOAdResponse;

// Referenced classes of package com.amazon.mShop.mobileads:
//            MobileAdsLayout

public static class I
    implements AmazonOOAdListener
{

    public void onAdCollapsed(Ad ad)
    {
    }

    public void onAdDismissed(Ad ad)
    {
    }

    public void onAdExpanded(Ad ad)
    {
    }

    public void onAdFailedToLoad(Ad ad, AdError aderror)
    {
    }

    public void onAdLoaded(Ad ad, AdProperties adproperties)
    {
    }

    public AmazonOOActionCode onAdReceived(Ad ad, AmazonOOAdResponse amazonooadresponse)
    {
        return AmazonOOActionCode.DISPLAY;
    }

    public void onSpecialUrlClicked(Ad ad, String s)
    {
    }

    public I()
    {
    }
}
