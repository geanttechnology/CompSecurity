// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

// Referenced classes of package com.flurry.sdk:
//            jj, kg

class it>
    implements LocationListener
{

    final jj a;

    public void onLocationChanged(Location location)
    {
        if (location != null)
        {
            jj.a(a, location);
        }
        if (jj.c(a) >= 3)
        {
            kg.a(4, jj.f(), "Max location reports reached, stopping");
            jj.b(a);
        }
    }

    public void onProviderDisabled(String s)
    {
    }

    public void onProviderEnabled(String s)
    {
    }

    public void onStatusChanged(String s, int i, Bundle bundle)
    {
    }

    public ation(jj jj1)
    {
        a = jj1;
        super();
    }
}
