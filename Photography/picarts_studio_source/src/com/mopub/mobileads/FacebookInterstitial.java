// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import java.util.Map;

// Referenced classes of package com.mopub.mobileads:
//            CustomEventInterstitial, MoPubErrorCode

public class FacebookInterstitial extends CustomEventInterstitial
    implements InterstitialAdListener
{

    public static final String PLACEMENT_ID_KEY = "placement_id";
    private InterstitialAd mFacebookInterstitial;
    private CustomEventInterstitial.CustomEventInterstitialListener mInterstitialListener;

    public FacebookInterstitial()
    {
    }

    private boolean extrasAreValid(Map map)
    {
        map = (String)map.get("placement_id");
        return map != null && map.length() > 0;
    }

    InterstitialAd getInterstitialAd()
    {
        return mFacebookInterstitial;
    }

    protected void loadInterstitial(Context context, CustomEventInterstitial.CustomEventInterstitialListener customeventinterstitiallistener, Map map, Map map1)
    {
        mInterstitialListener = customeventinterstitiallistener;
        if (extrasAreValid(map1))
        {
            mFacebookInterstitial = new InterstitialAd(context, (String)map1.get("placement_id"));
            mFacebookInterstitial.setAdListener(this);
            mFacebookInterstitial.loadAd();
            return;
        } else
        {
            mInterstitialListener.onInterstitialFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
    }

    public void onAdClicked(Ad ad)
    {
        mInterstitialListener.onInterstitialClicked();
    }

    public void onAdLoaded(Ad ad)
    {
        mInterstitialListener.onInterstitialLoaded();
    }

    public void onError(Ad ad, AdError aderror)
    {
        if (aderror == AdError.NO_FILL)
        {
            mInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_NO_FILL);
            return;
        }
        if (aderror == AdError.INTERNAL_ERROR)
        {
            mInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
            return;
        } else
        {
            mInterstitialListener.onInterstitialFailed(MoPubErrorCode.UNSPECIFIED);
            return;
        }
    }

    public void onInterstitialDismissed(Ad ad)
    {
        mInterstitialListener.onInterstitialDismissed();
    }

    public void onInterstitialDisplayed(Ad ad)
    {
        mInterstitialListener.onInterstitialShown();
    }

    protected void onInvalidate()
    {
        if (mFacebookInterstitial != null)
        {
            mFacebookInterstitial.destroy();
            mFacebookInterstitial = null;
        }
    }

    protected void showInterstitial()
    {
        if (mFacebookInterstitial != null && mFacebookInterstitial.isAdLoaded())
        {
            mFacebookInterstitial.show();
        }
    }
}
