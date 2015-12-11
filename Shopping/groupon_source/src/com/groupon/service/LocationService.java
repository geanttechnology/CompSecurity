// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.app.Application;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import com.groupon.models.division.Division;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.util.Function1;
import com.groupon.util.GeoPoint;
import com.littlefluffytoys.littlefluffylocationlibrary.LocationInfo;
import com.littlefluffytoys.littlefluffylocationlibrary.LocationLibrary;
import roboguice.util.Ln;

public class LocationService
{

    private static final int LFL_INVALID_LATLNG_VALUE = 2147;
    private Application context;
    private CurrentDivisionManager currentDivisionManager;
    private Handler handler;
    private LocationManager lm;

    public LocationService()
    {
    }

    private void refreshLocation(int i)
    {
        boolean flag;
        LocationLibrary.forceLocationUpdate(context.getApplicationContext());
        flag = false;
        boolean flag1 = waitForLocationUpdate(context, i);
        flag = flag1;
_L2:
        if (!flag)
        {
            Ln.d("Timed out trying to get location", new Object[0]);
        }
        return;
        InterruptedException interruptedexception;
        interruptedexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private Location toLocation(LocationInfo locationinfo)
    {
        if (locationinfo == null || Math.abs((int)locationinfo.lastLat) == 2147 || Math.abs((int)locationinfo.lastLong) == 2147)
        {
            return null;
        } else
        {
            Location location = new Location("littlefluffylocationlibrary");
            location.setAccuracy(locationinfo.lastAccuracy);
            location.setLatitude(locationinfo.lastLat);
            location.setLongitude(locationinfo.lastLong);
            location.setTime(locationinfo.lastLocationUpdateTimestamp);
            return location;
        }
    }

    private boolean waitForLocationUpdate(Context context1, int i)
        throws InterruptedException
    {
        long l = System.currentTimeMillis();
        context1 = context1.getApplicationContext();
        LocationInfo locationinfo;
        for (locationinfo = new LocationInfo(context1); isAGpsProviderEnabled() && System.currentTimeMillis() - l < (long)i && locationinfo.lastLocationUpdateTimestamp < l; locationinfo.refresh(context1))
        {
            Thread.sleep(1000L);
        }

        return locationinfo.lastLocationUpdateTimestamp > l;
    }

    public GeoPoint getBestGuessForLocation()
    {
        GeoPoint geopoint1 = null;
        GeoPoint geopoint = geopoint1;
        if (isAGpsProviderEnabled())
        {
            Location location = getLocation();
            geopoint = geopoint1;
            if (location != null)
            {
                geopoint = new GeoPoint(location);
            }
        }
        geopoint1 = geopoint;
        if (geopoint == null)
        {
            geopoint1 = currentDivisionManager.getCurrentDivision().geoPoint;
        }
        return geopoint1;
    }

    public Location getLocation()
    {
        return toLocation(getLocationInfo());
    }

    public Location getLocation(int i)
    {
        Location location1 = getLocation();
        Location location = location1;
        if (location1 == null)
        {
            refreshLocation(i);
            location = getLocation();
        }
        return location;
    }

    public void getLocationAsync(final Function1 listener, final int maxWaitMs)
    {
        (new Thread() {

            final LocationService this$0;
            final Function1 val$listener;
            final int val$maxWaitMs;

            public void run()
            {
                refreshLocation(maxWaitMs);
                if (listener != null)
                {
                    handler.post(new Runnable() {

                        final _cls1 this$1;

                        public void run()
                        {
                            listener.execute(getLocation());
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                }
            }

            
            {
                this$0 = LocationService.this;
                maxWaitMs = i;
                listener = function1;
                super();
            }
        }).start();
    }

    public LocationInfo getLocationInfo()
    {
        return new LocationInfo(context.getApplicationContext());
    }

    public boolean isAGpsProviderEnabled()
    {
        boolean flag;
        boolean flag1;
        flag = false;
        flag1 = false;
        boolean flag2 = lm.isProviderEnabled("gps");
        flag = flag2;
_L1:
        flag2 = lm.isProviderEnabled("network");
        flag1 = flag2;
_L2:
        Exception exception;
        return flag || flag1;
        exception;
        Ln.e(exception);
          goto _L1
        exception;
        Ln.e(exception);
          goto _L2
    }


}
