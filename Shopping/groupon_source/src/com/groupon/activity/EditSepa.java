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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            EditCreditCardEu

public class EditSepa extends EditCreditCardEu
{
    class SepaSubmitListener extends EditCreditCardEu.EuSubmitListener
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
                billingInfoProvider.setBillingRecordCardType(IntentFactory.Payments.SEPADIRECTDEBIT.getPaymentId());
                billingInfoProvider.setBillingRecordType(IntentFactory.Payments.SEPADIRECTDEBIT.getPaymentId());
                putBillingRecord();
                return;
            }
        }

        SepaSubmitListener()
        {
            this$0 = EditSepa.this;
            super(EditSepa.this);
        }
    }


    private final String BIC_VALIDATION_REGEX = "[a-zA-Z]{6}[a-zA-Z0-9]{2}([a-zA-Z0-9]{3})?";
    private final String IBAN_VALIDATION_REGEX = "DE\\d{20}";
    EditText issuerNumberView;
    Spinner monthFromSpinner;
    ViewGroup validFromContainer;
    Spinner yearFromSpinner;

    public EditSepa()
    {
    }

    protected String getActionBarTitle()
    {
        return getString(0x7f08045e);
    }

    protected int getTitleTextResId()
    {
        return 0x7f08004f;
    }

    protected void initializeActivity()
    {
        submitView.setOnClickListener(new SepaSubmitListener());
    }

    protected boolean isCardScanAvailable()
    {
        return false;
    }

    protected void renderUi(String s)
    {
        firstName.setNextFocusDownId(-1);
        lastName.setNextFocusDownId(-1);
        addressView.setNextFocusUpId(-1);
        stateView.setVisibility(8);
        countryCodeView.setVisibility(8);
        streetNumberView.setVisibility(0);
        iban.setVisibility(0);
        iban.setNextFocusDownId(-1);
        bic.setVisibility(0);
        bic.setNextFocusDownId(-1);
        if (isUSACompatible)
        {
            creditCardOneLine.setVisibility(8);
            addViewPadding(PADDING_20, 0, PADDING_20, 0, new View[] {
                iban, bic
            });
        }
        iban.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            final EditSepa this$0;

            public void onFocusChange(View view, boolean flag)
            {
                if (flag && iban.getText().length() == 0)
                {
                    iban.setText(Strings.toString(currentCountryManager.getCurrentCountry().isoName).toUpperCase());
                    iban.setSelection(2);
                }
            }

            
            {
                this$0 = EditSepa.this;
                super();
            }
        });
        if (expirationDate != null)
        {
            expirationDate.setVisibility(8);
        }
        cardNumberView.setVisibility(8);
        paymentMethodLayout.setVisibility(8);
        cvvView.setVisibility(8);
        validFromContainer.setVisibility(8);
        monthFromSpinner.setVisibility(8);
        yearFromSpinner.setVisibility(8);
        issuerNumberView.setVisibility(8);
    }

    protected boolean validateCreditCardInfo()
    {
        boolean flag = true;
        Pattern pattern = Pattern.compile("DE\\d{20}");
        String s = Strings.toString(iban.getText());
        if (Strings.isEmpty(s) || !pattern.matcher(s).matches())
        {
            Toast.makeText(getApplicationContext(), 0x7f080177, 1).show();
            flag = false;
        } else
        {
            Pattern pattern1 = Pattern.compile("[a-zA-Z]{6}[a-zA-Z0-9]{2}([a-zA-Z0-9]{3})?");
            String s1 = Strings.toString(bic.getText());
            if (Strings.isEmpty(s1) || !pattern1.matcher(s1).matches())
            {
                Toast.makeText(getApplicationContext(), 0x7f08016c, 1).show();
                return false;
            }
        }
        return flag;
    }

    protected boolean validateExpirationDate()
    {
        return true;
    }
}
