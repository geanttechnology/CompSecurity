// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.os.SystemClock;
import android.view.View;

// Referenced classes of package com.mobeta.android.dslv:
//            DragSortListView

private class mScrolling
    implements Runnable
{

    public static final int DOWN = 1;
    public static final int STOP = -1;
    public static final int UP = 0;
    private float dt;
    private int dy;
    private boolean mAbort;
    private long mCurrTime;
    private int mFirstFooter;
    private int mLastHeader;
    private long mPrevTime;
    private float mScrollSpeed;
    private boolean mScrolling;
    private int scrollDir;
    private long tStart;
    final DragSortListView this$0;

    public int getScrollDir()
    {
        if (mScrolling)
        {
            return scrollDir;
        } else
        {
            return -1;
        }
    }

    public boolean isScrolling()
    {
        return mScrolling;
    }

    public void run()
    {
        if (mAbort)
        {
            mScrolling = false;
            return;
        }
        int j = getFirstVisiblePosition();
        int i = getLastVisiblePosition();
        int l = getCount();
        int k = getPaddingTop();
        int i1 = getHeight() - k - getPaddingBottom();
        int j1 = Math.min(DragSortListView.access$7(DragSortListView.this), DragSortListView.access$23(DragSortListView.this) + DragSortListView.access$3(DragSortListView.this));
        int k1 = Math.max(DragSortListView.access$7(DragSortListView.this), DragSortListView.access$23(DragSortListView.this) - DragSortListView.access$3(DragSortListView.this));
        View view1;
        if (scrollDir == 0)
        {
            View view = getChildAt(0);
            if (view == null)
            {
                mScrolling = false;
                return;
            }
            if (j == 0 && view.getTop() == k)
            {
                mScrolling = false;
                return;
            }
            mScrollSpeed = DragSortListView.access$24(DragSortListView.this).getSpeed((DragSortListView.access$25(DragSortListView.this) - (float)k1) / DragSortListView.access$26(DragSortListView.this), mPrevTime);
        } else
        {
            View view2 = getChildAt(i - j);
            if (view2 == null)
            {
                mScrolling = false;
                return;
            }
            if (i == l - 1 && view2.getBottom() <= i1 + k)
            {
                mScrolling = false;
                return;
            }
            mScrollSpeed = -DragSortListView.access$24(DragSortListView.this).getSpeed(((float)j1 - DragSortListView.access$27(DragSortListView.this)) / DragSortListView.access$28(DragSortListView.this), mPrevTime);
        }
        mCurrTime = SystemClock.uptimeMillis();
        dt = mCurrTime - mPrevTime;
        dy = Math.round(mScrollSpeed * dt);
        if (dy >= 0)
        {
            dy = Math.min(i1, dy);
            i = j;
        } else
        {
            dy = Math.max(-i1, dy);
        }
        view1 = getChildAt(i - j);
        l = view1.getTop() + dy;
        j = l;
        if (i == 0)
        {
            j = l;
            if (l > k)
            {
                j = k;
            }
        }
        DragSortListView.access$29(DragSortListView.this, true);
        setSelectionFromTop(i, j - k);
        layoutChildren();
        invalidate();
        DragSortListView.access$29(DragSortListView.this, false);
        DragSortListView.access$30(DragSortListView.this, i, view1, false);
        mPrevTime = mCurrTime;
        post(this);
    }

    public void startScrolling(int i)
    {
        if (!mScrolling)
        {
            mAbort = false;
            mScrolling = true;
            tStart = SystemClock.uptimeMillis();
            mPrevTime = tStart;
            scrollDir = i;
            post(this);
        }
    }

    public void stopScrolling(boolean flag)
    {
        if (flag)
        {
            removeCallbacks(this);
            mScrolling = false;
            return;
        } else
        {
            mAbort = true;
            return;
        }
    }

    public file()
    {
        this$0 = DragSortListView.this;
        super();
        mScrolling = false;
    }
}
