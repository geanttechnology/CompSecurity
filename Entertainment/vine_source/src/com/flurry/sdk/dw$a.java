// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

// Referenced classes of package com.flurry.sdk:
//            dw, el

class it>
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

    public void onStatusChanged(String s, int i, Bundle bundle)
    {
    }

    public ation(dw dw1)
    {
        a = dw1;
        super();
    }
}
