// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingRequest;
import java.util.List;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzl

public class zzf
    implements GeofencingApi
{
    private static abstract class zza extends com.google.android.gms.location.LocationServices.zza
    {

        public Result zzb(Status status)
        {
            return zzd(status);
        }

        public Status zzd(Status status)
        {
            return status;
        }

        public zza(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }
    }


    public zzf()
    {
    }

    public PendingResult addGeofences(GoogleApiClient googleapiclient, GeofencingRequest geofencingrequest, PendingIntent pendingintent)
    {
        return googleapiclient.zzb(new zza(googleapiclient, geofencingrequest, pendingintent) {

            final GeofencingRequest zzaFs;
            final zzf zzaFt;
            final PendingIntent zzarN;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzl)zzb);
            }

            protected void zza(zzl zzl1)
                throws RemoteException
            {
                zzl1.zza(zzaFs, zzarN, this);
            }

            
            {
                zzaFt = zzf.this;
                zzaFs = geofencingrequest;
                zzarN = pendingintent;
                super(googleapiclient);
            }
        });
    }

    public PendingResult addGeofences(GoogleApiClient googleapiclient, List list, PendingIntent pendingintent)
    {
        com.google.android.gms.location.GeofencingRequest.Builder builder = new com.google.android.gms.location.GeofencingRequest.Builder();
        builder.addGeofences(list);
        builder.setInitialTrigger(5);
        return addGeofences(googleapiclient, builder.build(), pendingintent);
    }

    public PendingResult removeGeofences(GoogleApiClient googleapiclient, PendingIntent pendingintent)
    {
        return googleapiclient.zzb(new zza(googleapiclient, pendingintent) {

            final zzf zzaFt;
            final PendingIntent zzarN;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzl)zzb);
            }

            protected void zza(zzl zzl1)
                throws RemoteException
            {
                zzl1.zza(zzarN, this);
            }

            
            {
                zzaFt = zzf.this;
                zzarN = pendingintent;
                super(googleapiclient);
            }
        });
    }

    public PendingResult removeGeofences(GoogleApiClient googleapiclient, List list)
    {
        return googleapiclient.zzb(new zza(googleapiclient, list) {

            final zzf zzaFt;
            final List zzaFu;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzl)zzb);
            }

            protected void zza(zzl zzl1)
                throws RemoteException
            {
                zzl1.zza(zzaFu, this);
            }

            
            {
                zzaFt = zzf.this;
                zzaFu = list;
                super(googleapiclient);
            }
        });
    }
}
