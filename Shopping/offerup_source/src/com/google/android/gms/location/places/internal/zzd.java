// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.GeoDataApi;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.model.LatLngBounds;

public class zzd
    implements GeoDataApi
{

    public zzd()
    {
    }

    public PendingResult addPlace(GoogleApiClient googleapiclient, AddPlaceRequest addplacerequest)
    {
        return googleapiclient.zzb(new _cls1(Places.zzaGz, googleapiclient, addplacerequest));
    }

    public PendingResult getAutocompletePredictions(GoogleApiClient googleapiclient, String s, LatLngBounds latlngbounds, AutocompleteFilter autocompletefilter)
    {
        return googleapiclient.zza(new _cls3(Places.zzaGz, googleapiclient, s, latlngbounds, autocompletefilter));
    }

    public transient PendingResult getPlaceById(GoogleApiClient googleapiclient, String as[])
    {
        boolean flag;
        if (as != null && as.length > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzaa(flag);
        return googleapiclient.zza(new _cls2(Places.zzaGz, googleapiclient, as));
    }

    public PendingResult getPlacePhotos(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zza(new _cls4(Places.zzaGz, googleapiclient, s));
    }

    private class _cls1 extends com.google.android.gms.location.places.zzl.zzc
    {

        final AddPlaceRequest zzaGV;
        final zzd zzaGW;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
        {
            zza((zze)zzb);
        }

        protected void zza(zze zze1)
        {
            zze1.zza(new zzl(this, zze1.getContext()), zzaGV);
        }

        _cls1(com.google.android.gms.common.api.Api.zzc zzc, GoogleApiClient googleapiclient, AddPlaceRequest addplacerequest)
        {
            zzaGW = zzd.this;
            zzaGV = addplacerequest;
            super(zzc, googleapiclient);
        }
    }


    private class _cls3 extends com.google.android.gms.location.places.zzl.zza
    {

        final zzd zzaGW;
        final LatLngBounds zzaGY;
        final AutocompleteFilter zzaGZ;
        final String zzaxk;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
        {
            zza((zze)zzb);
        }

        protected void zza(zze zze1)
        {
            zze1.zza(new zzl(this), zzaxk, zzaGY, zzaGZ);
        }

        _cls3(com.google.android.gms.common.api.Api.zzc zzc, GoogleApiClient googleapiclient, String s, LatLngBounds latlngbounds, AutocompleteFilter autocompletefilter)
        {
            zzaGW = zzd.this;
            zzaxk = s;
            zzaGY = latlngbounds;
            zzaGZ = autocompletefilter;
            super(zzc, googleapiclient);
        }
    }


    private class _cls2 extends com.google.android.gms.location.places.zzl.zzc
    {

        final zzd zzaGW;
        final String zzaGX[];

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
        {
            zza((zze)zzb);
        }

        protected void zza(zze zze1)
        {
            java.util.List list = Arrays.asList(zzaGX);
            zze1.zza(new zzl(this, zze1.getContext()), list);
        }

        _cls2(com.google.android.gms.common.api.Api.zzc zzc, GoogleApiClient googleapiclient, String as[])
        {
            zzaGW = zzd.this;
            zzaGX = as;
            super(zzc, googleapiclient);
        }
    }


    private class _cls4 extends com.google.android.gms.location.places.zzf.zzb
    {

        final zzd zzaGW;
        final String zzaHa;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
        {
            zza((zze)zzb);
        }

        protected void zza(zze zze1)
        {
            zze1.zza(new zzf(this), zzaHa);
        }

        _cls4(com.google.android.gms.common.api.Api.zzc zzc, GoogleApiClient googleapiclient, String s)
        {
            zzaGW = zzd.this;
            zzaHa = s;
            super(zzc, googleapiclient);
        }
    }

}
