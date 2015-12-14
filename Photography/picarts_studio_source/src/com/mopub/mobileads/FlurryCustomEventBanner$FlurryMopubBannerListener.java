// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.flurry.android.ads.FlurryAdBanner;
import com.flurry.android.ads.FlurryAdBannerListener;
import com.flurry.android.ads.FlurryAdErrorType;

// Referenced classes of package com.mopub.mobileads:
//            FlurryCustomEventBanner, MoPubErrorCode

class <init>
    implements FlurryAdBannerListener
{

    private final String LOG_TAG;
    final FlurryCustomEventBanner this$0;

    public void onAppExit(FlurryAdBanner flurryadbanner)
    {
        (new StringBuilder("onAppExit(")).append(flurryadbanner.toString()).append(")");
        if (FlurryCustomEventBanner.access$200(FlurryCustomEventBanner.this) != null)
        {
            FlurryCustomEventBanner.access$200(FlurryCustomEventBanner.this).eApplication();
        }
    }

    public void onClicked(FlurryAdBanner flurryadbanner)
    {
        (new StringBuilder("onClicked ")).append(flurryadbanner.toString());
        if (FlurryCustomEventBanner.access$200(FlurryCustomEventBanner.this) != null)
        {
            FlurryCustomEventBanner.access$200(FlurryCustomEventBanner.this).erClicked();
        }
    }

    public void onCloseFullscreen(FlurryAdBanner flurryadbanner)
    {
        (new StringBuilder("onCloseFullscreen(")).append(flurryadbanner.toString()).append(")");
        if (FlurryCustomEventBanner.access$200(FlurryCustomEventBanner.this) != null)
        {
            FlurryCustomEventBanner.access$200(FlurryCustomEventBanner.this).erCollapsed();
        }
    }

    public void onError(FlurryAdBanner flurryadbanner, FlurryAdErrorType flurryaderrortype, int i)
    {
        (new StringBuilder("onError(")).append(flurryadbanner.toString()).append(flurryaderrortype.toString()).append(i).append(")");
        if (FlurryCustomEventBanner.access$200(FlurryCustomEventBanner.this) != null)
        {
            if (FlurryAdErrorType.FETCH.equals(flurryaderrortype))
            {
                FlurryCustomEventBanner.access$200(FlurryCustomEventBanner.this).erFailed(MoPubErrorCode.NETWORK_NO_FILL);
            } else
            if (FlurryAdErrorType.RENDER.equals(flurryaderrortype))
            {
                FlurryCustomEventBanner.access$200(FlurryCustomEventBanner.this).erFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
                return;
            }
        }
    }

    public void onFetched(FlurryAdBanner flurryadbanner)
    {
        (new StringBuilder("onFetched(")).append(flurryadbanner.toString()).append(")");
        if (FlurryCustomEventBanner.access$100(FlurryCustomEventBanner.this) != null)
        {
            FlurryCustomEventBanner.access$100(FlurryCustomEventBanner.this).displayAd();
        }
    }

    public void onRendered(FlurryAdBanner flurryadbanner)
    {
        (new StringBuilder("onRendered(")).append(flurryadbanner.toString()).append(")");
        if (FlurryCustomEventBanner.access$200(FlurryCustomEventBanner.this) != null)
        {
            FlurryCustomEventBanner.access$200(FlurryCustomEventBanner.this).erLoaded(FlurryCustomEventBanner.access$300(FlurryCustomEventBanner.this));
        }
    }

    public void onShowFullscreen(FlurryAdBanner flurryadbanner)
    {
        (new StringBuilder("onShowFullscreen(")).append(flurryadbanner.toString()).append(")");
        if (FlurryCustomEventBanner.access$200(FlurryCustomEventBanner.this) != null)
        {
            FlurryCustomEventBanner.access$200(FlurryCustomEventBanner.this).erExpanded();
        }
    }

    public void onVideoCompleted(FlurryAdBanner flurryadbanner)
    {
        (new StringBuilder("onVideoCompleted ")).append(flurryadbanner.toString());
    }

    private ()
    {
        this$0 = FlurryCustomEventBanner.this;
        super();
        LOG_TAG = getClass().getSimpleName();
    }

    LOG_TAG(LOG_TAG log_tag)
    {
        this();
    }
}
