// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzp, zzi, LocationRequestUpdateData, LocationRequestInternal, 
//            zzg

public class zzk
{
    private static class zza extends com.google.android.gms.location.zzc.zza
    {

        private Handler zzaFy;

        private void zzb(int i, Object obj)
        {
            if (zzaFy == null)
            {
                Log.e("LocationClientHelper", "Received a data in client after calling removeLocationUpdates.");
                return;
            } else
            {
                Message message = Message.obtain();
                message.what = i;
                message.obj = obj;
                zzaFy.sendMessage(message);
                return;
            }
        }

        public void onLocationAvailability(LocationAvailability locationavailability)
        {
            zzb(1, locationavailability);
        }

        public void onLocationResult(LocationResult locationresult)
        {
            zzb(0, locationresult);
        }

        public void release()
        {
            zzaFy = null;
        }

        zza(LocationCallback locationcallback, Looper looper)
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
                zzx.zza(flag, "Can't create handler inside thread that has not called Looper.prepare()");
            }
            zzaFy = new _cls1(this, looper1, locationcallback);
        }
    }

    private static class zzb extends Handler
    {

        private final LocationListener zzaFA;

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
            zzaFA.onLocationChanged(message);
        }

        public zzb(LocationListener locationlistener)
        {
            zzaFA = locationlistener;
        }

        public zzb(LocationListener locationlistener, Looper looper)
        {
            super(looper);
            zzaFA = locationlistener;
        }
    }

    private static class zzc extends com.google.android.gms.location.zzd.zza
    {

        private Handler zzaFy;

        public void onLocationChanged(Location location)
        {
            if (zzaFy == null)
            {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            } else
            {
                Message message = Message.obtain();
                message.what = 1;
                message.obj = location;
                zzaFy.sendMessage(message);
                return;
            }
        }

        public void release()
        {
            zzaFy = null;
        }

        zzc(LocationListener locationlistener, Looper looper)
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
                zzx.zza(flag, "Can't create handler inside thread that has not called Looper.prepare()");
            }
            if (looper == null)
            {
                locationlistener = new zzb(locationlistener);
            } else
            {
                locationlistener = new zzb(locationlistener, looper);
            }
            zzaFy = locationlistener;
        }
    }


    private final Context mContext;
    private final zzp zzaFb;
    private ContentProviderClient zzaFv;
    private boolean zzaFw;
    private Map zzaFx;
    private Map zzaqR;

    public zzk(Context context, zzp zzp1)
    {
        zzaFv = null;
        zzaFw = false;
        zzaqR = new HashMap();
        zzaFx = new HashMap();
        mContext = context;
        zzaFb = zzp1;
    }

    private zza zza(LocationCallback locationcallback, Looper looper)
    {
        Map map = zzaqR;
        map;
        JVM INSTR monitorenter ;
        zza zza2 = (zza)zzaFx.get(locationcallback);
        zza zza1;
        zza1 = zza2;
        if (zza2 != null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        zza1 = new zza(locationcallback, looper);
        zzaFx.put(locationcallback, zza1);
        map;
        JVM INSTR monitorexit ;
        return zza1;
        locationcallback;
        map;
        JVM INSTR monitorexit ;
        throw locationcallback;
    }

    private zzc zza(LocationListener locationlistener, Looper looper)
    {
        Map map = zzaqR;
        map;
        JVM INSTR monitorenter ;
        zzc zzc2 = (zzc)zzaqR.get(locationlistener);
        zzc zzc1;
        zzc1 = zzc2;
        if (zzc2 != null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        zzc1 = new zzc(locationlistener, looper);
        zzaqR.put(locationlistener, zzc1);
        map;
        JVM INSTR monitorexit ;
        return zzc1;
        locationlistener;
        map;
        JVM INSTR monitorexit ;
        throw locationlistener;
    }

    public Location getLastLocation()
    {
        zzaFb.zzpb();
        Location location;
        try
        {
            location = ((zzi)zzaFb.zzpc()).zzdv(mContext.getPackageName());
        }
        catch (RemoteException remoteexception)
        {
            throw new IllegalStateException(remoteexception);
        }
        return location;
    }

    public void removeAllListeners()
    {
        Object obj = zzaqR;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = zzaqR.values().iterator();
_L2:
        Object obj1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_85;
            }
            obj1 = (zzc)iterator.next();
        } while (obj1 == null);
        ((zzi)zzaFb.zzpc()).zza(LocationRequestUpdateData.zza(((com.google.android.gms.location.zzd) (obj1)), null));
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
        zzaqR.clear();
        exception = zzaFx.values().iterator();
_L3:
        do
        {
            if (!exception.hasNext())
            {
                break MISSING_BLOCK_LABEL_157;
            }
            obj1 = (zza)exception.next();
        } while (obj1 == null);
        ((zzi)zzaFb.zzpc()).zza(LocationRequestUpdateData.zza(((com.google.android.gms.location.zzc) (obj1)), null));
          goto _L3
        zzaFx.clear();
        obj;
        JVM INSTR monitorexit ;
    }

    public void zza(PendingIntent pendingintent, zzg zzg)
        throws RemoteException
    {
        zzaFb.zzpb();
        ((zzi)zzaFb.zzpc()).zza(LocationRequestUpdateData.zzb(pendingintent, zzg));
    }

    public void zza(LocationCallback locationcallback, zzg zzg)
        throws RemoteException
    {
        zzaFb.zzpb();
        zzx.zzb(locationcallback, "Invalid null callback");
        Map map = zzaFx;
        map;
        JVM INSTR monitorenter ;
        locationcallback = (zza)zzaFx.remove(locationcallback);
        if (locationcallback == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        locationcallback.release();
        ((zzi)zzaFb.zzpc()).zza(LocationRequestUpdateData.zza(locationcallback, zzg));
        map;
        JVM INSTR monitorexit ;
        return;
        locationcallback;
        map;
        JVM INSTR monitorexit ;
        throw locationcallback;
    }

    public void zza(LocationListener locationlistener, zzg zzg)
        throws RemoteException
    {
        zzaFb.zzpb();
        zzx.zzb(locationlistener, "Invalid null listener");
        Map map = zzaqR;
        map;
        JVM INSTR monitorenter ;
        locationlistener = (zzc)zzaqR.remove(locationlistener);
        if (zzaFv != null && zzaqR.isEmpty())
        {
            zzaFv.release();
            zzaFv = null;
        }
        if (locationlistener == null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        locationlistener.release();
        ((zzi)zzaFb.zzpc()).zza(LocationRequestUpdateData.zza(locationlistener, zzg));
        map;
        JVM INSTR monitorexit ;
        return;
        locationlistener;
        map;
        JVM INSTR monitorexit ;
        throw locationlistener;
    }

    public void zza(LocationRequest locationrequest, PendingIntent pendingintent, zzg zzg)
        throws RemoteException
    {
        zzaFb.zzpb();
        ((zzi)zzaFb.zzpc()).zza(LocationRequestUpdateData.zza(LocationRequestInternal.zzb(locationrequest), pendingintent, zzg));
    }

    public void zza(LocationRequest locationrequest, LocationListener locationlistener, Looper looper, zzg zzg)
        throws RemoteException
    {
        zzaFb.zzpb();
        locationlistener = zza(locationlistener, looper);
        ((zzi)zzaFb.zzpc()).zza(LocationRequestUpdateData.zza(LocationRequestInternal.zzb(locationrequest), locationlistener, zzg));
    }

    public void zza(LocationRequestInternal locationrequestinternal, LocationCallback locationcallback, Looper looper, zzg zzg)
        throws RemoteException
    {
        zzaFb.zzpb();
        locationcallback = zza(locationcallback, looper);
        ((zzi)zzaFb.zzpc()).zza(LocationRequestUpdateData.zza(locationrequestinternal, locationcallback, zzg));
    }

    public void zzah(boolean flag)
        throws RemoteException
    {
        zzaFb.zzpb();
        ((zzi)zzaFb.zzpc()).zzah(flag);
        zzaFw = flag;
    }

    public void zzc(Location location)
        throws RemoteException
    {
        zzaFb.zzpb();
        ((zzi)zzaFb.zzpc()).zzc(location);
    }

    public LocationAvailability zzwD()
    {
        zzaFb.zzpb();
        LocationAvailability locationavailability;
        try
        {
            locationavailability = ((zzi)zzaFb.zzpc()).zzdw(mContext.getPackageName());
        }
        catch (RemoteException remoteexception)
        {
            throw new IllegalStateException(remoteexception);
        }
        return locationavailability;
    }

    public void zzwE()
    {
        if (!zzaFw)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        zzah(false);
        return;
        RemoteException remoteexception;
        remoteexception;
        throw new IllegalStateException(remoteexception);
    }

    // Unreferenced inner class com/google/android/gms/location/internal/zzk$zza$1

/* anonymous class */
    class zza._cls1 extends Handler
    {

        final LocationCallback zzaFh;
        final zza zzaFz;

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                return;

            case 0: // '\0'
                zzaFh.onLocationResult((LocationResult)message.obj);
                return;

            case 1: // '\001'
                zzaFh.onLocationAvailability((LocationAvailability)message.obj);
                break;
            }
        }

            
            {
                zzaFz = zza1;
                zzaFh = locationcallback;
                super(looper);
            }
    }

}
