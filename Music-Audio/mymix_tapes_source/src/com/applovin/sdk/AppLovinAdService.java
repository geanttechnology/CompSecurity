// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.sdk;


// Referenced classes of package com.applovin.sdk:
//            AppLovinAdUpdateListener, AppLovinAdSize, AppLovinAdLoadListener

public interface AppLovinAdService
{

    public static final String URI_AD_SERVICE = "/adservice";
    public static final String URI_API_SERVICE = "/api";
    public static final String URI_CLOSE_AD = "/adservice/close_ad";
    public static final String URI_LAUNCH_APP = "/launch";
    public static final String URI_NEXT_AD = "/adservice/next_ad";

    public abstract void addAdUpdateListener(AppLovinAdUpdateListener applovinadupdatelistener);

    public abstract void addAdUpdateListener(AppLovinAdUpdateListener applovinadupdatelistener, AppLovinAdSize applovinadsize);

    public abstract boolean hasPreloadedAd(AppLovinAdSize applovinadsize);

    public abstract void loadNextAd(AppLovinAdSize applovinadsize, AppLovinAdLoadListener applovinadloadlistener);

    public abstract void preloadAd(AppLovinAdSize applovinadsize);

    public abstract void removeAdUpdateListener(AppLovinAdUpdateListener applovinadupdatelistener, AppLovinAdSize applovinadsize);
}
