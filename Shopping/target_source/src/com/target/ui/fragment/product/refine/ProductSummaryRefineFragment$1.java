// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.refine;

import android.animation.Animator;
import android.view.animation.Animation;
import com.target.ui.util.aj;

// Referenced classes of package com.target.ui.fragment.product.refine:
//            ProductSummaryRefineFragment

class this._cls0
    implements android.view.animation.fineFragment._cls1
{

    final ProductSummaryRefineFragment this$0;

    public void onAnimationEnd(Animation animation)
    {
        aj.d(ProductSummaryRefineFragment.a(ProductSummaryRefineFragment.this).resetDoneBtn).start();
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    ews()
    {
        this$0 = ProductSummaryRefineFragment.this;
        super();
    }
}
