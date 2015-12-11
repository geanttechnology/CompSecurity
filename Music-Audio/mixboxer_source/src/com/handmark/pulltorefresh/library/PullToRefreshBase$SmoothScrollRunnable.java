// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.view.animation.Interpolator;
import com.handmark.pulltorefresh.library.internal.ViewCompat;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            PullToRefreshBase

final class mListener
    implements Runnable
{

    private boolean mContinueRunning;
    private int mCurrentY;
    private final long mDuration;
    private final Interpolator mInterpolator;
    private dListener mListener;
    private final int mScrollFromY;
    private final int mScrollToY;
    private long mStartTime;
    final PullToRefreshBase this$0;

    public final void run()
    {
        if (mStartTime == -1L)
        {
            mStartTime = System.currentTimeMillis();
        } else
        {
            long l = Math.max(Math.min(((System.currentTimeMillis() - mStartTime) * 1000L) / mDuration, 1000L), 0L);
            float f = mScrollFromY - mScrollToY;
            int i = Math.round(mInterpolator.getInterpolation((float)l / 1000F) * f);
            mCurrentY = mScrollFromY - i;
            setHeaderScroll(mCurrentY);
        }
        if (mContinueRunning && mScrollToY != mCurrentY)
        {
            ViewCompat.postOnAnimation(PullToRefreshBase.this, this);
        } else
        if (mListener != null)
        {
            mListener.onSmoothScrollFinished();
            return;
        }
    }

    public final void stop()
    {
        mContinueRunning = false;
        removeCallbacks(this);
    }

    public dListener(int i, int j, long l, dListener dlistener)
    {
        this$0 = PullToRefreshBase.this;
        super();
        mContinueRunning = true;
        mStartTime = -1L;
        mCurrentY = -1;
        mScrollFromY = i;
        mScrollToY = j;
        mInterpolator = PullToRefreshBase.access$100(PullToRefreshBase.this);
        mDuration = l;
        mListener = dlistener;
    }
}
