// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

// Referenced classes of package com.target.ui.view:
//            ExpandableImageViewPager

class t> extends AnimatorListenerAdapter
{

    final ExpandableImageViewPager this$0;

    public void onAnimationEnd(Animator animator)
    {
        super.onAnimationEnd(animator);
        ExpandableImageViewPager.a(ExpandableImageViewPager.this, false);
    }

    public void onAnimationStart(Animator animator)
    {
        super.onAnimationStart(animator);
        ExpandableImageViewPager.a(ExpandableImageViewPager.this, true);
    }

    ()
    {
        this$0 = ExpandableImageViewPager.this;
        super();
    }
}
