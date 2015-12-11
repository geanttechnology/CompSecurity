// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.groupon.Channel;
import com.groupon.models.billingrecord.BillingRecord;
import com.groupon.models.country.Country;
import com.groupon.models.country.CreditCard;
import com.groupon.models.country.PaymentMethod;
import com.groupon.models.support.StaticSupportInfo;
import com.groupon.service.BillingService;
import com.groupon.service.core.StaticSupportInfoService;
import com.groupon.service.countryanddivision.CountriesService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.AbstractRetryAsyncTask;
import com.groupon.util.ContextUtils;
import com.groupon.util.CreditCardStorageOptInHandler;
import com.groupon.util.Function1;
import com.groupon.util.LoggingUtils;
import com.groupon.util.ReturningFunction1;
import com.groupon.util.VolatileBillingInfoProvider;
import com.groupon.view.CreditCardOneLine;
import com.groupon.view.SpinnerButton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            EditCreditCard

public class EditCreditCardEu extends EditCreditCard
{
    protected class ConsentChangeListener
        implements android.view.View.OnClickListener
    {

        final EditCreditCardEu this$0;

        public void onClick(View view)
        {
            storageOptIn.doUpdateUserConsent(storageChoice.isChecked());
        }

        protected ConsentChangeListener()
        {
            this$0 = EditCreditCardEu.this;
            super();
        }
    }

    class EuSubmitListener
        implements android.view.View.OnClickListener
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
            if (!isLATAMAmex())
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
            if (isLATAMAmex())
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
            billingService.putEuBillingRecord(Integer.valueOf(0x7f100102), new Function1() {

                final EuSubmitListener this$1;

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
                this$1 = EuSubmitListener.this;
                super();
            }
            }, new ReturningFunction1() {

                final EuSubmitListener this$1;

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
                this$1 = EuSubmitListener.this;
                super();
            }
            }, null, billingInfoProvider.getBillingInfoParams().toArray());
        }

        EuSubmitListener()
        {
            this$0 = EditCreditCardEu.this;
            super();
        }
    }

    private class GetCountriesRetryAsyncTask extends AbstractRetryAsyncTask
    {

        final EditCreditCardEu this$0;

        public volatile Object call()
            throws Exception
        {
            return call();
        }

        public List call()
            throws Exception
        {
            return countriesService.getCountriesSyncTask();
        }

        protected volatile void onSuccess(Object obj)
            throws Exception
        {
            onSuccess((List)obj);
        }

        protected void onSuccess(List list)
            throws Exception
        {
            super.onSuccess(list);
            for (list = list.iterator(); list.hasNext();)
            {
                Country country = (Country)list.next();
                if (Strings.equals(country.shortName, currentCountryManager.getCurrentCountry().shortName))
                {
                    loadPaymentMethodsFrom(getFilteredCreditCards(country.getCreditCards()));
                    paymentMethod.setEnabled(true);
                    return;
                }
            }

            throw new RuntimeException("Could not find a country that matches.");
        }

        public GetCountriesRetryAsyncTask()
        {
            this$0 = EditCreditCardEu.this;
            super(EditCreditCardEu.this);
        }
    }


    protected VolatileBillingInfoProvider billingInfoProvider;
    private BillingService billingService;
    protected Channel channel;
    private CountriesService countriesService;
    protected EditText cpf;
    protected CurrentCountryManager currentCountryManager;
    private LoggingUtils loggingUtils;
    Spinner paymentMethod;
    LinearLayout paymentMethodLayout;
    private StaticSupportInfoService staticSupportInfoService;
    CheckBox storageChoice;
    protected Bundle storageConsentRequirements;
    private CreditCardStorageOptInHandler storageOptIn;

    public EditCreditCardEu()
    {
        channel = Channel.UNKNOWN;
    }

    private boolean isLATAMAmex()
    {
        return currentCountryManager.getCurrentCountry().isLATAMCompatible() && Strings.equalsIgnoreCase(((PaymentMethod)paymentMethod.getSelectedItem()).name, "amex");
    }

    private void loadPaymentMethodsFrom(List list)
    {
        Spinner spinner = paymentMethod;
        int i;
        if (isUSACompatible)
        {
            i = 0x7f03020b;
        } else
        {
            i = 0x7f030209;
        }
        spinner.setAdapter(new ArrayAdapter(i, list, list) {

            final EditCreditCardEu this$0;
            final List val$paymentMethods;

            public View getDropDownView(int j, View view, ViewGroup viewgroup)
            {
                viewgroup = (TextView)super.getDropDownView(j, view, viewgroup);
                String s = ((CreditCard)paymentMethods.get(j)).name;
                j = ContextUtils.getIdentifier(getContext(), s.toLowerCase(), "string");
                double d;
                if (j == 0)
                {
                    viewgroup.setText(s);
                } else
                {
                    viewgroup.setText(getString(j));
                }
                d = getResources().getDisplayMetrics().density;
                if (viewgroup.getLayoutParams() != null)
                {
                    view = viewgroup.getLayoutParams();
                } else
                {
                    view = new android.widget.AbsListView.LayoutParams(EditCreditCardEu.this, null);
                }
                view.height = (int)(50D * d);
                viewgroup.setText(getPaymentDisplayName(s));
                viewgroup.setLayoutParams(view);
                viewgroup.setGravity(17);
                return viewgroup;
            }

            protected String getPaymentDisplayName(String s)
            {
                Country country = currentCountryManager.getCurrentCountry();
                if (Strings.equals(s, "creditcard") && (country.isBrazil() || country.isLATAMCompatible()))
                {
                    if (country.isLATAMCompatible())
                    {
                        return (new StringBuilder()).append(getString(0x7f08047e)).append(" / ").append(getString(0x7f08046e)).toString();
                    } else
                    {
                        return getString(0x7f080115);
                    }
                }
                int j = ContextUtils.getIdentifier(getContext(), s.toLowerCase(), "string");
                if (j != 0)
                {
                    s = getString(j);
                }
                return s;
            }

            public View getView(int j, View view, ViewGroup viewgroup)
            {
                String s = ((CreditCard)paymentMethods.get(j)).name;
                viewgroup = view;
                if (view == null)
                {
                    view = inflater;
                    if (isUSACompatible)
                    {
                        j = 0x7f03020b;
                    } else
                    {
                        j = 0x7f030209;
                    }
                    viewgroup = view.inflate(j, null, false);
                }
                view = (TextView)viewgroup;
                view.setText(getPaymentDisplayName(s));
                return view;
            }

            
            {
                this$0 = EditCreditCardEu.this;
                paymentMethods = list1;
                super(final_context, i, list);
            }
        });
    }

    private boolean validateBillingInfoSpecial()
    {
        while (!validateFirstLastName() || !validatePaymentMethod() || !validateCreditCardInfo() || !validateExpirationDate() || !validateStreetNumber() || !validateAddress() || !validatePostalCode() || !validateCity()) 
        {
            return false;
        }
        return true;
    }

    private boolean validateCPF()
    {
        if (currentCountryManager.getCurrentCountry().isBrazil() && Strings.isEmpty(cpf.getText()))
        {
            Toast.makeText(getApplicationContext(), 0x7f080170, 0).show();
            return false;
        } else
        {
            return true;
        }
    }

    protected List getFilteredCreditCards(List list)
    {
        if (availableCCPaymentMethodsForDeal != null && availableCCPaymentMethodsForDeal.length != 0) goto _L2; else goto _L1
_L1:
        return list;
_L2:
        List list1 = Arrays.asList(availableCCPaymentMethodsForDeal);
        ArrayList arraylist = new ArrayList();
        Iterator iterator = list.iterator();
        do
        {
            list = arraylist;
            if (!iterator.hasNext())
            {
                continue;
            }
            list = (CreditCard)iterator.next();
            if (list1.contains(((CreditCard) (list)).name))
            {
                arraylist.add(list);
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void initializeActivity()
    {
        submitView.setOnClickListener(new EuSubmitListener());
        if (isUSACompatible)
        {
            lastName.setImeOptions(6);
        }
    }

    protected boolean isCVVRequiredForSelectedCard()
    {
        if (isUSACompatible)
        {
            return creditCardOneLine.isCvvRequired();
        }
        return cvvView.getVisibility() == 0;
    }

    protected void loadPaymentMethods()
    {
        GetCountriesRetryAsyncTask getcountriesretryasynctask = new GetCountriesRetryAsyncTask();
        getcountriesretryasynctask.progressView(1);
        getcountriesretryasynctask.execute();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        storageOptIn = new CreditCardStorageOptInHandler(loggingUtils, getClass().getSimpleName(), channel.name(), storageConsentRequirements);
        storageChoice.setOnClickListener(new ConsentChangeListener());
        storageOptIn.doRestoreState(bundle, loginPrefs);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("country_key", currentCountryManager.getCurrentCountry().shortName);
        storageOptIn.doSaveState(bundle);
    }

    protected void renderUi(String s)
    {
        cpf = (EditText)findViewById(0x7f1000c1);
        final List creditCardList = currentCountryManager.getCurrentCountry().getCreditCards();
        int i;
        if (currentCountryManager.getCurrentCountry().isCanadaQuebec())
        {
            stateView.setVisibility(0);
            initializeStateSpinner(s);
        } else
        {
            stateView.setVisibility(8);
        }
        countryCodeView.setVisibility(8);
        streetNumberView.setVisibility(0);
        s = cpf;
        if (currentCountryManager.getCurrentCountry().isBrazil())
        {
            i = 0;
        } else
        {
            i = 8;
        }
        s.setVisibility(i);
        paymentMethodLayout.setVisibility(0);
        if (creditCardList != null)
        {
            loadPaymentMethodsFrom(getFilteredCreditCards(creditCardList));
        } else
        {
            paymentMethod.setEnabled(false);
            loadPaymentMethods();
        }
        paymentMethod.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {

            final EditCreditCardEu this$0;
            final List val$creditCardList;

            public void onItemSelected(AdapterView adapterview, View view, int j, long l)
            {
                boolean flag = false;
                if (creditCardList != null)
                {
                    adapterview = (CreditCard)creditCardList.get(j);
                    boolean flag1;
                    if (isUSACompatible)
                    {
                        creditCardOneLine.setCvvVisibility(((CreditCard) (adapterview)).requireCVV);
                        ((TextView)view).setTextColor(getResources().getColor(0x7f0e00a8));
                    } else
                    {
                        view = cvvView;
                        if (((CreditCard)creditCardList.get(j)).requireCVV)
                        {
                            j = 0;
                        } else
                        {
                            j = 8;
                        }
                        view.setVisibility(j);
                    }
                    flag1 = isLATAMAmex();
                    view = streetNumberView;
                    if (flag1)
                    {
                        j = 8;
                    } else
                    {
                        j = 0;
                    }
                    view.setVisibility(j);
                    view = addressView;
                    if (flag1)
                    {
                        j = postalCodeView.getId();
                    } else
                    {
                        j = streetNumberView.getId();
                    }
                    view.setNextFocusDownId(j);
                    if (storageOptIn.updateConsentForPaymentMethod(((CreditCard) (adapterview)).name))
                    {
                        adapterview = storageChoice;
                        if (storageOptIn.isConsentRequested())
                        {
                            j = ((flag) ? 1 : 0);
                        } else
                        {
                            j = 8;
                        }
                        adapterview.setVisibility(j);
                        storageChoice.setChecked(storageOptIn.hasStorageConsent());
                    }
                }
            }

            public void onNothingSelected(AdapterView adapterview)
            {
            }

            
            {
                this$0 = EditCreditCardEu.this;
                creditCardList = list;
                super();
            }
        });
    }

    protected void saveToPrefs(BillingRecord billingrecord)
    {
        super.saveToPrefs(billingrecord);
        storageOptIn.doSaveUserConsent(loginPrefs);
    }

    protected boolean valid()
    {
        for (Country country = currentCountryManager.getCurrentCountry(); staticSupportInfoService.getSupportInfo(country).numberBeforeStreet && staticSupportInfoService.getSupportInfo(country).postalCodeAfterCity && !super.validateBillingInfo() || !staticSupportInfoService.getSupportInfo(country).numberBeforeStreet && !staticSupportInfoService.getSupportInfo(country).postalCodeAfterCity && !validateBillingInfo() || staticSupportInfoService.getSupportInfo(country).numberBeforeStreet && !staticSupportInfoService.getSupportInfo(country).postalCodeAfterCity && !validateBillingInfoSpecial();)
        {
            return false;
        }

        return true;
    }

    protected boolean validateBillingInfo()
    {
        while (!validateFirstLastName() || !validatePaymentMethod() || !validateCreditCardInfo() || !validateExpirationDate() || !validateCPF() || !validateAddress() || !validateStreetNumber() || !validatePostalCode() || !validateCity()) 
        {
            return false;
        }
        return true;
    }

    protected boolean validateCreditCardInfo()
    {
        Object obj;
        if (isUSACompatible)
        {
            obj = creditCardOneLine.getCardNumber();
        } else
        {
            obj = cardNumberView.getText();
        }
        if (Strings.isEmpty(obj))
        {
            Toast.makeText(getApplicationContext(), 0x7f08016d, 0).show();
            return false;
        }
        if (isCVVRequiredForSelectedCard())
        {
            Object obj1;
            if (isUSACompatible)
            {
                obj1 = creditCardOneLine.getCvv();
            } else
            {
                obj1 = cvvView.getText();
            }
            if (Strings.isEmpty(obj1))
            {
                Toast.makeText(getApplicationContext(), 0x7f08018f, 0).show();
                return false;
            }
        }
        return true;
    }

    protected boolean validatePaymentMethod()
    {
        boolean flag1 = true;
        boolean flag = flag1;
        if (paymentMethodLayout.getVisibility() == 0)
        {
            flag = flag1;
            if (paymentMethod.getSelectedItemPosition() == -1)
            {
                Toast.makeText(getApplicationContext(), 0x7f080190, 1).show();
                flag = false;
            }
        }
        return flag;
    }





}
