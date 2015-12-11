// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import java.util.LinkedList;
import java.util.Queue;

public class HorizontalListView extends AdapterView
{

    protected ListAdapter mAdapter;
    public boolean mAlwaysOverrideTouch;
    protected int mCurrentX;
    private boolean mDataChanged;
    private DataSetObserver mDataObserver;
    private int mDisplayOffset;
    private GestureDetector mGesture;
    private int mLeftViewIndex;
    private int mMaxX;
    protected int mNextX;
    private android.view.GestureDetector.OnGestureListener mOnGesture;
    private android.widget.AdapterView.OnItemClickListener mOnItemClicked;
    private android.widget.AdapterView.OnItemLongClickListener mOnItemLongClicked;
    private android.widget.AdapterView.OnItemSelectedListener mOnItemSelected;
    private Queue mRemovedViewQueue;
    private int mRightViewIndex;
    protected Scroller mScroller;

    public HorizontalListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mAlwaysOverrideTouch = true;
        mLeftViewIndex = -1;
        mRightViewIndex = 0;
        mMaxX = 0x7fffffff;
        mDisplayOffset = 0;
        mRemovedViewQueue = new LinkedList();
        mDataChanged = false;
        mDataObserver = new DataSetObserver() {

            final HorizontalListView this$0;

            public void onChanged()
            {
                synchronized (HorizontalListView.this)
                {
                    mDataChanged = true;
                }
                invalidate();
                requestLayout();
                return;
                exception;
                horizontallistview;
                JVM INSTR monitorexit ;
                throw exception;
            }

            public void onInvalidated()
            {
                reset();
                invalidate();
                requestLayout();
            }

            
            {
                this$0 = HorizontalListView.this;
                super();
            }
        };
        mOnGesture = new android.view.GestureDetector.SimpleOnGestureListener() {

            final HorizontalListView this$0;

            private boolean isEventWithinView(MotionEvent motionevent, View view)
            {
                Rect rect = new Rect();
                int ai[] = new int[2];
                view.getLocationOnScreen(ai);
                int i = ai[0];
                int j = view.getWidth();
                int k = ai[1];
                rect.set(i, k, i + j, k + view.getHeight());
                return rect.contains((int)motionevent.getRawX(), (int)motionevent.getRawY());
            }

            public boolean onDown(MotionEvent motionevent)
            {
                return HorizontalListView.this.onDown(motionevent);
            }

            public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
            {
                return HorizontalListView.this.onFling(motionevent, motionevent1, f, f1);
            }

            public void onLongPress(MotionEvent motionevent)
            {
                int i;
                int j;
                j = getChildCount();
                i = 0;
_L5:
                if (i < j) goto _L2; else goto _L1
_L1:
                return;
_L2:
                View view = getChildAt(i);
                if (!isEventWithinView(motionevent, view))
                {
                    break; /* Loop/switch isn't completed */
                }
                if (mOnItemLongClicked != null)
                {
                    mOnItemLongClicked.onItemLongClick(HorizontalListView.this, view, mLeftViewIndex + 1 + i, mAdapter.getItemId(mLeftViewIndex + 1 + i));
                    return;
                }
                if (true) goto _L1; else goto _L3
_L3:
                i++;
                if (true) goto _L5; else goto _L4
_L4:
            }

            public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
            {
                synchronized (HorizontalListView.this)
                {
                    motionevent1 = HorizontalListView.this;
                    motionevent1.mNextX = ((HorizontalListView) (motionevent1)).mNextX + (int)f;
                }
                requestLayout();
                return true;
                motionevent1;
                motionevent;
                JVM INSTR monitorexit ;
                throw motionevent1;
            }

            public boolean onSingleTapConfirmed(MotionEvent motionevent)
            {
                int i = 0;
_L5:
                if (i < getChildCount()) goto _L2; else goto _L1
_L1:
                return true;
_L2:
                View view = getChildAt(i);
                if (!isEventWithinView(motionevent, view))
                {
                    break; /* Loop/switch isn't completed */
                }
                if (mOnItemClicked != null)
                {
                    mOnItemClicked.onItemClick(HorizontalListView.this, view, mLeftViewIndex + 1 + i, mAdapter.getItemId(mLeftViewIndex + 1 + i));
                }
                if (mOnItemSelected != null)
                {
                    mOnItemSelected.onItemSelected(HorizontalListView.this, view, mLeftViewIndex + 1 + i, mAdapter.getItemId(mLeftViewIndex + 1 + i));
                }
                if (true) goto _L1; else goto _L3
_L3:
                i++;
                if (true) goto _L5; else goto _L4
_L4:
            }

            
            {
                this$0 = HorizontalListView.this;
                super();
            }
        };
        initView();
    }

    private void addAndMeasureChild(View view, int i)
    {
        android.view.ViewGroup.LayoutParams layoutparams1 = view.getLayoutParams();
        android.view.ViewGroup.LayoutParams layoutparams = layoutparams1;
        if (layoutparams1 == null)
        {
            layoutparams = new android.view.ViewGroup.LayoutParams(-1, -1);
        }
        addViewInLayout(view, i, layoutparams, true);
        view.measure(android.view.View.MeasureSpec.makeMeasureSpec(getWidth(), 0x80000000), android.view.View.MeasureSpec.makeMeasureSpec(getHeight(), 0x80000000));
    }

    private void fillList(int i)
    {
        int j = 0;
        View view = getChildAt(getChildCount() - 1);
        if (view != null)
        {
            j = view.getRight();
        }
        fillListRight(j, i);
        j = 0;
        view = getChildAt(0);
        if (view != null)
        {
            j = view.getLeft();
        }
        fillListLeft(j, i);
    }

    private void fillListLeft(int i, int j)
    {
        do
        {
            if (i + j <= 0 || mLeftViewIndex < 0)
            {
                return;
            }
            View view = mAdapter.getView(mLeftViewIndex, (View)mRemovedViewQueue.poll(), this);
            addAndMeasureChild(view, 0);
            i -= view.getMeasuredWidth();
            mLeftViewIndex = mLeftViewIndex - 1;
            mDisplayOffset = mDisplayOffset - view.getMeasuredWidth();
        } while (true);
    }

    private void fillListRight(int i, int j)
    {
        do
        {
            if (i + j >= getWidth() || mRightViewIndex >= mAdapter.getCount())
            {
                return;
            }
            View view = mAdapter.getView(mRightViewIndex, (View)mRemovedViewQueue.poll(), this);
            addAndMeasureChild(view, -1);
            i += view.getMeasuredWidth();
            if (mRightViewIndex == mAdapter.getCount() - 1)
            {
                mMaxX = (mCurrentX + i) - getWidth();
            }
            if (mMaxX < 0)
            {
                mMaxX = 0;
            }
            mRightViewIndex = mRightViewIndex + 1;
        } while (true);
    }

    private void initView()
    {
        this;
        JVM INSTR monitorenter ;
        mLeftViewIndex = -1;
        mRightViewIndex = 0;
        mDisplayOffset = 0;
        mCurrentX = 0;
        mNextX = 0;
        mMaxX = 0x7fffffff;
        mScroller = new Scroller(getContext());
        mGesture = new GestureDetector(getContext(), mOnGesture);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void positionItems(int i)
    {
        if (getChildCount() <= 0) goto _L2; else goto _L1
_L1:
        int j;
        mDisplayOffset = mDisplayOffset + i;
        j = mDisplayOffset;
        i = 0;
_L5:
        if (i < getChildCount()) goto _L3; else goto _L2
_L2:
        return;
_L3:
        View view = getChildAt(i);
        int k = view.getMeasuredWidth();
        view.layout(j, 0, j + k, view.getMeasuredHeight());
        j += view.getPaddingRight() + k;
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void removeNonVisibleItems(int i)
    {
        View view = getChildAt(0);
_L3:
        if (view != null && view.getRight() + i <= 0) goto _L2; else goto _L1
_L1:
        view = getChildAt(getChildCount() - 1);
_L4:
        if (view == null || view.getLeft() + i < getWidth())
        {
            return;
        }
        break MISSING_BLOCK_LABEL_96;
_L2:
        mDisplayOffset = mDisplayOffset + view.getMeasuredWidth();
        mRemovedViewQueue.offer(view);
        removeViewInLayout(view);
        mLeftViewIndex = mLeftViewIndex + 1;
        view = getChildAt(0);
          goto _L3
        mRemovedViewQueue.offer(view);
        removeViewInLayout(view);
        mRightViewIndex = mRightViewIndex - 1;
        view = getChildAt(getChildCount() - 1);
          goto _L4
    }

    private void reset()
    {
        this;
        JVM INSTR monitorenter ;
        initView();
        removeAllViewsInLayout();
        requestLayout();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        return super.dispatchTouchEvent(motionevent) | mGesture.onTouchEvent(motionevent);
    }

    public volatile Adapter getAdapter()
    {
        return getAdapter();
    }

    public ListAdapter getAdapter()
    {
        return mAdapter;
    }

    public View getSelectedView()
    {
        return null;
    }

    protected boolean onDown(MotionEvent motionevent)
    {
        mScroller.forceFinished(true);
        return true;
    }

    protected boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        this;
        JVM INSTR monitorenter ;
        mScroller.fling(mNextX, 0, (int)(-f), 0, 0, mMaxX, 0, 0);
        this;
        JVM INSTR monitorexit ;
        requestLayout();
        return true;
        motionevent;
        this;
        JVM INSTR monitorexit ;
        throw motionevent;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        this;
        JVM INSTR monitorenter ;
        ListAdapter listadapter;
        super.onLayout(flag, i, j, k, l);
        listadapter = mAdapter;
        if (listadapter != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (mDataChanged)
        {
            i = mCurrentX;
            initView();
            removeAllViewsInLayout();
            mNextX = i;
            mDataChanged = false;
        }
        if (mScroller.computeScrollOffset())
        {
            mNextX = mScroller.getCurrX();
        }
        if (mNextX <= 0)
        {
            mNextX = 0;
            mScroller.forceFinished(true);
        }
        if (mNextX >= mMaxX)
        {
            mNextX = mMaxX;
            mScroller.forceFinished(true);
        }
        i = mCurrentX - mNextX;
        removeNonVisibleItems(i);
        fillList(i);
        positionItems(i);
        mCurrentX = mNextX;
        if (!mScroller.isFinished())
        {
            post(new Runnable() {

                final HorizontalListView this$0;

                public void run()
                {
                    requestLayout();
                }

            
            {
                this$0 = HorizontalListView.this;
                super();
            }
            });
        }
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void scrollTo(int i)
    {
        this;
        JVM INSTR monitorenter ;
        mScroller.startScroll(mNextX, 0, i - mNextX, 0);
        requestLayout();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public volatile void setAdapter(Adapter adapter)
    {
        setAdapter((ListAdapter)adapter);
    }

    public void setAdapter(ListAdapter listadapter)
    {
        if (mAdapter != null)
        {
            mAdapter.unregisterDataSetObserver(mDataObserver);
        }
        mAdapter = listadapter;
        mAdapter.registerDataSetObserver(mDataObserver);
        reset();
    }

    public void setOnItemClickListener(android.widget.AdapterView.OnItemClickListener onitemclicklistener)
    {
        mOnItemClicked = onitemclicklistener;
    }

    public void setOnItemLongClickListener(android.widget.AdapterView.OnItemLongClickListener onitemlongclicklistener)
    {
        mOnItemLongClicked = onitemlongclicklistener;
    }

    public void setOnItemSelectedListener(android.widget.AdapterView.OnItemSelectedListener onitemselectedlistener)
    {
        mOnItemSelected = onitemselectedlistener;
    }

    public void setSelection(int i)
    {
    }






}
