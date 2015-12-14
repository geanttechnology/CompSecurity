// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinLogger;

// Referenced classes of package com.applovin.impl.adview:
//            AdViewControllerImpl

class g
    implements Runnable
{

    final AdViewControllerImpl a;
    private final AppLovinAd b;

    public g(AdViewControllerImpl adviewcontrollerimpl, AppLovinAd applovinad)
    {
        a = adviewcontrollerimpl;
        super();
        b = applovinad;
    }

    public void run()
    {
        AppLovinAdClickListener applovinadclicklistener;
        applovinadclicklistener = AdViewControllerImpl.h(a);
        if (applovinadclicklistener == null || b == null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        applovinadclicklistener.adClicked(b);
        return;
        Throwable throwable;
        throwable;
        AdViewControllerImpl.b(a).userError("AppLovinAdView", "Exception while notifying ad click listener", throwable);
        return;
    }
}
