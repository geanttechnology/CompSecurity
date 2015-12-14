// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import com.inmobi.commons.InMobi;
import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.IMInterstitial;
import com.inmobi.monetization.IMInterstitialListener;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.mopub.mobileads:
//            CustomEventInterstitial, MoPubErrorCode

public class InMobiInterstitial extends CustomEventInterstitial
    implements IMInterstitialListener
{

    public static final String APP_ID_KEY = "app_id";
    private static final String DEFAULT_APP_ID = "YOUR_INMOBI_APP_ID_HERE";
    private static boolean isAppInitialized = false;
    private IMInterstitial iMInterstitial;
    private CustomEventInterstitial.CustomEventInterstitialListener mInterstitialListener;

    public InMobiInterstitial()
    {
    }

    private boolean extrasAreValid(Map map)
    {
        return map.containsKey("app_id");
    }

    protected void loadInterstitial(Context context, CustomEventInterstitial.CustomEventInterstitialListener customeventinterstitiallistener, Map map, Map map1)
    {
        mInterstitialListener = customeventinterstitiallistener;
        if (context instanceof Activity)
        {
            context = (Activity)context;
        } else
        {
            context = null;
        }
        if (context == null)
        {
            mInterstitialListener.onInterstitialFailed(MoPubErrorCode.UNSPECIFIED);
            return;
        }
        customeventinterstitiallistener = "YOUR_INMOBI_APP_ID_HERE";
        if (extrasAreValid(map1))
        {
            customeventinterstitiallistener = (String)map1.get("app_id");
        }
        if (!isAppInitialized)
        {
            InMobi.initialize(context, customeventinterstitiallistener);
            isAppInitialized = true;
        }
        iMInterstitial = new IMInterstitial(context, customeventinterstitiallistener);
        context = new HashMap();
        context.put("tp", "c_mopub");
        context.put("tp-ver", "3.13.0");
        iMInterstitial.setRequestParams(context);
        iMInterstitial.setIMInterstitialListener(this);
        iMInterstitial.loadInterstitial();
    }

    public void onDismissInterstitialScreen(IMInterstitial iminterstitial)
    {
        mInterstitialListener.onInterstitialDismissed();
    }

    public void onInterstitialFailed(IMInterstitial iminterstitial, IMErrorCode imerrorcode)
    {
        if (imerrorcode == IMErrorCode.INTERNAL_ERROR)
        {
            mInterstitialListener.onInterstitialFailed(MoPubErrorCode.INTERNAL_ERROR);
            return;
        }
        if (imerrorcode == IMErrorCode.INVALID_REQUEST)
        {
            mInterstitialListener.onInterstitialFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        if (imerrorcode == IMErrorCode.NETWORK_ERROR)
        {
            mInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
            return;
        }
        if (imerrorcode == IMErrorCode.NO_FILL)
        {
            mInterstitialListener.onInterstitialFailed(MoPubErrorCode.NO_FILL);
            return;
        } else
        {
            mInterstitialListener.onInterstitialFailed(MoPubErrorCode.UNSPECIFIED);
            return;
        }
    }

    public void onInterstitialInteraction(IMInterstitial iminterstitial, Map map)
    {
        mInterstitialListener.onInterstitialClicked();
    }

    public void onInterstitialLoaded(IMInterstitial iminterstitial)
    {
        mInterstitialListener.onInterstitialLoaded();
    }

    public void onInvalidate()
    {
        if (iMInterstitial != null)
        {
            iMInterstitial.setIMInterstitialListener(null);
            iMInterstitial.destroy();
        }
    }

    public void onLeaveApplication(IMInterstitial iminterstitial)
    {
    }

    public void onShowInterstitialScreen(IMInterstitial iminterstitial)
    {
        mInterstitialListener.onInterstitialShown();
    }

    public void showInterstitial()
    {
        if (iMInterstitial != null && com.inmobi.monetization.IMInterstitial.State.READY.equals(iMInterstitial.getState()))
        {
            iMInterstitial.show();
        }
    }

}
