// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.target.ui.adapter.search.SearchHistoryItemsAdapter;
import java.util.ArrayList;
import java.util.List;

public class RecentItemsCardView extends FrameLayout
    implements com.target.ui.adapter.search.SearchHistoryItemsAdapter.a
{
    class Views extends com.target.ui.view.a
    {

        ListView listView;
        final RecentItemsCardView this$0;

        Views(View view)
        {
            this$0 = RecentItemsCardView.this;
            super(view);
        }
    }

    private class a
        implements android.widget.AdapterView.OnItemClickListener
    {

        final RecentItemsCardView this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            while (RecentItemsCardView.a(RecentItemsCardView.this) == null || i < RecentItemsCardView.b(RecentItemsCardView.this).listView.getHeaderViewsCount()) 
            {
                return;
            }
            adapterview = (String)adapterview.getItemAtPosition(i);
            RecentItemsCardView.a(RecentItemsCardView.this).a(adapterview);
        }

        private a()
        {
            this$0 = RecentItemsCardView.this;
            super();
        }

    }

    public static interface b
    {

        public abstract void a(String s);

        public abstract void b(String s);
    }


    private SearchHistoryItemsAdapter mAdapter;
    private b mSearchHistoryListener;
    private Views mViews;

    public RecentItemsCardView(Context context)
    {
        super(context);
        a();
    }

    public RecentItemsCardView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    static b a(RecentItemsCardView recentitemscardview)
    {
        return recentitemscardview.mSearchHistoryListener;
    }

    private void a()
    {
        inflate(getContext(), 0x7f0301e8, this);
        mViews = new Views(this);
        mViews.listView.setOnItemClickListener(new a());
        mAdapter = new SearchHistoryItemsAdapter(getContext(), new ArrayList());
        mAdapter.a(this);
        mViews.listView.setAdapter(mAdapter);
    }

    static Views b(RecentItemsCardView recentitemscardview)
    {
        return recentitemscardview.mViews;
    }

    public void a(String s)
    {
        if (mSearchHistoryListener == null)
        {
            return;
        } else
        {
            mSearchHistoryListener.b(s);
            return;
        }
    }

    public void a(boolean flag)
    {
        mAdapter.a(flag);
    }

    public void setData(List list)
    {
        mAdapter.a(list);
    }

    public void setSearchHistoryListener(b b1)
    {
        mSearchHistoryListener = b1;
    }
}
