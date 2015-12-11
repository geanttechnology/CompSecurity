// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.cs;
import java.util.concurrent.ScheduledFuture;

// Referenced classes of package com.parse:
//            LocationNotifier

static final class val.manager
    implements LocationListener
{

    final LocationManager val$manager;
    final android.support.v7.eUpdates val$tcs;
    final cs val$timeoutFuture;

    public void onLocationChanged(Location location)
    {
        if (location == null)
        {
            return;
        } else
        {
            ((ScheduledFuture)val$timeoutFuture.a()).cancel(true);
            val$tcs.ancel(location);
            val$manager.removeUpdates(this);
            return;
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

    ger(cs cs1, android.support.v7. , LocationManager locationmanager)
    {
        val$timeoutFuture = cs1;
        val$tcs = ;
        val$manager = locationmanager;
        super();
    }
}
