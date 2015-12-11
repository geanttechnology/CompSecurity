// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cart;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.h;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.target.mothership.model.cart.interfaces.SaveForLaterProduct;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.services.o;
import com.target.ui.analytics.a.an;
import com.target.ui.analytics.a.bg;
import com.target.ui.c.d.a;
import com.target.ui.fragment.account.AuthenticateDialog;
import com.target.ui.fragment.cart.a.b;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.fragment.common.ErrorDialogFragment;
import com.target.ui.helper.b.d;
import com.target.ui.service.provider.f;
import com.target.ui.util.al;
import com.target.ui.util.k;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.common.TargetErrorView;
import com.target.ui.view.common.c;
import java.util.List;

public class SaveForLaterFragment extends BaseNavigationFragment
    implements com.target.ui.adapter.f.a.a, com.target.ui.fragment.account.BaseAccountDialog.a, com.target.ui.fragment.account.BaseAccountDialog.b, com.target.ui.fragment.account.BaseAccountDialog.c, b, c
{
    static class Views extends com.target.ui.view.a
    {

        View emptyListContainer;
        TextView emptyListPrimaryHint;
        TextView emptyListSecondaryHint;
        TargetErrorView errorView;
        RecyclerView list;

        Views(View view)
        {
            super(view);
        }
    }


    private static final String TAG = com/target/ui/fragment/cart/SaveForLaterFragment.getSimpleName();
    private com.target.ui.adapter.f.a mAdapter;
    private a mNavigateToPdpDelegate;
    private com.target.ui.fragment.cart.b.b mPresenter;
    private com.target.ui.view.common.h mSnackBar;
    private Views mViews;

    public SaveForLaterFragment()
    {
        mNavigateToPdpDelegate = new a(this);
    }

    public static SaveForLaterFragment a()
    {
        return new SaveForLaterFragment();
    }

    public void A_()
    {
        mPresenter.c();
    }

    public void a(int i1)
    {
        j(getString(i1));
    }

    public void a(Menu menu, MenuInflater menuinflater, int i1)
    {
        menuinflater.inflate(i1, menu);
    }

    public void a(SaveForLaterProduct saveforlaterproduct)
    {
        mPresenter.b(saveforlaterproduct);
    }

    public void a(Guest guest)
    {
        mPresenter.e();
    }

    public void a(Guest guest, o o1)
    {
        if (Z())
        {
            return;
        } else
        {
            guest = AuthenticateDialog.a(guest, this);
            guest.a(o1);
            guest.show(getFragmentManager(), AuthenticateDialog.TAG);
            return;
        }
    }

    public void a(com.target.ui.c.d.d d1)
    {
        mNavigateToPdpDelegate.a(d1);
    }

    public void a(BitmapImageView bitmapimageview, SaveForLaterProduct saveforlaterproduct)
    {
        mPresenter.a(bitmapimageview, saveforlaterproduct);
    }

    public void a(String s)
    {
        mPresenter.h();
    }

    public void a(List list)
    {
        mAdapter.a(list);
        al.a(mViews.list, new View[] {
            mViews.emptyListContainer, mViews.errorView
        });
    }

    public void a(boolean flag)
    {
        o(flag);
    }

    public void b()
    {
        if (Z())
        {
            return;
        } else
        {
            getFragmentManager().c();
            return;
        }
    }

    public void b(int i1)
    {
        if (Z())
        {
            return;
        } else
        {
            ErrorDialogFragment.a("", getString(i1)).show(getFragmentManager(), ErrorDialogFragment.TAG);
            return;
        }
    }

    public void b(SaveForLaterProduct saveforlaterproduct)
    {
        mPresenter.a(saveforlaterproduct);
    }

    public void b(Object obj)
    {
        mPresenter.d();
    }

    public void b(String s)
    {
        mPresenter.g();
    }

    public void c()
    {
        mPresenter.f();
    }

    public void c(int i1)
    {
        mSnackBar.c(getString(i1));
    }

    public void e()
    {
        if (Z())
        {
            return;
        } else
        {
            m().a();
            return;
        }
    }

    public void g()
    {
        al.a(mViews.emptyListContainer, new View[] {
            mViews.list, mViews.errorView
        });
    }

    public void h()
    {
        mViews.errorView.a("", getString(0x7f090278), true);
        al.a(mViews.errorView, new View[] {
            mViews.emptyListContainer, mViews.list
        });
    }

    public void i()
    {
        if (Z())
        {
            return;
        } else
        {
            ErrorDialogFragment.a("", getString(0x7f090278)).show(getFragmentManager(), ErrorDialogFragment.TAG);
            return;
        }
    }

    public void j()
    {
        mViews.errorView.a(com.target.ui.view.common.b.a.ERROR_NO_NETWORK, true);
        al.a(mViews.errorView, new View[] {
            mViews.emptyListContainer, mViews.list
        });
    }

    public void k()
    {
        an.a(1).e();
    }

    public com.target.ui.fragment.account.BaseAccountDialog.c l()
    {
        return this;
    }

    public com.target.ui.fragment.account.BaseAccountDialog.e n()
    {
        return p();
    }

    public void n_()
    {
        mPresenter.i();
    }

    public void o()
    {
        an.a(2).e();
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        a(mNavigateToPdpDelegate);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mSnackBar = new com.target.ui.view.common.h(getActivity());
        mPresenter = new com.target.ui.fragment.cart.b.b(new d(), new f());
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        mPresenter.a(menu, menuinflater);
        super.onCreateOptionsMenu(menu, menuinflater);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03007b, viewgroup, false);
        mViews = new Views(layoutinflater);
        mAdapter = new com.target.ui.adapter.f.a(getActivity().getApplicationContext(), this);
        mViews.list.setLayoutManager(new LinearLayoutManager(getActivity()));
        mViews.list.a(new k(getActivity(), 1));
        mViews.list.setAdapter(mAdapter);
        mViews.emptyListPrimaryHint.setText(0x7f0904d8);
        mViews.emptyListSecondaryHint.setText(0x7f0904d9);
        mViews.errorView.setClickListener(this);
        mPresenter.a(this);
        return layoutinflater;
    }

    public void onDestroy()
    {
        mPresenter.v_();
        mPresenter = null;
        mSnackBar = null;
        super.onDestroy();
    }

    public void onDestroyView()
    {
        mPresenter.z_();
        super.onDestroyView();
    }

    public void onDetach()
    {
        super.onDetach();
        mNavigateToPdpDelegate = null;
    }

    public void onPause()
    {
        super.onPause();
        mSnackBar.a();
    }

    public void onResume()
    {
        super.onResume();
        bg.j().e();
    }

    public com.target.ui.fragment.account.BaseAccountDialog.a p()
    {
        return this;
    }

}
