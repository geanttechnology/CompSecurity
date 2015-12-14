// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.shareview;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;

// Referenced classes of package com.cyberlink.youcammakeup.pages.shareview:
//            b

public class a
{

    LocationListener a;
    LocationListener b;
    private LocationManager c;
    private b d;
    private boolean e;
    private Handler f;

    public a(LocationManager locationmanager, b b1)
    {
        e = false;
        f = new Handler();
        a = new LocationListener() {

            final a a;

            public void onLocationChanged(Location location)
            {
                a.a(a, location);
                a.b(a).removeUpdates(this);
                a.b(a).removeUpdates(a.b);
            }

            public void onProviderDisabled(String s)
            {
                a.a(a, null);
            }

            public void onProviderEnabled(String s)
            {
            }

            public void onStatusChanged(String s, int i, Bundle bundle)
            {
            }

            
            {
                a = a.this;
                super();
            }
        };
        b = new LocationListener() {

            final a a;

            public void onLocationChanged(Location location)
            {
                a.a(a, location);
                a.b(a).removeUpdates(this);
                a.b(a).removeUpdates(a.a);
            }

            public void onProviderDisabled(String s)
            {
                a.a(a, null);
            }

            public void onProviderEnabled(String s)
            {
            }

            public void onStatusChanged(String s, int i, Bundle bundle)
            {
            }

            
            {
                a = a.this;
                super();
            }
        };
        c = locationmanager;
        d = b1;
    }

    private void a(Location location)
    {
        d.a(location);
        e = true;
    }

    static void a(a a1, Location location)
    {
        a1.a(location);
    }

    static boolean a(a a1)
    {
        return a1.e;
    }

    static LocationManager b(a a1)
    {
        return a1.c;
    }

    public void a()
    {
        boolean flag = c.isProviderEnabled("gps");
        boolean flag1 = c.isProviderEnabled("network");
_L2:
        if (!flag && !flag1)
        {
            a(((Location) (null)));
            return;
        }
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        flag = false;
_L3:
        exception.printStackTrace();
        flag1 = false;
        if (true) goto _L2; else goto _L1
_L1:
        if (flag)
        {
            c.requestLocationUpdates("gps", 0L, 0.0F, a);
        }
        if (flag1)
        {
            c.requestLocationUpdates("network", 0L, 0.0F, b);
        }
        f.postDelayed(new Runnable() {

            final a a;

            public void run()
            {
                if (!a.a(a))
                {
                    a.a(a, null);
                    a.b(a).removeUpdates(a.a);
                    a.b(a).removeUpdates(a.b);
                }
            }

            
            {
                a = a.this;
                super();
            }
        }, 7000L);
        return;
        exception;
          goto _L3
    }
}
