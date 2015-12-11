// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models.product;

import android.location.Location;

// Referenced classes of package com.abtnprojects.ambatana.models.product:
//            Geo

public class DistanceEntity
{

    private final String distanceType;
    private final Location userLocation;

    public DistanceEntity(Location location, String s)
    {
        userLocation = location;
        distanceType = s;
    }

    public int getDistanceRange(Geo geo)
    {
        if (userLocation == null || geo == null || distanceType == null)
        {
            return 0;
        }
        Location location = new Location("");
        location.setLatitude(geo.getLat());
        location.setLongitude(geo.getLng());
        double d;
        if (distanceType == "mi")
        {
            d = 0.62137100000000001D;
        } else
        {
            d = 1.0D;
        }
        return (int)Math.max(Math.round(d * (double)(userLocation.distanceTo(location) / 1000F)), 1L);
    }
}
