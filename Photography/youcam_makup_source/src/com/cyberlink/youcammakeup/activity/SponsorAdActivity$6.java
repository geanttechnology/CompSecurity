// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            SponsorAdActivity

class a
    implements android.view.
{

    final SponsorAdActivity a;

    public void onClick(View view)
    {
        if (SponsorAdActivity.e(a).getVisibility() != 8 || SponsorAdActivity.f(a))
        {
            return;
        } else
        {
            SponsorAdActivity.g(a).setClickable(false);
            SponsorAdActivity.h(a).setVisibility(8);
            view = new AnimationSet(true);
            view.setInterpolator(new LinearInterpolator());
            view.setDuration(100L);
            view.addAnimation(new AlphaAnimation(1.0F, 0.0F));
            view.addAnimation(new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 0.2F));
            SponsorAdActivity.h(a).clearAnimation();
            SponsorAdActivity.h(a).startAnimation(view);
            return;
        }
    }

    (SponsorAdActivity sponsoradactivity)
    {
        a = sponsoradactivity;
        super();
    }
}
