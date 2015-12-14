// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import android.view.View;
import android.view.animation.AlphaAnimation;
import com.applovin.impl.adview.u;
import com.applovin.impl.sdk.ca;

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
        if (AppLovinInterstitialActivity.r(a))
        {
            AppLovinInterstitialActivity.o(a).setVisibility(0);
            return;
        }
        try
        {
            AppLovinInterstitialActivity.b(a, true);
            if (AppLovinInterstitialActivity.s(a) && AppLovinInterstitialActivity.t(a) != null)
            {
                AppLovinInterstitialActivity.t(a).setVisibility(0);
                AppLovinInterstitialActivity.t(a).bringToFront();
            }
            AppLovinInterstitialActivity.o(a).setVisibility(0);
            AppLovinInterstitialActivity.o(a).bringToFront();
            AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
            alphaanimation.setDuration(AppLovinInterstitialActivity.l(a).e());
            alphaanimation.setRepeatCount(0);
            AppLovinInterstitialActivity.o(a).startAnimation(alphaanimation);
            return;
        }
        catch (Throwable throwable)
        {
            a.dismiss();
        }
        return;
    }
}
