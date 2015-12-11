// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.dragsort;

import android.os.SystemClock;
import android.view.View;
import co.vine.android.views.HorizontalListView;

// Referenced classes of package co.vine.android.dragsort:
//            DragSortWidget

public class mScrolling
    implements Runnable
{

    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    private float dt;
    private int dx;
    private boolean mAbort;
    private long mCurrTime;
    private long mPrevTime;
    private float mScrollSpeed;
    private boolean mScrolling;
    private int scrollDir;
    private long tStart;
    final DragSortWidget this$0;

    public void run()
    {
        if (mAbort)
        {
            mScrolling = false;
            return;
        }
        int k = DragSortWidget.access$100(DragSortWidget.this);
        int i = DragSortWidget.access$000(DragSortWidget.this).getFirstVisiblePosition();
        int j = DragSortWidget.access$000(DragSortWidget.this).getLastVisiblePosition();
        int l = DragSortWidget.access$000(DragSortWidget.this).getCount();
        int i1 = DragSortWidget.access$000(DragSortWidget.this).getWidth();
        if (scrollDir == 0)
        {
            View view = DragSortWidget.access$000(DragSortWidget.this).getChildAt(0);
            if (view == null)
            {
                mScrolling = false;
                return;
            }
            if (i == 0 && view.getLeft() == 0)
            {
                mScrolling = false;
                return;
            }
            j = DragSortWidget.access$200(DragSortWidget.this) - DragSortWidget.access$000(DragSortWidget.this).getLeft();
            i = j;
            if (j < 0)
            {
                i = 0;
            }
            mScrollSpeed = DragSortWidget.access$300(DragSortWidget.this) / (float)(i + 1);
        } else
        {
            View view1 = DragSortWidget.access$000(DragSortWidget.this).getChildAt(j - i);
            if (view1 == null)
            {
                mScrolling = false;
                return;
            }
            if (j == l - 1 && view1.getRight() <= i1)
            {
                mScrolling = false;
                return;
            }
            j = (i1 - DragSortWidget.access$200(DragSortWidget.this)) + DragSortWidget.access$000(DragSortWidget.this).getLeft();
            i = j;
            if (j < 0)
            {
                i = 0;
            }
            mScrollSpeed = -DragSortWidget.access$300(DragSortWidget.this) / (float)(i + 1);
        }
        mCurrTime = SystemClock.uptimeMillis();
        dt = mCurrTime - mPrevTime;
        dx = Math.round(mScrollSpeed * dt);
        DragSortWidget.access$000(DragSortWidget.this).scroll(dx, dx);
        mPrevTime = mCurrTime;
        DragSortWidget.access$102(DragSortWidget.this, DragSortWidget.access$400(DragSortWidget.this));
        if (DragSortWidget.access$100(DragSortWidget.this) == -1)
        {
            DragSortWidget.access$102(DragSortWidget.this, k);
        }
        DragSortWidget.access$500(DragSortWidget.this, k, DragSortWidget.access$100(DragSortWidget.this));
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
            DragSortWidget.access$000(DragSortWidget.this).removeCallbacks(this);
            mScrolling = false;
            return;
        } else
        {
            mAbort = true;
            return;
        }
    }

    public ()
    {
        this$0 = DragSortWidget.this;
        super();
        mScrollSpeed = 0.0F;
        mScrolling = false;
    }
}
