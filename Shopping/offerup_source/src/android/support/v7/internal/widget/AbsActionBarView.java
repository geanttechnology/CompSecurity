// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.view.at;
import android.support.v4.view.bi;
import android.support.v4.view.cx;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ActionMenuView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

abstract class AbsActionBarView extends ViewGroup
{

    protected ActionMenuPresenter mActionMenuPresenter;
    protected int mContentHeight;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    protected ActionMenuView mMenuView;
    protected final Context mPopupContext;
    protected final VisibilityAnimListener mVisAnimListener;
    protected cx mVisibilityAnim;

    AbsActionBarView(Context context)
    {
        this(context, null);
    }

    AbsActionBarView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    AbsActionBarView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mVisAnimListener = new VisibilityAnimListener();
        attributeset = new TypedValue();
        if (context.getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.actionBarPopupTheme, attributeset, true) && ((TypedValue) (attributeset)).resourceId != 0)
        {
            mPopupContext = new ContextThemeWrapper(context, ((TypedValue) (attributeset)).resourceId);
            return;
        } else
        {
            mPopupContext = context;
            return;
        }
    }

    protected static int next(int i, int j, boolean flag)
    {
        if (flag)
        {
            return i - j;
        } else
        {
            return i + j;
        }
    }

    public int getAnimatedVisibility()
    {
        if (mVisibilityAnim != null)
        {
            return mVisAnimListener.mFinalVisibility;
        } else
        {
            return getVisibility();
        }
    }

    public int getContentHeight()
    {
        return mContentHeight;
    }

    protected int measureChildView(View view, int i, int j, int k)
    {
        view.measure(android.view.View.MeasureSpec.makeMeasureSpec(i, 0x80000000), j);
        return Math.max(0, i - view.getMeasuredWidth() - k);
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            super.onConfigurationChanged(configuration);
        }
        TypedArray typedarray = getContext().obtainStyledAttributes(null, android.support.v7.appcompat.R.styleable.ActionBar, android.support.v7.appcompat.R.attr.actionBarStyle, 0);
        setContentHeight(typedarray.getLayoutDimension(android.support.v7.appcompat.R.styleable.ActionBar_height, 0));
        typedarray.recycle();
        if (mActionMenuPresenter != null)
        {
            mActionMenuPresenter.onConfigurationChanged(configuration);
        }
    }

    public boolean onHoverEvent(MotionEvent motionevent)
    {
        int i = at.a(motionevent);
        if (i == 9)
        {
            mEatingHover = false;
        }
        if (!mEatingHover)
        {
            boolean flag = super.onHoverEvent(motionevent);
            if (i == 9 && !flag)
            {
                mEatingHover = true;
            }
        }
        if (i == 10 || i == 3)
        {
            mEatingHover = false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i = at.a(motionevent);
        if (i == 0)
        {
            mEatingTouch = false;
        }
        if (!mEatingTouch)
        {
            boolean flag = super.onTouchEvent(motionevent);
            if (i == 0 && !flag)
            {
                mEatingTouch = true;
            }
        }
        if (i == 1 || i == 3)
        {
            mEatingTouch = false;
        }
        return true;
    }

    protected int positionChild(View view, int i, int j, int k, boolean flag)
    {
        int l = view.getMeasuredWidth();
        int i1 = view.getMeasuredHeight();
        j = (k - i1) / 2 + j;
        if (flag)
        {
            view.layout(i - l, j, i, i1 + j);
        } else
        {
            view.layout(i, j, i + l, i1 + j);
        }
        i = l;
        if (flag)
        {
            i = -l;
        }
        return i;
    }

    public void setContentHeight(int i)
    {
        mContentHeight = i;
        requestLayout();
    }

    public void setVisibility(int i)
    {
        if (i != getVisibility())
        {
            if (mVisibilityAnim != null)
            {
                mVisibilityAnim.b();
            }
            super.setVisibility(i);
        }
    }

    public cx setupAnimatorToVisibility(int i, long l)
    {
        if (mVisibilityAnim != null)
        {
            mVisibilityAnim.b();
        }
        if (i == 0)
        {
            if (getVisibility() != 0)
            {
                bi.c(this, 0.0F);
            }
            cx cx1 = bi.q(this).a(1.0F);
            cx1.a(l);
            cx1.a(mVisAnimListener.withFinalVisibility(cx1, i));
            return cx1;
        } else
        {
            cx cx2 = bi.q(this).a(0.0F);
            cx2.a(l);
            cx2.a(mVisAnimListener.withFinalVisibility(cx2, i));
            return cx2;
        }
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



    private class VisibilityAnimListener
        implements dk
    {

        private boolean mCanceled;
        int mFinalVisibility;
        final AbsActionBarView this$0;

        public void onAnimationCancel(View view)
        {
            mCanceled = true;
        }

        public void onAnimationEnd(View view)
        {
            if (mCanceled)
            {
                return;
            } else
            {
                mVisibilityAnim = null;
                setVisibility(mFinalVisibility);
                return;
            }
        }

        public void onAnimationStart(View view)
        {
            setVisibility(0);
            mCanceled = false;
        }

        public VisibilityAnimListener withFinalVisibility(cx cx1, int i)
        {
            mVisibilityAnim = cx1;
            mFinalVisibility = i;
            return this;
        }

        protected VisibilityAnimListener()
        {
            this$0 = AbsActionBarView.this;
            super();
            mCanceled = false;
        }
    }

}
