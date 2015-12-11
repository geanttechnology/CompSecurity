// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import com.groupon.models.billingrecord.BillingRecord;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.VolatileBillingInfoProvider;
import com.groupon.view.CreditCardOneLine;
import com.groupon.view.SpinnerButton;
import java.util.Calendar;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            EditCreditCardEu

public class EditMaestro extends EditCreditCardEu
{
    class MaestroSubmitListener extends EditCreditCardEu.EuSubmitListener
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

        MaestroSubmitListener()
        {
            this$0 = EditMaestro.this;
            super(EditMaestro.this);
        }
    }


    EditText issuerNumberView;
    String maestroType;
    Spinner monthFromSpinner;
    ViewGroup validFromContainer;
    Spinner yearFromSpinner;

    public EditMaestro()
    {
    }

    protected String getMonthAdapterPrompt()
    {
        return getString(0x7f080400);
    }

    protected void initializeActivity()
    {
        submitView.setOnClickListener(new MaestroSubmitListener());
    }

    protected boolean isCardScanAvailable()
    {
        return false;
    }

    protected void renderUi(String s)
    {
        int i = 0x7f1000ca;
        boolean flag = false;
        stateView.setVisibility(8);
        countryCodeView.setVisibility(8);
        streetNumberView.setVisibility(0);
        paymentMethodLayout.setVisibility(8);
        boolean flag1 = Strings.equalsIgnoreCase(maestroType, "maestrouk");
        ArrayAdapter arrayadapter;
        if (isUSACompatible)
        {
            s = creditCardOneLine.getCreditCardNumberView();
            int j;
            if (flag1)
            {
                j = 0x7f1000bb;
            } else
            {
                j = 0x7f1000ca;
            }
            s.setNextFocusDownId(j);
            creditCardOneLine.setCvvVisibility(flag1);
            s = creditCardOneLine.getCvvView();
            if (flag1)
            {
                i = 0x7f1000bd;
            }
            s.setNextFocusDownId(i);
            s = creditCardOneLine.getExpirationMonthView();
            if (flag1)
            {
                i = 0x7f1000bf;
            } else
            {
                i = 0x7f1000b9;
            }
            s.setNextFocusUpId(i);
        } else
        {
            s = cardNumberView;
            int k;
            if (flag1)
            {
                k = 0x7f1000bb;
            } else
            {
                k = 0x7f1000ca;
            }
            s.setNextFocusDownId(k);
            s = cvvView;
            if (flag1)
            {
                k = 0;
            } else
            {
                k = 8;
            }
            s.setVisibility(k);
            s = cvvView;
            if (flag1)
            {
                i = 0x7f1000bd;
            }
            s.setNextFocusDownId(i);
        }
        s = validFromContainer;
        if (flag1)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        s.setVisibility(i);
        s = monthFromSpinner;
        if (flag1)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        s.setVisibility(i);
        s = yearFromSpinner;
        if (flag1)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        s.setVisibility(i);
        s = issuerNumberView;
        if (flag1)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 8;
        }
        s.setVisibility(i);
        s = new Integer[15];
        if (isUSACompatible)
        {
            i = 0x7f03020b;
        } else
        {
            i = 0x7f030209;
        }
        arrayadapter = new ArrayAdapter(this, i, s);
        for (i = 0; i < 15; i++)
        {
            s[i] = Integer.valueOf(Calendar.getInstance().get(1) - i);
        }

        arrayadapter.setDropDownViewResource(0x1090009);
        yearFromSpinner.setAdapter(arrayadapter);
        s = getResources().getStringArray(0x7f0f000d);
        if (isUSACompatible)
        {
            i = 0x7f03020b;
        } else
        {
            i = 0x7f030209;
        }
        s = new ArrayAdapter(this, i, s);
        s.setDropDownViewResource(0x1090009);
        monthFromSpinner.setAdapter(s);
    }

    protected void saveToPrefs(BillingRecord billingrecord)
    {
        Object obj = billingrecord.id;
        if (Strings.notEmpty(obj))
        {
            billingrecord = ((BillingRecord) (obj));
        } else
        {
            billingrecord = billingrecord.billingRecordId;
        }
        obj = loginPrefs.edit();
        if (!Strings.notEmpty(billingrecord))
        {
            billingrecord = maestroType;
        }
        ((com.groupon.util.ArraySharedPreferences.Editor) (obj)).putString("currentBillingRecordId", billingrecord).apply();
    }
}
