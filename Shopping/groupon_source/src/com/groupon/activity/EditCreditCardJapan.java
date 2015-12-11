// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.groupon.models.billingrecord.BillingRecord;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.VolatileBillingInfoProvider;
import com.groupon.view.CreditCardOneLine;
import com.groupon.view.SpinnerButton;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            EditCreditCardEu

public class EditCreditCardJapan extends EditCreditCardEu
{
    class EuSubmitListener
        implements android.view.View.OnClickListener
    {

        final EditCreditCardJapan this$0;

        public void onClick(View view)
        {
            onSubmitClick();
        }

        protected void onSubmitClick()
        {
            if (!valid())
            {
                return;
            }
            billingInfoProvider.clear();
            billingInfoProvider.setBillingRecordType("creditcard");
            billingInfoProvider.setBillingRecordCardType("");
            Object obj = billingInfoProvider;
            int i;
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
            if (isCVVRequiredForSelectedCard())
            {
                VolatileBillingInfoProvider volatilebillinginfoprovider = billingInfoProvider;
                if (isUSACompatible)
                {
                    obj = creditCardOneLine.getCvv();
                } else
                {
                    obj = Strings.toString(cvvView.getText());
                }
                volatilebillinginfoprovider.setBillingRecordCVV(((String) (obj)));
            }
            billingInfoProvider.setCVVRequiredForCard(isCVVRequiredForSelectedCard());
            volatilebillinginfoprovider = billingInfoProvider;
            if (isUSACompatible)
            {
                obj = creditCardOneLine.getCardNumber();
            } else
            {
                obj = Strings.toString(cardNumberView.getText());
            }
            volatilebillinginfoprovider.setBillingRecordCardNumber(((String) (obj)));
            logCreditCardVariantEvent();
            setResultAndSaveToPrefs(null);
        }

        EuSubmitListener()
        {
            this$0 = EditCreditCardJapan.this;
            super();
        }
    }


    public EditCreditCardJapan()
    {
    }

    protected void initializeActivity()
    {
        submitView.setOnClickListener(new EuSubmitListener());
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        firstName.setVisibility(8);
        lastName.setVisibility(8);
        if (creditCardDemographicsContainer != null)
        {
            creditCardDemographicsContainer.setVisibility(8);
        }
    }

    protected void saveToPrefs(BillingRecord billingrecord)
    {
        loginPrefs.edit().putString("currentBillingRecordId", "volatile").apply();
    }

    protected void setUpBillingAddressSection(Bundle bundle)
    {
        initializeActivity();
    }

    protected boolean valid()
    {
        return validateCreditCardInfo() && validateExpirationDate();
    }
}
