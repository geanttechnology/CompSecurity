// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.view.View;

// Referenced classes of package com.target.ui.view:
//            ExpandableImageViewPager

class this._cls1
    implements Runnable
{

    final l.targetPosition this$1;

    public void run()
    {
        ExpandableImageViewPager.a(_fld0, targetPosition);
    }

    l.desiredScrollAmount()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/target/ui/view/ExpandableImageViewPager$6

/* anonymous class */
    class ExpandableImageViewPager._cls6 extends android.support.v7.widget.RecyclerView.p
    {

        final ExpandableImageViewPager this$0;
        final int val$desiredScrollAmount;
        final int val$targetPosition;

        protected void a(int i, int j, android.support.v7.widget.RecyclerView.q q, android.support.v7.widget.RecyclerView.p.a a1)
        {
        }

        protected void a(View view, android.support.v7.widget.RecyclerView.q q, android.support.v7.widget.RecyclerView.p.a a1)
        {
            a1.a(desiredScrollAmount);
            a1.b(500);
        }

        protected void e()
        {
        }

        protected void f()
        {
            postDelayed(new ExpandableImageViewPager._cls6._cls1(), 100L);
        }

            
            {
                this$0 = final_expandableimageviewpager;
                targetPosition = i;
                desiredScrollAmount = I.this;
                super();
            }
    }

}
