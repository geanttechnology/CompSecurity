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
import bolts.Capture;
import bolts.Task;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.parse:
//            Parse, ParseException

class LocationNotifier
{

    private static Location fakeLocation = null;

    LocationNotifier()
    {
    }

    static Task getCurrentLocationAsync(Context context, long l, Criteria criteria)
    {
        bolts.Task.TaskCompletionSource taskcompletionsource = Task.create();
        Capture capture = new Capture();
        context = (LocationManager)context.getSystemService("location");
        LocationListener locationlistener = new LocationListener(capture, taskcompletionsource, context) {

            final LocationManager val$manager;
            final bolts.Task.TaskCompletionSource val$tcs;
            final Capture val$timeoutFuture;

            public void onLocationChanged(Location location)
            {
                if (location == null)
                {
                    return;
                } else
                {
                    ((ScheduledFuture)timeoutFuture.get()).cancel(true);
                    tcs.trySetResult(location);
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
                timeoutFuture = capture;
                tcs = taskcompletionsource;
                manager = locationmanager;
                super();
            }
        };
        capture.set(Parse.getScheduledExecutor().schedule(new Runnable(taskcompletionsource, context, locationlistener) {

            final LocationListener val$listener;
            final LocationManager val$manager;
            final bolts.Task.TaskCompletionSource val$tcs;

            public void run()
            {
                tcs.trySetError(new ParseException(124, "Location fetch timed out."));
                manager.removeUpdates(listener);
            }

            
            {
                tcs = taskcompletionsource;
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
        return taskcompletionsource.getTask();
    }

    static void setFakeLocation(Location location)
    {
        fakeLocation = location;
    }

}
