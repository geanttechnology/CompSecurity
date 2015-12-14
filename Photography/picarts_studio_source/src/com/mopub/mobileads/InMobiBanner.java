// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import com.inmobi.commons.InMobi;
import com.inmobi.monetization.IMBanner;
import com.inmobi.monetization.IMBannerListener;
import com.inmobi.monetization.IMErrorCode;
import com.mopub.common.util.Views;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.mopub.mobileads:
//            CustomEventBanner, MoPubErrorCode

public class InMobiBanner extends CustomEventBanner
    implements IMBannerListener
{

    public static final String APP_ID_KEY = "app_id";
    private static final String DEFAULT_APP_ID = "YOUR_INMOBI_APP_ID_HERE";
    private static boolean isAppInitialized = false;
    private IMBanner iMBanner;
    private CustomEventBanner.CustomEventBannerListener mBannerListener;

    public InMobiBanner()
    {
    }

    private boolean extrasAreValid(Map map)
    {
        return map.containsKey("app_id");
    }

    protected void loadBanner(Context context, CustomEventBanner.CustomEventBannerListener customeventbannerlistener, Map map, Map map1)
    {
        mBannerListener = customeventbannerlistener;
        customeventbannerlistener = "YOUR_INMOBI_APP_ID_HERE";
        if (context instanceof Activity)
        {
            context = (Activity)context;
        } else
        {
            context = null;
        }
        if (context == null)
        {
            mBannerListener.onBannerFailed(null);
            return;
        }
        if (extrasAreValid(map1))
        {
            customeventbannerlistener = (String)map1.get("app_id");
        }
        if (!isAppInitialized)
        {
            InMobi.initialize(context, customeventbannerlistener);
            isAppInitialized = true;
        }
        iMBanner = new IMBanner(context, customeventbannerlistener, 15);
        context = new HashMap();
        context.put("tp", "c_mopub");
        context.put("tp-ver", "3.13.0");
        iMBanner.setRequestParams(context);
        InMobi.setLogLevel(com.inmobi.commons.InMobi.LOG_LEVEL.VERBOSE);
        iMBanner.setIMBannerListener(this);
        iMBanner.setRefreshInterval(-1);
        iMBanner.loadBanner();
    }

    public void onBannerInteraction(IMBanner imbanner, Map map)
    {
        mBannerListener.onBannerClicked();
    }

    public void onBannerRequestFailed(IMBanner imbanner, IMErrorCode imerrorcode)
    {
        if (imerrorcode == IMErrorCode.INTERNAL_ERROR)
        {
            mBannerListener.onBannerFailed(MoPubErrorCode.INTERNAL_ERROR);
            return;
        }
        if (imerrorcode == IMErrorCode.INVALID_REQUEST)
        {
            mBannerListener.onBannerFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        if (imerrorcode == IMErrorCode.NETWORK_ERROR)
        {
            mBannerListener.onBannerFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
            return;
        }
        if (imerrorcode == IMErrorCode.NO_FILL)
        {
            mBannerListener.onBannerFailed(MoPubErrorCode.NO_FILL);
            return;
        } else
        {
            mBannerListener.onBannerFailed(MoPubErrorCode.UNSPECIFIED);
            return;
        }
    }

    public void onBannerRequestSucceeded(IMBanner imbanner)
    {
        if (iMBanner != null)
        {
            mBannerListener.onBannerLoaded(imbanner);
            return;
        } else
        {
            mBannerListener.onBannerFailed(null);
            return;
        }
    }

    public void onDismissBannerScreen(IMBanner imbanner)
    {
        mBannerListener.onBannerCollapsed();
    }

    public void onInvalidate()
    {
        if (iMBanner != null)
        {
            iMBanner.setIMBannerListener(null);
            Views.removeFromParent(iMBanner);
            iMBanner.destroy();
        }
    }

    public void onLeaveApplication(IMBanner imbanner)
    {
    }

    public void onShowBannerScreen(IMBanner imbanner)
    {
        mBannerListener.onBannerExpanded();
    }

}
