// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.a.a;

import android.location.Location;
import android.location.LocationManager;
import java.util.TimerTask;

// Referenced classes of package com.b.a.a:
//            b, g, f

final class e extends TimerTask
{

    private b a;

    e(b b1)
    {
        a = b1;
        super();
    }

    public final void run()
    {
        g.b(b.a(a), "GetLastLocation::run");
        a.b.removeUpdates(a.f);
        a.b.removeUpdates(a.g);
        if (a.d)
        {
            g.b(b.a(a), "GetLastLocation::network_enabled");
        }
        Location location = a.b.getLastKnownLocation("gps");
        if (a.e)
        {
            g.b(b.a(a), "GetLastLocation::passive_enabled");
        }
        Location location1 = a.b.getLastKnownLocation("network");
        if (location != null && location1 != null)
        {
            g.b(b.a(a), "GetLastLocation::gps_loc&&net_loc");
            if (location.getTime() > location1.getTime())
            {
                g.b(b.a(a), "GetLastLocation::gps_loc");
                a.c.a(location);
                return;
            } else
            {
                g.b(b.a(a), "GetLastLocation::net_loc");
                a.c.a(location1);
                return;
            }
        }
        if (location != null)
        {
            g.b(b.a(a), "GetLastLocation::gps_loc");
            a.c.a(location);
            return;
        }
        if (location1 != null)
        {
            g.b(b.a(a), "GetLastLocation::net_loc");
            a.c.a(location1);
            return;
        } else
        {
            g.b(b.a(a), "GetLastLocation::null");
            a.c.a(null);
            return;
        }
    }
}
