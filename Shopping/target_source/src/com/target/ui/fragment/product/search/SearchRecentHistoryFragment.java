// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.search;

import android.os.Bundle;
import android.support.v4.app.f;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import com.target.ui.fragment.product.common.BaseProductSearchFragment;
import com.target.ui.util.ai;
import com.target.ui.util.al;
import com.target.ui.view.search.SearchRecentHistoryCardView;
import java.util.List;

public class SearchRecentHistoryFragment extends BaseProductSearchFragment
{
    static class Views extends com.target.ui.view.a
    {

        SearchRecentHistoryCardView recentHistoryView;

        public Views(View view)
        {
            super(view);
        }
    }

    private class a
        implements com.target.ui.view.search.SearchRecentHistoryCardView.c
    {

        final SearchRecentHistoryFragment this$0;

        public void a()
        {
            SearchRecentHistoryFragment.a(SearchRecentHistoryFragment.this);
        }

        public void a(String s)
        {
            SearchRecentHistoryFragment.a(SearchRecentHistoryFragment.this, s);
        }

        private a()
        {
            this$0 = SearchRecentHistoryFragment.this;
            super();
        }

    }


    public static final String TAG = com/target/ui/fragment/product/search/SearchRecentHistoryFragment.getSimpleName();
    private Views mViews;

    public SearchRecentHistoryFragment()
    {
    }

    private void a(View view)
    {
        mViews = new Views(view);
    }

    static void a(SearchRecentHistoryFragment searchrecenthistoryfragment)
    {
        searchrecenthistoryfragment.f();
    }

    static void a(SearchRecentHistoryFragment searchrecenthistoryfragment, String s)
    {
        searchrecenthistoryfragment.b(s);
    }

    public static SearchRecentHistoryFragment i()
    {
        return new SearchRecentHistoryFragment();
    }

    private void j()
    {
        mViews.recentHistoryView.setSearchListener(new a());
    }

    private void k()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.recentHistoryView.setSearchListener(null);
            return;
        }
    }

    public void a()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            ai.a(this, "Unable to get the recent searches!");
            al.c(mViews.recentHistoryView);
            return;
        }
    }

    public void a(String s)
    {
    }

    public void a(List list)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.recentHistoryView.setDisplayEditIcon(false);
            mViews.recentHistoryView.setData(list);
            al.b(mViews.recentHistoryView);
            return;
        }
    }

    public void b()
    {
    }

    public void c()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            getActivity().onBackPressed();
            return;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            super.onCreateOptionsMenu(menu, menuinflater);
            j(getString(0x7f0904f1));
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030080, viewgroup, false);
        a(layoutinflater);
        e();
        j();
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        k();
        mViews = null;
    }

}
