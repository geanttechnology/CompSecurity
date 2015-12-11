// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

// Referenced classes of package com.groupon.view:
//            ExpandableStickyListAnimator

class  extends AnimatorListenerAdapter
{

    final ExpandableStickyListAnimator this$0;
    final int val$animType;
    final View val$target;
    final int val$viewHeight;

    public void onAnimationEnd(Animator animator)
    {
        animator = val$target;
        int i;
        if (ExpandableStickyListAnimator.access$000(ExpandableStickyListAnimator.this, val$animType))
        {
            i = 0;
        } else
        {
            i = 8;
        }
        animator.setVisibility(i);
        val$target.getLayoutParams().target = val$viewHeight;
    }

    ()
    {
        this$0 = final_expandablestickylistanimator;
        val$target = view;
        val$animType = i;
        val$viewHeight = I.this;
        super();
    }
}
