// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingRequest;
import java.util.List;

public class zzf
    implements GeofencingApi
{

    public zzf()
    {
    }

    public PendingResult addGeofences(GoogleApiClient googleapiclient, GeofencingRequest geofencingrequest, PendingIntent pendingintent)
    {
        return googleapiclient.zzb(new _cls1(googleapiclient, geofencingrequest, pendingintent));
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
        return googleapiclient.zzb(new _cls2(googleapiclient, pendingintent));
    }

    public PendingResult removeGeofences(GoogleApiClient googleapiclient, List list)
    {
        return googleapiclient.zzb(new _cls3(googleapiclient, list));
    }

    private class _cls1 extends zza
    {
        private class zza extends com.google.android.gms.location.LocationServices.zza
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


        final GeofencingRequest zzaFs;
        final zzf zzaFt;
        final PendingIntent zzarN;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
        {
            zza((zzl)zzb);
        }

        protected void zza(zzl zzl1)
        {
            zzl1.zza(zzaFs, zzarN, this);
        }

        _cls1(GoogleApiClient googleapiclient, GeofencingRequest geofencingrequest, PendingIntent pendingintent)
        {
            zzaFt = zzf.this;
            zzaFs = geofencingrequest;
            zzarN = pendingintent;
            super(googleapiclient);
        }
    }


    private class _cls2 extends zza
    {

        final zzf zzaFt;
        final PendingIntent zzarN;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
        {
            zza((zzl)zzb);
        }

        protected void zza(zzl zzl1)
        {
            zzl1.zza(zzarN, this);
        }

        _cls2(GoogleApiClient googleapiclient, PendingIntent pendingintent)
        {
            zzaFt = zzf.this;
            zzarN = pendingintent;
            super(googleapiclient);
        }
    }


    private class _cls3 extends zza
    {

        final zzf zzaFt;
        final List zzaFu;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
        {
            zza((zzl)zzb);
        }

        protected void zza(zzl zzl1)
        {
            zzl1.zza(zzaFu, this);
        }

        _cls3(GoogleApiClient googleapiclient, List list)
        {
            zzaFt = zzf.this;
            zzaFu = list;
            super(googleapiclient);
        }
    }

}
