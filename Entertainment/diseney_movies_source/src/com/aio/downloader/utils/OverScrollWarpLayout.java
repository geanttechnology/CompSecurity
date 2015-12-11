// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;

public class OverScrollWarpLayout extends LinearLayout
{

    private static final float OVERSHOOT_TENSION = 0.75F;
    private Scroller mScroller;

    public OverScrollWarpLayout(Context context)
    {
        super(context);
        setOrientation(1);
        mScroller = new Scroller(getContext(), new OvershootInterpolator(0.75F));
    }

    public OverScrollWarpLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        setOrientation(1);
        mScroller = new Scroller(getContext(), new OvershootInterpolator(0.75F));
    }

    public void computeScroll()
    {
        if (mScroller.computeScrollOffset())
        {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
        super.computeScroll();
    }

    public final int getScrollerCurrY()
    {
        return mScroller.getCurrY();
    }

    public void smoothScrollBy(int i, int j)
    {
        mScroller.startScroll(mScroller.getFinalX(), mScroller.getFinalY(), i, j);
        invalidate();
    }

    public void smoothScrollTo(int i, int j)
    {
        smoothScrollBy(i - mScroller.getFinalX(), j - mScroller.getFinalY());
    }

    public final void smoothScrollToNormal()
    {
        smoothScrollTo(0, 0);
    }
}
