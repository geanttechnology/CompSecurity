// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.media;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HorizontalContainer extends ViewGroup
{
    public static interface OnScrollListener
    {

        public abstract void onPageChanged(int i);

        public abstract void onScroll(int i);

        public abstract void onViewScrollFinished(int i);
    }

    static final class TouchState extends Enum
    {

        private static final TouchState $VALUES[];
        public static final TouchState NO_MOVE;
        public static final TouchState SCROLL;
        int stateValue;

        public static TouchState valueOf(String s)
        {
            return (TouchState)Enum.valueOf(com/amazon/now/media/HorizontalContainer$TouchState, s);
        }

        public static TouchState[] values()
        {
            return (TouchState[])$VALUES.clone();
        }

        static 
        {
            NO_MOVE = new TouchState("NO_MOVE", 0, 0);
            SCROLL = new TouchState("SCROLL", 1, 1);
            $VALUES = (new TouchState[] {
                NO_MOVE, SCROLL
            });
        }

        private TouchState(String s, int i, int j)
        {
            super(s, i);
            stateValue = j;
        }
    }


    protected static final int INVALID_SCREEN_PAGE = -1;
    private boolean mAllowLongPress;
    protected int mCurrentPage;
    private boolean mIsFirstChildView;
    private float mLastMotionX;
    private float mLastMotionY;
    private List mListeners;
    private int mMaximumVelocity;
    protected int mNextPage;
    private int mPageWidth;
    private int mScrollAnimationDuration;
    private Scroller mScroller;
    private int mTouchSlop;
    private TouchState mTouchState;
    private VelocityTracker mVelocityTracker;

    public HorizontalContainer(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mNextPage = -1;
        mScrollAnimationDuration = 300;
        mIsFirstChildView = true;
        mTouchState = TouchState.NO_MOVE;
        mListeners = new ArrayList();
        mScroller = new Scroller(getContext());
        mCurrentPage = 0;
        context = ViewConfiguration.get(getContext());
        mTouchSlop = context.getScaledTouchSlop();
        mMaximumVelocity = context.getScaledMaximumFlingVelocity();
        setWillNotDraw(true);
        enableChildrenCache();
        setPersistentDrawingCache(1);
    }

    private void clearChildrenCache()
    {
        setChildrenDrawnWithCacheEnabled(false);
    }

    private void enableChildrenCache()
    {
        setChildrenDrawingCacheEnabled(true);
        setChildrenDrawnWithCacheEnabled(true);
    }

    private int getPageWidthPadding()
    {
        return (getMeasuredWidth() - mPageWidth) / 2;
    }

    private int getScrollXForPage(int i)
    {
        return mPageWidth * i - getPageWidthPadding();
    }

    private void hanldeMoveForScroll(float f, float f1)
    {
        int i = (int)Math.abs(f - mLastMotionX);
        int j = (int)Math.abs(f1 - mLastMotionY);
        boolean flag;
        if (i > mTouchSlop)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (j > mTouchSlop)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (flag || j)
        {
            if (flag)
            {
                mTouchState = TouchState.SCROLL;
                enableChildrenCache();
            }
            if (mAllowLongPress)
            {
                mAllowLongPress = false;
                View view = getChildAt(mCurrentPage);
                if (view != null)
                {
                    view.cancelLongPress();
                }
            }
        }
    }

    private void init()
    {
        ViewConfiguration viewconfiguration = ViewConfiguration.get(getContext());
        mTouchSlop = viewconfiguration.getScaledTouchSlop();
        mMaximumVelocity = viewconfiguration.getScaledMaximumFlingVelocity();
    }

    private void moveToDestination()
    {
        int i;
        int j;
        j = getScrollXForPage(mCurrentPage);
        i = mCurrentPage;
        if (getScrollX() >= j - getWidth() / 8) goto _L2; else goto _L1
_L1:
        i = Math.max(0, mCurrentPage - 1);
_L4:
        moveToPage(i);
        return;
_L2:
        if (getScrollX() > getWidth() / 8 + j)
        {
            i = getLastActiveChildIndex();
            if (i < 0)
            {
                i = mCurrentPage;
            } else
            {
                i = Math.min(i, mCurrentPage + 1);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void addOnScrollListener(OnScrollListener onscrolllistener)
    {
        mListeners.add(onscrolllistener);
    }

    public void addView(View view)
    {
        boolean flag;
        if (getChildCount() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        super.addView(view);
        if (flag)
        {
            init();
        }
    }

    public void computeScroll()
    {
        if (mScroller.computeScrollOffset())
        {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        } else
        if (mNextPage != -1)
        {
            mCurrentPage = mNextPage;
            mNextPage = -1;
            clearChildrenCache();
            return;
        }
    }

    protected void dispatchDraw(Canvas canvas)
    {
        long l = getDrawingTime();
        int k = getChildCount();
        for (int i = 0; i < k; i++)
        {
            drawChild(canvas, getChildAt(i), l);
        }

        int j = getScrollX() + getPageWidthPadding();
        k = mPageWidth;
        canvas = mListeners.iterator();
        do
        {
            if (!canvas.hasNext())
            {
                break;
            }
            OnScrollListener onscrolllistener = (OnScrollListener)canvas.next();
            onscrolllistener.onScroll(j);
            if (j % k == 0)
            {
                onscrolllistener.onViewScrollFinished(j / mPageWidth);
            }
        } while (true);
    }

    public int getCurrentPage()
    {
        return mCurrentPage;
    }

    public int getLastActiveChildIndex()
    {
        for (int i = getChildCount() - 1; i >= 0; i--)
        {
            if (getChildAt(i).getVisibility() != 8)
            {
                return i;
            }
        }

        return -1;
    }

    public int getPageWidth()
    {
        return mPageWidth;
    }

    public void moveToPage(int i)
    {
        if (i >= 0 && i < getChildCount())
        {
            scrollToPage(i, mScrollAnimationDuration);
        }
    }

    public void moveToPageWithNoAnimation(int i)
    {
        scrollToPage(i, 0);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        float f;
        float f1;
        int i;
        i = motionevent.getAction();
        if (i == 2 && !mTouchState.equals(TouchState.NO_MOVE))
        {
            return true;
        }
        f = motionevent.getX();
        f1 = motionevent.getY();
        i;
        JVM INSTR tableswitch 0 3: default 68
    //                   0 87
    //                   1 153
    //                   2 131
    //                   3 153;
           goto _L1 _L2 _L3 _L4 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_153;
_L5:
        boolean flag;
        if (!mTouchState.equals(TouchState.NO_MOVE))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
_L2:
        mLastMotionX = f;
        mLastMotionY = f1;
        mAllowLongPress = true;
        if (mScroller.isFinished())
        {
            motionevent = TouchState.NO_MOVE;
        } else
        {
            motionevent = TouchState.SCROLL;
        }
        mTouchState = motionevent;
          goto _L5
_L4:
        if (mTouchState.equals(TouchState.NO_MOVE))
        {
            hanldeMoveForScroll(f, f1);
        }
          goto _L5
        clearChildrenCache();
        mTouchState = TouchState.NO_MOVE;
          goto _L5
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        j = 0;
        i = 0;
        for (l = getChildCount(); i < l;)
        {
            View view = getChildAt(i);
            k = j;
            if (view.getVisibility() != 8)
            {
                k = view.getMeasuredWidth();
                view.layout(j, 0, j + k, view.getMeasuredHeight());
                k = j + k;
            }
            i++;
            j = k;
        }

    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        mPageWidth = getMeasuredWidth();
        int k = getChildCount();
        for (i = 0; i < k; i++)
        {
            getChildAt(i).measure(android.view.View.MeasureSpec.makeMeasureSpec(mPageWidth, 0x40000000), j);
        }

        if (mIsFirstChildView && mCurrentPage > 0)
        {
            scrollTo(getScrollXForPage(mCurrentPage), 0);
            mIsFirstChildView = false;
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect)
    {
        if (getChildCount() != 0)
        {
            View view;
            int j;
            if (mNextPage != -1)
            {
                j = mNextPage;
            } else
            {
                j = mCurrentPage;
            }
            view = getChildAt(j);
            if (view != null)
            {
                view.requestFocus(i, rect);
                return false;
            }
        }
        return false;
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        setCurrentPage(mCurrentPage);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        float f;
        float f1;
        int i;
        if (getChildCount() <= 1)
        {
            return true;
        }
        if (mVelocityTracker == null)
        {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(motionevent);
        i = motionevent.getAction();
        f = motionevent.getX();
        f1 = motionevent.getY();
        i;
        JVM INSTR tableswitch 0 3: default 80
    //                   0 82
    //                   1 197
    //                   2 111
    //                   3 328;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return true;
_L2:
        if (!mScroller.isFinished())
        {
            mScroller.abortAnimation();
        }
        mLastMotionX = f;
        mLastMotionY = f1;
        return true;
_L4:
        int k;
        if (mTouchState.equals(TouchState.NO_MOVE))
        {
            hanldeMoveForScroll(f, f1);
            return true;
        }
        k = (int)(mLastMotionX - f);
        if (getScrollX() < 0) goto _L7; else goto _L6
_L6:
        i = k;
        if (getScrollX() <= getChildAt(getChildCount() - 1).getLeft()) goto _L8; else goto _L7
_L7:
        i = k / 2;
_L8:
        scrollBy(i, 0);
        mLastMotionX = f;
        mLastMotionY = f1;
        return true;
_L3:
        if (mTouchState.equals(TouchState.SCROLL))
        {
            motionevent = mVelocityTracker;
            motionevent.computeCurrentVelocity(1000, mMaximumVelocity);
            int j = (int)motionevent.getXVelocity();
            if (j > 1000 && mCurrentPage > 0)
            {
                moveToPage(mCurrentPage - 1);
            } else
            if (j < -1000 && mCurrentPage < getChildCount() - 1)
            {
                moveToPage(mCurrentPage + 1);
            } else
            {
                moveToDestination();
            }
            if (mVelocityTracker != null)
            {
                mVelocityTracker.recycle();
                mVelocityTracker = null;
            }
        }
        mTouchState = TouchState.NO_MOVE;
        return true;
_L5:
        mTouchState = TouchState.NO_MOVE;
        return true;
    }

    public void removeOnScrollListener(OnScrollListener onscrolllistener)
    {
        mListeners.remove(onscrolllistener);
    }

    public void scrollToPage(int i, int j)
    {
        enableChildrenCache();
        boolean flag;
        int k;
        int l;
        if (i != mCurrentPage)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        k = getScrollXForPage(i);
        l = getScrollX();
        mNextPage = i;
        if (flag)
        {
            for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); ((OnScrollListener)iterator.next()).onPageChanged(mNextPage)) { }
        }
        mScroller.startScroll(getScrollX(), 0, k - l, 0, j);
        invalidate();
    }

    public void setCurrentPage(int i)
    {
        mCurrentPage = i;
        scrollTo(getScrollXForPage(mCurrentPage), 0);
        invalidate();
    }
}
