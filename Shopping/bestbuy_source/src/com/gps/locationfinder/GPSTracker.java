// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gps.locationfinder;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import com.inc247.ChatSDKUtil;
import com.inc247.bridge.ChatSDKNativeToJSBridge;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public class GPSTracker extends Service
    implements LocationListener
{

    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10L;
    private static final long MIN_TIME_BW_UPDATES = 60000L;
    public static String OnChangedLatitude;
    public static String OnChangedLongitude;
    public static Location location;
    public static LocationManager locationManager;
    public static String sendChangedLocationToJS = "ReceivedLocation";
    boolean canGetLocation;
    JSONObject data;
    boolean isGPSEnabled;
    boolean isNetworkEnabled;
    public double latitude;
    public double longitude;
    private final Context mContext;

    public GPSTracker(Context context)
    {
        isGPSEnabled = false;
        isNetworkEnabled = false;
        canGetLocation = false;
        mContext = context;
        getLocation();
    }

    public boolean canGetLocation()
    {
        return canGetLocation;
    }

    public String getAddressLine(Context context)
    {
        context = getGeocoderAddress(context);
        if (context != null && context.size() > 0)
        {
            context = (Address)context.get(0);
            return (new StringBuilder(String.valueOf(context.getAddressLine(1)))).append("\n").append(context.getAddressLine(2)).append("\n").append(context.getAddressLine(3)).toString();
        } else
        {
            return null;
        }
    }

    public String getCountryName(Context context)
    {
        context = getGeocoderAddress(context);
        if (context != null && context.size() > 0)
        {
            return ((Address)context.get(0)).getCountryName();
        } else
        {
            return null;
        }
    }

    public List getGeocoderAddress(Context context)
    {
        if (location == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        context = new Geocoder(context, Locale.ENGLISH);
        context = context.getFromLocation(latitude, longitude, 1);
        return context;
        context;
        context.printStackTrace();
        ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString((new StringBuilder("{'Error':'")).append(context).append("'}").toString()));
        return null;
    }

    public double getLatitude()
    {
        if (location != null)
        {
            latitude = location.getLatitude();
        }
        return latitude;
    }

    public String getLocality(Context context)
    {
        context = getGeocoderAddress(context);
        if (context != null && context.size() > 0)
        {
            return ((Address)context.get(0)).getLocality();
        } else
        {
            return null;
        }
    }

    public Location getLocation()
    {
        try
        {
            locationManager = (LocationManager)mContext.getSystemService("location");
            isGPSEnabled = locationManager.isProviderEnabled("gps");
            isNetworkEnabled = locationManager.isProviderEnabled("network");
            if (isGPSEnabled || isNetworkEnabled)
            {
                canGetLocation = true;
                if (isNetworkEnabled)
                {
                    locationManager.requestLocationUpdates("network", 60000L, 10F, this);
                    if (locationManager != null)
                    {
                        location = locationManager.getLastKnownLocation("network");
                        updateGPSCoordinates();
                    }
                }
                if (isGPSEnabled && location == null)
                {
                    locationManager.requestLocationUpdates("gps", 60000L, 10F, this);
                    if (locationManager != null)
                    {
                        location = locationManager.getLastKnownLocation("gps");
                        updateGPSCoordinates();
                    }
                }
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString((new StringBuilder("{'Error':'")).append(exception).append("'}").toString()));
        }
        return location;
    }

    public double getLongitude()
    {
        if (location != null)
        {
            longitude = location.getLongitude();
        }
        return longitude;
    }

    public String getPostalCode(Context context)
    {
        context = getGeocoderAddress(context);
        if (context != null && context.size() > 0)
        {
            return ((Address)context.get(0)).getPostalCode();
        } else
        {
            return null;
        }
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onLocationChanged(Location location1)
    {
        try
        {
            OnChangedLongitude = String.valueOf(location1.getLongitude());
            OnChangedLatitude = String.valueOf(location1.getLatitude());
        }
        // Misplaced declaration of an exception variable
        catch (Location location1)
        {
            location1.printStackTrace();
            ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString((new StringBuilder("{'Error':'")).append(location1).append("'}").toString()));
        }
        location1 = ChatSDKUtil.sendLocation(sendChangedLocationToJS, OnChangedLongitude, OnChangedLatitude);
        if (locationManager == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        ChatSDKNativeToJSBridge.executeJS(location1);
        ChatSDKNativeToJSBridge.data.put("longitude : ", OnChangedLongitude);
        ChatSDKNativeToJSBridge.data.put("latitude : ", OnChangedLatitude);
        return;
        location1;
        location1.printStackTrace();
        ChatSDKNativeToJSBridge.executeJS(ChatSDKUtil.createExecJSString((new StringBuilder("{'Error':'")).append(location1).append("'}").toString()));
        return;
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

    public void stopUsingGPS()
    {
        if (locationManager != null)
        {
            locationManager.removeUpdates(this);
        }
    }

    public void updateGPSCoordinates()
    {
        if (location != null)
        {
            latitude = location.getLatitude();
            longitude = location.getLongitude();
        }
    }

}
