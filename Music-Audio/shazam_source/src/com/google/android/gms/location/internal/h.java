// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.location.internal:
//            m, f

public final class h
{
    private static final class a extends com.google.android.gms.location.k.a
    {

        private Handler a;

        private void a(int i, Object obj)
        {
            if (a == null)
            {
                Log.e("LocationClientHelper", "Received a data in client after calling removeLocationUpdates.");
                return;
            } else
            {
                Message message = Message.obtain();
                message.what = i;
                message.obj = obj;
                a.sendMessage(message);
                return;
            }
        }

        public final void a(LocationAvailability locationavailability)
        {
            a(1, locationavailability);
        }

        public final void a(LocationResult locationresult)
        {
            a(0, locationresult);
        }
    }

    private static final class b extends com.google.android.gms.location.l.a
    {

        private Handler a;

        public final void a(Location location)
        {
            if (a == null)
            {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            } else
            {
                Message message = Message.obtain();
                message.what = 1;
                message.obj = location;
                a.sendMessage(message);
                return;
            }
        }
    }


    final m a;
    boolean b;
    Map c;
    Map d;
    private final Context e;
    private ContentProviderClient f;

    public h(Context context, m m1)
    {
        f = null;
        b = false;
        c = new HashMap();
        d = new HashMap();
        e = context;
        a = m1;
    }

    public final Location a()
    {
        a.a();
        Location location;
        try
        {
            location = ((f)a.b()).b(e.getPackageName());
        }
        catch (RemoteException remoteexception)
        {
            throw new IllegalStateException(remoteexception);
        }
        return location;
    }
}
