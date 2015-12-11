// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.View;
import com.groupon.tracking.mobile.sdk.Logger;

// Referenced classes of package com.groupon.view:
//            PagerSlidingTabStrip, GrouponViewPager

class val.position
    implements android.view.p._cls2
{

    final PagerSlidingTabStrip this$0;
    final int val$position;

    public void onClick(View view)
    {
        PagerSlidingTabStrip.access$402(PagerSlidingTabStrip.this, true);
        view = PagerSlidingTabStrip.access$200(PagerSlidingTabStrip.this).findFragmentByPositionIfAvailable(PagerSlidingTabStrip.access$100(PagerSlidingTabStrip.this));
        android.app.Fragment fragment = PagerSlidingTabStrip.access$200(PagerSlidingTabStrip.this).findFragmentByPositionIfAvailable(val$position);
        if (view != null && fragment != null)
        {
            PagerSlidingTabStrip.access$600(PagerSlidingTabStrip.this).logClick("", "carousel_click", view.getClass().getSimpleName(), PagerSlidingTabStrip.access$500(PagerSlidingTabStrip.this, view.getClass().getSimpleName(), fragment.getClass().getSimpleName()));
        }
        PagerSlidingTabStrip.access$200(PagerSlidingTabStrip.this).setCurrentItem(val$position);
    }

    ()
    {
        this$0 = final_pagerslidingtabstrip;
        val$position = I.this;
        super();
    }
}
