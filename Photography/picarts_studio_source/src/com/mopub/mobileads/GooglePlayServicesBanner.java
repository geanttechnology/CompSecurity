// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.mopub.common.util.Views;
import java.util.Map;

// Referenced classes of package com.mopub.mobileads:
//            CustomEventBanner, MoPubErrorCode

class GooglePlayServicesBanner extends CustomEventBanner
{

    public static final String AD_HEIGHT_KEY = "adHeight";
    public static final String AD_UNIT_ID_KEY = "adUnitID";
    public static final String AD_WIDTH_KEY = "adWidth";
    public static final String LOCATION_KEY = "location";
    private CustomEventBanner.CustomEventBannerListener mBannerListener;
    private AdView mGoogleAdView;

    GooglePlayServicesBanner()
    {
    }

    private AdSize calculateAdSize(int i, int j)
    {
        if (i <= AdSize.BANNER.getWidth() && j <= AdSize.BANNER.getHeight())
        {
            return AdSize.BANNER;
        }
        if (i <= AdSize.MEDIUM_RECTANGLE.getWidth() && j <= AdSize.MEDIUM_RECTANGLE.getHeight())
        {
            return AdSize.MEDIUM_RECTANGLE;
        }
        if (i <= AdSize.FULL_BANNER.getWidth() && j <= AdSize.FULL_BANNER.getHeight())
        {
            return AdSize.FULL_BANNER;
        }
        if (i <= AdSize.LEADERBOARD.getWidth() && j <= AdSize.LEADERBOARD.getHeight())
        {
            return AdSize.LEADERBOARD;
        } else
        {
            return null;
        }
    }

    private boolean extrasAreValid(Map map)
    {
        try
        {
            Integer.parseInt((String)map.get("adWidth"));
            Integer.parseInt((String)map.get("adHeight"));
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return false;
        }
        return map.containsKey("adUnitID");
    }

    AdView getGoogleAdView()
    {
        return mGoogleAdView;
    }

    protected void loadBanner(Context context, CustomEventBanner.CustomEventBannerListener customeventbannerlistener, Map map, Map map1)
    {
        mBannerListener = customeventbannerlistener;
        if (extrasAreValid(map1))
        {
            customeventbannerlistener = (String)map1.get("adUnitID");
            int i = Integer.parseInt((String)map1.get("adWidth"));
            int j = Integer.parseInt((String)map1.get("adHeight"));
            mGoogleAdView = new AdView(context);
            mGoogleAdView.setAdListener(new AdViewListener());
            mGoogleAdView.setAdUnitId(customeventbannerlistener);
            context = calculateAdSize(i, j);
            if (context == null)
            {
                mBannerListener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
                return;
            }
        } else
        {
            mBannerListener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        mGoogleAdView.setAdSize(context);
        context = (new com.google.android.gms.ads.AdRequest.Builder()).setRequestAgent("MoPub").build();
        try
        {
            mGoogleAdView.loadAd(context);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            mBannerListener.onBannerFailed(MoPubErrorCode.NETWORK_NO_FILL);
        }
    }

    protected void onInvalidate()
    {
        Views.removeFromParent(mGoogleAdView);
        if (mGoogleAdView != null)
        {
            mGoogleAdView.setAdListener(null);
            mGoogleAdView.destroy();
        }
    }



    private class AdViewListener extends AdListener
    {

        final GooglePlayServicesBanner this$0;

        public void onAdClosed()
        {
        }

        public void onAdFailedToLoad(int i)
        {
            if (mBannerListener != null)
            {
                mBannerListener.onBannerFailed(MoPubErrorCode.NETWORK_NO_FILL);
            }
        }

        public void onAdLeftApplication()
        {
        }

        public void onAdLoaded()
        {
            if (mBannerListener != null)
            {
                mBannerListener.onBannerLoaded(mGoogleAdView);
            }
        }

        public void onAdOpened()
        {
            if (mBannerListener != null)
            {
                mBannerListener.onBannerClicked();
            }
        }

        private AdViewListener()
        {
            this$0 = GooglePlayServicesBanner.this;
            super();
        }

    }

}
