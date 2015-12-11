// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.target.mothership.model.h;
import com.target.mothership.services.x;
import com.target.mothership.util.o;
import com.target.ui.fragment.product.common.BaseProductSearchFragment;
import com.target.ui.model.search.a;
import com.target.ui.model.search.c;
import com.target.ui.model.search.handler.ProductSuggestionModelTransformer;
import com.target.ui.util.al;
import com.target.ui.util.q;
import com.target.ui.view.search.SearchHistoryCardView;
import com.target.ui.view.search.SearchSuggestionCardView;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.product.search:
//            a

public class SearchProductEverywhere extends BaseProductSearchFragment
{
    static class Views extends com.target.ui.view.a
    {

        SearchHistoryCardView searchHistoryView;
        SearchSuggestionCardView searchSuggestionView;

        public Views(View view)
        {
            super(view);
        }
    }

    private class a
        implements com.target.ui.view.search.SearchHistoryCardView.d
    {

        final SearchProductEverywhere this$0;

        public void a()
        {
            com.target.ui.fragment.product.search.SearchProductEverywhere.a(SearchProductEverywhere.this);
        }

        public void a(String s)
        {
            com.target.ui.fragment.product.search.SearchProductEverywhere.a(SearchProductEverywhere.this, s);
        }

        public void b()
        {
            SearchProductEverywhere.b(SearchProductEverywhere.this);
        }

        public void b(String s)
        {
            if (getActivity() == null)
            {
                return;
            } else
            {
                com.target.ui.fragment.product.search.a.c(getActivity(), s);
                return;
            }
        }

        private a()
        {
            this$0 = SearchProductEverywhere.this;
            super();
        }

    }

    private class b
        implements com.target.ui.view.search.SearchSuggestionCardView.b
    {

        final SearchProductEverywhere this$0;

        public void a(com.target.ui.model.search.a a1)
        {
            com.target.ui.fragment.product.search.SearchProductEverywhere.a(SearchProductEverywhere.this, a1);
        }

        public void c_(String s)
        {
            if (getActivity() == null)
            {
                return;
            } else
            {
                com.target.ui.fragment.product.search.a.c(getActivity(), s);
                return;
            }
        }

        private b()
        {
            this$0 = SearchProductEverywhere.this;
            super();
        }

    }

    private class c extends h
    {

        final SearchProductEverywhere this$0;

        public String a()
        {
            return "TYPE_AHEAD_TAG";
        }

        public void a(x x1)
        {
            if (x1 != null)
            {
                x1 = x1.getMessage();
            } else
            {
                x1 = "";
            }
            if (o.g(x1))
            {
                q.a(SearchProductEverywhere.TAG, (new StringBuilder()).append("Error loading type ahead suggestions").append(x1).toString());
            }
        }

        public volatile void a(Object obj)
        {
            a((List)obj);
        }

        public void a(List list)
        {
            com.target.ui.fragment.product.search.SearchProductEverywhere.a(SearchProductEverywhere.this, list);
        }

        public void b(Object obj)
        {
            a((x)obj);
        }

        private c()
        {
            this$0 = SearchProductEverywhere.this;
            super();
        }

    }


    public static final String TAG = com/target/ui/fragment/product/search/SearchProductEverywhere.getSimpleName();
    private static final String TYPE_AHEAD_TAG = "TYPE_AHEAD_TAG";
    private com.target.mothership.model.typeahead.c mSearchSuggestionManager;
    private Views mViews;

    public SearchProductEverywhere()
    {
    }

    private void a(View view)
    {
        mViews = new Views(view);
    }

    static void a(SearchProductEverywhere searchproducteverywhere)
    {
        searchproducteverywhere.f();
    }

    static void a(SearchProductEverywhere searchproducteverywhere, com.target.ui.model.search.a a1)
    {
        searchproducteverywhere.a(a1);
    }

    static void a(SearchProductEverywhere searchproducteverywhere, String s)
    {
        searchproducteverywhere.b(s);
    }

    static void a(SearchProductEverywhere searchproducteverywhere, List list)
    {
        searchproducteverywhere.b(list);
    }

    private void a(boolean flag)
    {
        al.a(mViews.searchSuggestionView, flag);
    }

    static void b(SearchProductEverywhere searchproducteverywhere)
    {
        searchproducteverywhere.g();
    }

    private void b(List list)
    {
        if (mViews == null)
        {
            return;
        }
        if (list == null || list.isEmpty())
        {
            a(false);
            return;
        } else
        {
            list = new com.target.ui.model.search.c((new ProductSuggestionModelTransformer(getActivity())).a(list), com.target.ui.model.search.c.a.ENTERPRISE_SEARCH_SUGGESTION);
            mViews.searchSuggestionView.setData(list);
            a(true);
            c(false);
            return;
        }
    }

    private void c(String s)
    {
        while (mSearchSuggestionManager == null || !o.g(s)) 
        {
            return;
        }
        mSearchSuggestionManager.a(s.toLowerCase(), new c());
    }

    private void c(boolean flag)
    {
        if (mViews.searchHistoryView.a())
        {
            al.a(mViews.searchHistoryView, flag);
        }
    }

    public static SearchProductEverywhere i()
    {
        return new SearchProductEverywhere();
    }

    private void j()
    {
        mViews.searchHistoryView.setSearchHistoryListener(new a());
        mViews.searchSuggestionView.setSearchSuggestionListener(new b());
    }

    private void k()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.searchHistoryView.setSearchHistoryListener(null);
            mViews.searchSuggestionView.setSearchSuggestionListener(null);
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
            c(false);
            return;
        }
    }

    public void a(String s)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            c(s);
            return;
        }
    }

    public void a(List list)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.searchHistoryView.setData(list);
            c(true);
            return;
        }
    }

    public void b()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            a(false);
            c(true);
            return;
        }
    }

    public void c()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            c(false);
            mViews.searchHistoryView.b();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mSearchSuggestionManager = new com.target.mothership.model.typeahead.c();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03007d, viewgroup, false);
        a(layoutinflater);
        d();
        j();
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        mSearchSuggestionManager = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        k();
        mSearchSuggestionManager.a("TYPE_AHEAD_TAG");
        mViews = null;
    }

}
