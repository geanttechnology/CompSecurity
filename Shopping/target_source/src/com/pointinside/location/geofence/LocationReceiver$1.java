// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.geofence;

import android.location.Location;
import com.pointinside.feeds.VenueEntity;
import com.pointinside.internal.utils.LogUtils;

// Referenced classes of package com.pointinside.location.geofence:
//            LocationReceiver, VenueProximityService

class val.curLoc
    implements ment.VenueLookupListener
{

    final LocationReceiver this$0;
    final Location val$curLoc;

    public void onSuccessfulLookup(VenueEntity venueentity)
    {
        if (venueentity != null)
        {
            LogUtils.logD(VenueProximityService.LOG_TAG, (new StringBuilder()).append("query succeeded::nearestVenue@(").append(venueentity.latitude).append(" ").append(venueentity.longitude).append(")").toString());
            LocationReceiver.proximityState = .Factory.buildOn(LocationReceiver.proximityState, venueentity, val$curLoc);
            LocationReceiver.access$100(LocationReceiver.this);
            int _tmp = LocationReceiver.access$202(0);
            return;
        } else
        {
            LocationReceiver.access$208();
            return;
        }
    }

    .Factory()
    {
        this$0 = final_locationreceiver;
        val$curLoc = Location.this;
        super();
    }
}
