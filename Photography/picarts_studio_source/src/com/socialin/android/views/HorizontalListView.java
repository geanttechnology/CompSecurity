// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.views;

import android.content.Context;
import android.content.res.Configuration;
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

            private HorizontalListView a;

            public final void onChanged()
            {
                synchronized (a)
                {
                    a.mDataChanged = true;
                }
                a.invalidate();
                a.requestLayout();
                return;
                exception;
                horizontallistview;
                JVM INSTR monitorexit ;
                throw exception;
            }

            public final void onInvalidated()
            {
                a.reset();
                a.invalidate();
                a.requestLayout();
            }

            
            {
                a = HorizontalListView.this;
                super();
            }
        };
        mOnGesture = new android.view.GestureDetector.SimpleOnGestureListener() {

            private float a;
            private float b;
            private float c;
            private HorizontalListView d;

            private static boolean a(MotionEvent motionevent, View view)
            {
                Rect rect = new Rect();
                int ai[] = new int[2];
                view.getLocationOnScreen(ai);
                int i = ai[0];
                int j = view.getWidth();
                int k = ai[1];
                rect.set(i, k, j + i, view.getHeight() + k);
                return rect.contains((int)motionevent.getRawX(), (int)motionevent.getRawY());
            }

            public final boolean onDown(MotionEvent motionevent)
            {
                return d.onDown(motionevent);
            }

            public final boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
            {
                return d.onFling(motionevent, motionevent1, f, f1);
            }

            public final void onLongPress(MotionEvent motionevent)
            {
                int j = d.getChildCount();
                int i = 0;
                do
                {
label0:
                    {
                        if (i < j)
                        {
                            View view = d.getChildAt(i);
                            if (!a(motionevent, view))
                            {
                                break label0;
                            }
                            if (d.mOnItemLongClicked != null)
                            {
                                d.mOnItemLongClicked.onItemLongClick(d, view, d.mLeftViewIndex + 1 + i, d.mAdapter.getItemId(i + (d.mLeftViewIndex + 1)));
                            }
                        }
                        return;
                    }
                    i++;
                } while (true);
            }

            public final boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
            {
                a = a + f;
                if (b * f >= 0.0F) goto _L2; else goto _L1
_L1:
                b = f;
_L4:
                return true;
_L2:
                b = f;
                c = a;
                if (c * a < 0.0F && Math.abs(a) < 5F) goto _L4; else goto _L3
_L3:
                synchronized (d)
                {
                    (new StringBuilder("distanceX: ")).append(a);
                    motionevent1 = d;
                    motionevent1.mNextX = ((HorizontalListView) (motionevent1)).mNextX + (int)a;
                }
                c = a;
                a = 0.0F;
                d.requestLayout();
                return true;
                motionevent1;
                motionevent;
                JVM INSTR monitorexit ;
                throw motionevent1;
            }

            public final boolean onSingleTapConfirmed(MotionEvent motionevent)
            {
                int i = 0;
                do
                {
label0:
                    {
                        if (i < d.getChildCount())
                        {
                            View view = d.getChildAt(i);
                            if (!a(motionevent, view))
                            {
                                break label0;
                            }
                            if (d.mOnItemClicked != null)
                            {
                                d.mOnItemClicked.onItemClick(d, view, d.mLeftViewIndex + 1 + i, d.mAdapter.getItemId(d.mLeftViewIndex + 1 + i));
                            }
                            if (d.mOnItemSelected != null)
                            {
                                d.mOnItemSelected.onItemSelected(d, view, d.mLeftViewIndex + 1 + i, d.mAdapter.getItemId(d.mLeftViewIndex + 1 + i));
                            }
                        }
                        return true;
                    }
                    i++;
                } while (true);
            }

            
            {
                d = HorizontalListView.this;
                super();
                a = 0.0F;
                b = 0.0F;
                c = 0.0F;
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
        boolean flag = false;
        View view = getChildAt(getChildCount() - 1);
        int j;
        if (view != null)
        {
            j = view.getRight();
        } else
        {
            j = 0;
        }
        fillListRight(j, i);
        view = getChildAt(0);
        j = ((flag) ? 1 : 0);
        if (view != null)
        {
            j = view.getLeft();
        }
        fillListLeft(j, i);
    }

    private void fillListLeft(int i, int j)
    {
        while (i + j > 0 && mLeftViewIndex >= 0) 
        {
            View view = mAdapter.getView(mLeftViewIndex, (View)mRemovedViewQueue.poll(), this);
            addAndMeasureChild(view, 0);
            i -= view.getMeasuredWidth();
            mLeftViewIndex = mLeftViewIndex - 1;
            mDisplayOffset = mDisplayOffset - view.getMeasuredWidth();
        }
    }

    private void fillListRight(int i, int j)
    {
        for (; i + j < getWidth() && mRightViewIndex < mAdapter.getCount(); mRightViewIndex = mRightViewIndex + 1)
        {
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
        }

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
        if (getChildCount() > 0)
        {
            mDisplayOffset = mDisplayOffset + i;
            int j = mDisplayOffset;
            for (i = 0; i < getChildCount(); i++)
            {
                View view = getChildAt(i);
                int k = view.getMeasuredWidth();
                view.layout(j, 0, j + k, view.getMeasuredHeight());
                j += k;
            }

        }
    }

    private void removeNonVisibleItems(int i)
    {
        for (View view = getChildAt(0); view != null && view.getRight() + i <= 0; view = getChildAt(0))
        {
            mDisplayOffset = mDisplayOffset + view.getMeasuredWidth();
            mRemovedViewQueue.offer(view);
            removeViewInLayout(view);
            mLeftViewIndex = mLeftViewIndex + 1;
        }

        do
        {
            View view1 = getChildAt(getChildCount() - 1);
            if (view1 != null && view1.getLeft() + i >= getWidth())
            {
                mRemovedViewQueue.offer(view1);
                removeViewInLayout(view1);
                mRightViewIndex = mRightViewIndex - 1;
            } else
            {
                return;
            }
        } while (true);
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

    protected void onConfigurationChanged(Configuration configuration)
    {
        reset();
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

                private HorizontalListView a;

                public final void run()
                {
                    a.requestLayout();
                }

            
            {
                a = HorizontalListView.this;
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
        if (listadapter != null)
        {
            mAdapter.registerDataSetObserver(mDataObserver);
        }
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


/*
    static boolean access$002(HorizontalListView horizontallistview, boolean flag)
    {
        horizontallistview.mDataChanged = flag;
        return flag;
    }

*/





}
