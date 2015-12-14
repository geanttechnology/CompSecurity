// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;

// Referenced classes of package com.applovin.impl.adview:
//            AdViewControllerImpl

class d
    implements AppLovinAdDisplayListener
{

    final AdViewControllerImpl a;

    d(AdViewControllerImpl adviewcontrollerimpl)
    {
        a = adviewcontrollerimpl;
        super();
    }

    public void adDisplayed(AppLovinAd applovinad)
    {
    }

    public void adHidden(AppLovinAd applovinad)
    {
        if (AdViewControllerImpl.g(a) != null)
        {
            AdViewControllerImpl.g(a).adHidden(applovinad);
        }
    }
}
