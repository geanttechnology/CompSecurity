// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.actionbarsherlock.internal.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.actionbarsherlock.internal.widget.IcsLinearLayout;

// Referenced classes of package com.actionbarsherlock.internal.view.menu:
//            MenuView, ActionMenuItemView, MenuBuilder, ActionMenuPresenter, 
//            MenuItemImpl

public class ActionMenuView extends IcsLinearLayout
    implements MenuBuilder.ItemInvoker, MenuView
{

    static final int GENERATED_ITEM_PADDING = 4;
    private static final boolean IS_FROYO;
    static final int MIN_CELL_SIZE = 56;
    private boolean mFirst;
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mGeneratedItemPadding;
    private MenuBuilder mMenu;
    private int mMinCellSize;
    private ActionMenuPresenter mPresenter;
    private boolean mReserveOverflow;

    public ActionMenuView(Context context)
    {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mFirst = true;
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        mMinCellSize = (int)(56F * f);
        mGeneratedItemPadding = (int)(f * 4F);
    }

    static int measureChildForCells(View view, int i, int j, int k, int l)
    {
        boolean flag1 = false;
        LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
        k = android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.MeasureSpec.getSize(k) - l, android.view.View.MeasureSpec.getMode(k));
        ActionMenuItemView actionmenuitemview;
        boolean flag;
        if (j > 0)
        {
            view.measure(android.view.View.MeasureSpec.makeMeasureSpec(i * j, 0x80000000), k);
            l = view.getMeasuredWidth();
            j = l / i;
            if (l % i != 0)
            {
                j++;
            }
        } else
        {
            j = 0;
        }
        if (view instanceof ActionMenuItemView)
        {
            actionmenuitemview = (ActionMenuItemView)view;
        } else
        {
            actionmenuitemview = null;
        }
        flag = flag1;
        if (!layoutparams.isOverflowButton)
        {
            flag = flag1;
            if (actionmenuitemview != null)
            {
                flag = flag1;
                if (actionmenuitemview.hasText())
                {
                    flag = true;
                }
            }
        }
        layoutparams.expandable = flag;
        layoutparams.cellsUsed = j;
        view.measure(android.view.View.MeasureSpec.makeMeasureSpec(j * i, 0x40000000), k);
        return j;
    }

    private void onMeasureExactFormat(int i, int j)
    {
        int l3 = android.view.View.MeasureSpec.getMode(j);
        i = android.view.View.MeasureSpec.getSize(i);
        int k3 = android.view.View.MeasureSpec.getSize(j);
        int k = getPaddingLeft();
        int l = getPaddingRight();
        int l4 = getPaddingTop() + getPaddingBottom();
        int i4 = i - (k + l);
        i = i4 / mMinCellSize;
        k = mMinCellSize;
        if (i == 0)
        {
            setMeasuredDimension(i4, 0);
            return;
        }
        int j4 = mMinCellSize + (i4 % k) / i;
        k = 0;
        int l1 = 0;
        int k1 = 0;
        int i2 = 0;
        int j1 = 0;
        long l5 = 0L;
        int k4 = getChildCount();
        int j2 = 0;
        while (j2 < k4) 
        {
            Object obj = getChildAt(j2);
            int i1;
            if (((View) (obj)).getVisibility() != 8)
            {
                boolean flag = obj instanceof ActionMenuItemView;
                i2++;
                if (flag)
                {
                    ((View) (obj)).setPadding(mGeneratedItemPadding, 0, mGeneratedItemPadding, 0);
                }
                LayoutParams layoutparams = (LayoutParams)((View) (obj)).getLayoutParams();
                layoutparams.expanded = false;
                layoutparams.extraPixels = 0;
                layoutparams.cellsUsed = 0;
                layoutparams.expandable = false;
                layoutparams.leftMargin = 0;
                layoutparams.rightMargin = 0;
                int k2;
                int i3;
                if (flag && ((ActionMenuItemView)obj).hasText())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                layoutparams.preventEdgeOffset = flag;
                if (layoutparams.isOverflowButton)
                {
                    i1 = 1;
                } else
                {
                    i1 = i;
                }
                i3 = measureChildForCells(((View) (obj)), j4, i1, j, l4);
                l1 = Math.max(l1, i3);
                float f;
                float f1;
                float f2;
                int j3;
                long l7;
                long l8;
                if (layoutparams.expandable)
                {
                    i1 = k1 + 1;
                } else
                {
                    i1 = k1;
                }
                if (layoutparams.isOverflowButton)
                {
                    j1 = 1;
                }
                k2 = i - i3;
                k1 = Math.max(k, ((View) (obj)).getMeasuredHeight());
                if (i3 == 1)
                {
                    long l6 = 1 << j2;
                    i = k1;
                    k1 = i1;
                    i3 = j1;
                    l5 = l6 | l5;
                    k = l1;
                    j1 = k2;
                    i1 = i;
                    l1 = i3;
                    i = i2;
                } else
                {
                    i = i2;
                    k = l1;
                    i2 = k1;
                    k1 = i1;
                    l1 = j1;
                    i1 = i2;
                    j1 = k2;
                }
            } else
            {
                int l2 = i2;
                i1 = k;
                i2 = i;
                k = l1;
                i = l2;
                l1 = j1;
                j1 = i2;
            }
            j2++;
            i2 = i;
            i = j1;
            j1 = l1;
            l1 = k;
            k = i1;
        }
        if (j1 != 0 && i2 == 2)
        {
            k2 = 1;
        } else
        {
            k2 = 0;
        }
        j = 0;
        j2 = i;
        i = j;
        l8 = l5;
        if (k1 <= 0) goto _L2; else goto _L1
_L1:
        l8 = l5;
        if (j2 <= 0) goto _L2; else goto _L3
_L3:
        j = 0x7fffffff;
        l7 = 0L;
        i1 = 0;
        i3 = 0;
_L10:
        if (i3 >= k4) goto _L5; else goto _L4
_L4:
        obj = (LayoutParams)getChildAt(i3).getLayoutParams();
        if (!((LayoutParams) (obj)).expandable) goto _L7; else goto _L6
_L6:
        if (((LayoutParams) (obj)).cellsUsed >= j) goto _L9; else goto _L8
_L8:
        i1 = ((LayoutParams) (obj)).cellsUsed;
        l7 = 1 << i3;
        j = 1;
_L12:
        j3 = i3 + 1;
        i3 = i1;
        i1 = j;
        j = i3;
        i3 = j3;
          goto _L10
_L9:
        if (((LayoutParams) (obj)).cellsUsed != j) goto _L7; else goto _L11
_L11:
        l7 |= 1 << i3;
        j3 = i1 + 1;
        i1 = j;
        j = j3;
          goto _L12
_L5:
        l5 |= l7;
        l8 = l5;
        if (i1 <= j2)
        {
            i = j2;
            i1 = 0;
            while (i1 < k4) 
            {
                obj = getChildAt(i1);
                layoutparams = (LayoutParams)((View) (obj)).getLayoutParams();
                if (((long)(1 << i1) & l7) == 0L)
                {
                    if (layoutparams.cellsUsed == j + 1)
                    {
                        l5 |= 1 << i1;
                    }
                } else
                {
                    if (k2 != 0 && layoutparams.preventEdgeOffset && i == 1)
                    {
                        ((View) (obj)).setPadding(mGeneratedItemPadding + j4, 0, mGeneratedItemPadding, 0);
                    }
                    layoutparams.cellsUsed = layoutparams.cellsUsed + 1;
                    layoutparams.expanded = true;
                    i--;
                }
                i1++;
            }
            j = 1;
            j2 = i;
            i = j;
            break MISSING_BLOCK_LABEL_432;
        }
_L2:
        if (j1 == 0 && i2 == 1)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (j2 <= 0 || l8 == 0L || j2 >= i2 - 1 && j == 0 && l1 <= 1) goto _L14; else goto _L13
_L13:
        f2 = Long.bitCount(l8);
        f1 = f2;
        if (j != 0) goto _L16; else goto _L15
_L15:
        f = f2;
        if ((1L & l8) != 0L)
        {
            f = f2;
            if (!((LayoutParams)getChildAt(0).getLayoutParams()).preventEdgeOffset)
            {
                f = f2 - 0.5F;
            }
        }
        f1 = f;
        if (((long)(1 << k4 - 1) & l8) == 0L) goto _L16; else goto _L17
_L17:
        f1 = f;
        if (((LayoutParams)getChildAt(k4 - 1).getLayoutParams()).preventEdgeOffset) goto _L16; else goto _L18
_L18:
        f -= 0.5F;
_L20:
        if (f > 0.0F)
        {
            j = (int)((float)(j2 * j4) / f);
        } else
        {
            j = 0;
        }
        i1 = 0;
        do
        {
            j1 = i;
            if (i1 >= k4)
            {
                break;
            }
            if (((long)(1 << i1) & l8) != 0L)
            {
                obj = getChildAt(i1);
                layoutparams = (LayoutParams)((View) (obj)).getLayoutParams();
                if (obj instanceof ActionMenuItemView)
                {
                    layoutparams.extraPixels = j;
                    layoutparams.expanded = true;
                    if (i1 == 0 && !layoutparams.preventEdgeOffset)
                    {
                        layoutparams.leftMargin = -j / 2;
                    }
                    i = 1;
                } else
                if (layoutparams.isOverflowButton)
                {
                    layoutparams.extraPixels = j;
                    layoutparams.expanded = true;
                    layoutparams.rightMargin = -j / 2;
                    i = 1;
                } else
                {
                    if (i1 != 0)
                    {
                        layoutparams.leftMargin = j / 2;
                    }
                    if (i1 != k4 - 1)
                    {
                        layoutparams.rightMargin = j / 2;
                    }
                }
            }
            i1++;
        } while (true);
          goto _L19
_L14:
        j1 = i;
_L19:
        if (j1 != 0)
        {
            j = android.view.View.MeasureSpec.makeMeasureSpec(k3 - l4, l3);
            for (i = 0; i < k4; i++)
            {
                obj = getChildAt(i);
                layoutparams = (LayoutParams)((View) (obj)).getLayoutParams();
                if (layoutparams.expanded)
                {
                    i1 = layoutparams.cellsUsed;
                    ((View) (obj)).measure(android.view.View.MeasureSpec.makeMeasureSpec(layoutparams.extraPixels + i1 * j4, 0x40000000), j);
                }
            }

        }
        if (l3 == 0x40000000)
        {
            k = k3;
        }
        setMeasuredDimension(i4, k);
        return;
_L16:
        f = f1;
        if (true) goto _L20; else goto _L7
_L7:
        j3 = j;
        j = i1;
        i1 = j3;
          goto _L12
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams != null && (layoutparams instanceof LayoutParams);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        return false;
    }

    protected volatile android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return generateDefaultLayoutParams();
    }

    protected volatile android.widget.LinearLayout.LayoutParams generateDefaultLayoutParams()
    {
        return generateDefaultLayoutParams();
    }

    protected LayoutParams generateDefaultLayoutParams()
    {
        LayoutParams layoutparams = new LayoutParams(-2, -2);
        layoutparams.gravity = 16;
        return layoutparams;
    }

    public volatile android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return generateLayoutParams(attributeset);
    }

    protected volatile android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return generateLayoutParams(layoutparams);
    }

    public volatile android.widget.LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return generateLayoutParams(attributeset);
    }

    protected volatile android.widget.LinearLayout.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return generateLayoutParams(layoutparams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new LayoutParams(getContext(), attributeset);
    }

    protected LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (layoutparams instanceof LayoutParams)
        {
            layoutparams = new LayoutParams((LayoutParams)layoutparams);
            if (((LayoutParams) (layoutparams)).gravity <= 0)
            {
                layoutparams.gravity = 16;
            }
            return layoutparams;
        } else
        {
            return generateDefaultLayoutParams();
        }
    }

    public LayoutParams generateOverflowButtonLayoutParams()
    {
        LayoutParams layoutparams = generateDefaultLayoutParams();
        layoutparams.isOverflowButton = true;
        return layoutparams;
    }

    public int getWindowAnimations()
    {
        return 0;
    }

    protected boolean hasDividerBeforeChildAt(int i)
    {
        boolean flag1 = false;
        if (i == 0)
        {
            return false;
        }
        View view = getChildAt(i - 1);
        View view1 = getChildAt(i);
        boolean flag = flag1;
        if (i < getChildCount())
        {
            flag = flag1;
            if (view instanceof ActionMenuChildView)
            {
                flag = ((ActionMenuChildView)view).needsDividerAfter() | false;
            }
        }
        if (i > 0 && (view1 instanceof ActionMenuChildView))
        {
            return ((ActionMenuChildView)view1).needsDividerBefore() | flag;
        } else
        {
            return flag;
        }
    }

    public void initialize(MenuBuilder menubuilder)
    {
        mMenu = menubuilder;
    }

    public boolean invokeItem(MenuItemImpl menuitemimpl)
    {
        return mMenu.performItemAction(menuitemimpl, 0);
    }

    public boolean isExpandedFormat()
    {
        return mFormatItems;
    }

    public boolean isOverflowReserved()
    {
        return mReserveOverflow;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (IS_FROYO)
        {
            super.onConfigurationChanged(configuration);
        }
        mPresenter.updateMenuView(false);
        if (mPresenter != null && mPresenter.isOverflowMenuShowing())
        {
            mPresenter.hideOverflowMenu();
            mPresenter.showOverflowMenu();
        }
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        mPresenter.dismissPopupMenus();
    }

    protected void onDraw(Canvas canvas)
    {
        if (!IS_FROYO && mFirst)
        {
            mFirst = false;
            requestLayout();
            return;
        } else
        {
            super.onDraw(canvas);
            return;
        }
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        if (!mFormatItems)
        {
            super.onLayout(flag, i, j, k, l);
        } else
        {
            int k3 = getChildCount();
            int j3 = (j + l) / 2;
            j = 0;
            int i1 = k - i - getPaddingRight() - getPaddingLeft();
            l = 0;
            int j1 = 0;
            while (j1 < k3) 
            {
                View view = getChildAt(j1);
                LayoutParams layoutparams1;
                if (view.getVisibility() != 8)
                {
                    LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
                    int l1;
                    if (layoutparams.isOverflowButton)
                    {
                        int k1 = view.getMeasuredWidth();
                        l = k1;
                        if (hasDividerBeforeChildAt(j1))
                        {
                            l = k1 + 0;
                        }
                        k1 = view.getMeasuredHeight();
                        int k2 = getWidth() - getPaddingRight() - layoutparams.rightMargin;
                        int l3 = j3 - k1 / 2;
                        view.layout(k2 - l, l3, k2, k1 + l3);
                        k1 = i1 - l;
                        i1 = 1;
                        l = j;
                        j = k1;
                    } else
                    {
                        int i2 = view.getMeasuredWidth();
                        int l2 = layoutparams.leftMargin;
                        i2 = i1 - (layoutparams.rightMargin + (i2 + l2));
                        l2 = j + 1;
                        i1 = l;
                        j = i2;
                        l = l2;
                    }
                } else
                {
                    int j2 = j;
                    int i3 = l;
                    j = i1;
                    l = j2;
                    i1 = i3;
                }
                l1 = j1 + 1;
                j1 = i1;
                i1 = j;
                j = l;
                l = j1;
                j1 = l1;
            }
            if (k3 == 1 && l == 0)
            {
                view = getChildAt(0);
                j = view.getMeasuredWidth();
                l = view.getMeasuredHeight();
                i = (k - i) / 2 - j / 2;
                k = j3 - l / 2;
                view.layout(i, k, j + i, l + k);
                return;
            }
            if (l != 0)
            {
                i = 0;
            } else
            {
                i = 1;
            }
            i = j - i;
            if (i > 0)
            {
                i = i1 / i;
            } else
            {
                i = 0;
            }
            k = Math.max(0, i);
            i = getPaddingLeft();
            j = 0;
            while (j < k3) 
            {
                view = getChildAt(j);
                layoutparams1 = (LayoutParams)view.getLayoutParams();
                if (view.getVisibility() != 8 && !layoutparams1.isOverflowButton)
                {
                    i += layoutparams1.leftMargin;
                    l = view.getMeasuredWidth();
                    i1 = view.getMeasuredHeight();
                    j1 = j3 - i1 / 2;
                    view.layout(i, j1, i + l, i1 + j1);
                    i = layoutparams1.rightMargin + l + k + i;
                }
                j++;
            }
        }
    }

    protected void onMeasure(int i, int j)
    {
        boolean flag1 = mFormatItems;
        int k;
        boolean flag;
        if (android.view.View.MeasureSpec.getMode(i) == 0x40000000)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mFormatItems = flag;
        if (flag1 != mFormatItems)
        {
            mFormatItemsWidth = 0;
        }
        k = android.view.View.MeasureSpec.getMode(i);
        if (mFormatItems && mMenu != null && k != mFormatItemsWidth)
        {
            mFormatItemsWidth = k;
            mMenu.onItemsChanged(true);
        }
        if (mFormatItems)
        {
            onMeasureExactFormat(i, j);
            return;
        } else
        {
            super.onMeasure(i, j);
            return;
        }
    }

    public void setOverflowReserved(boolean flag)
    {
        mReserveOverflow = flag;
    }

    public void setPresenter(ActionMenuPresenter actionmenupresenter)
    {
        mPresenter = actionmenupresenter;
    }

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        IS_FROYO = flag;
    }

    private class LayoutParams extends android.widget.LinearLayout.LayoutParams
    {

        public int cellsUsed;
        public boolean expandable;
        public boolean expanded;
        public int extraPixels;
        public boolean isOverflowButton;
        public boolean preventEdgeOffset;

        public LayoutParams(int i, int j)
        {
            super(i, j);
            isOverflowButton = false;
        }

        public LayoutParams(int i, int j, boolean flag)
        {
            super(i, j);
            isOverflowButton = flag;
        }

        public LayoutParams(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
        }

        public LayoutParams(LayoutParams layoutparams)
        {
            super(layoutparams);
            isOverflowButton = layoutparams.isOverflowButton;
        }
    }


    private class ActionMenuChildView
    {

        public abstract boolean needsDividerAfter();

        public abstract boolean needsDividerBefore();
    }

}
