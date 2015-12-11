// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.location.places.PlaceDetectionApi;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzl;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            zzk

public class zzj
    implements PlaceDetectionApi
{

    public zzj()
    {
    }

    public PendingResult getCurrentPlace(GoogleApiClient googleapiclient, PlaceFilter placefilter)
    {
        return googleapiclient.zza(new com.google.android.gms.location.places.zzl.zzd(Places.zzaGA, googleapiclient, placefilter) {

            final PlaceFilter zzaHf;
            final zzj zzaHg;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzk)zzb);
            }

            protected void zza(zzk zzk1)
                throws RemoteException
            {
                zzk1.zza(new zzl(this, zzk1.getContext()), zzaHf);
            }

            
            {
                zzaHg = zzj.this;
                zzaHf = placefilter;
                super(zzc, googleapiclient);
            }
        });
    }

    public PendingResult reportDeviceAtPlace(GoogleApiClient googleapiclient, PlaceReport placereport)
    {
        return googleapiclient.zzb(new com.google.android.gms.location.places.zzl.zzf(Places.zzaGA, googleapiclient, placereport) {

            final zzj zzaHg;
            final PlaceReport zzaHh;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzk)zzb);
            }

            protected void zza(zzk zzk1)
                throws RemoteException
            {
                zzk1.zza(new zzl(this), zzaHh);
            }

            
            {
                zzaHg = zzj.this;
                zzaHh = placereport;
                super(zzc, googleapiclient);
            }
        });
    }
}
