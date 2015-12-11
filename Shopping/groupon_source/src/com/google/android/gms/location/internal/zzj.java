// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.location.copresence.internal.CopresenceApiOptions;
import com.google.android.gms.location.copresence.internal.zzb;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzb, zzi, zzg

public class zzj extends com.google.android.gms.location.internal.zzb
{
    private final class zza extends com.google.android.gms.common.internal.zzi.zzc
    {

        private final int zzTS;
        private final String zzayT[];
        final zzj zzayU;

        protected void zza(com.google.android.gms.location.zze.zza zza1)
        {
            if (zza1 != null)
            {
                zza1.zza(zzTS, zzayT);
            }
        }

        protected void zznP()
        {
        }

        protected void zzr(Object obj)
        {
            zza((com.google.android.gms.location.zze.zza)obj);
        }

        public zza(com.google.android.gms.location.zze.zza zza1, int i, String as[])
        {
            zzayU = zzj.this;
            super(zzj.this, zza1);
            zzTS = LocationStatusCodes.zzgA(i);
            zzayT = as;
        }
    }

    private static final class zzb extends zzf.zza
    {

        private com.google.android.gms.location.zze.zza zzayV;
        private com.google.android.gms.location.zze.zzb zzayW;
        private zzj zzayX;

        public void zza(int i, PendingIntent pendingintent)
        {
            if (zzayX == null)
            {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
                return;
            } else
            {
                zzj zzj1 = zzayX;
                zzj zzj2 = zzayX;
                zzj2.getClass();
                zzj1.zza(zzj2. new zzc(1, zzayW, i, pendingintent));
                zzayX = null;
                zzayV = null;
                zzayW = null;
                return;
            }
        }

        public void zza(int i, String as[])
            throws RemoteException
        {
            if (zzayX == null)
            {
                Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
                return;
            } else
            {
                zzj zzj1 = zzayX;
                zzj zzj2 = zzayX;
                zzj2.getClass();
                zzj1.zza(zzj2. new zza(zzayV, i, as));
                zzayX = null;
                zzayV = null;
                zzayW = null;
                return;
            }
        }

        public void zzb(int i, String as[])
        {
            if (zzayX == null)
            {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
                return;
            } else
            {
                zzj zzj1 = zzayX;
                zzj zzj2 = zzayX;
                zzj2.getClass();
                zzj1.zza(zzj2. new zzc(2, zzayW, i, as));
                zzayX = null;
                zzayV = null;
                zzayW = null;
                return;
            }
        }

        public zzb(com.google.android.gms.location.zze.zza zza1, zzj zzj1)
        {
            zzayV = zza1;
            zzayW = null;
            zzayX = zzj1;
        }

        public zzb(com.google.android.gms.location.zze.zzb zzb1, zzj zzj1)
        {
            zzayW = zzb1;
            zzayV = null;
            zzayX = zzj1;
        }
    }

    private final class zzc extends com.google.android.gms.common.internal.zzi.zzc
    {

        private final PendingIntent mPendingIntent;
        private final int zzTS;
        private final String zzayT[];
        final zzj zzayU;
        private final int zzayY;

        protected void zza(com.google.android.gms.location.zze.zzb zzb1)
        {
label0:
            {
label1:
                {
                    if (zzb1 != null)
                    {
                        switch (zzayY)
                        {
                        default:
                            Log.wtf("LocationClientImpl", (new StringBuilder()).append("Unsupported action: ").append(zzayY).toString());
                            break;

                        case 1: // '\001'
                            break label1;

                        case 2: // '\002'
                            break label0;
                        }
                    }
                    return;
                }
                zzb1.zza(zzTS, mPendingIntent);
                return;
            }
            zzb1.zzb(zzTS, zzayT);
        }

        protected void zznP()
        {
        }

        protected void zzr(Object obj)
        {
            zza((com.google.android.gms.location.zze.zzb)obj);
        }

        public zzc(int i, com.google.android.gms.location.zze.zzb zzb1, int j, PendingIntent pendingintent)
        {
            boolean flag = true;
            zzayU = zzj.this;
            super(zzj.this, zzb1);
            if (i != 1)
            {
                flag = false;
            }
            com.google.android.gms.common.internal.zzb.zzU(flag);
            zzayY = i;
            zzTS = LocationStatusCodes.zzgA(j);
            mPendingIntent = pendingintent;
            zzayT = null;
        }

        public zzc(int i, com.google.android.gms.location.zze.zzb zzb1, int j, String as[])
        {
            zzayU = zzj.this;
            super(zzj.this, zzb1);
            boolean flag;
            if (i == 2)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            com.google.android.gms.common.internal.zzb.zzU(flag);
            zzayY = i;
            zzTS = LocationStatusCodes.zzgA(j);
            zzayT = as;
            mPendingIntent = null;
        }
    }


    private final zzi zzayR;
    private final com.google.android.gms.location.copresence.internal.zzb zzayS;

    public zzj(Context context, Looper looper, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, String s)
    {
        this(context, looper, connectioncallbacks, onconnectionfailedlistener, s, (new com.google.android.gms.common.api.GoogleApiClient.Builder(context)).zzmx());
    }

    public zzj(Context context, Looper looper, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, String s, zze zze1)
    {
        this(context, looper, connectioncallbacks, onconnectionfailedlistener, s, zze1, CopresenceApiOptions.zzayn);
    }

    public zzj(Context context, Looper looper, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, String s, zze zze1, CopresenceApiOptions copresenceapioptions)
    {
        super(context, looper, connectioncallbacks, onconnectionfailedlistener, s, zze1);
        zzayR = new zzi(context, zzayq);
        zzayS = com.google.android.gms.location.copresence.internal.zzb.zza(context, zze1.getAccountName(), zze1.zzny(), zzayq, copresenceapioptions);
    }

    public void disconnect()
    {
        zzi zzi1 = zzayR;
        zzi1;
        JVM INSTR monitorenter ;
        boolean flag = isConnected();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        zzayR.removeAllListeners();
        zzayR.zzux();
_L1:
        super.disconnect();
        zzi1;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", ((Throwable) (obj)));
          goto _L1
        obj;
        zzi1;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public boolean requiresAccount()
    {
        return true;
    }

    public void zza(long l, PendingIntent pendingintent)
        throws RemoteException
    {
        zznL();
        zzu.zzu(pendingintent);
        boolean flag;
        if (l >= 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzu.zzb(flag, "detectionIntervalMillis must be >= 0");
        ((zzg)zznM()).zza(l, true, pendingintent);
    }

    public void zza(PendingIntent pendingintent)
        throws RemoteException
    {
        zznL();
        zzu.zzu(pendingintent);
        ((zzg)zznM()).zza(pendingintent);
    }

    public void zza(PendingIntent pendingintent, com.google.android.gms.location.zze.zzb zzb1)
        throws RemoteException
    {
        zznL();
        zzu.zzb(pendingintent, "PendingIntent must be specified.");
        zzu.zzb(zzb1, "OnRemoveGeofencesResultListener not provided.");
        if (zzb1 == null)
        {
            zzb1 = null;
        } else
        {
            zzb1 = new zzb(zzb1, this);
        }
        ((zzg)zznM()).zza(pendingintent, zzb1, getContext().getPackageName());
    }

    public void zza(GeofencingRequest geofencingrequest, PendingIntent pendingintent, com.google.android.gms.location.zze.zza zza1)
        throws RemoteException
    {
        zznL();
        zzu.zzb(geofencingrequest, "geofencingRequest can't be null.");
        zzu.zzb(pendingintent, "PendingIntent must be specified.");
        zzu.zzb(zza1, "OnAddGeofencesResultListener not provided.");
        if (zza1 == null)
        {
            zza1 = null;
        } else
        {
            zza1 = new zzb(zza1, this);
        }
        ((zzg)zznM()).zza(geofencingrequest, pendingintent, zza1);
    }
}
