// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;

// Referenced classes of package com.applovin.impl.sdk:
//            bd

class bg
    implements AppLovinNativeAdPrecacheListener
{

    final AppLovinNativeAdPrecacheListener a;
    final bd b;

    bg(bd bd1, AppLovinNativeAdPrecacheListener applovinnativeadprecachelistener)
    {
        b = bd1;
        a = applovinnativeadprecachelistener;
        super();
    }

    public void onNativeAdImagePrecachingFailed(AppLovinNativeAd applovinnativead, int i)
    {
    }

    public void onNativeAdImagesPrecached(AppLovinNativeAd applovinnativead)
    {
    }

    public void onNativeAdVideoPrecachingFailed(AppLovinNativeAd applovinnativead, int i)
    {
        bd.a(b, a, applovinnativead, i, true);
    }

    public void onNativeAdVideoPreceached(AppLovinNativeAd applovinnativead)
    {
        bd.a(b, a, applovinnativead, true);
    }
}
