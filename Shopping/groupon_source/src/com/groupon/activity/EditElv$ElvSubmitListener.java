// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.widget.EditText;
import com.groupon.util.VolatileBillingInfoProvider;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            EditElv

class istener extends istener
{

    final EditElv this$0;

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
        VolatileBillingInfoProvider volatilebillinginfoprovider = billingInfoProvider;
        String s;
        if (isUSACompatible)
        {
            s = Strings.toString(accountNumberView.getText());
        } else
        {
            s = Strings.toString(cardNumberView.getText());
        }
        volatilebillinginfoprovider.setBillingRecordElvAccountNumber(s);
        billingInfoProvider.setBillingRecordElvBankCode(Strings.toString(bankCodeView.getText()));
        billingInfoProvider.setBillingRecordCardType(.PaymentId());
        billingInfoProvider.setBillingRecordType(.PaymentId());
        putBillingRecord();
    }

    istener()
    {
        this$0 = EditElv.this;
        super(EditElv.this);
    }
}
