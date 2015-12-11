// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.a.a.e;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.util.o;
import com.target.ui.fragment.product.common.BaseProductSearchFragment;
import com.target.ui.model.search.c;
import com.target.ui.model.search.handler.a;
import com.target.ui.service.k;
import com.target.ui.util.aa;
import com.target.ui.util.af;
import com.target.ui.util.ai;
import com.target.ui.util.al;
import com.target.ui.util.q;
import com.target.ui.view.search.SearchCurrentStoreCardView;
import com.target.ui.view.search.SearchHistoryCardView;
import com.target.ui.view.search.SearchSuggestionCardView;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.product.search:
//            a

public class SearchProductInStore extends BaseProductSearchFragment
{
    static class Views extends com.target.ui.view.a
    {

        SearchCurrentStoreCardView currentStoreView;
        SearchHistoryCardView searchHistoryView;
        SearchSuggestionCardView searchSuggestionView;

        public Views(View view)
        {
            super(view);
        }
    }

    private class a
        implements com.target.ui.view.search.SearchCurrentStoreCardView.b
    {

        final SearchProductInStore this$0;

        public void a()
        {
            ai.a(getActivity(), "yet to implement!");
        }

        private a()
        {
            this$0 = SearchProductInStore.this;
            super();
        }

    }

    private class b
        implements com.target.ui.util.aa.c
    {

        final SearchProductInStore this$0;

        public void a(String s)
        {
            String s1 = SearchProductInStore.TAG;
            StringBuilder stringbuilder = (new StringBuilder()).append("Error loading type ahead suggestions");
            if (s == null)
            {
                s = "";
            }
            q.a(s1, stringbuilder.append(s).toString());
        }

        public void a(List list)
        {
            com.target.ui.fragment.product.search.SearchProductInStore.a(SearchProductInStore.this, list);
        }

        private b()
        {
            this$0 = SearchProductInStore.this;
            super();
        }

    }

    private class c
        implements com.target.ui.view.search.SearchHistoryCardView.d
    {

        final SearchProductInStore this$0;

        public void a()
        {
            com.target.ui.fragment.product.search.SearchProductInStore.a(SearchProductInStore.this);
        }

        public void a(String s)
        {
            com.target.ui.fragment.product.search.SearchProductInStore.a(SearchProductInStore.this, s);
        }

        public void b()
        {
            SearchProductInStore.b(SearchProductInStore.this);
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

        private c()
        {
            this$0 = SearchProductInStore.this;
            super();
        }

    }

    private class d
        implements com.target.ui.view.search.SearchSuggestionCardView.b
    {

        final SearchProductInStore this$0;

        public void a(com.target.ui.model.search.a a1)
        {
            com.target.ui.fragment.product.search.SearchProductInStore.a(SearchProductInStore.this, a1);
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

        private d()
        {
            this$0 = SearchProductInStore.this;
            super();
        }

    }


    public static final String TAG = com/target/ui/fragment/product/search/SearchProductInStore.getSimpleName();
    private Views mViews;

    public SearchProductInStore()
    {
    }

    private void a(View view)
    {
        mViews = new Views(view);
    }

    static void a(SearchProductInStore searchproductinstore)
    {
        searchproductinstore.f();
    }

    static void a(SearchProductInStore searchproductinstore, com.target.ui.model.search.a a1)
    {
        searchproductinstore.a(a1);
    }

    static void a(SearchProductInStore searchproductinstore, String s)
    {
        searchproductinstore.b(s);
    }

    static void a(SearchProductInStore searchproductinstore, List list)
    {
        searchproductinstore.b(list);
    }

    private void a(boolean flag)
    {
        mViews.currentStoreView.setStoreName(af.a(h()));
        al.a(mViews.currentStoreView, flag);
    }

    static void b(SearchProductInStore searchproductinstore)
    {
        searchproductinstore.g();
    }

    private void b(List list)
    {
        if (mViews == null)
        {
            return;
        }
        if (list != null && !list.isEmpty())
        {
            list = new com.target.ui.model.search.c((new com.target.ui.model.search.handler.a()).a(list), com.target.ui.model.search.c.a.PI_SEARCH_SUGGESTION);
            mViews.searchSuggestionView.setData(list);
            d(true);
            return;
        } else
        {
            d(false);
            return;
        }
    }

    private void c(String s)
    {
        boolean flag = com.target.ui.service.k.a().c().b();
        if (o.g(s) && flag)
        {
            aa.a(s, (RelevantStoreSummary)com.target.ui.service.k.a().c().c(), new b());
        }
    }

    private void c(boolean flag)
    {
        if (mViews.searchHistoryView.a())
        {
            al.a(mViews.searchHistoryView, flag);
        }
    }

    private void d(boolean flag)
    {
        boolean flag2 = true;
        al.a(mViews.searchSuggestionView, flag);
        boolean flag1;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        a(flag1);
        if (!flag)
        {
            flag = flag2;
        } else
        {
            flag = false;
        }
        c(flag);
    }

    public static SearchProductInStore i()
    {
        return new SearchProductInStore();
    }

    private void j()
    {
        mViews.currentStoreView.setClickListener(new a());
        mViews.searchSuggestionView.setSearchSuggestionListener(new d());
        mViews.searchHistoryView.setSearchHistoryListener(new c());
    }

    private void k()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.searchSuggestionView.setOnClickListener(null);
            mViews.currentStoreView.setOnClickListener(null);
            mViews.searchHistoryView.setSearchHistoryListener(null);
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
            d(false);
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
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03007e, viewgroup, false);
        a(layoutinflater);
        d();
        a(true);
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
