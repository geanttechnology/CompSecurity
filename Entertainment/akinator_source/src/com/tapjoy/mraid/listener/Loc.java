// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.listener;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.tapjoy.mraid.controller.MraidLocation;

public class Loc
    implements LocationListener
{

    MraidLocation a;
    private LocationManager b;
    private String c;

    public Loc(Context context, int i, MraidLocation mraidlocation, String s)
    {
        a = mraidlocation;
        b = (LocationManager)context.getSystemService("location");
        c = s;
    }

    public void onLocationChanged(Location location)
    {
        a.success(location);
    }

    public void onProviderDisabled(String s)
    {
        a.fail();
    }

    public void onProviderEnabled(String s)
    {
    }

    public void onStatusChanged(String s, int i, Bundle bundle)
    {
        if (i == 0)
        {
            a.fail();
        }
    }

    public void start()
    {
        b.requestLocationUpdates(c, 0L, 0.0F, this);
    }

    public void stop()
    {
        b.removeUpdates(this);
    }
}
