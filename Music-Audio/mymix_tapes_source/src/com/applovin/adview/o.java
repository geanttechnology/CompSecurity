// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import android.view.animation.Animation;
import com.applovin.impl.adview.s;

// Referenced classes of package com.applovin.adview:
//            n, AppLovinInterstitialActivity

class o
    implements android.view.animation.Animation.AnimationListener
{

    final boolean a;
    final n b;

    o(n n1, boolean flag)
    {
        b = n1;
        a = flag;
        super();
    }

    public void onAnimationEnd(Animation animation)
    {
        if (!a)
        {
            AppLovinInterstitialActivity.m(b.a).setVisibility(4);
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
        AppLovinInterstitialActivity.m(b.a).setVisibility(0);
    }
}
