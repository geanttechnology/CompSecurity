// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.util.DisplayMetrics;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

// Referenced classes of package com.groupon.view:
//            HotelsLoadingScreen

class val.fromXFull
    implements android.view.animation.tener
{

    final HotelsLoadingScreen this$0;
    final int val$fromXFull;

    public void onAnimationEnd(Animation animation)
    {
        animation = new TranslateAnimation(val$fromXFull, HotelsLoadingScreen.access$000(HotelsLoadingScreen.this).widthPixels, 0.0F, 0.0F);
        animation.setDuration(20000L);
        animation.setRepeatCount(-1);
        animation.setRepeatMode(1);
        animation.setInterpolator(new AccelerateInterpolator());
        HotelsLoadingScreen.access$100(HotelsLoadingScreen.this).startAnimation(animation);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    olator()
    {
        this$0 = final_hotelsloadingscreen;
        val$fromXFull = I.this;
        super();
    }
}
