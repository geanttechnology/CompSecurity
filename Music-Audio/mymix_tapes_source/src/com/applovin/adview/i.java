// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import com.applovin.impl.sdk.AppLovinAdImpl;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;

// Referenced classes of package com.applovin.adview:
//            AppLovinInterstitialActivity

class i
    implements AppLovinAdDisplayListener
{

    final AppLovinInterstitialActivity a;

    i(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        a = applovininterstitialactivity;
        super();
    }

    public void adDisplayed(AppLovinAd applovinad)
    {
        AppLovinInterstitialActivity.a(a, (AppLovinAdImpl)applovinad);
        if (!AppLovinInterstitialActivity.y(a))
        {
            AppLovinInterstitialActivity.b(a, applovinad);
        }
    }

    public void adHidden(AppLovinAd applovinad)
    {
        AppLovinInterstitialActivity.a(a, applovinad);
    }
}
