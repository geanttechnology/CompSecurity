// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.melnykov.fab;

import android.view.View;
import android.widget.AbsListView;

abstract class AbsListViewScrollDetector
    implements android.widget.AbsListView.OnScrollListener
{

    private int mLastScrollY;
    private AbsListView mListView;
    private int mPreviousFirstVisibleItem;
    private int mScrollThreshold;

    AbsListViewScrollDetector()
    {
    }

    private int getTopItemScrollY()
    {
        if (mListView == null || mListView.getChildAt(0) == null)
        {
            return 0;
        } else
        {
            return mListView.getChildAt(0).getTop();
        }
    }

    private boolean isSameRow(int i)
    {
        return i == mPreviousFirstVisibleItem;
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (k == 0)
        {
            return;
        }
        if (isSameRow(i))
        {
            j = getTopItemScrollY();
            if (Math.abs(mLastScrollY - j) > mScrollThreshold)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0)
            {
                if (mLastScrollY > j)
                {
                    onScrollUp();
                } else
                {
                    onScrollDown();
                }
            }
            mLastScrollY = j;
            return;
        }
        if (i > mPreviousFirstVisibleItem)
        {
            onScrollUp();
        } else
        {
            onScrollDown();
        }
        mLastScrollY = getTopItemScrollY();
        mPreviousFirstVisibleItem = i;
    }

    abstract void onScrollDown();

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    abstract void onScrollUp();

    public void setListView(AbsListView abslistview)
    {
        mListView = abslistview;
    }

    public void setScrollThreshold(int i)
    {
        mScrollThreshold = i;
    }
}
