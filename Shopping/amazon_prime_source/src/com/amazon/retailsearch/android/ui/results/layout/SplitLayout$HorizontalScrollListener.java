// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import com.amazon.retailsearch.android.ui.HorizontalListView;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            SplitLayout

private class <init>
    implements com.amazon.retailsearch.android.ui.ScrollListener
{

    final SplitLayout this$0;

    public void onScroll(HorizontalListView horizontallistview, int i, int j, int k)
    {
        if (loaderScrollListener != null && horizontallistview != null)
        {
            loaderScrollListener.roll(horizontallistview, i, j, k);
        }
    }

    public void onScrollStateChanged(HorizontalListView horizontallistview, int i)
    {
        if (horizontallistview != null)
        {
            loadAtBottom(horizontallistview.getFirstVisiblePosition(), horizontallistview.getLastVisiblePosition());
            if (loaderScrollListener != null)
            {
                loaderScrollListener.rollStateChanged(horizontallistview, i);
            }
        }
    }

    private ()
    {
        this$0 = SplitLayout.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
