// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.cs;
import android.support.v7.cu;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.parse:
//            ParseExecutors, ParseException

class LocationNotifier
{

    private static Location fakeLocation = null;

    LocationNotifier()
    {
    }

    static cu getCurrentLocationAsync(Context context, long l, Criteria criteria)
    {
        android.support.v7.cu.a a = cu.a();
        cs cs1 = new cs();
        context = (LocationManager)context.getSystemService("location");
        LocationListener locationlistener = new LocationListener(cs1, a, context) {

            final LocationManager val$manager;
            final android.support.v7.cu.a val$tcs;
            final cs val$timeoutFuture;

            public void onLocationChanged(Location location)
            {
                if (location == null)
                {
                    return;
                } else
                {
                    ((ScheduledFuture)timeoutFuture.a()).cancel(true);
                    tcs.a(location);
                    manager.removeUpdates(this);
                    return;
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
                timeoutFuture = cs1;
                tcs = a;
                manager = locationmanager;
                super();
            }
        };
        cs1.a(ParseExecutors.scheduled().schedule(new Runnable(a, context, locationlistener) {

            final LocationListener val$listener;
            final LocationManager val$manager;
            final android.support.v7.cu.a val$tcs;

            public void run()
            {
                tcs.a(new ParseException(124, "Location fetch timed out."));
                manager.removeUpdates(listener);
            }

            
            {
                tcs = a;
                manager = locationmanager;
                listener = locationlistener;
                super();
            }
        }, l, TimeUnit.MILLISECONDS));
        criteria = context.getBestProvider(criteria, true);
        if (criteria != null)
        {
            context.requestLocationUpdates(criteria, 0L, 0.0F, locationlistener);
        }
        if (fakeLocation != null)
        {
            locationlistener.onLocationChanged(fakeLocation);
        }
        return a.a();
    }

    static void setFakeLocation(Location location)
    {
        fakeLocation = location;
    }

}
