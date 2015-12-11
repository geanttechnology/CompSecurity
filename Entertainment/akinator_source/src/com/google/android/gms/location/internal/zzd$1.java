// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzd, zzl, FusedLocationProviderResult

class nt extends a
{

    final LocationRequest zzaFd;
    final LocationListener zzaFe;
    final zzd zzaFf;

    protected volatile void zza(com.google.android.gms.common.api.b b)
        throws RemoteException
    {
        zza((zzl)b);
    }

    protected void zza(zzl zzl1)
        throws RemoteException
    {
        a a = new zzg.zza() {

            final zzd._cls1 zzaFg;

            public void zza(FusedLocationProviderResult fusedlocationproviderresult)
            {
                zzaFg.zzb(fusedlocationproviderresult.getStatus());
            }

            
            {
                zzaFg = zzd._cls1.this;
                super();
            }
        };
        zzl1.zza(zzaFd, zzaFe, null, a);
    }

    nt(zzd zzd1, GoogleApiClient googleapiclient, LocationRequest locationrequest, LocationListener locationlistener)
    {
        zzaFf = zzd1;
        zzaFd = locationrequest;
        zzaFe = locationlistener;
        super(googleapiclient);
    }
}
