// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.geofence;

import android.location.Location;

// Referenced classes of package com.pointinside.location.geofence:
//            VenueProximityState

public class VenueProximityCache
{

    private static Location LOCATION = null;
    private static VenueProximityState STATE = null;

    private VenueProximityCache()
    {
    }

    public static Location getLocation()
    {
        return LOCATION;
    }

    public static VenueProximityState getState()
    {
        return STATE;
    }

    static void setLocation(Location location)
    {
        LOCATION = location;
    }

    static void setState(VenueProximityState venueproximitystate)
    {
        STATE = venueproximitystate;
    }

}
