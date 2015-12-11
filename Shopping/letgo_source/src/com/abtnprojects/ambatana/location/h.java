// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.location;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.aqo;
import android.support.v7.du;
import android.support.v7.is;
import android.support.v7.iv;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.g;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.e;
import com.google.android.gms.location.m;
import com.google.android.gms.location.o;

// Referenced classes of package com.abtnprojects.ambatana.location:
//            f

public class h extends f
    implements com.google.android.gms.common.api.c.b, com.google.android.gms.common.api.c.c
{

    private static final String b = com/abtnprojects/ambatana/location/h.getSimpleName();
    private c c;
    private LocationRequest d;
    private Location e;
    private LocationRequest f;

    public h(Activity activity, du du)
    {
        super(activity, du);
        a(activity);
        g();
    }

    private LocationRequest a(long l, long l1, int i)
    {
        LocationRequest locationrequest = new LocationRequest();
        locationrequest.a(l);
        locationrequest.c(l1);
        locationrequest.b(2L * l);
        locationrequest.a(i);
        return locationrequest;
    }

    private void g()
    {
        if (d == null)
        {
            d = a(0x493e0L, 0x1d4c0L, 102);
        }
        if (f == null)
        {
            f = a(10000L, 5000L, 104);
        }
    }

    private boolean h()
    {
        LocationAvailability locationavailability = m.b.b(c);
        return locationavailability != null && locationavailability.a();
    }

    public void a()
    {
        c.b();
        com.google.android.gms.location.LocationSettingsRequest.a a1 = (new com.google.android.gms.location.LocationSettingsRequest.a()).a(f).a(d).a(true);
        m.d.a(c, a1.a()).a(new com.google.android.gms.common.api.h() {

            final h a;

            public volatile void a(g g1)
            {
                a((LocationSettingsResult)g1);
            }

            public void a(LocationSettingsResult locationsettingsresult)
            {
                locationsettingsresult = locationsettingsresult.a();
                locationsettingsresult.g();
                JVM INSTR lookupswitch 3: default 44
            //                           0: 45
            //                           6: 53
            //                           8502: 96;
                   goto _L1 _L2 _L3 _L4
_L1:
                return;
_L2:
                a.c();
                return;
_L3:
                if (is.g(a.a) || !iv.b(a.a)) goto _L1; else goto _L5
_L5:
                locationsettingsresult.a(a.a, 433);
                return;
                locationsettingsresult;
                return;
_L4:
                a.c();
                return;
            }

            
            {
                a = h.this;
                super();
            }
        });
    }

    protected void a(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        aqo.a("Building GoogleApiClient", new Object[0]);
        if (c == null)
        {
            c = (new com.google.android.gms.common.api.c.a(context)).a(m.a).a(this).a(this).b();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public void a(LocationAvailability locationavailability)
    {
        if (locationavailability.a())
        {
            c();
        }
    }

    public void a(LocationResult locationresult)
    {
        a(locationresult.a());
    }

    public void c()
    {
        if (c != null && !c.d())
        {
            c.b();
        }
    }

    public void d()
    {
        if (c != null && c.d())
        {
            m.b.a(c, this);
            c.c();
        }
    }

    public boolean f()
    {
        return !h();
    }

    public void onConnected(Bundle bundle)
    {
        aqo.a("Location services connected", new Object[0]);
        e = m.b.a(c);
        aqo.b("Location availability %s", new Object[] {
            Boolean.valueOf(h())
        });
        b(e);
        if (e == null)
        {
            m.b.a(c, f, this, Looper.getMainLooper());
            return;
        } else
        {
            m.b.a(c, d, this, Looper.getMainLooper());
            return;
        }
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        aqo.b("Connection failed: ConnectionResult.getErrorCode() = %d", new Object[] {
            Integer.valueOf(connectionresult.c())
        });
    }

    public void onConnectionSuspended(int i)
    {
        c.b();
    }

}
