// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.iovation.mobile.android.details.background;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import com.iovation.mobile.android.details.c;
import com.iovation.mobile.android.details.j;
import com.iovation.mobile.android.details.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
    implements c
{

    private static boolean b = false;
    private static Location f;
    protected int a;
    private Context c;
    private long d;
    private com.iovation.mobile.android.details.background.listeners.a e;

    public a()
    {
        d = 0L;
        a = 0;
        e = new com.iovation.mobile.android.details.background.listeners.a(this);
    }

    public void a(int i)
    {
        a = i;
    }

    public void a(Context context)
    {
        ((LocationManager)context.getSystemService("location")).removeUpdates(e);
    }

    public void a(Context context, j j1)
    {
        boolean flag1 = false;
        if (!k.a("android.permission.ACCESS_FINE_LOCATION", context)) goto _L2; else goto _L1
_L1:
        LocationManager locationmanager;
        boolean flag;
        locationmanager = (LocationManager)context.getSystemService("location");
        boolean flag2;
        try
        {
            flag = locationmanager.isProviderEnabled("gps");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            flag = false;
        }
        flag2 = locationmanager.isProviderEnabled("network");
        flag1 = flag2;
_L6:
        j1.a("LSEN", "TRUE");
        Object obj;
        if (flag && !flag1)
        {
            j1.a("LSG", "GPS");
            obj = "gps";
        } else
        if (!flag && flag1)
        {
            j1.a("LSG", "NET");
            obj = "network";
        } else
        if (!flag && !flag1)
        {
            j1.a("LSG", "NONE");
            obj = "gps";
        } else
        if (flag && flag1)
        {
            j1.a("LSG", "BOTH");
            obj = "gps";
        } else
        {
            obj = "gps";
        }
        if (obj != null) goto _L4; else goto _L3
_L3:
        return;
_L4:
        if (f == null)
        {
            f = locationmanager.getLastKnownLocation(((String) (obj)));
        }
        if (f != null)
        {
            break; /* Loop/switch isn't completed */
        }
        f = locationmanager.getLastKnownLocation("network");
        if (f == null) goto _L3; else goto _L5
_L5:
        obj = b(context);
        j1.a("LAT", Double.toString(f.getLatitude()));
        j1.a("LON", Double.toString(f.getLongitude()));
        j1.a("ALT", Double.toString(f.getAltitude()));
        j1.a("GLA", Float.toString(f.getAccuracy()));
        j1.a("GLD", Long.toString(f.getTime()));
        j1.a("MOCK", Integer.toString(((ArrayList) (obj)).size()));
        j1.a("MLS", Integer.toString(c(context)));
        j1.a("NMEA", Integer.toString(a));
        return;
_L2:
        j1.a("LSEN", "FALSE");
        return;
        obj;
          goto _L6
    }

    public void a(Location location)
    {
        f = location;
        if (f.getAccuracy() <= 100F)
        {
            a(c);
        }
    }

    public ArrayList b(Context context)
    {
        ArrayList arraylist;
        PackageManager packagemanager;
        Iterator iterator;
        arraylist = new ArrayList();
        packagemanager = context.getPackageManager();
        iterator = packagemanager.getInstalledApplications(128).iterator();
_L5:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        ApplicationInfo applicationinfo = (ApplicationInfo)iterator.next();
        String as[] = packagemanager.getPackageInfo(applicationinfo.packageName, 4096).requestedPermissions;
        int i;
        if (as == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = 0;
_L3:
        if (i >= as.length)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (as[i].equals("android.permission.ACCESS_MOCK_LOCATION") && !applicationinfo.packageName.equals(context.getPackageName()))
        {
            arraylist.add(applicationinfo.packageName);
        }
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        return arraylist;
        Object obj;
        obj;
        continue; /* Loop/switch isn't completed */
        obj;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public int c(Context context)
    {
        int i;
        try
        {
            i = android.provider.Settings.Secure.getInt(context.getContentResolver(), "mock_location");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return -1;
        }
        return i != 1 ? 0 : 1;
    }

}
