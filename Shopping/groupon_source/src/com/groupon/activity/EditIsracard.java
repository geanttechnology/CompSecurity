// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import com.groupon.util.VolatileBillingInfoProvider;
import com.groupon.view.CreditCardOneLine;
import com.groupon.view.SpinnerButton;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            EditCreditCardEu

public class EditIsracard extends EditCreditCardEu
{
    class IsracardSubmitListener extends EditCreditCardEu.EuSubmitListener
    {

        final EditIsracard this$0;

        protected void onSubmitClick()
        {
            if (!valid())
            {
                return;
            }
            billingInfoProvider.clear();
            Object obj = Strings.toString(firstName.getText());
            Object obj1 = Strings.toString(lastName.getText());
            String s = Strings.toString(addressView.getText());
            String s1 = Strings.toString(postalCodeView.getText());
            billingInfoProvider.setFirstName(((String) (obj)));
            billingInfoProvider.setLastName(((String) (obj1)));
            billingInfoProvider.setStreetAddress1(s);
            billingInfoProvider.setStreetNumber(Strings.toString(streetNumberView.getText()));
            billingInfoProvider.setCity(Strings.toString(cityView.getText()));
            billingInfoProvider.setPostalCode(s1);
            obj1 = billingInfoProvider;
            int i;
            if (isUSACompatible)
            {
                obj = creditCardOneLine.getCardNumber();
            } else
            {
                obj = Strings.toString(cardNumberView.getText());
            }
            ((VolatileBillingInfoProvider) (obj1)).setBillingRecordCardNumber(((String) (obj)));
            billingInfoProvider.setBillingRecordType(IntentFactory.Payments.ISRACARD.getPaymentId());
            billingInfoProvider.setBillingRecordCardType(IntentFactory.Payments.ISRACARD.getPaymentId());
            obj = billingInfoProvider;
            if (isUSACompatible)
            {
                i = creditCardOneLine.getExpirationMonth();
            } else
            {
                i = expirationMonth;
            }
            ((VolatileBillingInfoProvider) (obj)).setBillingRecordExpirationMonth(Strings.toString(Integer.valueOf(i)));
            obj = billingInfoProvider;
            if (isUSACompatible)
            {
                i = creditCardOneLine.getExpirationYear();
            } else
            {
                i = expirationYear;
            }
            ((VolatileBillingInfoProvider) (obj)).setBillingRecordExpirationYear(Strings.toString(Integer.valueOf(i)));
            obj1 = billingInfoProvider;
            if (isUSACompatible)
            {
                obj = creditCardOneLine.getCvv();
            } else
            {
                obj = Strings.toString(cvvView.getText());
            }
            ((VolatileBillingInfoProvider) (obj1)).setBillingRecordCVV(((String) (obj)));
            billingInfoProvider.setCVVRequiredForCard(true);
            putBillingRecord();
        }

        IsracardSubmitListener()
        {
            this$0 = EditIsracard.this;
            super(EditIsracard.this);
        }
    }


    public EditIsracard()
    {
    }

    protected String getActionBarTitle()
    {
        return getString(0x7f0804e7);
    }

    protected int getTitleTextResId()
    {
        return 0x7f08004c;
    }

    protected void initializeActivity()
    {
        submitView.setOnClickListener(new IsracardSubmitListener());
    }

    protected boolean isCardScanAvailable()
    {
        return false;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
    }

    protected void renderUi(String s)
    {
        cpf = (EditText)findViewById(0x7f1000c1);
        cpf.setVisibility(8);
        stateView.setVisibility(8);
        countryCodeView.setVisibility(8);
        streetNumberView.setVisibility(0);
        paymentMethodLayout.setVisibility(8);
        if (isUSACompatible)
        {
            creditCardOneLine.setCvvVisibility(true);
            return;
        } else
        {
            cvvView.setVisibility(0);
            return;
        }
    }
}
