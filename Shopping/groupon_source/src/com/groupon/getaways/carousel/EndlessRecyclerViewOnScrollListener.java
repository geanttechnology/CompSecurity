// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.carousel;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public abstract class EndlessRecyclerViewOnScrollListener extends android.support.v7.widget.RecyclerView.OnScrollListener
{

    private final android.support.v7.widget.RecyclerView.Adapter adapter;
    private boolean loading;
    private int previousTotalItemCount;
    private int visibleThreshold;

    public EndlessRecyclerViewOnScrollListener(android.support.v7.widget.RecyclerView.Adapter adapter1)
    {
        visibleThreshold = 5;
        previousTotalItemCount = 0;
        loading = true;
        adapter = adapter1;
    }

    public abstract void onLoadMore();

    public void onScrolled(RecyclerView recyclerview, int i, int j)
    {
        super.onScrolled(recyclerview, i, j);
        i = recyclerview.getChildCount();
        j = adapter.getItemCount();
        int k = ((LinearLayoutManager)recyclerview.getLayoutManager()).findFirstVisibleItemPosition();
        if (j < previousTotalItemCount)
        {
            previousTotalItemCount = j;
            if (j == 0)
            {
                loading = true;
            }
        }
        if (loading && j > previousTotalItemCount)
        {
            loading = false;
            previousTotalItemCount = j;
        }
        if (!loading && j - i <= visibleThreshold + k)
        {
            onLoadMore();
            loading = true;
        }
    }

    public void setVisibleThreshold(int i)
    {
        visibleThreshold = i;
    }
}
