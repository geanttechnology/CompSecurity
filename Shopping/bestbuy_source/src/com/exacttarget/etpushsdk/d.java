// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import com.exacttarget.etpushsdk.data.LocationUpdate;
import com.exacttarget.etpushsdk.database.b;
import com.exacttarget.etpushsdk.database.c;
import com.exacttarget.etpushsdk.event.BeaconRequest;
import com.exacttarget.etpushsdk.event.GeofenceRequest;
import com.exacttarget.etpushsdk.event.LastKnownLocationEvent;
import com.exacttarget.etpushsdk.util.m;
import com.exacttarget.etpushsdk.util.n;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.exacttarget.etpushsdk:
//            ETLocationManager, ETPushReceiver

class d
    implements Runnable
{

    final LastKnownLocationEvent a;
    final ETLocationManager b;

    d(ETLocationManager etlocationmanager, LastKnownLocationEvent lastknownlocationevent)
    {
        b = etlocationmanager;
        a = lastknownlocationevent;
        super();
    }

    public void run()
    {
        try
        {
            Object obj = new Date(a.getLocation().getTime());
            List list = com.exacttarget.etpushsdk.database.d.a("timestamp = ?", new String[] {
                n.a(((Date) (obj)))
            }, null, null, null);
            m.a("~!ETLocationManager", String.format("Location updates count: %1$d", new Object[] {
                Integer.valueOf(list.size())
            }));
            if (list.size() == 0)
            {
                m.a("~!ETLocationManager", "Create new location in DB");
                LocationUpdate locationupdate = new LocationUpdate(ETLocationManager.e(b));
                locationupdate.setLatitude(Double.valueOf(a.getLocation().getLatitude()));
                locationupdate.setLongitude(Double.valueOf(a.getLocation().getLongitude()));
                locationupdate.setAccuracy(Integer.valueOf(Math.round(a.getLocation().getAccuracy())));
                locationupdate.setTimestamp(((Date) (obj)));
                com.exacttarget.etpushsdk.database.d.a(locationupdate);
            }
            obj = new Intent(ETLocationManager.e(b), com/exacttarget/etpushsdk/ETPushReceiver);
            ((Intent) (obj)).putExtra("et_send_type_extra", "et_send_type_location");
            ETLocationManager.e(b).sendBroadcast(((Intent) (obj)));
            m.a("~!ETLocationManager", String.format("isWatchingLocation: %1$s and getGeofenceInvalidated(): %2$s", new Object[] {
                ETLocationManager.j(), Boolean.valueOf(b.d())
            }));
            if (ETLocationManager.j().booleanValue() && b.d())
            {
                m.a("~!ETLocationManager", "Retrieve geofence data");
                Object obj1 = new GeofenceRequest(ETLocationManager.e(b));
                ((GeofenceRequest) (obj1)).setLatitude(Double.valueOf(a.getLocation().getLatitude()));
                ((GeofenceRequest) (obj1)).setLongitude(Double.valueOf(a.getLocation().getLongitude()));
                c.a(((GeofenceRequest) (obj1)));
                m.a("~!ETLocationManager", "Requesting new Geofence data");
                obj1 = new Intent(ETLocationManager.e(b), com/exacttarget/etpushsdk/ETPushReceiver);
                ((Intent) (obj1)).putExtra("et_send_type_extra", "et_send_type_geofence");
                ETLocationManager.e(b).sendBroadcast(((Intent) (obj1)));
            }
            if (ETLocationManager.k().booleanValue() && b.f())
            {
                m.a("~!ETLocationManager", "Retrieve beacon data");
                Object obj2 = new BeaconRequest(ETLocationManager.e(b));
                ((BeaconRequest) (obj2)).setLatitude(Double.valueOf(a.getLocation().getLatitude()));
                ((BeaconRequest) (obj2)).setLongitude(Double.valueOf(a.getLocation().getLongitude()));
                com.exacttarget.etpushsdk.database.b.a(((BeaconRequest) (obj2)));
                obj2 = new Intent(ETLocationManager.e(b), com/exacttarget/etpushsdk/ETPushReceiver);
                ((Intent) (obj2)).putExtra("et_send_type_extra", "et_send_type_proximity");
                ETLocationManager.e(b).sendBroadcast(((Intent) (obj2)));
            }
            return;
        }
        catch (Exception exception)
        {
            m.c("~!ETLocationManager", exception.getMessage(), exception);
        }
    }
}
