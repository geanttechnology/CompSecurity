// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.picsart.studio.view:
//            d

public class FlowLayout extends ViewGroup
{

    private static boolean b;
    private int a;

    public FlowLayout(Context context)
    {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams instanceof d;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new d(1, 1);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        int l1 = getChildCount();
        l = getPaddingLeft();
        j = getPaddingTop();
        for (int j1 = 0; j1 < l1;)
        {
            View view = getChildAt(j1);
            int i1 = j;
            int k1 = l;
            if (view.getVisibility() != 8)
            {
                int i2 = view.getMeasuredWidth();
                int j2 = view.getMeasuredHeight();
                d d1 = (d)view.getLayoutParams();
                i1 = j;
                k1 = l;
                if (l + i2 > k - i)
                {
                    k1 = getPaddingLeft();
                    i1 = j + a;
                }
                view.layout(k1, i1, k1 + i2, j2 + i1);
                k1 += d1.a + i2;
            }
            j1++;
            j = i1;
            l = k1;
        }

    }

    protected void onMeasure(int i, int j)
    {
        if (!b && android.view.View.MeasureSpec.getMode(i) == 0)
        {
            throw new AssertionError();
        }
        int j2 = android.view.View.MeasureSpec.getSize(i) - getPaddingLeft() - getPaddingRight();
        int l1 = android.view.View.MeasureSpec.getSize(j) - getPaddingTop() - getPaddingBottom();
        int k2 = getChildCount();
        int l = 0;
        int k = getPaddingLeft();
        i = getPaddingTop();
        int i1;
        int j1;
        if (android.view.View.MeasureSpec.getMode(j) == 0x80000000)
        {
            i1 = android.view.View.MeasureSpec.makeMeasureSpec(l1, 0x80000000);
        } else
        {
            i1 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        for (j1 = 0; j1 < k2; j1++)
        {
            View view = getChildAt(j1);
            if (view.getVisibility() == 8)
            {
                continue;
            }
            d d1 = (d)view.getLayoutParams();
            view.measure(android.view.View.MeasureSpec.makeMeasureSpec(j2, 0x80000000), i1);
            int l2 = view.getMeasuredWidth();
            int i2 = Math.max(l, view.getMeasuredHeight() + d1.b);
            l = i;
            int k1 = k;
            if (k + l2 > j2)
            {
                k1 = getPaddingLeft();
                l = i + i2;
            }
            k = k1 + (d1.a + l2);
            k1 = i2;
            i = l;
            l = k1;
        }

        a = l;
        if (android.view.View.MeasureSpec.getMode(j) == 0)
        {
            i += l;
        } else
        if (android.view.View.MeasureSpec.getMode(j) == 0x80000000 && i + l < l1)
        {
            i += l;
        } else
        {
            i = l1;
        }
        setMeasuredDimension(j2, i);
    }

    static 
    {
        boolean flag;
        if (!com/picsart/studio/view/FlowLayout.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b = flag;
    }
}
