// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.mcoupons;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.google.a.a.e;
import com.target.mothership.model.coupons.c;
import com.target.mothership.model.coupons.interfaces.CompletedSignUp;
import com.target.mothership.model.coupons.interfaces.RegisteredPhone;
import com.target.mothership.model.coupons.params.CouponsSignUpParams;
import com.target.ui.analytics.a.ba;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.util.SpannableStringUtils;
import com.target.ui.util.e.a;
import com.target.ui.util.q;
import com.target.ui.view.account.b;
import com.target.ui.view.mcoupons.CouponsPinView;

// Referenced classes of package com.target.ui.fragment.mcoupons:
//            a, CouponsErrorDialogFragment, CouponListFragment

public class CouponsVerificationFragment extends BaseNavigationFragment
    implements com.target.ui.fragment.mcoupons.a, com.target.ui.helper.f.a.c, com.target.ui.view.account.b
{
    private class a
    {

        boolean isValidForm;
        final CouponsVerificationFragment this$0;

        private a()
        {
            this$0 = CouponsVerificationFragment.this;
            super();
            isValidForm = false;
        }

    }

    private class b
    {

        TextView agreementTextView;
        CouponsPinView couponsPinView;
        TextView enterPinText;
        TextView phoneNumberTextView;
        Button pinSubmitButton;
        final CouponsVerificationFragment this$0;

        b(View view)
        {
            this$0 = CouponsVerificationFragment.this;
            super();
            agreementTextView = (TextView)view.findViewById(0x7f10019a);
            phoneNumberTextView = (TextView)view.findViewById(0x7f100196);
            enterPinText = (TextView)view.findViewById(0x7f100197);
            pinSubmitButton = (Button)view.findViewById(0x7f100199);
            couponsPinView = (CouponsPinView)view.findViewById(0x7f100198);
        }
    }


    private static final String COUPONS_SIGNUP_PARAMS_PARCELABLE_KEY = "COUPONS_SIGNUP_PARAMS_PARCELABLE_KEY";
    private static final String COUPON_CODE_KEY = "COUPON_CODE_KEY";
    private static final String LOG_TAG = com/target/ui/fragment/mcoupons/CouponsVerificationFragment.getSimpleName();
    private static final String REGISTERED_PHONE_NUMBER_PARCELABLE_KEY = "REGISTERED_PHONE_NUMBER_PARCELABLE_KEY";
    private ClickableSpan clickableSpan;
    private com.target.ui.helper.f.a mCouponDataHelper;
    private a mFormState;
    private b mViews;

    public CouponsVerificationFragment()
    {
        clickableSpan = new ClickableSpan() {

            final CouponsVerificationFragment this$0;

            public void onClick(View view)
            {
                com.target.ui.util.h.c.a(getActivity(), getString(0x7f0902cd));
            }

            public void updateDrawState(TextPaint textpaint)
            {
                textpaint.setUnderlineText(false);
            }

            
            {
                this$0 = CouponsVerificationFragment.this;
                super();
            }
        };
    }

    public static CouponsVerificationFragment a(RegisteredPhone registeredphone, CouponsSignUpParams couponssignupparams, String s)
    {
        CouponsVerificationFragment couponsverificationfragment = new CouponsVerificationFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("REGISTERED_PHONE_NUMBER_PARCELABLE_KEY", registeredphone);
        bundle.putParcelable("COUPONS_SIGNUP_PARAMS_PARCELABLE_KEY", couponssignupparams);
        if (s != null)
        {
            bundle.putString("COUPON_CODE_KEY", s);
        }
        couponsverificationfragment.setArguments(bundle);
        return couponsverificationfragment;
    }

    private void a()
    {
        RegisteredPhone registeredphone = (RegisteredPhone)getArguments().getParcelable("REGISTERED_PHONE_NUMBER_PARCELABLE_KEY");
        mViews.phoneNumberTextView.setText(com.target.ui.util.d.b.h(registeredphone.a()));
    }

    private void a(a a1)
    {
        a1.isValidForm = mViews.couponsPinView.a();
    }

    static void a(CouponsVerificationFragment couponsverificationfragment)
    {
        couponsverificationfragment.f();
    }

    static void a(CouponsVerificationFragment couponsverificationfragment, boolean flag)
    {
        couponsverificationfragment.o(flag);
    }

    private void a(boolean flag)
    {
        if (flag)
        {
            com.target.ui.util.e.a.a(this);
        }
        mViews.pinSubmitButton.setEnabled(flag);
        mViews.pinSubmitButton.requestFocus();
    }

    private void b(com.target.mothership.model.coupons.interfaces.a.b b1)
    {
        com.target.ui.fragment.mcoupons.CouponsErrorDialogFragment.a(getActivity(), b1).show(getFragmentManager(), CouponsErrorDialogFragment.TAG);
    }

    private boolean b(a a1)
    {
        return a1.isValidForm;
    }

    private void c()
    {
        Object obj = new c();
        if (!((c) (obj)).a().b())
        {
            q.a(TAG, "Coupon sign up failed !");
            return;
        }
        obj = (CompletedSignUp)((c) (obj)).a().c();
        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey("COUPON_CODE_KEY"))
        {
            obj = com.target.ui.fragment.mcoupons.CouponListFragment.a(((CompletedSignUp) (obj)), bundle.getString("COUPON_CODE_KEY", null));
        } else
        {
            obj = com.target.ui.fragment.mcoupons.CouponListFragment.a(((CompletedSignUp) (obj)));
        }
        m().e(((android.support.v4.app.Fragment) (obj)));
    }

    private void d()
    {
        if (Z())
        {
            return;
        } else
        {
            com.target.ui.fragment.mcoupons.CouponsErrorDialogFragment.a(getString(0x7f0902b7), getString(0x7f0902b6)).show(getFragmentManager(), CouponsErrorDialogFragment.TAG);
            return;
        }
    }

    private void e()
    {
        android.view.View.OnClickListener onclicklistener = new android.view.View.OnClickListener() {

            final CouponsVerificationFragment this$0;

            public void onClick(View view)
            {
                com.target.ui.fragment.mcoupons.CouponsVerificationFragment.a(CouponsVerificationFragment.this, true);
                com.target.ui.fragment.mcoupons.CouponsVerificationFragment.a(CouponsVerificationFragment.this);
            }

            
            {
                this$0 = CouponsVerificationFragment.this;
                super();
            }
        };
        mViews.pinSubmitButton.setOnClickListener(onclicklistener);
    }

    private void f()
    {
        String s = mViews.couponsPinView.getCompletePinNumber();
        Object obj = getArguments();
        CouponsSignUpParams couponssignupparams = (CouponsSignUpParams)((Bundle) (obj)).getParcelable("COUPONS_SIGNUP_PARAMS_PARCELABLE_KEY");
        obj = (RegisteredPhone)((Bundle) (obj)).getParcelable("REGISTERED_PHONE_NUMBER_PARCELABLE_KEY");
        mCouponDataHelper.a(((RegisteredPhone) (obj)), s, couponssignupparams);
    }

    private void g()
    {
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(getString(0x7f0902cb));
        SpannableStringUtils.a(getActivity(), spannablestringbuilder, getString(0x7f0902cb), getString(0x7f0902cc));
        SpannableStringUtils.a(spannablestringbuilder, getString(0x7f0902cb), getString(0x7f0902cd), clickableSpan);
        SpannableStringUtils.a(spannablestringbuilder, getString(0x7f0902cb), getString(0x7f0902cd), new ForegroundColorSpan(getResources().getColor(0x7f0f00e2)));
        mViews.agreementTextView.setText(spannablestringbuilder);
        mViews.agreementTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void a(View view, boolean flag)
    {
        if (view.getId() == mViews.couponsPinView.getId())
        {
            mFormState.isValidForm = flag;
        }
        a(b(mFormState));
    }

    public void a(CompletedSignUp completedsignup)
    {
        if (mViews == null)
        {
            q.a(LOG_TAG, "Null context for views");
        } else
        {
            o(false);
            if (!Z())
            {
                c();
                return;
            }
        }
    }

    public void a(com.target.mothership.model.coupons.interfaces.a.b b1)
    {
        if (mViews == null)
        {
            q.a(LOG_TAG, "Null context for views");
        } else
        {
            o(false);
            if (!Z())
            {
                b(b1);
                return;
            }
        }
    }

    public void b()
    {
        if (mViews == null)
        {
            q.a(LOG_TAG, "Null context for views");
            return;
        } else
        {
            o(false);
            d();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        j(getString(0x7f0902ce));
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030065, viewgroup, false);
        mViews = new b(layoutinflater);
        mCouponDataHelper = new com.target.ui.helper.f.a(this);
        mViews.couponsPinView.setInputValidationListener(this);
        a();
        e();
        g();
        mFormState = new a();
        a(mFormState);
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

}
