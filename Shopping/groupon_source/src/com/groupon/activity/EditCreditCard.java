// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.groupon.component.creditcardscanner.CreditCardScanner;
import com.groupon.dogfood.DogfoodHelper;
import com.groupon.models.billingrecord.BillingRecord;
import com.groupon.models.billingrecord.BillingRecordContainer;
import com.groupon.models.country.Country;
import com.groupon.models.error.GrouponException;
import com.groupon.models.nst.CardScanClickExtraInfo;
import com.groupon.models.nst.ClickMetadata;
import com.groupon.service.core.AbTestService;
import com.groupon.service.core.UserManager;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.BillingRecordUtil;
import com.groupon.util.ContextUtils;
import com.groupon.util.DialogManager;
import com.groupon.util.ExpirationDatePickerDialog;
import com.groupon.util.Function1;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.util.LoggingUtils;
import com.groupon.util.ReturningFunction1;
import com.groupon.util.ZipCodeAutoComplete;
import com.groupon.view.CreditCardIconHelper;
import com.groupon.view.CreditCardOneLine;
import com.groupon.view.SpinnerButton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apmem.tools.layouts.FlowLayout;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity

public class EditCreditCard extends GrouponActivity
{
    private class DatePickerDialogOnDateSetListener
        implements android.app.DatePickerDialog.OnDateSetListener
    {

        final EditCreditCard this$0;

        public void onDateSet(DatePicker datepicker, int i, int j, int k)
        {
            expirationYear = i;
            expirationMonth = j + 1;
            datepicker = billingUtil.generateFormattedCardExpirationDate(expirationYear, expirationMonth);
            expirationDate.setText(datepicker);
        }

        private DatePickerDialogOnDateSetListener()
        {
            this$0 = EditCreditCard.this;
            super();
        }

    }

    private class ScanCardOnClickListener
        implements android.view.View.OnClickListener
    {

        final EditCreditCard this$0;

        public void onClick(View view)
        {
            mSuccessfulScan = false;
            try
            {
                creditCardScanner.startScannerActivity(EditCreditCard.this);
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                Toast.makeText(getApplicationContext(), 0x7f080295, 1).show();
            }
            logCreditCardVariantEvent();
        }

        private ScanCardOnClickListener()
        {
            this$0 = EditCreditCard.this;
            super();
        }

    }

    private class ShowExpirationDateDialogOnClickListener
        implements android.view.View.OnClickListener
    {

        final EditCreditCard this$0;

        public void onClick(View view)
        {
            dpd.show();
        }

        private ShowExpirationDateDialogOnClickListener()
        {
            this$0 = EditCreditCard.this;
            super();
        }

    }


    private static final String CARDIO_SCAN_VARIANT = "cardIO";
    protected static final String COUNTRY_CODE_KEY = "country_key";
    public static final String EXPIRATION_DATE = "expiration_date";
    private static final String JUMIO_SCAN_VARIANT = "jumio";
    public static final String MONTH = "month";
    protected static int PADDING_15 = 0;
    protected static int PADDING_20 = 0;
    public static final int REQUEST_CODE = 10102;
    private static final String SELECTED_DATE = "Selected Date: ";
    public static final String SELECT_EXPIRATION_DATE = "Select Expiration Date";
    public static final String STATES_RESOURCE_NAME = "shipping_state_";
    private static final String STATE_KEY = "state_key";
    public static final String YEAR = "year";
    String EDIT;
    private AbTestService abTestService;
    protected EditText accountNumber;
    protected EditText addressView;
    protected String availableCCPaymentMethodsForDeal[];
    protected EditText bankCode;
    protected EditText bic;
    String billingRecordAddressOne;
    String billingRecordCardNumber;
    String billingRecordCity;
    String billingRecordId;
    String billingRecordPostalCode;
    String billingRecordState;
    private BillingRecordUtil billingUtil;
    protected EditText cardNumberView;
    private Pattern cardRegex;
    String cartUUID;
    protected EditText cityView;
    protected Spinner countryCodeView;
    BillingRecord creditCard;
    LinearLayout creditCardDemographics;
    protected LinearLayout creditCardDemographicsContainer;
    protected FrameLayout creditCardIconContainer;
    protected CreditCardOneLine creditCardOneLine;
    private CreditCardScanner creditCardScanner;
    private CurrentCountryManager currentCountryManager;
    protected EditText cvvView;
    private android.app.DatePickerDialog.OnDateSetListener datePickerListener;
    String dealId;
    private DialogManager dialogManager;
    private DogfoodHelper dogfoodHelper;
    private ExpirationDatePickerDialog dpd;
    protected TextView expirationDate;
    protected int expirationMonth;
    protected int expirationYear;
    protected EditText firstName;
    protected EditText iban;
    protected LayoutInflater inflater;
    boolean isBillingRecord;
    protected boolean isUSACompatible;
    protected EditText issuerNumber;
    protected EditText lastName;
    private Logger logger;
    private LoggingUtils loggingUtils;
    protected ArraySharedPreferences loginPrefs;
    private String mScannedCardNumber;
    private boolean mSuccessfulScan;
    Intent next;
    TextView paymentInfoHeaderTitle;
    protected EditText postalCodeView;
    RelativeLayout scanCard;
    TextView secureConnectionView;
    protected Spinner stateView;
    protected EditText streetNumberView;
    protected SpinnerButton submitView;
    FlowLayout supportedPaymentIcons;
    TextView title;
    private UserManager userManager;
    private ZipCodeAutoComplete zipCodeAutoComplete;

    public EditCreditCard()
    {
        cardRegex = Pattern.compile("^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13})$");
    }

    private void createCardManualInteractionNSTLog()
    {
        String s;
        if (next != null && next.hasExtra("dealId"))
        {
            s = next.getStringExtra("dealId");
        } else
        {
            s = "";
        }
        logger.logClick("", "credit_card_manual_click", "checkout", s);
    }

    private void enableDemographicPickers(boolean flag)
    {
        cityView.setEnabled(flag);
        stateView.setEnabled(flag);
        countryCodeView.setEnabled(flag);
    }

    private List getSaveBillingRecordParams()
    {
        android.text.Editable editable = firstName.getText();
        android.text.Editable editable1 = lastName.getText();
        String s;
        String s1;
        int i;
        int j;
        if (isUSACompatible)
        {
            s = creditCardOneLine.getCardNumber().replaceAll("\\D", "");
        } else
        {
            s = Strings.toString(cardNumberView.getText()).replaceAll("\\D", "");
        }
        if (isUSACompatible)
        {
            i = creditCardOneLine.getExpirationMonth();
        } else
        {
            i = expirationMonth;
        }
        if (isUSACompatible)
        {
            j = creditCardOneLine.getExpirationYear();
        } else
        {
            j = expirationYear;
        }
        if (isUSACompatible)
        {
            s1 = creditCardOneLine.getCvv();
        } else
        {
            s1 = Strings.toString(cvvView.getText());
        }
        return new ArrayList(Arrays.asList(new Object[] {
            "first_name", editable, "last_name", editable1, "card_number", s, "month", Integer.valueOf(i), "year", Integer.valueOf(j), 
            "cvv", s1, "address1", Strings.toString(addressView.getText()), "city", Strings.toString(cityView.getText()), "state", Strings.toString(stateView.getSelectedItem()).toUpperCase(), "zip", Strings.toString(postalCodeView.getText()), 
            "country", Strings.toString(countryCodeView.getSelectedItem())
        }));
    }

    private List getUpdateBillingRecordParams()
    {
        android.text.Editable editable = firstName.getText();
        android.text.Editable editable1 = lastName.getText();
        Object obj;
        Object obj1;
        int i;
        int j;
        if (isUSACompatible)
        {
            obj = creditCardOneLine.getCardNumber().replaceAll("\\D", "");
        } else
        {
            obj = Strings.toString(cardNumberView.getText()).replaceAll("\\D", "");
        }
        if (isUSACompatible)
        {
            i = creditCardOneLine.getExpirationMonth();
        } else
        {
            i = expirationMonth;
        }
        if (isUSACompatible)
        {
            j = creditCardOneLine.getExpirationYear();
        } else
        {
            j = expirationYear;
        }
        if (isUSACompatible)
        {
            obj1 = creditCardOneLine.getCvv();
        } else
        {
            obj1 = Strings.toString(cvvView.getText());
        }
        obj1 = new ArrayList(Arrays.asList(new Object[] {
            "first_name", editable, "last_name", editable1, "card_number", obj, "month", Integer.valueOf(i), "year", Integer.valueOf(j), 
            "cvv", obj1, "address1", Strings.toString(addressView.getText()), "city", Strings.toString(cityView.getText()), "state", Strings.toString(stateView.getSelectedItem()).toUpperCase(), "zip", Strings.toString(postalCodeView.getText()), 
            "country", Strings.toString(countryCodeView.getSelectedItem())
        }));
        if (isUSACompatible)
        {
            obj = creditCardOneLine.getCardNumber();
        } else
        {
            obj = cardNumberView.getText();
        }
        if (!Strings.toString(obj).contains("****"))
        {
            if (isUSACompatible)
            {
                obj = creditCardOneLine.getCardNumber().replaceAll("\\D", "");
            } else
            {
                obj = cardNumberView.getText();
            }
            ((ArrayList) (obj1)).addAll(Arrays.asList(new String[] {
                "card_number", Strings.toString(obj).replaceAll("\\D", "")
            }));
        }
        return ((List) (obj1));
    }

    private void hideKeyboard(View view)
    {
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private boolean isCanadaSelected()
    {
        return countryCodeView != null && countryCodeView.getSelectedItem() != null && countryCodeView.getSelectedItem().toString().equalsIgnoreCase("ca");
    }

    private void logCardScanStatus(boolean flag)
    {
        String s;
        String s1;
        Logger logger1;
        if (abTestService.isVariantEnabled("cardScan1508", "cardIO"))
        {
            s = "cardIO";
        } else
        {
            s = "jumio";
        }
        logger1 = logger;
        if (flag)
        {
            s1 = "success";
        } else
        {
            s1 = "cancel";
        }
        logger1.logCardScanStatus("", s, s1, Logger.NULL_NST_FIELD);
    }

    private void setCreditCardLayoutView()
    {
        String s;
        int i;
        s = currentCountryManager.getCurrentCountry().shortName;
        Object obj;
        if (isUSACompatible)
        {
            obj = "_v3";
        } else
        {
            obj = "_v2";
        }
        i = ContextUtils.getIdentifier(this, (new StringBuilder()).append("credit_card_demographics_").append(s).append(((String) (obj))).toString(), "layout");
        if (i != 0) goto _L2; else goto _L1
_L1:
        obj = inflater;
        if (isUSACompatible)
        {
            i = 0x7f0300af;
        } else
        {
            i = 0x7f0300ae;
        }
        ((LayoutInflater) (obj)).inflate(i, creditCardDemographics);
_L4:
        obj = (TextView)creditCardDemographics.findViewById(0x7f1000c3);
        if (obj != null)
        {
            ((TextView) (obj)).setText(Strings.toString(((TextView) (obj)).getText()).toUpperCase());
        }
        return;
_L2:
        inflater.inflate(i, creditCardDemographics);
        if (Arrays.binarySearch(new String[] {
    "br", "ca_eu", "de", "fr", "pt", "uk"
}, s) < 0)
        {
            creditCardDemographics.findViewById(0x7f1001f4).setVisibility(0);
            creditCardDemographics.findViewById(0x7f1001ee).setVisibility(8);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void toggleCardScanButton(boolean flag)
    {
        if (scanCard != null && isCardScanAvailable())
        {
            RelativeLayout relativelayout = scanCard;
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            relativelayout.setVisibility(i);
            if (flag)
            {
                scanCard.setOnClickListener(new ScanCardOnClickListener());
            }
        }
    }

    protected transient void addViewPadding(int i, int j, int k, int l, View aview[])
    {
        int j1 = aview.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            View view = aview[i1];
            if (view != null)
            {
                view.setPadding(i, j, k, l);
            }
        }

    }

    protected String getActionBarTitle()
    {
        int i;
        if (currentCountryManager.getCurrentCountry().isBrazil())
        {
            i = 0x7f080115;
        } else
        {
            i = 0x7f080117;
        }
        return getString(i);
    }

    protected String getMonthAdapterPrompt()
    {
        return getString(0x7f08035a);
    }

    protected String[] getStringArray(String s, String s1)
    {
        int i = ContextUtils.getIdentifier(this, (new StringBuilder()).append(s).append(s1.toLowerCase()).toString(), "array");
        if (i > 0)
        {
            return getResources().getStringArray(i);
        } else
        {
            return null;
        }
    }

    protected int getTitleTextResId()
    {
        return 0x7f080047;
    }

    protected boolean handleBillingRecordException(Exception exception)
    {
        if (exception instanceof GrouponException)
        {
            Object obj = ((GrouponException)exception).mapErrorFieldToErrorList;
            if (obj != null && !((Map) (obj)).entrySet().isEmpty())
            {
                exception = new StringBuilder();
                exception.append(getResources().getString(0x7f080154));
                for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext();)
                {
                    Object obj1 = (java.util.Map.Entry)((Iterator) (obj)).next();
                    String s = (String)((java.util.Map.Entry) (obj1)).getKey();
                    obj1 = ((Collection)((java.util.Map.Entry) (obj1)).getValue()).iterator();
                    while (((Iterator) (obj1)).hasNext()) 
                    {
                        String s1 = (String)((Iterator) (obj1)).next();
                        exception.append('\n');
                        exception.append(s);
                        exception.append(": ");
                        exception.append(s1);
                    }
                }

                exception.append(".");
                exception = dialogManager.getDialogFragment(getResources().getString(0x7f080153), exception.toString());
                GrouponDialogFragment.show(getFragmentManager(), exception, "generic_error_dialog");
                return false;
            }
        }
        return true;
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setToolbarTitle(getActionBarTitle());
    }

    protected void initializeActivity()
    {
        countryCodeView.post(new Runnable() {

            final EditCreditCard this$0;

            public void run()
            {
                countryCodeView.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {

                    final _cls1 this$1;

                    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
                    {
                        adapterview = stateView;
                        if (isCanadaSelected())
                        {
                            i = 0x7f0802f1;
                        } else
                        {
                            i = 0x7f0803bf;
                        }
                        adapterview.setPromptId(i);
                        adapterview = postalCodeView;
                        if (isCanadaSelected())
                        {
                            i = 0x7f0802e1;
                        } else
                        {
                            i = 0x7f08042e;
                        }
                        adapterview.setHint(i);
                        adapterview = Strings.toString(countryCodeView.getSelectedItem());
                        initializeSpinner(stateView, getStringArray("shipping_state_", adapterview), null);
                    }

                    public void onNothingSelected(AdapterView adapterview)
                    {
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
            }

            
            {
                this$0 = EditCreditCard.this;
                super();
            }
        });
        submitView.setOnClickListener(new android.view.View.OnClickListener() {

            final EditCreditCard this$0;

            public void onClick(View view)
            {
                if (!valid())
                {
                    return;
                }
                if (mSuccessfulScan)
                {
                    if (isUSACompatible)
                    {
                        view = creditCardOneLine.getCardNumber();
                    } else
                    {
                        view = cardNumberView.getText();
                    }
                    if (!Strings.equals(view, mScannedCardNumber))
                    {
                        createCardManualInteractionNSTLog();
                    }
                }
                if (creditCard == null && !isBillingRecord)
                {
                    saveBillingRecord();
                } else
                {
                    updateBillingRecord();
                }
                logCreditCardVariantEvent();
            }

            
            {
                this$0 = EditCreditCard.this;
                super();
            }
        });
        if (isUSACompatible)
        {
            lastName.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

                final EditCreditCard this$0;

                public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
                {
                    if (i == 5)
                    {
                        creditCardOneLine.getCreditCardNumberView().requestFocus();
                    }
                    return false;
                }

            
            {
                this$0 = EditCreditCard.this;
                super();
            }
            });
        }
    }

    protected void initializeCountrySpinner(String s)
    {
        String as[] = getResources().getStringArray(0x7f0f0005);
        String as1[] = getResources().getStringArray(0x7f0f0002);
        initializeSpinner(countryCodeView, as1, as);
        int i = 0;
        do
        {
label0:
            {
                if (i < as1.length)
                {
                    if (!Strings.equalsIgnoreCase(s, as1[i]))
                    {
                        break label0;
                    }
                    countryCodeView.setSelection(i);
                }
                return;
            }
            i++;
        } while (true);
    }

    protected void initializeSpinner(Spinner spinner, String as[], String as1[])
    {
        if (spinner != null && as != null)
        {
            final int final_i;
            if (isUSACompatible)
            {
                final_i = 0x7f03020b;
            } else
            {
                final_i = 0x7f030209;
            }
            spinner.setAdapter(new ArrayAdapter(as, as1, as) {

                final EditCreditCard this$0;
                final String val$stringArray1[];
                final String val$stringArray2[];

                public View getDropDownView(int i, View view, ViewGroup viewgroup)
                {
                    if (view == null)
                    {
                        view = inflater.inflate(0x7f030207, null);
                    }
                    viewgroup = (TextView)(TextView)view;
                    if (stringArray2 != null)
                    {
                        view = stringArray2[i];
                    } else
                    {
                        view = stringArray1[i];
                    }
                    viewgroup.setText(view);
                    return viewgroup;
                }

            
            {
                this$0 = EditCreditCard.this;
                stringArray2 = as1;
                stringArray1 = as2;
                super(final_context, final_i, as);
            }
            });
        }
    }

    protected void initializeStateSpinner(String s)
    {
        initializeSpinner(stateView, getStringArray("shipping_state_", s), null);
        if (creditCard != null)
        {
            cityView.setText(creditCard.city);
            if (isUSACompatible)
            {
                creditCardOneLine.setCardNumber(creditCard.cardNumber);
            } else
            {
                cardNumberView.setText(creditCard.cardNumber);
            }
            addressView.setText(creditCard.streetAddress1);
            postalCodeView.setText(creditCard.postalCode);
            setSpinnerValue(stateView, creditCard.state.toUpperCase(), getStringArray("shipping_state_", s));
            submitView.setText(EDIT);
        } else
        if (isBillingRecord)
        {
            cityView.setText(billingRecordCity);
            if (isUSACompatible)
            {
                creditCardOneLine.setCardNumber(billingRecordCardNumber);
            } else
            {
                cardNumberView.setText(billingRecordCardNumber);
            }
            addressView.setText(billingRecordAddressOne);
            postalCodeView.setText(billingRecordPostalCode);
            setSpinnerValue(stateView, Strings.toString(billingRecordState).toUpperCase(), getStringArray("shipping_state_", s));
            submitView.setText(EDIT);
            return;
        }
    }

    protected boolean isCardScanAvailable()
    {
        return creditCardScanner.isOn() && !dogfoodHelper.isDogfood();
    }

    protected void logCreditCardVariantEvent()
    {
        loggingUtils.logClick("", "save_cc_info", getClass().getName(), dealId, cartUUID);
        ClickMetadata clickmetadata = new ClickMetadata();
        String s;
        CardScanClickExtraInfo cardscanclickextrainfo;
        if (next != null && next.hasExtra("dealId"))
        {
            s = next.getStringExtra("dealId");
        } else
        {
            s = "";
        }
        clickmetadata.dealId = s;
        cardscanclickextrainfo = new CardScanClickExtraInfo();
        if (abTestService.isVariantEnabled("cardScan1508", "cardIO"))
        {
            s = "cardIO";
        } else
        {
            s = "jumio";
        }
        cardscanclickextrainfo.cardScanMedium = s;
        logger.logClick("", "card_scan_click", "checkout", clickmetadata, cardscanclickextrainfo);
    }

    protected void logGeoCoderUserChanges()
    {
        if (cityView.getTag() != null)
        {
            zipCodeAutoComplete.logGeoCoderUserChangesCity(Strings.toString(cityView.getTag()), cityView.getText().toString());
            cityView.setTag(null);
        }
        if (stateView.getTag() != null)
        {
            zipCodeAutoComplete.logGeoCoderUserChangesState(Strings.toString(stateView.getTag()), Strings.toString(stateView.getSelectedItem()));
            stateView.setTag(null);
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        creditCardScanner.handleScanResult(this, i, j, intent);
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        loggingUtils.logClick("", "cancel_cc_info", getClass().getName(), dealId, cartUUID);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        isUSACompatible = currentCountryManager.getCurrentCountry().isUSACompatible();
        String s;
        int i;
        if (isUSACompatible)
        {
            i = 0x7f030022;
        } else
        {
            i = 0x7f030021;
        }
        setContentView(i);
        if (!isUSACompatible)
        {
            dogfoodHelper.logHideViewId(0x7f1000bb);
            dogfoodHelper.logHideViewId(0x7f1000b9);
            dogfoodHelper.logHideViewId(0x7f1000c0);
            dogfoodHelper.logHideViewId(0x7f1000b8);
            dogfoodHelper.logHideViewId(0x7f1000b4);
            dogfoodHelper.logHideViewId(0x7f1000b5);
            dogfoodHelper.logHideViewId(0x7f1000bb);
        }
        PADDING_15 = (int)TypedValue.applyDimension(1, 15F, getResources().getDisplayMetrics());
        PADDING_20 = (int)TypedValue.applyDimension(1, 20F, getResources().getDisplayMetrics());
        if (android.os.Build.VERSION.SDK_INT <= 19)
        {
            addViewPadding(PADDING_15, PADDING_15, PADDING_15, PADDING_15, new View[] {
                addressView, cityView, postalCodeView, streetNumberView, cardNumberView, cvvView, firstName, lastName, bankCode, iban, 
                bic, accountNumber, issuerNumber
            });
            if (creditCardOneLine != null)
            {
                addViewPadding(PADDING_15, 0, 0, 0, new View[] {
                    creditCardOneLine.creditCardOneLineLayout
                });
            }
            if (isUSACompatible)
            {
                addViewPadding(PADDING_20, 0, PADDING_20, 0, new View[] {
                    firstName, lastName, issuerNumber
                });
            }
        }
        s = Strings.toString(paymentInfoHeaderTitle.getText());
        paymentInfoHeaderTitle.setText(s);
        if (isUSACompatible)
        {
            addViewPadding(PADDING_15, 0, 0, 0, new View[] {
                creditCardIconContainer
            });
        }
        if (bundle != null && expirationMonth == 0 && expirationYear == 0)
        {
            expirationMonth = bundle.getInt("month");
            expirationYear = bundle.getInt("year");
        }
        if (!isUSACompatible)
        {
            datePickerListener = new DatePickerDialogOnDateSetListener();
            Object obj = Calendar.getInstance();
            if (expirationMonth == 0 && expirationYear == 0)
            {
                dpd = new ExpirationDatePickerDialog(this, datePickerListener, ((Calendar) (obj)).get(1), ((Calendar) (obj)).get(2), ((Calendar) (obj)).get(5));
                dpd.setTitle("Select Expiration Date");
            } else
            {
                dpd = new ExpirationDatePickerDialog(this, datePickerListener, expirationYear, expirationMonth - 1, ((Calendar) (obj)).get(5));
                obj = billingUtil.generateFormattedCardExpirationDate(expirationYear, expirationMonth);
                dpd.setTitle((new StringBuilder()).append("Selected Date: ").append(((String) (obj))).toString());
            }
            expirationDate.setOnClickListener(new ShowExpirationDateDialogOnClickListener());
        }
        submitView.setText(0x7f08033e);
        secureConnectionView.setVisibility(0);
        setUpBillingAddressSection(bundle);
        toggleCardScanButton(creditCardScanner.isOn());
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        if (stateView != null)
        {
            stateView.setSelection(bundle.getInt("state_key"));
            if (bundle.containsKey("edit_state"))
            {
                stateView.setTag(bundle.getString("edit_state"));
            }
        }
        if (cityView != null && bundle.containsKey("edit_city"))
        {
            cityView.setTag(bundle.getString("edit_city"));
        }
        if (expirationDate != null && bundle.containsKey("expiration_date"))
        {
            expirationDate.setText(bundle.getString("expiration_date"));
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (cityView != null && cityView.getTag() != null)
        {
            bundle.putString("edit_city", Strings.toString(cityView.getTag()));
        }
        if (stateView != null)
        {
            bundle.putInt("state_key", stateView.getSelectedItemPosition());
            if (stateView.getTag() != null)
            {
                bundle.putString("edit_state", Strings.toString(stateView.getTag()));
            }
        }
        if (countryCodeView != null)
        {
            bundle.putString("country_key", Strings.toString(countryCodeView.getSelectedItem()));
        }
        if (expirationDate != null && !Strings.isEmpty(expirationDate.getText()))
        {
            bundle.putString("expiration_date", expirationDate.getText().toString());
        }
        if (expirationYear != 0 && expirationMonth != 0)
        {
            bundle.putInt("year", expirationYear);
            bundle.putInt("month", expirationMonth);
        }
    }

    public void onScannerCanceled()
    {
        logCardScanStatus(false);
    }

    public void onScannerFinished(Map map)
    {
        boolean flag;
        int i;
        int j;
        flag = true;
        mSuccessfulScan = true;
        logCardScanStatus(true);
        mScannedCardNumber = (String)map.get("card_number");
        String s;
        String s1;
        if (isUSACompatible)
        {
            creditCardOneLine.setCardNumber(mScannedCardNumber);
            creditCardOneLine.setCvv((String)map.get("cvv_code"));
        } else
        {
            cardNumberView.setText(mScannedCardNumber);
            cvvView.setText((CharSequence)map.get("cvv_code"));
        }
        s = (String)map.get("expiry_date_month");
        s1 = (String)map.get("expiry_date_year");
        i = Integer.parseInt(s);
        j = Integer.parseInt(s1);
        if (i == 0 || j == 0)
        {
            flag = false;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        if (!isUSACompatible) goto _L4; else goto _L3
_L3:
        creditCardOneLine.setExpirationMonth(i);
        creditCardOneLine.setExpirationYear(j);
_L2:
        s = (String)map.get("first_name");
        map = (String)map.get("last_name");
        firstName.setText(s);
        lastName.setText(map);
        return;
_L4:
        try
        {
            expirationDate.setText((new StringBuilder()).append(i - 1).append("/").append(j).toString());
        }
        catch (NumberFormatException numberformatexception) { }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void onSdkInitialized()
    {
        toggleCardScanButton(true);
    }

    protected void renderUi(String s)
    {
        streetNumberView.setVisibility(8);
        initializeStateSpinner(s);
        initializeCountrySpinner(s);
    }

    protected void saveBillingRecord()
    {
        submitView.startSpinning();
        userManager.saveBillingRecord(null, getSaveBillingRecordParams(), new Function1() {

            final EditCreditCard this$0;

            public void execute(BillingRecordContainer billingrecordcontainer)
            {
                Toast.makeText(getApplicationContext(), 0x7f080053, 0).show();
                setResultAndSaveToPrefs(billingrecordcontainer.billingRecord);
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((BillingRecordContainer)obj);
            }

            
            {
                this$0 = EditCreditCard.this;
                super();
            }
        }, new ReturningFunction1() {

            final EditCreditCard this$0;

            public Boolean execute(Exception exception)
            {
                submitView.stopSpinning();
                return Boolean.valueOf(handleBillingRecordException(exception));
            }

            public volatile Object execute(Object obj)
                throws Exception
            {
                return execute((Exception)obj);
            }

            
            {
                this$0 = EditCreditCard.this;
                super();
            }
        }, null, null);
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
            billingrecord = "volatile";
        }
        ((com.groupon.util.ArraySharedPreferences.Editor) (obj)).putString("currentBillingRecordId", billingrecord).apply();
    }

    protected void setPaymentOptionIcons(List list)
    {
        if (!list.isEmpty())
        {
            supportedPaymentIcons.setVisibility(0);
            int i = 0;
            while (i < list.size()) 
            {
                Object obj = ((String)list.get(i)).toLowerCase();
                if (Strings.notEmpty(obj) && CreditCardIconHelper.supportedCardTypes.containsKey(obj))
                {
                    int j = ((Integer)CreditCardIconHelper.supportedCardTypes.get(obj)).intValue();
                    obj = new ImageView(this);
                    ((ImageView) (obj)).setImageResource(j);
                    ((ImageView) (obj)).setPadding((int)getResources().getDimension(0x7f0b0205), (int)getResources().getDimension(0x7f0b0207), (int)getResources().getDimension(0x7f0b0206), (int)getResources().getDimension(0x7f0b0204));
                    supportedPaymentIcons.addView(((View) (obj)));
                }
                i++;
            }
        }
    }

    protected void setResultAndSaveToPrefs(BillingRecord billingrecord)
    {
        saveToPrefs(billingrecord);
        setResult(-1);
        if (next != null)
        {
            getIntent().removeExtra("next");
            startActivity(next);
        }
        finish();
    }

    protected void setSpinnerValue(Spinner spinner, String s, String as[])
    {
        int i = 0;
        do
        {
label0:
            {
                if (i < as.length)
                {
                    if (!Strings.equalsIgnoreCase(s, as[i]))
                    {
                        break label0;
                    }
                    spinner.setSelection(i);
                }
                return;
            }
            i++;
        } while (true);
    }

    protected void setUpBillingAddressSection(Bundle bundle)
    {
        setCreditCardLayoutView();
        if (title != null)
        {
            title.setText(getTitleTextResId());
        }
        addressView = (EditText)findViewById(0x7f1000ba);
        cityView = (EditText)findViewById(0x7f1001f1);
        stateView = (Spinner)findViewById(0x7f1001f0);
        postalCodeView = (EditText)findViewById(0x7f1001f2);
        countryCodeView = (Spinner)findViewById(0x7f1001f3);
        streetNumberView = (EditText)findViewById(0x7f1001ef);
        if (android.os.Build.VERSION.SDK_INT <= 19)
        {
            addViewPadding(PADDING_15, PADDING_15, PADDING_15, PADDING_15, new View[] {
                addressView, cityView, postalCodeView, streetNumberView
            });
        }
        if (bundle != null && bundle.containsKey("country_key"))
        {
            bundle = bundle.getString("country_key");
        } else
        {
            bundle = currentCountryManager.getCurrentCountry().shortName;
        }
        renderUi(bundle);
        initializeActivity();
    }

    protected void updateBillingRecord()
    {
        String s;
        if (isBillingRecord)
        {
            s = billingRecordId;
        } else
        {
            s = creditCard.id;
        }
        userManager.updateBillingRecord(s, submitView, getUpdateBillingRecordParams(), new Function1() {

            final EditCreditCard this$0;

            public void execute(BillingRecordContainer billingrecordcontainer)
            {
                Toast.makeText(getApplicationContext(), 0x7f080142, 0).show();
                setResultAndSaveToPrefs(billingrecordcontainer.billingRecord);
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((BillingRecordContainer)obj);
            }

            
            {
                this$0 = EditCreditCard.this;
                super();
            }
        }, new ReturningFunction1() {

            final EditCreditCard this$0;

            public Boolean execute(Exception exception)
            {
                if (exception instanceof GrouponException)
                {
                    exception = dialogManager.getDialogFragment(exception.getMessage().replaceFirst("^(\\w+)\\W+([A-Z].*)$", "$2"));
                    GrouponDialogFragment.show(getFragmentManager(), exception, "generic_error_dialog");
                    return Boolean.valueOf(false);
                } else
                {
                    return Boolean.valueOf(true);
                }
            }

            public volatile Object execute(Object obj)
                throws Exception
            {
                return execute((Exception)obj);
            }

            
            {
                this$0 = EditCreditCard.this;
                super();
            }
        }, null, null);
    }

    protected boolean valid()
    {
        return validateBillingInfo();
    }

    protected boolean validateAddress()
    {
        boolean flag = true;
        if (Strings.isEmpty(addressView.getText()))
        {
            Toast.makeText(getApplicationContext(), 0x7f08016a, 1).show();
            flag = false;
        }
        return flag;
    }

    protected boolean validateBillingInfo()
    {
        return validateFirstLastName() && validatePaymentMethod() && validateCreditCardInfo() && validateExpirationDate() && validateStreetNumber() && validateAddress() && validateCity() && validatePostalCode();
    }

    protected boolean validateCity()
    {
        if (Strings.isEmpty(cityView.getText()))
        {
            Toast.makeText(getApplicationContext(), 0x7f08016e, 0).show();
            return false;
        } else
        {
            return true;
        }
    }

    protected boolean validateCreditCardInfo()
    {
        Object obj3;
label0:
        {
            obj3 = cardRegex;
            Object obj;
            if (isUSACompatible)
            {
                obj = creditCardOneLine.getCardNumber();
            } else
            {
                obj = Strings.toString(cardNumberView.getText()).replaceAll("\\D", "");
            }
            obj3 = ((Pattern) (obj3)).matcher(((CharSequence) (obj)));
            if (isUSACompatible)
            {
                obj = creditCardOneLine.getCardNumber();
            } else
            {
                obj = cardNumberView.getText();
            }
            if (!Strings.isEmpty(obj))
            {
                if (isUSACompatible)
                {
                    obj = creditCardOneLine.getCardNumber();
                } else
                {
                    obj = cardNumberView.getText();
                }
                if (Strings.toString(obj).contains("****") && creditCard != null || ((Matcher) (obj3)).matches())
                {
                    break label0;
                }
            }
            Toast.makeText(getApplicationContext(), 0x7f08016d, 0).show();
            return false;
        }
label1:
        {
            Object obj1;
            if (isUSACompatible)
            {
                obj1 = creditCardOneLine.getCardNumber();
            } else
            {
                obj1 = cardNumberView.getText();
            }
            if (!Strings.isEmpty(obj1))
            {
                if (isUSACompatible)
                {
                    obj1 = creditCardOneLine.getCardNumber();
                } else
                {
                    obj1 = cardNumberView.getText();
                }
                if (Strings.toString(obj1).contains("****") && isBillingRecord || ((Matcher) (obj3)).matches())
                {
                    break label1;
                }
            }
            Toast.makeText(getApplicationContext(), 0x7f08016d, 0).show();
            return false;
        }
        Object obj2;
        if (isUSACompatible)
        {
            obj2 = creditCardOneLine.getCvv();
        } else
        {
            obj2 = cvvView.getText();
        }
        if (Strings.isEmpty(obj2))
        {
            Toast.makeText(getApplicationContext(), 0x7f08018f, 0).show();
            return false;
        } else
        {
            return true;
        }
    }

    protected boolean validateExpirationDate()
    {
        boolean flag1 = true;
        int i;
        boolean flag;
        if (isUSACompatible)
        {
            i = creditCardOneLine.getExpirationYear();
        } else
        if (expirationYear != -1)
        {
            i = Integer.valueOf(expirationYear).intValue();
        } else
        {
            i = Calendar.getInstance().get(1);
        }
        if (!isUSACompatible && expirationMonth == -1 || isUSACompatible && !creditCardOneLine.isExpirationMonthValid())
        {
            Context context = getApplicationContext();
            if (isUSACompatible)
            {
                i = 0x7f080174;
            } else
            {
                i = 0x7f080172;
            }
            Toast.makeText(context, i, 0).show();
            flag = false;
        } else
        {
            int j;
            if (isUSACompatible)
            {
                j = creditCardOneLine.getExpirationMonth() - 1;
            } else
            {
                j = expirationMonth - 1;
            }
            flag = flag1;
            if (j < Calendar.getInstance().get(2))
            {
                flag = flag1;
                if (i == Calendar.getInstance().get(1))
                {
                    Toast.makeText(getApplicationContext(), 0x7f080173, 0).show();
                    return false;
                }
            }
        }
        return flag;
    }

    protected boolean validateFirstLastName()
    {
        if (Strings.isEmpty(firstName.getText()))
        {
            Toast.makeText(getApplicationContext(), 0x7f080176, 1).show();
            return false;
        }
        if (Strings.isEmpty(lastName.getText()))
        {
            Toast.makeText(getApplicationContext(), 0x7f080179, 1).show();
            return false;
        } else
        {
            return true;
        }
    }

    protected boolean validatePaymentMethod()
    {
        return true;
    }

    protected boolean validatePostalCode()
    {
        if (Strings.isEmpty(postalCodeView.getText()))
        {
            Toast.makeText(getApplicationContext(), 0x7f080181, 0).show();
            return false;
        } else
        {
            return true;
        }
    }

    protected boolean validateStreetNumber()
    {
        if (streetNumberView.getVisibility() == 0 && Strings.isEmpty(streetNumberView.getText()))
        {
            Toast.makeText(getApplicationContext(), 0x7f080186, 0).show();
            return false;
        } else
        {
            return true;
        }
    }





/*
    static boolean access$402(EditCreditCard editcreditcard, boolean flag)
    {
        editcreditcard.mSuccessfulScan = flag;
        return flag;
    }

*/





}
