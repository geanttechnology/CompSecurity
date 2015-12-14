// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import com.google.android.gms.ads.InterstitialAd;
import java.util.Map;

// Referenced classes of package com.mopub.mobileads:
//            CustomEventInterstitial, MoPubErrorCode

public class GooglePlayServicesInterstitial extends CustomEventInterstitial
{

    public static final String AD_UNIT_ID_KEY = "adUnitID";
    public static final String LOCATION_KEY = "location";
    private InterstitialAd mGoogleInterstitialAd;
    private CustomEventInterstitial.CustomEventInterstitialListener mInterstitialListener;

    public GooglePlayServicesInterstitial()
    {
    }

    private boolean extrasAreValid(Map map)
    {
        return map.containsKey("adUnitID");
    }

    InterstitialAd getGoogleInterstitialAd()
    {
        return mGoogleInterstitialAd;
    }

    protected void loadInterstitial(Context context, CustomEventInterstitial.CustomEventInterstitialListener customeventinterstitiallistener, Map map, Map map1)
    {
        mInterstitialListener = customeventinterstitiallistener;
        if (extrasAreValid(map1))
        {
            customeventinterstitiallistener = (String)map1.get("adUnitID");
            mGoogleInterstitialAd = new InterstitialAd(context);
            mGoogleInterstitialAd.setAdListener(new InterstitialAdListener());
            mGoogleInterstitialAd.setAdUnitId(customeventinterstitiallistener);
            context = (new com.google.android.gms.ads.AdRequest.Builder()).setRequestAgent("MoPub").build();
            try
            {
                mGoogleInterstitialAd.loadAd(context);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                mInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_NO_FILL);
            }
        } else
        {
            mInterstitialListener.onInterstitialFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
    }

    protected void onInvalidate()
    {
        if (mGoogleInterstitialAd != null)
        {
            mGoogleInterstitialAd.setAdListener(null);
        }
    }

    protected void showInterstitial()
    {
        if (mGoogleInterstitialAd.isLoaded())
        {
            mGoogleInterstitialAd.show();
        }
    }


    private class InterstitialAdListener extends AdListener
    {

        final GooglePlayServicesInterstitial this$0;

        public void onAdClosed()
        {
            if (mInterstitialListener != null)
            {
                mInterstitialListener.onInterstitialDismissed();
            }
        }

        public void onAdFailedToLoad(int i)
        {
            if (mInterstitialListener != null)
            {
                mInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_NO_FILL);
            }
        }

        public void onAdLeftApplication()
        {
            if (mInterstitialListener != null)
            {
                mInterstitialListener.onInterstitialClicked();
            }
        }

        public void onAdLoaded()
        {
            if (mInterstitialListener != null)
            {
                mInterstitialListener.onInterstitialLoaded();
            }
        }

        public void onAdOpened()
        {
            if (mInterstitialListener != null)
            {
                mInterstitialListener.onInterstitialShown();
            }
        }

        private InterstitialAdListener()
        {
            this$0 = GooglePlayServicesInterstitial.this;
            super();
        }

    }

}
