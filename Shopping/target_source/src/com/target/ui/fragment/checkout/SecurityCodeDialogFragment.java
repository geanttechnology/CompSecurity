// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.checkout;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.target.mothership.common.tender.a;
import com.target.mothership.model.common.AppliedPaymentCardTender;
import com.target.ui.fragment.common.BaseDialogFragment;
import com.target.ui.model.checkout.CardDataModel;
import com.target.ui.util.al;
import com.target.ui.util.d.b;
import com.target.ui.util.e;
import com.target.ui.util.q;
import com.target.ui.util.validation.d;

public class SecurityCodeDialogFragment extends BaseDialogFragment
{
    static class Views extends com.target.ui.view.a
    {

        ImageView cardImage;
        TextView expiry;
        EditText inputField;
        TextView lastFourDigits;
        Button submitButton;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a(com.target.mothership.common.tender.a a1, String s);
    }

    private static final class b extends Enum
    {

        private static final b $VALUES[];
        public static final b Cvv;
        public static final b TargetDebitCardPin;

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(com/target/ui/fragment/checkout/SecurityCodeDialogFragment$b, s);
        }

        public static b[] values()
        {
            return (b[])$VALUES.clone();
        }

        static 
        {
            TargetDebitCardPin = new b("TargetDebitCardPin", 0);
            Cvv = new b("Cvv", 1);
            $VALUES = (new b[] {
                TargetDebitCardPin, Cvv
            });
        }

        private b(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String ARG_APPLIED_PAYMENT_CARD = "AppliedPaymentCardTender";
    private static final String ARG_PAYMENT_CARD_DATA = "PaymentCardData";
    public static final String TAG = com/target/ui/fragment/checkout/SecurityCodeDialogFragment.getSimpleName();
    private com.target.mothership.common.tender.a mCardType;
    private final TextWatcher mInputTextWatcher = new TextWatcher() {

        final SecurityCodeDialogFragment this$0;

        public void afterTextChanged(Editable editable)
        {
            if (com.target.ui.fragment.checkout.SecurityCodeDialogFragment.a(SecurityCodeDialogFragment.this).inputField.getText().toString().length() != com.target.ui.fragment.checkout.SecurityCodeDialogFragment.b(SecurityCodeDialogFragment.this))
            {
                com.target.ui.fragment.checkout.SecurityCodeDialogFragment.a(SecurityCodeDialogFragment.this).submitButton.setEnabled(false);
                return;
            } else
            {
                com.target.ui.fragment.checkout.SecurityCodeDialogFragment.a(SecurityCodeDialogFragment.this).submitButton.setEnabled(true);
                return;
            }
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

            
            {
                this$0 = SecurityCodeDialogFragment.this;
                super();
            }
    };
    private a mListener;
    private int mSecurityCodeMaxLength;
    private final android.view.View.OnClickListener mSubmitButtonListener = new android.view.View.OnClickListener() {

        final SecurityCodeDialogFragment this$0;

        public void onClick(View view)
        {
            view = com.target.ui.fragment.checkout.SecurityCodeDialogFragment.a(SecurityCodeDialogFragment.this).inputField.getText().toString();
            com.target.ui.fragment.checkout.SecurityCodeDialogFragment.a(SecurityCodeDialogFragment.this, view);
        }

            
            {
                this$0 = SecurityCodeDialogFragment.this;
                super();
            }
    };
    private Views mViews;

    public SecurityCodeDialogFragment()
    {
    }

    static Views a(SecurityCodeDialogFragment securitycodedialogfragment)
    {
        return securitycodedialogfragment.mViews;
    }

    private static b a(com.target.mothership.common.tender.a a1)
    {
        static class _cls3
        {

            static final int $SwitchMap$com$target$mothership$common$tender$CardType[];
            static final int $SwitchMap$com$target$ui$fragment$checkout$SecurityCodeDialogFragment$SecurityCodeType[];

            static 
            {
                $SwitchMap$com$target$ui$fragment$checkout$SecurityCodeDialogFragment$SecurityCodeType = new int[b.values().length];
                try
                {
                    $SwitchMap$com$target$ui$fragment$checkout$SecurityCodeDialogFragment$SecurityCodeType[b.TargetDebitCardPin.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$fragment$checkout$SecurityCodeDialogFragment$SecurityCodeType[b.Cvv.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                $SwitchMap$com$target$mothership$common$tender$CardType = new int[com.target.mothership.common.tender.a.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$tender$CardType[com.target.mothership.common.tender.a.TARGET_DEBIT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls3..SwitchMap.com.target.mothership.common.tender.CardType[a1.ordinal()])
        {
        default:
            return b.Cvv;

        case 1: // '\001'
            return b.TargetDebitCardPin;
        }
    }

    public static SecurityCodeDialogFragment a(AppliedPaymentCardTender appliedpaymentcardtender, a a1)
    {
        SecurityCodeDialogFragment securitycodedialogfragment = new SecurityCodeDialogFragment();
        if (a1 == null || !(a1 instanceof Fragment))
        {
            throw new IllegalArgumentException("SecurityCodeListener must be an instance of Fragment");
        } else
        {
            securitycodedialogfragment.setTargetFragment((Fragment)a1, 0);
            a1 = new Bundle();
            a1.putParcelable("AppliedPaymentCardTender", appliedpaymentcardtender);
            securitycodedialogfragment.setArguments(a1);
            return securitycodedialogfragment;
        }
    }

    public static SecurityCodeDialogFragment a(CardDataModel carddatamodel, a a1)
    {
        SecurityCodeDialogFragment securitycodedialogfragment = new SecurityCodeDialogFragment();
        if (a1 == null || !(a1 instanceof Fragment))
        {
            throw new IllegalArgumentException("SecurityCodeListener must be an instance of Fragment");
        } else
        {
            securitycodedialogfragment.setTargetFragment((Fragment)a1, 0);
            a1 = new Bundle();
            a1.putParcelable("PaymentCardData", carddatamodel);
            securitycodedialogfragment.setArguments(a1);
            return securitycodedialogfragment;
        }
    }

    private String a(b b1)
    {
        Resources resources = getResources();
        switch (_cls3..SwitchMap.com.target.ui.fragment.checkout.SecurityCodeDialogFragment.SecurityCodeType[b1.ordinal()])
        {
        default:
            return resources.getString(0x7f09023a);

        case 1: // '\001'
            return resources.getString(0x7f09023b);
        }
    }

    private void a(int i)
    {
        mSecurityCodeMaxLength = i;
        android.text.InputFilter.LengthFilter lengthfilter = new android.text.InputFilter.LengthFilter(mSecurityCodeMaxLength);
        mViews.inputField.setFilters(new InputFilter[] {
            lengthfilter
        });
    }

    private void a(AppliedPaymentCardTender appliedpaymentcardtender)
    {
        mCardType = appliedpaymentcardtender.d();
        b b1 = a(mCardType);
        b(appliedpaymentcardtender);
        a(d.a(appliedpaymentcardtender));
        mViews.inputField.setHint(a(b1));
        e.a(appliedpaymentcardtender.d(), mViews.cardImage);
        mViews.lastFourDigits.setText(appliedpaymentcardtender.e());
    }

    static void a(SecurityCodeDialogFragment securitycodedialogfragment, String s)
    {
        securitycodedialogfragment.a(s);
    }

    private void a(CardDataModel carddatamodel)
    {
        mCardType = carddatamodel.a();
        b b1 = a(mCardType);
        b(carddatamodel);
        a(d.a(carddatamodel.a()));
        mViews.inputField.setHint(a(b1));
        e.a(carddatamodel.a(), mViews.cardImage);
        mViews.lastFourDigits.setText(carddatamodel.c());
    }

    private void a(String s)
    {
        if (mListener == null)
        {
            dismiss();
            q.a(TAG, "tried to submit security code, but listener is null");
            return;
        } else
        {
            mListener.a(mCardType, s);
            dismiss();
            return;
        }
    }

    static int b(SecurityCodeDialogFragment securitycodedialogfragment)
    {
        return securitycodedialogfragment.mSecurityCodeMaxLength;
    }

    private void b(AppliedPaymentCardTender appliedpaymentcardtender)
    {
        if (!e.a(appliedpaymentcardtender.d()))
        {
            al.c(mViews.expiry);
            return;
        }
        appliedpaymentcardtender = com.target.ui.util.d.b.a(appliedpaymentcardtender);
        if (!((com.target.ui.util.d.a.d) (appliedpaymentcardtender)).isValid)
        {
            al.c(mViews.expiry);
            return;
        } else
        {
            mViews.expiry.setText(((com.target.ui.util.d.a.d) (appliedpaymentcardtender)).formattedExpiryDate);
            return;
        }
    }

    private void b(CardDataModel carddatamodel)
    {
        if (!e.a(carddatamodel.a()))
        {
            al.c(mViews.expiry);
            return;
        }
        carddatamodel = com.target.ui.util.d.b.a(carddatamodel);
        if (!((com.target.ui.util.d.a.d) (carddatamodel)).isValid)
        {
            al.c(mViews.expiry);
            return;
        } else
        {
            mViews.expiry.setText(((com.target.ui.util.d.a.d) (carddatamodel)).formattedExpiryDate);
            return;
        }
    }

    public AppliedPaymentCardTender a()
    {
        return (AppliedPaymentCardTender)getArguments().getParcelable("AppliedPaymentCardTender");
    }

    public CardDataModel b()
    {
        return (CardDataModel)getArguments().getParcelable("PaymentCardData");
    }

    public void onAttach(Activity activity)
    {
        Fragment fragment = getTargetFragment();
        if (fragment != null && (fragment instanceof a))
        {
            mListener = (a)fragment;
            super.onAttach(activity);
            return;
        } else
        {
            throw new IllegalStateException("Make sure to implement SecurityCodeListener");
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03004e, viewgroup, false);
        mViews = new Views(layoutinflater);
        mViews.inputField.addTextChangedListener(mInputTextWatcher);
        mViews.submitButton.setOnClickListener(mSubmitButtonListener);
        viewgroup = a();
        if (viewgroup != null)
        {
            a(viewgroup);
            return layoutinflater;
        } else
        {
            a(b());
            return layoutinflater;
        }
    }

    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    public void onStart()
    {
        super.onStart();
        com.target.ui.util.e.a.b(mViews.inputField);
    }

}
