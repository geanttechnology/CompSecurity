// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.util;

import android.content.Context;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class LocationUtil
{
    public static class LocationHandler extends Handler
    {

        public static final int ERR = -1;
        public static final int OK = 0;
        public static final int OK_LOCATION = 1;
        private Location location;

        public Location getLocation()
        {
            if (location != null)
            {
                return new Location(location);
            } else
            {
                return null;
            }
        }

        public void handleError(Message message)
        {
        }

        public void handleLocation(Location location1)
        {
        }

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                return;

            case -1: 
                handleError(message);
                return;

            case 0: // '\0'
                handleOk(message);
                return;

            case 1: // '\001'
                break;
            }
            if (message.obj instanceof Location)
            {
                location = (Location)message.obj;
            }
            if (location != null)
            {
                message = new Location(location);
            } else
            {
                message = null;
            }
            handleLocation(message);
        }

        public void handleOk(Message message)
        {
        }

        public LocationHandler()
        {
        }
    }


    private LocationUtil()
    {
    }

    public static void getBestLocation(Context context, LocationHandler locationhandler)
        throws Exception
    {
        getLocation(null, context, locationhandler);
    }

    private static String getBestProvider(LocationManager locationmanager)
    {
        if (locationmanager == null)
        {
            return null;
        } else
        {
            Criteria criteria = new Criteria();
            criteria.setCostAllowed(true);
            criteria.setPowerRequirement(0);
            criteria.setBearingRequired(false);
            criteria.setSpeedRequired(false);
            criteria.setAltitudeRequired(false);
            criteria.setAccuracy(2);
            return locationmanager.getBestProvider(criteria, true);
        }
    }

    public static void getGPSLocation(Context context, LocationHandler locationhandler)
        throws Exception
    {
        getLocation("gps", context, locationhandler);
    }

    public static Location getLastBestLocation(Context context)
    {
        Object obj;
        if (context != null)
        {
            if ((obj = context.getSystemService("location")) != null)
            {
                return getLastLocation(getBestProvider((LocationManager)obj), context);
            }
        }
        return null;
    }

    public static Location getLastGPSLocation(Context context)
    {
        return getLastLocation("gps", context);
    }

    public static Location getLastLocation(String s, Context context)
    {
        if (context != null)
        {
            if ((context = ((Context) (context.getSystemService("location")))) != null)
            {
                return ((LocationManager)context).getLastKnownLocation(s);
            }
        }
        return null;
    }

    public static Location getLastNetworkLocation(Context context)
    {
        return getLastLocation("network", context);
    }

    public static void getLocation(String s, Context context, LocationHandler locationhandler)
        throws Exception
    {
        if (context == null)
        {
            throw new Exception("No Context");
        }
        context = ((Context) (context.getSystemService("location")));
        if (context == null)
        {
            throw new Exception("No LocationManager");
        }
        LocationManager locationmanager = (LocationManager)context;
        if (locationmanager == null)
        {
            throw new Exception("No LocationManager");
        }
        context = s;
        if (s == null)
        {
            context = getBestProvider(locationmanager);
        }
        if (context == null)
        {
            throw new Exception("No Provider available");
        } else
        {
            locationmanager.requestLocationUpdates(context, 0L, 0.0F, new LocationListener(locationhandler, locationmanager) {

                final LocationHandler val$handler;
                final LocationManager val$lm;

                public void onLocationChanged(Location location)
                {
                    if (handler != null)
                    {
                        Message message = Message.obtain();
                        message.what = 1;
                        message.obj = location;
                        handler.sendMessage(message);
                    }
                    lm.removeUpdates(this);
                }

                public void onProviderDisabled(String s1)
                {
                    if (handler != null)
                    {
                        handler.sendEmptyMessage(-1);
                    }
                    lm.removeUpdates(this);
                }

                public void onProviderEnabled(String s1)
                {
                }

                public void onStatusChanged(String s1, int i, Bundle bundle)
                {
                }

            
            {
                handler = locationhandler;
                lm = locationmanager;
                super();
            }
            });
            return;
        }
    }

    public static void getNetworkLocation(Context context, LocationHandler locationhandler)
        throws Exception
    {
        getLocation("network", context, locationhandler);
    }

    public static boolean isGPSOn(Context context)
    {
        if (context != null)
        {
            if ((context = ((Context) (context.getSystemService("location")))) != null && ((LocationManager)context).isProviderEnabled("gps"))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean isLocationServiceAvailable(Context context)
    {
        return isNetworkLocationOn(context) || isGPSOn(context);
    }

    public static boolean isNetworkLocationOn(Context context)
    {
        if (context != null)
        {
            if ((context = ((Context) (context.getSystemService("location")))) != null && ((LocationManager)context).isProviderEnabled("network"))
            {
                return true;
            }
        }
        return false;
    }

    public static List lookupAddresses(String s, int i, Context context)
    {
        Geocoder geocoder;
        geocoder = new Geocoder(context, Locale.getDefault());
        context = new ArrayList();
        List list = geocoder.getFromLocationName(s, i);
        context = list;
_L1:
label0:
        {
            Object obj;
            if (context != null)
            {
                obj = context;
                if (!context.isEmpty())
                {
                    break label0;
                }
            }
            Exception exception;
            try
            {
                obj = geocoder.getFromLocationName(s, i);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return context;
            }
        }
        return ((List) (obj));
        exception;
          goto _L1
    }
}
