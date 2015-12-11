// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import java.util.HashMap;

// Referenced classes of package com.tapjoy:
//            TJAdUnitJSBridge, TapjoyLog

final class a
    implements LocationListener
{

    final TJAdUnitJSBridge a;

    public final void onLocationChanged(Location location)
    {
        if (TJAdUnitJSBridge.d(a) == null || TJAdUnitJSBridge.e(a) == null)
        {
            if (TJAdUnitJSBridge.f(a) != null && TJAdUnitJSBridge.g(a) != null)
            {
                TapjoyLog.i("TJAdUnitJSBridge", "stopping updates");
                TJAdUnitJSBridge.f(a).removeUpdates(TJAdUnitJSBridge.g(a));
            }
        } else
        if (location != null)
        {
            HashMap hashmap = new HashMap();
            hashmap.put("lat", Double.valueOf(location.getLatitude()));
            hashmap.put("long", Double.valueOf(location.getLongitude()));
            hashmap.put("altitude", Double.valueOf(location.getAltitude()));
            hashmap.put("timestamp", Long.valueOf(location.getTime()));
            hashmap.put("speed", Float.valueOf(location.getSpeed()));
            hashmap.put("course", Float.valueOf(location.getBearing()));
            a.invokeJSAdunitMethod("locationUpdated", hashmap);
            return;
        }
    }

    public final void onProviderDisabled(String s)
    {
    }

    public final void onProviderEnabled(String s)
    {
    }

    public final void onStatusChanged(String s, int i, Bundle bundle)
    {
    }

    er(TJAdUnitJSBridge tjadunitjsbridge)
    {
        a = tjadunitjsbridge;
        super();
    }
}
