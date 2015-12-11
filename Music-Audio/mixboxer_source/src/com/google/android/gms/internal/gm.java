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
//            gq, gl, eg

public class gm
{
    private static class a extends Handler
    {

        private final LocationListener xT;

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
            xT.onLocationChanged(message);
        }

        public a(LocationListener locationlistener)
        {
            xT = locationlistener;
        }

        public a(LocationListener locationlistener, Looper looper)
        {
            super(looper);
            xT = locationlistener;
        }
    }

    private static class b extends com.google.android.gms.location.c.a
    {

        private Handler xU;

        public void onLocationChanged(Location location)
        {
            if (xU == null)
            {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            } else
            {
                Message message = Message.obtain();
                message.what = 1;
                message.obj = location;
                xU.sendMessage(message);
                return;
            }
        }

        public void release()
        {
            xU = null;
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
            xU = locationlistener;
        }
    }


    private final Context mContext;
    private final gq xP;
    private ContentProviderClient xQ;
    private boolean xR;
    private HashMap xS;

    public gm(Context context, gq gq1)
    {
        xQ = null;
        xR = false;
        xS = new HashMap();
        mContext = context;
        xP = gq1;
    }

    public void dI()
    {
        if (xR)
        {
            setMockMode(false);
        }
    }

    public Location getLastLocation()
    {
        xP.bP();
        Location location;
        try
        {
            location = ((gl)xP.bQ()).an(mContext.getPackageName());
        }
        catch (RemoteException remoteexception)
        {
            throw new IllegalStateException(remoteexception);
        }
        return location;
    }

    public void removeAllListeners()
    {
        Object obj = xS;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = xS.values().iterator();
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
        ((gl)xP.bQ()).a(b1);
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
        xS.clear();
        obj;
        JVM INSTR monitorexit ;
    }

    public void removeLocationUpdates(PendingIntent pendingintent)
    {
        xP.bP();
        try
        {
            ((gl)xP.bQ()).a(pendingintent);
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
        xP.bP();
        eg.b(locationlistener, "Invalid null listener");
        HashMap hashmap = xS;
        hashmap;
        JVM INSTR monitorenter ;
        locationlistener = (b)xS.remove(locationlistener);
        if (xQ != null && xS.isEmpty())
        {
            xQ.release();
            xQ = null;
        }
        if (locationlistener == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        locationlistener.release();
        ((gl)xP.bQ()).a(locationlistener);
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
        xP.bP();
        try
        {
            ((gl)xP.bQ()).a(locationrequest, pendingintent);
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
        xP.bP();
        if (looper == null)
        {
            eg.b(Looper.myLooper(), "Can't create handler inside thread that has not called Looper.prepare()");
        }
        HashMap hashmap = xS;
        hashmap;
        JVM INSTR monitorenter ;
        b b1 = (b)xS.get(locationlistener);
        if (b1 != null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        looper = new b(locationlistener, looper);
_L1:
        xS.put(locationlistener, looper);
        ((gl)xP.bQ()).a(locationrequest, looper, mContext.getPackageName());
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
        xP.bP();
        try
        {
            ((gl)xP.bQ()).setMockLocation(location);
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
        xP.bP();
        try
        {
            ((gl)xP.bQ()).setMockMode(flag);
        }
        catch (RemoteException remoteexception)
        {
            throw new IllegalStateException(remoteexception);
        }
        xR = flag;
    }
}
