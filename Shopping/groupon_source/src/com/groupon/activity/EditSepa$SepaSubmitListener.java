// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.widget.EditText;
import com.groupon.util.VolatileBillingInfoProvider;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            EditSepa

class tener extends tener
{

    final EditSepa this$0;

    protected void onSubmitClick()
    {
        if (!valid())
        {
            return;
        } else
        {
            billingInfoProvider.clear();
            billingInfoProvider.setFirstName(Strings.toString(firstName.getText()));
            billingInfoProvider.setLastName(Strings.toString(lastName.getText()));
            billingInfoProvider.setStreetAddress1(Strings.toString(addressView.getText()));
            billingInfoProvider.setStreetNumber(Strings.toString(streetNumberView.getText()));
            billingInfoProvider.setCity(Strings.toString(cityView.getText()));
            billingInfoProvider.setPostalCode(Strings.toString(postalCodeView.getText()));
            billingInfoProvider.setBillingRecordSepaIban(Strings.toString(iban.getText()));
            billingInfoProvider.setBillingRecordSepaBic(Strings.toString(bic.getText()));
            billingInfoProvider.setBillingRecordCardType(IRECTDEBIT.ymentId());
            billingInfoProvider.setBillingRecordType(IRECTDEBIT.ymentId());
            putBillingRecord();
            return;
        }
    }

    tener()
    {
        this$0 = EditSepa.this;
        super(EditSepa.this);
    }
}
