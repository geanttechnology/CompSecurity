// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.d;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.c;
import com.google.android.gms.location.f;
import com.google.android.gms.location.h;
import com.target.a.a.a;
import com.target.a.a.b;
import java.util.ArrayList;
import java.util.Iterator;

public class g
{
    private class a
        implements com.google.android.gms.common.api.d.b
    {

        final g this$0;

        public void a(int i)
        {
        }

        public void a(Bundle bundle)
        {
            com.target.a.a.b.e("DeviceLocationManager", "onConnected()");
            com.target.mothership.services.g.a(g.this, false);
            com.target.mothership.services.g.a(g.this, null);
            if (com.target.mothership.b.a().m())
            {
                if (com.target.mothership.c.b() == com.target.mothership.c.b.NoLocation)
                {
                    com.target.mothership.services.g.a(g.this, null);
                    return;
                } else
                {
                    com.target.mothership.services.g.a(g.this, com.target.mothership.services.g.c());
                    return;
                }
            }
            com.target.mothership.services.g.b(g.this, h.b.a(com.target.mothership.services.g.a(g.this)));
            if (com.target.mothership.services.g.b(g.this) != null)
            {
                com.target.mothership.services.g.a(g.this, com.target.mothership.services.g.b(g.this));
            }
            com.target.mothership.services.g.a(g.this, LocationRequest.a());
            bundle = com.target.mothership.services.g.d(g.this);
            byte byte0;
            if (com.target.mothership.services.g.c(g.this))
            {
                byte0 = 100;
            } else
            {
                byte0 = 102;
            }
            bundle.a(byte0);
            com.target.mothership.services.g.d(g.this).a(1000L);
            com.target.mothership.services.g.d(g.this).b(1000L);
            h.b.a(com.target.mothership.services.g.a(g.this), com.target.mothership.services.g.d(g.this), g.e(g.this));
            com.target.mothership.services.g.f(g.this);
        }

        private a()
        {
            this$0 = g.this;
            super();
        }

    }

    private class b
        implements com.google.android.gms.common.api.d.d
    {

        final g this$0;

        public void a(ConnectionResult connectionresult)
        {
            com.target.mothership.services.g.a(g.this, connectionresult);
            com.target.mothership.services.g.b(g.this, connectionresult);
        }

        private b()
        {
            this$0 = g.this;
            super();
        }

    }

    private class c
        implements f
    {

        final g this$0;

        public void a(Location location)
        {
            com.target.a.a.b.e("DeviceLocationManager", "onLocationChanged()");
            com.target.mothership.services.g.b(g.this, location);
            com.target.mothership.services.g.a(g.this, location);
            if (com.target.mothership.services.g.a(g.this).e() && !g.g(g.this))
            {
                com.target.mothership.services.g.a(g.this, true);
                h.b.a(com.target.mothership.services.g.a(g.this), g.e(g.this));
                com.target.mothership.services.g.d(g.this).a(60000L);
                com.target.mothership.services.g.d(g.this).b(60000L);
                h.b.a(com.target.mothership.services.g.a(g.this), com.target.mothership.services.g.d(g.this), g.e(g.this));
            }
        }

        private c()
        {
            this$0 = g.this;
            super();
        }

    }

    public static interface d
    {

        public abstract void a(Location location);

        public abstract void a(ConnectionResult connectionresult);
    }


    private static final Location FAKE_LOCATION;
    private static final int FAST_LOCATION_UPDATE_MS = 1000;
    private static final String LOG_TAG = "DeviceLocationManager";
    private static final int SLOW_LOCATION_UPDATE_MS = 60000;
    private static g sManager;
    private com.google.android.gms.common.api.d mApiClient;
    private boolean mFirstLocationAcquired;
    private boolean mHighAccuracyAllowed;
    private Location mLastLocation;
    private ArrayList mListeners;
    private ConnectionResult mLocationClientConnectionError;
    private c mLocationListener;
    private LocationRequest mLocationRequest;

    private g(com.target.a.a.a a1)
    {
        a1 = a1.a();
        mApiClient = (new com.google.android.gms.common.api.d.a(a1)).a(h.a).a(new a()).a(new b()).b();
        mListeners = new ArrayList();
        mLocationListener = new c();
        boolean flag;
        if (a1.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mHighAccuracyAllowed = flag;
    }

    static ConnectionResult a(g g1, ConnectionResult connectionresult)
    {
        g1.mLocationClientConnectionError = connectionresult;
        return connectionresult;
    }

    static com.google.android.gms.common.api.d a(g g1)
    {
        return g1.mApiClient;
    }

    static LocationRequest a(g g1, LocationRequest locationrequest)
    {
        g1.mLocationRequest = locationrequest;
        return locationrequest;
    }

    public static g a()
    {
        if (sManager == null)
        {
            throw new IllegalStateException("LocationManager has not been initialized, call initialize first");
        } else
        {
            return sManager;
        }
    }

    public static g a(com.target.a.a.a a1)
    {
        Context context = a1.a();
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0 && context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0)
        {
            throw new IllegalStateException("Location permissions are required to use LocationManager");
        } else
        {
            sManager = new g(a1);
            return sManager;
        }
    }

    private void a(Location location)
    {
        for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); ((d)iterator.next()).a(location)) { }
    }

    private void a(ConnectionResult connectionresult)
    {
        for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); ((d)iterator.next()).a(connectionresult)) { }
    }

    static void a(g g1, Location location)
    {
        g1.a(location);
    }

    static boolean a(g g1, boolean flag)
    {
        g1.mFirstLocationAcquired = flag;
        return flag;
    }

    static Location b(g g1)
    {
        return g1.mLastLocation;
    }

    static Location b(g g1, Location location)
    {
        g1.mLastLocation = location;
        return location;
    }

    static void b(g g1, ConnectionResult connectionresult)
    {
        g1.a(connectionresult);
    }

    static Location c()
    {
        return FAKE_LOCATION;
    }

    static boolean c(g g1)
    {
        return g1.mHighAccuracyAllowed;
    }

    static LocationRequest d(g g1)
    {
        return g1.mLocationRequest;
    }

    private void d()
    {
        com.target.a.a.b.e("DeviceLocationManager", (new StringBuilder()).append("updateClientState(), listener count=").append(mListeners.size()).append(", isConnected()=").append(mApiClient.e()).append(", isConnecting()=").append(mApiClient.f()).toString());
        if (!mListeners.isEmpty()) goto _L2; else goto _L1
_L1:
        com.target.a.a.b.e("DeviceLocationManager", "Removing listener from location updates");
        if (!mApiClient.e()) goto _L4; else goto _L3
_L3:
        com.target.a.a.b.e("DeviceLocationManager", "Disconnecting API client");
        h.b.a(mApiClient, mLocationListener);
        mApiClient.d();
_L6:
        return;
_L4:
        com.target.a.a.b.e("DeviceLocationManager", "NOT disconnecting API client");
        return;
_L2:
        if (!mListeners.isEmpty() && !mApiClient.e() && !mApiClient.f())
        {
            com.target.a.a.b.e("DeviceLocationManager", "Connecting API client");
            mApiClient.c();
            return;
        }
        if (mLocationClientConnectionError != null)
        {
            a(mLocationClientConnectionError);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    static c e(g g1)
    {
        return g1.mLocationListener;
    }

    static void f(g g1)
    {
        g1.d();
    }

    static boolean g(g g1)
    {
        return g1.mFirstLocationAcquired;
    }

    public void a(d d1)
    {
        com.target.a.a.b.e("DeviceLocationManager", (new StringBuilder()).append("addListener(").append(d1).append("), listener count=").append(mListeners.size()).toString());
        if (!mListeners.contains(d1))
        {
            mListeners.add(d1);
            com.target.a.a.b.e("DeviceLocationManager", (new StringBuilder()).append("Added listener: ").append(d1).append(", listener count=").append(mListeners.size()).toString());
        }
        d();
    }

    public Location b()
    {
        return mLastLocation;
    }

    public void b(d d1)
    {
        com.target.a.a.b.e("DeviceLocationManager", (new StringBuilder()).append("Removing listener: ").append(d1).append(", listener count=").append(mListeners.size()).toString());
        mListeners.remove(d1);
        d();
    }

    static 
    {
        FAKE_LOCATION = new Location("flp");
        FAKE_LOCATION.setLatitude(45D);
        FAKE_LOCATION.setLongitude(-90D);
    }
}
