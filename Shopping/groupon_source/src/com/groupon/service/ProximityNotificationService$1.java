// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.location.Location;
import com.groupon.util.Function1;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.service:
//            ProximityNotificationService

class val.geofenceUUID
    implements Function1
{

    final ProximityNotificationService this$0;
    final String val$geofenceUUID;
    final String val$transitionType;

    public void execute(Location location)
    {
        Ln.d("Proximity_Notifications: Geofence breached, Trying to aquire most recent location", new Object[0]);
        ProximityNotificationService.access$000(ProximityNotificationService.this, null, val$transitionType, val$geofenceUUID);
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((Location)obj);
    }

    ()
    {
        this$0 = final_proximitynotificationservice;
        val$transitionType = s;
        val$geofenceUUID = String.this;
        super();
    }
}
