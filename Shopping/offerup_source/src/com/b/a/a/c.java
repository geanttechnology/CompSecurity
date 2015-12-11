// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.a.a;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import java.util.Timer;

// Referenced classes of package com.b.a.a:
//            b, g, f

final class c
    implements LocationListener
{

    private b a;

    c(b b1)
    {
        a = b1;
        super();
    }

    public final void onLocationChanged(Location location)
    {
        g.b(b.a(a), "locationListenerNetwork::onLocationChanged");
        a.a.cancel();
        a.c.a(location);
        a.b.removeUpdates(this);
        a.b.removeUpdates(a.g);
    }

    public final void onProviderDisabled(String s)
    {
    }

    public final void onProviderEnabled(String s)
    {
    }

    public final void onStatusChanged(String s, int i, Bundle bundle)
    {
    }
}
