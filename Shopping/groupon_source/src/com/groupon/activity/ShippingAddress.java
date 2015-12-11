// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.groupon.Channel;
import com.groupon.db.models.Deal;
import com.groupon.db.models.DealSummary;
import com.groupon.loader.DealLoaderCallbacks;
import com.groupon.models.country.Country;
import com.groupon.models.dealbreakdown.DealBreakdownAddress;
import com.groupon.models.shipping.ShippingField;
import com.groupon.service.ShippingService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.ContextUtils;
import com.groupon.util.DealUtils;
import com.groupon.util.LoggingUtils;
import com.groupon.util.LowerCaseFirstCharacter;
import com.groupon.util.ZipCodeAutoComplete;
import com.groupon.view.DealCardCompact;
import com.groupon.view.GrouponCheckMark;
import com.groupon.view.ShippingEditText;
import com.groupon.view.SpinnerButton;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity

public class ShippingAddress extends GrouponActivity
{

    private static final String COUNTRY_CODE_KEY = "country_key";
    public static final int REQUEST_CODE = 10119;
    private static final String SHIPPING_FIRST_LAST_NAME = "firstLastName";
    public static final String SHIPPING_STATE_RESOURCE_NAME = "shipping_state_";
    private static final String STATE_KEY = "state_key";
    private static final String STRING = "string";
    private static final String USE_BILLING_AS_SHIPPING_CHECK_STATE = "use_billing_as_shipping_check_state";
    String cartDealImageUrl;
    protected String cartUUID;
    Channel channel;
    protected String countryCode;
    protected CurrentCountryManager currentCountryManager;
    DealCardCompact dealCardCompact;
    protected String dealId;
    DealBreakdownAddress defaultAddress;
    protected LayoutInflater inflater;
    boolean isMasterAddress;
    protected boolean isUSACompatible;
    Integer itemsCount;
    protected LoggingUtils loggingUtils;
    String maxCartDiscount;
    Intent next;
    String optionId;
    protected DealBreakdownAddress otherAddress;
    private SharedPreferences prefs;
    TextView secureConnectionView;
    protected LinearLayout shippingAddressLayout;
    protected Spinner shippingCountry;
    EditText shippingFirstName;
    EditText shippingLastName;
    ScrollView shippingScrollView;
    protected ShippingService shippingService;
    protected Spinner shippingState;
    protected SpinnerButton submitButton;
    protected Spinner titleSpinner;
    private boolean useBillingAsShipping;
    CheckBox useBillingAsShippingCheckBox;
    GrouponCheckMark useBillingAsShippingCheckMark;
    View useBillingAsShippingContainer;
    private ZipCodeAutoComplete zipCodeAutoComplete;

    public ShippingAddress()
    {
        useBillingAsShipping = true;
    }

    private void onUseBillingAsShippingCheckedChanged(boolean flag)
    {
        initializeSpinners();
        DealBreakdownAddress dealbreakdownaddress;
        if (flag)
        {
            dealbreakdownaddress = defaultAddress;
        } else
        if (otherAddress != null)
        {
            dealbreakdownaddress = otherAddress;
        } else
        {
            dealbreakdownaddress = new DealBreakdownAddress();
        }
        fillTextFields(dealbreakdownaddress);
    }

    private void populateFields()
    {
        byte byte0;
        boolean flag;
        if (!hasBillingAddress() || currentCountryManager.getCurrentCountry().isJapan())
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        if (useBillingAsShippingCheckBox != null)
        {
            useBillingAsShippingCheckBox.setVisibility(byte0);
        } else
        if (useBillingAsShippingContainer != null)
        {
            useBillingAsShippingContainer.setVisibility(byte0);
            useBillingAsShippingContainer.setOnClickListener(new android.view.View.OnClickListener() {

                final ShippingAddress this$0;

                public void onClick(View view)
                {
                    useBillingAsShippingCheckMark.toggle();
                }

            
            {
                this$0 = ShippingAddress.this;
                super();
            }
            });
        }
        if (useBillingAsShipping && getBillingAddressInstance() != null && otherAddress == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (useBillingAsShippingCheckBox != null)
        {
            useBillingAsShippingCheckBox.setChecked(flag);
        } else
        if (useBillingAsShippingCheckMark != null)
        {
            useBillingAsShippingCheckMark.setChecked(flag);
        }
_L7:
        if (flag && getBillingAddressInstance() != null)
        {
            fillTextFields(getBillingAddressInstance());
        } else
        if (otherAddress != null)
        {
            fillTextFields(otherAddress);
        }
        if (getBillingAddressInstance() == null) goto _L2; else goto _L1
_L1:
        if (useBillingAsShippingCheckBox == null) goto _L4; else goto _L3
_L3:
        useBillingAsShippingCheckBox.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final ShippingAddress this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag1)
            {
                onUseBillingAsShippingCheckedChanged(flag1);
            }

            
            {
                this$0 = ShippingAddress.this;
                super();
            }
        });
_L2:
        return;
_L4:
        if (useBillingAsShippingCheckMark == null) goto _L2; else goto _L5
_L5:
        useBillingAsShippingCheckMark.setOnCheckedChangeListener(new com.groupon.view.GrouponCheckMark.OnCheckedChangeListener() {

            final ShippingAddress this$0;

            public void onCheckedChanged(View view, boolean flag1)
            {
                onUseBillingAsShippingCheckedChanged(flag1);
            }

            
            {
                this$0 = ShippingAddress.this;
                super();
            }
        });
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void setDealCardCompact()
    {
        boolean flag;
label0:
        {
            if (isUSACompatible)
            {
                if (itemsCount != null && itemsCount.intValue() > 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    break label0;
                }
                dealCardCompact.setShoppingCartInfo(itemsCount.intValue(), maxCartDiscount, cartDealImageUrl);
            }
            return;
        }
        if (dealId != null)
        {
            dealCardCompact.setLoading(true);
            getLoaderManager().initLoader(0, null, new DealLoaderCallbacks(dealId, flag) {

                final ShippingAddress this$0;
                final boolean val$isCartExperience;

                public void onDealLoaded(Deal deal)
                {
                    dealCardCompact.setInfo(new DealSummary(deal, channel), DealUtils.getOption(deal, optionId));
                }

                public void onLoadFinished(Loader loader, Deal deal)
                {
                    boolean flag1 = false;
                    super.onLoadFinished(loader, deal);
                    dealCardCompact.setLoading(false);
                    loader = dealCardCompact;
                    int i = ((flag1) ? 1 : 0);
                    if (deal == null)
                    {
                        if (isCartExperience)
                        {
                            i = ((flag1) ? 1 : 0);
                        } else
                        {
                            i = 8;
                        }
                    }
                    loader.setVisibility(i);
                }

                public volatile void onLoadFinished(Loader loader, Object obj)
                {
                    onLoadFinished(loader, (Deal)obj);
                }

            
            {
                this$0 = ShippingAddress.this;
                isCartExperience = flag;
                super(final_context, s);
            }
            });
            return;
        } else
        {
            dealCardCompact.setVisibility(8);
            return;
        }
    }

    protected void addFirstAndLastNameFields()
    {
        View view = inflater.inflate(0x7f030025, shippingAddressLayout, false);
        shippingFirstName = (EditText)view.findViewById(0x7f1000d5);
        shippingLastName = (EditText)view.findViewById(0x7f1000d6);
        shippingAddressLayout.addView(view);
    }

    protected void addShippingFieldsHeader()
    {
        View view = inflater.inflate(0x7f0301f2, shippingAddressLayout, false);
        TextView textview = (TextView)view.findViewById(0x7f1000b0);
        int i;
        if (isMasterAddress)
        {
            i = 0x7f080152;
        } else
        {
            i = 0x7f080386;
        }
        textview.setText(i);
        shippingAddressLayout.addView(view);
    }

    protected void addShippingTitleSpinner()
    {
        LayoutInflater layoutinflater = inflater;
        int i;
        if (isUSACompatible)
        {
            i = 0x7f0301f5;
        } else
        {
            i = 0x7f0301f4;
        }
        titleSpinner = (Spinner)layoutinflater.inflate(i, shippingAddressLayout, false);
        shippingAddressLayout.addView(titleSpinner);
    }

    protected void constructLayoutDynamically()
    {
        Object obj = shippingService.getShippingAddress();
        shippingAddressLayout.removeAllViews();
        if (((List) (obj)).contains("shippingTitle"))
        {
            addShippingTitleSpinner();
        }
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            String s = (String)((Iterator) (obj)).next();
            if (Strings.equalsIgnoreCase(s, "shippingTitle"))
            {
                initializeTitleSpinner();
            } else
            if (shouldAddFieldFor(s))
            {
                constructViewForField(s);
                if (!isUSACompatible && (shippingService.isFirstNameJP(s) || shippingService.isLastName(s)))
                {
                    addShippingFieldsHeader();
                }
            }
        } while (true);
        if (isUSACompatible && (currentCountryManager.getCurrentCountry().isUSACompatible() || currentCountryManager.getCurrentCountry().isBelgium() || currentCountryManager.getCurrentCountry().isUAE()))
        {
            View view = inflater.inflate(0x7f030026, shippingAddressLayout, false);
            shippingState = (Spinner)view.findViewById(0x7f1000d0);
            shippingCountry = (Spinner)view.findViewById(0x7f1000d1);
            shippingAddressLayout.addView(view);
        }
    }

    protected DealBreakdownAddress constructShippingAddress()
    {
        int j = shippingAddressLayout.getChildCount();
        Object obj = new DealBreakdownAddress();
        int i = 0;
        while (i < j) 
        {
            Object obj1 = shippingAddressLayout.getChildAt(i);
            if (obj1 instanceof ShippingEditText)
            {
                obj1 = (ShippingEditText)obj1;
                try
                {
                    obj.getClass().getDeclaredField(LowerCaseFirstCharacter.toLowerCaseFirstCharacter(((ShippingEditText) (obj1)).getJsonParam())).set(obj, Strings.toString(((ShippingEditText) (obj1)).getText()));
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new RuntimeException(((Throwable) (obj)));
                }
            }
            i++;
        }
        return ((DealBreakdownAddress) (obj));
    }

    protected View constructViewForField(String s)
    {
        s = (ShippingField)shippingService.getShippingFields().shippingFields.get(s);
        Object obj = inflater;
        ShippingEditText shippingedittext;
        String s1;
        int i;
        if (isUSACompatible)
        {
            i = 0x7f0301f1;
        } else
        {
            i = 0x7f0301f0;
        }
        obj = ((LayoutInflater) (obj)).inflate(i, shippingAddressLayout, false);
        shippingedittext = (ShippingEditText)((View) (obj)).findViewById(0x7f10051a);
        shippingedittext.setHint(ContextUtils.getIdentifier(this, ((ShippingField) (s)).hintId, "string"));
        s1 = ((ShippingField) (s)).errorMessageId;
        if (Strings.notEmpty(s1))
        {
            shippingedittext.setErrorMessage(getString(ContextUtils.getIdentifier(this, s1, "string")));
        }
        if (currentCountryManager.getCurrentCountry().isJapan())
        {
            shippingedittext.setHttpParam(((ShippingField) (s)).httpParamAlt);
        } else
        {
            shippingedittext.setHttpParam(((ShippingField) (s)).httpParam);
        }
        shippingedittext.setJsonParam(((ShippingField) (s)).jsonParam);
        shippingedittext.setInputType(((ShippingField) (s)).inputType);
        shippingedittext.setLines(((ShippingField) (s)).lines);
        shippingAddressLayout.addView(((View) (obj)));
        return shippingedittext;
    }

    protected void enableDemographicPickers(boolean flag)
    {
        if (shippingState != null && shippingCountry != null)
        {
            shippingState.setEnabled(flag);
            shippingCountry.setEnabled(flag);
        }
    }

    protected void fillSpinners(DealBreakdownAddress dealbreakdownaddress)
    {
        String as[] = getResources().getStringArray(0x7f0f0002);
        String s;
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            s = getCountryCodeForCountry(getCountry(dealbreakdownaddress));
        } else
        {
            s = getCountry(dealbreakdownaddress);
        }
        setSpinnerValue(shippingCountry, s, as);
        as = getShippingStringArray("shipping_state_", s);
        if (as == null)
        {
            return;
        }
        if (shippingCountry != null && !Strings.equalsIgnoreCase(s, Strings.toString(shippingCountry.getSelectedItem())))
        {
            initializeSpinner(shippingState, as, null);
        }
        dealbreakdownaddress = dealbreakdownaddress.state;
        setSpinnerValue(shippingState, dealbreakdownaddress, as);
        prefs.edit().putString("preferredShippingState", dealbreakdownaddress).apply();
    }

    protected void fillStaticTextFields(DealBreakdownAddress dealbreakdownaddress)
    {
        if (isUSACompatible && currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            dealbreakdownaddress = dealbreakdownaddress.name;
            if (Strings.notEmpty(dealbreakdownaddress))
            {
                dealbreakdownaddress = dealbreakdownaddress.split("\\s+", 2);
                shippingFirstName.setText(dealbreakdownaddress[0]);
                EditText edittext = shippingLastName;
                if (dealbreakdownaddress.length > 1)
                {
                    dealbreakdownaddress = dealbreakdownaddress[1];
                } else
                {
                    dealbreakdownaddress = null;
                }
                edittext.setText(dealbreakdownaddress);
            }
        }
    }

    protected void fillTextFields(DealBreakdownAddress dealbreakdownaddress)
    {
        fillSpinners(dealbreakdownaddress);
        fillStaticTextFields(dealbreakdownaddress);
        int j = shippingAddressLayout.getChildCount();
        int i = 0;
        while (i < j) 
        {
            Object obj = shippingAddressLayout.getChildAt(i);
            if (obj instanceof ShippingEditText)
            {
                obj = (ShippingEditText)obj;
                try
                {
                    ((ShippingEditText) (obj)).setText(Strings.toString(dealbreakdownaddress.getClass().getDeclaredField(LowerCaseFirstCharacter.toLowerCaseFirstCharacter(((ShippingEditText) (obj)).getJsonParam())).get(dealbreakdownaddress)));
                }
                // Misplaced declaration of an exception variable
                catch (DealBreakdownAddress dealbreakdownaddress)
                {
                    throw new RuntimeException(dealbreakdownaddress);
                }
            }
            i++;
        }
    }

    protected DealBreakdownAddress getBillingAddressInstance()
    {
        return defaultAddress;
    }

    protected String getCountry(DealBreakdownAddress dealbreakdownaddress)
    {
        dealbreakdownaddress = dealbreakdownaddress.country;
        if (dealbreakdownaddress != null)
        {
            return dealbreakdownaddress;
        } else
        {
            return prefs.getString("preferredShippingCountry", countryCode);
        }
    }

    protected String getCountryCodeForCountry(String s)
    {
        String as[] = getResources().getStringArray(0x7f0f0002);
        String as1[] = getResources().getStringArray(0x7f0f0005);
        int k = as.length;
        for (int i = 0; i < k; i++)
        {
            String s1 = as[i];
            if (Strings.equalsIgnoreCase(s, s1))
            {
                return s1;
            }
        }

        for (int j = 0; j < as1.length; j++)
        {
            if (Strings.equalsIgnoreCase(s, as1[j]))
            {
                return as[j];
            }
        }

        return countryCode;
    }

    protected String[] getShippingStringArray(String s, String s1)
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

    protected boolean hasBillingAddress()
    {
        return defaultAddress != null;
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        if (isUSACompatible)
        {
            if (currentCountryManager.getCurrentCountry().isUSACompatible())
            {
                bundle = getString(0x7f080050);
            } else
            {
                bundle = getString(0x7f080049);
            }
        } else
        {
            bundle = null;
        }
        setToolbarTitle(bundle);
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

                final ShippingAddress this$0;
                final String val$stringArray1[];
                final String val$stringArray2[];

                public View getDropDownView(int i, View view, ViewGroup viewgroup)
                {
                    int j;
                    if (view == null)
                    {
                        view = inflater.inflate(0x1090009, null);
                    }
                    viewgroup = (TextView)(TextView)view;
                    viewgroup.setTextSize(0, (int)getContext().getResources().getDimension(0x7f0b0065));
                    j = (int)getContext().getResources().getDimension(0x7f0b0064);
                    viewgroup.setPadding(j, j, j, j);
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
                this$0 = ShippingAddress.this;
                stringArray2 = as1;
                stringArray1 = as2;
                super(final_context, final_i, as);
            }
            });
        }
    }

    protected void initializeSpinners()
    {
        String as[] = getResources().getStringArray(0x7f0f0002);
        String as1[] = getResources().getStringArray(0x7f0f0005);
        initializeSpinner(shippingCountry, as, as1);
        setSpinnerValue(shippingCountry, getCountryCodeForCountry(prefs.getString("preferredShippingCountry", countryCode)), as);
        if (shippingCountry != null)
        {
            shippingCountry.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {

                final ShippingAddress this$0;

                public void onItemSelected(AdapterView adapterview, View view, int i, long l)
                {
                    adapterview = Strings.toString(shippingCountry.getSelectedItem());
                    adapterview = getShippingStringArray("shipping_state_", adapterview);
                    initializeSpinner(shippingState, adapterview, null);
                    setSpinnerValue(shippingState, prefs.getString("preferredShippingState", ""), adapterview);
                }

                public void onNothingSelected(AdapterView adapterview)
                {
                }

            
            {
                this$0 = ShippingAddress.this;
                super();
            }
            });
        }
    }

    protected void initializeTitleSpinner()
    {
        if (titleSpinner != null)
        {
            titleSpinner.setVisibility(0);
            String as[] = getResources().getStringArray(0x7f0f0015);
            initializeSpinner(titleSpinner, as, null);
        }
    }

    protected void logGeoCoderUserChanges()
    {
        if (shippingState.getTag() != null)
        {
            zipCodeAutoComplete.logGeoCoderUserChangesState(Strings.toString(shippingState.getTag()), Strings.toString(shippingState.getSelectedItem()));
            shippingState.setTag(null);
        }
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        loggingUtils.logClick("", "cancel_shipping_address_click", getClass().getName(), dealId, cartUUID);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        isUSACompatible = currentCountryManager.getCurrentCountry().isUSACompatible();
        String s;
        int i;
        if (isUSACompatible)
        {
            i = 0x7f030024;
        } else
        {
            i = 0x7f030023;
        }
        setContentView(i);
        setDealCardCompact();
        shippingScrollView.setDescendantFocusability(0x20000);
        shippingScrollView.setFocusable(true);
        shippingScrollView.setFocusableInTouchMode(true);
        shippingScrollView.setOnTouchListener(new android.view.View.OnTouchListener() {

            final ShippingAddress this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                view.requestFocusFromTouch();
                return false;
            }

            
            {
                this$0 = ShippingAddress.this;
                super();
            }
        });
        if (bundle != null && bundle.containsKey("country_key"))
        {
            s = bundle.getString("country_key");
        } else
        {
            s = currentCountryManager.getCurrentCountry().shortName;
        }
        countryCode = s;
        if (isUSACompatible)
        {
            boolean flag;
            if (bundle == null || bundle.getBoolean("use_billing_as_shipping_check_state", true))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            useBillingAsShipping = flag;
        }
        submitButton.setText(0x7f08033e);
        secureConnectionView.setVisibility(0);
        submitButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ShippingAddress this$0;

            public void onClick(View view)
            {
                if (!valid())
                {
                    return;
                } else
                {
                    onSubmitClick();
                    return;
                }
            }

            
            {
                this$0 = ShippingAddress.this;
                super();
            }
        });
        if (useBillingAsShippingCheckMark != null)
        {
            useBillingAsShippingCheckMark.setUncheckedStateVisibility(true);
        }
        constructLayoutDynamically();
        initializeSpinners();
        populateFields();
    }

    protected void onPause()
    {
        super.onPause();
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 2);
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        if (shippingState != null)
        {
            shippingState.setSelection(bundle.getInt("state_key"));
            if (bundle.containsKey("edit_state"))
            {
                shippingState.setTag(bundle.getString("edit_state"));
            }
        }
        if (shippingState != null && (currentCountryManager.getCurrentCountry().isUSACompatible() || currentCountryManager.getCurrentCountry().isCanadaQuebec()))
        {
            shippingState.setSelection(bundle.getInt("state_key"));
        }
        int j = shippingAddressLayout.getChildCount();
        int i = 0;
        while (i < j) 
        {
            View view = shippingAddressLayout.getChildAt(i);
            if (view instanceof ShippingEditText)
            {
                ((ShippingEditText)view).setText(bundle.getString(((ShippingEditText)view).getHttpParam()));
            }
            i++;
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (shippingState != null)
        {
            bundle.putInt("state_key", shippingState.getSelectedItemPosition());
            if (shippingState.getTag() != null)
            {
                bundle.putString("edit_state", Strings.toString(shippingState.getTag()));
            }
        }
        if (shippingState != null && (currentCountryManager.getCurrentCountry().isUSACompatible() || currentCountryManager.getCurrentCountry().isCanadaQuebec()))
        {
            bundle.putInt("state_key", shippingState.getSelectedItemPosition());
        }
        if (currentCountryManager.getCurrentCountry().isUSACompatible() && shippingCountry != null)
        {
            bundle.putString("country_key", Strings.toString(shippingCountry.getSelectedItem()));
        }
        if (isUSACompatible)
        {
            bundle.putBoolean("use_billing_as_shipping_check_state", useBillingAsShippingCheckMark.isChecked());
        }
        int j = shippingAddressLayout.getChildCount();
        int i = 0;
        while (i < j) 
        {
            Object obj = shippingAddressLayout.getChildAt(i);
            if (obj instanceof ShippingEditText)
            {
                obj = (ShippingEditText)obj;
                bundle.putString(((ShippingEditText) (obj)).getHttpParam(), ((ShippingEditText) (obj)).getText().toString());
            }
            i++;
        }
    }

    protected void onSubmitClick()
    {
        loggingUtils.logClick("", "save_shipping_address_click", getClass().getName(), dealId, cartUUID);
        DealBreakdownAddress dealbreakdownaddress = constructShippingAddress();
        if (shippingState != null && shippingCountry != null)
        {
            dealbreakdownaddress.state = shippingState.getSelectedItem().toString();
            dealbreakdownaddress.country = shippingCountry.getSelectedItem().toString();
        }
        if (isUSACompatible)
        {
            dealbreakdownaddress.name = (new StringBuilder()).append(shippingFirstName.getText()).append(" ").append(shippingLastName.getText()).toString();
        }
        setResultAndFinish(-1, dealbreakdownaddress);
    }

    protected void setResultAndFinish(int i, DealBreakdownAddress dealbreakdownaddress)
    {
        shippingService.store(dealbreakdownaddress);
        setResult(i);
        finish();
    }

    protected void setSpinnerValue(Spinner spinner, String s, String as[])
    {
        if (spinner != null)
        {
            if (Strings.isEmpty(s))
            {
                spinner.setSelection(0);
            } else
            {
                int i = 0;
                while (i < as.length) 
                {
                    if (Strings.equalsIgnoreCase(s, as[i]))
                    {
                        spinner.setSelection(i);
                        return;
                    }
                    i++;
                }
            }
        }
    }

    protected boolean shouldAddFieldFor(String s)
    {
        if (isUSACompatible && Strings.equalsIgnoreCase(s, "firstLastName"))
        {
            addFirstAndLastNameFields();
            return false;
        } else
        {
            return true;
        }
    }

    public boolean valid()
    {
        boolean flag = true;
        int i = shippingAddressLayout.getChildCount() - 1;
        while (i >= 0) 
        {
            View view = shippingAddressLayout.getChildAt(i);
            if (view instanceof ShippingEditText)
            {
                boolean flag1;
                if (!((ShippingEditText)view).isEmpty())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                flag &= flag1;
            }
            i--;
        }
        return validSpinners() && flag;
    }

    protected boolean validSpinners()
    {
        if (shippingCountry != null && shippingCountry.getVisibility() == 0 && shippingCountry.getSelectedItemPosition() < 0)
        {
            Toast.makeText(getApplicationContext(), 0x7f08016f, 1).show();
            return false;
        }
        if (shippingState != null && shippingState.getVisibility() == 0 && shippingState.getSelectedItemPosition() < 0)
        {
            Toast.makeText(getApplicationContext(), 0x7f080185, 1).show();
            return false;
        } else
        {
            return true;
        }
    }


}
