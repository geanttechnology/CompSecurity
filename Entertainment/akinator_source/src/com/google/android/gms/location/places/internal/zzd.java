// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.GeoDataApi;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzf;
import com.google.android.gms.location.places.zzl;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            zze

public class zzd
    implements GeoDataApi
{

    public zzd()
    {
    }

    public PendingResult addPlace(GoogleApiClient googleapiclient, AddPlaceRequest addplacerequest)
    {
        return googleapiclient.zzb(new com.google.android.gms.location.places.zzl.zzc(Places.zzaGz, googleapiclient, addplacerequest) {

            final AddPlaceRequest zzaGV;
            final zzd zzaGW;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zze)zzb);
            }

            protected void zza(zze zze1)
                throws RemoteException
            {
                zze1.zza(new zzl(this, zze1.getContext()), zzaGV);
            }

            
            {
                zzaGW = zzd.this;
                zzaGV = addplacerequest;
                super(zzc, googleapiclient);
            }
        });
    }

    public PendingResult getAutocompletePredictions(GoogleApiClient googleapiclient, String s, LatLngBounds latlngbounds, AutocompleteFilter autocompletefilter)
    {
        return googleapiclient.zza(new com.google.android.gms.location.places.zzl.zza(Places.zzaGz, googleapiclient, s, latlngbounds, autocompletefilter) {

            final zzd zzaGW;
            final LatLngBounds zzaGY;
            final AutocompleteFilter zzaGZ;
            final String zzaxk;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zze)zzb);
            }

            protected void zza(zze zze1)
                throws RemoteException
            {
                zze1.zza(new zzl(this), zzaxk, zzaGY, zzaGZ);
            }

            
            {
                zzaGW = zzd.this;
                zzaxk = s;
                zzaGY = latlngbounds;
                zzaGZ = autocompletefilter;
                super(zzc, googleapiclient);
            }
        });
    }

    public transient PendingResult getPlaceById(GoogleApiClient googleapiclient, String as[])
    {
        boolean flag = true;
        if (as == null || as.length < 1)
        {
            flag = false;
        }
        zzx.zzaa(flag);
        return googleapiclient.zza(new com.google.android.gms.location.places.zzl.zzc(Places.zzaGz, googleapiclient, as) {

            final zzd zzaGW;
            final String zzaGX[];

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zze)zzb);
            }

            protected void zza(zze zze1)
                throws RemoteException
            {
                java.util.List list = Arrays.asList(zzaGX);
                zze1.zza(new zzl(this, zze1.getContext()), list);
            }

            
            {
                zzaGW = zzd.this;
                zzaGX = as;
                super(zzc, googleapiclient);
            }
        });
    }

    public PendingResult getPlacePhotos(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zza(new com.google.android.gms.location.places.zzf.zzb(Places.zzaGz, googleapiclient, s) {

            final zzd zzaGW;
            final String zzaHa;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zze)zzb);
            }

            protected void zza(zze zze1)
                throws RemoteException
            {
                zze1.zza(new zzf(this), zzaHa);
            }

            
            {
                zzaGW = zzd.this;
                zzaHa = s;
                super(zzc, googleapiclient);
            }
        });
    }
}
