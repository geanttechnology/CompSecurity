// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.search;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.e.d;
import com.target.ui.f.c;
import com.target.ui.fragment.common.BaseFullScreenDialogFragment;
import com.target.ui.fragment.product.dialog.SearchHistoryClearDialog;
import com.target.ui.fragment.product.plp.ProductSummaryPageFragment;
import com.target.ui.fragment.product.search.a.a;
import com.target.ui.fragment.product.search.presenter.SearchOverlayPresenter;
import com.target.ui.fragment.scan.SearchScanUpcFragment;
import com.target.ui.helper.o.b;
import com.target.ui.model.search.handler.ProductSuggestionModelTransformer;
import com.target.ui.service.provider.j;
import com.target.ui.util.ai;
import com.target.ui.util.al;
import com.target.ui.view.search.ExtendedSearchHistoryView;
import com.target.ui.view.search.SearchOverlayView;
import com.target.ui.view.search.SearchSuggestionCardView;
import java.util.List;

public class SearchOverlayDialogFragment extends BaseFullScreenDialogFragment
    implements com.target.ui.fragment.product.dialog.SearchHistoryClearDialog.b, a
{
    static class Views extends com.target.ui.view.a
    {

        View divider;
        ExtendedSearchHistoryView searchHistoryView;
        SearchOverlayView searchOverlayView;
        SearchSuggestionCardView searchSuggestionView;

        Views(View view)
        {
            super(view);
        }
    }


    private static final String ARG_INITIAL_SEARCH_TERM = "initial_search_term";
    private static final String ARG_PRESENTER_SAVED_STATE = "presenter_saved_state";
    private static final int INTERNAL_VOICE_SEARCH_REQUEST_CODE = 1;
    public static final String TAG = com/target/ui/fragment/product/search/SearchOverlayDialogFragment.getSimpleName();
    private d mNavigationFragmentManagerHolder;
    private SearchOverlayPresenter mPresenter;
    private Views mViews;

    public SearchOverlayDialogFragment()
    {
    }

    public static SearchOverlayDialogFragment a(String s, Fragment fragment)
    {
        SearchOverlayDialogFragment searchoverlaydialogfragment = new SearchOverlayDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("initial_search_term", s);
        searchoverlaydialogfragment.setArguments(bundle);
        searchoverlaydialogfragment.setTargetFragment(fragment, 0);
        return searchoverlaydialogfragment;
    }

    static SearchOverlayPresenter a(SearchOverlayDialogFragment searchoverlaydialogfragment)
    {
        return searchoverlaydialogfragment.mPresenter;
    }

    private void g()
    {
        mViews.searchHistoryView.setExtendedSearchHistoryClickListener(new com.target.ui.view.search.ExtendedSearchHistoryView.a() {

            final SearchOverlayDialogFragment this$0;

            public void a_(String s)
            {
                com.target.ui.fragment.product.search.SearchOverlayDialogFragment.a(SearchOverlayDialogFragment.this).a_(s);
            }

            public void b(String s)
            {
                com.target.ui.fragment.product.search.SearchOverlayDialogFragment.a(SearchOverlayDialogFragment.this).b(s);
            }

            public void u_()
            {
                com.target.ui.fragment.product.search.SearchOverlayDialogFragment.a(SearchOverlayDialogFragment.this).u_();
            }

            
            {
                this$0 = SearchOverlayDialogFragment.this;
                super();
            }
        });
        mViews.searchSuggestionView.setSearchSuggestionListener(new com.target.ui.view.search.SearchSuggestionCardView.b() {

            final SearchOverlayDialogFragment this$0;

            public void a(com.target.ui.model.search.a a1)
            {
                com.target.ui.fragment.product.search.SearchOverlayDialogFragment.a(SearchOverlayDialogFragment.this).a(a1);
            }

            public void c_(String s)
            {
                com.target.ui.fragment.product.search.SearchOverlayDialogFragment.a(SearchOverlayDialogFragment.this).c_(s);
            }

            
            {
                this$0 = SearchOverlayDialogFragment.this;
                super();
            }
        });
        mViews.searchOverlayView.setSearchOverlayViewListener(new com.target.ui.view.search.SearchOverlayView.a() {

            final SearchOverlayDialogFragment this$0;

            public void a()
            {
                com.target.ui.fragment.product.search.SearchOverlayDialogFragment.a(SearchOverlayDialogFragment.this).a();
            }

            public void a(String s)
            {
                com.target.ui.fragment.product.search.SearchOverlayDialogFragment.a(SearchOverlayDialogFragment.this).a(s);
            }

            public void b_(String s)
            {
                com.target.ui.fragment.product.search.SearchOverlayDialogFragment.a(SearchOverlayDialogFragment.this).b_(s);
            }

            public void w_()
            {
                com.target.ui.fragment.product.search.SearchOverlayDialogFragment.a(SearchOverlayDialogFragment.this).w_();
            }

            public void x_()
            {
                com.target.ui.fragment.product.search.SearchOverlayDialogFragment.a(SearchOverlayDialogFragment.this).x_();
            }

            
            {
                this$0 = SearchOverlayDialogFragment.this;
                super();
            }
        });
    }

    public void a()
    {
        Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        intent.putExtra("android.speech.extra.PROMPT", 0x7f0904ed);
        startActivityForResult(intent, 1);
    }

    public void a(int i)
    {
        ai.a(getActivity(), i);
    }

    public void a(ProductSummaryParam productsummaryparam)
    {
        mNavigationFragmentManagerHolder.m().d(ProductSummaryPageFragment.a(productsummaryparam, false));
        dismiss();
    }

    public void a(Store store)
    {
        mNavigationFragmentManagerHolder.m().d(SearchScanUpcFragment.a(store));
        dismiss();
    }

    public void a(String s)
    {
        mViews.searchOverlayView.setSearchTerm(s);
    }

    public void a(List list)
    {
        mViews.searchHistoryView.setData(list);
    }

    public void a(boolean flag)
    {
        al.a(mViews.divider, flag);
    }

    public void b()
    {
        dismiss();
    }

    public void b(List list)
    {
        list = new com.target.ui.model.search.c((new ProductSuggestionModelTransformer(getActivity())).a(list), com.target.ui.model.search.c.a.ENTERPRISE_SEARCH_SUGGESTION);
        mViews.searchSuggestionView.setData(list);
    }

    public void b(boolean flag)
    {
        al.a(mViews.searchHistoryView, flag);
    }

    public void c()
    {
        mPresenter.c();
    }

    public void c(boolean flag)
    {
        al.a(mViews.searchSuggestionView, flag);
    }

    public void f()
    {
        SearchHistoryClearDialog.a(this).show(getFragmentManager(), SearchHistoryClearDialog.TAG);
    }

    public void onActivityResult(int i, int k, Intent intent)
    {
        if (i != 1)
        {
            super.onActivityResult(i, k, intent);
            return;
        }
        SearchOverlayPresenter searchoverlaypresenter = mPresenter;
        if (intent != null)
        {
            intent = intent.getStringArrayListExtra("android.speech.extra.RESULTS");
        } else
        {
            intent = null;
        }
        searchoverlaypresenter.a(k, intent);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        mNavigationFragmentManagerHolder = (d)getTargetFragment();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getArguments().getString("initial_search_term");
        android.os.Parcelable parcelable = getArguments().getParcelable("presenter_saved_state");
        mPresenter = new SearchOverlayPresenter(new b(), new com.target.ui.helper.o.a(), new j(), bundle, parcelable);
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = super.onCreateDialog(bundle);
        com.target.ui.util.e.a.a(bundle);
        return bundle;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        super.onCreateOptionsMenu(menu, menuinflater);
        mPresenter.a(menu, menuinflater);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03007f, viewgroup, false);
        mViews = new Views(layoutinflater);
        g();
        mPresenter.a(this);
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        mPresenter.v_();
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mPresenter.z_();
        mViews = null;
    }

    public void onDetach()
    {
        super.onDetach();
        mNavigationFragmentManagerHolder = null;
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("presenter_saved_state", mPresenter.e());
    }

}
