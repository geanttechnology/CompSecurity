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
import android.widget.ImageView;
import android.widget.TextView;
import com.target.mothership.common.tender.a;
import com.target.ui.fragment.common.BaseDialogFragment;
import com.target.ui.util.al;
import com.target.ui.util.e;

public class SelectPaymentDialogFragment extends BaseDialogFragment
{
    static class Views extends com.target.ui.view.a
    {

        TextView address;
        TextView cardNumber;
        View editButton;
        View paymentCardContainer;
        View paymentCardDetails;
        ImageView paymentCardImage;
        View paypal;
        TextView selectCardText;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void P();

        public abstract void Q();
    }


    private static final String ARG_ADDRESS_LINE = "address line";
    private static final String ARG_CARD_DETAILS_PRESENT = "this fragment was instantiated with some displayable card details";
    private static final String ARG_CARD_TYPE_ORDINAL = "card type ordinal";
    private static final String ARG_LAST_4_DIGITS = "last 4 digits of the card number";
    public static final String TAG = com/target/ui/fragment/checkout/SelectPaymentDialogFragment.getSimpleName();
    private final android.view.View.OnClickListener mInternalClickListener = new android.view.View.OnClickListener() {

        final SelectPaymentDialogFragment this$0;

        public void onClick(View view)
        {
            dismiss();
            switch (view.getId())
            {
            default:
                return;

            case 2131755967: 
            case 2131755969: 
                com.target.ui.fragment.checkout.SelectPaymentDialogFragment.a(SelectPaymentDialogFragment.this).P();
                return;

            case 2131755686: 
                com.target.ui.fragment.checkout.SelectPaymentDialogFragment.a(SelectPaymentDialogFragment.this).Q();
                return;
            }
        }

            
            {
                this$0 = SelectPaymentDialogFragment.this;
                super();
            }
    };
    private a mListener;
    private Views mViews;

    public SelectPaymentDialogFragment()
    {
    }

    static a a(SelectPaymentDialogFragment selectpaymentdialogfragment)
    {
        return selectpaymentdialogfragment.mListener;
    }

    public static SelectPaymentDialogFragment a(Fragment fragment)
    {
        SelectPaymentDialogFragment selectpaymentdialogfragment = new SelectPaymentDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("this fragment was instantiated with some displayable card details", false);
        selectpaymentdialogfragment.setArguments(bundle);
        selectpaymentdialogfragment.setTargetFragment(fragment, 0);
        return selectpaymentdialogfragment;
    }

    public static SelectPaymentDialogFragment a(String s, String s1, com.target.mothership.common.tender.a a1, Fragment fragment)
    {
        SelectPaymentDialogFragment selectpaymentdialogfragment = new SelectPaymentDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("last 4 digits of the card number", s);
        bundle.putString("address line", s1);
        bundle.putInt("card type ordinal", a1.ordinal());
        bundle.putBoolean("this fragment was instantiated with some displayable card details", true);
        selectpaymentdialogfragment.setArguments(bundle);
        selectpaymentdialogfragment.setTargetFragment(fragment, 0);
        return selectpaymentdialogfragment;
    }

    private void a()
    {
        mViews.cardNumber.setText(c());
        mViews.address.setText(d());
        com.target.ui.util.e.a(e(), mViews.paymentCardImage);
    }

    private void b()
    {
        al.a(mViews.selectCardText, new View[] {
            mViews.paymentCardDetails, mViews.editButton
        });
        mViews.selectCardText.setText(0x7f090241);
    }

    private String c()
    {
        return getArguments().getString("last 4 digits of the card number");
    }

    private String d()
    {
        return getArguments().getString("address line");
    }

    private com.target.mothership.common.tender.a e()
    {
        int i = getArguments().getInt("card type ordinal");
        return com.target.mothership.common.tender.a.values()[i];
    }

    private boolean f()
    {
        return getArguments().getBoolean("this fragment was instantiated with some displayable card details");
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        mListener = (a)getTargetFragment();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03004f, viewgroup, false);
        mViews = new Views(layoutinflater);
        mViews.paymentCardContainer.setBackgroundResource(0x7f02023f);
        mViews.paymentCardImage.setPadding((int)getResources().getDimension(0x7f0a022e), 0, 0, 0);
        mViews.paymentCardContainer.setOnClickListener(mInternalClickListener);
        mViews.editButton.setOnClickListener(mInternalClickListener);
        mViews.paypal.setOnClickListener(mInternalClickListener);
        if (f())
        {
            a();
            return layoutinflater;
        } else
        {
            b();
            return layoutinflater;
        }
    }

    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

}
