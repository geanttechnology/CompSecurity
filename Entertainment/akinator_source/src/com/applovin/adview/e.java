// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import android.view.View;
import android.view.animation.AlphaAnimation;
import com.applovin.impl.adview.u;
import com.applovin.impl.sdk.bv;
import com.applovin.sdk.AppLovinLogger;

// Referenced classes of package com.applovin.adview:
//            AppLovinInterstitialActivity

class e
    implements Runnable
{

    final AppLovinInterstitialActivity a;

    e(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        a = applovininterstitialactivity;
        super();
    }

    public void run()
    {
        try
        {
            if (!AppLovinInterstitialActivity.r(a) && AppLovinInterstitialActivity.n(a) != null)
            {
                AppLovinInterstitialActivity.c(a, true);
                AppLovinInterstitialActivity.n(a).setVisibility(0);
                AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
                alphaanimation.setDuration(AppLovinInterstitialActivity.j(a).e());
                alphaanimation.setRepeatCount(0);
                AppLovinInterstitialActivity.n(a).startAnimation(alphaanimation);
                if (AppLovinInterstitialActivity.p(a) && AppLovinInterstitialActivity.s(a) != null)
                {
                    AppLovinInterstitialActivity.s(a).setVisibility(0);
                    AppLovinInterstitialActivity.s(a).bringToFront();
                }
            }
            return;
        }
        catch (Throwable throwable)
        {
            AppLovinInterstitialActivity.b(a).w("AppLovinInterstitialActivity", (new StringBuilder()).append("Unable to show skip button: ").append(throwable).toString());
        }
    }
}
