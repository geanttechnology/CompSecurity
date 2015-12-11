// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

// Referenced classes of package com.aio.downloader.views:
//            LFrameLayout

public class LTabIndicator extends HorizontalScrollView
{
    public static interface OnTabSelectedListener
    {

        public abstract void onTabSelected(int i);
    }

    private class PageListener
        implements android.support.v4.view.ViewPager.OnPageChangeListener
    {

        final LTabIndicator this$0;

        public void onPageScrollStateChanged(int i)
        {
            if (i == 0)
            {
                scrollToChild(mPager.getCurrentItem(), 0);
            }
            if (mOnPageChangeListener != null)
            {
                mOnPageChangeListener.onPageScrollStateChanged(i);
            }
        }

        public void onPageScrolled(int i, float f, int j)
        {
            currentPosition = i;
            currentPositionOffset = f;
            scrollToChild(i, (int)((float)mTabsContainer.getChildAt(i).getWidth() * f));
            invalidate();
            if (mOnPageChangeListener != null)
            {
                mOnPageChangeListener.onPageScrolled(i, f, j);
            }
        }

        public void onPageSelected(int i)
        {
            tabSelect(i);
            if (mOnPageChangeListener != null)
            {
                mOnPageChangeListener.onPageSelected(i);
            }
        }

        private PageListener()
        {
            this$0 = LTabIndicator.this;
            super();
        }

        PageListener(PageListener pagelistener)
        {
            this();
        }
    }

    private class TabView extends LFrameLayout
    {

        private TextView mTabText;
        final LTabIndicator this$0;

        private void init()
        {
            mTabText = new TextView(getContext());
            mTabText.setTextAppearance(getContext(), 0x1010041);
            mTabText.setTextSize((float)tabTextSize / getResources().getConfiguration().fontScale);
            mTabText.setSingleLine(true);
            mTabText.setGravity(17);
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
            addView(mTabText, layoutparams);
        }

        public TextView getTextView()
        {
            return mTabText;
        }

        public TabView(Context context)
        {
            this(context, null);
        }

        public TabView(Context context, AttributeSet attributeset)
        {
            this$0 = LTabIndicator.this;
            super(context, attributeset);
            init();
            setDelayClick(false);
            setColor(mAnimColor);
        }
    }


    private int currentPosition;
    private float currentPositionOffset;
    private Paint diviPaint;
    private int dividerColor;
    private int dividerPadding;
    private int dividerWidth;
    private boolean enableDivider;
    private boolean enableExpand;
    private int indicatorColor;
    private float indicatorHeight;
    private boolean indicatorOnTop;
    private int lastScrollX;
    private int mAnimColor;
    private Paint mBaseLinePaint;
    private Paint mCurrentPaint;
    public android.support.v4.view.ViewPager.OnPageChangeListener mOnPageChangeListener;
    private ViewPager mPager;
    private OnTabSelectedListener mTabSelectedListener;
    private LinearLayout mTabsContainer;
    private int scrollOffset;
    private int tabCount;
    private int tabPadding;
    private int tabTextSize;
    private int textSelectedColor;
    private int textUnselectColor;
    private int underlineColor;
    private float underlineHeight;
    private boolean viewPagerScrollWithAnimation;

    public LTabIndicator(Context context)
    {
        this(context, null);
    }

    public LTabIndicator(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public LTabIndicator(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        currentPosition = 0;
        currentPositionOffset = 0.0F;
        mCurrentPaint = new Paint();
        mBaseLinePaint = new Paint();
        indicatorColor = 0xdeffffff;
        underlineColor = 0x8affffff;
        dividerColor = 0x1a000000;
        textSelectedColor = 0xdeffffff;
        textUnselectColor = 0x8affffff;
        mAnimColor = 0x8affffff;
        enableExpand = true;
        enableDivider = false;
        indicatorOnTop = false;
        viewPagerScrollWithAnimation = true;
        tabTextSize = 16;
        scrollOffset = 52;
        indicatorHeight = 3F;
        underlineHeight = 1.0F;
        dividerPadding = 12;
        tabPadding = 24;
        dividerWidth = 1;
        lastScrollX = 0;
        setFillViewport(true);
        setWillNotDraw(false);
        attributeset = getResources().getDisplayMetrics();
        mTabsContainer = new LinearLayout(context);
        mTabsContainer.setOrientation(0);
        context = new android.widget.FrameLayout.LayoutParams(-1, -1);
        context.height = (int)TypedValue.applyDimension(1, 50F, attributeset);
        mTabsContainer.setLayoutParams(context);
        addView(mTabsContainer);
        scrollOffset = (int)TypedValue.applyDimension(1, scrollOffset, attributeset);
        dividerPadding = (int)TypedValue.applyDimension(1, dividerPadding, attributeset);
        tabPadding = (int)TypedValue.applyDimension(1, tabPadding, attributeset);
        dividerWidth = (int)TypedValue.applyDimension(1, dividerWidth, attributeset);
        indicatorHeight = TypedValue.applyDimension(1, indicatorHeight, attributeset);
        underlineHeight = TypedValue.applyDimension(1, underlineHeight, attributeset);
        mCurrentPaint.setAntiAlias(true);
        mCurrentPaint.setStyle(android.graphics.Paint.Style.FILL);
        mCurrentPaint.setColor(indicatorColor);
        mBaseLinePaint.setAntiAlias(true);
        mBaseLinePaint.setStyle(android.graphics.Paint.Style.FILL);
        mBaseLinePaint.setColor(underlineColor);
        diviPaint = new Paint();
        diviPaint.setAntiAlias(true);
        diviPaint.setStrokeWidth(dividerWidth);
    }

    private void addTab(final int position, String s)
    {
        TabView tabview = new TabView(getContext());
        tabview.getTextView().setText(s);
        tabview.setFocusable(true);
        tabview.setOnClickListener(new android.view.View.OnClickListener() {

            final LTabIndicator this$0;
            private final int val$position;

            public void onClick(View view)
            {
                if (mPager.getCurrentItem() != position && mTabSelectedListener != null)
                {
                    mTabSelectedListener.onTabSelected(position);
                }
                mPager.setCurrentItem(position, viewPagerScrollWithAnimation);
            }

            
            {
                this$0 = LTabIndicator.this;
                position = i;
                super();
            }
        });
        if (!enableExpand)
        {
            tabview.setPadding(tabPadding, 0, tabPadding, 0);
        }
        LinearLayout linearlayout = mTabsContainer;
        if (enableExpand)
        {
            s = new android.widget.LinearLayout.LayoutParams(0, -1, 1.0F);
        } else
        {
            s = new android.widget.LinearLayout.LayoutParams(-2, -1);
        }
        linearlayout.addView(tabview, position, s);
    }

    private void scrollToChild(int i, int j)
    {
        if (tabCount != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int k = mTabsContainer.getChildAt(i).getLeft() + j;
        if (i <= 0)
        {
            i = k;
            if (j <= 0)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        i = k - scrollOffset;
        if (i == lastScrollX) goto _L1; else goto _L3
_L3:
        lastScrollX = i;
        scrollTo(i, 0);
        return;
    }

    private void tabSelect(int i)
    {
        int k = mTabsContainer.getChildCount();
        int j = 0;
        do
        {
            if (j >= k)
            {
                return;
            }
            View view = mTabsContainer.getChildAt(j);
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
                ((TabView)view).getTextView().setTextColor(textSelectedColor);
            } else
            {
                ((TabView)view).getTextView().setTextColor(textUnselectColor);
            }
            j++;
        } while (true);
    }

    private void updateTabStyles()
    {
        int i = 0;
        do
        {
            if (i >= tabCount)
            {
                tabSelect(mPager.getCurrentItem());
                return;
            }
            mTabsContainer.getChildAt(i).setBackgroundColor(0);
            i++;
        } while (true);
    }

    public boolean getViewPagerScrollWithAnimation()
    {
        return viewPagerScrollWithAnimation;
    }

    public boolean isEnableDivider()
    {
        return enableDivider;
    }

    public boolean isEnableExpand()
    {
        return enableExpand;
    }

    public boolean isIndicatorOnTop()
    {
        return indicatorOnTop;
    }

    public void notifyDataSetChanged()
    {
        mTabsContainer.removeAllViews();
        tabCount = mPager.getAdapter().getCount();
        int i = 0;
        do
        {
            if (i >= tabCount)
            {
                updateTabStyles();
                return;
            }
            addTab(i, mPager.getAdapter().getPageTitle(i).toString());
            i++;
        } while (true);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (!isInEditMode() && tabCount != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int j = getHeight();
        float f;
        float f1;
        float f2;
        float f3;
        View view;
        if (indicatorOnTop)
        {
            canvas.drawRect(0.0F, 0.0F, mTabsContainer.getWidth(), underlineHeight, mBaseLinePaint);
        } else
        {
            canvas.drawRect(0.0F, (float)j - underlineHeight, mTabsContainer.getWidth(), j, mBaseLinePaint);
        }
        view = mTabsContainer.getChildAt(currentPosition);
        f3 = view.getLeft();
        f2 = view.getRight();
        f1 = f3;
        f = f2;
        if (currentPositionOffset > 0.0F)
        {
            f1 = f3;
            f = f2;
            if (currentPosition < tabCount - 1)
            {
                View view1 = mTabsContainer.getChildAt(currentPosition + 1);
                f1 = view1.getLeft();
                f = view1.getRight();
                f1 = currentPositionOffset * f1 + (1.0F - currentPositionOffset) * f3;
                f = currentPositionOffset * f + (1.0F - currentPositionOffset) * f2;
            }
        }
        if (indicatorOnTop)
        {
            canvas.drawRect(f1, 0.0F, f, indicatorHeight, mCurrentPaint);
        } else
        {
            canvas.drawRect(f1, (float)j - indicatorHeight, f, j, mCurrentPaint);
        }
        if (enableDivider)
        {
            diviPaint.setColor(dividerColor);
            int i = 0;
            while (i < tabCount - 1) 
            {
                View view2 = mTabsContainer.getChildAt(i);
                canvas.drawLine(view2.getRight(), dividerPadding, view2.getRight(), j - dividerPadding, diviPaint);
                i++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void setCurrentItem(int i)
    {
        mPager.setCurrentItem(i, viewPagerScrollWithAnimation);
    }

    public void setEnableDivider(boolean flag)
    {
        enableDivider = flag;
    }

    public void setEnableExpand(boolean flag)
    {
        enableExpand = flag;
    }

    public void setIndicatorOnTop(boolean flag)
    {
        indicatorOnTop = flag;
    }

    public void setOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener)
    {
        mOnPageChangeListener = onpagechangelistener;
    }

    public void setOnTabReselectedListener(OnTabSelectedListener ontabselectedlistener)
    {
        mTabSelectedListener = ontabselectedlistener;
    }

    public void setTabText(int i, String s)
    {
        if (i < 0 || i > mTabsContainer.getChildCount() - 1)
        {
            throw new RuntimeException("tabs does not have this position.");
        }
        View view = mTabsContainer.getChildAt(i);
        if (view instanceof TextView)
        {
            ((TextView)view).setText(s);
        }
    }

    public void setViewPager(ViewPager viewpager)
    {
        mPager = viewpager;
        if (viewpager.getAdapter() == null)
        {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        } else
        {
            viewpager.setOnPageChangeListener(new PageListener(null));
            notifyDataSetChanged();
            return;
        }
    }

    public void setViewPagerScrollWithAnimation(boolean flag)
    {
        viewPagerScrollWithAnimation = flag;
    }










}
