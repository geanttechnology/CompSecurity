// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.x;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.copresence.internal.CopresenceApiOptions;
import com.google.android.gms.location.copresence.internal.b;
import com.google.android.gms.location.k;
import com.google.android.gms.location.n;
import java.util.List;

// Referenced classes of package com.google.android.gms.location.internal:
//            b, i, g, LocationRequestInternal

public class j extends com.google.android.gms.location.internal.b
{
    private static final class a extends f.a
    {

        private com.google.android.gms.common.api.k.b a;

        public void a(int k, PendingIntent pendingintent)
        {
            Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByPendingIntentResult");
        }

        public void a(int k, String as[])
        {
            if (a == null)
            {
                Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
                return;
            } else
            {
                as = n.b(n.a(k));
                a.a(as);
                a = null;
                return;
            }
        }

        public void b(int k, String as[])
        {
            Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByRequestIdsResult");
        }

        public a(com.google.android.gms.common.api.k.b b1)
        {
            a = b1;
        }
    }

    private static final class b extends f.a
    {

        private com.google.android.gms.common.api.k.b a;

        private void a(int k)
        {
            if (a == null)
            {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesResult called multiple times");
                return;
            } else
            {
                com.google.android.gms.common.api.Status status = n.b(n.a(k));
                a.a(status);
                a = null;
                return;
            }
        }

        public void a(int k, PendingIntent pendingintent)
        {
            a(k);
        }

        public void a(int k, String as[])
        {
            Log.wtf("LocationClientImpl", "Unexpected call to onAddGeofencesResult");
        }

        public void b(int k, String as[])
        {
            a(k);
        }

        public b(com.google.android.gms.common.api.k.b b1)
        {
            a = b1;
        }
    }

    private static final class c extends h.a
    {

        private com.google.android.gms.common.api.k.b a;

        public void a(LocationSettingsResult locationsettingsresult)
            throws RemoteException
        {
            a.a(locationsettingsresult);
            a = null;
        }

        public c(com.google.android.gms.common.api.k.b b1)
        {
            boolean flag;
            if (b1 != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            x.b(flag, "listener can't be null.");
            a = b1;
        }
    }


    private final i b;
    private final com.google.android.gms.location.copresence.internal.b c;

    public j(Context context, Looper looper, com.google.android.gms.common.api.c.b b1, com.google.android.gms.common.api.c.c c1, String s)
    {
        this(context, looper, b1, c1, s, h.a(context));
    }

    public j(Context context, Looper looper, com.google.android.gms.common.api.c.b b1, com.google.android.gms.common.api.c.c c1, String s, h h1)
    {
        this(context, looper, b1, c1, s, h1, CopresenceApiOptions.a);
    }

    public j(Context context, Looper looper, com.google.android.gms.common.api.c.b b1, com.google.android.gms.common.api.c.c c1, String s, h h1, CopresenceApiOptions copresenceapioptions)
    {
        super(context, looper, b1, c1, s, h1);
        b = new i(context, a);
        c = com.google.android.gms.location.copresence.internal.b.a(context, h1.a(), h1.g(), a, copresenceapioptions);
    }

    public Location a()
    {
        return b.a();
    }

    public void a(long l, PendingIntent pendingintent)
        throws RemoteException
    {
        zzoz();
        x.a(pendingintent);
        boolean flag;
        if (l >= 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        x.b(flag, "detectionIntervalMillis must be >= 0");
        ((g)zzoA()).a(l, true, pendingintent);
    }

    public void a(PendingIntent pendingintent)
        throws RemoteException
    {
        zzoz();
        x.a(pendingintent);
        ((g)zzoA()).a(pendingintent);
    }

    public void a(GeofencingRequest geofencingrequest, PendingIntent pendingintent, com.google.android.gms.common.api.k.b b1)
        throws RemoteException
    {
        zzoz();
        x.a(geofencingrequest, "geofencingRequest can't be null.");
        x.a(pendingintent, "PendingIntent must be specified.");
        x.a(b1, "ResultHolder not provided.");
        b1 = new a(b1);
        ((g)zzoA()).a(geofencingrequest, pendingintent, b1);
    }

    public void a(LocationRequest locationrequest, k k, Looper looper)
        throws RemoteException
    {
        synchronized (b)
        {
            b.a(locationrequest, k, looper);
        }
        return;
        locationrequest;
        l;
        JVM INSTR monitorexit ;
        throw locationrequest;
    }

    public void a(LocationSettingsRequest locationsettingsrequest, com.google.android.gms.common.api.k.b b1, String s)
        throws RemoteException
    {
        boolean flag1 = true;
        zzoz();
        boolean flag;
        if (locationsettingsrequest != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        x.b(flag, "locationSettingsRequest can't be null nor empty.");
        if (b1 != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        x.b(flag, "listener can't be null.");
        b1 = new c(b1);
        ((g)zzoA()).a(locationsettingsrequest, b1, s);
    }

    public void a(LocationRequestInternal locationrequestinternal, com.google.android.gms.location.j j1, Looper looper)
        throws RemoteException
    {
        synchronized (b)
        {
            b.a(locationrequestinternal, j1, looper);
        }
        return;
        locationrequestinternal;
        k;
        JVM INSTR monitorexit ;
        throw locationrequestinternal;
    }

    public void a(com.google.android.gms.location.j j1)
        throws RemoteException
    {
        b.a(j1);
    }

    public void a(k k)
        throws RemoteException
    {
        b.a(k);
    }

    public void a(List list, com.google.android.gms.common.api.k.b b1)
        throws RemoteException
    {
        zzoz();
        boolean flag;
        if (list != null && list.size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        x.b(flag, "geofenceRequestIds can't be null nor empty.");
        x.a(b1, "ResultHolder not provided.");
        list = (String[])list.toArray(new String[0]);
        b1 = new b(b1);
        ((g)zzoA()).a(list, b1, getContext().getPackageName());
    }

    public LocationAvailability b()
    {
        return b.b();
    }

    public void disconnect()
    {
        i k = b;
        k;
        JVM INSTR monitorenter ;
        boolean flag = isConnected();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        b.c();
        b.d();
_L1:
        super.disconnect();
        k;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", ((Throwable) (obj)));
          goto _L1
        obj;
        k;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public boolean zzoC()
    {
        return true;
    }
}
