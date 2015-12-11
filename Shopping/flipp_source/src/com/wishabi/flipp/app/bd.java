// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

// Referenced classes of package com.wishabi.flipp.app:
//            be, FlyerActivity

final class bd
    implements Runnable
{

    final FlyerActivity a;

    bd(FlyerActivity flyeractivity)
    {
        a = flyeractivity;
        super();
    }

    public final void run()
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
        alphaanimation.setDuration(500L);
        alphaanimation.setAnimationListener(new be(this));
        FlyerActivity.c(a).startAnimation(alphaanimation);
    }
}
