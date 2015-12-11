// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.location;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.exacttarget.etpushsdk.util.m;

// Referenced classes of package com.exacttarget.etpushsdk.location:
//            e

class f
    implements LocationListener
{

    final e a;

    f(e e1)
    {
        a = e1;
        super();
    }

    public void onLocationChanged(Location location)
    {
        m.a("~!ld", (new StringBuilder()).append("Single Location Update Received: ").append(location.getLatitude()).append(",").append(location.getLongitude()).toString());
        if (a.a != null && location != null)
        {
            a.a.onLocationChanged(location);
        }
        a.b.removeUpdates(a.e);
    }

    public void onProviderDisabled(String s)
    {
    }

    public void onProviderEnabled(String s)
    {
    }

    public void onStatusChanged(String s, int i, Bundle bundle)
    {
    }
}
