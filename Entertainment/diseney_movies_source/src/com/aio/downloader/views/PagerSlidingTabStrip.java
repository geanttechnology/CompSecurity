// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PagerSlidingTabStrip extends HorizontalScrollView
{
    public static interface CustomTabProvider
    {

        public abstract View getCustomTabView(ViewGroup viewgroup, int i);

        public abstract void tabSelected(View view);

        public abstract void tabUnselected(View view);
    }

    public static interface OnTabReselectedListener
    {

        public abstract void onTabReselected(int i);
    }

    private class PageListener
        implements android.support.v4.view.ViewPager.OnPageChangeListener
    {

        final PagerSlidingTabStrip this$0;

        public void onPageScrollStateChanged(int i)
        {
            if (i == 0)
            {
                scrollToChild(mPager.getCurrentItem(), 0);
            }
            View view = mTabsContainer.getChildAt(mPager.getCurrentItem());
            select(view);
            if (mPager.getCurrentItem() - 1 >= 0)
            {
                View view1 = mTabsContainer.getChildAt(mPager.getCurrentItem() - 1);
                unSelect(view1);
            }
            if (mPager.getCurrentItem() + 1 <= mPager.getAdapter().getCount() - 1)
            {
                View view2 = mTabsContainer.getChildAt(mPager.getCurrentItem() + 1);
                unSelect(view2);
            }
            if (mDelegatePageListener != null)
            {
                mDelegatePageListener.onPageScrollStateChanged(i);
            }
        }

        public void onPageScrolled(int i, float f, int j)
        {
            mCurrentPosition = i;
            mCurrentPositionOffset = f;
            int k;
            if (mTabCount > 0)
            {
                k = (int)((float)mTabsContainer.getChildAt(i).getWidth() * f);
            } else
            {
                k = 0;
            }
            scrollToChild(i, k);
            invalidate();
            if (mDelegatePageListener != null)
            {
                mDelegatePageListener.onPageScrolled(i, f, j);
            }
        }

        public void onPageSelected(int i)
        {
            updateSelection(i);
            if (mDelegatePageListener != null)
            {
                mDelegatePageListener.onPageSelected(i);
            }
        }

        private PageListener()
        {
            this$0 = PagerSlidingTabStrip.this;
            super();
        }

        PageListener(PageListener pagelistener)
        {
            this();
        }
    }

    private class PagerAdapterObserver extends DataSetObserver
    {

        private boolean attached;
        final PagerSlidingTabStrip this$0;

        public boolean isAttached()
        {
            return attached;
        }

        public void onChanged()
        {
            notifyDataSetChanged();
        }

        public void setAttached(boolean flag)
        {
            attached = flag;
        }

        private PagerAdapterObserver()
        {
            this$0 = PagerSlidingTabStrip.this;
            super();
            attached = false;
        }

        PagerAdapterObserver(PagerAdapterObserver pageradapterobserver)
        {
            this();
        }
    }

    static class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel, null);
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

        SavedState(Parcel parcel, SavedState savedstate)
        {
            this(parcel);
        }

        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }


    private static final int ANDROID_ATTRS[] = {
        0x1010036, 0x10100d5, 0x10100d6, 0x10100d8
    };
    public static final int DEF_VALUE_TAB_TEXT_ALPHA = 150;
    private static final int PADDING_INDEX = 1;
    private static final int PADDING_LEFT_INDEX = 2;
    private static final int PADDING_RIGHT_INDEX = 3;
    private static final int TEXT_COLOR_PRIMARY = 0;
    private android.view.ViewTreeObserver.OnGlobalLayoutListener firstTabGlobalLayoutListener = new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

        final PagerSlidingTabStrip this$0;

        private void removeGlobalLayoutListenerJB()
        {
            getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        private void removeGlobalLayoutListenerPreJB()
        {
            getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }

        public void onGlobalLayout()
        {
            Object obj1 = mTabsContainer.getChildAt(0);
            if (android.os.Build.VERSION.SDK_INT < 16)
            {
                removeGlobalLayoutListenerPreJB();
            } else
            {
                removeGlobalLayoutListenerJB();
            }
            if (isPaddingMiddle)
            {
                int l = ((View) (obj1)).getWidth() / 2;
                obj1 = PagerSlidingTabStrip.this;
                PagerSlidingTabStrip pagerslidingtabstrip = PagerSlidingTabStrip.this;
                l = getWidth() / 2 - l;
                pagerslidingtabstrip.mPaddingRight = l;
                obj1.mPaddingLeft = l;
            }
            setPadding(mPaddingLeft, getPaddingTop(), mPaddingRight, getPaddingBottom());
            if (mScrollOffset == 0)
            {
                mScrollOffset = getWidth() / 2 - mPaddingLeft;
            }
            mCurrentPosition = mPager.getCurrentItem();
            mCurrentPositionOffset = 0.0F;
            scrollToChild(mCurrentPosition, 0);
            updateSelection(mCurrentPosition);
        }

            
            {
                this$0 = PagerSlidingTabStrip.this;
                super();
            }
    };
    private boolean isCustomTabs;
    private boolean isExpandTabs;
    private boolean isPaddingMiddle;
    private boolean isTabTextAllCaps;
    private final PagerAdapterObserver mAdapterObserver;
    private int mCurrentPosition;
    private float mCurrentPositionOffset;
    public android.support.v4.view.ViewPager.OnPageChangeListener mDelegatePageListener;
    private int mDividerColor;
    private int mDividerPadding;
    private Paint mDividerPaint;
    private int mDividerWidth;
    private int mIndicatorColor;
    private int mIndicatorHeight;
    private int mLastScrollX;
    private int mPaddingLeft;
    private int mPaddingRight;
    private final PageListener mPageListener;
    private ViewPager mPager;
    private Paint mRectPaint;
    private int mScrollOffset;
    private int mTabBackgroundResId;
    private int mTabCount;
    private android.widget.LinearLayout.LayoutParams mTabLayoutParams;
    private int mTabPadding;
    private OnTabReselectedListener mTabReselectedListener;
    private ColorStateList mTabTextColor;
    private int mTabTextSize;
    private Typeface mTabTextTypeface;
    private int mTabTextTypefaceStyle;
    private LinearLayout mTabsContainer;
    private int mUnderlineColor;
    private int mUnderlineHeight;

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
        super(context, attributeset, i);
        mAdapterObserver = new PagerAdapterObserver(null);
        mPageListener = new PageListener(null);
        mTabReselectedListener = null;
        mCurrentPosition = 0;
        mCurrentPositionOffset = 0.0F;
        mIndicatorHeight = 2;
        mUnderlineHeight = 0;
        mDividerWidth = 0;
        mDividerPadding = 0;
        mTabPadding = 12;
        mTabTextSize = 14;
        mTabTextColor = null;
        mPaddingLeft = 0;
        mPaddingRight = 0;
        isExpandTabs = false;
        isPaddingMiddle = false;
        isTabTextAllCaps = true;
        mTabTextTypeface = null;
        mTabTextTypefaceStyle = 1;
        mLastScrollX = 0;
        mTabBackgroundResId = 0x7f020166;
        setFillViewport(true);
        setWillNotDraw(false);
        mTabsContainer = new LinearLayout(context);
        mTabsContainer.setOrientation(0);
        addView(mTabsContainer);
        mRectPaint = new Paint();
        mRectPaint.setAntiAlias(true);
        mRectPaint.setStyle(android.graphics.Paint.Style.FILL);
        Object obj = getResources().getDisplayMetrics();
        mScrollOffset = (int)TypedValue.applyDimension(1, mScrollOffset, ((android.util.DisplayMetrics) (obj)));
        mIndicatorHeight = (int)TypedValue.applyDimension(1, mIndicatorHeight, ((android.util.DisplayMetrics) (obj)));
        mUnderlineHeight = (int)TypedValue.applyDimension(1, mUnderlineHeight, ((android.util.DisplayMetrics) (obj)));
        mDividerPadding = (int)TypedValue.applyDimension(1, mDividerPadding, ((android.util.DisplayMetrics) (obj)));
        mTabPadding = (int)TypedValue.applyDimension(1, mTabPadding, ((android.util.DisplayMetrics) (obj)));
        mDividerWidth = (int)TypedValue.applyDimension(1, mDividerWidth, ((android.util.DisplayMetrics) (obj)));
        mTabTextSize = (int)TypedValue.applyDimension(2, mTabTextSize, ((android.util.DisplayMetrics) (obj)));
        mDividerPaint = new Paint();
        mDividerPaint.setAntiAlias(true);
        mDividerPaint.setStrokeWidth(mDividerWidth);
        obj = context.obtainStyledAttributes(attributeset, ANDROID_ATTRS);
        int k = context.getResources().getColor(0x7f08002e);
        mUnderlineColor = k;
        mDividerColor = k;
        mIndicatorColor = k;
        i = ((TypedArray) (obj)).getDimensionPixelSize(1, 0);
        TypedArray typedarray;
        int j;
        if (i > 0)
        {
            j = i;
        } else
        {
            j = ((TypedArray) (obj)).getDimensionPixelSize(2, 0);
        }
        mPaddingLeft = j;
        if (i <= 0)
        {
            i = ((TypedArray) (obj)).getDimensionPixelSize(3, 0);
        }
        mPaddingRight = i;
        ((TypedArray) (obj)).recycle();
        obj = "sans-serif";
        typedarray = context.obtainStyledAttributes(attributeset, com.aio.downloader.R.styleable.PagerSlidingTabStrip);
        mIndicatorColor = typedarray.getColor(0, mIndicatorColor);
        mIndicatorHeight = typedarray.getDimensionPixelSize(1, mIndicatorHeight);
        mUnderlineColor = typedarray.getColor(2, mUnderlineColor);
        mUnderlineHeight = typedarray.getDimensionPixelSize(3, mUnderlineHeight);
        mDividerColor = typedarray.getColor(4, mDividerColor);
        mDividerWidth = typedarray.getDimensionPixelSize(5, mDividerWidth);
        mDividerPadding = typedarray.getDimensionPixelSize(6, mDividerPadding);
        isExpandTabs = typedarray.getBoolean(8, isExpandTabs);
        mScrollOffset = typedarray.getDimensionPixelSize(7, mScrollOffset);
        isPaddingMiddle = typedarray.getBoolean(9, isPaddingMiddle);
        mTabPadding = typedarray.getDimensionPixelSize(10, mTabPadding);
        mTabBackgroundResId = typedarray.getResourceId(11, mTabBackgroundResId);
        mTabTextSize = typedarray.getDimensionPixelSize(12, mTabTextSize);
        if (typedarray.hasValue(13))
        {
            context = typedarray.getColorStateList(13);
        } else
        {
            context = null;
        }
        mTabTextColor = context;
        mTabTextTypefaceStyle = typedarray.getInt(14, mTabTextTypefaceStyle);
        isTabTextAllCaps = typedarray.getBoolean(15, isTabTextAllCaps);
        i = typedarray.getInt(16, 150);
        attributeset = typedarray.getString(17);
        typedarray.recycle();
        if (mTabTextColor == null)
        {
            mTabTextColor = createColorStateList(k, k, Color.argb(i, Color.red(k), Color.green(k), Color.blue(k)));
        }
        context = ((Context) (obj));
        if (attributeset != null)
        {
            context = attributeset;
        }
        mTabTextTypeface = Typeface.create(context, mTabTextTypefaceStyle);
        setTabsContainerParentViewPaddings();
        if (isExpandTabs)
        {
            context = new android.widget.LinearLayout.LayoutParams(0, -1, 1.0F);
        } else
        {
            context = new android.widget.LinearLayout.LayoutParams(-2, -1);
        }
        mTabLayoutParams = context;
    }

    private void addTab(final int position, CharSequence charsequence, View view)
    {
        TextView textview = (TextView)view.findViewById(0x7f07037e);
        if (textview != null && charsequence != null)
        {
            textview.setText(charsequence);
        }
        view.setFocusable(true);
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final PagerSlidingTabStrip this$0;
            private final int val$position;

            public void onClick(View view1)
            {
                if (mPager.getCurrentItem() != position)
                {
                    view1 = mTabsContainer.getChildAt(mPager.getCurrentItem());
                    unSelect(view1);
                    mPager.setCurrentItem(position);
                } else
                if (mTabReselectedListener != null)
                {
                    mTabReselectedListener.onTabReselected(position);
                    return;
                }
            }

            
            {
                this$0 = PagerSlidingTabStrip.this;
                position = i;
                super();
            }
        });
        mTabsContainer.addView(view, position, mTabLayoutParams);
    }

    private ColorStateList createColorStateList(int i)
    {
        return new ColorStateList(new int[][] {
            new int[0]
        }, new int[] {
            i
        });
    }

    private ColorStateList createColorStateList(int i, int j, int k)
    {
        int ai[] = new int[0];
        return new ColorStateList(new int[][] {
            new int[] {
                0x10100a7
            }, new int[] {
                0x10100a1
            }, ai
        }, new int[] {
            i, j, k
        });
    }

    private Pair getIndicatorCoordinates()
    {
        View view = mTabsContainer.getChildAt(mCurrentPosition);
        float f3 = view.getLeft();
        float f2 = view.getRight();
        float f1 = f3;
        float f = f2;
        if (mCurrentPositionOffset > 0.0F)
        {
            f1 = f3;
            f = f2;
            if (mCurrentPosition < mTabCount - 1)
            {
                View view1 = mTabsContainer.getChildAt(mCurrentPosition + 1);
                f1 = view1.getLeft();
                f = view1.getRight();
                f1 = mCurrentPositionOffset * f1 + (1.0F - mCurrentPositionOffset) * f3;
                f = mCurrentPositionOffset * f + (1.0F - mCurrentPositionOffset) * f2;
            }
        }
        return new Pair(Float.valueOf(f1), Float.valueOf(f));
    }

    private void scrollToChild(int i, int j)
    {
        if (mTabCount != 0) goto _L2; else goto _L1
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
        i = mScrollOffset;
        Pair pair = getIndicatorCoordinates();
        float f = k - i;
        i = (int)((((Float)pair.second).floatValue() - ((Float)pair.first).floatValue()) / 2.0F + f);
        if (i == mLastScrollX) goto _L1; else goto _L3
_L3:
        mLastScrollX = i;
        scrollTo(i, 0);
        return;
    }

    private void select(View view)
    {
        if (view != null)
        {
            TextView textview = (TextView)view.findViewById(0x7f07037e);
            if (textview != null)
            {
                textview.setSelected(true);
            }
            if (isCustomTabs)
            {
                ((CustomTabProvider)mPager.getAdapter()).tabSelected(view);
            }
        }
    }

    private void setTabsContainerParentViewPaddings()
    {
        int i;
        if (mIndicatorHeight >= mUnderlineHeight)
        {
            i = mIndicatorHeight;
        } else
        {
            i = mUnderlineHeight;
        }
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), i);
    }

    private void unSelect(View view)
    {
        if (view != null)
        {
            TextView textview = (TextView)view.findViewById(0x7f07037e);
            if (textview != null)
            {
                textview.setSelected(false);
            }
            if (isCustomTabs)
            {
                ((CustomTabProvider)mPager.getAdapter()).tabUnselected(view);
            }
        }
    }

    private void updateSelection(int i)
    {
        int j = 0;
        do
        {
            if (j >= mTabCount)
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
            if (flag)
            {
                select(view);
            } else
            {
                unSelect(view);
            }
            j++;
        } while (true);
    }

    private void updateTabStyles()
    {
        int i = 0;
        do
        {
            if (i >= mTabCount)
            {
                return;
            }
            Object obj = mTabsContainer.getChildAt(i);
            ((View) (obj)).setBackgroundResource(mTabBackgroundResId);
            ((View) (obj)).setPadding(mTabPadding, ((View) (obj)).getPaddingTop(), mTabPadding, ((View) (obj)).getPaddingBottom());
            obj = (TextView)((View) (obj)).findViewById(0x7f07037e);
            if (obj != null)
            {
                ((TextView) (obj)).setTextColor(mTabTextColor);
                ((TextView) (obj)).setTypeface(mTabTextTypeface, mTabTextTypefaceStyle);
                ((TextView) (obj)).setTextSize(0, mTabTextSize);
                if (isTabTextAllCaps)
                {
                    if (android.os.Build.VERSION.SDK_INT >= 14)
                    {
                        ((TextView) (obj)).setAllCaps(true);
                    } else
                    {
                        ((TextView) (obj)).setText(((TextView) (obj)).getText().toString().toUpperCase(getResources().getConfiguration().locale));
                    }
                }
            }
            i++;
        } while (true);
    }

    public int getDividerColor()
    {
        return mDividerColor;
    }

    public int getDividerPadding()
    {
        return mDividerPadding;
    }

    public int getDividerWidth()
    {
        return mDividerWidth;
    }

    public int getIndicatorColor()
    {
        return mIndicatorColor;
    }

    public int getIndicatorHeight()
    {
        return mIndicatorHeight;
    }

    public int getScrollOffset()
    {
        return mScrollOffset;
    }

    public boolean getShouldExpand()
    {
        return isExpandTabs;
    }

    public int getTabBackground()
    {
        return mTabBackgroundResId;
    }

    public int getTabPaddingLeftRight()
    {
        return mTabPadding;
    }

    public ColorStateList getTextColor()
    {
        return mTabTextColor;
    }

    public int getTextSize()
    {
        return mTabTextSize;
    }

    public int getUnderlineColor()
    {
        return mUnderlineColor;
    }

    public int getUnderlineHeight()
    {
        return mUnderlineHeight;
    }

    public boolean isTextAllCaps()
    {
        return isTabTextAllCaps;
    }

    public void notifyDataSetChanged()
    {
        mTabsContainer.removeAllViews();
        mTabCount = mPager.getAdapter().getCount();
        int i = 0;
        do
        {
            if (i >= mTabCount)
            {
                updateTabStyles();
                return;
            }
            View view;
            if (isCustomTabs)
            {
                view = ((CustomTabProvider)mPager.getAdapter()).getCustomTabView(this, i);
            } else
            {
                view = LayoutInflater.from(getContext()).inflate(0x7f0300a2, this, false);
            }
            addTab(i, mPager.getAdapter().getPageTitle(i), view);
            i++;
        } while (true);
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (mPager != null && !mAdapterObserver.isAttached())
        {
            mPager.getAdapter().registerDataSetObserver(mAdapterObserver);
            mAdapterObserver.setAttached(true);
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (mPager != null && mAdapterObserver.isAttached())
        {
            mPager.getAdapter().unregisterDataSetObserver(mAdapterObserver);
            mAdapterObserver.setAttached(false);
        }
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (!isInEditMode() && mTabCount != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int j = getHeight();
        if (mDividerWidth <= 0) goto _L4; else goto _L3
_L3:
        int i;
        mDividerPaint.setStrokeWidth(mDividerWidth);
        mDividerPaint.setColor(mDividerColor);
        i = 0;
_L5:
        if (i < mTabCount - 1)
        {
            break MISSING_BLOCK_LABEL_215;
        }
_L4:
        if (mUnderlineHeight > 0)
        {
            mRectPaint.setColor(mUnderlineColor);
            canvas.drawRect(mPaddingLeft, j - mUnderlineHeight, mTabsContainer.getWidth() + mPaddingRight, j, mRectPaint);
        }
        if (mIndicatorHeight > 0)
        {
            mRectPaint.setColor(mIndicatorColor);
            Pair pair = getIndicatorCoordinates();
            float f = ((Float)pair.first).floatValue();
            float f1 = mPaddingLeft;
            float f2 = j - mIndicatorHeight;
            float f3 = ((Float)pair.second).floatValue();
            canvas.drawRect(f1 + f, f2, (float)mPaddingLeft + f3, j, mRectPaint);
            return;
        }
          goto _L1
        View view = mTabsContainer.getChildAt(i);
        canvas.drawLine(view.getRight(), mDividerPadding, view.getRight(), j - mDividerPadding, mDividerPaint);
        i++;
          goto _L5
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        if (isPaddingMiddle || mPaddingLeft > 0 || mPaddingRight > 0)
        {
            int i1;
            if (isPaddingMiddle)
            {
                i1 = getWidth();
            } else
            {
                i1 = getWidth() - mPaddingLeft - mPaddingRight;
            }
            mTabsContainer.setMinimumWidth(i1);
            setClipToPadding(false);
        }
        if (mTabsContainer.getChildCount() > 0)
        {
            mTabsContainer.getChildAt(0).getViewTreeObserver().addOnGlobalLayoutListener(firstTabGlobalLayoutListener);
        }
        super.onLayout(flag, i, j, k, l);
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        mCurrentPosition = ((SavedState) (parcelable)).currentPosition;
        if (mCurrentPosition != 0 && mTabsContainer.getChildCount() > 0)
        {
            unSelect(mTabsContainer.getChildAt(0));
            select(mTabsContainer.getChildAt(mCurrentPosition));
        }
        requestLayout();
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.currentPosition = mCurrentPosition;
        return savedstate;
    }

    public void setAllCaps(boolean flag)
    {
        isTabTextAllCaps = flag;
    }

    public void setDividerColor(int i)
    {
        mDividerColor = i;
        invalidate();
    }

    public void setDividerColorResource(int i)
    {
        mDividerColor = getResources().getColor(i);
        invalidate();
    }

    public void setDividerPadding(int i)
    {
        mDividerPadding = i;
        invalidate();
    }

    public void setDividerWidth(int i)
    {
        mDividerWidth = i;
        invalidate();
    }

    public void setIndicatorColor(int i)
    {
        mIndicatorColor = i;
        invalidate();
    }

    public void setIndicatorColorResource(int i)
    {
        mIndicatorColor = getResources().getColor(i);
        invalidate();
    }

    public void setIndicatorHeight(int i)
    {
        mIndicatorHeight = i;
        invalidate();
    }

    public void setOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener)
    {
        mDelegatePageListener = onpagechangelistener;
    }

    public void setOnTabReselectedListener(OnTabReselectedListener ontabreselectedlistener)
    {
        mTabReselectedListener = ontabreselectedlistener;
    }

    public void setScrollOffset(int i)
    {
        mScrollOffset = i;
        invalidate();
    }

    public void setShouldExpand(boolean flag)
    {
        isExpandTabs = flag;
        if (mPager != null)
        {
            requestLayout();
        }
    }

    public void setTabBackground(int i)
    {
        mTabBackgroundResId = i;
    }

    public void setTabPaddingLeftRight(int i)
    {
        mTabPadding = i;
        updateTabStyles();
    }

    public void setTextColor(int i)
    {
        setTextColor(createColorStateList(i));
    }

    public void setTextColor(ColorStateList colorstatelist)
    {
        mTabTextColor = colorstatelist;
        updateTabStyles();
    }

    public void setTextColorResource(int i)
    {
        setTextColor(getResources().getColor(i));
    }

    public void setTextColorStateListResource(int i)
    {
        setTextColor(getResources().getColorStateList(i));
    }

    public void setTextSize(int i)
    {
        mTabTextSize = i;
        updateTabStyles();
    }

    public void setTypeface(Typeface typeface, int i)
    {
        mTabTextTypeface = typeface;
        mTabTextTypefaceStyle = i;
        updateTabStyles();
    }

    public void setUnderlineColor(int i)
    {
        mUnderlineColor = i;
        invalidate();
    }

    public void setUnderlineColorResource(int i)
    {
        mUnderlineColor = getResources().getColor(i);
        invalidate();
    }

    public void setUnderlineHeight(int i)
    {
        mUnderlineHeight = i;
        invalidate();
    }

    public void setViewPager(ViewPager viewpager)
    {
        mPager = viewpager;
        if (viewpager.getAdapter() == null)
        {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        } else
        {
            isCustomTabs = viewpager.getAdapter() instanceof CustomTabProvider;
            viewpager.setOnPageChangeListener(mPageListener);
            viewpager.getAdapter().registerDataSetObserver(mAdapterObserver);
            mAdapterObserver.setAttached(true);
            notifyDataSetChanged();
            return;
        }
    }



















}
