// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import java.util.Iterator;
import java.util.List;

public class LocationHelper
{

    public LocationHelper()
    {
    }

    public static Location getLastLocation(Context context)
    {
        Object obj = null;
        if (!locationPermissionGranted(context))
        {
            return null;
        }
        LocationManager locationmanager = (LocationManager)context.getApplicationContext().getSystemService("location");
        Iterator iterator = locationmanager.getAllProviders().iterator();
        context = obj;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Location location = locationmanager.getLastKnownLocation((String)iterator.next());
            if (location != null && location.getTime() > 0x8000000000000000L)
            {
                context = location;
            }
        } while (true);
        return context;
    }

    private static boolean locationPermissionGranted(Context context)
    {
        return context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
    }
}
