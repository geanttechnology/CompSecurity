// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shipping;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.services.o;
import com.target.ui.adapter.checkout.ShippingAddressAdapter;
import com.target.ui.analytics.a.ar;
import com.target.ui.analytics.a.au;
import com.target.ui.e.e;
import com.target.ui.fragment.account.AuthenticateDialog;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.fragment.common.ErrorDialogFragment;
import com.target.ui.fragment.shipping.a.f;
import com.target.ui.fragment.shipping.a.g;
import com.target.ui.fragment.shipping.b.b;
import com.target.ui.fragment.shop.ShopHomeFragment;
import com.target.ui.helper.c.i;
import com.target.ui.service.provider.d;
import com.target.ui.util.ai;
import com.target.ui.util.al;
import com.target.ui.util.e.a;
import com.target.ui.view.common.TargetErrorView;
import com.target.ui.view.common.c;
import com.target.ui.view.common.h;
import java.util.ArrayList;
import java.util.List;

public class ShippingAddressListFragment extends BaseNavigationFragment
    implements android.view.View.OnClickListener, com.target.ui.adapter.checkout.ShippingAddressAdapter.a, com.target.ui.fragment.account.BaseAccountDialog.a, com.target.ui.fragment.account.BaseAccountDialog.b, com.target.ui.fragment.shipping.a.e.a, b, c
{
    static class Views extends com.target.ui.view.a
    {

        Button actionSelectAddressDoneButton;
        View emptyListContainer;
        TextView emptyListPrimaryHint;
        TextView emptyListSecondaryHint;
        TargetErrorView errorView;
        ListView listView;

        Views(View view)
        {
            super(view);
        }
    }


    private static final String KEY_INITIATED_CHECKOUT = "initiated_checkout";
    private static final String KEY_PRODUCT_LIST = "product_list";
    private static final int NEW_ADDRESS_INDEX = 1;
    private static final String SHIPPING_INFO_MODE = "mode";
    public static final String TAG = com/target/ui/fragment/shipping/ShippingAddressListFragment.getSimpleName();
    private ShippingAddressAdapter mAdapter;
    private f mPresenter;
    private h mSnackBar;
    private Views mViews;
    private g mode;

    public ShippingAddressListFragment()
    {
    }

    public static ShippingAddressListFragment a(OrderReview orderreview, List list, com.target.ui.fragment.shipping.a.e.a a1)
    {
        ShippingAddressListFragment shippingaddresslistfragment = new ShippingAddressListFragment();
        if (a1 == null || !(a1 instanceof BaseNavigationFragment))
        {
            throw new IllegalArgumentException("ShippingActionListener must be an instance of BaseNavigationFragment");
        } else
        {
            shippingaddresslistfragment.setTargetFragment((Fragment)a1, 0);
            list = new ArrayList(list);
            a1 = new Bundle();
            a1.putParcelable("initiated_checkout", orderreview);
            a1.putParcelableArrayList("product_list", list);
            a1.putInt("mode", g.CHECKOUT.ordinal());
            shippingaddresslistfragment.setArguments(a1);
            return shippingaddresslistfragment;
        }
    }

    public static ShippingAddressListFragment b()
    {
        ShippingAddressListFragment shippingaddresslistfragment = new ShippingAddressListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("mode", g.ACCOUNT.ordinal());
        shippingaddresslistfragment.setArguments(bundle);
        return shippingaddresslistfragment;
    }

    private void t()
    {
        mViews.errorView.setClickListener(this);
        mViews.actionSelectAddressDoneButton.setOnClickListener(this);
    }

    private void u()
    {
        o(false);
        al.a(mViews.errorView, new View[] {
            mViews.emptyListContainer, mViews.listView, mViews.actionSelectAddressDoneButton
        });
    }

    public void A_()
    {
        mPresenter.g();
    }

    public void a()
    {
        if (mAdapter == null || mAdapter.b() == null)
        {
            return;
        }
        GuestAddress guestaddress;
        boolean flag;
        if (!mAdapter.a())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (mAdapter.getCount() > 2)
        {
            guestaddress = (GuestAddress)mAdapter.getItem(1);
        } else
        {
            guestaddress = null;
        }
        mPresenter.a(flag, guestaddress, m());
    }

    public void a(int i1)
    {
        mViews.errorView.a("", getString(i1), true);
        u();
    }

    public void a(GuestAddress guestaddress)
    {
        mPresenter.a(guestaddress);
    }

    public void a(GuestAddress guestaddress, OrderReview orderreview)
    {
    }

    public void a(Guest guest)
    {
        mPresenter.a(guest);
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

    public void a(ShippingAddressDetailsFragment.a a1, OrderReview orderreview)
    {
        mPresenter.a(false);
    }

    public void a(String s1)
    {
        mPresenter.a(s1);
    }

    public void a(List list, boolean flag)
    {
        mAdapter = new ShippingAddressAdapter(getActivity(), list, this, flag);
        mViews.listView.setAdapter(mAdapter);
    }

    public void a(boolean flag)
    {
        if (flag)
        {
            mViews.actionSelectAddressDoneButton.setVisibility(0);
        } else
        {
            mViews.actionSelectAddressDoneButton.setVisibility(8);
        }
        mViews.actionSelectAddressDoneButton.setEnabled(flag);
    }

    public boolean a(e e1)
    {
        ai.a(this, 0x7f090219);
        return true;
    }

    public void b(Object obj)
    {
        mPresenter.b(obj);
    }

    public void b(String s1)
    {
        mPresenter.b(s1);
    }

    public void c()
    {
        mPresenter.c();
    }

    public void c(boolean flag)
    {
        o(flag);
    }

    public void d(boolean flag)
    {
        if (flag)
        {
            String s1;
            if (mode.equals(g.ACCOUNT))
            {
                s1 = getString(0x7f090099);
            } else
            {
                s1 = getString(0x7f090248);
            }
            mViews.emptyListPrimaryHint.setText(getString(0x7f090244));
            mViews.emptyListSecondaryHint.setText(s1);
            al.a(mViews.emptyListContainer, new View[] {
                mViews.listView, mViews.errorView
            });
            return;
        } else
        {
            al.b(mViews.listView);
            al.a(new View[] {
                mViews.emptyListContainer, mViews.errorView
            });
            return;
        }
    }

    public f e()
    {
        Bundle bundle = getArguments();
        OrderReview orderreview = (OrderReview)bundle.getParcelable("initiated_checkout");
        ArrayList arraylist = bundle.getParcelableArrayList("product_list");
        mode = com.target.ui.fragment.shipping.a.g.values()[bundle.getInt("mode")];
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$fragment$shipping$presenter$ShippingInfoMode[];

            static 
            {
                $SwitchMap$com$target$ui$fragment$shipping$presenter$ShippingInfoMode = new int[com.target.ui.fragment.shipping.a.g.values().length];
                try
                {
                    $SwitchMap$com$target$ui$fragment$shipping$presenter$ShippingInfoMode[g.ACCOUNT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$fragment$shipping$presenter$ShippingInfoMode[g.CHECKOUT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.ui.fragment.shipping.presenter.ShippingInfoMode[mode.ordinal()])
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unrecognized ShippingInfoMode: ").append(mode).toString());

        case 1: // '\001'
            return new com.target.ui.fragment.shipping.a.b(new d(), new com.target.ui.helper.c.b());

        case 2: // '\002'
            return new com.target.ui.fragment.shipping.a.d(new d(), new com.target.ui.helper.c.f(orderreview), new i(orderreview, arraylist), orderreview, arraylist);
        }
    }

    public void g()
    {
        mViews.errorView.a(com.target.ui.view.common.b.a.ERROR_NO_NETWORK, true);
        u();
    }

    public void h()
    {
        o(false);
        if (Z())
        {
            return;
        } else
        {
            ErrorDialogFragment.a(getString(0x7f090278)).show(getFragmentManager(), ErrorDialogFragment.TAG);
            return;
        }
    }

    public void i()
    {
        mPresenter.a(true);
    }

    public void j()
    {
        al.c(mViews.errorView);
    }

    public void k()
    {
        mSnackBar.c(getString(0x7f09009a));
    }

    public com.target.ui.fragment.account.BaseAccountDialog.c l()
    {
        return this;
    }

    public com.target.ui.fragment.account.BaseAccountDialog.e n()
    {
        return s();
    }

    public void n_()
    {
        mPresenter.n_();
    }

    public void o()
    {
        mSnackBar.c(getString(0x7f090098));
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        com.target.ui.util.e.a.a(this);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131755364: 
            mPresenter.f();
            break;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mPresenter = e();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            j(getResources().getString(0x7f090247));
            menuinflater.inflate(0x7f120001, menu);
            super.onCreateOptionsMenu(menu, menuinflater);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030083, viewgroup, false);
        mViews = new Views(layoutinflater);
        mSnackBar = new h(getActivity());
        t();
        mPresenter.a(this);
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        mPresenter.v_();
        mPresenter = null;
        mAdapter = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mPresenter.z_();
        mViews = null;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131756540: 
            mPresenter.a(m());
            break;
        }
        return true;
    }

    public void onPause()
    {
        super.onPause();
        mSnackBar.a();
    }

    public void onResume()
    {
        super.onResume();
        switch (_cls1..SwitchMap.com.target.ui.fragment.shipping.presenter.ShippingInfoMode[mode.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            ar.j().e();
            return;

        case 2: // '\002'
            au.j().e();
            break;
        }
    }

    public void onStart()
    {
        _cls1..SwitchMap.com.target.ui.fragment.shipping.presenter.ShippingInfoMode[mode.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 37
    //                   2 48;
           goto _L1 _L2 _L3
_L1:
        super.onStart();
        return;
_L2:
        mPresenter.a(this);
        continue; /* Loop/switch isn't completed */
_L3:
        Fragment fragment = getTargetFragment();
        if (fragment == null)
        {
            throw new IllegalStateException("tried to retrieve target fragment, but it was null.");
        }
        if (!(fragment instanceof com.target.ui.fragment.shipping.a.e.a))
        {
            throw new IllegalStateException((new StringBuilder()).append("targetFragment must be an instance of ShippingActionListener.").append(fragment.getClass().getSimpleName()).append(" is not a ShippingActionListener.").toString());
        }
        mPresenter.a((com.target.ui.fragment.shipping.a.e.a)fragment);
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void p()
    {
        if (mAdapter == null)
        {
            mViews.errorView.a("", getString(0x7f0901e2), true);
            u();
        }
    }

    public void q()
    {
        com.target.ui.f.c c1;
        if (!Z())
        {
            if ((c1 = m()) != null)
            {
                c1.a(ShopHomeFragment.a());
                return;
            }
        }
    }

    public void r()
    {
        com.target.ui.f.c c1;
        if (!Z())
        {
            if ((c1 = m()) != null)
            {
                c1.b();
                return;
            }
        }
    }

    public com.target.ui.fragment.account.BaseAccountDialog.a s()
    {
        return this;
    }

}
