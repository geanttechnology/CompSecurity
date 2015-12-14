// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import al;
import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.HorizontalScrollView;
import b;
import cv;
import dh;
import di;
import dj;
import dk;
import r;

// Referenced classes of package android.support.v7.internal.widget:
//            SpinnerCompat, AdapterViewCompat

public class ScrollingTabContainerView extends HorizontalScrollView
    implements cv
{

    private static final int FADE_DURATION = 200;
    private static final String TAG = "ScrollingTabContainerView";
    private static final Interpolator sAlphaInterpolator = new DecelerateInterpolator();
    private boolean mAllowCollapse;
    private int mContentHeight;
    public int mMaxTabWidth;
    private int mSelectedTabIndex;
    int mStackedTabMaxWidth;
    private dj mTabClickListener;
    private LinearLayoutCompat mTabLayout;
    public Runnable mTabSelector;
    private SpinnerCompat mTabSpinner;
    protected final VisibilityAnimListener mVisAnimListener = new VisibilityAnimListener();
    protected ViewPropertyAnimatorCompat mVisibilityAnim;

    public ScrollingTabContainerView(Context context)
    {
        super(context);
        setHorizontalScrollBarEnabled(false);
        context = al.a(context);
        setContentHeight(context.e());
        mStackedTabMaxWidth = context.g();
        mTabLayout = createTabLayout();
        addView(mTabLayout, new android.view.ViewGroup.LayoutParams(-2, -1));
    }

    private SpinnerCompat createSpinner()
    {
        SpinnerCompat spinnercompat = new SpinnerCompat(getContext(), null, r.actionDropDownStyle);
        spinnercompat.setLayoutParams(new android.support.v7.widget.LinearLayoutCompat.LayoutParams(-2, -1));
        spinnercompat.a(this);
        return spinnercompat;
    }

    private LinearLayoutCompat createTabLayout()
    {
        LinearLayoutCompat linearlayoutcompat = new LinearLayoutCompat(getContext(), null, r.actionBarTabBarStyle);
        linearlayoutcompat.setMeasureWithLargestChildEnabled(true);
        linearlayoutcompat.setGravity(17);
        linearlayoutcompat.setLayoutParams(new android.support.v7.widget.LinearLayoutCompat.LayoutParams(-2, -1));
        return linearlayoutcompat;
    }

    private dk createTabView(b b1, boolean flag)
    {
        b1 = new dk(this, getContext(), b1, flag);
        if (flag)
        {
            b1.setBackgroundDrawable(null);
            b1.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, mContentHeight));
            return b1;
        }
        b1.setFocusable(true);
        if (mTabClickListener == null)
        {
            mTabClickListener = new dj(this, null);
        }
        b1.setOnClickListener(mTabClickListener);
        return b1;
    }

    private boolean isCollapsed()
    {
        return mTabSpinner != null && mTabSpinner.getParent() == this;
    }

    private void performCollapse()
    {
        if (isCollapsed())
        {
            return;
        }
        if (mTabSpinner == null)
        {
            mTabSpinner = createSpinner();
        }
        removeView(mTabLayout);
        addView(mTabSpinner, new android.view.ViewGroup.LayoutParams(-2, -1));
        if (mTabSpinner.c() == null)
        {
            mTabSpinner.a(new di(this, null));
        }
        if (mTabSelector != null)
        {
            removeCallbacks(mTabSelector);
            mTabSelector = null;
        }
        mTabSpinner.setSelection(mSelectedTabIndex);
    }

    private boolean performExpand()
    {
        if (!isCollapsed())
        {
            return false;
        } else
        {
            removeView(mTabSpinner);
            addView(mTabLayout, new android.view.ViewGroup.LayoutParams(-2, -1));
            setTabSelected(mTabSpinner.getSelectedItemPosition());
            return false;
        }
    }

    public void addTab(b b1, int i, boolean flag)
    {
        b1 = createTabView(b1, false);
        mTabLayout.addView(b1, i, new android.support.v7.widget.LinearLayoutCompat.LayoutParams(0, -1, 1.0F));
        if (mTabSpinner != null)
        {
            ((di)mTabSpinner.c()).notifyDataSetChanged();
        }
        if (flag)
        {
            b1.setSelected(true);
        }
        if (mAllowCollapse)
        {
            requestLayout();
        }
    }

    public void addTab(b b1, boolean flag)
    {
        b1 = createTabView(b1, false);
        mTabLayout.addView(b1, new android.support.v7.widget.LinearLayoutCompat.LayoutParams(0, -1, 1.0F));
        if (mTabSpinner != null)
        {
            ((di)mTabSpinner.c()).notifyDataSetChanged();
        }
        if (flag)
        {
            b1.setSelected(true);
        }
        if (mAllowCollapse)
        {
            requestLayout();
        }
    }

    public void animateToTab(int i)
    {
        View view = mTabLayout.getChildAt(i);
        if (mTabSelector != null)
        {
            removeCallbacks(mTabSelector);
        }
        mTabSelector = new dh(this, view);
        post(mTabSelector);
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
            }
            ViewPropertyAnimatorCompat viewpropertyanimatorcompat = ViewCompat.animate(this).alpha(1.0F);
            viewpropertyanimatorcompat.setDuration(200L);
            viewpropertyanimatorcompat.setInterpolator(sAlphaInterpolator);
            viewpropertyanimatorcompat.setListener(mVisAnimListener.a(viewpropertyanimatorcompat, i));
            viewpropertyanimatorcompat.start();
            return;
        } else
        {
            ViewPropertyAnimatorCompat viewpropertyanimatorcompat1 = ViewCompat.animate(this).alpha(0.0F);
            viewpropertyanimatorcompat1.setDuration(200L);
            viewpropertyanimatorcompat1.setInterpolator(sAlphaInterpolator);
            viewpropertyanimatorcompat1.setListener(mVisAnimListener.a(viewpropertyanimatorcompat1, i));
            viewpropertyanimatorcompat1.start();
            return;
        }
    }

    public void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (mTabSelector != null)
        {
            post(mTabSelector);
        }
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            super.onConfigurationChanged(configuration);
        }
        configuration = al.a(getContext());
        setContentHeight(configuration.e());
        mStackedTabMaxWidth = configuration.g();
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (mTabSelector != null)
        {
            removeCallbacks(mTabSelector);
        }
    }

    public void onItemClick(AdapterViewCompat adapterviewcompat, View view, int i, long l)
    {
        ((dk)view).b().d();
    }

    public void onMeasure(int i, int j)
    {
        j = 1;
        int k = android.view.View.MeasureSpec.getMode(i);
        int i1;
        boolean flag;
        if (k == 0x40000000)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setFillViewport(flag);
        i1 = mTabLayout.getChildCount();
        if (i1 > 1 && (k == 0x40000000 || k == 0x80000000))
        {
            int l;
            if (i1 > 2)
            {
                mMaxTabWidth = (int)((float)android.view.View.MeasureSpec.getSize(i) * 0.4F);
            } else
            {
                mMaxTabWidth = android.view.View.MeasureSpec.getSize(i) / 2;
            }
            mMaxTabWidth = Math.min(mMaxTabWidth, mStackedTabMaxWidth);
        } else
        {
            mMaxTabWidth = -1;
        }
        l = android.view.View.MeasureSpec.makeMeasureSpec(mContentHeight, 0x40000000);
        if (flag || !mAllowCollapse)
        {
            j = 0;
        }
        if (j != 0)
        {
            mTabLayout.measure(0, l);
            if (mTabLayout.getMeasuredWidth() > android.view.View.MeasureSpec.getSize(i))
            {
                performCollapse();
            } else
            {
                performExpand();
            }
        } else
        {
            performExpand();
        }
        j = getMeasuredWidth();
        super.onMeasure(i, l);
        i = getMeasuredWidth();
        if (flag && j != i)
        {
            setTabSelected(mSelectedTabIndex);
        }
    }

    public void removeAllTabs()
    {
        mTabLayout.removeAllViews();
        if (mTabSpinner != null)
        {
            ((di)mTabSpinner.c()).notifyDataSetChanged();
        }
        if (mAllowCollapse)
        {
            requestLayout();
        }
    }

    public void removeTabAt(int i)
    {
        mTabLayout.removeViewAt(i);
        if (mTabSpinner != null)
        {
            ((di)mTabSpinner.c()).notifyDataSetChanged();
        }
        if (mAllowCollapse)
        {
            requestLayout();
        }
    }

    public void setAllowCollapse(boolean flag)
    {
        mAllowCollapse = flag;
    }

    public void setContentHeight(int i)
    {
        mContentHeight = i;
        requestLayout();
    }

    public void setTabSelected(int i)
    {
        mSelectedTabIndex = i;
        int k = mTabLayout.getChildCount();
        int j = 0;
        while (j < k) 
        {
            View view = mTabLayout.getChildAt(j);
            boolean flag;
            if (j == i)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.setSelected(flag);
            if (flag)
            {
                animateToTab(i);
            }
            j++;
        }
        if (mTabSpinner != null && i >= 0)
        {
            mTabSpinner.setSelection(i);
        }
    }

    public void updateTab(int i)
    {
        ((dk)mTabLayout.getChildAt(i)).a();
        if (mTabSpinner != null)
        {
            ((di)mTabSpinner.c()).notifyDataSetChanged();
        }
        if (mAllowCollapse)
        {
            requestLayout();
        }
    }




    private class VisibilityAnimListener
        implements ViewPropertyAnimatorListener
    {

        final ScrollingTabContainerView a;
        private boolean b;
        private int c;

        public VisibilityAnimListener a(ViewPropertyAnimatorCompat viewpropertyanimatorcompat, int i)
        {
            c = i;
            a.mVisibilityAnim = viewpropertyanimatorcompat;
            return this;
        }

        public void onAnimationCancel(View view)
        {
            b = true;
        }

        public void onAnimationEnd(View view)
        {
            if (b)
            {
                return;
            } else
            {
                a.mVisibilityAnim = null;
                a.setVisibility(c);
                return;
            }
        }

        public void onAnimationStart(View view)
        {
            a.setVisibility(0);
            b = false;
        }

        protected VisibilityAnimListener()
        {
            a = ScrollingTabContainerView.this;
            super();
            b = false;
        }
    }

}
