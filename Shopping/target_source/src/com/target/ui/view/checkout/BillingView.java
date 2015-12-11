// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.target.mothership.common.params.AddressParams;
import com.target.mothership.model.common.a;
import com.target.mothership.model.common.c;
import com.target.mothership.util.o;
import com.target.ui.model.checkout.BillingCardDetailsModel;
import com.target.ui.model.checkout.CardDataModel;
import com.target.ui.model.checkout.TGTBillingCardDetailsModel;
import com.target.ui.model.checkout.TGTCardDataModel;
import com.target.ui.util.al;
import com.target.ui.view.account.b;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.view.checkout:
//            a, f, AddressFormView, PaymentCardEntryView, 
//            b, PaymentCardStaticView

public class BillingView extends LinearLayout
    implements com.target.ui.view.account.b, com.target.ui.view.checkout.a, com.target.ui.view.checkout.f
{
    static class Views extends com.target.ui.view.a
    {

        AddressFormView address;
        PaymentCardEntryView card;
        PaymentCardStaticView cardNonEditable;
        View progressBar;

        Views(View view)
        {
            super(view);
        }
    }

    private class a
        implements AddressFormView.a
    {

        String addressLine;
        String apartment;
        String city;
        String firstName;
        boolean isValid;
        String lastName;
        String phoneNumber;
        String state;
        final BillingView this$0;
        String zipCode;

        public void a()
        {
            isValid = false;
        }

        public void a(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
                String s7)
        {
            firstName = s;
            lastName = s1;
            addressLine = s2;
            apartment = s3;
            city = s4;
            zipCode = s5;
            state = s6;
            phoneNumber = s7;
            isValid = true;
        }

        private a()
        {
            this$0 = BillingView.this;
            super();
        }

    }

    public class b
    {

        private final AddressParams mAddressParams;
        final BillingView this$0;

        public boolean a()
        {
            return mAddressParams != null;
        }

        public AddressParams b()
            throws IllegalStateException
        {
            if (!a())
            {
                throw new IllegalStateException("Does not contain valid AddressParams.  Did you remember to check isValid()?");
            } else
            {
                return mAddressParams;
            }
        }

        private b(AddressParams addressparams)
        {
            this$0 = BillingView.this;
            super();
            mAddressParams = addressparams;
        }

    }

    public class c
    {

        private final TGTBillingCardDetailsModel model;
        final BillingView this$0;

        public boolean a()
        {
            return model != null;
        }

        public BillingCardDetailsModel b()
            throws IllegalStateException
        {
            if (!a())
            {
                throw new IllegalStateException("Does not contain valid BillingCardDetailsModel.  Did you remember to check isValid()?");
            } else
            {
                return model;
            }
        }

        private c(BillingCardDetailsModel billingcarddetailsmodel)
        {
            this$0 = BillingView.this;
            super();
            if (billingcarddetailsmodel == null)
            {
                model = null;
                return;
            } else
            {
                model = new TGTBillingCardDetailsModel();
                model.a(billingcarddetailsmodel.b());
                model.a(billingcarddetailsmodel.a());
                return;
            }
        }

    }

    private static final class d extends Enum
    {

        private static final d $VALUES[];
        public static final d AddNewCard;
        public static final d EditAddress;

        public static d valueOf(String s)
        {
            return (d)Enum.valueOf(com/target/ui/view/checkout/BillingView$d, s);
        }

        public static d[] values()
        {
            return (d[])$VALUES.clone();
        }

        static 
        {
            EditAddress = new d("EditAddress", 0);
            AddNewCard = new d("AddNewCard", 1);
            $VALUES = (new d[] {
                EditAddress, AddNewCard
            });
        }

        private d(String s, int i)
        {
            super(s, i);
        }
    }

    private class e
        implements PaymentCardEntryView.a
    {

        String cardNumber;
        com.target.mothership.common.tender.a cardType;
        String expMonth;
        String expYear;
        boolean isValid;
        String security;
        final BillingView this$0;

        public void a()
        {
            isValid = false;
        }

        public void a(com.target.mothership.common.tender.a a1, String s, String s1, String s2, String s3)
        {
            cardType = a1;
            cardNumber = s;
            expMonth = s1;
            expYear = s2;
            security = s3;
            isValid = true;
        }

        private e()
        {
            this$0 = BillingView.this;
            super();
        }

    }

    private class f
    {

        final BillingView this$0;
        boolean validAddress;
        boolean validCard;

        private f()
        {
            this$0 = BillingView.this;
            super();
            validCard = false;
            validAddress = false;
        }

    }


    private static final String DEFAULT_COUNTRY = "US";
    private static final String TAG = com/target/ui/view/checkout/BillingView.getSimpleName();
    private com.target.ui.view.checkout.b mActionListener;
    private f mFormState;
    private com.target.ui.view.account.c mInputChangeListener;
    private com.target.ui.view.account.b mListener;
    private d mMode;
    private com.target.ui.view.checkout.f mPaymentCardEntryActionListener;
    private CardDataModel mPrePopulatedCardDataCache;
    private boolean mShowRedSavings;
    private Views mViews;

    public BillingView(Context context)
    {
        super(context);
        mMode = d.AddNewCard;
        mShowRedSavings = true;
        a(context);
    }

    public BillingView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mMode = d.AddNewCard;
        mShowRedSavings = true;
        a(context);
    }

    public BillingView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mMode = d.AddNewCard;
        mShowRedSavings = true;
        a(context);
    }

    private AddressParams a(a a1)
    {
        if (!a1.isValid)
        {
            return null;
        }
        ArrayList arraylist = new ArrayList();
        arraylist.add(a1.addressLine);
        if (o.g(a1.apartment))
        {
            arraylist.add(a1.apartment);
        }
        return new AddressParams(com.target.mothership.model.common.a.Billing, arraylist, a1.city, a1.state, a1.zipCode, "US", a1.firstName, "", a1.lastName, com.target.ui.util.d.b.g(a1.phoneNumber), com.target.mothership.model.common.c.Home, true);
    }

    private CardDataModel a(e e1)
    {
        if (!e1.isValid)
        {
            return null;
        } else
        {
            TGTCardDataModel tgtcarddatamodel = new TGTCardDataModel();
            tgtcarddatamodel.a(e1.cardType);
            tgtcarddatamodel.a(e1.cardNumber);
            tgtcarddatamodel.b(com.target.ui.util.d.b.a(e1.cardNumber));
            tgtcarddatamodel.d(e1.expMonth);
            tgtcarddatamodel.c(e1.expYear);
            tgtcarddatamodel.e(e1.security);
            return tgtcarddatamodel;
        }
    }

    private a a(AddressFormView addressformview)
    {
        a a1 = new a();
        addressformview.a(a1);
        return a1;
    }

    private c a(d d1)
    {
        AddressParams addressparams;
        if (!b(mFormState))
        {
            return new c(null);
        }
        addressparams = a(a(mViews.address));
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$view$checkout$BillingView$BillingViewMode[];

            static 
            {
                $SwitchMap$com$target$ui$view$checkout$BillingView$BillingViewMode = new int[d.values().length];
                try
                {
                    $SwitchMap$com$target$ui$view$checkout$BillingView$BillingViewMode[d.EditAddress.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$view$checkout$BillingView$BillingViewMode[d.AddNewCard.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.target.ui.view.checkout.BillingView.BillingViewMode[d1.ordinal()];
        JVM INSTR tableswitch 1 2: default 68
    //                   1 95
    //                   2 129;
           goto _L1 _L2 _L3
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("Cannot get billing view inputs for undefined mode: ").append(d1).toString());
_L2:
        d1 = mPrePopulatedCardDataCache;
_L5:
        TGTBillingCardDetailsModel tgtbillingcarddetailsmodel = new TGTBillingCardDetailsModel();
        tgtbillingcarddetailsmodel.a(addressparams);
        tgtbillingcarddetailsmodel.a(d1);
        return new c(tgtbillingcarddetailsmodel, null);
_L3:
        d1 = a(a(mViews.card));
        if (true) goto _L5; else goto _L4
_L4:
    }

    private e a(PaymentCardEntryView paymentcardentryview)
    {
        e e1 = new e(null);
        paymentcardentryview.a(e1);
        return e1;
    }

    private void a(Context context)
    {
        inflate(context, 0x7f030128, this);
        mViews = new Views(this);
        mViews.card.setInputValidationListener(this);
        mViews.card.setPaymentCardEntryActionListener(this);
        mViews.address.setInputValidationListener(this);
        mViews.address.setCheckoutAddressFormListener(this);
        mViews.address.setAddressHint(getResources().getString(0x7f0901c3));
        mFormState = new f(null);
    }

    private void a(f f1)
    {
        boolean flag;
        if (mMode == d.EditAddress || a(mViews.card).isValid)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f1.validCard = flag;
        f1.validAddress = a(mViews.address).isValid;
    }

    private void b(boolean flag)
    {
        if (mListener != null)
        {
            mListener.a(this, flag);
        }
    }

    private boolean b(f f1)
    {
        return f1.validAddress && f1.validCard;
    }

    public b a()
    {
        return new b(a(a(mViews.address)), null);
    }

    public void a(View view, boolean flag)
    {
        int i = view.getId();
        if (i != mViews.address.getId()) goto _L2; else goto _L1
_L1:
        mFormState.validAddress = flag;
_L4:
        flag = b(mFormState);
        if (flag && mActionListener != null)
        {
            mActionListener.b(b().b());
        }
        b(flag);
        return;
_L2:
        if (i == mViews.card.getId())
        {
            view = mFormState;
            if (mMode == d.EditAddress || flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.validCard = flag;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(com.target.mothership.model.c.c.a a1)
    {
        mViews.address.setGeoCodeDetails(a1);
    }

    public void a(BillingCardDetailsModel billingcarddetailsmodel)
    {
        if (billingcarddetailsmodel == null)
        {
            throw new IllegalArgumentException("BillingCardDetailsModel cannot be null");
        }
        AddressParams addressparams = billingcarddetailsmodel.b();
        if (addressparams == null)
        {
            throw new IllegalArgumentException("BillingCardDetailsModel must not have a null AddressParams");
        }
        billingcarddetailsmodel = billingcarddetailsmodel.a();
        if (billingcarddetailsmodel == null)
        {
            throw new IllegalArgumentException("BillingCardDetailsModel cannot contain a null CardDataModel");
        }
        if (o.e(billingcarddetailsmodel.c()))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("CardDataModel must contain at least the last 4 digits of a card number, but it only contains").append(billingcarddetailsmodel.c()).toString());
        }
        if (billingcarddetailsmodel.a() == null)
        {
            throw new IllegalArgumentException("CardDataModel must have a non-null CardType");
        } else
        {
            mMode = d.EditAddress;
            mViews.cardNonEditable.a(billingcarddetailsmodel.a(), billingcarddetailsmodel.c());
            al.a(mViews.cardNonEditable, new View[] {
                mViews.card
            });
            mViews.address.a(addressparams);
            mPrePopulatedCardDataCache = billingcarddetailsmodel;
            a(mFormState);
            b(b(mFormState));
            return;
        }
    }

    public void a(String s)
    {
        mViews.card.a(s);
    }

    public void a(boolean flag)
    {
        mShowRedSavings = flag;
    }

    public c b()
    {
        return a(mMode);
    }

    public void c(String s)
    {
        if (!o.g(s) || mActionListener == null)
        {
            return;
        } else
        {
            mActionListener.e(s);
            return;
        }
    }

    public void q()
    {
        if (mPaymentCardEntryActionListener != null)
        {
            mPaymentCardEntryActionListener.q();
        }
    }

    public void setActionListener(com.target.ui.view.checkout.b b1)
    {
        mActionListener = b1;
    }

    public void setInputChangeListener(com.target.ui.view.account.c c1)
    {
        mInputChangeListener = c1;
        mViews.address.setInputChangeListener(mInputChangeListener);
    }

    public void setInputValidationListener(com.target.ui.view.account.b b1)
    {
        mListener = b1;
    }

    public void setPaymentCardEntryActionListener(com.target.ui.view.checkout.f f1)
    {
        mPaymentCardEntryActionListener = f1;
    }

}
