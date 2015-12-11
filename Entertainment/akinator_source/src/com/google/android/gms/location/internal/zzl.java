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
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.List;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzb, zzk, zzi, zzg, 
//            LocationRequestInternal

public class zzl extends com.google.android.gms.location.internal.zzb
{
    private static final class zza extends zzh.zza
    {

        private com.google.android.gms.internal.zzlb.zzb zzaFC;

        public void zza(int i, PendingIntent pendingintent)
        {
            Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByPendingIntentResult");
        }

        public void zza(int i, String as[])
        {
            if (zzaFC == null)
            {
                Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
                return;
            } else
            {
                as = LocationStatusCodes.zzgW(LocationStatusCodes.zzgV(i));
                zzaFC.zzp(as);
                zzaFC = null;
                return;
            }
        }

        public void zzb(int i, String as[])
        {
            Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByRequestIdsResult");
        }

        public zza(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzaFC = zzb1;
        }
    }

    private static final class zzb extends zzh.zza
    {

        private com.google.android.gms.internal.zzlb.zzb zzaFC;

        private void zzgZ(int i)
        {
            if (zzaFC == null)
            {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesResult called multiple times");
                return;
            } else
            {
                com.google.android.gms.common.api.Status status = LocationStatusCodes.zzgW(LocationStatusCodes.zzgV(i));
                zzaFC.zzp(status);
                zzaFC = null;
                return;
            }
        }

        public void zza(int i, PendingIntent pendingintent)
        {
            zzgZ(i);
        }

        public void zza(int i, String as[])
        {
            Log.wtf("LocationClientImpl", "Unexpected call to onAddGeofencesResult");
        }

        public void zzb(int i, String as[])
        {
            zzgZ(i);
        }

        public zzb(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzaFC = zzb1;
        }
    }

    private static final class zzc extends zzj.zza
    {

        private com.google.android.gms.internal.zzlb.zzb zzaFC;

        public void zza(LocationSettingsResult locationsettingsresult)
            throws RemoteException
        {
            zzaFC.zzp(locationsettingsresult);
            zzaFC = null;
        }

        public zzc(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            boolean flag;
            if (zzb1 != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzb(flag, "listener can't be null.");
            zzaFC = zzb1;
        }
    }


    private final zzk zzaFB;

    public zzl(Context context, Looper looper, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, String s)
    {
        this(context, looper, connectioncallbacks, onconnectionfailedlistener, s, zzf.zzak(context));
    }

    public zzl(Context context, Looper looper, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, String s, zzf zzf1)
    {
        super(context, looper, connectioncallbacks, onconnectionfailedlistener, s, zzf1);
        zzaFB = new zzk(context, zzaFb);
    }

    public void disconnect()
    {
        zzk zzk1 = zzaFB;
        zzk1;
        JVM INSTR monitorenter ;
        boolean flag = isConnected();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        zzaFB.removeAllListeners();
        zzaFB.zzwE();
_L1:
        super.disconnect();
        zzk1;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", ((Throwable) (obj)));
          goto _L1
        obj;
        zzk1;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public Location getLastLocation()
    {
        return zzaFB.getLastLocation();
    }

    public void zza(long l, PendingIntent pendingintent)
        throws RemoteException
    {
        zzpb();
        zzx.zzw(pendingintent);
        boolean flag;
        if (l >= 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "detectionIntervalMillis must be >= 0");
        ((zzi)zzpc()).zza(l, true, pendingintent);
    }

    public void zza(PendingIntent pendingintent)
        throws RemoteException
    {
        zzpb();
        zzx.zzw(pendingintent);
        ((zzi)zzpc()).zza(pendingintent);
    }

    public void zza(PendingIntent pendingintent, com.google.android.gms.internal.zzlb.zzb zzb1)
        throws RemoteException
    {
        zzpb();
        zzx.zzb(pendingintent, "PendingIntent must be specified.");
        zzx.zzb(zzb1, "ResultHolder not provided.");
        zzb1 = new zzb(zzb1);
        ((zzi)zzpc()).zza(pendingintent, zzb1, getContext().getPackageName());
    }

    public void zza(PendingIntent pendingintent, zzg zzg)
        throws RemoteException
    {
        zzaFB.zza(pendingintent, zzg);
    }

    public void zza(GeofencingRequest geofencingrequest, PendingIntent pendingintent, com.google.android.gms.internal.zzlb.zzb zzb1)
        throws RemoteException
    {
        zzpb();
        zzx.zzb(geofencingrequest, "geofencingRequest can't be null.");
        zzx.zzb(pendingintent, "PendingIntent must be specified.");
        zzx.zzb(zzb1, "ResultHolder not provided.");
        zzb1 = new zza(zzb1);
        ((zzi)zzpc()).zza(geofencingrequest, pendingintent, zzb1);
    }

    public void zza(LocationCallback locationcallback, zzg zzg)
        throws RemoteException
    {
        zzaFB.zza(locationcallback, zzg);
    }

    public void zza(LocationListener locationlistener, zzg zzg)
        throws RemoteException
    {
        zzaFB.zza(locationlistener, zzg);
    }

    public void zza(LocationRequest locationrequest, PendingIntent pendingintent, zzg zzg)
        throws RemoteException
    {
        zzaFB.zza(locationrequest, pendingintent, zzg);
    }

    public void zza(LocationRequest locationrequest, LocationListener locationlistener, Looper looper, zzg zzg)
        throws RemoteException
    {
        synchronized (zzaFB)
        {
            zzaFB.zza(locationrequest, locationlistener, looper, zzg);
        }
        return;
        locationrequest;
        zzk1;
        JVM INSTR monitorexit ;
        throw locationrequest;
    }

    public void zza(LocationSettingsRequest locationsettingsrequest, com.google.android.gms.internal.zzlb.zzb zzb1, String s)
        throws RemoteException
    {
        boolean flag1 = true;
        zzpb();
        boolean flag;
        if (locationsettingsrequest != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "locationSettingsRequest can't be null nor empty.");
        if (zzb1 != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "listener can't be null.");
        zzb1 = new zzc(zzb1);
        ((zzi)zzpc()).zza(locationsettingsrequest, zzb1, s);
    }

    public void zza(LocationRequestInternal locationrequestinternal, LocationCallback locationcallback, Looper looper, zzg zzg)
        throws RemoteException
    {
        synchronized (zzaFB)
        {
            zzaFB.zza(locationrequestinternal, locationcallback, looper, zzg);
        }
        return;
        locationrequestinternal;
        zzk1;
        JVM INSTR monitorexit ;
        throw locationrequestinternal;
    }

    public void zza(List list, com.google.android.gms.internal.zzlb.zzb zzb1)
        throws RemoteException
    {
        zzpb();
        boolean flag;
        if (list != null && list.size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "geofenceRequestIds can't be null nor empty.");
        zzx.zzb(zzb1, "ResultHolder not provided.");
        list = (String[])list.toArray(new String[0]);
        zzb1 = new zzb(zzb1);
        ((zzi)zzpc()).zza(list, zzb1, getContext().getPackageName());
    }

    public void zzah(boolean flag)
        throws RemoteException
    {
        zzaFB.zzah(flag);
    }

    public void zzc(Location location)
        throws RemoteException
    {
        zzaFB.zzc(location);
    }

    public boolean zzpe()
    {
        return true;
    }

    public LocationAvailability zzwD()
    {
        return zzaFB.zzwD();
    }
}
