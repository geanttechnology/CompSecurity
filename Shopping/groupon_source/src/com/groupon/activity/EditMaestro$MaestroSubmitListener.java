// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.widget.EditText;
import android.widget.Spinner;
import com.groupon.util.VolatileBillingInfoProvider;
import com.groupon.view.CreditCardOneLine;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            EditMaestro

class <init> extends <init>
{

    final EditMaestro this$0;

    protected void onSubmitClick()
    {
        if (!valid())
        {
            return;
        }
        billingInfoProvider.clear();
        billingInfoProvider.setFirstName(Strings.toString(firstName.getText()));
        billingInfoProvider.setLastName(Strings.toString(lastName.getText()));
        billingInfoProvider.setStreetAddress1(Strings.toString(addressView.getText()));
        billingInfoProvider.setStreetNumber(Strings.toString(streetNumberView.getText()));
        billingInfoProvider.setCity(Strings.toString(cityView.getText()));
        billingInfoProvider.setPostalCode(Strings.toString(postalCodeView.getText()));
        billingInfoProvider.setBillingRecordType(maestroType);
        billingInfoProvider.setBillingRecordCardType(maestroType);
        Object obj = billingInfoProvider;
        int i;
        if (isUSACompatible)
        {
            i = creditCardOneLine.getExpirationMonth();
        } else
        {
            i = expirationMonth;
        }
        ((VolatileBillingInfoProvider) (obj)).setBillingRecordValidToMonth(Strings.toString(Integer.valueOf(i)));
        obj = billingInfoProvider;
        if (isUSACompatible)
        {
            i = creditCardOneLine.getExpirationYear();
        } else
        {
            i = expirationYear;
        }
        ((VolatileBillingInfoProvider) (obj)).setBillingRecordValidToYear(Strings.toString(Integer.valueOf(i)));
        if (Strings.equalsIgnoreCase(maestroType, "maestrouk"))
        {
            if (monthFromSpinner.getSelectedItem() != null && yearFromSpinner.getSelectedItem() != null)
            {
                billingInfoProvider.setBillingRecordValidFromMonth(Strings.toString(Integer.valueOf(monthFromSpinner.getSelectedItemPosition() + 1)));
                billingInfoProvider.setBillingRecordValidFromYear(Strings.toString(yearFromSpinner.getSelectedItem()));
            }
            billingInfoProvider.setBillingRecordIssuerNumber(Strings.toString(issuerNumberView.getText()));
            VolatileBillingInfoProvider volatilebillinginfoprovider = billingInfoProvider;
            if (isUSACompatible)
            {
                obj = creditCardOneLine.getCvv();
            } else
            {
                obj = Strings.toString(cvvView.getText());
            }
            volatilebillinginfoprovider.setBillingRecordCVV(((String) (obj)));
            billingInfoProvider.setCVVRequiredForCard(isCVVRequiredForSelectedCard());
        }
        volatilebillinginfoprovider = billingInfoProvider;
        if (isUSACompatible)
        {
            obj = creditCardOneLine.getCardNumber();
        } else
        {
            obj = Strings.toString(cardNumberView.getText());
        }
        volatilebillinginfoprovider.setBillingRecordCardNumber(((String) (obj)));
        putBillingRecord();
    }

    ()
    {
        this$0 = EditMaestro.this;
        super(EditMaestro.this);
    }
}
