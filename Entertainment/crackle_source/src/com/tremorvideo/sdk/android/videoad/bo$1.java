// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            bo

static final class a
    implements LocationListener
{

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

    (LocationManager locationmanager)
    {
        a = locationmanager;
        super();
    }
}
