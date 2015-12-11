// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.groupon.models.country.Country;
import com.groupon.models.dealbreakdown.DealBreakdownAddress;
import com.groupon.models.shipping.AddressEu;
import com.groupon.models.shipping.Location;
import com.groupon.network.HttpResponseException;
import com.groupon.service.ShippingService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.CheckedFunction1;
import com.groupon.util.ContextUtils;
import com.groupon.util.CountryUtil;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.LoggingUtils;
import com.groupon.view.ShippingEditText;
import com.groupon.view.SpinnerButton;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            ShippingAddress

public class ShippingAddressEu extends ShippingAddress
{

    public static final int REQUEST_CODE = 10120;
    private static final String SHIPPING_TITLE_CODE_MRS = "f";
    String SHIPPING_TITLE_MR;
    private CountryUtil countryUtil;
    protected DealBreakdownAddress existingAddress;
    protected boolean isShippingAddress;
    private Spinner shippingPrefecture;

    public ShippingAddressEu()
    {
    }

    private String[] getCountryCodesArray()
    {
        String s = currentCountryManager.getCurrentCountry().shortName;
        return getResources().getStringArray(ContextUtils.getIdentifier(this, (new StringBuilder()).append("country_codes_").append(s).toString(), "array"));
    }

    private String[] getCountryNamesArray()
    {
        String s = currentCountryManager.getCurrentCountry().shortName;
        return getResources().getStringArray(ContextUtils.getIdentifier(this, (new StringBuilder()).append("country_names_").append(s).toString(), "array"));
    }

    protected void addShippingAddress()
    {
        shippingService.addShippingAddressEu(this, Integer.valueOf(0x7f100102), new Function1() {

            final ShippingAddressEu this$0;

            public void execute(AddressEu addresseu)
            {
                setResultAndFinish(-1, addresseu.location.id);
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((AddressEu)obj);
            }

            
            {
                this$0 = ShippingAddressEu.this;
                super();
            }
        }, new Function1() {

            final ShippingAddressEu this$0;

            public void execute(Exception exception)
            {
label0:
                {
                    if (exception instanceof HttpResponseException)
                    {
                        switch (((HttpResponseException)exception).getStatusCode())
                        {
                        default:
                            Toast.makeText(getApplicationContext(), getString(0x7f0801a3), 1).show();
                            break;

                        case 409: 
                            break label0;
                        }
                    }
                    return;
                }
                Toast.makeText(getApplicationContext(), getString(0x7f0801a2), 1).show();
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((Exception)obj);
            }

            
            {
                this$0 = ShippingAddressEu.this;
                super();
            }
        }, new Function0() {

            final ShippingAddressEu this$0;

            public void execute()
            {
                submitButton.stopSpinning();
            }

            
            {
                this$0 = ShippingAddressEu.this;
                super();
            }
        }, getHttpParams().toArray());
    }

    protected View constructViewForField(String s)
    {
        View view = super.constructViewForField(s);
        if (currentCountryManager.getCurrentCountry().isJapan() && Strings.equalsIgnoreCase(s, "shippingPostalCodeJP"))
        {
            s = inflater;
            int i;
            if (isUSACompatible)
            {
                i = 0x7f03014a;
            } else
            {
                i = 0x7f030149;
            }
            shippingPrefecture = (Spinner)s.inflate(i, shippingAddressLayout, true).findViewById(0x7f1003d3);
            shippingPrefecture.setPrompt(getString(0x7f0802e7));
            s = shippingPrefecture;
            if (isUSACompatible)
            {
                i = 0x7f03020b;
            } else
            {
                i = 0x7f030209;
            }
            s.setAdapter(new ArrayAdapter(this, i, getResources().getStringArray(0x7f0f000b)));
        }
        return view;
    }

    protected void fillSpinners(DealBreakdownAddress dealbreakdownaddress)
    {
        if (titleSpinner != null && titleSpinner.getVisibility() == 0)
        {
            Spinner spinner = titleSpinner;
            int i;
            if (Strings.equalsIgnoreCase("m", dealbreakdownaddress.title))
            {
                i = 0;
            } else
            {
                i = 1;
            }
            spinner.setSelection(i);
        }
        if (currentCountryManager.getCurrentCountry().isJapan())
        {
            shippingPrefecture.setSelection(dealbreakdownaddress.pref - 1);
        } else
        if (shippingCountry != null && (currentCountryManager.getCurrentCountry().isBelgium() || currentCountryManager.getCurrentCountry().isUAE()))
        {
            setSpinnerValue(shippingCountry, dealbreakdownaddress.country, getCountryCodesArray());
            return;
        }
    }

    protected List getHttpParams()
    {
        int j = shippingAddressLayout.getChildCount();
        ArrayList arraylist = new ArrayList(j);
        int i = 0;
        while (i < j) 
        {
            Object obj = shippingAddressLayout.getChildAt(i);
            if (obj instanceof ShippingEditText)
            {
                obj = (ShippingEditText)obj;
                arraylist.addAll(Arrays.asList(new CharSequence[] {
                    ((ShippingEditText) (obj)).getHttpParam(), ((ShippingEditText) (obj)).getText()
                }));
            }
            i++;
        }
        Object obj1;
        if (titleSpinner != null && titleSpinner.getVisibility() == 0)
        {
            if (Strings.equalsIgnoreCase(titleSpinner.getSelectedItem(), SHIPPING_TITLE_MR))
            {
                obj1 = "m";
            } else
            {
                obj1 = "f";
            }
            arraylist.addAll(Arrays.asList(new String[] {
                "title", obj1
            }));
        }
        if (currentCountryManager.getCurrentCountry().isJapan())
        {
            if (currentCountryManager.getCurrentCountry().isJapan())
            {
                obj1 = "pref";
            } else
            {
                obj1 = "shipping_pref";
            }
            arraylist.addAll(Arrays.asList(new Serializable[] {
                obj1, Integer.valueOf(shippingPrefecture.getSelectedItemPosition() + 1)
            }));
        }
        if (shippingCountry != null && (currentCountryManager.getCurrentCountry().isBelgium() || currentCountryManager.getCurrentCountry().isUAE()))
        {
            obj1 = shippingCountry.getSelectedItem();
        } else
        {
            obj1 = countryUtil.reverseTransformIsoImperfectionsFrenchCanada(countryCode);
        }
        arraylist.addAll(Arrays.asList(new Object[] {
            "country", obj1
        }));
        return arraylist;
    }

    protected void initializeSpinners()
    {
        if (currentCountryManager.getCurrentCountry().isBelgium() || currentCountryManager.getCurrentCountry().isUAE())
        {
            String as[] = getCountryNamesArray();
            if (shippingCountry != null)
            {
                Spinner spinner = shippingCountry;
                int i;
                if (isUSACompatible)
                {
                    i = 0x7f03020b;
                } else
                {
                    i = 0x7f030209;
                }
                spinner.setAdapter(new ArrayAdapter(i, getCountryCodesArray(), as) {

                    final ShippingAddressEu this$0;
                    final String val$countryNames[];

                    public View getDropDownView(int j, View view, ViewGroup viewgroup)
                    {
                        viewgroup = view;
                        if (view == null)
                        {
                            view = inflater;
                            int k;
                            if (isUSACompatible)
                            {
                                k = 0x7f03020b;
                            } else
                            {
                                k = 0x7f030209;
                            }
                            viewgroup = view.inflate(k, null, false);
                        }
                        view = (TextView)viewgroup;
                        view.setText(countryNames[j]);
                        return view;
                    }

                    public View getView(int j, View view, ViewGroup viewgroup)
                    {
                        viewgroup = view;
                        if (view == null)
                        {
                            view = inflater;
                            int k;
                            if (isUSACompatible)
                            {
                                k = 0x7f03020b;
                            } else
                            {
                                k = 0x7f030209;
                            }
                            viewgroup = view.inflate(k, null, false);
                        }
                        view = (TextView)viewgroup;
                        view.setText(countryNames[j]);
                        return view;
                    }

            
            {
                this$0 = ShippingAddressEu.this;
                countryNames = as1;
                super(final_context, i, as);
            }
                });
            }
            if (shippingState != null)
            {
                shippingState.setVisibility(8);
            }
        } else
        if (shippingCountry != null && shippingState != null)
        {
            shippingCountry.setVisibility(8);
            shippingState.setVisibility(8);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    protected void onSubmitClick()
    {
        loggingUtils.logClick("", "save_shipping_address_click", getClass().getName(), dealId, cartUUID);
        if (otherAddress != null || existingAddress != null)
        {
            String s;
            if (otherAddress != null)
            {
                s = otherAddress.id;
            } else
            {
                s = existingAddress.id;
            }
            updateShippingAddress(s);
            return;
        } else
        {
            addShippingAddress();
            return;
        }
    }

    protected void setResultAndFinish(int i, String s)
    {
        shippingService.store(s);
        setResult(i);
        finish();
    }

    protected void updateShippingAddress(final String shippingAddressId)
    {
        shippingService.updateShippingAddressEu(this, shippingAddressId, Integer.valueOf(0x7f100102), new CheckedFunction1() {

            final ShippingAddressEu this$0;
            final String val$shippingAddressId;

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((Void)obj);
            }

            public void execute(Void void1)
                throws Exception
            {
                setResultAndFinish(-1, shippingAddressId);
            }

            
            {
                this$0 = ShippingAddressEu.this;
                shippingAddressId = s;
                super();
            }
        }, new Function1() {

            final ShippingAddressEu this$0;

            public void execute(Exception exception)
            {
                if (exception instanceof HttpResponseException)
                {
                    Toast.makeText(getApplicationContext(), getString(0x7f0801a3), 1).show();
                }
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((Exception)obj);
            }

            
            {
                this$0 = ShippingAddressEu.this;
                super();
            }
        }, new Function0() {

            final ShippingAddressEu this$0;

            public void execute()
            {
                submitButton.stopSpinning();
            }

            
            {
                this$0 = ShippingAddressEu.this;
                super();
            }
        }, getHttpParams().toArray());
    }

    protected boolean validSpinners()
    {
        boolean flag = true;
        if (currentCountryManager.getCurrentCountry().isJapan())
        {
            if (shippingPrefecture.getSelectedItemPosition() < 0)
            {
                Toast.makeText(getApplicationContext(), 0x7f080182, 1).show();
                flag = false;
            }
            return flag;
        } else
        {
            return super.validSpinners();
        }
    }
}
