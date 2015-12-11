// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.VolatileBillingInfoProvider;
import com.groupon.view.CreditCardOneLine;
import com.groupon.view.SpinnerButton;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            EditCreditCardEu

public class EditElv extends EditCreditCardEu
{
    class ElvSubmitListener extends EditCreditCardEu.EuSubmitListener
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
            billingInfoProvider.setBillingRecordCardType(IntentFactory.Payments.ELV.getPaymentId());
            billingInfoProvider.setBillingRecordType(IntentFactory.Payments.ELV.getPaymentId());
            putBillingRecord();
        }

        ElvSubmitListener()
        {
            this$0 = EditElv.this;
            super(EditElv.this);
        }
    }


    private static final int ELV_ACCOUNT_LEN_MAX = 12;
    private static final int ELV_ACCOUNT_LEN_MIN = 4;
    private static final int ELV_BANK_CODE_LEN_AT = 5;
    private static final int ELV_BANK_CODE_LEN_DE = 8;
    EditText accountNumberView;
    EditText bankCodeView;
    EditText issuerNumberView;
    Spinner monthFromSpinner;
    ViewGroup validFromContainer;
    Spinner yearFromSpinner;

    public EditElv()
    {
    }

    protected String getActionBarTitle()
    {
        return getString(0x7f080484);
    }

    protected int getTitleTextResId()
    {
        return 0x7f08004a;
    }

    protected void initializeActivity()
    {
        submitView.setOnClickListener(new ElvSubmitListener());
    }

    protected boolean isCardScanAvailable()
    {
        return false;
    }

    protected void renderUi(String s)
    {
        if (isUSACompatible)
        {
            creditCardOneLine.setVisibility(8);
            accountNumberView.setVisibility(0);
        } else
        {
            cardNumberView.setHint(0x7f080045);
        }
        firstName.setNextFocusDownId(-1);
        lastName.setNextFocusDownId(-1);
        if (!isUSACompatible)
        {
            cardNumberView.setNextFocusUpId(-1);
            cardNumberView.setNextFocusDownId(-1);
        }
        addressView.setNextFocusUpId(-1);
        stateView.setVisibility(8);
        countryCodeView.setVisibility(8);
        streetNumberView.setVisibility(0);
        bankCodeView.setVisibility(0);
        paymentMethodLayout.setVisibility(8);
        if (!isUSACompatible)
        {
            cvvView.setVisibility(8);
        }
        if (expirationDate != null)
        {
            expirationDate.setVisibility(8);
        }
        validFromContainer.setVisibility(8);
        monthFromSpinner.setVisibility(8);
        yearFromSpinner.setVisibility(8);
        issuerNumberView.setVisibility(8);
        if (isUSACompatible)
        {
            addViewPadding(PADDING_20, 0, PADDING_20, 0, new View[] {
                accountNumber, bankCode
            });
        }
    }

    protected boolean validateCreditCardInfo()
    {
        int i;
        if (isUSACompatible)
        {
            i = accountNumberView.getText().length();
        } else
        {
            i = Strings.toString(cardNumberView.getText()).length();
        }
        if (i < 4 || i > 12)
        {
            String s = getString(0x7f080168, new Object[] {
                Integer.valueOf(4), Integer.valueOf(12)
            });
            Toast.makeText(getApplicationContext(), s, 0).show();
            return false;
        }
        int j = Strings.toString(bankCodeView.getText()).length();
        if (currentCountryManager.getCurrentCountry().isAustria())
        {
            i = 5;
        } else
        if (currentCountryManager.getCurrentCountry().isGermany())
        {
            i = 8;
        } else
        {
            i = 0;
        }
        if (j != i)
        {
            String s1 = getString(0x7f08016b, new Object[] {
                Integer.valueOf(i)
            });
            Toast.makeText(getApplicationContext(), s1, 0).show();
            return false;
        } else
        {
            return true;
        }
    }

    protected boolean validateExpirationDate()
    {
        return true;
    }
}
