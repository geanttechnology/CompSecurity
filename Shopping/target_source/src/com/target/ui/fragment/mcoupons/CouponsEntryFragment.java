// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.mcoupons;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.target.mothership.model.coupons.interfaces.RegisteredPhone;
import com.target.mothership.model.coupons.interfaces.a.d;
import com.target.mothership.model.coupons.params.CouponsSignUpParams;
import com.target.ui.analytics.a.ba;
import com.target.ui.f.c;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.util.e.a;
import com.target.ui.util.q;
import com.target.ui.view.account.b;
import com.target.ui.view.mcoupons.CouponsSignUpView;

// Referenced classes of package com.target.ui.fragment.mcoupons:
//            a, CouponsVerificationFragment, CouponsErrorDialogFragment, CouponAcceptTermsFragment

public class CouponsEntryFragment extends BaseNavigationFragment
    implements CouponAcceptTermsFragment.c, com.target.ui.fragment.mcoupons.a, com.target.ui.helper.f.a.b, b
{
    private class a
    {

        Button continueButton;
        CouponsSignUpView signUpView;
        final CouponsEntryFragment this$0;

        a(View view)
        {
            this$0 = CouponsEntryFragment.this;
            super();
            signUpView = (CouponsSignUpView)view.findViewById(0x7f100193);
            continueButton = (Button)view.findViewById(0x7f100194);
        }
    }


    private static final String COUPON_CODE_KEY = "COUPON_CODE_KEY";
    private static final String LOG_TAG = com/target/ui/fragment/mcoupons/CouponsEntryFragment.getSimpleName();
    private static final int PHONE_NUMBER_LENGTH_WITHOUT_PREFIX_ONE = 10;
    private static final String PHONE_NUMBER_PREFIX_STRING = "1";
    private com.target.ui.helper.f.a mCouponDataHelper;
    private boolean mIsValidForm;
    private String mPhoneNumber;
    private a mViews;

    public CouponsEntryFragment()
    {
        mIsValidForm = false;
    }

    public static CouponsEntryFragment a(String s)
    {
        CouponsEntryFragment couponsentryfragment = new CouponsEntryFragment();
        Bundle bundle = new Bundle();
        bundle.putString("COUPON_CODE_KEY", s);
        couponsentryfragment.setArguments(bundle);
        return couponsentryfragment;
    }

    private void a(boolean flag)
    {
        if (flag)
        {
            mPhoneNumber = mViews.signUpView.getPhoneNumberEntered();
            com.target.ui.util.e.a.a(this);
        }
        mViews.continueButton.setEnabled(flag);
    }

    private void b(RegisteredPhone registeredphone)
    {
        Object obj = null;
        Bundle bundle = getArguments();
        String s = obj;
        if (bundle != null)
        {
            s = obj;
            if (bundle.containsKey("COUPON_CODE_KEY"))
            {
                s = bundle.getString("COUPON_CODE_KEY", null);
            }
        }
        registeredphone = com.target.ui.fragment.mcoupons.CouponsVerificationFragment.a(registeredphone, e(), s);
        m().d(registeredphone);
    }

    private void b(String s)
    {
        mCouponDataHelper.a(c(s));
    }

    public static CouponsEntryFragment c()
    {
        return new CouponsEntryFragment();
    }

    private String c(String s)
    {
        String s1 = com.target.ui.util.d.b.g(s);
        s = null;
        if (s1.length() == 10)
        {
            s = new StringBuilder("1");
            s.append(s1);
        }
        if (s == null)
        {
            return s1;
        } else
        {
            return s.toString();
        }
    }

    private void d()
    {
        mViews.continueButton.setOnClickListener(new android.view.View.OnClickListener() {

            final CouponsEntryFragment this$0;

            public void onClick(View view)
            {
                m().d(com.target.ui.fragment.mcoupons.CouponAcceptTermsFragment.b(CouponsEntryFragment.this));
            }

            
            {
                this$0 = CouponsEntryFragment.this;
                super();
            }
        });
    }

    private CouponsSignUpParams e()
    {
        com.target.ui.view.mcoupons.CouponsSignUpView.b b1 = mViews.signUpView.getName();
        return new CouponsSignUpParams(b1.b(), b1.c(), mViews.signUpView.getZipCode());
    }

    private void f()
    {
        mIsValidForm = mViews.signUpView.a();
    }

    public void a()
    {
        o(true);
        b(mPhoneNumber);
    }

    public void a(View view, boolean flag)
    {
        if (view.getId() == mViews.signUpView.getId())
        {
            mIsValidForm = flag;
        }
        a(mIsValidForm);
    }

    public void a(RegisteredPhone registeredphone)
    {
        if (mViews == null)
        {
            q.a(LOG_TAG, "Null context for views");
        } else
        {
            o(false);
            if (!Z())
            {
                b(registeredphone);
                return;
            }
        }
    }

    public void a(d d1)
    {
        if (mViews == null)
        {
            q.a(LOG_TAG, "Null context for views");
        } else
        {
            o(false);
            if (!Z())
            {
                com.target.ui.fragment.mcoupons.CouponsErrorDialogFragment.a(getActivity(), d1).show(getFragmentManager(), CouponsErrorDialogFragment.TAG);
                return;
            }
        }
    }

    public void b()
    {
        if (mViews == null)
        {
            q.a(LOG_TAG, "Null context for views");
        } else
        {
            o(false);
            if (!Z())
            {
                com.target.ui.fragment.mcoupons.CouponsErrorDialogFragment.a(getString(0x7f0902b7), getString(0x7f0902b6)).show(getFragmentManager(), CouponsErrorDialogFragment.TAG);
                return;
            }
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030064, viewgroup, false);
        mViews = new a(layoutinflater);
        mCouponDataHelper = new com.target.ui.helper.f.a(this);
        mViews.signUpView.setInputValidationListener(this);
        d();
        f();
        com.target.ui.service.c.a().a(this);
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        com.target.ui.service.c.a().b(this);
        mViews = null;
    }

    public void onResume()
    {
        super.onResume();
        ba.a(this).e();
    }

    public void onStart()
    {
        super.onStart();
        j(getString(0x7f0902b3));
    }

}
