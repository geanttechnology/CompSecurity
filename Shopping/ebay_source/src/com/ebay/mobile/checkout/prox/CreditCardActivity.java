// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.prox;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.model.cart.Cart;
import com.ebay.common.model.cart.JsonModel;
import com.ebay.common.view.util.DialogManager;
import com.ebay.common.view.util.EbayCountryManager;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.PreferredCountryActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.checkout.BaseCheckoutActivity;
import com.ebay.mobile.checkout.CheckoutError;
import com.ebay.mobile.common.EbayUtil;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.data.BillingAddress;
import com.ebay.nautilus.domain.data.CreditCard;
import java.io.IOException;

// Referenced classes of package com.ebay.mobile.checkout.prox:
//            ProxHelper

public final class CreditCardActivity extends BaseCheckoutActivity
{
    public final class CardNumberChangeListener extends CreditTextWatcher
    {

        final CreditCardActivity this$0;

        public void afterTextChanged(Editable editable)
        {
            if (editable == watchedView.getText())
            {
                editable = editable.toString();
                com.ebay.nautilus.domain.data.CreditCard.Type type = com.ebay.nautilus.domain.data.CreditCard.Type.fromCardNumber(editable);
                if (type.cvvLength() == 4)
                {
                    cvc.setHint(0x7f0707f1);
                } else
                {
                    cvc.setHint(0x7f0707f0);
                }
                setCurrentType(type);
                if (!TextUtils.isEmpty(editable))
                {
                    int i = editable.length();
                    String s = com.ebay.nautilus.domain.data.CreditCard.Number.formatString(editable);
                    if (i < s.length())
                    {
                        safeSetTextAfterTextChanged(s);
                    }
                    if (com.ebay.nautilus.domain.data.CreditCard.Number.hasFullLength(editable))
                    {
                        if (com.ebay.nautilus.domain.data.CreditCard.Number.passesLuhnChecksum(editable))
                        {
                            watchedView.setTextColor(baseColor);
                            requestFocusIfNotMasked(expiration);
                            return;
                        } else
                        {
                            watchedView.setTextColor(errorColor);
                            return;
                        }
                    }
                    if (type == com.ebay.nautilus.domain.data.CreditCard.Type.UNKNOWN || type == com.ebay.nautilus.domain.data.CreditCard.Type.INSUFFICIENT_DIGITS)
                    {
                        if (!editable.contains("\u2022"))
                        {
                            watchedView.setTextColor(errorColor);
                            return;
                        }
                    } else
                    {
                        watchedView.setTextColor(baseColor);
                        return;
                    }
                }
            }
        }

        public CardNumberChangeListener(EditText edittext)
        {
            this$0 = CreditCardActivity.this;
            super(edittext);
        }
    }

    public static class CreditTextWatcher
        implements TextWatcher
    {

        protected final int baseColor;
        protected final int errorColor;
        protected final EditText watchedView;

        public void afterTextChanged(Editable editable)
        {
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        protected void safeSetTextAfterTextChanged(String s)
        {
            watchedView.removeTextChangedListener(this);
            watchedView.setText(s);
            watchedView.setSelection(s.length());
            watchedView.addTextChangedListener(this);
        }

        public CreditTextWatcher(EditText edittext)
        {
            watchedView = edittext;
            baseColor = edittext.getTextColors().getDefaultColor();
            errorColor = edittext.getResources().getColor(0x7f0d009b);
        }
    }

    public final class CvcChangeListener extends CreditTextWatcher
    {

        final CreditCardActivity this$0;

        public void afterTextChanged(Editable editable)
        {
            Object obj;
            if (editable == watchedView.getText())
            {
                obj = cardNumber.getText().toString();
                editable = editable.toString();
                break MISSING_BLOCK_LABEL_30;
            }
_L1:
            return;
            if (!TextUtils.isEmpty(editable) && com.ebay.nautilus.domain.data.CreditCard.Number.hasFullLength(((String) (obj))) && com.ebay.nautilus.domain.data.CreditCard.Number.passesLuhnChecksum(((String) (obj))))
            {
                obj = com.ebay.nautilus.domain.data.CreditCard.Type.fromCardNumber(((String) (obj)));
                if (editable.length() == ((com.ebay.nautilus.domain.data.CreditCard.Type) (obj)).cvvLength())
                {
                    requestFocusIfNotMasked(cardholderName);
                    return;
                }
            }
              goto _L1
        }

        public CvcChangeListener(EditText edittext)
        {
            this$0 = CreditCardActivity.this;
            super(edittext);
        }
    }

    public final class ExpirationChangeListener extends CreditTextWatcher
    {

        final CreditCardActivity this$0;

        public void afterTextChanged(Editable editable)
        {
            if (editable == watchedView.getText())
            {
                editable = editable.toString();
                if (!TextUtils.isEmpty(editable))
                {
                    safeSetTextAfterTextChanged(com.ebay.nautilus.domain.data.CreditCard.Expiration.format(editable));
                    if (com.ebay.nautilus.domain.data.CreditCard.Expiration.hasFullLength(editable))
                    {
                        if (com.ebay.nautilus.domain.data.CreditCard.Expiration.isValid(editable))
                        {
                            watchedView.setTextColor(baseColor);
                            requestFocusIfNotMasked(cvc);
                            return;
                        } else
                        {
                            watchedView.setTextColor(errorColor);
                            return;
                        }
                    }
                }
            }
        }

        public ExpirationChangeListener(EditText edittext)
        {
            this$0 = CreditCardActivity.this;
            super(edittext);
        }
    }


    private static final String EXTRA_ADDRESS_CITY = "addressCity";
    private static final String EXTRA_ADDRESS_COUNTRY = "addressCountry";
    private static final String EXTRA_ADDRESS_COUNTRY_TAG = "addressCountryTag";
    private static final String EXTRA_ADDRESS_LINE_1 = "addressLine1";
    private static final String EXTRA_ADDRESS_LINE_2 = "addressLine2";
    private static final String EXTRA_ADDRESS_POSTAL_CODE = "addressPostalCode";
    private static final String EXTRA_ADDRESS_STATE = "addressState";
    private static final String EXTRA_CARDHOLDER_NAME = "cardholderName";
    private static final String EXTRA_CARD_NUMBER = "cardNumber";
    private static final String EXTRA_CVC = "cvc";
    private static final String EXTRA_EXPIRATION = "expiration";
    public static final String EXTRA_FUNDING_INSTRUMENT_ID = "fundingInstrumentId";
    private static final int RESULT_SELECT_COUNTRY = 0x61665;
    private EditText addressCity;
    private TextView addressCountry;
    private EditText addressLine1;
    private EditText addressLine2;
    private EditText addressPostalCode;
    private Spinner addressState;
    private Drawable amexDrawable;
    private ImageView amexImageView;
    private EditText cardNumber;
    private CardNumberChangeListener cardNumberChangeListener;
    private EditText cardholderName;
    private EditText cvc;
    private CvcChangeListener cvcChangeListener;
    protected final DialogManager dialogManager = (DialogManager)getShim(com/ebay/common/view/util/DialogManager);
    private Drawable discoverDrawable;
    private ImageView discoverImageView;
    private EditText expiration;
    private ExpirationChangeListener expirationChangeListener;
    private ColorFilter grayscaleFilter;
    private Drawable mastercardDrawable;
    private ImageView mastercardImageView;
    private Drawable visaDrawable;
    private ImageView visaImageView;

    public CreditCardActivity()
    {
    }

    private void addFundingInstrumentFromFormData()
    {
        CreditCard creditcard = new CreditCard();
        creditcard.cardNumber = CreditCard.getDigitsOnlyString(cardNumber.getText().toString());
        creditcard.type = com.ebay.nautilus.domain.data.CreditCard.Type.fromCardNumber(creditcard.cardNumber);
        creditcard.expireMonth = Integer.parseInt(expiration.getText().toString().substring(0, 2));
        creditcard.expireYear = Integer.parseInt(expiration.getText().toString().substring(3)) + 2000;
        creditcard.cvvNumber = cvc.getText().toString();
        creditcard.accountHolderName = cardholderName.getText().toString().trim();
        creditcard.billingAddress = getBillingAddressFromFormData();
        creditcard.billingAddress.setFirstLastNameFromFullNameString(creditcard.accountHolderName);
        apiAddCreditCard(creditcard);
    }

    private void addOrUpdateFundingInstrumentFromFormData()
    {
        if (temporaryFundingInstrumentId != null && cardNumber.getText().toString().contains("\u2022") && cvc.getText().toString().contains("\u2022"))
        {
            if (validateForm(true))
            {
                updateFundingInstrumentFromFormData();
            }
        } else
        if (validateForm(false))
        {
            addFundingInstrumentFromFormData();
            return;
        }
    }

    private void clearBulletedFieldsToNullOnFocus(View view)
    {
        if (temporaryFundingInstrumentId != null)
        {
            int i = view.getId();
            if (i == 0x7f100511 || i == 0x7f100515)
            {
                cardNumber.setText(null);
                cvc.setText(null);
                temporaryFundingInstrumentId = null;
            }
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

    private void requestFocusIfNotMasked(EditText edittext)
    {
        while (cardNumber.getText().toString().contains("\u2022") || cvc.getText().toString().contains("\u2022")) 
        {
            return;
        }
        edittext.requestFocus();
    }

    private void updateFormWithCreditCard(CreditCard creditcard)
    {
        if (creditcard == null) goto _L2; else goto _L1
_L1:
        EbayCountry ebaycountry;
        cardNumber.setText(creditcard.getMaskedNumber());
        expiration.setText(CreditCard.renderExpirationDate(creditcard));
        cvc.setText(creditcard.getMaskedCvv());
        cardholderName.setText(creditcard.accountHolderName);
        ebaycountry = EbayCountry.getInstance(creditcard.billingAddress.countryCode);
        addressCountry.setText(EbayCountryManager.getCountryWithLanguageName(getResources(), ebaycountry));
        addressCountry.setTag(ebaycountry);
        addressLine1.setText(creditcard.billingAddress.streetAddress);
        addressLine2.setText(creditcard.billingAddress.streetAddress2);
        addressCity.setText(creditcard.billingAddress.city);
        if (creditcard.billingAddress.state == null) goto _L4; else goto _L3
_L3:
        ArrayAdapter arrayadapter = (ArrayAdapter)addressState.getAdapter();
        if (arrayadapter == null) goto _L4; else goto _L5
_L5:
        int i = 0;
_L10:
        if (i >= arrayadapter.getCount()) goto _L4; else goto _L6
_L6:
        if (!((CharSequence)arrayadapter.getItem(i)).toString().equals(creditcard.billingAddress.state)) goto _L8; else goto _L7
_L7:
        addressState.setSelection(i);
_L4:
        addressPostalCode.setText(creditcard.billingAddress.postalCode);
        ProxHelper.updateInputFormForCountry(this, findViewById(0x1020002), ebaycountry, creditcard.billingAddress.state);
        setCurrentType(creditcard.type);
_L2:
        return;
_L8:
        i++;
        if (true) goto _L10; else goto _L9
_L9:
    }

    private void updateFundingInstrumentFromFormData()
    {
        CreditCard creditcard = new CreditCard();
        creditcard.expireMonth = Integer.parseInt(expiration.getText().toString().substring(0, 2));
        creditcard.expireYear = Integer.parseInt(expiration.getText().toString().substring(3)) + 2000;
        creditcard.accountHolderName = cardholderName.getText().toString().trim();
        creditcard.billingAddress = getBillingAddressFromFormData();
        creditcard.billingAddress.setFirstLastNameFromFullNameString(creditcard.accountHolderName);
        if (creditcard.billingAddress.equals(creditCard.billingAddress) && creditcard.accountHolderName.equals(creditCard.accountHolderName) && creditcard.expireYear == creditCard.expireYear && creditcard.expireMonth == creditCard.expireMonth)
        {
            finish();
            return;
        } else
        {
            apiUpdateCreditCard(temporaryFundingInstrumentId, creditcard);
            return;
        }
    }

    private boolean validateForm(boolean flag)
    {
        boolean flag1;
label0:
        {
            Object obj;
label1:
            {
                flag1 = true;
                boolean flag2 = true;
                if (flag)
                {
                    break label0;
                }
                obj = cardNumber.getText().toString();
                if (com.ebay.nautilus.domain.data.CreditCard.Number.hasFullLength(((String) (obj))))
                {
                    flag1 = flag2;
                    if (com.ebay.nautilus.domain.data.CreditCard.Number.passesLuhnChecksum(((String) (obj))))
                    {
                        break label1;
                    }
                }
                flag1 = false;
            }
            obj = com.ebay.nautilus.domain.data.CreditCard.Type.fromCardNumber(((String) (obj)));
            if (cvc.length() != ((com.ebay.nautilus.domain.data.CreditCard.Type) (obj)).cvvLength())
            {
                flag1 = false;
            }
        }
        String s = expiration.getText().toString();
        if (!com.ebay.nautilus.domain.data.CreditCard.Expiration.hasFullLength(s) || !com.ebay.nautilus.domain.data.CreditCard.Expiration.isValid(s))
        {
            flag1 = false;
        }
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
        if (findViewById(0x7f100508).getVisibility() == 0)
        {
            flag1 = flag;
            if (addressState.getSelectedItem() == null)
            {
                flag1 = false;
            }
        }
        if (addressPostalCode.length() == 0)
        {
            flag1 = false;
        }
        if (cardholderName.length() == 0 || cardholderName.getText().toString().trim().length() == 0)
        {
            flag1 = false;
        }
        if (!flag1)
        {
            dialogManager.showDynamicAlertDialog(getString(0x7f070130), getString(0x7f0707e3), false);
        }
        return flag1;
    }

    public String getTrackingEventName()
    {
        return "CreditCard";
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 0x61665 && j == -1)
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

    public void onCreate(final Bundle shippingAddress)
    {
        super.onCreate(shippingAddress);
        setContentView(0x7f0301b0);
        shippingAddress = (TextView)findViewById(0x7f100518);
        String s = com.ebay.common.view.util.EbayCountryManager.Default.payPalGuestCheckoutTnCUrl(MyApp.getPrefs().getCurrentCountry());
        if (s != null)
        {
            shippingAddress.setText(EbayUtil.removeUnderlinesFromHtmlLinks(getString(0x7f0700a0, new Object[] {
                s
            })));
            shippingAddress.setMovementMethod(LinkMovementMethod.getInstance());
            shippingAddress.setVisibility(0);
        } else
        {
            shippingAddress.setVisibility(8);
        }
        shippingAddress = new ColorMatrix();
        shippingAddress.setSaturation(0.0F);
        grayscaleFilter = new ColorMatrixColorFilter(shippingAddress);
        cardNumber = (EditText)findViewById(0x7f100511);
        expiration = (EditText)findViewById(0x7f100513);
        cvc = (EditText)findViewById(0x7f100515);
        cardholderName = (EditText)findViewById(0x7f100517);
        addressCountry = (TextView)findViewById(0x7f100500);
        addressLine1 = (EditText)findViewById(0x7f100503);
        addressLine2 = (EditText)findViewById(0x7f100504);
        addressCity = (EditText)findViewById(0x7f100505);
        addressState = (Spinner)findViewById(0x7f100506);
        addressPostalCode = (EditText)findViewById(0x7f100509);
        shippingAddress = cart.getBuyerShippingAddress();
        if (shippingAddress != null && ((Address) (shippingAddress)).addressFields != null)
        {
            com.ebay.nautilus.domain.data.Address.AddressFields addressfields = ((Address) (shippingAddress)).addressFields;
            EbayCountry ebaycountry = EbayCountry.getInstance(addressfields.country);
            addressCountry.setText(EbayCountryManager.getCountryWithLanguageName(getResources(), ebaycountry));
            addressCountry.setTag(ebaycountry);
            ProxHelper.updateInputFormForCountry(this, findViewById(0x1020002), ebaycountry, addressfields.stateOrProvince);
            addressLine1.setText(addressfields.street1);
            addressLine2.setText(addressfields.street2);
            addressCity.setText(addressfields.city);
            addressPostalCode.setText(addressfields.postalCode);
        }
        findViewById(0x7f1004fe).setOnClickListener(new android.view.View.OnClickListener() {

            final CreditCardActivity this$0;
            final Address val$shippingAddress;

            public void onClick(View view)
            {
                view = new Intent(CreditCardActivity.this, com/ebay/mobile/activities/PreferredCountryActivity);
                if (shippingAddress != null)
                {
                    view.putExtra("extraCountry", EbayCountry.getInstance(shippingAddress.addressFields.country));
                }
                startActivityForResult(view, 0x61665);
            }

            
            {
                this$0 = CreditCardActivity.this;
                shippingAddress = address;
                super();
            }
        });
        visaImageView = (ImageView)findViewById(0x7f10050f);
        visaDrawable = visaImageView.getDrawable();
        amexImageView = (ImageView)findViewById(0x7f10050e);
        amexDrawable = amexImageView.getDrawable();
        discoverImageView = (ImageView)findViewById(0x7f10050c);
        discoverDrawable = discoverImageView.getDrawable();
        mastercardImageView = (ImageView)findViewById(0x7f10050d);
        mastercardDrawable = mastercardImageView.getDrawable();
        cardNumberChangeListener = new CardNumberChangeListener(cardNumber);
        expirationChangeListener = new ExpirationChangeListener(expiration);
        cvcChangeListener = new CvcChangeListener(cvc);
        setCurrentType(com.ebay.nautilus.domain.data.CreditCard.Type.UNKNOWN);
        findViewById(0x7f100502).setVisibility(8);
    }

    public void onError(com.ebay.mobile.checkout.BaseCheckoutActivity.Operation operation, boolean flag, IOException ioexception)
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
        if (!flag)
        {
            flag1 = true;
        }
        operation.showDynamicAlertDialog(s, ioexception, flag1);
    }

    public void onPartialFailure(com.ebay.mobile.checkout.BaseCheckoutActivity.Operation operation, JsonModel jsonmodel)
    {
        String s = jsonmodel.getErrorId();
        operation = CheckoutError.mapCheckoutError(operation, s);
        if (operation == null)
        {
            jsonmodel = jsonmodel.getErrorMessage();
            if (jsonmodel != null)
            {
                operation = jsonmodel;
                if (!TextUtils.isEmpty(s))
                {
                    operation = (new StringBuilder()).append(jsonmodel).append(" (").append(s).append(")").toString();
                }
            } else
            {
                operation = getString(0x7f0707e2);
            }
            dialogManager.showDynamicAlertDialog(null, operation, false);
        } else
        {
            boolean flag = operation.shouldAbortOnError();
            if (flag)
            {
                setResult(503);
            }
            dialogManager.showDynamicAlertDialog(null, operation.getErrorString(this), flag);
        }
        enableProgressDialog(false, false);
    }

    protected void onPause()
    {
        if (cardNumber != null)
        {
            cardNumber.removeTextChangedListener(cardNumberChangeListener);
            cardNumber.setOnFocusChangeListener(null);
        }
        if (expiration != null)
        {
            expiration.removeTextChangedListener(expirationChangeListener);
            expiration.setOnFocusChangeListener(null);
        }
        if (cvc != null)
        {
            cvc.removeTextChangedListener(cvcChangeListener);
            cvc.setOnFocusChangeListener(null);
        }
        super.onPause();
    }

    protected void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        setDoneButtonOnClickListener(new android.view.View.OnClickListener() {

            final CreditCardActivity this$0;

            public void onClick(View view)
            {
                ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                addOrUpdateFundingInstrumentFromFormData();
            }

            
            {
                this$0 = CreditCardActivity.this;
                super();
            }
        });
        android.view.View.OnFocusChangeListener onfocuschangelistener = new android.view.View.OnFocusChangeListener() {

            final CreditCardActivity this$0;

            public void onFocusChange(View view, boolean flag)
            {
                if (flag)
                {
                    clearBulletedFieldsToNullOnFocus(view);
                    getWindow().setSoftInputMode(5);
                }
            }

            
            {
                this$0 = CreditCardActivity.this;
                super();
            }
        };
        cardNumber.setOnFocusChangeListener(onfocuschangelistener);
        expiration.setOnFocusChangeListener(onfocuschangelistener);
        cvc.setOnFocusChangeListener(onfocuschangelistener);
        if (bundle == null)
        {
            bundle = getIntent().getStringExtra("fundingInstrumentId");
            if (bundle != null && !bundle.startsWith("TC_"))
            {
                apiGetFundingInstrument(bundle);
            }
        }
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        cardNumber.setText(bundle.getString("cardNumber", ""));
        expiration.setText(bundle.getString("expiration", ""));
        cvc.setText(bundle.getString("cvc", ""));
        cardholderName.setText(bundle.getString("cardholderName", ""));
        addressCountry.setText(bundle.getString("addressCountry", ""));
        EbayCountry ebaycountry = (EbayCountry)bundle.getParcelable("addressCountryTag");
        addressCountry.setTag(ebaycountry);
        addressLine1.setText(bundle.getString("addressLine1", ""));
        addressLine2.setText(bundle.getString("addressLine2", ""));
        addressCity.setText(bundle.getString("addressCity", ""));
        addressPostalCode.setText(bundle.getString("addressPostalCode", ""));
        bundle = bundle.getString("addressState", "");
        ProxHelper.updateInputFormForCountry(this, findViewById(0x1020002), ebaycountry, bundle);
    }

    protected void onResume()
    {
        super.onResume();
        if (cardNumber != null)
        {
            cardNumber.addTextChangedListener(cardNumberChangeListener);
        }
        if (expiration != null)
        {
            expiration.addTextChangedListener(expirationChangeListener);
        }
        if (cvc != null)
        {
            cvc.addTextChangedListener(cvcChangeListener);
        }
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).addSourceIdentification(getIntent()).send(this);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("cardNumber", cardNumber.getText().toString());
        bundle.putString("expiration", expiration.getText().toString());
        bundle.putString("cvc", cvc.getText().toString());
        bundle.putString("cardholderName", cardholderName.getText().toString());
        bundle.putString("addressCountry", addressCountry.getText().toString());
        bundle.putParcelable("addressCountryTag", (EbayCountry)addressCountry.getTag());
        bundle.putString("addressLine1", addressLine1.getText().toString());
        bundle.putString("addressLine2", addressLine2.getText().toString());
        bundle.putString("addressCity", addressCity.getText().toString());
        bundle.putString("addressState", (String)addressState.getSelectedItem());
        bundle.putString("addressPostalCode", addressPostalCode.getText().toString());
    }

    public void onSuccess(com.ebay.mobile.checkout.BaseCheckoutActivity.Operation operation)
    {
        if (isFinishing())
        {
            return;
        }
        static class _cls4
        {

            static final int $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[];
            static final int $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[];

            static 
            {
                $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type = new int[com.ebay.nautilus.domain.data.CreditCard.Type.values().length];
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[com.ebay.nautilus.domain.data.CreditCard.Type.VISA.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[com.ebay.nautilus.domain.data.CreditCard.Type.AMERICANEXPRESS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[com.ebay.nautilus.domain.data.CreditCard.Type.DISCOVER.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$CreditCard$Type[com.ebay.nautilus.domain.data.CreditCard.Type.MASTERCARD.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation = new int[com.ebay.mobile.checkout.BaseCheckoutActivity.Operation.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[com.ebay.mobile.checkout.BaseCheckoutActivity.Operation.ADD_CREDIT_CARD.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[com.ebay.mobile.checkout.BaseCheckoutActivity.Operation.UPDATE_CREDIT_CARD.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[com.ebay.mobile.checkout.BaseCheckoutActivity.Operation.GET_FUNDING_INSTRUMENT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls4..SwitchMap.com.ebay.mobile.checkout.BaseCheckoutActivity.Operation[operation.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
            setCheckoutResult(-1, (new Intent()).putExtra("fundingInstrumentId", temporaryFundingInstrumentId));
            finish();
            return;

        case 3: // '\003'
            updateFormWithCreditCard(creditCard);
            break;
        }
        enableProgressDialog(false, false);
    }

    protected void setCurrentType(com.ebay.nautilus.domain.data.CreditCard.Type type)
    {
        switch (_cls4..SwitchMap.com.ebay.nautilus.domain.data.CreditCard.Type[type.ordinal()])
        {
        default:
            amexDrawable.clearColorFilter();
            discoverDrawable.clearColorFilter();
            mastercardDrawable.clearColorFilter();
            visaDrawable.clearColorFilter();
            return;

        case 1: // '\001'
            amexDrawable.setColorFilter(grayscaleFilter);
            discoverDrawable.setColorFilter(grayscaleFilter);
            mastercardDrawable.setColorFilter(grayscaleFilter);
            visaDrawable.clearColorFilter();
            return;

        case 2: // '\002'
            amexDrawable.clearColorFilter();
            discoverDrawable.setColorFilter(grayscaleFilter);
            mastercardDrawable.setColorFilter(grayscaleFilter);
            visaDrawable.setColorFilter(grayscaleFilter);
            return;

        case 3: // '\003'
            amexDrawable.setColorFilter(grayscaleFilter);
            discoverDrawable.clearColorFilter();
            mastercardDrawable.setColorFilter(grayscaleFilter);
            visaDrawable.setColorFilter(grayscaleFilter);
            return;

        case 4: // '\004'
            amexDrawable.setColorFilter(grayscaleFilter);
            break;
        }
        discoverDrawable.setColorFilter(grayscaleFilter);
        mastercardDrawable.clearColorFilter();
        visaDrawable.setColorFilter(grayscaleFilter);
    }







}
