// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import com.mopub.network.AdResponse;

// Referenced classes of package com.mopub.nativeads:
//            MoPubNative, NativeResponse, NativeErrorCode, NativeAdInterface

class val.response
    implements ive.CustomEventNativeListener
{

    final MoPubNative this$0;
    final AdResponse val$response;

    public void onNativeAdFailed(NativeErrorCode nativeerrorcode)
    {
        requestNativeAd(val$response.getFailoverUrl());
    }

    public void onNativeAdLoaded(NativeAdInterface nativeadinterface)
    {
        android.content.Context context = getContextOrDestroy();
        if (context == null)
        {
            return;
        } else
        {
            MoPubNative.access$300(MoPubNative.this).onNativeLoad(new NativeResponse(context, val$response.getImpressionTrackingUrl(), val$response.getClickTrackingUrl(), MoPubNative.access$100(MoPubNative.this), nativeadinterface, MoPubNative.access$200(MoPubNative.this)));
            return;
        }
    }

    ace()
    {
        this$0 = final_mopubnative;
        val$response = AdResponse.this;
        super();
    }
}
