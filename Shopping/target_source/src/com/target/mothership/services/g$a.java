// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services;

import android.os.Bundle;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.h;
import com.target.a.a.b;
import com.target.mothership.c;

// Referenced classes of package com.target.mothership.services:
//            g

private class <init>
    implements com.google.android.gms.common.api.it>
{

    final g this$0;

    public void a(int i)
    {
    }

    public void a(Bundle bundle)
    {
        b.e("DeviceLocationManager", "onConnected()");
        g.a(g.this, false);
        g.a(g.this, null);
        if (com.target.mothership.b.a().m())
        {
            if (c.b() == com.target.mothership.NoLocation)
            {
                g.a(g.this, null);
                return;
            } else
            {
                g.a(g.this, com.target.mothership.services.g.c());
                return;
            }
        }
        com.target.mothership.services.g.b(g.this, h.b.a(g.a(g.this)));
        if (com.target.mothership.services.g.b(g.this) != null)
        {
            g.a(g.this, com.target.mothership.services.g.b(g.this));
        }
        g.a(g.this, LocationRequest.a());
        bundle = g.d(g.this);
        byte byte0;
        if (com.target.mothership.services.g.c(g.this))
        {
            byte0 = 100;
        } else
        {
            byte0 = 102;
        }
        bundle.a(byte0);
        g.d(g.this).a(1000L);
        g.d(g.this).b(1000L);
        h.b.a(g.a(g.this), g.d(g.this), g.e(g.this));
        g.f(g.this);
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
