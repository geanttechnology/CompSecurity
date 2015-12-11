// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class aq extends ViewGroup
{

    public aq(Context context)
    {
        super(context);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new android.view.ViewGroup.LayoutParams(getContext(), attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return new android.view.ViewGroup.LayoutParams(layoutparams);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        j = getPaddingLeft();
        k = getPaddingTop();
        l = getChildCount();
        for (i = 0; i < l; i++)
        {
            View view = getChildAt(i);
            if (view.getVisibility() != 8)
            {
                view.layout(j, k, view.getMeasuredWidth() + j, view.getMeasuredHeight() + k);
            }
        }

    }

    protected void onMeasure(int i, int j)
    {
        int l = 0;
        int i2 = getChildCount();
        measureChildren(i, j);
        int i1 = 0;
        int k;
        int j1;
        for (k = 0; i1 < i2; k = j1)
        {
            View view = getChildAt(i1);
            int l1 = l;
            j1 = k;
            if (view.getVisibility() != 8)
            {
                l1 = Math.max(l, view.getMeasuredWidth());
                j1 = Math.max(k, view.getMeasuredHeight());
            }
            i1++;
            l = l1;
        }

        i1 = getPaddingLeft();
        int k1 = getPaddingRight();
        k = Math.max(k + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
        setMeasuredDimension(resolveSize(Math.max(l + (i1 + k1), getSuggestedMinimumWidth()), i), resolveSize(k, j));
    }
}
