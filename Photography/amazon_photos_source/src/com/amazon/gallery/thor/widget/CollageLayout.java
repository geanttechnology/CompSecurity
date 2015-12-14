// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class CollageLayout extends ViewGroup
{

    private double largestChildSpaceRatio;
    private boolean reverseLayout;

    public CollageLayout(Context context)
    {
        this(context, null);
    }

    public CollageLayout(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public CollageLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        context = context.obtainStyledAttributes(attributeset, com.amazon.photos.R.styleable.CollageLayout);
        largestChildSpaceRatio = context.getFloat(0, 0.5F);
        reverseLayout = context.getBoolean(1, false);
        context.recycle();
    }

    private void divideTotalAreaAmongChildren(int i, int j, int k)
    {
        if (k != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int l1;
        if (k == 1)
        {
            measureChildWithExactDimensions(getChildAt(0), i, j);
            return;
        }
        int l = getLargestChildWidth(i);
        measureChildWithExactDimensions(getChildAt(0), l, j);
        i -= l;
        l1 = k - 1;
        l = getDivisionFactor(l1);
        if (l <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        int k2 = i / l;
        int i3 = j / l;
        int i2 = k - l1;
        int j1 = i;
        l = j;
        j = l1;
        i = i2;
        while (i < k) 
        {
            measureChildWithExactDimensions(getChildAt(i), k2, i3);
            j1 -= k2;
            l -= i3;
            j--;
            i++;
        }
        if (true) goto _L1; else goto _L3
_L3:
        measureChildWithExactDimensions(getChildAt(1), i, j / 2);
        int j2 = j / 2;
        int i1 = l1 - 1;
        int l2 = i / i1;
        l1 = k - i1;
        int k1 = i;
        i = l1;
        while (i < k) 
        {
            measureChildWithExactDimensions(getChildAt(i), l2, j - j2);
            k1 -= l2;
            i1--;
            i++;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private int getDivisionFactor(int i)
    {
        int j;
        if ((i & 0xf) > 9)
        {
            j = -1;
        } else
        {
            int k = (int)Math.floor(Math.sqrt(i) + 0.5D);
            j = k;
            if (k * k != i)
            {
                return -1;
            }
        }
        return j;
    }

    private int getLargestChildWidth(int i)
    {
        double d = largestChildSpaceRatio * (double)i;
        int k = (int)d;
        int j = k;
        if ((i - k) % 2 != 0)
        {
            j = (int)Math.ceil(d);
        }
        return j;
    }

    private void layoutChildWithMargins(View view, int i, int j, int k, int l)
    {
        android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)view.getLayoutParams();
        view.layout(i + marginlayoutparams.leftMargin, j + marginlayoutparams.topMargin, (i + k) - marginlayoutparams.rightMargin, (j + l) - marginlayoutparams.bottomMargin);
    }

    private void measureChildWithExactDimensions(View view, int i, int j)
    {
        measureChildWithoutMargins(view, android.view.View.MeasureSpec.makeMeasureSpec(i, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(j, 0x40000000));
    }

    private void measureChildWithoutMargins(View view, int i, int j)
    {
        android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, 0, marginlayoutparams.width), getChildMeasureSpec(j, 0, marginlayoutparams.height));
    }

    private void onCollageViewLayout(boolean flag, int i, int j, int k, int l, int i1)
    {
        if (i1 != 0)
        {
            j = getPaddingLeft();
            i = getPaddingTop();
            int i2 = getPaddingRight();
            View view = getChildAt(0);
            l = view.getMeasuredWidth();
            layoutChildWithMargins(view, j, i, l, view.getMeasuredHeight());
            j += l;
            int j1 = j;
            l = 1;
            while (l < i1) 
            {
                View view1 = getChildAt(l);
                int j2 = view1.getMeasuredWidth();
                int l1 = view1.getMeasuredHeight();
                layoutChildWithMargins(view1, j1, i, j2, l1);
                if (j1 + j2 < k - i2 - ((android.view.ViewGroup.MarginLayoutParams)view1.getLayoutParams()).rightMargin)
                {
                    j1 += j2;
                    l1 = i;
                    i = j1;
                } else
                {
                    int k1 = j;
                    l1 = i + l1;
                    i = k1;
                }
                l++;
                j1 = i;
                i = l1;
            }
        }
    }

    private void onCollageViewLayoutReverse(boolean flag, int i, int j, int k, int l, int i1)
    {
        if (i1 != 0)
        {
            int j2 = getPaddingLeft();
            int j1 = getPaddingTop();
            int k1 = getPaddingRight();
            View view = getChildAt(0);
            j = view.getMeasuredWidth();
            l = view.getMeasuredHeight();
            k = k - k1 - j;
            layoutChildWithMargins(view, k, j1, j, l);
            l = 1;
            j = k;
            while (l < i1) 
            {
                View view1 = getChildAt(l);
                int l1 = view1.getMeasuredWidth();
                int k2 = view1.getMeasuredHeight();
                int i2 = j - l1;
                layoutChildWithMargins(view1, i2, j1, l1, k2);
                j = i2;
                l1 = j1;
                if (i2 <= i + j2 + ((android.view.ViewGroup.MarginLayoutParams)view1.getLayoutParams()).leftMargin)
                {
                    j = k;
                    l1 = j1 + k2;
                }
                l++;
                j1 = l1;
            }
        }
    }

    private void onCollageViewMeasure(int i, int j, int k)
    {
        i = getDefaultSize(0, i);
        j = getDefaultSize(0, j);
        divideTotalAreaAmongChildren(i - (getPaddingLeft() + getPaddingRight()), j - (getPaddingTop() + getPaddingBottom()), k);
        setMeasuredDimension(i, j);
    }

    public boolean hasReverseLayoutDirection()
    {
        return reverseLayout;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        if (reverseLayout)
        {
            onCollageViewLayoutReverse(flag, i, j, k, l, getChildCount());
            return;
        } else
        {
            onCollageViewLayout(flag, i, j, k, l, getChildCount());
            return;
        }
    }

    protected void onMeasure(int i, int j)
    {
        onCollageViewMeasure(i, j, getChildCount());
    }

    public void setLargestChildSpaceRatio(double d)
    {
        if (largestChildSpaceRatio != d)
        {
            largestChildSpaceRatio = d;
            requestLayout();
        }
    }

    public void setReverseLayoutDirection(boolean flag)
    {
        if (flag != reverseLayout)
        {
            reverseLayout = flag;
            requestLayout();
        }
    }

    public boolean shouldDelayChildPressedState()
    {
        return false;
    }
}
