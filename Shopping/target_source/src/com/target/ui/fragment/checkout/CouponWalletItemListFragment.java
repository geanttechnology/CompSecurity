// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.checkout;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.google.a.a.e;
import com.target.mothership.model.coupon_wallets.interfaces.WalletItem;
import com.target.ui.adapter.checkout.CouponWalletAdapter;
import com.target.ui.f.c;
import com.target.ui.fragment.checkout.b.b;
import com.target.ui.fragment.checkout.d.d;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.fragment.common.SimpleDialogFragment;
import com.target.ui.util.al;
import com.target.ui.util.e.a;
import com.target.ui.view.TargetButton;
import java.util.ArrayList;
import java.util.List;

public class CouponWalletItemListFragment extends BaseNavigationFragment
    implements com.target.ui.adapter.checkout.CouponWalletAdapter.a, d
{
    private static class a
    {

        private TargetButton applyButton;
        private ListView couponWalletList;

        static ListView a(a a1)
        {
            return a1.couponWalletList;
        }

        static TargetButton b(a a1)
        {
            return a1.applyButton;
        }

        public a(View view)
        {
            couponWalletList = (ListView)view.findViewById(0x7f100163);
            applyButton = (TargetButton)view.findViewById(0x7f100164);
        }
    }

    public static interface b
    {

        public abstract void a(WalletItem walletitem);
    }


    private static final String KEY_WALLET_ITEMS = "wallet_items";
    private CouponWalletAdapter mAdapter;
    private com.target.ui.fragment.checkout.b.b mPresenter;
    private a mViews;
    private b mWalletItemActionListener;

    public CouponWalletItemListFragment()
    {
    }

    public static CouponWalletItemListFragment a(ArrayList arraylist, b b1)
    {
        CouponWalletItemListFragment couponwalletitemlistfragment = new CouponWalletItemListFragment();
        if (!(b1 instanceof BaseNavigationFragment))
        {
            throw new IllegalArgumentException("WalletItemActionListener must be an instance of BaseNavigationFragment");
        } else
        {
            couponwalletitemlistfragment.setTargetFragment((Fragment)b1, 0);
            b1 = new Bundle();
            b1.putParcelableArrayList("wallet_items", arraylist);
            couponwalletitemlistfragment.setArguments(b1);
            return couponwalletitemlistfragment;
        }
    }

    static com.target.ui.fragment.checkout.b.b a(CouponWalletItemListFragment couponwalletitemlistfragment)
    {
        return couponwalletitemlistfragment.mPresenter;
    }

    private List a()
    {
        return getArguments().getParcelableArrayList("wallet_items");
    }

    private void b()
    {
        c c1;
        if (!Z())
        {
            if ((c1 = m()) != null)
            {
                c1.b();
                return;
            }
        }
    }

    public void a(WalletItem walletitem)
    {
        mPresenter.a(walletitem);
    }

    public void a(List list, WalletItem walletitem)
    {
        android.support.v4.app.f f = getActivity();
        if (f != null && mViews != null)
        {
            mAdapter = new CouponWalletAdapter(f, list, walletitem, this);
            com.target.ui.fragment.checkout.a.a(mViews).setAdapter(mAdapter);
        }
    }

    public void a(boolean flag)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            al.b(com.target.ui.fragment.checkout.a.b(mViews));
            com.target.ui.fragment.checkout.a.b(mViews).setEnabled(flag);
            com.target.ui.fragment.checkout.a.b(mViews).setOnClickListener(new android.view.View.OnClickListener() {

                final CouponWalletItemListFragment this$0;

                public void onClick(View view)
                {
                    com.target.ui.fragment.checkout.CouponWalletItemListFragment.a(CouponWalletItemListFragment.this).c();
                }

            
            {
                this$0 = CouponWalletItemListFragment.this;
                super();
            }
            });
            return;
        }
    }

    public void b(WalletItem walletitem)
    {
        mPresenter.b(walletitem);
    }

    public void c(WalletItem walletitem)
    {
        e e1 = walletitem.c();
        Object obj = walletitem.b();
        if (e1.b())
        {
            walletitem = (String)e1.c();
        } else
        {
            walletitem = getResources().getString(0x7f090527);
        }
        if (((e) (obj)).b())
        {
            obj = (String)((e) (obj)).c();
        } else
        {
            obj = "";
        }
        SimpleDialogFragment.a(walletitem, ((String) (obj))).show(getFragmentManager(), SimpleDialogFragment.TAG);
    }

    public void d(WalletItem walletitem)
    {
        if (mWalletItemActionListener != null)
        {
            mWalletItemActionListener.a(walletitem);
            b();
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        com.target.ui.util.e.a.a(this);
    }

    public void onAttach(Activity activity)
    {
        try
        {
            mWalletItemActionListener = (b)getTargetFragment();
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new ClassCastException((new StringBuilder()).append("Parent fragment must implement ").append(com/target/ui/fragment/checkout/CouponWalletItemListFragment$b.getSimpleName()).toString());
        }
        if (mWalletItemActionListener == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("TargetFragment must be an instance of ").append(com/target/ui/fragment/checkout/CouponWalletItemListFragment$b.getSimpleName()).toString());
        } else
        {
            super.onAttach(activity);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mPresenter = new com.target.ui.fragment.checkout.b.b(a());
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030055, viewgroup, false);
        mViews = new a(layoutinflater);
        mPresenter.a(this);
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
        mPresenter.z_();
        mViews = null;
    }
}
