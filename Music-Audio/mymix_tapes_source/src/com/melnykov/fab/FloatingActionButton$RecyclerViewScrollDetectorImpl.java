// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.melnykov.fab;

import android.support.v7.widget.RecyclerView;

// Referenced classes of package com.melnykov.fab:
//            RecyclerViewScrollDetector, FloatingActionButton, ScrollDirectionListener

private class <init> extends RecyclerViewScrollDetector
{

    private android.support.v7.widget.Listener mOnScrollListener;
    private ScrollDirectionListener mScrollDirectionListener;
    final FloatingActionButton this$0;

    private void setScrollDirectionListener(ScrollDirectionListener scrolldirectionlistener)
    {
        mScrollDirectionListener = scrolldirectionlistener;
    }

    public void onScrollDown()
    {
        show();
        if (mScrollDirectionListener != null)
        {
            mScrollDirectionListener.onScrollDown();
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerview, int i)
    {
        if (mOnScrollListener != null)
        {
            mOnScrollListener.Listener(recyclerview, i);
        }
        super.onScrollStateChanged(recyclerview, i);
    }

    public void onScrollUp()
    {
        hide();
        if (mScrollDirectionListener != null)
        {
            mScrollDirectionListener.onScrollUp();
        }
    }

    public void onScrolled(RecyclerView recyclerview, int i, int j)
    {
        if (mOnScrollListener != null)
        {
            mOnScrollListener.Listener(recyclerview, i, j);
        }
        super.onScrolled(recyclerview, i, j);
    }

    public void setOnScrollListener(android.support.v7.widget.Listener listener)
    {
        mOnScrollListener = listener;
    }


    private ()
    {
        this$0 = FloatingActionButton.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
