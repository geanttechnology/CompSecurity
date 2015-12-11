// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.inventory;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.ebay.android.widget.DelayedAutoCompleteTextView;
import com.ebay.app.AlertDialogFragment;
import com.ebay.common.Preferences;
import com.ebay.common.model.inventory.InventoryInfo;
import com.ebay.common.model.inventory.LocationAddress;
import com.ebay.common.model.inventory.StoreAvailability;
import com.ebay.common.net.api.inventory.LookupAvailabilityNetLoader;
import com.ebay.common.net.api.inventory.LookupAvailabilityResponse;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.ModalActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.dcs.DcsInteger;
import com.ebay.mobile.dcs.DcsString;
import com.ebay.mobile.search.SearchUtil;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.LocationUtil;
import com.ebay.mobile.util.PickupUtil;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.util.DelimitedStringBuilder;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.ebay.mobile.inventory:
//            StorePickerAutocompleteDialogFragment, StorePickerInfoDialogPudoFragment, StorePickerInfoDialogFragment, LocationServicesEnableDialogFragment, 
//            LocationServicesImproveDialogFragment

public class StorePickerActivity extends ModalActivity
    implements android.view.View.OnClickListener, android.view.View.OnKeyListener, android.view.View.OnTouchListener, android.widget.AdapterView.OnItemClickListener, android.widget.TextView.OnEditorActionListener, StorePickerAutocompleteDialogFragment.StorePickerAutocompleteDialogListener, com.google.android.gms.maps.GoogleMap.OnMarkerClickListener, com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener
{
    private class LocationAutoCompleteAdapter extends ArrayAdapter
    {

        private ArrayList resultList;
        final StorePickerActivity this$0;

        private ArrayList getMatchingLocations(String s)
        {
            ArrayList arraylist = new ArrayList();
            try
            {
                geocodedLocations = getGeocodedLocations(s);
            }
            catch (Exception exception) { }
            if (geocodedLocations != null)
            {
                DelimitedStringBuilder delimitedstringbuilder;
                for (Iterator iterator = geocodedLocations.iterator(); iterator.hasNext(); arraylist.add(delimitedstringbuilder.toString()))
                {
                    Address address = (Address)iterator.next();
                    if (StorePickerActivity.debugLogger.isLoggable)
                    {
                        StorePickerActivity.debugLogger.log(address.toString());
                    }
                    delimitedstringbuilder = new DelimitedStringBuilder(", ");
                    if (!s.equals(address.getAddressLine(0)))
                    {
                        int j = address.getMaxAddressLineIndex();
                        for (int i = 0; i <= j; i++)
                        {
                            delimitedstringbuilder.append(address.getAddressLine(i));
                        }

                        continue;
                    }
                    if (!s.equals(address.getFeatureName()))
                    {
                        delimitedstringbuilder.append(address.getFeatureName());
                    }
                    if (address.getLocality() != null)
                    {
                        delimitedstringbuilder.append(address.getLocality());
                    }
                    if (address.getAdminArea() != null)
                    {
                        delimitedstringbuilder.append(address.getAdminArea());
                    }
                    if (address.getCountryName() != null)
                    {
                        delimitedstringbuilder.append(address.getCountryName());
                    }
                    if (address.getPostalCode() != null)
                    {
                        delimitedstringbuilder.append(address.getPostalCode());
                    }
                }

            }
            return arraylist;
        }

        public int getCount()
        {
            int i = 0;
            if (resultList != null)
            {
                i = resultList.size();
            }
            return i;
        }

        public Filter getFilter()
        {
            return new Filter() {

                final LocationAutoCompleteAdapter this$1;

                protected android.widget.Filter.FilterResults performFiltering(CharSequence charsequence)
                {
                    android.widget.Filter.FilterResults filterresults = new android.widget.Filter.FilterResults();
                    if (charsequence != null)
                    {
                        resultList = getMatchingLocations(charsequence.toString());
                        filterresults.values = resultList;
                        filterresults.count = resultList.size();
                    }
                    return filterresults;
                }

                protected void publishResults(CharSequence charsequence, android.widget.Filter.FilterResults filterresults)
                {
                    if (filterresults != null && filterresults.count > 0)
                    {
                        notifyDataSetChanged();
                        return;
                    } else
                    {
                        notifyDataSetInvalidated();
                        return;
                    }
                }

            
            {
                this$1 = LocationAutoCompleteAdapter.this;
                super();
            }
            };
        }

        public volatile Object getItem(int i)
        {
            return getItem(i);
        }

        public String getItem(int i)
        {
            String s1 = "";
            String s = s1;
            if (resultList != null)
            {
                s = s1;
                if (resultList.size() > i)
                {
                    s = (String)resultList.get(i);
                }
            }
            return s;
        }



/*
        static ArrayList access$702(LocationAutoCompleteAdapter locationautocompleteadapter, ArrayList arraylist)
        {
            locationautocompleteadapter.resultList = arraylist;
            return arraylist;
        }

*/


        public LocationAutoCompleteAdapter(Context context, int i)
        {
            this$0 = StorePickerActivity.this;
            super(context, i);
        }
    }

    static final class LocationsDistanceComparator
        implements Comparator
    {

        private final double userLatitude;
        private final double userLongitude;

        public int compare(Address address, Address address1)
        {
            boolean flag = false;
            int i = ((flag) ? 1 : 0);
            if (address != null)
            {
                i = ((flag) ? 1 : 0);
                if (address1 != null)
                {
                    i = ((flag) ? 1 : 0);
                    if (address.hasLatitude())
                    {
                        i = ((flag) ? 1 : 0);
                        if (address.hasLongitude())
                        {
                            i = ((flag) ? 1 : 0);
                            if (address1.hasLatitude())
                            {
                                i = ((flag) ? 1 : 0);
                                if (address1.hasLongitude())
                                {
                                    double d = address.getLatitude();
                                    double d1 = address.getLongitude();
                                    address = new float[1];
                                    Location.distanceBetween(userLatitude, userLongitude, d, d1, address);
                                    d = address1.getLatitude();
                                    d1 = address1.getLongitude();
                                    address1 = new float[1];
                                    Location.distanceBetween(userLatitude, userLongitude, d, d1, address1);
                                    i = (int)(address[0] - address1[0]);
                                }
                            }
                        }
                    }
                }
            }
            return i;
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((Address)obj, (Address)obj1);
        }

        LocationsDistanceComparator(double d, double d1)
        {
            userLatitude = d;
            userLongitude = d1;
        }
    }

    private class StorePickerArrayAdapter extends ArrayAdapter
    {

        private final int greenColor;
        private final LayoutInflater inflater;
        private final com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type logisticsPlanType;
        private final int redColor;
        final StorePickerActivity this$0;

        public int getCount()
        {
            return super.getCount() + 2;
        }

        public StoreAvailability getItem(int i)
        {
            return (StoreAvailability)super.getItem(i - 1);
        }

        public volatile Object getItem(int i)
        {
            return getItem(i);
        }

        public int getItemViewType(int i)
        {
            if (i == 0 || i == getCount() - 1)
            {
                return -1;
            } else
            {
                return super.getItemViewType(i - 1);
            }
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            StoreAvailability storeavailability;
            if (i == 0)
            {
                return inflater.inflate(0x7f03025a, viewgroup, false);
            }
            if (i == getCount() - 1)
            {
                view = DeviceConfiguration.getAsync();
                viewgroup = inflater.inflate(0x7f03025b, viewgroup, false);
                Object obj = getResources();
                view = view.get(DcsString.BopisTermsLink);
                if (!TextUtils.isEmpty(view))
                {
                    view = String.format(((Resources) (obj)).getString(0x7f070478), new Object[] {
                        view, ((Resources) (obj)).getString(0x7f070b37)
                    });
                } else
                {
                    view = ((Resources) (obj)).getString(0x7f070b37);
                }
                view = String.format(((Resources) (obj)).getString(0x7f070b36), new Object[] {
                    view
                });
                obj = (TextView)viewgroup.findViewById(0x7f100525);
                ((TextView) (obj)).setMovementMethod(LinkMovementMethod.getInstance());
                ((TextView) (obj)).setText(Html.fromHtml(view));
                return viewgroup;
            }
            StringBuilder stringbuilder;
            Object obj1;
            int j;
            if (view == null || getItemViewType(i) == -1)
            {
                view = inflater.inflate(0x7f03025c, viewgroup, false);
            }
            viewgroup = (FrameLayout)view.findViewById(0x7f100819);
            viewgroup.removeAllViews();
            storeavailability = getItem(i);
            if (com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.PUDO != logisticsPlanType) goto _L2; else goto _L1
_L1:
            stringbuilder = new StringBuilder();
            i = 0;
            if (!TextUtils.isEmpty(storeavailability.name))
            {
                stringbuilder.append(storeavailability.name);
                i = 1;
            }
            j = i;
            if (!TextUtils.isEmpty(storeavailability.address.address1))
            {
                if (i != 0)
                {
                    stringbuilder.append("\n");
                }
                stringbuilder.append(storeavailability.address.address1);
                j = 1;
            }
            obj1 = StorePickerActivity.getCityRegionPostal(storeavailability);
            if (!TextUtils.isEmpty(((CharSequence) (obj1))))
            {
                if (j != 0)
                {
                    stringbuilder.append("\n");
                }
                stringbuilder.append(((String) (obj1)));
            }
            if (stringbuilder.length() > 0)
            {
                obj1 = inflater.inflate(0x7f03025e, viewgroup, false);
                ((TextView)((View) (obj1)).findViewById(0x7f100189)).setText(stringbuilder.toString());
                viewgroup.addView(((View) (obj1)));
            }
_L4:
            ((TextView)view.findViewById(0x7f10081a)).setText(String.format("%.1f %s", new Object[] {
                Double.valueOf(storeavailability.distance), unit.toString()
            }));
            ((RadioButton)view.findViewById(0x7f100818)).setChecked(storeavailability.equals(selectedStoreInfo.getSelectedStore()));
            return view;
_L2:
            View view1;
            if (com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.ISPU != logisticsPlanType)
            {
                continue; /* Loop/switch isn't completed */
            }
            view1 = inflater.inflate(0x7f03025d, viewgroup, false);
            if (!TextUtils.isEmpty(storeavailability.address.address1))
            {
                TextView textview = (TextView)view1.findViewById(0x7f100352);
                textview.setText(storeavailability.address.address1);
                textview.setTypeface(null, 1);
            }
            if (storeavailability.availability != null)
            {
                View view2 = view.findViewById(0x7f100818);
                TextView textview1 = (TextView)view1.findViewById(0x7f100353);
                textview1.setText(getAvailabilityTypeDisplayString(storeavailability.availability));
                textview1.setTextColor(greenColor);
                view2.setEnabled(true);
                if (!com.ebay.common.model.inventory.StoreAvailability.AvailabilityType.OUT_OF_STOCK.equals(storeavailability.availability))
                {
                    break; /* Loop/switch isn't completed */
                }
                textview1.setTextColor(redColor);
                view2.setEnabled(false);
            }
_L6:
            viewgroup.addView(view1);
            if (true) goto _L4; else goto _L3
_L3:
            if (storeavailability.fulfillmentTime == null) goto _L6; else goto _L5
_L5:
            ((TextView)view1.findViewById(0x7f100354)).setText(PickupUtil.formatFulfillmentTime(StorePickerActivity.this, storeavailability.fulfillmentTime));
              goto _L6
        }

        public StorePickerArrayAdapter(Context context, List list, com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type type)
        {
            this$0 = StorePickerActivity.this;
            super(context, 0, list);
            logisticsPlanType = type;
            inflater = (LayoutInflater)context.getSystemService("layout_inflater");
            storepickeractivity = getResources();
            greenColor = getColor(0x7f0d0063);
            redColor = getColor(0x7f0d00f0);
        }
    }

    private class StorePickerInfoWindowAdapter
        implements com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
    {

        private final com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type logisticsPlanType;
        final StorePickerActivity this$0;

        public View getInfoContents(Marker marker)
        {
            Object obj = (StoreAvailability)markerToAvailabilityMap.get(marker);
            marker = getLayoutInflater().inflate(0x7f030260, null);
            if (com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.PUDO != logisticsPlanType)
            {
                TextView textview = (TextView)marker.findViewById(0x7f10081b);
                textview.setText(((StoreAvailability) (obj)).name);
                textview.setVisibility(0);
            }
            ((TextView)marker.findViewById(0x7f100352)).setText(((StoreAvailability) (obj)).address.address1);
            ((TextView)marker.findViewById(0x7f10081c)).setText(StorePickerActivity.getCityRegionPostal(((StoreAvailability) (obj))));
            obj = PickupUtil.formatStoreHours(StorePickerActivity.this, ((StoreAvailability) (obj)));
            ((TextView)marker.findViewById(0x7f10081f)).setText(((String) (obj)).toString());
            obj = selectedStoreInfo.getEstimatedDeliveryDate();
            if (obj != null)
            {
                marker.findViewById(0x7f10081d).setVisibility(0);
                obj = Util.getEstimatedPickupDateString(StorePickerActivity.this, ((java.util.Date) (obj)), false);
                TextView textview1 = (TextView)marker.findViewById(0x7f10081e);
                textview1.setVisibility(0);
                textview1.setText(((CharSequence) (obj)));
            }
            return marker;
        }

        public View getInfoWindow(Marker marker)
        {
            return null;
        }

        public StorePickerInfoWindowAdapter(com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type type)
        {
            this$0 = StorePickerActivity.this;
            super();
            logisticsPlanType = type;
        }
    }


    private static final int DIALOG_GEOCODER_UNAVAILABLE = 9673;
    private static final int DIALOG_INFO = 9671;
    public static final String INVENTORY_INFO = "inventory_info";
    private static final String INVENTORY_LOOKUP_IS_PENDING = "inventory_lookup_is_pending";
    private static final String LAST_LOCATIONS_ARRAY = "last_locations_array";
    private static final int LOADER_LOOKUP_AVAILABILITY = 9670;
    private static final int MAX_GEOCODED_LOCATIONS = 5;
    private static final int MULTI_LOCATION_PADDING = 30;
    private static final int RESULT_VOICE_RECOGNITION = 9672;
    private static final int SINGLE_LOCATION_ZOOM = 11;
    static com.ebay.nautilus.kernel.util.FwLog.LogInfo debugLogger;
    static com.ebay.nautilus.kernel.util.FwLog.LogInfo verboseLogger;
    private final Map availabilityToMarkerMap = new HashMap();
    private EbayCountry currentCountry;
    private int geoCoderCallCount;
    private List geocodedLocations;
    private Geocoder geocoder;
    private com.ebay.common.model.inventory.InventoryInfo.ListDerivation initialDerivation;
    private List inventoryBases;
    private boolean inventoryLookupIsPending;
    private boolean isFirstEntry;
    private ArrayList lastLocations;
    private LocationListener locationListener;
    private final Map markerToAvailabilityMap = new HashMap();
    private int maxMarkersToShowInInitialMapView;
    private ListView pickerList;
    private GoogleMap pickerMap;
    private InventoryInfo selectedStoreInfo;
    private com.ebay.common.net.api.inventory.LookupAvailabilityRequest.Unit unit;
    private boolean wasSelectedFromMap;
    private boolean wasStoreSelected;

    public StorePickerActivity()
    {
        geocoder = null;
        selectedStoreInfo = null;
        locationListener = null;
        geocodedLocations = null;
        unit = com.ebay.common.net.api.inventory.LookupAvailabilityRequest.Unit.KM;
        geoCoderCallCount = 0;
        inventoryBases = null;
        inventoryLookupIsPending = false;
        lastLocations = null;
    }

    private void callInventoryService(com.ebay.common.net.api.inventory.LookupAvailabilityRequest.PhysicalLocation physicallocation)
    {
        DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
        int i = deviceconfiguration.get(DcsInteger.StorePickerSearchRadius);
        if (com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.PUDO == selectedStoreInfo.getLogisticsPlanType())
        {
            i = deviceconfiguration.get(DcsInteger.StorePickerSearchRadiusPudo);
        }
        inventoryLookupIsPending = true;
        physicallocation = new LookupAvailabilityNetLoader(getEbayContext(), selectedStoreInfo.getSellerUserId(), selectedStoreInfo.getItemSku(), physicallocation, Integer.valueOf(i), unit, currentCountry.getCountryCode(), selectedStoreInfo.getLogisticsPlanType(), selectedStoreInfo.getEstimatedDeliveryDate());
        getFwLoaderManager().start(9670, physicallocation, true);
    }

    private void callInventoryServiceWithAddress(Address address)
    {
        double d = address.getLatitude();
        double d1 = address.getLongitude();
        selectedStoreInfo.setQueryLocation(new LatLng(d, d1));
        callInventoryService(new com.ebay.common.net.api.inventory.LookupAvailabilityRequest.PhysicalLocation(d, d1));
    }

    private void createUI()
    {
        setContentView(0x7f030259);
        showBackButton();
        hideCloseButton();
        Object obj;
        try
        {
            if (Geocoder.isPresent())
            {
                findViewById(0x7f10080f).setVisibility(0);
                DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
                DelayedAutoCompleteTextView delayedautocompletetextview = (DelayedAutoCompleteTextView)findViewById(0x7f100824);
                delayedautocompletetextview.setDelay(deviceconfiguration.get(DcsInteger.StorePickerAutocompleteDelayMs));
                delayedautocompletetextview.setThreshold(deviceconfiguration.get(DcsInteger.StorePickerAutocompleteMinChars));
                delayedautocompletetextview.setOnTouchListener(this);
                delayedautocompletetextview.setOnItemClickListener(this);
                delayedautocompletetextview.setOnEditorActionListener(this);
                delayedautocompletetextview.setOnKeyListener(this);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (debugLogger.isLoggable)
            {
                debugLogger.logAsWarning(((Exception) (obj)).getMessage());
            }
        }
        findViewById(0x7f100814).setOnClickListener(this);
        findViewById(0x7f100815).setOnClickListener(this);
        findViewById(0x7f100142).setOnClickListener(new android.view.View.OnClickListener() {

            final StorePickerActivity this$0;

            public void onClick(View view)
            {
            }

            
            {
                this$0 = StorePickerActivity.this;
                super();
            }
        });
        obj = (MapFragment)getFragmentManager().findFragmentById(0x7f100810);
        if (maxMarkersToShowInInitialMapView > 0)
        {
            pickerMap = ((MapFragment) (obj)).getMap();
            pickerMap.setMapType(1);
            pickerMap.setMyLocationEnabled(true);
            obj = pickerMap.getUiSettings();
            ((UiSettings) (obj)).setZoomControlsEnabled(false);
            ((UiSettings) (obj)).setCompassEnabled(false);
            pickerMap.setOnMarkerClickListener(this);
            pickerMap.setInfoWindowAdapter(new StorePickerInfoWindowAdapter(selectedStoreInfo.getLogisticsPlanType()));
            pickerMap.setOnMyLocationButtonClickListener(this);
        } else
        {
            ((MapFragment) (obj)).getView().setVisibility(8);
        }
        pickerList = (ListView)findViewById(0x7f100811);
        pickerList.setOnItemClickListener(this);
    }

    private void displayError(String s)
    {
        if (maxMarkersToShowInInitialMapView > 0)
        {
            LatLng latlng = selectedStoreInfo.getQueryLocation();
            Object obj = latlng;
            if (latlng == null)
            {
                obj = selectedStoreInfo.getUserLocation();
            }
            float f = 10F;
            latlng = ((LatLng) (obj));
            if (obj == null)
            {
                latlng = new LatLng(0.0D, 0.0D);
                f = 0.0F;
            }
            obj = CameraUpdateFactory.newLatLngZoom(latlng, f);
            pickerMap.moveCamera(((com.google.android.gms.maps.CameraUpdate) (obj)));
            pickerMap.getUiSettings().setAllGesturesEnabled(false);
        }
        findViewById(0x7f100142).setVisibility(8);
        findViewById(0x7f100811).setVisibility(8);
        TextView textview = (TextView)findViewById(0x7f100812);
        textview.setText(s);
        textview.setVisibility(0);
    }

    private LocationAutoCompleteAdapter getAutoCompleteAdapter()
    {
        LocationAutoCompleteAdapter locationautocompleteadapter = null;
        DelayedAutoCompleteTextView delayedautocompletetextview = (DelayedAutoCompleteTextView)findViewById(0x7f100824);
        if (delayedautocompletetextview != null)
        {
            LocationAutoCompleteAdapter locationautocompleteadapter1 = (LocationAutoCompleteAdapter)delayedautocompletetextview.getAdapter();
            locationautocompleteadapter = locationautocompleteadapter1;
            if (locationautocompleteadapter1 == null)
            {
                locationautocompleteadapter = new LocationAutoCompleteAdapter(this, 0x7f03025f);
                delayedautocompletetextview.setAdapter(locationautocompleteadapter);
            }
        }
        return locationautocompleteadapter;
    }

    private String getAvailabilityTypeDisplayString(com.ebay.common.model.inventory.StoreAvailability.AvailabilityType availabilitytype)
    {
        Resources resources = getResources();
        static class _cls3
        {

            static final int $SwitchMap$com$ebay$common$model$inventory$StoreAvailability$AvailabilityType[];

            static 
            {
                $SwitchMap$com$ebay$common$model$inventory$StoreAvailability$AvailabilityType = new int[com.ebay.common.model.inventory.StoreAvailability.AvailabilityType.values().length];
                try
                {
                    $SwitchMap$com$ebay$common$model$inventory$StoreAvailability$AvailabilityType[com.ebay.common.model.inventory.StoreAvailability.AvailabilityType.IN_STOCK.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$common$model$inventory$StoreAvailability$AvailabilityType[com.ebay.common.model.inventory.StoreAvailability.AvailabilityType.OUT_OF_STOCK.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$common$model$inventory$StoreAvailability$AvailabilityType[com.ebay.common.model.inventory.StoreAvailability.AvailabilityType.SHIP_TO_STORE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls3..SwitchMap.com.ebay.common.model.inventory.StoreAvailability.AvailabilityType[availabilitytype.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return resources.getString(0x7f070b39);

        case 2: // '\002'
            return resources.getString(0x7f070b44);

        case 3: // '\003'
            return resources.getString(0x7f070b45);
        }
    }

    private static String getCityRegionPostal(StoreAvailability storeavailability)
    {
        StringBuilder stringbuilder = new StringBuilder();
        boolean flag = false;
        if (!TextUtils.isEmpty(storeavailability.address.city))
        {
            stringbuilder.append(storeavailability.address.city);
            flag = true;
        }
        boolean flag1 = flag;
        if (!TextUtils.isEmpty(storeavailability.address.region))
        {
            if (flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append(storeavailability.address.region);
            flag1 = true;
        }
        if (!TextUtils.isEmpty(storeavailability.address.postalCode))
        {
            if (flag1)
            {
                stringbuilder.append(" ");
            }
            stringbuilder.append(storeavailability.address.postalCode);
        }
        return stringbuilder.toString();
    }

    private List getGeocodedLocations(String s)
        throws IOException
    {
        if (geocoder == null)
        {
            Locale locale = Locale.getDefault();
            EbaySite ebaysite = EbaySite.getInstanceFromId(selectedStoreInfo.site);
            if (ebaysite != null)
            {
                locale = ebaysite.getLocale();
            }
            geocoder = new Geocoder(this, locale);
        }
        try
        {
            s = geocoder.getFromLocationName(s, 5);
            Collections.sort(s, new LocationsDistanceComparator(selectedStoreInfo.getUserLocation().latitude, selectedStoreInfo.getUserLocation().longitude));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            if (debugLogger.isLoggable)
            {
                debugLogger.logAsError(s.getMessage());
            }
            throw s;
        }
        if (s == null) goto _L2; else goto _L1
_L1:
        if (!s.isEmpty()) goto _L3; else goto _L2
_L2:
        s = lastLocations;
_L5:
        geoCoderCallCount = geoCoderCallCount + 1;
        return s;
_L3:
        lastLocations = (ArrayList)s;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void moveMapAndShowMarkerInfoWindow(Marker marker)
    {
        if (maxMarkersToShowInInitialMapView > 0)
        {
            marker.showInfoWindow();
            float f = pickerMap.getCameraPosition().zoom;
            marker = CameraUpdateFactory.newLatLngZoom(new LatLng(marker.getPosition().latitude + 90D / Math.pow(2D, f), marker.getPosition().longitude), f);
            pickerMap.animateCamera(marker, 500, null);
        }
    }

    private void onLookupAvailability(LookupAvailabilityNetLoader lookupavailabilitynetloader)
    {
        inventoryLookupIsPending = false;
        resetUI();
        if (lookupavailabilitynetloader == null || lookupavailabilitynetloader.getResponse() == null)
        {
            displayError(getResources().getString(0x7f070b38));
            return;
        }
        List list = lookupavailabilitynetloader.getResponse().getAvailabilities();
        lookupavailabilitynetloader = list;
        if (list != null)
        {
            lookupavailabilitynetloader = list;
            if (com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.PUDO == selectedStoreInfo.getLogisticsPlanType())
            {
                lookupavailabilitynetloader = list.subList(0, Math.min(list.size(), MyApp.getDeviceConfiguration().getConfig().get(DcsInteger.StorePickerStoresToDisplay)));
            }
        }
        selectedStoreInfo.setAvailabilities(lookupavailabilitynetloader);
        if (lookupavailabilitynetloader != null && !lookupavailabilitynetloader.isEmpty())
        {
            selectedStoreInfo.setForceInventoryLookup(false);
            updateUI();
            return;
        }
        if (inventoryBases != null && inventoryBases.size() > 0)
        {
            callInventoryService((com.ebay.common.net.api.inventory.LookupAvailabilityRequest.PhysicalLocation)inventoryBases.remove(0));
            return;
        } else
        {
            displayError(getResources().getString(0x7f070b43));
            return;
        }
    }

    private void resetUI()
    {
        findViewById(0x7f100142).setVisibility(8);
        findViewById(0x7f100812).setVisibility(8);
        findViewById(0x7f100811).setVisibility(0);
        if (maxMarkersToShowInInitialMapView > 0)
        {
            pickerMap.clear();
        }
        markerToAvailabilityMap.clear();
        availabilityToMarkerMap.clear();
    }

    private void sendSelectionTracking()
    {
        if (wasStoreSelected)
        {
            TrackingData trackingdata = new TrackingData("InstorePickupSelection", TrackingType.EVENT);
            String s;
            if (selectedStoreInfo != null)
            {
                if (com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.PUDO == selectedStoreInfo.getLogisticsPlanType())
                {
                    s = "1";
                } else
                {
                    s = "0";
                }
                trackingdata.addKeyValuePair("pudo", s);
            }
            if (wasSelectedFromMap)
            {
                s = "0";
            } else
            {
                s = "1";
            }
            trackingdata.addKeyValuePair("stpicker", s);
            trackingdata.send(this);
        }
    }

    private void sendTrackingEvent()
    {
        TrackingData trackingdata = new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION);
        LocationUtil.addGeoTagsToTrackingData(this, trackingdata, LocationUtil.getLastKnownLocation(this));
        Object obj;
        if (isFirstEntry)
        {
            isFirstEntry = false;
            trackingdata.addKeyValuePair("ispfshow", "1");
            trackingdata.addSourceIdentification(getIntent());
        } else
        if (initialDerivation == com.ebay.common.model.inventory.InventoryInfo.ListDerivation.LATLNG)
        {
            trackingdata.addKeyValuePair("overridegps", "1");
            trackingdata.addKeyValuePair("overridesa", "0");
        } else
        if (initialDerivation == com.ebay.common.model.inventory.InventoryInfo.ListDerivation.POSTAL_CODE || initialDerivation == com.ebay.common.model.inventory.InventoryInfo.ListDerivation.SEARCH_POSTAL_CODE)
        {
            trackingdata.addKeyValuePair("overridegps", "0");
            trackingdata.addKeyValuePair("overridesa", "1");
        } else
        {
            trackingdata.addKeyValuePair("overridegps", "0");
            trackingdata.addKeyValuePair("overridesa", "0");
        }
        obj = selectedStoreInfo.getAvailabilities();
        if (obj == null || ((List) (obj)).size() == 0)
        {
            trackingdata.addKeyValuePair("nsf", "1");
        } else
        {
            boolean flag1 = true;
            obj = ((List) (obj)).iterator();
            boolean flag;
            do
            {
                flag = flag1;
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                StoreAvailability storeavailability = (StoreAvailability)((Iterator) (obj)).next();
                if (com.ebay.common.model.inventory.StoreAvailability.AvailabilityType.OUT_OF_STOCK.equals(storeavailability.availability))
                {
                    continue;
                }
                flag = false;
                break;
            } while (true);
            if (flag)
            {
                trackingdata.addKeyValuePair("ostk", "1");
            }
        }
        if (selectedStoreInfo != null)
        {
            if (com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.PUDO == selectedStoreInfo.getLogisticsPlanType())
            {
                obj = "1";
            } else
            {
                obj = "0";
            }
            trackingdata.addKeyValuePair("pudo", ((String) (obj)));
        }
        trackingdata.send(this);
    }

    private void updateUI()
    {
        final List availabilities = selectedStoreInfo.getAvailabilities();
        if (availabilities != null)
        {
            pickerList.setVisibility(0);
            pickerList.setAdapter(new StorePickerArrayAdapter(this, availabilities, selectedStoreInfo.getLogisticsPlanType()));
            findViewById(0x7f100037).getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                final StorePickerActivity this$0;
                final List val$availabilities;

                public void onGlobalLayout()
                {
                    findViewById(0x7f100037).getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    StoreAvailability storeavailability = selectedStoreInfo.getSelectedStore();
                    if (storeavailability != null && availabilities.contains(storeavailability))
                    {
                        pickerList.setSelectionFromTop(availabilities.indexOf(storeavailability), 0);
                    }
                    if (maxMarkersToShowInInitialMapView > 0)
                    {
                        int i = 0;
                        Object obj = new com.google.android.gms.maps.model.LatLngBounds.Builder();
                        LatLng latlng = selectedStoreInfo.getUserLocation();
                        boolean flag = false;
                        if (latlng != null)
                        {
                            ((com.google.android.gms.maps.model.LatLngBounds.Builder) (obj)).include(latlng);
                            flag = true;
                        }
                        for (Iterator iterator = availabilities.iterator(); iterator.hasNext();)
                        {
                            StoreAvailability storeavailability1 = (StoreAvailability)iterator.next();
                            int j = 0x7f0202db;
                            if (com.ebay.common.model.inventory.StoreAvailability.AvailabilityType.OUT_OF_STOCK.equals(storeavailability1.availability))
                            {
                                j = 0x7f0202dc;
                            }
                            int k = i;
                            if (i < maxMarkersToShowInInitialMapView)
                            {
                                k = i + 1;
                                ((com.google.android.gms.maps.model.LatLngBounds.Builder) (obj)).include(new LatLng(storeavailability1.address.latitude, storeavailability1.address.longitude));
                            }
                            Marker marker = pickerMap.addMarker((new MarkerOptions()).position(new LatLng(storeavailability1.address.latitude, storeavailability1.address.longitude)).icon(BitmapDescriptorFactory.fromResource(j)));
                            markerToAvailabilityMap.put(marker, storeavailability1);
                            availabilityToMarkerMap.put(storeavailability1, marker);
                            i = k;
                        }

                        obj = ((com.google.android.gms.maps.model.LatLngBounds.Builder) (obj)).build();
                        if (!flag && (availabilities.size() == 1 || maxMarkersToShowInInitialMapView == 1))
                        {
                            obj = (StoreAvailability)availabilities.get(0);
                            obj = CameraUpdateFactory.newLatLngZoom(new LatLng(((StoreAvailability) (obj)).address.latitude, ((StoreAvailability) (obj)).address.longitude), 11F);
                        } else
                        {
                            obj = CameraUpdateFactory.newLatLngBounds(((com.google.android.gms.maps.model.LatLngBounds) (obj)), 30);
                        }
                        pickerMap.moveCamera(((com.google.android.gms.maps.CameraUpdate) (obj)));
                        obj = pickerMap.getUiSettings();
                        ((UiSettings) (obj)).setZoomGesturesEnabled(true);
                        ((UiSettings) (obj)).setScrollGesturesEnabled(true);
                        obj = selectedStoreInfo.getSelectedStore();
                        if (obj != null)
                        {
                            obj = (Marker)availabilityToMarkerMap.get(obj);
                            if (obj != null)
                            {
                                moveMapAndShowMarkerInfoWindow(((Marker) (obj)));
                            }
                        }
                    }
                    findViewById(0x7f100142).setVisibility(8);
                }

            
            {
                this$0 = StorePickerActivity.this;
                availabilities = list;
                super();
            }
            });
        }
    }

    public String getTrackingEventName()
    {
        return "InstorePickup";
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (verboseLogger.isLoggable)
        {
            FwLog.logMethod(verboseLogger, new Object[0]);
        }
        i;
        JVM INSTR tableswitch 9672 9672: default 40
    //                   9672 48;
           goto _L1 _L2
_L1:
        super.onActivityResult(i, j, intent);
_L4:
        return;
_L2:
        if (intent != null)
        {
            intent = intent.getStringArrayListExtra("android.speech.extra.RESULTS");
            if (intent != null && !intent.isEmpty())
            {
                intent = (String)intent.get(0);
                if (debugLogger.isLoggable)
                {
                    debugLogger.log((new StringBuilder()).append("Match: ").append(intent).toString());
                }
                DelayedAutoCompleteTextView delayedautocompletetextview = (DelayedAutoCompleteTextView)findViewById(0x7f100824);
                delayedautocompletetextview.setText(intent);
                delayedautocompletetextview.requestFocus();
                return;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onAutocompleteItemSelected(DialogFragment dialogfragment)
    {
        dialogfragment = ((StorePickerAutocompleteDialogFragment)dialogfragment).getSelectedAddress();
        if (dialogfragment != null)
        {
            callInventoryServiceWithAddress(dialogfragment);
        }
    }

    public void onClick(View view)
    {
        if (verboseLogger.isLoggable)
        {
            FwLog.logMethod(verboseLogger, new Object[0]);
        }
        switch (view.getId())
        {
        default:
            return;

        case 2131757079: 
            if (com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.PUDO == selectedStoreInfo.getLogisticsPlanType())
            {
                view = new StorePickerInfoDialogPudoFragment();
            } else
            {
                view = new StorePickerInfoDialogFragment();
            }
            view.show(getFragmentManager(), "info_dialog");
            return;

        case 2131757090: 
            view = getAutoCompleteAdapter();
            if (view != null)
            {
                view.clear();
            }
            view = new Intent("android.speech.action.RECOGNIZE_SPEECH");
            view.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
            view.putExtra("android.speech.extra.PROMPT", getString(0x7f070b46));
            startActivityForResult(view, 9672);
            return;

        case 2131757091: 
            ((DelayedAutoCompleteTextView)findViewById(0x7f100824)).setText("");
            lastLocations = null;
            findViewById(0x7f100822).setVisibility(0);
            findViewById(0x7f100823).setVisibility(8);
            return;

        case 2131757076: 
            setResult(0, new Intent());
            finish();
            return;

        case 2131757077: 
            view = selectedStoreInfo.getSelectedStore();
            break;
        }
        if (view == null || ((StoreAvailability) (view)).availability != com.ebay.common.model.inventory.StoreAvailability.AvailabilityType.OUT_OF_STOCK)
        {
            sendSelectionTracking();
            view = new Intent();
            view.putExtra("inventory_info", selectedStoreInfo);
            setResult(-1, view);
            finish();
            return;
        } else
        {
            view = new com.ebay.app.AlertDialogFragment.Builder();
            view.setMessage(getResources().getString(0x7f070b40));
            view.setPositiveButton(0x7f070738);
            view.createFromActivity(9671).show(getFragmentManager(), "out_of_stock_store_selected");
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        if (verboseLogger.isLoggable)
        {
            FwLog.logMethod(verboseLogger, new Object[] {
                bundle
            });
        }
        super.onCreate(bundle);
        locationListener = LocationUtil.primeLastLocationFromGps(this);
        if (bundle == null) goto _L2; else goto _L1
_L1:
        selectedStoreInfo = (InventoryInfo)bundle.get("inventory_info");
        inventoryLookupIsPending = bundle.getBoolean("inventory_lookup_is_pending");
        lastLocations = bundle.getParcelableArrayList("last_locations_array");
_L4:
        if (selectedStoreInfo == null)
        {
            selectedStoreInfo = new InventoryInfo();
        }
        initialDerivation = selectedStoreInfo.getDerivation();
        isFirstEntry = true;
        wasStoreSelected = false;
        wasSelectedFromMap = false;
        maxMarkersToShowInInitialMapView = DeviceConfiguration.getAsync().get(DcsInteger.StorePickerStoresToDisplay);
        currentCountry = MyApp.getPrefs().getCurrentCountry();
        bundle = currentCountry.site.id;
        if (bundle.equals(EbaySite.UK.id) || bundle.equals(EbaySite.US.id))
        {
            unit = com.ebay.common.net.api.inventory.LookupAvailabilityRequest.Unit.MILE;
        }
        createUI();
        setTitle(getString(SearchUtil.getInStorePickupResourceForCountry(currentCountry)));
        return;
_L2:
        if (getIntent().getExtras() != null)
        {
            selectedStoreInfo = (InventoryInfo)getIntent().getExtras().getParcelable("inventory_info");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        boolean flag;
        boolean flag1;
        if (verboseLogger.isLoggable)
        {
            FwLog.logMethod(verboseLogger, new Object[0]);
        }
        flag1 = false;
        flag = flag1;
        if (textview.getId() != 0x7f100824) goto _L2; else goto _L1
_L1:
        flag = flag1;
        if (i != 3) goto _L2; else goto _L3
_L3:
        keyevent = (DelayedAutoCompleteTextView)findViewById(0x7f100824);
        if (keyevent != null)
        {
            keyevent.dismissDropDown();
        }
        keyevent = getAutoCompleteAdapter();
        if (keyevent != null)
        {
            keyevent.clear();
        }
        keyevent = textview.getText().toString();
        textview = null;
        keyevent = getGeocodedLocations(keyevent);
        textview = keyevent;
_L5:
        if (textview != null && textview.size() > 0)
        {
            keyevent = new StorePickerAutocompleteDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("location_list", new ArrayList(textview));
            keyevent.setArguments(bundle);
            keyevent.show(getFragmentManager(), "autocomplete_dialog");
            ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(findViewById(0x7f100824).getWindowToken(), 0);
        }
        findViewById(0x7f100822).setVisibility(0);
        findViewById(0x7f100823).setVisibility(8);
        flag = true;
_L2:
        return flag;
        keyevent;
        keyevent = new com.ebay.app.AlertDialogFragment.Builder();
        keyevent.setTitle(0x7f070ad6);
        keyevent.setMessage(getResources().getString(0x7f070142));
        keyevent.setPositiveButton(0x7f070738);
        keyevent.createFromActivity(9673).show(getFragmentManager(), "geocoder_service_unavailable");
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (verboseLogger.isLoggable)
        {
            FwLog.logMethod(verboseLogger, new Object[] {
                Integer.valueOf(i), Long.valueOf(l)
            });
        }
        if (adapterview.getAdapter() instanceof LocationAutoCompleteAdapter)
        {
            findViewById(0x7f100822).setVisibility(0);
            findViewById(0x7f100823).setVisibility(8);
            callInventoryServiceWithAddress((Address)geocodedLocations.get(i));
            ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(findViewById(0x7f100824).getWindowToken(), 0);
        } else
        {
            adapterview = pickerList.getAdapter();
            if (adapterview != null && adapterview.getItemViewType(i) != -1)
            {
                adapterview = (StoreAvailability)adapterview.getItem(i);
                view = (Marker)availabilityToMarkerMap.get(adapterview);
                wasStoreSelected = true;
                wasSelectedFromMap = false;
                selectedStoreInfo.setSelectedStore(adapterview);
                moveMapAndShowMarkerInfoWindow(view);
                ((StorePickerArrayAdapter)pickerList.getAdapter()).notifyDataSetChanged();
                return;
            }
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (view.getId() == 0x7f100824 && i == 67 && keyevent.getAction() == 1)
        {
            lastLocations = null;
        }
        return false;
    }

    public boolean onMarkerClick(Marker marker)
    {
        if (verboseLogger.isLoggable)
        {
            FwLog.logMethod(verboseLogger, new Object[0]);
        }
        wasStoreSelected = true;
        wasSelectedFromMap = true;
        moveMapAndShowMarkerInfoWindow(marker);
        selectedStoreInfo.setSelectedStore((StoreAvailability)markerToAvailabilityMap.get(marker));
        ((StorePickerArrayAdapter)pickerList.getAdapter()).notifyDataSetChanged();
        pickerList.smoothScrollToPosition(selectedStoreInfo.getAvailabilities().indexOf(selectedStoreInfo.getSelectedStore()));
        return true;
    }

    public boolean onMyLocationButtonClick()
    {
        Preferences preferences;
        boolean flag;
        preferences = MyApp.getPrefs();
        flag = LocationUtil.isNetworkLocationServicesEnabled(this);
        if (LocationUtil.getLastKnownLocation(this) != null) goto _L2; else goto _L1
_L1:
        (new LocationServicesEnableDialogFragment()).show(getFragmentManager(), "location_services_enable_dialog");
_L4:
        return false;
_L2:
        if (preferences.getShowImproveLocationDialog() && (!flag || !Util.hasNetwork()))
        {
            (new LocationServicesImproveDialogFragment()).show(getFragmentManager(), "location_services_improve_dialog");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onPause()
    {
        super.onPause();
        if (geoCoderCallCount != 0)
        {
            TrackingData trackingdata = new TrackingData("GeoCodeEvent", TrackingType.EVENT);
            trackingdata.addKeyValuePair("gccount", String.valueOf(geoCoderCallCount));
            trackingdata.send(this);
            geoCoderCallCount = 0;
        }
    }

    protected void onResume()
    {
        if (verboseLogger.isLoggable)
        {
            FwLog.logMethod(verboseLogger, new Object[0]);
        }
        super.onResume();
        if (inventoryLookupIsPending) goto _L2; else goto _L1
_L1:
        List list;
        resetUI();
        list = selectedStoreInfo.getAvailabilities();
        if (list == null || list.isEmpty()) goto _L4; else goto _L3
_L3:
        updateUI();
        sendTrackingEvent();
_L2:
        return;
_L4:
        if (list != null)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj1 = LocationUtil.getLastKnownLocation(this);
        if (obj1 != null)
        {
            DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
            obj1 = new LatLng(((Location) (obj1)).getLatitude(), ((Location) (obj1)).getLongitude());
            selectedStoreInfo.setUserLocation(((LatLng) (obj1)), deviceconfiguration.get(DcsInteger.BopisGeocoderBiasBoxSize));
        }
        if (selectedStoreInfo.isForceInventoryLookup())
        {
            if (inventoryBases == null)
            {
                inventoryBases = new ArrayList();
            }
            Object obj = selectedStoreInfo.getSearchRefinedPostalCode();
            if (obj != null)
            {
                inventoryBases.add(new com.ebay.common.net.api.inventory.LookupAvailabilityRequest.PhysicalLocation(this, ((String) (obj)), selectedStoreInfo.site));
            }
            obj = selectedStoreInfo.getPostalCode();
            if (obj != null)
            {
                inventoryBases.add(new com.ebay.common.net.api.inventory.LookupAvailabilityRequest.PhysicalLocation(this, ((String) (obj)), selectedStoreInfo.site));
            }
            obj = selectedStoreInfo.getUserLocation();
            if (obj != null)
            {
                inventoryBases.add(new com.ebay.common.net.api.inventory.LookupAvailabilityRequest.PhysicalLocation(((LatLng) (obj)).latitude, ((LatLng) (obj)).longitude));
            }
            if (inventoryBases.size() > 0)
            {
                callInventoryService((com.ebay.common.net.api.inventory.LookupAvailabilityRequest.PhysicalLocation)inventoryBases.remove(0));
                return;
            }
            displayError(getResources().getString(0x7f070b43));
            sendTrackingEvent();
            if (debugLogger.isLoggable)
            {
                debugLogger.log("Unable to determine store locations.");
                return;
            }
        } else
        if (selectedStoreInfo.getDerivation() == com.ebay.common.model.inventory.InventoryInfo.ListDerivation.LATLNG || selectedStoreInfo.getDerivation() == com.ebay.common.model.inventory.InventoryInfo.ListDerivation.UNKNOWN)
        {
            LatLng latlng = selectedStoreInfo.getUserLocation();
            if (latlng != null)
            {
                callInventoryService(new com.ebay.common.net.api.inventory.LookupAvailabilityRequest.PhysicalLocation(latlng.latitude, latlng.longitude));
                return;
            }
            displayError(getResources().getString(0x7f070b43));
            sendTrackingEvent();
            if (debugLogger.isLoggable)
            {
                debugLogger.log("Unable to determine store locations.");
                return;
            }
        } else
        {
            displayError(getResources().getString(0x7f070b43));
            sendTrackingEvent();
            if (debugLogger.isLoggable)
            {
                debugLogger.log("Unable to determine store locations.");
                return;
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
        displayError(getResources().getString(0x7f070b43));
        sendTrackingEvent();
        if (debugLogger.isLoggable)
        {
            debugLogger.log("Unable to determine store locations.");
            return;
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        if (verboseLogger.isLoggable)
        {
            FwLog.logMethod(verboseLogger, new Object[0]);
        }
        bundle.putParcelable("inventory_info", selectedStoreInfo);
        bundle.putBoolean("inventory_lookup_is_pending", inventoryLookupIsPending);
        bundle.putParcelableArrayList("last_locations_array", lastLocations);
        super.onSaveInstanceState(bundle);
    }

    protected void onStop()
    {
        if (verboseLogger.isLoggable)
        {
            FwLog.logMethod(verboseLogger, new Object[0]);
        }
        LocationUtil.cancelLocationListener(this, locationListener);
        super.onStop();
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
        if (fwloader.isCanceled()) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 9670 9670: default 28
    //                   9670 29;
           goto _L2 _L3
_L2:
        return;
_L3:
        onLookupAvailability((LookupAvailabilityNetLoader)fwloader);
        sendTrackingEvent();
        return;
    }

    protected void onTaskStarted(int i, FwLoader fwloader)
    {
        findViewById(0x7f100142).setVisibility(0);
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (verboseLogger.isLoggable)
        {
            FwLog.logMethod(verboseLogger, new Object[0]);
        }
        if (view.getId() == 0x7f100824 && motionevent.getAction() == 1)
        {
            findViewById(0x7f100822).setVisibility(8);
            findViewById(0x7f100823).setVisibility(0);
            view = getAutoCompleteAdapter();
            if (view != null)
            {
                view.notifyDataSetChanged();
            }
        }
        return false;
    }

    static 
    {
        debugLogger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("StorePicker", 3, "Log StorePickerActivity events");
        verboseLogger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo(debugLogger.tag, 2, "Log extended StorePickerActivity events");
    }














/*
    static List access$902(StorePickerActivity storepickeractivity, List list)
    {
        storepickeractivity.geocodedLocations = list;
        return list;
    }

*/
}
