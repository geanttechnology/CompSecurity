// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.AbsListView;
import android.widget.ListView;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItSlidingDrawerView

public class ViewItHistoryListView extends ListView
{

    private int mFirstItemIndex;
    private float mLastMotionPositionY;
    private ViewItSlidingDrawerView mSlidingDrawer;

    public ViewItHistoryListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mFirstItemIndex = -1;
        mLastMotionPositionY = 0.0F;
        setOnScrollListener(new android.widget.AbsListView.OnScrollListener() {

            final ViewItHistoryListView this$0;

            public void onScroll(AbsListView abslistview, int i, int j, int k)
            {
                mFirstItemIndex = i;
            }

            public void onScrollStateChanged(AbsListView abslistview, int i)
            {
            }

            
            {
                this$0 = ViewItHistoryListView.this;
                super();
            }
        });
    }

    public boolean isListViewScrolledToTop()
    {
        return mFirstItemIndex == 0;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        float f = motionevent.getY();
        boolean flag;
        if (f > mLastMotionPositionY)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mLastMotionPositionY = f;
        if (motionevent.getAction() == 2 && mFirstItemIndex == 0 && flag)
        {
            mSlidingDrawer.requestInterceptTouchEvent();
        }
        return super.onTouchEvent(motionevent);
    }

    public void setSlidingDrawerView(ViewItSlidingDrawerView viewitslidingdrawerview)
    {
        mSlidingDrawer = viewitslidingdrawerview;
    }


/*
    static int access$002(ViewItHistoryListView viewithistorylistview, int i)
    {
        viewithistorylistview.mFirstItemIndex = i;
        return i;
    }

*/
}
