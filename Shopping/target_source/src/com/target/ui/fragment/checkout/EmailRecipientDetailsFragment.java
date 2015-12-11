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
import android.widget.Button;
import android.widget.RadioButton;
import com.google.a.a.e;
import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.util.o;
import com.target.ui.f.c;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.model.checkout.EmailRecipientDetailsModel;
import com.target.ui.model.checkout.TGTEmailRecipientDetailsModel;
import com.target.ui.service.a;
import com.target.ui.util.al;
import com.target.ui.view.account.b;
import com.target.ui.view.checkout.AltEmailRecipientView;

public class EmailRecipientDetailsFragment extends BaseNavigationFragment
    implements android.view.View.OnClickListener, b
{
    static class Views extends com.target.ui.view.a
    {

        Button actionDoneButton;
        AltEmailRecipientView altEmailRecipientDetails;
        RadioButton altRecipientButton;
        RadioButton selfRecipientButton;

        Views(View view)
        {
            super(view);
        }
    }

    public final class a
        implements com.target.ui.view.checkout.AltEmailRecipientView.a
    {

        public String email;
        public String fromName;
        boolean isValid;
        final EmailRecipientDetailsFragment this$0;
        public String toName;

        public void a()
        {
            isValid = false;
        }

        public void a(String s, String s1, String s2)
        {
            toName = s;
            email = s1;
            fromName = s2;
            isValid = true;
        }

        public a()
        {
            this$0 = EmailRecipientDetailsFragment.this;
            super();
        }
    }


    private static final String KEY_INITIATED_CHECKOUT = "initiated_checkout";
    private static final String KEY_RECIPIENT_DETAILS = "recipient_details";
    public static final String TAG = com/target/ui/fragment/checkout/EmailRecipientDetailsFragment.getSimpleName();
    private EmailRecipientDetailsModel mEmailRecipientDetails;
    private com.target.ui.view.checkout.DeliveryView.a mListener;
    private OrderReview mOrderReview;
    private Views mViews;

    public EmailRecipientDetailsFragment()
    {
    }

    public static EmailRecipientDetailsFragment a(OrderReview orderreview, EmailRecipientDetailsModel emailrecipientdetailsmodel, com.target.ui.view.checkout.DeliveryView.a a1)
        throws IllegalArgumentException
    {
        EmailRecipientDetailsFragment emailrecipientdetailsfragment = new EmailRecipientDetailsFragment();
        if (a1 == null || !(a1 instanceof Fragment))
        {
            throw new IllegalArgumentException("DeliveryActionListener must be an instance of Fragment");
        } else
        {
            emailrecipientdetailsfragment.setTargetFragment((Fragment)a1, 0);
            a1 = new Bundle();
            a1.putParcelable("initiated_checkout", orderreview);
            a1.putParcelable("recipient_details", emailrecipientdetailsmodel);
            emailrecipientdetailsfragment.setArguments(a1);
            return emailrecipientdetailsfragment;
        }
    }

    private void a()
    {
        mViews.selfRecipientButton.setOnClickListener(this);
        mViews.altRecipientButton.setOnClickListener(this);
        mViews.actionDoneButton.setOnClickListener(this);
    }

    private void a(EmailRecipientDetailsModel emailrecipientdetailsmodel)
    {
        if (emailrecipientdetailsmodel == null)
        {
            d();
            return;
        }
        if (emailrecipientdetailsmodel.a())
        {
            d();
            return;
        } else
        {
            e();
            return;
        }
    }

    private Guest b()
    {
        com.target.ui.service.a a1 = com.target.ui.service.a.a();
        if (a1.c().b())
        {
            return (Guest)a1.c().c();
        } else
        {
            return null;
        }
    }

    private void c()
    {
        if (!mViews.selfRecipientButton.isChecked()) goto _L2; else goto _L1
_L1:
        TGTEmailRecipientDetailsModel tgtemailrecipientdetailsmodel = new TGTEmailRecipientDetailsModel();
        tgtemailrecipientdetailsmodel.a(true);
        String s = com.target.ui.util.e.a(b(), mOrderReview);
        if (o.g(s))
        {
            tgtemailrecipientdetailsmodel.b(s);
        }
        mListener.a(tgtemailrecipientdetailsmodel);
_L6:
        f();
_L4:
        return;
_L2:
        a a1;
        a1 = new a();
        mViews.altEmailRecipientDetails.a(a1);
        if (!a1.isValid) goto _L4; else goto _L3
_L3:
        TGTEmailRecipientDetailsModel tgtemailrecipientdetailsmodel1 = new TGTEmailRecipientDetailsModel();
        tgtemailrecipientdetailsmodel1.a(false);
        tgtemailrecipientdetailsmodel1.a(a1.toName);
        tgtemailrecipientdetailsmodel1.b(a1.email);
        tgtemailrecipientdetailsmodel1.c(a1.fromName);
        mListener.a(tgtemailrecipientdetailsmodel1);
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void d()
    {
        mViews.selfRecipientButton.setChecked(true);
        mViews.altRecipientButton.setChecked(false);
        al.c(mViews.altEmailRecipientDetails);
        mViews.actionDoneButton.setEnabled(true);
    }

    private void e()
    {
        mViews.altRecipientButton.setChecked(true);
        mViews.selfRecipientButton.setChecked(false);
        al.b(mViews.altEmailRecipientDetails);
        mViews.actionDoneButton.setEnabled(false);
        mViews.altEmailRecipientDetails.setInputValidationListener(this);
        mViews.altEmailRecipientDetails.a();
        mViews.altEmailRecipientDetails.a(mEmailRecipientDetails);
    }

    private void f()
    {
        m().b();
    }

    public void a(View view, boolean flag)
    {
        if (view.getId() == mViews.altEmailRecipientDetails.getId())
        {
            mViews.actionDoneButton.setEnabled(flag);
        }
    }

    public void onAttach(Activity activity)
    {
        Fragment fragment = getTargetFragment();
        if (fragment != null && (fragment instanceof com.target.ui.view.checkout.DeliveryView.a))
        {
            mListener = (com.target.ui.view.checkout.DeliveryView.a)fragment;
            super.onAttach(activity);
            return;
        } else
        {
            throw new IllegalStateException("Make sure to implement DeliveryActionListener");
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        case 2131755321: 
        case 2131755323: 
        case 2131755324: 
        default:
            return;

        case 2131755325: 
            c();
            return;

        case 2131755320: 
            d();
            return;

        case 2131755322: 
            e();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (getArguments() != null)
        {
            mOrderReview = (OrderReview)getArguments().getParcelable("initiated_checkout");
            mEmailRecipientDetails = (EmailRecipientDetailsModel)getArguments().getParcelable("recipient_details");
        }
        j(getResources().getString(0x7f0901dd));
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03004b, null);
        mViews = new Views(layoutinflater);
        a();
        a(mEmailRecipientDetails);
        return layoutinflater;
    }

    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

}
