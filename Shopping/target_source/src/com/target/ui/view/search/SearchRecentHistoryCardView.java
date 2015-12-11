// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.target.ui.adapter.search.SearchHistoryItemsAdapter;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.view.search:
//            SearchRecentHistoryFooter

public class SearchRecentHistoryCardView extends FrameLayout
{
    static class Views extends com.target.ui.view.a
    {

        SearchRecentHistoryFooter footer;
        ListView listView;

        Views(Context context, View view)
        {
            super(view);
            footer = new SearchRecentHistoryFooter(context);
        }
    }

    private class a
        implements SearchRecentHistoryFooter.a
    {

        final SearchRecentHistoryCardView this$0;

        public void a()
        {
            if (SearchRecentHistoryCardView.a(SearchRecentHistoryCardView.this) == null)
            {
                return;
            } else
            {
                SearchRecentHistoryCardView.a(SearchRecentHistoryCardView.this).a();
                return;
            }
        }

        private a()
        {
            this$0 = SearchRecentHistoryCardView.this;
            super();
        }

    }

    private class b
        implements android.widget.AdapterView.OnItemClickListener
    {

        final SearchRecentHistoryCardView this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            while (SearchRecentHistoryCardView.a(SearchRecentHistoryCardView.this) == null || i < SearchRecentHistoryCardView.b(SearchRecentHistoryCardView.this).listView.getHeaderViewsCount()) 
            {
                return;
            }
            adapterview = (String)adapterview.getItemAtPosition(i);
            SearchRecentHistoryCardView.a(SearchRecentHistoryCardView.this).a(adapterview);
        }

        private b()
        {
            this$0 = SearchRecentHistoryCardView.this;
            super();
        }

    }

    public static interface c
    {

        public abstract void a();

        public abstract void a(String s);
    }


    private SearchHistoryItemsAdapter mAdapter;
    private c mListener;
    private Views mViews;

    public SearchRecentHistoryCardView(Context context)
    {
        super(context);
        a();
    }

    public SearchRecentHistoryCardView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    static c a(SearchRecentHistoryCardView searchrecenthistorycardview)
    {
        return searchrecenthistorycardview.mListener;
    }

    private void a()
    {
        inflate(getContext(), 0x7f0301ee, this);
        mViews = new Views(getContext(), this);
        mViews.listView.addFooterView(mViews.footer);
        mViews.listView.setOnItemClickListener(new b());
        mViews.footer.setClickListener(new a());
        mAdapter = new SearchHistoryItemsAdapter(getContext(), new ArrayList());
        mAdapter.a(true);
        mViews.listView.setAdapter(mAdapter);
    }

    static Views b(SearchRecentHistoryCardView searchrecenthistorycardview)
    {
        return searchrecenthistorycardview.mViews;
    }

    public void setData(List list)
    {
        mAdapter.a(list);
    }

    public void setDisplayEditIcon(boolean flag)
    {
        mAdapter.b(flag);
    }

    public void setSearchListener(c c1)
    {
        mListener = c1;
    }
}
