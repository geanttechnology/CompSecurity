// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.geofence;

import android.location.Location;
import com.pointinside.feeds.VenueEntity;

// Referenced classes of package com.pointinside.location.geofence:
//            VenueProximityState

static class 
{

    public static VenueProximityState buildOn(VenueProximityState venueproximitystate, VenueEntity venueentity, Location location)
    {
        if (venueentity == null)
        {
            return venueproximitystate;
        } else
        {
            return access._mth400(access._mth300(access._mth200(new <init>(venueproximitystate, null), location).setVenueLocation(venueentity), location), location).build();
        }
    }

    public static VenueProximityState disable(VenueProximityState venueproximitystate)
    {
        return (new <init>(venueproximitystate, null)).setVenueLocation(venueproximitystate.venueLocation).setDistance(venueproximitystate.distance).setDirection(venueproximitystate.direction).setProximityState(ABLED).build();
    }

    public static VenueProximityState zeroState()
    {
        return (new <init>(null)).build();
    }

    ()
    {
    }
}
