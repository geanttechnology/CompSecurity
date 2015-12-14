// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.FrameLayout;
import com.flurry.android.ads.FlurryAdBanner;
import java.util.Map;

// Referenced classes of package com.mopub.mobileads:
//            CustomEventBanner, MoPubErrorCode, FlurryAgentWrapper

public class FlurryCustomEventBanner extends CustomEventBanner
{

    private static final String AD_SPACE_NAME = "adSpaceName";
    private static final String API_KEY = "apiKey";
    public static final String LOG_TAG = com/mopub/mobileads/FlurryCustomEventBanner.getSimpleName();
    private String mAdSpaceName;
    private String mApiKey;
    private FlurryAdBanner mBanner;
    private Context mContext;
    private FrameLayout mLayout;
    private CustomEventBanner.CustomEventBannerListener mListener;

    public FlurryCustomEventBanner()
    {
    }

    private boolean extrasAreValid(Map map)
    {
        while (map == null || !map.containsKey("apiKey") || !map.containsKey("adSpaceName")) 
        {
            return false;
        }
        return true;
    }

    protected void loadBanner(Context context, CustomEventBanner.CustomEventBannerListener customeventbannerlistener, Map map, Map map1)
    {
        if (context == null)
        {
            Log.e(LOG_TAG, "Context cannot be null.");
            customeventbannerlistener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        if (customeventbannerlistener == null)
        {
            Log.e(LOG_TAG, "CustomEventBannerListener cannot be null.");
            customeventbannerlistener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        if (!(context instanceof Activity))
        {
            Log.e(LOG_TAG, "Ad can be rendered only in Activity context.");
            customeventbannerlistener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        if (!extrasAreValid(map1))
        {
            customeventbannerlistener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        } else
        {
            mContext = context;
            mListener = customeventbannerlistener;
            mLayout = new FrameLayout(context);
            mApiKey = (String)map1.get("apiKey");
            mAdSpaceName = (String)map1.get("adSpaceName");
            FlurryAgentWrapper.getInstance().onStartSession(context, mApiKey);
            (new StringBuilder("fetch Flurry Ad (")).append(mAdSpaceName).append(") -- ").append(mLayout.toString());
            mBanner = new FlurryAdBanner(mContext, mLayout, mAdSpaceName);
            mBanner.setListener(new FlurryMopubBannerListener());
            mBanner.fetchAd();
            return;
        }
    }

    protected void onInvalidate()
    {
        if (mContext == null)
        {
            return;
        }
        (new StringBuilder("MoPub issued onInvalidate (")).append(mAdSpaceName).append(")");
        if (mBanner != null)
        {
            mBanner.destroy();
            mBanner = null;
        }
        FlurryAgentWrapper.getInstance().onEndSession(mContext);
        mContext = null;
        mListener = null;
        mLayout = null;
    }





    private class FlurryMopubBannerListener
        implements FlurryAdBannerListener
    {

        private final String LOG_TAG;
        final FlurryCustomEventBanner this$0;

        public void onAppExit(FlurryAdBanner flurryadbanner)
        {
            (new StringBuilder("onAppExit(")).append(flurryadbanner.toString()).append(")");
            if (mListener != null)
            {
                mListener.onLeaveApplication();
            }
        }

        public void onClicked(FlurryAdBanner flurryadbanner)
        {
            (new StringBuilder("onClicked ")).append(flurryadbanner.toString());
            if (mListener != null)
            {
                mListener.onBannerClicked();
            }
        }

        public void onCloseFullscreen(FlurryAdBanner flurryadbanner)
        {
            (new StringBuilder("onCloseFullscreen(")).append(flurryadbanner.toString()).append(")");
            if (mListener != null)
            {
                mListener.onBannerCollapsed();
            }
        }

        public void onError(FlurryAdBanner flurryadbanner, FlurryAdErrorType flurryaderrortype, int i)
        {
            (new StringBuilder("onError(")).append(flurryadbanner.toString()).append(flurryaderrortype.toString()).append(i).append(")");
            if (mListener != null)
            {
                if (FlurryAdErrorType.FETCH.equals(flurryaderrortype))
                {
                    mListener.onBannerFailed(MoPubErrorCode.NETWORK_NO_FILL);
                } else
                if (FlurryAdErrorType.RENDER.equals(flurryaderrortype))
                {
                    mListener.onBannerFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
                    return;
                }
            }
        }

        public void onFetched(FlurryAdBanner flurryadbanner)
        {
            (new StringBuilder("onFetched(")).append(flurryadbanner.toString()).append(")");
            if (mBanner != null)
            {
                mBanner.displayAd();
            }
        }

        public void onRendered(FlurryAdBanner flurryadbanner)
        {
            (new StringBuilder("onRendered(")).append(flurryadbanner.toString()).append(")");
            if (mListener != null)
            {
                mListener.onBannerLoaded(mLayout);
            }
        }

        public void onShowFullscreen(FlurryAdBanner flurryadbanner)
        {
            (new StringBuilder("onShowFullscreen(")).append(flurryadbanner.toString()).append(")");
            if (mListener != null)
            {
                mListener.onBannerExpanded();
            }
        }

        public void onVideoCompleted(FlurryAdBanner flurryadbanner)
        {
            (new StringBuilder("onVideoCompleted ")).append(flurryadbanner.toString());
        }

        private FlurryMopubBannerListener()
        {
            this$0 = FlurryCustomEventBanner.this;
            super();
            LOG_TAG = getClass().getSimpleName();
        }

    }

}
