// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.mcoupons;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import com.target.mothership.model.coupons.c;
import com.target.mothership.model.coupons.interfaces.AvailableCouponOffer;
import com.target.ui.analytics.a.ba;
import com.target.ui.fragment.mcoupons.a.a;
import com.target.ui.fragment.mcoupons.presenter.CouponDetailPresenter;
import com.target.ui.fragment.webview.TargetBaseWebViewFragment;
import com.target.ui.service.provider.d;
import com.target.ui.view.common.h;

public class CouponDetailFragment extends TargetBaseWebViewFragment
    implements a
{

    private static final String AVAILABLE_COUPON_OFFER_KEY = "AVAILABLE_COUPON_OFFER_KEY";
    private static final String COUPON_OFFER_URI_KEY = "COUPON_OFFER_URI_KEY";
    private CouponDetailPresenter mPresenter;
    private h mSnackBar;

    public CouponDetailFragment()
    {
    }

    public static CouponDetailFragment a(AvailableCouponOffer availablecouponoffer)
    {
        CouponDetailFragment coupondetailfragment = new CouponDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("AVAILABLE_COUPON_OFFER_KEY", availablecouponoffer);
        coupondetailfragment.setArguments(bundle);
        return coupondetailfragment;
    }

    public static CouponDetailFragment a(String s)
    {
        CouponDetailFragment coupondetailfragment = new CouponDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("COUPON_OFFER_URI_KEY", s);
        coupondetailfragment.setArguments(bundle);
        return coupondetailfragment;
    }

    public int a()
    {
        return 0x7f030056;
    }

    public void a(int j)
    {
        c(j);
    }

    public int b()
    {
        return 0x7f100233;
    }

    public void b(int j)
    {
        mSnackBar.c(getString(j));
    }

    public void b(String s)
    {
        j(s);
    }

    public int c()
    {
        return 0x7f100230;
    }

    public void c(String s)
    {
        e(s);
    }

    public int d()
    {
        return 0x7f100165;
    }

    public int e()
    {
        return 0x7f100428;
    }

    public int f()
    {
        return 0x7f100231;
    }

    protected boolean i()
    {
        return true;
    }

    protected boolean k()
    {
        mPresenter.d();
        return true;
    }

    public void l()
    {
        super.l();
        ba.a(a(V()), this).e();
    }

    public void n()
    {
        a(com.target.ui.view.common.b.a.ERROR_NO_NETWORK, true);
    }

    public void o()
    {
        t();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Object obj = getArguments();
        bundle = (AvailableCouponOffer)((Bundle) (obj)).getParcelable("AVAILABLE_COUPON_OFFER_KEY");
        obj = ((Bundle) (obj)).getString("COUPON_OFFER_URI_KEY");
        mPresenter = new CouponDetailPresenter(new c(), new d(), ((String) (obj)), bundle, null);
        mSnackBar = new h(getActivity());
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        super.onCreateOptionsMenu(menu, menuinflater);
        mPresenter.a(menu, menuinflater);
    }

    public void onDestroy()
    {
        super.onDestroy();
        mPresenter.v_();
        mPresenter = null;
        mSnackBar = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mPresenter.z_();
    }

    public void onPause()
    {
        super.onPause();
        if (mSnackBar == null)
        {
            return;
        } else
        {
            mSnackBar.a();
            return;
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        mPresenter.a(this, q());
    }
}
