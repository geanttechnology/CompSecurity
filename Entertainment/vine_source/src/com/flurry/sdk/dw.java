// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;

// Referenced classes of package com.flurry.sdk:
//            dm, dn, el, dl

public class dw
    implements dn.a
{
    class a
        implements LocationListener
    {

        final dw a;

        public void onLocationChanged(Location location)
        {
            if (location != null)
            {
                dw.a(a, location);
            }
            if (dw.a(a) >= 3)
            {
                el.a(4, dw.h(), "Max location reports reached, stopping");
                dw.b(a);
            }
        }

        public void onProviderDisabled(String s)
        {
        }

        public void onProviderEnabled(String s)
        {
        }

        public void onStatusChanged(String s, int i1, Bundle bundle)
        {
        }

        public a()
        {
            a = dw.this;
            super();
        }
    }


    private static final String c = com/flurry/sdk/dw.getSimpleName();
    private static dw o;
    boolean a;
    boolean b;
    private final int d = 3;
    private final long e = 10000L;
    private final long f = 0L;
    private LocationManager g;
    private Criteria h;
    private Location i;
    private a j;
    private String k;
    private int l;
    private int m;
    private volatile Location n;

    private dw()
    {
        a = false;
        l = 0;
        m = 0;
        j = new a();
        dn dn1 = dm.a();
        h = (Criteria)dn1.a("LocationCriteria");
        dn1.a("LocationCriteria", this);
        el.a(4, c, (new StringBuilder()).append("initSettings, LocationCriteria = ").append(h).toString());
        b = ((Boolean)dn1.a("ReportLocation")).booleanValue();
        dn1.a("ReportLocation", this);
        el.a(4, c, (new StringBuilder()).append("initSettings, ReportLocation = ").append(b).toString());
    }

    static int a(dw dw1)
    {
        int i1 = dw1.m + 1;
        dw1.m = i1;
        return i1;
    }

    static Location a(dw dw1, Location location)
    {
        dw1.i = location;
        return location;
    }

    public static dw a()
    {
        com/flurry/sdk/dw;
        JVM INSTR monitorenter ;
        dw dw1;
        if (o == null)
        {
            o = new dw();
        }
        dw1 = o;
        com/flurry/sdk/dw;
        JVM INSTR monitorexit ;
        return dw1;
        Exception exception;
        exception;
        throw exception;
    }

    private void a(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            g.requestLocationUpdates(s, 10000L, 0.0F, j, Looper.getMainLooper());
        }
    }

    private Location b(String s)
    {
        Location location = null;
        if (!TextUtils.isEmpty(s))
        {
            location = g.getLastKnownLocation(s);
        }
        return location;
    }

    static void b(dw dw1)
    {
        dw1.i();
    }

    static String h()
    {
        return c;
    }

    private void i()
    {
        g.removeUpdates(j);
        a = false;
        m = 0;
        el.a(4, c, "LocationProvider stopped");
    }

    private void j()
    {
        if (b && n == null)
        {
            Context context = dl.a().b();
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0)
            {
                i();
                String s = k();
                a(s);
                i = b(s);
                a = true;
                el.a(4, c, "LocationProvider started");
                return;
            }
        }
    }

    private String k()
    {
        Criteria criteria = h;
        Object obj = criteria;
        if (criteria == null)
        {
            obj = new Criteria();
        }
        if (TextUtils.isEmpty(k))
        {
            obj = g.getBestProvider(((Criteria) (obj)), true);
        } else
        {
            obj = k;
        }
        el.a(4, c, (new StringBuilder()).append("provider = ").append(((String) (obj))).toString());
        return ((String) (obj));
    }

    public void a(float f1, float f2)
    {
        n = new Location("Explicit");
        n.setLatitude(f1);
        n.setLongitude(f2);
    }

    public void a(String s, Object obj)
    {
        if (s.equals("LocationCriteria"))
        {
            h = (Criteria)obj;
            el.a(4, c, (new StringBuilder()).append("onSettingUpdate, LocationCriteria = ").append(h).toString());
            if (a)
            {
                j();
            }
        } else
        if (s.equals("ReportLocation"))
        {
            b = ((Boolean)obj).booleanValue();
            el.a(4, c, (new StringBuilder()).append("onSettingUpdate, ReportLocation = ").append(b).toString());
            if (b)
            {
                if (!a && l > 0)
                {
                    j();
                    return;
                }
            } else
            {
                i();
                return;
            }
        } else
        {
            el.a(6, c, "LocationProvider internal error! Had to be LocationCriteria or ReportLocation key.");
            return;
        }
    }

    public void b()
    {
        this;
        JVM INSTR monitorenter ;
        LocationManager locationmanager = g;
        if (locationmanager == null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        g = (LocationManager)dl.a().b().getSystemService("location");
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void c()
    {
        this;
        JVM INSTR monitorenter ;
        el.a(4, c, "Location provider subscribed");
        l = l + 1;
        if (!a && m < 3)
        {
            j();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void d()
    {
        this;
        JVM INSTR monitorenter ;
        el.a(4, c, "Location provider unsubscribed");
        if (l > 0) goto _L2; else goto _L1
_L1:
        el.a(6, c, "Error! Unsubscribed too many times!");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        l = l - 1;
        if (l == 0)
        {
            i();
        }
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void e()
    {
        n = null;
    }

    public Location f()
    {
        Location location = null;
        if (n != null)
        {
            return n;
        }
        if (b)
        {
            location = b(k());
            if (location != null)
            {
                i = location;
            }
            location = i;
        }
        el.a(4, c, (new StringBuilder()).append("getLocation() = ").append(location).toString());
        return location;
    }

    public void g()
    {
        l = 0;
        i();
    }

}
