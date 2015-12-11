// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import java.util.List;

public class LocationUtil
{

    public LocationUtil()
    {
    }

    public static Location getLastKnownLocation(Context context)
    {
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
        return context;
    }
}
