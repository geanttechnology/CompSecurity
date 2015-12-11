// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.support.v4.view.cx;
import android.support.v7.internal.view.menu.i;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ActionMenuView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

// Referenced classes of package android.support.v7.internal.widget:
//            AbsActionBarView, TintTypedArray, ViewUtils

public class ActionBarContextView extends AbsActionBarView
{

    private View mClose;
    private int mCloseItemLayout;
    private View mCustomView;
    private CharSequence mSubtitle;
    private int mSubtitleStyleRes;
    private TextView mSubtitleView;
    private CharSequence mTitle;
    private LinearLayout mTitleLayout;
    private boolean mTitleOptional;
    private int mTitleStyleRes;
    private TextView mTitleView;

    public ActionBarContextView(Context context)
    {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, android.support.v7.appcompat.R.attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeset, int j)
    {
        super(context, attributeset, j);
        context = TintTypedArray.obtainStyledAttributes(context, attributeset, android.support.v7.appcompat.R.styleable.ActionMode, j, 0);
        setBackgroundDrawable(context.getDrawable(android.support.v7.appcompat.R.styleable.ActionMode_background));
        mTitleStyleRes = context.getResourceId(android.support.v7.appcompat.R.styleable.ActionMode_titleTextStyle, 0);
        mSubtitleStyleRes = context.getResourceId(android.support.v7.appcompat.R.styleable.ActionMode_subtitleTextStyle, 0);
        mContentHeight = context.getLayoutDimension(android.support.v7.appcompat.R.styleable.ActionMode_height, 0);
        mCloseItemLayout = context.getResourceId(android.support.v7.appcompat.R.styleable.ActionMode_closeItemLayout, android.support.v7.appcompat.R.layout.abc_action_mode_close_item_material);
        context.recycle();
    }

    private void initTitle()
    {
label0:
        {
            byte byte1 = 8;
            boolean flag = true;
            if (mTitleLayout == null)
            {
                LayoutInflater.from(getContext()).inflate(android.support.v7.appcompat.R.layout.abc_action_bar_title_item, this);
                mTitleLayout = (LinearLayout)getChildAt(getChildCount() - 1);
                mTitleView = (TextView)mTitleLayout.findViewById(android.support.v7.appcompat.R.id.action_bar_title);
                mSubtitleView = (TextView)mTitleLayout.findViewById(android.support.v7.appcompat.R.id.action_bar_subtitle);
                if (mTitleStyleRes != 0)
                {
                    mTitleView.setTextAppearance(getContext(), mTitleStyleRes);
                }
                if (mSubtitleStyleRes != 0)
                {
                    mSubtitleView.setTextAppearance(getContext(), mSubtitleStyleRes);
                }
            }
            mTitleView.setText(mTitle);
            mSubtitleView.setText(mSubtitle);
            Object obj;
            byte byte0;
            int j;
            if (!TextUtils.isEmpty(mTitle))
            {
                byte0 = 1;
            } else
            {
                byte0 = 0;
            }
            if (TextUtils.isEmpty(mSubtitle))
            {
                flag = false;
            }
            obj = mSubtitleView;
            if (flag)
            {
                j = 0;
            } else
            {
                j = 8;
            }
            ((TextView) (obj)).setVisibility(j);
            obj = mTitleLayout;
            if (byte0 == 0)
            {
                byte0 = byte1;
                if (!flag)
                {
                    break label0;
                }
            }
            byte0 = 0;
        }
        ((LinearLayout) (obj)).setVisibility(byte0);
        if (mTitleLayout.getParent() == null)
        {
            addView(mTitleLayout);
        }
    }

    public void closeMode()
    {
        if (mClose == null)
        {
            killMode();
        }
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new android.view.ViewGroup.MarginLayoutParams(-1, -2);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new android.view.ViewGroup.MarginLayoutParams(getContext(), attributeset);
    }

    public volatile int getAnimatedVisibility()
    {
        return super.getAnimatedVisibility();
    }

    public volatile int getContentHeight()
    {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle()
    {
        return mSubtitle;
    }

    public CharSequence getTitle()
    {
        return mTitle;
    }

    public void initForMode(final ActionMode mode)
    {
        if (mClose != null) goto _L2; else goto _L1
_L1:
        mClose = LayoutInflater.from(getContext()).inflate(mCloseItemLayout, this, false);
        addView(mClose);
_L4:
        mClose.findViewById(android.support.v7.appcompat.R.id.action_mode_close_button).setOnClickListener(new _cls1());
        mode = (i)mode.getMenu();
        if (mActionMenuPresenter != null)
        {
            mActionMenuPresenter.dismissPopupMenus();
        }
        mActionMenuPresenter = new ActionMenuPresenter(getContext());
        mActionMenuPresenter.setReserveOverflow(true);
        android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(-2, -1);
        mode.a(mActionMenuPresenter, mPopupContext);
        mMenuView = (ActionMenuView)mActionMenuPresenter.getMenuView(this);
        mMenuView.setBackgroundDrawable(null);
        addView(mMenuView, layoutparams);
        return;
_L2:
        if (mClose.getParent() == null)
        {
            addView(mClose);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean isTitleOptional()
    {
        return mTitleOptional;
    }

    public void killMode()
    {
        removeAllViews();
        mCustomView = null;
        mMenuView = null;
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (mActionMenuPresenter != null)
        {
            mActionMenuPresenter.hideOverflowMenu();
            mActionMenuPresenter.hideSubMenus();
        }
    }

    public volatile boolean onHoverEvent(MotionEvent motionevent)
    {
        return super.onHoverEvent(motionevent);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
label0:
        {
            if (android.os.Build.VERSION.SDK_INT >= 14)
            {
                if (accessibilityevent.getEventType() != 32)
                {
                    break label0;
                }
                accessibilityevent.setSource(this);
                accessibilityevent.setClassName(getClass().getName());
                accessibilityevent.setPackageName(getContext().getPackageName());
                accessibilityevent.setContentDescription(mTitle);
            }
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityevent);
    }

    protected void onLayout(boolean flag, int j, int k, int l, int i1)
    {
        flag = ViewUtils.isLayoutRtl(this);
        int j1;
        int k1;
        int l1;
        if (flag)
        {
            j1 = l - j - getPaddingRight();
        } else
        {
            j1 = getPaddingLeft();
        }
        k1 = getPaddingTop();
        l1 = i1 - k - getPaddingTop() - getPaddingBottom();
        if (mClose != null && mClose.getVisibility() != 8)
        {
            Object obj = (android.view.ViewGroup.MarginLayoutParams)mClose.getLayoutParams();
            if (flag)
            {
                k = ((android.view.ViewGroup.MarginLayoutParams) (obj)).rightMargin;
            } else
            {
                k = ((android.view.ViewGroup.MarginLayoutParams) (obj)).leftMargin;
            }
            if (flag)
            {
                i1 = ((android.view.ViewGroup.MarginLayoutParams) (obj)).leftMargin;
            } else
            {
                i1 = ((android.view.ViewGroup.MarginLayoutParams) (obj)).rightMargin;
            }
            k = next(j1, k, flag);
            k = next(positionChild(mClose, k, k1, l1, flag) + k, i1, flag);
        } else
        {
            k = j1;
        }
        i1 = k;
        if (mTitleLayout != null)
        {
            i1 = k;
            if (mCustomView == null)
            {
                i1 = k;
                if (mTitleLayout.getVisibility() != 8)
                {
                    i1 = k + positionChild(mTitleLayout, k, k1, l1, flag);
                }
            }
        }
        if (mCustomView != null)
        {
            positionChild(mCustomView, i1, k1, l1, flag);
        }
        if (flag)
        {
            j = getPaddingLeft();
        } else
        {
            j = l - j - getPaddingRight();
        }
        if (mMenuView != null)
        {
            obj = mMenuView;
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            positionChild(((View) (obj)), j, k1, l1, flag);
        }
    }

    protected void onMeasure(int j, int k)
    {
        int j1 = 0x40000000;
        boolean flag = false;
        if (android.view.View.MeasureSpec.getMode(j) != 0x40000000)
        {
            throw new IllegalStateException((new StringBuilder()).append(getClass().getSimpleName()).append(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)").toString());
        }
        if (android.view.View.MeasureSpec.getMode(k) == 0)
        {
            throw new IllegalStateException((new StringBuilder()).append(getClass().getSimpleName()).append(" can only be used with android:layout_height=\"wrap_content\"").toString());
        }
        int l1 = android.view.View.MeasureSpec.getSize(j);
        int l;
        int i1;
        int k1;
        int i2;
        if (mContentHeight > 0)
        {
            l = mContentHeight;
        } else
        {
            l = android.view.View.MeasureSpec.getSize(k);
        }
        i2 = getPaddingTop() + getPaddingBottom();
        j = l1 - getPaddingLeft() - getPaddingRight();
        k1 = l - i2;
        i1 = android.view.View.MeasureSpec.makeMeasureSpec(k1, 0x80000000);
        k = j;
        if (mClose != null)
        {
            j = measureChildView(mClose, j, i1, 0);
            android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)mClose.getLayoutParams();
            k = marginlayoutparams.leftMargin;
            k = j - (marginlayoutparams.rightMargin + k);
        }
        j = k;
        if (mMenuView != null)
        {
            j = k;
            if (mMenuView.getParent() == this)
            {
                j = measureChildView(mMenuView, k, i1, 0);
            }
        }
        k = j;
        if (mTitleLayout != null)
        {
            k = j;
            if (mCustomView == null)
            {
                if (mTitleOptional)
                {
                    k = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
                    mTitleLayout.measure(k, i1);
                    int j2 = mTitleLayout.getMeasuredWidth();
                    Object obj;
                    if (j2 <= j)
                    {
                        i1 = 1;
                    } else
                    {
                        i1 = 0;
                    }
                    k = j;
                    if (i1 != 0)
                    {
                        k = j - j2;
                    }
                    obj = mTitleLayout;
                    if (i1 != 0)
                    {
                        j = 0;
                    } else
                    {
                        j = 8;
                    }
                    ((LinearLayout) (obj)).setVisibility(j);
                } else
                {
                    k = measureChildView(mTitleLayout, j, i1, 0);
                }
            }
        }
        if (mCustomView != null)
        {
            obj = mCustomView.getLayoutParams();
            if (((android.view.ViewGroup.LayoutParams) (obj)).width != -2)
            {
                j = 0x40000000;
            } else
            {
                j = 0x80000000;
            }
            i1 = k;
            if (((android.view.ViewGroup.LayoutParams) (obj)).width >= 0)
            {
                i1 = Math.min(((android.view.ViewGroup.LayoutParams) (obj)).width, k);
            }
            if (((android.view.ViewGroup.LayoutParams) (obj)).height != -2)
            {
                k = j1;
            } else
            {
                k = 0x80000000;
            }
            if (((android.view.ViewGroup.LayoutParams) (obj)).height >= 0)
            {
                j1 = Math.min(((android.view.ViewGroup.LayoutParams) (obj)).height, k1);
            } else
            {
                j1 = k1;
            }
            mCustomView.measure(android.view.View.MeasureSpec.makeMeasureSpec(i1, j), android.view.View.MeasureSpec.makeMeasureSpec(j1, k));
        }
        if (mContentHeight <= 0)
        {
            i1 = getChildCount();
            j = 0;
            for (k = ((flag) ? 1 : 0); k < i1; k++)
            {
                l = getChildAt(k).getMeasuredHeight() + i2;
                if (l > j)
                {
                    j = l;
                }
            }

            setMeasuredDimension(l1, j);
            return;
        } else
        {
            setMeasuredDimension(l1, l);
            return;
        }
    }

    public volatile boolean onTouchEvent(MotionEvent motionevent)
    {
        return super.onTouchEvent(motionevent);
    }

    public void setContentHeight(int j)
    {
        mContentHeight = j;
    }

    public void setCustomView(View view)
    {
        if (mCustomView != null)
        {
            removeView(mCustomView);
        }
        mCustomView = view;
        if (view != null && mTitleLayout != null)
        {
            removeView(mTitleLayout);
            mTitleLayout = null;
        }
        if (view != null)
        {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charsequence)
    {
        mSubtitle = charsequence;
        initTitle();
    }

    public void setTitle(CharSequence charsequence)
    {
        mTitle = charsequence;
        initTitle();
    }

    public void setTitleOptional(boolean flag)
    {
        if (flag != mTitleOptional)
        {
            requestLayout();
        }
        mTitleOptional = flag;
    }

    public volatile void setVisibility(int j)
    {
        super.setVisibility(j);
    }

    public volatile cx setupAnimatorToVisibility(int j, long l)
    {
        return super.setupAnimatorToVisibility(j, l);
    }

    public boolean shouldDelayChildPressedState()
    {
        return false;
    }

    public boolean showOverflowMenu()
    {
        if (mActionMenuPresenter != null)
        {
            return mActionMenuPresenter.showOverflowMenu();
        } else
        {
            return false;
        }
    }

    private class _cls1
        implements android.view.View.OnClickListener
    {

        final ActionBarContextView this$0;
        final ActionMode val$mode;

        public void onClick(View view)
        {
            mode.finish();
        }

        _cls1()
        {
            this$0 = ActionBarContextView.this;
            mode = actionmode;
            super();
        }
    }

}
