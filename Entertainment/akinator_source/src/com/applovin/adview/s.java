// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import android.view.View;
import android.view.animation.AlphaAnimation;
import com.applovin.impl.adview.u;
import com.applovin.impl.sdk.bv;

// Referenced classes of package com.applovin.adview:
//            AppLovinInterstitialActivity

class s
    implements Runnable
{

    final AppLovinInterstitialActivity a;

    s(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        a = applovininterstitialactivity;
        super();
    }

    public void run()
    {
        if (AppLovinInterstitialActivity.o(a))
        {
            AppLovinInterstitialActivity.m(a).setVisibility(0);
            return;
        }
        try
        {
            AppLovinInterstitialActivity.b(a, true);
            if (AppLovinInterstitialActivity.p(a) && AppLovinInterstitialActivity.q(a) != null)
            {
                AppLovinInterstitialActivity.q(a).setVisibility(0);
                AppLovinInterstitialActivity.q(a).bringToFront();
            }
            AppLovinInterstitialActivity.m(a).setVisibility(0);
            AppLovinInterstitialActivity.m(a).bringToFront();
            AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
            alphaanimation.setDuration(AppLovinInterstitialActivity.j(a).e());
            alphaanimation.setRepeatCount(0);
            AppLovinInterstitialActivity.m(a).startAnimation(alphaanimation);
            return;
        }
        catch (Throwable throwable)
        {
            a.dismiss();
        }
        return;
    }
}
