// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class PageIndicators extends HorizontalScrollView
{
    private static class PageListener
        implements android.support.v4.view.ViewPager.OnPageChangeListener
    {

        private PageIndicators pageIndicators;

        public void onPageScrollStateChanged(int i)
        {
        }

        public void onPageScrolled(int i, float f, int j)
        {
            pageIndicators.scrollToChild(i, (int)((float)pageIndicators.indicatorContainer.getChildAt(i).getWidth() * f));
            pageIndicators.invalidate();
        }

        public void onPageSelected(int i)
        {
            pageIndicators.setActiveIndicator(i);
        }

        public PageListener(PageIndicators pageindicators)
        {
            pageIndicators = pageindicators;
        }
    }


    private final int activeColor;
    private final int inactiveColor;
    private final LinearLayout indicatorContainer;
    private int indicatorCount;
    private final android.widget.LinearLayout.LayoutParams indicatorLayoutParams;
    private int indicatorPaddingDp;
    private int lastScrollX;
    private final PageListener pageListener;
    private ViewPager pager;

    public PageIndicators(Context context)
    {
        this(context, null);
    }

    public PageIndicators(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public PageIndicators(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        pageListener = new PageListener(this);
        attributeset = context.obtainStyledAttributes(attributeset, com.groupon.R.styleable.PageIndicators, 0, 0);
        activeColor = attributeset.getColor(0, 0x7f0e00f4);
        inactiveColor = attributeset.getColor(1, 0x7f0e00f3);
        indicatorPaddingDp = attributeset.getDimensionPixelOffset(2, 0);
        attributeset.recycle();
        setFillViewport(true);
        setWillNotDraw(false);
        indicatorContainer = new LinearLayout(context);
        indicatorContainer.setOrientation(0);
        indicatorContainer.setHorizontalGravity(1);
        indicatorContainer.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        addView(indicatorContainer);
        indicatorLayoutParams = new android.widget.LinearLayout.LayoutParams(-2, -1);
    }

    private void addIndicator(int i, int j)
    {
        ImageButton imagebutton = new ImageButton(getContext());
        imagebutton.setBackground(null);
        imagebutton.setImageDrawable(getResources().getDrawable(j));
        imagebutton.setPadding(indicatorPaddingDp, 0, indicatorPaddingDp, 0);
        indicatorContainer.addView(imagebutton, i, indicatorLayoutParams);
    }

    private void notifyDataSetChanged()
    {
        indicatorContainer.removeAllViews();
        indicatorCount = pager.getAdapter().getCount();
        pager.setOnPageChangeListener(pageListener);
        for (int i = 0; i < indicatorCount; i++)
        {
            addIndicator(i, 0x7f0200f4);
        }

        setActiveIndicator(0);
    }

    private void scrollToChild(int i, int j)
    {
        if (indicatorCount != 0)
        {
            if ((i = indicatorContainer.getChildAt(i).getLeft() + j) != lastScrollX)
            {
                lastScrollX = i;
                scrollTo(i, 0);
                return;
            }
        }
    }

    public void setActiveIndicator(int i)
    {
        int j = 0;
        while (j < indicatorContainer.getChildCount()) 
        {
            GradientDrawable gradientdrawable = (GradientDrawable)((ImageButton)indicatorContainer.getChildAt(j)).getDrawable();
            if (j == i)
            {
                gradientdrawable.setColor(activeColor);
            } else
            {
                gradientdrawable.setColor(inactiveColor);
            }
            j++;
        }
    }

    public void setViewPager(ViewPager viewpager)
    {
        pager = viewpager;
        if (viewpager.getAdapter() == null)
        {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        } else
        {
            notifyDataSetChanged();
            return;
        }
    }


}
