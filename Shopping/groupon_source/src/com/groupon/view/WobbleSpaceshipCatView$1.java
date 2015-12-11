// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;

// Referenced classes of package com.groupon.view:
//            WobbleSpaceshipCatView

class <init> extends AnimatorListenerAdapter
{

    final WobbleSpaceshipCatView this$0;

    public void onAnimationCancel(Animator animator)
    {
        WobbleSpaceshipCatView.access$002(WobbleSpaceshipCatView.this, true);
    }

    public void onAnimationEnd(Animator animator)
    {
        if (!WobbleSpaceshipCatView.access$000(WobbleSpaceshipCatView.this))
        {
            WobbleSpaceshipCatView.access$100(WobbleSpaceshipCatView.this).start();
        }
    }

    public void onAnimationStart(Animator animator)
    {
        WobbleSpaceshipCatView.access$002(WobbleSpaceshipCatView.this, false);
    }

    ()
    {
        this$0 = WobbleSpaceshipCatView.this;
        super();
    }
}
