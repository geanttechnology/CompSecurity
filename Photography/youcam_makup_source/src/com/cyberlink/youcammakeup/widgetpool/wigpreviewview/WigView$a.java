// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.wigpreviewview;

import android.animation.Animator;
import android.animation.ValueAnimator;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.wigpreviewview:
//            WigView

class a
    implements android.animation.nimatorListener, android.animation.tor.AnimatorUpdateListener
{

    final WigView a;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        a.setAlpha(255F);
        a.setVisibility(4);
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f = ((Float)valueanimator.getAnimatedValue()).floatValue();
        a.setAlpha((int)(f * 255F));
        a.invalidate();
    }

    (WigView wigview)
    {
        a = wigview;
        super();
    }
}
