// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.prox;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.ebay.app.DatePickerDialogFragment;
import com.ebay.common.Preferences;
import com.ebay.common.model.cart.Cart;
import com.ebay.common.model.cart.CartPaymentMethods;
import com.ebay.common.model.cart.JsonModel;
import com.ebay.common.view.util.DialogManager;
import com.ebay.common.view.util.EbayCountryManager;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.PreferredCountryActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.checkout.BaseCheckoutActivity;
import com.ebay.mobile.checkout.CheckoutError;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.content.dm.AddressDataManager;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.data.ErrorMessageDetails;
import com.ebay.nautilus.domain.net.api.addressbook.AddressResponseData;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.checkout.prox:
//            ProxHelper

public final class PayUponInvoiceActivity extends BaseCheckoutActivity
    implements android.app.DatePickerDialog.OnDateSetListener
{

    private static final int ACTIVITY_RESULT_DATE_OF_BIRTH = 919;
    private static final int ACTIVITY_RESULT_SELECT_COUNTRY = 920;
    private static final String EXTRA_ADDRESS = "address";
    private static final String EXTRA_ADDRESS_CITY = "addressCity";
    private static final String EXTRA_ADDRESS_COUNTRY = "addressCountry";
    public static final String EXTRA_ADDRESS_ID = "addressId";
    private static final String EXTRA_ADDRESS_LINE_1 = "addressLine1";
    private static final String EXTRA_ADDRESS_LINE_2 = "addressLine2";
    private static final String EXTRA_ADDRESS_POSTAL_CODE = "addressPostalCode";
    private static final String EXTRA_ADDRESS_STATE = "addressState";
    private static final String EXTRA_BILLING_NAME = "billingName";
    public static final String EXTRA_DATE_OF_BIRTH = "dob";
    private static final String EXTRA_IS_UPDATING_BEFORE_DONE = "isUpdatingBeforeDone";
    private static final int MINIMUM_AGE_IN_YEARS = 18;
    private EditText addressCity;
    private TextView addressCountry;
    private EditText addressLine1;
    private EditText addressLine2;
    private EditText addressName;
    private EditText addressPostalCode;
    private Spinner addressState;
    private Address billingAddress;
    protected AddressDataManager billingAddressDataManager;
    protected final DialogManager dialogManager = (DialogManager)getShim(com/ebay/common/view/util/DialogManager);
    private String dob;
    private boolean isUpdatingBeforeDone;
    private Calendar minimumDateOfBirth;

    public PayUponInvoiceActivity()
    {
    }

    private void createDefaultShippingAddress()
    {
        Address address = getDefaultShippingAddress();
        address.addressType = "Billing";
        addressDataManager.updateAddress(address, MyApp.getDeviceConfiguration().isMECAddressValidationEnabledForCountry(address.addressFields.country));
    }

    private void returnResult()
    {
        Object obj;
        String s;
        obj = Calendar.getInstance();
        s = ((TextView)findViewById(0x7f10051d)).getText().toString();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        if (s.length() > 0)
        {
            ((Calendar) (obj)).setTime(DateFormat.getDateFormat(this).parse(s));
            obj = (new Intent()).putExtra("dob", ((java.io.Serializable) (obj)));
            ((Intent) (obj)).putExtra("addressId", billingAddress.getAddressId());
            setCheckoutResult(-1, ((Intent) (obj)));
            finish();
        }
        return;
        ParseException parseexception;
        parseexception;
        dialogManager.showDynamicAlertDialog(getString(0x7f070130), getString(0x7f0707e3), false);
        return;
    }

    private void updateUi()
    {
        if (dob != null)
        {
            ((TextView)findViewById(0x7f10051d)).setText(dob);
        }
        if (billingAddress == null) goto _L2; else goto _L1
_L1:
        EbayCountry ebaycountry = EbayCountry.getInstance(billingAddress.addressFields.country);
        addressCountry.setText(EbayCountryManager.getCountryWithLanguageName(getResources(), ebaycountry));
        addressCountry.setTag(ebaycountry);
        ProxHelper.updateInputFormForCountry(this, findViewById(0x1020002), ebaycountry, null);
        if (billingAddress.addressFields.stateOrProvince == null) goto _L4; else goto _L3
_L3:
        ArrayAdapter arrayadapter = (ArrayAdapter)addressState.getAdapter();
        if (arrayadapter == null) goto _L4; else goto _L5
_L5:
        int i = 0;
_L10:
        if (i >= arrayadapter.getCount()) goto _L4; else goto _L6
_L6:
        if (!((CharSequence)arrayadapter.getItem(i)).toString().equals(billingAddress.addressFields.stateOrProvince)) goto _L8; else goto _L7
_L7:
        addressState.setSelection(i);
_L4:
        addressName.setText(billingAddress.addressFields.name);
        addressLine1.setText(billingAddress.addressFields.street1);
        addressLine2.setText(billingAddress.addressFields.street2);
        addressCity.setText(billingAddress.addressFields.city);
        addressPostalCode.setText(billingAddress.addressFields.postalCode);
_L2:
        enableProgressDialog(false, false);
        return;
_L8:
        i++;
        if (true) goto _L10; else goto _L9
_L9:
    }

    private void verifyFormAndTakeNextAction()
    {
        Object obj;
        boolean flag;
        flag = true;
        if (billingAddress == null || billingAddress.getAddressId() == null)
        {
            flag = false;
        }
        obj = Calendar.getInstance();
        Object obj1 = ((TextView)findViewById(0x7f10051d)).getText().toString();
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        int i = ((String) (obj1)).length();
        if (i != 0) goto _L3; else goto _L2
_L2:
        flag = false;
_L4:
        if (addressName.length() == 0)
        {
            flag = false;
        }
        if (addressCountry.length() == 0)
        {
            flag = false;
        }
        if (addressLine1.length() == 0)
        {
            flag = false;
        }
        if (addressCity.length() == 0)
        {
            flag = false;
        }
        if (addressPostalCode.length() == 0)
        {
            flag = false;
        }
        obj = new Address(billingAddress);
        billingAddress.addressFields.phone = null;
        ((Address) (obj)).addressFields.phone = null;
        if (addressName.length() > 0)
        {
            ((Address) (obj)).addressFields.name = addressName.getText().toString();
        }
        if (addressCity.length() > 0)
        {
            ((Address) (obj)).addressFields.city = addressCity.getText().toString();
        }
        if (addressLine1.length() > 0)
        {
            ((Address) (obj)).addressFields.street1 = addressLine1.getText().toString();
        }
        if (addressLine2.length() > 0)
        {
            ((Address) (obj)).addressFields.street2 = addressLine2.getText().toString();
        }
        if (addressPostalCode.length() > 0)
        {
            ((Address) (obj)).addressFields.postalCode = addressPostalCode.getText().toString();
        }
        if (addressState.getVisibility() == 0)
        {
            ((Address) (obj)).addressFields.stateOrProvince = (String)addressState.getSelectedItem();
        }
        obj1 = (EbayCountry)addressCountry.getTag();
        if (obj1 != null)
        {
            ((Address) (obj)).addressFields.country = ((EbayCountry) (obj1)).getCountryCode();
        }
        ParseException parseexception;
        boolean flag1;
        if (flag)
        {
            if (!((Address) (obj)).equals(billingAddress) && billingAddressDataManager != null)
            {
                updateProgressDialog(0x7f070c7d);
                enableProgressDialog(true, true);
                isUpdatingBeforeDone = true;
                billingAddressDataManager.updateAddress(((Address) (obj)), MyApp.getDeviceConfiguration().isMECAddressValidationEnabledForCountry(billingAddress.addressFields.country));
                return;
            } else
            {
                returnResult();
                return;
            }
        } else
        {
            dialogManager.showDynamicAlertDialog(getString(0x7f070130), getString(0x7f0707e3), false);
            return;
        }
_L3:
        ((Calendar) (obj)).setTime(DateFormat.getDateFormat(this).parse(((String) (obj1))));
        flag1 = ((Calendar) (obj)).after(minimumDateOfBirth);
        if (flag1)
        {
            flag = false;
        }
          goto _L4
        parseexception;
        flag = false;
          goto _L4
    }

    public String getTrackingEventName()
    {
        return "PayUponInvoice";
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 920 && j == -1)
        {
            if ((intent = (EbayCountry)intent.getParcelableExtra("extraCountry")) != null)
            {
                addressCountry.setText(EbayCountryManager.getCountryWithLanguageName(getResources(), intent));
                addressCountry.setTag(intent);
                ProxHelper.updateInputFormForCountry(this, findViewById(0x1020002), intent, null);
                return;
            }
        }
    }

    public void onAddressUpdated(AddressDataManager addressdatamanager, Content content)
    {
        if ("Shipping".equals(((com.ebay.nautilus.domain.content.dm.AddressDataManager.KeyParams)addressdatamanager.getParams()).addressType))
        {
            if (billingAddressDataManager != null)
            {
                billingAddressDataManager.forceReloadData();
            }
        } else
        if (isUpdatingBeforeDone)
        {
            enableProgressDialog(false, false);
            addressdatamanager = (AddressResponseData)content.getData();
            if (addressdatamanager.getAck() == 1)
            {
                billingAddress = null;
                billingAddressDataManager.forceReloadData();
                return;
            }
            addressdatamanager = addressdatamanager.getErrors();
            if (addressdatamanager != null && addressdatamanager.size() > 0)
            {
                addressdatamanager = (ErrorMessageDetails)addressdatamanager.get(0);
                addressdatamanager = CheckoutError.mapCheckoutError(com.ebay.mobile.checkout.BaseCheckoutActivity.Operation.ADDRESS_DATA_MANAGER, addressdatamanager.getLongMessage(getEbayContext()));
                if (addressdatamanager != null)
                {
                    dialogManager.showDynamicAlertDialog(null, addressdatamanager.getErrorString(this), addressdatamanager.shouldAbortOnError());
                    return;
                }
            }
        }
    }

    public void onAddressesChanged(AddressDataManager addressdatamanager, Content content, boolean flag)
    {
        if (!"Billing".equals(((com.ebay.nautilus.domain.content.dm.AddressDataManager.KeyParams)addressdatamanager.getParams()).addressType) || billingAddress != null) goto _L2; else goto _L1
_L1:
        addressdatamanager = (List)content.getData();
        content = content.getStatus();
        if (content.hasError()) goto _L4; else goto _L3
_L3:
        if (addressdatamanager != null) goto _L6; else goto _L5
_L5:
        billingAddressDataManager.onCurrentCountryChanged((UserContextDataManager)DataManager.getIfExists(getEbayContext(), UserContextDataManager.KEY), MyApp.getPrefs().getCurrentCountry());
        billingAddressDataManager.forceReloadData();
_L2:
        return;
_L6:
        if (addressdatamanager.size() <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        addressdatamanager = addressdatamanager.iterator();
        do
        {
            if (!addressdatamanager.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            content = (Address)addressdatamanager.next();
        } while (content == null || ((Address) (content)).addressFields == null || !"Billing".equals(((Address) (content)).addressType) || !content.isDefault());
        billingAddress = content;
        updateUi();
        if (isUpdatingBeforeDone)
        {
            isUpdatingBeforeDone = false;
            returnResult();
            return;
        }
        if (true) goto _L2; else goto _L7
_L7:
        createDefaultShippingAddress();
        return;
_L4:
        addressdatamanager = content.getFirstError();
        if (addressdatamanager != null && 1017 == addressdatamanager.getId())
        {
            createDefaultShippingAddress();
            return;
        }
        if (true) goto _L2; else goto _L8
_L8:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0301b4);
        TextView textview = (TextView)findViewById(0x7f10051d);
        final Calendar now = cart.cartPaymentMethods.getSelectedPaymentMethod();
        if (now != null)
        {
            now = now.getDateOfBirth();
            if (now != null)
            {
                textview.setText(SimpleDateFormat.getDateInstance(3, Locale.getDefault()).format(now.getTime()));
            }
        }
        now = Calendar.getInstance();
        now.add(1, -18);
        if (textview != null)
        {
            textview.setOnClickListener(new android.view.View.OnClickListener() {

                final PayUponInvoiceActivity this$0;
                final Calendar val$now;

                public void onClick(View view)
                {
                    view = new com.ebay.app.DatePickerDialogFragment.Builder();
                    Object obj = ((TextView)findViewById(0x7f10051d)).getText();
                    if (obj != null && !TextUtils.isEmpty(obj.toString()))
                    {
                        try
                        {
                            obj = DateFormat.getDateFormat(PayUponInvoiceActivity.this).parse(obj.toString());
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(((java.util.Date) (obj)));
                            view.setYear(calendar.get(1));
                            view.setMonth(calendar.get(2));
                            view.setDay(calendar.get(5));
                        }
                        catch (ParseException parseexception) { }
                    } else
                    {
                        view.setYear(now.get(1));
                        view.setMonth(now.get(2));
                        view.setDay(now.get(5));
                    }
                    view.createFromActivity(919, PayUponInvoiceActivity.this).show(getFragmentManager(), "dateOfBirthPicker");
                }

            
            {
                this$0 = PayUponInvoiceActivity.this;
                now = calendar;
                super();
            }
            });
        }
        if (minimumDateOfBirth == null)
        {
            minimumDateOfBirth = Calendar.getInstance();
            minimumDateOfBirth.set(13, 0);
            minimumDateOfBirth.set(12, 0);
            minimumDateOfBirth.set(10, 0);
            minimumDateOfBirth.set(14, 1);
            minimumDateOfBirth.add(1, -18);
        }
        addressName = (EditText)findViewById(0x7f100502);
        addressLine1 = (EditText)findViewById(0x7f100503);
        addressLine2 = (EditText)findViewById(0x7f100504);
        addressCity = (EditText)findViewById(0x7f100505);
        addressState = (Spinner)findViewById(0x7f100506);
        addressPostalCode = (EditText)findViewById(0x7f100509);
        addressCountry = (TextView)findViewById(0x7f100500);
        if (bundle != null)
        {
            updateUi();
        } else
        {
            updateProgressDialog(0x7f070c60);
            enableProgressDialog(true, true);
        }
        findViewById(0x7f1004fe).setOnClickListener(new android.view.View.OnClickListener() {

            final PayUponInvoiceActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(PayUponInvoiceActivity.this, com/ebay/mobile/activities/PreferredCountryActivity);
                if (billingAddress != null)
                {
                    view.putExtra("extraCountry", EbayCountry.getInstance(billingAddress.addressFields.country));
                }
                startActivityForResult(view, 920);
            }

            
            {
                this$0 = PayUponInvoiceActivity.this;
                super();
            }
        });
    }

    public void onDateSet(DatePicker datepicker, int i, int j, int k)
    {
        datepicker = (TextView)findViewById(0x7f10051d);
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
            datepicker.setText(DateFormat.getDateFormat(this).format(calendar.getTime()));
        }
    }

    public void onError(com.ebay.mobile.checkout.BaseCheckoutActivity.Operation operation, boolean flag, IOException ioexception)
    {
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        billingAddressDataManager = (AddressDataManager)datamanagercontainer.initialize(new com.ebay.nautilus.domain.content.dm.AddressDataManager.KeyParams("Billing"), this);
        super.onInitializeDataManagers(datamanagercontainer);
    }

    public void onPartialFailure(com.ebay.mobile.checkout.BaseCheckoutActivity.Operation operation, JsonModel jsonmodel)
    {
    }

    protected void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        setDoneButtonOnClickListener(new android.view.View.OnClickListener() {

            final PayUponInvoiceActivity this$0;

            public void onClick(View view)
            {
                ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                verifyFormAndTakeNextAction();
            }

            
            {
                this$0 = PayUponInvoiceActivity.this;
                super();
            }
        });
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        dob = bundle.getString("dob", "");
        billingAddress = (Address)bundle.getParcelable("address");
        isUpdatingBeforeDone = bundle.getBoolean("isUpdatingBeforeDone");
        addressName.setText(bundle.getString("billingName", ""));
        addressCountry.setText(bundle.getString("addressCountry", ""));
        addressLine1.setText(bundle.getString("addressLine1", ""));
        addressLine2.setText(bundle.getString("addressLine2", ""));
        addressCity.setText(bundle.getString("addressCity", ""));
        addressPostalCode.setText(bundle.getString("addressPostalCode", ""));
        int i = bundle.getInt("addressState", -1);
        if (i != -1)
        {
            addressState.setSelection(i);
        }
    }

    protected void onResume()
    {
        super.onResume();
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).send(this);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("dob", dob);
        bundle.putParcelable("address", billingAddress);
        bundle.putBoolean("isUpdatingBeforeDone", isUpdatingBeforeDone);
        bundle.putString("billingName", addressName.getText().toString());
        bundle.putString("addressCountry", addressCountry.getText().toString());
        bundle.putString("addressLine1", addressLine1.getText().toString());
        bundle.putString("addressLine2", addressLine2.getText().toString());
        bundle.putString("addressCity", addressCity.getText().toString());
        bundle.putInt("addressState", addressState.getSelectedItemPosition());
        bundle.putString("addressPostalCode", addressPostalCode.getText().toString());
    }

    public void onSuccess(com.ebay.mobile.checkout.BaseCheckoutActivity.Operation operation)
    {
    }


}
