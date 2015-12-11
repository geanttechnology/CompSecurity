// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.iovation.mobile.android.details.background.listeners;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

public class a
    implements android.location.GpsStatus.Listener, android.location.GpsStatus.NmeaListener, LocationListener
{

    private com.iovation.mobile.android.details.background.a a;

    public a(com.iovation.mobile.android.details.background.a a1)
    {
        a = a1;
    }

    public void onGpsStatusChanged(int i)
    {
    }

    public void onLocationChanged(Location location)
    {
        try
        {
            a.a(location);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Location location)
        {
            return;
        }
    }

    public void onNmeaReceived(long l, String s)
    {
        a.a(1);
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
}
