// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.location;

import com.urbanairship.Logger;

// Referenced classes of package com.urbanairship.location:
//            RegionEvent

public class CircularRegion
{

    public static final int MAX_RADIUS = 0x186a0;
    private final double latitude;
    private final double longitude;
    private final double radius;

    public CircularRegion(double d, double d1, double d2)
    {
        radius = d;
        latitude = d1;
        longitude = d2;
    }

    public double getLatitude()
    {
        return latitude;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public double getRadius()
    {
        return radius;
    }

    public boolean isValid()
    {
        if (radius > 100000D || radius <= 0.0D)
        {
            Logger.error("The radius must be greater than 0 and less than or equal to 100000 meters.");
            return false;
        }
        if (!RegionEvent.regionEventLatitudeIsValid(Double.valueOf(latitude)))
        {
            Logger.error("The latitude must be greater than or equal to -90.0 and less than or equal to 90.0 degrees.");
            return false;
        }
        if (!RegionEvent.regionEventLongitudeIsValid(Double.valueOf(longitude)))
        {
            Logger.error("The longitude must be greater than or equal to -180.0 and less than or equal to 180.0 degrees.");
            return false;
        } else
        {
            return true;
        }
    }
}
