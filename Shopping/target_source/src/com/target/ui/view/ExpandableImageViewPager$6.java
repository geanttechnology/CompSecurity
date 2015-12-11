// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.view.View;

// Referenced classes of package com.target.ui.view:
//            ExpandableImageViewPager

class > extends android.support.v7.widget.iredScrollAmount
{

    final ExpandableImageViewPager this$0;
    final int val$desiredScrollAmount;
    final int val$targetPosition;

    protected void a(int i, int j, android.support.v7.widget.iredScrollAmount iredscrollamount, android.support.v7.widget.iredScrollAmount iredscrollamount1)
    {
    }

    protected void a(View view, android.support.v7.widget.iredScrollAmount iredscrollamount, android.support.v7.widget.iredScrollAmount iredscrollamount1)
    {
        iredscrollamount1.iredScrollAmount(val$desiredScrollAmount);
        iredscrollamount1.iredScrollAmount(500);
    }

    protected void e()
    {
    }

    protected void f()
    {
        postDelayed(new Runnable() {

            final ExpandableImageViewPager._cls6 this$1;

            public void run()
            {
                ExpandableImageViewPager.a(this$0, targetPosition);
            }

            
            {
                this$1 = ExpandableImageViewPager._cls6.this;
                super();
            }
        }, 100L);
    }

    _cls1.this._cls1()
    {
        this$0 = final_expandableimageviewpager;
        val$targetPosition = i;
        val$desiredScrollAmount = I.this;
        super();
    }
}
