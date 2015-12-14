// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import android.view.View;
import android.view.animation.AlphaAnimation;
import com.applovin.impl.adview.s;
import com.applovin.impl.sdk.AppLovinSdkImpl;
import com.applovin.impl.sdk.ca;
import com.applovin.sdk.AppLovinLogger;

// Referenced classes of package com.applovin.adview:
//            AppLovinInterstitialActivity, o

class n
    implements android.view.View.OnClickListener
{

    final AppLovinInterstitialActivity a;

    n(AppLovinInterstitialActivity applovininterstitialactivity)
    {
        a = applovininterstitialactivity;
        super();
    }

    public void onClick(View view)
    {
        float f1 = 1.0F;
        AppLovinInterstitialActivity.k(a).getLogger().d("AppLovinInterstitialActivity", "Video view tapped!");
        if (AppLovinInterstitialActivity.l(a).z() && AppLovinInterstitialActivity.m(a) != null && AppLovinInterstitialActivity.m(a).getVisibility() != 8)
        {
            float f;
            boolean flag;
            if (AppLovinInterstitialActivity.m(a).getVisibility() == 4)
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
            view.setAnimationListener(new o(this, flag));
            AppLovinInterstitialActivity.m(a).startAnimation(view);
        }
    }
}
