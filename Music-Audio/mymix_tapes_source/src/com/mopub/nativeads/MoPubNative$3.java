// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import com.mopub.network.AdResponse;

// Referenced classes of package com.mopub.nativeads:
//            MoPubNative, AdRendererRegistry, NativeErrorCode, NativeAd, 
//            BaseNativeAd

class val.response
    implements ive.CustomEventNativeListener
{

    final MoPubNative this$0;
    final AdResponse val$response;

    public void onNativeAdFailed(NativeErrorCode nativeerrorcode)
    {
        requestNativeAd(val$response.getFailoverUrl());
    }

    public void onNativeAdLoaded(BaseNativeAd basenativead)
    {
        android.content.Context context = getContextOrDestroy();
        if (context == null)
        {
            return;
        }
        MoPubAdRenderer mopubadrenderer = mAdRendererRegistry.getRendererForAd(basenativead);
        if (mopubadrenderer == null)
        {
            onNativeAdFailed(NativeErrorCode.NATIVE_RENDERER_CONFIGURATION_ERROR);
            return;
        } else
        {
            MoPubNative.access$200(MoPubNative.this).onNativeLoad(new NativeAd(context, val$response.getImpressionTrackingUrl(), val$response.getClickTrackingUrl(), MoPubNative.access$100(MoPubNative.this), basenativead, mopubadrenderer));
            return;
        }
    }

    e()
    {
        this$0 = final_mopubnative;
        val$response = AdResponse.this;
        super();
    }
}
