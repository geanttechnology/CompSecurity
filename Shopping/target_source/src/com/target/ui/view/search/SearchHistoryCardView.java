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
//            SearchHistoryHeader, SearchHistoryFooter

public class SearchHistoryCardView extends FrameLayout
    implements com.target.ui.adapter.search.SearchHistoryItemsAdapter.a
{
    static class Views extends com.target.ui.view.a
    {

        final SearchHistoryFooter footer;
        final SearchHistoryHeader header;
        ListView listView;

        Views(Context context, View view)
        {
            super(view);
            header = new SearchHistoryHeader(context);
            footer = new SearchHistoryFooter(context);
        }
    }

    private class a
        implements SearchHistoryFooter.a
    {

        final SearchHistoryCardView this$0;

        public void a()
        {
            if (SearchHistoryCardView.a(SearchHistoryCardView.this) == null)
            {
                return;
            } else
            {
                SearchHistoryCardView.a(SearchHistoryCardView.this).b();
                return;
            }
        }

        private a()
        {
            this$0 = SearchHistoryCardView.this;
            super();
        }

    }

    private class b
        implements SearchHistoryHeader.a
    {

        final SearchHistoryCardView this$0;

        public void a()
        {
            if (SearchHistoryCardView.a(SearchHistoryCardView.this) == null)
            {
                return;
            } else
            {
                SearchHistoryCardView.a(SearchHistoryCardView.this).a();
                return;
            }
        }

        private b()
        {
            this$0 = SearchHistoryCardView.this;
            super();
        }

    }

    private class c
        implements android.widget.AdapterView.OnItemClickListener
    {

        final SearchHistoryCardView this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            while (SearchHistoryCardView.a(SearchHistoryCardView.this) == null || i < SearchHistoryCardView.b(SearchHistoryCardView.this).listView.getHeaderViewsCount()) 
            {
                return;
            }
            adapterview = (String)adapterview.getItemAtPosition(i);
            SearchHistoryCardView.a(SearchHistoryCardView.this).a(adapterview);
        }

        private c()
        {
            this$0 = SearchHistoryCardView.this;
            super();
        }

    }

    public static interface d
    {

        public abstract void a();

        public abstract void a(String s);

        public abstract void b();

        public abstract void b(String s);
    }


    private SearchHistoryItemsAdapter mAdapter;
    private d mListener;
    private Views mViews;

    public SearchHistoryCardView(Context context)
    {
        super(context);
        c();
    }

    public SearchHistoryCardView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c();
    }

    static d a(SearchHistoryCardView searchhistorycardview)
    {
        return searchhistorycardview.mListener;
    }

    static Views b(SearchHistoryCardView searchhistorycardview)
    {
        return searchhistorycardview.mViews;
    }

    private void c()
    {
        inflate(getContext(), 0x7f0301e8, this);
        mViews = new Views(getContext(), this);
        mViews.listView.addHeaderView(mViews.header);
        mViews.listView.addFooterView(mViews.footer);
        mViews.listView.setOnItemClickListener(new c());
        mViews.header.setOnClickListener(new android.view.View.OnClickListener() {

            final SearchHistoryCardView this$0;

            public void onClick(View view)
            {
            }

            
            {
                this$0 = SearchHistoryCardView.this;
                super();
            }
        });
        mViews.header.setClickListener(new b());
        mViews.footer.setClickListener(new a());
        mAdapter = new SearchHistoryItemsAdapter(getContext(), new ArrayList());
        mAdapter.a(this);
        mAdapter.a(true);
        mAdapter.b(true);
        mViews.listView.setAdapter(mAdapter);
    }

    public void a(String s)
    {
        if (mListener == null)
        {
            return;
        } else
        {
            mListener.b(s);
            return;
        }
    }

    public boolean a()
    {
        while (mAdapter == null || mAdapter.getCount() <= 0) 
        {
            return false;
        }
        return true;
    }

    public void b()
    {
        mAdapter.clear();
    }

    public void setData(List list)
    {
        mAdapter.a(list);
    }

    public void setSearchHistoryListener(d d1)
    {
        mListener = d1;
    }
}
