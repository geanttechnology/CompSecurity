// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.h;
import com.google.android.gms.location.g;
import com.google.android.gms.location.m;
import java.util.List;

public class ahe
    implements com.google.android.gms.common.api.c.b, com.google.android.gms.common.api.c.c, h
{

    private Context a;
    private List b;
    private c c;
    private boolean d;

    public ahe(Context context)
    {
        a = context;
        b = null;
        c = null;
        d = false;
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
        if (c == null)
        {
            c = (new com.google.android.gms.common.api.c.a(a)).a(m.a).a(this).a(this).b();
        }
        return c;
    }

    private void c()
    {
        try
        {
            d = false;
            b().c();
            if (com.kahuna.sdk.m.s())
            {
                Log.d("Kahuna", "Location Services client disconnected.");
            }
            c = null;
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void a(Status status)
    {
        if (!status.f()) goto _L2; else goto _L1
_L1:
        if (com.kahuna.sdk.m.s())
        {
            Log.d("Kahuna", (new StringBuilder()).append("Geofences removed successfully: ").append(b).toString());
        }
_L4:
        c();
        return;
_L2:
        if (com.kahuna.sdk.m.s())
        {
            Log.d("Kahuna", (new StringBuilder()).append("Failure removing Geofences: ").append(b).toString());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public volatile void a(com.google.android.gms.common.api.g g1)
    {
        a((Status)g1);
    }

    public void a(List list)
        throws IllegalArgumentException, UnsupportedOperationException
    {
        if (list == null || list.size() == 0)
        {
            if (com.kahuna.sdk.m.s())
            {
                Log.e("Kahuna", "No valid geofences, ignoring.");
            }
        } else
        if (!d)
        {
            b = list;
            a();
            return;
        }
    }

    public void onConnected(Bundle bundle)
    {
        if (com.kahuna.sdk.m.s())
        {
            Log.d("Kahuna", "Location Services client connected.");
        }
        m.c.a(c, b).a(this);
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
        d = false;
        if (com.kahuna.sdk.m.s())
        {
            Log.e("Kahuna", "Removal: Received connection failed event while attempt geofencing connection.");
            Log.e("Kahuna", (new StringBuilder()).append("Error Code: ").append(connectionresult.c()).toString());
        }
        c = null;
    }

    public void onConnectionSuspended(int i)
    {
    }
}
