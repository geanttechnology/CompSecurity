// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import com.groupon.models.billingrecord.BillingRecord;
import com.groupon.models.country.Country;
import com.groupon.models.country.PaymentMethod;
import com.groupon.service.BillingService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.Function1;
import com.groupon.util.ReturningFunction1;
import com.groupon.util.VolatileBillingInfoProvider;
import com.groupon.view.CreditCardOneLine;
import java.util.ArrayList;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            EditCreditCardEu

class this._cls0
    implements android.view.istener
{

    final EditCreditCardEu this$0;

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
        String s = Strings.toString(firstName.getText());
        String s1 = Strings.toString(lastName.getText());
        String s2 = Strings.toString(addressView.getText());
        String s3 = Strings.toString(postalCodeView.getText());
        billingInfoProvider.setFirstName(s);
        billingInfoProvider.setLastName(s1);
        billingInfoProvider.setStreetAddress1(s2);
        if (!EditCreditCardEu.access$000(EditCreditCardEu.this))
        {
            billingInfoProvider.setStreetNumber(Strings.toString(streetNumberView.getText()));
        }
        billingInfoProvider.setCity(Strings.toString(cityView.getText()));
        billingInfoProvider.setPostalCode(s3);
        Object obj = ((PaymentMethod)paymentMethod.getSelectedItem()).name;
        billingInfoProvider.setBillingRecordType("creditcard");
        billingInfoProvider.setBillingRecordCardType(Strings.toString(obj));
        obj = billingInfoProvider;
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
        if (currentCountryManager.getCurrentCountry().isBrazil())
        {
            billingInfoProvider.setBillingRecordCpf(Strings.toString(cpf.getText()));
        }
        if (EditCreditCardEu.access$000(EditCreditCardEu.this))
        {
            billingInfoProvider.setBillingRecordFirstName(s);
            billingInfoProvider.setBillingRecordLastName(s1);
            billingInfoProvider.setBillingRecordAddress(s2);
            billingInfoProvider.setBillingRecordPostalCode(s3);
        }
        putBillingRecord();
        logCreditCardVariantEvent();
    }

    protected void putBillingRecord()
    {
        EditCreditCardEu.access$200(EditCreditCardEu.this).putEuBillingRecord(Integer.valueOf(0x7f100102), new Function1() {

            final EditCreditCardEu.EuSubmitListener this$1;

            public void execute(com.groupon.models.billingrecord.BillingRecord.List list)
            {
                if (list != null && !list.billingRecords.isEmpty())
                {
                    setResultAndSaveToPrefs((BillingRecord)list.billingRecords.get(0));
                }
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((com.groupon.models.billingrecord.BillingRecord.List)obj);
            }

            
            {
                this$1 = EditCreditCardEu.EuSubmitListener.this;
                super();
            }
        }, new ReturningFunction1() {

            final EditCreditCardEu.EuSubmitListener this$1;

            public Boolean execute(Exception exception)
                throws RuntimeException
            {
                billingInfoProvider.clear();
                return Boolean.valueOf(handleBillingRecordException(exception));
            }

            public volatile Object execute(Object obj)
                throws Exception
            {
                return execute((Exception)obj);
            }

            
            {
                this$1 = EditCreditCardEu.EuSubmitListener.this;
                super();
            }
        }, null, billingInfoProvider.getBillingInfoParams().toArray());
    }

    _cls2.this._cls1()
    {
        this$0 = EditCreditCardEu.this;
        super();
    }
}
