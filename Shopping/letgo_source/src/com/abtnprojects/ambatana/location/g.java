// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.location;

import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.aqo;
import android.support.v7.du;

// Referenced classes of package com.abtnprojects.ambatana.location:
//            f

public class g extends f
    implements LocationListener
{

    private static final String b = com/abtnprojects/ambatana/location/g.getSimpleName();
    private boolean c;
    private boolean d;
    private LocationManager e;
    private Location f;

    g(Activity activity, du du, LocationManager locationmanager)
    {
        super(activity, du);
        c = false;
        d = false;
        e = locationmanager;
    }

    private void a(LocationManager locationmanager)
    {
        c = locationmanager.isProviderEnabled("gps");
        d = locationmanager.isProviderEnabled("network");
    }

    private void a(String s)
    {
        e.requestLocationUpdates(s, 60000L, 5000F, this);
    }

    private void b(String s)
    {
        if (e != null)
        {
            f = e.getLastKnownLocation(s);
            b(f);
        }
    }

    public void a()
    {
        a(e);
        c();
    }

    public void c()
    {
        a(e);
        if (f())
        {
            b();
            return;
        }
        try
        {
            if (d)
            {
                b("network");
                a("network");
            }
            if (c && f == null)
            {
                b("gps");
                a("gps");
                return;
            }
        }
        catch (Exception exception)
        {
            aqo.b(exception, "acquireLocation", new Object[0]);
        }
        return;
    }

    public void d()
    {
        if (e != null)
        {
            e.removeUpdates(this);
        }
    }

    public boolean f()
    {
        return !c && !d;
    }

    public void onLocationChanged(Location location)
    {
        a(location);
    }

    public void onProviderDisabled(String s)
    {
        if ("gps".equalsIgnoreCase(s))
        {
            c = false;
        } else
        if ("network".equalsIgnoreCase(s))
        {
            d = false;
            return;
        }
    }

    public void onProviderEnabled(String s)
    {
        c();
    }

    public void onStatusChanged(String s, int i, Bundle bundle)
    {
    }

}
