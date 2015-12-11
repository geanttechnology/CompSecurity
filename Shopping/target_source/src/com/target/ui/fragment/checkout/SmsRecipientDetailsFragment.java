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
import com.target.ui.f.c;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.model.checkout.SmsRecipientDetailsModel;
import com.target.ui.model.checkout.TGTSmsRecipientDetailsModel;
import com.target.ui.util.al;
import com.target.ui.view.account.b;
import com.target.ui.view.checkout.AltSmsRecipientView;

public class SmsRecipientDetailsFragment extends BaseNavigationFragment
    implements android.view.View.OnClickListener, b
{
    static class Views extends com.target.ui.view.a
    {

        Button actionDoneButton;
        RadioButton altRecipientButton;
        AltSmsRecipientView altSmsRecipientDetails;
        RadioButton selfRecipientButton;

        Views(View view)
        {
            super(view);
        }
    }

    public final class a
        implements com.target.ui.view.checkout.AltSmsRecipientView.a
    {

        public String fromName;
        boolean isValid;
        public String phoneNumber;
        final SmsRecipientDetailsFragment this$0;
        public String toName;

        public void a()
        {
            isValid = false;
        }

        public void a(String s, String s1, String s2)
        {
            toName = s;
            phoneNumber = s1;
            fromName = s2;
            isValid = true;
        }

        public a()
        {
            this$0 = SmsRecipientDetailsFragment.this;
            super();
        }
    }


    private static final String KEY_RECIPIENT_DETAILS = "recipient_details";
    public static final String TAG = com/target/ui/fragment/checkout/SmsRecipientDetailsFragment.getSimpleName();
    private com.target.ui.view.checkout.DeliveryView.a mListener;
    private SmsRecipientDetailsModel mSmsRecipientDetails;
    private Views mViews;

    public SmsRecipientDetailsFragment()
    {
    }

    public static SmsRecipientDetailsFragment a(SmsRecipientDetailsModel smsrecipientdetailsmodel, com.target.ui.view.checkout.DeliveryView.a a1)
        throws IllegalArgumentException
    {
        SmsRecipientDetailsFragment smsrecipientdetailsfragment = new SmsRecipientDetailsFragment();
        if (a1 == null || !(a1 instanceof Fragment))
        {
            throw new IllegalArgumentException("DeliveryActionListener must be an instance of Fragment");
        } else
        {
            smsrecipientdetailsfragment.setTargetFragment((Fragment)a1, 0);
            a1 = new Bundle();
            a1.putParcelable("recipient_details", smsrecipientdetailsmodel);
            smsrecipientdetailsfragment.setArguments(a1);
            return smsrecipientdetailsfragment;
        }
    }

    private void a()
    {
        mViews.selfRecipientButton.setOnClickListener(this);
        mViews.altRecipientButton.setOnClickListener(this);
        mViews.actionDoneButton.setOnClickListener(this);
    }

    private void a(SmsRecipientDetailsModel smsrecipientdetailsmodel)
    {
        if (smsrecipientdetailsmodel == null)
        {
            c();
            return;
        }
        if (smsrecipientdetailsmodel.a())
        {
            c();
            return;
        } else
        {
            d();
            return;
        }
    }

    private void b()
    {
        if (!mViews.selfRecipientButton.isChecked()) goto _L2; else goto _L1
_L1:
        TGTSmsRecipientDetailsModel tgtsmsrecipientdetailsmodel = new TGTSmsRecipientDetailsModel();
        tgtsmsrecipientdetailsmodel.a(true);
        mListener.a(tgtsmsrecipientdetailsmodel);
_L6:
        e();
_L4:
        return;
_L2:
        a a1;
        a1 = new a();
        mViews.altSmsRecipientDetails.a(a1);
        if (!a1.isValid) goto _L4; else goto _L3
_L3:
        TGTSmsRecipientDetailsModel tgtsmsrecipientdetailsmodel1 = new TGTSmsRecipientDetailsModel();
        tgtsmsrecipientdetailsmodel1.a(false);
        tgtsmsrecipientdetailsmodel1.a(a1.toName);
        tgtsmsrecipientdetailsmodel1.b(a1.phoneNumber);
        tgtsmsrecipientdetailsmodel1.c(a1.fromName);
        mListener.a(tgtsmsrecipientdetailsmodel1);
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void c()
    {
        mViews.selfRecipientButton.setChecked(true);
        mViews.altRecipientButton.setChecked(false);
        al.c(mViews.altSmsRecipientDetails);
        mViews.actionDoneButton.setEnabled(true);
    }

    private void d()
    {
        mViews.altRecipientButton.setChecked(true);
        mViews.selfRecipientButton.setChecked(false);
        al.b(mViews.altSmsRecipientDetails);
        mViews.actionDoneButton.setEnabled(false);
        mViews.altSmsRecipientDetails.setInputValidationListener(this);
        mViews.altSmsRecipientDetails.a(mSmsRecipientDetails);
    }

    private void e()
    {
        m().b();
    }

    public void a(View view, boolean flag)
    {
        if (view.getId() == mViews.altSmsRecipientDetails.getId())
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
            b();
            return;

        case 2131755320: 
            c();
            return;

        case 2131755322: 
            d();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (getArguments() != null)
        {
            mSmsRecipientDetails = (SmsRecipientDetailsModel)getArguments().getParcelable("recipient_details");
        }
        j(getResources().getString(0x7f09025b));
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030050, null);
        mViews = new Views(layoutinflater);
        a();
        a(mSmsRecipientDetails);
        return layoutinflater;
    }

    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

}
