// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzd, zzl, FusedLocationProviderResult

class nt extends a
{

    final PendingIntent zzaEY;
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

            final zzd._cls9 zzaFq;

            public void zza(FusedLocationProviderResult fusedlocationproviderresult)
            {
                zzaFq.zzb(fusedlocationproviderresult.getStatus());
            }

            
            {
                zzaFq = zzd._cls9.this;
                super();
            }
        };
        zzl1.zza(zzaEY, a);
    }

    nt(zzd zzd1, GoogleApiClient googleapiclient, PendingIntent pendingintent)
    {
        zzaFf = zzd1;
        zzaEY = pendingintent;
        super(googleapiclient);
    }
}
