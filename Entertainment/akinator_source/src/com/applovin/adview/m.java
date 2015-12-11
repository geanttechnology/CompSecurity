// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import android.view.View;
import android.view.animation.AlphaAnimation;
import com.applovin.impl.adview.s;
import com.applovin.impl.sdk.AppLovinSdkImpl;
import com.applovin.impl.sdk.bv;
import com.applovin.sdk.AppLovinLogger;

// Referenced classes of package com.applovin.adview:
//            AppLovinInterstitialActivity, n

class m
    implements android.view.View.OnClickListener
{

    final AppLovinInterstitialActivity a;

    m(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        a = applovininterstitialactivity;
        super();
    }

    public void onClick(View view)
    {
        float f1 = 1.0F;
        AppLovinInterstitialActivity.i(a).getLogger().d("AppLovinInterstitialActivity", "Video view tapped!");
        if (AppLovinInterstitialActivity.j(a).z() && AppLovinInterstitialActivity.k(a) != null && AppLovinInterstitialActivity.k(a).getVisibility() != 8)
        {
            float f;
            boolean flag;
            if (AppLovinInterstitialActivity.k(a).getVisibility() == 4)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                f = 0.0F;
            } else
            {
                f = 1.0F;
            }
            if (!flag)
            {
                f1 = 0.0F;
            }
            view = new AlphaAnimation(f, f1);
            view.setDuration(750L);
            view.setAnimationListener(new n(this, flag));
            AppLovinInterstitialActivity.k(a).startAnimation(view);
        }
    }
}
