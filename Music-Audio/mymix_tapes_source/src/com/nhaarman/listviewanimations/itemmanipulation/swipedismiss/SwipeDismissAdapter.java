// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss;

import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.nhaarman.listviewanimations.ArrayAdapter;
import com.nhaarman.listviewanimations.BaseAdapterDecorator;
import com.nhaarman.listviewanimations.itemmanipulation.OnDismissCallback;

// Referenced classes of package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss:
//            SwipeOnScrollListener, SwipeDismissListViewTouchListener

public class SwipeDismissAdapter extends BaseAdapterDecorator
{

    protected OnDismissCallback mOnDismissCallback;
    protected SwipeDismissListViewTouchListener mSwipeDismissListViewTouchListener;
    protected SwipeOnScrollListener mSwipeOnScrollListener;

    public SwipeDismissAdapter(BaseAdapter baseadapter, OnDismissCallback ondismisscallback)
    {
        this(baseadapter, ondismisscallback, new SwipeOnScrollListener());
    }

    public SwipeDismissAdapter(BaseAdapter baseadapter, OnDismissCallback ondismisscallback, SwipeOnScrollListener swipeonscrolllistener)
    {
        super(baseadapter);
        mOnDismissCallback = ondismisscallback;
        mSwipeOnScrollListener = swipeonscrolllistener;
    }

    protected SwipeDismissListViewTouchListener createListViewTouchListener(AbsListView abslistview)
    {
        return new SwipeDismissListViewTouchListener(abslistview, mOnDismissCallback, mSwipeOnScrollListener);
    }

    public void notifyDataSetChanged()
    {
        super.notifyDataSetChanged();
        if (mSwipeDismissListViewTouchListener != null)
        {
            mSwipeDismissListViewTouchListener.notifyDataSetChanged();
        }
    }

    public void setAbsListView(AbsListView abslistview)
    {
        super.setAbsListView(abslistview);
        if (mDecoratedBaseAdapter instanceof ArrayAdapter)
        {
            ((ArrayAdapter)mDecoratedBaseAdapter).propagateNotifyDataSetChanged(this);
        }
        mSwipeDismissListViewTouchListener = createListViewTouchListener(abslistview);
        mSwipeDismissListViewTouchListener.setIsParentHorizontalScrollContainer(isParentHorizontalScrollContainer());
        mSwipeDismissListViewTouchListener.setTouchChild(getTouchChild());
        abslistview.setOnTouchListener(mSwipeDismissListViewTouchListener);
    }

    public void setIsParentHorizontalScrollContainer(boolean flag)
    {
        super.setIsParentHorizontalScrollContainer(flag);
        if (mSwipeDismissListViewTouchListener != null)
        {
            mSwipeDismissListViewTouchListener.setIsParentHorizontalScrollContainer(flag);
        }
    }

    public void setTouchChild(int i)
    {
        super.setTouchChild(i);
        if (mSwipeDismissListViewTouchListener != null)
        {
            mSwipeDismissListViewTouchListener.setTouchChild(i);
        }
    }
}
