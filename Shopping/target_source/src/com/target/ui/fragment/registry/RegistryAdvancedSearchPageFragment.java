// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.registry;

import android.os.Bundle;
import android.support.v4.app.f;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.target.mothership.common.params.RegistrySearchParam;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.analytics.a.ba;
import com.target.ui.f.c;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.fragment.registry.a.b;
import com.target.ui.fragment.registry.presenter.RegistryAdvancedSearchPagePresenter;
import com.target.ui.util.ag;
import com.target.ui.util.validation.validator.RegistryFirstNameValidator;
import com.target.ui.util.validation.validator.RegistryLastNameValidator;
import com.target.ui.view.registry.RegistryAdvancedSearchOptionalFieldsView;
import com.target.ui.view.registry.RegistryNameView;
import java.util.Date;

// Referenced classes of package com.target.ui.fragment.registry:
//            RegistrySearchSummaryPageFragment

public class RegistryAdvancedSearchPageFragment extends BaseNavigationFragment
    implements com.target.ui.fragment.registry.a.b
{
    static class Views extends com.target.ui.view.a
    {

        RegistryAdvancedSearchOptionalFieldsView optionalFieldsView;
        RegistryNameView registryNameView;
        Button searchButtonView;

        Views(View view)
        {
            super(view);
        }
    }

    private class a
        implements com.target.ui.view.registry.RegistryAdvancedSearchOptionalFieldsView.h
    {

        final RegistryAdvancedSearchPageFragment this$0;

        public void a()
        {
            RegistryAdvancedSearchPageFragment.a(RegistryAdvancedSearchPageFragment.this).c();
        }

        public void a(boolean flag)
        {
            RegistryAdvancedSearchPageFragment.a(RegistryAdvancedSearchPageFragment.this).a(flag);
        }

        public void b()
        {
            RegistryAdvancedSearchPageFragment.a(RegistryAdvancedSearchPageFragment.this).d();
        }

        public void c()
        {
            RegistryAdvancedSearchPageFragment.a(RegistryAdvancedSearchPageFragment.this).e();
        }

        public void d()
        {
            RegistryAdvancedSearchPageFragment.a(RegistryAdvancedSearchPageFragment.this).f();
        }

        private a()
        {
            this$0 = RegistryAdvancedSearchPageFragment.this;
            super();
        }

    }

    private final class b
        implements com.target.ui.view.registry.RegistryNameView.e
    {

        final RegistryAdvancedSearchPageFragment this$0;

        public void a(String s)
        {
            RegistryAdvancedSearchPageFragment.a(RegistryAdvancedSearchPageFragment.this).a(s);
        }

        public void a(String s, boolean flag)
        {
            RegistryAdvancedSearchPageFragment.a(RegistryAdvancedSearchPageFragment.this).a(s, flag);
        }

        public void b(String s)
        {
            RegistryAdvancedSearchPageFragment.a(RegistryAdvancedSearchPageFragment.this).b(s);
        }

        public void b(String s, boolean flag)
        {
            RegistryAdvancedSearchPageFragment.a(RegistryAdvancedSearchPageFragment.this).b(s, flag);
        }

        private b()
        {
            this$0 = RegistryAdvancedSearchPageFragment.this;
            super();
        }

    }

    private class c
        implements android.view.View.OnClickListener
    {

        final RegistryAdvancedSearchPageFragment this$0;

        public void onClick(View view)
        {
            com.target.ui.fragment.registry.RegistryAdvancedSearchPageFragment.b(RegistryAdvancedSearchPageFragment.this);
        }

        private c()
        {
            this$0 = RegistryAdvancedSearchPageFragment.this;
            super();
        }

    }


    private static final String ARG_FIRST_NAME = "registryAdvancedSearchFirstNameArg";
    private static final String ARG_LAST_NAME = "registryAdvancedSearchLastNameArg";
    private static final String ARG_SAVED_STATE_PRESENTER = "registryAdvancedSearchSavedStateArg";
    private static final String ARG_STORE_ARG = "registryAdvancedSearchStoreArg";
    private RegistryFirstNameValidator mFirstNameValidator;
    private RegistryLastNameValidator mLastNameValidator;
    private RegistryAdvancedSearchPagePresenter mPresenter;
    private Views mViews;

    public RegistryAdvancedSearchPageFragment()
    {
    }

    public static RegistryAdvancedSearchPageFragment a(String s, String s1, Store store)
    {
        RegistryAdvancedSearchPageFragment registryadvancedsearchpagefragment = new RegistryAdvancedSearchPageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("registryAdvancedSearchFirstNameArg", s);
        bundle.putString("registryAdvancedSearchLastNameArg", s1);
        bundle.putParcelable("registryAdvancedSearchStoreArg", store);
        registryadvancedsearchpagefragment.setArguments(bundle);
        return registryadvancedsearchpagefragment;
    }

    static RegistryAdvancedSearchPagePresenter a(RegistryAdvancedSearchPageFragment registryadvancedsearchpagefragment)
    {
        return registryadvancedsearchpagefragment.mPresenter;
    }

    private void b(RegistrySearchParam registrysearchparam)
    {
        m().d(RegistrySearchSummaryPageFragment.a(registrysearchparam, l()));
    }

    static void b(RegistryAdvancedSearchPageFragment registryadvancedsearchpagefragment)
    {
        registryadvancedsearchpagefragment.n();
    }

    private void c(boolean flag)
    {
        mViews.searchButtonView.setEnabled(flag);
    }

    private void e(Date date)
    {
        if (Z())
        {
            return;
        } else
        {
            ag.a(getActivity().getFragmentManager(), date, new com.target.ui.util.ag.a() {

                final RegistryAdvancedSearchPageFragment this$0;

                public void a(Date date1)
                {
                    RegistryAdvancedSearchPageFragment.a(RegistryAdvancedSearchPageFragment.this).a(date1);
                }

            
            {
                this$0 = RegistryAdvancedSearchPageFragment.this;
                super();
            }
            });
            return;
        }
    }

    private void f(Date date)
    {
        if (Z())
        {
            return;
        } else
        {
            ag.a(getActivity().getFragmentManager(), date, new com.target.ui.util.ag.a() {

                final RegistryAdvancedSearchPageFragment this$0;

                public void a(Date date1)
                {
                    RegistryAdvancedSearchPageFragment.a(RegistryAdvancedSearchPageFragment.this).b(date1);
                }

            
            {
                this$0 = RegistryAdvancedSearchPageFragment.this;
                super();
            }
            });
            return;
        }
    }

    private void h()
    {
        mViews.registryNameView.setClickListener(new b());
        mViews.optionalFieldsView.setClickListener(new a());
        mViews.searchButtonView.setOnClickListener(new c());
    }

    private void i()
    {
        mViews.registryNameView.setClickListener(null);
        mViews.optionalFieldsView.setClickListener(null);
        mViews.searchButtonView.setOnClickListener(null);
    }

    private String j()
    {
        return getArguments().getString("registryAdvancedSearchFirstNameArg");
    }

    private String k()
    {
        return getArguments().getString("registryAdvancedSearchLastNameArg");
    }

    private Store l()
    {
        return (Store)getArguments().getParcelable("registryAdvancedSearchStoreArg");
    }

    private void n()
    {
        String s = mViews.registryNameView.getFirstName();
        String s1 = mViews.registryNameView.getLastName();
        com.target.mothership.common.registries.c c1 = mViews.optionalFieldsView.getRegistryEventType();
        String s2 = mViews.optionalFieldsView.getCity();
        String s3 = mViews.optionalFieldsView.getState();
        Date date = mViews.optionalFieldsView.getStartDate();
        Date date1 = mViews.optionalFieldsView.getEndDate();
        String s4 = mViews.optionalFieldsView.getEmail();
        mPresenter.a(s, s1, c1, s2, s3, date, date1, s4);
    }

    public void a()
    {
        mViews.registryNameView.a();
    }

    public void a(int i1)
    {
        j(getString(i1));
    }

    public void a(RegistrySearchParam registrysearchparam)
    {
        b(registrysearchparam);
    }

    public void a(String s)
    {
        mViews.registryNameView.a(s);
    }

    public void a(String s, String s1)
    {
        mViews.registryNameView.a(s, s1);
    }

    public void a(Date date)
    {
        e(date);
    }

    public void a(boolean flag)
    {
        c(flag);
    }

    public void b()
    {
        mViews.registryNameView.b();
    }

    public void b(int i1)
    {
        mViews.optionalFieldsView.a(i1);
    }

    public void b(String s)
    {
        mViews.registryNameView.b(s);
    }

    public void b(Date date)
    {
        f(date);
    }

    public void c()
    {
        ba.a(this).e();
    }

    public void c(int i1)
    {
        mViews.optionalFieldsView.b(i1);
    }

    public void c(Date date)
    {
        mViews.optionalFieldsView.a(date);
    }

    public void d()
    {
        mViews.optionalFieldsView.a();
    }

    public void d(Date date)
    {
        mViews.optionalFieldsView.b(date);
    }

    public void e()
    {
        mViews.optionalFieldsView.b();
    }

    public void f()
    {
        mViews.optionalFieldsView.c();
    }

    public void g()
    {
        mViews.optionalFieldsView.d();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        android.os.Parcelable parcelable = null;
        if (bundle != null)
        {
            parcelable = bundle.getParcelable("registryAdvancedSearchSavedStateArg");
        }
        mFirstNameValidator = new RegistryFirstNameValidator(getActivity());
        mLastNameValidator = new RegistryLastNameValidator(getActivity());
        mPresenter = new RegistryAdvancedSearchPagePresenter(mFirstNameValidator, mLastNameValidator, j(), k(), parcelable);
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
        layoutinflater = layoutinflater.inflate(0x7f030075, viewgroup, false);
        mViews = new Views(layoutinflater);
        mPresenter.a(this);
        h();
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        mPresenter.v_();
        mPresenter = null;
        mFirstNameValidator = null;
        mLastNameValidator = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        i();
        mViews = null;
        mPresenter.z_();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putParcelable("registryAdvancedSearchSavedStateArg", mPresenter.g());
        super.onSaveInstanceState(bundle);
    }
}
