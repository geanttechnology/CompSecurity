// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.flurry.android.ads.FlurryAdInterstitial;
import java.util.Map;

// Referenced classes of package com.mopub.mobileads:
//            CustomEventInterstitial, MoPubErrorCode, FlurryAgentWrapper

public class FlurryCustomEventInterstitial extends CustomEventInterstitial
{

    private static final String AD_SPACE_NAME = "adSpaceName";
    private static final String API_KEY = "apiKey";
    public static final String LOG_TAG = com/mopub/mobileads/FlurryCustomEventInterstitial.getSimpleName();
    private String mAdSpaceName;
    private String mApiKey;
    private Context mContext;
    private FlurryAdInterstitial mInterstitial;
    private CustomEventInterstitial.CustomEventInterstitialListener mListener;

    public FlurryCustomEventInterstitial()
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

    protected void loadInterstitial(Context context, CustomEventInterstitial.CustomEventInterstitialListener customeventinterstitiallistener, Map map, Map map1)
    {
        if (context == null)
        {
            Log.e(LOG_TAG, "Context cannot be null.");
            customeventinterstitiallistener.onInterstitialFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        if (customeventinterstitiallistener == null)
        {
            Log.e(LOG_TAG, "CustomEventInterstitialListener cannot be null.");
            customeventinterstitiallistener.onInterstitialFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        if (!(context instanceof Activity))
        {
            Log.e(LOG_TAG, "Ad can be rendered only in Activity context.");
            customeventinterstitiallistener.onInterstitialFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        if (!extrasAreValid(map1))
        {
            customeventinterstitiallistener.onInterstitialFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        } else
        {
            mContext = context;
            mListener = customeventinterstitiallistener;
            mApiKey = (String)map1.get("apiKey");
            mAdSpaceName = (String)map1.get("adSpaceName");
            FlurryAgentWrapper.getInstance().onStartSession(context, mApiKey);
            (new StringBuilder("fetch Flurry ad (")).append(mAdSpaceName).append(")");
            mInterstitial = new FlurryAdInterstitial(mContext, mAdSpaceName);
            mInterstitial.setListener(new FlurryMopubInterstitialListener());
            mInterstitial.fetchAd();
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
        if (mInterstitial != null)
        {
            mInterstitial.destroy();
            mInterstitial = null;
        }
        FlurryAgentWrapper.getInstance().onEndSession(mContext);
        mContext = null;
        mListener = null;
    }

    protected void showInterstitial()
    {
        (new StringBuilder("MoPub issued showInterstitial (")).append(mAdSpaceName).append(")");
        if (mInterstitial != null)
        {
            mInterstitial.displayAd();
        }
    }



    private class FlurryMopubInterstitialListener
        implements FlurryAdInterstitialListener
    {

        private final String LOG_TAG;
        final FlurryCustomEventInterstitial this$0;

        public void onAppExit(FlurryAdInterstitial flurryadinterstitial)
        {
            (new StringBuilder("onAppExit(")).append(flurryadinterstitial.toString()).append(")");
            if (mListener != null)
            {
                mListener.onLeaveApplication();
            }
        }

        public void onClicked(FlurryAdInterstitial flurryadinterstitial)
        {
            (new StringBuilder("onClicked ")).append(flurryadinterstitial.toString());
            if (mListener != null)
            {
                mListener.onInterstitialClicked();
            }
        }

        public void onClose(FlurryAdInterstitial flurryadinterstitial)
        {
            (new StringBuilder("onClose(")).append(flurryadinterstitial.toString()).append(")");
            if (mListener != null)
            {
                mListener.onInterstitialDismissed();
            }
        }

        public void onDisplay(FlurryAdInterstitial flurryadinterstitial)
        {
            (new StringBuilder("onDisplay(")).append(flurryadinterstitial.toString()).append(")");
        }

        public void onError(FlurryAdInterstitial flurryadinterstitial, FlurryAdErrorType flurryaderrortype, int i)
        {
            (new StringBuilder("onError(")).append(flurryadinterstitial.toString()).append(flurryaderrortype.toString()).append(i).append(")");
            if (mListener != null)
            {
                if (FlurryAdErrorType.FETCH.equals(flurryaderrortype))
                {
                    mListener.onInterstitialFailed(MoPubErrorCode.NETWORK_NO_FILL);
                } else
                if (FlurryAdErrorType.RENDER.equals(flurryaderrortype))
                {
                    mListener.onInterstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
                    return;
                }
            }
        }

        public void onFetched(FlurryAdInterstitial flurryadinterstitial)
        {
            (new StringBuilder("onFetched(")).append(flurryadinterstitial.toString()).append(")");
            if (mListener != null)
            {
                mListener.onInterstitialLoaded();
            }
        }

        public void onRendered(FlurryAdInterstitial flurryadinterstitial)
        {
            (new StringBuilder("onRendered(")).append(flurryadinterstitial.toString()).append(")");
            if (mListener != null)
            {
                mListener.onInterstitialShown();
            }
        }

        public void onVideoCompleted(FlurryAdInterstitial flurryadinterstitial)
        {
            (new StringBuilder("onVideoCompleted ")).append(flurryadinterstitial.toString());
        }

        private FlurryMopubInterstitialListener()
        {
            this$0 = FlurryCustomEventInterstitial.this;
            super();
            LOG_TAG = getClass().getSimpleName();
        }

    }

}
