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
import com.target.ui.adapter.search.ProductSearchSuggestionAdapter;
import com.target.ui.model.search.c;

public class SearchSuggestionCardView extends FrameLayout
    implements com.target.ui.adapter.search.ProductSearchSuggestionAdapter.b
{
    static class Views extends com.target.ui.view.a
    {

        ListView listView;

        Views(View view)
        {
            super(view);
        }
    }

    private class a
        implements android.widget.AdapterView.OnItemClickListener
    {

        final SearchSuggestionCardView this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            while (SearchSuggestionCardView.a(SearchSuggestionCardView.this) == null || i < SearchSuggestionCardView.b(SearchSuggestionCardView.this).listView.getHeaderViewsCount()) 
            {
                return;
            }
            adapterview = (com.target.ui.model.search.a)adapterview.getItemAtPosition(i);
            SearchSuggestionCardView.a(SearchSuggestionCardView.this).a(adapterview);
        }

        private a()
        {
            this$0 = SearchSuggestionCardView.this;
            super();
        }

    }

    public static interface b
    {

        public abstract void a(com.target.ui.model.search.a a1);

        public abstract void c_(String s);
    }


    private b mListener;
    private Views mViews;

    public SearchSuggestionCardView(Context context)
    {
        super(context);
        a();
    }

    public SearchSuggestionCardView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    static b a(SearchSuggestionCardView searchsuggestioncardview)
    {
        return searchsuggestioncardview.mListener;
    }

    private void a()
    {
        inflate(getContext(), 0x7f0301f0, this);
        mViews = new Views(this);
        mViews.listView.setOnItemClickListener(new a());
    }

    static Views b(SearchSuggestionCardView searchsuggestioncardview)
    {
        return searchsuggestioncardview.mViews;
    }

    protected ProductSearchSuggestionAdapter a(Context context, c c, com.target.ui.adapter.search.ProductSearchSuggestionAdapter.b b1)
    {
        return new ProductSearchSuggestionAdapter(context, c, b1);
    }

    public void a(String s)
    {
        if (mListener != null)
        {
            mListener.c_(s);
        }
    }

    public void setData(c c)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            c = a(getContext(), c, this);
            mViews.listView.setAdapter(c);
            return;
        }
    }

    public void setSearchSuggestionListener(b b1)
    {
        mListener = b1;
    }
}
