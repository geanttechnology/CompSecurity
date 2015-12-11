// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import com.applovin.impl.adview.u;

// Referenced classes of package com.applovin.adview:
//            AppLovinInterstitialActivity

class f
    implements Runnable
{

    final u a;
    final AppLovinInterstitialActivity b;

    f(AppLovinInterstitialActivity applovininterstitialactivity, u u)
    {
        b = applovininterstitialactivity;
        a = u;
        super();
    }

    public void run()
    {
        if (a.equals(AppLovinInterstitialActivity.m(b)))
        {
            AppLovinInterstitialActivity.t(b);
        } else
        if (a.equals(AppLovinInterstitialActivity.n(b)))
        {
            com.applovin.adview.AppLovinInterstitialActivity.u(b);
            return;
        }
    }
}
