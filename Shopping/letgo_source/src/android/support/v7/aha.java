// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.PendingIntent;
import android.content.Context;
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
import com.kahuna.sdk.m;

public class aha
    implements com.google.android.gms.common.api.c.b, com.google.android.gms.common.api.c.c, h
{

    private Context a;
    private c b;
    private PendingIntent c;

    protected aha(Context context)
    {
        a = context;
        b = null;
    }

    private void a()
    {
        b().b();
    }

    private c b()
    {
        if (b == null)
        {
            b = (new com.google.android.gms.common.api.c.a(a)).a(a.a).a(this).a(this).b();
        }
        return b;
    }

    private void c()
    {
        b().c();
        b = null;
    }

    private void d()
    {
        a.b.a(b, c).a(this);
    }

    protected void a(PendingIntent pendingintent)
    {
        c = pendingintent;
        if (c == null)
        {
            return;
        } else
        {
            a();
            return;
        }
    }

    public void a(Status status)
    {
        if (!status.f() && m.s())
        {
            Log.d("Kahuna", (new StringBuilder()).append("Failed to remove Activity Recognition Updates: ").append(status.c()).toString());
        }
        c();
_L1:
        return;
        status;
        if (m.s())
        {
            Log.w("Kahuna", "caught exception processing remove activity result: ");
            status.printStackTrace();
            return;
        }
          goto _L1
    }

    public volatile void a(g g)
    {
        a((Status)g);
    }

    public void onConnected(Bundle bundle)
    {
        if (m.s())
        {
            Log.d("Kahuna", "Activity Recognition Remover Play Services Connected");
        }
        d();
_L1:
        return;
        bundle;
        if (m.s())
        {
            Log.w("Kahuna", "caught exception attempting to remove activity updates: ");
            bundle.printStackTrace();
            return;
        }
          goto _L1
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        if (m.s())
        {
            Log.d("Kahuna", (new StringBuilder()).append("Activity Recognition Remover Play Services connection failed: ").append(connectionresult.toString()).toString());
        }
    }

    public void onConnectionSuspended(int i)
    {
    }
}
