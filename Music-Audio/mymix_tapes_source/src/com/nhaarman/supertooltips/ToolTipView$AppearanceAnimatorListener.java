// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.supertooltips;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;

// Referenced classes of package com.nhaarman.supertooltips:
//            ToolTipView

private class mToolTipViewY extends AnimatorListenerAdapter
{

    private final float mToolTipViewX;
    private final float mToolTipViewY;
    final ToolTipView this$0;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        animator = (android.widget.torListener)getLayoutParams();
        animator. = (int)mToolTipViewX;
        animator.mToolTipViewX = (int)mToolTipViewY;
        setX(0.0F);
        setY(0.0F);
        setLayoutParams(animator);
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    (float f, float f1)
    {
        this$0 = ToolTipView.this;
        super();
        mToolTipViewX = f;
        mToolTipViewY = f1;
    }
}
