// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.refine;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v4.app.h;

// Referenced classes of package com.target.ui.fragment.product.refine:
//            ProductSummaryRefineFragment

class this._cls0 extends AnimatorListenerAdapter
{

    final ProductSummaryRefineFragment this$0;

    public void onAnimationEnd(Animator animator)
    {
        if (ProductSummaryRefineFragment.a(ProductSummaryRefineFragment.this) == null || Z())
        {
            return;
        } else
        {
            getFragmentManager().d();
            return;
        }
    }

    public void onAnimationStart(Animator animator)
    {
        ProductSummaryRefineFragment.b(ProductSummaryRefineFragment.this);
    }

    ()
    {
        this$0 = ProductSummaryRefineFragment.this;
        super();
    }
}
