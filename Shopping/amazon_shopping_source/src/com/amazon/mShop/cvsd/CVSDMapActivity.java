// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.cvsd;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.account.NonZeroLengthTextWatcher;
import com.amazon.mShop.control.cvsd.CVSDController;
import com.amazon.mShop.control.cvsd.CVSDReceivedResult;
import com.amazon.mShop.control.cvsd.CVSDSubscriber;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.UIUtils;
import com.amazon.rio.j2me.client.persistence.DataStore;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.Address;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.OverlayItem;
import com.google.android.maps.Projection;
import java.util.List;

// Referenced classes of package com.amazon.mShop.cvsd:
//            ConvenienceStoreMarkerTapListener, ConvenienceStoreOverlay, CVSDRefinmentsActivity, CVSDStoreDetailsActivity

public class CVSDMapActivity extends MapActivity
    implements CVSDSubscriber, ConvenienceStoreMarkerTapListener
{
    class MyAddressTextWatcher extends NonZeroLengthTextWatcher
    {

        final CVSDMapActivity this$0;

        public void update()
        {
            addressDialogPositiveButton.setEnabled(addressTextWatcher.isWatchedNonZeroLength());
        }

        public MyAddressTextWatcher(EditText edittext)
        {
            this$0 = CVSDMapActivity.this;
            super(edittext);
        }
    }

    class MyLandmarkTextWatcher extends NonZeroLengthTextWatcher
    {

        final CVSDMapActivity this$0;

        public void update()
        {
            landmarkDialogPositiveButton.setEnabled(landmarkTextWatcher.isWatchedNonZeroLength());
        }

        public MyLandmarkTextWatcher(EditText edittext)
        {
            this$0 = CVSDMapActivity.this;
            super(edittext);
        }
    }

    class MyZip1TextWatcher extends NonZeroLengthTextWatcher
    {

        final CVSDMapActivity this$0;

        public void update()
        {
            zipDialogPositiveButton.setEnabled(checkJPZip());
        }

        public MyZip1TextWatcher(EditText edittext)
        {
            this$0 = CVSDMapActivity.this;
            super(edittext);
        }
    }

    class MyZip2TextWatcher extends NonZeroLengthTextWatcher
    {

        final CVSDMapActivity this$0;

        public void update()
        {
            zipDialogPositiveButton.setEnabled(checkJPZip());
        }

        public MyZip2TextWatcher(EditText edittext)
        {
            this$0 = CVSDMapActivity.this;
            super(edittext);
        }
    }

    class MyZipTextWatcher extends NonZeroLengthTextWatcher
    {

        final CVSDMapActivity this$0;

        public void update()
        {
            zipDialogPositiveButton.setEnabled(zipTextWatcher.isWatchedNonZeroLength());
        }

        public MyZipTextWatcher(EditText edittext)
        {
            this$0 = CVSDMapActivity.this;
            super(edittext);
        }
    }

    private class OptionListAdapter extends BaseAdapter
    {

        private final Context mContext;
        private final CharSequence mItems[];
        private final LayoutInflater mLayoutInflater;
        final CVSDMapActivity this$0;

        public int getCount()
        {
            return mItems.length;
        }

        public Object getItem(int i)
        {
            return mItems[i];
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            viewgroup = view;
            if (view == null)
            {
                viewgroup = mLayoutInflater.inflate(com.amazon.mShop.android.lib.R.layout.cvsd_list_item, null);
            }
            view = (TextView)viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.cvsd_list_item_text);
            view.setTextSize(0, view.getResources().getDimension(com.amazon.mShop.android.lib.R.dimen.cvsd_list_item_text_size));
            view.setText(mItems[i]);
            return viewgroup;
        }

        public OptionListAdapter(Context context)
        {
            this$0 = CVSDMapActivity.this;
            super();
            mContext = context;
            mLayoutInflater = LayoutInflater.from(mContext);
            mItems = (new CharSequence[] {
                mContext.getResources().getString(com.amazon.mShop.android.lib.R.string.opl_cvsd_search_address), mContext.getResources().getString(com.amazon.mShop.android.lib.R.string.opl_cvsd_search_zip), mContext.getResources().getString(com.amazon.mShop.android.lib.R.string.opl_cvsd_search_landmark), mContext.getResources().getString(com.amazon.mShop.android.lib.R.string.opl_cvsd_search_location)
            });
        }
    }

    private class StatesSpinnerAdapter extends ArrayAdapter
    {

        final String states[];
        final CVSDMapActivity this$0;

        public StatesSpinnerAdapter(Context context)
        {
            this$0 = CVSDMapActivity.this;
            super(context, 0x1090008);
            setDropDownViewResource(0x1090009);
            states = getResources().getStringArray(com.amazon.mShop.android.lib.R.array.opl_new_address_jp_states);
            cvsdmapactivity = states;
            int j = CVSDMapActivity.this.length;
            for (int i = 0; i < j; i++)
            {
                add(CVSDMapActivity.this[i]);
            }

        }
    }


    private static final String MARKET_LOCALE_FR = "FR";
    private static final String MARKET_LOCALE_JP = "JP";
    private static final double VALUE_1E6 = Math.pow(10D, 6D);
    private static final int VALUE_MY_LOCATION_ZOOM_DEFAULT_LEVEL = 15;
    private final int Zip1MinLength = 3;
    private final int Zip2MinLength = 4;
    private EditText address;
    private Button addressDialogPositiveButton;
    private MyAddressTextWatcher addressTextWatcher;
    private Button bubble;
    private CVSDController cvsdController;
    private LocationListener flyToCurrentLocationLocationListener;
    private EditText landmark;
    private Button landmarkDialogPositiveButton;
    private MyLandmarkTextWatcher landmarkTextWatcher;
    private ConvenienceStoreOverlay mConvenienceStoreOverlay;
    private MapView mMapView;
    private MyLocationOverlay mMyLocationOverlay;
    private LocationListener searchByCurrentLocationLocationListener;
    private EditText zip;
    private EditText zip1;
    private MyZip1TextWatcher zip1TextWatcher;
    private EditText zip2;
    private MyZip2TextWatcher zip2TextWatcher;
    private Button zipDialogPositiveButton;
    private MyZipTextWatcher zipTextWatcher;

    public CVSDMapActivity()
    {
        cvsdController = new CVSDController();
    }

    private void centerMapBasedOnMarket()
    {
        String s = getResources().getString(com.amazon.mShop.android.lib.R.string.opl_new_address_default_country_code);
        GeoPoint geopoint = null;
        byte byte0 = -1;
        if (s.equals("JP"))
        {
            geopoint = new GeoPoint(0x23036f5, 0x8457e04);
            byte0 = 5;
        } else
        if (s.equals("FR"))
        {
            geopoint = new GeoPoint(0x2ced39a, 0x24c4c3);
            byte0 = 5;
        }
        if (geopoint == null || byte0 == -1)
        {
            return;
        } else
        {
            mMapView.getController().setCenter(geopoint);
            mMapView.getController().setZoom(byte0);
            return;
        }
    }

    private boolean checkJPZip()
    {
        return zip1 != null && zip1.length() == 3 && zip2 != null && zip2.length() == 4;
    }

    private void clearMap()
    {
        List list = mMapView.getOverlays();
        if (list != null)
        {
            list.remove(mConvenienceStoreOverlay);
        }
        if (bubble != null)
        {
            bubble.setVisibility(8);
        }
        mMapView.invalidate();
    }

    private void createSearchOptionDialog()
    {
        OptionListAdapter optionlistadapter = new OptionListAdapter(this);
        final AmazonAlertDialog dialog = (new com.amazon.mShop.AmazonAlertDialog.Builder(this)).create();
        AmazonAlertDialog.customizeAlertDialog(this, dialog, getResources().getString(com.amazon.mShop.android.lib.R.string.opl_cvsd_search_by), optionlistadapter, new android.widget.AdapterView.OnItemClickListener() {

            final CVSDMapActivity this$0;
            final AmazonAlertDialog val$dialog;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                if (i != 0) goto _L2; else goto _L1
_L1:
                searchByAddress();
_L4:
                dialog.dismiss();
                return;
_L2:
                if (i == 1)
                {
                    searchByZipCode();
                } else
                if (i == 2)
                {
                    searchByLandmark();
                } else
                if (i == 3)
                {
                    searchByCurrentLocation();
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                this$0 = CVSDMapActivity.this;
                dialog = amazonalertdialog;
                super();
            }
        }, -1);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }

    private void flyToCurrentLocation()
    {
        if (!isLocationProviderEnabled())
        {
            requestUserConfigLocationProvider();
            return;
        }
        if (mMyLocationOverlay != null)
        {
            mMyLocationOverlay.enableMyLocation();
            GeoPoint geopoint = mMyLocationOverlay.getMyLocation();
            if (geopoint != null)
            {
                flyToCurrentLocation(geopoint);
                return;
            }
        }
        final LocationManager locationManager = (LocationManager)getSystemService("location");
        if (flyToCurrentLocationLocationListener == null)
        {
            flyToCurrentLocationLocationListener = new LocationListener() {

                final CVSDMapActivity this$0;
                final LocationManager val$locationManager;

                public void onLocationChanged(Location location)
                {
                    if (location != null)
                    {
                        flyToCurrentLocation(location);
                        locationManager.removeUpdates(flyToCurrentLocationLocationListener);
                    }
                }

                public void onProviderDisabled(String s)
                {
                }

                public void onProviderEnabled(String s)
                {
                }

                public void onStatusChanged(String s, int i, Bundle bundle)
                {
                }

            
            {
                this$0 = CVSDMapActivity.this;
                locationManager = locationmanager;
                super();
            }
            };
        }
        locationManager.requestLocationUpdates("gps", 0L, 0.0F, flyToCurrentLocationLocationListener);
        locationManager.requestLocationUpdates("network", 0L, 0.0F, flyToCurrentLocationLocationListener);
    }

    private void flyToCurrentLocation(Location location)
    {
        if (location != null)
        {
            mMapView.getController().setZoom(15);
            location = new GeoPoint((int)(location.getLatitude() * VALUE_1E6), (int)(location.getLongitude() * VALUE_1E6));
            mMapView.getController().animateTo(location);
        }
    }

    private void flyToCurrentLocation(GeoPoint geopoint)
    {
        if (geopoint != null)
        {
            mMapView.getController().setZoom(15);
            mMapView.getController().animateTo(geopoint);
        }
    }

    private boolean isLocationProviderEnabled()
    {
        LocationManager locationmanager = (LocationManager)getSystemService("location");
        return locationmanager.isProviderEnabled("network") || locationmanager.isProviderEnabled("gps");
    }

    private void requestUserConfigLocationProvider()
    {
        com.amazon.mShop.AmazonAlertDialog.Builder builder = (new com.amazon.mShop.AmazonAlertDialog.Builder(this)).setMessage(getResources().getString(com.amazon.mShop.android.lib.R.string.opl_cvsd_location_settings_message));
        android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

            final CVSDMapActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                if (i == -2)
                {
                    createSearchOptionDialog();
                } else
                if (i == -1)
                {
                    dialoginterface = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                    List list = getPackageManager().queryIntentActivities(dialoginterface, 0x10000);
                    if (list != null && list.size() > 0)
                    {
                        startActivityForResult(dialoginterface, 9);
                        return;
                    } else
                    {
                        showDialogRequestingUserToConfigLocationSettingsManually();
                        return;
                    }
                }
            }

            
            {
                this$0 = CVSDMapActivity.this;
                super();
            }
        };
        builder.setPositiveButton(com.amazon.mShop.android.lib.R.string.alert_ok_button, onclicklistener);
        builder.setNegativeButton(com.amazon.mShop.android.lib.R.string.alert_cancel_button, onclicklistener);
        builder.setTitle(getResources().getString(com.amazon.mShop.android.lib.R.string.opl_cvsd_location_settings_title));
        builder.create().show();
    }

    private void searchByAddress()
    {
        Object obj = LayoutInflater.from(this).inflate(com.amazon.mShop.android.lib.R.layout.cvsd_search_by_address_dialog_content, null);
        address = (EditText)((View) (obj)).findViewById(com.amazon.mShop.android.lib.R.id.cvsd_address_edit);
        addressTextWatcher = new MyAddressTextWatcher(address);
        final Spinner statesSpinner = (Spinner)((View) (obj)).findViewById(com.amazon.mShop.android.lib.R.id.cvsd_states_spinner);
        statesSpinner.setAdapter(new StatesSpinnerAdapter(this));
        Object obj1 = ((View) (obj)).findViewById(com.amazon.mShop.android.lib.R.id.cvsd_search_by_address_jp_states_container);
        final String market = getResources().getString(com.amazon.mShop.android.lib.R.string.opl_new_address_default_country_code);
        if (market.equals("JP"))
        {
            ((View) (obj1)).setVisibility(0);
        } else
        {
            ((View) (obj1)).setVisibility(8);
        }
        obj1 = new com.amazon.mShop.AmazonAlertDialog.Builder(this);
        ((com.amazon.mShop.AmazonAlertDialog.Builder) (obj1)).setTitle(getResources().getString(com.amazon.mShop.android.lib.R.string.opl_cvsd_search_address));
        ((com.amazon.mShop.AmazonAlertDialog.Builder) (obj1)).setView(((View) (obj)));
        ((com.amazon.mShop.AmazonAlertDialog.Builder) (obj1)).setPositiveButton(com.amazon.mShop.android.lib.R.string.opl_cvsd_search_store_button, new android.content.DialogInterface.OnClickListener() {

            final CVSDMapActivity this$0;
            final String val$market;
            final Spinner val$statesSpinner;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                clearMap();
                dialoginterface = null;
                if (market.equals("JP"))
                {
                    dialoginterface = statesSpinner.getSelectedItem().toString();
                }
                UIUtils.closeSoftKeyboard(address);
                cvsdController.searchDeliveryLocationByAddress(dialoginterface, address.getText().toString(), null);
            }

            
            {
                this$0 = CVSDMapActivity.this;
                market = s;
                statesSpinner = spinner;
                super();
            }
        });
        ((com.amazon.mShop.AmazonAlertDialog.Builder) (obj1)).setNegativeButton(com.amazon.mShop.android.lib.R.string.opl_cancel_button, new android.content.DialogInterface.OnClickListener() {

            final CVSDMapActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                if (i == -2)
                {
                    finish();
                }
            }

            
            {
                this$0 = CVSDMapActivity.this;
                super();
            }
        });
        obj = ((com.amazon.mShop.AmazonAlertDialog.Builder) (obj1)).create();
        ((AmazonAlertDialog) (obj)).show();
        addressDialogPositiveButton = ((AmazonAlertDialog) (obj)).getButton(-1);
        addressDialogPositiveButton.setEnabled(false);
        UIUtils.showSoftKeyboard(address);
    }

    private void searchByCurrentLocation()
    {
        if (com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getBoolean("allowUseUserCurrentlocation"))
        {
            clearMap();
            searchDeliveryLocationByCurrentLocation();
            return;
        } else
        {
            showUseCurrentLocationConfirmationDialog();
            return;
        }
    }

    private void searchByLandmark()
    {
        Object obj = LayoutInflater.from(this).inflate(com.amazon.mShop.android.lib.R.layout.cvsd_search_by_landmark_dialog_content, null);
        landmark = (EditText)((View) (obj)).findViewById(com.amazon.mShop.android.lib.R.id.cvsd_landmark_edit);
        landmarkTextWatcher = new MyLandmarkTextWatcher(landmark);
        final Spinner statesSpinner = (Spinner)((View) (obj)).findViewById(com.amazon.mShop.android.lib.R.id.cvsd_states_spinner);
        statesSpinner.setAdapter(new StatesSpinnerAdapter(this));
        Object obj1 = ((View) (obj)).findViewById(com.amazon.mShop.android.lib.R.id.cvsd_search_by_landmark_jp_states_container);
        final String market = getResources().getString(com.amazon.mShop.android.lib.R.string.opl_new_address_default_country_code);
        if (market.equals("JP"))
        {
            ((View) (obj1)).setVisibility(0);
        } else
        {
            ((View) (obj1)).setVisibility(8);
        }
        obj1 = new com.amazon.mShop.AmazonAlertDialog.Builder(this);
        ((com.amazon.mShop.AmazonAlertDialog.Builder) (obj1)).setTitle(getResources().getString(com.amazon.mShop.android.lib.R.string.opl_cvsd_search_landmark));
        ((com.amazon.mShop.AmazonAlertDialog.Builder) (obj1)).setView(((View) (obj)));
        ((com.amazon.mShop.AmazonAlertDialog.Builder) (obj1)).setPositiveButton(com.amazon.mShop.android.lib.R.string.opl_cvsd_search_store_button, new android.content.DialogInterface.OnClickListener() {

            final CVSDMapActivity this$0;
            final String val$market;
            final Spinner val$statesSpinner;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                clearMap();
                dialoginterface = null;
                if (market.equals("JP"))
                {
                    dialoginterface = (String)statesSpinner.getSelectedItem();
                }
                UIUtils.closeSoftKeyboard(landmark);
                cvsdController.searchDeliveryLoationByLandmark(landmark.getText().toString(), dialoginterface, null);
            }

            
            {
                this$0 = CVSDMapActivity.this;
                market = s;
                statesSpinner = spinner;
                super();
            }
        });
        ((com.amazon.mShop.AmazonAlertDialog.Builder) (obj1)).setNegativeButton(com.amazon.mShop.android.lib.R.string.opl_cancel_button, new android.content.DialogInterface.OnClickListener() {

            final CVSDMapActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                if (i == -2)
                {
                    finish();
                }
            }

            
            {
                this$0 = CVSDMapActivity.this;
                super();
            }
        });
        obj = ((com.amazon.mShop.AmazonAlertDialog.Builder) (obj1)).create();
        ((AmazonAlertDialog) (obj)).show();
        landmarkDialogPositiveButton = ((AmazonAlertDialog) (obj)).getButton(-1);
        landmarkDialogPositiveButton.setEnabled(false);
        UIUtils.showSoftKeyboard(landmark);
    }

    private void searchByZipCode()
    {
        Object obj;
        final String market;
        obj = LayoutInflater.from(this).inflate(com.amazon.mShop.android.lib.R.layout.cvsd_search_by_zip_dialog_content, null);
        market = getResources().getString(com.amazon.mShop.android.lib.R.string.opl_new_address_default_country_code);
        if (!market.equals("JP")) goto _L2; else goto _L1
_L1:
        ((View) (obj)).findViewById(com.amazon.mShop.android.lib.R.id.cvsd_search_by_zip_jp_container).setVisibility(0);
        zip1 = (EditText)((View) (obj)).findViewById(com.amazon.mShop.android.lib.R.id.cvsd_zip1_edit);
        zip2 = (EditText)((View) (obj)).findViewById(com.amazon.mShop.android.lib.R.id.cvsd_zip2_edit);
        zip1TextWatcher = new MyZip1TextWatcher(zip1);
        zip2TextWatcher = new MyZip2TextWatcher(zip2);
        UIUtils.setMaxLengthFromRule(zip1, com.amazon.mShop.android.lib.R.string.opl_address_zip1_rule);
        UIUtils.setMaxLengthFromRule(zip2, com.amazon.mShop.android.lib.R.string.opl_address_zip2_rule);
_L4:
        com.amazon.mShop.AmazonAlertDialog.Builder builder = new com.amazon.mShop.AmazonAlertDialog.Builder(this);
        builder.setTitle(getResources().getString(com.amazon.mShop.android.lib.R.string.opl_cvsd_search_zip));
        builder.setView(((View) (obj)));
        builder.setPositiveButton(com.amazon.mShop.android.lib.R.string.opl_cvsd_search_store_button, new android.content.DialogInterface.OnClickListener() {

            final CVSDMapActivity this$0;
            final String val$market;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                clearMap();
                dialoginterface = null;
                if (market.equals("JP"))
                {
                    dialoginterface = zip1.getText().toString();
                    String s = zip2.getText().toString();
                    dialoginterface = (new StringBuilder()).append(dialoginterface).append("-").append(s).toString();
                } else
                if (market.equals("FR"))
                {
                    dialoginterface = zip.getText().toString();
                }
                if (zip1 != null || zip != null)
                {
                    EditText edittext;
                    if (zip1 != null)
                    {
                        edittext = zip1;
                    } else
                    {
                        edittext = zip;
                    }
                    UIUtils.closeSoftKeyboard(edittext);
                }
                cvsdController.searchDeliveryLocationByZipcode(dialoginterface, null);
            }

            
            {
                this$0 = CVSDMapActivity.this;
                market = s;
                super();
            }
        });
        builder.setNegativeButton(com.amazon.mShop.android.lib.R.string.opl_cancel_button, new android.content.DialogInterface.OnClickListener() {

            final CVSDMapActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                if (i == -2)
                {
                    finish();
                }
            }

            
            {
                this$0 = CVSDMapActivity.this;
                super();
            }
        });
        obj = builder.create();
        ((AmazonAlertDialog) (obj)).show();
        zipDialogPositiveButton = ((AmazonAlertDialog) (obj)).getButton(-1);
        zipDialogPositiveButton.setEnabled(false);
        if (zip1 != null)
        {
            UIUtils.showSoftKeyboard(zip1);
        }
        if (zip != null)
        {
            UIUtils.showSoftKeyboard(zip);
        }
        return;
_L2:
        if (market.equals("FR"))
        {
            ((View) (obj)).findViewById(com.amazon.mShop.android.lib.R.id.cvsd_search_by_zip_fr_container).setVisibility(0);
            zip = (EditText)((View) (obj)).findViewById(com.amazon.mShop.android.lib.R.id.cvsd_zip_edit);
            zipTextWatcher = new MyZipTextWatcher(zip);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void searchDeliveryLocationByAddress(Address address1)
    {
        cvsdController.searchDeliveryLocationByAddress(address1, null);
    }

    private void searchDeliveryLocationByCurrentLocation()
    {
        if (!isLocationProviderEnabled())
        {
            requestUserConfigLocationProvider();
            return;
        }
        if (mMyLocationOverlay != null)
        {
            mMyLocationOverlay.enableMyLocation();
            GeoPoint geopoint = mMyLocationOverlay.getMyLocation();
            if (geopoint != null)
            {
                flyToCurrentLocation(geopoint);
                searchDeliveryLocationByCurrentLocation((new StringBuilder()).append((double)geopoint.getLatitudeE6() / VALUE_1E6).append("").toString(), (new StringBuilder()).append((double)geopoint.getLongitudeE6() / VALUE_1E6).append("").toString());
                return;
            }
        }
        final LocationManager locationManager = (LocationManager)getSystemService("location");
        if (searchByCurrentLocationLocationListener == null)
        {
            searchByCurrentLocationLocationListener = new LocationListener() {

                final CVSDMapActivity this$0;
                final LocationManager val$locationManager;

                public void onLocationChanged(Location location)
                {
                    if (location != null)
                    {
                        flyToCurrentLocation(location);
                        searchDeliveryLocationByCurrentLocation((new StringBuilder()).append(location.getLatitude()).append("").toString(), (new StringBuilder()).append(location.getLongitude()).append("").toString());
                        locationManager.removeUpdates(searchByCurrentLocationLocationListener);
                    }
                }

                public void onProviderDisabled(String s)
                {
                }

                public void onProviderEnabled(String s)
                {
                }

                public void onStatusChanged(String s, int i, Bundle bundle)
                {
                }

            
            {
                this$0 = CVSDMapActivity.this;
                locationManager = locationmanager;
                super();
            }
            };
        }
        locationManager.requestLocationUpdates("gps", 0L, 0.0F, searchByCurrentLocationLocationListener);
        locationManager.requestLocationUpdates("network", 0L, 0.0F, searchByCurrentLocationLocationListener);
    }

    private void searchDeliveryLocationByCurrentLocation(String s, String s1)
    {
        cvsdController.searchDeliveryLocationByCurrentLocation(s, s1);
    }

    private void showDialogRequestingUserToConfigLocationSettingsManually()
    {
        com.amazon.mShop.AmazonAlertDialog.Builder builder = (new com.amazon.mShop.AmazonAlertDialog.Builder(this)).setMessage(getResources().getString(com.amazon.mShop.android.lib.R.string.opl_cvsd_manual_location_settings_message));
        android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

            final CVSDMapActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                if (i == -1)
                {
                    createSearchOptionDialog();
                }
            }

            
            {
                this$0 = CVSDMapActivity.this;
                super();
            }
        };
        builder.setPositiveButton(com.amazon.mShop.android.lib.R.string.alert_ok_button, onclicklistener);
        builder.setTitle(getResources().getString(com.amazon.mShop.android.lib.R.string.opl_cvsd_manual_location_settings_title));
        builder.create().show();
    }

    private void showUseCurrentLocationConfirmationDialog()
    {
        com.amazon.mShop.AmazonAlertDialog.Builder builder = (new com.amazon.mShop.AmazonAlertDialog.Builder(this)).setMessage(getResources().getString(com.amazon.mShop.android.lib.R.string.opl_cvsd_use_current_location_confirm));
        android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

            final CVSDMapActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                if (i == -2)
                {
                    createSearchOptionDialog();
                } else
                if (i == -1)
                {
                    com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putBoolean("allowUseUserCurrentlocation", true);
                    searchDeliveryLocationByCurrentLocation();
                    return;
                }
            }

            
            {
                this$0 = CVSDMapActivity.this;
                super();
            }
        };
        builder.setPositiveButton(com.amazon.mShop.android.lib.R.string.alert_ok_button, onclicklistener);
        builder.setNegativeButton(com.amazon.mShop.android.lib.R.string.alert_cancel_button, onclicklistener);
        builder.create().show();
    }

    protected boolean isRouteDisplayed()
    {
        return false;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i != 8) goto _L2; else goto _L1
_L1:
        if (j == -1)
        {
            i = intent.getExtras().getInt("com.amazon.mShop.cvsd.CVSDRefinementsView.KEY_REFINEMENTS_SELECTED_INDEX");
            intent = (Address)CVSDReceivedResult.receivedAddresss.get(i);
            CVSDReceivedResult.reset();
            searchDeliveryLocationByAddress(intent);
        }
_L4:
        return;
_L2:
        if (i != 7)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (j != -1) goto _L4; else goto _L3
_L3:
        setResult(-1);
        finish();
        return;
        if (i != 9) goto _L4; else goto _L5
_L5:
        createSearchOptionDialog();
        return;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setTitle(com.amazon.mShop.android.lib.R.string.opl_cvsd_search_for_a_convenience_store);
        setTitle(getString(com.amazon.mShop.android.lib.R.string.opl_cvsd_search_for_a_convenience_store));
        cvsdController.setSubscriber(this);
        setContentView(com.amazon.mShop.android.lib.R.layout.cvsd_map);
        mMapView = (MapView)findViewById(com.amazon.mShop.android.lib.R.id.mapview);
        if (mMapView == null)
        {
            return;
        }
        mMapView.setBuiltInZoomControls(true);
        mMapView.setReticleDrawMode(com.google.android.maps.MapView.ReticleDrawMode.DRAW_RETICLE_UNDER);
        bundle = mMapView.getOverlays();
        mMyLocationOverlay = new MyLocationOverlay(this, mMapView);
        bundle.add(mMyLocationOverlay);
        ((Button)findViewById(com.amazon.mShop.android.lib.R.id.cvsd_search_option_button)).setOnClickListener(new android.view.View.OnClickListener() {

            final CVSDMapActivity this$0;

            public void onClick(View view)
            {
                createSearchOptionDialog();
            }

            
            {
                this$0 = CVSDMapActivity.this;
                super();
            }
        });
        ((Button)findViewById(com.amazon.mShop.android.lib.R.id.cvsd_current_location_button)).setOnClickListener(new android.view.View.OnClickListener() {

            final CVSDMapActivity this$0;

            public void onClick(View view)
            {
                if (com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getBoolean("allowUseUserCurrentlocation"))
                {
                    flyToCurrentLocation();
                    return;
                } else
                {
                    view = (new com.amazon.mShop.AmazonAlertDialog.Builder(CVSDMapActivity.this)).setMessage(com.amazon.mShop.android.lib.R.string.opl_cvsd_use_current_location_confirm);
                    android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

                        final _cls2 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            if (i == -1)
                            {
                                com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putBoolean("allowUseUserCurrentlocation", true);
                                flyToCurrentLocation();
                            } else
                            if (i == -2)
                            {
                                return;
                            }
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    };
                    view.setPositiveButton(com.amazon.mShop.android.lib.R.string.alert_ok_button, onclicklistener);
                    view.setNegativeButton(com.amazon.mShop.android.lib.R.string.alert_cancel_button, onclicklistener);
                    view.create().show();
                    return;
                }
            }

            
            {
                this$0 = CVSDMapActivity.this;
                super();
            }
        });
        if (com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getBoolean("allowUseUserCurrentlocation"))
        {
            searchDeliveryLocationByCurrentLocation();
        } else
        {
            showUseCurrentLocationConfirmationDialog();
        }
        centerMapBasedOnMarket();
    }

    public void onDeliveryLocationsReceived(List list)
    {
        if (list.size() > 0)
        {
            mConvenienceStoreOverlay = new ConvenienceStoreOverlay(getResources().getDrawable(com.amazon.mShop.android.lib.R.drawable.android_cvsd_pin), list, this);
            mMapView.getOverlays().add(mConvenienceStoreOverlay);
            mMapView.getController().zoomToSpan((int)((double)mConvenienceStoreOverlay.getLatSpanE6() * 1.2D), (int)((double)mConvenienceStoreOverlay.getLonSpanE6() * 1.2D));
            int i = mConvenienceStoreOverlay.getItem(0).getPoint().getLatitudeE6();
            int j = mConvenienceStoreOverlay.getItem(0).getPoint().getLongitudeE6();
            mMapView.getController().animateTo(new GeoPoint(i, j));
        }
    }

    protected void onDestroy()
    {
        cvsdController.setSubscriber(null);
        super.onDestroy();
    }

    public void onError(Exception exception, ServiceCall servicecall)
    {
    }

    public void onNoOverlayItemTap()
    {
        if (bubble != null)
        {
            bubble.setVisibility(8);
        }
    }

    public void onOnlyMessageReceived(String s)
    {
        UIUtils.alert(this, s);
    }

    protected void onPause()
    {
        super.onPause();
        LocationManager locationmanager = (LocationManager)getSystemService("location");
        if (locationmanager != null && flyToCurrentLocationLocationListener != null)
        {
            locationmanager.removeUpdates(flyToCurrentLocationLocationListener);
        }
        if (locationmanager != null && searchByCurrentLocationLocationListener != null)
        {
            locationmanager.removeUpdates(searchByCurrentLocationLocationListener);
        }
        if (mMyLocationOverlay != null)
        {
            mMyLocationOverlay.disableMyLocation();
        }
    }

    public void onRefinementsReceived()
    {
        startActivityForResult(new Intent(this, com/amazon/mShop/cvsd/CVSDRefinmentsActivity), 8);
    }

    protected void onResume()
    {
        super.onResume();
        if (com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getBoolean("allowUseUserCurrentlocation") && mMyLocationOverlay != null)
        {
            mMyLocationOverlay.enableMyLocation();
        }
    }

    public void onTap(final OverlayItem selectedAddress)
    {
        GeoPoint geopoint = selectedAddress.getPoint();
        mMapView.getProjection().toPixels(geopoint, new Point());
        int i = getResources().getDrawable(com.amazon.mShop.android.lib.R.drawable.android_cvsd_pin).getIntrinsicHeight();
        if (bubble == null)
        {
            bubble = (Button)LayoutInflater.from(this).inflate(com.amazon.mShop.android.lib.R.layout.cvsd_bubble_button, null);
            bubble.setSingleLine(true);
            bubble.setEllipsize(android.text.TextUtils.TruncateAt.END);
            bubble.setLayoutParams(new com.google.android.maps.MapView.LayoutParams(-2, -2, geopoint, 0, -i, 81));
            bubble.setText(selectedAddress.getTitle());
            mMapView.addView(bubble);
        } else
        {
            bubble.setVisibility(0);
            bubble.setLayoutParams(new com.google.android.maps.MapView.LayoutParams(-2, -2, geopoint, 0, -i, 81));
            bubble.setText(selectedAddress.getTitle());
        }
        i = mConvenienceStoreOverlay.getOverlayItemIndex(selectedAddress);
        mMapView.getController().animateTo(selectedAddress.getPoint());
        selectedAddress = (Address)cvsdController.getResultAddressList().get(i);
        bubble.setOnClickListener(new android.view.View.OnClickListener() {

            final CVSDMapActivity this$0;
            final Address val$selectedAddress;

            public void onClick(View view)
            {
                CVSDReceivedResult.reset();
                CVSDReceivedResult.receivedType = 0;
                CVSDReceivedResult.receivedAddresss.add(selectedAddress);
                view = new Intent(CVSDMapActivity.this, com/amazon/mShop/cvsd/CVSDStoreDetailsActivity);
                startActivityForResult(view, 7);
            }

            
            {
                this$0 = CVSDMapActivity.this;
                selectedAddress = address1;
                super();
            }
        });
    }



























}
