// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.nativeAds;


// Referenced classes of package com.applovin.nativeAds:
//            AppLovinNativeAd

public interface AppLovinNativeAdPrecacheListener
{

    public abstract void onNativeAdImagePrecachingFailed(AppLovinNativeAd applovinnativead, int i);

    public abstract void onNativeAdImagesPrecached(AppLovinNativeAd applovinnativead);

    public abstract void onNativeAdVideoPrecachingFailed(AppLovinNativeAd applovinnativead, int i);

    public abstract void onNativeAdVideoPreceached(AppLovinNativeAd applovinnativead);
}
