// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.h;
import com.google.android.gms.location.a;
import com.google.android.gms.location.b;
import com.kahuna.sdk.KahunaCoreReceiver;
import com.kahuna.sdk.m;

// Referenced classes of package android.support.v7:
//            ahc

public class ahb
    implements com.google.android.gms.common.api.c.b, com.google.android.gms.common.api.c.c, h
{

    private Context a;
    private PendingIntent b;
    private c c;

    protected ahb(Context context)
    {
        a = context;
        b = null;
        c = null;
    }

    private void a(PendingIntent pendingintent)
    {
        b = pendingintent;
    }

    private void c()
    {
        a.b.a(c, android.support.v7.ahc.b(), g()).a(this);
    }

    private void d()
    {
        e().b();
    }

    private c e()
    {
        if (c == null)
        {
            c = (new com.google.android.gms.common.api.c.a(a)).a(a.a).a(this).a(this).b();
        }
        return c;
    }

    private void f()
    {
        e().c();
        c = null;
    }

    private PendingIntent g()
    {
        if (a() != null)
        {
            return b;
        } else
        {
            Object obj = new Intent(a, com/kahuna/sdk/KahunaCoreReceiver);
            obj = PendingIntent.getBroadcast(a, 0, ((Intent) (obj)), 0x8000000);
            a(((PendingIntent) (obj)));
            return ((PendingIntent) (obj));
        }
    }

    protected PendingIntent a()
    {
        return b;
    }

    public void a(Status status)
    {
        if (!status.f() && m.s())
        {
            Log.d("Kahuna", (new StringBuilder()).append("Failed to request Activity Recognition Updates: ").append(status.c()).toString());
        }
        f();
_L1:
        return;
        status;
        if (m.s())
        {
            Log.w("Kahuna", "caught exception processing request activity result: ");
            status.printStackTrace();
            return;
        }
          goto _L1
    }

    public volatile void a(g g1)
    {
        a((Status)g1);
    }

    protected void b()
    {
        d();
    }

    public void onConnected(Bundle bundle)
    {
        if (m.s())
        {
            Log.d("Kahuna", "Activity Recognition Requester Play Services Connected");
        }
        c();
_L1:
        return;
        bundle;
        if (m.s())
        {
            Log.w("Kahuna", "caught exception attempting to request for activity updates: ");
            bundle.printStackTrace();
            return;
        }
          goto _L1
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        if (m.s())
        {
            Log.d("Kahuna", (new StringBuilder()).append("Activity Recognition Requester Play Services connection failed: ").append(connectionresult.toString()).toString());
        }
    }

    public void onConnectionSuspended(int i)
    {
    }
}
