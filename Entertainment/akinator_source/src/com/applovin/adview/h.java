// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import com.applovin.impl.sdk.AppLovinAdImpl;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;

// Referenced classes of package com.applovin.adview:
//            AppLovinInterstitialActivity

class h
    implements AppLovinAdDisplayListener
{

    final AppLovinInterstitialActivity a;

    h(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        a = applovininterstitialactivity;
        super();
    }

    public void adDisplayed(AppLovinAd applovinad)
    {
        AppLovinInterstitialActivity.a(a, (AppLovinAdImpl)applovinad);
        if (!AppLovinInterstitialActivity.v(a))
        {
            AppLovinInterstitialActivity.b(a, applovinad);
        }
    }

    public void adHidden(AppLovinAd applovinad)
    {
        AppLovinInterstitialActivity.a(a, applovinad);
    }
}
