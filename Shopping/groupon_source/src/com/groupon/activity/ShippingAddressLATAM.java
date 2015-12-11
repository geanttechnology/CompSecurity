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
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.groupon.http.Http;
import com.groupon.models.country.Country;
import com.groupon.models.dealbreakdown.DealBreakdownAddress;
import com.groupon.models.shipping.AddressEu;
import com.groupon.models.shipping.Location;
import com.groupon.models.shippingFields.RegionMX;
import com.groupon.models.shippingFields.ShippingField;
import com.groupon.models.shippingFields.ShippingSelectValue;
import com.groupon.network.HttpResponseException;
import com.groupon.service.ShippingService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.Function1;
import com.groupon.util.ReturningFunction1;
import com.groupon.util.ViewUtils;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            ShippingAddressEu

public class ShippingAddressLATAM extends ShippingAddressEu
{
    private class ShippingLocationsAdapter extends BaseAdapter
    {

        public List array;
        final ShippingAddressLATAM this$0;

        public int getCount()
        {
            return array.size();
        }

        public View getDropDownView(int i, View view, ViewGroup viewgroup)
        {
            viewgroup = view;
            if (view == null)
            {
                viewgroup = inflater.inflate(0x7f030207, null, false);
            }
            view = (TextView)viewgroup;
            view.setText(getItemLabel(i));
            return view;
        }

        public com.groupon.models.shippingFields.RegionMX.Location getItem(int i)
        {
            return (com.groupon.models.shippingFields.RegionMX.Location)array.get(i);
        }

        public volatile Object getItem(int i)
        {
            return getItem(i);
        }

        public long getItemId(int i)
        {
            return 0L;
        }

        public String getItemLabel(int i)
        {
            return getItem(i).name;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            viewgroup = view;
            if (view == null)
            {
                viewgroup = inflater.inflate(0x7f030209, null, false);
            }
            view = (TextView)viewgroup;
            view.setText(getItemLabel(i));
            return view;
        }

        public ShippingLocationsAdapter(List list)
        {
            this$0 = ShippingAddressLATAM.this;
            super();
            array = list;
        }
    }

    private class ShippingSelectValueAdapter extends BaseAdapter
    {

        private List array;
        final ShippingAddressLATAM this$0;

        public int getCount()
        {
            return array.size();
        }

        public View getDropDownView(int i, View view, ViewGroup viewgroup)
        {
            viewgroup = view;
            if (view == null)
            {
                viewgroup = inflater.inflate(0x7f030207, null, false);
            }
            view = (TextView)viewgroup;
            view.setText(getItemLabel(i));
            return view;
        }

        public ShippingSelectValue getItem(int i)
        {
            return (ShippingSelectValue)array.get(i);
        }

        public volatile Object getItem(int i)
        {
            return getItem(i);
        }

        public long getItemId(int i)
        {
            return 0L;
        }

        public String getItemLabel(int i)
        {
            if (currentCountryManager.getCurrentCountry().isChile() || currentCountryManager.getCurrentCountry().isColombia())
            {
                return getItem(i).label;
            } else
            {
                return "name";
            }
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            viewgroup = view;
            if (view == null)
            {
                viewgroup = inflater.inflate(0x7f030209, null, false);
            }
            view = (TextView)viewgroup;
            view.setText(getItemLabel(i));
            return view;
        }

        public ShippingSelectValueAdapter(List list)
        {
            this$0 = ShippingAddressLATAM.this;
            super();
            array = list;
        }
    }


    private static final String POSTAL_CODE_LATAM = "postalCodeLatam";
    private static final String SHIPPING_PHONE = "shippingPhone";
    String ERROR_INVALID_LOCATION_CL;
    String ERROR_INVALID_LOCATION_CO;
    String ERROR_INVALID_LOCATION_MX;
    String ERROR_INVALID_POSTAL;
    String ERROR_INVALID_REGION_CL;
    String ERROR_INVALID_REGION_CO;
    String dealId;
    private DeviceInfoUtil deviceInfoUtil;
    private ArraySharedPreferences loginPrefs;
    private String selectedLocation;
    private String selectedLocationAlternative;
    private String selectedRegion;
    private String selectedRegionAlternative;
    private EditText shippingLocationAlternative;
    private EditText shippingLocationAlternativeCLCO;
    private Spinner shippingLocationCLCO;
    private HashMap shippingLocationsCL;
    private Spinner shippingLocationsSpinner;
    private EditText shippingPostalCode;
    private TextView shippingRegion;
    private EditText shippingRegionAlternativeCLCO;
    private Spinner shippingRegionCLCO;
    private TextView shippingStateLatam;
    private Spinner shippingTitlesSpinner;
    private boolean shouldIgnoreFirstSetLocations;

    public ShippingAddressLATAM()
    {
        shouldIgnoreFirstSetLocations = false;
    }

    private void getLocationByPostalCodeForMexico(String s)
    {
        shippingService.getLocationsByPostalCodeMX(this, s, new Function1() {

            final ShippingAddressLATAM this$0;

            public void execute(RegionMX regionmx)
            {
                shippingLocationAlternative.setVisibility(8);
                String s1 = regionmx.stateName;
                if (Strings.notEmpty(s1))
                {
                    shippingStateLatam.setVisibility(0);
                    shippingStateLatam.setText(s1);
                    shippingStateLatam.setTag(regionmx.stateId);
                } else
                {
                    shippingStateLatam.setVisibility(8);
                }
                s1 = regionmx.name;
                if (Strings.notEmpty(s1))
                {
                    shippingRegion.setVisibility(0);
                    shippingRegion.setText(s1);
                    shippingRegion.setTag(regionmx.id);
                } else
                {
                    shippingRegion.setVisibility(8);
                }
                shippingLocationsSpinner.setVisibility(0);
                shippingLocationsSpinner.setAdapter(new ShippingLocationsAdapter(regionmx.locationsForRegionMX));
                if (existingAddress != null)
                {
                    int i = existingAddress.shipping_street_type;
                    if (i > 0)
                    {
                        shippingTitlesSpinner.setSelection(i - 1);
                    }
                    regionmx = existingAddress.shipping_township;
                    if (Strings.notEmpty(regionmx))
                    {
                        setSpinnerSelection(shippingLocationsSpinner, regionmx);
                    }
                }
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((RegionMX)obj);
            }

            
            {
                this$0 = ShippingAddressLATAM.this;
                super();
            }
        }, new ReturningFunction1() {

            final ShippingAddressLATAM this$0;

            public Boolean execute(Exception exception)
                throws RuntimeException
            {
                if ((exception instanceof HttpResponseException) && ((HttpResponseException)exception).getStatusCode() == 404)
                {
                    Toast.makeText(getApplicationContext(), getString(0x7f080181), 1).show();
                    return Boolean.valueOf(false);
                } else
                {
                    shippingLocationAlternative.setVisibility(0);
                    shippingRegion.setVisibility(8);
                    shippingStateLatam.setVisibility(8);
                    return Boolean.valueOf(true);
                }
            }

            public volatile Object execute(Object obj)
                throws Exception
            {
                return execute((Exception)obj);
            }

            
            {
                this$0 = ShippingAddressLATAM.this;
                super();
            }
        }, null);
    }

    private void getRegionsAndLocationsForCLCO(final String regionCode, final String locationCode)
    {
        shippingService.getShippingFieldsCLCO(dealId, new Function1() {

            final ShippingAddressLATAM this$0;
            final String val$locationCode;
            final String val$regionCode;

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((List)obj);
            }

            public void execute(List list)
                throws RuntimeException
            {
                processShippingFieldsCLCO(list, regionCode, locationCode);
                boolean flag = shouldIgnoreFirstSetLocations;
                if (shippingRegionCLCO.getVisibility() == 0)
                {
                    shippingRegionCLCO.setOnItemSelectedListener(flag. new android.widget.AdapterView.OnItemSelectedListener() {

                        private boolean shouldIgnoreSet;
                        final _cls5 this$1;
                        final boolean val$shouldIgnore;

                        public void onItemSelected(AdapterView adapterview, View view, int i, long l)
                        {
                            if (!shouldIgnoreSet)
                            {
                                adapterview = (ShippingSelectValue)shippingRegionCLCO.getAdapter().getItem(i);
                                setLocationsFieldCL(((ShippingSelectValue) (adapterview)).value);
                            }
                            shouldIgnoreSet = false;
                        }

                        public void onNothingSelected(AdapterView adapterview)
                        {
                        }

            
            {
                this$1 = final__pcls5;
                shouldIgnore = Z.this;
                super();
                shouldIgnoreSet = shouldIgnore;
            }
                    });
                }
            }

            
            {
                this$0 = ShippingAddressLATAM.this;
                regionCode = s;
                locationCode = s1;
                super();
            }
        }, new ReturningFunction1() {

            final ShippingAddressLATAM this$0;

            public Boolean execute(Exception exception)
                throws RuntimeException
            {
                shippingRegionCLCO.setVisibility(8);
                shippingRegionAlternativeCLCO.setVisibility(0);
                shippingLocationCLCO.setVisibility(8);
                shippingLocationAlternativeCLCO.setVisibility(0);
                if (Strings.notEmpty(selectedLocationAlternative))
                {
                    shippingLocationAlternativeCLCO.setText(selectedLocationAlternative);
                }
                return Boolean.valueOf(false);
            }

            public volatile Object execute(Object obj)
                throws Exception
            {
                return execute((Exception)obj);
            }

            
            {
                this$0 = ShippingAddressLATAM.this;
                super();
            }
        }, null);
    }

    private void processShippingFieldsCLCO(List list, String s, String s1)
    {
        boolean flag = false;
        Iterator iterator = list.iterator();
        do
        {
            if (iterator.hasNext())
            {
                list = (ShippingField)iterator.next();
                if (list != null)
                {
                    if (((ShippingField) (list)).name.equals("shipping_state"))
                    {
                        list = ((ShippingField) (list)).selectValues;
                        if (list != null && list.size() > 0)
                        {
                            shippingRegionCLCO.setAdapter(new ShippingSelectValueAdapter(list));
                            shippingRegionCLCO.setEnabled(true);
                            if (s != null && Strings.notEmpty(s) || Strings.notEmpty(selectedRegion))
                            {
                                SpinnerAdapter spinneradapter = shippingRegionCLCO.getAdapter();
                                int i;
                                if (Strings.notEmpty(selectedRegion))
                                {
                                    list = selectedRegion;
                                } else
                                {
                                    list = s;
                                }
                                i = getPositionForCode(spinneradapter, list);
                                if (i > -1)
                                {
                                    shippingRegionCLCO.setSelection(i);
                                    flag = true;
                                }
                            }
                        } else
                        {
                            shippingRegionCLCO.setVisibility(8);
                            shippingRegionAlternativeCLCO.setVisibility(0);
                            if (Strings.notEmpty(selectedRegionAlternative))
                            {
                                shippingRegionAlternativeCLCO.setText(selectedRegionAlternative);
                            }
                        }
                    } else
                    if (((ShippingField) (list)).name.equals("shipping_district"))
                    {
                        list = ((ShippingField) (list)).dynamicSelectValues;
                        if (list != null)
                        {
                            shippingLocationsCL = list;
                            if (s1 != null && Strings.notEmpty(s1) && flag || Strings.notEmpty(selectedRegion) && Strings.notEmpty(selectedLocation))
                            {
                                SpinnerAdapter spinneradapter1;
                                if (Strings.notEmpty(selectedRegion))
                                {
                                    list = selectedRegion;
                                } else
                                {
                                    list = s;
                                }
                                setLocationsFieldCL(list);
                                spinneradapter1 = shippingLocationCLCO.getAdapter();
                                if (spinneradapter1 != null && spinneradapter1.getCount() > 0)
                                {
                                    int j;
                                    if (Strings.notEmpty(selectedLocation))
                                    {
                                        list = selectedLocation;
                                    } else
                                    {
                                        list = s1;
                                    }
                                    j = getPositionForCode(spinneradapter1, list);
                                    if (j > -1)
                                    {
                                        shippingLocationCLCO.setSelection(j);
                                        shouldIgnoreFirstSetLocations = true;
                                    }
                                }
                            }
                        }
                    }
                }
            } else
            {
                return;
            }
        } while (true);
    }

    private void saveAddress(String s, String s1)
    {
        ((Http)(new Http(this, com/groupon/models/shipping/AddressEu, s, getHttpParams().toArray()) {

            final ShippingAddressLATAM this$0;

            protected void onSuccess(AddressEu addresseu)
                throws Exception
            {
                super.onSuccess(addresseu);
                setResultAndFinish(-1, addresseu.location.id);
            }

            protected volatile void onSuccess(Object obj)
                throws Exception
            {
                onSuccess((AddressEu)obj);
            }

            transient 
            {
                this$0 = ShippingAddressLATAM.this;
                super(context, class1, s, aobj);
            }
        }).progressView(submitButton)).method(s1).execute();
    }

    private void setLocationsFieldCL(String s)
    {
        if (shippingLocationsCL.get(s) != null)
        {
            s = (List)shippingLocationsCL.get(s);
        } else
        {
            s = null;
        }
        if (s != null && s.size() > 0)
        {
            shippingLocationCLCO.setAdapter(new ShippingSelectValueAdapter(s));
            shippingLocationCLCO.setVisibility(0);
            return;
        } else
        {
            shippingLocationCLCO.setVisibility(8);
            shippingLocationAlternativeCLCO.setVisibility(0);
            return;
        }
    }

    private void setSpinnerSelection(Spinner spinner, String s)
    {
        SpinnerAdapter spinneradapter = spinner.getAdapter();
        if (spinneradapter == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        j = spinneradapter.getCount();
        i = 0;
_L7:
        if (i >= j) goto _L2; else goto _L3
_L3:
        if (!Strings.equalsIgnoreCase(((com.groupon.models.shippingFields.RegionMX.Location)spinneradapter.getItem(i)).name, s)) goto _L5; else goto _L4
_L4:
        spinner.setSelection(i);
_L2:
        return;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private boolean validateFieldsCLCO()
    {
        String s;
        String s1;
        if (currentCountryManager.getCurrentCountry().isChile())
        {
            s = ERROR_INVALID_REGION_CL;
        } else
        {
            s = ERROR_INVALID_REGION_CO;
        }
        if (currentCountryManager.getCurrentCountry().isChile())
        {
            s1 = ERROR_INVALID_LOCATION_CL;
        } else
        {
            s1 = ERROR_INVALID_LOCATION_CO;
        }
        if (shippingRegionCLCO.getVisibility() == 0 && shippingRegionCLCO.getSelectedItemPosition() < 0)
        {
            Toast.makeText(getApplicationContext(), s, 1).show();
            return false;
        }
        if (shippingRegionAlternativeCLCO.getVisibility() == 0 && Strings.isEmpty(shippingRegionAlternativeCLCO.getText()))
        {
            ViewUtils.setEditTextError(shippingRegionAlternativeCLCO, s);
            return false;
        }
        if (shippingLocationCLCO.getVisibility() == 0 && shippingLocationCLCO.getSelectedItemPosition() < 0)
        {
            Toast.makeText(getApplicationContext(), s1, 1).show();
            return false;
        }
        if (shippingLocationAlternativeCLCO.getVisibility() == 0 && Strings.isEmpty(shippingLocationAlternativeCLCO.getText()))
        {
            ViewUtils.setEditTextError(shippingLocationAlternativeCLCO, s1);
            return false;
        } else
        {
            return super.valid();
        }
    }

    private boolean validateFieldsMX()
    {
        if (Strings.isEmpty(shippingPostalCode.getText()))
        {
            ViewUtils.setEditTextError(shippingPostalCode, ERROR_INVALID_POSTAL);
            return false;
        }
        if (shippingLocationsSpinner.getVisibility() == 0 && shippingLocationsSpinner.getSelectedItemPosition() < 0)
        {
            Toast.makeText(getApplicationContext(), ERROR_INVALID_LOCATION_MX, 1).show();
            return false;
        }
        if (shippingLocationAlternative.getVisibility() == 0 && Strings.isEmpty(shippingLocationAlternative.getText()))
        {
            ViewUtils.setEditTextError(shippingLocationAlternative, ERROR_INVALID_LOCATION_MX);
            return false;
        } else
        {
            return super.valid();
        }
    }

    protected void addShippingAddress()
    {
        saveAddress(String.format("https:/users/%s/locations", new Object[] {
            loginPrefs.getString("userId", "")
        }), "POST");
    }

    protected View constructViewForField(String s)
    {
        View view = super.constructViewForField(s);
        if (Strings.equalsIgnoreCase(s, "postalCodeLatam") && currentCountryManager.getCurrentCountry().isMexico())
        {
            shippingPostalCode = (EditText)view;
            s = inflater.inflate(0x7f0301ef, shippingAddressLayout, true);
            shippingLocationsSpinner = (Spinner)s.findViewById(0x7f100517);
            shippingLocationAlternative = (EditText)s.findViewById(0x7f100516);
            shippingTitlesSpinner = (Spinner)s.findViewById(0x7f100518);
            shippingStateLatam = (TextView)s.findViewById(0x7f100519);
            shippingRegion = (TextView)s.findViewById(0x7f100515);
        } else
        if (Strings.equalsIgnoreCase(s, "shippingPhone") && (currentCountryManager.getCurrentCountry().isChile() || currentCountryManager.getCurrentCountry().isColombia()))
        {
            s = inflater;
            int i;
            if (currentCountryManager.getCurrentCountry().isChile())
            {
                i = 0x7f0301ed;
            } else
            {
                i = 0x7f0301ee;
            }
            s = s.inflate(i, shippingAddressLayout, true);
            shippingRegionCLCO = (Spinner)s.findViewById(0x7f100515);
            shippingRegionAlternativeCLCO = (EditText)s.findViewById(0x7f100514);
            shippingLocationCLCO = (Spinner)s.findViewById(0x7f100517);
            shippingLocationAlternativeCLCO = (EditText)findViewById(0x7f100516);
            shippingTitlesSpinner = (Spinner)s.findViewById(0x7f100518);
            shippingRegionCLCO.setEnabled(false);
            return view;
        }
        return view;
    }

    protected void fillSpinners(DealBreakdownAddress dealbreakdownaddress)
    {
        if (currentCountryManager.getCurrentCountry().isMexico())
        {
            getLocationByPostalCodeForMexico(dealbreakdownaddress.shipping_postal_code);
            return;
        }
        String s;
        if (existingAddress != null)
        {
            dealbreakdownaddress = existingAddress.shipping_state;
        } else
        {
            dealbreakdownaddress = null;
        }
        if (existingAddress != null)
        {
            s = existingAddress.shipping_district;
        } else
        {
            s = null;
        }
        getRegionsAndLocationsForCLCO(dealbreakdownaddress, s);
    }

    protected DealBreakdownAddress getBillingAddressInstance()
    {
        return existingAddress;
    }

    protected List getHttpParams()
    {
        List list = super.getHttpParams();
        String s3 = deviceInfoUtil.getLanguageFromLocale();
        String s;
        String s1;
        String s2;
        if (currentCountryManager.getCurrentCountry().isMexico())
        {
            if (shippingStateLatam.getTag() != null)
            {
                s = shippingStateLatam.getTag().toString();
            } else
            {
                s = "";
            }
        } else
        if ((currentCountryManager.getCurrentCountry().isChile() || currentCountryManager.getCurrentCountry().isColombia()) && shippingRegionCLCO.getVisibility() == 0)
        {
            s = ((ShippingSelectValue)shippingRegionCLCO.getSelectedItem()).value;
        } else
        {
            s = Strings.toString(shippingRegionAlternativeCLCO.getText());
        }
        if (currentCountryManager.getCurrentCountry().isMexico())
        {
            if (shippingRegion.getTag() != null)
            {
                s1 = shippingRegion.getTag().toString();
            } else
            {
                s1 = "";
            }
        } else
        if ((currentCountryManager.getCurrentCountry().isChile() || currentCountryManager.getCurrentCountry().isColombia()) && shippingLocationCLCO.getVisibility() == 0)
        {
            s1 = ((ShippingSelectValue)shippingLocationCLCO.getSelectedItem()).value;
        } else
        {
            s1 = Strings.toString(shippingLocationAlternativeCLCO.getText());
        }
        if (currentCountryManager.getCurrentCountry().isMexico())
        {
            if (shippingLocationsSpinner.getVisibility() == 0)
            {
                s2 = ((com.groupon.models.shippingFields.RegionMX.Location)shippingLocationsSpinner.getSelectedItem()).name;
            } else
            {
                s2 = Strings.toString(shippingLocationAlternative.getText());
            }
        } else
        {
            s2 = "";
        }
        list.addAll(Arrays.asList(new Serializable[] {
            "lang", s3, "shipping_street_type", Long.valueOf(shippingTitlesSpinner.getSelectedItemId())
        }));
        if (Strings.notEmpty(s))
        {
            list.addAll(Arrays.asList(new String[] {
                "shipping_state", s
            }));
        }
        if (Strings.notEmpty(s1))
        {
            list.addAll(Arrays.asList(new String[] {
                "shipping_district", s1
            }));
        }
        if (Strings.notEmpty(s2))
        {
            list.addAll(Arrays.asList(new String[] {
                "shipping_township", s2
            }));
        }
        return list;
    }

    public int getPositionForCode(Adapter adapter, String s)
    {
        byte byte0 = -1;
        int k = adapter.getCount();
        int i = 0;
        do
        {
label0:
            {
                int j = byte0;
                if (i < k)
                {
                    if (!Strings.equalsIgnoreCase(((ShippingSelectValue)adapter.getItem(i)).value, s))
                    {
                        break label0;
                    }
                    j = i;
                }
                return j;
            }
            i++;
        } while (true);
    }

    protected boolean hasBillingAddress()
    {
        return !isShippingAddress && existingAddress != null;
    }

    protected void initializeSpinners()
    {
        if (shippingCountry != null && shippingState != null)
        {
            shippingCountry.setVisibility(8);
            shippingState.setVisibility(8);
        }
        String as[] = getResources().getStringArray(0x7f0f0014);
        shippingTitlesSpinner.setAdapter(new ArrayAdapter(this, 0x7f030209, as) {

            final ShippingAddressLATAM this$0;

            public long getItemId(int i)
            {
                return (long)(i + 1);
            }

            
            {
                this$0 = ShippingAddressLATAM.this;
                super(context, i, as);
            }
        });
        if (shippingPostalCode != null)
        {
            shippingPostalCode.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

                final ShippingAddressLATAM this$0;

                public void onFocusChange(View view, boolean flag)
                {
                    if (!flag)
                    {
                        getLocationByPostalCodeForMexico(shippingPostalCode.getText().toString());
                    }
                }

            
            {
                this$0 = ShippingAddressLATAM.this;
                super();
            }
            });
        }
        if ((currentCountryManager.getCurrentCountry().isChile() || currentCountryManager.getCurrentCountry().isColombia()) && existingAddress == null)
        {
            getRegionsAndLocationsForCLCO(null, null);
        }
    }

    public void onCreate(Bundle bundle)
    {
        if (bundle != null)
        {
            selectedRegion = bundle.getString("region", "");
            selectedRegionAlternative = bundle.getString("region_alternative", "");
            selectedLocation = bundle.getString("location", "");
            selectedLocationAlternative = bundle.getString("location_alternative", "");
        }
        super.onCreate(bundle);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (shippingRegionCLCO == null || shippingRegionCLCO.getVisibility() != 0 || shippingRegionCLCO.getSelectedItemPosition() == -1) goto _L2; else goto _L1
_L1:
        bundle.putString("region", ((ShippingSelectValue)shippingRegionCLCO.getSelectedItem()).value);
_L8:
        if (shippingLocationCLCO == null || shippingLocationCLCO.getVisibility() != 0 || shippingLocationCLCO.getSelectedItemPosition() == -1) goto _L4; else goto _L3
_L3:
        bundle.putString("location", ((ShippingSelectValue)shippingLocationCLCO.getSelectedItem()).value);
_L6:
        return;
_L2:
        if (shippingRegionAlternativeCLCO != null && shippingRegionAlternativeCLCO.getVisibility() == 0 && Strings.notEmpty(shippingRegionAlternativeCLCO.getText()))
        {
            bundle.putString("region_alternative", Strings.toString(shippingLocationAlternativeCLCO.getText()));
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (shippingLocationAlternativeCLCO == null || shippingLocationAlternativeCLCO.getVisibility() != 0 || !Strings.notEmpty(shippingLocationAlternativeCLCO.getText())) goto _L6; else goto _L5
_L5:
        bundle.putString("location_alternative", Strings.toString(shippingLocationAlternativeCLCO.getText()));
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected void updateShippingAddress(String s)
    {
        saveAddress(String.format("https:/users/%s/locations/%s", new Object[] {
            loginPrefs.getString("userId", ""), s
        }), "PUT");
    }

    public boolean valid()
    {
        if (currentCountryManager.getCurrentCountry().isMexico())
        {
            return validateFieldsMX();
        } else
        {
            return validateFieldsCLCO();
        }
    }
















}
