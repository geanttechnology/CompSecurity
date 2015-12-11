// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaos.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

public class PinnedHeaderExpandableListView extends ExpandableListView
    implements android.widget.AbsListView.OnScrollListener, android.widget.ExpandableListView.OnGroupClickListener
{
    public static interface HeaderAdapter
    {

        public static final int PINNED_HEADER_GONE = 0;
        public static final int PINNED_HEADER_PUSHED_UP = 2;
        public static final int PINNED_HEADER_VISIBLE = 1;

        public abstract void configureHeader(View view, int i, int j, int k);

        public abstract int getGroupClickStatus(int i);

        public abstract int getHeaderState(int i, int j);

        public abstract void setGroupClickStatus(int i, int j);
    }


    private static final int MAX_ALPHA = 255;
    private HeaderAdapter mAdapter;
    private float mDownX;
    private float mDownY;
    private View mHeaderView;
    private int mHeaderViewHeight;
    private boolean mHeaderViewVisible;
    private int mHeaderViewWidth;
    private int mOldState;

    public PinnedHeaderExpandableListView(Context context)
    {
        super(context);
        mOldState = -1;
        registerListener();
    }

    public PinnedHeaderExpandableListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mOldState = -1;
        registerListener();
    }

    public PinnedHeaderExpandableListView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mOldState = -1;
        registerListener();
    }

    private void headerViewClick()
    {
        int i = ExpandableListView.getPackedPositionGroup(getExpandableListPosition(getFirstVisiblePosition()));
        if (mAdapter.getGroupClickStatus(i) == 1)
        {
            collapseGroup(i);
            mAdapter.setGroupClickStatus(i, 0);
        } else
        {
            expandGroup(i);
            mAdapter.setGroupClickStatus(i, 1);
        }
        setSelectedGroup(i);
    }

    private void registerListener()
    {
        setOnScrollListener(this);
        setOnGroupClickListener(this);
    }

    public void configureHeaderView(int i, int j)
    {
        if (mHeaderView == null || mAdapter == null || ((ExpandableListAdapter)mAdapter).getGroupCount() == 0)
        {
            return;
        }
        int k;
        int l;
        switch (mAdapter.getHeaderState(i, j))
        {
        default:
            return;

        case 0: // '\0'
            mHeaderViewVisible = false;
            return;

        case 1: // '\001'
            mAdapter.configureHeader(mHeaderView, i, j, 255);
            if (mHeaderView.getTop() != 0)
            {
                mHeaderView.layout(0, 0, mHeaderViewWidth, mHeaderViewHeight);
            }
            mHeaderViewVisible = true;
            return;

        case 2: // '\002'
            l = getChildAt(0).getBottom();
            k = mHeaderView.getHeight();
            break;
        }
        if (l < k)
        {
            l -= k;
            k = ((k + l) * 255) / k;
        } else
        {
            l = 0;
            k = 255;
        }
        mAdapter.configureHeader(mHeaderView, i, j, k);
        if (mHeaderView.getTop() != l)
        {
            mHeaderView.layout(0, l, mHeaderViewWidth, mHeaderViewHeight + l);
        }
        mHeaderViewVisible = true;
    }

    protected void dispatchDraw(Canvas canvas)
    {
        super.dispatchDraw(canvas);
        if (mHeaderViewVisible)
        {
            drawChild(canvas, mHeaderView, getDrawingTime());
        }
    }

    public boolean onGroupClick(ExpandableListView expandablelistview, View view, int i, long l)
    {
        if (mAdapter.getGroupClickStatus(i) == 0)
        {
            mAdapter.setGroupClickStatus(i, 1);
            expandablelistview.expandGroup(i);
        } else
        if (mAdapter.getGroupClickStatus(i) == 1)
        {
            mAdapter.setGroupClickStatus(i, 0);
            expandablelistview.collapseGroup(i);
            return true;
        }
        return true;
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        long l1 = getExpandableListPosition(getFirstVisiblePosition());
        i = ExpandableListView.getPackedPositionGroup(l1);
        j = ExpandableListView.getPackedPositionChild(l1);
        k = mAdapter.getHeaderState(i, j);
        if (mHeaderView != null && mAdapter != null && k != mOldState)
        {
            mOldState = k;
            mHeaderView.layout(0, 0, mHeaderViewWidth, mHeaderViewHeight);
        }
        configureHeaderView(i, j);
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        if (mHeaderView != null)
        {
            measureChild(mHeaderView, i, j);
            mHeaderViewWidth = mHeaderView.getMeasuredWidth();
            mHeaderViewHeight = mHeaderView.getMeasuredHeight();
        }
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        long l = getExpandableListPosition(i);
        configureHeaderView(ExpandableListView.getPackedPositionGroup(l), ExpandableListView.getPackedPositionChild(l));
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag = true;
        if (!mHeaderViewVisible) goto _L2; else goto _L1
_L1:
        motionevent.getAction();
        JVM INSTR tableswitch 0 1: default 36
    //                   0 46
    //                   1 90;
           goto _L2 _L3 _L4
_L2:
        flag = super.onTouchEvent(motionevent);
_L6:
        return flag;
_L3:
        mDownX = motionevent.getX();
        mDownY = motionevent.getY();
        if (mDownX <= (float)mHeaderViewWidth && mDownY <= (float)mHeaderViewHeight)
        {
            return true;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        float f = motionevent.getX();
        float f1 = motionevent.getY();
        float f2 = Math.abs(f - mDownX);
        float f3 = Math.abs(f1 - mDownY);
        if (f > (float)mHeaderViewWidth || f1 > (float)mHeaderViewHeight || f2 > (float)mHeaderViewWidth || f3 > (float)mHeaderViewHeight)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (mHeaderView == null) goto _L6; else goto _L5
_L5:
        headerViewClick();
        return true;
        if (true) goto _L2; else goto _L7
_L7:
    }

    public void setAdapter(ExpandableListAdapter expandablelistadapter)
    {
        super.setAdapter(expandablelistadapter);
        mAdapter = (HeaderAdapter)expandablelistadapter;
    }

    public void setHeaderView(View view)
    {
        mHeaderView = view;
        view.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, -2));
        if (mHeaderView != null)
        {
            setFadingEdgeLength(0);
        }
        requestLayout();
    }
}
