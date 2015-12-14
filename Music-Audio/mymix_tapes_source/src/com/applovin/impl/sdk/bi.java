// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.applovin.impl.sdk:
//            bh

class bi
    implements AppLovinNativeAdLoadListener
{

    final bh a;

    bi(bh bh1)
    {
        a = bh1;
        super();
    }

    public void onNativeAdsFailedToLoad(int i)
    {
        if (a.b != null)
        {
            a.b.onNativeAdsFailedToLoad(i);
        }
    }

    public void onNativeAdsLoaded(List list)
    {
        if (a.b != null)
        {
            list = new ArrayList();
            list.addAll(a.a);
            list.addAll(a.c);
            a.b.onNativeAdsLoaded(list);
        }
    }
}
