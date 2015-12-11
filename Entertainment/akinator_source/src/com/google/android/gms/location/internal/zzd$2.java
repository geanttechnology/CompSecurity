// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationCallback;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzd, zzl, FusedLocationProviderResult

class nt extends a
{

    final zzd zzaFf;
    final LocationCallback zzaFh;

    protected volatile void zza(com.google.android.gms.common.api.b b)
        throws RemoteException
    {
        zza((zzl)b);
    }

    protected void zza(zzl zzl1)
        throws RemoteException
    {
        a a = new zzg.zza() {

            final zzd._cls2 zzaFi;

            public void zza(FusedLocationProviderResult fusedlocationproviderresult)
            {
                zzaFi.zzb(fusedlocationproviderresult.getStatus());
            }

            
            {
                zzaFi = zzd._cls2.this;
                super();
            }
        };
        zzl1.zza(zzaFh, a);
    }

    nt(zzd zzd1, GoogleApiClient googleapiclient, LocationCallback locationcallback)
    {
        zzaFf = zzd1;
        zzaFh = locationcallback;
        super(googleapiclient);
    }
}
