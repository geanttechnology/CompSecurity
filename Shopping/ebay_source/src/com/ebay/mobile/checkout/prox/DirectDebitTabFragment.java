// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.prox;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.ebay.app.DatePickerDialogFragment;
import com.ebay.common.Preferences;
import com.ebay.common.view.util.DialogManager;
import com.ebay.common.view.util.EbayCountryManager;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseFragment;
import com.ebay.mobile.activities.PreferredCountryActivity;
import com.ebay.mobile.checkout.BaseCheckoutActivity;
import com.ebay.mobile.common.EbayUtil;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.data.BillingAddress;
import com.ebay.nautilus.domain.data.DirectDebit;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.checkout.prox:
//            DirectDebitActivity, ProxHelper

public class DirectDebitTabFragment extends BaseFragment
    implements android.app.DatePickerDialog.OnDateSetListener, android.widget.TextView.OnEditorActionListener
{
    public final class AccountNumberChangeListener extends CreditCardActivity.CreditTextWatcher
    {

        final DirectDebitTabFragment this$0;

        public void afterTextChanged(Editable editable)
        {
            if (watchedView != null && editable == watchedView.getText())
            {
                editable = editable.toString();
                break MISSING_BLOCK_LABEL_23;
            }
            do
            {
                return;
            } while (TextUtils.isEmpty(editable) || editable.length() != 10);
            watchedView.setTextColor(baseColor);
            requestFocusIfNotMasked(bankCode);
        }

        public AccountNumberChangeListener(EditText edittext)
        {
            this$0 = DirectDebitTabFragment.this;
            super(edittext);
        }
    }

    public final class BankCodeChangeListener extends CreditCardActivity.CreditTextWatcher
    {

        final DirectDebitTabFragment this$0;

        public void afterTextChanged(Editable editable)
        {
label0:
            {
                if (watchedView != null && editable == watchedView.getText())
                {
                    editable = editable.toString();
                    if (!TextUtils.isEmpty(editable))
                    {
                        break label0;
                    }
                }
                return;
            }
            if (editable.length() == 8)
            {
                watchedView.setTextColor(baseColor);
                openDateDialog();
                return;
            } else
            {
                watchedView.setTextColor(errorColor);
                return;
            }
        }

        public BankCodeChangeListener(EditText edittext)
        {
            this$0 = DirectDebitTabFragment.this;
            super(edittext);
        }
    }

    static interface EditDataListener
    {

        public abstract void onClearMaskedFields();

        public abstract void onReadyToReceiveEditData();
    }

    public final class IbanNumberChangeListener extends CreditCardActivity.CreditTextWatcher
    {

        final DirectDebitTabFragment this$0;

        public void afterTextChanged(Editable editable)
        {
label0:
            {
                if (watchedView != null && editable == watchedView.getText())
                {
                    editable = editable.toString();
                    if (!TextUtils.isEmpty(editable))
                    {
                        break label0;
                    }
                }
                return;
            }
            if (editable.length() >= 2)
            {
                ibanNumber.setInputType(2);
            } else
            {
                ibanNumber.setInputType(1);
            }
            safeSetTextAfterTextChanged(editable.toUpperCase(Locale.getDefault()));
            if (editable.length() == 22 && DirectDebit.validateMod97Checksum(editable))
            {
                watchedView.setTextColor(baseColor);
                requestFocusIfNotMasked(bankAccountName);
                return;
            } else
            {
                watchedView.setTextColor(errorColor);
                return;
            }
        }

        public IbanNumberChangeListener(EditText edittext)
        {
            this$0 = DirectDebitTabFragment.this;
            super(edittext);
        }
    }


    private static final int ACCOUNT_NUMBER_MAX_DIGITS = 10;
    private static final int ACTIVITY_RESULT_BILLING_COUNTRY = 919;
    private static final int ACTIVITY_RESULT_DATE_OF_BIRTH = 920;
    private static final int BANK_CODE_REQUIRED_LENGTH = 8;
    private static final String EXTRA_ACCOUNT_NUMBER = "accountNumber";
    private static final String EXTRA_ADDRESS_CITY = "addressCity";
    private static final String EXTRA_ADDRESS_COUNTRY = "addressCountry";
    private static final String EXTRA_ADDRESS_COUNTRY_TAG = "addressCountryTag";
    private static final String EXTRA_ADDRESS_LINE_1 = "addressLine1";
    private static final String EXTRA_ADDRESS_LINE_2 = "addressLine2";
    private static final String EXTRA_ADDRESS_POSTAL_CODE = "addressPostalCode";
    private static final String EXTRA_ADDRESS_STATE = "addressState";
    private static final String EXTRA_BANK_CODE = "bankNumber";
    private static final String EXTRA_CARDHOLDER_NAME = "cardholderName";
    private static final String EXTRA_DATE_OF_BIRTH = "dob";
    private static final String EXTRA_IBAN_NUMBER = "ibanNumber";
    public static final String EXTRA_TAB_INDEX = "com.ebay.mobile.checkout.prox.DirectDebitTabFragment.tabIndex";
    private static final int IBAN_REQUIRED_LENGTH = 22;
    private static final int MINIMUM_AGE_IN_YEARS = 18;
    public static final int TAB_ACCOUNT = 0;
    public static final int TAB_IBAN = 1;
    private EditText accountNumber;
    private AccountNumberChangeListener accountNumberChangeListener;
    private EditText addressCity;
    private TextView addressCountry;
    private EditText addressLine1;
    private EditText addressLine2;
    private EditText addressPostalCode;
    private Spinner addressState;
    private EditText bankAccountName;
    private EditText bankCode;
    private BankCodeChangeListener bankCodeChangeListener;
    private TextView dob;
    private EditText ibanNumber;
    private IbanNumberChangeListener ibanNumberChangeListener;
    private Calendar minimumDateOfBirth;
    private int tabIndex;

    public DirectDebitTabFragment()
    {
    }

    private void addFundingInstrumentFromFormData()
    {
        DirectDebit directdebit = new DirectDebit();
        tabIndex;
        JVM INSTR tableswitch 0 1: default 36
    //                   0 138
    //                   1 172;
           goto _L1 _L2 _L3
_L1:
        java.util.Date date = null;
        java.util.Date date1 = DateFormat.getDateFormat(getActivity()).parse(dob.getText().toString());
        date = date1;
_L4:
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        directdebit.dateOfBirth = DateFormat.format("MM/dd/yyyy", calendar.getTime()).toString();
        directdebit.accountHolderName = bankAccountName.getText().toString().trim();
        directdebit.billingAddress = getBillingAddressFromFormData();
        directdebit.billingAddress.setFirstLastNameFromFullNameString(directdebit.accountHolderName);
        ((BaseCheckoutActivity)getActivity()).apiAddDirectDebit(directdebit);
        return;
_L2:
        directdebit.bankAccountNumber = new com.ebay.nautilus.domain.data.DirectDebit.Bban(accountNumber.getText().toString(), bankCode.getText().toString());
          goto _L1
_L3:
        directdebit.internationalBankAccountNumber = new com.ebay.nautilus.domain.data.DirectDebit.Iban(ibanNumber.getText().toString());
          goto _L1
        ParseException parseexception;
        parseexception;
          goto _L4
    }

    private void clearBulletedFieldsToNullOnFocus(View view)
    {
        int i = view.getId();
        if (i == 0x7f10051e || i == 0x7f10051b || i == 0x7f100519)
        {
            ((DirectDebitActivity)getActivity()).onClearMaskedFields();
        }
    }

    private BillingAddress getBillingAddressFromFormData()
    {
        BillingAddress billingaddress = new BillingAddress();
        EbayCountry ebaycountry = (EbayCountry)addressCountry.getTag();
        if (ebaycountry != null)
        {
            billingaddress.countryCode = ebaycountry.getCountryCode();
        }
        if (addressCity.length() > 0)
        {
            billingaddress.city = addressCity.getText().toString();
        }
        if (addressLine1.length() > 0)
        {
            billingaddress.streetAddress = addressLine1.getText().toString();
        }
        if (addressLine2.length() > 0)
        {
            billingaddress.streetAddress2 = addressLine2.getText().toString();
        }
        if (addressState.getVisibility() == 0)
        {
            billingaddress.state = (String)addressState.getSelectedItem();
        }
        if (addressPostalCode.length() > 0)
        {
            billingaddress.postalCode = addressPostalCode.getText().toString();
        }
        return billingaddress;
    }

    private void openDateDialog()
    {
        com.ebay.app.DatePickerDialogFragment.Builder builder = new com.ebay.app.DatePickerDialogFragment.Builder();
        Object obj = Calendar.getInstance();
        ((Calendar) (obj)).add(1, -18);
        Object obj1 = ((TextView)getView().findViewById(0x7f10051d)).getText();
        if (obj1 != null && !TextUtils.isEmpty(obj1.toString()))
        {
            try
            {
                obj = DateFormat.getDateFormat(getActivity()).parse(obj1.toString());
                obj1 = Calendar.getInstance();
                ((Calendar) (obj1)).setTime(((java.util.Date) (obj)));
                builder.setYear(((Calendar) (obj1)).get(1));
                builder.setMonth(((Calendar) (obj1)).get(2));
                builder.setDay(((Calendar) (obj1)).get(5));
            }
            catch (ParseException parseexception) { }
        } else
        {
            builder.setYear(((Calendar) (obj)).get(1));
            builder.setMonth(((Calendar) (obj)).get(2));
            builder.setDay(((Calendar) (obj)).get(5));
        }
        builder.createFromFragment(920, this).show(getFragmentManager(), "dateOfBirthPicker");
    }

    private void requestFocusIfNotMasked(TextView textview)
    {
        while (ibanNumber.getText().toString().contains("\u2022") || accountNumber.getText().toString().contains("\u2022") || bankCode.getText().toString().contains("\u2022")) 
        {
            return;
        }
        textview.requestFocus();
    }

    private void updateFundingInstrumentFromFormData()
    {
        DirectDebitActivity directdebitactivity = (DirectDebitActivity)getActivity();
        DirectDebit directdebit1 = directdebitactivity.directDebit;
        DirectDebit directdebit = new DirectDebit();
        directdebit.accountHolderName = bankAccountName.getText().toString().trim();
        directdebit.billingAddress = getBillingAddressFromFormData();
        directdebit.billingAddress.setFirstLastNameFromFullNameString(directdebit.accountHolderName);
        if (directdebit.billingAddress.equals(directdebit1.billingAddress) && directdebit.accountHolderName.equals(directdebit1.accountHolderName))
        {
            directdebitactivity.finish();
            return;
        } else
        {
            BaseCheckoutActivity basecheckoutactivity = (BaseCheckoutActivity)getActivity();
            basecheckoutactivity.apiUpdateDirectDebit(basecheckoutactivity.temporaryFundingInstrumentId, directdebit);
            return;
        }
    }

    private boolean validateForm(boolean flag)
    {
        boolean flag1;
        boolean flag2;
        boolean flag3;
        flag3 = true;
        flag2 = true;
        flag1 = flag2;
        if (flag) goto _L2; else goto _L1
_L1:
        tabIndex;
        JVM INSTR tableswitch 0 1: default 40
    //                   0 205
    //                   1 239;
           goto _L3 _L4 _L5
_L3:
        flag1 = flag2;
_L2:
        if (addressCountry.length() == 0)
        {
            flag1 = false;
        }
        flag = flag1;
        if (addressLine1.length() == 0)
        {
            flag = false;
        }
        if (addressCity.length() == 0)
        {
            flag = false;
        }
        flag1 = flag;
        if (getView().findViewById(0x7f100508).getVisibility() == 0)
        {
            flag1 = flag;
            if (addressState.getSelectedItem() == null)
            {
                flag1 = false;
            }
        }
        flag = flag1;
        if (addressPostalCode.length() == 0)
        {
            flag = false;
        }
        if (bankAccountName.length() == 0 || bankAccountName.getText().toString().trim().length() == 0)
        {
            flag = false;
        }
        try
        {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(DateFormat.getDateFormat(getActivity()).parse(dob.getText().toString()));
            flag1 = calendar.after(minimumDateOfBirth);
        }
        catch (ParseException parseexception)
        {
            return false;
        }
        if (flag1)
        {
            flag = false;
        }
        return flag;
_L4:
        flag1 = flag3;
        if (accountNumber.length() < 8)
        {
            flag1 = false;
        }
        if (bankCode.length() != 8)
        {
            flag1 = false;
        }
          goto _L2
_L5:
        if (ibanNumber.length() != 22) goto _L7; else goto _L6
_L6:
        flag1 = flag2;
        if (DirectDebit.validateMod97Checksum(ibanNumber.getText().toString())) goto _L2; else goto _L7
_L7:
        flag1 = false;
          goto _L2
    }

    void addOrUpdateFundingInstrumentFromFormData()
    {
        DirectDebitActivity directdebitactivity = (DirectDebitActivity)getActivity();
        if (directdebitactivity.temporaryFundingInstrumentId == null) goto _L2; else goto _L1
_L1:
        tabIndex;
        JVM INSTR tableswitch 0 1: default 40
    //                   0 41
    //                   1 73;
           goto _L3 _L4 _L5
_L3:
        return;
_L4:
        if (!accountNumber.getText().toString().contains("\u2022") || !validateForm(true)) goto _L3; else goto _L6
_L6:
        updateFundingInstrumentFromFormData();
        return;
_L5:
        if (!ibanNumber.getText().toString().contains("\u2022") || !validateForm(true)) goto _L3; else goto _L7
_L7:
        updateFundingInstrumentFromFormData();
        return;
_L2:
        if (!validateForm(false))
        {
            directdebitactivity.dialogManager.showDynamicAlertDialog(getString(0x7f070130), getString(0x7f0707e3), false);
            return;
        } else
        {
            addFundingInstrumentFromFormData();
            return;
        }
    }

    protected void clearMaskedFields()
    {
        ibanNumber.setText(null);
        accountNumber.setText(null);
        bankCode.setText(null);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (bundle != null)
        {
            ibanNumber.setText(bundle.getString("ibanNumber", ""));
            accountNumber.setText(bundle.getString("accountNumber", ""));
            bankCode.setText(bundle.getString("bankNumber", ""));
            dob.setText(bundle.getString("dob", ""));
            bankAccountName.setText(bundle.getString("cardholderName", ""));
            addressCountry.setText(bundle.getString("addressCountry", ""));
            EbayCountry ebaycountry = (EbayCountry)bundle.getParcelable("addressCountryTag");
            addressCountry.setTag(ebaycountry);
            addressLine1.setText(bundle.getString("addressLine1", ""));
            addressLine2.setText(bundle.getString("addressLine2", ""));
            addressCity.setText(bundle.getString("addressCity", ""));
            addressPostalCode.setText(bundle.getString("addressPostalCode", ""));
            bundle = bundle.getString("addressState", "");
            ProxHelper.updateInputFormForCountry(getActivity(), getView(), ebaycountry, bundle);
        }
        bundle = new android.view.View.OnFocusChangeListener() {

            final DirectDebitTabFragment this$0;

            public void onFocusChange(View view, boolean flag)
            {
                if (flag)
                {
                    clearBulletedFieldsToNullOnFocus(view);
                    getActivity().getWindow().setSoftInputMode(5);
                }
            }

            
            {
                this$0 = DirectDebitTabFragment.this;
                super();
            }
        };
        ibanNumber.setOnFocusChangeListener(bundle);
        accountNumber.setOnFocusChangeListener(bundle);
        bankCode.setOnFocusChangeListener(bundle);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        i;
        JVM INSTR tableswitch 919 919: default 20
    //                   919 21;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (j == -1 && (intent = (EbayCountry)intent.getParcelableExtra("extraCountry")) != null)
        {
            addressCountry.setText(EbayCountryManager.getCountryWithLanguageName(getResources(), intent));
            addressCountry.setTag(intent);
            ProxHelper.updateInputFormForCountry(getActivity(), getView(), intent, null);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        tabIndex = getArguments().getInt("com.ebay.mobile.checkout.prox.DirectDebitTabFragment.tabIndex");
        setRetainInstance(false);
    }

    public View onCreateView(LayoutInflater layoutinflater, final ViewGroup shippingAddress, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f0301b2, shippingAddress, false);
        ibanNumber = (EditText)layoutinflater.findViewById(0x7f10051e);
        accountNumber = (EditText)layoutinflater.findViewById(0x7f100519);
        bankCode = (EditText)layoutinflater.findViewById(0x7f10051b);
        dob = (TextView)layoutinflater.findViewById(0x7f10051d);
        bankAccountName = (EditText)layoutinflater.findViewById(0x7f100521);
        addressCountry = (TextView)layoutinflater.findViewById(0x7f100500);
        addressLine1 = (EditText)layoutinflater.findViewById(0x7f100503);
        addressLine2 = (EditText)layoutinflater.findViewById(0x7f100504);
        addressCity = (EditText)layoutinflater.findViewById(0x7f100505);
        addressState = (Spinner)layoutinflater.findViewById(0x7f100506);
        addressPostalCode = (EditText)layoutinflater.findViewById(0x7f100509);
        tabIndex;
        JVM INSTR tableswitch 0 1: default 188
    //                   0 538
    //                   1 562;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_562;
_L4:
        shippingAddress = ((BaseCheckoutActivity)getActivity()).getDefaultShippingAddress();
        if (shippingAddress != null && ((Address) (shippingAddress)).addressFields != null)
        {
            bundle = ((Address) (shippingAddress)).addressFields;
            EbayCountry ebaycountry = EbayCountry.getInstance(((com.ebay.nautilus.domain.data.Address.AddressFields) (bundle)).country);
            addressCountry.setText(EbayCountryManager.getCountryWithLanguageName(getResources(), ebaycountry));
            addressCountry.setTag(ebaycountry);
            ProxHelper.updateInputFormForCountry(getActivity(), layoutinflater, ebaycountry, ((com.ebay.nautilus.domain.data.Address.AddressFields) (bundle)).stateOrProvince);
            addressLine1.setText(((com.ebay.nautilus.domain.data.Address.AddressFields) (bundle)).street1);
            addressLine2.setText(((com.ebay.nautilus.domain.data.Address.AddressFields) (bundle)).street2);
            addressCity.setText(((com.ebay.nautilus.domain.data.Address.AddressFields) (bundle)).city);
            addressPostalCode.setText(((com.ebay.nautilus.domain.data.Address.AddressFields) (bundle)).postalCode);
        }
        addressCountry.setOnClickListener(new android.view.View.OnClickListener() {

            final DirectDebitTabFragment this$0;
            final Address val$shippingAddress;

            public void onClick(View view)
            {
                view = new Intent(getActivity(), com/ebay/mobile/activities/PreferredCountryActivity);
                view.putExtra("extraCountry", EbayCountry.getInstance(shippingAddress.addressFields.country));
                startActivityForResult(view, 919);
            }

            
            {
                this$0 = DirectDebitTabFragment.this;
                shippingAddress = address;
                super();
            }
        });
        if (bankCode != null)
        {
            bankCode.setOnEditorActionListener(this);
        }
        if (dob != null)
        {
            dob.setOnClickListener(new android.view.View.OnClickListener() {

                final DirectDebitTabFragment this$0;

                public void onClick(View view)
                {
                    openDateDialog();
                }

            
            {
                this$0 = DirectDebitTabFragment.this;
                super();
            }
            });
        }
        shippingAddress = (TextView)layoutinflater.findViewById(0x7f100523);
        bundle = com.ebay.common.view.util.EbayCountryManager.Default.payPalGuestCheckoutTnCUrl(MyApp.getPrefs().getCurrentCountry());
        if (bundle != null)
        {
            shippingAddress.setText(EbayUtil.removeUnderlinesFromHtmlLinks(getString(0x7f0700a0, new Object[] {
                bundle
            })));
            shippingAddress.setMovementMethod(LinkMovementMethod.getInstance());
            shippingAddress.setVisibility(0);
        } else
        {
            shippingAddress.setVisibility(8);
        }
        accountNumberChangeListener = new AccountNumberChangeListener(accountNumber);
        bankCodeChangeListener = new BankCodeChangeListener(bankCode);
        ibanNumberChangeListener = new IbanNumberChangeListener(ibanNumber);
        minimumDateOfBirth = Calendar.getInstance();
        minimumDateOfBirth.set(13, 0);
        minimumDateOfBirth.set(12, 0);
        minimumDateOfBirth.set(10, 0);
        minimumDateOfBirth.set(14, 1);
        minimumDateOfBirth.add(1, -18);
        layoutinflater.findViewById(0x7f100502).setVisibility(8);
        return layoutinflater;
_L2:
        ibanNumber.setVisibility(8);
        layoutinflater.findViewById(0x7f10051f).setVisibility(8);
          goto _L4
        accountNumber.setVisibility(8);
        bankCode.setVisibility(8);
        layoutinflater.findViewById(0x7f10051a).setVisibility(8);
        layoutinflater.findViewById(0x7f10051c).setVisibility(8);
          goto _L4
    }

    public void onDateSet(DatePicker datepicker, int i, int j, int k)
    {
        datepicker = (TextView)getView().findViewById(0x7f10051d);
        if (datepicker != null)
        {
            Calendar calendar = Calendar.getInstance();
            calendar.clear();
            calendar.set(i, j, k);
            if (calendar.before(minimumDateOfBirth))
            {
                i = getResources().getColor(0x7f0d00dd);
            } else
            {
                i = getResources().getColor(0x7f0d00f0);
            }
            datepicker.setTextColor(i);
            datepicker.setText(DateFormat.getDateFormat(getActivity()).format(calendar.getTime()));
            requestFocusIfNotMasked(bankAccountName);
        }
    }

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        while (textview != bankCode || i != 5) 
        {
            return false;
        }
        openDateDialog();
        return true;
    }

    public void onPause()
    {
        super.onPause();
        if (accountNumber != null)
        {
            accountNumber.removeTextChangedListener(accountNumberChangeListener);
        }
        if (bankCode != null)
        {
            bankCode.removeTextChangedListener(bankCodeChangeListener);
        }
        if (ibanNumber != null)
        {
            ibanNumber.removeTextChangedListener(ibanNumberChangeListener);
        }
    }

    public void onResume()
    {
        super.onResume();
        if (accountNumber != null)
        {
            accountNumber.addTextChangedListener(accountNumberChangeListener);
        }
        if (bankCode != null)
        {
            bankCode.addTextChangedListener(bankCodeChangeListener);
        }
        if (ibanNumber != null)
        {
            ibanNumber.addTextChangedListener(ibanNumberChangeListener);
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("ibanNumber", ibanNumber.getText().toString());
        bundle.putString("accountNumber", accountNumber.getText().toString());
        bundle.putString("bankNumber", bankCode.getText().toString());
        bundle.putString("dob", dob.getText().toString());
        bundle.putString("cardholderName", bankAccountName.getText().toString());
        bundle.putString("addressCountry", addressCountry.getText().toString());
        bundle.putParcelable("addressCountryTag", (EbayCountry)addressCountry.getTag());
        bundle.putString("addressLine1", addressLine1.getText().toString());
        bundle.putString("addressLine2", addressLine2.getText().toString());
        bundle.putString("addressCity", addressCity.getText().toString());
        bundle.putString("addressState", (String)addressState.getSelectedItem());
        bundle.putString("addressPostalCode", addressPostalCode.getText().toString());
    }

    public void onStart()
    {
        super.onStart();
        ((DirectDebitActivity)getActivity()).onReadyToReceiveEditData();
    }

    void updateFormWithDirectDebit(DirectDebit directdebit)
    {
        if (directdebit == null) goto _L2; else goto _L1
_L1:
        int i;
        Object obj;
        if (directdebit.isIban())
        {
            ibanNumber.setText(DirectDebit.getMaskedNumber(directdebit.internationalBankAccountNumber.ibanAccountNumber, directdebit.internationalBankAccountNumber.cardNumberLastFour, 22));
        } else
        {
            accountNumber.setText(DirectDebit.getMaskedNumber(directdebit.bankAccountNumber.accountNumber, directdebit.bankAccountNumber.cardNumberLastFour, 10));
            bankCode.setText(directdebit.bankAccountNumber.routingNumber);
        }
        dob.setText(directdebit.dateOfBirth);
        obj = EbayCountry.getInstance(directdebit.billingAddress.countryCode);
        addressCountry.setText(EbayCountryManager.getCountryWithLanguageName(getResources(), ((EbayCountry) (obj))));
        addressCountry.setTag(obj);
        addressLine1.setText(directdebit.billingAddress.streetAddress);
        addressLine2.setText(directdebit.billingAddress.streetAddress2);
        addressCity.setText(directdebit.billingAddress.city);
        if (directdebit.billingAddress.state == null) goto _L4; else goto _L3
_L3:
        obj = (ArrayAdapter)addressState.getAdapter();
        if (obj == null) goto _L4; else goto _L5
_L5:
        i = 0;
_L10:
        if (i >= ((ArrayAdapter) (obj)).getCount()) goto _L4; else goto _L6
_L6:
        if (!((CharSequence)((ArrayAdapter) (obj)).getItem(i)).toString().equals(directdebit.billingAddress.state)) goto _L8; else goto _L7
_L7:
        addressState.setSelection(i);
_L4:
        addressPostalCode.setText(directdebit.billingAddress.postalCode);
_L2:
        return;
_L8:
        i++;
        if (true) goto _L10; else goto _L9
_L9:
    }






}
