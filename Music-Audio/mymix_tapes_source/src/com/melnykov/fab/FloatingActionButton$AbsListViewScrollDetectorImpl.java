// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.melnykov.fab;

import android.widget.AbsListView;

// Referenced classes of package com.melnykov.fab:
//            AbsListViewScrollDetector, FloatingActionButton, ScrollDirectionListener

private class <init> extends AbsListViewScrollDetector
{

    private android.widget.l.mOnScrollListener mOnScrollListener;
    private ScrollDirectionListener mScrollDirectionListener;
    final FloatingActionButton this$0;

    private void setScrollDirectionListener(ScrollDirectionListener scrolldirectionlistener)
    {
        mScrollDirectionListener = scrolldirectionlistener;
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (mOnScrollListener != null)
        {
            mOnScrollListener.mOnScrollListener(abslistview, i, j, k);
        }
        super.onScroll(abslistview, i, j, k);
    }

    public void onScrollDown()
    {
        show();
        if (mScrollDirectionListener != null)
        {
            mScrollDirectionListener.onScrollDown();
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        if (mOnScrollListener != null)
        {
            mOnScrollListener.mOnScrollListener(abslistview, i);
        }
        super.onScrollStateChanged(abslistview, i);
    }

    public void onScrollUp()
    {
        hide();
        if (mScrollDirectionListener != null)
        {
            mScrollDirectionListener.onScrollUp();
        }
    }

    public void setOnScrollListener(android.widget.l l)
    {
        mOnScrollListener = l;
    }


    private I()
    {
        this$0 = FloatingActionButton.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
