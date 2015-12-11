// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.animation.ValueAnimator;

// Referenced classes of package com.target.ui.view:
//            ExpandableImageViewPager

class this._cls0
    implements android.animation.eListener
{

    final ExpandableImageViewPager this$0;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        ExpandableImageViewPager.a(ExpandableImageViewPager.this, Integer.valueOf(((Integer)valueanimator.getAnimatedValue()).intValue()));
    }

    Listener()
    {
        this$0 = ExpandableImageViewPager.this;
        super();
    }
}
