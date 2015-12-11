// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.x;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.j;
import com.google.android.gms.location.k;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.google.android.gms.location.internal:
//            n, g, LocationRequestInternal, LocationRequestUpdateData

public class i
{
    private static class a extends com.google.android.gms.location.r.a
    {

        private Handler a;

        private void a(int j, Object obj)
        {
            if (a == null)
            {
                Log.e("LocationClientHelper", "Received a data in client after calling removeLocationUpdates.");
                return;
            } else
            {
                Message message = Message.obtain();
                message.what = j;
                message.obj = obj;
                a.sendMessage(message);
                return;
            }
        }

        public void a()
        {
            a = null;
        }

        public void a(LocationAvailability locationavailability)
        {
            a(1, locationavailability);
        }

        public void a(LocationResult locationresult)
        {
            a(0, locationresult);
        }

        a(j j, Looper looper)
        {
            Looper looper1 = looper;
            if (looper == null)
            {
                looper1 = Looper.myLooper();
                boolean flag;
                if (looper1 != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                x.a(flag, "Can't create handler inside thread that has not called Looper.prepare()");
            }
            a = new _cls1(this, looper1, j);
        }
    }

    private static class b extends Handler
    {

        private final k a;

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
                return;

            case 1: // '\001'
                message = new Location((Location)message.obj);
                break;
            }
            a.a(message);
        }

        public b(k k1)
        {
            a = k1;
        }

        public b(k k1, Looper looper)
        {
            super(looper);
            a = k1;
        }
    }

    private static class c extends com.google.android.gms.location.s.a
    {

        private Handler a;

        public void a()
        {
            a = null;
        }

        public void a(Location location)
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

        c(k k, Looper looper)
        {
            if (looper == null)
            {
                boolean flag;
                if (Looper.myLooper() != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                x.a(flag, "Can't create handler inside thread that has not called Looper.prepare()");
            }
            if (looper == null)
            {
                k = new b(k);
            } else
            {
                k = new b(k, looper);
            }
            a = k;
        }
    }


    private final n a;
    private final Context b;
    private ContentProviderClient c;
    private boolean d;
    private Map e;
    private Map f;

    public i(Context context, n n1)
    {
        c = null;
        d = false;
        e = new HashMap();
        f = new HashMap();
        b = context;
        a = n1;
    }

    private a a(j j, Looper looper)
    {
        Map map = e;
        map;
        JVM INSTR monitorenter ;
        a a2 = (a)f.get(j);
        a a1;
        a1 = a2;
        if (a2 != null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        a1 = new a(j, looper);
        f.put(j, a1);
        map;
        JVM INSTR monitorexit ;
        return a1;
        j;
        map;
        JVM INSTR monitorexit ;
        throw j;
    }

    private c a(k k, Looper looper)
    {
        Map map = e;
        map;
        JVM INSTR monitorenter ;
        c c2 = (c)e.get(k);
        c c1;
        c1 = c2;
        if (c2 != null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        c1 = new c(k, looper);
        e.put(k, c1);
        map;
        JVM INSTR monitorexit ;
        return c1;
        k;
        map;
        JVM INSTR monitorexit ;
        throw k;
    }

    public Location a()
    {
        a.a();
        Location location;
        try
        {
            location = ((g)a.c()).b(b.getPackageName());
        }
        catch (RemoteException remoteexception)
        {
            throw new IllegalStateException(remoteexception);
        }
        return location;
    }

    public void a(LocationRequest locationrequest, k k, Looper looper)
        throws RemoteException
    {
        a.a();
        k = a(k, looper);
        ((g)a.c()).a(LocationRequestUpdateData.a(LocationRequestInternal.a(locationrequest), k));
    }

    public void a(LocationRequestInternal locationrequestinternal, j j, Looper looper)
        throws RemoteException
    {
        a.a();
        j = a(j, looper);
        ((g)a.c()).a(LocationRequestUpdateData.a(locationrequestinternal, j));
    }

    public void a(j j)
        throws RemoteException
    {
        a.a();
        x.a(j, "Invalid null callback");
        Map map = f;
        map;
        JVM INSTR monitorenter ;
        j = (a)f.remove(j);
        if (j == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        j.a();
        ((g)a.c()).a(LocationRequestUpdateData.a(j));
        map;
        JVM INSTR monitorexit ;
        return;
        j;
        map;
        JVM INSTR monitorexit ;
        throw j;
    }

    public void a(k k)
        throws RemoteException
    {
        a.a();
        x.a(k, "Invalid null listener");
        Map map = e;
        map;
        JVM INSTR monitorenter ;
        k = (c)e.remove(k);
        if (c != null && e.isEmpty())
        {
            c.release();
            c = null;
        }
        if (k == null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        k.a();
        ((g)a.c()).a(LocationRequestUpdateData.a(k));
        map;
        JVM INSTR monitorexit ;
        return;
        k;
        map;
        JVM INSTR monitorexit ;
        throw k;
    }

    public void a(boolean flag)
        throws RemoteException
    {
        a.a();
        ((g)a.c()).a(flag);
        d = flag;
    }

    public LocationAvailability b()
    {
        a.a();
        LocationAvailability locationavailability;
        try
        {
            locationavailability = ((g)a.c()).c(b.getPackageName());
        }
        catch (RemoteException remoteexception)
        {
            throw new IllegalStateException(remoteexception);
        }
        return locationavailability;
    }

    public void c()
    {
        Object obj = e;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = e.values().iterator();
_L2:
        Object obj1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_84;
            }
            obj1 = (c)iterator.next();
        } while (obj1 == null);
        ((g)a.c()).a(LocationRequestUpdateData.a(((com.google.android.gms.location.s) (obj1))));
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new IllegalStateException(((Throwable) (obj)));
        }
        e.clear();
        exception = f.values().iterator();
_L3:
        do
        {
            if (!exception.hasNext())
            {
                break MISSING_BLOCK_LABEL_155;
            }
            obj1 = (a)exception.next();
        } while (obj1 == null);
        ((g)a.c()).a(LocationRequestUpdateData.a(((com.google.android.gms.location.r) (obj1))));
          goto _L3
        f.clear();
        obj;
        JVM INSTR monitorexit ;
    }

    public void d()
    {
        if (!d)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        a(false);
        return;
        RemoteException remoteexception;
        remoteexception;
        throw new IllegalStateException(remoteexception);
    }

    // Unreferenced inner class com/google/android/gms/location/internal/i$a$1

/* anonymous class */
    class a._cls1 extends Handler
    {

        final j a;
        final a b;

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                return;

            case 0: // '\0'
                a.a((LocationResult)message.obj);
                return;

            case 1: // '\001'
                a.a((LocationAvailability)message.obj);
                break;
            }
        }

            
            {
                b = a1;
                a = j1;
                super(looper);
            }
    }

}
