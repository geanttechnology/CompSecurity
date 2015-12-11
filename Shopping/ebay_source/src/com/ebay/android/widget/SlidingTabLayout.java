// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

// Referenced classes of package com.ebay.android.widget:
//            SlidingTabStrip

public class SlidingTabLayout extends HorizontalScrollView
{
    private class InternalViewPagerListener
        implements android.support.v4.view.ViewPager.OnPageChangeListener
    {

        private int scrollState;
        final SlidingTabLayout this$0;

        public void onPageScrollStateChanged(int i)
        {
            scrollState = i;
            if (viewPagerPageChangeListener != null)
            {
                viewPagerPageChangeListener.onPageScrollStateChanged(i);
            }
        }

        public void onPageScrolled(int i, float f, int j)
        {
            int k = tabStrip.getChildCount();
            if (k != 0 && i >= 0 && i < k)
            {
                tabStrip.onViewPagerPageChanged(i, f);
                View view = tabStrip.getChildAt(i);
                int l;
                if (view != null)
                {
                    l = (int)((float)view.getWidth() * f);
                } else
                {
                    l = 0;
                }
                scrollToTab(i, l);
                if (viewPagerPageChangeListener != null)
                {
                    viewPagerPageChangeListener.onPageScrolled(i, f, j);
                    return;
                }
            }
        }

        public void onPageSelected(int i)
        {
            if (scrollState == 0)
            {
                tabStrip.onViewPagerPageChanged(i, 0.0F);
                scrollToTab(i, 0);
            }
            int j = 0;
            while (j < tabStrip.getChildCount()) 
            {
                View view = tabStrip.getChildAt(j);
                boolean flag;
                if (i == j)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                view.setSelected(flag);
                j++;
            }
            if (viewPagerPageChangeListener != null)
            {
                viewPagerPageChangeListener.onPageSelected(i);
            }
        }

        private InternalViewPagerListener()
        {
            this$0 = SlidingTabLayout.this;
            super();
        }

    }

    private class TabClickListener
        implements android.view.View.OnClickListener
    {

        final SlidingTabLayout this$0;

        public void onClick(View view)
        {
            int i = 0;
            do
            {
label0:
                {
                    if (i < tabStrip.getChildCount())
                    {
                        if (view != tabStrip.getChildAt(i))
                        {
                            break label0;
                        }
                        viewPager.setCurrentItem(i);
                    }
                    return;
                }
                i++;
            } while (true);
        }

        private TabClickListener()
        {
            this$0 = SlidingTabLayout.this;
            super();
        }

    }

    public static interface TabColorizer
    {

        public abstract int getDividerColor(int i);

        public abstract int getIndicatorColor(int i);
    }


    private static final int TAB_VIEW_PADDING_DIPS = 16;
    private static final int TAB_VIEW_TEXT_SIZE_SP = 14;
    private static final int TITLE_OFFSET_DIPS = 24;
    private SparseArray contentDescriptions;
    private boolean distributeEvenly;
    private final SlidingTabStrip tabStrip;
    private int tabViewLayoutId;
    private int tabViewTextViewId;
    private int titleOffset;
    private ViewPager viewPager;
    private android.support.v4.view.ViewPager.OnPageChangeListener viewPagerPageChangeListener;

    public SlidingTabLayout(Context context)
    {
        this(context, null);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeset, int i)
    {
        android.graphics.drawable.Drawable drawable;
        super(context, attributeset, i);
        contentDescriptions = new SparseArray();
        attributeset = context.obtainStyledAttributes(attributeset, com.ebay.mobile.R.styleable.SlidingTabLayout, i, 0);
        i = attributeset.getInt(1, 0);
        drawable = attributeset.getDrawable(0);
        attributeset.recycle();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        titleOffset = (int)(24F * getResources().getDisplayMetrics().density);
        tabStrip = new SlidingTabStrip(context);
        i;
        JVM INSTR tableswitch 1 4: default 120
    //                   1 149
    //                   2 160
    //                   3 120
    //                   4 171;
           goto _L1 _L2 _L3 _L1 _L4
_L1:
        tabStrip.setShowDividers(0);
_L6:
        tabStrip.setDividerDrawable(drawable);
        addView(tabStrip, -1, -2);
        return;
_L2:
        tabStrip.setShowDividers(1);
        continue; /* Loop/switch isn't completed */
_L3:
        tabStrip.setShowDividers(2);
        continue; /* Loop/switch isn't completed */
_L4:
        tabStrip.setShowDividers(4);
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void populateTabStrip()
    {
        PagerAdapter pageradapter = viewPager.getAdapter();
        TabClickListener tabclicklistener = new TabClickListener();
        if (pageradapter != null)
        {
            int i = 0;
            while (i < pageradapter.getCount()) 
            {
                Object obj1 = null;
                Object obj = null;
                if (tabViewLayoutId != 0)
                {
                    obj1 = LayoutInflater.from(getContext()).inflate(tabViewLayoutId, tabStrip, false);
                    obj = (TextView)((View) (obj1)).findViewById(tabViewTextViewId);
                }
                Object obj2 = obj1;
                if (obj1 == null)
                {
                    obj2 = createDefaultTabView(getContext());
                }
                obj1 = obj;
                if (obj == null)
                {
                    obj1 = obj;
                    if (android/widget/TextView.isInstance(obj2))
                    {
                        obj1 = (TextView)obj2;
                    }
                }
                if (distributeEvenly)
                {
                    obj = (android.widget.LinearLayout.LayoutParams)((View) (obj2)).getLayoutParams();
                    obj.width = 0;
                    obj.weight = 1.0F;
                }
                ((TextView) (obj1)).setText(pageradapter.getPageTitle(i));
                ((View) (obj2)).setOnClickListener(tabclicklistener);
                obj = (String)contentDescriptions.get(i, null);
                if (obj != null)
                {
                    ((View) (obj2)).setContentDescription(((CharSequence) (obj)));
                }
                tabStrip.addView(((View) (obj2)));
                if (i == viewPager.getCurrentItem())
                {
                    ((View) (obj2)).setSelected(true);
                }
                i++;
            }
        }
    }

    private void scrollToTab(int i, int j)
    {
        int k = tabStrip.getChildCount();
        View view;
        if (k != 0 && i >= 0 && i < k)
        {
            if ((view = tabStrip.getChildAt(i)) != null)
            {
label0:
                {
                    int l = view.getLeft() + j;
                    if (i <= 0)
                    {
                        i = l;
                        if (j <= 0)
                        {
                            break label0;
                        }
                    }
                    i = l - titleOffset;
                }
                scrollTo(i, 0);
                return;
            }
        }
    }

    protected TextView createDefaultTabView(Context context)
    {
        context = new TextView(context);
        context.setGravity(17);
        context.setTextSize(2, 14F);
        context.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -2));
        TypedValue typedvalue = new TypedValue();
        getContext().getTheme().resolveAttribute(0x101030e, typedvalue, true);
        context.setBackgroundResource(typedvalue.resourceId);
        int i = (int)(16F * getResources().getDisplayMetrics().density);
        context.setPadding(i, i, i, i);
        return context;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (viewPager != null)
        {
            scrollToTab(viewPager.getCurrentItem(), 0);
        }
    }

    public void setContentDescription(int i, String s)
    {
        contentDescriptions.put(i, s);
    }

    public void setCustomTabColorizer(TabColorizer tabcolorizer)
    {
        tabStrip.setCustomTabColorizer(tabcolorizer);
    }

    public void setCustomTabView(int i, int j)
    {
        tabViewLayoutId = i;
        tabViewTextViewId = j;
    }

    public void setDistributeEvenly(boolean flag)
    {
        distributeEvenly = flag;
    }

    public void setOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener)
    {
        viewPagerPageChangeListener = onpagechangelistener;
    }

    public transient void setSelectedIndicatorColors(int ai[])
    {
        tabStrip.setSelectedIndicatorColors(ai);
    }

    public void setTabTitle(int i, CharSequence charsequence)
    {
        TextView textview = (TextView)tabStrip.getChildAt(i);
        if (textview != null)
        {
            textview.setText(charsequence);
        }
    }

    public void setViewPager(ViewPager viewpager)
    {
        tabStrip.removeAllViews();
        viewPager = viewpager;
        if (viewPager != null)
        {
            viewPager.setOnPageChangeListener(new InternalViewPagerListener());
            populateTabStrip();
        }
    }




}
