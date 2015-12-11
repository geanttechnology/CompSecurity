// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.groupon.tracking.mobile.sdk.Logger;
import java.util.Locale;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.view:
//            GrouponViewPager

public class PagerSlidingTabStrip extends HorizontalScrollView
{
    public static interface IconTabProvider
    {

        public abstract int getPageIconResId(int i);
    }

    private class PageListener
        implements android.support.v4.view.ViewPager.OnPageChangeListener
    {

        final PagerSlidingTabStrip this$0;

        public void onPageScrollStateChanged(int i)
        {
            if (i == 0)
            {
                scrollToChild(pager.getCurrentItem(), 0);
            }
            if (delegatePageListener != null)
            {
                delegatePageListener.onPageScrollStateChanged(i);
            }
        }

        public void onPageScrolled(int i, float f, int j)
        {
            currentPosition = i;
            currentPositionOffset = f;
            scrollToChild(i, (int)((float)tabsContainer.getChildAt(i).getWidth() * f));
            invalidate();
            if (delegatePageListener != null)
            {
                delegatePageListener.onPageScrolled(i, f, j);
            }
        }

        public void onPageSelected(int i)
        {
            android.app.Fragment fragment = pager.findFragmentByPositionIfAvailable(i);
            if (!tabClicked && fragment != null && previousClassName != null)
            {
                logger.logUserInteraction("", getDirection(i), previousClassName, createClickMetadata(previousClassName, fragment.getClass().getSimpleName()), Logger.NULL_NST_FIELD);
            } else
            {
                tabClicked = false;
            }
            if (delegatePageListener != null)
            {
                delegatePageListener.onPageSelected(i);
            }
            highlightTabText(i);
        }

        private PageListener()
        {
            this$0 = PagerSlidingTabStrip.this;
            super();
        }

    }

    static class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public SavedState[] newArray(int i)
            {
                return new SavedState[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        int currentPosition;

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeInt(currentPosition);
        }


        private SavedState(Parcel parcel)
        {
            super(parcel);
            currentPosition = parcel.readInt();
        }


        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }


    private static final int ATTRS[] = {
        0x1010095, 0x1010098
    };
    private int currentPosition;
    private float currentPositionOffset;
    private String defaultFont;
    private android.widget.LinearLayout.LayoutParams defaultTabLayoutParams;
    public android.support.v4.view.ViewPager.OnPageChangeListener delegatePageListener;
    private android.widget.LinearLayout.LayoutParams expandedTabLayoutParams;
    private int indicatorColor;
    private int indicatorHeight;
    private int lastScrollX;
    private Locale locale;
    private Logger logger;
    private final PageListener pageListener;
    private GrouponViewPager pager;
    private String previousClassName;
    private Paint rectPaint;
    private int scrollOffset;
    private boolean shouldExpand;
    private int tabBackgroundColor;
    private int tabBackgroundResId;
    private boolean tabClicked;
    private int tabCount;
    private int tabPadding;
    private int tabTextColor;
    private int tabTextHighlighted;
    private int tabTextSize;
    private Typeface tabTypeface;
    private int tabTypefaceStyle;
    private LinearLayout tabsContainer;
    private boolean textAllCaps;

    public PagerSlidingTabStrip(Context context)
    {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeset, int i)
    {
        boolean flag = true;
        super(context, attributeset, i);
        pageListener = new PageListener();
        currentPosition = 0;
        currentPositionOffset = 0.0F;
        shouldExpand = false;
        textAllCaps = true;
        scrollOffset = 52;
        indicatorHeight = 2;
        tabPadding = 12;
        tabTextSize = 14;
        tabTypeface = null;
        tabTypefaceStyle = 0;
        lastScrollX = 0;
        tabBackgroundResId = 0x7f0202a6;
        tabClicked = false;
        setFillViewport(true);
        setWillNotDraw(false);
        tabsContainer = new LinearLayout(context);
        tabsContainer.setOrientation(0);
        tabsContainer.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        addView(tabsContainer);
        Object obj = getResources();
        indicatorColor = ((Resources) (obj)).getColor(0x7f0e018c);
        tabTextColor = ((Resources) (obj)).getColor(0x7f0e018d);
        tabTextHighlighted = ((Resources) (obj)).getColor(0x7f0e01a9);
        tabBackgroundColor = ((Resources) (obj)).getColor(0x7f0e0004);
        defaultFont = ((Resources) (obj)).getString(0x7f080511);
        obj = ((Resources) (obj)).getDisplayMetrics();
        scrollOffset = (int)TypedValue.applyDimension(1, scrollOffset, ((android.util.DisplayMetrics) (obj)));
        indicatorHeight = (int)TypedValue.applyDimension(1, indicatorHeight, ((android.util.DisplayMetrics) (obj)));
        tabPadding = (int)TypedValue.applyDimension(1, tabPadding, ((android.util.DisplayMetrics) (obj)));
        tabTextSize = (int)TypedValue.applyDimension(2, tabTextSize, ((android.util.DisplayMetrics) (obj)));
        context = context.obtainStyledAttributes(attributeset, ATTRS);
        tabTextSize = context.getDimensionPixelSize(0, tabTextSize);
        tabTextColor = context.getColor(1, tabTextColor);
        context.recycle();
        rectPaint = new Paint();
        rectPaint.setAntiAlias(true);
        rectPaint.setStyle(android.graphics.Paint.Style.FILL);
        defaultTabLayoutParams = new android.widget.LinearLayout.LayoutParams(-2, -1);
        expandedTabLayoutParams = new android.widget.LinearLayout.LayoutParams(0, -1, 1.0F);
        if (locale == null)
        {
            locale = getResources().getConfiguration().locale;
        }
        RoboGuice.getInjector(getContext()).injectMembers(this);
        setBackgroundColor(tabBackgroundColor);
        if (android.os.Build.VERSION.SDK_INT <= 19)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        tabTypefaceStyle = i;
        setTypeface(Typeface.create(defaultFont, tabTypefaceStyle), tabTypefaceStyle);
    }

    private void addIconTab(int i, int j)
    {
        ImageButton imagebutton = new ImageButton(getContext());
        imagebutton.setImageResource(j);
        addTab(i, imagebutton);
    }

    private void addTab(final int position, View view)
    {
        view.setFocusable(true);
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final PagerSlidingTabStrip this$0;
            final int val$position;

            public void onClick(View view1)
            {
                tabClicked = true;
                view1 = pager.findFragmentByPositionIfAvailable(currentPosition);
                android.app.Fragment fragment = pager.findFragmentByPositionIfAvailable(position);
                if (view1 != null && fragment != null)
                {
                    logger.logClick("", "carousel_click", view1.getClass().getSimpleName(), createClickMetadata(view1.getClass().getSimpleName(), fragment.getClass().getSimpleName()));
                }
                pager.setCurrentItem(position);
            }

            
            {
                this$0 = PagerSlidingTabStrip.this;
                position = i;
                super();
            }
        });
        view.setPadding(tabPadding, 0, tabPadding, 0);
        LinearLayout linearlayout = tabsContainer;
        android.widget.LinearLayout.LayoutParams layoutparams;
        if (shouldExpand)
        {
            layoutparams = expandedTabLayoutParams;
        } else
        {
            layoutparams = defaultTabLayoutParams;
        }
        linearlayout.addView(view, position, layoutparams);
    }

    private void addTextTab(int i, String s)
    {
        TextView textview = new TextView(getContext());
        textview.setText(s);
        textview.setGravity(17);
        textview.setSingleLine();
        addTab(i, textview);
    }

    private String createClickMetadata(String s, String s1)
    {
        return String.format("{\"sourcePage\": \"%s\", \"destinationPage\": \"%s\"}", new Object[] {
            Strings.toString(s), Strings.toString(s1)
        });
    }

    private String getDirection(int i)
    {
        if (i > 0)
        {
            android.app.Fragment fragment = pager.findFragmentByPositionIfAvailable(i - 1);
            if (fragment != null && Strings.equals(fragment.getClass().getSimpleName(), previousClassName))
            {
                return "swipe_right";
            }
        }
        return "swipe_left";
    }

    private void resetTextColor()
    {
        for (int i = 0; i < tabCount; i++)
        {
            Object obj = tabsContainer.getChildAt(i);
            if (!(obj instanceof TextView))
            {
                continue;
            }
            obj = (TextView)obj;
            if (((TextView) (obj)).getCurrentTextColor() != tabTextColor)
            {
                ((TextView) (obj)).setTextColor(tabTextColor);
            }
        }

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
        if (i == lastScrollX) goto _L1; else goto _L3
_L3:
        lastScrollX = i;
        scrollTo(i, 0);
        return;
    }

    private void updateTabStyles()
    {
        for (int i = 0; i < tabCount; i++)
        {
            Object obj = tabsContainer.getChildAt(i);
            ((View) (obj)).setBackgroundResource(tabBackgroundResId);
            if (!(obj instanceof TextView))
            {
                continue;
            }
            obj = (TextView)obj;
            ((TextView) (obj)).setTextSize(0, tabTextSize);
            ((TextView) (obj)).setTypeface(tabTypeface, tabTypefaceStyle);
            ((TextView) (obj)).setTextColor(tabTextColor);
            if (textAllCaps)
            {
                ((TextView) (obj)).setAllCaps(true);
            }
        }

    }

    public int getTextColor()
    {
        return tabTextColor;
    }

    public int getTextSize()
    {
        return tabTextSize;
    }

    protected void highlightTabText(int i)
    {
        View view = tabsContainer.getChildAt(i);
        if (view instanceof TextView)
        {
            resetTextColor();
            ((TextView)view).setTextColor(tabTextHighlighted);
        }
    }

    public boolean isTextAllCaps()
    {
        return textAllCaps;
    }

    public void notifyDataSetChanged()
    {
        tabsContainer.removeAllViews();
        tabCount = pager.getAdapter().getCount();
        int i = 0;
        while (i < tabCount) 
        {
            if (pager.getAdapter() instanceof IconTabProvider)
            {
                addIconTab(i, ((IconTabProvider)pager.getAdapter()).getPageIconResId(i));
            } else
            {
                addTextTab(i, pager.getAdapter().getPageTitle(i).toString());
            }
            i++;
        }
        updateTabStyles();
        getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final PagerSlidingTabStrip this$0;

            public void onGlobalLayout()
            {
                getViewTreeObserver().removeOnGlobalLayoutListener(this);
                currentPosition = pager.getCurrentItem();
                scrollToChild(currentPosition, 0);
                highlightTabText(currentPosition);
            }

            
            {
                this$0 = PagerSlidingTabStrip.this;
                super();
            }
        });
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (isInEditMode() || tabCount == 0)
        {
            return;
        }
        int i = getHeight();
        rectPaint.setColor(indicatorColor);
        View view = tabsContainer.getChildAt(currentPosition);
        float f3 = view.getLeft();
        float f2 = view.getRight();
        float f1 = f3;
        float f = f2;
        if (currentPositionOffset > 0.0F)
        {
            f1 = f3;
            f = f2;
            if (currentPosition < tabCount - 1)
            {
                View view1 = tabsContainer.getChildAt(currentPosition + 1);
                f1 = view1.getLeft();
                f = view1.getRight();
                f1 = currentPositionOffset * f1 + (1.0F - currentPositionOffset) * f3;
                f = currentPositionOffset * f + (1.0F - currentPositionOffset) * f2;
            }
        }
        canvas.drawRect(f1, i - indicatorHeight, f, i, rectPaint);
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        currentPosition = ((SavedState) (parcelable)).currentPosition;
        requestLayout();
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.currentPosition = currentPosition;
        return savedstate;
    }

    public void setOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener)
    {
        delegatePageListener = onpagechangelistener;
    }

    public void setPreviousClassName(String s)
    {
        previousClassName = s;
    }

    public void setShouldExpand(boolean flag)
    {
        shouldExpand = flag;
        requestLayout();
    }

    public void setTextColor(int i)
    {
        tabTextColor = i;
        updateTabStyles();
    }

    public void setTextSize(int i)
    {
        tabTextSize = i;
        updateTabStyles();
    }

    public void setTypeface(Typeface typeface, int i)
    {
        tabTypeface = typeface;
        tabTypefaceStyle = i;
        updateTabStyles();
    }

    public void setViewPager(GrouponViewPager grouponviewpager)
    {
        pager = grouponviewpager;
        if (grouponviewpager.getAdapter() == null)
        {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        } else
        {
            grouponviewpager.addOnPageChangeListener(pageListener);
            notifyDataSetChanged();
            return;
        }
    }





/*
    static int access$102(PagerSlidingTabStrip pagerslidingtabstrip, int i)
    {
        pagerslidingtabstrip.currentPosition = i;
        return i;
    }

*/






/*
    static boolean access$402(PagerSlidingTabStrip pagerslidingtabstrip, boolean flag)
    {
        pagerslidingtabstrip.tabClicked = flag;
        return flag;
    }

*/




/*
    static float access$802(PagerSlidingTabStrip pagerslidingtabstrip, float f)
    {
        pagerslidingtabstrip.currentPositionOffset = f;
        return f;
    }

*/

}
