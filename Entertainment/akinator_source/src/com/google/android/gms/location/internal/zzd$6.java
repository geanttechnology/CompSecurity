// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzd, zzl, LocationRequestInternal, FusedLocationProviderResult

class nt extends a
{

    final LocationRequest zzaFd;
    final zzd zzaFf;
    final LocationCallback zzaFh;
    final Looper zzaFl;

    protected volatile void zza(com.google.android.gms.common.api.b b)
        throws RemoteException
    {
        zza((zzl)b);
    }

    protected void zza(zzl zzl1)
        throws RemoteException
    {
        a a = new zzg.zza() {

            final zzd._cls6 zzaFn;

            public void zza(FusedLocationProviderResult fusedlocationproviderresult)
            {
                zzaFn.zzb(fusedlocationproviderresult.getStatus());
            }

            
            {
                zzaFn = zzd._cls6.this;
                super();
            }
        };
        zzl1.zza(LocationRequestInternal.zzb(zzaFd), zzaFh, zzaFl, a);
    }

    nt(zzd zzd1, GoogleApiClient googleapiclient, LocationRequest locationrequest, LocationCallback locationcallback, Looper looper)
    {
        zzaFf = zzd1;
        zzaFd = locationrequest;
        zzaFh = locationcallback;
        zzaFl = looper;
        super(googleapiclient);
    }
}
