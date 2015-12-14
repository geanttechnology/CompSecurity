// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.mopub.common.util.Views;
import java.util.Map;

// Referenced classes of package com.mopub.mobileads:
//            CustomEventBanner, MoPubErrorCode

public class FacebookBanner extends CustomEventBanner
    implements AdListener
{

    public static final String PLACEMENT_ID_KEY = "placement_id";
    private CustomEventBanner.CustomEventBannerListener mBannerListener;
    private AdView mFacebookBanner;

    public FacebookBanner()
    {
    }

    private AdSize calculateAdSize(int i, int j)
    {
        if (j <= AdSize.BANNER_320_50.getHeight())
        {
            return AdSize.BANNER_320_50;
        }
        if (j <= AdSize.BANNER_HEIGHT_90.getHeight())
        {
            return AdSize.BANNER_HEIGHT_90;
        }
        if (j <= AdSize.RECTANGLE_HEIGHT_250.getHeight())
        {
            return AdSize.RECTANGLE_HEIGHT_250;
        } else
        {
            return null;
        }
    }

    private boolean localExtrasAreValid(Map map)
    {
        return (map.get("com_mopub_ad_width") instanceof Integer) && (map.get("com_mopub_ad_height") instanceof Integer);
    }

    private boolean serverExtrasAreValid(Map map)
    {
        map = (String)map.get("placement_id");
        return map != null && map.length() > 0;
    }

    AdView getAdView()
    {
        return mFacebookBanner;
    }

    protected void loadBanner(Context context, CustomEventBanner.CustomEventBannerListener customeventbannerlistener, Map map, Map map1)
    {
        mBannerListener = customeventbannerlistener;
        if (serverExtrasAreValid(map1))
        {
            customeventbannerlistener = (String)map1.get("placement_id");
            if (localExtrasAreValid(map))
            {
                map = calculateAdSize(((Integer)map.get("com_mopub_ad_width")).intValue(), ((Integer)map.get("com_mopub_ad_height")).intValue());
                if (map == null)
                {
                    mBannerListener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
                    return;
                } else
                {
                    mFacebookBanner = new AdView(context, customeventbannerlistener, map);
                    mFacebookBanner.setAdListener(this);
                    mFacebookBanner.disableAutoRefresh();
                    mFacebookBanner.loadAd();
                    return;
                }
            } else
            {
                mBannerListener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
                return;
            }
        } else
        {
            mBannerListener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
    }

    public void onAdClicked(Ad ad)
    {
        mBannerListener.onBannerClicked();
    }

    public void onAdLoaded(Ad ad)
    {
        mBannerListener.onBannerLoaded(mFacebookBanner);
    }

    public void onError(Ad ad, AdError aderror)
    {
        if (aderror == AdError.NO_FILL)
        {
            mBannerListener.onBannerFailed(MoPubErrorCode.NETWORK_NO_FILL);
            return;
        }
        if (aderror == AdError.INTERNAL_ERROR)
        {
            mBannerListener.onBannerFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
            return;
        } else
        {
            mBannerListener.onBannerFailed(MoPubErrorCode.UNSPECIFIED);
            return;
        }
    }

    protected void onInvalidate()
    {
        if (mFacebookBanner != null)
        {
            Views.removeFromParent(mFacebookBanner);
            mFacebookBanner.destroy();
            mFacebookBanner = null;
        }
    }
}
