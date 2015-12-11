// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import com.ebay.mobile.ads.NativeAdLoader;
import com.ebay.mobile.util.AdUtil;
import com.google.android.gms.ads.AdListener;
import java.lang.ref.WeakReference;

// Referenced classes of package com.ebay.mobile.home.cards:
//            NativeAdsViewModel

static final class adLoader extends AdListener
{

    private final NativeAdLoader adLoader;
    private final WeakReference viewModelReference;

    public void onAdFailedToLoad(int i)
    {
        NativeAdsViewModel nativeadsviewmodel = (NativeAdsViewModel)viewModelReference.get();
        if (nativeadsviewmodel != null)
        {
            nativeadsviewmodel.adLoadFailed = true;
            if (nativeadsviewmodel.adListener != null)
            {
                nativeadsviewmodel.adListener.onAdFailedToLoad(i);
            }
            if (AdUtil.logDfpAds.wModelReference)
            {
                AdUtil.logDfpAds.wModelReference(String.format("DFP onAdFailedToLoad:  %s", new Object[] {
                    Integer.valueOf(i)
                }));
                return;
            }
        }
    }

    public void onAdLoaded()
    {
        NativeAdsViewModel nativeadsviewmodel = (NativeAdsViewModel)viewModelReference.get();
        if (nativeadsviewmodel != null)
        {
            if (adLoader != null)
            {
                nativeadsviewmodel.nativeAd = adLoader.getNativeAd();
            }
            if (nativeadsviewmodel.adListener != null)
            {
                nativeadsviewmodel.adListener.onAdLoaded();
            }
            if (AdUtil.logDfpAds.oader)
            {
                AdUtil.logDfpAds.oader("DFP onAdLoaded");
                return;
            }
        }
    }

    public void onAdOpened()
    {
        NativeAdsViewModel nativeadsviewmodel;
        for (nativeadsviewmodel = (NativeAdsViewModel)viewModelReference.get(); nativeadsviewmodel == null || nativeadsviewmodel.adListener == null;)
        {
            return;
        }

        nativeadsviewmodel.adListener.onAdOpened();
    }

    I(NativeAdsViewModel nativeadsviewmodel, NativeAdLoader nativeadloader)
    {
        viewModelReference = new WeakReference(nativeadsviewmodel);
        adLoader = nativeadloader;
    }
}
