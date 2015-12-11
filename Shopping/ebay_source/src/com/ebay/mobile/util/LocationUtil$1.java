// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.util;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.ebay.nautilus.kernel.util.FwLog;

// Referenced classes of package com.ebay.mobile.util:
//            LocationUtil

static final class val.locationManager
    implements LocationListener
{

    final LocationManager val$locationManager;

    public void onLocationChanged(Location location)
    {
        if (LocationUtil.access$000().sLoggable)
        {
            FwLog.logMethod(LocationUtil.access$000(), new Object[] {
                location
            });
        }
        val$locationManager.removeUpdates(this);
    }

    public void onProviderDisabled(String s)
    {
        if (LocationUtil.access$000().sLoggable)
        {
            FwLog.logMethod(LocationUtil.access$000(), new Object[] {
                s
            });
        }
        val$locationManager.removeUpdates(this);
    }

    public void onProviderEnabled(String s)
    {
        if (LocationUtil.access$000().sLoggable)
        {
            FwLog.logMethod(LocationUtil.access$000(), new Object[] {
                s
            });
        }
        val$locationManager.removeUpdates(this);
    }

    public void onStatusChanged(String s, int i, Bundle bundle)
    {
        if (LocationUtil.access$000().sLoggable)
        {
            FwLog.logMethod(LocationUtil.access$000(), new Object[] {
                s, Integer.valueOf(i)
            });
        }
        val$locationManager.removeUpdates(this);
    }

    LogInfo(LocationManager locationmanager)
    {
        val$locationManager = locationmanager;
        super();
    }
}
