// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

// Referenced classes of package com.actionbarsherlock.internal.widget:
//            IcsLinearLayout

public class TabsLinearLayout extends IcsLinearLayout
{

    private static final int LinearLayout_measureWithLargestChild = 0;
    private static final int R_styleable_LinearLayout[] = {
        0x10102d4
    };
    private boolean mUseLargestChild;

    public TabsLinearLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        context = context.obtainStyledAttributes(attributeset, R_styleable_LinearLayout);
        mUseLargestChild = context.getBoolean(0, false);
        context.recycle();
    }

    private void useLargestChildHorizontal()
    {
        int l = getChildCount();
        int i = 0;
        int j = 0;
        for (; i < l; i++)
        {
            j = Math.max(getChildAt(i).getMeasuredWidth(), j);
        }

        int k = 0;
        i = 0;
        while (k < l) 
        {
            View view = getChildAt(k);
            if (view != null && view.getVisibility() != 8)
            {
                android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)view.getLayoutParams();
                int i1;
                if (layoutparams.weight > 0.0F)
                {
                    view.measure(android.view.View.MeasureSpec.makeMeasureSpec(j, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0x40000000));
                    i += j;
                } else
                {
                    i += view.getMeasuredWidth();
                }
                i1 = layoutparams.leftMargin;
                i = layoutparams.rightMargin + i1 + i;
            }
            k++;
        }
        setMeasuredDimension(getPaddingLeft() + getPaddingRight() + i, getMeasuredHeight());
    }

    public boolean isMeasureWithLargestChildEnabled()
    {
        return mUseLargestChild;
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        if (getChildCount() > 2)
        {
            i = android.view.View.MeasureSpec.getMode(i);
            if (mUseLargestChild && i == 0 && getOrientation() == 0)
            {
                useLargestChildHorizontal();
                return;
            }
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean flag)
    {
        mUseLargestChild = flag;
    }

}
