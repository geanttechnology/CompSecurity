// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.animation.ValueAnimator;
import android.view.View;

// Referenced classes of package com.groupon.view:
//            ExpandableStickyListAnimator

class val.target
    implements android.animation.tener
{

    final ExpandableStickyListAnimator this$0;
    final android.view.r val$lp;
    final View val$target;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        val$lp.lp = ((Float)valueanimator.getAnimatedValue()).intValue();
        val$target.setLayoutParams(val$lp);
        val$target.requestLayout();
    }

    stener()
    {
        this$0 = final_expandablestickylistanimator;
        val$lp = r;
        val$target = View.this;
        super();
    }
}
