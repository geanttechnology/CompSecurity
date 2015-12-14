// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import java.util.List;

// Referenced classes of package com.applovin.impl.sdk:
//            bd

class bj
    implements AppLovinNativeAdLoadListener
{

    final AppLovinNativeAdLoadListener a;
    final bd b;

    bj(bd bd, AppLovinNativeAdLoadListener applovinnativeadloadlistener)
    {
        b = bd;
        a = applovinnativeadloadlistener;
        super();
    }

    public void onNativeAdsFailedToLoad(int i)
    {
        if (a != null)
        {
            a.onNativeAdsFailedToLoad(i);
        }
    }

    public void onNativeAdsLoaded(List list)
    {
        if (a != null)
        {
            a.onNativeAdsLoaded(list);
        }
    }
}
