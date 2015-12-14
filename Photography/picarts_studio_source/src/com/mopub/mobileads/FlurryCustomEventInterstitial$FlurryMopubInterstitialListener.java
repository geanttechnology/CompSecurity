// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.flurry.android.ads.FlurryAdErrorType;
import com.flurry.android.ads.FlurryAdInterstitial;
import com.flurry.android.ads.FlurryAdInterstitialListener;

// Referenced classes of package com.mopub.mobileads:
//            FlurryCustomEventInterstitial, MoPubErrorCode

class <init>
    implements FlurryAdInterstitialListener
{

    private final String LOG_TAG;
    final FlurryCustomEventInterstitial this$0;

    public void onAppExit(FlurryAdInterstitial flurryadinterstitial)
    {
        (new StringBuilder("onAppExit(")).append(flurryadinterstitial.toString()).append(")");
        if (FlurryCustomEventInterstitial.access$100(FlurryCustomEventInterstitial.this) != null)
        {
            FlurryCustomEventInterstitial.access$100(FlurryCustomEventInterstitial.this).eApplication();
        }
    }

    public void onClicked(FlurryAdInterstitial flurryadinterstitial)
    {
        (new StringBuilder("onClicked ")).append(flurryadinterstitial.toString());
        if (FlurryCustomEventInterstitial.access$100(FlurryCustomEventInterstitial.this) != null)
        {
            FlurryCustomEventInterstitial.access$100(FlurryCustomEventInterstitial.this).rstitialClicked();
        }
    }

    public void onClose(FlurryAdInterstitial flurryadinterstitial)
    {
        (new StringBuilder("onClose(")).append(flurryadinterstitial.toString()).append(")");
        if (FlurryCustomEventInterstitial.access$100(FlurryCustomEventInterstitial.this) != null)
        {
            FlurryCustomEventInterstitial.access$100(FlurryCustomEventInterstitial.this).rstitialDismissed();
        }
    }

    public void onDisplay(FlurryAdInterstitial flurryadinterstitial)
    {
        (new StringBuilder("onDisplay(")).append(flurryadinterstitial.toString()).append(")");
    }

    public void onError(FlurryAdInterstitial flurryadinterstitial, FlurryAdErrorType flurryaderrortype, int i)
    {
        (new StringBuilder("onError(")).append(flurryadinterstitial.toString()).append(flurryaderrortype.toString()).append(i).append(")");
        if (FlurryCustomEventInterstitial.access$100(FlurryCustomEventInterstitial.this) != null)
        {
            if (FlurryAdErrorType.FETCH.equals(flurryaderrortype))
            {
                FlurryCustomEventInterstitial.access$100(FlurryCustomEventInterstitial.this).rstitialFailed(MoPubErrorCode.NETWORK_NO_FILL);
            } else
            if (FlurryAdErrorType.RENDER.equals(flurryaderrortype))
            {
                FlurryCustomEventInterstitial.access$100(FlurryCustomEventInterstitial.this).rstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
                return;
            }
        }
    }

    public void onFetched(FlurryAdInterstitial flurryadinterstitial)
    {
        (new StringBuilder("onFetched(")).append(flurryadinterstitial.toString()).append(")");
        if (FlurryCustomEventInterstitial.access$100(FlurryCustomEventInterstitial.this) != null)
        {
            FlurryCustomEventInterstitial.access$100(FlurryCustomEventInterstitial.this).rstitialLoaded();
        }
    }

    public void onRendered(FlurryAdInterstitial flurryadinterstitial)
    {
        (new StringBuilder("onRendered(")).append(flurryadinterstitial.toString()).append(")");
        if (FlurryCustomEventInterstitial.access$100(FlurryCustomEventInterstitial.this) != null)
        {
            FlurryCustomEventInterstitial.access$100(FlurryCustomEventInterstitial.this).rstitialShown();
        }
    }

    public void onVideoCompleted(FlurryAdInterstitial flurryadinterstitial)
    {
        (new StringBuilder("onVideoCompleted ")).append(flurryadinterstitial.toString());
    }

    private ()
    {
        this$0 = FlurryCustomEventInterstitial.this;
        super();
        LOG_TAG = getClass().getSimpleName();
    }

    LOG_TAG(LOG_TAG log_tag)
    {
        this();
    }
}
