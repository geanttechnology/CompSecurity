// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.widget.EditText;
import com.groupon.util.VolatileBillingInfoProvider;
import com.groupon.view.CreditCardOneLine;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            EditIsracard

class nit> extends nit>
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
        billingInfoProvider.setBillingRecordType(cordType.cordType());
        billingInfoProvider.setBillingRecordCardType(cordCardType.cordCardType());
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

    ()
    {
        this$0 = EditIsracard.this;
        super(EditIsracard.this);
    }
}
