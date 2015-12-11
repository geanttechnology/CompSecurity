// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.lang.reflect.Field;

public class WrapContentLinearLayoutManager extends LinearLayoutManager
{

    private static final int CHILD_HEIGHT = 1;
    private static final int CHILD_WIDTH = 0;
    private static final int DEFAULT_CHILD_SIZE = 100;
    private static boolean canMakeInsetsDirty = true;
    private static Field insetsDirtyField = null;
    private final int childDimensions[];
    private int childSize;
    private final Rect tmpRect;

    public WrapContentLinearLayoutManager(Context context)
    {
        super(context);
        childDimensions = new int[2];
        childSize = 100;
        tmpRect = new Rect();
    }

    public WrapContentLinearLayoutManager(Context context, int i, boolean flag)
    {
        super(context, i, flag);
        childDimensions = new int[2];
        childSize = 100;
        tmpRect = new Rect();
    }

    public WrapContentLinearLayoutManager(RecyclerView recyclerview)
    {
        super(recyclerview.getContext());
        childDimensions = new int[2];
        childSize = 100;
        tmpRect = new Rect();
    }

    public WrapContentLinearLayoutManager(RecyclerView recyclerview, int i, boolean flag)
    {
        super(recyclerview.getContext(), i, flag);
        childDimensions = new int[2];
        childSize = 100;
        tmpRect = new Rect();
    }

    private void initChildDimensions(int i, int j, boolean flag)
    {
        if (childDimensions[0] != 0 || childDimensions[1] != 0)
        {
            return;
        }
        if (flag)
        {
            childDimensions[0] = i;
            childDimensions[1] = childSize;
            return;
        } else
        {
            childDimensions[0] = childSize;
            childDimensions[1] = j;
            return;
        }
    }

    private static void makeInsetsDirty(android.support.v7.widget.RecyclerView.LayoutParams layoutparams)
    {
        if (!canMakeInsetsDirty)
        {
            return;
        }
        try
        {
            if (insetsDirtyField == null)
            {
                insetsDirtyField = android/support/v7/widget/RecyclerView$LayoutParams.getDeclaredField("mInsetsDirty");
                insetsDirtyField.setAccessible(true);
            }
            insetsDirtyField.set(layoutparams, Boolean.valueOf(true));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (android.support.v7.widget.RecyclerView.LayoutParams layoutparams)
        {
            canMakeInsetsDirty = false;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (android.support.v7.widget.RecyclerView.LayoutParams layoutparams)
        {
            canMakeInsetsDirty = false;
        }
    }

    public static int makeUnspecifiedSpec()
    {
        return android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
    }

    private void measureChild(android.support.v7.widget.RecyclerView.Recycler recycler, int i, int j, int k, int ai[])
    {
        View view;
        android.support.v7.widget.RecyclerView.LayoutParams layoutparams;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        try
        {
            view = recycler.getViewForPosition(i);
        }
        // Misplaced declaration of an exception variable
        catch (android.support.v7.widget.RecyclerView.Recycler recycler)
        {
            return;
        }
        layoutparams = (android.support.v7.widget.RecyclerView.LayoutParams)view.getLayoutParams();
        i = getPaddingLeft();
        l = getPaddingRight();
        i1 = getPaddingTop();
        j1 = getPaddingBottom();
        k1 = layoutparams.leftMargin;
        l1 = layoutparams.rightMargin;
        i2 = layoutparams.topMargin;
        j2 = layoutparams.bottomMargin;
        makeInsetsDirty(layoutparams);
        calculateItemDecorationsForChild(view, tmpRect);
        k2 = getRightDecorationWidth(view);
        l2 = getLeftDecorationWidth(view);
        i3 = getTopDecorationHeight(view);
        j3 = getBottomDecorationHeight(view);
        view.measure(getChildMeasureSpec(j, i + l + (k1 + l1) + (k2 + l2), layoutparams.width, canScrollHorizontally()), getChildMeasureSpec(k, i1 + j1 + (i2 + j2) + (i3 + j3), layoutparams.height, canScrollVertically()));
        ai[0] = getDecoratedMeasuredWidth(view) + layoutparams.leftMargin + layoutparams.rightMargin;
        ai[1] = getDecoratedMeasuredHeight(view) + layoutparams.bottomMargin + layoutparams.topMargin;
        makeInsetsDirty(layoutparams);
        recycler.recycleView(view);
    }

    public void onMeasure(android.support.v7.widget.RecyclerView.Recycler recycler, android.support.v7.widget.RecyclerView.State state, int i, int j)
    {
        int k;
        int l;
        boolean flag;
        boolean flag1;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        l = android.view.View.MeasureSpec.getMode(i);
        k = android.view.View.MeasureSpec.getMode(j);
        k1 = android.view.View.MeasureSpec.getSize(i);
        j1 = android.view.View.MeasureSpec.getSize(j);
        boolean flag2;
        boolean flag3;
        if (l != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (k != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (l == 0x40000000)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if (k == 0x40000000)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        l1 = makeUnspecifiedSpec();
        if (flag3 && flag2)
        {
            super.onMeasure(recycler, state, i, j);
            return;
        }
        int j2;
        boolean flag4;
        if (getOrientation() == 1)
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
        initChildDimensions(k1, j1, flag4);
        j = 0;
        i = 0;
        recycler.clear();
        i2 = state.getItemCount();
        j2 = getItemCount();
        i1 = 0;
_L7:
        k = i;
        l = j;
        if (i1 >= j2) goto _L2; else goto _L1
_L1:
        if (!flag4) goto _L4; else goto _L3
_L3:
        if (i1 < i2)
        {
            measureChild(recycler, i1, k1, l1, childDimensions);
        }
        i += childDimensions[1];
        if (i1 == 0)
        {
            j = childDimensions[0];
        }
        l = i;
        k = j;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_360;
        }
        l = i;
        k = j;
        if (i < j1)
        {
            break MISSING_BLOCK_LABEL_360;
        }
        l = j;
        k = i;
_L2:
        if (flag3)
        {
            i = k1;
        } else
        {
            j = l + (getPaddingLeft() + getPaddingRight());
            i = j;
            if (flag1)
            {
                i = Math.min(j, k1);
            }
        }
        if (flag2)
        {
            j = j1;
        } else
        {
            k += getPaddingTop() + getPaddingBottom();
            j = k;
            if (flag)
            {
                j = Math.min(k, j1);
            }
        }
        setMeasuredDimension(i, j);
        return;
_L4:
        if (i1 < i2)
        {
            measureChild(recycler, i1, l1, j1, childDimensions);
        }
        j += childDimensions[0];
        if (i1 == 0)
        {
            i = childDimensions[1];
        }
        l = i;
        k = j;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_360;
        }
        k = i;
        l = j;
        if (j >= k1) goto _L2; else goto _L5
_L5:
        k = j;
        l = i;
        i1++;
        i = l;
        j = k;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void setOrientation(int i)
    {
        if (childDimensions != null && getOrientation() != i)
        {
            childDimensions[0] = 0;
            childDimensions[1] = 0;
        }
        super.setOrientation(i);
    }

}
