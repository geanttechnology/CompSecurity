// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nielsen.app.sdk;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import java.io.Closeable;
import java.io.IOException;

class AppLocationManager
    implements Closeable
{
    public class AppLocationListener
        implements LocationListener
    {

        final AppLocationManager a;

        public void onLocationChanged(Location location)
        {
            if (location != null)
            {
                AppLocationManager.a(a, location);
            }
        }

        public void onProviderDisabled(String s)
        {
        }

        public void onProviderEnabled(String s)
        {
        }

        public void onStatusChanged(String s, int j, Bundle bundle)
        {
        }

        public AppLocationListener()
        {
            a = AppLocationManager.this;
            super();
        }
    }


    private static AppLocationManager c = null;
    private AppLocationListener a;
    private Location b;
    private Context d;
    private LocationManager e;
    private Criteria f;
    private String g;
    private boolean h;
    private boolean i;

    private AppLocationManager(Context context)
    {
        a = null;
        b = null;
        d = null;
        e = null;
        f = null;
        g = "";
        h = false;
        i = false;
        a = new AppLocationListener();
        f = new Criteria();
        d = context;
    }

    static Location a(AppLocationManager applocationmanager, Location location)
    {
        applocationmanager.b = location;
        return location;
    }

    public static AppLocationManager a(Context context)
    {
        if (c == null)
        {
            c = new AppLocationManager(context);
        }
        return c;
    }

    public boolean a()
    {
        return h;
    }

    public boolean a(int j, int k, long l, float f1)
        throws IllegalArgumentException
    {
label0:
        {
            h = false;
            boolean flag;
            try
            {
                b();
                if (e == null)
                {
                    e = (LocationManager)d.getSystemService("location");
                }
                if (e == null)
                {
                    return h;
                }
                f.setAltitudeRequired(false);
                f.setBearingRequired(false);
                f.setCostAllowed(false);
                f.setAccuracy(j);
                f.setPowerRequirement(k);
                g = e.getBestProvider(f, true);
                if (g == null || g.isEmpty())
                {
                    break label0;
                }
                h = true;
                e.requestLocationUpdates(g, l, f1, a);
                b = e.getLastKnownLocation(g);
                i = true;
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                throw new IllegalArgumentException("startUpdate() failed. Invalid arguments.");
            }
            catch (Exception exception) { }
            if (h && i)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return flag;
        }
        return false;
    }

    public void b()
    {
        if (i && e != null)
        {
            e.removeUpdates(a);
            i = false;
        }
    }

    public Location c()
    {
        return b;
    }

    public void close()
        throws IOException
    {
        b();
    }

}
