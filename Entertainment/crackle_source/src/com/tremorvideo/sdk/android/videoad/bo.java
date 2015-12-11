// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.common.GooglePlayServicesUtil;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            ad, bq

public final class bo
{

    public static double a = 0.0D;
    public static double b = 0.0D;
    private static long c = 0L;

    public static int a()
    {
        if (!b() && !c())
        {
            return 2;
        }
        LocationManager locationmanager = (LocationManager)ad.v().getSystemService("location");
        if (b() && locationmanager.isProviderEnabled("gps"))
        {
            return 3;
        }
        return !c() || !locationmanager.isProviderEnabled("network") ? 2 : 3;
    }

    public static void a(Context context)
    {
        if (b() || c())
        {
            context = (LocationManager)context.getSystemService("location");
            LocationListener locationlistener = new LocationListener(context) {

                final LocationManager a;

                public void onLocationChanged(Location location)
                {
                    bo.a(location);
                    a.removeUpdates(this);
                }

                public void onProviderDisabled(String s)
                {
                    a.removeUpdates(this);
                }

                public void onProviderEnabled(String s)
                {
                }

                public void onStatusChanged(String s, int i, Bundle bundle)
                {
                    if (i != 2)
                    {
                        a.removeUpdates(this);
                    }
                }

            
            {
                a = locationmanager;
                super();
            }
            };
            if (b())
            {
                if (!a("gps", ((LocationManager) (context)), locationlistener) && !a("network", ((LocationManager) (context)), locationlistener))
                {
                    a(context.getLastKnownLocation("gps"));
                }
            } else
            if (!a("network", ((LocationManager) (context)), locationlistener))
            {
                a(context.getLastKnownLocation("network"));
                return;
            }
        }
    }

    public static void a(Context context, boolean flag)
    {
        if (!b() && !c() || c != 0L && SystemClock.elapsedRealtime() - c <= 0x493e0L && (a != 0.0D || b != 0.0D))
        {
            break MISSING_BLOCK_LABEL_130;
        }
        if (android.os.Build.VERSION.SDK_INT <= 8 || !flag)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        Class.forName("com.google.android.gms.common.GooglePlayServicesUtil");
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0)
        {
            (new bq(context)).a();
            return;
        }
        try
        {
            a(context);
            return;
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            a(context);
            ad.d((new StringBuilder()).append("Google Play Services Client Library is not included exception: ").append(classnotfoundexception).toString());
            return;
        }
        catch (Exception exception)
        {
            a(context);
        }
        return;
        a(context);
    }

    static void a(Location location)
    {
        if (location != null)
        {
            c = SystemClock.elapsedRealtime();
            a = location.getLatitude();
            b = location.getLongitude();
        }
    }

    private static boolean a(String s, LocationManager locationmanager, LocationListener locationlistener)
    {
        if (!locationmanager.isProviderEnabled(s))
        {
            return false;
        } else
        {
            a(locationmanager.getLastKnownLocation(s));
            locationmanager.requestLocationUpdates(s, 0L, 0.0F, locationlistener);
            return true;
        }
    }

    private static boolean b()
    {
        return ad.a("android.permission.ACCESS_FINE_LOCATION");
    }

    private static boolean c()
    {
        return ad.a("android.permission.ACCESS_COARSE_LOCATION");
    }

}
