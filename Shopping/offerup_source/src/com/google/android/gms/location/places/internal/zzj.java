// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.location.places.PlaceDetectionApi;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.Places;

public class zzj
    implements PlaceDetectionApi
{

    public zzj()
    {
    }

    public PendingResult getCurrentPlace(GoogleApiClient googleapiclient, PlaceFilter placefilter)
    {
        return googleapiclient.zza(new _cls1(Places.zzaGA, googleapiclient, placefilter));
    }

    public PendingResult reportDeviceAtPlace(GoogleApiClient googleapiclient, PlaceReport placereport)
    {
        return googleapiclient.zzb(new _cls2(Places.zzaGA, googleapiclient, placereport));
    }

    private class _cls1 extends com.google.android.gms.location.places.zzl.zzd
    {

        final PlaceFilter zzaHf;
        final zzj zzaHg;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
        {
            zza((zzk)zzb);
        }

        protected void zza(zzk zzk1)
        {
            zzk1.zza(new zzl(this, zzk1.getContext()), zzaHf);
        }

        _cls1(com.google.android.gms.common.api.Api.zzc zzc, GoogleApiClient googleapiclient, PlaceFilter placefilter)
        {
            zzaHg = zzj.this;
            zzaHf = placefilter;
            super(zzc, googleapiclient);
        }
    }


    private class _cls2 extends com.google.android.gms.location.places.zzl.zzf
    {

        final zzj zzaHg;
        final PlaceReport zzaHh;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
        {
            zza((zzk)zzb);
        }

        protected void zza(zzk zzk1)
        {
            zzk1.zza(new zzl(this), zzaHh);
        }

        _cls2(com.google.android.gms.common.api.Api.zzc zzc, GoogleApiClient googleapiclient, PlaceReport placereport)
        {
            zzaHg = zzj.this;
            zzaHh = placereport;
            super(zzc, googleapiclient);
        }
    }

}
