// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            ae, af

class ag
    implements LocationListener
{

    Location a;
    boolean b;
    String c;
    final ae d;

    public ag(ae ae1, String s)
    {
        d = ae1;
        super();
        b = false;
        c = s;
        a = new Location(c);
    }

    public Location a()
    {
        if (b)
        {
            return a;
        } else
        {
            return null;
        }
    }

    public void onLocationChanged(Location location)
    {
        if (location.getLatitude() == 0.0D && location.getLongitude() == 0.0D)
        {
            return;
        }
        if (ae.a(d) != null && ae.b(d) && "gps".equals(c))
        {
            ae.a(d).a(true);
        }
        if (!b)
        {
            Log.d("LocationManager", "Got first location.");
        }
        a.set(location);
        b = true;
    }

    public void onProviderDisabled(String s)
    {
        b = false;
    }

    public void onProviderEnabled(String s)
    {
    }

    public void onStatusChanged(String s, int i, Bundle bundle)
    {
        i;
        JVM INSTR tableswitch 0 1: default 24
    //                   0 25
    //                   1 25;
           goto _L1 _L2 _L2
_L1:
        return;
_L2:
        b = false;
        if (ae.a(d) != null && ae.b(d) && "gps".equals(s))
        {
            ae.a(d).a(false);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }
}
