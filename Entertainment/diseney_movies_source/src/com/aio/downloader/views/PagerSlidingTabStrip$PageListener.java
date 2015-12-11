// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

// Referenced classes of package com.aio.downloader.views:
//            PagerSlidingTabStrip

private class <init>
    implements android.support.v4.view.
{

    final PagerSlidingTabStrip this$0;

    public void onPageScrollStateChanged(int i)
    {
        if (i == 0)
        {
            PagerSlidingTabStrip.access$12(PagerSlidingTabStrip.this, PagerSlidingTabStrip.access$8(PagerSlidingTabStrip.this).getCurrentItem(), 0);
        }
        View view = PagerSlidingTabStrip.access$0(PagerSlidingTabStrip.this).getChildAt(PagerSlidingTabStrip.access$8(PagerSlidingTabStrip.this).getCurrentItem());
        PagerSlidingTabStrip.access$15(PagerSlidingTabStrip.this, view);
        if (PagerSlidingTabStrip.access$8(PagerSlidingTabStrip.this).getCurrentItem() - 1 >= 0)
        {
            View view1 = PagerSlidingTabStrip.access$0(PagerSlidingTabStrip.this).getChildAt(PagerSlidingTabStrip.access$8(PagerSlidingTabStrip.this).getCurrentItem() - 1);
            PagerSlidingTabStrip.access$16(PagerSlidingTabStrip.this, view1);
        }
        if (PagerSlidingTabStrip.access$8(PagerSlidingTabStrip.this).getCurrentItem() + 1 <= PagerSlidingTabStrip.access$8(PagerSlidingTabStrip.this).getAdapter().getCount() - 1)
        {
            View view2 = PagerSlidingTabStrip.access$0(PagerSlidingTabStrip.this).getChildAt(PagerSlidingTabStrip.access$8(PagerSlidingTabStrip.this).getCurrentItem() + 1);
            PagerSlidingTabStrip.access$16(PagerSlidingTabStrip.this, view2);
        }
        if (mDelegatePageListener != null)
        {
            mDelegatePageListener.ageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int j)
    {
        PagerSlidingTabStrip.access$9(PagerSlidingTabStrip.this, i);
        PagerSlidingTabStrip.access$10(PagerSlidingTabStrip.this, f);
        int k;
        if (PagerSlidingTabStrip.access$14(PagerSlidingTabStrip.this) > 0)
        {
            k = (int)((float)PagerSlidingTabStrip.access$0(PagerSlidingTabStrip.this).getChildAt(i).getWidth() * f);
        } else
        {
            k = 0;
        }
        PagerSlidingTabStrip.access$12(PagerSlidingTabStrip.this, i, k);
        invalidate();
        if (mDelegatePageListener != null)
        {
            mDelegatePageListener.ageScrolled(i, f, j);
        }
    }

    public void onPageSelected(int i)
    {
        PagerSlidingTabStrip.access$13(PagerSlidingTabStrip.this, i);
        if (mDelegatePageListener != null)
        {
            mDelegatePageListener.ageSelected(i);
        }
    }

    private ()
    {
        this$0 = PagerSlidingTabStrip.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
