// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.animation.ValueAnimator;
import android.view.View;
import com.target.ui.layout_manager.EagerLinearLayoutManager;

// Referenced classes of package com.target.ui.view:
//            ExpandableImageViewPager

class val.finalPadding
    implements android.animation.eListener
{

    final ExpandableImageViewPager this$0;
    final int val$finalPadding;
    final int val$initialPadding;
    final boolean val$isCollapsed;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        int i = ((Integer)valueanimator.getAnimatedValue()).intValue();
        getLayoutParams().ht = i;
        float f1 = valueanimator.getAnimatedFraction();
        float f;
        float f2;
        if (!val$isCollapsed)
        {
            f = 1.0F - f1;
        } else
        {
            f = f1;
        }
        valueanimator = ExpandableImageViewPager.this;
        f2 = ExpandableImageViewPager.a(ExpandableImageViewPager.this);
        ExpandableImageViewPager.a(valueanimator, f * (ExpandableImageViewPager.b(ExpandableImageViewPager.this) - ExpandableImageViewPager.a(ExpandableImageViewPager.this)) + f2, val$isCollapsed);
        for (int j = 0; j < ExpandableImageViewPager.c(ExpandableImageViewPager.this).o(); j++)
        {
            ExpandableImageViewPager.c(ExpandableImageViewPager.this).g(j).getLayoutParams().h = getViewWidth();
        }

        if (ExpandableImageViewPager.d(ExpandableImageViewPager.this) && val$initialPadding != val$finalPadding)
        {
            int k = Math.round((float)val$initialPadding + f1 * (float)(val$finalPadding - val$initialPadding));
            setPadding(k, 0, k, 0);
            return;
        } else
        {
            requestLayout();
            return;
        }
    }

    Manager()
    {
        this$0 = final_expandableimageviewpager;
        val$isCollapsed = flag;
        val$initialPadding = i;
        val$finalPadding = I.this;
        super();
    }
}
