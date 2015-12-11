// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.groupon.util.WobbleSpaceshipCatAnimationListener;

// Referenced classes of package com.groupon.view:
//            WobbleSpaceshipCatView

class <init> extends AnimatorListenerAdapter
{

    final WobbleSpaceshipCatView this$0;

    public void onAnimationEnd(Animator animator)
    {
        wobbleSpaceshipCatAnimationListener.onExitRightAnimationEnd();
    }

    onListener()
    {
        this$0 = WobbleSpaceshipCatView.this;
        super();
    }
}
