// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.location.Location;
import com.millennialmedia.android.MMAdView;
import com.millennialmedia.android.MMRequest;
import com.millennialmedia.android.MMSDK;
import java.util.Map;

// Referenced classes of package com.mopub.mobileads:
//            CustomEventBanner, AdViewController, MoPubErrorCode

class MillennialBanner extends CustomEventBanner
{

    public static final String AD_HEIGHT_KEY = "adHeight";
    public static final String AD_WIDTH_KEY = "adWidth";
    public static final String APID_KEY = "adUnitID";
    private CustomEventBanner.CustomEventBannerListener mBannerListener;
    private MMAdView mMillennialAdView;

    MillennialBanner()
    {
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

    MMAdView getMMAdView()
    {
        return mMillennialAdView;
    }

    protected void loadBanner(Context context, CustomEventBanner.CustomEventBannerListener customeventbannerlistener, Map map, Map map1)
    {
        mBannerListener = customeventbannerlistener;
        if (extrasAreValid(map1))
        {
            customeventbannerlistener = (String)map1.get("adUnitID");
            int i = Integer.parseInt((String)map1.get("adWidth"));
            int j = Integer.parseInt((String)map1.get("adHeight"));
            MMSDK.initialize(context);
            mMillennialAdView = new MMAdView(context);
            mMillennialAdView.setListener(new MillennialBannerRequestListener());
            mMillennialAdView.setApid(customeventbannerlistener);
            mMillennialAdView.setWidth(i);
            mMillennialAdView.setHeight(j);
            context = (Location)map.get("location");
            if (context != null)
            {
                MMRequest.setUserLocation(context);
            }
            mMillennialAdView.setMMRequest(new MMRequest());
            mMillennialAdView.setId(MMSDK.getDefaultAdId());
            AdViewController.setShouldHonorServerDimensions(mMillennialAdView);
            mMillennialAdView.getAd();
            return;
        } else
        {
            mBannerListener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
    }

    protected void onInvalidate()
    {
        if (mMillennialAdView != null)
        {
            mMillennialAdView.setListener(null);
        }
    }



    private class MillennialBannerRequestListener
        implements RequestListener
    {

        final MillennialBanner this$0;

        public void MMAdOverlayClosed(MMAd mmad)
        {
            mBannerListener.onBannerCollapsed();
        }

        public void MMAdOverlayLaunched(MMAd mmad)
        {
            mBannerListener.onBannerExpanded();
        }

        public void MMAdRequestIsCaching(MMAd mmad)
        {
        }

        public void onSingleTap(MMAd mmad)
        {
            mBannerListener.onBannerClicked();
        }

        public void requestCompleted(MMAd mmad)
        {
            mBannerListener.onBannerLoaded(mMillennialAdView);
        }

        public void requestFailed(MMAd mmad, MMException mmexception)
        {
            mBannerListener.onBannerFailed(MoPubErrorCode.NETWORK_NO_FILL);
        }

        MillennialBannerRequestListener()
        {
            this$0 = MillennialBanner.this;
            super();
        }
    }

}
