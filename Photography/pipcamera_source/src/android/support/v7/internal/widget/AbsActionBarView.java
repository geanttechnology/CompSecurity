// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ActionMenuView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import x;

abstract class AbsActionBarView extends ViewGroup
{

    private static final int FADE_DURATION = 200;
    private static final Interpolator sAlphaInterpolator = new DecelerateInterpolator();
    protected ActionMenuPresenter mActionMenuPresenter;
    protected int mContentHeight;
    protected ActionMenuView mMenuView;
    protected final Context mPopupContext;
    protected boolean mSplitActionBar;
    protected ViewGroup mSplitView;
    protected boolean mSplitWhenNarrow;
    protected final VisibilityAnimListener mVisAnimListener;
    protected ViewPropertyAnimatorCompat mVisibilityAnim;

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

    public void animateToVisibility(int i)
    {
        if (mVisibilityAnim != null)
        {
            mVisibilityAnim.cancel();
        }
        if (i == 0)
        {
            if (getVisibility() != 0)
            {
                ViewCompat.setAlpha(this, 0.0F);
                if (mSplitView != null && mMenuView != null)
                {
                    ViewCompat.setAlpha(mMenuView, 0.0F);
                }
            }
            ViewPropertyAnimatorCompat viewpropertyanimatorcompat = ViewCompat.animate(this).alpha(1.0F);
            viewpropertyanimatorcompat.setDuration(200L);
            viewpropertyanimatorcompat.setInterpolator(sAlphaInterpolator);
            if (mSplitView != null && mMenuView != null)
            {
                x x1 = new x();
                ViewPropertyAnimatorCompat viewpropertyanimatorcompat2 = ViewCompat.animate(mMenuView).alpha(1.0F);
                viewpropertyanimatorcompat2.setDuration(200L);
                x1.a(mVisAnimListener.a(viewpropertyanimatorcompat, i));
                x1.a(viewpropertyanimatorcompat).a(viewpropertyanimatorcompat2);
                x1.a();
                return;
            } else
            {
                viewpropertyanimatorcompat.setListener(mVisAnimListener.a(viewpropertyanimatorcompat, i));
                viewpropertyanimatorcompat.start();
                return;
            }
        }
        ViewPropertyAnimatorCompat viewpropertyanimatorcompat1 = ViewCompat.animate(this).alpha(0.0F);
        viewpropertyanimatorcompat1.setDuration(200L);
        viewpropertyanimatorcompat1.setInterpolator(sAlphaInterpolator);
        if (mSplitView != null && mMenuView != null)
        {
            x x2 = new x();
            ViewPropertyAnimatorCompat viewpropertyanimatorcompat3 = ViewCompat.animate(mMenuView).alpha(0.0F);
            viewpropertyanimatorcompat3.setDuration(200L);
            x2.a(mVisAnimListener.a(viewpropertyanimatorcompat1, i));
            x2.a(viewpropertyanimatorcompat1).a(viewpropertyanimatorcompat3);
            x2.a();
            return;
        } else
        {
            viewpropertyanimatorcompat1.setListener(mVisAnimListener.a(viewpropertyanimatorcompat1, i));
            viewpropertyanimatorcompat1.start();
            return;
        }
    }

    public boolean canShowOverflowMenu()
    {
        return isOverflowReserved() && getVisibility() == 0;
    }

    public void dismissPopupMenus()
    {
        if (mActionMenuPresenter != null)
        {
            mActionMenuPresenter.e();
        }
    }

    public int getAnimatedVisibility()
    {
        if (mVisibilityAnim != null)
        {
            return mVisAnimListener.a;
        } else
        {
            return getVisibility();
        }
    }

    public int getContentHeight()
    {
        return mContentHeight;
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

    public boolean isOverflowMenuShowPending()
    {
        if (mActionMenuPresenter != null)
        {
            return mActionMenuPresenter.h();
        } else
        {
            return false;
        }
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

    public boolean isOverflowReserved()
    {
        return mActionMenuPresenter != null && mActionMenuPresenter.i();
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
            mActionMenuPresenter.a(configuration);
        }
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

    public void postShowOverflowMenu()
    {
        post(new Runnable() {

            final AbsActionBarView a;

            public void run()
            {
                a.showOverflowMenu();
            }

            
            {
                a = AbsActionBarView.this;
                super();
            }
        });
    }

    public void setContentHeight(int i)
    {
        mContentHeight = i;
        requestLayout();
    }

    public void setSplitToolbar(boolean flag)
    {
        mSplitActionBar = flag;
    }

    public void setSplitView(ViewGroup viewgroup)
    {
        mSplitView = viewgroup;
    }

    public void setSplitWhenNarrow(boolean flag)
    {
        mSplitWhenNarrow = flag;
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


    private class VisibilityAnimListener
        implements ViewPropertyAnimatorListener
    {

        int a;
        final AbsActionBarView b;
        private boolean c;

        public VisibilityAnimListener a(ViewPropertyAnimatorCompat viewpropertyanimatorcompat, int i)
        {
            b.mVisibilityAnim = viewpropertyanimatorcompat;
            a = i;
            return this;
        }

        public void onAnimationCancel(View view)
        {
            c = true;
        }

        public void onAnimationEnd(View view)
        {
            if (!c)
            {
                b.mVisibilityAnim = null;
                b.setVisibility(a);
                if (b.mSplitView != null && b.mMenuView != null)
                {
                    b.mMenuView.setVisibility(a);
                    return;
                }
            }
        }

        public void onAnimationStart(View view)
        {
            b.setVisibility(0);
            c = false;
        }

        protected VisibilityAnimListener()
        {
            b = AbsActionBarView.this;
            super();
            c = false;
        }
    }

}
