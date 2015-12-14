// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import com.applovin.impl.adview.af;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;

// Referenced classes of package com.applovin.adview:
//            AppLovinInterstitialActivity

class j
    implements AppLovinAdClickListener
{

    final AppLovinInterstitialActivity a;

    j(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        a = applovininterstitialactivity;
        super();
    }

    public void adClicked(AppLovinAd applovinad)
    {
        AppLovinAdClickListener applovinadclicklistener = AppLovinInterstitialActivity.z(a).e();
        if (applovinadclicklistener != null)
        {
            applovinadclicklistener.adClicked(applovinad);
        }
    }
}
