// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;


// Referenced classes of package com.mopub.nativeads:
//            FlurryForwardingNativeAd, NativeErrorCode

class this._cls0
    implements ener
{

    final FlurryForwardingNativeAd this$0;

    public void onImagesCached()
    {
        if (FlurryForwardingNativeAd.access$000(FlurryForwardingNativeAd.this) != null)
        {
            FlurryForwardingNativeAd.access$100();
            FlurryForwardingNativeAd.access$000(FlurryForwardingNativeAd.this).onNativeAdLoaded(FlurryForwardingNativeAd.access$200(FlurryForwardingNativeAd.this));
            return;
        } else
        {
            FlurryForwardingNativeAd.access$100();
            return;
        }
    }

    public void onImagesFailedToCache(NativeErrorCode nativeerrorcode)
    {
        if (FlurryForwardingNativeAd.access$000(FlurryForwardingNativeAd.this) != null)
        {
            FlurryForwardingNativeAd.access$100();
            (new StringBuilder("preCacheImages: Unable to cache Ad image. Error[")).append(nativeerrorcode.toString()).append("]");
            FlurryForwardingNativeAd.access$000(FlurryForwardingNativeAd.this).onNativeAdFailed(nativeerrorcode);
            return;
        } else
        {
            FlurryForwardingNativeAd.access$100();
            return;
        }
    }

    ntNativeListener()
    {
        this$0 = FlurryForwardingNativeAd.this;
        super();
    }
}
