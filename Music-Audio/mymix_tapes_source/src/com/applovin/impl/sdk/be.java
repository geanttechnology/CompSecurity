// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import java.util.List;

// Referenced classes of package com.applovin.impl.sdk:
//            bd

class be
    implements AppLovinNativeAdLoadListener
{

    final AppLovinNativeAdLoadListener a;
    final bd b;

    be(bd bd1, AppLovinNativeAdLoadListener applovinnativeadloadlistener)
    {
        b = bd1;
        a = applovinnativeadloadlistener;
        super();
    }

    public void onNativeAdsFailedToLoad(int i)
    {
        bd.a(b, a, i);
    }

    public void onNativeAdsLoaded(List list)
    {
        b.a(list, a);
    }
}
