// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.registry;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.f;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.target.mothership.common.params.RegistryDetailsParam;
import com.target.mothership.common.registries.RegistryId;
import com.target.mothership.model.registries.interfaces.Registry;
import com.target.mothership.model.registries.interfaces.RegistryDetails;
import com.target.mothership.model.registries.interfaces.RegistryProductDetails;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.analytics.a.bf;
import com.target.ui.c.d.a;
import com.target.ui.c.d.d;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.fragment.registry.a.c;
import com.target.ui.fragment.registry.presenter.RegistryDetailsPagePresenter;
import com.target.ui.util.af;
import com.target.ui.util.al;
import com.target.ui.util.k;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.common.TargetErrorView;
import java.util.ArrayList;
import java.util.List;

public class RegistryDetailPageFragment extends BaseNavigationFragment
    implements com.target.ui.fragment.registry.a.c
{
    static class Views extends com.target.ui.view.a
    {

        View contentContainer;
        TargetErrorView errorContainer;
        RecyclerView mListRecyclerView;
        View progressContainer;

        Views(View view)
        {
            super(view);
        }
    }

    private class a
        implements com.target.ui.view.common.c
    {

        final RegistryDetailPageFragment this$0;

        public void A_()
        {
            com.target.ui.fragment.registry.RegistryDetailPageFragment.a(RegistryDetailPageFragment.this).d();
        }

        private a()
        {
            this$0 = RegistryDetailPageFragment.this;
            super();
        }

    }

    private class b
        implements com.target.ui.adapter.e.a.a
    {

        final RegistryDetailPageFragment this$0;

        public void a()
        {
            com.target.ui.fragment.registry.RegistryDetailPageFragment.a(RegistryDetailPageFragment.this).e();
        }

        public void a(RegistryProductDetails registryproductdetails, RegistryDetails registrydetails, BitmapImageView bitmapimageview)
        {
            com.target.ui.fragment.registry.RegistryDetailPageFragment.a(RegistryDetailPageFragment.this).a(registryproductdetails, registrydetails, bitmapimageview, RegistryDetailPageFragment.b(RegistryDetailPageFragment.this));
        }

        private b()
        {
            this$0 = RegistryDetailPageFragment.this;
            super();
        }

    }

    private class c extends android.support.v7.widget.RecyclerView.k
    {

        final RegistryDetailPageFragment this$0;

        public void a(RecyclerView recyclerview, int i1, int j1)
        {
            int k1 = com.target.ui.fragment.registry.RegistryDetailPageFragment.c(RegistryDetailPageFragment.this).o();
            int l1 = com.target.ui.fragment.registry.RegistryDetailPageFragment.c(RegistryDetailPageFragment.this).w();
            int i2 = com.target.ui.fragment.registry.RegistryDetailPageFragment.c(RegistryDetailPageFragment.this).i();
            com.target.ui.fragment.registry.RegistryDetailPageFragment.a(RegistryDetailPageFragment.this).a(i2, k1, l1, i1, j1);
        }

        private c()
        {
            this$0 = RegistryDetailPageFragment.this;
            super();
        }

    }


    private static final String ARG_REGISTRY = "registryArg";
    private static final String ARG_REGISTRY_ID = "registryIdArg";
    private static final String ARG_SAVED_STATE_PRESENTER = "registryPresenterSavedStateArg";
    private static final String ARG_STORE = "storeArg";
    private static final String ARG_VIEW_MODE = "viewModeArg";
    private static final float BARCODE_DENSITY_INDEPENDENT_SCALING_FACTOR = 0.06F;
    private static final int VIEW_MODE_REGISTRY = 2;
    private static final int VIEW_MODE_REGISTRY_ID = 1;
    private static final double X_SIZE_MAX_RATIO = 1D;
    private static final double X_SIZE_MIN_RATIO = 0D;
    private LinearLayoutManager mListLayoutManager;
    private com.target.ui.adapter.e.a mListViewAdapter;
    private RegistryDetailsPagePresenter mPresenter;
    private com.target.ui.c.d.a mProductNavigateDelegate;
    private List mRegistryProductDetailsList;
    private Views mViews;

    public RegistryDetailPageFragment()
    {
        mProductNavigateDelegate = new com.target.ui.c.d.a(this);
        mRegistryProductDetailsList = new ArrayList();
    }

    private double a(double d1, double d2, double d3)
    {
        return Math.min(Math.max(d1, d2), d3);
    }

    public static RegistryDetailPageFragment a(RegistryId registryid, Store store)
    {
        RegistryDetailPageFragment registrydetailpagefragment = new RegistryDetailPageFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("storeArg", store);
        bundle.putInt("viewModeArg", 1);
        bundle.putParcelable("registryIdArg", registryid);
        registrydetailpagefragment.setArguments(bundle);
        return registrydetailpagefragment;
    }

    public static RegistryDetailPageFragment a(Registry registry, Store store)
    {
        RegistryDetailPageFragment registrydetailpagefragment = new RegistryDetailPageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("viewModeArg", 2);
        bundle.putParcelable("storeArg", store);
        bundle.putParcelable("registryArg", registry);
        registrydetailpagefragment.setArguments(bundle);
        return registrydetailpagefragment;
    }

    static RegistryDetailsPagePresenter a(RegistryDetailPageFragment registrydetailpagefragment)
    {
        return registrydetailpagefragment.mPresenter;
    }

    static Store b(RegistryDetailPageFragment registrydetailpagefragment)
    {
        return registrydetailpagefragment.o();
    }

    static LinearLayoutManager c(RegistryDetailPageFragment registrydetailpagefragment)
    {
        return registrydetailpagefragment.mListLayoutManager;
    }

    private void c()
    {
        mListViewAdapter.a(new b());
        mViews.mListRecyclerView.setOnScrollListener(new c());
        mViews.errorContainer.setClickListener(new a());
    }

    private void d()
    {
        mListViewAdapter.a(null);
        mViews.mListRecyclerView.setOnScrollListener(null);
        mViews.errorContainer.setClickListener(null);
    }

    private void e()
    {
        al.a(mViews.progressContainer, new View[] {
            mViews.errorContainer, mViews.contentContainer
        });
    }

    private void f()
    {
        al.a(mViews.errorContainer, new View[] {
            mViews.progressContainer, mViews.contentContainer
        });
    }

    private void g()
    {
        al.a(mViews.contentContainer, new View[] {
            mViews.progressContainer, mViews.errorContainer, mViews.contentContainer
        });
    }

    private void h()
    {
        mViews.mListRecyclerView.setHasFixedSize(true);
        mListLayoutManager = new LinearLayoutManager(getActivity());
        mListLayoutManager.b(1);
        mViews.mListRecyclerView.setLayoutManager(mListLayoutManager);
        final com.k.a.c stickyHeadersDecoration = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(stickyHeadersDecoration);
        double d1 = a(((DisplayMetrics) (stickyHeadersDecoration)).density * 0.06F, 0.0D, 1.0D);
        mListViewAdapter = new com.target.ui.adapter.e.a(mRegistryProductDetailsList, Double.valueOf(d1));
        mViews.mListRecyclerView.setAdapter(mListViewAdapter);
        mViews.mListRecyclerView.a(new k(getActivity(), 1));
        stickyHeadersDecoration = new com.k.a.c(mListViewAdapter);
        mViews.mListRecyclerView.a(stickyHeadersDecoration);
        mListViewAdapter.a(new android.support.v7.widget.RecyclerView.c() {

            final RegistryDetailPageFragment this$0;
            final com.k.a.c val$stickyHeadersDecoration;

            public void a()
            {
                if (stickyHeadersDecoration == null)
                {
                    return;
                } else
                {
                    stickyHeadersDecoration.a();
                    return;
                }
            }

            
            {
                this$0 = RegistryDetailPageFragment.this;
                stickyHeadersDecoration = c1;
                super();
            }
        });
    }

    private void i()
    {
        mListViewAdapter.d();
    }

    private RegistryDetailsParam j()
    {
        if (k() == 1)
        {
            return new RegistryDetailsParam(n(), o());
        } else
        {
            return new RegistryDetailsParam(l(), o());
        }
    }

    private int k()
    {
        return getArguments().getInt("viewModeArg") != 2 ? 1 : 2;
    }

    private Registry l()
    {
        return (Registry)getArguments().getParcelable("registryArg");
    }

    private RegistryId n()
    {
        return (RegistryId)getArguments().getParcelable("registryIdArg");
    }

    private Store o()
    {
        return (Store)getArguments().getParcelable("storeArg");
    }

    public void a()
    {
        mViews.errorContainer.a(com.target.ui.view.common.b.a.ERROR_NO_NETWORK, true);
        f();
    }

    public void a(int i1)
    {
        j(getString(i1));
    }

    public void a(int i1, int j1, boolean flag)
    {
        String s;
        String s1;
        if (i1 == 0)
        {
            s = "";
        } else
        {
            s = getString(i1);
        }
        if (j1 == 0)
        {
            s1 = "";
        } else
        {
            s1 = getString(j1);
        }
        mViews.errorContainer.a(s, s1, flag);
        f();
    }

    public void a(com.target.mothership.common.registries.c c1)
    {
        j(af.a(String.format(getString(0x7f0904a3), new Object[] {
            c1.toString()
        })));
    }

    public void a(RegistryDetails registrydetails, int i1)
    {
        mListViewAdapter.a(registrydetails, i1);
        g();
    }

    public void a(d d1)
    {
        mProductNavigateDelegate.a(d1);
    }

    public void a(List list)
    {
        mRegistryProductDetailsList.clear();
        mRegistryProductDetailsList.addAll(list);
        i();
        g();
    }

    public void a(boolean flag)
    {
        mListViewAdapter.b(flag);
    }

    public void b()
    {
        e();
    }

    public void b(com.target.mothership.common.registries.c c1)
    {
        (new bf(c1)).e();
    }

    public void c(boolean flag)
    {
        mListViewAdapter.c(flag);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        a(mProductNavigateDelegate);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        android.os.Parcelable parcelable = null;
        if (bundle != null)
        {
            parcelable = bundle.getParcelable("registryPresenterSavedStateArg");
        }
        mPresenter = new RegistryDetailsPagePresenter(new com.target.ui.helper.l.a(), j(), parcelable);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            super.onCreateOptionsMenu(menu, menuinflater);
            mPresenter.a(menu, menuinflater);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030076, viewgroup, false);
        mViews = new Views(layoutinflater);
        h();
        mPresenter.a(this);
        c();
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        mPresenter.v_();
        mPresenter = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        d();
        mPresenter.z_();
        mViews = null;
    }

    public void onDetach()
    {
        super.onDetach();
        mProductNavigateDelegate = null;
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putParcelable("registryPresenterSavedStateArg", mPresenter.c());
        super.onSaveInstanceState(bundle);
    }
}
