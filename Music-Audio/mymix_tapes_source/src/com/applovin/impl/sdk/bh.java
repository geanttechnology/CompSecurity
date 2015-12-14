// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import java.util.List;

// Referenced classes of package com.applovin.impl.sdk:
//            bi, bd

class bh
    implements AppLovinNativeAdLoadListener
{

    final List a;
    final AppLovinNativeAdLoadListener b;
    final List c;
    final bd d;

    bh(bd bd1, List list, AppLovinNativeAdLoadListener applovinnativeadloadlistener, List list1)
    {
        d = bd1;
        a = list;
        b = applovinnativeadloadlistener;
        c = list1;
        super();
    }

    public void onNativeAdsFailedToLoad(int i)
    {
        if (b != null)
        {
            b.onNativeAdsFailedToLoad(i);
        }
    }

    public void onNativeAdsLoaded(List list)
    {
        bd.a(d, a, new bi(this));
    }
}
