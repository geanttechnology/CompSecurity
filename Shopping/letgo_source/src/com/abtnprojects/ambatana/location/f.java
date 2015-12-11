// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.location;

import android.app.Activity;
import android.location.Location;
import android.os.AsyncTask;
import android.support.v7.ags;
import android.support.v7.ajx;
import android.support.v7.aqo;
import android.support.v7.du;
import android.support.v7.dz;
import android.support.v7.ee;
import android.support.v7.ei;
import android.support.v7.fy;
import android.support.v7.is;
import com.abtnprojects.ambatana.models.CurrentUserLocation;
import com.abtnprojects.ambatana.models.LetgoAddress;
import com.google.android.gms.location.j;
import com.google.android.gms.maps.model.LatLng;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import java.util.Date;

// Referenced classes of package com.abtnprojects.ambatana.location:
//            GeocodeIntentService

public abstract class f extends j
{

    protected final Activity a;
    private CurrentUserLocation b;
    private LetgoAddress c;
    private final du d;

    public f(Activity activity, du du1)
    {
        a = activity;
        c = du1.a();
        b = du1.b();
        d = du1;
    }

    private boolean a(CurrentUserLocation currentuserlocation, Location location)
    {
        while (currentuserlocation == null || location == null || ags.b(new LatLng(currentuserlocation.getLatitude(), currentuserlocation.getLongitude()), new LatLng(location.getLatitude(), location.getLongitude())) > 2000D) 
        {
            return true;
        }
        return false;
    }

    public abstract void a();

    protected void a(Location location)
    {
label0:
        {
            if (location != null)
            {
                aqo.a("New location %s", new Object[] {
                    location
                });
                b = d.b();
                c = d.a();
                aqo.a("Cached address %s", new Object[] {
                    c
                });
                if (!c(location) && c != null)
                {
                    break label0;
                }
                aqo.a("Expired cache or null saved address, update location", new Object[0]);
                GeocodeIntentService.a(a, location, is.g(a));
                b = CurrentUserLocation.getInstance();
                b.updateLocationData(location.getLatitude(), location.getLongitude(), location.getProvider());
                d.a(b);
                dz.a().a(new ee(location));
            }
            return;
        }
        aqo.a("Ignoring location update, use cached location", new Object[0]);
    }

    protected void b()
    {
        dz.a().a(new ei());
    }

    protected void b(Location location)
    {
        if (location != null)
        {
            a(location);
            return;
        }
        if (b == null)
        {
            aqo.a("Calling to get location by ip", new Object[0]);
            location = new fy(a);
            Void avoid[] = new Void[0];
            if (!(location instanceof AsyncTask))
            {
                location.execute(avoid);
                return;
            } else
            {
                AsyncTaskInstrumentation.execute((AsyncTask)location, avoid);
                return;
            }
        } else
        {
            aqo.a("Cached location is not null", new Object[0]);
            location = new Location(b.getProvider());
            location.setLatitude(b.getLatitude());
            location.setLongitude(b.getLongitude());
            location.setTime(b.getLastUpdated());
            a(location);
            return;
        }
    }

    public abstract void c();

    protected boolean c(Location location)
    {
        if (b != null)
        {
            if ("UserLocationByIp".equalsIgnoreCase(b.getProvider()))
            {
                return a(b, location);
            }
            if (!(new Date()).after(new Date(b.getLastUpdated() + 0x66ff300L)) && !a(b, location))
            {
                return false;
            }
        }
        return true;
    }

    public abstract void d();

    public CurrentUserLocation e()
    {
        return b;
    }

    public abstract boolean f();
}
