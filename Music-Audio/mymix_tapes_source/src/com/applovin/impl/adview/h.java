// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinLogger;

// Referenced classes of package com.applovin.impl.adview:
//            AdViewControllerImpl

class h
    implements Runnable
{

    final AdViewControllerImpl a;
    private final AppLovinAd b;

    public h(AdViewControllerImpl adviewcontrollerimpl, AppLovinAd applovinad)
    {
        a = adviewcontrollerimpl;
        super();
        b = applovinad;
    }

    public void run()
    {
        AppLovinAdDisplayListener applovinaddisplaylistener;
        applovinaddisplaylistener = AdViewControllerImpl.g(a);
        if (applovinaddisplaylistener == null || b == null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        applovinaddisplaylistener.adHidden(b);
        return;
        Throwable throwable;
        throwable;
        AdViewControllerImpl.b(a).userError("AppLovinAdView", "Exception while notifying ad display listener", throwable);
        return;
    }
}
