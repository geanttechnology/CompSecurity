// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import ab;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ActionMenuView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import as;
import ca;
import dx;
import ed;
import ee;
import r;
import w;
import y;

// Referenced classes of package android.support.v7.internal.widget:
//            AbsActionBarView

public class ActionBarContextView extends AbsActionBarView
    implements ViewPropertyAnimatorListener
{

    private static final int ANIMATE_IDLE = 0;
    private static final int ANIMATE_IN = 1;
    private static final int ANIMATE_OUT = 2;
    private static final String TAG = "ActionBarContextView";
    private boolean mAnimateInOnLayout;
    private int mAnimationMode;
    private View mClose;
    private int mCloseItemLayout;
    private as mCurrentAnimation;
    private View mCustomView;
    private Drawable mSplitBackground;
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
        this(context, attributeset, r.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        context = dx.a(context, attributeset, ab.ActionMode, i, 0);
        setBackgroundDrawable(context.a(ab.ActionMode_background));
        mTitleStyleRes = context.f(ab.ActionMode_titleTextStyle, 0);
        mSubtitleStyleRes = context.f(ab.ActionMode_subtitleTextStyle, 0);
        mContentHeight = context.e(ab.ActionMode_height, 0);
        mSplitBackground = context.a(ab.ActionMode_backgroundSplit);
        mCloseItemLayout = context.f(ab.ActionMode_closeItemLayout, y.abc_action_mode_close_item_material);
        context.b();
    }

    private void finishAnimation()
    {
        as as1 = mCurrentAnimation;
        if (as1 != null)
        {
            mCurrentAnimation = null;
            as1.b();
        }
    }

    private void initTitle()
    {
label0:
        {
            byte byte1 = 8;
            boolean flag = true;
            if (mTitleLayout == null)
            {
                LayoutInflater.from(getContext()).inflate(y.abc_action_bar_title_item, this);
                mTitleLayout = (LinearLayout)getChildAt(getChildCount() - 1);
                mTitleView = (TextView)mTitleLayout.findViewById(w.action_bar_title);
                mSubtitleView = (TextView)mTitleLayout.findViewById(w.action_bar_subtitle);
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
            int i;
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
                i = 0;
            } else
            {
                i = 8;
            }
            ((TextView) (obj)).setVisibility(i);
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

    private as makeInAnimation()
    {
        ViewCompat.setTranslationX(mClose, -mClose.getWidth() - ((android.view.ViewGroup.MarginLayoutParams)mClose.getLayoutParams()).leftMargin);
        ViewPropertyAnimatorCompat viewpropertyanimatorcompat = ViewCompat.animate(mClose).translationX(0.0F);
        viewpropertyanimatorcompat.setDuration(200L);
        viewpropertyanimatorcompat.setListener(this);
        viewpropertyanimatorcompat.setInterpolator(new DecelerateInterpolator());
        as as1 = new as();
        as1.a(viewpropertyanimatorcompat);
        if (mMenuView != null)
        {
            int i = mMenuView.getChildCount();
            if (i > 0)
            {
                int k = i - 1;
                for (int j = 0; k >= 0; j++)
                {
                    Object obj = mMenuView.getChildAt(k);
                    ViewCompat.setScaleY(((View) (obj)), 0.0F);
                    obj = ViewCompat.animate(((View) (obj))).scaleY(1.0F);
                    ((ViewPropertyAnimatorCompat) (obj)).setDuration(300L);
                    as1.a(((ViewPropertyAnimatorCompat) (obj)));
                    k--;
                }

            }
        }
        return as1;
    }

    private as makeOutAnimation()
    {
        ViewPropertyAnimatorCompat viewpropertyanimatorcompat = ViewCompat.animate(mClose).translationX(-mClose.getWidth() - ((android.view.ViewGroup.MarginLayoutParams)mClose.getLayoutParams()).leftMargin);
        viewpropertyanimatorcompat.setDuration(200L);
        viewpropertyanimatorcompat.setListener(this);
        viewpropertyanimatorcompat.setInterpolator(new DecelerateInterpolator());
        as as1 = new as();
        as1.a(viewpropertyanimatorcompat);
        if (mMenuView != null)
        {
            if (mMenuView.getChildCount() <= 0);
        }
        return as1;
    }

    public volatile void animateToVisibility(int i)
    {
        super.animateToVisibility(i);
    }

    public volatile boolean canShowOverflowMenu()
    {
        return super.canShowOverflowMenu();
    }

    public void closeMode()
    {
        if (mAnimationMode == 2)
        {
            return;
        }
        if (mClose == null)
        {
            killMode();
            return;
        } else
        {
            finishAnimation();
            mAnimationMode = 2;
            mCurrentAnimation = makeOutAnimation();
            mCurrentAnimation.a();
            return;
        }
    }

    public volatile void dismissPopupMenus()
    {
        super.dismissPopupMenus();
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

    public boolean hideOverflowMenu()
    {
        if (mActionMenuPresenter != null)
        {
            return mActionMenuPresenter.d();
        } else
        {
            return false;
        }
    }

    public void initForMode(ee ee1)
    {
        android.view.ViewGroup.LayoutParams layoutparams;
        if (mClose == null)
        {
            mClose = LayoutInflater.from(getContext()).inflate(mCloseItemLayout, this, false);
            addView(mClose);
        } else
        if (mClose.getParent() == null)
        {
            addView(mClose);
        }
        mClose.findViewById(w.action_mode_close_button).setOnClickListener(new ca(this, ee1));
        ee1 = (MenuBuilder)ee1.b();
        if (mActionMenuPresenter != null)
        {
            mActionMenuPresenter.e();
        }
        mActionMenuPresenter = new ActionMenuPresenter(getContext());
        mActionMenuPresenter.b(true);
        layoutparams = new android.view.ViewGroup.LayoutParams(-2, -1);
        if (!mSplitActionBar)
        {
            ee1.a(mActionMenuPresenter, mPopupContext);
            mMenuView = (ActionMenuView)mActionMenuPresenter.a(this);
            mMenuView.setBackgroundDrawable(null);
            addView(mMenuView, layoutparams);
        } else
        {
            mActionMenuPresenter.a(getContext().getResources().getDisplayMetrics().widthPixels, true);
            mActionMenuPresenter.b(0x7fffffff);
            layoutparams.width = -1;
            layoutparams.height = mContentHeight;
            ee1.a(mActionMenuPresenter, mPopupContext);
            mMenuView = (ActionMenuView)mActionMenuPresenter.a(this);
            mMenuView.setBackgroundDrawable(mSplitBackground);
            mSplitView.addView(mMenuView, layoutparams);
        }
        mAnimateInOnLayout = true;
    }

    public volatile boolean isOverflowMenuShowPending()
    {
        return super.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing()
    {
        if (mActionMenuPresenter != null)
        {
            return mActionMenuPresenter.g();
        } else
        {
            return false;
        }
    }

    public volatile boolean isOverflowReserved()
    {
        return super.isOverflowReserved();
    }

    public boolean isTitleOptional()
    {
        return mTitleOptional;
    }

    public void killMode()
    {
        finishAnimation();
        removeAllViews();
        if (mSplitView != null)
        {
            mSplitView.removeView(mMenuView);
        }
        mCustomView = null;
        mMenuView = null;
        mAnimateInOnLayout = false;
    }

    public void onAnimationCancel(View view)
    {
    }

    public void onAnimationEnd(View view)
    {
        if (mAnimationMode == 2)
        {
            killMode();
        }
        mAnimationMode = 0;
    }

    public void onAnimationStart(View view)
    {
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (mActionMenuPresenter != null)
        {
            mActionMenuPresenter.d();
            mActionMenuPresenter.f();
        }
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

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        flag = ed.a(this);
        int i1;
        int j1;
        int k1;
        if (flag)
        {
            i1 = k - i - getPaddingRight();
        } else
        {
            i1 = getPaddingLeft();
        }
        j1 = getPaddingTop();
        k1 = l - j - getPaddingTop() - getPaddingBottom();
        j = i1;
        if (mClose != null)
        {
            j = i1;
            if (mClose.getVisibility() != 8)
            {
                Object obj = (android.view.ViewGroup.MarginLayoutParams)mClose.getLayoutParams();
                if (flag)
                {
                    j = ((android.view.ViewGroup.MarginLayoutParams) (obj)).rightMargin;
                } else
                {
                    j = ((android.view.ViewGroup.MarginLayoutParams) (obj)).leftMargin;
                }
                if (flag)
                {
                    l = ((android.view.ViewGroup.MarginLayoutParams) (obj)).leftMargin;
                } else
                {
                    l = ((android.view.ViewGroup.MarginLayoutParams) (obj)).rightMargin;
                }
                j = next(i1, j, flag);
                l = next(positionChild(mClose, j, j1, k1, flag) + j, l, flag);
                j = l;
                if (mAnimateInOnLayout)
                {
                    mAnimationMode = 1;
                    mCurrentAnimation = makeInAnimation();
                    mCurrentAnimation.a();
                    mAnimateInOnLayout = false;
                    j = l;
                }
            }
        }
        l = j;
        if (mTitleLayout != null)
        {
            l = j;
            if (mCustomView == null)
            {
                l = j;
                if (mTitleLayout.getVisibility() != 8)
                {
                    l = j + positionChild(mTitleLayout, j, j1, k1, flag);
                }
            }
        }
        if (mCustomView != null)
        {
            positionChild(mCustomView, l, j1, k1, flag);
        }
        if (flag)
        {
            i = getPaddingLeft();
        } else
        {
            i = k - i - getPaddingRight();
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
            positionChild(((View) (obj)), i, j1, k1, flag);
        }
    }

    protected void onMeasure(int i, int j)
    {
        int i1 = 0x40000000;
        boolean flag = false;
        if (android.view.View.MeasureSpec.getMode(i) != 0x40000000)
        {
            throw new IllegalStateException((new StringBuilder()).append(getClass().getSimpleName()).append(" can only be used ").append("with android:layout_width=\"match_parent\" (or fill_parent)").toString());
        }
        if (android.view.View.MeasureSpec.getMode(j) == 0)
        {
            throw new IllegalStateException((new StringBuilder()).append(getClass().getSimpleName()).append(" can only be used ").append("with android:layout_height=\"wrap_content\"").toString());
        }
        int k1 = android.view.View.MeasureSpec.getSize(i);
        int k;
        int l;
        int j1;
        int l1;
        if (mContentHeight > 0)
        {
            k = mContentHeight;
        } else
        {
            k = android.view.View.MeasureSpec.getSize(j);
        }
        l1 = getPaddingTop() + getPaddingBottom();
        i = k1 - getPaddingLeft() - getPaddingRight();
        j1 = k - l1;
        l = android.view.View.MeasureSpec.makeMeasureSpec(j1, 0x80000000);
        j = i;
        if (mClose != null)
        {
            i = measureChildView(mClose, i, l, 0);
            android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)mClose.getLayoutParams();
            j = marginlayoutparams.leftMargin;
            j = i - (marginlayoutparams.rightMargin + j);
        }
        i = j;
        if (mMenuView != null)
        {
            i = j;
            if (mMenuView.getParent() == this)
            {
                i = measureChildView(mMenuView, j, l, 0);
            }
        }
        j = i;
        if (mTitleLayout != null)
        {
            j = i;
            if (mCustomView == null)
            {
                if (mTitleOptional)
                {
                    j = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
                    mTitleLayout.measure(j, l);
                    int i2 = mTitleLayout.getMeasuredWidth();
                    Object obj;
                    if (i2 <= i)
                    {
                        l = 1;
                    } else
                    {
                        l = 0;
                    }
                    j = i;
                    if (l != 0)
                    {
                        j = i - i2;
                    }
                    obj = mTitleLayout;
                    if (l != 0)
                    {
                        i = 0;
                    } else
                    {
                        i = 8;
                    }
                    ((LinearLayout) (obj)).setVisibility(i);
                } else
                {
                    j = measureChildView(mTitleLayout, i, l, 0);
                }
            }
        }
        if (mCustomView != null)
        {
            obj = mCustomView.getLayoutParams();
            if (((android.view.ViewGroup.LayoutParams) (obj)).width != -2)
            {
                i = 0x40000000;
            } else
            {
                i = 0x80000000;
            }
            l = j;
            if (((android.view.ViewGroup.LayoutParams) (obj)).width >= 0)
            {
                l = Math.min(((android.view.ViewGroup.LayoutParams) (obj)).width, j);
            }
            if (((android.view.ViewGroup.LayoutParams) (obj)).height != -2)
            {
                j = i1;
            } else
            {
                j = 0x80000000;
            }
            if (((android.view.ViewGroup.LayoutParams) (obj)).height >= 0)
            {
                i1 = Math.min(((android.view.ViewGroup.LayoutParams) (obj)).height, j1);
            } else
            {
                i1 = j1;
            }
            mCustomView.measure(android.view.View.MeasureSpec.makeMeasureSpec(l, i), android.view.View.MeasureSpec.makeMeasureSpec(i1, j));
        }
        if (mContentHeight <= 0)
        {
            l = getChildCount();
            i = 0;
            for (j = ((flag) ? 1 : 0); j < l; j++)
            {
                k = getChildAt(j).getMeasuredHeight() + l1;
                if (k > i)
                {
                    i = k;
                }
            }

            setMeasuredDimension(k1, i);
            return;
        } else
        {
            setMeasuredDimension(k1, k);
            return;
        }
    }

    public volatile void postShowOverflowMenu()
    {
        super.postShowOverflowMenu();
    }

    public void setContentHeight(int i)
    {
        mContentHeight = i;
    }

    public void setCustomView(View view)
    {
        if (mCustomView != null)
        {
            removeView(mCustomView);
        }
        mCustomView = view;
        if (mTitleLayout != null)
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

    public void setSplitToolbar(boolean flag)
    {
        if (mSplitActionBar != flag)
        {
            if (mActionMenuPresenter != null)
            {
                android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(-2, -1);
                if (!flag)
                {
                    mMenuView = (ActionMenuView)mActionMenuPresenter.a(this);
                    mMenuView.setBackgroundDrawable(null);
                    ViewGroup viewgroup = (ViewGroup)mMenuView.getParent();
                    if (viewgroup != null)
                    {
                        viewgroup.removeView(mMenuView);
                    }
                    addView(mMenuView, layoutparams);
                } else
                {
                    mActionMenuPresenter.a(getContext().getResources().getDisplayMetrics().widthPixels, true);
                    mActionMenuPresenter.b(0x7fffffff);
                    layoutparams.width = -1;
                    layoutparams.height = mContentHeight;
                    mMenuView = (ActionMenuView)mActionMenuPresenter.a(this);
                    mMenuView.setBackgroundDrawable(mSplitBackground);
                    ViewGroup viewgroup1 = (ViewGroup)mMenuView.getParent();
                    if (viewgroup1 != null)
                    {
                        viewgroup1.removeView(mMenuView);
                    }
                    mSplitView.addView(mMenuView, layoutparams);
                }
            }
            super.setSplitToolbar(flag);
        }
    }

    public volatile void setSplitView(ViewGroup viewgroup)
    {
        super.setSplitView(viewgroup);
    }

    public volatile void setSplitWhenNarrow(boolean flag)
    {
        super.setSplitWhenNarrow(flag);
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

    public boolean shouldDelayChildPressedState()
    {
        return false;
    }

    public boolean showOverflowMenu()
    {
        if (mActionMenuPresenter != null)
        {
            return mActionMenuPresenter.c();
        } else
        {
            return false;
        }
    }
}
