// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package com.google.android.gms.internal:
//            hl, hg, er

public class hh
{
    private static class a extends Handler
    {

        private final LocationListener Lo;

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
            Lo.onLocationChanged(message);
        }

        public a(LocationListener locationlistener)
        {
            Lo = locationlistener;
        }

        public a(LocationListener locationlistener, Looper looper)
        {
            super(looper);
            Lo = locationlistener;
        }
    }

    private static class b extends com.google.android.gms.location.a.a
    {

        private Handler Lp;

        public void onLocationChanged(Location location)
        {
            if (Lp == null)
            {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            } else
            {
                Message message = Message.obtain();
                message.what = 1;
                message.obj = location;
                Lp.sendMessage(message);
                return;
            }
        }

        public void release()
        {
            Lp = null;
        }

        b(LocationListener locationlistener, Looper looper)
        {
            if (looper == null)
            {
                locationlistener = new a(locationlistener);
            } else
            {
                locationlistener = new a(locationlistener, looper);
            }
            Lp = locationlistener;
        }
    }


    private final hl Lk;
    private ContentProviderClient Ll;
    private boolean Lm;
    private HashMap Ln;
    private final Context mContext;

    public hh(Context context, hl hl1)
    {
        Ll = null;
        Lm = false;
        Ln = new HashMap();
        mContext = context;
        Lk = hl1;
    }

    public Location getLastLocation()
    {
        Lk.bm();
        Location location;
        try
        {
            location = ((hg)Lk.eb()).aF(mContext.getPackageName());
        }
        catch (RemoteException remoteexception)
        {
            throw new IllegalStateException(remoteexception);
        }
        return location;
    }

    public void gl()
    {
        if (Lm)
        {
            setMockMode(false);
        }
    }

    public void removeAllListeners()
    {
        Object obj = Ln;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = Ln.values().iterator();
_L2:
        b b1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_79;
            }
            b1 = (b)iterator.next();
        } while (b1 == null);
        ((hg)Lk.eb()).a(b1);
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
        Ln.clear();
        obj;
        JVM INSTR monitorexit ;
    }

    public void removeLocationUpdates(PendingIntent pendingintent)
    {
        Lk.bm();
        try
        {
            ((hg)Lk.eb()).a(pendingintent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (PendingIntent pendingintent)
        {
            throw new IllegalStateException(pendingintent);
        }
    }

    public void removeLocationUpdates(LocationListener locationlistener)
    {
        Lk.bm();
        er.b(locationlistener, "Invalid null listener");
        HashMap hashmap = Ln;
        hashmap;
        JVM INSTR monitorenter ;
        locationlistener = (b)Ln.remove(locationlistener);
        if (Ll != null && Ln.isEmpty())
        {
            Ll.release();
            Ll = null;
        }
        if (locationlistener == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        locationlistener.release();
        ((hg)Lk.eb()).a(locationlistener);
        hashmap;
        JVM INSTR monitorexit ;
        return;
        locationlistener;
        throw new IllegalStateException(locationlistener);
        locationlistener;
        hashmap;
        JVM INSTR monitorexit ;
        throw locationlistener;
    }

    public void requestLocationUpdates(LocationRequest locationrequest, PendingIntent pendingintent)
    {
        Lk.bm();
        try
        {
            ((hg)Lk.eb()).a(locationrequest, pendingintent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (LocationRequest locationrequest)
        {
            throw new IllegalStateException(locationrequest);
        }
    }

    public void requestLocationUpdates(LocationRequest locationrequest, LocationListener locationlistener, Looper looper)
    {
        Lk.bm();
        if (looper == null)
        {
            er.b(Looper.myLooper(), "Can't create handler inside thread that has not called Looper.prepare()");
        }
        HashMap hashmap = Ln;
        hashmap;
        JVM INSTR monitorenter ;
        b b1 = (b)Ln.get(locationlistener);
        if (b1 != null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        looper = new b(locationlistener, looper);
_L1:
        Ln.put(locationlistener, looper);
        ((hg)Lk.eb()).a(locationrequest, looper, mContext.getPackageName());
        hashmap;
        JVM INSTR monitorexit ;
        return;
        locationrequest;
        throw new IllegalStateException(locationrequest);
        locationrequest;
        hashmap;
        JVM INSTR monitorexit ;
        throw locationrequest;
        looper = b1;
          goto _L1
    }

    public void setMockLocation(Location location)
    {
        Lk.bm();
        try
        {
            ((hg)Lk.eb()).setMockLocation(location);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Location location)
        {
            throw new IllegalStateException(location);
        }
    }

    public void setMockMode(boolean flag)
    {
        Lk.bm();
        try
        {
            ((hg)Lk.eb()).setMockMode(flag);
        }
        catch (RemoteException remoteexception)
        {
            throw new IllegalStateException(remoteexception);
        }
        Lm = flag;
    }
}
