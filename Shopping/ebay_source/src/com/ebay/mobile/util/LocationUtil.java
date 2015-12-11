// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.util;

import android.app.Service;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.nautilus.domain.data.PostalCodeSpecification;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.util.FwLog;
import java.util.List;

public class LocationUtil
{

    private static final long LOCATION_STALENESS_THRESHOLD = 10000L;
    private static final int MIN_ACCEPTABLE_ACCURACY = 30;
    private static com.ebay.nautilus.kernel.util.FwLog.LogInfo debugLogger;
    private static com.ebay.nautilus.kernel.util.FwLog.LogInfo verboseLogger;

    public LocationUtil()
    {
    }

    public static void addGeoTagsToTrackingData(Context context, TrackingData trackingdata, Location location)
    {
        if ((DeviceConfiguration.getAsync().get(DcsBoolean.geoTracking) || verboseLogger.isLoggable) && trackingdata != null)
        {
            if (location != null)
            {
                if ("gps".equals(location.getProvider()))
                {
                    trackingdata.addKeyValuePair("mlocgran", "high");
                } else
                {
                    trackingdata.addKeyValuePair("mlocgran", "low");
                }
                trackingdata.addKeyValuePair("mloc", (new StringBuilder()).append(location.getLatitude()).append(",").append(location.getLongitude()).toString());
                if (location.hasAccuracy())
                {
                    trackingdata.addKeyValuePair("mlocacc", String.valueOf((int)location.getAccuracy()));
                } else
                {
                    trackingdata.addKeyValuePair("mlocacc", "-1");
                }
                trackingdata.addKeyValuePair("mlocage", String.valueOf(System.currentTimeMillis() - location.getTime()));
                if (location.hasAltitude())
                {
                    trackingdata.addKeyValuePair("mlocalt", String.valueOf((int)location.getAltitude()));
                }
                if (location.hasBearing())
                {
                    trackingdata.addKeyValuePair("mlocdir", String.valueOf(location.getBearing()));
                }
                if (location.hasSpeed())
                {
                    trackingdata.addKeyValuePair("mlocspeed", String.valueOf((int)location.getSpeed()));
                }
            } else
            {
                trackingdata.addKeyValuePair("mlocerr", "1");
            }
            trackingdata.addKeyValuePair("mlocset", getAvailableProvidersForTracking(context));
        }
    }

    public static void cancelLocationListener(Context context, LocationListener locationlistener)
    {
        if (verboseLogger.isLoggable)
        {
            FwLog.logMethod(verboseLogger, new Object[0]);
        }
        if (locationlistener != null)
        {
            context = (LocationManager)context.getSystemService("location");
            if (context != null)
            {
                context.removeUpdates(locationlistener);
            }
        }
    }

    public static final com.ebay.common.net.api.inventory.LookupAvailabilityRequest.PhysicalLocation getAvailableLocation(Context context, String s, String s1)
    {
        if (!TextUtils.isEmpty(s))
        {
            context = new com.ebay.common.net.api.inventory.LookupAvailabilityRequest.PhysicalLocation(context, s, s1);
        } else
        {
            s = null;
            PostalCodeSpecification postalcodespecification = MyApp.getPrefs().getPostalCode();
            if (postalcodespecification != null && !TextUtils.isEmpty(postalcodespecification.postalCode))
            {
                return new com.ebay.common.net.api.inventory.LookupAvailabilityRequest.PhysicalLocation(context, postalcodespecification.postalCode, s1);
            }
            s1 = getLastKnownLocation(context);
            context = s;
            if (s1 != null)
            {
                return new com.ebay.common.net.api.inventory.LookupAvailabilityRequest.PhysicalLocation(s1.getLatitude(), s1.getLongitude());
            }
        }
        return context;
    }

    public static String getAvailableProvidersForTracking(Context context)
    {
        boolean flag;
        boolean flag1;
label0:
        {
            if (verboseLogger.isLoggable)
            {
                FwLog.logMethod(verboseLogger, new Object[0]);
            }
            String s = null;
            if (DeviceConfiguration.getAsync().get(DcsBoolean.geoTracking) || verboseLogger.isLoggable)
            {
                context = (LocationManager)context.getSystemService("location");
                flag = context.isProviderEnabled("network");
                flag1 = context.isProviderEnabled("gps");
                if (!flag1 || !flag)
                {
                    break label0;
                }
                s = "3";
            }
            return s;
        }
        if (flag)
        {
            return "5";
        }
        if (flag1)
        {
            return "4";
        } else
        {
            return "0";
        }
    }

    public static Location getLastKnownLocation(Context context)
    {
        if (verboseLogger.isLoggable)
        {
            FwLog.logMethod(verboseLogger, new Object[0]);
        }
        Object obj = null;
        LocationManager locationmanager = (LocationManager)context.getSystemService("location");
        context = obj;
        if (locationmanager != null)
        {
            context = obj;
            if (locationmanager.getAllProviders().contains("passive"))
            {
                context = locationmanager.getLastKnownLocation("passive");
            }
        }
        if (debugLogger.isLoggable)
        {
            debugLogger.log((new StringBuilder()).append("Last known location: ").append(context).toString());
        }
        return context;
    }

    public static boolean isGpsLocationServicesEnabled(Context context)
    {
        context = (LocationManager)context.getSystemService("location");
        return context != null && context.isProviderEnabled("gps");
    }

    public static boolean isNetworkLocationServicesEnabled(Context context)
    {
        context = (LocationManager)context.getSystemService("location");
        return context != null && context.isProviderEnabled("network");
    }

    public static LocationListener primeLastLocationFromGps(Context context)
    {
        if (verboseLogger.isLoggable)
        {
            FwLog.logMethod(verboseLogger, new Object[0]);
        }
        Object obj = null;
        LocationManager locationmanager = (LocationManager)context.getSystemService("location");
        LocationListener locationlistener = obj;
        if (locationmanager != null)
        {
            locationlistener = obj;
            if (locationmanager.getAllProviders().contains("gps"))
            {
                locationlistener = new LocationListener(locationmanager, context) {

                    final Context val$context;
                    final LocationManager val$locationManager;

                    public void onLocationChanged(Location location)
                    {
                        if (LocationUtil.verboseLogger.isLoggable)
                        {
                            FwLog.logMethod(LocationUtil.verboseLogger, new Object[] {
                                location
                            });
                        }
                        if (location.getAccuracy() < 30F)
                        {
                            locationManager.removeUpdates(this);
                        }
                    }

                    public void onProviderDisabled(String s)
                    {
                        if (LocationUtil.verboseLogger.isLoggable)
                        {
                            FwLog.logMethod(LocationUtil.verboseLogger, new Object[] {
                                s
                            });
                        }
                        locationManager.removeUpdates(this);
                        LocationUtil.primeLastLocationFromNetwork(context);
                    }

                    public void onProviderEnabled(String s)
                    {
                        if (LocationUtil.verboseLogger.isLoggable)
                        {
                            FwLog.logMethod(LocationUtil.verboseLogger, new Object[] {
                                s
                            });
                        }
                        locationManager.removeUpdates(this);
                    }

                    public void onStatusChanged(String s, int i, Bundle bundle)
                    {
                        if (LocationUtil.verboseLogger.isLoggable)
                        {
                            FwLog.logMethod(LocationUtil.verboseLogger, new Object[] {
                                s, Integer.valueOf(i)
                            });
                        }
                        locationManager.removeUpdates(this);
                    }

            
            {
                locationManager = locationmanager;
                context = context1;
                super();
            }
                };
                locationmanager.requestLocationUpdates("gps", 0L, 0.0F, locationlistener);
            }
        }
        return locationlistener;
    }

    public static void primeLastLocationFromNetwork(Context context)
    {
        if (verboseLogger.isLoggable)
        {
            FwLog.logMethod(verboseLogger, new Object[0]);
        }
        context = (LocationManager)context.getSystemService("location");
        if (context != null && context.getAllProviders().contains("network"))
        {
            context.requestLocationUpdates("network", 0L, 0.0F, new LocationListener(context) {

                final LocationManager val$locationManager;

                public void onLocationChanged(Location location)
                {
                    if (LocationUtil.verboseLogger.isLoggable)
                    {
                        FwLog.logMethod(LocationUtil.verboseLogger, new Object[] {
                            location
                        });
                    }
                    locationManager.removeUpdates(this);
                }

                public void onProviderDisabled(String s)
                {
                    if (LocationUtil.verboseLogger.isLoggable)
                    {
                        FwLog.logMethod(LocationUtil.verboseLogger, new Object[] {
                            s
                        });
                    }
                    locationManager.removeUpdates(this);
                }

                public void onProviderEnabled(String s)
                {
                    if (LocationUtil.verboseLogger.isLoggable)
                    {
                        FwLog.logMethod(LocationUtil.verboseLogger, new Object[] {
                            s
                        });
                    }
                    locationManager.removeUpdates(this);
                }

                public void onStatusChanged(String s, int i, Bundle bundle)
                {
                    if (LocationUtil.verboseLogger.isLoggable)
                    {
                        FwLog.logMethod(LocationUtil.verboseLogger, new Object[] {
                            s, Integer.valueOf(i)
                        });
                    }
                    locationManager.removeUpdates(this);
                }

            
            {
                locationManager = locationmanager;
                super();
            }
            });
        }
    }

    public static void sendForegroundOrBackgroundEvent(Service service, String s)
    {
        TrackingData trackingdata;
label0:
        {
            Location location;
label1:
            {
                if (verboseLogger.isLoggable)
                {
                    FwLog.logMethod(verboseLogger, new Object[0]);
                }
                trackingdata = new TrackingData(s, TrackingType.EVENT);
                if (!DeviceConfiguration.getAsync().get(DcsBoolean.geoTracking) && !verboseLogger.isLoggable)
                {
                    break label0;
                }
                Location location1 = getLastKnownLocation(service);
                if (location1 != null)
                {
                    location = location1;
                    if (System.currentTimeMillis() - location1.getTime() <= 10000L)
                    {
                        break label1;
                    }
                }
                if ("Foreground".equals(s))
                {
                    primeLastLocationFromNetwork(service);
                }
                location = getLastKnownLocation(service);
            }
            addGeoTagsToTrackingData(service, trackingdata, location);
        }
        trackingdata.send(service);
    }

    static 
    {
        debugLogger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("LocationUtil", 3, "Log LocationUtil events");
        verboseLogger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo(debugLogger.tag, 2, "Log extended LocationUtil events");
    }

}
