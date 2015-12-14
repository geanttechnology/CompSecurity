// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

// Referenced classes of package android.support.design.widget:
//            CollapsingTextHelper, AnimationUtils, ViewUtils, ValueAnimatorCompat, 
//            ViewOffsetHelper, AppBarLayout, ViewGroupUtils

public class CollapsingToolbarLayout extends FrameLayout
{
    public static class LayoutParams extends android.widget.FrameLayout.LayoutParams
    {

        int mCollapseMode;
        float mParallaxMult;

        public void setParallaxMultiplier(float f)
        {
            mParallaxMult = f;
        }

        public LayoutParams(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
            mCollapseMode = 0;
            mParallaxMult = 0.5F;
            context = context.obtainStyledAttributes(attributeset, android.support.design.R.styleable.CollapsingAppBarLayout_LayoutParams);
            mCollapseMode = context.getInt(android.support.design.R.styleable.CollapsingAppBarLayout_LayoutParams_layout_collapseMode, 0);
            setParallaxMultiplier(context.getFloat(android.support.design.R.styleable.CollapsingAppBarLayout_LayoutParams_layout_collapseParallaxMultiplier, 0.5F));
            context.recycle();
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
        {
            super(layoutparams);
            mCollapseMode = 0;
            mParallaxMult = 0.5F;
        }

        public LayoutParams(android.widget.FrameLayout.LayoutParams layoutparams)
        {
            super(layoutparams);
            mCollapseMode = 0;
            mParallaxMult = 0.5F;
        }
    }

    private class OffsetUpdateListener
        implements AppBarLayout.OnOffsetChangedListener
    {

        final CollapsingToolbarLayout this$0;

        public void onOffsetChanged(AppBarLayout appbarlayout, int i)
        {
            View view;
            LayoutParams layoutparams;
            ViewOffsetHelper viewoffsethelper;
            int j;
            int i1;
            mCurrentOffset = i;
            int k;
            int j1;
            if (mLastInsets != null)
            {
                j = mLastInsets.getSystemWindowInsetTop();
            } else
            {
                j = 0;
            }
            i1 = appbarlayout.getTotalScrollRange();
            k = 0;
            j1 = getChildCount();
            if (k >= j1)
            {
                break MISSING_BLOCK_LABEL_174;
            }
            view = getChildAt(k);
            layoutparams = (LayoutParams)view.getLayoutParams();
            viewoffsethelper = CollapsingToolbarLayout.getViewOffsetHelper(view);
            switch (layoutparams.mCollapseMode)
            {
            default:
                break;

            case 1: // '\001'
                break; /* Loop/switch isn't completed */

            case 2: // '\002'
                break;
            }
            break MISSING_BLOCK_LABEL_153;
_L4:
            k++;
            if (true) goto _L2; else goto _L1
_L2:
            break MISSING_BLOCK_LABEL_49;
_L1:
            if ((getHeight() - j) + i >= view.getHeight())
            {
                viewoffsethelper.setTopAndBottomOffset(-i);
            }
            continue; /* Loop/switch isn't completed */
            viewoffsethelper.setTopAndBottomOffset(Math.round((float)(-i) * layoutparams.mParallaxMult));
            if (true) goto _L4; else goto _L3
_L3:
            int l;
            int k1;
            if (mContentScrim != null || mStatusBarScrim != null)
            {
                if (getHeight() + i < getScrimTriggerOffset() + j)
                {
                    showScrim();
                } else
                {
                    hideScrim();
                }
            }
            if (mStatusBarScrim != null && j > 0)
            {
                ViewCompat.postInvalidateOnAnimation(CollapsingToolbarLayout.this);
            }
            l = getHeight();
            k1 = ViewCompat.getMinimumHeight(CollapsingToolbarLayout.this);
            mCollapsingTextHelper.setExpansionFraction((float)Math.abs(i) / (float)(l - k1 - j));
            if (Math.abs(i) == i1)
            {
                ViewCompat.setElevation(appbarlayout, appbarlayout.getTargetElevation());
                return;
            } else
            {
                ViewCompat.setElevation(appbarlayout, 0.0F);
                return;
            }
        }

        private OffsetUpdateListener()
        {
            this$0 = CollapsingToolbarLayout.this;
            super();
        }

    }


    private final CollapsingTextHelper mCollapsingTextHelper;
    private Drawable mContentScrim;
    private int mCurrentOffset;
    private View mDummyView;
    private int mExpandedMarginBottom;
    private int mExpandedMarginLeft;
    private int mExpandedMarginRight;
    private int mExpandedMarginTop;
    private WindowInsetsCompat mLastInsets;
    private AppBarLayout.OnOffsetChangedListener mOnOffsetChangedListener;
    private boolean mRefreshToolbar;
    private int mScrimAlpha;
    private ValueAnimatorCompat mScrimAnimator;
    private boolean mScrimsAreShown;
    private Drawable mStatusBarScrim;
    private final Rect mTmpRect;
    private Toolbar mToolbar;
    private int mToolbarId;

    public CollapsingToolbarLayout(Context context)
    {
        this(context, null);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeset, int i)
    {
        int j = 1;
        super(context, attributeset, i);
        mRefreshToolbar = true;
        mTmpRect = new Rect();
        mCollapsingTextHelper = new CollapsingTextHelper(this);
        mCollapsingTextHelper.setExpandedTextVerticalGravity(80);
        mCollapsingTextHelper.setTextSizeInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
        context = context.obtainStyledAttributes(attributeset, android.support.design.R.styleable.CollapsingToolbarLayout, i, android.support.design.R.style.Widget_Design_CollapsingToolbar);
        i = context.getDimensionPixelSize(android.support.design.R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        mExpandedMarginBottom = i;
        mExpandedMarginRight = i;
        mExpandedMarginTop = i;
        mExpandedMarginLeft = i;
        if (ViewCompat.getLayoutDirection(this) == 1)
        {
            i = j;
        } else
        {
            i = 0;
        }
        if (context.hasValue(android.support.design.R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart))
        {
            j = context.getDimensionPixelSize(android.support.design.R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
            if (i != 0)
            {
                mExpandedMarginRight = j;
            } else
            {
                mExpandedMarginLeft = j;
            }
        }
        if (context.hasValue(android.support.design.R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd))
        {
            j = context.getDimensionPixelSize(android.support.design.R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
            if (i != 0)
            {
                mExpandedMarginLeft = j;
            } else
            {
                mExpandedMarginRight = j;
            }
        }
        if (context.hasValue(android.support.design.R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop))
        {
            mExpandedMarginTop = context.getDimensionPixelSize(android.support.design.R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (context.hasValue(android.support.design.R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom))
        {
            mExpandedMarginBottom = context.getDimensionPixelSize(android.support.design.R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        i = context.getResourceId(android.support.design.R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, android.support.design.R.style.TextAppearance_AppCompat_Title);
        mCollapsingTextHelper.setExpandedTextAppearance(i);
        i = context.getResourceId(android.support.design.R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, android.support.design.R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        mCollapsingTextHelper.setCollapsedTextAppearance(i);
        setContentScrim(context.getDrawable(android.support.design.R.styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(context.getDrawable(android.support.design.R.styleable.CollapsingToolbarLayout_statusBarScrim));
        mToolbarId = context.getResourceId(android.support.design.R.styleable.CollapsingToolbarLayout_toolbarId, -1);
        context.recycle();
        setWillNotDraw(false);
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() {

            final CollapsingToolbarLayout this$0;

            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowinsetscompat)
            {
                mLastInsets = windowinsetscompat;
                requestLayout();
                return windowinsetscompat.consumeSystemWindowInsets();
            }

            
            {
                this$0 = CollapsingToolbarLayout.this;
                super();
            }
        });
    }

    private void animateScrim(int i)
    {
        ensureToolbar();
        if (mScrimAnimator != null) goto _L2; else goto _L1
_L1:
        mScrimAnimator = ViewUtils.createAnimator();
        mScrimAnimator.setDuration(600);
        mScrimAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        mScrimAnimator.setUpdateListener(new ValueAnimatorCompat.AnimatorUpdateListener() {

            final CollapsingToolbarLayout this$0;

            public void onAnimationUpdate(ValueAnimatorCompat valueanimatorcompat)
            {
                setScrimAlpha(valueanimatorcompat.getAnimatedIntValue());
            }

            
            {
                this$0 = CollapsingToolbarLayout.this;
                super();
            }
        });
_L4:
        mScrimAnimator.setIntValues(mScrimAlpha, i);
        mScrimAnimator.start();
        return;
_L2:
        if (mScrimAnimator.isRunning())
        {
            mScrimAnimator.cancel();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void ensureToolbar()
    {
        Toolbar toolbar1;
        Object obj;
        int i;
        int j;
        if (!mRefreshToolbar)
        {
            return;
        }
        toolbar1 = null;
        obj = null;
        i = 0;
        j = getChildCount();
_L7:
        Toolbar toolbar = obj;
        if (i >= j) goto _L2; else goto _L1
_L1:
        View view;
        view = getChildAt(i);
        toolbar = toolbar1;
        if (!(view instanceof Toolbar)) goto _L4; else goto _L3
_L3:
        if (mToolbarId == -1)
        {
            break MISSING_BLOCK_LABEL_148;
        }
        if (mToolbarId != view.getId()) goto _L6; else goto _L5
_L5:
        toolbar = (Toolbar)view;
_L2:
        Toolbar toolbar2 = toolbar;
        if (toolbar == null)
        {
            toolbar2 = toolbar1;
        }
        if (toolbar2 != null)
        {
            mToolbar = toolbar2;
            mDummyView = new View(getContext());
            mToolbar.addView(mDummyView, -1, -1);
        } else
        {
            mToolbar = null;
            mDummyView = null;
        }
        mRefreshToolbar = false;
        return;
_L6:
        toolbar = toolbar1;
        if (toolbar1 == null)
        {
            toolbar = (Toolbar)view;
        }
_L4:
        i++;
        toolbar1 = toolbar;
          goto _L7
        toolbar = (Toolbar)view;
          goto _L2
    }

    private static ViewOffsetHelper getViewOffsetHelper(View view)
    {
        ViewOffsetHelper viewoffsethelper1 = (ViewOffsetHelper)view.getTag(android.support.design.R.id.view_offset_helper);
        ViewOffsetHelper viewoffsethelper = viewoffsethelper1;
        if (viewoffsethelper1 == null)
        {
            viewoffsethelper = new ViewOffsetHelper(view);
            view.setTag(android.support.design.R.id.view_offset_helper, viewoffsethelper);
        }
        return viewoffsethelper;
    }

    private void hideScrim()
    {
        if (mScrimsAreShown)
        {
            if (ViewCompat.isLaidOut(this) && !isInEditMode())
            {
                animateScrim(0);
            } else
            {
                setScrimAlpha(0);
            }
            mScrimsAreShown = false;
        }
    }

    private void setScrimAlpha(int i)
    {
        if (i != mScrimAlpha)
        {
            if (mContentScrim != null && mToolbar != null)
            {
                ViewCompat.postInvalidateOnAnimation(mToolbar);
            }
            mScrimAlpha = i;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private void showScrim()
    {
        if (!mScrimsAreShown)
        {
            if (ViewCompat.isLaidOut(this) && !isInEditMode())
            {
                animateScrim(255);
            } else
            {
                setScrimAlpha(255);
            }
            mScrimsAreShown = true;
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams instanceof LayoutParams;
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        ensureToolbar();
        if (mToolbar == null && mContentScrim != null && mScrimAlpha > 0)
        {
            mContentScrim.mutate().setAlpha(mScrimAlpha);
            mContentScrim.draw(canvas);
        }
        mCollapsingTextHelper.draw(canvas);
        if (mStatusBarScrim != null && mScrimAlpha > 0)
        {
            int i;
            if (mLastInsets != null)
            {
                i = mLastInsets.getSystemWindowInsetTop();
            } else
            {
                i = 0;
            }
            if (i > 0)
            {
                mStatusBarScrim.setBounds(0, -mCurrentOffset, getWidth(), i - mCurrentOffset);
                mStatusBarScrim.mutate().setAlpha(mScrimAlpha);
                mStatusBarScrim.draw(canvas);
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long l)
    {
        ensureToolbar();
        if (view == mToolbar && mContentScrim != null && mScrimAlpha > 0)
        {
            mContentScrim.mutate().setAlpha(mScrimAlpha);
            mContentScrim.draw(canvas);
        }
        return super.drawChild(canvas, view, l);
    }

    protected LayoutParams generateDefaultLayoutParams()
    {
        return new LayoutParams(super.generateDefaultLayoutParams());
    }

    protected volatile android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return generateDefaultLayoutParams();
    }

    protected volatile android.widget.FrameLayout.LayoutParams generateDefaultLayoutParams()
    {
        return generateDefaultLayoutParams();
    }

    public volatile android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return generateLayoutParams(attributeset);
    }

    protected volatile android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return generateLayoutParams(layoutparams);
    }

    public android.widget.FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new LayoutParams(getContext(), attributeset);
    }

    protected android.widget.FrameLayout.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return new LayoutParams(layoutparams);
    }

    public Drawable getContentScrim()
    {
        return mContentScrim;
    }

    final int getScrimTriggerOffset()
    {
        return ViewCompat.getMinimumHeight(this) * 2;
    }

    public Drawable getStatusBarScrim()
    {
        return mStatusBarScrim;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        android.view.ViewParent viewparent = getParent();
        if (viewparent instanceof AppBarLayout)
        {
            if (mOnOffsetChangedListener == null)
            {
                mOnOffsetChangedListener = new OffsetUpdateListener();
            }
            ((AppBarLayout)viewparent).addOnOffsetChangedListener(mOnOffsetChangedListener);
        }
    }

    protected void onDetachedFromWindow()
    {
        android.view.ViewParent viewparent = getParent();
        if (mOnOffsetChangedListener != null && (viewparent instanceof AppBarLayout))
        {
            ((AppBarLayout)viewparent).removeOnOffsetChangedListener(mOnOffsetChangedListener);
        }
        super.onDetachedFromWindow();
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        j = 0;
        for (int i1 = getChildCount(); j < i1; j++)
        {
            View view = getChildAt(j);
            if (mLastInsets != null && !ViewCompat.getFitsSystemWindows(view))
            {
                int j1 = mLastInsets.getSystemWindowInsetTop();
                if (view.getTop() < j1)
                {
                    view.offsetTopAndBottom(j1);
                }
            }
            getViewOffsetHelper(view).onViewLayout();
        }

        if (mDummyView != null)
        {
            ViewGroupUtils.getDescendantRect(this, mDummyView, mTmpRect);
            mCollapsingTextHelper.setCollapsedBounds(mTmpRect.left, l - mTmpRect.height(), mTmpRect.right, l);
            mCollapsingTextHelper.setExpandedBounds(mExpandedMarginLeft + i, mTmpRect.bottom + mExpandedMarginTop, k - mExpandedMarginRight, l - mExpandedMarginBottom);
            mCollapsingTextHelper.recalculate();
        }
        if (mToolbar != null)
        {
            setMinimumHeight(mToolbar.getHeight());
        }
    }

    protected void onMeasure(int i, int j)
    {
        ensureToolbar();
        super.onMeasure(i, j);
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        if (mContentScrim != null)
        {
            mContentScrim.setBounds(0, 0, i, j);
        }
    }

    public void setCollapsedTitleTextAppearance(int i)
    {
        mCollapsingTextHelper.setCollapsedTextAppearance(i);
    }

    public void setCollapsedTitleTextColor(int i)
    {
        mCollapsingTextHelper.setCollapsedTextColor(i);
    }

    public void setContentScrim(Drawable drawable)
    {
        if (mContentScrim != drawable)
        {
            if (mContentScrim != null)
            {
                mContentScrim.setCallback(null);
            }
            mContentScrim = drawable;
            drawable.setBounds(0, 0, getWidth(), getHeight());
            drawable.setCallback(this);
            drawable.mutate().setAlpha(mScrimAlpha);
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setContentScrimColor(int i)
    {
        setContentScrim(new ColorDrawable(i));
    }

    public void setContentScrimResource(int i)
    {
        setContentScrim(ContextCompat.getDrawable(getContext(), i));
    }

    public void setExpandedTitleColor(int i)
    {
        mCollapsingTextHelper.setExpandedTextColor(i);
    }

    public void setExpandedTitleTextAppearance(int i)
    {
        mCollapsingTextHelper.setExpandedTextAppearance(i);
    }

    public void setStatusBarScrim(Drawable drawable)
    {
        if (mStatusBarScrim != drawable)
        {
            if (mStatusBarScrim != null)
            {
                mStatusBarScrim.setCallback(null);
            }
            mStatusBarScrim = drawable;
            drawable.setCallback(this);
            drawable.mutate().setAlpha(mScrimAlpha);
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarScrimColor(int i)
    {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setStatusBarScrimResource(int i)
    {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), i));
    }

    public void setTitle(CharSequence charsequence)
    {
        mCollapsingTextHelper.setText(charsequence);
    }



/*
    static WindowInsetsCompat access$002(CollapsingToolbarLayout collapsingtoolbarlayout, WindowInsetsCompat windowinsetscompat)
    {
        collapsingtoolbarlayout.mLastInsets = windowinsetscompat;
        return windowinsetscompat;
    }

*/



/*
    static int access$302(CollapsingToolbarLayout collapsingtoolbarlayout, int i)
    {
        collapsingtoolbarlayout.mCurrentOffset = i;
        return i;
    }

*/






}
