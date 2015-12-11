// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.registry;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import com.k.a.c;
import com.target.mothership.common.params.RegistrySearchParam;
import com.target.mothership.model.registries.interfaces.Registry;
import com.target.mothership.model.registries.interfaces.RegistrySearchSummary;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.adapter.e.b;
import com.target.ui.analytics.a.ba;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.fragment.registry.a.f;
import com.target.ui.fragment.registry.presenter.RegistrySearchSummaryPagePresenter;
import com.target.ui.helper.l.a;
import com.target.ui.model.registry.RegistryRefineModel;
import com.target.ui.util.al;
import com.target.ui.util.k;
import com.target.ui.view.TargetFloatingActionButton;
import com.target.ui.view.common.TargetErrorView;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.registry:
//            RegistryDetailPageFragment, RegistrySearchRefinePageFragment

public class RegistrySearchSummaryPageFragment extends BaseNavigationFragment
    implements RegistrySearchRefinePageFragment.a, f
{
    static class Views extends com.target.ui.view.a
    {

        View contentContainer;
        TargetErrorView errorContainer;
        RecyclerView mListRecyclerView;
        View progressContainer;
        TargetFloatingActionButton refineFloatingActionButton;

        Views(View view)
        {
            super(view);
        }
    }

    private class a
        implements com.target.ui.view.common.c
    {

        final RegistrySearchSummaryPageFragment this$0;

        public void A_()
        {
            com.target.ui.fragment.registry.RegistrySearchSummaryPageFragment.b(RegistrySearchSummaryPageFragment.this).c();
        }

        private a()
        {
            this$0 = RegistrySearchSummaryPageFragment.this;
            super();
        }

    }

    private class b
        implements com.target.ui.adapter.e.b.a
    {

        final RegistrySearchSummaryPageFragment this$0;

        public void a()
        {
            com.target.ui.fragment.registry.RegistrySearchSummaryPageFragment.b(RegistrySearchSummaryPageFragment.this).d();
        }

        public void a(RegistrySearchSummary registrysearchsummary)
        {
            com.target.ui.fragment.registry.RegistrySearchSummaryPageFragment.b(RegistrySearchSummaryPageFragment.this).a(registrysearchsummary);
        }

        private b()
        {
            this$0 = RegistrySearchSummaryPageFragment.this;
            super();
        }

    }

    private class c extends android.support.v7.widget.RecyclerView.k
    {

        final RegistrySearchSummaryPageFragment this$0;

        public void a(RecyclerView recyclerview, int i1, int j1)
        {
            int k1 = com.target.ui.fragment.registry.RegistrySearchSummaryPageFragment.c(RegistrySearchSummaryPageFragment.this).o();
            int l1 = com.target.ui.fragment.registry.RegistrySearchSummaryPageFragment.c(RegistrySearchSummaryPageFragment.this).w();
            int i2 = com.target.ui.fragment.registry.RegistrySearchSummaryPageFragment.c(RegistrySearchSummaryPageFragment.this).i();
            com.target.ui.fragment.registry.RegistrySearchSummaryPageFragment.b(RegistrySearchSummaryPageFragment.this).a(i2, k1, l1, i1, j1);
        }

        private c()
        {
            this$0 = RegistrySearchSummaryPageFragment.this;
            super();
        }

    }

    private class d
        implements android.view.View.OnClickListener
    {

        final RegistrySearchSummaryPageFragment this$0;

        public void onClick(View view)
        {
            com.target.ui.fragment.registry.RegistrySearchSummaryPageFragment.b(RegistrySearchSummaryPageFragment.this).e();
        }

        private d()
        {
            this$0 = RegistrySearchSummaryPageFragment.this;
            super();
        }

    }


    private static final String ARG_REGISTRY_SEARCH_PARAM = "registrySearchParamArg";
    private static final String ARG_SAVED_STATE_PRESENTER = "registrySearchPresenterSavedState";
    private static final String ARG_STORE = "storeArg";
    private static final String TAG = com/target/ui/fragment/registry/RegistrySearchSummaryPageFragment.getSimpleName();
    private android.support.v7.widget.RecyclerView.c mListAdapterDataObserver;
    private LinearLayoutManager mListLayoutManager;
    private com.target.ui.adapter.e.b mListViewAdapter;
    private RegistrySearchSummaryPagePresenter mPresenter;
    private List mRegistrySummaryList;
    private Parcelable mSavedState;
    private com.k.a.c mStickyHeaderDecoration;
    private Views mViews;

    public RegistrySearchSummaryPageFragment()
    {
        mRegistrySummaryList = new ArrayList();
        mListAdapterDataObserver = new android.support.v7.widget.RecyclerView.c() {

            final RegistrySearchSummaryPageFragment this$0;

            public void a()
            {
                if (com.target.ui.fragment.registry.RegistrySearchSummaryPageFragment.a(RegistrySearchSummaryPageFragment.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.fragment.registry.RegistrySearchSummaryPageFragment.a(RegistrySearchSummaryPageFragment.this).a();
                    return;
                }
            }

            
            {
                this$0 = RegistrySearchSummaryPageFragment.this;
                super();
            }
        };
    }

    static com.k.a.c a(RegistrySearchSummaryPageFragment registrysearchsummarypagefragment)
    {
        return registrysearchsummarypagefragment.mStickyHeaderDecoration;
    }

    public static RegistrySearchSummaryPageFragment a(RegistrySearchParam registrysearchparam, Store store)
    {
        RegistrySearchSummaryPageFragment registrysearchsummarypagefragment = new RegistrySearchSummaryPageFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("storeArg", store);
        bundle.putParcelable("registrySearchParamArg", registrysearchparam);
        registrysearchsummarypagefragment.setArguments(bundle);
        return registrysearchsummarypagefragment;
    }

    static RegistrySearchSummaryPagePresenter b(RegistrySearchSummaryPageFragment registrysearchsummarypagefragment)
    {
        return registrysearchsummarypagefragment.mPresenter;
    }

    static LinearLayoutManager c(RegistrySearchSummaryPageFragment registrysearchsummarypagefragment)
    {
        return registrysearchsummarypagefragment.mListLayoutManager;
    }

    private void d()
    {
        mViews.errorContainer.setClickListener(new a());
        mViews.mListRecyclerView.setOnScrollListener(new c());
        mViews.refineFloatingActionButton.setOnClickListener(new d());
        mListViewAdapter.a(new b());
        mListViewAdapter.a(mListAdapterDataObserver);
    }

    private void e()
    {
        mViews.errorContainer.setClickListener(null);
        mViews.mListRecyclerView.setOnScrollListener(null);
        mViews.refineFloatingActionButton.setOnClickListener(null);
        mListViewAdapter.a(null);
        mListViewAdapter.b(mListAdapterDataObserver);
    }

    private Store f()
    {
        return (Store)getArguments().getParcelable("storeArg");
    }

    private RegistrySearchParam g()
    {
        return (RegistrySearchParam)getArguments().getParcelable("registrySearchParamArg");
    }

    private void h()
    {
        mViews.mListRecyclerView.setHasFixedSize(true);
        mListLayoutManager = new LinearLayoutManager(getActivity());
        mListLayoutManager.b(1);
        mViews.mListRecyclerView.setLayoutManager(mListLayoutManager);
        mListViewAdapter = new com.target.ui.adapter.e.b(mRegistrySummaryList);
        mViews.mListRecyclerView.setAdapter(mListViewAdapter);
        mViews.mListRecyclerView.a(new k(getActivity(), 1));
        mStickyHeaderDecoration = new com.k.a.c(mListViewAdapter);
        mViews.mListRecyclerView.a(new com.k.a.c(mListViewAdapter));
        mListViewAdapter.a(new android.support.v7.widget.RecyclerView.c() {

            final RegistrySearchSummaryPageFragment this$0;

            public void a()
            {
                if (com.target.ui.fragment.registry.RegistrySearchSummaryPageFragment.a(RegistrySearchSummaryPageFragment.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.fragment.registry.RegistrySearchSummaryPageFragment.a(RegistrySearchSummaryPageFragment.this).a();
                    return;
                }
            }

            
            {
                this$0 = RegistrySearchSummaryPageFragment.this;
                super();
            }
        });
    }

    private void i()
    {
        al.a(mViews.progressContainer, new View[] {
            mViews.errorContainer, mViews.contentContainer
        });
    }

    private void j()
    {
        al.a(mViews.errorContainer, new View[] {
            mViews.progressContainer, mViews.contentContainer
        });
    }

    private void k()
    {
        al.a(mViews.contentContainer, new View[] {
            mViews.progressContainer, mViews.errorContainer, mViews.contentContainer
        });
    }

    private void l()
    {
        mListViewAdapter.d();
        k();
    }

    public void a()
    {
        mViews.errorContainer.a(com.target.ui.view.common.b.a.ERROR_NO_NETWORK, true);
        j();
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
        j();
    }

    public void a(int i1, String s)
    {
        s = String.format(getString(0x7f0904c6), new Object[] {
            Integer.valueOf(i1), s
        });
        mListViewAdapter.a(s);
    }

    public void a(RegistrySearchParam registrysearchparam, RegistryRefineModel registryrefinemodel)
    {
        mPresenter.a(registrysearchparam, registryrefinemodel);
    }

    public void a(Registry registry)
    {
        if (Z())
        {
            return;
        } else
        {
            m().d(com.target.ui.fragment.registry.RegistryDetailPageFragment.a(registry, f()));
            return;
        }
    }

    public void a(RegistryRefineModel registryrefinemodel)
    {
        if (Z())
        {
            return;
        } else
        {
            registryrefinemodel = com.target.ui.fragment.registry.RegistrySearchRefinePageFragment.a(g(), registryrefinemodel, this);
            m().a(registryrefinemodel, com.target.ui.f.c.a.SLIDE_BOTTOM);
            return;
        }
    }

    public void a(List list)
    {
        mRegistrySummaryList.clear();
        mRegistrySummaryList.addAll(list);
        l();
    }

    public void a(boolean flag)
    {
        mListViewAdapter.c(false);
        mListViewAdapter.b(flag);
    }

    public void b()
    {
        i();
    }

    public void c()
    {
        ba.a(this).e();
    }

    public void c(boolean flag)
    {
        mListViewAdapter.c(flag);
    }

    public void d(boolean flag)
    {
        al.a(mViews.refineFloatingActionButton, flag);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            mSavedState = bundle.getParcelable("registrySearchPresenterSavedState");
        }
        mPresenter = new RegistrySearchSummaryPagePresenter(new com.target.ui.helper.l.a(), g(), new RegistryRefineModel(), mSavedState);
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
        layoutinflater = layoutinflater.inflate(0x7f030079, viewgroup, false);
        mViews = new Views(layoutinflater);
        h();
        mPresenter.a(this);
        d();
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        mPresenter.v_();
        mPresenter = null;
        mListLayoutManager = null;
        mRegistrySummaryList = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        e();
        mPresenter.z_();
        mViews = null;
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putParcelable("registrySearchPresenterSavedState", mPresenter.f());
        super.onSaveInstanceState(bundle);
    }

}
