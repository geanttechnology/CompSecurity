// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import android.view.View;
import android.view.animation.AlphaAnimation;
import com.applovin.impl.adview.u;
import com.applovin.impl.sdk.ca;
import com.applovin.sdk.AppLovinLogger;

// Referenced classes of package com.applovin.adview:
//            AppLovinInterstitialActivity

class f
    implements Runnable
{

    final AppLovinInterstitialActivity a;

    f(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        a = applovininterstitialactivity;
        super();
    }

    public void run()
    {
        try
        {
            if (!com.applovin.adview.AppLovinInterstitialActivity.u(a) && AppLovinInterstitialActivity.p(a) != null)
            {
                AppLovinInterstitialActivity.c(a, true);
                AppLovinInterstitialActivity.p(a).setVisibility(0);
                AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
                alphaanimation.setDuration(AppLovinInterstitialActivity.l(a).e());
                alphaanimation.setRepeatCount(0);
                AppLovinInterstitialActivity.p(a).startAnimation(alphaanimation);
                if (AppLovinInterstitialActivity.s(a) && AppLovinInterstitialActivity.v(a) != null)
                {
                    AppLovinInterstitialActivity.v(a).setVisibility(0);
                    AppLovinInterstitialActivity.v(a).bringToFront();
                }
            }
            return;
        }
        catch (Throwable throwable)
        {
            AppLovinInterstitialActivity.c(a).w("AppLovinInterstitialActivity", (new StringBuilder()).append("Unable to show skip button: ").append(throwable).toString());
        }
    }
}
