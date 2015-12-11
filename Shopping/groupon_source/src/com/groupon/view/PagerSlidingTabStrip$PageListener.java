// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.View;
import android.widget.LinearLayout;
import com.groupon.tracking.mobile.sdk.Logger;

// Referenced classes of package com.groupon.view:
//            PagerSlidingTabStrip, GrouponViewPager

private class <init>
    implements android.support.v4.view.
{

    final PagerSlidingTabStrip this$0;

    public void onPageScrollStateChanged(int i)
    {
        if (i == 0)
        {
            PagerSlidingTabStrip.access$300(PagerSlidingTabStrip.this, PagerSlidingTabStrip.access$200(PagerSlidingTabStrip.this).getCurrentItem(), 0);
        }
        if (delegatePageListener != null)
        {
            delegatePageListener.ageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int j)
    {
        PagerSlidingTabStrip.access$102(PagerSlidingTabStrip.this, i);
        PagerSlidingTabStrip.access$802(PagerSlidingTabStrip.this, f);
        PagerSlidingTabStrip.access$300(PagerSlidingTabStrip.this, i, (int)((float)PagerSlidingTabStrip.access$900(PagerSlidingTabStrip.this).getChildAt(i).getWidth() * f));
        invalidate();
        if (delegatePageListener != null)
        {
            delegatePageListener.ageScrolled(i, f, j);
        }
    }

    public void onPageSelected(int i)
    {
        android.app.Fragment fragment = PagerSlidingTabStrip.access$200(PagerSlidingTabStrip.this).findFragmentByPositionIfAvailable(i);
        if (!PagerSlidingTabStrip.access$400(PagerSlidingTabStrip.this) && fragment != null && PagerSlidingTabStrip.access$1000(PagerSlidingTabStrip.this) != null)
        {
            PagerSlidingTabStrip.access$600(PagerSlidingTabStrip.this).logUserInteraction("", PagerSlidingTabStrip.access$1100(PagerSlidingTabStrip.this, i), PagerSlidingTabStrip.access$1000(PagerSlidingTabStrip.this), PagerSlidingTabStrip.access$500(PagerSlidingTabStrip.this, PagerSlidingTabStrip.access$1000(PagerSlidingTabStrip.this), fragment.getClass().getSimpleName()), Logger.NULL_NST_FIELD);
        } else
        {
            PagerSlidingTabStrip.access$402(PagerSlidingTabStrip.this, false);
        }
        if (delegatePageListener != null)
        {
            delegatePageListener.ageSelected(i);
        }
        highlightTabText(i);
    }

    private ner()
    {
        this$0 = PagerSlidingTabStrip.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
