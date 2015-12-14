// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import com.flurry.android.ads.FlurryAdErrorType;
import com.flurry.android.ads.FlurryAdNative;
import com.flurry.android.ads.FlurryAdNativeListener;

// Referenced classes of package com.mopub.nativeads:
//            FlurryForwardingNativeAd

class this._cls0
    implements FlurryAdNativeListener
{

    final FlurryForwardingNativeAd this$0;

    public void onAppExit(FlurryAdNative flurryadnative)
    {
        FlurryForwardingNativeAd.access$100();
        (new StringBuilder("onAppExit(")).append(flurryadnative.toString()).append(")");
    }

    public void onClicked(FlurryAdNative flurryadnative)
    {
        FlurryForwardingNativeAd.access$100();
        (new StringBuilder("onClicked(")).append(flurryadnative.toString()).append(") Successful.");
        notifyAdClicked();
    }

    public void onCloseFullscreen(FlurryAdNative flurryadnative)
    {
        FlurryForwardingNativeAd.access$100();
        (new StringBuilder("onCloseFullscreen(")).append(flurryadnative.toString()).append(")");
    }

    public void onError(FlurryAdNative flurryadnative, FlurryAdErrorType flurryaderrortype, int i)
    {
        if (flurryaderrortype.equals(FlurryAdErrorType.FETCH))
        {
            FlurryForwardingNativeAd.access$100();
            (new StringBuilder("onError(")).append(flurryadnative.toString()).append(", ").append(flurryaderrortype.toString()).append(",").append(i).append(")");
            FlurryForwardingNativeAd.access$400(FlurryForwardingNativeAd.access$200(FlurryForwardingNativeAd.this), flurryadnative);
        }
    }

    public void onFetched(FlurryAdNative flurryadnative)
    {
        FlurryForwardingNativeAd.access$100();
        (new StringBuilder("onFetched(")).append(flurryadnative.toString()).append(") Successful.");
        FlurryForwardingNativeAd.access$300(FlurryForwardingNativeAd.access$200(FlurryForwardingNativeAd.this), flurryadnative);
    }

    public void onImpressionLogged(FlurryAdNative flurryadnative)
    {
        FlurryForwardingNativeAd.access$100();
        (new StringBuilder("onImpressionLogged(")).append(flurryadnative.toString()).append(")  Successful.");
        notifyAdImpressed();
    }

    public void onShowFullscreen(FlurryAdNative flurryadnative)
    {
        FlurryForwardingNativeAd.access$100();
        (new StringBuilder("onShowFullscreen(")).append(flurryadnative.toString()).append(")");
    }

    ()
    {
        this$0 = FlurryForwardingNativeAd.this;
        super();
    }
}
