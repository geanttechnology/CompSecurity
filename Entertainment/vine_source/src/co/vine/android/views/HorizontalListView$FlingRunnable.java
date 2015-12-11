// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.views;

import android.widget.Scroller;

// Referenced classes of package co.vine.android.views:
//            HorizontalListView

private class mScroller
    implements Runnable
{

    private int mLastFlingX;
    private int mScreenWidth;
    private final Scroller mScroller;
    final HorizontalListView this$0;

    public void run()
    {
        int i = getChildCount();
        if (HorizontalListView.access$400(HorizontalListView.this) == 0 || i == 0)
        {
            stop();
            return;
        }
        Scroller scroller = mScroller;
        boolean flag = scroller.computeScrollOffset();
        int j = scroller.getCurrX();
        i = mLastFlingX - j;
        boolean flag1;
        if (i > 0)
        {
            i = Math.min(mScreenWidth, i);
        } else
        {
            i = Math.max(-mScreenWidth, i);
        }
        flag1 = scroll(i, i);
        if (flag)
        {
            if (flag1)
            {
                mLastFlingX = j;
                post(this);
                return;
            }
            if (i > 0)
            {
                i = HorizontalListView.access$1800(HorizontalListView.this);
            } else
            {
                i = -HorizontalListView.access$1900(HorizontalListView.this);
            }
            scroll(i, i);
            stop();
            return;
        } else
        {
            stop();
            return;
        }
    }

    public void start(int i)
    {
        if (i == 0)
        {
            return;
        }
        HorizontalListView.access$002(HorizontalListView.this, 4);
        mScreenWidth = getWidth() - getPaddingLeft() - getPaddingRight() - 1;
        removeCallbacks(this);
        int j;
        if (i < 0)
        {
            j = 0x7fffffff;
        } else
        {
            j = 0;
        }
        mLastFlingX = j;
        mScroller.fling(j, 0, i, 0, 0, 0x7fffffff, 0, 0x7fffffff);
        post(this);
    }

    public void stop()
    {
        if (HorizontalListView.access$000(HorizontalListView.this) == 4)
        {
            HorizontalListView.access$002(HorizontalListView.this, -1);
            removeCallbacks(this);
            if (!mScroller.isFinished())
            {
                mScroller.abortAnimation();
                invalidate();
            }
        }
    }

    public ()
    {
        this$0 = HorizontalListView.this;
        super();
        mScroller = new Scroller(getContext());
    }
}
