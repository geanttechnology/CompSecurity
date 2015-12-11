// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.geofence;

import android.location.Location;
import android.location.LocationManager;
import java.util.List;

// Referenced classes of package com.pointinside.location.geofence:
//            ProviderHelper, VenueProximityService, LocationReceiver

class this._cls0 extends ProviderHelper
{

    final VenueProximityService this$0;

    List getLocationProviders()
    {
        List list = LOCATION_MANAGER.getAllProviders();
        list.remove("passive");
        return list;
    }

    void locationFound(Location location)
    {
        sendBroadcast(LocationReceiver.getIntent(getPackageName(), location));
        VenueProximityService.access$800(VenueProximityService.this, location);
    }

    (LocationManager locationmanager)
    {
        this$0 = VenueProximityService.this;
        super(locationmanager);
    }
}
