// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.navigation;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.f;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.b;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.TextView;
import com.google.a.a.e;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.model.store.interfaces.StoreSummary;
import com.target.ui.analytics.a.ai;
import com.target.ui.analytics.a.ba;
import com.target.ui.f.c;
import com.target.ui.fragment.account.AccountTabbedFragment;
import com.target.ui.fragment.common.BaseStoreChooserFragment;
import com.target.ui.fragment.common.TargetWebFragment;
import com.target.ui.fragment.list.ListDetailFragment;
import com.target.ui.fragment.navigation.b.a;
import com.target.ui.fragment.store.StoreDetailFragment;
import com.target.ui.model.list.ListCollectionItem;
import com.target.ui.service.k;
import com.target.ui.service.m;
import com.target.ui.util.j;
import com.target.ui.view.HelpNotificationBadgeView;
import com.target.ui.view.navigation.NavigationHeaderView;
import com.target.ui.view.navigation.NavigationStoreSelectionView;

public class NavigationDrawerFragment extends BaseStoreChooserFragment
    implements a, com.target.ui.service.a.b, com.target.ui.service.k.c, com.target.ui.view.navigation.NavigationStoreSelectionView.a
{
    static class Views extends com.target.ui.view.a
    {

        HelpNotificationBadgeView helpNotificationBadgeView;
        NavigationHeaderView navigationHeaderView;
        NavigationStoreSelectionView navigationStoreSelectionView;

        Views(View view)
        {
            super(view);
        }
    }


    private static final String PARTNERS_URL = "file:///android_asset/htmls/partners.html";
    private static final String TAG = com/target/ui/fragment/navigation/NavigationDrawerFragment.getSimpleName();
    private DrawerLayout mDrawerLayout;
    private b mDrawerToggle;
    private View mFragmentContainerView;
    private com.target.ui.fragment.navigation.a.a mNavigationDrawerPresenter;
    private Views mViews;

    public NavigationDrawerFragment()
    {
    }

    static Views a(NavigationDrawerFragment navigationdrawerfragment)
    {
        return navigationdrawerfragment.mViews;
    }

    private void a(final View rootView)
    {
        mViews = new Views(rootView);
        com.target.ui.service.k.a().a(this);
        com.target.ui.service.a.a().a(this);
        l();
        if (com.target.ui.util.j.b())
        {
            rootView.setOnApplyWindowInsetsListener(new android.view.View.OnApplyWindowInsetsListener() {

                final NavigationDrawerFragment this$0;
                final View val$rootView;

                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowinsets)
                {
                    if (com.target.ui.fragment.navigation.NavigationDrawerFragment.a(NavigationDrawerFragment.this) != null)
                    {
                        com.target.ui.fragment.navigation.NavigationDrawerFragment.a(NavigationDrawerFragment.this).navigationHeaderView.a(windowinsets.getSystemWindowInsetTop());
                        rootView.setOnApplyWindowInsetsListener(null);
                        rootView.requestLayout();
                    }
                    return rootView.onApplyWindowInsets(windowinsets);
                }

            
            {
                this$0 = NavigationDrawerFragment.this;
                rootView = view;
                super();
            }
            });
        }
        mViews.helpNotificationBadgeView.setOnClickListener(new android.view.View.OnClickListener() {

            final NavigationDrawerFragment this$0;

            public void onClick(View view)
            {
                com.target.ui.fragment.navigation.NavigationDrawerFragment.b(NavigationDrawerFragment.this).e();
            }

            
            {
                this$0 = NavigationDrawerFragment.this;
                super();
            }
        });
        mViews.navigationStoreSelectionView.setListener(this);
        b(com.target.ui.service.k.a().c());
    }

    private void a(TextView textview)
    {
        textview.setText(getString(0x7f0903d6));
    }

    static void a(NavigationDrawerFragment navigationdrawerfragment, Fragment fragment)
    {
        navigationdrawerfragment.a(fragment);
    }

    static void a(NavigationDrawerFragment navigationdrawerfragment, Fragment fragment, String s)
    {
        navigationdrawerfragment.a(fragment, s);
    }

    static com.target.ui.fragment.navigation.a.a b(NavigationDrawerFragment navigationdrawerfragment)
    {
        return navigationdrawerfragment.mNavigationDrawerPresenter;
    }

    private void b(View view)
    {
        View view1 = view.findViewById(0x7f100472);
        View view2 = view.findViewById(0x7f100473);
        TextView textview = (TextView)view.findViewById(0x7f100474);
        View view3 = view.findViewById(0x7f100475);
        View view4 = view.findViewById(0x7f100476);
        View view5 = view.findViewById(0x7f100479);
        view = view.findViewById(0x7f10047a);
        view1.setOnClickListener(new android.view.View.OnClickListener() {

            final NavigationDrawerFragment this$0;

            public void onClick(View view6)
            {
                NavigationDrawerFragment.d(NavigationDrawerFragment.this);
                ai.a(com.target.ui.analytics.a.ai.a.Shop).e();
            }

            
            {
                this$0 = NavigationDrawerFragment.this;
                super();
            }
        });
        view2.setOnClickListener(new android.view.View.OnClickListener() {

            final NavigationDrawerFragment this$0;

            public void onClick(View view6)
            {
                view6 = ListDetailFragment.a((ListCollectionItem)m.a().b().d());
                com.target.ui.fragment.navigation.NavigationDrawerFragment.a(NavigationDrawerFragment.this, view6);
                ai.a(com.target.ui.analytics.a.ai.a.List).e();
            }

            
            {
                this$0 = NavigationDrawerFragment.this;
                super();
            }
        });
        view3.setOnClickListener(new android.view.View.OnClickListener() {

            final NavigationDrawerFragment this$0;

            public void onClick(View view6)
            {
                com.target.ui.fragment.navigation.NavigationDrawerFragment.b(NavigationDrawerFragment.this, AccountTabbedFragment.a());
                ai.a(com.target.ui.analytics.a.ai.a.Account).e();
            }

            
            {
                this$0 = NavigationDrawerFragment.this;
                super();
            }
        });
        view4.setOnClickListener(new android.view.View.OnClickListener() {

            final NavigationDrawerFragment this$0;

            public void onClick(View view6)
            {
                com.target.ui.fragment.navigation.NavigationDrawerFragment.b(NavigationDrawerFragment.this).g();
            }

            
            {
                this$0 = NavigationDrawerFragment.this;
                super();
            }
        });
        view5.setOnClickListener(new android.view.View.OnClickListener() {

            final NavigationDrawerFragment this$0;

            public void onClick(View view6)
            {
                view6 = TargetWebFragment.a(false, "file:///android_asset/htmls/partners.html", getString(0x7f0903f8));
                com.target.ui.fragment.navigation.NavigationDrawerFragment.a(NavigationDrawerFragment.this, view6, TargetWebFragment.TAG);
            }

            
            {
                this$0 = NavigationDrawerFragment.this;
                super();
            }
        });
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final NavigationDrawerFragment this$0;

            public void onClick(View view6)
            {
                com.target.ui.fragment.navigation.NavigationDrawerFragment.b(NavigationDrawerFragment.this).f();
            }

            
            {
                this$0 = NavigationDrawerFragment.this;
                super();
            }
        });
        a(textview);
    }

    private void b(e e1)
    {
        mViews.navigationStoreSelectionView.setCurrentStore((RelevantStoreSummary)e1.d());
    }

    static void b(NavigationDrawerFragment navigationdrawerfragment, Fragment fragment)
    {
        navigationdrawerfragment.a(fragment);
    }

    static b c(NavigationDrawerFragment navigationdrawerfragment)
    {
        return navigationdrawerfragment.mDrawerToggle;
    }

    static void d(NavigationDrawerFragment navigationdrawerfragment)
    {
        navigationdrawerfragment.S();
    }

    private void k()
    {
        com.target.ui.service.k.a().b(this);
        com.target.ui.service.a.a().b(this);
        mViews.navigationStoreSelectionView.setListener(null);
        mViews = null;
    }

    private void l()
    {
        e e1 = com.target.ui.service.a.a().c();
        mViews.navigationHeaderView.a(e1);
    }

    public void J()
    {
    }

    public void a()
    {
        if (mViews != null)
        {
            mViews.helpNotificationBadgeView.setVisibility(8);
        }
    }

    public void a(int i1)
    {
        if (mViews != null)
        {
            mViews.helpNotificationBadgeView.setVisibility(0);
            mViews.helpNotificationBadgeView.setBadgeInformation(i1);
        }
    }

    public void a(int i1, DrawerLayout drawerlayout)
    {
        mFragmentContainerView = getActivity().findViewById(i1);
        mDrawerLayout = drawerlayout;
        mDrawerLayout.a(0x7f020113, 0x800003);
        mDrawerToggle = new b(getActivity(), mDrawerLayout, 0x7f0903db, 0x7f0903da) {

            final NavigationDrawerFragment this$0;

            public void a(int j1)
            {
                super.a(j1);
            }

            public void a(View view)
            {
                super.a(view);
                ba.a(NavigationDrawerFragment.this).e();
                ai.a(com.target.ui.analytics.a.ai.a.Main).e();
            }

            public void b(View view)
            {
                super.b(view);
            }

            
            {
                this$0 = NavigationDrawerFragment.this;
                super(activity, drawerlayout, i1, j1);
            }
        };
        mDrawerLayout.post(new Runnable() {

            final NavigationDrawerFragment this$0;

            public void run()
            {
                com.target.ui.fragment.navigation.NavigationDrawerFragment.c(NavigationDrawerFragment.this).a();
            }

            
            {
                this$0 = NavigationDrawerFragment.this;
                super();
            }
        });
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    public void a(e e1)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            b(e1);
            return;
        }
    }

    public void a(Guest guest)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.navigationHeaderView.a(guest);
            return;
        }
    }

    public void a(RelevantStoreSummary relevantstoresummary)
    {
        m().e(StoreDetailFragment.a(relevantstoresummary.getStoreId()));
    }

    public void a(StoreSummary storesummary)
    {
        com.target.ui.service.k.a().a(storesummary.getStoreId());
    }

    public void b()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.navigationHeaderView.a();
            return;
        }
    }

    public void c()
    {
        if (getActivity() != null)
        {
            com.target.ui.d.a.c().b(getActivity());
        }
    }

    public void d()
    {
        if (getActivity() != null)
        {
            com.target.ui.d.a.c().a(getActivity());
        }
    }

    public void e()
    {
        h();
    }

    public void f()
    {
        if (mDrawerLayout != null && mDrawerLayout.j(mFragmentContainerView))
        {
            mDrawerLayout.i(mFragmentContainerView);
        }
    }

    public com.target.ui.fragment.store.StoreChooserDialogFragment.d g()
    {
        return com.target.ui.fragment.store.StoreChooserDialogFragment.d.NEARBY_STORES;
    }

    public b i()
    {
        return mDrawerToggle;
    }

    public boolean j()
    {
        return mDrawerLayout != null && mDrawerLayout.j(mFragmentContainerView);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        m(false);
        setHasOptionsMenu(true);
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        mDrawerToggle.a(configuration);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mNavigationDrawerPresenter = new com.target.ui.fragment.navigation.a.a(new com.target.ui.helper.i.a(com.target.ui.d.a.c()));
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030066, viewgroup, false);
        a(layoutinflater);
        b(layoutinflater);
        mNavigationDrawerPresenter.a(this);
        return layoutinflater;
    }

    public void onDestroy()
    {
        mNavigationDrawerPresenter.v_();
        mNavigationDrawerPresenter = null;
        super.onDestroy();
    }

    public void onDestroyView()
    {
        mNavigationDrawerPresenter.z_();
        k();
        super.onDestroyView();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (mDrawerToggle.a(menuitem))
        {
            com.target.ui.util.e.a.a(this);
            return true;
        } else
        {
            return false;
        }
    }

    public void onResume()
    {
        super.onResume();
        mNavigationDrawerPresenter.c();
        a(com.target.ui.service.k.a().c());
    }

}
