// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;

// Referenced classes of package com.groupon.activity:
//            Splash

class nerAdapter extends AnimatorListenerAdapter
{

    final Splash this$0;

    public void onAnimationEnd(Animator animator)
    {
        ObjectAnimator.ofFloat(welcomeText, "alpha", new float[] {
            0.0F, 1.0F
        }).setDuration(300L).start();
    }

    r()
    {
        this$0 = Splash.this;
        super();
    }
}
