// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.geofence;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.pointinside.internal.utils.LogUtils;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

// Referenced classes of package com.pointinside.location.geofence:
//            SortableLocation

abstract class ProviderHelper
{

    private static final String CLASS_NAME = com/pointinside/location/geofence/ProviderHelper.getSimpleName();
    private static final String LOG_TAG = LogUtils.makeLogTag(com/pointinside/location/geofence/ProviderHelper.getSimpleName());
    protected LocationManager LOCATION_MANAGER;
    private final LocationListener locationListener = new LocationListener() {

        private final String LOG_TAG = (new StringBuilder()).append("(").append(com/pointinside/location/geofence/VenueProximityManager$LocationListener.getSimpleName()).append(") ").toString();
        final ProviderHelper this$0;

        private String statusToString(int i)
        {
            switch (i)
            {
            default:
                return "none";

            case 2: // '\002'
                return "available";

            case 0: // '\0'
                return "out of service";

            case 1: // '\001'
                return "temp unavailable";
            }
        }

        public void onLocationChanged(Location location)
        {
            locationUpdates.add(new SortableLocation(location));
            LogUtils.logD(LOG_TAG, (new StringBuilder()).append(location.getProvider()).append(" resolved new location (").append(location.getLatitude()).append(" ").append(location.getLongitude()).append(")").toString());
        }

        public void onProviderDisabled(String s)
        {
            LogUtils.logD(LOG_TAG, (new StringBuilder()).append(ProviderHelper.CLASS_NAME).append(s).append(" disabled").toString());
        }

        public void onProviderEnabled(String s)
        {
            LogUtils.logD(LOG_TAG, (new StringBuilder()).append(ProviderHelper.CLASS_NAME).append(s).append(" enabled").toString());
        }

        public void onStatusChanged(String s, int i, Bundle bundle)
        {
            LogUtils.logD(LOG_TAG, (new StringBuilder()).append(ProviderHelper.CLASS_NAME).append(s).append(" status changed ").append(statusToString(i)).toString());
        }

            
            {
                this$0 = ProviderHelper.this;
                super();
            }
    };
    private List locationUpdates;

    ProviderHelper(LocationManager locationmanager)
    {
        locationUpdates = new Stack();
        LOCATION_MANAGER = locationmanager;
    }

    private Location getBestLocation()
        throws EmptyStackException
    {
        if (locationUpdates.isEmpty())
        {
            String s;
            for (Iterator iterator = getLocationProviders().iterator(); iterator.hasNext(); locationUpdates.add(new SortableLocation(LOCATION_MANAGER.getLastKnownLocation(s))))
            {
                s = (String)iterator.next();
            }

        }
        Collections.sort(locationUpdates);
        logSortedLocations();
        return ((SortableLocation)((Stack)locationUpdates).pop()).location;
    }

    private Location getDisabledLocation()
    {
        return new Location(VenueProximityState.Type.DISABLED.toString());
    }

    private boolean isProviderEnabled()
    {
        Iterator iterator = getLocationProviders().iterator();
        String s;
        boolean flag;
        for (flag = false; iterator.hasNext(); flag = LOCATION_MANAGER.isProviderEnabled(s) | flag)
        {
            s = (String)iterator.next();
        }

        return flag;
    }

    private String locationProviderString(List list)
    {
        Iterator iterator = list.iterator();
        String s;
        for (list = ""; iterator.hasNext(); list = (new StringBuilder()).append(list).append(s).append(", ").toString())
        {
            s = (String)iterator.next();
        }

        return list.substring(0, list.length() - 2);
    }

    void close()
    {
        Location location = getBestLocation();
        if (!isProviderEnabled() || location == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
_L1:
        locationFound(location);
        destroy();
        return;
        location = getDisabledLocation();
          goto _L1
        Object obj;
        obj;
        LogUtils.logW(LOG_TAG, "No location updates during search, using last known location");
        destroy();
        return;
        obj;
        destroy();
        throw obj;
    }

    public void destroy()
    {
        locationUpdates.clear();
        LOCATION_MANAGER.removeUpdates(locationListener);
        LOCATION_MANAGER = null;
    }

    abstract List getLocationProviders();

    abstract void locationFound(Location location);

    protected void logSortedLocations()
    {
        Iterator iterator = locationUpdates.iterator();
        SimpleDateFormat simpledateformat = new SimpleDateFormat("HH:mm:ss");
        LogUtils.logD(LOG_TAG, "SORTED LOCATIONS");
        LogUtils.logD(LOG_TAG, "----------------");
        int i = 0;
        while (iterator.hasNext()) 
        {
            Object obj = ((SortableLocation)iterator.next()).location;
            if (obj != null)
            {
                double d = ((Location) (obj)).getLongitude();
                double d1 = ((Location) (obj)).getLatitude();
                String s = simpledateformat.format(new Date(((Location) (obj)).getTime()));
                float f = ((Location) (obj)).getAccuracy();
                obj = String.format((new StringBuilder()).append(s).append(" ").append(((Location) (obj)).getProvider()).append(" (%.2f, %.2f) %.2f").toString(), new Object[] {
                    Double.valueOf(d), Double.valueOf(d1), Float.valueOf(f)
                });
            } else
            {
                obj = "NULL";
            }
            LogUtils.logD(LOG_TAG, (new StringBuilder()).append("@").append(i).append("->").append(((String) (obj))).toString());
            i++;
        }
        LogUtils.logD(LOG_TAG, "----------------");
    }

    void open()
    {
        LOCATION_MANAGER.removeUpdates(locationListener);
        LogUtils.logD(LOG_TAG, (new StringBuilder()).append("-- Registered with providers:").append(locationProviderString(getLocationProviders())).toString());
        Iterator iterator = getLocationProviders().iterator();
        while (iterator.hasNext()) 
        {
            String s = (String)iterator.next();
            LOCATION_MANAGER.requestLocationUpdates(s, 0L, 0.0F, locationListener);
            String s1 = LOG_TAG;
            StringBuilder stringbuilder = (new StringBuilder()).append("==> ").append(s).append(" ");
            if (LOCATION_MANAGER.isProviderEnabled(s))
            {
                s = "en";
            } else
            {
                s = "dis";
            }
            LogUtils.logD(s1, stringbuilder.append(s).append("abled").toString());
        }
    }



}
