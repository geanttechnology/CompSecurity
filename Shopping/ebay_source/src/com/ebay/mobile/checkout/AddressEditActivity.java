// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.model.cart.Cart;
import com.ebay.common.model.cart.JsonModel;
import com.ebay.common.net.api.local.EbayNowMappedException;
import com.ebay.common.net.api.local.EbayNowValidateTimeSlotDataManager;
import com.ebay.common.view.util.DialogManager;
import com.ebay.common.view.util.EbayCountryManager;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.PreferredCountryActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.EbayPhoneNumberUtil;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.AddressDataManager;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.net.api.addressbook.AddressResponseData;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.ebay.mobile.checkout:
//            BaseCheckoutActivity, CheckoutError

public class AddressEditActivity extends BaseCheckoutActivity
    implements android.view.View.OnClickListener, com.ebay.nautilus.domain.content.dm.AddressDataManager.Observer
{
    public static final class AddressValidation extends Enum
    {

        private static final AddressValidation $VALUES[];
        public static final AddressValidation BAD_CITY;
        public static final AddressValidation BAD_COUNTRY_CODE;
        public static final AddressValidation BAD_NAME;
        public static final AddressValidation BAD_PHONE;
        public static final AddressValidation BAD_POSTAL_CODE;
        public static final AddressValidation BAD_STATE_OR_PROVINCE;
        public static final AddressValidation BAD_STREET1;
        public static final AddressValidation PHONE_NUMBER_REQUIRED;
        public static final AddressValidation VALID;

        public static AddressValidation valueOf(String s)
        {
            return (AddressValidation)Enum.valueOf(com/ebay/mobile/checkout/AddressEditActivity$AddressValidation, s);
        }

        public static AddressValidation[] values()
        {
            return (AddressValidation[])$VALUES.clone();
        }

        static 
        {
            VALID = new AddressValidation("VALID", 0);
            BAD_NAME = new AddressValidation("BAD_NAME", 1);
            BAD_STREET1 = new AddressValidation("BAD_STREET1", 2);
            BAD_CITY = new AddressValidation("BAD_CITY", 3);
            BAD_STATE_OR_PROVINCE = new AddressValidation("BAD_STATE_OR_PROVINCE", 4);
            BAD_COUNTRY_CODE = new AddressValidation("BAD_COUNTRY_CODE", 5);
            BAD_POSTAL_CODE = new AddressValidation("BAD_POSTAL_CODE", 6);
            BAD_PHONE = new AddressValidation("BAD_PHONE", 7);
            PHONE_NUMBER_REQUIRED = new AddressValidation("PHONE_NUMBER_REQUIRED", 8);
            $VALUES = (new AddressValidation[] {
                VALID, BAD_NAME, BAD_STREET1, BAD_CITY, BAD_STATE_OR_PROVINCE, BAD_COUNTRY_CODE, BAD_POSTAL_CODE, BAD_PHONE, PHONE_NUMBER_REQUIRED
            });
        }

        private AddressValidation(String s, int i)
        {
            super(s, i);
        }
    }

    private final class RevalidateObserver
        implements com.ebay.common.net.api.local.EbayNowValidateTimeSlotDataManager.Observer
    {

        private String errorMessage;
        private int revalidateCount;
        final AddressEditActivity this$0;

        public void onValidateTimeSlotComplete(EbayNowValidateTimeSlotDataManager ebaynowvalidatetimeslotdatamanager, Content content)
        {
            revalidateCount = revalidateCount - 1;
            content = content.getStatus();
            if (!content.hasError()) goto _L2; else goto _L1
_L1:
            errorMessage = MyApp.getDisplayableServiceError(getEbayContext(), content);
            if (TextUtils.isEmpty(errorMessage))
            {
                errorMessage = getString(0x7f07024a);
            }
_L4:
            if (revalidateCount == 0)
            {
                if (errorMessage == null)
                {
                    break; /* Loop/switch isn't completed */
                }
                dialogManager.showDynamicAlertDialog(null, errorMessage, false);
                resetUi(true);
            }
            return;
_L2:
            ebaynowvalidatetimeslotdatamanager = ebaynowvalidatetimeslotdatamanager.getMappedException();
            if (ebaynowvalidatetimeslotdatamanager != null && "INVALID_PHONE".equals(((EbayNowMappedException) (ebaynowvalidatetimeslotdatamanager)).errorId))
            {
                errorMessage = getString(0x7f070caa);
            }
            if (true) goto _L4; else goto _L3
_L3:
            boolean flag = MyApp.getDeviceConfiguration().isMECAddressValidationEnabledForCountry(currentAddress.addressFields.country);
            updateAddressRequestId = currentAddress.getAddressId();
            addressDataManager.updateAddress(currentAddress, flag);
            return;
        }

        public RevalidateObserver(int i)
        {
            this$0 = AddressEditActivity.this;
            super();
            revalidateCount = i;
            errorMessage = null;
        }
    }

    public class StateOrProvinceListener
        implements android.widget.AdapterView.OnItemSelectedListener
    {

        final AddressEditActivity this$0;

        public void onItemSelected(AdapterView adapterview, View view, int i, long l)
        {
            if (i > 0)
            {
                currentAddress.addressFields.stateOrProvince = adapterview.getItemAtPosition(i).toString();
            }
        }

        public void onNothingSelected(AdapterView adapterview)
        {
        }

        public StateOrProvinceListener()
        {
            this$0 = AddressEditActivity.this;
            super();
        }
    }


    public static final String EXTRA_ADDRESS_TO_EDIT = "address_to_edit";
    public static final String EXTRA_ADDRESS_TYPE = "address_type";
    static final String EXTRA_CURRENT_ADDRESS = "current_address";
    static final String EXTRA_FOCUS_PHONE = "address_focus_phone";
    protected static final Integer RESULT_SHIPPING_COUNTRY = Integer.valueOf(1);
    private static final String TAG = "AddressEditActivity";
    private static final List countryCodesWithoutPostalCodes;
    private final String EXTRA_ERROR_CODE = "error_code";
    private final String EXTRA_IS_EDITING_EXISTING_ADDRESS = "is_editing";
    private final String EXTRA_SERVICE_MODIFIED_ADDRESS = "serviceModifiedAddress";
    private String addressType;
    protected Address currentAddress;
    protected final DialogManager dialogManager = (DialogManager)getShim(com/ebay/common/view/util/DialogManager);
    String errorCode;
    boolean isEditingExistingAddress;
    private boolean serviceModifiedAddressDuringAddOrEdit;
    private Address startingAddress;

    public AddressEditActivity()
    {
        isEditingExistingAddress = false;
        serviceModifiedAddressDuringAddOrEdit = false;
    }

    private final void allDone(boolean flag)
    {
        Intent intent = new Intent();
        intent.putExtra("address_to_edit", currentAddress);
        byte byte0;
        if (flag)
        {
            byte0 = -1;
        } else
        {
            byte0 = 0;
        }
        setCheckoutResult(byte0, intent);
        finish();
    }

    private boolean countryHasStatesOrProvinces(String s)
    {
        return getStateProvinceCodes(s) != 0;
    }

    private void createUi()
    {
        setContentView(0x7f03001e);
        findViewById(0x7f1000a8).setOnClickListener(this);
        findViewById(0x7f1000a7).setOnClickListener(this);
        findViewById(0x7f10009b).setOnClickListener(new android.view.View.OnClickListener() {

            final AddressEditActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(AddressEditActivity.this, com/ebay/mobile/activities/PreferredCountryActivity);
                if (isEditingExistingAddress)
                {
                    view.putExtra("extraCountry", EbayCountry.getInstance(currentAddress.addressFields.country));
                }
                startActivityForResult(view, AddressEditActivity.RESULT_SHIPPING_COUNTRY.intValue());
            }

            
            {
                this$0 = AddressEditActivity.this;
                super();
            }
        });
    }

    private String getEditTextValue(int i)
    {
        String s = null;
        EditText edittext = (EditText)findViewById(i);
        if (edittext != null)
        {
            s = edittext.getText().toString();
        }
        return s;
    }

    private String getPostalCodeLabel(String s)
    {
        String s1 = getResources().getString(0x7f070204);
        if ("AT".equals(s))
        {
            s1 = getString(0x7f0701f7);
        } else
        {
            if ("AU".equals(s))
            {
                return getString(0x7f0701f8);
            }
            if ("CA".equals(s))
            {
                return getString(0x7f0701fa);
            }
            if ("DE".equals(s))
            {
                return getString(0x7f0701fc);
            }
            if ("FR".equals(s))
            {
                return getString(0x7f0701fd);
            }
            if ("GB".equals(s))
            {
                return getString(0x7f0701fe);
            }
            if ("IT".equals(s))
            {
                return getString(0x7f0701ff);
            }
            if ("US".equals(s))
            {
                return getString(0x7f070202);
            }
        }
        return s1;
    }

    private Address getStartingAddress()
    {
        Address address1 = (Address)getIntent().getParcelableExtra("address_to_edit");
        Address address = address1;
        if (address1 == null)
        {
            address = new Address();
            EbayCountry ebaycountry = MyApp.getPrefs().getCurrentCountry();
            address.addressFields.countryName = EbayCountryManager.getCountryWithLanguageName(getResources(), ebaycountry);
            address.addressFields.country = ebaycountry.getCountryCode();
        }
        return address;
    }

    private int getStateProvinceCodes(String s)
    {
        int i = 0;
        if ("US".equals(s))
        {
            i = 0x7f0e0006;
        } else
        {
            if ("CA".equals(s))
            {
                return 0x7f0e0001;
            }
            if ("AU".equals(s))
            {
                return 0x7f0e0000;
            }
            if ("IT".equals(s))
            {
                return 0x7f0e0003;
            }
            if ("JP".equals(s))
            {
                return 0x7f0e0004;
            }
            if ("IN".equals(s))
            {
                return 0x7f0e0002;
            }
        }
        return i;
    }

    private String getStateProvinceLabel(String s)
    {
        String s1 = "";
        if ("AU".equals(s))
        {
            s1 = getResources().getString(0x7f0701f9);
        } else
        {
            if ("CA".equals(s))
            {
                return getResources().getString(0x7f0701fb);
            }
            if ("IT".equals(s))
            {
                return getResources().getString(0x7f070200);
            }
            if ("US".equals(s))
            {
                return getResources().getString(0x7f070203);
            }
            if ("JP".equals(s))
            {
                return getResources().getString(0x7f070201);
            }
        }
        return s1;
    }

    private boolean isEmptyOrBlank(String s)
    {
        return TextUtils.isEmpty(s) || TextUtils.getTrimmedLength(s) == 0;
    }

    private void saveAddress()
    {
        Object obj1 = null;
        currentAddress.addressFields.name = getEditTextValue(0x7f10009f);
        currentAddress.addressFields.street1 = getEditTextValue(0x7f1000a1);
        currentAddress.addressFields.street2 = getEditTextValue(0x7f1000a2);
        currentAddress.addressFields.city = getEditTextValue(0x7f1000a3);
        if (findViewById(0x7f1000a5).getVisibility() == 0)
        {
            currentAddress.addressFields.stateOrProvince = getEditTextValue(0x7f1000a5);
        }
        currentAddress.addressFields.postalCode = getEditTextValue(0x7f1000a6);
        currentAddress.addressFields.phone = getEditTextValue(0x7f1000a0);
        com.ebay.nautilus.domain.data.Address.AddressFields addressfields = currentAddress.addressFields;
        String s;
        if (isEmptyOrBlank(currentAddress.addressFields.name))
        {
            s = null;
        } else
        {
            s = currentAddress.addressFields.name;
        }
        addressfields.name = s;
        addressfields = currentAddress.addressFields;
        if (isEmptyOrBlank(currentAddress.addressFields.street1))
        {
            s = null;
        } else
        {
            s = currentAddress.addressFields.street1;
        }
        addressfields.street1 = s;
        addressfields = currentAddress.addressFields;
        if (isEmptyOrBlank(currentAddress.addressFields.street2))
        {
            s = null;
        } else
        {
            s = currentAddress.addressFields.street2;
        }
        addressfields.street2 = s;
        if (findViewById(0x7f1000a5).getVisibility() == 0)
        {
            com.ebay.nautilus.domain.data.Address.AddressFields addressfields1 = currentAddress.addressFields;
            if (isEmptyOrBlank(currentAddress.addressFields.stateOrProvince))
            {
                s = null;
            } else
            {
                s = currentAddress.addressFields.stateOrProvince;
            }
            addressfields1.stateOrProvince = s;
        }
        addressfields1 = currentAddress.addressFields;
        if (isEmptyOrBlank(currentAddress.addressFields.city))
        {
            s = null;
        } else
        {
            s = currentAddress.addressFields.city;
        }
        addressfields1.city = s;
        addressfields1 = currentAddress.addressFields;
        if (isEmptyOrBlank(currentAddress.addressFields.postalCode))
        {
            s = null;
        } else
        {
            s = currentAddress.addressFields.postalCode;
        }
        addressfields1.postalCode = s;
        addressfields1 = currentAddress.addressFields;
        if (isEmptyOrBlank(currentAddress.addressFields.phone))
        {
            s = obj1;
        } else
        {
            s = currentAddress.addressFields.phone;
        }
        addressfields1.phone = s;
        if (!TextUtils.isEmpty(currentAddress.addressFields.country)) goto _L2; else goto _L1
_L1:
        dialogManager.showDynamicAlertDialog(getString(0x7f070bf3), getString(0x7f070bed), false);
_L13:
        return;
_L2:
        Object obj;
        if (startingAddress != null)
        {
            if (!TextUtils.isEmpty(startingAddress.addressFields.phone))
            {
                currentAddress.addressFields.phone = valueOrEmptyString(EbayPhoneNumberUtil.formatPhoneNumber(currentAddress.addressFields.phone, currentAddress.addressFields.country));
                startingAddress.addressFields.phone = valueOrEmptyString(EbayPhoneNumberUtil.formatPhoneNumber(startingAddress.addressFields.phone, startingAddress.addressFields.country));
            }
            if (currentAddress.equals(startingAddress))
            {
                boolean flag;
                if (serviceModifiedAddressDuringAddOrEdit)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                allDone(flag);
                return;
            }
        }
        obj = validateAddress(currentAddress);
        if (AddressValidation.VALID == obj)
        {
            break MISSING_BLOCK_LABEL_822;
        }
        static class _cls2
        {

            static final int $SwitchMap$com$ebay$mobile$checkout$AddressEditActivity$AddressValidation[];

            static 
            {
                $SwitchMap$com$ebay$mobile$checkout$AddressEditActivity$AddressValidation = new int[AddressValidation.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$AddressEditActivity$AddressValidation[AddressValidation.BAD_NAME.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$AddressEditActivity$AddressValidation[AddressValidation.BAD_STREET1.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$AddressEditActivity$AddressValidation[AddressValidation.BAD_CITY.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$AddressEditActivity$AddressValidation[AddressValidation.BAD_STATE_OR_PROVINCE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$AddressEditActivity$AddressValidation[AddressValidation.BAD_COUNTRY_CODE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$AddressEditActivity$AddressValidation[AddressValidation.BAD_POSTAL_CODE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$AddressEditActivity$AddressValidation[AddressValidation.BAD_PHONE.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$AddressEditActivity$AddressValidation[AddressValidation.PHONE_NUMBER_REQUIRED.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2..SwitchMap.com.ebay.mobile.checkout.AddressEditActivity.AddressValidation[((AddressValidation) (obj)).ordinal()];
        JVM INSTR tableswitch 1 8: default 712
    //                   1 742
    //                   2 752
    //                   3 762
    //                   4 772
    //                   5 782
    //                   6 792
    //                   7 802
    //                   8 812;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L11:
        break MISSING_BLOCK_LABEL_812;
_L4:
        break; /* Loop/switch isn't completed */
_L3:
        obj = null;
_L14:
        if (obj != null)
        {
            dialogManager.showDynamicAlertDialog(getString(0x7f070bf3), getString(((Integer) (obj)).intValue()), false);
            return;
        }
        if (true) goto _L13; else goto _L12
_L12:
        obj = Integer.valueOf(0x7f070bee);
          goto _L14
_L5:
        obj = Integer.valueOf(0x7f070bf2);
          goto _L14
_L6:
        obj = Integer.valueOf(0x7f070bec);
          goto _L14
_L7:
        obj = Integer.valueOf(0x7f070bf1);
          goto _L14
_L8:
        obj = Integer.valueOf(0x7f070bed);
          goto _L14
_L9:
        obj = Integer.valueOf(0x7f070be1);
          goto _L14
_L10:
        obj = Integer.valueOf(0x7f070bef);
          goto _L14
        obj = Integer.valueOf(0x7f070bfd);
          goto _L14
        Address address = new Address(currentAddress);
        address.addressFields.phone = EbayPhoneNumberUtil.formatPhoneNumberForApi(address.addressFields.phone, address.addressFields.country);
        boolean flag1 = MyApp.getDeviceConfiguration().isMECAddressValidationEnabledForCountry(address.addressFields.country);
        enableProgressDialog(true, false);
        if (isEditingExistingAddress)
        {
            updateProgressDialog(0x7f070c7c);
            if (cart != null && cart.hasEbayNowDeliveryTimeSlots())
            {
                revalidateEbayNowDeliverySlotsForAddress(address);
                return;
            } else
            {
                updateAddressRequestId = address.getAddressId();
                addressDataManager.updateAddress(address, flag1);
                return;
            }
        }
        updateProgressDialog(0x7f070bd6);
        if (addressType == null)
        {
            addressDataManager.addAddress(address, flag1);
            return;
        } else
        {
            addressDataManager.addAddress(address, flag1, addressType);
            return;
        }
    }

    private void setCountryUi()
    {
        Object obj;
        Spinner spinner;
        set_view_text(0x7f10009d, currentAddress.addressFields.country);
        spinner = (Spinner)findViewById(0x7f1000a4);
        obj = Boolean.valueOf(false);
        if (!countryHasStatesOrProvinces(currentAddress.addressFields.country)) goto _L2; else goto _L1
_L1:
        int i;
        obj = Boolean.valueOf(true);
        i = getStateProvinceCodes(currentAddress.addressFields.country);
        if (i == 0) goto _L4; else goto _L3
_L3:
        String as[];
        as = getResources().getStringArray(i);
        ArrayAdapter arrayadapter = new ArrayAdapter(this, 0x1090008, as);
        arrayadapter.setDropDownViewResource(0x1090009);
        spinner.setAdapter(arrayadapter);
        spinner.setPrompt(getStateProvinceLabel(currentAddress.addressFields.country));
        if (currentAddress == null) goto _L4; else goto _L5
_L5:
        int j;
        int k;
        j = 0;
        k = as.length;
        i = 0;
_L10:
        if (i >= k) goto _L4; else goto _L6
_L6:
        if (!as[i].equals(currentAddress.addressFields.stateOrProvince)) goto _L8; else goto _L7
_L7:
        spinner.setSelection(j);
_L4:
        spinner.setOnItemSelectedListener(new StateOrProvinceListener());
_L2:
        if (((Boolean) (obj)).booleanValue())
        {
            i = 0;
        } else
        {
            i = 8;
        }
        spinner.setVisibility(i);
        obj = (TextView)findViewById(0x7f1000a5);
        if ("GB".equals(currentAddress.addressFields.country))
        {
            ((TextView) (obj)).setVisibility(0);
        } else
        {
            ((TextView) (obj)).setVisibility(8);
        }
        obj = (EditText)findViewById(0x7f1000a6);
        if (countryCodesWithoutPostalCodes.contains(currentAddress.addressFields.country))
        {
            ((EditText) (obj)).setVisibility(8);
            return;
        } else
        {
            ((EditText) (obj)).setHint(getPostalCodeLabel(currentAddress.addressFields.country));
            ((EditText) (obj)).setVisibility(0);
            return;
        }
_L8:
        j++;
        i++;
        if (true) goto _L10; else goto _L9
_L9:
    }

    private void setEditTextValue(int i, String s, boolean flag)
    {
        EditText edittext = (EditText)findViewById(i);
        if (edittext != null && !TextUtils.isEmpty(s))
        {
            SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
            StyleSpan stylespan1 = new StyleSpan(0);
            StyleSpan stylespan = stylespan1;
            if (flag)
            {
                stylespan = stylespan1;
                if (!s.equals(getEditTextValue(i)))
                {
                    stylespan = new StyleSpan(1);
                }
            }
            spannablestringbuilder.append(s);
            spannablestringbuilder.setSpan(stylespan, 0, spannablestringbuilder.length(), 33);
            edittext.setText(spannablestringbuilder);
        }
    }

    private void updateUi()
    {
        if (currentAddress != null)
        {
            set_view_text(0x7f10009f, valueOrEmptyString(currentAddress.addressFields.name));
            set_view_text(0x7f1000a1, valueOrEmptyString(currentAddress.addressFields.street1));
            set_view_text(0x7f1000a2, valueOrEmptyString(currentAddress.addressFields.street2));
            set_view_text(0x7f1000a3, valueOrEmptyString(currentAddress.addressFields.city));
            if (findViewById(0x7f1000a5).getVisibility() == 0)
            {
                set_view_text(0x7f1000a5, valueOrEmptyString(currentAddress.addressFields.stateOrProvince));
            }
            set_view_text(0x7f1000a6, valueOrEmptyString(currentAddress.addressFields.postalCode));
            set_view_text(0x7f1000a0, valueOrEmptyString(EbayPhoneNumberUtil.formatPhoneNumber(currentAddress.addressFields.phone, currentAddress.addressFields.country)));
            setCountryUi();
        }
    }

    private AddressValidation validateAddress(Address address)
    {
        AddressValidation addressvalidation1 = AddressValidation.VALID;
        if (!TextUtils.isEmpty(address.addressFields.name)) goto _L2; else goto _L1
_L1:
        AddressValidation addressvalidation = AddressValidation.BAD_NAME;
_L4:
        return addressvalidation;
_L2:
        if (TextUtils.isEmpty(address.addressFields.street1))
        {
            return AddressValidation.BAD_STREET1;
        }
        if (TextUtils.isEmpty(address.addressFields.city))
        {
            return AddressValidation.BAD_CITY;
        }
        if (countryHasStatesOrProvinces(address.addressFields.country) && (TextUtils.isEmpty(address.addressFields.stateOrProvince) || "--".equals(address.addressFields.stateOrProvince)))
        {
            return AddressValidation.BAD_STATE_OR_PROVINCE;
        }
        if (TextUtils.isEmpty(address.addressFields.country))
        {
            return AddressValidation.BAD_COUNTRY_CODE;
        }
        if (!countryCodesWithoutPostalCodes.contains(address.addressFields.country) && TextUtils.isEmpty(address.addressFields.postalCode))
        {
            return AddressValidation.BAD_POSTAL_CODE;
        }
        if (TextUtils.isEmpty(address.addressFields.phone))
        {
            break; /* Loop/switch isn't completed */
        }
        addressvalidation = addressvalidation1;
        if (EbayPhoneNumberUtil.formatPhoneNumberNational(address.addressFields.phone, address.addressFields.country) == null)
        {
            return AddressValidation.BAD_PHONE;
        }
        if (true) goto _L4; else goto _L3
_L3:
        addressvalidation = addressvalidation1;
        if (cart != null)
        {
            addressvalidation = addressvalidation1;
            if (cart.isPhoneNumberRequired())
            {
                addressvalidation = addressvalidation1;
                if (TextUtils.isEmpty(address.addressFields.phone))
                {
                    return AddressValidation.PHONE_NUMBER_REQUIRED;
                }
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    private String valueOrEmptyString(String s)
    {
        String s1 = s;
        if (TextUtils.isEmpty(s))
        {
            s1 = "";
        }
        return s1;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (i == RESULT_SHIPPING_COUNTRY.intValue() && j == -1 && j == -1)
        {
            if ((intent = (EbayCountry)intent.getParcelableExtra("extraCountry")) != null)
            {
                currentAddress.addressFields.countryName = EbayCountryManager.getCountryWithLanguageName(getResources(), intent);
                currentAddress.addressFields.country = intent.getCountryCode();
                setCountryUi();
                return;
            }
        }
    }

    public void onAddressUpdated(AddressDataManager addressdatamanager, Content content)
    {
        if (!isFinishing())
        {
            ResultStatus resultstatus = content.getStatus();
            AddressResponseData addressresponsedata = (AddressResponseData)content.getData();
            if (!resultstatus.hasError() && !resultstatus.hasWarning())
            {
                currentAddress.setAddressId(addressresponsedata.addressId);
                super.onAddressUpdated(addressdatamanager, content);
                allDone(true);
                return;
            }
            if (!checkForIafTokenFailure(resultstatus.getMessages()))
            {
                if (addressresponsedata != null)
                {
                    addressdatamanager = addressresponsedata.getAddress();
                    if (addressdatamanager != null && addressresponsedata.addressModified)
                    {
                        if (addressresponsedata.modifiedFields.contactNameChanged)
                        {
                            currentAddress.addressFields.name = ((Address) (addressdatamanager)).addressFields.name;
                        }
                        if (addressresponsedata.modifiedFields.addressLine1Changed)
                        {
                            currentAddress.addressFields.street1 = ((Address) (addressdatamanager)).addressFields.street1;
                        }
                        if (addressresponsedata.modifiedFields.addressLine2Changed)
                        {
                            currentAddress.addressFields.street2 = ((Address) (addressdatamanager)).addressFields.street2;
                        }
                        if (addressresponsedata.modifiedFields.cityChanged)
                        {
                            currentAddress.addressFields.city = ((Address) (addressdatamanager)).addressFields.city;
                        }
                        if (addressresponsedata.modifiedFields.postalCodeChanged)
                        {
                            currentAddress.addressFields.postalCode = ((Address) (addressdatamanager)).addressFields.postalCode;
                        }
                        if (addressresponsedata.modifiedFields.stateChanged)
                        {
                            currentAddress.addressFields.stateOrProvince = ((Address) (addressdatamanager)).addressFields.stateOrProvince;
                        }
                        if (addressresponsedata.modifiedFields.countryChanged)
                        {
                            currentAddress.addressFields.country = ((Address) (addressdatamanager)).addressFields.country;
                        }
                        if (addressresponsedata.modifiedFields.phoneNoChanged)
                        {
                            currentAddress.addressFields.phone = ((Address) (addressdatamanager)).addressFields.phone;
                        }
                        setCheckoutResult(-1, null);
                        startingAddress = new Address(currentAddress);
                        serviceModifiedAddressDuringAddOrEdit = addressresponsedata.addressModified;
                        resetUi(true);
                        dialogManager.showDynamicAlertDialog(getString(0x7f070130), getString(0x7f070bfa), false);
                        return;
                    }
                }
                content = resultstatus.getMessages();
                addressdatamanager = (new StringBuilder()).append(getString(0x7f070beb)).append("\n");
                for (content = content.iterator(); content.hasNext();)
                {
                    com.ebay.nautilus.kernel.content.ResultStatus.Message message = (com.ebay.nautilus.kernel.content.ResultStatus.Message)content.next();
                    CheckoutError checkouterror = CheckoutError.mapCheckoutError(BaseCheckoutActivity.Operation.ADDRESS_DATA_MANAGER, message.getLongMessage(getEbayContext()));
                    if (addressdatamanager.length() > 0)
                    {
                        addressdatamanager.append("\n");
                    }
                    if (checkouterror != null)
                    {
                        addressdatamanager.append(checkouterror.getMappedErrorString(this));
                    } else
                    {
                        addressdatamanager.append(message.getLongMessage(getEbayContext()));
                    }
                }

                if (addressdatamanager.length() > 0)
                {
                    dialogManager.showDynamicAlertDialog(null, addressdatamanager.toString(), false);
                    resetUi(true);
                    return;
                }
            }
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131755176: 
            saveAddress();
            return;

        case 2131755175: 
            currentAddress = new Address(startingAddress);
            updateUi();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        int i;
        if (bundle != null)
        {
            errorCode = bundle.getString("error_code");
            startingAddress = (Address)bundle.getParcelable("address_to_edit");
            currentAddress = (Address)bundle.getParcelable("current_address");
            isEditingExistingAddress = bundle.getBoolean("is_editing");
            serviceModifiedAddressDuringAddOrEdit = bundle.getBoolean("serviceModifiedAddress", false);
        } else
        {
            if (getIntent().hasExtra("address_to_edit"))
            {
                isEditingExistingAddress = true;
            }
            startingAddress = getStartingAddress();
            currentAddress = new Address(startingAddress);
            serviceModifiedAddressDuringAddOrEdit = false;
        }
        createUi();
        updateUi();
        if (getIntent().getBooleanExtra("address_focus_phone", false))
        {
            bundle = findViewById(0x7f1000a0);
        } else
        {
            bundle = findViewById(0x7f10009f);
        }
        bundle.requestFocus();
        bundle.setSelected(true);
        ((InputMethodManager)getSystemService("input_method")).toggleSoftInput(2, 0);
        addressType = getIntent().getStringExtra("address_type");
        if (isEditingExistingAddress)
        {
            i = 0x7f070c1d;
        } else
        {
            i = 0x7f070bd5;
        }
        setTitle(i);
        hideCloseButton();
        showBackButton();
    }

    public void onError(BaseCheckoutActivity.Operation operation, boolean flag, IOException ioexception)
    {
        boolean flag1 = false;
        if (isFinishing())
        {
            return;
        }
        enableProgressDialog(false, false);
        operation = dialogManager;
        String s = getString(0x7f070130);
        ioexception = CheckoutError.getConnectionError(getResources(), flag, ioexception);
        if (flag)
        {
            flag = flag1;
        } else
        {
            flag = true;
        }
        operation.showDynamicAlertDialog(s, ioexception, flag);
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4 && keyevent.getRepeatCount() == 0)
        {
            allDone(false);
        }
        return super.onKeyDown(i, keyevent);
    }

    public void onPartialFailure(BaseCheckoutActivity.Operation operation, JsonModel jsonmodel)
    {
    }

    protected void onPause()
    {
        super.onPause();
        Util.hideSoftInput(this, findViewById(0x1020002));
    }

    protected void onResume()
    {
        super.onResume();
        (new TrackingData("CheckoutNewShippingAddress", TrackingType.PAGE_IMPRESSION)).send(this);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("error_code", errorCode);
        bundle.putParcelable("address_to_edit", startingAddress);
        bundle.putParcelable("current_address", currentAddress);
        bundle.putBoolean("is_editing", isEditingExistingAddress);
        bundle.putBoolean("serviceModifiedAddress", serviceModifiedAddressDuringAddOrEdit);
    }

    public void onSuccess(BaseCheckoutActivity.Operation operation)
    {
    }

    protected void resetUi(boolean flag)
    {
        setEditTextValue(0x7f10009f, currentAddress.addressFields.name, flag);
        setEditTextValue(0x7f1000a1, currentAddress.addressFields.street1, flag);
        setEditTextValue(0x7f1000a2, currentAddress.addressFields.street2, flag);
        setEditTextValue(0x7f1000a3, currentAddress.addressFields.city, flag);
        setEditTextValue(0x7f1000a5, currentAddress.addressFields.stateOrProvince, flag);
        setEditTextValue(0x7f1000a6, currentAddress.addressFields.postalCode, flag);
        Util.hideSoftInput(this, findViewById(0x7f10009a));
        if (flag)
        {
            ScrollView scrollview = (ScrollView)findViewById(0x7f10009a);
            scrollview.fullScroll(33);
            scrollview.pageScroll(33);
        }
        enableProgressDialog(false, false);
    }

    protected void revalidateEbayNowDeliverySlotsForAddress(Address address)
    {
        Object obj1 = MyApp.getPrefs().getAuthentication();
        if (obj1 == null || cart == null || cart.lineItems == null)
        {
            onPartialFailure(BaseCheckoutActivity.Operation.SET_SHIPPING_ADDRESS, cart);
        } else
        {
            Object obj = new ArrayList();
            Iterator iterator = cart.sellers.keySet().iterator();
label0:
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj2 = (String)iterator.next();
                Object obj3 = (com.ebay.common.model.cart.Cart.Seller)cart.sellers.get(obj2);
                if (obj3 != null)
                {
                    obj2 = ((com.ebay.common.model.cart.Cart.Seller) (obj3)).cartLineItemIds.iterator();
                    do
                    {
                        if (!((Iterator) (obj2)).hasNext())
                        {
                            continue label0;
                        }
                        obj3 = (String)((Iterator) (obj2)).next();
                        obj3 = cart.getLineItemByCartLineItemId(((String) (obj3))).getSelectedLogisticsPlan();
                    } while (obj3 == null || !((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan) (obj3)).isEbayNow());
                    obj2 = ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan) (obj3)).getReservationToken();
                    obj3 = ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan) (obj3)).getDeliveryInstructions();
                    ((List) (obj)).add(new com.ebay.common.net.api.local.EbayNowValidateTimeSlotDataManager.KeyParams(((Authentication) (obj1)).iafToken, ((String) (obj2)), address.addressFields.phone, ((String) (obj3))));
                } else
                {
                    Log.e("AddressEditActivity", (new StringBuilder()).append("revalidateEbayNowDeliverySlotsForAddress: null seller for ID: ").append(((String) (obj2))).toString());
                }
            } while (true);
            address = getDataManagerContainer();
            obj1 = new RevalidateObserver(((List) (obj)).size());
            obj = ((List) (obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                address.initialize((com.ebay.common.net.api.local.EbayNowValidateTimeSlotDataManager.KeyParams)((Iterator) (obj)).next(), obj1);
            }
        }
    }

    static 
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("AO");
        arraylist.add("AG");
        arraylist.add("AW");
        arraylist.add("BS");
        arraylist.add("BZ");
        arraylist.add("BJ");
        arraylist.add("BW");
        arraylist.add("BF");
        arraylist.add("BI");
        arraylist.add("CM");
        arraylist.add("CF");
        arraylist.add("KM");
        arraylist.add("CG");
        arraylist.add("CD");
        arraylist.add("CI");
        arraylist.add("CW");
        arraylist.add("DJ");
        arraylist.add("DM");
        arraylist.add("TL");
        arraylist.add("GQ");
        arraylist.add("ER");
        arraylist.add("FJ");
        arraylist.add("GM");
        arraylist.add("GH");
        arraylist.add("GD");
        arraylist.add("GN");
        arraylist.add("GY");
        arraylist.add("HK");
        arraylist.add("KI");
        arraylist.add("KP");
        arraylist.add("MO");
        arraylist.add("MW");
        arraylist.add("ML");
        arraylist.add("MR");
        arraylist.add("MU");
        arraylist.add("MS");
        arraylist.add("NR");
        arraylist.add("NU");
        arraylist.add("PA");
        arraylist.add("QA");
        arraylist.add("RW");
        arraylist.add("KN");
        arraylist.add("LC");
        arraylist.add("MF");
        arraylist.add("ST");
        arraylist.add("SC");
        arraylist.add("SL");
        arraylist.add("SB");
        arraylist.add("SO");
        arraylist.add("SR");
        arraylist.add("SY");
        arraylist.add("TZ");
        arraylist.add("TK");
        arraylist.add("TO");
        arraylist.add("TV");
        arraylist.add("UG");
        arraylist.add("VU");
        arraylist.add("YE");
        arraylist.add("ZW");
        countryCodesWithoutPostalCodes = Collections.unmodifiableList(arraylist);
    }
}
