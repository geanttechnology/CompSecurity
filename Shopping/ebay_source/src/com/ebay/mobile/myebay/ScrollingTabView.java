// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.ebay.mobile.util.ThemeUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ScrollingTabView extends HorizontalScrollView
    implements android.support.v4.view.ViewPager.OnPageChangeListener
{
    public static interface OnCurrentTabReselected
    {

        public abstract void onTabReselected(int i);
    }

    private class UnderlineView extends View
    {

        private final float bigUnderlineHeight;
        private final Paint bigUnderlinePaint = new Paint();
        private final float dividerPadding;
        private final Paint dividerPaint = new Paint();
        private final float smallUnderlineHeight;
        private final Paint smallUnderlinePaint = new Paint();
        final ScrollingTabView this$0;

        protected void onDraw(Canvas canvas)
        {
            super.onDraw(canvas);
            if (!isInEditMode() && tabCount != 0)
            {
                View view = tabsContainer.getChildAt(currentPositionForDrawing);
                float f3 = view.getLeft();
                float f2 = view.getRight();
                float f1 = f3;
                float f = f2;
                if (currentPositionOffset > 0.0F)
                {
                    f1 = f3;
                    f = f2;
                    if (currentPositionForDrawing < tabCount - 1)
                    {
                        View view1 = tabsContainer.getChildAt(currentPositionForDrawing + 1);
                        f1 = view1.getLeft();
                        f = view1.getRight();
                        f1 = currentPositionOffset * f1 + (1.0F - currentPositionOffset) * f3;
                        f = currentPositionOffset * f + (1.0F - currentPositionOffset) * f2;
                    }
                }
                canvas.drawRect(0.0F, (float)getHeight() - smallUnderlineHeight, getWidth(), getHeight(), smallUnderlinePaint);
                canvas.drawRect(f1, (float)getHeight() - bigUnderlineHeight, f, getHeight(), bigUnderlinePaint);
                int i = 0;
                while (i < tabCount - 1) 
                {
                    View view2 = tabsContainer.getChildAt(i);
                    canvas.drawLine(view2.getRight(), dividerPadding, view2.getRight(), (float)getHeight() - dividerPadding, dividerPaint);
                    i++;
                }
            }
        }

        public UnderlineView(Context context, AttributeSet attributeset)
        {
            this$0 = ScrollingTabView.this;
            super(context);
            scrollingtabview = context.getTheme().obtainStyledAttributes(attributeset, com.ebay.mobile.R.styleable.ScrollingTabView, 0, 0);
            smallUnderlinePaint.setAntiAlias(true);
            smallUnderlinePaint.setStyle(android.graphics.Paint.Style.FILL);
            smallUnderlinePaint.setColor(getColor(3, 0));
            bigUnderlinePaint.setAntiAlias(true);
            bigUnderlinePaint.setStyle(android.graphics.Paint.Style.FILL);
            bigUnderlinePaint.setColor(getColor(5, 0));
            dividerPaint.setAntiAlias(true);
            dividerPaint.setStrokeWidth(getDimension(1, 0.0F));
            dividerPaint.setColor(getColor(0, 0));
            smallUnderlineHeight = getDimension(4, 0.0F);
            bigUnderlineHeight = getDimension(6, 0.0F);
            dividerPadding = getDimension(2, 0.0F);
            recycle();
        }
    }


    private final RelativeLayout container;
    private int currentPosition;
    private int currentPositionForDrawing;
    private float currentPositionOffset;
    private final List delegatePageListeners;
    private boolean forceScroll;
    private int lastScrollX;
    private OnCurrentTabReselected onCurrentTabReselected;
    private int scrollOffset;
    private int tabCount;
    private final android.view.View.OnClickListener tabListener;
    private final LinearLayout tabsContainer;
    private final UnderlineView underlineView;
    private ViewPager viewPager;
    private final android.widget.LinearLayout.LayoutParams weightedLayoutParams;

    public ScrollingTabView(Context context)
    {
        this(context, null);
    }

    public ScrollingTabView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ScrollingTabView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        currentPositionForDrawing = 0;
        currentPosition = 0;
        currentPositionOffset = 0.0F;
        scrollOffset = 90;
        lastScrollX = 0;
        tabListener = new android.view.View.OnClickListener() {

            final ScrollingTabView this$0;

            public void onClick(View view)
            {
                int j = ((Integer)view.getTag()).intValue();
                if (currentPosition == j && onCurrentTabReselected != null)
                {
                    onCurrentTabReselected.onTabReselected(currentPosition);
                }
                viewPager.setCurrentItem(j);
            }

            
            {
                this$0 = ScrollingTabView.this;
                super();
            }
        };
        setFillViewport(true);
        setWillNotDraw(false);
        setSmoothScrollingEnabled(true);
        tabCount = 0;
        delegatePageListeners = new ArrayList();
        onCurrentTabReselected = null;
        forceScroll = false;
        container = new RelativeLayout(context);
        container.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -1));
        addView(container);
        tabsContainer = new LinearLayout(context);
        tabsContainer.setOrientation(0);
        tabsContainer.setId(0x7f100007);
        i = ThemeUtil.resolveThemeResId(context.getTheme(), 0x7f010055, 0x7f020005);
        tabsContainer.setBackgroundResource(i);
        tabsContainer.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        container.addView(tabsContainer);
        underlineView = new UnderlineView(context, attributeset);
        context = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        context.addRule(5, 0x7f100007);
        context.addRule(7, 0x7f100007);
        context.addRule(12);
        underlineView.setLayoutParams(context);
        container.addView(underlineView);
        scrollOffset = (int)TypedValue.applyDimension(1, scrollOffset, getResources().getDisplayMetrics());
        weightedLayoutParams = new android.widget.LinearLayout.LayoutParams(0, -1, 1.0F);
    }

    private boolean isLayoutReadyForScrolling(int i)
    {
        View view = tabsContainer.getChildAt(i);
        return view.getLeft() != view.getRight();
    }

    private void scrollAfterLayoutCompleteJellyBean()
    {
        getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final ScrollingTabView this$0;

            public void onGlobalLayout()
            {
                getViewTreeObserver().removeOnGlobalLayoutListener(this);
                forceScroll = true;
                scrollToChild(currentPosition, 0);
            }

            
            {
                this$0 = ScrollingTabView.this;
                super();
            }
        });
    }

    private void scrollAfterLayoutCompletePreJellyBean()
    {
        getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final ScrollingTabView this$0;

            public void onGlobalLayout()
            {
                getViewTreeObserver().removeGlobalOnLayoutListener(this);
                forceScroll = true;
                scrollToChild(currentPosition, 0);
            }

            
            {
                this$0 = ScrollingTabView.this;
                super();
            }
        });
    }

    private void scrollToChild(int i, int j)
    {
        if (tabCount != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int k = tabsContainer.getChildAt(i).getLeft() + j;
        if (i <= 0)
        {
            i = k;
            if (j <= 0)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        i = k - scrollOffset;
        if (i == lastScrollX && !forceScroll) goto _L1; else goto _L3
_L3:
        lastScrollX = i;
        scrollTo(i, 0);
        if (forceScroll)
        {
            forceScroll = false;
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private void updateTabPositions(int i)
    {
        for (; i < tabCount; i++)
        {
            tabsContainer.getChildAt(i).setTag(Integer.valueOf(i));
        }

    }

    public void addOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener)
    {
        delegatePageListeners.add(onpagechangelistener);
    }

    public void addTab(View view, int i)
    {
        if (view != null)
        {
            view.setTag(Integer.valueOf(i));
            view.setFocusable(true);
            view.setOnClickListener(tabListener);
            tabCount = tabCount + 1;
            tabsContainer.addView(view, i, weightedLayoutParams);
            updateTabPositions(i);
        }
    }

    public void clearAllTabs()
    {
        tabsContainer.removeAllViews();
        tabCount = 0;
    }

    public int getCurrentPosition()
    {
        return currentPosition;
    }

    public View getTabAtIndex(int i)
    {
        Object obj = null;
        View view = obj;
        if (i >= 0)
        {
            view = obj;
            if (i < tabCount)
            {
                view = tabsContainer.getChildAt(i);
            }
        }
        return view;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (isInEditMode() || tabCount == 0)
        {
            return;
        } else
        {
            underlineView.invalidate();
            return;
        }
    }

    public void onPageScrollStateChanged(int i)
    {
        if (i == 0)
        {
            scrollToChild(viewPager.getCurrentItem(), 0);
        }
        for (Iterator iterator = delegatePageListeners.iterator(); iterator.hasNext(); ((android.support.v4.view.ViewPager.OnPageChangeListener)iterator.next()).onPageScrollStateChanged(i)) { }
    }

    public void onPageScrolled(int i, float f, int j)
    {
        View view = tabsContainer.getChildAt(i);
        if (view != null)
        {
            currentPositionForDrawing = i;
            currentPositionOffset = f;
            scrollToChild(i, (int)((float)view.getWidth() * f));
            invalidate();
            for (Iterator iterator = delegatePageListeners.iterator(); iterator.hasNext(); ((android.support.v4.view.ViewPager.OnPageChangeListener)iterator.next()).onPageScrolled(i, f, j)) { }
        }
    }

    public void onPageSelected(int i)
    {
        currentPosition = i;
        for (Iterator iterator = delegatePageListeners.iterator(); iterator.hasNext(); ((android.support.v4.view.ViewPager.OnPageChangeListener)iterator.next()).onPageSelected(i)) { }
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        super.onRestoreInstanceState(parcelable);
        setPosition(currentPosition);
    }

    public void removeTabAtIndex(int i)
    {
        if (i >= 0 && i < tabCount)
        {
            tabsContainer.removeViewAt(i);
            tabCount = tabCount - 1;
        }
        updateTabPositions(i);
    }

    public void setOnCurrentTabReselected(OnCurrentTabReselected oncurrenttabreselected)
    {
        onCurrentTabReselected = oncurrenttabreselected;
    }

    public void setPosition(int i)
    {
label0:
        {
            if (i < tabCount)
            {
                currentPositionForDrawing = i;
                currentPosition = i;
                viewPager.setCurrentItem(currentPosition);
                if (!isLayoutReadyForScrolling(currentPosition))
                {
                    break label0;
                }
                scrollToChild(currentPosition, 0);
            }
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            scrollAfterLayoutCompleteJellyBean();
            return;
        } else
        {
            scrollAfterLayoutCompletePreJellyBean();
            return;
        }
    }

    public void setViewPager(ViewPager viewpager)
    {
        viewPager = viewpager;
        if (viewPager != null)
        {
            viewPager.setOnPageChangeListener(this);
        }
    }





/*
    static boolean access$302(ScrollingTabView scrollingtabview, boolean flag)
    {
        scrollingtabview.forceScroll = flag;
        return flag;
    }

*/





}
