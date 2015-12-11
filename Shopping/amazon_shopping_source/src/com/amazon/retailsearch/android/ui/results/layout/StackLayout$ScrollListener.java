// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import android.widget.AbsListView;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            StackLayout

private class <init>
    implements android.widget.r
{

    final StackLayout this$0;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (loaderScrollListener != null)
        {
            loaderScrollListener.onScroll(abslistview, i, j, k);
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        if (abslistview != null)
        {
            loadAtBottom(abslistview.getFirstVisiblePosition(), abslistview.getLastVisiblePosition());
        }
        if (loaderScrollListener != null)
        {
            loaderScrollListener.onScrollStateChanged(abslistview, i);
        }
    }

    private tener()
    {
        this$0 = StackLayout.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
