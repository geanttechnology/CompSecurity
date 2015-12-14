// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;

// Referenced classes of package com.applovin.impl.adview:
//            AdViewControllerImpl

class e
    implements AppLovinAdVideoPlaybackListener
{

    final AdViewControllerImpl a;

    e(AdViewControllerImpl adviewcontrollerimpl)
    {
        a = adviewcontrollerimpl;
        super();
    }

    public void videoPlaybackBegan(AppLovinAd applovinad)
    {
        if (AdViewControllerImpl.i(a) != null)
        {
            AdViewControllerImpl.i(a).videoPlaybackBegan(applovinad);
        }
    }

    public void videoPlaybackEnded(AppLovinAd applovinad, double d, boolean flag)
    {
        if (AdViewControllerImpl.i(a) != null)
        {
            AdViewControllerImpl.i(a).videoPlaybackEnded(applovinad, d, flag);
        }
    }
}
