// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services;

import android.location.Location;
import com.google.android.gms.common.api.d;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.c;
import com.google.android.gms.location.f;
import com.google.android.gms.location.h;
import com.target.a.a.b;

// Referenced classes of package com.target.mothership.services:
//            g

private class <init>
    implements f
{

    final g this$0;

    public void a(Location location)
    {
        b.e("DeviceLocationManager", "onLocationChanged()");
        com.target.mothership.services.g.b(g.this, location);
        g.a(g.this, location);
        if (g.a(g.this).e() && !g.g(g.this))
        {
            g.a(g.this, true);
            h.b.a(g.a(g.this), g.e(g.this));
            com.target.mothership.services.g.d(g.this).a(60000L);
            com.target.mothership.services.g.d(g.this).b(60000L);
            h.b.a(g.a(g.this), com.target.mothership.services.g.d(g.this), g.e(g.this));
        }
    }

    private ationRequest()
    {
        this$0 = g.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
