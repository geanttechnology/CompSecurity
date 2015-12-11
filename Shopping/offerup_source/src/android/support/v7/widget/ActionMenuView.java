// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.internal.view.menu.i;
import android.support.v7.internal.view.menu.j;
import android.support.v7.internal.view.menu.k;
import android.support.v7.internal.view.menu.m;
import android.support.v7.internal.view.menu.y;
import android.support.v7.internal.view.menu.z;
import android.support.v7.internal.widget.ViewUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package android.support.v7.widget:
//            LinearLayoutCompat, ActionMenuPresenter

public class ActionMenuView extends LinearLayoutCompat
    implements k, z
{

    private y mActionMenuPresenterCallback;
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mGeneratedItemPadding;
    private i mMenu;
    private j mMenuBuilderCallback;
    private int mMinCellSize;
    private OnMenuItemClickListener mOnMenuItemClickListener;
    private Context mPopupContext;
    private int mPopupTheme;
    private ActionMenuPresenter mPresenter;
    private boolean mReserveOverflow;

    public ActionMenuView(Context context)
    {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        mMinCellSize = (int)(56F * f);
        mGeneratedItemPadding = (int)(f * 4F);
        mPopupContext = context;
        mPopupTheme = 0;
    }

    static int measureChildForCells(View view, int j, int l, int i1, int j1)
    {
        boolean flag1 = false;
        LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
        int k1 = android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.MeasureSpec.getSize(i1) - j1, android.view.View.MeasureSpec.getMode(i1));
        ActionMenuItemView actionmenuitemview;
        boolean flag;
        if (view instanceof ActionMenuItemView)
        {
            actionmenuitemview = (ActionMenuItemView)view;
        } else
        {
            actionmenuitemview = null;
        }
        if (actionmenuitemview != null && actionmenuitemview.b())
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (l > 0 && (j1 == 0 || l >= 2))
        {
            view.measure(android.view.View.MeasureSpec.makeMeasureSpec(j * l, 0x80000000), k1);
            int l1 = view.getMeasuredWidth();
            i1 = l1 / j;
            l = i1;
            if (l1 % j != 0)
            {
                l = i1 + 1;
            }
            i1 = l;
            if (j1 != 0)
            {
                i1 = l;
                if (l < 2)
                {
                    i1 = 2;
                }
            }
        } else
        {
            i1 = 0;
        }
        flag = flag1;
        if (!layoutparams.isOverflowButton)
        {
            flag = flag1;
            if (j1 != 0)
            {
                flag = true;
            }
        }
        layoutparams.expandable = flag;
        layoutparams.cellsUsed = i1;
        view.measure(android.view.View.MeasureSpec.makeMeasureSpec(i1 * j, 0x40000000), k1);
        return i1;
    }

    private void onMeasureExactFormat(int j, int l)
    {
        int j4 = android.view.View.MeasureSpec.getMode(l);
        j = android.view.View.MeasureSpec.getSize(j);
        int i4 = android.view.View.MeasureSpec.getSize(l);
        int i1 = getPaddingLeft();
        int k1 = getPaddingRight();
        int k3 = getPaddingTop() + getPaddingBottom();
        int k4 = getChildMeasureSpec(l, k3, -2);
        int l4 = j - (i1 + k1);
        j = l4 / mMinCellSize;
        l = mMinCellSize;
        if (j == 0)
        {
            setMeasuredDimension(l4, 0);
            return;
        }
        int i5 = mMinCellSize + (l4 % l) / j;
        l = 0;
        int k2 = 0;
        int j2 = 0;
        int l2 = 0;
        int i2 = 0;
        long l5 = 0L;
        int j5 = getChildCount();
        int i3 = 0;
        while (i3 < j5) 
        {
            Object obj = getChildAt(i3);
            int j1;
            int l1;
            if (((View) (obj)).getVisibility() != 8)
            {
                boolean flag = obj instanceof ActionMenuItemView;
                l2++;
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
                int j3;
                if (flag && ((ActionMenuItemView)obj).b())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                layoutparams.preventEdgeOffset = flag;
                if (layoutparams.isOverflowButton)
                {
                    j1 = 1;
                } else
                {
                    j1 = j;
                }
                j3 = measureChildForCells(((View) (obj)), i5, j1, k4, k3);
                k2 = Math.max(k2, j3);
                float f;
                float f1;
                float f2;
                int l3;
                long l7;
                long l8;
                if (layoutparams.expandable)
                {
                    j1 = j2 + 1;
                } else
                {
                    j1 = j2;
                }
                if (layoutparams.isOverflowButton)
                {
                    l1 = 1;
                } else
                {
                    l1 = i2;
                }
                j -= j3;
                j2 = Math.max(l, ((View) (obj)).getMeasuredHeight());
                if (j3 == 1)
                {
                    long l6 = 1 << i3;
                    l = j2;
                    i2 = j;
                    j2 = j1;
                    j3 = l1;
                    l5 = l6 | l5;
                    j = l2;
                    l1 = i2;
                    j1 = l;
                    i2 = j3;
                    l = k2;
                } else
                {
                    l = l2;
                    i2 = k2;
                    k2 = j2;
                    l2 = j;
                    j = l;
                    l = i2;
                    j2 = j1;
                    i2 = l1;
                    j1 = k2;
                    l1 = l2;
                }
            } else
            {
                j1 = l;
                l1 = j;
                l = k2;
                j = l2;
            }
            i3++;
            l2 = j;
            j = l1;
            k2 = l;
            l = j1;
        }
        if (i2 != 0 && l2 == 2)
        {
            j3 = 1;
        } else
        {
            j3 = 0;
        }
        j1 = 0;
        i3 = j;
        j = j1;
        l8 = l5;
        if (j2 <= 0) goto _L2; else goto _L1
_L1:
        l8 = l5;
        if (i3 <= 0) goto _L2; else goto _L3
_L3:
        j1 = 0x7fffffff;
        l7 = 0L;
        l1 = 0;
        k3 = 0;
_L10:
        if (k3 >= j5) goto _L5; else goto _L4
_L4:
        obj = (LayoutParams)getChildAt(k3).getLayoutParams();
        if (!((LayoutParams) (obj)).expandable) goto _L7; else goto _L6
_L6:
        if (((LayoutParams) (obj)).cellsUsed >= j1) goto _L9; else goto _L8
_L8:
        l1 = ((LayoutParams) (obj)).cellsUsed;
        l7 = 1 << k3;
        j1 = 1;
_L12:
        l3 = k3 + 1;
        k3 = l1;
        l1 = j1;
        j1 = k3;
        k3 = l3;
          goto _L10
_L9:
        if (((LayoutParams) (obj)).cellsUsed != j1) goto _L7; else goto _L11
_L11:
        l7 |= 1 << k3;
        l3 = l1 + 1;
        l1 = j1;
        j1 = l3;
          goto _L12
_L5:
        l5 |= l7;
        l8 = l5;
        if (l1 <= i3)
        {
            l1 = 0;
            j = i3;
            while (l1 < j5) 
            {
                obj = getChildAt(l1);
                layoutparams = (LayoutParams)((View) (obj)).getLayoutParams();
                if (((long)(1 << l1) & l7) == 0L)
                {
                    if (layoutparams.cellsUsed == j1 + 1)
                    {
                        l5 |= 1 << l1;
                    }
                } else
                {
                    if (j3 && layoutparams.preventEdgeOffset && j == 1)
                    {
                        ((View) (obj)).setPadding(mGeneratedItemPadding + i5, 0, mGeneratedItemPadding, 0);
                    }
                    layoutparams.cellsUsed = layoutparams.cellsUsed + 1;
                    layoutparams.expanded = true;
                    j--;
                }
                l1++;
            }
            j1 = 1;
            i3 = j;
            j = j1;
            break MISSING_BLOCK_LABEL_436;
        }
_L2:
        if (i2 == 0 && l2 == 1)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (i3 <= 0 || l8 == 0L || i3 >= l2 - 1 && j1 == 0 && k2 <= 1) goto _L14; else goto _L13
_L13:
        f2 = Long.bitCount(l8);
        f1 = f2;
        if (j1 != 0) goto _L16; else goto _L15
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
        if (((long)(1 << j5 - 1) & l8) == 0L) goto _L16; else goto _L17
_L17:
        f1 = f;
        if (((LayoutParams)getChildAt(j5 - 1).getLayoutParams()).preventEdgeOffset) goto _L16; else goto _L18
_L18:
        f -= 0.5F;
_L20:
        if (f > 0.0F)
        {
            j1 = (int)((float)(i3 * i5) / f);
        } else
        {
            j1 = 0;
        }
        l1 = 0;
        do
        {
            i2 = j;
            if (l1 >= j5)
            {
                break;
            }
            if (((long)(1 << l1) & l8) != 0L)
            {
                obj = getChildAt(l1);
                layoutparams = (LayoutParams)((View) (obj)).getLayoutParams();
                if (obj instanceof ActionMenuItemView)
                {
                    layoutparams.extraPixels = j1;
                    layoutparams.expanded = true;
                    if (l1 == 0 && !layoutparams.preventEdgeOffset)
                    {
                        layoutparams.leftMargin = -j1 / 2;
                    }
                    j = 1;
                } else
                if (layoutparams.isOverflowButton)
                {
                    layoutparams.extraPixels = j1;
                    layoutparams.expanded = true;
                    layoutparams.rightMargin = -j1 / 2;
                    j = 1;
                } else
                {
                    if (l1 != 0)
                    {
                        layoutparams.leftMargin = j1 / 2;
                    }
                    if (l1 != j5 - 1)
                    {
                        layoutparams.rightMargin = j1 / 2;
                    }
                }
            }
            l1++;
        } while (true);
          goto _L19
_L14:
        i2 = j;
_L19:
        if (i2 != 0)
        {
            for (j = 0; j < j5; j++)
            {
                obj = getChildAt(j);
                layoutparams = (LayoutParams)((View) (obj)).getLayoutParams();
                if (layoutparams.expanded)
                {
                    j1 = layoutparams.cellsUsed;
                    ((View) (obj)).measure(android.view.View.MeasureSpec.makeMeasureSpec(layoutparams.extraPixels + j1 * i5, 0x40000000), k4);
                }
            }

        }
        if (j4 == 0x40000000)
        {
            l = i4;
        }
        setMeasuredDimension(l4, l);
        return;
_L16:
        f = f1;
        if (true) goto _L20; else goto _L7
_L7:
        l3 = j1;
        j1 = l1;
        l1 = l3;
          goto _L12
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams != null && (layoutparams instanceof LayoutParams);
    }

    public void dismissPopupMenus()
    {
        if (mPresenter != null)
        {
            mPresenter.dismissPopupMenus();
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams()
    {
        LayoutParams layoutparams = new LayoutParams(-2, -2);
        layoutparams.gravity = 16;
        return layoutparams;
    }

    protected volatile LinearLayoutCompat.LayoutParams generateDefaultLayoutParams()
    {
        return generateDefaultLayoutParams();
    }

    protected volatile android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return generateDefaultLayoutParams();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new LayoutParams(getContext(), attributeset);
    }

    protected LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (layoutparams != null)
        {
            if (layoutparams instanceof LayoutParams)
            {
                layoutparams = new LayoutParams((LayoutParams)layoutparams);
            } else
            {
                layoutparams = new LayoutParams(layoutparams);
            }
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

    public volatile LinearLayoutCompat.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return generateLayoutParams(attributeset);
    }

    protected volatile LinearLayoutCompat.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return generateLayoutParams(layoutparams);
    }

    public volatile android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return generateLayoutParams(attributeset);
    }

    protected volatile android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return generateLayoutParams(layoutparams);
    }

    public LayoutParams generateOverflowButtonLayoutParams()
    {
        LayoutParams layoutparams = generateDefaultLayoutParams();
        layoutparams.isOverflowButton = true;
        return layoutparams;
    }

    public Menu getMenu()
    {
        if (mMenu == null)
        {
            Object obj = getContext();
            mMenu = new i(((Context) (obj)));
            mMenu.a(new MenuBuilderCallback(null));
            mPresenter = new ActionMenuPresenter(((Context) (obj)));
            mPresenter.setReserveOverflow(true);
            ActionMenuPresenter actionmenupresenter = mPresenter;
            if (mActionMenuPresenterCallback != null)
            {
                obj = mActionMenuPresenterCallback;
            } else
            {
                obj = new ActionMenuPresenterCallback(null);
            }
            actionmenupresenter.setCallback(((y) (obj)));
            mMenu.a(mPresenter, mPopupContext);
            mPresenter.setMenuView(this);
        }
        return mMenu;
    }

    public Drawable getOverflowIcon()
    {
        getMenu();
        return mPresenter.getOverflowIcon();
    }

    public int getPopupTheme()
    {
        return mPopupTheme;
    }

    public int getWindowAnimations()
    {
        return 0;
    }

    protected boolean hasSupportDividerBeforeChildAt(int j)
    {
        boolean flag1 = false;
        if (j == 0)
        {
            return false;
        }
        View view = getChildAt(j - 1);
        View view1 = getChildAt(j);
        boolean flag = flag1;
        if (j < getChildCount())
        {
            flag = flag1;
            if (view instanceof ActionMenuChildView)
            {
                flag = ((ActionMenuChildView)view).needsDividerAfter() | false;
            }
        }
        if (j > 0 && (view1 instanceof ActionMenuChildView))
        {
            return ((ActionMenuChildView)view1).needsDividerBefore() | flag;
        } else
        {
            return flag;
        }
    }

    public boolean hideOverflowMenu()
    {
        return mPresenter != null && mPresenter.hideOverflowMenu();
    }

    public void initialize(i j)
    {
        mMenu = j;
    }

    public boolean invokeItem(m m)
    {
        return mMenu.a(m, 0);
    }

    public boolean isOverflowMenuShowPending()
    {
        return mPresenter != null && mPresenter.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing()
    {
        return mPresenter != null && mPresenter.isOverflowMenuShowing();
    }

    public boolean isOverflowReserved()
    {
        return mReserveOverflow;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            super.onConfigurationChanged(configuration);
        }
        if (mPresenter != null)
        {
            mPresenter.updateMenuView(false);
            if (mPresenter.isOverflowMenuShowing())
            {
                mPresenter.hideOverflowMenu();
                mPresenter.showOverflowMenu();
            }
        }
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    protected void onLayout(boolean flag, int j, int l, int i1, int j1)
    {
        if (mFormatItems) goto _L2; else goto _L1
_L1:
        super.onLayout(flag, j, l, i1, j1);
_L4:
        return;
_L2:
        int k3 = getChildCount();
        int j3 = (j1 - l) / 2;
        int l3 = getDividerWidth();
        l = 0;
        j1 = i1 - j - getPaddingRight() - getPaddingLeft();
        int l1 = 0;
        flag = ViewUtils.isLayoutRtl(this);
        int k1 = 0;
        while (k1 < k3) 
        {
            View view = getChildAt(k1);
            LayoutParams layoutparams1;
            if (view.getVisibility() != 8)
            {
                LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
                if (layoutparams.isOverflowButton)
                {
                    int i2 = view.getMeasuredWidth();
                    l1 = i2;
                    if (hasSupportDividerBeforeChildAt(k1))
                    {
                        l1 = i2 + l3;
                    }
                    int i4 = view.getMeasuredHeight();
                    int l2;
                    int j4;
                    if (flag)
                    {
                        i2 = getPaddingLeft();
                        i2 = layoutparams.leftMargin + i2;
                        l2 = i2 + l1;
                    } else
                    {
                        l2 = getWidth() - getPaddingRight() - layoutparams.rightMargin;
                        i2 = l2 - l1;
                    }
                    j4 = j3 - i4 / 2;
                    view.layout(i2, j4, l2, i4 + j4);
                    i2 = j1 - l1;
                    l1 = 1;
                    j1 = l;
                    l = i2;
                } else
                {
                    int j2 = view.getMeasuredWidth();
                    int i3 = layoutparams.leftMargin;
                    j1 -= layoutparams.rightMargin + (j2 + i3);
                    hasSupportDividerBeforeChildAt(k1);
                    j2 = l + 1;
                    l = j1;
                    j1 = j2;
                }
            } else
            {
                int k2 = l;
                l = j1;
                j1 = k2;
            }
            i2 = k1 + 1;
            k1 = j1;
            j1 = l;
            l = k1;
            k1 = i2;
        }
        if (k3 == 1 && l1 == 0)
        {
            view = getChildAt(0);
            l = view.getMeasuredWidth();
            j1 = view.getMeasuredHeight();
            j = (i1 - j) / 2 - l / 2;
            i1 = j3 - j1 / 2;
            view.layout(j, i1, l + j, j1 + i1);
            return;
        }
        if (l1 != 0)
        {
            j = 0;
        } else
        {
            j = 1;
        }
        j = l - j;
        if (j > 0)
        {
            j = j1 / j;
        } else
        {
            j = 0;
        }
        i1 = Math.max(0, j);
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        j = getWidth() - getPaddingRight();
        l = 0;
        while (l < k3) 
        {
            view = getChildAt(l);
            layoutparams1 = (LayoutParams)view.getLayoutParams();
            if (view.getVisibility() != 8 && !layoutparams1.isOverflowButton)
            {
                j -= layoutparams1.rightMargin;
                j1 = view.getMeasuredWidth();
                k1 = view.getMeasuredHeight();
                l1 = j3 - k1 / 2;
                view.layout(j - j1, l1, j, k1 + l1);
                j -= layoutparams1.leftMargin + j1 + i1;
            }
            l++;
        }
        if (true) goto _L4; else goto _L3
_L3:
        j = getPaddingLeft();
        l = 0;
        while (l < k3) 
        {
            view = getChildAt(l);
            layoutparams1 = (LayoutParams)view.getLayoutParams();
            if (view.getVisibility() != 8 && !layoutparams1.isOverflowButton)
            {
                j += layoutparams1.leftMargin;
                j1 = view.getMeasuredWidth();
                k1 = view.getMeasuredHeight();
                l1 = j3 - k1 / 2;
                view.layout(j, l1, j + j1, k1 + l1);
                j = layoutparams1.rightMargin + j1 + i1 + j;
            }
            l++;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    protected void onMeasure(int j, int l)
    {
        boolean flag1 = mFormatItems;
        int i1;
        int k1;
        boolean flag;
        if (android.view.View.MeasureSpec.getMode(j) == 0x40000000)
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
        i1 = android.view.View.MeasureSpec.getSize(j);
        if (mFormatItems && mMenu != null && i1 != mFormatItemsWidth)
        {
            mFormatItemsWidth = i1;
            mMenu.b(true);
        }
        k1 = getChildCount();
        if (mFormatItems && k1 > 0)
        {
            onMeasureExactFormat(j, l);
            return;
        }
        for (int j1 = 0; j1 < k1; j1++)
        {
            LayoutParams layoutparams = (LayoutParams)getChildAt(j1).getLayoutParams();
            layoutparams.rightMargin = 0;
            layoutparams.leftMargin = 0;
        }

        super.onMeasure(j, l);
    }

    public i peekMenu()
    {
        return mMenu;
    }

    public void setExpandedActionViewsExclusive(boolean flag)
    {
        mPresenter.setExpandedActionViewsExclusive(flag);
    }

    public void setMenuCallbacks(y y, j j)
    {
        mActionMenuPresenterCallback = y;
        mMenuBuilderCallback = j;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onmenuitemclicklistener)
    {
        mOnMenuItemClickListener = onmenuitemclicklistener;
    }

    public void setOverflowIcon(Drawable drawable)
    {
        getMenu();
        mPresenter.setOverflowIcon(drawable);
    }

    public void setOverflowReserved(boolean flag)
    {
        mReserveOverflow = flag;
    }

    public void setPopupTheme(int j)
    {
label0:
        {
            if (mPopupTheme != j)
            {
                mPopupTheme = j;
                if (j != 0)
                {
                    break label0;
                }
                mPopupContext = getContext();
            }
            return;
        }
        mPopupContext = new ContextThemeWrapper(getContext(), j);
    }

    public void setPresenter(ActionMenuPresenter actionmenupresenter)
    {
        mPresenter = actionmenupresenter;
        mPresenter.setMenuView(this);
    }

    public boolean showOverflowMenu()
    {
        return mPresenter != null && mPresenter.showOverflowMenu();
    }



    private class LayoutParams extends LinearLayoutCompat.LayoutParams
    {

        public int cellsUsed;
        public boolean expandable;
        boolean expanded;
        public int extraPixels;
        public boolean isOverflowButton;
        public boolean preventEdgeOffset;

        public LayoutParams(int j, int l)
        {
            super(j, l);
            isOverflowButton = false;
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

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
        {
            super(layoutparams);
        }
    }


    private class MenuBuilderCallback
        implements j
    {

        final ActionMenuView this$0;

        public boolean onMenuItemSelected(i l, MenuItem menuitem)
        {
            return mOnMenuItemClickListener != null && mOnMenuItemClickListener.onMenuItemClick(menuitem);
        }

        public void onMenuModeChange(i l)
        {
            if (mMenuBuilderCallback != null)
            {
                mMenuBuilderCallback.onMenuModeChange(l);
            }
        }

        private MenuBuilderCallback()
        {
            this$0 = ActionMenuView.this;
            super();
        }

        MenuBuilderCallback(_cls1 _pcls1)
        {
            this();
        }

        private class OnMenuItemClickListener
        {

            public abstract boolean onMenuItemClick(MenuItem menuitem);
        }

    }


    private class ActionMenuPresenterCallback
        implements y
    {

        final ActionMenuView this$0;

        public void onCloseMenu(i j, boolean flag)
        {
        }

        public boolean onOpenSubMenu(i j)
        {
            return false;
        }

        private ActionMenuPresenterCallback()
        {
            this$0 = ActionMenuView.this;
            super();
        }

        ActionMenuPresenterCallback(_cls1 _pcls1)
        {
            this();
        }
    }


    private class ActionMenuChildView
    {

        public abstract boolean needsDividerAfter();

        public abstract boolean needsDividerBefore();
    }

}
