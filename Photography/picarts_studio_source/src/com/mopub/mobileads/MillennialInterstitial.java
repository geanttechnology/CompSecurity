// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.location.Location;
import com.millennialmedia.android.MMInterstitial;
import com.millennialmedia.android.MMRequest;
import com.millennialmedia.android.MMSDK;
import java.util.Map;

// Referenced classes of package com.mopub.mobileads:
//            CustomEventInterstitial, MoPubErrorCode

class MillennialInterstitial extends CustomEventInterstitial
{

    public static final String APID_KEY = "adUnitID";
    private CustomEventInterstitial.CustomEventInterstitialListener mInterstitialListener;
    private MMInterstitial mMillennialInterstitial;

    MillennialInterstitial()
    {
    }

    private boolean extrasAreValid(Map map)
    {
        return map.containsKey("adUnitID");
    }

    protected void loadInterstitial(Context context, CustomEventInterstitial.CustomEventInterstitialListener customeventinterstitiallistener, Map map, Map map1)
    {
        mInterstitialListener = customeventinterstitiallistener;
        if (extrasAreValid(map1))
        {
            customeventinterstitiallistener = (String)map1.get("adUnitID");
            MMSDK.initialize(context);
            map = (Location)map.get("location");
            if (map != null)
            {
                MMRequest.setUserLocation(map);
            }
            mMillennialInterstitial = new MMInterstitial(context);
            mMillennialInterstitial.setListener(new MillennialInterstitialRequestListener());
            mMillennialInterstitial.setMMRequest(new MMRequest());
            mMillennialInterstitial.setApid(customeventinterstitiallistener);
            mMillennialInterstitial.fetch();
            return;
        } else
        {
            mInterstitialListener.onInterstitialFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
    }

    protected void onInvalidate()
    {
        if (mMillennialInterstitial != null)
        {
            mMillennialInterstitial.setListener(null);
        }
    }

    protected void showInterstitial()
    {
        if (mMillennialInterstitial.isAdAvailable())
        {
            mMillennialInterstitial.display();
        }
    }



    private class MillennialInterstitialRequestListener
        implements RequestListener
    {

        final MillennialInterstitial this$0;

        public void MMAdOverlayClosed(MMAd mmad)
        {
            mInterstitialListener.onInterstitialDismissed();
        }

        public void MMAdOverlayLaunched(MMAd mmad)
        {
            mInterstitialListener.onInterstitialShown();
        }

        public void MMAdRequestIsCaching(MMAd mmad)
        {
        }

        public void onSingleTap(MMAd mmad)
        {
            mInterstitialListener.onInterstitialClicked();
        }

        public void requestCompleted(MMAd mmad)
        {
            if (mMillennialInterstitial.isAdAvailable())
            {
                mInterstitialListener.onInterstitialLoaded();
                return;
            } else
            {
                mInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
                return;
            }
        }

        public void requestFailed(MMAd mmad, MMException mmexception)
        {
            if (mMillennialInterstitial == null || mmexception == null)
            {
                mInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
                return;
            }
            if (mmexception.getCode() == 17 && mMillennialInterstitial.isAdAvailable())
            {
                mInterstitialListener.onInterstitialLoaded();
                return;
            } else
            {
                mInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_NO_FILL);
                return;
            }
        }

        MillennialInterstitialRequestListener()
        {
            this$0 = MillennialInterstitial.this;
            super();
        }
    }

}
