// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.graphics.Rect;
import android.view.View;
import com.nineoldandroids.animation.ValueAnimator;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            HighlightView

class val.parent
    implements com.nineoldandroids.animation.imatorUpdateListener
{

    final HighlightView this$0;
    final ValueAnimator val$anim1;
    final ValueAnimator val$anim2;
    final ValueAnimator val$anim3;
    final ValueAnimator val$anim4;
    final View val$parent;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        int i = ((Integer)val$anim1.getAnimatedValue()).intValue();
        int j = ((Integer)val$anim2.getAnimatedValue()).intValue();
        int k = ((Integer)val$anim3.getAnimatedValue()).intValue();
        int l = ((Integer)val$anim4.getAnimatedValue()).intValue();
        HighlightView.access$000(HighlightView.this).left = i;
        HighlightView.access$000(HighlightView.this).right = j;
        HighlightView.access$000(HighlightView.this).top = k;
        HighlightView.access$000(HighlightView.this).bottom = l;
        val$parent.invalidate();
    }

    dateListener()
    {
        this$0 = final_highlightview;
        val$anim1 = valueanimator;
        val$anim2 = valueanimator1;
        val$anim3 = valueanimator2;
        val$anim4 = valueanimator3;
        val$parent = View.this;
        super();
    }
}
