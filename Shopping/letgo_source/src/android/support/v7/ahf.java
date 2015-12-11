// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.h;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.g;
import com.google.android.gms.location.k;
import com.google.android.gms.location.m;
import com.kahuna.sdk.KahunaCoreReceiver;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ahf
    implements com.google.android.gms.common.api.c.b, com.google.android.gms.common.api.c.c, h
{

    private Context a;
    private PendingIntent b;
    private List c;
    private c d;
    private k e;
    private boolean f;

    public ahf(Context context)
    {
        e = new k() {

            final ahf a;

            public void a(Location location)
            {
            }

            
            {
                a = ahf.this;
                super();
            }
        };
        a = context;
        d = null;
        f = false;
    }

    static c a(ahf ahf1)
    {
        return ahf1.d;
    }

    private void a()
    {
        try
        {
            b().b();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private c b()
    {
        if (d == null)
        {
            d = (new com.google.android.gms.common.api.c.a(a)).a(m.a).a(this).a(this).b();
        }
        return d;
    }

    static k b(ahf ahf1)
    {
        return ahf1.e;
    }

    private void c()
    {
        b = e();
        m.c.a(d, c, b).a(this);
    }

    static void c(ahf ahf1)
    {
        ahf1.d();
    }

    private void d()
    {
        try
        {
            f = false;
            b().c();
            if (com.kahuna.sdk.m.s())
            {
                Log.d("Kahuna", "Location Services client disconnected.");
            }
            d = null;
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private PendingIntent e()
    {
        if (b != null)
        {
            return b;
        } else
        {
            Intent intent = new Intent(a, com/kahuna/sdk/KahunaCoreReceiver);
            intent.setAction("KAHUNA_GEOFENCES_UPDATED");
            return PendingIntent.getBroadcast(a, 0, intent, 0x8000000);
        }
    }

    public void a(Status status)
    {
        if (status.f())
        {
            if (com.kahuna.sdk.m.s())
            {
                Log.d("Kahuna", (new StringBuilder()).append("Geofences added successfully: ").append(c).toString());
            }
            status = LocationRequest.a();
            status.a(100);
            status.a(100L);
            status.c(10L);
            m.b.a(d, status, e);
            if (com.kahuna.sdk.m.s())
            {
                Log.d("Kahuna", "Requesting gps updates for 30 seconds for new geofences just updated");
            }
            (new Timer()).schedule(new TimerTask() {

                final ahf a;

                public void run()
                {
                    try
                    {
                        m.b.a(ahf.a(a), ahf.b(a)).a(5000L, TimeUnit.MILLISECONDS);
                    }
                    catch (Exception exception) { }
                    if (com.kahuna.sdk.m.s())
                    {
                        Log.d("Kahuna", "Finished requesting for gps updates for geofences.");
                    }
                    android.support.v7.ahf.c(a);
                }

            
            {
                a = ahf.this;
                super();
            }
            }, 30000L);
            return;
        }
        try
        {
            if (com.kahuna.sdk.m.s())
            {
                Log.d("Kahuna", (new StringBuilder()).append("Failure adding Geofences: ").append(c).toString());
            }
            d();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Status status)
        {
            d();
        }
        return;
    }

    public volatile void a(com.google.android.gms.common.api.g g1)
    {
        a((Status)g1);
    }

    public void a(List list)
        throws UnsupportedOperationException
    {
        c = list;
        if (!f)
        {
            f = true;
            a();
        } else
        if (com.kahuna.sdk.m.s())
        {
            Log.w("Kahuna", "Error attempting to register geofences while previous registration in progess");
            return;
        }
    }

    public void onConnected(Bundle bundle)
    {
        if (com.kahuna.sdk.m.s())
        {
            Log.d("Kahuna", "Location Services client connected.");
        }
        c();
_L1:
        return;
        bundle;
        if (com.kahuna.sdk.m.s())
        {
            Log.d("Kahuna", (new StringBuilder()).append("Caught exception in Geofence Remover onConnected: ").append(bundle).toString());
            return;
        }
          goto _L1
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        f = false;
        if (com.kahuna.sdk.m.s())
        {
            Log.e("Kahuna", "Adding: Received connection failed event while attempt geofencing connection.");
            Log.e("Kahuna", (new StringBuilder()).append("Error Code: ").append(connectionresult.c()).toString());
        }
        d = null;
    }

    public void onConnectionSuspended(int i)
    {
    }
}
