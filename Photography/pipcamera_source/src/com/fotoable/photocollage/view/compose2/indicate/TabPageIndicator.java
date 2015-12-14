// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.view.compose2.indicate;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import mo;
import mp;
import mq;

// Referenced classes of package com.fotoable.photocollage.view.compose2.indicate:
//            PageIndicator

public class TabPageIndicator extends HorizontalScrollView
    implements PageIndicator
{

    public static final int ALIGN_CENTER = 2;
    public static final int ALIGN_LEFT = 1;
    private static final CharSequence EMPTY_TITLE = "";
    private int TAB_ALIGNTYPE;
    private android.support.v4.view.ViewPager.OnPageChangeListener mListener;
    private int mMaxTabWidth;
    private int mSelectedTabIndex;
    private final android.view.View.OnClickListener mTabClickListener;
    private final LinearLayout mTabLayout;
    private mp mTabReselectedListener;
    private Runnable mTabSelector;
    private ViewPager mViewPager;

    public TabPageIndicator(Context context)
    {
        this(context, null);
    }

    public TabPageIndicator(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        TAB_ALIGNTYPE = 2;
        mTabClickListener = new android.view.View.OnClickListener() {

            final TabPageIndicator a;

            public void onClick(View view)
            {
                view = (mq)view;
                int i = a.mViewPager.getCurrentItem();
                int j = view.a();
                a.mViewPager.setCurrentItem(j);
                if (i == j && a.mTabReselectedListener != null)
                {
                    a.mTabReselectedListener.a(j);
                }
            }

            
            {
                a = TabPageIndicator.this;
                super();
            }
        };
        setHorizontalScrollBarEnabled(false);
        mTabLayout = new LinearLayout(getContext());
        mTabLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -1));
        mTabLayout.setOrientation(0);
        addView(mTabLayout);
    }

    private void addTab(int i, CharSequence charsequence, int j)
    {
        mq mq1 = new mq(this, getContext());
        mq.a(mq1, i);
        mq1.setFocusable(true);
        mq1.setOnClickListener(mTabClickListener);
        mq1.a(charsequence);
        if (j != 0)
        {
            mq1.a(j, 0, 0, 0);
        }
        if (TAB_ALIGNTYPE == 1)
        {
            mTabLayout.addView(mq1, new android.widget.LinearLayout.LayoutParams(-2, -1, 0.0F));
            return;
        } else
        {
            mTabLayout.addView(mq1, new android.widget.LinearLayout.LayoutParams(0, -1, charsequence.length() + 5));
            return;
        }
    }

    private void animateToTab(int i)
    {
        View view = mTabLayout.getChildAt(i);
        if (mTabSelector != null)
        {
            removeCallbacks(mTabSelector);
        }
        mTabSelector = new Runnable(view) {

            final View a;
            final TabPageIndicator b;

            public void run()
            {
                int j = a.getLeft();
                int k = (b.getWidth() - a.getWidth()) / 2;
                b.smoothScrollTo(j - k, 0);
                b.mTabSelector = null;
            }

            
            {
                b = TabPageIndicator.this;
                a = view;
                super();
            }
        };
        post(mTabSelector);
    }

    public void notifyDataSetChanged()
    {
        mTabLayout.removeAllViews();
        PagerAdapter pageradapter = mViewPager.getAdapter();
        mo mo1 = null;
        if (pageradapter instanceof mo)
        {
            mo1 = (mo)pageradapter;
        }
        int k = pageradapter.getCount();
        int i = 0;
        while (i < k) 
        {
            CharSequence charsequence = pageradapter.getPageTitle(i);
            if (charsequence == null)
            {
                charsequence = EMPTY_TITLE;
            }
            int j;
            if (mo1 != null)
            {
                j = mo1.a(i);
            } else
            {
                j = 0;
            }
            addTab(i, charsequence, j);
            i++;
        }
        if (mSelectedTabIndex > k)
        {
            mSelectedTabIndex = k - 1;
        }
        setCurrentItem(mSelectedTabIndex);
        requestLayout();
    }

    public void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (mTabSelector != null)
        {
            post(mTabSelector);
        }
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (mTabSelector != null)
        {
            removeCallbacks(mTabSelector);
        }
    }

    public void onMeasure(int i, int j)
    {
        int k = android.view.View.MeasureSpec.getMode(i);
        int l;
        boolean flag;
        if (k == 0x40000000)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setFillViewport(flag);
        l = mTabLayout.getChildCount();
        if (l > 1 && (k == 0x40000000 || k == 0x80000000))
        {
            if (l > 2)
            {
                mMaxTabWidth = (int)((float)android.view.View.MeasureSpec.getSize(i) * 0.4F);
            } else
            {
                mMaxTabWidth = android.view.View.MeasureSpec.getSize(i) / 2;
            }
        } else
        {
            mMaxTabWidth = -1;
        }
        k = getMeasuredWidth();
        super.onMeasure(i, j);
        i = getMeasuredWidth();
        if (flag && k != i)
        {
            setCurrentItem(mSelectedTabIndex);
        }
    }

    public void onPageScrollStateChanged(int i)
    {
        if (mListener != null)
        {
            mListener.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int j)
    {
        if (mListener != null)
        {
            mListener.onPageScrolled(i, f, j);
        }
    }

    public void onPageSelected(int i)
    {
        setCurrentItem(i);
        if (mListener != null)
        {
            mListener.onPageSelected(i);
        }
    }

    public void setCurrentItem(int i)
    {
        if (mViewPager != null)
        {
            mSelectedTabIndex = i;
            mViewPager.setCurrentItem(i);
            int k = mTabLayout.getChildCount();
            int j = 0;
            while (j < k) 
            {
                View view = mTabLayout.getChildAt(j);
                boolean flag;
                if (j == i)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                view.setSelected(flag);
                if (flag)
                {
                    animateToTab(i);
                }
                j++;
            }
        }
    }

    public void setOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener)
    {
        mListener = onpagechangelistener;
    }

    public void setOnTabReselectedListener(mp mp)
    {
        mTabReselectedListener = mp;
    }

    public void setTabAlignType(int i)
    {
        TAB_ALIGNTYPE = i;
    }

    public void setViewPager(ViewPager viewpager)
    {
        if (mViewPager == viewpager)
        {
            return;
        }
        if (mViewPager != null)
        {
            mViewPager.setOnPageChangeListener(null);
        }
        if (viewpager.getAdapter() == null)
        {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        } else
        {
            mViewPager = viewpager;
            viewpager.setOnPageChangeListener(this);
            notifyDataSetChanged();
            return;
        }
    }

    public void setViewPager(ViewPager viewpager, int i)
    {
        setViewPager(viewpager);
        setCurrentItem(i);
    }





/*
    static Runnable access$202(TabPageIndicator tabpageindicator, Runnable runnable)
    {
        tabpageindicator.mTabSelector = runnable;
        return runnable;
    }

*/

}
