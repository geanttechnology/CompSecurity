// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.service;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.offerup.android.network.b;
import com.offerup.android.utils.m;
import java.util.Calendar;

// Referenced classes of package com.offerup.android.service:
//            PaymentLocationService

final class g extends Thread
    implements com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener, LocationListener
{

    private Context a;
    private long b;
    private boolean c;
    private long d;
    private PaymentLocationService e;

    public g(PaymentLocationService paymentlocationservice, Context context, long l, boolean flag)
    {
        e = paymentlocationservice;
        super();
        a = context;
        b = l;
        c = flag;
    }

    private void a(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        e.b = (new com.google.android.gms.common.api.GoogleApiClient.Builder(context)).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(LocationServices.API).build();
        e.c = new LocationRequest();
        e.c.setInterval(1000L);
        e.c.setFastestInterval(500L);
        e.c.setPriority(100);
        this;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public final void onConnected(Bundle bundle)
    {
        e.d = LocationServices.FusedLocationApi.getLastLocation(e.b);
        com.b.a.a.g.a(PaymentLocationService.a, (new StringBuilder("Last location = ")).append(e.d).toString());
        LocationServices.FusedLocationApi.requestLocationUpdates(e.b, e.c, this);
    }

    public final void onConnectionFailed(ConnectionResult connectionresult)
    {
        com.offerup.android.network.b.a(b, c, e.d, (new StringBuilder("onConnectionFailed from play services with ")).append(connectionresult.toString()).toString());
    }

    public final void onConnectionSuspended(int i)
    {
        com.offerup.android.network.b.a(b, c, e.d, (new StringBuilder("onConnectionSuspended from play services with code ")).append(i).toString());
    }

    public final void onLocationChanged(Location location)
    {
        e.d = location;
        com.b.a.a.g.a(PaymentLocationService.a, (new StringBuilder("Current location = ")).append(e.d).toString());
        if (Calendar.getInstance(m.a).getTimeInMillis() - d >= 5000L)
        {
            LocationServices.FusedLocationApi.removeLocationUpdates(e.b, this);
            e.b.disconnect();
            com.offerup.android.network.b.a(b, c, e.d, "received from play services");
        }
    }

    public final void run()
    {
        try
        {
            d = Calendar.getInstance(m.a).getTimeInMillis();
            a(a);
            e.b.connect();
            return;
        }
        catch (Exception exception)
        {
            com.b.a.a.g.a(PaymentLocationService.a, exception);
        }
    }
}
