// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.bbyobjects;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class BBYFlowLayout extends ViewGroup
{

    public BBYFlowLayout(Context context)
    {
        super(context);
    }

    public BBYFlowLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public BBYFlowLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        int k1 = 0;
        l = getPaddingLeft();
        j = getPaddingTop();
        int i1 = 0;
        while (k1 < getChildCount()) 
        {
            View view = getChildAt(k1);
            int j1;
            if (view.getVisibility() == 8)
            {
                j1 = i1;
            } else
            {
                int k2 = view.getMeasuredWidth();
                int i2 = view.getMeasuredHeight();
                int j2 = Math.max(i2, i1);
                j1 = j2;
                i1 = j;
                int l1 = l;
                if (k2 + l + getPaddingRight() > k - i)
                {
                    l1 = getPaddingLeft();
                    i1 = j + (j2 + 2);
                    j1 = i2;
                }
                view.layout(l1, i1, l1 + k2, i2 + i1);
                l = l1 + (k2 + 15);
                j = i1;
            }
            k1++;
            i1 = j1;
        }
    }

    protected void onMeasure(int i, int j)
    {
        int l = getPaddingLeft();
        int k = getPaddingTop();
        int k2 = android.view.View.MeasureSpec.getSize(i);
        int k1 = 0;
        int i1 = 0;
        while (k1 < getChildCount()) 
        {
            View view = getChildAt(k1);
            int j1;
            if (view.getVisibility() == 8)
            {
                j1 = i1;
            } else
            {
                view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), getChildMeasureSpec(j, getPaddingTop() + getPaddingBottom(), view.getLayoutParams().height));
                int l2 = view.getMeasuredWidth();
                int i2 = view.getMeasuredHeight();
                int j2 = Math.max(i2, i1);
                j1 = j2;
                i1 = k;
                int l1 = l;
                if (l2 + l + getPaddingRight() > k2)
                {
                    l1 = getPaddingLeft();
                    i1 = k + (j2 + 2);
                    j1 = i2;
                }
                l = l1 + (l2 + 15);
                k = i1;
            }
            k1++;
            i1 = j1;
        }
        setMeasuredDimension(k2, resolveSize(k + i1 + getPaddingBottom() + 0, j));
    }
}
