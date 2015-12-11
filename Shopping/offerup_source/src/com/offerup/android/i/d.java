// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.i;

import android.content.Context;
import android.os.Bundle;
import com.b.a.a.g;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationServices;

// Referenced classes of package com.offerup.android.i:
//            e, f

public final class d
    implements com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener, e
{

    private GoogleApiClient a;
    private f b;
    private final Object c = new Object();

    public d(Context context)
    {
        a = (new com.google.android.gms.common.api.GoogleApiClient.Builder(context)).addApi(LocationServices.API).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
    }

    public final void a()
    {
        a.connect();
    }

    public final void a(f f1)
    {
        synchronized (c)
        {
            b = f1;
        }
        return;
        f1;
        obj;
        JVM INSTR monitorexit ;
        throw f1;
    }

    public final void onConnected(Bundle bundle)
    {
        g.a("GoogleLocationClient", "onConnected()");
        synchronized (c)
        {
            if (b != null)
            {
                b.a(LocationServices.FusedLocationApi.getLastLocation(a));
            }
        }
        a.disconnect();
        return;
        exception;
        bundle;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void onConnectionFailed(ConnectionResult connectionresult)
    {
        g.a("GoogleLocationClient", (new StringBuilder("onConnectionFailed(")).append(connectionresult.toString()).append(")").toString());
        synchronized (c)
        {
            if (b != null)
            {
                b.a();
            }
        }
        return;
        exception;
        connectionresult;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void onConnectionSuspended(int i)
    {
        g.a("GoogleLocationClient", (new StringBuilder("onConnectionSuspended(")).append(i).append(")").toString());
    }
}
