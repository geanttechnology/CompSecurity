// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.ListAdapter;
import com.twitter.android.widget.RefreshableListView;

// Referenced classes of package co.vine.android.widget:
//            PinnedHeaderAdapter

public class PinnedHeaderListView extends RefreshableListView
    implements android.widget.AbsListView.OnScrollListener
{
    public static interface ScrollDeltaListener
    {

        public abstract void onScroll(int i);
    }


    private int mNavBottom;
    private android.widget.AbsListView.OnScrollListener mOnScrollListener;
    private PinnedHeaderAdapter mPinnedHeaderAdapter;
    private int mPinnedHeaderHeight;
    private boolean mPinnedHeaderIsVisible;
    private int mPinnedHeaderOffset;
    private View mPinnedHeaderView;
    private ScrollDeltaListener mScrollDeltaListener;
    private View mTrackedChild;
    private int mTrackedChildPrevPosition;
    private int mTrackedChildPrevTop;

    public PinnedHeaderListView(Context context)
    {
        super(context);
        mPinnedHeaderOffset = 0;
        mPinnedHeaderIsVisible = true;
        mPinnedHeaderView = null;
        mOnScrollListener = null;
        mPinnedHeaderAdapter = null;
        mPinnedHeaderHeight = 0;
        mTrackedChild = null;
        mTrackedChildPrevTop = 0;
        mTrackedChildPrevPosition = 0;
        mScrollDeltaListener = null;
        mNavBottom = 0;
        init();
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mPinnedHeaderOffset = 0;
        mPinnedHeaderIsVisible = true;
        mPinnedHeaderView = null;
        mOnScrollListener = null;
        mPinnedHeaderAdapter = null;
        mPinnedHeaderHeight = 0;
        mTrackedChild = null;
        mTrackedChildPrevTop = 0;
        mTrackedChildPrevPosition = 0;
        mScrollDeltaListener = null;
        mNavBottom = 0;
        init();
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mPinnedHeaderOffset = 0;
        mPinnedHeaderIsVisible = true;
        mPinnedHeaderView = null;
        mOnScrollListener = null;
        mPinnedHeaderAdapter = null;
        mPinnedHeaderHeight = 0;
        mTrackedChild = null;
        mTrackedChildPrevTop = 0;
        mTrackedChildPrevPosition = 0;
        mScrollDeltaListener = null;
        mNavBottom = 0;
        init();
    }

    private void ensureHeaderHasLayoutParams(View view)
    {
        android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
        if (layoutparams == null)
        {
            view.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, -2));
        } else
        if (layoutparams.height == -1)
        {
            layoutparams.height = -2;
            view.setLayoutParams(layoutparams);
            return;
        }
    }

    private View getChildInTheMiddle()
    {
        return getChildAt(getChildCount() / 2);
    }

    private void init()
    {
        super.setOnScrollListener(this);
    }

    private void measureHeader(View view)
    {
        if (view != null)
        {
            measureChild(view, android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(mPinnedHeaderHeight, 0x40000000));
        }
    }

    public void dispatchDraw(Canvas canvas)
    {
        super.dispatchDraw(canvas);
        if (mPinnedHeaderIsVisible && mPinnedHeaderView != null && !isMode(2) && mPinnedHeaderOffset > -mPinnedHeaderHeight)
        {
            canvas.save();
            canvas.clipRect(0, mPinnedHeaderOffset + mNavBottom, getWidth(), mPinnedHeaderHeight + mPinnedHeaderOffset + mNavBottom);
            canvas.translate(0.0F, mPinnedHeaderOffset + mNavBottom);
            mPinnedHeaderView.draw(canvas);
            canvas.restore();
        }
    }

    public int getPinnedHeaderBottomAbs()
    {
        int ai[] = new int[2];
        getLocationInWindow(ai);
        return mPinnedHeaderOffset + mPinnedHeaderHeight + mNavBottom + ai[1];
    }

    public int getPositionForPixelLocation(int i)
    {
        for (int j = 0; j < getChildCount(); j++)
        {
            View view = getChildAt(j);
            if (view != null && view.getTop() <= i && view.getBottom() >= i)
            {
                return j;
            }
        }

        return 0;
    }

    public boolean isAbsoluteTouchInPinnedHeader(MotionEvent motionevent)
    {
        int ai[] = new int[2];
        getLocationInWindow(ai);
        return mPinnedHeaderIsVisible && mPinnedHeaderView != null && motionevent.getRawY() > (float)(mNavBottom + ai[1]) && motionevent.getRawY() < (float)(mNavBottom + mPinnedHeaderOffset + mPinnedHeaderHeight + ai[1]);
    }

    public boolean isTouchInPinnedHeader(MotionEvent motionevent)
    {
        return mPinnedHeaderIsVisible && mPinnedHeaderView != null && motionevent.getY() > (float)mNavBottom && motionevent.getY() < (float)(mPinnedHeaderOffset + mPinnedHeaderHeight + mNavBottom);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (isTouchInPinnedHeader(motionevent))
        {
            return true;
        } else
        {
            return super.onInterceptTouchEvent(motionevent);
        }
    }

    public void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        measureHeader(mPinnedHeaderView);
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (mPinnedHeaderAdapter != null)
        {
            PinnedHeaderAdapter.PinnedHeaderStatus pinnedheaderstatus = mPinnedHeaderAdapter.getPinnedHeaderStatus(mNavBottom);
            if (pinnedheaderstatus != null)
            {
                mPinnedHeaderOffset = pinnedheaderstatus.pinnedHeaderOffset;
                mPinnedHeaderIsVisible = pinnedheaderstatus.pinnedHeaderIsVisible;
                if (pinnedheaderstatus.shouldRequestNewView)
                {
                    mPinnedHeaderHeight = mPinnedHeaderAdapter.getPinnedHeaderHeight();
                    mPinnedHeaderView = mPinnedHeaderAdapter.getPinnedHeaderView(mPinnedHeaderView);
                    if (mPinnedHeaderView != null)
                    {
                        ensureHeaderHasLayoutParams(mPinnedHeaderView);
                        measureHeader(mPinnedHeaderView);
                        mPinnedHeaderAdapter.layoutPinnedHeader(mPinnedHeaderView, 0, mPinnedHeaderOffset + mNavBottom, getWidth(), mNavBottom + mPinnedHeaderOffset + mPinnedHeaderHeight);
                    }
                }
            }
        }
        if (mOnScrollListener != null)
        {
            mOnScrollListener.onScroll(abslistview, i, j, k);
        }
    }

    protected void onScrollChanged(int i, int j, int k, int l)
    {
        super.onScrollChanged(i, j, k, l);
        if (mTrackedChild == null)
        {
            if (getChildCount() > 0)
            {
                mTrackedChild = getChildInTheMiddle();
                mTrackedChildPrevTop = mTrackedChild.getTop();
                mTrackedChildPrevPosition = getPositionForView(mTrackedChild);
            }
            return;
        }
        if (mTrackedChild.getParent() == this && getPositionForView(mTrackedChild) == mTrackedChildPrevPosition)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            i = mTrackedChild.getTop();
            if (mScrollDeltaListener != null)
            {
                j = mTrackedChildPrevTop;
                mScrollDeltaListener.onScroll(i - j);
            }
            mTrackedChildPrevTop = i;
            return;
        } else
        {
            mTrackedChild = null;
            return;
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        if (mOnScrollListener != null)
        {
            mOnScrollListener.onScrollStateChanged(abslistview, i);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (isTouchInPinnedHeader(motionevent))
        {
            motionevent.setLocation(motionevent.getX(), motionevent.getY() - (float)mPinnedHeaderOffset - (float)mNavBottom);
            return mPinnedHeaderView.dispatchTouchEvent(motionevent);
        } else
        {
            return super.onTouchEvent(motionevent);
        }
    }

    public volatile void setAdapter(Adapter adapter)
    {
        setAdapter((ListAdapter)adapter);
    }

    public void setAdapter(ListAdapter listadapter)
    {
        super.setAdapter(listadapter);
        if (listadapter instanceof PinnedHeaderAdapter)
        {
            setPinnedHeaderAdapter((PinnedHeaderAdapter)listadapter);
        }
    }

    public void setNavBottom(int i)
    {
        mNavBottom = i;
    }

    public void setOnScrollListener(android.widget.AbsListView.OnScrollListener onscrolllistener)
    {
        mOnScrollListener = onscrolllistener;
    }

    public void setPinnedHeaderAdapter(PinnedHeaderAdapter pinnedheaderadapter)
    {
        mPinnedHeaderAdapter = pinnedheaderadapter;
    }

    public void setScrollDeltaListener(ScrollDeltaListener scrolldeltalistener)
    {
        mScrollDeltaListener = scrolldeltalistener;
    }

    public void untrackScrollawayChild()
    {
        mTrackedChild = null;
    }
}
