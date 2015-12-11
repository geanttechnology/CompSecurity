// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.geofence;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import com.pointinside.feeds.VenueEntity;

// Referenced classes of package com.pointinside.location.geofence:
//            LocationReceiver, VenueProximityState, VenueProximityService

private static class e
{

    private static float distanceToFence(VenueProximityState venueproximitystate)
    {
        ueLocation uelocation = venueproximitystate.venueLocation;
        float f = venueproximitystate.distance;
        float f1 = uelocation.venue.geofence;
        return f - (uelocation.getAccuracy() + f1);
    }

    private static Location getLocation(Intent intent)
    {
        return (Location)intent.getExtras().get("com.pointinside.location.geofence.LocationReceiver.Location");
    }

    private static void queueNextAlarm(Context context, VenueProximityState venueproximitystate)
    {
        int i = timeToNextAlarm(venueproximitystate);
        VenueProximityService.setNextAlarm(context, VenueProximityService.getStartIntent(context.getPackageName(), i, -1), i);
    }

    private static int timeToNextAlarm(VenueProximityState venueproximitystate)
    {
        float f = distanceToFence(venueproximitystate);
        byte byte0 = 120;
        int i = 0;
        int j = Float.valueOf(f / 26.6F).intValue();
        if (j >= 0)
        {
            i = j;
        }
        j = i;
        if (i > 120)
        {
            j = 120;
        }
        if (venueproximitystate.type == e.DISABLED)
        {
            i = byte0;
        } else
        {
            i = j;
        }
        return i * 1000;
    }



    private e()
    {
    }
}
