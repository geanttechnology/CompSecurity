// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.nativeAds;


// Referenced classes of package com.applovin.nativeAds:
//            AppLovinNativeAdLoadListener, AppLovinNativeAd, AppLovinNativeAdPrecacheListener

public interface AppLovinNativeAdService
{

    public abstract void loadNativeAds(int i, AppLovinNativeAdLoadListener applovinnativeadloadlistener);

    public abstract void precacheResources(AppLovinNativeAd applovinnativead, AppLovinNativeAdPrecacheListener applovinnativeadprecachelistener);
}
