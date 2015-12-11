// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzd, zzl, FusedLocationProviderResult

class nt extends a
{

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

            final zzd._cls8 zzaFp;

            public void zza(FusedLocationProviderResult fusedlocationproviderresult)
            {
                zzaFp.zzb(fusedlocationproviderresult.getStatus());
            }

            
            {
                zzaFp = zzd._cls8.this;
                super();
            }
        };
        zzl1.zza(zzaFe, a);
    }

    nt(zzd zzd1, GoogleApiClient googleapiclient, LocationListener locationlistener)
    {
        zzaFf = zzd1;
        zzaFe = locationlistener;
        super(googleapiclient);
    }
}
