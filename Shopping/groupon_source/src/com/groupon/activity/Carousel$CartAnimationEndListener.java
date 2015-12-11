// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

// Referenced classes of package com.groupon.activity:
//            Carousel

private class shouldShowCartMessages extends AnimatorListenerAdapter
{

    private final float initialVisibility;
    private final boolean shouldShowCartMessages;
    final Carousel this$0;
    private final View view;

    public void onAnimationEnd(Animator animator)
    {
        super.onAnimationEnd(animator);
        animator = view;
        byte byte0;
        if (initialVisibility == 0.0F)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        animator.setVisibility(byte0);
        if (shouldShowCartMessages && view.getVisibility() != 0)
        {
            Carousel.access$2100(Carousel.this);
        }
    }

    public (View view1, float f, boolean flag)
    {
        this$0 = Carousel.this;
        super();
        view = view1;
        initialVisibility = f;
        shouldShowCartMessages = flag;
    }
}
