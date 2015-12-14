// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss;

import android.widget.AbsListView;

// Referenced classes of package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss:
//            SwipeDismissListViewTouchListener

public class SwipeOnScrollListener
    implements android.widget.AbsListView.OnScrollListener
{

    private SwipeDismissListViewTouchListener mTouchListener;

    public SwipeOnScrollListener()
    {
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        if (i != 0)
        {
            mTouchListener.disallowSwipe();
        }
    }

    public void setTouchListener(SwipeDismissListViewTouchListener swipedismisslistviewtouchlistener)
    {
        mTouchListener = swipedismisslistviewtouchlistener;
    }
}
