// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.view.View;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

public class ScrollerRunnable
    implements Runnable
{
    public static interface ScrollableView
    {

        public abstract int getMaxX();

        public abstract int getMinX();

        public abstract boolean post(Runnable runnable);

        public abstract boolean removeCallbacks(Runnable runnable);

        public abstract void scrollIntoSlots();

        public abstract void trackMotionScroll(int i);
    }


    protected int mAnimationDuration;
    protected boolean mHasMore;
    protected int mLastFlingX;
    private int mOverscrollDistance;
    protected ScrollableView mParent;
    protected int mPreviousX;
    private OverScroller mScroller;
    protected boolean mShouldStopFling;

    public ScrollerRunnable(ScrollableView scrollableview, int i, int j, Interpolator interpolator)
    {
        if (interpolator == null)
        {
            mScroller = new OverScroller(((View)scrollableview).getContext());
        } else
        {
            mScroller = new OverScroller(((View)scrollableview).getContext(), interpolator);
        }
        mOverscrollDistance = j;
        mParent = scrollableview;
        mAnimationDuration = i;
    }

    protected void abortAnimation()
    {
        mScroller.abortAnimation();
    }

    public boolean computeScrollOffset()
    {
        return mScroller.computeScrollOffset();
    }

    public void endFling(boolean flag)
    {
        abortAnimation();
        mLastFlingX = 0;
        mHasMore = false;
        if (flag)
        {
            mParent.scrollIntoSlots();
        }
    }

    public float getCurrVelocity()
    {
        return mScroller.getCurrVelocity();
    }

    public int getCurrX()
    {
        return mScroller.getCurrX();
    }

    public int getLastFlingX()
    {
        return mLastFlingX;
    }

    public int getPreviousX()
    {
        return mPreviousX;
    }

    public boolean hasMore()
    {
        return mHasMore;
    }

    public boolean isFinished()
    {
        return mScroller.isFinished();
    }

    public void run()
    {
        mShouldStopFling = false;
        mPreviousX = getCurrX();
        mHasMore = computeScrollOffset();
        int i = getCurrX();
        mParent.trackMotionScroll(i);
        if (mHasMore && !mShouldStopFling)
        {
            mLastFlingX = i;
            mParent.post(this);
            return;
        } else
        {
            endFling(true);
            return;
        }
    }

    public boolean springBack(int i, int j, int k, int l, int i1, int j1)
    {
        return mScroller.springBack(i, j, k, l, i1, j1);
    }

    protected void startCommon()
    {
        mParent.removeCallbacks(this);
    }

    public void startUsingDistance(int i, int j)
    {
        if (j == 0)
        {
            return;
        } else
        {
            startCommon();
            mLastFlingX = i;
            mScroller.startScroll(i, 0, j, 0, mAnimationDuration);
            mParent.post(this);
            return;
        }
    }

    public void startUsingVelocity(int i, int j)
    {
        if (j == 0)
        {
            return;
        } else
        {
            startCommon();
            mLastFlingX = i;
            mScroller.fling(i, 0, j, 0, mParent.getMinX(), mParent.getMaxX(), 0, 0x7fffffff, mOverscrollDistance, 0);
            mParent.post(this);
            return;
        }
    }

    public void stop(boolean flag)
    {
        mParent.removeCallbacks(this);
        endFling(flag);
    }
}
