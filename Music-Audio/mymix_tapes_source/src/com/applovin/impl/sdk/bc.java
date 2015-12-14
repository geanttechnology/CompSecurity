// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdkUtils;

// Referenced classes of package com.applovin.impl.sdk:
//            NativeAdImpl, bb, ay

class bc
    implements AppLovinNativeAdPrecacheListener
{

    final bb a;

    bc(bb bb1)
    {
        a = bb1;
        super();
    }

    public void onNativeAdImagePrecachingFailed(AppLovinNativeAd applovinnativead, int i)
    {
        a.b(NativeAdImpl.SPEC_NATIVE, i);
    }

    public void onNativeAdImagesPrecached(AppLovinNativeAd applovinnativead)
    {
        if (!AppLovinSdkUtils.isValidString(applovinnativead.getVideoUrl()))
        {
            a.c((ay)applovinnativead);
        }
    }

    public void onNativeAdVideoPrecachingFailed(AppLovinNativeAd applovinnativead, int i)
    {
        a.b.w("NativeAdPreloadManager", (new StringBuilder()).append("Video failed to cache during native ad preload. ").append(i).toString());
        a.c((ay)applovinnativead);
    }

    public void onNativeAdVideoPreceached(AppLovinNativeAd applovinnativead)
    {
        a.c((ay)applovinnativead);
    }
}
