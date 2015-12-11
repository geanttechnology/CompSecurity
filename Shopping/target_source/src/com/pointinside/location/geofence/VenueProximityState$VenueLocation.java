// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.geofence;

import android.location.Location;
import com.pointinside.feeds.VenueEntity;

// Referenced classes of package com.pointinside.location.geofence:
//            VenueProximityState

public static class venue extends Location
{

    public final VenueEntity venue;

    public I(VenueEntity venueentity)
    {
        super(new Location("com.pointinside.feeds.client.model.maps.Venue"));
        if (venueentity != null)
        {
            venue = venueentity;
            setLatitude(venueentity.latitude);
            setLongitude(venueentity.longitude);
            return;
        } else
        {
            venue = null;
            return;
        }
    }
}
